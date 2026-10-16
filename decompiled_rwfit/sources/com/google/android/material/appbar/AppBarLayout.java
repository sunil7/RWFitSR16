package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.gms.internal.mlkit_vision_barcode.xb;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.t;
import eb.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import ka.e;
import ka.f;
import ka.i;
import l1.h0;
import l1.i0;
import l1.k0;
import l1.r;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements x0.b {

    /* renamed from: q, reason: collision with root package name */
    public static final int f10165q = R$style.Widget_Design_AppBarLayout;

    /* renamed from: a, reason: collision with root package name */
    public int f10166a;

    /* renamed from: b, reason: collision with root package name */
    public int f10167b;

    /* renamed from: c, reason: collision with root package name */
    public int f10168c;

    /* renamed from: d, reason: collision with root package name */
    public int f10169d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public int f10170f;

    /* renamed from: g, reason: collision with root package name */
    public x1 f10171g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f10172h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10173i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10174j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10175k;

    /* renamed from: l, reason: collision with root package name */
    public int f10176l;

    /* renamed from: m, reason: collision with root package name */
    public WeakReference f10177m;

    /* renamed from: n, reason: collision with root package name */
    public ValueAnimator f10178n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f10179o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f10180p;

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends f {
        public ScrollingViewBehavior() {
        }

        public static AppBarLayout v(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) arrayList.get(i3);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // x0.c
        public final boolean b(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // x0.c
        public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            x0.c cVar = ((x0.f) view2.getLayoutParams()).f19716a;
            if (cVar instanceof BaseBehavior) {
                int bottom = (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVar).f10181j) + this.e) - u(view2);
                WeakHashMap weakHashMap = z0.f15748a;
                view.offsetTopAndBottom(bottom);
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.f10175k) {
                return false;
            }
            appBarLayout.e(appBarLayout.f(view));
            return false;
        }

        @Override // x0.c
        public final void e(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                z0.j(m1.c.f15926h.a(), coordinatorLayout);
                z0.k(m1.c.f15927i.a(), coordinatorLayout);
                z0.g(0, coordinatorLayout);
            }
        }

        @Override // x0.c
        public final boolean m(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z5) {
            AppBarLayout v6 = v(coordinatorLayout.o(view));
            if (v6 != null) {
                rect.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect2 = this.f15582c;
                rect2.set(0, 0, width, height);
                if (!rect2.contains(rect)) {
                    v6.d(false, !z5, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            this.f15584f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public static ka.b b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ka.b bVar = new ka.b((LinearLayout.LayoutParams) layoutParams);
            bVar.f15572a = 1;
            return bVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ka.b bVar2 = new ka.b((ViewGroup.MarginLayoutParams) layoutParams);
            bVar2.f15572a = 1;
            return bVar2;
        }
        ka.b bVar3 = new ka.b(layoutParams);
        bVar3.f15572a = 1;
        return bVar3;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ka.b generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ka.b bVar = new ka.b(context, attributeSet);
        bVar.f15572a = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
        bVar.f15572a = obtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
        if (obtainStyledAttributes.hasValue(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
            bVar.f15573b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
        }
        obtainStyledAttributes.recycle();
        return bVar;
    }

    public void addOnOffsetChangedListener(ka.a aVar) {
        if (this.f10172h == null) {
            this.f10172h = new ArrayList();
        }
        if (aVar == null || this.f10172h.contains(aVar)) {
            return;
        }
        this.f10172h.add(aVar);
    }

    public final void c(int i3) {
        this.f10166a = i3;
        if (!willNotDraw()) {
            WeakHashMap weakHashMap = z0.f15748a;
            h0.k(this);
        }
        ArrayList arrayList = this.f10172h;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ka.a aVar = (ka.a) this.f10172h.get(i10);
                if (aVar != null) {
                    aVar.a(this, i3);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ka.b;
    }

    public final void d(boolean z5, boolean z6, boolean z8) {
        this.f10170f = (z5 ? 1 : 2) | (z6 ? 4 : 0) | (z8 ? 8 : 0);
        requestLayout();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f10180p == null || getTopInset() <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(0.0f, -this.f10166a);
        this.f10180p.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f10180p;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e(boolean z5) {
        if (this.f10174j == z5) {
            return false;
        }
        this.f10174j = z5;
        refreshDrawableState();
        if (this.f10175k && (getBackground() instanceof h)) {
            h hVar = (h) getBackground();
            float dimension = getResources().getDimension(R$dimen.design_appbar_elevation);
            float f2 = z5 ? 0.0f : dimension;
            if (!z5) {
                dimension = 0.0f;
            }
            ValueAnimator valueAnimator = this.f10178n;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, dimension);
            this.f10178n = ofFloat;
            ofFloat.setDuration(getResources().getInteger(R$integer.app_bar_elevation_anim_duration));
            this.f10178n.setInterpolator(ja.a.f15383a);
            this.f10178n.addUpdateListener(new t(hVar, 5));
            this.f10178n.start();
        }
        return true;
    }

    public final boolean f(View view) {
        int i3;
        if (this.f10177m == null && (i3 = this.f10176l) != -1) {
            View findViewById = view != null ? view.findViewById(i3) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.f10176l);
            }
            if (findViewById != null) {
                this.f10177m = new WeakReference(findViewById);
            }
        }
        WeakReference weakReference = this.f10177m;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ka.b bVar = new ka.b(-1, -2);
        bVar.f15572a = 1;
        return bVar;
    }

    @Override // x0.b
    public x0.c getBehavior() {
        return new Behavior();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getDownNestedPreScrollRange() {
        /*
            r10 = this;
            r0 = 5
            int r1 = r10.f10168c
            r2 = -1
            if (r1 == r2) goto L7
            return r1
        L7:
            int r1 = r10.getChildCount()
            int r1 = r1 + (-1)
            r3 = 0
            r4 = r3
        Lf:
            if (r1 < 0) goto L5f
            android.view.View r5 = r10.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            ka.b r6 = (ka.b) r6
            int r7 = r5.getMeasuredHeight()
            int r8 = r6.f15572a
            r9 = r8 & 5
            if (r9 != r0) goto L5a
            int r9 = r6.topMargin
            int r6 = r6.bottomMargin
            int r9 = r9 + r6
            r6 = r8 & 8
            if (r6 == 0) goto L36
            java.util.WeakHashMap r6 = l1.z0.f15748a
            int r6 = l1.h0.d(r5)
        L34:
            int r6 = r6 + r9
            goto L45
        L36:
            r6 = r8 & 2
            if (r6 == 0) goto L43
            java.util.WeakHashMap r6 = l1.z0.f15748a
            int r6 = l1.h0.d(r5)
            int r6 = r7 - r6
            goto L34
        L43:
            int r6 = r9 + r7
        L45:
            if (r1 != 0) goto L58
            java.util.WeakHashMap r8 = l1.z0.f15748a
            boolean r5 = l1.h0.b(r5)
            if (r5 == 0) goto L58
            int r5 = r10.getTopInset()
            int r7 = r7 - r5
            int r6 = java.lang.Math.min(r6, r7)
        L58:
            int r4 = r4 + r6
            goto L5d
        L5a:
            if (r4 <= 0) goto L5d
            goto L5f
        L5d:
            int r1 = r1 + r2
            goto Lf
        L5f:
            int r0 = java.lang.Math.max(r3, r4)
            r10.f10168c = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.getDownNestedPreScrollRange():int");
    }

    public int getDownNestedScrollRange() {
        int i3 = this.f10169d;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            ka.b bVar = (ka.b) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin + childAt.getMeasuredHeight();
            int i12 = bVar.f15572a;
            if ((i12 & 1) == 0) {
                break;
            }
            i11 += measuredHeight;
            if ((i12 & 2) != 0) {
                WeakHashMap weakHashMap = z0.f15748a;
                i11 -= h0.d(childAt);
                break;
            }
            i10++;
        }
        int max = Math.max(0, i11);
        this.f10169d = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f10176l;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap weakHashMap = z0.f15748a;
        int d5 = h0.d(this);
        if (d5 == 0) {
            int childCount = getChildCount();
            d5 = childCount >= 1 ? h0.d(getChildAt(childCount - 1)) : 0;
            if (d5 == 0) {
                return getHeight() / 3;
            }
        }
        return (d5 * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f10170f;
    }

    public Drawable getStatusBarForeground() {
        return this.f10180p;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        x1 x1Var = this.f10171g;
        if (x1Var != null) {
            return x1Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i3 = this.f10167b;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            ka.b bVar = (ka.b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i12 = bVar.f15572a;
            if ((i12 & 1) == 0) {
                break;
            }
            int i13 = measuredHeight + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin + i11;
            if (i10 == 0) {
                WeakHashMap weakHashMap = z0.f15748a;
                if (h0.b(childAt)) {
                    i13 -= getTopInset();
                }
            }
            i11 = i13;
            if ((i12 & 2) != 0) {
                WeakHashMap weakHashMap2 = z0.f15748a;
                i11 -= h0.d(childAt);
                break;
            }
            i10++;
        }
        int max = Math.max(0, i11);
        this.f10167b = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        rb.d(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        if (this.f10179o == null) {
            this.f10179o = new int[4];
        }
        int[] iArr = this.f10179o;
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + iArr.length);
        boolean z5 = this.f10173i;
        int i10 = R$attr.state_liftable;
        if (!z5) {
            i10 = -i10;
        }
        iArr[0] = i10;
        iArr[1] = (z5 && this.f10174j) ? R$attr.state_lifted : -R$attr.state_lifted;
        int i11 = R$attr.state_collapsible;
        if (!z5) {
            i11 = -i11;
        }
        iArr[2] = i11;
        iArr[3] = (z5 && this.f10174j) ? R$attr.state_collapsed : -R$attr.state_collapsed;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.f10177m;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f10177m = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        boolean z6 = true;
        super.onLayout(z5, i3, i10, i11, i12);
        WeakHashMap weakHashMap = z0.f15748a;
        if (h0.b(this) && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !h0.b(childAt)) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    getChildAt(childCount).offsetTopAndBottom(topInset);
                }
            }
        }
        this.f10167b = -1;
        this.f10168c = -1;
        this.f10169d = -1;
        this.e = false;
        int childCount2 = getChildCount();
        int i13 = 0;
        while (true) {
            if (i13 >= childCount2) {
                break;
            }
            if (((ka.b) getChildAt(i13).getLayoutParams()).f15573b != null) {
                this.e = true;
                break;
            }
            i13++;
        }
        Drawable drawable = this.f10180p;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f10175k) {
            int childCount3 = getChildCount();
            int i14 = 0;
            while (true) {
                if (i14 >= childCount3) {
                    z6 = false;
                    break;
                }
                int i15 = ((ka.b) getChildAt(i14).getLayoutParams()).f15572a;
                if ((i15 & 1) == 1 && (i15 & 10) != 0) {
                    break;
                } else {
                    i14++;
                }
            }
        }
        if (this.f10173i != z6) {
            this.f10173i = z6;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != 1073741824) {
            WeakHashMap weakHashMap = z0.f15748a;
            if (h0.b(this) && getChildCount() > 0) {
                View childAt = getChildAt(0);
                if (childAt.getVisibility() != 8 && !h0.b(childAt)) {
                    int measuredHeight = getMeasuredHeight();
                    if (mode == Integer.MIN_VALUE) {
                        measuredHeight = xb.a(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i10));
                    } else if (mode == 0) {
                        measuredHeight += getTopInset();
                    }
                    setMeasuredDimension(getMeasuredWidth(), measuredHeight);
                }
            }
        }
        this.f10167b = -1;
        this.f10168c = -1;
        this.f10169d = -1;
    }

    public void removeOnOffsetChangedListener(ka.a aVar) {
        ArrayList arrayList = this.f10172h;
        if (arrayList == null || aVar == null) {
            return;
        }
        arrayList.remove(aVar);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        rb.b(this, f2);
    }

    public void setExpanded(boolean z5) {
        WeakHashMap weakHashMap = z0.f15748a;
        d(z5, k0.c(this), true);
    }

    public void setLiftOnScroll(boolean z5) {
        this.f10175k = z5;
    }

    public void setLiftOnScrollTargetViewId(int i3) {
        this.f10176l = i3;
        WeakReference weakReference = this.f10177m;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f10177m = null;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        if (i3 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i3);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f10180p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f10180p = mutate;
            boolean z5 = false;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f10180p.setState(getDrawableState());
                }
                Drawable drawable3 = this.f10180p;
                WeakHashMap weakHashMap = z0.f15748a;
                d1.c.b(drawable3, i0.d(this));
                this.f10180p.setVisible(getVisibility() == 0, false);
                this.f10180p.setCallback(this);
            }
            if (this.f10180p != null && getTopInset() > 0) {
                z5 = true;
            }
            setWillNotDraw(true ^ z5);
            WeakHashMap weakHashMap2 = z0.f15748a;
            h0.k(this);
        }
    }

    public void setStatusBarForegroundColor(int i3) {
        setStatusBarForeground(new ColorDrawable(i3));
    }

    public void setStatusBarForegroundResource(int i3) {
        setStatusBarForeground(pb.b(getContext(), i3));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        i.a(this, f2);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z5 = i3 == 0;
        Drawable drawable = this.f10180p;
        if (drawable != null) {
            drawable.setVisible(z5, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f10180p;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppBarLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = com.google.android.material.appbar.AppBarLayout.f10165q
            android.content.Context r9 = ib.a.a(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            r9 = -1
            r8.f10167b = r9
            r8.f10168c = r9
            r8.f10169d = r9
            r6 = 0
            r8.f10170f = r6
            android.content.Context r7 = r8.getContext()
            r0 = 1
            r8.setOrientation(r0)
            android.view.ViewOutlineProvider r0 = android.view.ViewOutlineProvider.BOUNDS
            r8.setOutlineProvider(r0)
            android.content.Context r0 = r8.getContext()
            int[] r2 = ka.i.f15591a
            int[] r5 = new int[r6]
            r1 = r10
            r3 = r11
            android.content.res.TypedArray r10 = com.google.android.material.internal.w.d(r0, r1, r2, r3, r4, r5)
            boolean r11 = r10.hasValue(r6)     // Catch: java.lang.Throwable -> L40
            if (r11 == 0) goto L44
            int r11 = r10.getResourceId(r6, r6)     // Catch: java.lang.Throwable -> L40
            android.animation.StateListAnimator r11 = android.animation.AnimatorInflater.loadStateListAnimator(r0, r11)     // Catch: java.lang.Throwable -> L40
            r8.setStateListAnimator(r11)     // Catch: java.lang.Throwable -> L40
            goto L44
        L40:
            r0 = move-exception
            r9 = r0
            goto Leb
        L44:
            r10.recycle()
            int[] r2 = com.google.android.material.R$styleable.AppBarLayout
            int[] r5 = new int[r6]
            r0 = r7
            android.content.res.TypedArray r10 = com.google.android.material.internal.w.d(r0, r1, r2, r3, r4, r5)
            int r11 = com.google.android.material.R$styleable.AppBarLayout_android_background
            android.graphics.drawable.Drawable r11 = r10.getDrawable(r11)
            java.util.WeakHashMap r1 = l1.z0.f15748a
            l1.h0.q(r8, r11)
            android.graphics.drawable.Drawable r11 = r8.getBackground()
            boolean r11 = r11 instanceof android.graphics.drawable.ColorDrawable
            if (r11 == 0) goto L7f
            android.graphics.drawable.Drawable r11 = r8.getBackground()
            android.graphics.drawable.ColorDrawable r11 = (android.graphics.drawable.ColorDrawable) r11
            eb.h r1 = new eb.h
            r1.<init>()
            int r11 = r11.getColor()
            android.content.res.ColorStateList r11 = android.content.res.ColorStateList.valueOf(r11)
            r1.l(r11)
            r1.j(r0)
            l1.h0.q(r8, r1)
        L7f:
            int r11 = com.google.android.material.R$styleable.AppBarLayout_expanded
            boolean r11 = r10.hasValue(r11)
            if (r11 == 0) goto L90
            int r11 = com.google.android.material.R$styleable.AppBarLayout_expanded
            boolean r11 = r10.getBoolean(r11, r6)
            r8.d(r11, r6, r6)
        L90:
            int r11 = com.google.android.material.R$styleable.AppBarLayout_elevation
            boolean r11 = r10.hasValue(r11)
            if (r11 == 0) goto La2
            int r11 = com.google.android.material.R$styleable.AppBarLayout_elevation
            int r11 = r10.getDimensionPixelSize(r11, r6)
            float r11 = (float) r11
            ka.i.a(r8, r11)
        La2:
            int r11 = com.google.android.material.R$styleable.AppBarLayout_android_keyboardNavigationCluster
            boolean r11 = r10.hasValue(r11)
            if (r11 == 0) goto Lb3
            int r11 = com.google.android.material.R$styleable.AppBarLayout_android_keyboardNavigationCluster
            boolean r11 = r10.getBoolean(r11, r6)
            r8.setKeyboardNavigationCluster(r11)
        Lb3:
            int r11 = com.google.android.material.R$styleable.AppBarLayout_android_touchscreenBlocksFocus
            boolean r11 = r10.hasValue(r11)
            if (r11 == 0) goto Lc4
            int r11 = com.google.android.material.R$styleable.AppBarLayout_android_touchscreenBlocksFocus
            boolean r11 = r10.getBoolean(r11, r6)
            r8.setTouchscreenBlocksFocus(r11)
        Lc4:
            int r11 = com.google.android.material.R$styleable.AppBarLayout_liftOnScroll
            boolean r11 = r10.getBoolean(r11, r6)
            r8.f10175k = r11
            int r11 = com.google.android.material.R$styleable.AppBarLayout_liftOnScrollTargetViewId
            int r9 = r10.getResourceId(r11, r9)
            r8.f10176l = r9
            int r9 = com.google.android.material.R$styleable.AppBarLayout_statusBarForeground
            android.graphics.drawable.Drawable r9 = r10.getDrawable(r9)
            r8.setStatusBarForeground(r9)
            r10.recycle()
            com.example.test.ui.device.activity.f0 r9 = new com.example.test.ui.device.activity.f0
            r10 = 22
            r9.<init>(r8, r10)
            l1.n0.u(r8, r9)
            return
        Leb:
            r10.recycle()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void removeOnOffsetChangedListener(ka.c cVar) {
        removeOnOffsetChangedListener((ka.a) cVar);
    }

    public static class BaseBehavior<T extends AppBarLayout> extends e {

        /* renamed from: j, reason: collision with root package name */
        public int f10181j;

        /* renamed from: k, reason: collision with root package name */
        public int f10182k;

        /* renamed from: l, reason: collision with root package name */
        public ValueAnimator f10183l;

        /* renamed from: m, reason: collision with root package name */
        public int f10184m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f10185n;

        /* renamed from: o, reason: collision with root package name */
        public float f10186o;

        /* renamed from: p, reason: collision with root package name */
        public WeakReference f10187p;

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new d();

            /* renamed from: a, reason: collision with root package name */
            public int f10188a;

            /* renamed from: b, reason: collision with root package name */
            public float f10189b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f10190c;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f10188a = parcel.readInt();
                this.f10189b = parcel.readFloat();
                this.f10190c = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i3) {
                super.writeToParcel(parcel, i3);
                parcel.writeInt(this.f10188a);
                parcel.writeFloat(this.f10189b);
                parcel.writeByte(this.f10190c ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
            this.f15578f = -1;
            this.f15580h = -1;
            this.f10184m = -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void B(androidx.coordinatorlayout.widget.CoordinatorLayout r8, com.google.android.material.appbar.AppBarLayout r9, int r10, int r11, boolean r12) {
            /*
                r0 = 1
                int r1 = java.lang.Math.abs(r10)
                int r2 = r9.getChildCount()
                r3 = 0
                r4 = r3
            Lb:
                r5 = 0
                if (r4 >= r2) goto L21
                android.view.View r6 = r9.getChildAt(r4)
                int r7 = r6.getTop()
                if (r1 < r7) goto L1f
                int r7 = r6.getBottom()
                if (r1 > r7) goto L1f
                goto L22
            L1f:
                int r4 = r4 + r0
                goto Lb
            L21:
                r6 = r5
            L22:
                if (r6 == 0) goto Lac
                android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
                ka.b r1 = (ka.b) r1
                int r1 = r1.f15572a
                r2 = r1 & 1
                if (r2 == 0) goto L5d
                java.util.WeakHashMap r2 = l1.z0.f15748a
                int r2 = l1.h0.d(r6)
                if (r11 <= 0) goto L4b
                r11 = r1 & 12
                if (r11 == 0) goto L4b
                int r10 = -r10
                int r11 = r6.getBottom()
                int r11 = r11 - r2
                int r1 = r9.getTopInset()
                int r11 = r11 - r1
                if (r10 < r11) goto L5d
            L49:
                r10 = r0
                goto L5e
            L4b:
                r11 = r1 & 2
                if (r11 == 0) goto L5d
                int r10 = -r10
                int r11 = r6.getBottom()
                int r11 = r11 - r2
                int r1 = r9.getTopInset()
                int r11 = r11 - r1
                if (r10 < r11) goto L5d
                goto L49
            L5d:
                r10 = r3
            L5e:
                boolean r11 = r9.f10175k
                if (r11 == 0) goto L6a
                android.view.View r10 = x(r8)
                boolean r10 = r9.f(r10)
            L6a:
                boolean r10 = r9.e(r10)
                if (r12 != 0) goto La9
                if (r10 == 0) goto Lac
                v2.h r10 = r8.f1888b
                java.lang.Object r10 = r10.f19147b
                m0.k r10 = (m0.k) r10
                java.lang.Object r10 = r10.getOrDefault(r9, r5)
                java.util.List r10 = (java.util.List) r10
                java.util.ArrayList r8 = r8.f1890d
                r8.clear()
                if (r10 == 0) goto L88
                r8.addAll(r10)
            L88:
                int r10 = r8.size()
            L8c:
                if (r3 >= r10) goto Lac
                java.lang.Object r11 = r8.get(r3)
                android.view.View r11 = (android.view.View) r11
                android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
                x0.f r11 = (x0.f) r11
                x0.c r11 = r11.f19716a
                boolean r12 = r11 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r12 == 0) goto La7
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r11 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r11
                int r8 = r11.f15584f
                if (r8 == 0) goto Lac
                goto La9
            La7:
                int r3 = r3 + r0
                goto L8c
            La9:
                r9.jumpDrawablesToCurrentState()
            Lac:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.B(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        public static View x(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if ((childAt instanceof r) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public final void A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m1.c cVar = m1.c.f15926h;
            z0.j(cVar.a(), coordinatorLayout);
            m1.c cVar2 = m1.c.f15927i;
            z0.k(cVar2.a(), coordinatorLayout);
            z0.g(0, coordinatorLayout);
            View x10 = x(coordinatorLayout);
            if (x10 == null || appBarLayout.getTotalScrollRange() == 0 || !(((x0.f) x10.getLayoutParams()).f19716a instanceof ScrollingViewBehavior)) {
                return;
            }
            if (u() != (-appBarLayout.getTotalScrollRange()) && x10.canScrollVertically(1)) {
                z0.l(coordinatorLayout, cVar, new c(appBarLayout, false));
            }
            if (u() != 0) {
                if (!x10.canScrollVertically(-1)) {
                    z0.l(coordinatorLayout, cVar2, new c(appBarLayout, true));
                    return;
                }
                int i3 = -appBarLayout.getDownNestedPreScrollRange();
                if (i3 != 0) {
                    z0.l(coordinatorLayout, cVar2, new b(this, coordinatorLayout, appBarLayout, x10, i3));
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0099  */
        @Override // ka.g, x0.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean h(androidx.coordinatorlayout.widget.CoordinatorLayout r9, android.view.View r10, int r11) {
            /*
                r8 = this;
                r2 = r10
                com.google.android.material.appbar.AppBarLayout r2 = (com.google.android.material.appbar.AppBarLayout) r2
                super.h(r9, r2, r11)
                int r10 = r2.getPendingAction()
                int r11 = r8.f10184m
                r6 = 1
                r7 = 0
                if (r11 < 0) goto L4a
                r0 = r10 & 8
                if (r0 != 0) goto L4a
                android.view.View r10 = r2.getChildAt(r11)
                int r11 = r10.getBottom()
                int r11 = -r11
                boolean r0 = r8.f10185n
                if (r0 == 0) goto L2f
                java.util.WeakHashMap r0 = l1.z0.f15748a
                int r10 = l1.h0.d(r10)
                int r0 = r2.getTopInset()
                int r0 = r0 + r10
                int r0 = r0 + r11
            L2d:
                r3 = r0
                goto L3e
            L2f:
                int r10 = r10.getHeight()
                float r10 = (float) r10
                float r0 = r8.f10186o
                float r10 = r10 * r0
                int r10 = java.lang.Math.round(r10)
                int r0 = r10 + r11
                goto L2d
            L3e:
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                r5 = 2147483647(0x7fffffff, float:NaN)
                r0 = r8
                r1 = r9
                r0.v(r1, r2, r3, r4, r5)
            L48:
                r3 = r7
                goto L7f
            L4a:
                r0 = r8
                r1 = r9
                if (r10 == 0) goto L48
                r9 = r10 & 4
                if (r9 == 0) goto L54
                r9 = r6
                goto L55
            L54:
                r9 = r7
            L55:
                r11 = r10 & 2
                if (r11 == 0) goto L6d
                int r10 = r2.getUpNestedPreScrollRange()
                int r3 = -r10
                if (r9 == 0) goto L64
                r8.w(r1, r2, r3)
                goto L48
            L64:
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                r5 = 2147483647(0x7fffffff, float:NaN)
                r0.v(r1, r2, r3, r4, r5)
                goto L48
            L6d:
                r10 = r10 & r6
                if (r10 == 0) goto L48
                if (r9 == 0) goto L76
                r8.w(r1, r2, r7)
                goto L48
            L76:
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                r5 = 2147483647(0x7fffffff, float:NaN)
                r3 = r7
                r0.v(r1, r2, r3, r4, r5)
            L7f:
                r2.f10170f = r3
                r9 = -1
                r0.f10184m = r9
                int r9 = r8.s()
                int r10 = r2.getTotalScrollRange()
                int r10 = -r10
                int r9 = com.google.android.gms.internal.mlkit_vision_barcode.xb.a(r9, r10, r3)
                ka.h r10 = r0.f15585a
                if (r10 == 0) goto L99
                r10.b(r9)
                goto L9b
            L99:
                r0.f15586b = r9
            L9b:
                int r9 = r8.s()
                r10 = 0
                B(r1, r2, r9, r10, r6)
                int r9 = r8.s()
                r2.c(r9)
                r8.A(r1, r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.h(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
        }

        @Override // x0.c
        public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i3, int i10, int i11) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((x0.f) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.w(i3, i10, View.MeasureSpec.makeMeasureSpec(0, 0), appBarLayout);
            return true;
        }

        @Override // x0.c
        public final /* bridge */ /* synthetic */ void k(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i10, int[] iArr, int i11) {
            y(coordinatorLayout, (AppBarLayout) view, view2, i10, iArr);
        }

        @Override // x0.c
        public final void l(CoordinatorLayout coordinatorLayout, View view, int i3, int i10, int i11, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i11 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = v(coordinatorLayout2, appBarLayout, u() - i11, -appBarLayout.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i11 == 0) {
                A(coordinatorLayout2, appBarLayout);
            }
        }

        @Override // x0.c
        public final void n(View view, Parcelable parcelable) {
            if (!(parcelable instanceof SavedState)) {
                this.f10184m = -1;
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            this.f10184m = savedState.f10188a;
            this.f10186o = savedState.f10189b;
            this.f10185n = savedState.f10190c;
        }

        @Override // x0.c
        public final Parcelable o(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            android.view.AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            int s7 = s();
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                int bottom = childAt.getBottom() + s7;
                if (childAt.getTop() + s7 <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(absSavedState);
                    savedState.f10188a = i3;
                    WeakHashMap weakHashMap = z0.f15748a;
                    savedState.f10190c = bottom == appBarLayout.getTopInset() + h0.d(childAt);
                    savedState.f10189b = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return absSavedState;
        }

        @Override // x0.c
        public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i10) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z5 = (i3 & 2) != 0 && (appBarLayout.f10175k || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z5 && (valueAnimator = this.f10183l) != null) {
                valueAnimator.cancel();
            }
            this.f10187p = null;
            this.f10182k = i10;
            return z5;
        }

        @Override // x0.c
        public final void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i3) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f10182k == 0 || i3 == 1) {
                z(coordinatorLayout, appBarLayout);
                if (appBarLayout.f10175k) {
                    appBarLayout.e(appBarLayout.f(view2));
                }
            }
            this.f10187p = new WeakReference(view2);
        }

        @Override // ka.e
        public final int u() {
            return s() + this.f10181j;
        }

        @Override // ka.e
        public final int v(CoordinatorLayout coordinatorLayout, View view, int i3, int i10, int i11) {
            int i12;
            boolean z5;
            int i13;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int u10 = u();
            int i14 = 0;
            if (i10 == 0 || u10 < i10 || u10 > i11) {
                this.f10181j = 0;
            } else {
                int a3 = xb.a(i3, i10, i11);
                if (u10 != a3) {
                    if (appBarLayout.e) {
                        int abs = Math.abs(a3);
                        int childCount = appBarLayout.getChildCount();
                        int i15 = 0;
                        while (true) {
                            if (i15 >= childCount) {
                                break;
                            }
                            View childAt = appBarLayout.getChildAt(i15);
                            ka.b bVar = (ka.b) childAt.getLayoutParams();
                            Interpolator interpolator = bVar.f15573b;
                            if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                                i15++;
                            } else if (interpolator != null) {
                                int i16 = bVar.f15572a;
                                if ((i16 & 1) != 0) {
                                    i13 = childAt.getHeight() + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
                                    if ((i16 & 2) != 0) {
                                        WeakHashMap weakHashMap = z0.f15748a;
                                        i13 -= h0.d(childAt);
                                    }
                                } else {
                                    i13 = 0;
                                }
                                WeakHashMap weakHashMap2 = z0.f15748a;
                                if (h0.b(childAt)) {
                                    i13 -= appBarLayout.getTopInset();
                                }
                                if (i13 > 0) {
                                    float f2 = i13;
                                    i12 = (childAt.getTop() + Math.round(interpolator.getInterpolation((abs - childAt.getTop()) / f2) * f2)) * Integer.signum(a3);
                                }
                            }
                        }
                    }
                    i12 = a3;
                    ka.h hVar = this.f15585a;
                    if (hVar != null) {
                        z5 = hVar.b(i12);
                    } else {
                        this.f15586b = i12;
                        z5 = false;
                    }
                    int i17 = u10 - a3;
                    this.f10181j = a3 - i12;
                    if (!z5 && appBarLayout.e) {
                        coordinatorLayout.m(appBarLayout);
                    }
                    appBarLayout.c(s());
                    B(coordinatorLayout, appBarLayout, a3, a3 < u10 ? -1 : 1, false);
                    i14 = i17;
                }
            }
            A(coordinatorLayout, appBarLayout);
            return i14;
        }

        public final void w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3) {
            int abs = Math.abs(u() - i3);
            float abs2 = Math.abs(0.0f);
            int round = abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int u10 = u();
            if (u10 == i3) {
                ValueAnimator valueAnimator = this.f10183l;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f10183l.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f10183l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f10183l = valueAnimator3;
                valueAnimator3.setInterpolator(ja.a.e);
                this.f10183l.addUpdateListener(new a(this, coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f10183l.setDuration(Math.min(round, FontStyle.WEIGHT_SEMI_BOLD));
            this.f10183l.setIntValues(u10, i3);
            this.f10183l.start();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void y(androidx.coordinatorlayout.widget.CoordinatorLayout r9, com.google.android.material.appbar.AppBarLayout r10, android.view.View r11, int r12, int[] r13) {
            /*
                r8 = this;
                if (r12 == 0) goto L2b
                if (r12 >= 0) goto L11
                int r0 = r10.getTotalScrollRange()
                int r0 = -r0
                int r1 = r10.getDownNestedPreScrollRange()
                int r1 = r1 + r0
            Le:
                r6 = r0
                r7 = r1
                goto L18
            L11:
                int r0 = r10.getUpNestedPreScrollRange()
                int r0 = -r0
                r1 = 0
                goto Le
            L18:
                if (r6 == r7) goto L2b
                int r0 = r8.u()
                int r5 = r0 - r12
                r2 = r8
                r3 = r9
                r4 = r10
                int r9 = r2.v(r3, r4, r5, r6, r7)
                r10 = 1
                r13[r10] = r9
                goto L2c
            L2b:
                r4 = r10
            L2c:
                boolean r9 = r4.f10175k
                if (r9 == 0) goto L37
                boolean r9 = r4.f(r11)
                r4.e(r9)
            L37:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.y(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int[]):void");
        }

        public final void z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int u10 = u();
            int childCount = appBarLayout.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    i3 = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                ka.b bVar = (ka.b) childAt.getLayoutParams();
                if ((bVar.f15572a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) bVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) bVar).bottomMargin;
                }
                int i10 = -u10;
                if (top <= i10 && bottom >= i10) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 >= 0) {
                View childAt2 = appBarLayout.getChildAt(i3);
                ka.b bVar2 = (ka.b) childAt2.getLayoutParams();
                int i11 = bVar2.f15572a;
                if ((i11 & 17) == 17) {
                    int i12 = -childAt2.getTop();
                    int i13 = -childAt2.getBottom();
                    if (i3 == appBarLayout.getChildCount() - 1) {
                        i13 += appBarLayout.getTopInset();
                    }
                    if ((i11 & 2) == 2) {
                        WeakHashMap weakHashMap = z0.f15748a;
                        i13 += h0.d(childAt2);
                    } else if ((i11 & 5) == 5) {
                        WeakHashMap weakHashMap2 = z0.f15748a;
                        int d5 = h0.d(childAt2) + i13;
                        if (u10 < d5) {
                            i12 = d5;
                        } else {
                            i13 = d5;
                        }
                    }
                    if ((i11 & 32) == 32) {
                        i12 += ((LinearLayout.LayoutParams) bVar2).topMargin;
                        i13 -= ((LinearLayout.LayoutParams) bVar2).bottomMargin;
                    }
                    if (u10 < (i13 + i12) / 2) {
                        i12 = i13;
                    }
                    w(coordinatorLayout, appBarLayout, xb.a(i12, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            this.f15578f = -1;
            this.f15580h = -1;
            this.f10184m = -1;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        ka.b bVar = new ka.b(-1, -2);
        bVar.f15572a = 1;
        return bVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    public void addOnOffsetChangedListener(ka.c cVar) {
        addOnOffsetChangedListener((ka.a) cVar);
    }
}
