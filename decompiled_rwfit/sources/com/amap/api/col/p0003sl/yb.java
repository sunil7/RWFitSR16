package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class yb {

    /* renamed from: a, reason: collision with root package name */
    static int f5477a = 1000;

    /* renamed from: b, reason: collision with root package name */
    static boolean f5478b = false;

    /* renamed from: c, reason: collision with root package name */
    static int f5479c = 20;

    /* renamed from: d, reason: collision with root package name */
    private static int f5480d = 10;
    static int e;

    @Deprecated
    public static synchronized void a(int i3, boolean z5) {
        synchronized (yb.class) {
            f5477a = i3;
            f5478b = z5;
        }
    }

    public static class a extends rc {

        /* renamed from: a, reason: collision with root package name */
        private int f5481a;

        /* renamed from: b, reason: collision with root package name */
        private Context f5482b;

        /* renamed from: c, reason: collision with root package name */
        private xb f5483c;

        public a(Context context, int i3) {
            this.f5482b = context;
            this.f5481a = i3;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public final void runTask() {
            int i3 = this.f5481a;
            if (i3 == 1) {
                try {
                    synchronized (yb.class) {
                        try {
                            String l3 = Long.toString(System.currentTimeMillis());
                            ub a3 = vb.a((WeakReference<ub>) null);
                            Context context = this.f5482b;
                            int i10 = ha.f4272c;
                            vb.a(context, a3, "f", yb.f5477a, 2097152, Constants.VIA_SHARE_TYPE_INFO);
                            if (a3.e == null) {
                                a3.e = new ab(new cb(new db(new cb())));
                            }
                            vb.a(l3, this.f5483c.a(), a3);
                        } finally {
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    ka.a(th2, "ofm", "aple");
                    return;
                }
            }
            if (i3 == 2) {
                try {
                    ub a10 = vb.a((WeakReference<ub>) null);
                    Context context2 = this.f5482b;
                    int i11 = ha.f4272c;
                    vb.a(context2, a10, "f", yb.f5477a, 2097152, Constants.VIA_SHARE_TYPE_INFO);
                    a10.f5156h = 14400000;
                    if (a10.f5155g == null) {
                        ab abVar = new ab(new cb(new db()));
                        Context context3 = this.f5482b;
                        ic icVar = new ic();
                        String str = new String(ca.a());
                        String e = b9.e(this.f5482b);
                        String b3 = f9.b();
                        String c9 = f9.c();
                        String t8 = f9.t(this.f5482b);
                        String e10 = f9.e();
                        String str2 = Build.MANUFACTURER;
                        String str3 = Build.DEVICE;
                        String f2 = b9.f(this.f5482b);
                        String str4 = Build.MODEL;
                        String c10 = b9.c(this.f5482b);
                        String b10 = b9.b(this.f5482b);
                        String q5 = f9.q(this.f5482b);
                        String f10 = f9.f(this.f5482b);
                        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
                        o9.a(this.f5482b);
                        a10.f5155g = new ec(new dc(context3, icVar, abVar, str, e, b3, c9, t8, e10, str2, str3, "", f2, str4, c10, b10, q5, f10, valueOf, ""));
                    }
                    if (TextUtils.isEmpty(a10.f5157i)) {
                        a10.f5157i = "fKey";
                    }
                    Context context4 = this.f5482b;
                    a10.f5154f = new mc(context4, a10.f5156h, a10.f5157i, new kc(context4, yb.f5478b, yb.f5480d * 1024, yb.f5479c * 1024, "offLocKey", yb.e * 1024));
                    vb.a(a10);
                } catch (Throwable th3) {
                    ka.a(th3, "ofm", "uold");
                }
            }
        }

        public a(Context context, xb xbVar) {
            this(context, 1);
            this.f5483c = xbVar;
        }
    }

    public static synchronized void a(int i3, boolean z5, int i10, int i11) {
        synchronized (yb.class) {
            try {
                f5477a = i3;
                f5478b = z5;
                if (i10 < 10 || i10 > 100) {
                    i10 = 20;
                }
                f5479c = i10;
                if (i10 / 5 > f5480d) {
                    f5480d = i10 / 5;
                }
                e = i11;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static synchronized void a(xb xbVar, Context context) {
        synchronized (yb.class) {
            qc.d().b(new a(context, xbVar));
        }
    }

    public static void a(Context context) {
        qc.d().b(new a(context, 2));
    }
}
