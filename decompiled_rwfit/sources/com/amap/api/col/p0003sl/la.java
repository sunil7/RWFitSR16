package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class la {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4493a = true;

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference<nc> f4494b = null;

    /* renamed from: c, reason: collision with root package name */
    private static WeakReference<nc> f4495c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String[] f4496d = new String[10];
    private static int e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f4497f = false;

    /* renamed from: g, reason: collision with root package name */
    private static int f4498g;

    /* renamed from: h, reason: collision with root package name */
    private static m9 f4499h;

    public static class a extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4500a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m9 f4501b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4502c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f4503d;
        final /* synthetic */ String e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ub f4504f;

        public a(Context context, m9 m9Var, String str, String str2, String str3, ub ubVar) {
            this.f4500a = context;
            this.f4501b = m9Var;
            this.f4502c = str;
            this.f4503d = str2;
            this.e = str3;
            this.f4504f = ubVar;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public final void runTask() {
            Context context = this.f4500a;
            m9 m9Var = this.f4501b;
            String str = this.f4502c;
            String str2 = this.f4503d;
            String str3 = this.e;
            String a3 = n9.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss:SSS");
            String a10 = vb.a(context, m9Var);
            b9.d(context);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a10);
            stringBuffer.append(",\"timestamp\":\"");
            stringBuffer.append(a3);
            stringBuffer.append("\",\"et\":\"1\",\"classname\":\"");
            stringBuffer.append(str);
            stringBuffer.append("\",\"traceInfo\":\"");
            stringBuffer.append(str3);
            stringBuffer.append("\",\"detail\":\"");
            stringBuffer.append(str2);
            stringBuffer.append("\"");
            String stringBuffer2 = stringBuffer.toString();
            ub ubVar = this.f4504f;
            if (ubVar.e == null) {
                ubVar.e = new za(new ab(new cb(new db())));
            }
            try {
                vb.a(e9.a(stringBuffer2), n9.e(stringBuffer2), this.f4504f);
            } catch (Throwable unused) {
            }
        }
    }

    public static class b extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4505a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4506b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ nc f4507c;

        public b(Context context, String str, nc ncVar) {
            this.f4505a = context;
            this.f4506b = str;
            this.f4507c = ncVar;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public final void runTask() {
            try {
                synchronized (la.class) {
                    try {
                        ub a3 = vb.a((WeakReference<ub>) null);
                        vb.a(this.f4505a, a3, this.f4506b, 1000, 4096000, "1");
                        a3.f5154f = this.f4507c;
                        if (a3.f5155g == null) {
                            Context context = this.f4505a;
                            a3.f5155g = new ec(new dc(context, new ic(), new ab(new cb(new db())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", b9.e(context), f9.b(), f9.p(this.f4505a), b9.f(this.f4505a), Build.MODEL, b9.b(this.f4505a), b9.c(this.f4505a), Build.VERSION.RELEASE));
                        }
                        a3.f5156h = 3600000;
                        vb.a(a3);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                ka.a(th3, "lg", "pul");
            }
        }
    }

    public static class c extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ub f4508a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f4509b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f4510c;

        public c(ub ubVar, Context context, d dVar) {
            this.f4508a = ubVar;
            this.f4509b = context;
            this.f4510c = dVar;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public final void runTask() {
            try {
                synchronized (la.class) {
                    try {
                        ub ubVar = this.f4508a;
                        if (ubVar.f5155g == null) {
                            Context context = this.f4509b;
                            ubVar.f5155g = new ec(new dc(context, new ic(), new ab(new cb(new db())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", b9.e(context), f9.b(), f9.p(this.f4509b), b9.f(this.f4509b), Build.MODEL, b9.b(this.f4509b), b9.c(this.f4509b), Build.VERSION.RELEASE));
                        }
                        int a3 = vb.a(this.f4508a);
                        d dVar = this.f4510c;
                        if (dVar != null) {
                            dVar.a(a3);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                ka.a(th2, "lg", "pul");
            }
        }
    }

    public interface d {
        void a(int i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c5, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00cd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r17, java.lang.Throwable r18, int r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.la.a(android.content.Context, java.lang.Throwable, int, java.lang.String, java.lang.String):void");
    }

    public static void b(Context context) {
        lc lcVar = new lc(f4493a);
        f4493a = false;
        int i3 = ha.f4272c;
        a(context, lcVar, "c");
    }

    public static void c(Context context) {
        WeakReference<nc> weakReference = f4494b;
        if (weakReference == null || weakReference.get() == null) {
            f4494b = new WeakReference<>(new mc(context, 3600000, "hKey", new oc(context, false)));
        }
        nc ncVar = f4494b.get();
        int i3 = ha.f4272c;
        a(context, ncVar, Const.INTENT_KEY_UMID);
    }

    public static void d(Context context) {
        WeakReference<nc> weakReference = f4495c;
        if (weakReference == null || weakReference.get() == null) {
            f4495c = new WeakReference<>(new mc(context, 3600000, "gKey", new oc(context, false)));
        }
        nc ncVar = f4495c.get();
        int i3 = ha.f4272c;
        a(context, ncVar, Const.INTENT_KEY_PKGNAME);
    }

    public static void a(m9 m9Var, Context context, String str, String str2) {
        if (m9Var == null || !m9Var.f() || str == null || "".equals(str)) {
            return;
        }
        a(context, m9Var, 1, str, str2);
    }

    private static void a(Context context, m9 m9Var, int i3, String str, String str2) {
        String str3;
        String a3 = n9.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss:SSS");
        String a10 = vb.a(context, m9Var);
        b9.d(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a10);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(a3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i3);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",\"detail\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || "".equals(stringBuffer2)) {
            return;
        }
        String a11 = e9.a(str2);
        if (i3 == 1) {
            int i10 = ha.f4272c;
            str3 = Const.INTENT_KEY_PKGNAME;
        } else if (i3 == 2) {
            int i11 = ha.f4272c;
            str3 = Const.INTENT_KEY_UMID;
        } else {
            if (i3 != 0) {
                return;
            }
            int i12 = ha.f4272c;
            str3 = "c";
        }
        ub a12 = vb.a((WeakReference<ub>) null);
        a12.f5150a = ha.a(context, str3);
        a12.f5153d = 1000;
        a12.f5151b = 4096000;
        a12.f5152c = "1";
        if (a12.e == null) {
            a12.e = new za(new ab(new cb(new db())));
        }
        try {
            vb.a(a11, n9.e(stringBuffer2.replaceAll("\n", "<br/>")), a12);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x00fb, code lost:
    
        if (r8 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00d6, code lost:
    
        if (r8 == null) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.la.a(android.content.Context):void");
    }

    public static void a(Context context, m9 m9Var, String str, int i3, String str2, String str3) {
        if (str2 == null || "".equals(str2)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("class:");
        sb2.append(str2);
        if (str3 != null) {
            sb2.append(" method:");
            sb2.append(str3);
            sb2.append("$<br/>");
        }
        sb2.append(str);
        a(context, m9Var, i3, str2, sb2.toString());
    }

    public static void a(Context context, m9 m9Var, String str, ub ubVar, String str2, String str3) {
        try {
            qc.d().b(new a(context, m9Var, str, str2, str3, ubVar));
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, nc ncVar, String str) {
        qc.d().b(new b(context, str, ncVar));
    }

    public static void a(Context context, ub ubVar, d dVar) {
        try {
            qc.d().b(new c(ubVar, context, dVar));
        } catch (Throwable unused) {
        }
    }
}
