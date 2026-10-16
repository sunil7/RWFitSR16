package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.util.List;

/* loaded from: classes.dex */
public class e9 {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f4000a;

        /* renamed from: b, reason: collision with root package name */
        String f4001b;

        /* renamed from: c, reason: collision with root package name */
        String f4002c;

        /* renamed from: d, reason: collision with root package name */
        String f4003d;
        String e;

        /* renamed from: f, reason: collision with root package name */
        String f4004f;

        /* renamed from: g, reason: collision with root package name */
        String f4005g;

        /* renamed from: h, reason: collision with root package name */
        String f4006h;

        /* renamed from: i, reason: collision with root package name */
        String f4007i;

        /* renamed from: j, reason: collision with root package name */
        String f4008j;

        /* renamed from: k, reason: collision with root package name */
        String f4009k;

        /* renamed from: l, reason: collision with root package name */
        String f4010l;

        /* renamed from: m, reason: collision with root package name */
        String f4011m;

        /* renamed from: n, reason: collision with root package name */
        String f4012n;

        /* renamed from: o, reason: collision with root package name */
        String f4013o;

        /* renamed from: p, reason: collision with root package name */
        String f4014p;

        /* renamed from: q, reason: collision with root package name */
        String f4015q;
        String r;

        /* renamed from: s, reason: collision with root package name */
        String f4016s;

        /* renamed from: t, reason: collision with root package name */
        String f4017t;

        /* renamed from: u, reason: collision with root package name */
        String f4018u;

        /* renamed from: v, reason: collision with root package name */
        String f4019v;

        /* renamed from: w, reason: collision with root package name */
        String f4020w;

        /* renamed from: x, reason: collision with root package name */
        String f4021x;

        /* renamed from: y, reason: collision with root package name */
        String f4022y;

        private a() {
        }

        public /* synthetic */ a(byte b3) {
            this();
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            return c(b9.g(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th2) {
            ga.a(th2, "CI", "Sco");
            return null;
        }
    }

    public static String b(String str) {
        FileInputStream fileInputStream;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                byte[] bArr = new byte[2048];
                MessageDigest messageDigest = MessageDigest.getInstance(n9.b("ETUQ1"));
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            String a3 = n9.a(messageDigest.digest());
                            try {
                                fileInputStream.close();
                                return a3;
                            } catch (IOException e) {
                                ga.a(e, "MD5", "gfm");
                                return a3;
                            }
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            ga.a(th, "MD5", "gfm");
                            return null;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e10) {
                                    ga.a(e10, "MD5", "gfm");
                                }
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static String c() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = !b9.a() ? "0" : "1";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th2) {
            ga.a(th2, "CI", "TS");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.Proxy$Type] */
    public static Proxy d(Context context) {
        Proxy proxy;
        String str = "pu";
        try {
            URI uri = new URI("http://restsdk.amap.com");
            if (f9.g(context) == 0) {
                try {
                    List<Proxy> select = ProxySelector.getDefault().select(uri);
                    if (select != null && !select.isEmpty() && (proxy = select.get(0)) != null) {
                        Proxy.Type type = proxy.type();
                        str = Proxy.Type.DIRECT;
                        if (type != str) {
                            return proxy;
                        }
                    }
                } catch (Throwable th2) {
                    ka.a(th2, "pu", "gpsc");
                }
            }
        } catch (Throwable th3) {
            ka.a(th3, str, "gp");
        }
        return null;
    }

    public static String a(String str) {
        byte[] bArr;
        if (str == null) {
            bArr = null;
        } else {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(n9.b("ETUQ1"));
                messageDigest.update(n9.e(str));
                bArr = messageDigest.digest();
            } catch (Throwable th2) {
                th2.printStackTrace();
                bArr = new byte[0];
            }
        }
        try {
            return n9.b(bArr);
        } catch (Throwable th3) {
            ga.a(th3, "ut", "csb2h");
            return null;
        }
    }

    public static String c(Context context) {
        try {
            a aVar = new a((byte) 0);
            aVar.f4003d = b9.f(context);
            aVar.f4007i = b9.c(context);
            return h9.c(a(context, aVar));
        } catch (Throwable th2) {
            ga.a(th2, "CI", "IX");
            return null;
        }
    }

    public static byte[] a(Context context, boolean z5, boolean z6) {
        try {
            return a(context, a(context, z5, z6, false));
        } catch (Throwable th2) {
            ga.a(th2, "CI", "gz");
            return null;
        }
    }

    private static String a() {
        String str;
        try {
            str = android.net.Proxy.getDefaultHost();
        } catch (Throwable th2) {
            ka.a(th2, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    public static String c(String str) {
        byte[] bArr;
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(n9.b("ETUQ1"));
            messageDigest.update(n9.e(str));
            bArr = messageDigest.digest();
        } catch (Throwable th2) {
            ga.a(th2, "MD5", "gmb");
            bArr = new byte[0];
        }
        return n9.a(bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x00d4, code lost:
    
        if (r9 != null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d6, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00db, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00dc, code lost:
    
        com.amap.api.col.p0003sl.ka.a(r0, "pu", "gPx2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
    
        if (r11 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008f, code lost:
    
        r15 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00bc, code lost:
    
        if (r11 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00c2, code lost:
    
        if (r9 != null) goto L133;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ff A[Catch: all -> 0x00e1, TRY_ENTER, TryCatch #0 {all -> 0x00e1, blocks: (B:103:0x00cb, B:65:0x00eb, B:71:0x00ff, B:73:0x0113, B:75:0x0119, B:79:0x0124, B:89:0x012d, B:91:0x0133, B:93:0x0139, B:97:0x0144), top: B:4:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00f9 A[Catch: all -> 0x00f6, TRY_LEAVE, TryCatch #9 {all -> 0x00f6, blocks: (B:67:0x00f0, B:99:0x00f9), top: B:66:0x00f0 }] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.net.Proxy a(android.content.Context r20) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.e9.a(android.content.Context):java.net.Proxy");
    }

    public static String b(Context context) {
        try {
            return h9.c(a(context, a(context, false, false, false)));
        } catch (Throwable th2) {
            ga.a(th2, "CI", "gCXi");
            return null;
        }
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th2) {
            ka.a(th2, "pu", "gdp");
            return -1;
        }
    }

    private static byte[] a(Context context, a aVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] a3;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            a(byteArrayOutputStream, aVar.f4000a);
            a(byteArrayOutputStream, aVar.f4001b);
            a(byteArrayOutputStream, aVar.f4002c);
            a(byteArrayOutputStream, aVar.f4003d);
            a(byteArrayOutputStream, aVar.e);
            a(byteArrayOutputStream, aVar.f4004f);
            a(byteArrayOutputStream, aVar.f4005g);
            a(byteArrayOutputStream, aVar.f4006h);
            a(byteArrayOutputStream, aVar.f4007i);
            a(byteArrayOutputStream, aVar.f4008j);
            a(byteArrayOutputStream, aVar.f4009k);
            a(byteArrayOutputStream, aVar.f4010l);
            a(byteArrayOutputStream, aVar.f4011m);
            a(byteArrayOutputStream, aVar.f4012n);
            a(byteArrayOutputStream, aVar.f4013o);
            a(byteArrayOutputStream, aVar.f4014p);
            a(byteArrayOutputStream, aVar.f4015q);
            a(byteArrayOutputStream, aVar.r);
            a(byteArrayOutputStream, aVar.f4016s);
            a(byteArrayOutputStream, aVar.f4017t);
            a(byteArrayOutputStream, (String) null);
            a(byteArrayOutputStream, (String) null);
            a(byteArrayOutputStream, aVar.f4018u);
            a(byteArrayOutputStream, aVar.f4019v);
            a(byteArrayOutputStream, aVar.f4020w);
            a(byteArrayOutputStream, aVar.f4021x);
            a(byteArrayOutputStream, aVar.f4022y);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            new String(byteArray);
            byte[] f2 = n9.f(byteArray);
            PublicKey a10 = n9.a();
            if (f2.length > 117) {
                byte[] bArr = new byte[117];
                System.arraycopy(f2, 0, bArr, 0, 117);
                byte[] a11 = h9.a(bArr, a10);
                a3 = new byte[f2.length + 11];
                System.arraycopy(a11, 0, a3, 0, 128);
                System.arraycopy(f2, 117, a3, 128, f2.length - 117);
            } else {
                a3 = h9.a(f2, a10);
            }
            try {
                byteArrayOutputStream.close();
                return a3;
            } catch (Throwable th3) {
                th3.printStackTrace();
                return a3;
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                ga.a(th, "CI", "gzx");
                return null;
            } finally {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
        }
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            n9.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, n9.e(str));
        } else {
            n9.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.amap.api.col.3sl.e9.a a(android.content.Context r5, boolean r6, boolean r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.e9.a(android.content.Context, boolean, boolean, boolean):com.amap.api.col.3sl.e9$a");
    }

    public static String a(byte[] bArr) {
        byte[] bArr2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(n9.b("ETUQ1"));
            messageDigest.update(bArr);
            bArr2 = messageDigest.digest();
        } catch (Throwable th2) {
            ga.a(th2, "MD5", "gmb");
            bArr2 = null;
        }
        return n9.a(bArr2);
    }
}
