package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i2 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2599a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f2600b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f2601c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f2602d = 0;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f2603f;

    public i2(StaggeredGridLayoutManager staggeredGridLayoutManager, int i3) {
        this.f2603f = staggeredGridLayoutManager;
        this.e = i3;
    }

    public final void a(View view) {
        e2 e2Var = (e2) view.getLayoutParams();
        e2Var.e = this;
        ArrayList arrayList = this.f2599a;
        arrayList.add(view);
        this.f2601c = Integer.MIN_VALUE;
        if (arrayList.size() == 1) {
            this.f2600b = Integer.MIN_VALUE;
        }
        if (e2Var.f2633a.isRemoved() || e2Var.f2633a.isUpdated()) {
            this.f2602d = this.f2603f.r.f(view) + this.f2602d;
        }
    }

    public final void b() {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem h4;
        View view = (View) com.google.android.gms.internal.mlkit_vision_barcode.l0.h(1, this.f2599a);
        e2 e2Var = (e2) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f2603f;
        this.f2601c = staggeredGridLayoutManager.r.e(view);
        if (e2Var.f2556f && (h4 = staggeredGridLayoutManager.B.h(e2Var.f2633a.getLayoutPosition())) != null && h4.f2497b == 1) {
            int i3 = this.f2601c;
            int[] iArr = h4.f2498c;
            this.f2601c = i3 + (iArr == null ? 0 : iArr[this.e]);
        }
    }

    public final void c() {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem h4;
        View view = (View) this.f2599a.get(0);
        e2 e2Var = (e2) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f2603f;
        this.f2600b = staggeredGridLayoutManager.r.h(view);
        if (e2Var.f2556f && (h4 = staggeredGridLayoutManager.B.h(e2Var.f2633a.getLayoutPosition())) != null && h4.f2497b == -1) {
            int i3 = this.f2600b;
            int[] iArr = h4.f2498c;
            this.f2600b = i3 - (iArr != null ? iArr[this.e] : 0);
        }
    }

    public final void d() {
        this.f2599a.clear();
        this.f2600b = Integer.MIN_VALUE;
        this.f2601c = Integer.MIN_VALUE;
        this.f2602d = 0;
    }

    public final int e() {
        return this.f2603f.f2492w ? g(r1.size() - 1, -1, false, false, true) : g(0, this.f2599a.size(), false, false, true);
    }

    public final int f() {
        return this.f2603f.f2492w ? g(0, this.f2599a.size(), false, false, true) : g(r1.size() - 1, -1, false, false, true);
    }

    public final int g(int i3, int i10, boolean z5, boolean z6, boolean z8) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f2603f;
        int n4 = staggeredGridLayoutManager.r.n();
        int j4 = staggeredGridLayoutManager.r.j();
        int i11 = i10 > i3 ? 1 : -1;
        while (i3 != i10) {
            View view = (View) this.f2599a.get(i3);
            int h4 = staggeredGridLayoutManager.r.h(view);
            int e = staggeredGridLayoutManager.r.e(view);
            boolean z10 = false;
            boolean z11 = !z8 ? h4 >= j4 : h4 > j4;
            if (!z8 ? e > n4 : e >= n4) {
                z10 = true;
            }
            if (z11 && z10) {
                if (z5 && z6) {
                    if (h4 >= n4 && e <= j4) {
                        return i1.K(view);
                    }
                } else {
                    if (z6) {
                        return i1.K(view);
                    }
                    if (h4 < n4 || e > j4) {
                        return i1.K(view);
                    }
                }
            }
            i3 += i11;
        }
        return -1;
    }

    public final int h(int i3) {
        int i10 = this.f2601c;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (this.f2599a.size() == 0) {
            return i3;
        }
        b();
        return this.f2601c;
    }

    public final View i(int i3, int i10) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f2603f;
        ArrayList arrayList = this.f2599a;
        View view = null;
        if (i10 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f2492w && i1.K(view2) >= i3) || ((!staggeredGridLayoutManager.f2492w && i1.K(view2) <= i3) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size();
        int i11 = 0;
        while (i11 < size2) {
            View view3 = (View) arrayList.get(i11);
            if ((staggeredGridLayoutManager.f2492w && i1.K(view3) <= i3) || ((!staggeredGridLayoutManager.f2492w && i1.K(view3) >= i3) || !view3.hasFocusable())) {
                break;
            }
            i11++;
            view = view3;
        }
        return view;
    }

    public final int j(int i3) {
        int i10 = this.f2600b;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (this.f2599a.size() == 0) {
            return i3;
        }
        c();
        return this.f2600b;
    }

    public final void k() {
        ArrayList arrayList = this.f2599a;
        int size = arrayList.size();
        View view = (View) arrayList.remove(size - 1);
        e2 e2Var = (e2) view.getLayoutParams();
        e2Var.e = null;
        if (e2Var.f2633a.isRemoved() || e2Var.f2633a.isUpdated()) {
            this.f2602d -= this.f2603f.r.f(view);
        }
        if (size == 1) {
            this.f2600b = Integer.MIN_VALUE;
        }
        this.f2601c = Integer.MIN_VALUE;
    }

    public final void l() {
        ArrayList arrayList = this.f2599a;
        View view = (View) arrayList.remove(0);
        e2 e2Var = (e2) view.getLayoutParams();
        e2Var.e = null;
        if (arrayList.size() == 0) {
            this.f2601c = Integer.MIN_VALUE;
        }
        if (e2Var.f2633a.isRemoved() || e2Var.f2633a.isUpdated()) {
            this.f2602d -= this.f2603f.r.f(view);
        }
        this.f2600b = Integer.MIN_VALUE;
    }

    public final void m(View view) {
        e2 e2Var = (e2) view.getLayoutParams();
        e2Var.e = this;
        ArrayList arrayList = this.f2599a;
        arrayList.add(0, view);
        this.f2600b = Integer.MIN_VALUE;
        if (arrayList.size() == 1) {
            this.f2601c = Integer.MIN_VALUE;
        }
        if (e2Var.f2633a.isRemoved() || e2Var.f2633a.isUpdated()) {
            this.f2602d = this.f2603f.r.f(view) + this.f2602d;
        }
    }
}
