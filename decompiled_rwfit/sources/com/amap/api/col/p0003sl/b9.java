package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: classes.dex */
public class b9 {

    /* renamed from: a, reason: collision with root package name */
    private static String f3781a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f3782b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f3783c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f3784d = "";
    static String e = null;

    /* renamed from: f, reason: collision with root package name */
    static boolean f3785f = false;

    /* renamed from: g, reason: collision with root package name */
    private static int f3786g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f3787h = false;

    public static class a extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3788a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3789b;

        public a(Context context, String str) {
            this.f3788a = context;
            this.f3789b = str;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public final void runTask() {
            Throwable th2;
            FileOutputStream fileOutputStream;
            try {
                File file = new File(ha.a(this.f3788a, "k.store"));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(n9.e(this.f3789b));
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    try {
                        ga.a(th2, "AI", "stf");
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                    } catch (Throwable th6) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th8) {
                th2 = th8;
                fileOutputStream = null;
            }
        }
    }

    public static boolean a() {
        if (f3785f) {
            return true;
        }
        if (b(e)) {
            f3785f = true;
            return true;
        }
        if (!TextUtils.isEmpty(e)) {
            f3785f = false;
            e = null;
            return false;
        }
        if (b(f3782b)) {
            f3785f = true;
            return true;
        }
        if (!TextUtils.isEmpty(f3782b)) {
            f3785f = false;
            f3782b = null;
            return false;
        }
        return true;
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c9 : str.toCharArray()) {
            if (('A' > c9 || c9 > 'z') && (('0' > c9 || c9 > ':') && c9 != '.')) {
                try {
                    ka.a(n9.b(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static void c(String str) {
        f3782b = str;
    }

    public static String d(Context context) {
        try {
            return a(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return f3784d;
        }
    }

    public static String e(Context context) {
        try {
            int i3 = c9.f3817a;
            if (context != null) {
                c9.f3819c = context.getApplicationContext();
            }
        } catch (Throwable unused) {
        }
        try {
            return a(context);
        } catch (Throwable th2) {
            ga.a(th2, "AI", "gKy");
            return f3784d;
        }
    }

    public static String f(Context context) {
        String str;
        try {
            str = f3782b;
        } catch (Throwable th2) {
            ga.a(th2, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return f3782b;
        }
        String packageName = context.getPackageName();
        f3782b = packageName;
        if (!b(packageName)) {
            f3782b = context.getPackageName();
        }
        return f3782b;
    }

    public static String g(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(n9.b("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b3 : digest) {
                String upperCase = Integer.toHexString(b3 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (b(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f3782b)) {
                str = f(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            e = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th2) {
            ga.a(th2, "AI", "gsp");
            return e;
        }
    }

    public static String c(Context context) {
        try {
        } catch (Throwable th2) {
            ga.a(th2, "AI", "gAV");
        }
        if (!"".equals(f3783c)) {
            return f3783c;
        }
        f3783c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        String str = f3783c;
        return str == null ? "" : str;
    }

    public static String b(Context context) {
        try {
        } catch (Throwable th2) {
            ga.a(th2, "AI", "gAN");
        }
        if (!"".equals(f3781a)) {
            return f3781a;
        }
        PackageManager packageManager = context.getPackageManager();
        f3781a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f3781a;
    }

    public static boolean c() {
        return f3787h;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f3784d = str;
    }

    public static int b() {
        return f3786g;
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f3784d = str;
        if (context != null) {
            qc.d().b(new a(context, str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(android.content.Context r5) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            java.lang.String r0 = com.amap.api.col.p0003sl.b9.f3784d
            java.lang.String r1 = ""
            if (r0 == 0) goto Lc
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L95
        Lc:
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            java.lang.String r2 = r5.getPackageName()
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r2, r3)
            if (r0 == 0) goto L98
            android.os.Bundle r0 = r0.metaData
            if (r0 != 0) goto L22
            goto L98
        L22:
            java.lang.String r2 = "com.amap.api.v2.apikey"
            java.lang.String r0 = r0.getString(r2)
            com.amap.api.col.p0003sl.b9.f3784d = r0
            if (r0 != 0) goto L95
            java.lang.String r0 = "k.store"
            java.lang.String r5 = com.amap.api.col.p0003sl.ha.a(r5, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 != 0) goto L3e
            goto L86
        L3e:
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L64
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L64
            int r2 = r5.available()     // Catch: java.lang.Throwable -> L62
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L62
            r5.read(r2)     // Catch: java.lang.Throwable -> L62
            java.lang.String r2 = com.amap.api.col.p0003sl.n9.c(r2)     // Catch: java.lang.Throwable -> L62
            int r0 = r2.length()     // Catch: java.lang.Throwable -> L62
            r3 = 32
            if (r0 != r3) goto L59
            r1 = r2
        L59:
            r5.close()     // Catch: java.lang.Throwable -> L5d
            goto L86
        L5d:
            r5 = move-exception
            r5.printStackTrace()
            goto L86
        L62:
            r2 = move-exception
            goto L67
        L64:
            r5 = move-exception
            r2 = r5
            r5 = 0
        L67:
            java.lang.String r3 = "AI"
            java.lang.String r4 = "gKe"
            com.amap.api.col.p0003sl.ga.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L89
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L78
            if (r2 == 0) goto L7c
            r0.delete()     // Catch: java.lang.Throwable -> L78
            goto L7c
        L78:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L89
        L7c:
            if (r5 == 0) goto L86
            r5.close()     // Catch: java.lang.Throwable -> L82
            goto L86
        L82:
            r5 = move-exception
            r5.printStackTrace()
        L86:
            com.amap.api.col.p0003sl.b9.f3784d = r1
            goto L95
        L89:
            r0 = move-exception
            if (r5 == 0) goto L94
            r5.close()     // Catch: java.lang.Throwable -> L90
            goto L94
        L90:
            r5 = move-exception
            r5.printStackTrace()
        L94:
            throw r0
        L95:
            java.lang.String r5 = com.amap.api.col.p0003sl.b9.f3784d
            return r5
        L98:
            java.lang.String r5 = com.amap.api.col.p0003sl.b9.f3784d
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.b9.a(android.content.Context):java.lang.String");
    }

    public static void a(int i3) {
        f3786g = i3;
    }

    public static void a(boolean z5) {
        f3787h = z5;
    }
}
