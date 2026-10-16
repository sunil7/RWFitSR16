package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.utils.s0;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.bottomappbar.e;
import com.google.android.material.internal.t;
import eb.h;
import eb.m;
import ia.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import l1.h0;
import l1.k0;
import l1.n0;
import l1.z0;
import oa.b;
import p1.d;
import x0.c;
import x0.f;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends c {
    public static final int X = R$style.Widget_Design_BottomSheet_Modal;
    public int A;
    public final float B;
    public boolean C;
    public boolean D;
    public final boolean E;
    public int F;
    public d G;
    public boolean H;
    public int I;
    public boolean J;
    public int K;
    public int L;
    public int M;
    public WeakReference N;
    public WeakReference O;
    public final ArrayList P;
    public VelocityTracker Q;
    public int R;
    public int S;
    public boolean T;
    public HashMap U;
    public int V;
    public final oa.a W;

    /* renamed from: a, reason: collision with root package name */
    public final int f10272a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10273b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10274c;

    /* renamed from: d, reason: collision with root package name */
    public int f10275d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public int f10276f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10277g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10278h;

    /* renamed from: i, reason: collision with root package name */
    public h f10279i;

    /* renamed from: j, reason: collision with root package name */
    public final int f10280j;

    /* renamed from: k, reason: collision with root package name */
    public int f10281k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f10282l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f10283m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f10284n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f10285o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f10286p;

    /* renamed from: q, reason: collision with root package name */
    public int f10287q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public m f10288s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10289t;

    /* renamed from: u, reason: collision with root package name */
    public e f10290u;

    /* renamed from: v, reason: collision with root package name */
    public final ValueAnimator f10291v;

    /* renamed from: w, reason: collision with root package name */
    public final int f10292w;

    /* renamed from: x, reason: collision with root package name */
    public int f10293x;

    /* renamed from: y, reason: collision with root package name */
    public int f10294y;

    /* renamed from: z, reason: collision with root package name */
    public final float f10295z;

    public BottomSheetBehavior() {
        this.f10272a = 0;
        this.f10273b = true;
        this.f10280j = -1;
        this.f10290u = null;
        this.f10295z = 0.5f;
        this.B = -1.0f;
        this.E = true;
        this.F = 4;
        this.P = new ArrayList();
        this.V = -1;
        this.W = new oa.a(this);
    }

    public static View w(View view) {
        WeakHashMap weakHashMap = z0.f15748a;
        if (n0.p(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View w8 = w(viewGroup.getChildAt(i3));
            if (w8 != null) {
                return w8;
            }
        }
        return null;
    }

    public static BottomSheetBehavior x(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        c cVar = ((f) layoutParams).f19716a;
        if (cVar instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) cVar;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    public final void A(int i3) {
        if (i3 == -1) {
            if (this.e) {
                return;
            } else {
                this.e = true;
            }
        } else {
            if (!this.e && this.f10275d == i3) {
                return;
            }
            this.e = false;
            this.f10275d = Math.max(0, i3);
        }
        J();
    }

    public final void B(int i3) {
        if (i3 == this.F) {
            return;
        }
        if (this.N == null) {
            if (i3 == 4 || i3 == 3 || i3 == 6 || (this.C && i3 == 5)) {
                this.F = i3;
                return;
            }
            return;
        }
        View view = (View) this.N.get();
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = z0.f15748a;
            if (k0.b(view)) {
                view.post(new androidx.activity.f(this, view, i3, 4, false));
                return;
            }
        }
        D(i3, view);
    }

    public final void C(int i3) {
        View view;
        if (this.F == i3) {
            return;
        }
        this.F = i3;
        WeakReference weakReference = this.N;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i10 = 0;
        if (i3 == 3) {
            I(true);
        } else if (i3 == 6 || i3 == 5 || i3 == 4) {
            I(false);
        }
        H(i3);
        while (true) {
            ArrayList arrayList = this.P;
            if (i10 >= arrayList.size()) {
                G();
                return;
            } else {
                ((b) arrayList.get(i10)).b(i3, view);
                i10++;
            }
        }
    }

    public final void D(int i3, View view) {
        int i10;
        int i11;
        if (i3 == 4) {
            i10 = this.A;
        } else if (i3 == 6) {
            i10 = this.f10294y;
            if (this.f10273b && i10 <= (i11 = this.f10293x)) {
                i3 = 3;
                i10 = i11;
            }
        } else if (i3 == 3) {
            i10 = y();
        } else {
            if (!this.C || i3 != 5) {
                throw new IllegalArgumentException(l0.j(i3, "Illegal state argument: "));
            }
            i10 = this.M;
        }
        F(view, i3, i10, false);
    }

    public final boolean E(View view, float f2) {
        if (this.D) {
            return true;
        }
        if (view.getTop() < this.A) {
            return false;
        }
        return Math.abs(((f2 * 0.1f) + ((float) view.getTop())) - ((float) this.A)) / ((float) t()) > 0.5f;
    }

    public final void F(View view, int i3, int i10, boolean z5) {
        d dVar = this.G;
        if (dVar == null || (!z5 ? dVar.s(view, view.getLeft(), i10) : dVar.q(view.getLeft(), i10))) {
            C(i3);
            return;
        }
        C(2);
        H(i3);
        if (this.f10290u == null) {
            this.f10290u = new e(this, view, i3);
        }
        e eVar = this.f10290u;
        if (eVar.f10258b) {
            eVar.f10259c = i3;
            return;
        }
        eVar.f10259c = i3;
        WeakHashMap weakHashMap = z0.f15748a;
        h0.m(view, eVar);
        this.f10290u.f10258b = true;
    }

    public final void G() {
        View view;
        int i3;
        WeakReference weakReference = this.N;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        z0.k(524288, view);
        z0.g(0, view);
        z0.k(262144, view);
        z0.g(0, view);
        z0.k(Const.I_MAX_OFFLINE_DATA_CACHE, view);
        z0.g(0, view);
        int i10 = this.V;
        if (i10 != -1) {
            z0.k(i10, view);
            z0.g(0, view);
        }
        if (!this.f10273b && this.F != 6) {
            String string = view.getResources().getString(R$string.bottomsheet_action_expand_halfway);
            d6.a aVar = new d6.a(this, 6);
            ArrayList e = z0.e(view);
            int i11 = 0;
            while (true) {
                if (i11 >= e.size()) {
                    int i12 = 0;
                    int i13 = -1;
                    while (true) {
                        int[] iArr = z0.f15751d;
                        if (i12 >= iArr.length || i13 != -1) {
                            break;
                        }
                        int i14 = iArr[i12];
                        boolean z5 = true;
                        for (int i15 = 0; i15 < e.size(); i15++) {
                            z5 &= ((m1.c) e.get(i15)).a() != i14;
                        }
                        if (z5) {
                            i13 = i14;
                        }
                        i12++;
                    }
                    i3 = i13;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((m1.c) e.get(i11)).f15934a).getLabel())) {
                        i3 = ((m1.c) e.get(i11)).a();
                        break;
                    }
                    i11++;
                }
            }
            if (i3 != -1) {
                m1.c cVar = new m1.c(null, i3, string, aVar, null);
                View.AccessibilityDelegate d5 = z0.d(view);
                l1.c cVar2 = d5 == null ? null : d5 instanceof l1.a ? ((l1.a) d5).f15676a : new l1.c(d5);
                if (cVar2 == null) {
                    cVar2 = new l1.c();
                }
                z0.n(view, cVar2);
                z0.k(cVar.a(), view);
                z0.e(view).add(cVar);
                z0.g(0, view);
            }
            this.V = i3;
        }
        if (this.C && this.F != 5) {
            z0.l(view, m1.c.f15930l, new d6.a(this, 5));
        }
        int i16 = this.F;
        if (i16 == 3) {
            z0.l(view, m1.c.f15929k, new d6.a(this, this.f10273b ? 4 : 6));
            return;
        }
        if (i16 == 4) {
            z0.l(view, m1.c.f15928j, new d6.a(this, this.f10273b ? 3 : 6));
        } else {
            if (i16 != 6) {
                return;
            }
            z0.l(view, m1.c.f15929k, new d6.a(this, 4));
            z0.l(view, m1.c.f15928j, new d6.a(this, 3));
        }
    }

    public final void H(int i3) {
        ValueAnimator valueAnimator = this.f10291v;
        if (i3 == 2) {
            return;
        }
        boolean z5 = i3 == 3;
        if (this.f10289t != z5) {
            this.f10289t = z5;
            if (this.f10279i == null || valueAnimator == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            }
            float f2 = z5 ? 0.0f : 1.0f;
            valueAnimator.setFloatValues(1.0f - f2, f2);
            valueAnimator.start();
        }
    }

    public final void I(boolean z5) {
        WeakReference weakReference = this.N;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z5) {
                if (this.U != null) {
                    return;
                } else {
                    this.U = new HashMap(childCount);
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if (childAt != this.N.get() && z5) {
                    this.U.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z5) {
                return;
            }
            this.U = null;
        }
    }

    public final void J() {
        View view;
        if (this.N != null) {
            s();
            if (this.F != 4 || (view = (View) this.N.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // x0.c
    public final void c(f fVar) {
        this.N = null;
        this.G = null;
    }

    @Override // x0.c
    public final void f() {
        this.N = null;
        this.G = null;
    }

    @Override // x0.c
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        d dVar;
        if (!view.isShown() || !this.E) {
            this.H = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.R = -1;
            VelocityTracker velocityTracker = this.Q;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Q = null;
            }
        }
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        this.Q.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.S = (int) motionEvent.getY();
            if (this.F != 2) {
                WeakReference weakReference = this.O;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.t(view2, x10, this.S)) {
                    this.R = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.T = true;
                }
            }
            this.H = this.R == -1 && !coordinatorLayout.t(view, x10, this.S);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.T = false;
            this.R = -1;
            if (this.H) {
                this.H = false;
                return false;
            }
        }
        if (this.H || (dVar = this.G) == null || !dVar.r(motionEvent)) {
            WeakReference weakReference2 = this.O;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.H || this.F == 1 || coordinatorLayout.t(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.G == null || Math.abs(this.S - motionEvent.getY()) <= this.G.f17370b) {
                return false;
            }
        }
        return true;
    }

    @Override // x0.c
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i3) {
        h hVar;
        int i10 = this.f10280j;
        boolean z5 = false;
        WeakHashMap weakHashMap = z0.f15748a;
        if (h0.b(coordinatorLayout) && !h0.b(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.N == null) {
            this.f10276f = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            boolean z6 = (Build.VERSION.SDK_INT < 29 || this.f10282l || this.e) ? false : true;
            if (this.f10283m || this.f10284n || this.f10285o || z6) {
                gb.a(view, new s0(this, z6));
            }
            this.N = new WeakReference(view);
            if (this.f10278h && (hVar = this.f10279i) != null) {
                h0.q(view, hVar);
            }
            h hVar2 = this.f10279i;
            if (hVar2 != null) {
                float f2 = this.B;
                if (f2 == -1.0f) {
                    f2 = n0.i(view);
                }
                hVar2.k(f2);
                boolean z8 = this.F == 3;
                this.f10289t = z8;
                this.f10279i.m(z8 ? 0.0f : 1.0f);
            }
            G();
            if (h0.c(view) == 0) {
                h0.s(view, 1);
            }
            if (view.getMeasuredWidth() > i10 && i10 != -1) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = i10;
                view.post(new j(view, 12, layoutParams, z5));
            }
        }
        if (this.G == null) {
            this.G = new d(coordinatorLayout.getContext(), coordinatorLayout, this.W);
        }
        int top = view.getTop();
        coordinatorLayout.v(i3, view);
        this.L = coordinatorLayout.getWidth();
        this.M = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.K = height;
        int i11 = this.M;
        int i12 = i11 - height;
        int i13 = this.r;
        if (i12 < i13) {
            if (this.f10286p) {
                this.K = i11;
            } else {
                this.K = i11 - i13;
            }
        }
        this.f10293x = Math.max(0, i11 - this.K);
        this.f10294y = (int) ((1.0f - this.f10295z) * this.M);
        s();
        int i14 = this.F;
        if (i14 == 3) {
            view.offsetTopAndBottom(y());
        } else if (i14 == 6) {
            view.offsetTopAndBottom(this.f10294y);
        } else if (this.C && i14 == 5) {
            view.offsetTopAndBottom(this.M);
        } else if (i14 == 4) {
            view.offsetTopAndBottom(this.A);
        } else if (i14 == 1 || i14 == 2) {
            view.offsetTopAndBottom(top - view.getTop());
        }
        this.O = new WeakReference(w(view));
        return true;
    }

    @Override // x0.c
    public final boolean j(View view) {
        WeakReference weakReference = this.O;
        return (weakReference == null || view != weakReference.get() || this.F == 3) ? false : true;
    }

    @Override // x0.c
    public final void k(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i10, int[] iArr, int i11) {
        boolean z5 = this.E;
        if (i11 == 1) {
            return;
        }
        WeakReference weakReference = this.O;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i12 = top - i10;
        if (i10 > 0) {
            if (i12 < y()) {
                int y4 = top - y();
                iArr[1] = y4;
                WeakHashMap weakHashMap = z0.f15748a;
                view.offsetTopAndBottom(-y4);
                C(3);
            } else {
                if (!z5) {
                    return;
                }
                iArr[1] = i10;
                WeakHashMap weakHashMap2 = z0.f15748a;
                view.offsetTopAndBottom(-i10);
                C(1);
            }
        } else if (i10 < 0 && !view2.canScrollVertically(-1)) {
            int i13 = this.A;
            if (i12 > i13 && !this.C) {
                int i14 = top - i13;
                iArr[1] = i14;
                WeakHashMap weakHashMap3 = z0.f15748a;
                view.offsetTopAndBottom(-i14);
                C(4);
            } else {
                if (!z5) {
                    return;
                }
                iArr[1] = i10;
                WeakHashMap weakHashMap4 = z0.f15748a;
                view.offsetTopAndBottom(-i10);
                C(1);
            }
        }
        v(view.getTop());
        this.I = i10;
        this.J = true;
    }

    @Override // x0.c
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i3, int i10, int i11, int[] iArr) {
    }

    @Override // x0.c
    public final void n(View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int i3 = this.f10272a;
        if (i3 != 0) {
            if (i3 == -1 || (i3 & 1) == 1) {
                this.f10275d = savedState.f10297b;
            }
            if (i3 == -1 || (i3 & 2) == 2) {
                this.f10273b = savedState.f10298c;
            }
            if (i3 == -1 || (i3 & 4) == 4) {
                this.C = savedState.f10299d;
            }
            if (i3 == -1 || (i3 & 8) == 8) {
                this.D = savedState.e;
            }
        }
        int i10 = savedState.f10296a;
        if (i10 == 1 || i10 == 2) {
            this.F = 4;
        } else {
            this.F = i10;
        }
    }

    @Override // x0.c
    public final Parcelable o(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new SavedState(this);
    }

    @Override // x0.c
    public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i10) {
        this.I = 0;
        this.J = false;
        return (i3 & 2) != 0;
    }

    @Override // x0.c
    public final void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i3) {
        int i10;
        float yVelocity;
        int i11 = 3;
        if (view.getTop() == y()) {
            C(3);
            return;
        }
        WeakReference weakReference = this.O;
        if (weakReference != null && view2 == weakReference.get() && this.J) {
            if (this.I <= 0) {
                if (this.C) {
                    VelocityTracker velocityTracker = this.Q;
                    if (velocityTracker == null) {
                        yVelocity = 0.0f;
                    } else {
                        velocityTracker.computeCurrentVelocity(1000, this.f10274c);
                        yVelocity = this.Q.getYVelocity(this.R);
                    }
                    if (E(view, yVelocity)) {
                        i10 = this.M;
                        i11 = 5;
                    }
                }
                if (this.I == 0) {
                    int top = view.getTop();
                    if (!this.f10273b) {
                        int i12 = this.f10294y;
                        if (top < i12) {
                            if (top < Math.abs(top - this.A)) {
                                i10 = y();
                            } else {
                                i10 = this.f10294y;
                            }
                        } else if (Math.abs(top - i12) < Math.abs(top - this.A)) {
                            i10 = this.f10294y;
                        } else {
                            i10 = this.A;
                            i11 = 4;
                        }
                        i11 = 6;
                    } else if (Math.abs(top - this.f10293x) < Math.abs(top - this.A)) {
                        i10 = this.f10293x;
                    } else {
                        i10 = this.A;
                        i11 = 4;
                    }
                } else {
                    if (this.f10273b) {
                        i10 = this.A;
                    } else {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - this.f10294y) < Math.abs(top2 - this.A)) {
                            i10 = this.f10294y;
                            i11 = 6;
                        } else {
                            i10 = this.A;
                        }
                    }
                    i11 = 4;
                }
            } else if (this.f10273b) {
                i10 = this.f10293x;
            } else {
                int top3 = view.getTop();
                int i13 = this.f10294y;
                if (top3 > i13) {
                    i11 = 6;
                    i10 = i13;
                } else {
                    i10 = y();
                }
            }
            F(view, i11, i10, false);
            this.J = false;
        }
    }

    @Override // x0.c
    public final boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.F == 1 && actionMasked == 0) {
            return true;
        }
        d dVar = this.G;
        if (dVar != null) {
            dVar.k(motionEvent);
        }
        if (actionMasked == 0) {
            this.R = -1;
            VelocityTracker velocityTracker = this.Q;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Q = null;
            }
        }
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        this.Q.addMovement(motionEvent);
        if (this.G != null && actionMasked == 2 && !this.H) {
            float abs = Math.abs(this.S - motionEvent.getY());
            d dVar2 = this.G;
            if (abs > dVar2.f17370b) {
                dVar2.b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.H;
    }

    public final void s() {
        int t8 = t();
        if (this.f10273b) {
            this.A = Math.max(this.M - t8, this.f10293x);
        } else {
            this.A = this.M - t8;
        }
    }

    public final int t() {
        int i3;
        return this.e ? Math.min(Math.max(this.f10276f, this.M - ((this.L * 9) / 16)), this.K) + this.f10287q : (this.f10282l || this.f10283m || (i3 = this.f10281k) <= 0) ? this.f10275d + this.f10287q : Math.max(this.f10275d, i3 + this.f10277g);
    }

    public final void u(Context context, AttributeSet attributeSet, boolean z5, ColorStateList colorStateList) {
        if (this.f10278h) {
            this.f10288s = m.b(context, attributeSet, R$attr.bottomSheetStyle, X).a();
            h hVar = new h(this.f10288s);
            this.f10279i = hVar;
            hVar.j(context);
            if (z5 && colorStateList != null) {
                this.f10279i.l(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.f10279i.setTint(typedValue.data);
        }
    }

    public final void v(int i3) {
        View view = (View) this.N.get();
        if (view != null) {
            ArrayList arrayList = this.P;
            if (arrayList.isEmpty()) {
                return;
            }
            int i10 = this.A;
            if (i3 <= i10 && i10 != y()) {
                y();
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                ((b) arrayList.get(i11)).a(view);
            }
        }
    }

    public final int y() {
        if (this.f10273b) {
            return this.f10293x;
        }
        return Math.max(this.f10292w, this.f10286p ? 0 : this.r);
    }

    public final void z(boolean z5) {
        if (this.C != z5) {
            this.C = z5;
            if (!z5 && this.F == 5) {
                B(4);
            }
            G();
        }
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final int f10296a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10297b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10298c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f10299d;
        public final boolean e;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10296a = parcel.readInt();
            this.f10297b = parcel.readInt();
            this.f10298c = parcel.readInt() == 1;
            this.f10299d = parcel.readInt() == 1;
            this.e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f10296a);
            parcel.writeInt(this.f10297b);
            parcel.writeInt(this.f10298c ? 1 : 0);
            parcel.writeInt(this.f10299d ? 1 : 0);
            parcel.writeInt(this.e ? 1 : 0);
        }

        public SavedState(BottomSheetBehavior bottomSheetBehavior) {
            super(AbsSavedState.EMPTY_STATE);
            this.f10296a = bottomSheetBehavior.F;
            this.f10297b = bottomSheetBehavior.f10275d;
            this.f10298c = bottomSheetBehavior.f10273b;
            this.f10299d = bottomSheetBehavior.C;
            this.e = bottomSheetBehavior.D;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i3;
        this.f10272a = 0;
        this.f10273b = true;
        this.f10280j = -1;
        this.f10290u = null;
        this.f10295z = 0.5f;
        this.B = -1.0f;
        this.E = true;
        this.F = 4;
        this.P = new ArrayList();
        this.V = -1;
        this.W = new oa.a(this);
        this.f10277g = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        this.f10278h = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            u(context, attributeSet, hasValue, t0.a(context, obtainStyledAttributes, R$styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            u(context, attributeSet, hasValue, null);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f10291v = ofFloat;
        ofFloat.setDuration(500L);
        this.f10291v.addUpdateListener(new t(this, 10));
        this.B = obtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            this.f10280j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_android_maxWidth, -1);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && (i3 = peekValue.data) == -1) {
            A(i3);
        } else {
            A(obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        z(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        this.f10282l = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z5 = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.f10273b != z5) {
            this.f10273b = z5;
            if (this.N != null) {
                s();
            }
            C((this.f10273b && this.F == 6) ? 3 : this.F);
            G();
        }
        this.D = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.E = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.f10272a = obtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f2 = obtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f10295z = f2;
            if (this.N != null) {
                this.f10294y = (int) ((1.0f - f2) * this.M);
            }
            TypedValue peekValue2 = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
            if (peekValue2 != null && peekValue2.type == 16) {
                int i10 = peekValue2.data;
                if (i10 >= 0) {
                    this.f10292w = i10;
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0);
                if (dimensionPixelOffset >= 0) {
                    this.f10292w = dimensionPixelOffset;
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f10283m = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
            this.f10284n = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
            this.f10285o = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
            this.f10286p = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
            obtainStyledAttributes.recycle();
            this.f10274c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}
