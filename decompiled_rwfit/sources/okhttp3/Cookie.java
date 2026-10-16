package okhttp3;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.Regex;
import kotlin.text.m;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes2.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;
        private String path = "/";

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j4 = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j4, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final Builder domain(String domain) {
            e.f(domain, "domain");
            return domain(domain, false);
        }

        public final Builder expiresAt(long j4) {
            if (j4 <= 0) {
                j4 = Long.MIN_VALUE;
            }
            if (j4 > DatesKt.MAX_DATE) {
                j4 = 253402300799999L;
            }
            this.expiresAt = j4;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String domain) {
            e.f(domain, "domain");
            return domain(domain, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String name) {
            e.f(name, "name");
            if (!e.a(m.B(name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = name;
            return this;
        }

        public final Builder path(String path) {
            e.f(path, "path");
            if (!m.x(path, "/", false)) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = path;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String value) {
            e.f(value, "value");
            if (!e.a(m.B(value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = value;
            return this;
        }

        private final Builder domain(String str, boolean z5) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(l0.n("unexpected domain: ", str));
            }
            this.domain = canonicalHost;
            this.hostOnly = z5;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        private final int dateCharacterOffset(String str, int i3, int i10, boolean z5) {
            while (i3 < i10) {
                char charAt = str.charAt(i3);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || ('0' <= charAt && '9' >= charAt) || (('a' <= charAt && 'z' >= charAt) || (('A' <= charAt && 'Z' >= charAt) || charAt == ':'))) == (!z5)) {
                    return i3;
                }
                i3++;
            }
            return i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            return e.a(str, str2) || (m.e(str, str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str));
        }

        private final String parseDomain(String str) {
            if (m.e(str, ".")) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(m.q(str, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i3, int i10) {
            int dateCharacterOffset = dateCharacterOffset(str, i3, i10, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            while (dateCharacterOffset < i10) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i10, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i12 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    e.e(group, "matcher.group(1)");
                    i12 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    e.e(group2, "matcher.group(2)");
                    i15 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    e.e(group3, "matcher.group(3)");
                    i16 = Integer.parseInt(group3);
                } else if (i13 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    e.e(group4, "matcher.group(1)");
                    i13 = Integer.parseInt(group4);
                } else if (i14 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    e.e(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    e.e(locale, "Locale.US");
                    String lowerCase = group5.toLowerCase(locale);
                    e.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    e.e(pattern, "MONTH_PATTERN.pattern()");
                    i14 = m.j(pattern, lowerCase, 0, false, 6) / 4;
                } else if (i11 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    e.e(group6, "matcher.group(1)");
                    i11 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i10, false);
            }
            if (70 <= i11 && 99 >= i11) {
                i11 += 1900;
            }
            if (i11 >= 0 && 69 >= i11) {
                i11 += 2000;
            }
            if (!(i11 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i14 == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i13 || 31 < i13) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i12 < 0 || 23 < i12) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i15 < 0 || 59 < i15) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i16 < 0 || 59 < i16) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i11);
            gregorianCalendar.set(2, i14 - 1);
            gregorianCalendar.set(5, i13);
            gregorianCalendar.set(11, i12);
            gregorianCalendar.set(12, i15);
            gregorianCalendar.set(13, i16);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e) {
                if (!new Regex("-?\\d+").matches(str)) {
                    throw e;
                }
                if (m.x(str, "-", false)) {
                    return Long.MIN_VALUE;
                }
                return Format.OFFSET_SAMPLE_RELATIVE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (e.a(encodedPath, str)) {
                return true;
            }
            return m.x(encodedPath, str, false) && (m.e(str, "/") || encodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl url, String setCookie) {
            e.f(url, "url");
            e.f(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        public final Cookie parse$okhttp(long j4, HttpUrl url, String setCookie) {
            long j10;
            String str;
            e.f(url, "url");
            e.f(setCookie, "setCookie");
            int delimiterOffset$default = Util.delimiterOffset$default(setCookie, ';', 0, 0, 6, (Object) null);
            int delimiterOffset$default2 = Util.delimiterOffset$default(setCookie, '=', 0, delimiterOffset$default, 2, (Object) null);
            String str2 = null;
            if (delimiterOffset$default2 != delimiterOffset$default) {
                String trimSubstring$default = Util.trimSubstring$default(setCookie, 0, delimiterOffset$default2, 1, null);
                if (trimSubstring$default.length() != 0 && Util.indexOfControlOrNonAscii(trimSubstring$default) == -1) {
                    String trimSubstring = Util.trimSubstring(setCookie, delimiterOffset$default2 + 1, delimiterOffset$default);
                    if (Util.indexOfControlOrNonAscii(trimSubstring) == -1) {
                        int i3 = delimiterOffset$default + 1;
                        int length = setCookie.length();
                        boolean z5 = false;
                        boolean z6 = false;
                        boolean z8 = false;
                        boolean z10 = true;
                        long j11 = -1;
                        long j12 = DatesKt.MAX_DATE;
                        String str3 = null;
                        while (i3 < length) {
                            int delimiterOffset = Util.delimiterOffset(setCookie, ';', i3, length);
                            int delimiterOffset2 = Util.delimiterOffset(setCookie, '=', i3, delimiterOffset);
                            String trimSubstring2 = Util.trimSubstring(setCookie, i3, delimiterOffset2);
                            String trimSubstring3 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(setCookie, delimiterOffset2 + 1, delimiterOffset) : "";
                            if (m.f(trimSubstring2, "expires")) {
                                try {
                                    j12 = parseExpires(trimSubstring3, 0, trimSubstring3.length());
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (m.f(trimSubstring2, "max-age")) {
                                j11 = parseMaxAge(trimSubstring3);
                            } else {
                                if (m.f(trimSubstring2, "domain")) {
                                    str2 = parseDomain(trimSubstring3);
                                    z10 = false;
                                } else if (m.f(trimSubstring2, FileDownloadModel.PATH)) {
                                    str3 = trimSubstring3;
                                } else if (m.f(trimSubstring2, "secure")) {
                                    z8 = true;
                                } else if (m.f(trimSubstring2, "httponly")) {
                                    z5 = true;
                                }
                                i3 = delimiterOffset + 1;
                            }
                            z6 = true;
                            i3 = delimiterOffset + 1;
                        }
                        if (j11 == Long.MIN_VALUE) {
                            j10 = Long.MIN_VALUE;
                        } else if (j11 != -1) {
                            long j13 = j4 + (j11 <= 9223372036854775L ? j11 * 1000 : Format.OFFSET_SAMPLE_RELATIVE);
                            j10 = (j13 < j4 || j13 > DatesKt.MAX_DATE) ? 253402300799999L : j13;
                        } else {
                            j10 = j12;
                        }
                        String host = url.host();
                        if (str2 == null) {
                            str = host;
                        } else {
                            if (!domainMatch(host, str2)) {
                                return null;
                            }
                            str = str2;
                        }
                        if (host.length() != str.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str) == null) {
                            return null;
                        }
                        String str4 = "/";
                        if (str3 == null || !m.x(str3, "/", false)) {
                            String encodedPath = url.encodedPath();
                            int m10 = m.m(encodedPath, '/', 0, 6);
                            if (m10 != 0) {
                                if (encodedPath == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                                str4 = encodedPath.substring(0, m10);
                                e.e(str4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            }
                            str3 = str4;
                        }
                        return new Cookie(trimSubstring$default, trimSubstring, j10, str, str3, z8, z5, z6, z10, null);
                    }
                }
            }
            return null;
        }

        public final List<Cookie> parseAll(HttpUrl url, Headers headers) {
            e.f(url, "url");
            e.f(headers, "headers");
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            for (int i3 = 0; i3 < size; i3++) {
                Cookie parse = parse(url, values.get(i3));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList == null) {
                return EmptyList.INSTANCE;
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
            e.e(unmodifiableList, "Collections.unmodifiableList(cookies)");
            return unmodifiableList;
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    private Cookie(String str, String str2, long j4, String str3, String str4, boolean z5, boolean z6, boolean z8, boolean z10) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j4;
        this.domain = str3;
        this.path = str4;
        this.secure = z5;
        this.httpOnly = z6;
        this.persistent = z8;
        this.hostOnly = z10;
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain, reason: not valid java name */
    public final String m114deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m115deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m116deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m117deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name, reason: not valid java name */
    public final String m118deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path, reason: not valid java name */
    public final String m119deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m120deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m121deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value, reason: not valid java name */
    public final String m122deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return e.a(cookie.name, this.name) && e.a(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && e.a(cookie.domain, this.domain) && e.a(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return Boolean.hashCode(this.hostOnly) + ((Boolean.hashCode(this.persistent) + ((Boolean.hashCode(this.httpOnly) + ((Boolean.hashCode(this.secure) + l0.d(l0.d((Long.hashCode(this.expiresAt) + l0.d(l0.d(527, 31, this.name), 31, this.value)) * 31, 31, this.domain), 31, this.path)) * 31)) * 31)) * 31);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl url) {
        e.f(url, "url");
        if ((this.hostOnly ? e.a(url.host(), this.domain) : Companion.domainMatch(url.host(), this.domain)) && Companion.pathMatch(url, this.path)) {
            return !this.secure || url.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z5) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.name);
        sb2.append('=');
        sb2.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb2.append("; domain=");
            if (z5) {
                sb2.append(".");
            }
            sb2.append(this.domain);
        }
        sb2.append("; path=");
        sb2.append(this.path);
        if (this.secure) {
            sb2.append("; secure");
        }
        if (this.httpOnly) {
            sb2.append("; httponly");
        }
        String sb3 = sb2.toString();
        e.e(sb3, "toString()");
        return sb3;
    }

    public final String value() {
        return this.value;
    }

    public /* synthetic */ Cookie(String str, String str2, long j4, String str3, String str4, boolean z5, boolean z6, boolean z8, boolean z10, c cVar) {
        this(str, str2, j4, str3, str4, z5, z6, z8, z10);
    }
}
