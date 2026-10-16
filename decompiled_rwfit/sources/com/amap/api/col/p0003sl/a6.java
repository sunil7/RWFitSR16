package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class a6 {

    /* renamed from: a, reason: collision with root package name */
    private static Context f3599a = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f3601c = "amap_resource1_0_0.png";

    /* renamed from: d, reason: collision with root package name */
    private static String f3602d = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f3600b = "amap_resource1_0_0.jar";
    private static String e = f3602d + f3600b;

    /* renamed from: f, reason: collision with root package name */
    public static int f3603f = -1;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        if (r1 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0006, code lost:
    
        if (r4 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.content.Context r4) {
        /*
            r0 = 1
            com.amap.api.col.p0003sl.a6.f3599a = r4     // Catch: java.lang.Throwable -> L39
            r1 = 0
            if (r4 != 0) goto L9
            if (r4 == 0) goto L44
            goto L35
        L9:
            java.lang.String r2 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.String r3 = "mounted"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            if (r2 == 0) goto L2f
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            boolean r2 = r1.canWrite()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            if (r2 != 0) goto L28
            java.io.File r1 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            goto L33
        L24:
            r2 = move-exception
            goto L73
        L26:
            r2 = move-exception
            goto L3b
        L28:
            java.lang.String r2 = "LBS"
            java.io.File r1 = r4.getExternalFilesDir(r2)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            goto L33
        L2f:
            java.io.File r1 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
        L33:
            if (r1 != 0) goto L44
        L35:
            r4.getFilesDir()     // Catch: java.lang.Throwable -> L39
            goto L44
        L39:
            r4 = move-exception
            goto L79
        L3b:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r1 != 0) goto L44
            java.io.File r1 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L39
        L44:
            if (r1 == 0) goto L5d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r4.<init>()     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L39
            r4.append(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = "/"
            r4.append(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L39
            com.amap.api.col.p0003sl.a6.f3602d = r4     // Catch: java.lang.Throwable -> L39
        L5d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r4.<init>()     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = com.amap.api.col.p0003sl.a6.f3602d     // Catch: java.lang.Throwable -> L39
            r4.append(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = com.amap.api.col.p0003sl.a6.f3600b     // Catch: java.lang.Throwable -> L39
            r4.append(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L39
            com.amap.api.col.p0003sl.a6.e = r4     // Catch: java.lang.Throwable -> L39
            return r0
        L73:
            if (r1 != 0) goto L78
            r4.getFilesDir()     // Catch: java.lang.Throwable -> L39
        L78:
            throw r2     // Catch: java.lang.Throwable -> L39
        L79:
            r4.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.a6.a(android.content.Context):boolean");
    }

    public static Resources a() {
        return f3599a.getResources();
    }

    public static View a(Context context, int i3, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(f3599a.getResources().getXml(i3), (ViewGroup) null);
    }
}
