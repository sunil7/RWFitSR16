package okhttp3;

import com.google.android.gms.internal.mlkit_vision_common.f0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import th.a;

/* loaded from: classes2.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final class Companion {
        private Companion() {
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m160deprecated_get(String mediaType) {
            e.f(mediaType, "mediaType");
            return get(mediaType);
        }

        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m161deprecated_parse(String mediaType) {
            e.f(mediaType, "mediaType");
            return parse(mediaType);
        }

        public final MediaType get(String toMediaType) {
            e.f(toMediaType, "$this$toMediaType");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(toMediaType);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + toMediaType + '\"').toString());
            }
            String group = matcher.group(1);
            e.e(group, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            e.e(locale, "Locale.US");
            String lowerCase = group.toLowerCase(locale);
            e.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String group2 = matcher.group(2);
            e.e(group2, "typeSubtype.group(2)");
            String lowerCase2 = group2.toLowerCase(locale);
            e.e(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = MediaType.PARAMETER.matcher(toMediaType);
            int end = matcher.end();
            while (end < toMediaType.length()) {
                matcher2.region(end, toMediaType.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb2 = new StringBuilder("Parameter is not formatted correctly: \"");
                    String substring = toMediaType.substring(end);
                    e.e(substring, "(this as java.lang.String).substring(startIndex)");
                    sb2.append(substring);
                    sb2.append("\" for: \"");
                    sb2.append(toMediaType);
                    sb2.append('\"');
                    throw new IllegalArgumentException(sb2.toString().toString());
                }
                String group3 = matcher2.group(1);
                if (group3 == null) {
                    end = matcher2.end();
                } else {
                    String group4 = matcher2.group(2);
                    if (group4 == null) {
                        group4 = matcher2.group(3);
                    } else if (m.x(group4, "'", false) && m.e(group4, "'") && group4.length() > 2) {
                        group4 = group4.substring(1, group4.length() - 1);
                        e.e(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    arrayList.add(group3);
                    arrayList.add(group4);
                    end = matcher2.end();
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new MediaType(toMediaType, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final MediaType parse(String toMediaTypeOrNull) {
            e.f(toMediaTypeOrNull, "$this$toMediaTypeOrNull");
            try {
                return get(toMediaTypeOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    private MediaType(String str, String str2, String str3, String[] strArr) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m158deprecated_subtype() {
        return this.subtype;
    }

    /* renamed from: -deprecated_type, reason: not valid java name */
    public final String m159deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && e.a(((MediaType) obj).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String parameter(String name) {
        e.f(name, "name");
        String[] strArr = this.parameterNamesAndValues;
        e.f(strArr, "<this>");
        a a3 = f0.a(new th.c(0, strArr.length - 1, 1), 2);
        int i3 = a3.f18633a;
        int i10 = a3.f18634b;
        int i11 = a3.f18635c;
        if (i11 >= 0) {
            if (i3 > i10) {
                return null;
            }
        } else if (i3 < i10) {
            return null;
        }
        while (!m.f(this.parameterNamesAndValues[i3], name)) {
            if (i3 == i10) {
                return null;
            }
            i3 += i11;
        }
        return this.parameterNamesAndValues[i3 + 1];
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String[] strArr, c cVar) {
        this(str, str2, str3, strArr);
    }

    public final Charset charset(Charset charset) {
        String parameter = parameter("charset");
        if (parameter == null) {
            return charset;
        }
        try {
            return Charset.forName(parameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
