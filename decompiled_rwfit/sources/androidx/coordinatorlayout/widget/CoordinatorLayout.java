package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.e1;
import j2.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import k1.e;
import l1.h0;
import l1.i0;
import l1.l0;
import l1.n;
import l1.n0;
import l1.t;
import l1.u;
import l1.x1;
import l1.z0;
import m0.k;
import v2.h;
import x0.b;
import x0.c;
import x0.d;
import x0.f;
import x0.g;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements t, u {

    /* renamed from: t, reason: collision with root package name */
    public static final String f1882t;

    /* renamed from: u, reason: collision with root package name */
    public static final Class[] f1883u;

    /* renamed from: v, reason: collision with root package name */
    public static final ThreadLocal f1884v;

    /* renamed from: w, reason: collision with root package name */
    public static final androidx.viewpager2.widget.a f1885w;

    /* renamed from: x, reason: collision with root package name */
    public static final e f1886x;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1887a;

    /* renamed from: b, reason: collision with root package name */
    public final h f1888b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1889c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1890d;
    public final int[] e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f1891f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1892g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1893h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f1894i;

    /* renamed from: j, reason: collision with root package name */
    public View f1895j;

    /* renamed from: k, reason: collision with root package name */
    public View f1896k;

    /* renamed from: l, reason: collision with root package name */
    public y f1897l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1898m;

    /* renamed from: n, reason: collision with root package name */
    public x1 f1899n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1900o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f1901p;

    /* renamed from: q, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f1902q;
    public n6.a r;

    /* renamed from: s, reason: collision with root package name */
    public final e1 f1903s;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public SparseArray f1904a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1904a = new SparseArray(readInt);
            for (int i3 = 0; i3 < readInt; i3++) {
                this.f1904a.append(iArr[i3], readParcelableArray[i3]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            SparseArray sparseArray = this.f1904a;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = this.f1904a.keyAt(i10);
                parcelableArr[i10] = (Parcelable) this.f1904a.valueAt(i10);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i3);
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f1882t = r02 != null ? r02.getName() : null;
        f1885w = new androidx.viewpager2.widget.a(14);
        f1883u = new Class[]{Context.class, AttributeSet.class};
        f1884v = new ThreadLocal();
        f1886x = new e(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public static void A(int i3, View view) {
        f fVar = (f) view.getLayoutParams();
        int i10 = fVar.f19723i;
        if (i10 != i3) {
            WeakHashMap weakHashMap = z0.f15748a;
            view.offsetLeftAndRight(i3 - i10);
            fVar.f19723i = i3;
        }
    }

    public static void B(int i3, View view) {
        f fVar = (f) view.getLayoutParams();
        int i10 = fVar.f19724j;
        if (i10 != i3) {
            WeakHashMap weakHashMap = z0.f15748a;
            view.offsetTopAndBottom(i3 - i10);
            fVar.f19724j = i3;
        }
    }

    public static Rect k() {
        Rect rect = (Rect) f1886x.a();
        return rect == null ? new Rect() : rect;
    }

    public static void q(int i3, Rect rect, Rect rect2, f fVar, int i10, int i11) {
        int i12 = fVar.f19718c;
        if (i12 == 0) {
            i12 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i12, i3);
        int i13 = fVar.f19719d;
        if ((i13 & 7) == 0) {
            i13 |= 8388611;
        }
        if ((i13 & 112) == 0) {
            i13 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i13, i3);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int i16 = absoluteGravity2 & 7;
        int i17 = absoluteGravity2 & 112;
        int width = i16 != 1 ? i16 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i17 != 16 ? i17 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i14 == 1) {
            width -= i10 / 2;
        } else if (i14 != 5) {
            width -= i10;
        }
        if (i15 == 16) {
            height -= i11 / 2;
        } else if (i15 != 80) {
            height -= i11;
        }
        rect2.set(width, height, i10 + width, i11 + height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f s(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f19717b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                c cVar = fVar.f19716a;
                if (cVar != behavior) {
                    if (cVar != null) {
                        cVar.f();
                    }
                    fVar.f19716a = behavior;
                    fVar.f19717b = true;
                    if (behavior != null) {
                        behavior.c(fVar);
                    }
                }
                fVar.f19717b = true;
                return fVar;
            }
            d dVar = null;
            for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                dVar = (d) cls.getAnnotation(d.class);
                if (dVar != null) {
                    break;
                }
            }
            if (dVar != null) {
                try {
                    c cVar2 = (c) dVar.value().getDeclaredConstructor(null).newInstance(null);
                    c cVar3 = fVar.f19716a;
                    if (cVar3 != cVar2) {
                        if (cVar3 != null) {
                            cVar3.f();
                        }
                        fVar.f19716a = cVar2;
                        fVar.f19717b = true;
                        if (cVar2 != null) {
                            cVar2.c(fVar);
                        }
                    }
                } catch (Exception e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            fVar.f19717b = true;
        }
        return fVar;
    }

    public final void C() {
        WeakHashMap weakHashMap = z0.f15748a;
        if (!h0.b(this)) {
            n0.u(this, null);
            return;
        }
        if (this.r == null) {
            this.r = new n6.a(this, 24);
        }
        n0.u(this, this.r);
        setSystemUiVisibility(1280);
    }

    @Override // l1.t
    public final void a(View view, View view2, int i3, int i10) {
        e1 e1Var = this.f1903s;
        if (i10 == 1) {
            e1Var.f2555c = i3;
        } else {
            e1Var.f2554b = i3;
        }
        this.f1896k = view2;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ((f) getChildAt(i11).getLayoutParams()).getClass();
        }
    }

    @Override // l1.t
    public final void b(View view, int i3, int i10, int[] iArr, int i11) {
        c cVar;
        int childCount = getChildCount();
        boolean z5 = false;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i11) && (cVar = fVar.f19716a) != null) {
                    int[] iArr2 = this.e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.k(this, childAt, view, i3, i10, iArr2, i11);
                    i12 = i3 > 0 ? Math.max(i12, iArr2[0]) : Math.min(i12, iArr2[0]);
                    i13 = i10 > 0 ? Math.max(i13, iArr2[1]) : Math.min(i13, iArr2[1]);
                    z5 = true;
                }
            }
        }
        iArr[0] = i12;
        iArr[1] = i13;
        if (z5) {
            u(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        c cVar = ((f) view.getLayoutParams()).f19716a;
        if (cVar != null) {
            cVar.getClass();
        }
        return super.drawChild(canvas, view, j4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1901p;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // l1.t
    public final void f(int i3, View view) {
        e1 e1Var = this.f1903s;
        if (i3 == 1) {
            e1Var.f2555c = 0;
        } else {
            e1Var.f2554b = 0;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i3)) {
                c cVar = fVar.f19716a;
                if (cVar != null) {
                    cVar.q(this, childAt, view, i3);
                }
                if (i3 == 0) {
                    fVar.f19727m = false;
                } else if (i3 == 1) {
                    fVar.f19728n = false;
                }
                fVar.f19729o = false;
            }
        }
        this.f1896k = null;
    }

    @Override // l1.u
    public final void g(View view, int i3, int i10, int i11, int i12, int i13, int[] iArr) {
        c cVar;
        int childCount = getChildCount();
        int i14 = 0;
        int i15 = 0;
        boolean z5 = false;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i13) && (cVar = fVar.f19716a) != null) {
                    int[] iArr2 = this.e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.l(this, childAt, i10, i11, i12, iArr2);
                    i14 = i11 > 0 ? Math.max(i14, iArr2[0]) : Math.min(i14, iArr2[0]);
                    i15 = i12 > 0 ? Math.max(i15, iArr2[1]) : Math.min(i15, iArr2[1]);
                    z5 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i14;
        iArr[1] = iArr[1] + i15;
        if (z5) {
            u(1);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        y();
        return Collections.unmodifiableList(this.f1887a);
    }

    public final x1 getLastWindowInsets() {
        return this.f1899n;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        e1 e1Var = this.f1903s;
        return e1Var.f2555c | e1Var.f2554b;
    }

    public Drawable getStatusBarBackground() {
        return this.f1901p;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    @Override // l1.t
    public final void i(View view, int i3, int i10, int i11, int i12, int i13) {
        g(view, i3, i10, i11, i12, 0, this.f1891f);
    }

    @Override // l1.t
    public final boolean j(View view, View view2, int i3, int i10) {
        int childCount = getChildCount();
        boolean z5 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVar = fVar.f19716a;
                if (cVar != null) {
                    boolean p8 = cVar.p(this, childAt, view, view2, i3, i10);
                    z5 |= p8;
                    if (i10 == 0) {
                        fVar.f19727m = p8;
                    } else if (i10 == 1) {
                        fVar.f19728n = p8;
                    }
                } else if (i10 == 0) {
                    fVar.f19727m = false;
                } else if (i10 == 1) {
                    fVar.f19728n = false;
                }
            }
        }
        return z5;
    }

    public final void l(f fVar, Rect rect, int i3, int i10) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i10) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i3 + max, i10 + max2);
    }

    public final void m(View view) {
        List list = (List) ((k) this.f1888b.f19147b).getOrDefault(view, null);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            View view2 = (View) list.get(i3);
            c cVar = ((f) view2.getLayoutParams()).f19716a;
            if (cVar != null) {
                cVar.d(this, view2, view);
            }
        }
    }

    public final void n(View view, Rect rect, boolean z5) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z5) {
            p(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList o(View view) {
        k kVar = (k) this.f1888b.f19147b;
        int i3 = kVar.f15919c;
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < i3; i10++) {
            ArrayList arrayList2 = (ArrayList) kVar.l(i10);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVar.h(i10));
            }
        }
        ArrayList arrayList3 = this.f1890d;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        z(false);
        if (this.f1898m) {
            if (this.f1897l == null) {
                this.f1897l = new y(this, 2);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1897l);
        }
        if (this.f1899n == null) {
            WeakHashMap weakHashMap = z0.f15748a;
            if (h0.b(this)) {
                l0.c(this);
            }
        }
        this.f1893h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z(false);
        if (this.f1898m && this.f1897l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1897l);
        }
        View view = this.f1896k;
        if (view != null) {
            f(0, view);
        }
        this.f1893h = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f1900o || this.f1901p == null) {
            return;
        }
        x1 x1Var = this.f1899n;
        int d5 = x1Var != null ? x1Var.d() : 0;
        if (d5 > 0) {
            this.f1901p.setBounds(0, 0, getWidth(), d5);
            this.f1901p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z(true);
        }
        boolean x10 = x(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return x10;
        }
        z(true);
        return x10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        c cVar;
        WeakHashMap weakHashMap = z0.f15748a;
        int d5 = i0.d(this);
        ArrayList arrayList = this.f1887a;
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            View view = (View) arrayList.get(i13);
            if (view.getVisibility() != 8 && ((cVar = ((f) view.getLayoutParams()).f19716a) == null || !cVar.h(this, view, d5))) {
                v(d5, view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r28, int r29) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f10, boolean z5) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0)) {
                    c cVar = fVar.f19716a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f10) {
        c cVar;
        int childCount = getChildCount();
        boolean z5 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.f19716a) != null) {
                    z5 |= cVar.j(view);
                }
            }
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i3, int i10, int[] iArr) {
        b(view, i3, i10, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i3, int i10, int i11, int i12) {
        i(view, i3, i10, i11, i12, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i3) {
        a(view, view2, i3, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray sparseArray = savedState.f1904a;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id2 = childAt.getId();
            c cVar = s(childAt).f19716a;
            if (id2 != -1 && cVar != null && (parcelable2 = (Parcelable) sparseArray.get(id2)) != null) {
                cVar.n(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable o3;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id2 = childAt.getId();
            c cVar = ((f) childAt.getLayoutParams()).f19716a;
            if (id2 != -1 && cVar != null && (o3 = cVar.o(childAt)) != null) {
                sparseArray.append(id2, o3);
            }
        }
        savedState.f1904a = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i3) {
        return j(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        f(0, view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.f1895j
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.x(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f1895j
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            x0.f r6 = (x0.f) r6
            x0.c r6 = r6.f19716a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f1895j
            boolean r6 = r6.r(r0, r7, r1)
        L2a:
            android.view.View r7 = r0.f1895j
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L53
            goto L54
        L53:
            return r6
        L54:
            r0.z(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(View view, Rect rect) {
        ThreadLocal threadLocal = g.f19731a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = g.f19731a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        g.a(this, view, matrix);
        ThreadLocal threadLocal3 = g.f19732b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int r(int i3) {
        int[] iArr = this.f1894i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i3);
            return 0;
        }
        if (i3 >= 0 && i3 < iArr.length) {
            return iArr[i3];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i3 + " out of range for " + this);
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        c cVar = ((f) view.getLayoutParams()).f19716a;
        if (cVar == null || !cVar.m(this, view, rect, z5)) {
            return super.requestChildRectangleOnScreen(view, rect, z5);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z5) {
        super.requestDisallowInterceptTouchEvent(z5);
        if (!z5 || this.f1892g) {
            return;
        }
        z(false);
        this.f1892g = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z5) {
        super.setFitsSystemWindows(z5);
        C();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1902q = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f1901p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f1901p = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f1901p.setState(getDrawableState());
                }
                Drawable drawable3 = this.f1901p;
                WeakHashMap weakHashMap = z0.f15748a;
                d1.c.b(drawable3, i0.d(this));
                this.f1901p.setVisible(getVisibility() == 0, false);
                this.f1901p.setCallback(this);
            }
            WeakHashMap weakHashMap2 = z0.f15748a;
            h0.k(this);
        }
    }

    public void setStatusBarBackgroundColor(int i3) {
        setStatusBarBackground(new ColorDrawable(i3));
    }

    public void setStatusBarBackgroundResource(int i3) {
        setStatusBarBackground(i3 != 0 ? a1.c.b(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z5 = i3 == 0;
        Drawable drawable = this.f1901p;
        if (drawable == null || drawable.isVisible() == z5) {
            return;
        }
        this.f1901p.setVisible(z5, false);
    }

    public final boolean t(View view, int i3, int i10) {
        e eVar = f1886x;
        Rect k10 = k();
        p(view, k10);
        try {
            return k10.contains(i3, i10);
        } finally {
            k10.setEmpty();
            eVar.c(k10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0291 A[EDGE_INSN: B:133:0x0291->B:105:0x0291 BREAK  A[LOOP:2: B:110:0x02a9->B:121:0x02e5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(int r26) {
        /*
            Method dump skipped, instructions count: 781
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.u(int):void");
    }

    public final void v(int i3, View view) {
        Rect k10;
        Rect k11;
        f fVar = (f) view.getLayoutParams();
        View view2 = fVar.f19725k;
        if (view2 == null && fVar.f19720f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        e eVar = f1886x;
        if (view2 != null) {
            k10 = k();
            k11 = k();
            try {
                p(view2, k10);
                f fVar2 = (f) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                q(i3, k10, k11, fVar2, measuredWidth, measuredHeight);
                l(fVar2, k11, measuredWidth, measuredHeight);
                view.layout(k11.left, k11.top, k11.right, k11.bottom);
                return;
            } finally {
                k10.setEmpty();
                eVar.c(k10);
                k11.setEmpty();
                eVar.c(k11);
            }
        }
        int i10 = fVar.e;
        if (i10 < 0) {
            f fVar3 = (f) view.getLayoutParams();
            k10 = k();
            k10.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
            if (this.f1899n != null) {
                WeakHashMap weakHashMap = z0.f15748a;
                if (h0.b(this) && !h0.b(view)) {
                    k10.left = this.f1899n.b() + k10.left;
                    k10.top = this.f1899n.d() + k10.top;
                    k10.right -= this.f1899n.c();
                    k10.bottom -= this.f1899n.a();
                }
            }
            k11 = k();
            int i11 = fVar3.f19718c;
            if ((i11 & 7) == 0) {
                i11 |= 8388611;
            }
            if ((i11 & 112) == 0) {
                i11 |= 48;
            }
            n.b(i11, view.getMeasuredWidth(), view.getMeasuredHeight(), k10, k11, i3);
            view.layout(k11.left, k11.top, k11.right, k11.bottom);
            return;
        }
        f fVar4 = (f) view.getLayoutParams();
        int i12 = fVar4.f19718c;
        if (i12 == 0) {
            i12 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i12, i3);
        int i13 = absoluteGravity & 7;
        int i14 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i3 == 1) {
            i10 = width - i10;
        }
        int r = r(i10) - measuredWidth2;
        if (i13 == 1) {
            r += measuredWidth2 / 2;
        } else if (i13 == 5) {
            r += measuredWidth2;
        }
        int i15 = i14 != 16 ? i14 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin, Math.min(r, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin, Math.min(i15, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin));
        view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1901p;
    }

    public final void w(int i3, int i10, int i11, View view) {
        measureChildWithMargins(view, i3, i10, i11, 0);
    }

    public final boolean x(MotionEvent motionEvent, int i3) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f1889c;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            arrayList.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i10) : i10));
        }
        androidx.viewpager2.widget.a aVar = f1885w;
        if (aVar != null) {
            Collections.sort(arrayList, aVar);
        }
        int size = arrayList.size();
        MotionEvent motionEvent2 = null;
        boolean z5 = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) arrayList.get(i11);
            c cVar = ((f) view.getLayoutParams()).f19716a;
            if (z5 && actionMasked != 0) {
                if (cVar != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i3 == 0) {
                        cVar.g(this, view, motionEvent2);
                    } else if (i3 == 1) {
                        cVar.r(this, view, motionEvent2);
                    }
                }
            } else if (!z5 && cVar != null) {
                if (i3 == 0) {
                    z5 = cVar.g(this, view, motionEvent);
                } else if (i3 == 1) {
                    z5 = cVar.r(this, view, motionEvent);
                }
                if (z5) {
                    this.f1895j = view;
                }
            }
        }
        arrayList.clear();
        return z5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f9, code lost:
    
        if ((android.view.Gravity.getAbsoluteGravity(r8.f19722h, r12) & r13) == r13) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0146, code lost:
    
        throw new java.lang.IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y() {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.y():void");
    }

    public final void z(boolean z5) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            c cVar = ((f) childAt.getLayoutParams()).f19716a;
            if (cVar != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z5) {
                    cVar.g(this, childAt, obtain);
                } else {
                    cVar.r(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            ((f) getChildAt(i10).getLayoutParams()).getClass();
        }
        this.f1895j = null;
        this.f1892g = false;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.coordinatorLayoutStyle);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes;
        CoordinatorLayout coordinatorLayout;
        Context context2;
        this.f1887a = new ArrayList();
        this.f1888b = new h(9);
        this.f1889c = new ArrayList();
        this.f1890d = new ArrayList();
        this.e = new int[2];
        this.f1891f = new int[2];
        this.f1903s = new e1(3);
        if (i3 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i3, 0);
        }
        TypedArray typedArray = obtainStyledAttributes;
        if (Build.VERSION.SDK_INT < 29) {
            coordinatorLayout = this;
            context2 = context;
        } else if (i3 == 0) {
            coordinatorLayout = this;
            context2 = context;
            coordinatorLayout.saveAttributeDataForStyleable(context2, R$styleable.CoordinatorLayout, attributeSet, typedArray, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            context2 = context;
            coordinatorLayout = this;
            coordinatorLayout.saveAttributeDataForStyleable(context2, R$styleable.CoordinatorLayout, attributeSet, typedArray, i3, 0);
        }
        int resourceId = typedArray.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            coordinatorLayout.f1894i = intArray;
            float f2 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i10 = 0; i10 < length; i10++) {
                coordinatorLayout.f1894i[i10] = (int) (r12[i10] * f2);
            }
        }
        coordinatorLayout.f1901p = typedArray.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        C();
        super.setOnHierarchyChangeListener(new x0.e(this));
        WeakHashMap weakHashMap = z0.f15748a;
        if (h0.c(this) == 0) {
            h0.s(this, 1);
        }
    }
}
