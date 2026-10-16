package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import java.util.WeakHashMap;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements j1, l1.v, l1.t, l1.u {
    public static final int[] B = {R$attr.actionBarSize, R.attr.windowContentOverlay};
    public final androidx.recyclerview.widget.e1 A;

    /* renamed from: a, reason: collision with root package name */
    public int f633a;

    /* renamed from: b, reason: collision with root package name */
    public int f634b;

    /* renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f635c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f636d;
    public k1 e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f637f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f638g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f639h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f640i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f641j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f642k;

    /* renamed from: l, reason: collision with root package name */
    public int f643l;

    /* renamed from: m, reason: collision with root package name */
    public int f644m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f645n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f646o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f647p;

    /* renamed from: q, reason: collision with root package name */
    public l1.x1 f648q;
    public l1.x1 r;

    /* renamed from: s, reason: collision with root package name */
    public l1.x1 f649s;

    /* renamed from: t, reason: collision with root package name */
    public l1.x1 f650t;

    /* renamed from: u, reason: collision with root package name */
    public d f651u;

    /* renamed from: v, reason: collision with root package name */
    public OverScroller f652v;

    /* renamed from: w, reason: collision with root package name */
    public ViewPropertyAnimator f653w;

    /* renamed from: x, reason: collision with root package name */
    public final ab.q f654x;

    /* renamed from: y, reason: collision with root package name */
    public final c f655y;

    /* renamed from: z, reason: collision with root package name */
    public final c f656z;

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public static boolean c(View view, Rect rect, boolean z5) {
        boolean z6;
        e eVar = (e) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        int i10 = rect.left;
        if (i3 != i10) {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i10;
            z6 = true;
        } else {
            z6 = false;
        }
        int i11 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        int i12 = rect.top;
        if (i11 != i12) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i12;
            z6 = true;
        }
        int i13 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        int i14 = rect.right;
        if (i13 != i14) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i14;
            z6 = true;
        }
        if (z5) {
            int i15 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i16 = rect.bottom;
            if (i15 != i16) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i16;
                return true;
            }
        }
        return z6;
    }

    @Override // l1.t
    public final void a(View view, View view2, int i3, int i10) {
        if (i10 == 0) {
            onNestedScrollAccepted(view, view2, i3);
        }
    }

    @Override // l1.t
    public final void b(View view, int i3, int i10, int[] iArr, int i11) {
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public final void d() {
        removeCallbacks(this.f655y);
        removeCallbacks(this.f656z);
        ViewPropertyAnimator viewPropertyAnimator = this.f653w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i3;
        super.draw(canvas);
        if (this.f637f == null || this.f638g) {
            return;
        }
        if (this.f636d.getVisibility() == 0) {
            i3 = (int) (this.f636d.getTranslationY() + this.f636d.getBottom() + 0.5f);
        } else {
            i3 = 0;
        }
        this.f637f.setBounds(0, i3, getWidth(), this.f637f.getIntrinsicHeight() + i3);
        this.f637f.draw(canvas);
    }

    public final void e(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(B);
        this.f633a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f637f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f638g = context.getApplicationInfo().targetSdkVersion < 19;
        this.f652v = new OverScroller(context);
    }

    @Override // l1.t
    public final void f(int i3, View view) {
        if (i3 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // l1.u
    public final void g(View view, int i3, int i10, int i11, int i12, int i13, int[] iArr) {
        i(view, i3, i10, i11, i12, i13);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f636d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        androidx.recyclerview.widget.e1 e1Var = this.A;
        return e1Var.f2555c | e1Var.f2554b;
    }

    public CharSequence getTitle() {
        k();
        return ((x3) this.e).f1109a.getTitle();
    }

    public final void h(int i3) {
        k();
        if (i3 == 2) {
            ((x3) this.e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i3 == 5) {
            ((x3) this.e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i3 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // l1.t
    public final void i(View view, int i3, int i10, int i11, int i12, int i13) {
        if (i13 == 0) {
            onNestedScroll(view, i3, i10, i11, i12);
        }
    }

    @Override // l1.t
    public final boolean j(View view, View view2, int i3, int i10) {
        return i10 == 0 && onStartNestedScroll(view, view2, i3);
    }

    public final void k() {
        k1 wrapper;
        if (this.f635c == null) {
            this.f635c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f636d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            KeyEvent.Callback findViewById = findViewById(R$id.action_bar);
            if (findViewById instanceof k1) {
                wrapper = (k1) findViewById;
            } else {
                if (!(findViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) findViewById).getWrapper();
            }
            this.e = wrapper;
        }
    }

    public final void l(h.k kVar, h.w wVar) {
        k();
        x3 x3Var = (x3) this.e;
        l lVar = x3Var.f1120m;
        Toolbar toolbar = x3Var.f1109a;
        if (lVar == null) {
            l lVar2 = new l(toolbar.getContext());
            x3Var.f1120m = lVar2;
            lVar2.f960i = R$id.action_menu_presenter;
        }
        l lVar3 = x3Var.f1120m;
        lVar3.e = wVar;
        if (kVar == null && toolbar.f836a == null) {
            return;
        }
        toolbar.f();
        h.k kVar2 = toolbar.f836a.f657p;
        if (kVar2 == kVar) {
            return;
        }
        if (kVar2 != null) {
            kVar2.r(toolbar.K);
            kVar2.r(toolbar.L);
        }
        if (toolbar.L == null) {
            toolbar.L = new r3(toolbar);
        }
        lVar3.r = true;
        if (kVar != null) {
            kVar.b(lVar3, toolbar.f844j);
            kVar.b(toolbar.L, toolbar.f844j);
        } else {
            lVar3.h(toolbar.f844j, null);
            toolbar.L.h(toolbar.f844j, null);
            lVar3.g(true);
            toolbar.L.g(true);
        }
        toolbar.f836a.setPopupTheme(toolbar.f845k);
        toolbar.f836a.setPresenter(lVar3);
        toolbar.K = lVar3;
        toolbar.t();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        l1.x1 h4 = l1.x1.h(windowInsets, this);
        boolean c9 = c(this.f636d, new Rect(h4.b(), h4.d(), h4.c(), h4.a()), false);
        WeakHashMap weakHashMap = l1.z0.f15748a;
        Rect rect = this.f645n;
        l1.n0.b(this, h4, rect);
        int i3 = rect.left;
        int i10 = rect.top;
        int i11 = rect.right;
        int i12 = rect.bottom;
        l1.v1 v1Var = h4.f15738a;
        l1.x1 l3 = v1Var.l(i3, i10, i11, i12);
        this.f648q = l3;
        boolean z5 = true;
        if (!this.r.equals(l3)) {
            this.r = this.f648q;
            c9 = true;
        }
        Rect rect2 = this.f646o;
        if (rect2.equals(rect)) {
            z5 = c9;
        } else {
            rect2.set(rect);
        }
        if (z5) {
            requestLayout();
        }
        return v1Var.a().f15738a.c().f15738a.b().g();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e(getContext());
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.l0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i14 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i14, i15, measuredWidth + i14, measuredHeight + i15);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        int measuredHeight;
        k();
        measureChildWithMargins(this.f636d, i3, 0, i10, 0);
        e eVar = (e) this.f636d.getLayoutParams();
        int max = Math.max(0, this.f636d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f636d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f636d.getMeasuredState());
        WeakHashMap weakHashMap = l1.z0.f15748a;
        boolean z5 = (l1.h0.g(this) & 256) != 0;
        if (z5) {
            measuredHeight = this.f633a;
            if (this.f640i && this.f636d.getTabContainer() != null) {
                measuredHeight += this.f633a;
            }
        } else {
            measuredHeight = this.f636d.getVisibility() != 8 ? this.f636d.getMeasuredHeight() : 0;
        }
        Rect rect = this.f645n;
        Rect rect2 = this.f647p;
        rect2.set(rect);
        l1.x1 x1Var = this.f648q;
        this.f649s = x1Var;
        if (this.f639h || z5) {
            c1.c a3 = c1.c.a(x1Var.b(), this.f649s.d() + measuredHeight, this.f649s.c(), this.f649s.a());
            l1.x1 x1Var2 = this.f649s;
            int i11 = Build.VERSION.SDK_INT;
            l1.o1 n1Var = i11 >= 30 ? new l1.n1(x1Var2) : i11 >= 29 ? new l1.m1(x1Var2) : new l1.l1(x1Var2);
            n1Var.d(a3);
            this.f649s = n1Var.b();
        } else {
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
            this.f649s = x1Var.f15738a.l(0, measuredHeight, 0, 0);
        }
        c(this.f635c, rect2, true);
        if (!this.f650t.equals(this.f649s)) {
            l1.x1 x1Var3 = this.f649s;
            this.f650t = x1Var3;
            l1.z0.b(this.f635c, x1Var3);
        }
        measureChildWithMargins(this.f635c, i3, 0, i10, 0);
        e eVar2 = (e) this.f635c.getLayoutParams();
        int max3 = Math.max(max, this.f635c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f635c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f635c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i3, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i10, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f10, boolean z5) {
        if (!this.f641j || !z5) {
            return false;
        }
        this.f652v.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO);
        if (this.f652v.getFinalY() > this.f636d.getHeight()) {
            d();
            this.f656z.run();
        } else {
            d();
            this.f655y.run();
        }
        this.f642k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i3, int i10, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i3, int i10, int i11, int i12) {
        int i13 = this.f643l + i10;
        this.f643l = i13;
        setActionBarHideOffset(i13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i3) {
        androidx.appcompat.app.p0 p0Var;
        g.j jVar;
        this.A.f2554b = i3;
        this.f643l = getActionBarHideOffset();
        d();
        d dVar = this.f651u;
        if (dVar == null || (jVar = (p0Var = (androidx.appcompat.app.p0) dVar).f556s) == null) {
            return;
        }
        jVar.a();
        p0Var.f556s = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i3) {
        if ((i3 & 2) == 0 || this.f636d.getVisibility() != 0) {
            return false;
        }
        return this.f641j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f641j || this.f642k) {
            return;
        }
        if (this.f643l <= this.f636d.getHeight()) {
            d();
            postDelayed(this.f655y, 600L);
        } else {
            d();
            postDelayed(this.f656z, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i3) {
        super.onWindowSystemUiVisibilityChanged(i3);
        k();
        int i10 = this.f644m ^ i3;
        this.f644m = i3;
        boolean z5 = (i3 & 4) == 0;
        boolean z6 = (i3 & 256) != 0;
        d dVar = this.f651u;
        if (dVar != null) {
            androidx.appcompat.app.p0 p0Var = (androidx.appcompat.app.p0) dVar;
            p0Var.f553o = !z6;
            if (z5 || !z6) {
                if (p0Var.f554p) {
                    p0Var.f554p = false;
                    p0Var.f(true);
                }
            } else if (!p0Var.f554p) {
                p0Var.f554p = true;
                p0Var.f(true);
            }
        }
        if ((i10 & 256) == 0 || this.f651u == null) {
            return;
        }
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.l0.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        this.f634b = i3;
        d dVar = this.f651u;
        if (dVar != null) {
            ((androidx.appcompat.app.p0) dVar).f552n = i3;
        }
    }

    public void setActionBarHideOffset(int i3) {
        d();
        this.f636d.setTranslationY(-Math.max(0, Math.min(i3, this.f636d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f651u = dVar;
        if (getWindowToken() != null) {
            ((androidx.appcompat.app.p0) this.f651u).f552n = this.f634b;
            int i3 = this.f644m;
            if (i3 != 0) {
                onWindowSystemUiVisibilityChanged(i3);
                WeakHashMap weakHashMap = l1.z0.f15748a;
                l1.l0.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z5) {
        this.f640i = z5;
    }

    public void setHideOnContentScrollEnabled(boolean z5) {
        if (z5 != this.f641j) {
            this.f641j = z5;
            if (z5) {
                return;
            }
            d();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i3) {
        k();
        x3 x3Var = (x3) this.e;
        x3Var.f1112d = i3 != 0 ? pb.b(x3Var.f1109a.getContext(), i3) : null;
        x3Var.c();
    }

    public void setLogo(int i3) {
        k();
        x3 x3Var = (x3) this.e;
        x3Var.e = i3 != 0 ? pb.b(x3Var.f1109a.getContext(), i3) : null;
        x3Var.c();
    }

    public void setOverlayMode(boolean z5) {
        this.f639h = z5;
        this.f638g = z5 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z5) {
    }

    public void setUiOptions(int i3) {
    }

    @Override // androidx.appcompat.widget.j1
    public void setWindowCallback(Window.Callback callback) {
        k();
        ((x3) this.e).f1118k = callback;
    }

    @Override // androidx.appcompat.widget.j1
    public void setWindowTitle(CharSequence charSequence) {
        k();
        x3 x3Var = (x3) this.e;
        if (x3Var.f1114g) {
            return;
        }
        x3Var.f1115h = charSequence;
        if ((x3Var.f1110b & 8) != 0) {
            Toolbar toolbar = x3Var.f1109a;
            toolbar.setTitle(charSequence);
            if (x3Var.f1114g) {
                l1.z0.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f634b = 0;
        this.f645n = new Rect();
        this.f646o = new Rect();
        this.f647p = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        l1.x1 x1Var = l1.x1.f15737b;
        this.f648q = x1Var;
        this.r = x1Var;
        this.f649s = x1Var;
        this.f650t = x1Var;
        this.f654x = new ab.q(this, 2);
        this.f655y = new c(this, 0);
        this.f656z = new c(this, 1);
        e(context);
        this.A = new androidx.recyclerview.widget.e1(3);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        x3 x3Var = (x3) this.e;
        x3Var.f1112d = drawable;
        x3Var.c();
    }
}
