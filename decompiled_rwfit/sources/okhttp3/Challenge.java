package okhttp3;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String scheme, Map<String, String> authParams) {
        String str;
        e.f(scheme, "scheme");
        e.f(authParams, "authParams");
        this.scheme = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                e.e(US, "US");
                str = key.toLowerCase(US);
                e.e(str, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            linkedHashMap.put(str, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        e.e(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = unmodifiableMap;
    }

    /* renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m106deprecated_authParams() {
        return this.authParams;
    }

    /* renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m107deprecated_charset() {
        return charset();
    }

    /* renamed from: -deprecated_realm, reason: not valid java name */
    public final String m108deprecated_realm() {
        return realm();
    }

    /* renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m109deprecated_scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                e.e(forName, "Charset.forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
        e.e(ISO_8859_1, "ISO_8859_1");
        return ISO_8859_1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Challenge)) {
            return false;
        }
        Challenge challenge = (Challenge) obj;
        return e.a(challenge.scheme, this.scheme) && e.a(challenge.authParams, this.authParams);
    }

    public int hashCode() {
        return this.authParams.hashCode() + l0.d(899, 31, this.scheme);
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public final Challenge withCharset(Charset charset) {
        e.f(charset, "charset");
        Map<String, String> map = this.authParams;
        e.f(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        String name = charset.name();
        e.e(name, "charset.name()");
        linkedHashMap.put("charset", name);
        return new Challenge(this.scheme, linkedHashMap);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Challenge(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "scheme"
            kotlin.jvm.internal.e.f(r2, r0)
            java.lang.String r0 = "realm"
            kotlin.jvm.internal.e.f(r3, r0)
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r0 = "singletonMap(\"realm\", realm)"
            kotlin.jvm.internal.e.e(r3, r0)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Challenge.<init>(java.lang.String, java.lang.String):void");
    }
}
