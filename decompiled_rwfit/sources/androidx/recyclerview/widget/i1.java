package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.R$styleable;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class i1 {

    /* renamed from: a, reason: collision with root package name */
    public de.o f2585a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f2586b;

    /* renamed from: c, reason: collision with root package name */
    public final g2 f2587c;

    /* renamed from: d, reason: collision with root package name */
    public final g2 f2588d;
    public r0 e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2589f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2590g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2591h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2592i;

    /* renamed from: j, reason: collision with root package name */
    public int f2593j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2594k;

    /* renamed from: l, reason: collision with root package name */
    public int f2595l;

    /* renamed from: m, reason: collision with root package name */
    public int f2596m;

    /* renamed from: n, reason: collision with root package name */
    public int f2597n;

    /* renamed from: o, reason: collision with root package name */
    public int f2598o;

    public i1() {
        h1 h1Var = new h1(this, 0);
        h1 h1Var2 = new h1(this, 1);
        this.f2587c = new g2(h1Var);
        this.f2588d = new g2(h1Var2);
        this.f2589f = false;
        this.f2590g = false;
        this.f2591h = true;
        this.f2592i = true;
    }

    public static int A(View view) {
        return view.getLeft() - ((j1) view.getLayoutParams()).f2634b.left;
    }

    public static int B(View view) {
        Rect rect = ((j1) view.getLayoutParams()).f2634b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public static int C(View view) {
        return view.getRight() + ((j1) view.getLayoutParams()).f2634b.right;
    }

    public static int D(View view) {
        return view.getTop() - ((j1) view.getLayoutParams()).f2634b.top;
    }

    public static int K(View view) {
        return ((j1) view.getLayoutParams()).f2633a.getLayoutPosition();
    }

    public static RecyclerView$LayoutManager$Properties L(Context context, AttributeSet attributeSet, int i3, int i10) {
        RecyclerView$LayoutManager$Properties recyclerView$LayoutManager$Properties = new RecyclerView$LayoutManager$Properties();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i3, i10);
        recyclerView$LayoutManager$Properties.orientation = obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
        recyclerView$LayoutManager$Properties.spanCount = obtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
        recyclerView$LayoutManager$Properties.reverseLayout = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
        recyclerView$LayoutManager$Properties.stackFromEnd = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
        obtainStyledAttributes.recycle();
        return recyclerView$LayoutManager$Properties;
    }

    public static boolean P(int i3, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (i11 > 0 && i3 != i11) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i3;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i3;
        }
        return true;
    }

    public static void Q(View view, int i3, int i10, int i11, int i12) {
        j1 j1Var = (j1) view.getLayoutParams();
        Rect rect = j1Var.f2634b;
        view.layout(i3 + rect.left + ((ViewGroup.MarginLayoutParams) j1Var).leftMargin, i10 + rect.top + ((ViewGroup.MarginLayoutParams) j1Var).topMargin, (i11 - rect.right) - ((ViewGroup.MarginLayoutParams) j1Var).rightMargin, (i12 - rect.bottom) - ((ViewGroup.MarginLayoutParams) j1Var).bottomMargin);
    }

    public static int g(int i3, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i10, i11) : size : Math.min(size, Math.max(i10, i11));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if (r5 == 1073741824) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(int r4, int r5, int r6, int r7, boolean r8) {
        /*
            int r4 = r4 - r6
            r6 = 0
            int r4 = java.lang.Math.max(r6, r4)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r8 == 0) goto L1d
            if (r7 < 0) goto L12
        L10:
            r5 = r3
            goto L30
        L12:
            if (r7 != r1) goto L1a
            if (r5 == r2) goto L22
            if (r5 == 0) goto L1a
            if (r5 == r3) goto L22
        L1a:
            r5 = r6
            r7 = r5
            goto L30
        L1d:
            if (r7 < 0) goto L20
            goto L10
        L20:
            if (r7 != r1) goto L24
        L22:
            r7 = r4
            goto L30
        L24:
            if (r7 != r0) goto L1a
            if (r5 == r2) goto L2e
            if (r5 != r3) goto L2b
            goto L2e
        L2b:
            r7 = r4
            r5 = r6
            goto L30
        L2e:
            r7 = r4
            r5 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i1.w(int, int, int, int, boolean):int");
    }

    public static int y(View view) {
        return view.getBottom() + ((j1) view.getLayoutParams()).f2634b.bottom;
    }

    public static void z(View view, Rect rect) {
        int[] iArr = RecyclerView.f2440i1;
        j1 j1Var = (j1) view.getLayoutParams();
        Rect rect2 = j1Var.f2634b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) j1Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) j1Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) j1Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) j1Var).bottomMargin);
    }

    public boolean A0() {
        return false;
    }

    public final boolean B0(View view, int i3, int i10, j1 j1Var) {
        return (this.f2591h && P(view.getMeasuredWidth(), i3, ((ViewGroup.MarginLayoutParams) j1Var).width) && P(view.getMeasuredHeight(), i10, ((ViewGroup.MarginLayoutParams) j1Var).height)) ? false : true;
    }

    public abstract void C0(int i3, RecyclerView recyclerView);

    public final void D0(r0 r0Var) {
        r0 r0Var2 = this.e;
        if (r0Var2 != null && r0Var != r0Var2 && r0Var2.e) {
            r0Var2.g();
        }
        this.e = r0Var;
        RecyclerView recyclerView = this.f2586b;
        y1 y1Var = recyclerView.f2453d0;
        y1Var.f2812g.removeCallbacks(y1Var);
        y1Var.f2809c.abortAnimation();
        if (r0Var.f2727h) {
            Log.w("RecyclerView", "An instance of " + r0Var.getClass().getSimpleName() + " was started more than once. Each instance of" + r0Var.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        r0Var.f2722b = recyclerView;
        r0Var.f2723c = this;
        int i3 = r0Var.f2721a;
        if (i3 == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.f2460g0.f2784a = i3;
        r0Var.e = true;
        r0Var.f2724d = true;
        r0Var.f2725f = recyclerView.f2471m.q(i3);
        r0Var.f2722b.f2453d0.a();
        r0Var.f2727h = true;
    }

    public final int E() {
        RecyclerView recyclerView = this.f2586b;
        z0 adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public abstract boolean E0();

    public final int F() {
        RecyclerView recyclerView = this.f2586b;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        return l1.i0.d(recyclerView);
    }

    public final int G() {
        RecyclerView recyclerView = this.f2586b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int H() {
        RecyclerView recyclerView = this.f2586b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int I() {
        RecyclerView recyclerView = this.f2586b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int J() {
        RecyclerView recyclerView = this.f2586b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int M(q1 q1Var, w1 w1Var) {
        return -1;
    }

    public final void N(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((j1) view.getLayoutParams()).f2634b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f2586b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f2586b.f2468k;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public abstract boolean O();

    public void R(int i3) {
        RecyclerView recyclerView = this.f2586b;
        if (recyclerView != null) {
            int u10 = recyclerView.e.u();
            for (int i10 = 0; i10 < u10; i10++) {
                recyclerView.e.s(i10).offsetLeftAndRight(i3);
            }
        }
    }

    public void S(int i3) {
        RecyclerView recyclerView = this.f2586b;
        if (recyclerView != null) {
            int u10 = recyclerView.e.u();
            for (int i10 = 0; i10 < u10; i10++) {
                recyclerView.e.s(i10).offsetTopAndBottom(i3);
            }
        }
    }

    public void T() {
    }

    public abstract void U(RecyclerView recyclerView);

    public abstract View V(View view, int i3, q1 q1Var, w1 w1Var);

    public void W(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f2586b;
        q1 q1Var = recyclerView.f2446b;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z5 = true;
        if (!recyclerView.canScrollVertically(1) && !this.f2586b.canScrollVertically(-1) && !this.f2586b.canScrollHorizontally(-1) && !this.f2586b.canScrollHorizontally(1)) {
            z5 = false;
        }
        accessibilityEvent.setScrollable(z5);
        z0 z0Var = this.f2586b.f2470l;
        if (z0Var != null) {
            accessibilityEvent.setItemCount(z0Var.getItemCount());
        }
    }

    public void X(q1 q1Var, w1 w1Var, m1.d dVar) {
        boolean canScrollVertically = this.f2586b.canScrollVertically(-1);
        AccessibilityNodeInfo accessibilityNodeInfo = dVar.f15938a;
        if (canScrollVertically || this.f2586b.canScrollHorizontally(-1)) {
            dVar.a(8192);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (this.f2586b.canScrollVertically(1) || this.f2586b.canScrollHorizontally(1)) {
            dVar.a(4096);
            accessibilityNodeInfo.setScrollable(true);
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) com.example.test.ui.device.activity.f0.p(M(q1Var, w1Var), x(q1Var, w1Var), 0).f7859b);
    }

    public final void Y(View view, m1.d dVar) {
        z1 L = RecyclerView.L(view);
        if (L == null || L.isRemoved()) {
            return;
        }
        de.o oVar = this.f2585a;
        if (((ArrayList) oVar.f12379d).contains(L.itemView)) {
            return;
        }
        RecyclerView recyclerView = this.f2586b;
        Z(recyclerView.f2446b, recyclerView.f2460g0, view, dVar);
    }

    public void Z(q1 q1Var, w1 w1Var, View view, m1.d dVar) {
    }

    public void a0(int i3, int i10) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(int r9, android.view.View r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i1.b(int, android.view.View, boolean):void");
    }

    public void b0() {
    }

    public abstract void c(String str);

    public void c0(int i3, int i10) {
    }

    public abstract boolean d();

    public void d0(int i3, int i10) {
    }

    public abstract boolean e();

    public void e0(int i3, int i10) {
    }

    public boolean f(j1 j1Var) {
        return j1Var != null;
    }

    public abstract void f0(q1 q1Var, w1 w1Var);

    public abstract void g0(w1 w1Var);

    public abstract void h(int i3, int i10, w1 w1Var, x xVar);

    public abstract void h0(Parcelable parcelable);

    public void i(int i3, x xVar) {
    }

    public abstract Parcelable i0();

    public abstract int j(w1 w1Var);

    public void j0(int i3) {
    }

    public abstract int k(w1 w1Var);

    /* JADX WARN: Removed duplicated region for block: B:9:0x006b A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean k0(androidx.recyclerview.widget.q1 r2, androidx.recyclerview.widget.w1 r3, int r4, android.os.Bundle r5) {
        /*
            r1 = this;
            androidx.recyclerview.widget.RecyclerView r2 = r1.f2586b
            r3 = 0
            if (r2 != 0) goto L7
            goto L6d
        L7:
            r5 = 4096(0x1000, float:5.74E-42)
            r0 = 1
            if (r4 == r5) goto L41
            r5 = 8192(0x2000, float:1.148E-41)
            if (r4 == r5) goto L13
            r2 = r3
            r4 = r2
            goto L69
        L13:
            r4 = -1
            boolean r2 = r2.canScrollVertically(r4)
            if (r2 == 0) goto L28
            int r2 = r1.f2598o
            int r5 = r1.J()
            int r2 = r2 - r5
            int r5 = r1.G()
            int r2 = r2 - r5
            int r2 = -r2
            goto L29
        L28:
            r2 = r3
        L29:
            androidx.recyclerview.widget.RecyclerView r5 = r1.f2586b
            boolean r4 = r5.canScrollHorizontally(r4)
            if (r4 == 0) goto L3f
            int r4 = r1.f2597n
            int r5 = r1.H()
            int r4 = r4 - r5
            int r5 = r1.I()
            int r4 = r4 - r5
            int r4 = -r4
            goto L69
        L3f:
            r4 = r3
            goto L69
        L41:
            boolean r2 = r2.canScrollVertically(r0)
            if (r2 == 0) goto L54
            int r2 = r1.f2598o
            int r4 = r1.J()
            int r2 = r2 - r4
            int r4 = r1.G()
            int r2 = r2 - r4
            goto L55
        L54:
            r2 = r3
        L55:
            androidx.recyclerview.widget.RecyclerView r4 = r1.f2586b
            boolean r4 = r4.canScrollHorizontally(r0)
            if (r4 == 0) goto L3f
            int r4 = r1.f2597n
            int r5 = r1.H()
            int r4 = r4 - r5
            int r5 = r1.I()
            int r4 = r4 - r5
        L69:
            if (r2 != 0) goto L6e
            if (r4 != 0) goto L6e
        L6d:
            return r3
        L6e:
            androidx.recyclerview.widget.RecyclerView r3 = r1.f2586b
            r3.h0(r4, r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i1.k0(androidx.recyclerview.widget.q1, androidx.recyclerview.widget.w1, int, android.os.Bundle):boolean");
    }

    public abstract int l(w1 w1Var);

    public final void l0(q1 q1Var) {
        for (int v6 = v() - 1; v6 >= 0; v6--) {
            if (!RecyclerView.L(u(v6)).shouldIgnore()) {
                View u10 = u(v6);
                o0(v6);
                q1Var.f(u10);
            }
        }
    }

    public abstract int m(w1 w1Var);

    public final void m0(q1 q1Var) {
        ArrayList arrayList;
        int size = q1Var.f2710a.size();
        int i3 = size - 1;
        while (true) {
            arrayList = q1Var.f2710a;
            if (i3 < 0) {
                break;
            }
            View view = ((z1) arrayList.get(i3)).itemView;
            z1 L = RecyclerView.L(view);
            if (!L.shouldIgnore()) {
                L.setIsRecyclable(false);
                if (L.isTmpDetached()) {
                    this.f2586b.removeDetachedView(view, false);
                }
                f1 f1Var = this.f2586b.L;
                if (f1Var != null) {
                    f1Var.d(L);
                }
                L.setIsRecyclable(true);
                z1 L2 = RecyclerView.L(view);
                L2.mScrapContainer = null;
                L2.mInChangeScrap = false;
                L2.clearReturnedFromScrapFlag();
                q1Var.g(L2);
            }
            i3--;
        }
        arrayList.clear();
        ArrayList arrayList2 = q1Var.f2711b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f2586b.invalidate();
        }
    }

    public abstract int n(w1 w1Var);

    public final void n0(View view, q1 q1Var) {
        de.o oVar = this.f2585a;
        x0 x0Var = (x0) oVar.f12377b;
        int indexOfChild = x0Var.f2801a.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (((e) oVar.f12378c).f(indexOfChild)) {
                oVar.M(view);
            }
            x0Var.g(indexOfChild);
        }
        q1Var.f(view);
    }

    public abstract int o(w1 w1Var);

    public final void o0(int i3) {
        if (u(i3) != null) {
            de.o oVar = this.f2585a;
            int A = oVar.A(i3);
            x0 x0Var = (x0) oVar.f12377b;
            View childAt = x0Var.f2801a.getChildAt(A);
            if (childAt == null) {
                return;
            }
            if (((e) oVar.f12378c).f(A)) {
                oVar.M(childAt);
            }
            x0Var.g(A);
        }
    }

    public final void p(q1 q1Var) {
        for (int v6 = v() - 1; v6 >= 0; v6--) {
            View u10 = u(v6);
            z1 L = RecyclerView.L(u10);
            if (!L.shouldIgnore()) {
                if (!L.isInvalid() || L.isRemoved() || this.f2586b.f2470l.hasStableIds()) {
                    u(v6);
                    this.f2585a.m(v6);
                    q1Var.h(u10);
                    this.f2586b.f2457f.n(L);
                } else {
                    o0(v6);
                    q1Var.g(L);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
    
        if ((r5.bottom - r10) > r2) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean p0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.H()
            int r1 = r8.J()
            int r2 = r8.f2597n
            int r3 = r8.I()
            int r2 = r2 - r3
            int r3 = r8.f2598o
            int r4 = r8.G()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.F()
            r7 = 1
            if (r3 != r7) goto L5c
            if (r2 == 0) goto L57
            goto L64
        L57:
            int r2 = java.lang.Math.max(r6, r10)
            goto L64
        L5c:
            if (r6 == 0) goto L5f
            goto L63
        L5f:
            int r6 = java.lang.Math.min(r4, r2)
        L63:
            r2 = r6
        L64:
            if (r1 == 0) goto L67
            goto L6b
        L67:
            int r1 = java.lang.Math.min(r5, r11)
        L6b:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lae
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L7c
            goto Lb3
        L7c:
            int r1 = r8.H()
            int r2 = r8.J()
            int r3 = r8.f2597n
            int r4 = r8.I()
            int r3 = r3 - r4
            int r4 = r8.f2598o
            int r5 = r8.G()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f2586b
            android.graphics.Rect r5 = r5.f2465i
            z(r13, r5)
            int r13 = r5.left
            int r13 = r13 - r11
            if (r13 >= r3) goto Lb3
            int r13 = r5.right
            int r13 = r13 - r11
            if (r13 <= r1) goto Lb3
            int r13 = r5.top
            int r13 = r13 - r10
            if (r13 >= r4) goto Lb3
            int r13 = r5.bottom
            int r13 = r13 - r10
            if (r13 > r2) goto Lae
            goto Lb3
        Lae:
            if (r11 != 0) goto Lb4
            if (r10 == 0) goto Lb3
            goto Lb4
        Lb3:
            return r0
        Lb4:
            if (r12 == 0) goto Lba
            r9.scrollBy(r11, r10)
            return r7
        Lba:
            r9.h0(r11, r10, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i1.p0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public View q(int i3) {
        int v6 = v();
        for (int i10 = 0; i10 < v6; i10++) {
            View u10 = u(i10);
            z1 L = RecyclerView.L(u10);
            if (L != null && L.getLayoutPosition() == i3 && !L.shouldIgnore() && (this.f2586b.f2460g0.f2789g || !L.isRemoved())) {
                return u10;
            }
        }
        return null;
    }

    public final void q0() {
        RecyclerView recyclerView = this.f2586b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public abstract j1 r();

    public abstract int r0(int i3, q1 q1Var, w1 w1Var);

    public j1 s(Context context, AttributeSet attributeSet) {
        return new j1(context, attributeSet);
    }

    public abstract void s0(int i3);

    public j1 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof j1 ? new j1((j1) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new j1((ViewGroup.MarginLayoutParams) layoutParams) : new j1(layoutParams);
    }

    public abstract int t0(int i3, q1 q1Var, w1 w1Var);

    public final View u(int i3) {
        de.o oVar = this.f2585a;
        if (oVar != null) {
            return oVar.s(i3);
        }
        return null;
    }

    public final void u0(RecyclerView recyclerView) {
        v0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public final int v() {
        de.o oVar = this.f2585a;
        if (oVar != null) {
            return oVar.u();
        }
        return 0;
    }

    public final void v0(int i3, int i10) {
        this.f2597n = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        this.f2595l = mode;
        if (mode == 0) {
            int[] iArr = RecyclerView.f2440i1;
        }
        this.f2598o = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i10);
        this.f2596m = mode2;
        if (mode2 == 0) {
            int[] iArr2 = RecyclerView.f2440i1;
        }
    }

    public void w0(Rect rect, int i3, int i10) {
        int I = I() + H() + rect.width();
        int G = G() + J() + rect.height();
        RecyclerView recyclerView = this.f2586b;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        this.f2586b.setMeasuredDimension(g(i3, I, l1.h0.e(recyclerView)), g(i10, G, l1.h0.d(this.f2586b)));
    }

    public int x(q1 q1Var, w1 w1Var) {
        return -1;
    }

    public final void x0(int i3, int i10) {
        int v6 = v();
        if (v6 == 0) {
            this.f2586b.m(i3, i10);
            return;
        }
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MIN_VALUE;
        int i14 = Integer.MAX_VALUE;
        for (int i15 = 0; i15 < v6; i15++) {
            View u10 = u(i15);
            Rect rect = this.f2586b.f2465i;
            z(u10, rect);
            int i16 = rect.left;
            if (i16 < i14) {
                i14 = i16;
            }
            int i17 = rect.right;
            if (i17 > i11) {
                i11 = i17;
            }
            int i18 = rect.top;
            if (i18 < i12) {
                i12 = i18;
            }
            int i19 = rect.bottom;
            if (i19 > i13) {
                i13 = i19;
            }
        }
        this.f2586b.f2465i.set(i14, i12, i11, i13);
        w0(this.f2586b.f2465i, i3, i10);
    }

    public final void y0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f2586b = null;
            this.f2585a = null;
            this.f2597n = 0;
            this.f2598o = 0;
        } else {
            this.f2586b = recyclerView;
            this.f2585a = recyclerView.e;
            this.f2597n = recyclerView.getWidth();
            this.f2598o = recyclerView.getHeight();
        }
        this.f2595l = 1073741824;
        this.f2596m = 1073741824;
    }

    public final boolean z0(View view, int i3, int i10, j1 j1Var) {
        return (!view.isLayoutRequested() && this.f2591h && P(view.getWidth(), i3, ((ViewGroup.MarginLayoutParams) j1Var).width) && P(view.getHeight(), i10, ((ViewGroup.MarginLayoutParams) j1Var).height)) ? false : true;
    }
}
