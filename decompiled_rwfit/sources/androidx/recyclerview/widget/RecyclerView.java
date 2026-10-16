package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements l1.b0, l1.r {

    /* renamed from: i1, reason: collision with root package name */
    public static final int[] f2440i1 = {R.attr.nestedScrollingEnabled};

    /* renamed from: j1, reason: collision with root package name */
    public static final Class[] f2441j1;

    /* renamed from: k1, reason: collision with root package name */
    public static final f0 f2442k1;
    public final AccessibilityManager A;
    public ArrayList B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public d1 G;
    public EdgeEffect H;
    public EdgeEffect I;
    public EdgeEffect J;
    public EdgeEffect K;
    public f1 L;
    public int M;
    public int N;
    public VelocityTracker O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public l1 U;
    public final x0 U0;
    public final int V;
    public boolean V0;
    public final int W;
    public b2 W0;
    public final int[] X0;
    public l1.s Y0;
    public final int[] Z0;

    /* renamed from: a, reason: collision with root package name */
    public final s1 f2443a;

    /* renamed from: a0, reason: collision with root package name */
    public final float f2444a0;

    /* renamed from: a1, reason: collision with root package name */
    public final int[] f2445a1;

    /* renamed from: b, reason: collision with root package name */
    public final q1 f2446b;

    /* renamed from: b0, reason: collision with root package name */
    public final float f2447b0;

    /* renamed from: b1, reason: collision with root package name */
    public final int[] f2448b1;

    /* renamed from: c, reason: collision with root package name */
    public SavedState f2449c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f2450c0;

    /* renamed from: c1, reason: collision with root package name */
    public final ArrayList f2451c1;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.appcompat.widget.w f2452d;

    /* renamed from: d0, reason: collision with root package name */
    public final y1 f2453d0;

    /* renamed from: d1, reason: collision with root package name */
    public final w0 f2454d1;
    public final de.o e;

    /* renamed from: e0, reason: collision with root package name */
    public z f2455e0;

    /* renamed from: e1, reason: collision with root package name */
    public boolean f2456e1;

    /* renamed from: f, reason: collision with root package name */
    public final g2 f2457f;

    /* renamed from: f0, reason: collision with root package name */
    public final x f2458f0;
    public int f1;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2459g;

    /* renamed from: g0, reason: collision with root package name */
    public final w1 f2460g0;

    /* renamed from: g1, reason: collision with root package name */
    public int f2461g1;

    /* renamed from: h, reason: collision with root package name */
    public final w0 f2462h;

    /* renamed from: h0, reason: collision with root package name */
    public n1 f2463h0;

    /* renamed from: h1, reason: collision with root package name */
    public final x0 f2464h1;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f2465i;
    public ArrayList i0;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f2466j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f2467j0;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f2468k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f2469k0;

    /* renamed from: l, reason: collision with root package name */
    public z0 f2470l;

    /* renamed from: m, reason: collision with root package name */
    public i1 f2471m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f2472n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f2473o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f2474p;

    /* renamed from: q, reason: collision with root package name */
    public m1 f2475q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2476s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2477t;

    /* renamed from: u, reason: collision with root package name */
    public int f2478u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2479v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2480w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2481x;

    /* renamed from: y, reason: collision with root package name */
    public int f2482y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2483z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new t1();

        /* renamed from: a, reason: collision with root package name */
        public Parcelable f2485a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2485a = parcel.readParcelable(classLoader == null ? i1.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeParcelable(this.f2485a, 0);
        }
    }

    static {
        Class cls = Integer.TYPE;
        f2441j1 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f2442k1 = new f0(2);
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public static RecyclerView E(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView E = E(viewGroup.getChildAt(i3));
            if (E != null) {
                return E;
            }
        }
        return null;
    }

    public static z1 L(View view) {
        if (view == null) {
            return null;
        }
        return ((j1) view.getLayoutParams()).f2633a;
    }

    private l1.s getScrollingChildHelper() {
        if (this.Y0 == null) {
            this.Y0 = new l1.s(this);
        }
        return this.Y0;
    }

    public static void i(z1 z1Var) {
        WeakReference<RecyclerView> weakReference = z1Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == z1Var.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            z1Var.mNestedRecyclerView = null;
        }
    }

    public final View A(float f2, float f10) {
        for (int u10 = this.e.u() - 1; u10 >= 0; u10--) {
            View s7 = this.e.s(u10);
            float translationX = s7.getTranslationX();
            float translationY = s7.getTranslationY();
            if (f2 >= s7.getLeft() + translationX && f2 <= s7.getRight() + translationX && f10 >= s7.getTop() + translationY && f10 <= s7.getBottom() + translationY) {
                return s7;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View B(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            return r3
        L17:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.B(android.view.View):android.view.View");
    }

    public final boolean C(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.f2474p;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            m1 m1Var = (m1) arrayList.get(i3);
            if (m1Var.b(motionEvent) && action != 3) {
                this.f2475q = m1Var;
                return true;
            }
        }
        return false;
    }

    public final void D(int[] iArr) {
        int u10 = this.e.u();
        if (u10 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i3 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int i10 = Integer.MIN_VALUE;
        for (int i11 = 0; i11 < u10; i11++) {
            z1 L = L(this.e.s(i11));
            if (!L.shouldIgnore()) {
                int layoutPosition = L.getLayoutPosition();
                if (layoutPosition < i3) {
                    i3 = layoutPosition;
                }
                if (layoutPosition > i10) {
                    i10 = layoutPosition;
                }
            }
        }
        iArr[0] = i3;
        iArr[1] = i10;
    }

    public final z1 F(int i3) {
        z1 z1Var = null;
        if (this.C) {
            return null;
        }
        int F = this.e.F();
        for (int i10 = 0; i10 < F; i10++) {
            z1 L = L(this.e.E(i10));
            if (L != null && !L.isRemoved() && I(L) == i3) {
                de.o oVar = this.e;
                if (!((ArrayList) oVar.f12379d).contains(L.itemView)) {
                    return L;
                }
                z1Var = L;
            }
        }
        return z1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.recyclerview.widget.z1 G(int r6, boolean r7) {
        /*
            r5 = this;
            de.o r0 = r5.e
            int r0 = r0.F()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3e
            de.o r3 = r5.e
            android.view.View r3 = r3.E(r2)
            androidx.recyclerview.widget.z1 r3 = L(r3)
            if (r3 == 0) goto L3b
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L3b
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L3b
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L3b
        L2a:
            de.o r1 = r5.e
            android.view.View r4 = r3.itemView
            java.lang.Object r1 = r1.f12379d
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L3a
            r1 = r3
            goto L3b
        L3a:
            return r3
        L3b:
            int r2 = r2 + 1
            goto L8
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.G(int, boolean):androidx.recyclerview.widget.z1");
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x015c, code lost:
    
        if (r1 < r13) goto L57;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ca A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H(int r21, int r22) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.H(int, int):boolean");
    }

    public final int I(z1 z1Var) {
        if (z1Var.hasAnyOfTheFlags(524) || !z1Var.isBound()) {
            return -1;
        }
        androidx.appcompat.widget.w wVar = this.f2452d;
        int i3 = z1Var.mPosition;
        ArrayList arrayList = (ArrayList) wVar.f1073c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = (a) arrayList.get(i10);
            int i11 = aVar.f2509a;
            if (i11 != 1) {
                if (i11 == 2) {
                    int i12 = aVar.f2510b;
                    if (i12 <= i3) {
                        int i13 = aVar.f2512d;
                        if (i12 + i13 > i3) {
                            return -1;
                        }
                        i3 -= i13;
                    } else {
                        continue;
                    }
                } else if (i11 == 8) {
                    int i14 = aVar.f2510b;
                    if (i14 == i3) {
                        i3 = aVar.f2512d;
                    } else {
                        if (i14 < i3) {
                            i3--;
                        }
                        if (aVar.f2512d <= i3) {
                            i3++;
                        }
                    }
                }
            } else if (aVar.f2510b <= i3) {
                i3 += aVar.f2512d;
            }
        }
        return i3;
    }

    public final long J(z1 z1Var) {
        return this.f2470l.hasStableIds() ? z1Var.getItemId() : z1Var.mPosition;
    }

    public final z1 K(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return L(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect M(View view) {
        j1 j1Var = (j1) view.getLayoutParams();
        boolean z5 = j1Var.f2635c;
        Rect rect = j1Var.f2634b;
        if (z5) {
            w1 w1Var = this.f2460g0;
            if (!w1Var.f2789g || (!j1Var.f2633a.isUpdated() && !j1Var.f2633a.isInvalid())) {
                rect.set(0, 0, 0, 0);
                ArrayList arrayList = this.f2473o;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Rect rect2 = this.f2465i;
                    rect2.set(0, 0, 0, 0);
                    ((g1) arrayList.get(i3)).e(rect2, view, this, w1Var);
                    rect.left += rect2.left;
                    rect.top += rect2.top;
                    rect.right += rect2.right;
                    rect.bottom += rect2.bottom;
                }
                j1Var.f2635c = false;
                return rect;
            }
        }
        return rect;
    }

    public final boolean N() {
        return !this.f2477t || this.C || this.f2452d.k();
    }

    public final boolean O() {
        return this.E > 0;
    }

    public final void P(int i3) {
        if (this.f2471m == null) {
            return;
        }
        setScrollState(2);
        this.f2471m.s0(i3);
        awakenScrollBars();
    }

    public final void Q() {
        int F = this.e.F();
        for (int i3 = 0; i3 < F; i3++) {
            ((j1) this.e.E(i3).getLayoutParams()).f2635c = true;
        }
        ArrayList arrayList = this.f2446b.f2712c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            j1 j1Var = (j1) ((z1) arrayList.get(i10)).itemView.getLayoutParams();
            if (j1Var != null) {
                j1Var.f2635c = true;
            }
        }
    }

    public final void R(int i3, int i10, boolean z5) {
        int i11 = i3 + i10;
        int F = this.e.F();
        for (int i12 = 0; i12 < F; i12++) {
            z1 L = L(this.e.E(i12));
            if (L != null && !L.shouldIgnore()) {
                int i13 = L.mPosition;
                w1 w1Var = this.f2460g0;
                if (i13 >= i11) {
                    L.offsetPosition(-i10, z5);
                    w1Var.f2788f = true;
                } else if (i13 >= i3) {
                    L.flagRemovedAndOffsetPosition(i3 - 1, -i10, z5);
                    w1Var.f2788f = true;
                }
            }
        }
        q1 q1Var = this.f2446b;
        ArrayList arrayList = q1Var.f2712c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            z1 z1Var = (z1) arrayList.get(size);
            if (z1Var != null) {
                int i14 = z1Var.mPosition;
                if (i14 >= i11) {
                    z1Var.offsetPosition(-i10, z5);
                } else if (i14 >= i3) {
                    z1Var.addFlags(8);
                    q1Var.e(size);
                }
            }
        }
        requestLayout();
    }

    public final void S() {
        this.E++;
    }

    public final void T(boolean z5) {
        int i3;
        AccessibilityManager accessibilityManager;
        int i10 = this.E - 1;
        this.E = i10;
        if (i10 < 1) {
            this.E = 0;
            if (z5) {
                int i11 = this.f2482y;
                this.f2482y = 0;
                if (i11 != 0 && (accessibilityManager = this.A) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(2048);
                    m1.a.b(obtain, i11);
                    sendAccessibilityEventUnchecked(obtain);
                }
                ArrayList arrayList = this.f2451c1;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    z1 z1Var = (z1) arrayList.get(size);
                    if (z1Var.itemView.getParent() == this && !z1Var.shouldIgnore() && (i3 = z1Var.mPendingAccessibilityState) != -1) {
                        View view = z1Var.itemView;
                        WeakHashMap weakHashMap = l1.z0.f15748a;
                        l1.h0.s(view, i3);
                        z1Var.mPendingAccessibilityState = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void U(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.N) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.N = motionEvent.getPointerId(i3);
            int x10 = (int) (motionEvent.getX(i3) + 0.5f);
            this.R = x10;
            this.P = x10;
            int y4 = (int) (motionEvent.getY(i3) + 0.5f);
            this.S = y4;
            this.Q = y4;
        }
    }

    public void V(int i3) {
    }

    public void W() {
    }

    public final void X() {
        if (this.V0 || !this.r) {
            return;
        }
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.h0.m(this, this.f2454d1);
        this.V0 = true;
    }

    public final void Y() {
        boolean z5;
        boolean z6 = false;
        if (this.C) {
            androidx.appcompat.widget.w wVar = this.f2452d;
            wVar.r((ArrayList) wVar.f1073c);
            wVar.r((ArrayList) wVar.f1074d);
            wVar.f1071a = 0;
            if (this.D) {
                this.f2471m.b0();
            }
        }
        if (this.L == null || !this.f2471m.E0()) {
            this.f2452d.d();
        } else {
            this.f2452d.q();
        }
        boolean z8 = this.f2467j0 || this.f2469k0;
        boolean z10 = this.f2477t && this.L != null && ((z5 = this.C) || z8 || this.f2471m.f2589f) && (!z5 || this.f2470l.hasStableIds());
        w1 w1Var = this.f2460g0;
        w1Var.f2792j = z10;
        if (z10 && z8 && !this.C && this.L != null && this.f2471m.E0()) {
            z6 = true;
        }
        w1Var.f2793k = z6;
    }

    public final void Z(boolean z5) {
        this.D = z5 | this.D;
        this.C = true;
        int F = this.e.F();
        for (int i3 = 0; i3 < F; i3++) {
            z1 L = L(this.e.E(i3));
            if (L != null && !L.shouldIgnore()) {
                L.addFlags(6);
            }
        }
        Q();
        q1 q1Var = this.f2446b;
        ArrayList arrayList = q1Var.f2712c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            z1 z1Var = (z1) arrayList.get(i10);
            if (z1Var != null) {
                z1Var.addFlags(6);
                z1Var.addChangePayload(null);
            }
        }
        z0 z0Var = q1Var.f2716h.f2470l;
        if (z0Var == null || !z0Var.hasStableIds()) {
            q1Var.d();
        }
    }

    public final void a0(z1 z1Var, e1 e1Var) {
        z1Var.setFlags(0, 8192);
        boolean z5 = this.f2460g0.f2790h;
        g2 g2Var = this.f2457f;
        if (z5 && z1Var.isUpdated() && !z1Var.isRemoved() && !z1Var.shouldIgnore()) {
            ((m0.e) g2Var.f2571b).d(J(z1Var), z1Var);
        }
        m0.k kVar = (m0.k) g2Var.f2570a;
        k2 k2Var = (k2) kVar.getOrDefault(z1Var, null);
        if (k2Var == null) {
            k2Var = k2.a();
            kVar.put(z1Var, k2Var);
        }
        k2Var.f2648b = e1Var;
        k2Var.f2647a |= 4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i3, int i10) {
        i1 i1Var = this.f2471m;
        if (i1Var != null) {
            i1Var.getClass();
        }
        super.addFocusables(arrayList, i3, i10);
    }

    public void addOnChildAttachStateChangeListener(k1 k1Var) {
        if (this.B == null) {
            this.B = new ArrayList();
        }
        this.B.add(k1Var);
    }

    public void addOnItemTouchListener(m1 m1Var) {
        this.f2474p.add(m1Var);
    }

    public void addOnScrollListener(n1 n1Var) {
        if (this.i0 == null) {
            this.i0 = new ArrayList();
        }
        this.i0.add(n1Var);
    }

    public final void b0(g1 g1Var) {
        i1 i1Var = this.f2471m;
        if (i1Var != null) {
            i1Var.c("Cannot remove item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f2473o;
        arrayList.remove(g1Var);
        if (arrayList.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        Q();
        requestLayout();
    }

    public final void c0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f2465i;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof j1) {
            j1 j1Var = (j1) layoutParams;
            if (!j1Var.f2635c) {
                int i3 = rect.left;
                Rect rect2 = j1Var.f2634b;
                rect.left = i3 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.f2471m.p0(this, view, this.f2465i, !this.f2477t, view2 == null);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof j1) && this.f2471m.f((j1) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        i1 i1Var = this.f2471m;
        if (i1Var != null && i1Var.d()) {
            return this.f2471m.j(this.f2460g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        i1 i1Var = this.f2471m;
        if (i1Var != null && i1Var.d()) {
            return this.f2471m.k(this.f2460g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        i1 i1Var = this.f2471m;
        if (i1Var != null && i1Var.d()) {
            return this.f2471m.l(this.f2460g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        i1 i1Var = this.f2471m;
        if (i1Var != null && i1Var.e()) {
            return this.f2471m.m(this.f2460g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        i1 i1Var = this.f2471m;
        if (i1Var != null && i1Var.e()) {
            return this.f2471m.n(this.f2460g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        i1 i1Var = this.f2471m;
        if (i1Var != null && i1Var.e()) {
            return this.f2471m.o(this.f2460g0);
        }
        return 0;
    }

    public final void d0() {
        VelocityTracker velocityTracker = this.O;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z5 = false;
        l0(0);
        EdgeEffect edgeEffect = this.H;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z5 = this.H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.I;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z5 |= this.I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.J;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z5 |= this.J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.K;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z5 |= this.K.isFinished();
        }
        if (z5) {
            WeakHashMap weakHashMap = l1.z0.f15748a;
            l1.h0.k(this);
        }
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f10, boolean z5) {
        return getScrollingChildHelper().a(f2, f10, z5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f10) {
        return getScrollingChildHelper().b(f2, f10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i3, int i10, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i3, i10, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i3, int i10, int i11, int i12, int[] iArr) {
        return getScrollingChildHelper().d(i3, i10, i11, i12, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z5;
        super.draw(canvas);
        ArrayList arrayList = this.f2473o;
        int size = arrayList.size();
        boolean z6 = false;
        for (int i3 = 0; i3 < size; i3++) {
            ((g1) arrayList.get(i3)).g(canvas, this);
        }
        EdgeEffect edgeEffect = this.H;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z5 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f2459g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.H;
            z5 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f2459g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.I;
            z5 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.J;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f2459g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.J;
            z5 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.K;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f2459g) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.K;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z6 = true;
            }
            z5 |= z6;
            canvas.restoreToCount(save4);
        }
        if ((z5 || this.L == null || arrayList.size() <= 0 || !this.L.f()) ? z5 : true) {
            WeakHashMap weakHashMap = l1.z0.f15748a;
            l1.h0.k(this);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        return super.drawChild(canvas, view, j4);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e0(int r17, android.view.MotionEvent r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.e0(int, android.view.MotionEvent, int, int):boolean");
    }

    public final void f(z1 z1Var) {
        View view = z1Var.itemView;
        boolean z5 = view.getParent() == this;
        this.f2446b.j(K(view));
        if (z1Var.isTmpDetached()) {
            this.e.g(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z5) {
            this.e.f(-1, view, true);
            return;
        }
        de.o oVar = this.e;
        int indexOfChild = ((x0) oVar.f12377b).f2801a.indexOfChild(view);
        if (indexOfChild >= 0) {
            ((e) oVar.f12378c).h(indexOfChild);
            oVar.G(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void f0(int[] iArr, int i3, int i10) {
        z1 z1Var;
        de.o oVar = this.e;
        j0();
        S();
        int i11 = h1.l.f14255a;
        h1.k.a("RV Scroll");
        w1 w1Var = this.f2460g0;
        z(w1Var);
        q1 q1Var = this.f2446b;
        int r02 = i3 != 0 ? this.f2471m.r0(i3, q1Var, w1Var) : 0;
        int t02 = i10 != 0 ? this.f2471m.t0(i10, q1Var, w1Var) : 0;
        h1.k.b();
        int u10 = oVar.u();
        for (int i12 = 0; i12 < u10; i12++) {
            View s7 = oVar.s(i12);
            z1 K = K(s7);
            if (K != null && (z1Var = K.mShadowingHolder) != null) {
                View view = z1Var.itemView;
                int left = s7.getLeft();
                int top = s7.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        T(true);
        k0(false);
        if (iArr != null) {
            iArr[0] = r02;
            iArr[1] = t02;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0186, code lost:
    
        if (r5 < 0) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x018e, code lost:
    
        if ((r5 * r6) <= 0) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0196, code lost:
    
        if ((r5 * r6) >= 0) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0160, code lost:
    
        if (r7 > 0) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0180, code lost:
    
        if (r5 > 0) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0183, code lost:
    
        if (r7 < 0) goto L136;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00db  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g(g1 g1Var) {
        i1 i1Var = this.f2471m;
        if (i1Var != null) {
            i1Var.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f2473o;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(g1Var);
        Q();
        requestLayout();
    }

    public final void g0(int i3) {
        r0 r0Var;
        if (this.f2480w) {
            return;
        }
        setScrollState(0);
        y1 y1Var = this.f2453d0;
        y1Var.f2812g.removeCallbacks(y1Var);
        y1Var.f2809c.abortAnimation();
        i1 i1Var = this.f2471m;
        if (i1Var != null && (r0Var = i1Var.e) != null) {
            r0Var.g();
        }
        i1 i1Var2 = this.f2471m;
        if (i1Var2 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            i1Var2.s0(i3);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        i1 i1Var = this.f2471m;
        if (i1Var != null) {
            return i1Var.r();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + y());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i1 i1Var = this.f2471m;
        if (i1Var != null) {
            return i1Var.s(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + y());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public z0 getAdapter() {
        return this.f2470l;
    }

    @Override // android.view.View
    public int getBaseline() {
        i1 i1Var = this.f2471m;
        if (i1Var == null) {
            return super.getBaseline();
        }
        i1Var.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i3, int i10) {
        return super.getChildDrawingOrder(i3, i10);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f2459g;
    }

    public b2 getCompatAccessibilityDelegate() {
        return this.W0;
    }

    public d1 getEdgeEffectFactory() {
        return this.G;
    }

    public f1 getItemAnimator() {
        return this.L;
    }

    public int getItemDecorationCount() {
        return this.f2473o.size();
    }

    public i1 getLayoutManager() {
        return this.f2471m;
    }

    public int getMaxFlingVelocity() {
        return this.W;
    }

    public int getMinFlingVelocity() {
        return this.V;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public l1 getOnFlingListener() {
        return this.U;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f2450c0;
    }

    public p1 getRecycledViewPool() {
        return this.f2446b.c();
    }

    public int getScrollState() {
        return this.M;
    }

    public final void h(String str) {
        if (O()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + y());
        }
        if (this.F > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + y()));
        }
    }

    public final void h0(int i3, int i10, boolean z5) {
        i1 i1Var = this.f2471m;
        if (i1Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f2480w) {
            return;
        }
        if (!i1Var.d()) {
            i3 = 0;
        }
        if (!this.f2471m.e()) {
            i10 = 0;
        }
        if (i3 == 0 && i10 == 0) {
            return;
        }
        if (z5) {
            int i11 = i3 != 0 ? 1 : 0;
            if (i10 != 0) {
                i11 |= 2;
            }
            getScrollingChildHelper().h(i11, 1);
        }
        this.f2453d0.b(i3, i10, Integer.MIN_VALUE, null);
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i0(int i3) {
        if (this.f2480w) {
            return;
        }
        i1 i1Var = this.f2471m;
        if (i1Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            i1Var.C0(i3, this);
        }
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.r;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f2480w;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f15729d;
    }

    public final void j() {
        int F = this.e.F();
        for (int i3 = 0; i3 < F; i3++) {
            z1 L = L(this.e.E(i3));
            if (!L.shouldIgnore()) {
                L.clearOldPosition();
            }
        }
        q1 q1Var = this.f2446b;
        ArrayList arrayList = q1Var.f2712c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((z1) arrayList.get(i10)).clearOldPosition();
        }
        ArrayList arrayList2 = q1Var.f2710a;
        int size2 = arrayList2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            ((z1) arrayList2.get(i11)).clearOldPosition();
        }
        ArrayList arrayList3 = q1Var.f2711b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i12 = 0; i12 < size3; i12++) {
                ((z1) q1Var.f2711b.get(i12)).clearOldPosition();
            }
        }
    }

    public final void j0() {
        int i3 = this.f2478u + 1;
        this.f2478u = i3;
        if (i3 != 1 || this.f2480w) {
            return;
        }
        this.f2479v = false;
    }

    public final void k(int i3, int i10) {
        boolean z5;
        EdgeEffect edgeEffect = this.H;
        if (edgeEffect == null || edgeEffect.isFinished() || i3 <= 0) {
            z5 = false;
        } else {
            this.H.onRelease();
            z5 = this.H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.J;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i3 < 0) {
            this.J.onRelease();
            z5 |= this.J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i10 > 0) {
            this.I.onRelease();
            z5 |= this.I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.K;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i10 < 0) {
            this.K.onRelease();
            z5 |= this.K.isFinished();
        }
        if (z5) {
            WeakHashMap weakHashMap = l1.z0.f15748a;
            l1.h0.k(this);
        }
    }

    public final void k0(boolean z5) {
        if (this.f2478u < 1) {
            this.f2478u = 1;
        }
        if (!z5 && !this.f2480w) {
            this.f2479v = false;
        }
        if (this.f2478u == 1) {
            if (z5 && this.f2479v && !this.f2480w && this.f2471m != null && this.f2470l != null) {
                o();
            }
            if (!this.f2480w) {
                this.f2479v = false;
            }
        }
        this.f2478u--;
    }

    public final void l() {
        de.o oVar = this.e;
        androidx.appcompat.widget.w wVar = this.f2452d;
        if (!this.f2477t || this.C) {
            int i3 = h1.l.f14255a;
            h1.k.a("RV FullInvalidate");
            o();
            h1.k.b();
            return;
        }
        if (wVar.k()) {
            int i10 = wVar.f1071a;
            if ((i10 & 4) == 0 || (i10 & 11) != 0) {
                if (wVar.k()) {
                    int i11 = h1.l.f14255a;
                    h1.k.a("RV FullInvalidate");
                    o();
                    h1.k.b();
                    return;
                }
                return;
            }
            int i12 = h1.l.f14255a;
            h1.k.a("RV PartialInvalidate");
            j0();
            S();
            wVar.q();
            if (!this.f2479v) {
                int u10 = oVar.u();
                int i13 = 0;
                while (true) {
                    if (i13 < u10) {
                        z1 L = L(oVar.s(i13));
                        if (L != null && !L.shouldIgnore() && L.isUpdated()) {
                            o();
                            break;
                        }
                        i13++;
                    } else {
                        wVar.c();
                        break;
                    }
                }
            }
            k0(true);
            T(true);
            h1.k.b();
        }
    }

    public final void l0(int i3) {
        getScrollingChildHelper().i(i3);
    }

    public final void m(int i3, int i10) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = l1.z0.f15748a;
        setMeasuredDimension(i1.g(i3, paddingRight, l1.h0.e(this)), i1.g(i10, getPaddingBottom() + getPaddingTop(), l1.h0.d(this)));
    }

    public final void n(View view) {
        z1 L = L(view);
        z0 z0Var = this.f2470l;
        if (z0Var != null && L != null) {
            z0Var.onViewDetachedFromWindow(L);
        }
        ArrayList arrayList = this.B;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((k1) this.B.get(size)).c(view);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x035a, code lost:
    
        if (((java.util.ArrayList) r21.e.f12379d).contains(getFocusedChild()) == false) goto L228;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03d7  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [androidx.recyclerview.widget.z1] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [int] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o() {
        /*
            Method dump skipped, instructions count: 1079
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r1 >= 30.0f) goto L20;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.E = r0
            r1 = 1
            r5.r = r1
            boolean r2 = r5.f2477t
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.f2477t = r2
            androidx.recyclerview.widget.i1 r2 = r5.f2471m
            if (r2 == 0) goto L1e
            r2.f2590g = r1
        L1e:
            r5.V0 = r0
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.z.e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.z r1 = (androidx.recyclerview.widget.z) r1
            r5.f2455e0 = r1
            if (r1 != 0) goto L68
            androidx.recyclerview.widget.z r1 = new androidx.recyclerview.widget.z
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2814a = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2817d = r2
            r5.f2455e0 = r1
            java.util.WeakHashMap r1 = l1.z0.f15748a
            android.view.Display r1 = l1.i0.b(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L5a
            if (r1 == 0) goto L5a
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L5a
            goto L5c
        L5a:
            r1 = 1114636288(0x42700000, float:60.0)
        L5c:
            androidx.recyclerview.widget.z r2 = r5.f2455e0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f2816c = r3
            r0.set(r2)
        L68:
            androidx.recyclerview.widget.z r0 = r5.f2455e0
            java.util.ArrayList r0 = r0.f2814a
            r0.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        r0 r0Var;
        super.onDetachedFromWindow();
        f1 f1Var = this.L;
        if (f1Var != null) {
            f1Var.e();
        }
        setScrollState(0);
        y1 y1Var = this.f2453d0;
        y1Var.f2812g.removeCallbacks(y1Var);
        y1Var.f2809c.abortAnimation();
        i1 i1Var = this.f2471m;
        if (i1Var != null && (r0Var = i1Var.e) != null) {
            r0Var.g();
        }
        this.r = false;
        i1 i1Var2 = this.f2471m;
        if (i1Var2 != null) {
            i1Var2.f2590g = false;
            i1Var2.U(this);
        }
        this.f2451c1.clear();
        removeCallbacks(this.f2454d1);
        this.f2457f.getClass();
        while (k2.f2646d.a() != null) {
        }
        z zVar = this.f2455e0;
        if (zVar != null) {
            zVar.f2814a.remove(this);
            this.f2455e0 = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f2473o;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((g1) arrayList.get(i3)).f(canvas, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        if (!this.f2480w) {
            this.f2475q = null;
            if (C(motionEvent)) {
                d0();
                setScrollState(0);
                return true;
            }
            i1 i1Var = this.f2471m;
            if (i1Var != null) {
                boolean d5 = i1Var.d();
                boolean e = this.f2471m.e();
                if (this.O == null) {
                    this.O = VelocityTracker.obtain();
                }
                this.O.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.f2481x) {
                        this.f2481x = false;
                    }
                    this.N = motionEvent.getPointerId(0);
                    int x10 = (int) (motionEvent.getX() + 0.5f);
                    this.R = x10;
                    this.P = x10;
                    int y4 = (int) (motionEvent.getY() + 0.5f);
                    this.S = y4;
                    this.Q = y4;
                    if (this.M == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        l0(1);
                    }
                    int[] iArr = this.f2445a1;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i3 = d5;
                    if (e) {
                        i3 = (d5 ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().h(i3, 0);
                } else if (actionMasked == 1) {
                    this.O.clear();
                    l0(0);
                } else if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.N);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.N + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x11 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y10 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.M != 1) {
                        int i10 = x11 - this.P;
                        int i11 = y10 - this.Q;
                        if (d5 == 0 || Math.abs(i10) <= this.T) {
                            z5 = false;
                        } else {
                            this.R = x11;
                            z5 = true;
                        }
                        if (e && Math.abs(i11) > this.T) {
                            this.S = y10;
                            z5 = true;
                        }
                        if (z5) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    d0();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.N = motionEvent.getPointerId(actionIndex);
                    int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.R = x12;
                    this.P = x12;
                    int y11 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.S = y11;
                    this.Q = y11;
                } else if (actionMasked == 6) {
                    U(motionEvent);
                }
                if (this.M == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int i13 = h1.l.f14255a;
        h1.k.a("RV OnLayout");
        o();
        h1.k.b();
        this.f2477t = true;
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i10) {
        i1 i1Var = this.f2471m;
        if (i1Var == null) {
            m(i3, i10);
            return;
        }
        boolean O = i1Var.O();
        boolean z5 = false;
        w1 w1Var = this.f2460g0;
        if (O) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i10);
            this.f2471m.f2586b.m(i3, i10);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z5 = true;
            }
            this.f2456e1 = z5;
            if (z5 || this.f2470l == null) {
                return;
            }
            if (w1Var.f2787d == 1) {
                p();
            }
            this.f2471m.v0(i3, i10);
            w1Var.f2791i = true;
            q();
            this.f2471m.x0(i3, i10);
            if (this.f2471m.A0()) {
                this.f2471m.v0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                w1Var.f2791i = true;
                q();
                this.f2471m.x0(i3, i10);
            }
            this.f1 = getMeasuredWidth();
            this.f2461g1 = getMeasuredHeight();
            return;
        }
        if (this.f2476s) {
            this.f2471m.f2586b.m(i3, i10);
            return;
        }
        if (this.f2483z) {
            j0();
            S();
            Y();
            T(true);
            if (w1Var.f2793k) {
                w1Var.f2789g = true;
            } else {
                this.f2452d.d();
                w1Var.f2789g = false;
            }
            this.f2483z = false;
            k0(false);
        } else if (w1Var.f2793k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        z0 z0Var = this.f2470l;
        if (z0Var != null) {
            w1Var.e = z0Var.getItemCount();
        } else {
            w1Var.e = 0;
        }
        j0();
        this.f2471m.f2586b.m(i3, i10);
        k0(false);
        w1Var.f2789g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (O()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i3, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f2449c = savedState;
        super.onRestoreInstanceState(savedState.a());
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f2449c;
        if (savedState2 != null) {
            savedState.f2485a = savedState2.f2485a;
            return savedState;
        }
        i1 i1Var = this.f2471m;
        if (i1Var != null) {
            savedState.f2485a = i1Var.i0();
            return savedState;
        }
        savedState.f2485a = null;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        super.onSizeChanged(i3, i10, i11, i12);
        if (i3 == i11 && i10 == i12) {
            return;
        }
        this.K = null;
        this.I = null;
        this.J = null;
        this.H = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0116  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        View B;
        k2 k2Var;
        w1 w1Var = this.f2460g0;
        w1Var.a(1);
        z(w1Var);
        w1Var.f2791i = false;
        j0();
        g2 g2Var = this.f2457f;
        ((m0.k) g2Var.f2570a).clear();
        m0.e eVar = (m0.e) g2Var.f2571b;
        eVar.a();
        S();
        Y();
        View focusedChild = (this.f2450c0 && hasFocus() && this.f2470l != null) ? getFocusedChild() : null;
        z1 K = (focusedChild == null || (B = B(focusedChild)) == null) ? null : K(B);
        if (K == null) {
            w1Var.f2795m = -1L;
            w1Var.f2794l = -1;
            w1Var.f2796n = -1;
        } else {
            w1Var.f2795m = this.f2470l.hasStableIds() ? K.getItemId() : -1L;
            w1Var.f2794l = this.C ? -1 : K.isRemoved() ? K.mOldPosition : K.getAbsoluteAdapterPosition();
            View view = K.itemView;
            int id2 = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    id2 = view.getId();
                }
            }
            w1Var.f2796n = id2;
        }
        w1Var.f2790h = w1Var.f2792j && this.f2469k0;
        this.f2469k0 = false;
        this.f2467j0 = false;
        w1Var.f2789g = w1Var.f2793k;
        w1Var.e = this.f2470l.getItemCount();
        D(this.X0);
        boolean z5 = w1Var.f2792j;
        m0.k kVar = (m0.k) g2Var.f2570a;
        if (z5) {
            int u10 = this.e.u();
            for (int i3 = 0; i3 < u10; i3++) {
                z1 L = L(this.e.s(i3));
                if (!L.shouldIgnore() && (!L.isInvalid() || this.f2470l.hasStableIds())) {
                    f1 f1Var = this.L;
                    f1.b(L);
                    L.getUnmodifiedPayloads();
                    f1Var.getClass();
                    e1 e1Var = new e1(0);
                    e1Var.a(L);
                    k2 k2Var2 = (k2) kVar.getOrDefault(L, null);
                    if (k2Var2 == null) {
                        k2Var2 = k2.a();
                        kVar.put(L, k2Var2);
                    }
                    k2Var2.f2648b = e1Var;
                    k2Var2.f2647a |= 4;
                    if (w1Var.f2790h && L.isUpdated() && !L.isRemoved() && !L.shouldIgnore() && !L.isInvalid()) {
                        eVar.d(J(L), L);
                    }
                }
            }
        }
        if (w1Var.f2793k) {
            int F = this.e.F();
            for (int i10 = 0; i10 < F; i10++) {
                z1 L2 = L(this.e.E(i10));
                if (!L2.shouldIgnore()) {
                    L2.saveOldPosition();
                }
            }
            boolean z6 = w1Var.f2788f;
            w1Var.f2788f = false;
            this.f2471m.f0(this.f2446b, w1Var);
            w1Var.f2788f = z6;
            for (int i11 = 0; i11 < this.e.u(); i11++) {
                z1 L3 = L(this.e.s(i11));
                if (!L3.shouldIgnore() && ((k2Var = (k2) kVar.getOrDefault(L3, null)) == null || (k2Var.f2647a & 4) == 0)) {
                    f1.b(L3);
                    boolean hasAnyOfTheFlags = L3.hasAnyOfTheFlags(8192);
                    f1 f1Var2 = this.L;
                    L3.getUnmodifiedPayloads();
                    f1Var2.getClass();
                    e1 e1Var2 = new e1(0);
                    e1Var2.a(L3);
                    if (hasAnyOfTheFlags) {
                        a0(L3, e1Var2);
                    } else {
                        k2 k2Var3 = (k2) kVar.getOrDefault(L3, null);
                        if (k2Var3 == null) {
                            k2Var3 = k2.a();
                            kVar.put(L3, k2Var3);
                        }
                        k2Var3.f2647a |= 2;
                        k2Var3.f2648b = e1Var2;
                    }
                }
            }
            j();
        } else {
            j();
        }
        T(true);
        k0(false);
        w1Var.f2787d = 2;
    }

    public final void q() {
        j0();
        S();
        w1 w1Var = this.f2460g0;
        w1Var.a(6);
        this.f2452d.d();
        w1Var.e = this.f2470l.getItemCount();
        w1Var.f2786c = 0;
        if (this.f2449c != null && this.f2470l.canRestoreState()) {
            Parcelable parcelable = this.f2449c.f2485a;
            if (parcelable != null) {
                this.f2471m.h0(parcelable);
            }
            this.f2449c = null;
        }
        w1Var.f2789g = false;
        this.f2471m.f0(this.f2446b, w1Var);
        w1Var.f2788f = false;
        w1Var.f2792j = w1Var.f2792j && this.L != null;
        w1Var.f2787d = 4;
        T(true);
        k0(false);
    }

    public final boolean r(int i3, int i10, int[] iArr, int[] iArr2, int i11) {
        return getScrollingChildHelper().c(i3, i10, iArr, iArr2, i11);
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z5) {
        z1 L = L(view);
        if (L != null) {
            if (L.isTmpDetached()) {
                L.clearTmpDetachFlag();
            } else if (!L.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + L + y());
            }
        }
        view.clearAnimation();
        n(view);
        super.removeDetachedView(view, z5);
    }

    public void removeOnChildAttachStateChangeListener(k1 k1Var) {
        ArrayList arrayList = this.B;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(k1Var);
    }

    public void removeOnItemTouchListener(m1 m1Var) {
        this.f2474p.remove(m1Var);
        if (this.f2475q == m1Var) {
            this.f2475q = null;
        }
    }

    public void removeOnScrollListener(n1 n1Var) {
        ArrayList arrayList = this.i0;
        if (arrayList != null) {
            arrayList.remove(n1Var);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        r0 r0Var = this.f2471m.e;
        if ((r0Var == null || !r0Var.e) && !O() && view2 != null) {
            c0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        return this.f2471m.p0(this, view, rect, z5, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z5) {
        ArrayList arrayList = this.f2474p;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((m1) arrayList.get(i3)).d(z5);
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f2478u != 0 || this.f2480w) {
            this.f2479v = true;
        } else {
            super.requestLayout();
        }
    }

    public final void s(int i3, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        getScrollingChildHelper().d(i3, i10, i11, i12, iArr, i13, iArr2);
    }

    @Override // android.view.View
    public final void scrollBy(int i3, int i10) {
        i1 i1Var = this.f2471m;
        if (i1Var == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f2480w) {
            return;
        }
        boolean d5 = i1Var.d();
        boolean e = this.f2471m.e();
        if (d5 || e) {
            if (!d5) {
                i3 = 0;
            }
            if (!e) {
                i10 = 0;
            }
            e0(i3, null, i10, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i3, int i10) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!O()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int a3 = accessibilityEvent != null ? m1.a.a(accessibilityEvent) : 0;
            this.f2482y |= a3 != 0 ? a3 : 0;
        }
    }

    public void setAccessibilityDelegateCompat(b2 b2Var) {
        this.W0 = b2Var;
        l1.z0.n(this, b2Var);
    }

    public void setAdapter(z0 z0Var) {
        setLayoutFrozen(false);
        z0 z0Var2 = this.f2470l;
        s1 s1Var = this.f2443a;
        if (z0Var2 != null) {
            z0Var2.unregisterAdapterDataObserver(s1Var);
            this.f2470l.onDetachedFromRecyclerView(this);
        }
        f1 f1Var = this.L;
        if (f1Var != null) {
            f1Var.e();
        }
        i1 i1Var = this.f2471m;
        q1 q1Var = this.f2446b;
        if (i1Var != null) {
            i1Var.l0(q1Var);
            this.f2471m.m0(q1Var);
        }
        q1Var.f2710a.clear();
        q1Var.d();
        androidx.appcompat.widget.w wVar = this.f2452d;
        wVar.r((ArrayList) wVar.f1073c);
        wVar.r((ArrayList) wVar.f1074d);
        wVar.f1071a = 0;
        z0 z0Var3 = this.f2470l;
        this.f2470l = z0Var;
        if (z0Var != null) {
            z0Var.registerAdapterDataObserver(s1Var);
            z0Var.onAttachedToRecyclerView(this);
        }
        i1 i1Var2 = this.f2471m;
        if (i1Var2 != null) {
            i1Var2.T();
        }
        z0 z0Var4 = this.f2470l;
        q1Var.f2710a.clear();
        q1Var.d();
        p1 c9 = q1Var.c();
        if (z0Var3 != null) {
            c9.f2706b--;
        }
        if (c9.f2706b == 0) {
            int i3 = 0;
            while (true) {
                SparseArray sparseArray = c9.f2705a;
                if (i3 >= sparseArray.size()) {
                    break;
                }
                ((o1) sparseArray.valueAt(i3)).f2690a.clear();
                i3++;
            }
        }
        if (z0Var4 != null) {
            c9.f2706b++;
        }
        this.f2460g0.f2788f = true;
        Z(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(c1 c1Var) {
        if (c1Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(c1Var != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z5) {
        if (z5 != this.f2459g) {
            this.K = null;
            this.I = null;
            this.J = null;
            this.H = null;
        }
        this.f2459g = z5;
        super.setClipToPadding(z5);
        if (this.f2477t) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(d1 d1Var) {
        d1Var.getClass();
        this.G = d1Var;
        this.K = null;
        this.I = null;
        this.J = null;
        this.H = null;
    }

    public void setHasFixedSize(boolean z5) {
        this.f2476s = z5;
    }

    public void setItemAnimator(f1 f1Var) {
        f1 f1Var2 = this.L;
        if (f1Var2 != null) {
            f1Var2.e();
            this.L.f2561a = null;
        }
        this.L = f1Var;
        if (f1Var != null) {
            f1Var.f2561a = this.U0;
        }
    }

    public void setItemViewCacheSize(int i3) {
        q1 q1Var = this.f2446b;
        q1Var.e = i3;
        q1Var.k();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z5) {
        suppressLayout(z5);
    }

    public void setLayoutManager(i1 i1Var) {
        RecyclerView recyclerView;
        r0 r0Var;
        if (i1Var == this.f2471m) {
            return;
        }
        setScrollState(0);
        y1 y1Var = this.f2453d0;
        y1Var.f2812g.removeCallbacks(y1Var);
        y1Var.f2809c.abortAnimation();
        i1 i1Var2 = this.f2471m;
        if (i1Var2 != null && (r0Var = i1Var2.e) != null) {
            r0Var.g();
        }
        i1 i1Var3 = this.f2471m;
        q1 q1Var = this.f2446b;
        if (i1Var3 != null) {
            f1 f1Var = this.L;
            if (f1Var != null) {
                f1Var.e();
            }
            this.f2471m.l0(q1Var);
            this.f2471m.m0(q1Var);
            q1Var.f2710a.clear();
            q1Var.d();
            if (this.r) {
                i1 i1Var4 = this.f2471m;
                i1Var4.f2590g = false;
                i1Var4.U(this);
            }
            this.f2471m.y0(null);
            this.f2471m = null;
        } else {
            q1Var.f2710a.clear();
            q1Var.d();
        }
        de.o oVar = this.e;
        ((e) oVar.f12378c).g();
        ArrayList arrayList = (ArrayList) oVar.f12379d;
        int size = arrayList.size() - 1;
        while (true) {
            recyclerView = ((x0) oVar.f12377b).f2801a;
            if (size < 0) {
                break;
            }
            z1 L = L((View) arrayList.get(size));
            if (L != null) {
                L.onLeftHiddenState(recyclerView);
            }
            arrayList.remove(size);
            size--;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.n(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.f2471m = i1Var;
        if (i1Var != null) {
            if (i1Var.f2586b != null) {
                throw new IllegalArgumentException("LayoutManager " + i1Var + " is already attached to a RecyclerView:" + i1Var.f2586b.y());
            }
            i1Var.y0(this);
            if (this.r) {
                this.f2471m.f2590g = true;
            }
        }
        q1Var.k();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z5) {
        getScrollingChildHelper().g(z5);
    }

    public void setOnFlingListener(l1 l1Var) {
        this.U = l1Var;
    }

    @Deprecated
    public void setOnScrollListener(n1 n1Var) {
        this.f2463h0 = n1Var;
    }

    public void setPreserveFocusAfterLayout(boolean z5) {
        this.f2450c0 = z5;
    }

    public void setRecycledViewPool(p1 p1Var) {
        q1 q1Var = this.f2446b;
        if (q1Var.f2715g != null) {
            r1.f2706b--;
        }
        q1Var.f2715g = p1Var;
        if (p1Var == null || q1Var.f2716h.getAdapter() == null) {
            return;
        }
        q1Var.f2715g.f2706b++;
    }

    @Deprecated
    public void setRecyclerListener(r1 r1Var) {
    }

    public void setScrollState(int i3) {
        r0 r0Var;
        if (i3 == this.M) {
            return;
        }
        this.M = i3;
        if (i3 != 2) {
            y1 y1Var = this.f2453d0;
            y1Var.f2812g.removeCallbacks(y1Var);
            y1Var.f2809c.abortAnimation();
            i1 i1Var = this.f2471m;
            if (i1Var != null && (r0Var = i1Var.e) != null) {
                r0Var.g();
            }
        }
        i1 i1Var2 = this.f2471m;
        if (i1Var2 != null) {
            i1Var2.j0(i3);
        }
        V(i3);
        n1 n1Var = this.f2463h0;
        if (n1Var != null) {
            n1Var.a(i3, this);
        }
        ArrayList arrayList = this.i0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((n1) this.i0.get(size)).a(i3, this);
            }
        }
    }

    public void setScrollingTouchSlop(int i3) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 != 0) {
            if (i3 == 1) {
                this.T = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i3 + "; using default value");
        }
        this.T = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(x1 x1Var) {
        this.f2446b.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i3) {
        return getScrollingChildHelper().h(i3, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().i(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z5) {
        r0 r0Var;
        if (z5 != this.f2480w) {
            h("Do not suppressLayout in layout or scroll");
            if (!z5) {
                this.f2480w = false;
                if (this.f2479v && this.f2471m != null && this.f2470l != null) {
                    requestLayout();
                }
                this.f2479v = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f2480w = true;
            this.f2481x = true;
            setScrollState(0);
            y1 y1Var = this.f2453d0;
            y1Var.f2812g.removeCallbacks(y1Var);
            y1Var.f2809c.abortAnimation();
            i1 i1Var = this.f2471m;
            if (i1Var == null || (r0Var = i1Var.e) == null) {
                return;
            }
            r0Var.g();
        }
    }

    public final void t(int i3, int i10) {
        this.F++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i3, scrollY - i10);
        W();
        n1 n1Var = this.f2463h0;
        if (n1Var != null) {
            n1Var.b(this, i3, i10);
        }
        ArrayList arrayList = this.i0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((n1) this.i0.get(size)).b(this, i3, i10);
            }
        }
        this.F--;
    }

    public final void u() {
        if (this.K != null) {
            return;
        }
        this.G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.K = edgeEffect;
        if (this.f2459g) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void v() {
        if (this.H != null) {
            return;
        }
        this.G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.H = edgeEffect;
        if (this.f2459g) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void w() {
        if (this.J != null) {
            return;
        }
        this.G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.J = edgeEffect;
        if (this.f2459g) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void x() {
        if (this.I != null) {
            return;
        }
        this.G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.I = edgeEffect;
        if (this.f2459g) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String y() {
        return " " + super.toString() + ", adapter:" + this.f2470l + ", layout:" + this.f2471m + ", context:" + getContext();
    }

    public final void z(w1 w1Var) {
        if (getScrollState() != 2) {
            w1Var.getClass();
            return;
        }
        OverScroller overScroller = this.f2453d0.f2809c;
        overScroller.getFinalX();
        overScroller.getCurrX();
        w1Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.recyclerViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    public RecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        boolean z5;
        char c9;
        TypedArray typedArray;
        ClassLoader classLoader;
        Constructor constructor;
        int i10 = 0;
        this.f2443a = new s1(this);
        this.f2446b = new q1(this);
        g2 g2Var = new g2();
        g2Var.f2570a = new m0.k();
        g2Var.f2571b = new m0.e();
        this.f2457f = g2Var;
        this.f2462h = new w0(i10, this);
        this.f2465i = new Rect();
        this.f2466j = new Rect();
        this.f2468k = new RectF();
        this.f2472n = new ArrayList();
        this.f2473o = new ArrayList();
        this.f2474p = new ArrayList();
        this.f2478u = 0;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = new d1();
        l lVar = new l();
        Object[] objArr = null;
        lVar.f2561a = null;
        lVar.f2562b = new ArrayList();
        lVar.f2563c = 120L;
        lVar.f2564d = 120L;
        lVar.e = 250L;
        lVar.f2565f = 250L;
        lVar.f2651g = true;
        lVar.f2652h = new ArrayList();
        lVar.f2653i = new ArrayList();
        lVar.f2654j = new ArrayList();
        lVar.f2655k = new ArrayList();
        lVar.f2656l = new ArrayList();
        lVar.f2657m = new ArrayList();
        lVar.f2658n = new ArrayList();
        lVar.f2659o = new ArrayList();
        lVar.f2660p = new ArrayList();
        lVar.f2661q = new ArrayList();
        lVar.r = new ArrayList();
        this.L = lVar;
        this.M = 0;
        this.N = -1;
        this.f2444a0 = Float.MIN_VALUE;
        this.f2447b0 = Float.MIN_VALUE;
        this.f2450c0 = true;
        this.f2453d0 = new y1(this);
        this.f2458f0 = new x(i10);
        w1 w1Var = new w1();
        w1Var.f2784a = -1;
        w1Var.f2785b = 0;
        w1Var.f2786c = 0;
        w1Var.f2787d = 1;
        w1Var.e = 0;
        w1Var.f2788f = false;
        w1Var.f2789g = false;
        w1Var.f2790h = false;
        w1Var.f2791i = false;
        w1Var.f2792j = false;
        w1Var.f2793k = false;
        this.f2460g0 = w1Var;
        this.f2467j0 = false;
        this.f2469k0 = false;
        x0 x0Var = new x0(this);
        this.U0 = x0Var;
        this.V0 = false;
        this.X0 = new int[2];
        this.Z0 = new int[2];
        this.f2445a1 = new int[2];
        this.f2448b1 = new int[2];
        this.f2451c1 = new ArrayList();
        this.f2454d1 = new w0(1, this);
        this.f1 = 0;
        this.f2461g1 = 0;
        this.f2464h1 = new x0(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.T = viewConfiguration.getScaledTouchSlop();
        this.f2444a0 = l1.a1.a(viewConfiguration);
        this.f2447b0 = l1.a1.b(viewConfiguration);
        this.V = viewConfiguration.getScaledMinimumFlingVelocity();
        this.W = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.L.f2561a = x0Var;
        this.f2452d = new androidx.appcompat.widget.w(new x0(this));
        this.e = new de.o(new x0(this));
        WeakHashMap weakHashMap = l1.z0.f15748a;
        if (l1.q0.b(this) == 0) {
            l1.q0.l(this, 8);
        }
        if (l1.h0.c(this) == 0) {
            l1.h0.s(this, 1);
        }
        this.A = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new b2(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i3, 0);
        l1.z0.m(this, context, R$styleable.RecyclerView, attributeSet, obtainStyledAttributes, i3);
        String string = obtainStyledAttributes.getString(R$styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f2459g = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        if (obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
                Resources resources = getContext().getResources();
                c9 = 2;
                z5 = 1;
                typedArray = obtainStyledAttributes;
                new w(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
            } else {
                throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + y());
            }
        } else {
            z5 = 1;
            c9 = 2;
            typedArray = obtainStyledAttributes;
        }
        typedArray.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                }
                String str = trim;
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class asSubclass = Class.forName(str, false, classLoader).asSubclass(i1.class);
                    try {
                        constructor = asSubclass.getConstructor(f2441j1);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = context;
                        objArr2[z5] = attributeSet;
                        objArr2[c9] = Integer.valueOf(i3);
                        objArr2[3] = 0;
                        objArr = objArr2;
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = asSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e10) {
                            e10.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e10);
                        }
                    }
                    constructor.setAccessible(z5);
                    setLayoutManager((i1) constructor.newInstance(objArr));
                } catch (ClassCastException e11) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e11);
                } catch (ClassNotFoundException e12) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e12);
                } catch (IllegalAccessException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e13);
                } catch (InstantiationException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e14);
                } catch (InvocationTargetException e15) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e15);
                }
            }
        }
        int[] iArr = f2440i1;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        l1.z0.m(this, context, iArr, attributeSet, obtainStyledAttributes2, i3);
        boolean z6 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z6);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        i1 i1Var = this.f2471m;
        if (i1Var != null) {
            return i1Var.t(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + y());
    }
}
