package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import androidx.recyclerview.widget.e1;
import androidx.swiperefreshlayout.R$styleable;
import java.util.WeakHashMap;
import l1.h0;
import l1.n0;
import l1.r;
import l1.s;
import l1.t;
import l1.u;
import l1.v;
import l1.z0;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements u, t, r, v {
    public static final int[] K = {R.attr.enabled};
    public g A;
    public g B;
    public h C;
    public h D;
    public boolean E;
    public int F;
    public boolean G;
    public final f H;
    public final g I;
    public final g J;

    /* renamed from: a, reason: collision with root package name */
    public View f2829a;

    /* renamed from: b, reason: collision with root package name */
    public j f2830b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2831c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2832d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f2833f;

    /* renamed from: g, reason: collision with root package name */
    public final e1 f2834g;

    /* renamed from: h, reason: collision with root package name */
    public final s f2835h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f2836i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f2837j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f2838k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2839l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2840m;

    /* renamed from: n, reason: collision with root package name */
    public int f2841n;

    /* renamed from: o, reason: collision with root package name */
    public float f2842o;

    /* renamed from: p, reason: collision with root package name */
    public float f2843p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2844q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public final DecelerateInterpolator f2845s;

    /* renamed from: t, reason: collision with root package name */
    public final a f2846t;

    /* renamed from: u, reason: collision with root package name */
    public int f2847u;

    /* renamed from: v, reason: collision with root package name */
    public int f2848v;

    /* renamed from: w, reason: collision with root package name */
    public final int f2849w;

    /* renamed from: x, reason: collision with root package name */
    public final int f2850x;

    /* renamed from: y, reason: collision with root package name */
    public int f2851y;

    /* renamed from: z, reason: collision with root package name */
    public final e f2852z;

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void setColorViewAlpha(int i3) {
        this.f2846t.getBackground().setAlpha(i3);
        this.f2852z.setAlpha(i3);
    }

    @Override // l1.t
    public final void a(View view, View view2, int i3, int i10) {
        if (i10 == 0) {
            onNestedScrollAccepted(view, view2, i3);
        }
    }

    @Override // l1.t
    public final void b(View view, int i3, int i10, int[] iArr, int i11) {
        if (i11 == 0) {
            onNestedPreScroll(view, i3, i10, iArr);
        }
    }

    public final boolean c() {
        View view = this.f2829a;
        return view instanceof ListView ? androidx.core.widget.i.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    public final void d() {
        if (this.f2829a == null) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (!childAt.equals(this.f2846t)) {
                    this.f2829a = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f10, boolean z5) {
        return this.f2835h.a(f2, f10, z5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f10) {
        return this.f2835h.b(f2, f10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i3, int i10, int[] iArr, int[] iArr2) {
        return this.f2835h.c(i3, i10, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i3, int i10, int i11, int i12, int[] iArr) {
        return this.f2835h.d(i3, i10, i11, i12, iArr, 0, null);
    }

    public final void e(float f2) {
        if (f2 > this.e) {
            m(true, true);
            return;
        }
        this.f2831c = false;
        e eVar = this.f2852z;
        d dVar = eVar.f2882a;
        dVar.e = 0.0f;
        dVar.f2864f = 0.0f;
        eVar.invalidateSelf();
        f fVar = new f(this, 1);
        this.f2848v = this.f2841n;
        g gVar = this.J;
        gVar.reset();
        gVar.setDuration(200L);
        gVar.setInterpolator(this.f2845s);
        a aVar = this.f2846t;
        aVar.f2854a = fVar;
        aVar.clearAnimation();
        this.f2846t.startAnimation(gVar);
        e eVar2 = this.f2852z;
        d dVar2 = eVar2.f2882a;
        if (dVar2.f2872n) {
            dVar2.f2872n = false;
        }
        eVar2.invalidateSelf();
    }

    @Override // l1.t
    public final void f(int i3, View view) {
        if (i3 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // l1.u
    public final void g(View view, int i3, int i10, int i11, int i12, int i13, int[] iArr) {
        if (i13 != 0) {
            return;
        }
        int i14 = iArr[1];
        if (i13 == 0) {
            this.f2835h.d(i3, i10, i11, i12, this.f2837j, i13, iArr);
        }
        int i15 = i12 - (iArr[1] - i14);
        if ((i15 == 0 ? i12 + this.f2837j[1] : i15) >= 0 || c()) {
            return;
        }
        float abs = this.f2833f + Math.abs(r14);
        this.f2833f = abs;
        h(abs);
        iArr[1] = iArr[1] + i15;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i3, int i10) {
        int i11 = this.f2847u;
        return i11 < 0 ? i10 : i10 == i3 + (-1) ? i11 : i10 >= i11 ? i10 + 1 : i10;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        e1 e1Var = this.f2834g;
        return e1Var.f2555c | e1Var.f2554b;
    }

    public int getProgressCircleDiameter() {
        return this.F;
    }

    public int getProgressViewEndOffset() {
        return this.f2850x;
    }

    public int getProgressViewStartOffset() {
        return this.f2849w;
    }

    public final void h(float f2) {
        h hVar;
        h hVar2;
        e eVar = this.f2852z;
        d dVar = eVar.f2882a;
        if (!dVar.f2872n) {
            dVar.f2872n = true;
        }
        eVar.invalidateSelf();
        float min = Math.min(1.0f, Math.abs(f2 / this.e));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.e;
        int i3 = this.f2851y;
        if (i3 <= 0) {
            i3 = this.f2850x;
        }
        float f10 = i3;
        double max2 = Math.max(0.0f, Math.min(abs, f10 * 2.0f) / f10) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i10 = this.f2849w + ((int) ((f10 * min) + (f10 * pow * 2.0f)));
        if (this.f2846t.getVisibility() != 0) {
            this.f2846t.setVisibility(0);
        }
        this.f2846t.setScaleX(1.0f);
        this.f2846t.setScaleY(1.0f);
        if (f2 < this.e) {
            if (this.f2852z.f2882a.f2877t > 76 && ((hVar2 = this.C) == null || !hVar2.hasStarted() || hVar2.hasEnded())) {
                h hVar3 = new h(this, this.f2852z.f2882a.f2877t, 76);
                hVar3.setDuration(300L);
                a aVar = this.f2846t;
                aVar.f2854a = null;
                aVar.clearAnimation();
                this.f2846t.startAnimation(hVar3);
                this.C = hVar3;
            }
        } else if (this.f2852z.f2882a.f2877t < 255 && ((hVar = this.D) == null || !hVar.hasStarted() || hVar.hasEnded())) {
            h hVar4 = new h(this, this.f2852z.f2882a.f2877t, 255);
            hVar4.setDuration(300L);
            a aVar2 = this.f2846t;
            aVar2.f2854a = null;
            aVar2.clearAnimation();
            this.f2846t.startAnimation(hVar4);
            this.D = hVar4;
        }
        e eVar2 = this.f2852z;
        float min2 = Math.min(0.8f, max * 0.8f);
        d dVar2 = eVar2.f2882a;
        dVar2.e = 0.0f;
        dVar2.f2864f = min2;
        eVar2.invalidateSelf();
        e eVar3 = this.f2852z;
        float min3 = Math.min(1.0f, max);
        d dVar3 = eVar3.f2882a;
        if (min3 != dVar3.f2874p) {
            dVar3.f2874p = min3;
        }
        eVar3.invalidateSelf();
        e eVar4 = this.f2852z;
        eVar4.f2882a.f2865g = ((pow * 2.0f) + ((max * 0.4f) - 0.25f)) * 0.5f;
        eVar4.invalidateSelf();
        setTargetOffsetTopAndBottom(i10 - this.f2841n);
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f2835h.f(0);
    }

    @Override // l1.t
    public final void i(View view, int i3, int i10, int i11, int i12, int i13) {
        g(view, i3, i10, i11, i12, i13, this.f2838k);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f2835h.f15729d;
    }

    @Override // l1.t
    public final boolean j(View view, View view2, int i3, int i10) {
        if (i10 == 0) {
            return onStartNestedScroll(view, view2, i3);
        }
        return false;
    }

    public final void k(float f2) {
        setTargetOffsetTopAndBottom((this.f2848v + ((int) ((this.f2849w - r0) * f2))) - this.f2846t.getTop());
    }

    public final void l() {
        this.f2846t.clearAnimation();
        this.f2852z.stop();
        this.f2846t.setVisibility(8);
        setColorViewAlpha(255);
        setTargetOffsetTopAndBottom(this.f2849w - this.f2841n);
        this.f2841n = this.f2846t.getTop();
    }

    public final void m(boolean z5, boolean z6) {
        if (this.f2831c != z5) {
            this.E = z6;
            d();
            this.f2831c = z5;
            f fVar = this.H;
            if (!z5) {
                g gVar = new g(this, 1);
                this.B = gVar;
                gVar.setDuration(150L);
                a aVar = this.f2846t;
                aVar.f2854a = fVar;
                aVar.clearAnimation();
                this.f2846t.startAnimation(this.B);
                return;
            }
            this.f2848v = this.f2841n;
            g gVar2 = this.I;
            gVar2.reset();
            gVar2.setDuration(200L);
            gVar2.setInterpolator(this.f2845s);
            if (fVar != null) {
                this.f2846t.f2854a = fVar;
            }
            this.f2846t.clearAnimation();
            this.f2846t.startAnimation(gVar2);
        }
    }

    public final void n(float f2) {
        float f10 = this.f2843p;
        float f11 = f2 - f10;
        float f12 = this.f2832d;
        if (f11 <= f12 || this.f2844q) {
            return;
        }
        this.f2842o = f10 + f12;
        this.f2844q = true;
        this.f2852z.setAlpha(76);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d();
        int actionMasked = motionEvent.getActionMasked();
        if (isEnabled() && !c() && !this.f2831c && !this.f2839l) {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i3 = this.r;
                        if (i3 == -1) {
                            Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        }
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex >= 0) {
                            n(motionEvent.getY(findPointerIndex));
                        }
                    } else if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionIndex) == this.r) {
                                this.r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                            }
                        }
                    }
                    return this.f2844q;
                }
                this.f2844q = false;
                this.r = -1;
                return this.f2844q;
            }
            setTargetOffsetTopAndBottom(this.f2849w - this.f2846t.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.r = pointerId;
            this.f2844q = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 >= 0) {
                this.f2843p = motionEvent.getY(findPointerIndex2);
                return this.f2844q;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f2829a == null) {
            d();
        }
        View view = this.f2829a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f2846t.getMeasuredWidth();
        int measuredHeight2 = this.f2846t.getMeasuredHeight();
        int i13 = measuredWidth / 2;
        int i14 = measuredWidth2 / 2;
        int i15 = this.f2841n;
        this.f2846t.layout(i13 - i14, i15, i13 + i14, measuredHeight2 + i15);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        if (this.f2829a == null) {
            d();
        }
        View view = this.f2829a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f2846t.measure(View.MeasureSpec.makeMeasureSpec(this.F, 1073741824), View.MeasureSpec.makeMeasureSpec(this.F, 1073741824));
        this.f2847u = -1;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == this.f2846t) {
                this.f2847u = i11;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f10, boolean z5) {
        return this.f2835h.a(f2, f10, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f10) {
        return this.f2835h.b(f2, f10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i3, int i10, int[] iArr) {
        if (i10 > 0) {
            float f2 = this.f2833f;
            if (f2 > 0.0f) {
                float f10 = i10;
                if (f10 > f2) {
                    iArr[1] = (int) f2;
                    this.f2833f = 0.0f;
                } else {
                    this.f2833f = f2 - f10;
                    iArr[1] = i10;
                }
                h(this.f2833f);
            }
        }
        int i11 = i3 - iArr[0];
        int i12 = i10 - iArr[1];
        int[] iArr2 = this.f2836i;
        if (dispatchNestedPreScroll(i11, i12, iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i3, int i10, int i11, int i12) {
        g(view, i3, i10, i11, i12, 0, this.f2838k);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i3) {
        this.f2834g.f2554b = i3;
        startNestedScroll(i3 & 2);
        this.f2833f = 0.0f;
        this.f2839l = true;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f2853a);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f2831c);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i3) {
        return (!isEnabled() || this.f2831c || (i3 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        this.f2834g.f2554b = 0;
        this.f2839l = false;
        float f2 = this.f2833f;
        if (f2 > 0.0f) {
            e(f2);
            this.f2833f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (isEnabled() && !c() && !this.f2831c && !this.f2839l) {
            if (actionMasked == 0) {
                this.r = motionEvent.getPointerId(0);
                this.f2844q = false;
                return true;
            }
            if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.r);
                if (findPointerIndex < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f2844q) {
                    float y4 = (motionEvent.getY(findPointerIndex) - this.f2842o) * 0.5f;
                    this.f2844q = false;
                    e(y4);
                }
                this.r = -1;
                return false;
            }
            if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.r);
                if (findPointerIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y10 = motionEvent.getY(findPointerIndex2);
                n(y10);
                if (this.f2844q) {
                    float f2 = (y10 - this.f2842o) * 0.5f;
                    if (f2 > 0.0f) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        h(f2);
                    }
                }
                return true;
            }
            if (actionMasked != 3) {
                if (actionMasked != 5) {
                    if (actionMasked == 6) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex) == this.r) {
                            this.r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                            return true;
                        }
                    }
                    return true;
                }
                int actionIndex2 = motionEvent.getActionIndex();
                if (actionIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.r = motionEvent.getPointerId(actionIndex2);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z5) {
        ViewParent parent;
        View view = this.f2829a;
        if (view != null) {
            WeakHashMap weakHashMap = z0.f15748a;
            if (!n0.p(view)) {
                if (this.G || (parent = getParent()) == null) {
                    return;
                }
                parent.requestDisallowInterceptTouchEvent(z5);
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    public void setAnimationProgress(float f2) {
        this.f2846t.setScaleX(f2);
        this.f2846t.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        d();
        e eVar = this.f2852z;
        d dVar = eVar.f2882a;
        dVar.f2867i = iArr;
        dVar.a(0);
        dVar.a(0);
        eVar.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr2[i3] = a1.d.a(context, iArr[i3]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i3) {
        this.e = i3;
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        if (z5) {
            return;
        }
        l();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z5) {
        this.G = z5;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z5) {
        this.f2835h.g(z5);
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
        this.f2830b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i3) {
        setProgressBackgroundColorSchemeResource(i3);
    }

    public void setProgressBackgroundColorSchemeColor(int i3) {
        this.f2846t.setBackgroundColor(i3);
    }

    public void setProgressBackgroundColorSchemeResource(int i3) {
        setProgressBackgroundColorSchemeColor(a1.d.a(getContext(), i3));
    }

    public void setRefreshing(boolean z5) {
        if (!z5 || this.f2831c == z5) {
            m(z5, false);
            return;
        }
        this.f2831c = z5;
        setTargetOffsetTopAndBottom((this.f2850x + this.f2849w) - this.f2841n);
        this.E = false;
        f fVar = this.H;
        this.f2846t.setVisibility(0);
        this.f2852z.setAlpha(255);
        g gVar = new g(this, 0);
        this.A = gVar;
        gVar.setDuration(this.f2840m);
        if (fVar != null) {
            this.f2846t.f2854a = fVar;
        }
        this.f2846t.clearAnimation();
        this.f2846t.startAnimation(this.A);
    }

    public void setSize(int i3) {
        if (i3 == 0 || i3 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i3 == 0) {
                this.F = (int) (displayMetrics.density * 56.0f);
            } else {
                this.F = (int) (displayMetrics.density * 40.0f);
            }
            this.f2846t.setImageDrawable(null);
            this.f2852z.c(i3);
            this.f2846t.setImageDrawable(this.f2852z);
        }
    }

    public void setSlingshotDistance(int i3) {
        this.f2851y = i3;
    }

    public void setTargetOffsetTopAndBottom(int i3) {
        a aVar = this.f2846t;
        aVar.bringToFront();
        WeakHashMap weakHashMap = z0.f15748a;
        aVar.offsetTopAndBottom(i3);
        this.f2841n = aVar.getTop();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i3) {
        return this.f2835h.h(i3, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.f2835h.i(0);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new k();

        /* renamed from: a, reason: collision with root package name */
        public final boolean f2853a;

        public SavedState(Parcelable parcelable, boolean z5) {
            super(parcelable);
            this.f2853a = z5;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeByte(this.f2853a ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2853a = parcel.readByte() != 0;
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2831c = false;
        this.e = -1.0f;
        this.f2836i = new int[2];
        this.f2837j = new int[2];
        this.f2838k = new int[2];
        this.r = -1;
        this.f2847u = -1;
        this.H = new f(this, 0);
        this.I = new g(this, 2);
        this.J = new g(this, 3);
        this.f2832d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f2840m = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f2845s = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.F = (int) (displayMetrics.density * 40.0f);
        a aVar = new a(getContext());
        float f2 = aVar.getContext().getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = aVar.getContext().obtainStyledAttributes(R$styleable.SwipeRefreshLayout);
        aVar.f2855b = obtainStyledAttributes.getColor(R$styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        obtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        WeakHashMap weakHashMap = z0.f15748a;
        n0.s(aVar, f2 * 4.0f);
        shapeDrawable.getPaint().setColor(aVar.f2855b);
        h0.q(aVar, shapeDrawable);
        this.f2846t = aVar;
        e eVar = new e(getContext());
        this.f2852z = eVar;
        eVar.c(1);
        this.f2846t.setImageDrawable(this.f2852z);
        this.f2846t.setVisibility(8);
        addView(this.f2846t);
        setChildrenDrawingOrderEnabled(true);
        int i3 = (int) (displayMetrics.density * 64.0f);
        this.f2850x = i3;
        this.e = i3;
        this.f2834g = new e1(3);
        this.f2835h = new s(this);
        setNestedScrollingEnabled(true);
        int i10 = -this.F;
        this.f2841n = i10;
        this.f2849w = i10;
        k(1.0f);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, K);
        setEnabled(obtainStyledAttributes2.getBoolean(0, true));
        obtainStyledAttributes2.recycle();
    }
}
