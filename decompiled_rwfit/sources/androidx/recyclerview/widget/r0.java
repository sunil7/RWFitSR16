package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class r0 {

    /* renamed from: a, reason: collision with root package name */
    public int f2721a = -1;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f2722b;

    /* renamed from: c, reason: collision with root package name */
    public i1 f2723c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2724d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public View f2725f;

    /* renamed from: g, reason: collision with root package name */
    public final u1 f2726g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2727h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f2728i;

    /* renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f2729j;

    /* renamed from: k, reason: collision with root package name */
    public PointF f2730k;

    /* renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f2731l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2732m;

    /* renamed from: n, reason: collision with root package name */
    public float f2733n;

    /* renamed from: o, reason: collision with root package name */
    public int f2734o;

    /* renamed from: p, reason: collision with root package name */
    public int f2735p;

    public r0(Context context) {
        u1 u1Var = new u1();
        u1Var.f2749d = -1;
        u1Var.f2750f = false;
        u1Var.f2751g = 0;
        u1Var.f2746a = 0;
        u1Var.f2747b = 0;
        u1Var.f2748c = Integer.MIN_VALUE;
        u1Var.e = null;
        this.f2726g = u1Var;
        this.f2728i = new LinearInterpolator();
        this.f2729j = new DecelerateInterpolator();
        this.f2732m = false;
        this.f2734o = 0;
        this.f2735p = 0;
        this.f2731l = context.getResources().getDisplayMetrics();
    }

    public static int a(int i3, int i10, int i11, int i12, int i13) {
        if (i13 == -1) {
            return i11 - i3;
        }
        if (i13 != 0) {
            if (i13 == 1) {
                return i12 - i10;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i14 = i11 - i3;
        if (i14 > 0) {
            return i14;
        }
        int i15 = i12 - i10;
        if (i15 < 0) {
            return i15;
        }
        return 0;
    }

    public float b(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int c(int i3) {
        float abs = Math.abs(i3);
        if (!this.f2732m) {
            this.f2733n = b(this.f2731l);
            this.f2732m = true;
        }
        return (int) Math.ceil(abs * this.f2733n);
    }

    public final PointF d(int i3) {
        Object obj = this.f2723c;
        if (obj instanceof v1) {
            return ((v1) obj).a(i3);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + v1.class.getCanonicalName());
        return null;
    }

    public final void e(int i3, int i10) {
        PointF d5;
        RecyclerView recyclerView = this.f2722b;
        if (this.f2721a == -1 || recyclerView == null) {
            g();
        }
        if (this.f2724d && this.f2725f == null && this.f2723c != null && (d5 = d(this.f2721a)) != null) {
            float f2 = d5.x;
            if (f2 != 0.0f || d5.y != 0.0f) {
                recyclerView.f0(null, (int) Math.signum(f2), (int) Math.signum(d5.y));
            }
        }
        this.f2724d = false;
        View view = this.f2725f;
        u1 u1Var = this.f2726g;
        if (view != null) {
            this.f2722b.getClass();
            z1 L = RecyclerView.L(view);
            if ((L != null ? L.getLayoutPosition() : -1) == this.f2721a) {
                View view2 = this.f2725f;
                w1 w1Var = recyclerView.f2460g0;
                f(view2, u1Var);
                u1Var.a(recyclerView);
                g();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f2725f = null;
            }
        }
        if (this.e) {
            w1 w1Var2 = recyclerView.f2460g0;
            if (this.f2722b.f2471m.v() == 0) {
                g();
            } else {
                int i11 = this.f2734o;
                int i12 = i11 - i3;
                if (i11 * i12 <= 0) {
                    i12 = 0;
                }
                this.f2734o = i12;
                int i13 = this.f2735p;
                int i14 = i13 - i10;
                if (i13 * i14 <= 0) {
                    i14 = 0;
                }
                this.f2735p = i14;
                if (i12 == 0 && i14 == 0) {
                    PointF d8 = d(this.f2721a);
                    if (d8 != null) {
                        if (d8.x != 0.0f || d8.y != 0.0f) {
                            float f10 = d8.y;
                            float sqrt = (float) Math.sqrt((f10 * f10) + (r10 * r10));
                            float f11 = d8.x / sqrt;
                            d8.x = f11;
                            float f12 = d8.y / sqrt;
                            d8.y = f12;
                            this.f2730k = d8;
                            this.f2734o = (int) (f11 * 10000.0f);
                            this.f2735p = (int) (f12 * 10000.0f);
                            int c9 = c(10000);
                            LinearInterpolator linearInterpolator = this.f2728i;
                            u1Var.f2746a = (int) (this.f2734o * 1.2f);
                            u1Var.f2747b = (int) (this.f2735p * 1.2f);
                            u1Var.f2748c = (int) (c9 * 1.2f);
                            u1Var.e = linearInterpolator;
                            u1Var.f2750f = true;
                        }
                    }
                    u1Var.f2749d = this.f2721a;
                    g();
                }
            }
            boolean z5 = u1Var.f2749d >= 0;
            u1Var.a(recyclerView);
            if (z5 && this.e) {
                this.f2724d = true;
                recyclerView.f2453d0.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(android.view.View r11, androidx.recyclerview.widget.u1 r12) {
        /*
            r10 = this;
            android.graphics.PointF r0 = r10.f2730k
            r1 = 1
            r2 = -1
            r3 = 0
            r4 = 0
            if (r0 == 0) goto L15
            float r0 = r0.x
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto Lf
            goto L15
        Lf:
            if (r0 <= 0) goto L13
            r0 = r1
            goto L16
        L13:
            r0 = r2
            goto L16
        L15:
            r0 = r4
        L16:
            androidx.recyclerview.widget.i1 r5 = r10.f2723c
            if (r5 == 0) goto L45
            boolean r6 = r5.d()
            if (r6 != 0) goto L21
            goto L45
        L21:
            android.view.ViewGroup$LayoutParams r6 = r11.getLayoutParams()
            androidx.recyclerview.widget.j1 r6 = (androidx.recyclerview.widget.j1) r6
            int r7 = androidx.recyclerview.widget.i1.A(r11)
            int r8 = r6.leftMargin
            int r7 = r7 - r8
            int r8 = androidx.recyclerview.widget.i1.C(r11)
            int r6 = r6.rightMargin
            int r8 = r8 + r6
            int r6 = r5.H()
            int r9 = r5.f2597n
            int r5 = r5.I()
            int r9 = r9 - r5
            int r0 = a(r7, r8, r6, r9, r0)
            goto L46
        L45:
            r0 = r4
        L46:
            android.graphics.PointF r5 = r10.f2730k
            if (r5 == 0) goto L55
            float r5 = r5.y
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 != 0) goto L51
            goto L55
        L51:
            if (r3 <= 0) goto L56
            r2 = r1
            goto L56
        L55:
            r2 = r4
        L56:
            androidx.recyclerview.widget.i1 r3 = r10.f2723c
            if (r3 == 0) goto L84
            boolean r5 = r3.e()
            if (r5 != 0) goto L61
            goto L84
        L61:
            android.view.ViewGroup$LayoutParams r4 = r11.getLayoutParams()
            androidx.recyclerview.widget.j1 r4 = (androidx.recyclerview.widget.j1) r4
            int r5 = androidx.recyclerview.widget.i1.D(r11)
            int r6 = r4.topMargin
            int r5 = r5 - r6
            int r11 = androidx.recyclerview.widget.i1.y(r11)
            int r4 = r4.bottomMargin
            int r11 = r11 + r4
            int r4 = r3.J()
            int r6 = r3.f2598o
            int r3 = r3.G()
            int r6 = r6 - r3
            int r4 = a(r5, r11, r4, r6, r2)
        L84:
            int r11 = r0 * r0
            int r2 = r4 * r4
            int r2 = r2 + r11
            double r2 = (double) r2
            double r2 = java.lang.Math.sqrt(r2)
            int r11 = (int) r2
            int r11 = r10.c(r11)
            double r2 = (double) r11
            r5 = 4599717252057688074(0x3fd57a786c22680a, double:0.3356)
            double r2 = r2 / r5
            double r2 = java.lang.Math.ceil(r2)
            int r11 = (int) r2
            if (r11 <= 0) goto Laf
            int r0 = -r0
            int r2 = -r4
            android.view.animation.DecelerateInterpolator r3 = r10.f2729j
            r12.f2746a = r0
            r12.f2747b = r2
            r12.f2748c = r11
            r12.e = r3
            r12.f2750f = r1
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.r0.f(android.view.View, androidx.recyclerview.widget.u1):void");
    }

    public final void g() {
        if (this.e) {
            this.e = false;
            this.f2735p = 0;
            this.f2734o = 0;
            this.f2730k = null;
            this.f2722b.f2460g0.f2784a = -1;
            this.f2725f = null;
            this.f2721a = -1;
            this.f2724d = false;
            i1 i1Var = this.f2723c;
            if (i1Var.e == this) {
                i1Var.e = null;
            }
            this.f2723c = null;
            this.f2722b = null;
        }
    }
}
