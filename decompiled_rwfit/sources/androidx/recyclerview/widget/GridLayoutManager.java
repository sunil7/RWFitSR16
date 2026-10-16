package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public c0 K;
    public final Rect L;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i10) {
        super(context, attributeSet, i3, i10);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new a0(0);
        this.L = new Rect();
        s1(i1.L(context, attributeSet, i3, i10).spanCount);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final boolean E0() {
        return this.f2436z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void G0(w1 w1Var, p0 p0Var, x xVar) {
        int i3;
        int i10 = this.F;
        for (int i11 = 0; i11 < this.F && (i3 = p0Var.f2697d) >= 0 && i3 < w1Var.b() && i10 > 0; i11++) {
            int i12 = p0Var.f2697d;
            xVar.b(i12, Math.max(0, p0Var.f2699g));
            i10 -= this.K.getSpanSize(i12);
            p0Var.f2697d += p0Var.e;
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final int M(q1 q1Var, w1 w1Var) {
        if (this.f2427p == 0) {
            return this.F;
        }
        if (w1Var.b() < 1) {
            return 0;
        }
        return o1(w1Var.b() - 1, q1Var, w1Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View T0(q1 q1Var, w1 w1Var, boolean z5, boolean z6) {
        int i3;
        int i10;
        int v6 = v();
        int i11 = 1;
        if (z6) {
            i10 = v() - 1;
            i3 = -1;
            i11 = -1;
        } else {
            i3 = v6;
            i10 = 0;
        }
        int b3 = w1Var.b();
        L0();
        int n4 = this.r.n();
        int j4 = this.r.j();
        View view = null;
        View view2 = null;
        while (i10 != i3) {
            View u10 = u(i10);
            int K = i1.K(u10);
            if (K >= 0 && K < b3 && p1(K, q1Var, w1Var) == 0) {
                if (((j1) u10.getLayoutParams()).f2633a.isRemoved()) {
                    if (view2 == null) {
                        view2 = u10;
                    }
                } else {
                    if (this.r.h(u10) < j4 && this.r.e(u10) >= n4) {
                        return u10;
                    }
                    if (view == null) {
                        view = u10;
                    }
                }
            }
            i10 += i11;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e2, code lost:
    
        if (r13 == (r2 > r15)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0107, code lost:
    
        if (r13 == (r2 > r8)) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0021, code lost:
    
        if (((java.util.ArrayList) r22.f2585a.f12379d).contains(r3) != false) goto L10;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View V(android.view.View r23, int r24, androidx.recyclerview.widget.q1 r25, androidx.recyclerview.widget.w1 r26) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.V(android.view.View, int, androidx.recyclerview.widget.q1, androidx.recyclerview.widget.w1):android.view.View");
    }

    @Override // androidx.recyclerview.widget.i1
    public final void Z(q1 q1Var, w1 w1Var, View view, m1.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b0)) {
            Y(view, dVar);
            return;
        }
        b0 b0Var = (b0) layoutParams;
        int o12 = o1(b0Var.f2633a.getLayoutPosition(), q1Var, w1Var);
        if (this.f2427p == 0) {
            dVar.g(com.example.test.ui.device.activity.i0.o(b0Var.e, b0Var.f2517f, o12, 1, false));
        } else {
            dVar.g(com.example.test.ui.device.activity.i0.o(o12, 1, b0Var.e, b0Var.f2517f, false));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
    
        r22.f2687b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v37 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z0(androidx.recyclerview.widget.q1 r19, androidx.recyclerview.widget.w1 r20, androidx.recyclerview.widget.p0 r21, androidx.recyclerview.widget.o0 r22) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.Z0(androidx.recyclerview.widget.q1, androidx.recyclerview.widget.w1, androidx.recyclerview.widget.p0, androidx.recyclerview.widget.o0):void");
    }

    @Override // androidx.recyclerview.widget.i1
    public final void a0(int i3, int i10) {
        this.K.invalidateSpanIndexCache();
        this.K.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void a1(q1 q1Var, w1 w1Var, n0 n0Var, int i3) {
        t1();
        if (w1Var.b() > 0 && !w1Var.f2789g) {
            boolean z5 = i3 == 1;
            int p12 = p1(n0Var.f2676b, q1Var, w1Var);
            if (z5) {
                while (p12 > 0) {
                    int i10 = n0Var.f2676b;
                    if (i10 <= 0) {
                        break;
                    }
                    int i11 = i10 - 1;
                    n0Var.f2676b = i11;
                    p12 = p1(i11, q1Var, w1Var);
                }
            } else {
                int b3 = w1Var.b() - 1;
                int i12 = n0Var.f2676b;
                while (i12 < b3) {
                    int i13 = i12 + 1;
                    int p13 = p1(i13, q1Var, w1Var);
                    if (p13 <= p12) {
                        break;
                    }
                    i12 = i13;
                    p12 = p13;
                }
                n0Var.f2676b = i12;
            }
        }
        m1();
    }

    @Override // androidx.recyclerview.widget.i1
    public final void b0() {
        this.K.invalidateSpanIndexCache();
        this.K.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.i1
    public final void c0(int i3, int i10) {
        this.K.invalidateSpanIndexCache();
        this.K.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.i1
    public final void d0(int i3, int i10) {
        this.K.invalidateSpanIndexCache();
        this.K.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.i1
    public final void e0(int i3, int i10) {
        this.K.invalidateSpanIndexCache();
        this.K.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean f(j1 j1Var) {
        return j1Var instanceof b0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final void f0(q1 q1Var, w1 w1Var) {
        boolean z5 = w1Var.f2789g;
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z5) {
            int v6 = v();
            for (int i3 = 0; i3 < v6; i3++) {
                b0 b0Var = (b0) u(i3).getLayoutParams();
                int layoutPosition = b0Var.f2633a.getLayoutPosition();
                sparseIntArray2.put(layoutPosition, b0Var.f2517f);
                sparseIntArray.put(layoutPosition, b0Var.e);
            }
        }
        super.f0(q1Var, w1Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final void g0(w1 w1Var) {
        super.g0(w1Var);
        this.E = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void h1(boolean z5) {
        if (z5) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.h1(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final int k(w1 w1Var) {
        return I0(w1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final int l(w1 w1Var) {
        return J0(w1Var);
    }

    public final void l1(int i3) {
        int i10;
        int[] iArr = this.G;
        int i11 = this.F;
        if (iArr == null || iArr.length != i11 + 1 || iArr[iArr.length - 1] != i3) {
            iArr = new int[i11 + 1];
        }
        int i12 = 0;
        iArr[0] = 0;
        int i13 = i3 / i11;
        int i14 = i3 % i11;
        int i15 = 0;
        for (int i16 = 1; i16 <= i11; i16++) {
            i12 += i14;
            if (i12 <= 0 || i11 - i12 >= i14) {
                i10 = i13;
            } else {
                i10 = i13 + 1;
                i12 -= i11;
            }
            i15 += i10;
            iArr[i16] = i15;
        }
        this.G = iArr;
    }

    public final void m1() {
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final int n(w1 w1Var) {
        return I0(w1Var);
    }

    public final int n1(int i3, int i10) {
        if (this.f2427p != 1 || !Y0()) {
            int[] iArr = this.G;
            return iArr[i10 + i3] - iArr[i3];
        }
        int[] iArr2 = this.G;
        int i11 = this.F;
        return iArr2[i11 - i3] - iArr2[(i11 - i3) - i10];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final int o(w1 w1Var) {
        return J0(w1Var);
    }

    public final int o1(int i3, q1 q1Var, w1 w1Var) {
        if (!w1Var.f2789g) {
            return this.K.getCachedSpanGroupIndex(i3, this.F);
        }
        int b3 = q1Var.b(i3);
        if (b3 != -1) {
            return this.K.getCachedSpanGroupIndex(b3, this.F);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i3);
        return 0;
    }

    public final int p1(int i3, q1 q1Var, w1 w1Var) {
        if (!w1Var.f2789g) {
            return this.K.getCachedSpanIndex(i3, this.F);
        }
        int i10 = this.J.get(i3, -1);
        if (i10 != -1) {
            return i10;
        }
        int b3 = q1Var.b(i3);
        if (b3 != -1) {
            return this.K.getCachedSpanIndex(b3, this.F);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 0;
    }

    public final int q1(int i3, q1 q1Var, w1 w1Var) {
        if (!w1Var.f2789g) {
            return this.K.getSpanSize(i3);
        }
        int i10 = this.I.get(i3, -1);
        if (i10 != -1) {
            return i10;
        }
        int b3 = q1Var.b(i3);
        if (b3 != -1) {
            return this.K.getSpanSize(b3);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final j1 r() {
        return this.f2427p == 0 ? new b0(-2, -1) : new b0(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final int r0(int i3, q1 q1Var, w1 w1Var) {
        t1();
        m1();
        return super.r0(i3, q1Var, w1Var);
    }

    public final void r1(int i3, View view, boolean z5) {
        int i10;
        int i11;
        b0 b0Var = (b0) view.getLayoutParams();
        Rect rect = b0Var.f2634b;
        int i12 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) b0Var).topMargin + ((ViewGroup.MarginLayoutParams) b0Var).bottomMargin;
        int i13 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) b0Var).leftMargin + ((ViewGroup.MarginLayoutParams) b0Var).rightMargin;
        int n12 = n1(b0Var.e, b0Var.f2517f);
        if (this.f2427p == 1) {
            i11 = i1.w(n12, i3, i13, ((ViewGroup.MarginLayoutParams) b0Var).width, false);
            i10 = i1.w(this.r.o(), this.f2596m, i12, ((ViewGroup.MarginLayoutParams) b0Var).height, true);
        } else {
            int w8 = i1.w(n12, i3, i12, ((ViewGroup.MarginLayoutParams) b0Var).height, false);
            int w9 = i1.w(this.r.o(), this.f2595l, i13, ((ViewGroup.MarginLayoutParams) b0Var).width, true);
            i10 = w8;
            i11 = w9;
        }
        j1 j1Var = (j1) view.getLayoutParams();
        if (z5 ? B0(view, i11, i10, j1Var) : z0(view, i11, i10, j1Var)) {
            view.measure(i11, i10);
        }
    }

    @Override // androidx.recyclerview.widget.i1
    public final j1 s(Context context, AttributeSet attributeSet) {
        b0 b0Var = new b0(context, attributeSet);
        b0Var.e = -1;
        b0Var.f2517f = 0;
        return b0Var;
    }

    public final void s1(int i3) {
        if (i3 == this.F) {
            return;
        }
        this.E = true;
        if (i3 < 1) {
            throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "Span count should be at least 1. Provided "));
        }
        this.F = i3;
        this.K.invalidateSpanIndexCache();
        q0();
    }

    @Override // androidx.recyclerview.widget.i1
    public final j1 t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            b0 b0Var = new b0((ViewGroup.MarginLayoutParams) layoutParams);
            b0Var.e = -1;
            b0Var.f2517f = 0;
            return b0Var;
        }
        b0 b0Var2 = new b0(layoutParams);
        b0Var2.e = -1;
        b0Var2.f2517f = 0;
        return b0Var2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public int t0(int i3, q1 q1Var, w1 w1Var) {
        t1();
        m1();
        return super.t0(i3, q1Var, w1Var);
    }

    public final void t1() {
        int G;
        int J;
        if (this.f2427p == 1) {
            G = this.f2597n - I();
            J = H();
        } else {
            G = this.f2598o - G();
            J = J();
        }
        l1(G - J);
    }

    @Override // androidx.recyclerview.widget.i1
    public final void w0(Rect rect, int i3, int i10) {
        int g10;
        int g11;
        if (this.G == null) {
            super.w0(rect, i3, i10);
        }
        int I = I() + H();
        int G = G() + J();
        if (this.f2427p == 1) {
            int height = rect.height() + G;
            RecyclerView recyclerView = this.f2586b;
            WeakHashMap weakHashMap = l1.z0.f15748a;
            g11 = i1.g(i10, height, l1.h0.d(recyclerView));
            int[] iArr = this.G;
            g10 = i1.g(i3, iArr[iArr.length - 1] + I, l1.h0.e(this.f2586b));
        } else {
            int width = rect.width() + I;
            RecyclerView recyclerView2 = this.f2586b;
            WeakHashMap weakHashMap2 = l1.z0.f15748a;
            g10 = i1.g(i3, width, l1.h0.e(recyclerView2));
            int[] iArr2 = this.G;
            g11 = i1.g(i10, iArr2[iArr2.length - 1] + G, l1.h0.d(this.f2586b));
        }
        this.f2586b.setMeasuredDimension(g10, g11);
    }

    @Override // androidx.recyclerview.widget.i1
    public final int x(q1 q1Var, w1 w1Var) {
        if (this.f2427p == 1) {
            return this.F;
        }
        if (w1Var.b() < 1) {
            return 0;
        }
        return o1(w1Var.b() - 1, q1Var, w1Var) + 1;
    }

    public GridLayoutManager(int i3, int i10) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new a0(0);
        this.L = new Rect();
        s1(i3);
    }

    public GridLayoutManager(int i3) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new a0(0);
        this.L = new Rect();
        s1(i3);
    }
}
