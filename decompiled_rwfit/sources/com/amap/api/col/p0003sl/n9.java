package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.p0003sl.m9;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class n9 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f4704a = {"arm64-v8a", "x86_64"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f4705b = {"arm", "x86"};

    /* renamed from: c, reason: collision with root package name */
    static String f4706c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f4707d = 0;

    static {
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < 80; i3++) {
            sb2.append("=");
        }
        f4706c = sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r8) {
        /*
            java.lang.Class<android.os.Build> r0 = android.os.Build.class
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "ut"
            r3 = 1
            r4 = 28
            if (r1 >= r4) goto L2f
            android.content.pm.ApplicationInfo r1 = r8.getApplicationInfo()     // Catch: java.lang.Throwable -> L29
            java.lang.Class<android.content.pm.ApplicationInfo> r5 = android.content.pm.ApplicationInfo.class
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L29
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Throwable -> L29
            java.lang.String r6 = "primaryCpuAbi"
            java.lang.reflect.Field r5 = r5.getDeclaredField(r6)     // Catch: java.lang.Throwable -> L29
            r5.setAccessible(r3)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r1 = r5.get(r1)     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L29
            goto L31
        L29:
            r1 = move-exception
            java.lang.String r5 = "gct"
            com.amap.api.col.p0003sl.ga.a(r1, r2, r5)
        L2f:
            java.lang.String r1 = ""
        L31:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r4) goto L9b
            java.lang.String r4 = "SUPPORTED_ABIS"
            java.lang.reflect.Field r4 = r0.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L4b
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch: java.lang.Throwable -> L4b
            r6 = 0
            if (r4 == 0) goto L4d
            int r7 = r4.length     // Catch: java.lang.Throwable -> L4b
            if (r7 <= 0) goto L4d
            r1 = r4[r6]     // Catch: java.lang.Throwable -> L4b
            goto L4d
        L4b:
            r8 = move-exception
            goto L96
        L4d:
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L4b
            if (r4 != 0) goto L9b
            java.lang.String[] r4 = com.amap.api.col.p0003sl.n9.f4704a     // Catch: java.lang.Throwable -> L4b
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: java.lang.Throwable -> L4b
            boolean r4 = r4.contains(r1)     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L9b
            android.content.pm.ApplicationInfo r8 = r8.getApplicationInfo()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r8 = r8.nativeLibraryDir     // Catch: java.lang.Throwable -> L4b
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L4b
            if (r4 != 0) goto L9b
            java.lang.String r4 = java.io.File.separator     // Catch: java.lang.Throwable -> L4b
            int r4 = r8.lastIndexOf(r4)     // Catch: java.lang.Throwable -> L4b
            int r4 = r4 + r3
            java.lang.String r8 = r8.substring(r4)     // Catch: java.lang.Throwable -> L4b
            java.lang.String[] r3 = com.amap.api.col.p0003sl.n9.f4705b     // Catch: java.lang.Throwable -> L4b
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch: java.lang.Throwable -> L4b
            boolean r8 = r3.contains(r8)     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9b
            java.lang.String r8 = "SUPPORTED_32_BIT_ABIS"
            java.lang.reflect.Field r8 = r0.getDeclaredField(r8)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r8 = r8.get(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9b
            int r0 = r8.length     // Catch: java.lang.Throwable -> L4b
            if (r0 <= 0) goto L9b
            r1 = r8[r6]     // Catch: java.lang.Throwable -> L4b
            goto L9b
        L96:
            java.lang.String r0 = "gct_p"
            com.amap.api.col.p0003sl.ga.a(r8, r2, r0)
        L9b:
            boolean r8 = android.text.TextUtils.isEmpty(r1)
            if (r8 == 0) goto La3
            java.lang.String r1 = android.os.Build.CPU_ABI
        La3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.n9.a(android.content.Context):java.lang.String");
    }

    public static m9 b() throws a9 {
        return new m9.a("collection", BuildConfig.VERSION_NAME, "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).a();
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    private static byte[] d(byte[] bArr) throws IOException, Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th4) {
            th = th4;
            gZIPOutputStream2 = gZIPOutputStream;
            try {
                throw th;
            } catch (Throwable th5) {
                if (gZIPOutputStream2 != null) {
                    gZIPOutputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th5;
            }
        }
    }

    public static byte[] e(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        String b3 = h9.b(e(str));
        try {
            return ((char) ((b3.length() % 26) + 65)) + b3;
        } catch (Throwable th2) {
            ga.a(th2, "ut", "tsfb64");
            return "";
        }
    }

    public static String b(String str) {
        return str.length() < 2 ? "" : c(h9.a(str.substring(1)));
    }

    public static byte[] c() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(Const.STR_MART_COMMA);
            byte[] bArr = new byte[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                bArr[i3] = Byte.parseByte(split[i3]);
            }
            String[] split2 = new StringBuffer(new String(h9.a(new String(bArr)))).reverse().toString().split(Const.STR_MART_COMMA);
            byte[] bArr2 = new byte[split2.length];
            for (int i10 = 0; i10 < split2.length; i10++) {
                bArr2[i10] = Byte.parseByte(split2[i10]);
            }
            return bArr2;
        } catch (Throwable th2) {
            ga.a(th2, "ut", "gIV");
            return new byte[16];
        }
    }

    public static byte[] e(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] f(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th2) {
            ga.a(th2, "ut", "gZp");
            return new byte[0];
        }
    }

    public static String b(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b3 : bArr) {
            String hexString = Integer.toHexString(b3 & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return c(h9.a(str)).contains(Build.MODEL + Build.VERSION.SDK_INT);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte[] c(String str) {
        if (str.length() % 2 != 0) {
            str = "0".concat(str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i10 = i3 * 2;
            bArr[i3] = (byte) Integer.parseInt(str.substring(i10, i10 + 2), 16);
        }
        return bArr;
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
                return;
            } catch (IOException e) {
                ga.a(e, "ut", "wsf");
                return;
            }
        }
        int length = str.length();
        if (length > 255) {
            length = 255;
        }
        a(byteArrayOutputStream, (byte) length, e(str));
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, byte b3, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b3});
            int i3 = b3 & 255;
            if (i3 < 255 && i3 > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i3 == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            ga.a(e, "ut", "wFie");
        }
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] a(int i3, int i10) {
        if (i10 > 4) {
            return new byte[0];
        }
        if (i10 == 2) {
            return new byte[]{(byte) (i3 / 256), (byte) (i3 % 256)};
        }
        return new byte[i10];
    }

    public static PublicKey a() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(h9.a("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
        } catch (Throwable unused) {
            byteArrayInputStream = null;
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(b("IWC41MDk"));
            KeyFactory keyFactory = KeyFactory.getInstance(b("EUlNB"));
            Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
            if (generateCertificate != null && keyFactory != null) {
                PublicKey generatePublic = keyFactory.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
                try {
                    byteArrayInputStream.close();
                    return generatePublic;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return generatePublic;
                }
            }
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            return null;
        } catch (Throwable unused2) {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
            return null;
        }
    }

    public static String a(byte[] bArr) {
        try {
            return b(bArr);
        } catch (Throwable th2) {
            ga.a(th2, "ut", "h2s");
            return null;
        }
    }

    public static String a(long j4, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j4));
        } catch (Throwable th2) {
            ga.a(th2, "ut", "ctt");
            return null;
        }
    }

    public static void a(Context context, String str, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String b3;
        str3 = "";
        String g10 = b9.g(context);
        String c9 = e9.c(g10);
        String d5 = b9.d(context);
        try {
            if (jSONObject.has("info")) {
                str5 = jSONObject.getString("info");
                str4 = "请在高德开放平台官网中搜索\"" + str5 + "\"相关内容进行解决";
            } else {
                str5 = "";
                str4 = str5;
            }
            try {
                if ("INVALID_USER_SCODE".equals(str5)) {
                    String string = jSONObject.has("sec_code") ? jSONObject.getString("sec_code") : "";
                    str3 = jSONObject.has("sec_code_debug") ? jSONObject.getString("sec_code_debug") : "";
                    if (c9.equals(string) || c9.equals(str3)) {
                        b3 = b("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si") + "\"请求内容过长导致业务调用失败\"相关内容进行解决";
                        str4 = b3;
                    }
                } else if ("INVALID_USER_KEY".equals(str5)) {
                    str3 = jSONObject.has("key") ? jSONObject.getString("key") : "";
                    if (str3.length() > 0 && !d5.equals(str3)) {
                        b3 = b("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");
                        str4 = b3;
                    }
                }
            } catch (Throwable unused) {
                str3 = str4;
                str4 = str3;
                Log.i("authErrLog", f4706c);
                Log.i("authErrLog", "                                   鉴权错误信息                                  ");
                Log.i("authErrLog", f4706c);
                a("SHA1Package:".concat(String.valueOf(g10)));
                a("key:".concat(String.valueOf(d5)));
                a("csid:".concat(String.valueOf(str)));
                a("gsid:".concat(String.valueOf(str2)));
                a("json:" + jSONObject.toString());
                Log.i("authErrLog", "                                                                               ");
                Log.i("authErrLog", str4);
                Log.i("authErrLog", f4706c);
            }
        } catch (Throwable unused2) {
        }
        Log.i("authErrLog", f4706c);
        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
        Log.i("authErrLog", f4706c);
        a("SHA1Package:".concat(String.valueOf(g10)));
        a("key:".concat(String.valueOf(d5)));
        a("csid:".concat(String.valueOf(str)));
        a("gsid:".concat(String.valueOf(str2)));
        a("json:" + jSONObject.toString());
        Log.i("authErrLog", "                                                                               ");
        Log.i("authErrLog", str4);
        Log.i("authErrLog", f4706c);
    }

    private static void a(String str) {
        int i3;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            Log.i("authErrLog", "|" + str.substring(0, 78) + "|");
            str = str.substring(78);
        }
        StringBuilder sb2 = new StringBuilder("|");
        sb2.append(str);
        for (i3 = 0; i3 < 78 - str.length(); i3++) {
            sb2.append(" ");
        }
        sb2.append("|");
        Log.i("authErrLog", sb2.toString());
    }

    public static String a(Map<String, String> map) {
        String str;
        if (map != null) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append(Const.STR_MART_ADD);
                }
                sb2.append(entry.getKey());
                sb2.append("=");
                sb2.append(entry.getValue());
            }
            str = sb2.toString();
        } else {
            str = null;
        }
        try {
        } catch (Throwable th2) {
            ga.a(th2, "ut", "sPa");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(Const.STR_MART_ADD);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append(str2);
                stringBuffer.append(Const.STR_MART_ADD);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }
}
