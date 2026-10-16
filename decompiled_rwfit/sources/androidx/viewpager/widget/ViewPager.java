package androidx.viewpager.widget;

import a1.c;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.appcompat.widget.d2;
import androidx.customview.view.AbsSavedState;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import l1.h0;
import l1.n0;
import l1.z0;
import n2.e;
import n2.f;
import n2.g;
import n2.h;
import n2.i;
import n2.j;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    public static final int[] W = {R.attr.layout_gravity};

    /* renamed from: a0, reason: collision with root package name */
    public static final androidx.viewpager2.widget.a f2918a0 = new androidx.viewpager2.widget.a(11);

    /* renamed from: b0, reason: collision with root package name */
    public static final e f2919b0 = new e(0);
    public int A;
    public float B;
    public float C;
    public float D;
    public float E;
    public int F;
    public VelocityTracker G;
    public int H;
    public int I;
    public int J;
    public int K;
    public EdgeEffect L;
    public EdgeEffect M;
    public boolean N;
    public boolean O;
    public int P;
    public ArrayList Q;
    public j R;
    public j S;
    public ArrayList T;
    public final androidx.activity.e U;
    public int V;

    /* renamed from: a, reason: collision with root package name */
    public int f2920a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2921b;

    /* renamed from: c, reason: collision with root package name */
    public final g f2922c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f2923d;
    public n2.a e;

    /* renamed from: f, reason: collision with root package name */
    public int f2924f;

    /* renamed from: g, reason: collision with root package name */
    public int f2925g;

    /* renamed from: h, reason: collision with root package name */
    public Parcelable f2926h;

    /* renamed from: i, reason: collision with root package name */
    public Scroller f2927i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2928j;

    /* renamed from: k, reason: collision with root package name */
    public d2 f2929k;

    /* renamed from: l, reason: collision with root package name */
    public int f2930l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f2931m;

    /* renamed from: n, reason: collision with root package name */
    public int f2932n;

    /* renamed from: o, reason: collision with root package name */
    public int f2933o;

    /* renamed from: p, reason: collision with root package name */
    public float f2934p;

    /* renamed from: q, reason: collision with root package name */
    public float f2935q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2936s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2937t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2938u;

    /* renamed from: v, reason: collision with root package name */
    public int f2939v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2940w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2941x;

    /* renamed from: y, reason: collision with root package name */
    public int f2942y;

    /* renamed from: z, reason: collision with root package name */
    public int f2943z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f2944a;

        /* renamed from: b, reason: collision with root package name */
        public Parcelable f2945b;

        /* renamed from: c, reason: collision with root package name */
        public final ClassLoader f2946c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f2944a = parcel.readInt();
            this.f2945b = parcel.readParcelable(classLoader);
            this.f2946c = classLoader;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("FragmentPager.SavedState{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" position=");
            return r5.a.e(sb2, this.f2944a, "}");
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f2944a);
            parcel.writeParcelable(this.f2945b, i3);
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f2921b = new ArrayList();
        this.f2922c = new g();
        this.f2923d = new Rect();
        this.f2925g = -1;
        this.f2926h = null;
        this.f2934p = -3.4028235E38f;
        this.f2935q = Float.MAX_VALUE;
        this.f2939v = 1;
        this.F = -1;
        this.N = true;
        this.U = new androidx.activity.e(this, 21);
        this.V = 0;
        k();
    }

    public static boolean c(int i3, int i10, int i11, View view, boolean z5) {
        int i12;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i13 = i10 + scrollX;
                if (i13 >= childAt.getLeft() && i13 < childAt.getRight() && (i12 = i11 + scrollY) >= childAt.getTop() && i12 < childAt.getBottom() && c(i3, i13 - childAt.getLeft(), i12 - childAt.getTop(), childAt, true)) {
                    break;
                }
            }
        }
        return z5 && view.canScrollHorizontally(-i3);
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z5) {
        if (this.f2937t != z5) {
            this.f2937t = z5;
        }
    }

    public final g a(int i3, int i10) {
        g gVar = new g();
        gVar.f16369b = i3;
        gVar.f16368a = this.e.f(this, i3);
        this.e.getClass();
        gVar.f16371d = 1.0f;
        ArrayList arrayList = this.f2921b;
        if (i10 < 0 || i10 >= arrayList.size()) {
            arrayList.add(gVar);
            return gVar;
        }
        arrayList.add(i10, gVar);
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i3, int i10) {
        g h4;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() == 0 && (h4 = h(childAt)) != null && h4.f16369b == this.f2924f) {
                    childAt.addFocusables(arrayList, i3, i10);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i10 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    public void addOnAdapterChangeListener(i iVar) {
        if (this.T == null) {
            this.T = new ArrayList();
        }
        this.T.add(iVar);
    }

    public void addOnPageChangeListener(j jVar) {
        if (this.Q == null) {
            this.Q = new ArrayList();
        }
        this.Q.add(jVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList arrayList) {
        g h4;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (h4 = h(childAt)) != null && h4.f16369b == this.f2924f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateDefaultLayoutParams();
        }
        h hVar = (h) layoutParams;
        boolean z5 = hVar.f16372a | (view.getClass().getAnnotation(f.class) != null);
        hVar.f16372a = z5;
        if (!this.f2936s) {
            super.addView(view, i3, layoutParams);
        } else {
            if (z5) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            hVar.f16375d = true;
            addViewInLayout(view, i3, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r8) {
        /*
            r7 = this;
            android.view.View r0 = r7.findFocus()
            r1 = 0
            if (r0 != r7) goto L9
        L7:
            r0 = r1
            goto L60
        L9:
            if (r0 == 0) goto L60
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r7) goto L16
            goto L60
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.<init>(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L7
        L60:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r7, r0, r8)
            r2 = 0
            r3 = 1
            r4 = 66
            r5 = 17
            if (r1 == 0) goto Lb2
            if (r1 == r0) goto Lb2
            android.graphics.Rect r6 = r7.f2923d
            if (r8 != r5) goto L96
            android.graphics.Rect r4 = r7.g(r1, r6)
            int r4 = r4.left
            android.graphics.Rect r5 = r7.g(r0, r6)
            int r5 = r5.left
            if (r0 == 0) goto L90
            if (r4 < r5) goto L90
            int r0 = r7.f2924f
            if (r0 <= 0) goto Lca
            int r0 = r0 - r3
            r7.v(r0, r3)
        L8e:
            r2 = r3
            goto Lca
        L90:
            boolean r0 = r1.requestFocus()
        L94:
            r2 = r0
            goto Lca
        L96:
            if (r8 != r4) goto Lca
            android.graphics.Rect r2 = r7.g(r1, r6)
            int r2 = r2.left
            android.graphics.Rect r3 = r7.g(r0, r6)
            int r3 = r3.left
            if (r0 == 0) goto Lad
            if (r2 > r3) goto Lad
            boolean r0 = r7.n()
            goto L94
        Lad:
            boolean r0 = r1.requestFocus()
            goto L94
        Lb2:
            if (r8 == r5) goto Lc1
            if (r8 != r3) goto Lb7
            goto Lc1
        Lb7:
            if (r8 == r4) goto Lbc
            r0 = 2
            if (r8 != r0) goto Lca
        Lbc:
            boolean r2 = r7.n()
            goto Lca
        Lc1:
            int r0 = r7.f2924f
            if (r0 <= 0) goto Lca
            int r0 = r0 - r3
            r7.v(r0, r3)
            goto L8e
        Lca:
            if (r2 == 0) goto Ld3
            int r8 = android.view.SoundEffectConstants.getContantForFocusDirection(r8)
            r7.playSoundEffect(r8)
        Ld3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.b(int):boolean");
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i3) {
        if (this.e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i3 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f2934p)) : i3 > 0 && scrollX < ((int) (((float) clientWidth) * this.f2935q));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof h) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.f2928j = true;
        if (this.f2927i.isFinished() || !this.f2927i.computeScrollOffset()) {
            d(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f2927i.getCurrX();
        int currY = this.f2927i.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!o(currX)) {
                this.f2927i.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap weakHashMap = z0.f15748a;
        h0.k(this);
    }

    public final void d(boolean z5) {
        boolean z6 = this.V == 2;
        if (z6) {
            setScrollingCacheEnabled(false);
            if (!this.f2927i.isFinished()) {
                this.f2927i.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f2927i.getCurrX();
                int currY = this.f2927i.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        o(currX);
                    }
                }
            }
        }
        this.f2938u = false;
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f2921b;
            if (i3 >= arrayList.size()) {
                break;
            }
            g gVar = (g) arrayList.get(i3);
            if (gVar.f16370c) {
                gVar.f16370c = false;
                z6 = true;
            }
            i3++;
        }
        if (z6) {
            androidx.activity.e eVar = this.U;
            if (!z5) {
                eVar.run();
            } else {
                WeakHashMap weakHashMap = z0.f15748a;
                h0.m(this, eVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0063 A[RETURN] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 1
            if (r0 != 0) goto L64
            int r0 = r6.getAction()
            r2 = 0
            if (r0 != 0) goto L5f
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L48
            r3 = 22
            if (r0 == r3) goto L36
            r3 = 61
            if (r0 == r3) goto L20
            goto L5f
        L20:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L2b
            boolean r6 = r5.b(r4)
            goto L60
        L2b:
            boolean r6 = r6.hasModifiers(r1)
            if (r6 == 0) goto L5f
            boolean r6 = r5.b(r1)
            goto L60
        L36:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L41
            boolean r6 = r5.n()
            goto L60
        L41:
            r6 = 66
            boolean r6 = r5.b(r6)
            goto L60
        L48:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L58
            int r6 = r5.f2924f
            if (r6 <= 0) goto L5f
            int r6 = r6 - r1
            r5.v(r6, r1)
            r6 = r1
            goto L60
        L58:
            r6 = 17
            boolean r6 = r5.b(r6)
            goto L60
        L5f:
            r6 = r2
        L60:
            if (r6 == 0) goto L63
            goto L64
        L63:
            return r2
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        g h4;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (h4 = h(childAt)) != null && h4.f16369b == this.f2924f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        n2.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z5 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.e) != null && aVar.c() > 1)) {
            if (!this.L.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.f2934p * width);
                this.L.setSize(height, width);
                z5 = this.L.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.M.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f2935q + 1.0f)) * width2);
                this.M.setSize(height2, width2);
                z5 |= this.M.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.L.finish();
            this.M.finish();
        }
        if (z5) {
            WeakHashMap weakHashMap = z0.f15748a;
            h0.k(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2931m;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e() {
        int c9 = this.e.c();
        this.f2920a = c9;
        ArrayList arrayList = this.f2921b;
        boolean z5 = arrayList.size() < (this.f2939v * 2) + 1 && arrayList.size() < c9;
        int i3 = this.f2924f;
        int i10 = 0;
        boolean z6 = false;
        while (i10 < arrayList.size()) {
            g gVar = (g) arrayList.get(i10);
            int d5 = this.e.d(gVar.f16368a);
            if (d5 != -1) {
                if (d5 == -2) {
                    arrayList.remove(i10);
                    i10--;
                    if (!z6) {
                        this.e.j(this);
                        z6 = true;
                    }
                    this.e.a(this, gVar.f16369b, gVar.f16368a);
                    int i11 = this.f2924f;
                    if (i11 == gVar.f16369b) {
                        i3 = Math.max(0, Math.min(i11, c9 - 1));
                    }
                } else {
                    int i12 = gVar.f16369b;
                    if (i12 != d5) {
                        if (i12 == this.f2924f) {
                            i3 = d5;
                        }
                        gVar.f16369b = d5;
                    }
                }
                z5 = true;
            }
            i10++;
        }
        if (z6) {
            this.e.b();
        }
        Collections.sort(arrayList, f2918a0);
        if (z5) {
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                h hVar = (h) getChildAt(i13).getLayoutParams();
                if (!hVar.f16372a) {
                    hVar.f16374c = 0.0f;
                }
            }
            w(i3, 0, false, true);
            requestLayout();
        }
    }

    public final void f(int i3) {
        j jVar = this.R;
        if (jVar != null) {
            jVar.b(i3);
        }
        ArrayList arrayList = this.Q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                j jVar2 = (j) this.Q.get(i10);
                if (jVar2 != null) {
                    jVar2.b(i3);
                }
            }
        }
        j jVar3 = this.S;
        if (jVar3 != null) {
            jVar3.b(i3);
        }
    }

    public final Rect g(View view, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        h hVar = new h(-1, -1);
        hVar.f16374c = 0.0f;
        return hVar;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public n2.a getAdapter() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i3, int i10) {
        throw null;
    }

    public int getCurrentItem() {
        return this.f2924f;
    }

    public int getOffscreenPageLimit() {
        return this.f2939v;
    }

    public int getPageMargin() {
        return this.f2930l;
    }

    public final g h(View view) {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f2921b;
            if (i3 >= arrayList.size()) {
                return null;
            }
            g gVar = (g) arrayList.get(i3);
            if (this.e.g(view, gVar.f16368a)) {
                return gVar;
            }
            i3++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final n2.g i() {
        /*
            r13 = this;
            int r0 = r13.getClientWidth()
            r1 = 0
            if (r0 <= 0) goto Lf
            int r2 = r13.getScrollX()
            float r2 = (float) r2
            float r3 = (float) r0
            float r2 = r2 / r3
            goto L10
        Lf:
            r2 = r1
        L10:
            if (r0 <= 0) goto L18
            int r3 = r13.f2930l
            float r3 = (float) r3
            float r0 = (float) r0
            float r3 = r3 / r0
            goto L19
        L18:
            r3 = r1
        L19:
            r0 = 0
            r4 = -1
            r5 = 1
            r6 = 0
            r8 = r0
            r9 = r5
            r7 = r6
            r6 = r4
            r4 = r1
        L22:
            java.util.ArrayList r10 = r13.f2921b
            int r11 = r10.size()
            if (r8 >= r11) goto L72
            java.lang.Object r11 = r10.get(r8)
            n2.g r11 = (n2.g) r11
            if (r9 != 0) goto L4c
            int r12 = r11.f16369b
            int r6 = r6 + r5
            if (r12 == r6) goto L4c
            float r1 = r1 + r4
            float r1 = r1 + r3
            n2.g r4 = r13.f2922c
            r4.e = r1
            r4.f16369b = r6
            n2.a r1 = r13.e
            r1.getClass()
            r1 = 1065353216(0x3f800000, float:1.0)
            r4.f16371d = r1
            int r8 = r8 + (-1)
            r6 = r4
            goto L4d
        L4c:
            r6 = r11
        L4d:
            float r1 = r6.e
            float r4 = r6.f16371d
            float r4 = r4 + r1
            float r4 = r4 + r3
            if (r9 != 0) goto L59
            int r9 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r9 < 0) goto L72
        L59:
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L71
            int r4 = r10.size()
            int r4 = r4 - r5
            if (r8 != r4) goto L65
            goto L71
        L65:
            int r4 = r6.f16369b
            float r7 = r6.f16371d
            int r8 = r8 + 1
            r9 = r6
            r6 = r4
            r4 = r7
            r7 = r9
            r9 = r0
            goto L22
        L71:
            return r6
        L72:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.i():n2.g");
    }

    public final g j(int i3) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f2921b;
            if (i10 >= arrayList.size()) {
                return null;
            }
            g gVar = (g) arrayList.get(i10);
            if (gVar.f16369b == i3) {
                return gVar;
            }
            i10++;
        }
    }

    public final void k() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f2927i = new Scroller(context, f2919b0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.A = viewConfiguration.getScaledPagingTouchSlop();
        this.H = (int) (400.0f * f2);
        this.I = viewConfiguration.getScaledMaximumFlingVelocity();
        this.L = new EdgeEffect(context);
        this.M = new EdgeEffect(context);
        this.J = (int) (25.0f * f2);
        this.K = (int) (2.0f * f2);
        this.f2942y = (int) (f2 * 16.0f);
        z0.n(this, new com.google.android.material.button.f(this, 4));
        if (h0.c(this) == 0) {
            h0.s(this, 1);
        }
        n0.u(this, new y(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r14 = r11.P
            r0 = 0
            r1 = 1
            if (r14 <= 0) goto L6c
            int r14 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = r0
        L1b:
            if (r6 >= r5) goto L6c
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            n2.h r8 = (n2.h) r8
            boolean r9 = r8.f16372a
            if (r9 != 0) goto L2c
            goto L69
        L2c:
            int r8 = r8.f16373b
            r8 = r8 & 7
            if (r8 == r1) goto L50
            r9 = 3
            if (r8 == r9) goto L4a
            r9 = 5
            if (r8 == r9) goto L3a
            r8 = r2
            goto L5d
        L3a:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L46:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5d
        L4a:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5d
        L50:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L46
        L5d:
            int r2 = r2 + r14
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L68
            r7.offsetLeftAndRight(r2)
        L68:
            r2 = r8
        L69:
            int r6 = r6 + 1
            goto L1b
        L6c:
            n2.j r14 = r11.R
            if (r14 == 0) goto L73
            r14.d(r13, r12)
        L73:
            java.util.ArrayList r14 = r11.Q
            if (r14 == 0) goto L8d
            int r14 = r14.size()
        L7b:
            if (r0 >= r14) goto L8d
            java.util.ArrayList r2 = r11.Q
            java.lang.Object r2 = r2.get(r0)
            n2.j r2 = (n2.j) r2
            if (r2 == 0) goto L8a
            r2.d(r13, r12)
        L8a:
            int r0 = r0 + 1
            goto L7b
        L8d:
            n2.j r14 = r11.S
            if (r14 == 0) goto L94
            r14.d(r13, r12)
        L94:
            r11.O = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.l(int, float, int):void");
    }

    public final void m(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.F) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.B = motionEvent.getX(i3);
            this.F = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.G;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean n() {
        n2.a aVar = this.e;
        if (aVar == null || this.f2924f >= aVar.c() - 1) {
            return false;
        }
        v(this.f2924f + 1, true);
        return true;
    }

    public final boolean o(int i3) {
        if (this.f2921b.size() == 0) {
            if (!this.N) {
                this.O = false;
                l(0, 0.0f, 0);
                if (!this.O) {
                    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
                }
            }
            return false;
        }
        g i10 = i();
        int clientWidth = getClientWidth();
        int i11 = this.f2930l;
        int i12 = clientWidth + i11;
        float f2 = clientWidth;
        int i13 = i10.f16369b;
        float f10 = ((i3 / f2) - i10.e) / (i10.f16371d + (i11 / f2));
        this.O = false;
        l(i13, f10, (int) (i12 * f10));
        if (this.O) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.N = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.U);
        Scroller scroller = this.f2927i;
        if (scroller != null && !scroller.isFinished()) {
            this.f2927i.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i3;
        float f2;
        ArrayList arrayList;
        int i10;
        super.onDraw(canvas);
        if (this.f2930l <= 0 || this.f2931m == null) {
            return;
        }
        ArrayList arrayList2 = this.f2921b;
        if (arrayList2.size() <= 0 || this.e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f10 = this.f2930l / width;
        int i11 = 0;
        g gVar = (g) arrayList2.get(0);
        float f11 = gVar.e;
        int size = arrayList2.size();
        int i12 = gVar.f16369b;
        int i13 = ((g) arrayList2.get(size - 1)).f16369b;
        while (i12 < i13) {
            while (true) {
                i3 = gVar.f16369b;
                if (i12 <= i3 || i11 >= size) {
                    break;
                }
                i11++;
                gVar = (g) arrayList2.get(i11);
            }
            if (i12 == i3) {
                float f12 = gVar.e;
                float f13 = gVar.f16371d;
                f2 = (f12 + f13) * width;
                f11 = f12 + f13 + f10;
            } else {
                this.e.getClass();
                f2 = (f11 + 1.0f) * width;
                f11 = 1.0f + f10 + f11;
            }
            if (this.f2930l + f2 > scrollX) {
                arrayList = arrayList2;
                i10 = scrollX;
                this.f2931m.setBounds(Math.round(f2), this.f2932n, Math.round(this.f2930l + f2), this.f2933o);
                this.f2931m.draw(canvas);
            } else {
                arrayList = arrayList2;
                i10 = scrollX;
            }
            if (f2 > i10 + r3) {
                return;
            }
            i12++;
            arrayList2 = arrayList;
            scrollX = i10;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            t();
            return false;
        }
        if (action != 0) {
            if (this.f2940w) {
                return true;
            }
            if (this.f2941x) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.D = x10;
            this.B = x10;
            float y4 = motionEvent.getY();
            this.E = y4;
            this.C = y4;
            this.F = motionEvent.getPointerId(0);
            this.f2941x = false;
            this.f2928j = true;
            this.f2927i.computeScrollOffset();
            if (this.V != 2 || Math.abs(this.f2927i.getFinalX() - this.f2927i.getCurrX()) <= this.K) {
                d(false);
                this.f2940w = false;
            } else {
                this.f2927i.abortAnimation();
                this.f2938u = false;
                q();
                this.f2940w = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i3 = this.F;
            if (i3 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i3);
                float x11 = motionEvent.getX(findPointerIndex);
                float f2 = x11 - this.B;
                float abs = Math.abs(f2);
                float y10 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y10 - this.E);
                if (f2 != 0.0f) {
                    float f10 = this.B;
                    if ((f10 >= this.f2943z || f2 <= 0.0f) && ((f10 <= getWidth() - this.f2943z || f2 >= 0.0f) && c((int) f2, (int) x11, (int) y10, this, false))) {
                        this.B = x11;
                        this.C = y10;
                        this.f2941x = true;
                        return false;
                    }
                }
                float f11 = this.A;
                if (abs > f11 && abs * 0.5f > abs2) {
                    this.f2940w = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f12 = this.D;
                    float f13 = this.A;
                    this.B = f2 > 0.0f ? f12 + f13 : f12 - f13;
                    this.C = y10;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > f11) {
                    this.f2941x = true;
                }
                if (this.f2940w && p(x11)) {
                    WeakHashMap weakHashMap = z0.f15748a;
                    h0.k(this);
                }
            }
        } else if (action == 6) {
            m(motionEvent);
        }
        if (this.G == null) {
            this.G = VelocityTracker.obtain();
        }
        this.G.addMovement(motionEvent);
        return this.f2940w;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i10) {
        h hVar;
        h hVar2;
        int i11;
        setMeasuredDimension(View.getDefaultSize(0, i3), View.getDefaultSize(0, i10));
        int measuredWidth = getMeasuredWidth();
        this.f2943z = Math.min(measuredWidth / 10, this.f2942y);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i12 = 0;
        while (true) {
            boolean z5 = true;
            int i13 = 1073741824;
            if (i12 >= childCount) {
                break;
            }
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8 && (hVar2 = (h) childAt.getLayoutParams()) != null && hVar2.f16372a) {
                int i14 = hVar2.f16373b;
                int i15 = i14 & 7;
                int i16 = i14 & 112;
                boolean z6 = i16 == 48 || i16 == 80;
                if (i15 != 3 && i15 != 5) {
                    z5 = false;
                }
                int i17 = Integer.MIN_VALUE;
                if (z6) {
                    i11 = Integer.MIN_VALUE;
                    i17 = 1073741824;
                } else {
                    i11 = z5 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i18 = ((ViewGroup.LayoutParams) hVar2).width;
                if (i18 != -2) {
                    if (i18 == -1) {
                        i18 = paddingLeft;
                    }
                    i17 = 1073741824;
                } else {
                    i18 = paddingLeft;
                }
                int i19 = ((ViewGroup.LayoutParams) hVar2).height;
                if (i19 == -2) {
                    i19 = measuredHeight;
                    i13 = i11;
                } else if (i19 == -1) {
                    i19 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i18, i17), View.MeasureSpec.makeMeasureSpec(i19, i13));
                if (z6) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z5) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i12++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.r = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f2936s = true;
        q();
        this.f2936s = false;
        int childCount2 = getChildCount();
        for (int i20 = 0; i20 < childCount2; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8 && ((hVar = (h) childAt2.getLayoutParams()) == null || !hVar.f16372a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * hVar.f16374c), 1073741824), this.r);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i3, Rect rect) {
        int i10;
        int i11;
        int i12;
        g h4;
        int childCount = getChildCount();
        if ((i3 & 2) != 0) {
            i11 = childCount;
            i10 = 0;
            i12 = 1;
        } else {
            i10 = childCount - 1;
            i11 = -1;
            i12 = -1;
        }
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (h4 = h(childAt)) != null && h4.f16369b == this.f2924f && childAt.requestFocus(i3, rect)) {
                return true;
            }
            i10 += i12;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (this.e != null) {
            w(savedState.f2944a, 0, false, true);
        } else {
            this.f2925g = savedState.f2944a;
            this.f2926h = savedState.f2945b;
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2944a = this.f2924f;
        if (this.e != null) {
            savedState.f2945b = null;
        }
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        super.onSizeChanged(i3, i10, i11, i12);
        if (i3 != i11) {
            int i13 = this.f2930l;
            s(i3, i11, i13, i13);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        n2.a aVar;
        boolean z5 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.e) == null || aVar.c() == 0) {
            return false;
        }
        if (this.G == null) {
            this.G = VelocityTracker.obtain();
        }
        this.G.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f2927i.abortAnimation();
            this.f2938u = false;
            q();
            float x10 = motionEvent.getX();
            this.D = x10;
            this.B = x10;
            float y4 = motionEvent.getY();
            this.E = y4;
            this.C = y4;
            this.F = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.f2940w) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.F);
                    if (findPointerIndex == -1) {
                        z5 = t();
                    } else {
                        float x11 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x11 - this.B);
                        float y10 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y10 - this.C);
                        if (abs > this.A && abs > abs2) {
                            this.f2940w = true;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                            float f2 = this.D;
                            this.B = x11 - f2 > 0.0f ? f2 + this.A : f2 - this.A;
                            this.C = y10;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f2940w) {
                    z5 = p(motionEvent.getX(motionEvent.findPointerIndex(this.F)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.B = motionEvent.getX(actionIndex);
                    this.F = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    m(motionEvent);
                    this.B = motionEvent.getX(motionEvent.findPointerIndex(this.F));
                }
            } else if (this.f2940w) {
                u(this.f2924f, 0, true, false);
                z5 = t();
            }
        } else if (this.f2940w) {
            VelocityTracker velocityTracker = this.G;
            velocityTracker.computeCurrentVelocity(1000, this.I);
            int xVelocity = (int) velocityTracker.getXVelocity(this.F);
            this.f2938u = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            g i3 = i();
            float f10 = clientWidth;
            int i10 = i3.f16369b;
            float f11 = ((scrollX / f10) - i3.e) / (i3.f16371d + (this.f2930l / f10));
            if (Math.abs((int) (motionEvent.getX(motionEvent.findPointerIndex(this.F)) - this.D)) <= this.J || Math.abs(xVelocity) <= this.H) {
                i10 += (int) (f11 + (i10 >= this.f2924f ? 0.4f : 0.6f));
            } else if (xVelocity <= 0) {
                i10++;
            }
            ArrayList arrayList = this.f2921b;
            if (arrayList.size() > 0) {
                i10 = Math.max(((g) arrayList.get(0)).f16369b, Math.min(i10, ((g) l0.h(1, arrayList)).f16369b));
            }
            w(i10, xVelocity, true, true);
            z5 = t();
        }
        if (z5) {
            WeakHashMap weakHashMap = z0.f15748a;
            h0.k(this);
        }
        return true;
    }

    public final boolean p(float f2) {
        boolean z5;
        boolean z6;
        float f10 = this.B - f2;
        this.B = f2;
        float scrollX = getScrollX() + f10;
        float clientWidth = getClientWidth();
        float f11 = this.f2934p * clientWidth;
        float f12 = this.f2935q * clientWidth;
        ArrayList arrayList = this.f2921b;
        boolean z8 = false;
        g gVar = (g) arrayList.get(0);
        g gVar2 = (g) l0.h(1, arrayList);
        if (gVar.f16369b != 0) {
            f11 = gVar.e * clientWidth;
            z5 = false;
        } else {
            z5 = true;
        }
        if (gVar2.f16369b != this.e.c() - 1) {
            f12 = gVar2.e * clientWidth;
            z6 = false;
        } else {
            z6 = true;
        }
        if (scrollX < f11) {
            if (z5) {
                this.L.onPull(Math.abs(f11 - scrollX) / clientWidth);
                z8 = true;
            }
            scrollX = f11;
        } else if (scrollX > f12) {
            if (z6) {
                this.M.onPull(Math.abs(scrollX - f12) / clientWidth);
                z8 = true;
            }
            scrollX = f12;
        }
        int i3 = (int) scrollX;
        this.B = (scrollX - i3) + this.B;
        scrollTo(i3, getScrollY());
        o(i3);
        return z8;
    }

    public final void q() {
        r(this.f2924f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        if (r10 == r11) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0301  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(int r18) {
        /*
            Method dump skipped, instructions count: 882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.r(int):void");
    }

    public void removeOnAdapterChangeListener(i iVar) {
        ArrayList arrayList = this.T;
        if (arrayList != null) {
            arrayList.remove(iVar);
        }
    }

    public void removeOnPageChangeListener(j jVar) {
        ArrayList arrayList = this.Q;
        if (arrayList != null) {
            arrayList.remove(jVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.f2936s) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final void s(int i3, int i10, int i11, int i12) {
        if (i10 > 0 && !this.f2921b.isEmpty()) {
            if (!this.f2927i.isFinished()) {
                this.f2927i.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i10 - getPaddingLeft()) - getPaddingRight()) + i12)) * (((i3 - getPaddingLeft()) - getPaddingRight()) + i11)), getScrollY());
                return;
            }
        }
        g j4 = j(this.f2924f);
        int min = (int) ((j4 != null ? Math.min(j4.e, this.f2935q) : 0.0f) * ((i3 - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            d(false);
            scrollTo(min, getScrollY());
        }
    }

    public void setAdapter(n2.a aVar) {
        ArrayList arrayList;
        n2.a aVar2 = this.e;
        if (aVar2 != null) {
            synchronized (aVar2) {
                aVar2.f16361b = null;
            }
            this.e.j(this);
            int i3 = 0;
            while (true) {
                arrayList = this.f2921b;
                if (i3 >= arrayList.size()) {
                    break;
                }
                g gVar = (g) arrayList.get(i3);
                this.e.a(this, gVar.f16369b, gVar.f16368a);
                i3++;
            }
            this.e.b();
            arrayList.clear();
            int i10 = 0;
            while (i10 < getChildCount()) {
                if (!((h) getChildAt(i10).getLayoutParams()).f16372a) {
                    removeViewAt(i10);
                    i10--;
                }
                i10++;
            }
            this.f2924f = 0;
            scrollTo(0, 0);
        }
        n2.a aVar3 = this.e;
        this.e = aVar;
        this.f2920a = 0;
        if (aVar != null) {
            if (this.f2929k == null) {
                this.f2929k = new d2(this, 2);
            }
            n2.a aVar4 = this.e;
            d2 d2Var = this.f2929k;
            synchronized (aVar4) {
                aVar4.f16361b = d2Var;
            }
            this.f2938u = false;
            boolean z5 = this.N;
            this.N = true;
            this.f2920a = this.e.c();
            if (this.f2925g >= 0) {
                this.e.getClass();
                w(this.f2925g, 0, false, true);
                this.f2925g = -1;
                this.f2926h = null;
            } else if (z5) {
                requestLayout();
            } else {
                q();
            }
        }
        ArrayList arrayList2 = this.T;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        int size = this.T.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((i) this.T.get(i11)).c(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i3) {
        this.f2938u = false;
        w(i3, 0, !this.N, false);
    }

    public void setOffscreenPageLimit(int i3) {
        if (i3 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i3 + " too small; defaulting to 1");
            i3 = 1;
        }
        if (i3 != this.f2939v) {
            this.f2939v = i3;
            q();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.R = jVar;
    }

    public void setPageMargin(int i3) {
        int i10 = this.f2930l;
        this.f2930l = i3;
        int width = getWidth();
        s(width, width, i3, i10);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f2931m = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i3) {
        if (this.V == i3) {
            return;
        }
        this.V = i3;
        j jVar = this.R;
        if (jVar != null) {
            jVar.a(i3);
        }
        ArrayList arrayList = this.Q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                j jVar2 = (j) this.Q.get(i10);
                if (jVar2 != null) {
                    jVar2.a(i3);
                }
            }
        }
        j jVar3 = this.S;
        if (jVar3 != null) {
            jVar3.a(i3);
        }
    }

    public final boolean t() {
        this.F = -1;
        this.f2940w = false;
        this.f2941x = false;
        VelocityTracker velocityTracker = this.G;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.G = null;
        }
        this.L.onRelease();
        this.M.onRelease();
        return this.L.isFinished() || this.M.isFinished();
    }

    public final void u(int i3, int i10, boolean z5, boolean z6) {
        int scrollX;
        int abs;
        g j4 = j(i3);
        int max = j4 != null ? (int) (Math.max(this.f2934p, Math.min(j4.e, this.f2935q)) * getClientWidth()) : 0;
        if (!z5) {
            if (z6) {
                f(i3);
            }
            d(false);
            scrollTo(max, 0);
            o(max);
            return;
        }
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
        } else {
            Scroller scroller = this.f2927i;
            if (scroller == null || scroller.isFinished()) {
                scrollX = getScrollX();
            } else {
                scrollX = this.f2928j ? this.f2927i.getCurrX() : this.f2927i.getStartX();
                this.f2927i.abortAnimation();
                setScrollingCacheEnabled(false);
            }
            int i11 = scrollX;
            int scrollY = getScrollY();
            int i12 = max - i11;
            int i13 = 0 - scrollY;
            if (i12 == 0 && i13 == 0) {
                d(false);
                q();
                setScrollState(0);
            } else {
                setScrollingCacheEnabled(true);
                setScrollState(2);
                int clientWidth = getClientWidth();
                int i14 = clientWidth / 2;
                float f2 = clientWidth;
                float f10 = i14;
                float sin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i12) * 1.0f) / f2) - 0.5f) * 0.47123894f)) * f10) + f10;
                int abs2 = Math.abs(i10);
                if (abs2 > 0) {
                    abs = Math.round(Math.abs(sin / abs2) * 1000.0f) * 4;
                } else {
                    this.e.getClass();
                    abs = (int) (((Math.abs(i12) / ((f2 * 1.0f) + this.f2930l)) + 1.0f) * 100.0f);
                }
                int min = Math.min(abs, FontStyle.WEIGHT_SEMI_BOLD);
                this.f2928j = false;
                this.f2927i.startScroll(i11, scrollY, i12, i13, min);
                WeakHashMap weakHashMap = z0.f15748a;
                h0.k(this);
            }
        }
        if (z6) {
            f(i3);
        }
    }

    public void v(int i3, boolean z5) {
        this.f2938u = false;
        w(i3, 0, z5, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2931m;
    }

    public final void w(int i3, int i10, boolean z5, boolean z6) {
        n2.a aVar = this.e;
        if (aVar == null || aVar.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        ArrayList arrayList = this.f2921b;
        if (!z6 && this.f2924f == i3 && arrayList.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 >= this.e.c()) {
            i3 = this.e.c() - 1;
        }
        int i11 = this.f2939v;
        int i12 = this.f2924f;
        if (i3 > i12 + i11 || i3 < i12 - i11) {
            for (int i13 = 0; i13 < arrayList.size(); i13++) {
                ((g) arrayList.get(i13)).f16370c = true;
            }
        }
        boolean z8 = this.f2924f != i3;
        if (!this.N) {
            r(i3);
            u(i3, i10, z5, z8);
        } else {
            this.f2924f = i3;
            if (z8) {
                f(i3);
            }
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        h hVar = new h(context, attributeSet);
        hVar.f16374c = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W);
        hVar.f16373b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
        return hVar;
    }

    public void setPageMarginDrawable(int i3) {
        setPageMarginDrawable(c.b(getContext(), i3));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2921b = new ArrayList();
        this.f2922c = new g();
        this.f2923d = new Rect();
        this.f2925g = -1;
        this.f2926h = null;
        this.f2934p = -3.4028235E38f;
        this.f2935q = Float.MAX_VALUE;
        this.f2939v = 1;
        this.F = -1;
        this.N = true;
        this.U = new androidx.activity.e(this, 21);
        this.V = 0;
        k();
    }
}
