package androidx.recyclerview.widget;

import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class y1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f2807a;

    /* renamed from: b, reason: collision with root package name */
    public int f2808b;

    /* renamed from: c, reason: collision with root package name */
    public OverScroller f2809c;

    /* renamed from: d, reason: collision with root package name */
    public Interpolator f2810d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2811f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2812g;

    public y1(RecyclerView recyclerView) {
        this.f2812g = recyclerView;
        f0 f0Var = RecyclerView.f2442k1;
        this.f2810d = f0Var;
        this.e = false;
        this.f2811f = false;
        this.f2809c = new OverScroller(recyclerView.getContext(), f0Var);
    }

    public final void a() {
        if (this.e) {
            this.f2811f = true;
            return;
        }
        RecyclerView recyclerView = this.f2812g;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.h0.m(recyclerView, this);
    }

    public final void b(int i3, int i10, int i11, BaseInterpolator baseInterpolator) {
        RecyclerView recyclerView = this.f2812g;
        if (i11 == Integer.MIN_VALUE) {
            int abs = Math.abs(i3);
            int abs2 = Math.abs(i10);
            boolean z5 = abs > abs2;
            int width = z5 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z5) {
                abs = abs2;
            }
            i11 = Math.min((int) (((abs / width) + 1.0f) * 300.0f), 2000);
        }
        int i12 = i11;
        Interpolator interpolator = baseInterpolator;
        if (baseInterpolator == null) {
            interpolator = RecyclerView.f2442k1;
        }
        if (this.f2810d != interpolator) {
            this.f2810d = interpolator;
            this.f2809c = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f2808b = 0;
        this.f2807a = 0;
        recyclerView.setScrollState(2);
        this.f2809c.startScroll(0, 0, i3, i10, i12);
        a();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3;
        int i10;
        int i11;
        int i12;
        boolean awakenScrollBars;
        RecyclerView recyclerView = this.f2812g;
        if (recyclerView.f2471m == null) {
            recyclerView.removeCallbacks(this);
            this.f2809c.abortAnimation();
            return;
        }
        this.f2811f = false;
        this.e = true;
        recyclerView.l();
        OverScroller overScroller = this.f2809c;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i13 = currX - this.f2807a;
            int i14 = currY - this.f2808b;
            this.f2807a = currX;
            this.f2808b = currY;
            int[] iArr = recyclerView.f2448b1;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean r = recyclerView.r(i13, i14, iArr, null, 1);
            int[] iArr2 = recyclerView.f2448b1;
            if (r) {
                i3 = i13 - iArr2[0];
                i10 = i14 - iArr2[1];
            } else {
                i3 = i13;
                i10 = i14;
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.k(i3, i10);
            }
            if (recyclerView.f2470l != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                recyclerView.f0(iArr2, i3, i10);
                i11 = iArr2[0];
                i12 = iArr2[1];
                i3 -= i11;
                i10 -= i12;
                r0 r0Var = recyclerView.f2471m.e;
                if (r0Var != null && !r0Var.f2724d && r0Var.e) {
                    int b3 = recyclerView.f2460g0.b();
                    if (b3 == 0) {
                        r0Var.g();
                    } else if (r0Var.f2721a >= b3) {
                        r0Var.f2721a = b3 - 1;
                        r0Var.e(i11, i12);
                    } else {
                        r0Var.e(i11, i12);
                    }
                }
            } else {
                i11 = 0;
                i12 = 0;
            }
            if (!recyclerView.f2473o.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.f2448b1;
            iArr3[0] = 0;
            iArr3[1] = 0;
            recyclerView.s(i11, i12, i3, i10, null, 1, iArr3);
            int i15 = i3 - iArr2[0];
            int i16 = i10 - iArr2[1];
            if (i11 != 0 || i12 != 0) {
                recyclerView.t(i11, i12);
            }
            awakenScrollBars = recyclerView.awakenScrollBars();
            if (!awakenScrollBars) {
                recyclerView.invalidate();
            }
            boolean z5 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i15 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i16 != 0));
            r0 r0Var2 = recyclerView.f2471m.e;
            if ((r0Var2 == null || !r0Var2.f2724d) && z5) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i17 = i15 < 0 ? -currVelocity : i15 > 0 ? currVelocity : 0;
                    if (i16 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i16 <= 0) {
                        currVelocity = 0;
                    }
                    if (i17 < 0) {
                        recyclerView.v();
                        if (recyclerView.H.isFinished()) {
                            recyclerView.H.onAbsorb(-i17);
                        }
                    } else if (i17 > 0) {
                        recyclerView.w();
                        if (recyclerView.J.isFinished()) {
                            recyclerView.J.onAbsorb(i17);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.x();
                        if (recyclerView.I.isFinished()) {
                            recyclerView.I.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.u();
                        if (recyclerView.K.isFinished()) {
                            recyclerView.K.onAbsorb(currVelocity);
                        }
                    }
                    if (i17 != 0 || currVelocity != 0) {
                        WeakHashMap weakHashMap = l1.z0.f15748a;
                        l1.h0.k(recyclerView);
                    }
                }
                x xVar = recyclerView.f2458f0;
                int[] iArr4 = (int[]) xVar.e;
                if (iArr4 != null) {
                    Arrays.fill(iArr4, -1);
                }
                xVar.f2800d = 0;
            } else {
                a();
                z zVar = recyclerView.f2455e0;
                if (zVar != null) {
                    zVar.a(recyclerView, i11, i12);
                }
            }
        }
        r0 r0Var3 = recyclerView.f2471m.e;
        if (r0Var3 != null && r0Var3.f2724d) {
            r0Var3.e(0, 0);
        }
        this.e = false;
        if (!this.f2811f) {
            recyclerView.setScrollState(0);
            recyclerView.l0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap2 = l1.z0.f15748a;
            l1.h0.m(recyclerView, this);
        }
    }
}
