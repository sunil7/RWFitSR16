package okhttp3;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.f0;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.j;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.Regex;
import kotlin.text.m;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import th.a;

/* loaded from: classes2.dex */
public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;

        public static final class Companion {
            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i3, int i10) {
                int parseInt;
                try {
                    parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i3, i10, "", false, false, false, false, null, 248, null));
                } catch (NumberFormatException unused) {
                }
                if (1 <= parseInt && 65535 >= parseInt) {
                    return parseInt;
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i3, int i10) {
                while (i3 < i10) {
                    char charAt = str.charAt(i3);
                    if (charAt == ':') {
                        return i3;
                    }
                    if (charAt == '[') {
                        do {
                            i3++;
                            if (i3 < i10) {
                            }
                        } while (str.charAt(i3) != ']');
                    }
                    i3++;
                }
                return i10;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i3, int i10) {
                if (i10 - i3 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i3);
                if ((e.h(charAt, 97) >= 0 && e.h(charAt, 122) <= 0) || (e.h(charAt, 65) >= 0 && e.h(charAt, 90) <= 0)) {
                    while (true) {
                        i3++;
                        if (i3 >= i10) {
                            break;
                        }
                        char charAt2 = str.charAt(i3);
                        if ('a' > charAt2 || 'z' < charAt2) {
                            if ('A' > charAt2 || 'Z' < charAt2) {
                                if ('0' > charAt2 || '9' < charAt2) {
                                    if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                        if (charAt2 == ':') {
                                            return i3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i3, int i10) {
                int i11 = 0;
                while (i3 < i10) {
                    char charAt = str.charAt(i3);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i11++;
                    i3++;
                }
                return i11;
            }

            public /* synthetic */ Companion(c cVar) {
                this();
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i3 = this.port;
            if (i3 != -1) {
                return i3;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            e.c(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return e.a(str, ".") || m.f(str, "%2e");
        }

        private final boolean isDotDot(String str) {
            return e.a(str, "..") || m.f(str, "%2e.") || m.f(str, ".%2e") || m.f(str, "%2e%2e");
        }

        private final void pop() {
            if (this.encodedPathSegments.remove(r0.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                this.encodedPathSegments.set(r0.size() - 1, "");
            }
        }

        private final void push(String str, int i3, int i10, boolean z5, boolean z6) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i3, i10, HttpUrl.PATH_SEGMENT_ENCODE_SET, z6, false, false, false, null, 240, null);
            if (isDot(canonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(canonicalize$okhttp$default)) {
                pop();
                return;
            }
            if (this.encodedPathSegments.get(r14.size() - 1).length() == 0) {
                this.encodedPathSegments.set(r14.size() - 1, canonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(canonicalize$okhttp$default);
            }
            if (z5) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            e.c(list);
            a a3 = f0.a(new a(list.size() - 2, 0, -1), 2);
            int i3 = a3.f18633a;
            int i10 = a3.f18634b;
            int i11 = a3.f18635c;
            if (i11 >= 0) {
                if (i3 > i10) {
                    return;
                }
            } else if (i3 < i10) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                e.c(list2);
                if (e.a(str, list2.get(i3))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    e.c(list3);
                    list3.remove(i3 + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    e.c(list4);
                    list4.remove(i3);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    e.c(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (i3 == i10) {
                    return;
                } else {
                    i3 += i11;
                }
            }
        }

        private final void resolvePath(String str, int i3, int i10) {
            if (i3 == i10) {
                return;
            }
            char charAt = str.charAt(i3);
            if (charAt == '/' || charAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i3++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i11 = i3;
            while (i11 < i10) {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i11, i10);
                boolean z5 = delimiterOffset < i10;
                String str2 = str;
                push(str2, i11, delimiterOffset, z5, true);
                if (z5) {
                    delimiterOffset++;
                }
                i11 = delimiterOffset;
                str = str2;
            }
        }

        public final Builder addEncodedPathSegment(String encodedPathSegment) {
            e.f(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String encodedPathSegments) {
            e.f(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        public final Builder addEncodedQueryParameter(String encodedName, String str) {
            e.f(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            e.c(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            e.c(list2);
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null) : null);
            return this;
        }

        public final Builder addPathSegment(String pathSegment) {
            e.f(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String pathSegments) {
            e.f(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        public final Builder addQueryParameter(String name, String str) {
            e.f(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            e.c(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            e.c(list2);
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null) : null);
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = HttpUrl.Companion;
            String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
            String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int effectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(j.g(list));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                List<String> list3 = list2;
                arrayList = new ArrayList(j.g(list3));
                for (String str3 : list3) {
                    arrayList.add(str3 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, percentDecode$okhttp$default, percentDecode$okhttp$default2, str2, effectivePort, arrayList2, arrayList, str4 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, 179, null) : null;
            return this;
        }

        public final Builder encodedPassword(String encodedPassword) {
            e.f(encodedPassword, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder encodedPath(String encodedPath) {
            e.f(encodedPath, "encodedPath");
            if (!m.x(encodedPath, "/", false)) {
                throw new IllegalArgumentException("unexpected encodedPath: ".concat(encodedPath).toString());
            }
            resolvePath(encodedPath, 0, encodedPath.length());
            return this;
        }

        public final Builder encodedQuery(String str) {
            Companion companion;
            String canonicalize$okhttp$default;
            this.encodedQueryNamesAndValues = (str == null || (canonicalize$okhttp$default = Companion.canonicalize$okhttp$default((companion = HttpUrl.Companion), str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null)) == null) ? null : companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
            return this;
        }

        public final Builder encodedUsername(String encodedUsername) {
            e.f(encodedUsername, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, 187, null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String host) {
            e.f(host, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, host, 0, 0, false, 7, null));
            if (canonicalHost == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(host));
            }
            this.host = canonicalHost;
            return this;
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int delimiterOffset;
            int i3;
            boolean z5;
            int i10;
            int i11;
            boolean z6;
            int i12;
            boolean z8;
            char c9;
            String input = str;
            e.f(input, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(input, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int schemeDelimiterOffset = companion.schemeDelimiterOffset(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            boolean z10 = true;
            char c10 = 65535;
            if (schemeDelimiterOffset != -1) {
                if (m.w(input, Const.HTTPS_START, indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!m.w(input, Const.HTTP_START, indexOfFirstNonAsciiWhitespace$default, true)) {
                        StringBuilder sb2 = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                        String substring = input.substring(0, schemeDelimiterOffset);
                        e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb2.append(substring);
                        sb2.append("'");
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.scheme = httpUrl.scheme();
            }
            int slashCount = companion.slashCount(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c11 = '?';
            char c12 = '#';
            if (slashCount >= 2 || httpUrl == null || !e.a(httpUrl.scheme(), this.scheme)) {
                int i13 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                boolean z11 = false;
                boolean z12 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(input, "@/\\?#", i13, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? input.charAt(delimiterOffset) : c10;
                    if (charAt == c10 || charAt == c12 || charAt == '/' || charAt == '\\' || charAt == c11) {
                        break;
                    }
                    if (charAt != '@') {
                        z5 = z10;
                        i10 = indexOfLastNonAsciiWhitespace$default;
                    } else {
                        if (z11) {
                            z5 = z10;
                            i10 = indexOfLastNonAsciiWhitespace$default;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.encodedPassword);
                            sb3.append("%40");
                            input = str;
                            i11 = delimiterOffset;
                            sb3.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, i13, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb3.toString();
                            z6 = z12;
                        } else {
                            int delimiterOffset2 = Util.delimiterOffset(input, ':', i13, delimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            z5 = z10;
                            i10 = indexOfLastNonAsciiWhitespace$default;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, input, i13, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z12) {
                                canonicalize$okhttp$default = this.encodedUsername + "%40" + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                i12 = delimiterOffset;
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, str, delimiterOffset2 + 1, i12, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z8 = z5;
                            } else {
                                i12 = delimiterOffset;
                                z8 = z11;
                            }
                            input = str;
                            i11 = i12;
                            z11 = z8;
                            z6 = z5;
                        }
                        i13 = i11 + 1;
                        z12 = z6;
                    }
                    z10 = z5;
                    indexOfLastNonAsciiWhitespace$default = i10;
                    c11 = '?';
                    c10 = 65535;
                    c12 = '#';
                }
                boolean z13 = z10;
                i3 = indexOfLastNonAsciiWhitespace$default;
                Companion companion3 = Companion;
                int portColonOffset = companion3.portColonOffset(input, i13, delimiterOffset);
                int i14 = portColonOffset + 1;
                if (i14 < delimiterOffset) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, input, i13, portColonOffset, false, 4, null));
                    int parsePort = companion3.parsePort(input, i14, delimiterOffset);
                    this.port = parsePort;
                    if (!(parsePort != -1 ? z13 : false)) {
                        StringBuilder sb4 = new StringBuilder("Invalid URL port: \"");
                        String substring2 = input.substring(i14, delimiterOffset);
                        e.e(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb4.append(substring2);
                        sb4.append('\"');
                        throw new IllegalArgumentException(sb4.toString().toString());
                    }
                } else {
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, input, i13, portColonOffset, false, 4, null));
                    String str2 = this.scheme;
                    e.c(str2);
                    this.port = companion4.defaultPort(str2);
                }
                if (!(this.host != null ? z13 : false)) {
                    StringBuilder sb5 = new StringBuilder("Invalid URL host: \"");
                    String substring3 = input.substring(i13, portColonOffset);
                    e.e(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb5.append(substring3);
                    sb5.append('\"');
                    throw new IllegalArgumentException(sb5.toString().toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || input.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i3 = indexOfLastNonAsciiWhitespace$default;
            }
            int i15 = i3;
            int delimiterOffset3 = Util.delimiterOffset(input, "?#", indexOfFirstNonAsciiWhitespace$default, i15);
            resolvePath(input, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 >= i15 || input.charAt(delimiterOffset3) != '?') {
                c9 = '#';
            } else {
                c9 = '#';
                int delimiterOffset4 = Util.delimiterOffset(input, '#', delimiterOffset3, i15);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, input, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i15 && input.charAt(delimiterOffset3) == c9) {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, delimiterOffset3 + 1, i15, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final Builder password(String password) {
            e.f(password, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final Builder port(int i3) {
            if (!(1 <= i3 && 65535 >= i3)) {
                throw new IllegalArgumentException(l0.j(i3, "unexpected port: ").toString());
            }
            this.port = i3;
            return this;
        }

        public final Builder query(String str) {
            Companion companion;
            String canonicalize$okhttp$default;
            this.encodedQueryNamesAndValues = (str == null || (canonicalize$okhttp$default = Companion.canonicalize$okhttp$default((companion = HttpUrl.Companion), str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null)) == null) ? null : companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String str = this.host;
            this.host = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i3 = 0; i3 < size; i3++) {
                List<String> list = this.encodedPathSegments;
                list.set(i3, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i3), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    String str2 = list2.get(i10);
                    list2.set(i10, str2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null) : null;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String encodedName) {
            e.f(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String name) {
            e.f(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        public final Builder removePathSegment(int i3) {
            this.encodedPathSegments.remove(i3);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String scheme) {
            e.f(scheme, "scheme");
            if (scheme.equalsIgnoreCase("http")) {
                this.scheme = "http";
                return this;
            }
            if (!scheme.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(scheme));
            }
            this.scheme = "https";
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            e.f(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i3, String encodedPathSegment) {
            e.f(encodedPathSegment, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(i3, canonicalize$okhttp$default);
            if ((isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: ".concat(encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String encodedName, String str) {
            e.f(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            e.f(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i3, String pathSegment) {
            e.f(pathSegment, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (!((isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) ? false : true)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(pathSegment).toString());
            }
            this.encodedPathSegments.set(i3, canonicalize$okhttp$default);
            return this;
        }

        public final void setPort$okhttp(int i3) {
            this.port = i3;
        }

        public final Builder setQueryParameter(String name, String str) {
            e.f(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb2.append(str);
                sb2.append("://");
            } else {
                sb2.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb2.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb2.append(':');
                    sb2.append(this.encodedPassword);
                }
                sb2.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (m.d(str2, ':')) {
                    sb2.append('[');
                    sb2.append(this.host);
                    sb2.append(']');
                } else {
                    sb2.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int effectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null || effectivePort != HttpUrl.Companion.defaultPort(str3)) {
                    sb2.append(':');
                    sb2.append(effectivePort);
                }
            }
            Companion companion = HttpUrl.Companion;
            companion.toPathString$okhttp(this.encodedPathSegments, sb2);
            if (this.encodedQueryNamesAndValues != null) {
                sb2.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                e.c(list);
                companion.toQueryString$okhttp(list, sb2);
            }
            if (this.encodedFragment != null) {
                sb2.append('#');
                sb2.append(this.encodedFragment);
            }
            String sb3 = sb2.toString();
            e.e(sb3, "StringBuilder().apply(builderAction).toString()");
            return sb3;
        }

        public final Builder username(String username) {
            e.f(username, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z5) {
            boolean z6;
            Builder builder;
            String str2;
            boolean z8;
            int i3 = 0;
            while (true) {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i3, str.length());
                if (delimiterOffset < str.length()) {
                    z6 = true;
                    str2 = str;
                    z8 = z5;
                    builder = this;
                } else {
                    z6 = false;
                    builder = this;
                    str2 = str;
                    z8 = z5;
                }
                builder.push(str2, i3, delimiterOffset, z6, z8);
                i3 = delimiterOffset + 1;
                if (i3 > str2.length()) {
                    return builder;
                }
                str = str2;
                z5 = z8;
            }
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i3, int i10, String str2, boolean z5, boolean z6, boolean z8, boolean z10, Charset charset, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i3 = 0;
            }
            if ((i11 & 2) != 0) {
                i10 = str.length();
            }
            if ((i11 & 8) != 0) {
                z5 = false;
            }
            if ((i11 & 16) != 0) {
                z6 = false;
            }
            if ((i11 & 32) != 0) {
                z8 = false;
            }
            if ((i11 & 64) != 0) {
                z10 = false;
            }
            if ((i11 & 128) != 0) {
                charset = null;
            }
            return companion.canonicalize$okhttp(str, i3, i10, str2, z5, z6, z8, z10, charset);
        }

        private final boolean isPercentEncoded(String str, int i3, int i10) {
            int i11 = i3 + 2;
            return i11 < i10 && str.charAt(i3) == '%' && Util.parseHexDigit(str.charAt(i3 + 1)) != -1 && Util.parseHexDigit(str.charAt(i11)) != -1;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i3, int i10, boolean z5, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i3 = 0;
            }
            if ((i11 & 2) != 0) {
                i10 = str.length();
            }
            if ((i11 & 4) != 0) {
                z5 = false;
            }
            return companion.percentDecode$okhttp(str, i3, i10, z5);
        }

        private final void writeCanonicalized(wh.j jVar, String str, int i3, int i10, String str2, boolean z5, boolean z6, boolean z8, boolean z10, Charset charset) {
            wh.j jVar2 = null;
            int i11 = i3;
            while (i11 < i10) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                int codePointAt = str.codePointAt(i11);
                if (!z5 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                    if (codePointAt == 43 && z8) {
                        jVar.h0(z5 ? "+" : "%2B");
                    } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && !z10) || m.d(str2, (char) codePointAt) || (codePointAt == 37 && (!z5 || (z6 && !isPercentEncoded(str, i11, i10)))))) {
                        if (jVar2 == null) {
                            jVar2 = new wh.j();
                        }
                        if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                            jVar2.i0(codePointAt);
                        } else {
                            jVar2.f0(str, i11, Character.charCount(codePointAt) + i11, charset);
                        }
                        while (!jVar2.D()) {
                            byte readByte = jVar2.readByte();
                            jVar.Z(37);
                            jVar.Z(HttpUrl.HEX_DIGITS[((readByte & 255) >> 4) & 15]);
                            jVar.Z(HttpUrl.HEX_DIGITS[readByte & 15]);
                        }
                    } else {
                        jVar.i0(codePointAt);
                    }
                }
                i11 += Character.charCount(codePointAt);
            }
        }

        private final void writePercentDecoded(wh.j jVar, String str, int i3, int i10, boolean z5) {
            int i11;
            while (i3 < i10) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                int codePointAt = str.codePointAt(i3);
                if (codePointAt != 37 || (i11 = i3 + 2) >= i10) {
                    if (codePointAt == 43 && z5) {
                        jVar.Z(32);
                        i3++;
                    }
                    jVar.i0(codePointAt);
                    i3 += Character.charCount(codePointAt);
                } else {
                    int parseHexDigit = Util.parseHexDigit(str.charAt(i3 + 1));
                    int parseHexDigit2 = Util.parseHexDigit(str.charAt(i11));
                    if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                        jVar.Z((parseHexDigit << 4) + parseHexDigit2);
                        i3 = Character.charCount(codePointAt) + i11;
                    }
                    jVar.i0(codePointAt);
                    i3 += Character.charCount(codePointAt);
                }
            }
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m154deprecated_get(String url) {
            e.f(url, "url");
            return get(url);
        }

        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m157deprecated_parse(String url) {
            e.f(url, "url");
            return parse(url);
        }

        public final String canonicalize$okhttp(String canonicalize, int i3, int i10, String encodeSet, boolean z5, boolean z6, boolean z8, boolean z10, Charset charset) {
            e.f(canonicalize, "$this$canonicalize");
            e.f(encodeSet, "encodeSet");
            int i11 = i3;
            while (i11 < i10) {
                int codePointAt = canonicalize.codePointAt(i11);
                if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && !z10) || m.d(encodeSet, (char) codePointAt) || ((codePointAt == 37 && (!z5 || (z6 && !isPercentEncoded(canonicalize, i11, i10)))) || (codePointAt == 43 && z8)))) {
                    wh.j jVar = new wh.j();
                    jVar.g0(i3, i11, canonicalize);
                    writeCanonicalized(jVar, canonicalize, i11, i10, encodeSet, z5, z6, z8, z10, charset);
                    return jVar.A();
                }
                i11 += Character.charCount(codePointAt);
            }
            String substring = canonicalize.substring(i3, i10);
            e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final int defaultPort(String scheme) {
            e.f(scheme, "scheme");
            int hashCode = scheme.hashCode();
            return hashCode != 3213448 ? (hashCode == 99617003 && scheme.equals("https")) ? 443 : -1 : scheme.equals("http") ? 80 : -1;
        }

        public final HttpUrl get(String toHttpUrl) {
            e.f(toHttpUrl, "$this$toHttpUrl");
            return new Builder().parse$okhttp(null, toHttpUrl).build();
        }

        public final HttpUrl parse(String toHttpUrlOrNull) {
            e.f(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            try {
                return get(toHttpUrlOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String percentDecode, int i3, int i10, boolean z5) {
            e.f(percentDecode, "$this$percentDecode");
            for (int i11 = i3; i11 < i10; i11++) {
                char charAt = percentDecode.charAt(i11);
                if (charAt == '%' || (charAt == '+' && z5)) {
                    wh.j jVar = new wh.j();
                    jVar.g0(i3, i11, percentDecode);
                    writePercentDecoded(jVar, percentDecode, i11, i10, z5);
                    return jVar.A();
                }
            }
            String substring = percentDecode.substring(i3, i10);
            e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(List<String> toPathString, StringBuilder out) {
            e.f(toPathString, "$this$toPathString");
            e.f(out, "out");
            int size = toPathString.size();
            for (int i3 = 0; i3 < size; i3++) {
                out.append('/');
                out.append(toPathString.get(i3));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String toQueryNamesAndValues) {
            e.f(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 <= toQueryNamesAndValues.length()) {
                int i10 = m.i(toQueryNamesAndValues, '&', i3, 4);
                if (i10 == -1) {
                    i10 = toQueryNamesAndValues.length();
                }
                int i11 = m.i(toQueryNamesAndValues, '=', i3, 4);
                if (i11 == -1 || i11 > i10) {
                    String substring = toQueryNamesAndValues.substring(i3, i10);
                    e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    arrayList.add(null);
                } else {
                    String substring2 = toQueryNamesAndValues.substring(i3, i11);
                    e.e(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    String substring3 = toQueryNamesAndValues.substring(i11 + 1, i10);
                    e.e(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                }
                i3 = i10 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> toQueryString, StringBuilder out) {
            e.f(toQueryString, "$this$toQueryString");
            e.f(out, "out");
            a a3 = f0.a(f0.b(0, toQueryString.size()), 2);
            int i3 = a3.f18633a;
            int i10 = a3.f18634b;
            int i11 = a3.f18635c;
            if (i11 >= 0) {
                if (i3 > i10) {
                    return;
                }
            } else if (i3 < i10) {
                return;
            }
            while (true) {
                String str = toQueryString.get(i3);
                String str2 = toQueryString.get(i3 + 1);
                if (i3 > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (i3 == i10) {
                    return;
                } else {
                    i3 += i11;
                }
            }
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m156deprecated_get(URL url) {
            e.f(url, "url");
            return get(url);
        }

        public final HttpUrl get(URL toHttpUrlOrNull) {
            e.f(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String url = toHttpUrlOrNull.toString();
            e.e(url, "toString()");
            return parse(url);
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m155deprecated_get(URI uri) {
            e.f(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI toHttpUrlOrNull) {
            e.f(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String uri = toHttpUrlOrNull.toString();
            e.e(uri, "toString()");
            return parse(uri);
        }
    }

    public HttpUrl(String scheme, String username, String password, String host, int i3, List<String> pathSegments, List<String> list, String str, String url) {
        e.f(scheme, "scheme");
        e.f(username, "username");
        e.f(password, "password");
        e.f(host, "host");
        e.f(pathSegments, "pathSegments");
        e.f(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i3;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = e.a(scheme, "https");
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m135deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m136deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m137deprecated_encodedPath() {
        return encodedPath();
    }

    /* renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m138deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m139deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m140deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m141deprecated_fragment() {
        return this.fragment;
    }

    /* renamed from: -deprecated_host, reason: not valid java name */
    public final String m142deprecated_host() {
        return this.host;
    }

    /* renamed from: -deprecated_password, reason: not valid java name */
    public final String m143deprecated_password() {
        return this.password;
    }

    /* renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m144deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m145deprecated_pathSize() {
        return pathSize();
    }

    /* renamed from: -deprecated_port, reason: not valid java name */
    public final int m146deprecated_port() {
        return this.port;
    }

    /* renamed from: -deprecated_query, reason: not valid java name */
    public final String m147deprecated_query() {
        return query();
    }

    /* renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m148deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m149deprecated_querySize() {
        return querySize();
    }

    /* renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m150deprecated_scheme() {
        return this.scheme;
    }

    /* renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m151deprecated_uri() {
        return uri();
    }

    /* renamed from: -deprecated_url, reason: not valid java name */
    public final URL m152deprecated_url() {
        return url();
    }

    /* renamed from: -deprecated_username, reason: not valid java name */
    public final String m153deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int i3 = m.i(this.url, '#', 0, 6) + 1;
        String str = this.url;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(i3);
        e.e(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int i3 = m.i(this.url, ':', this.scheme.length() + 3, 4) + 1;
        int i10 = m.i(this.url, '@', 0, 6);
        String str = this.url;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(i3, i10);
        e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedPath() {
        int i3 = m.i(this.url, '/', this.scheme.length() + 3, 4);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", i3, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(i3, delimiterOffset);
        e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final List<String> encodedPathSegments() {
        int i3 = m.i(this.url, '/', this.scheme.length() + 3, 4);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", i3, str.length());
        ArrayList arrayList = new ArrayList();
        while (i3 < delimiterOffset) {
            int i10 = i3 + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i10, delimiterOffset);
            String str2 = this.url;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = str2.substring(i10, delimiterOffset2);
            e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(substring);
            i3 = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int i3 = m.i(this.url, '?', 0, 6) + 1;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, '#', i3, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(i3, delimiterOffset);
        e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, ":@", length, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(length, delimiterOffset);
        e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && e.a(((HttpUrl) obj).url, this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb2);
        return sb2.toString();
    }

    public final String queryParameter(String name) {
        e.f(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        a a3 = f0.a(f0.b(0, list.size()), 2);
        int i3 = a3.f18633a;
        int i10 = a3.f18634b;
        int i11 = a3.f18635c;
        if (i11 < 0 ? i3 >= i10 : i3 <= i10) {
            while (!name.equals(this.queryNamesAndValues.get(i3))) {
                if (i3 != i10) {
                    i3 += i11;
                }
            }
            return this.queryNamesAndValues.get(i3 + 1);
        }
        return null;
    }

    public final String queryParameterName(int i3) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i3 * 2);
        e.c(str);
        return str;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return EmptySet.INSTANCE;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a a3 = f0.a(f0.b(0, this.queryNamesAndValues.size()), 2);
        int i3 = a3.f18633a;
        int i10 = a3.f18634b;
        int i11 = a3.f18635c;
        if (i11 < 0 ? i3 >= i10 : i3 <= i10) {
            while (true) {
                String str = this.queryNamesAndValues.get(i3);
                e.c(str);
                linkedHashSet.add(str);
                if (i3 == i10) {
                    break;
                }
                i3 += i11;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        e.e(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final String queryParameterValue(int i3) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i3 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String name) {
        e.f(name, "name");
        if (this.queryNamesAndValues == null) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        a a3 = f0.a(f0.b(0, this.queryNamesAndValues.size()), 2);
        int i3 = a3.f18633a;
        int i10 = a3.f18634b;
        int i11 = a3.f18635c;
        if (i11 < 0 ? i3 >= i10 : i3 <= i10) {
            while (true) {
                if (name.equals(this.queryNamesAndValues.get(i3))) {
                    arrayList.add(this.queryNamesAndValues.get(i3 + 1));
                }
                if (i3 == i10) {
                    break;
                }
                i3 += i11;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        e.e(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        e.c(newBuilder);
        return newBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String link) {
        e.f(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(builder, ""));
                e.e(create, "try {\n        val stripp…e) // Unexpected!\n      }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public final String username() {
        return this.username;
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    public final Builder newBuilder(String link) {
        e.f(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
