package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends i1 implements i0, v1 {
    public final n0 A;
    public final o0 B;
    public final int C;
    public final int[] D;

    /* renamed from: p, reason: collision with root package name */
    public int f2427p;

    /* renamed from: q, reason: collision with root package name */
    public p0 f2428q;
    public androidx.emoji2.text.g r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2429s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f2430t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2431u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2432v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f2433w;

    /* renamed from: x, reason: collision with root package name */
    public int f2434x;

    /* renamed from: y, reason: collision with root package name */
    public int f2435y;

    /* renamed from: z, reason: collision with root package name */
    public SavedState f2436z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new q0();

        /* renamed from: a, reason: collision with root package name */
        public int f2437a;

        /* renamed from: b, reason: collision with root package name */
        public int f2438b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2439c;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f2437a);
            parcel.writeInt(this.f2438b);
            parcel.writeInt(this.f2439c ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i3) {
        this.f2427p = 1;
        this.f2430t = false;
        this.f2431u = false;
        this.f2432v = false;
        this.f2433w = true;
        this.f2434x = -1;
        this.f2435y = Integer.MIN_VALUE;
        this.f2436z = null;
        this.A = new n0(0);
        this.B = new o0();
        this.C = 2;
        this.D = new int[2];
        g1(i3);
        c(null);
        if (this.f2430t) {
            this.f2430t = false;
            q0();
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean A0() {
        if (this.f2596m != 1073741824 && this.f2595l != 1073741824) {
            int v6 = v();
            for (int i3 = 0; i3 < v6; i3++) {
                ViewGroup.LayoutParams layoutParams = u(i3).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.i1
    public void C0(int i3, RecyclerView recyclerView) {
        r0 r0Var = new r0(recyclerView.getContext());
        r0Var.f2721a = i3;
        D0(r0Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public boolean E0() {
        return this.f2436z == null && this.f2429s == this.f2432v;
    }

    public void F0(w1 w1Var, int[] iArr) {
        int i3;
        int o3 = w1Var.f2784a != -1 ? this.r.o() : 0;
        if (this.f2428q.f2698f == -1) {
            i3 = 0;
        } else {
            i3 = o3;
            o3 = 0;
        }
        iArr[0] = o3;
        iArr[1] = i3;
    }

    public void G0(w1 w1Var, p0 p0Var, x xVar) {
        int i3 = p0Var.f2697d;
        if (i3 < 0 || i3 >= w1Var.b()) {
            return;
        }
        xVar.b(i3, Math.max(0, p0Var.f2699g));
    }

    public final int H0(w1 w1Var) {
        if (v() == 0) {
            return 0;
        }
        L0();
        androidx.emoji2.text.g gVar = this.r;
        boolean z5 = !this.f2433w;
        return c.b(w1Var, gVar, O0(z5), N0(z5), this, this.f2433w);
    }

    public final int I0(w1 w1Var) {
        if (v() == 0) {
            return 0;
        }
        L0();
        androidx.emoji2.text.g gVar = this.r;
        boolean z5 = !this.f2433w;
        return c.c(w1Var, gVar, O0(z5), N0(z5), this, this.f2433w, this.f2431u);
    }

    public final int J0(w1 w1Var) {
        if (v() == 0) {
            return 0;
        }
        L0();
        androidx.emoji2.text.g gVar = this.r;
        boolean z5 = !this.f2433w;
        return c.d(w1Var, gVar, O0(z5), N0(z5), this, this.f2433w);
    }

    public final int K0(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 17 ? i3 != 33 ? i3 != 66 ? (i3 == 130 && this.f2427p == 1) ? 1 : Integer.MIN_VALUE : this.f2427p == 0 ? 1 : Integer.MIN_VALUE : this.f2427p == 1 ? -1 : Integer.MIN_VALUE : this.f2427p == 0 ? -1 : Integer.MIN_VALUE : (this.f2427p != 1 && Y0()) ? -1 : 1 : (this.f2427p != 1 && Y0()) ? 1 : -1;
    }

    public final void L0() {
        if (this.f2428q == null) {
            p0 p0Var = new p0();
            p0Var.f2694a = true;
            p0Var.f2700h = 0;
            p0Var.f2701i = 0;
            p0Var.f2703k = null;
            this.f2428q = p0Var;
        }
    }

    public final int M0(q1 q1Var, p0 p0Var, w1 w1Var, boolean z5) {
        int i3;
        int i10 = p0Var.f2696c;
        int i11 = p0Var.f2699g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                p0Var.f2699g = i11 + i10;
            }
            b1(q1Var, p0Var);
        }
        int i12 = p0Var.f2696c + p0Var.f2700h;
        while (true) {
            if ((!p0Var.f2704l && i12 <= 0) || (i3 = p0Var.f2697d) < 0 || i3 >= w1Var.b()) {
                break;
            }
            o0 o0Var = this.B;
            o0Var.f2686a = 0;
            o0Var.f2687b = false;
            o0Var.f2688c = false;
            o0Var.f2689d = false;
            Z0(q1Var, w1Var, p0Var, o0Var);
            if (!o0Var.f2687b) {
                int i13 = p0Var.f2695b;
                int i14 = o0Var.f2686a;
                p0Var.f2695b = (p0Var.f2698f * i14) + i13;
                if (!o0Var.f2688c || p0Var.f2703k != null || !w1Var.f2789g) {
                    p0Var.f2696c -= i14;
                    i12 -= i14;
                }
                int i15 = p0Var.f2699g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + i14;
                    p0Var.f2699g = i16;
                    int i17 = p0Var.f2696c;
                    if (i17 < 0) {
                        p0Var.f2699g = i16 + i17;
                    }
                    b1(q1Var, p0Var);
                }
                if (z5 && o0Var.f2689d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - p0Var.f2696c;
    }

    public final View N0(boolean z5) {
        return this.f2431u ? S0(0, v(), z5, true) : S0(v() - 1, -1, z5, true);
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean O() {
        return true;
    }

    public final View O0(boolean z5) {
        return this.f2431u ? S0(v() - 1, -1, z5, true) : S0(0, v(), z5, true);
    }

    public final int P0() {
        View S0 = S0(0, v(), false, true);
        if (S0 == null) {
            return -1;
        }
        return i1.K(S0);
    }

    public final int Q0() {
        View S0 = S0(v() - 1, -1, false, true);
        if (S0 == null) {
            return -1;
        }
        return i1.K(S0);
    }

    public final View R0(int i3, int i10) {
        int i11;
        int i12;
        L0();
        if (i10 <= i3 && i10 >= i3) {
            return u(i3);
        }
        if (this.r.h(u(i3)) < this.r.n()) {
            i11 = 16644;
            i12 = 16388;
        } else {
            i11 = 4161;
            i12 = 4097;
        }
        return this.f2427p == 0 ? this.f2587c.e(i3, i10, i11, i12) : this.f2588d.e(i3, i10, i11, i12);
    }

    public final View S0(int i3, int i10, boolean z5, boolean z6) {
        L0();
        int i11 = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;
        int i12 = z5 ? 24579 : 320;
        if (!z6) {
            i11 = 0;
        }
        return this.f2427p == 0 ? this.f2587c.e(i3, i10, i12, i11) : this.f2588d.e(i3, i10, i12, i11);
    }

    public View T0(q1 q1Var, w1 w1Var, boolean z5, boolean z6) {
        int i3;
        int i10;
        int i11;
        L0();
        int v6 = v();
        if (z6) {
            i10 = v() - 1;
            i3 = -1;
            i11 = -1;
        } else {
            i3 = v6;
            i10 = 0;
            i11 = 1;
        }
        int b3 = w1Var.b();
        int n4 = this.r.n();
        int j4 = this.r.j();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i10 != i3) {
            View u10 = u(i10);
            int K = i1.K(u10);
            int h4 = this.r.h(u10);
            int e = this.r.e(u10);
            if (K >= 0 && K < b3) {
                if (!((j1) u10.getLayoutParams()).f2633a.isRemoved()) {
                    boolean z8 = e <= n4 && h4 < n4;
                    boolean z10 = h4 >= j4 && e > j4;
                    if (!z8 && !z10) {
                        return u10;
                    }
                    if (z5) {
                        if (!z10) {
                            if (view != null) {
                            }
                            view = u10;
                        }
                        view2 = u10;
                    } else {
                        if (!z8) {
                            if (view != null) {
                            }
                            view = u10;
                        }
                        view2 = u10;
                    }
                } else if (view3 == null) {
                    view3 = u10;
                }
            }
            i10 += i11;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void U(RecyclerView recyclerView) {
    }

    public final int U0(int i3, q1 q1Var, w1 w1Var, boolean z5) {
        int j4;
        int j10 = this.r.j() - i3;
        if (j10 <= 0) {
            return 0;
        }
        int i10 = -e1(-j10, q1Var, w1Var);
        int i11 = i3 + i10;
        if (!z5 || (j4 = this.r.j() - i11) <= 0) {
            return i10;
        }
        this.r.s(j4);
        return j4 + i10;
    }

    @Override // androidx.recyclerview.widget.i1
    public View V(View view, int i3, q1 q1Var, w1 w1Var) {
        int K0;
        d1();
        if (v() != 0 && (K0 = K0(i3)) != Integer.MIN_VALUE) {
            L0();
            i1(K0, (int) (this.r.o() * 0.33333334f), false, w1Var);
            p0 p0Var = this.f2428q;
            p0Var.f2699g = Integer.MIN_VALUE;
            p0Var.f2694a = false;
            M0(q1Var, p0Var, w1Var, true);
            View R0 = K0 == -1 ? this.f2431u ? R0(v() - 1, -1) : R0(0, v()) : this.f2431u ? R0(0, v()) : R0(v() - 1, -1);
            View X0 = K0 == -1 ? X0() : W0();
            if (!X0.hasFocusable()) {
                return R0;
            }
            if (R0 != null) {
                return X0;
            }
        }
        return null;
    }

    public final int V0(int i3, q1 q1Var, w1 w1Var, boolean z5) {
        int n4;
        int n8 = i3 - this.r.n();
        if (n8 <= 0) {
            return 0;
        }
        int i10 = -e1(n8, q1Var, w1Var);
        int i11 = i3 + i10;
        if (!z5 || (n4 = i11 - this.r.n()) <= 0) {
            return i10;
        }
        this.r.s(-n4);
        return i10 - n4;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void W(AccessibilityEvent accessibilityEvent) {
        super.W(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(P0());
            accessibilityEvent.setToIndex(Q0());
        }
    }

    public final View W0() {
        return u(this.f2431u ? 0 : v() - 1);
    }

    public final View X0() {
        return u(this.f2431u ? v() - 1 : 0);
    }

    public final boolean Y0() {
        return F() == 1;
    }

    public void Z0(q1 q1Var, w1 w1Var, p0 p0Var, o0 o0Var) {
        int i3;
        int i10;
        int i11;
        int i12;
        View b3 = p0Var.b(q1Var);
        if (b3 == null) {
            o0Var.f2687b = true;
            return;
        }
        j1 j1Var = (j1) b3.getLayoutParams();
        if (p0Var.f2703k == null) {
            if (this.f2431u == (p0Var.f2698f == -1)) {
                b(-1, b3, false);
            } else {
                b(0, b3, false);
            }
        } else {
            if (this.f2431u == (p0Var.f2698f == -1)) {
                b(-1, b3, true);
            } else {
                b(0, b3, true);
            }
        }
        j1 j1Var2 = (j1) b3.getLayoutParams();
        Rect M = this.f2586b.M(b3);
        int i13 = M.left + M.right;
        int i14 = M.top + M.bottom;
        int w8 = i1.w(this.f2597n, this.f2595l, I() + H() + ((ViewGroup.MarginLayoutParams) j1Var2).leftMargin + ((ViewGroup.MarginLayoutParams) j1Var2).rightMargin + i13, ((ViewGroup.MarginLayoutParams) j1Var2).width, d());
        int w9 = i1.w(this.f2598o, this.f2596m, G() + J() + ((ViewGroup.MarginLayoutParams) j1Var2).topMargin + ((ViewGroup.MarginLayoutParams) j1Var2).bottomMargin + i14, ((ViewGroup.MarginLayoutParams) j1Var2).height, e());
        if (z0(b3, w8, w9, j1Var2)) {
            b3.measure(w8, w9);
        }
        o0Var.f2686a = this.r.f(b3);
        if (this.f2427p == 1) {
            if (Y0()) {
                i12 = this.f2597n - I();
                i3 = i12 - this.r.g(b3);
            } else {
                i3 = H();
                i12 = this.r.g(b3) + i3;
            }
            if (p0Var.f2698f == -1) {
                i10 = p0Var.f2695b;
                i11 = i10 - o0Var.f2686a;
            } else {
                i11 = p0Var.f2695b;
                i10 = o0Var.f2686a + i11;
            }
        } else {
            int J = J();
            int g10 = this.r.g(b3) + J;
            if (p0Var.f2698f == -1) {
                int i15 = p0Var.f2695b;
                int i16 = i15 - o0Var.f2686a;
                i12 = i15;
                i10 = g10;
                i3 = i16;
                i11 = J;
            } else {
                int i17 = p0Var.f2695b;
                int i18 = o0Var.f2686a + i17;
                i3 = i17;
                i10 = g10;
                i11 = J;
                i12 = i18;
            }
        }
        i1.Q(b3, i3, i11, i12, i10);
        if (j1Var.f2633a.isRemoved() || j1Var.f2633a.isUpdated()) {
            o0Var.f2688c = true;
        }
        o0Var.f2689d = b3.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.v1
    public final PointF a(int i3) {
        if (v() == 0) {
            return null;
        }
        int i10 = (i3 < i1.K(u(0))) != this.f2431u ? -1 : 1;
        return this.f2427p == 0 ? new PointF(i10, 0.0f) : new PointF(0.0f, i10);
    }

    public void a1(q1 q1Var, w1 w1Var, n0 n0Var, int i3) {
    }

    public final void b1(q1 q1Var, p0 p0Var) {
        if (!p0Var.f2694a || p0Var.f2704l) {
            return;
        }
        int i3 = p0Var.f2699g;
        int i10 = p0Var.f2701i;
        if (p0Var.f2698f == -1) {
            int v6 = v();
            if (i3 < 0) {
                return;
            }
            int i11 = (this.r.i() - i3) + i10;
            if (this.f2431u) {
                for (int i12 = 0; i12 < v6; i12++) {
                    View u10 = u(i12);
                    if (this.r.h(u10) < i11 || this.r.q(u10) < i11) {
                        c1(q1Var, 0, i12);
                        return;
                    }
                }
                return;
            }
            int i13 = v6 - 1;
            for (int i14 = i13; i14 >= 0; i14--) {
                View u11 = u(i14);
                if (this.r.h(u11) < i11 || this.r.q(u11) < i11) {
                    c1(q1Var, i13, i14);
                    return;
                }
            }
            return;
        }
        if (i3 < 0) {
            return;
        }
        int i15 = i3 - i10;
        int v9 = v();
        if (!this.f2431u) {
            for (int i16 = 0; i16 < v9; i16++) {
                View u12 = u(i16);
                if (this.r.e(u12) > i15 || this.r.p(u12) > i15) {
                    c1(q1Var, 0, i16);
                    return;
                }
            }
            return;
        }
        int i17 = v9 - 1;
        for (int i18 = i17; i18 >= 0; i18--) {
            View u13 = u(i18);
            if (this.r.e(u13) > i15 || this.r.p(u13) > i15) {
                c1(q1Var, i17, i18);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final void c(String str) {
        RecyclerView recyclerView;
        if (this.f2436z != null || (recyclerView = this.f2586b) == null) {
            return;
        }
        recyclerView.h(str);
    }

    public final void c1(q1 q1Var, int i3, int i10) {
        if (i3 == i10) {
            return;
        }
        if (i10 <= i3) {
            while (i3 > i10) {
                View u10 = u(i3);
                o0(i3);
                q1Var.f(u10);
                i3--;
            }
            return;
        }
        for (int i11 = i10 - 1; i11 >= i3; i11--) {
            View u11 = u(i11);
            o0(i11);
            q1Var.f(u11);
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean d() {
        return this.f2427p == 0;
    }

    public final void d1() {
        if (this.f2427p == 1 || !Y0()) {
            this.f2431u = this.f2430t;
        } else {
            this.f2431u = !this.f2430t;
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean e() {
        return this.f2427p == 1;
    }

    public final int e1(int i3, q1 q1Var, w1 w1Var) {
        if (v() != 0 && i3 != 0) {
            L0();
            this.f2428q.f2694a = true;
            int i10 = i3 > 0 ? 1 : -1;
            int abs = Math.abs(i3);
            i1(i10, abs, true, w1Var);
            p0 p0Var = this.f2428q;
            int M0 = M0(q1Var, p0Var, w1Var, false) + p0Var.f2699g;
            if (M0 >= 0) {
                if (abs > M0) {
                    i3 = i10 * M0;
                }
                this.r.s(-i3);
                this.f2428q.f2702j = i3;
                return i3;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.i1
    public void f0(q1 q1Var, w1 w1Var) {
        View view;
        View view2;
        View T0;
        int i3;
        int h4;
        int i10;
        int i11;
        List list;
        int i12;
        int i13;
        int U0;
        int i14;
        View q5;
        int h10;
        int i15;
        int i16;
        int i17 = -1;
        if (!(this.f2436z == null && this.f2434x == -1) && w1Var.b() == 0) {
            l0(q1Var);
            return;
        }
        SavedState savedState = this.f2436z;
        if (savedState != null && (i16 = savedState.f2437a) >= 0) {
            this.f2434x = i16;
        }
        L0();
        this.f2428q.f2694a = false;
        d1();
        RecyclerView recyclerView = this.f2586b;
        if (recyclerView == null || (view = recyclerView.getFocusedChild()) == null || ((ArrayList) this.f2585a.f12379d).contains(view)) {
            view = null;
        }
        n0 n0Var = this.A;
        if (!n0Var.f2678d || this.f2434x != -1 || this.f2436z != null) {
            n0Var.d();
            n0Var.f2677c = this.f2431u ^ this.f2432v;
            if (!w1Var.f2789g && (i3 = this.f2434x) != -1) {
                if (i3 < 0 || i3 >= w1Var.b()) {
                    this.f2434x = -1;
                    this.f2435y = Integer.MIN_VALUE;
                } else {
                    int i18 = this.f2434x;
                    n0Var.f2676b = i18;
                    SavedState savedState2 = this.f2436z;
                    if (savedState2 != null && savedState2.f2437a >= 0) {
                        boolean z5 = savedState2.f2439c;
                        n0Var.f2677c = z5;
                        if (z5) {
                            n0Var.e = this.r.j() - this.f2436z.f2438b;
                        } else {
                            n0Var.e = this.r.n() + this.f2436z.f2438b;
                        }
                    } else if (this.f2435y == Integer.MIN_VALUE) {
                        View q8 = q(i18);
                        if (q8 == null) {
                            if (v() > 0) {
                                n0Var.f2677c = (this.f2434x < i1.K(u(0))) == this.f2431u;
                            }
                            n0Var.a();
                        } else if (this.r.f(q8) > this.r.o()) {
                            n0Var.a();
                        } else if (this.r.h(q8) - this.r.n() < 0) {
                            n0Var.e = this.r.n();
                            n0Var.f2677c = false;
                        } else if (this.r.j() - this.r.e(q8) < 0) {
                            n0Var.e = this.r.j();
                            n0Var.f2677c = true;
                        } else {
                            if (n0Var.f2677c) {
                                int e = this.r.e(q8);
                                androidx.emoji2.text.g gVar = this.r;
                                h4 = (Integer.MIN_VALUE == gVar.f2029a ? 0 : gVar.o() - gVar.f2029a) + e;
                            } else {
                                h4 = this.r.h(q8);
                            }
                            n0Var.e = h4;
                        }
                    } else {
                        boolean z6 = this.f2431u;
                        n0Var.f2677c = z6;
                        if (z6) {
                            n0Var.e = this.r.j() - this.f2435y;
                        } else {
                            n0Var.e = this.r.n() + this.f2435y;
                        }
                    }
                    n0Var.f2678d = true;
                }
            }
            if (v() != 0) {
                RecyclerView recyclerView2 = this.f2586b;
                if (recyclerView2 == null || (view2 = recyclerView2.getFocusedChild()) == null || ((ArrayList) this.f2585a.f12379d).contains(view2)) {
                    view2 = null;
                }
                if (view2 != null) {
                    j1 j1Var = (j1) view2.getLayoutParams();
                    if (!j1Var.f2633a.isRemoved() && j1Var.f2633a.getLayoutPosition() >= 0 && j1Var.f2633a.getLayoutPosition() < w1Var.b()) {
                        n0Var.c(i1.K(view2), view2);
                        n0Var.f2678d = true;
                    }
                }
                boolean z8 = this.f2429s;
                boolean z10 = this.f2432v;
                if (z8 == z10 && (T0 = T0(q1Var, w1Var, n0Var.f2677c, z10)) != null) {
                    n0Var.b(i1.K(T0), T0);
                    if (!w1Var.f2789g && E0()) {
                        int h11 = this.r.h(T0);
                        int e10 = this.r.e(T0);
                        int n4 = this.r.n();
                        int j4 = this.r.j();
                        boolean z11 = e10 <= n4 && h11 < n4;
                        boolean z12 = h11 >= j4 && e10 > j4;
                        if (z11 || z12) {
                            if (n0Var.f2677c) {
                                n4 = j4;
                            }
                            n0Var.e = n4;
                        }
                    }
                    n0Var.f2678d = true;
                }
            }
            n0Var.a();
            n0Var.f2676b = this.f2432v ? w1Var.b() - 1 : 0;
            n0Var.f2678d = true;
        } else if (view != null && (this.r.h(view) >= this.r.j() || this.r.e(view) <= this.r.n())) {
            n0Var.c(i1.K(view), view);
        }
        p0 p0Var = this.f2428q;
        p0Var.f2698f = p0Var.f2702j >= 0 ? 1 : -1;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        F0(w1Var, iArr);
        int n8 = this.r.n() + Math.max(0, iArr[0]);
        int k10 = this.r.k() + Math.max(0, iArr[1]);
        if (w1Var.f2789g && (i14 = this.f2434x) != -1 && this.f2435y != Integer.MIN_VALUE && (q5 = q(i14)) != null) {
            if (this.f2431u) {
                i15 = this.r.j() - this.r.e(q5);
                h10 = this.f2435y;
            } else {
                h10 = this.r.h(q5) - this.r.n();
                i15 = this.f2435y;
            }
            int i19 = i15 - h10;
            if (i19 > 0) {
                n8 += i19;
            } else {
                k10 -= i19;
            }
        }
        if (!n0Var.f2677c ? !this.f2431u : this.f2431u) {
            i17 = 1;
        }
        a1(q1Var, w1Var, n0Var, i17);
        p(q1Var);
        this.f2428q.f2704l = this.r.l() == 0 && this.r.i() == 0;
        this.f2428q.getClass();
        this.f2428q.f2701i = 0;
        if (n0Var.f2677c) {
            k1(n0Var.f2676b, n0Var.e);
            p0 p0Var2 = this.f2428q;
            p0Var2.f2700h = n8;
            M0(q1Var, p0Var2, w1Var, false);
            p0 p0Var3 = this.f2428q;
            i11 = p0Var3.f2695b;
            int i20 = p0Var3.f2697d;
            int i21 = p0Var3.f2696c;
            if (i21 > 0) {
                k10 += i21;
            }
            j1(n0Var.f2676b, n0Var.e);
            p0 p0Var4 = this.f2428q;
            p0Var4.f2700h = k10;
            p0Var4.f2697d += p0Var4.e;
            M0(q1Var, p0Var4, w1Var, false);
            p0 p0Var5 = this.f2428q;
            i10 = p0Var5.f2695b;
            int i22 = p0Var5.f2696c;
            if (i22 > 0) {
                k1(i20, i11);
                p0 p0Var6 = this.f2428q;
                p0Var6.f2700h = i22;
                M0(q1Var, p0Var6, w1Var, false);
                i11 = this.f2428q.f2695b;
            }
        } else {
            j1(n0Var.f2676b, n0Var.e);
            p0 p0Var7 = this.f2428q;
            p0Var7.f2700h = k10;
            M0(q1Var, p0Var7, w1Var, false);
            p0 p0Var8 = this.f2428q;
            i10 = p0Var8.f2695b;
            int i23 = p0Var8.f2697d;
            int i24 = p0Var8.f2696c;
            if (i24 > 0) {
                n8 += i24;
            }
            k1(n0Var.f2676b, n0Var.e);
            p0 p0Var9 = this.f2428q;
            p0Var9.f2700h = n8;
            p0Var9.f2697d += p0Var9.e;
            M0(q1Var, p0Var9, w1Var, false);
            p0 p0Var10 = this.f2428q;
            int i25 = p0Var10.f2695b;
            int i26 = p0Var10.f2696c;
            if (i26 > 0) {
                j1(i23, i10);
                p0 p0Var11 = this.f2428q;
                p0Var11.f2700h = i26;
                M0(q1Var, p0Var11, w1Var, false);
                i10 = this.f2428q.f2695b;
            }
            i11 = i25;
        }
        if (v() > 0) {
            if (this.f2431u ^ this.f2432v) {
                int U02 = U0(i10, q1Var, w1Var, true);
                i12 = i11 + U02;
                i13 = i10 + U02;
                U0 = V0(i12, q1Var, w1Var, false);
            } else {
                int V0 = V0(i11, q1Var, w1Var, true);
                i12 = i11 + V0;
                i13 = i10 + V0;
                U0 = U0(i13, q1Var, w1Var, false);
            }
            i11 = i12 + U0;
            i10 = i13 + U0;
        }
        if (w1Var.f2793k && v() != 0 && !w1Var.f2789g && E0()) {
            List list2 = q1Var.f2713d;
            int size = list2.size();
            int K = i1.K(u(0));
            int i27 = 0;
            int i28 = 0;
            for (int i29 = 0; i29 < size; i29++) {
                z1 z1Var = (z1) list2.get(i29);
                if (!z1Var.isRemoved()) {
                    if ((z1Var.getLayoutPosition() < K) != this.f2431u) {
                        i27 += this.r.f(z1Var.itemView);
                    } else {
                        i28 += this.r.f(z1Var.itemView);
                    }
                }
            }
            this.f2428q.f2703k = list2;
            if (i27 > 0) {
                k1(i1.K(X0()), i11);
                p0 p0Var12 = this.f2428q;
                p0Var12.f2700h = i27;
                p0Var12.f2696c = 0;
                p0Var12.a(null);
                M0(q1Var, this.f2428q, w1Var, false);
            }
            if (i28 > 0) {
                j1(i1.K(W0()), i10);
                p0 p0Var13 = this.f2428q;
                p0Var13.f2700h = i28;
                p0Var13.f2696c = 0;
                list = null;
                p0Var13.a(null);
                M0(q1Var, this.f2428q, w1Var, false);
            } else {
                list = null;
            }
            this.f2428q.f2703k = list;
        }
        if (w1Var.f2789g) {
            n0Var.d();
        } else {
            androidx.emoji2.text.g gVar2 = this.r;
            gVar2.f2029a = gVar2.o();
        }
        this.f2429s = this.f2432v;
    }

    public final void f1(int i3, int i10) {
        this.f2434x = i3;
        this.f2435y = i10;
        SavedState savedState = this.f2436z;
        if (savedState != null) {
            savedState.f2437a = -1;
        }
        q0();
    }

    @Override // androidx.recyclerview.widget.i1
    public void g0(w1 w1Var) {
        this.f2436z = null;
        this.f2434x = -1;
        this.f2435y = Integer.MIN_VALUE;
        this.A.d();
    }

    public final void g1(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "invalid orientation:"));
        }
        c(null);
        if (i3 != this.f2427p || this.r == null) {
            androidx.emoji2.text.g d5 = androidx.emoji2.text.g.d(this, i3);
            this.r = d5;
            this.A.f2679f = d5;
            this.f2427p = i3;
            q0();
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final void h(int i3, int i10, w1 w1Var, x xVar) {
        if (this.f2427p != 0) {
            i3 = i10;
        }
        if (v() == 0 || i3 == 0) {
            return;
        }
        L0();
        i1(i3 > 0 ? 1 : -1, Math.abs(i3), true, w1Var);
        G0(w1Var, this.f2428q, xVar);
    }

    @Override // androidx.recyclerview.widget.i1
    public final void h0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f2436z = savedState;
            if (this.f2434x != -1) {
                savedState.f2437a = -1;
            }
            q0();
        }
    }

    public void h1(boolean z5) {
        c(null);
        if (this.f2432v == z5) {
            return;
        }
        this.f2432v = z5;
        q0();
    }

    @Override // androidx.recyclerview.widget.i1
    public final void i(int i3, x xVar) {
        boolean z5;
        int i10;
        SavedState savedState = this.f2436z;
        if (savedState == null || (i10 = savedState.f2437a) < 0) {
            d1();
            z5 = this.f2431u;
            i10 = this.f2434x;
            if (i10 == -1) {
                i10 = z5 ? i3 - 1 : 0;
            }
        } else {
            z5 = savedState.f2439c;
        }
        int i11 = z5 ? -1 : 1;
        for (int i12 = 0; i12 < this.C && i10 >= 0 && i10 < i3; i12++) {
            xVar.b(i10, 0);
            i10 += i11;
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final Parcelable i0() {
        SavedState savedState = this.f2436z;
        if (savedState != null) {
            SavedState savedState2 = new SavedState();
            savedState2.f2437a = savedState.f2437a;
            savedState2.f2438b = savedState.f2438b;
            savedState2.f2439c = savedState.f2439c;
            return savedState2;
        }
        SavedState savedState3 = new SavedState();
        if (v() <= 0) {
            savedState3.f2437a = -1;
            return savedState3;
        }
        L0();
        boolean z5 = this.f2429s ^ this.f2431u;
        savedState3.f2439c = z5;
        if (z5) {
            View W0 = W0();
            savedState3.f2438b = this.r.j() - this.r.e(W0);
            savedState3.f2437a = i1.K(W0);
            return savedState3;
        }
        View X0 = X0();
        savedState3.f2437a = i1.K(X0);
        savedState3.f2438b = this.r.h(X0) - this.r.n();
        return savedState3;
    }

    public final void i1(int i3, int i10, boolean z5, w1 w1Var) {
        int n4;
        this.f2428q.f2704l = this.r.l() == 0 && this.r.i() == 0;
        this.f2428q.f2698f = i3;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        F0(w1Var, iArr);
        int max = Math.max(0, iArr[0]);
        int max2 = Math.max(0, iArr[1]);
        boolean z6 = i3 == 1;
        p0 p0Var = this.f2428q;
        int i11 = z6 ? max2 : max;
        p0Var.f2700h = i11;
        if (!z6) {
            max = max2;
        }
        p0Var.f2701i = max;
        if (z6) {
            p0Var.f2700h = this.r.k() + i11;
            View W0 = W0();
            p0 p0Var2 = this.f2428q;
            p0Var2.e = this.f2431u ? -1 : 1;
            int K = i1.K(W0);
            p0 p0Var3 = this.f2428q;
            p0Var2.f2697d = K + p0Var3.e;
            p0Var3.f2695b = this.r.e(W0);
            n4 = this.r.e(W0) - this.r.j();
        } else {
            View X0 = X0();
            p0 p0Var4 = this.f2428q;
            p0Var4.f2700h = this.r.n() + p0Var4.f2700h;
            p0 p0Var5 = this.f2428q;
            p0Var5.e = this.f2431u ? 1 : -1;
            int K2 = i1.K(X0);
            p0 p0Var6 = this.f2428q;
            p0Var5.f2697d = K2 + p0Var6.e;
            p0Var6.f2695b = this.r.h(X0);
            n4 = (-this.r.h(X0)) + this.r.n();
        }
        p0 p0Var7 = this.f2428q;
        p0Var7.f2696c = i10;
        if (z5) {
            p0Var7.f2696c = i10 - n4;
        }
        p0Var7.f2699g = n4;
    }

    @Override // androidx.recyclerview.widget.i1
    public final int j(w1 w1Var) {
        return H0(w1Var);
    }

    public final void j1(int i3, int i10) {
        this.f2428q.f2696c = this.r.j() - i10;
        p0 p0Var = this.f2428q;
        p0Var.e = this.f2431u ? -1 : 1;
        p0Var.f2697d = i3;
        p0Var.f2698f = 1;
        p0Var.f2695b = i10;
        p0Var.f2699g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.i1
    public int k(w1 w1Var) {
        return I0(w1Var);
    }

    public final void k1(int i3, int i10) {
        this.f2428q.f2696c = i10 - this.r.n();
        p0 p0Var = this.f2428q;
        p0Var.f2697d = i3;
        p0Var.e = this.f2431u ? 1 : -1;
        p0Var.f2698f = -1;
        p0Var.f2695b = i10;
        p0Var.f2699g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.i1
    public int l(w1 w1Var) {
        return J0(w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final int m(w1 w1Var) {
        return H0(w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public int n(w1 w1Var) {
        return I0(w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public int o(w1 w1Var) {
        return J0(w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final View q(int i3) {
        int v6 = v();
        if (v6 == 0) {
            return null;
        }
        int K = i3 - i1.K(u(0));
        if (K >= 0 && K < v6) {
            View u10 = u(K);
            if (i1.K(u10) == i3) {
                return u10;
            }
        }
        return super.q(i3);
    }

    @Override // androidx.recyclerview.widget.i1
    public j1 r() {
        return new j1(-2, -2);
    }

    @Override // androidx.recyclerview.widget.i1
    public int r0(int i3, q1 q1Var, w1 w1Var) {
        if (this.f2427p == 1) {
            return 0;
        }
        return e1(i3, q1Var, w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final void s0(int i3) {
        this.f2434x = i3;
        this.f2435y = Integer.MIN_VALUE;
        SavedState savedState = this.f2436z;
        if (savedState != null) {
            savedState.f2437a = -1;
        }
        q0();
    }

    @Override // androidx.recyclerview.widget.i1
    public int t0(int i3, q1 q1Var, w1 w1Var) {
        if (this.f2427p == 0) {
            return 0;
        }
        return e1(i3, q1Var, w1Var);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i10) {
        this.f2427p = 1;
        this.f2430t = false;
        this.f2431u = false;
        this.f2432v = false;
        this.f2433w = true;
        this.f2434x = -1;
        this.f2435y = Integer.MIN_VALUE;
        this.f2436z = null;
        this.A = new n0(0);
        this.B = new o0();
        this.C = 2;
        this.D = new int[2];
        RecyclerView$LayoutManager$Properties L = i1.L(context, attributeSet, i3, i10);
        g1(L.orientation);
        boolean z5 = L.reverseLayout;
        c(null);
        if (z5 != this.f2430t) {
            this.f2430t = z5;
            q0();
        }
        h1(L.stackFromEnd);
    }
}
