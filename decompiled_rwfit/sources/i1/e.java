package i1;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import m0.k;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final m0.f f14340a = new m0.f(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f14341b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f14342c;

    /* renamed from: d, reason: collision with root package name */
    public static final k f14343d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new h(0));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f14341b = threadPoolExecutor;
        f14342c = new Object();
        f14343d = new k();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i1.d a(java.lang.String r6, android.content.Context r7, androidx.camera.core.impl.e r8, int r9) {
        /*
            m0.f r0 = i1.e.f14340a
            java.lang.Object r1 = r0.a(r6)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L10
            i1.d r6 = new i1.d
            r6.<init>(r1)
            return r6
        L10:
            d6.a r8 = i1.b.a(r7, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            r1 = 1
            r2 = -3
            java.lang.Object r3 = r8.f12306b
            i1.f[] r3 = (i1.f[]) r3
            int r8 = r8.f12305a
            if (r8 == 0) goto L24
            if (r8 == r1) goto L22
        L20:
            r1 = r2
            goto L3d
        L22:
            r1 = -2
            goto L3d
        L24:
            if (r3 == 0) goto L3d
            int r8 = r3.length
            if (r8 != 0) goto L2a
            goto L3d
        L2a:
            int r8 = r3.length
            r1 = 0
            r4 = r1
        L2d:
            if (r4 >= r8) goto L3d
            r5 = r3[r4]
            int r5 = r5.e
            if (r5 == 0) goto L3a
            if (r5 >= 0) goto L38
            goto L20
        L38:
            r1 = r5
            goto L3d
        L3a:
            int r4 = r4 + 1
            goto L2d
        L3d:
            if (r1 == 0) goto L45
            i1.d r6 = new i1.d
            r6.<init>(r1)
            return r6
        L45:
            com.google.android.gms.internal.mlkit_vision_barcode.d1 r8 = c1.f.f3359a
            android.graphics.Typeface r7 = r8.b(r7, r3, r9)
            if (r7 == 0) goto L56
            r0.b(r6, r7)
            i1.d r6 = new i1.d
            r6.<init>(r7)
            return r6
        L56:
            i1.d r6 = new i1.d
            r6.<init>(r2)
            return r6
        L5c:
            i1.d r6 = new i1.d
            r7 = -1
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.e.a(java.lang.String, android.content.Context, androidx.camera.core.impl.e, int):i1.d");
    }
}
