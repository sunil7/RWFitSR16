package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.autonavi.aps.amapapi.security.Encrypt;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class aa {

    /* renamed from: b, reason: collision with root package name */
    private static final String f3613b = n9.b("SRFZHZUVZT3BOa0ZiemZRQQ");

    /* renamed from: c, reason: collision with root package name */
    private static final String f3614c = n9.b("FbGJzX3Nkaw");

    /* renamed from: d, reason: collision with root package name */
    private static final String f3615d = n9.b("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
    private static final String e = n9.b("FQU5EU0RLMTA");

    /* renamed from: f, reason: collision with root package name */
    private static final String f3616f = n9.b("FMTAw");

    /* renamed from: g, reason: collision with root package name */
    private static boolean f3617g = false;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f3618h = 0;

    /* renamed from: a, reason: collision with root package name */
    private String f3619a = "";

    private String b() {
        if (!TextUtils.isEmpty(this.f3619a)) {
            return this.f3619a;
        }
        String c9 = n9.c(h9.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA"));
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < c9.length(); i3++) {
            stringBuffer.append((char) (c9.charAt(i3) - (i3 % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i10 = 0; i10 < stringBuffer2.length() / 2; i10++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt((stringBuffer2.length() - 1) - i10) + stringBuffer2.charAt(i10)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.f3619a = stringBuffer4;
        return stringBuffer4;
    }

    public final synchronized Map<String, String> a() {
        if (f3617g) {
            return null;
        }
        f3617g = true;
        HashMap hashMap = new HashMap();
        hashMap.put(n9.b("FZW50"), n9.b("FMg"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(n9.b("SY2hhbm5lbD0"));
        String str = f3614c;
        sb2.append(str);
        sb2.append(n9.b("SJmRpdj0"));
        String str2 = e;
        sb2.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(n9.b("FQA"));
        stringBuffer.append(f3615d);
        String c9 = e9.c(stringBuffer.toString());
        sb2.append(n9.b("FJnNpZ249"));
        sb2.append(c9.toUpperCase(Locale.US));
        sb2.append(n9.b("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(n9.b("FaW4"), x9.a(eb.a(sb2.toString().getBytes(), f3613b.getBytes())));
        hashMap.put(n9.b("Sa2V5dA"), f3616f);
        return hashMap;
    }

    public final String a(String str, String str2, String str3, String str4) {
        String str5;
        byte[] bArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(n9.b("LdGlk"), str);
            jSONObject.put(n9.b("FZGl1"), str2);
            jSONObject.put(n9.b("AZGl1Mg"), str3);
            jSONObject.put(n9.b("EZGl1Mw"), str4);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(n9.b("EQUVT"));
            keyGenerator.init(128, secureRandom);
            str5 = x9.a(keyGenerator.generateKey().getEncoded());
        } catch (Throwable unused) {
            str5 = null;
        }
        if (!TextUtils.isEmpty(str5)) {
            String a3 = x9.a(eb.a((jSONObject2 + "\u0000").getBytes(), str5.getBytes()));
            if (!TextUtils.isEmpty(a3)) {
                try {
                    PublicKey a10 = x.a(b());
                    byte[] bytes = str5.getBytes("utf-8");
                    try {
                        Cipher cipher = Cipher.getInstance(n9.b(Encrypt.KEY_TRANSFORMATION));
                        cipher.init(1, a10);
                        bArr = cipher.doFinal(bytes);
                    } catch (Throwable unused2) {
                        bArr = null;
                    }
                    return n9.b("Fa2V5PQ") + URLEncoder.encode(x9.a(bArr)) + n9.b("SJmRhdGE9") + URLEncoder.encode(a3);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
        return null;
    }
}
