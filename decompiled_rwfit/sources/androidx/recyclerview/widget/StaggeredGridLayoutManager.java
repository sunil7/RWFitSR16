package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends i1 implements v1 {
    public final g2 B;
    public final int C;
    public boolean D;
    public boolean E;
    public SavedState F;
    public int G;
    public final Rect H;
    public final d2 I;
    public boolean J;
    public final boolean K;
    public int[] L;
    public final t M;

    /* renamed from: p, reason: collision with root package name */
    public final int f2486p;

    /* renamed from: q, reason: collision with root package name */
    public final i2[] f2487q;
    public final androidx.emoji2.text.g r;

    /* renamed from: s, reason: collision with root package name */
    public final androidx.emoji2.text.g f2488s;

    /* renamed from: t, reason: collision with root package name */
    public final int f2489t;

    /* renamed from: u, reason: collision with root package name */
    public int f2490u;

    /* renamed from: v, reason: collision with root package name */
    public final m0 f2491v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2492w;

    /* renamed from: y, reason: collision with root package name */
    public final BitSet f2494y;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2493x = false;

    /* renamed from: z, reason: collision with root package name */
    public int f2495z = -1;
    public int A = Integer.MIN_VALUE;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new h2();

        /* renamed from: a, reason: collision with root package name */
        public int f2500a;

        /* renamed from: b, reason: collision with root package name */
        public int f2501b;

        /* renamed from: c, reason: collision with root package name */
        public int f2502c;

        /* renamed from: d, reason: collision with root package name */
        public int[] f2503d;
        public int e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f2504f;

        /* renamed from: g, reason: collision with root package name */
        public ArrayList f2505g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f2506h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f2507i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f2508j;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f2500a);
            parcel.writeInt(this.f2501b);
            parcel.writeInt(this.f2502c);
            if (this.f2502c > 0) {
                parcel.writeIntArray(this.f2503d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f2504f);
            }
            parcel.writeInt(this.f2506h ? 1 : 0);
            parcel.writeInt(this.f2507i ? 1 : 0);
            parcel.writeInt(this.f2508j ? 1 : 0);
            parcel.writeList(this.f2505g);
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i10) {
        this.f2486p = -1;
        this.f2492w = false;
        g2 g2Var = new g2();
        this.B = g2Var;
        this.C = 2;
        this.H = new Rect();
        this.I = new d2(this);
        this.J = false;
        this.K = true;
        this.M = new t(this, 2);
        RecyclerView$LayoutManager$Properties L = i1.L(context, attributeSet, i3, i10);
        int i11 = L.orientation;
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i11 != this.f2489t) {
            this.f2489t = i11;
            androidx.emoji2.text.g gVar = this.r;
            this.r = this.f2488s;
            this.f2488s = gVar;
            q0();
        }
        int i12 = L.spanCount;
        c(null);
        if (i12 != this.f2486p) {
            g2Var.c();
            q0();
            this.f2486p = i12;
            this.f2494y = new BitSet(this.f2486p);
            this.f2487q = new i2[this.f2486p];
            for (int i13 = 0; i13 < this.f2486p; i13++) {
                this.f2487q[i13] = new i2(this, i13);
            }
            q0();
        }
        boolean z5 = L.reverseLayout;
        c(null);
        SavedState savedState = this.F;
        if (savedState != null && savedState.f2506h != z5) {
            savedState.f2506h = z5;
        }
        this.f2492w = z5;
        q0();
        m0 m0Var = new m0();
        m0Var.f2664a = true;
        m0Var.f2668f = 0;
        m0Var.f2669g = 0;
        this.f2491v = m0Var;
        this.r = androidx.emoji2.text.g.d(this, this.f2489t);
        this.f2488s = androidx.emoji2.text.g.d(this, 1 - this.f2489t);
    }

    public static int j1(int i3, int i10, int i11) {
        int mode;
        return (!(i10 == 0 && i11 == 0) && ((mode = View.MeasureSpec.getMode(i3)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i3) - i10) - i11), mode) : i3;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void C0(int i3, RecyclerView recyclerView) {
        r0 r0Var = new r0(recyclerView.getContext());
        r0Var.f2721a = i3;
        D0(r0Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean E0() {
        return this.F == null;
    }

    public final boolean F0() {
        int P0;
        int Q0;
        if (v() != 0 && this.C != 0 && this.f2590g) {
            if (this.f2493x) {
                P0 = Q0();
                Q0 = P0();
            } else {
                P0 = P0();
                Q0 = Q0();
            }
            g2 g2Var = this.B;
            if (P0 == 0 && U0() != null) {
                g2Var.c();
                this.f2589f = true;
                q0();
                return true;
            }
            if (this.J) {
                int i3 = this.f2493x ? -1 : 1;
                int i10 = Q0 + 1;
                StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem g10 = g2Var.g(P0, i10, i3);
                if (g10 == null) {
                    this.J = false;
                    g2Var.f(i10);
                    return false;
                }
                StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem g11 = g2Var.g(P0, g10.f2496a, i3 * (-1));
                if (g11 == null) {
                    g2Var.f(g10.f2496a);
                } else {
                    g2Var.f(g11.f2496a + 1);
                }
                this.f2589f = true;
                q0();
                return true;
            }
        }
        return false;
    }

    public final int G0(w1 w1Var) {
        if (v() == 0) {
            return 0;
        }
        androidx.emoji2.text.g gVar = this.r;
        boolean z5 = !this.K;
        return c.b(w1Var, gVar, L0(z5), K0(z5), this, this.K);
    }

    public final int H0(w1 w1Var) {
        if (v() == 0) {
            return 0;
        }
        androidx.emoji2.text.g gVar = this.r;
        boolean z5 = !this.K;
        return c.c(w1Var, gVar, L0(z5), K0(z5), this, this.K, this.f2493x);
    }

    public final int I0(w1 w1Var) {
        if (v() == 0) {
            return 0;
        }
        androidx.emoji2.text.g gVar = this.r;
        boolean z5 = !this.K;
        return c.d(w1Var, gVar, L0(z5), K0(z5), this, this.K);
    }

    public final int J0(q1 q1Var, m0 m0Var, w1 w1Var) {
        i2 i2Var;
        int i3;
        int i10;
        int S0;
        int f2;
        int i11;
        int n4;
        int f10;
        boolean z5;
        int i12;
        int i13;
        int i14;
        q1 q1Var2 = q1Var;
        int i15 = 0;
        int i16 = 1;
        this.f2494y.set(0, this.f2486p, true);
        m0 m0Var2 = this.f2491v;
        int i17 = m0Var2.f2671i ? m0Var.e == 1 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : Integer.MIN_VALUE : m0Var.e == 1 ? m0Var.f2669g + m0Var.f2665b : m0Var.f2668f - m0Var.f2665b;
        g1(m0Var.e, i17);
        int j4 = this.f2493x ? this.r.j() : this.r.n();
        boolean z6 = false;
        while (true) {
            int i18 = m0Var.f2666c;
            if (((i18 < 0 || i18 >= w1Var.b()) ? i15 : i16) == 0 || (!m0Var2.f2671i && this.f2494y.isEmpty())) {
                break;
            }
            View view = q1Var2.i(m0Var.f2666c, Format.OFFSET_SAMPLE_RELATIVE).itemView;
            m0Var.f2666c += m0Var.f2667d;
            e2 e2Var = (e2) view.getLayoutParams();
            int layoutPosition = e2Var.f2633a.getLayoutPosition();
            g2 g2Var = this.B;
            int[] iArr = (int[]) g2Var.f2570a;
            int i19 = (iArr == null || layoutPosition >= iArr.length) ? -1 : iArr[layoutPosition];
            int i20 = i19 == -1 ? i16 : i15;
            if (i20 != 0) {
                if (e2Var.f2556f) {
                    i2Var = this.f2487q[i15];
                } else {
                    if (Y0(m0Var.e)) {
                        i14 = this.f2486p - i16;
                        i13 = -1;
                        i12 = -1;
                    } else {
                        i12 = i16;
                        i13 = this.f2486p;
                        i14 = i15;
                    }
                    i2 i2Var2 = null;
                    if (m0Var.e == i16) {
                        int n8 = this.r.n();
                        int i21 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                        while (i14 != i13) {
                            i2 i2Var3 = this.f2487q[i14];
                            int i22 = i14;
                            int h4 = i2Var3.h(n8);
                            if (h4 < i21) {
                                i2Var2 = i2Var3;
                                i21 = h4;
                            }
                            i14 = i22 + i12;
                        }
                    } else {
                        int j10 = this.r.j();
                        int i23 = Integer.MIN_VALUE;
                        while (i14 != i13) {
                            i2 i2Var4 = this.f2487q[i14];
                            int i24 = i14;
                            int j11 = i2Var4.j(j10);
                            if (j11 > i23) {
                                i23 = j11;
                                i2Var2 = i2Var4;
                            }
                            i14 = i24 + i12;
                        }
                    }
                    i2Var = i2Var2;
                }
                g2Var.d(layoutPosition);
                ((int[]) g2Var.f2570a)[layoutPosition] = i2Var.e;
            } else {
                i2Var = this.f2487q[i19];
            }
            e2Var.e = i2Var;
            if (m0Var.e == 1) {
                b(-1, view, false);
            } else {
                b(0, view, false);
            }
            if (e2Var.f2556f) {
                if (this.f2489t == 1) {
                    i3 = i20;
                    W0(view, this.G, i1.w(this.f2598o, this.f2596m, G() + J(), ((ViewGroup.MarginLayoutParams) e2Var).height, true));
                } else {
                    i3 = i20;
                    W0(view, i1.w(this.f2597n, this.f2595l, I() + H(), ((ViewGroup.MarginLayoutParams) e2Var).width, true), this.G);
                }
                i10 = 1;
            } else {
                i3 = i20;
                if (this.f2489t == 1) {
                    i10 = 1;
                    W0(view, i1.w(this.f2490u, this.f2595l, 0, ((ViewGroup.MarginLayoutParams) e2Var).width, false), i1.w(this.f2598o, this.f2596m, G() + J(), ((ViewGroup.MarginLayoutParams) e2Var).height, true));
                } else {
                    i10 = 1;
                    W0(view, i1.w(this.f2597n, this.f2595l, I() + H(), ((ViewGroup.MarginLayoutParams) e2Var).width, true), i1.w(this.f2490u, this.f2596m, 0, ((ViewGroup.MarginLayoutParams) e2Var).height, false));
                }
            }
            if (m0Var.e == i10) {
                f2 = e2Var.f2556f ? R0(j4) : i2Var.h(j4);
                S0 = this.r.f(view) + f2;
                if (i3 != 0 && e2Var.f2556f) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2498c = new int[this.f2486p];
                    for (int i25 = 0; i25 < this.f2486p; i25++) {
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2498c[i25] = f2 - this.f2487q[i25].h(f2);
                    }
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2497b = -1;
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2496a = layoutPosition;
                    g2Var.a(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                }
            } else {
                S0 = e2Var.f2556f ? S0(j4) : i2Var.j(j4);
                f2 = S0 - this.r.f(view);
                if (i3 != 0 && e2Var.f2556f) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f2498c = new int[this.f2486p];
                    for (int i26 = 0; i26 < this.f2486p; i26++) {
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f2498c[i26] = this.f2487q[i26].j(S0) - S0;
                    }
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f2497b = 1;
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f2496a = layoutPosition;
                    g2Var.a(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2);
                }
            }
            if (!e2Var.f2556f || m0Var.f2667d != -1) {
                i11 = 1;
            } else if (i3 != 0) {
                i11 = 1;
                this.J = true;
            } else {
                if (m0Var.e != 1) {
                    int j12 = this.f2487q[0].j(Integer.MIN_VALUE);
                    int i27 = 1;
                    while (true) {
                        if (i27 >= this.f2486p) {
                            z5 = true;
                            break;
                        }
                        if (this.f2487q[i27].j(Integer.MIN_VALUE) != j12) {
                            z5 = false;
                            break;
                        }
                        i27++;
                    }
                } else {
                    int h10 = this.f2487q[0].h(Integer.MIN_VALUE);
                    int i28 = 1;
                    while (true) {
                        if (i28 >= this.f2486p) {
                            z5 = true;
                            break;
                        }
                        if (this.f2487q[i28].h(Integer.MIN_VALUE) != h10) {
                            z5 = false;
                            break;
                        }
                        i28++;
                    }
                }
                i11 = 1;
                if (!z5) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem h11 = g2Var.h(layoutPosition);
                    if (h11 != null) {
                        h11.f2499d = true;
                    }
                    this.J = true;
                }
            }
            if (m0Var.e == i11) {
                if (e2Var.f2556f) {
                    for (int i29 = this.f2486p - i11; i29 >= 0; i29--) {
                        this.f2487q[i29].a(view);
                    }
                } else {
                    e2Var.e.a(view);
                }
            } else if (e2Var.f2556f) {
                for (int i30 = this.f2486p - 1; i30 >= 0; i30--) {
                    this.f2487q[i30].m(view);
                }
            } else {
                e2Var.e.m(view);
            }
            if (V0() && this.f2489t == 1) {
                f10 = e2Var.f2556f ? this.f2488s.j() : this.f2488s.j() - (((this.f2486p - 1) - i2Var.e) * this.f2490u);
                n4 = f10 - this.f2488s.f(view);
            } else {
                n4 = e2Var.f2556f ? this.f2488s.n() : this.f2488s.n() + (i2Var.e * this.f2490u);
                f10 = this.f2488s.f(view) + n4;
            }
            if (this.f2489t == 1) {
                i1.Q(view, n4, f2, f10, S0);
            } else {
                i1.Q(view, f2, n4, S0, f10);
            }
            if (e2Var.f2556f) {
                g1(m0Var2.e, i17);
            } else {
                i1(i2Var, m0Var2.e, i17);
            }
            q1Var2 = q1Var;
            a1(q1Var2, m0Var2);
            if (m0Var2.f2670h && view.hasFocusable()) {
                if (e2Var.f2556f) {
                    this.f2494y.clear();
                } else {
                    this.f2494y.set(i2Var.e, false);
                }
            }
            i16 = 1;
            z6 = true;
            i15 = 0;
        }
        if (!z6) {
            a1(q1Var2, m0Var2);
        }
        int n10 = m0Var2.e == -1 ? this.r.n() - S0(this.r.n()) : R0(this.r.j()) - this.r.j();
        if (n10 > 0) {
            return Math.min(m0Var.f2665b, n10);
        }
        return 0;
    }

    public final View K0(boolean z5) {
        int n4 = this.r.n();
        int j4 = this.r.j();
        View view = null;
        for (int v6 = v() - 1; v6 >= 0; v6--) {
            View u10 = u(v6);
            int h4 = this.r.h(u10);
            int e = this.r.e(u10);
            if (e > n4 && h4 < j4) {
                if (e <= j4 || !z5) {
                    return u10;
                }
                if (view == null) {
                    view = u10;
                }
            }
        }
        return view;
    }

    public final View L0(boolean z5) {
        int n4 = this.r.n();
        int j4 = this.r.j();
        int v6 = v();
        View view = null;
        for (int i3 = 0; i3 < v6; i3++) {
            View u10 = u(i3);
            int h4 = this.r.h(u10);
            if (this.r.e(u10) > n4 && h4 < j4) {
                if (h4 >= n4 || !z5) {
                    return u10;
                }
                if (view == null) {
                    view = u10;
                }
            }
        }
        return view;
    }

    public final int[] M0(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f2486p];
        } else if (iArr.length < this.f2486p) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f2486p + ", array size:" + iArr.length);
        }
        for (int i3 = 0; i3 < this.f2486p; i3++) {
            i2 i2Var = this.f2487q[i3];
            iArr[i3] = i2Var.f2603f.f2492w ? i2Var.g(0, i2Var.f2599a.size(), true, true, false) : i2Var.g(r3.size() - 1, -1, true, true, false);
        }
        return iArr;
    }

    public final void N0(q1 q1Var, w1 w1Var, boolean z5) {
        int j4;
        int R0 = R0(Integer.MIN_VALUE);
        if (R0 != Integer.MIN_VALUE && (j4 = this.r.j() - R0) > 0) {
            int i3 = j4 - (-e1(-j4, q1Var, w1Var));
            if (!z5 || i3 <= 0) {
                return;
            }
            this.r.s(i3);
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean O() {
        return this.C != 0;
    }

    public final void O0(q1 q1Var, w1 w1Var, boolean z5) {
        int n4;
        int S0 = S0(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        if (S0 != Integer.MAX_VALUE && (n4 = S0 - this.r.n()) > 0) {
            int e12 = n4 - e1(n4, q1Var, w1Var);
            if (!z5 || e12 <= 0) {
                return;
            }
            this.r.s(-e12);
        }
    }

    public final int P0() {
        if (v() == 0) {
            return 0;
        }
        return i1.K(u(0));
    }

    public final int Q0() {
        int v6 = v();
        if (v6 == 0) {
            return 0;
        }
        return i1.K(u(v6 - 1));
    }

    @Override // androidx.recyclerview.widget.i1
    public final void R(int i3) {
        super.R(i3);
        for (int i10 = 0; i10 < this.f2486p; i10++) {
            i2 i2Var = this.f2487q[i10];
            int i11 = i2Var.f2600b;
            if (i11 != Integer.MIN_VALUE) {
                i2Var.f2600b = i11 + i3;
            }
            int i12 = i2Var.f2601c;
            if (i12 != Integer.MIN_VALUE) {
                i2Var.f2601c = i12 + i3;
            }
        }
    }

    public final int R0(int i3) {
        int h4 = this.f2487q[0].h(i3);
        for (int i10 = 1; i10 < this.f2486p; i10++) {
            int h10 = this.f2487q[i10].h(i3);
            if (h10 > h4) {
                h4 = h10;
            }
        }
        return h4;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void S(int i3) {
        super.S(i3);
        for (int i10 = 0; i10 < this.f2486p; i10++) {
            i2 i2Var = this.f2487q[i10];
            int i11 = i2Var.f2600b;
            if (i11 != Integer.MIN_VALUE) {
                i2Var.f2600b = i11 + i3;
            }
            int i12 = i2Var.f2601c;
            if (i12 != Integer.MIN_VALUE) {
                i2Var.f2601c = i12 + i3;
            }
        }
    }

    public final int S0(int i3) {
        int j4 = this.f2487q[0].j(i3);
        for (int i10 = 1; i10 < this.f2486p; i10++) {
            int j10 = this.f2487q[i10].j(i3);
            if (j10 < j4) {
                j4 = j10;
            }
        }
        return j4;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void T() {
        this.B.c();
        for (int i3 = 0; i3 < this.f2486p; i3++) {
            this.f2487q[i3].d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T0(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.f2493x
            if (r0 == 0) goto L9
            int r0 = r7.Q0()
            goto Ld
        L9:
            int r0 = r7.P0()
        Ld:
            r1 = 8
            if (r10 != r1) goto L1b
            if (r8 >= r9) goto L17
            int r2 = r9 + 1
        L15:
            r3 = r8
            goto L1e
        L17:
            int r2 = r8 + 1
            r3 = r9
            goto L1e
        L1b:
            int r2 = r8 + r9
            goto L15
        L1e:
            androidx.recyclerview.widget.g2 r4 = r7.B
            r4.i(r3)
            r5 = 1
            if (r10 == r5) goto L37
            r6 = 2
            if (r10 == r6) goto L33
            if (r10 == r1) goto L2c
            goto L3a
        L2c:
            r4.l(r8, r5)
            r4.k(r9, r5)
            goto L3a
        L33:
            r4.l(r8, r9)
            goto L3a
        L37:
            r4.k(r8, r9)
        L3a:
            if (r2 > r0) goto L3d
            goto L4f
        L3d:
            boolean r8 = r7.f2493x
            if (r8 == 0) goto L46
            int r8 = r7.P0()
            goto L4a
        L46:
            int r8 = r7.Q0()
        L4a:
            if (r3 > r8) goto L4f
            r7.q0()
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.T0(int, int, int):void");
    }

    @Override // androidx.recyclerview.widget.i1
    public final void U(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2586b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.M);
        }
        for (int i3 = 0; i3 < this.f2486p; i3++) {
            this.f2487q[i3].d();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bd, code lost:
    
        if (r10 == r11) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d3, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d1, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00cf, code lost:
    
        if (r10 == r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View U0() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.U0():android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0051, code lost:
    
        if (r9.f2489t == 1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0057, code lost:
    
        if (r9.f2489t == 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0063, code lost:
    
        if (V0() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x006f, code lost:
    
        if (V0() == false) goto L37;
     */
    @Override // androidx.recyclerview.widget.i1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View V(android.view.View r10, int r11, androidx.recyclerview.widget.q1 r12, androidx.recyclerview.widget.w1 r13) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.V(android.view.View, int, androidx.recyclerview.widget.q1, androidx.recyclerview.widget.w1):android.view.View");
    }

    public final boolean V0() {
        return F() == 1;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void W(AccessibilityEvent accessibilityEvent) {
        super.W(accessibilityEvent);
        if (v() > 0) {
            View L0 = L0(false);
            View K0 = K0(false);
            if (L0 == null || K0 == null) {
                return;
            }
            int K = i1.K(L0);
            int K2 = i1.K(K0);
            if (K < K2) {
                accessibilityEvent.setFromIndex(K);
                accessibilityEvent.setToIndex(K2);
            } else {
                accessibilityEvent.setFromIndex(K2);
                accessibilityEvent.setToIndex(K);
            }
        }
    }

    public final void W0(View view, int i3, int i10) {
        RecyclerView recyclerView = this.f2586b;
        Rect rect = this.H;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.M(view));
        }
        e2 e2Var = (e2) view.getLayoutParams();
        int j12 = j1(i3, ((ViewGroup.MarginLayoutParams) e2Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) e2Var).rightMargin + rect.right);
        int j13 = j1(i10, ((ViewGroup.MarginLayoutParams) e2Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) e2Var).bottomMargin + rect.bottom);
        if (z0(view, j12, j13, e2Var)) {
            view.measure(j12, j13);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01aa, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01a6, code lost:
    
        if ((r11 < P0()) != r16.f2493x) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x042a, code lost:
    
        if (F0() != false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0198, code lost:
    
        if (r16.f2493x != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a8, code lost:
    
        r11 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X0(androidx.recyclerview.widget.q1 r17, androidx.recyclerview.widget.w1 r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1096
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.X0(androidx.recyclerview.widget.q1, androidx.recyclerview.widget.w1, boolean):void");
    }

    public final boolean Y0(int i3) {
        if (this.f2489t == 0) {
            return (i3 == -1) != this.f2493x;
        }
        return ((i3 == -1) == this.f2493x) == V0();
    }

    public final void Z0(int i3, w1 w1Var) {
        int P0;
        int i10;
        if (i3 > 0) {
            P0 = Q0();
            i10 = 1;
        } else {
            P0 = P0();
            i10 = -1;
        }
        m0 m0Var = this.f2491v;
        m0Var.f2664a = true;
        h1(P0, w1Var);
        f1(i10);
        m0Var.f2666c = P0 + m0Var.f2667d;
        m0Var.f2665b = Math.abs(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0019, code lost:
    
        if ((r4 < P0()) != r3.f2493x) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r3.f2493x != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r1 = 1;
     */
    @Override // androidx.recyclerview.widget.v1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF a(int r4) {
        /*
            r3 = this;
            int r0 = r3.v()
            r1 = -1
            r2 = 1
            if (r0 != 0) goto Le
            boolean r4 = r3.f2493x
            if (r4 == 0) goto L1b
        Lc:
            r1 = r2
            goto L1b
        Le:
            int r0 = r3.P0()
            if (r4 >= r0) goto L16
            r4 = r2
            goto L17
        L16:
            r4 = 0
        L17:
            boolean r0 = r3.f2493x
            if (r4 == r0) goto Lc
        L1b:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>()
            if (r1 != 0) goto L24
            r4 = 0
            return r4
        L24:
            int r0 = r3.f2489t
            r2 = 0
            if (r0 != 0) goto L2f
            float r0 = (float) r1
            r4.x = r0
            r4.y = r2
            return r4
        L2f:
            r4.x = r2
            float r0 = (float) r1
            r4.y = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int):android.graphics.PointF");
    }

    @Override // androidx.recyclerview.widget.i1
    public final void a0(int i3, int i10) {
        T0(i3, i10, 1);
    }

    public final void a1(q1 q1Var, m0 m0Var) {
        if (!m0Var.f2664a || m0Var.f2671i) {
            return;
        }
        if (m0Var.f2665b == 0) {
            if (m0Var.e == -1) {
                b1(q1Var, m0Var.f2669g);
                return;
            } else {
                c1(q1Var, m0Var.f2668f);
                return;
            }
        }
        int i3 = 1;
        if (m0Var.e == -1) {
            int i10 = m0Var.f2668f;
            int j4 = this.f2487q[0].j(i10);
            while (i3 < this.f2486p) {
                int j10 = this.f2487q[i3].j(i10);
                if (j10 > j4) {
                    j4 = j10;
                }
                i3++;
            }
            int i11 = i10 - j4;
            b1(q1Var, i11 < 0 ? m0Var.f2669g : m0Var.f2669g - Math.min(i11, m0Var.f2665b));
            return;
        }
        int i12 = m0Var.f2669g;
        int h4 = this.f2487q[0].h(i12);
        while (i3 < this.f2486p) {
            int h10 = this.f2487q[i3].h(i12);
            if (h10 < h4) {
                h4 = h10;
            }
            i3++;
        }
        int i13 = h4 - m0Var.f2669g;
        c1(q1Var, i13 < 0 ? m0Var.f2668f : Math.min(i13, m0Var.f2665b) + m0Var.f2668f);
    }

    @Override // androidx.recyclerview.widget.i1
    public final void b0() {
        this.B.c();
        q0();
    }

    public final void b1(q1 q1Var, int i3) {
        for (int v6 = v() - 1; v6 >= 0; v6--) {
            View u10 = u(v6);
            if (this.r.h(u10) < i3 || this.r.q(u10) < i3) {
                return;
            }
            e2 e2Var = (e2) u10.getLayoutParams();
            if (e2Var.f2556f) {
                for (int i10 = 0; i10 < this.f2486p; i10++) {
                    if (this.f2487q[i10].f2599a.size() == 1) {
                        return;
                    }
                }
                for (int i11 = 0; i11 < this.f2486p; i11++) {
                    this.f2487q[i11].k();
                }
            } else if (e2Var.e.f2599a.size() == 1) {
                return;
            } else {
                e2Var.e.k();
            }
            n0(u10, q1Var);
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final void c(String str) {
        RecyclerView recyclerView;
        if (this.F != null || (recyclerView = this.f2586b) == null) {
            return;
        }
        recyclerView.h(str);
    }

    @Override // androidx.recyclerview.widget.i1
    public final void c0(int i3, int i10) {
        T0(i3, i10, 8);
    }

    public final void c1(q1 q1Var, int i3) {
        while (v() > 0) {
            View u10 = u(0);
            if (this.r.e(u10) > i3 || this.r.p(u10) > i3) {
                return;
            }
            e2 e2Var = (e2) u10.getLayoutParams();
            if (e2Var.f2556f) {
                for (int i10 = 0; i10 < this.f2486p; i10++) {
                    if (this.f2487q[i10].f2599a.size() == 1) {
                        return;
                    }
                }
                for (int i11 = 0; i11 < this.f2486p; i11++) {
                    this.f2487q[i11].l();
                }
            } else if (e2Var.e.f2599a.size() == 1) {
                return;
            } else {
                e2Var.e.l();
            }
            n0(u10, q1Var);
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean d() {
        return this.f2489t == 0;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void d0(int i3, int i10) {
        T0(i3, i10, 2);
    }

    public final void d1() {
        if (this.f2489t == 1 || !V0()) {
            this.f2493x = this.f2492w;
        } else {
            this.f2493x = !this.f2492w;
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean e() {
        return this.f2489t == 1;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void e0(int i3, int i10) {
        T0(i3, i10, 4);
    }

    public final int e1(int i3, q1 q1Var, w1 w1Var) {
        if (v() == 0 || i3 == 0) {
            return 0;
        }
        Z0(i3, w1Var);
        m0 m0Var = this.f2491v;
        int J0 = J0(q1Var, m0Var, w1Var);
        if (m0Var.f2665b >= J0) {
            i3 = i3 < 0 ? -J0 : J0;
        }
        this.r.s(-i3);
        this.D = this.f2493x;
        m0Var.f2665b = 0;
        a1(q1Var, m0Var);
        return i3;
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean f(j1 j1Var) {
        return j1Var instanceof e2;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void f0(q1 q1Var, w1 w1Var) {
        X0(q1Var, w1Var, true);
    }

    public final void f1(int i3) {
        m0 m0Var = this.f2491v;
        m0Var.e = i3;
        m0Var.f2667d = this.f2493x != (i3 == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void g0(w1 w1Var) {
        this.f2495z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.I.a();
    }

    public final void g1(int i3, int i10) {
        for (int i11 = 0; i11 < this.f2486p; i11++) {
            if (!this.f2487q[i11].f2599a.isEmpty()) {
                i1(this.f2487q[i11], i3, i10);
            }
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final void h(int i3, int i10, w1 w1Var, x xVar) {
        m0 m0Var;
        int h4;
        int i11;
        if (this.f2489t != 0) {
            i3 = i10;
        }
        if (v() == 0 || i3 == 0) {
            return;
        }
        Z0(i3, w1Var);
        int[] iArr = this.L;
        if (iArr == null || iArr.length < this.f2486p) {
            this.L = new int[this.f2486p];
        }
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = this.f2486p;
            m0Var = this.f2491v;
            if (i12 >= i14) {
                break;
            }
            if (m0Var.f2667d == -1) {
                h4 = m0Var.f2668f;
                i11 = this.f2487q[i12].j(h4);
            } else {
                h4 = this.f2487q[i12].h(m0Var.f2669g);
                i11 = m0Var.f2669g;
            }
            int i15 = h4 - i11;
            if (i15 >= 0) {
                this.L[i13] = i15;
                i13++;
            }
            i12++;
        }
        Arrays.sort(this.L, 0, i13);
        for (int i16 = 0; i16 < i13; i16++) {
            int i17 = m0Var.f2666c;
            if (i17 < 0 || i17 >= w1Var.b()) {
                return;
            }
            xVar.b(m0Var.f2666c, this.L[i16]);
            m0Var.f2666c += m0Var.f2667d;
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final void h0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.F = savedState;
            if (this.f2495z != -1) {
                savedState.f2503d = null;
                savedState.f2502c = 0;
                savedState.f2500a = -1;
                savedState.f2501b = -1;
                savedState.f2503d = null;
                savedState.f2502c = 0;
                savedState.e = 0;
                savedState.f2504f = null;
                savedState.f2505g = null;
            }
            q0();
        }
    }

    public final void h1(int i3, w1 w1Var) {
        int i10;
        int i11;
        int i12;
        m0 m0Var = this.f2491v;
        boolean z5 = false;
        m0Var.f2665b = 0;
        m0Var.f2666c = i3;
        r0 r0Var = this.e;
        if (!(r0Var != null && r0Var.e) || (i12 = w1Var.f2784a) == -1) {
            i10 = 0;
            i11 = 0;
        } else {
            if (this.f2493x == (i12 < i3)) {
                i10 = this.r.o();
                i11 = 0;
            } else {
                i11 = this.r.o();
                i10 = 0;
            }
        }
        RecyclerView recyclerView = this.f2586b;
        if (recyclerView == null || !recyclerView.f2459g) {
            m0Var.f2669g = this.r.i() + i10;
            m0Var.f2668f = -i11;
        } else {
            m0Var.f2668f = this.r.n() - i11;
            m0Var.f2669g = this.r.j() + i10;
        }
        m0Var.f2670h = false;
        m0Var.f2664a = true;
        if (this.r.l() == 0 && this.r.i() == 0) {
            z5 = true;
        }
        m0Var.f2671i = z5;
    }

    @Override // androidx.recyclerview.widget.i1
    public final Parcelable i0() {
        int j4;
        int n4;
        int[] iArr;
        SavedState savedState = this.F;
        if (savedState != null) {
            SavedState savedState2 = new SavedState();
            savedState2.f2502c = savedState.f2502c;
            savedState2.f2500a = savedState.f2500a;
            savedState2.f2501b = savedState.f2501b;
            savedState2.f2503d = savedState.f2503d;
            savedState2.e = savedState.e;
            savedState2.f2504f = savedState.f2504f;
            savedState2.f2506h = savedState.f2506h;
            savedState2.f2507i = savedState.f2507i;
            savedState2.f2508j = savedState.f2508j;
            savedState2.f2505g = savedState.f2505g;
            return savedState2;
        }
        SavedState savedState3 = new SavedState();
        savedState3.f2506h = this.f2492w;
        savedState3.f2507i = this.D;
        savedState3.f2508j = this.E;
        g2 g2Var = this.B;
        if (g2Var == null || (iArr = (int[]) g2Var.f2570a) == null) {
            savedState3.e = 0;
        } else {
            savedState3.f2504f = iArr;
            savedState3.e = iArr.length;
            savedState3.f2505g = (ArrayList) g2Var.f2571b;
        }
        if (v() <= 0) {
            savedState3.f2500a = -1;
            savedState3.f2501b = -1;
            savedState3.f2502c = 0;
            return savedState3;
        }
        savedState3.f2500a = this.D ? Q0() : P0();
        View K0 = this.f2493x ? K0(true) : L0(true);
        savedState3.f2501b = K0 != null ? i1.K(K0) : -1;
        int i3 = this.f2486p;
        savedState3.f2502c = i3;
        savedState3.f2503d = new int[i3];
        for (int i10 = 0; i10 < this.f2486p; i10++) {
            if (this.D) {
                j4 = this.f2487q[i10].h(Integer.MIN_VALUE);
                if (j4 != Integer.MIN_VALUE) {
                    n4 = this.r.j();
                    j4 -= n4;
                    savedState3.f2503d[i10] = j4;
                } else {
                    savedState3.f2503d[i10] = j4;
                }
            } else {
                j4 = this.f2487q[i10].j(Integer.MIN_VALUE);
                if (j4 != Integer.MIN_VALUE) {
                    n4 = this.r.n();
                    j4 -= n4;
                    savedState3.f2503d[i10] = j4;
                } else {
                    savedState3.f2503d[i10] = j4;
                }
            }
        }
        return savedState3;
    }

    public final void i1(i2 i2Var, int i3, int i10) {
        int i11 = i2Var.f2602d;
        int i12 = i2Var.e;
        if (i3 == -1) {
            int i13 = i2Var.f2600b;
            if (i13 == Integer.MIN_VALUE) {
                i2Var.c();
                i13 = i2Var.f2600b;
            }
            if (i13 + i11 <= i10) {
                this.f2494y.set(i12, false);
                return;
            }
            return;
        }
        int i14 = i2Var.f2601c;
        if (i14 == Integer.MIN_VALUE) {
            i2Var.b();
            i14 = i2Var.f2601c;
        }
        if (i14 - i11 >= i10) {
            this.f2494y.set(i12, false);
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final int j(w1 w1Var) {
        return G0(w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final void j0(int i3) {
        if (i3 == 0) {
            F0();
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final int k(w1 w1Var) {
        return H0(w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final int l(w1 w1Var) {
        return I0(w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final int m(w1 w1Var) {
        return G0(w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final int n(w1 w1Var) {
        return H0(w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final int o(w1 w1Var) {
        return I0(w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final j1 r() {
        return this.f2489t == 0 ? new e2(-2, -1) : new e2(-1, -2);
    }

    @Override // androidx.recyclerview.widget.i1
    public final int r0(int i3, q1 q1Var, w1 w1Var) {
        return e1(i3, q1Var, w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final j1 s(Context context, AttributeSet attributeSet) {
        return new e2(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.i1
    public final void s0(int i3) {
        SavedState savedState = this.F;
        if (savedState != null && savedState.f2500a != i3) {
            savedState.f2503d = null;
            savedState.f2502c = 0;
            savedState.f2500a = -1;
            savedState.f2501b = -1;
        }
        this.f2495z = i3;
        this.A = Integer.MIN_VALUE;
        q0();
    }

    @Override // androidx.recyclerview.widget.i1
    public final j1 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e2((ViewGroup.MarginLayoutParams) layoutParams) : new e2(layoutParams);
    }

    @Override // androidx.recyclerview.widget.i1
    public final int t0(int i3, q1 q1Var, w1 w1Var) {
        return e1(i3, q1Var, w1Var);
    }

    @Override // androidx.recyclerview.widget.i1
    public final void w0(Rect rect, int i3, int i10) {
        int g10;
        int g11;
        int i11 = this.f2486p;
        int I = I() + H();
        int G = G() + J();
        if (this.f2489t == 1) {
            int height = rect.height() + G;
            RecyclerView recyclerView = this.f2586b;
            WeakHashMap weakHashMap = l1.z0.f15748a;
            g11 = i1.g(i10, height, l1.h0.d(recyclerView));
            g10 = i1.g(i3, (this.f2490u * i11) + I, l1.h0.e(this.f2586b));
        } else {
            int width = rect.width() + I;
            RecyclerView recyclerView2 = this.f2586b;
            WeakHashMap weakHashMap2 = l1.z0.f15748a;
            g10 = i1.g(i3, width, l1.h0.e(recyclerView2));
            g11 = i1.g(i10, (this.f2490u * i11) + G, l1.h0.d(this.f2586b));
        }
        this.f2586b.setMeasuredDimension(g10, g11);
    }
}
