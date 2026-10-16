package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.widget.j;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import androidx.recyclerview.widget.a2;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.h0;
import l1.i0;
import l1.n0;
import l1.x1;
import l1.z0;
import n.m0;
import p1.d;
import q1.b;
import q1.c;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    public static final int[] C = {R.attr.colorPrimaryDark};
    public static final int[] D = {R.attr.layout_gravity};
    public static final boolean E;
    public static final boolean F;
    public static final boolean G;
    public Matrix A;
    public final m0 B;

    /* renamed from: a, reason: collision with root package name */
    public final j f1993a;

    /* renamed from: b, reason: collision with root package name */
    public float f1994b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1995c;

    /* renamed from: d, reason: collision with root package name */
    public int f1996d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f1997f;

    /* renamed from: g, reason: collision with root package name */
    public final d f1998g;

    /* renamed from: h, reason: collision with root package name */
    public final d f1999h;

    /* renamed from: i, reason: collision with root package name */
    public final q1.d f2000i;

    /* renamed from: j, reason: collision with root package name */
    public final q1.d f2001j;

    /* renamed from: k, reason: collision with root package name */
    public int f2002k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2003l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2004m;

    /* renamed from: n, reason: collision with root package name */
    public int f2005n;

    /* renamed from: o, reason: collision with root package name */
    public int f2006o;

    /* renamed from: p, reason: collision with root package name */
    public int f2007p;

    /* renamed from: q, reason: collision with root package name */
    public int f2008q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f2009s;

    /* renamed from: t, reason: collision with root package name */
    public float f2010t;

    /* renamed from: u, reason: collision with root package name */
    public float f2011u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f2012v;

    /* renamed from: w, reason: collision with root package name */
    public WindowInsets f2013w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2014x;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f2015y;

    /* renamed from: z, reason: collision with root package name */
    public Rect f2016z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f2017a;

        /* renamed from: b, reason: collision with root package name */
        public int f2018b;

        /* renamed from: c, reason: collision with root package name */
        public int f2019c;

        /* renamed from: d, reason: collision with root package name */
        public int f2020d;
        public int e;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2017a = 0;
            this.f2017a = parcel.readInt();
            this.f2018b = parcel.readInt();
            this.f2019c = parcel.readInt();
            this.f2020d = parcel.readInt();
            this.e = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f2017a);
            parcel.writeInt(this.f2018b);
            parcel.writeInt(this.f2019c);
            parcel.writeInt(this.f2020d);
            parcel.writeInt(this.e);
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        E = true;
        F = true;
        G = i3 >= 29;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public static String j(int i3) {
        return (i3 & 3) == 3 ? "LEFT" : (i3 & 5) == 5 ? "RIGHT" : Integer.toHexString(i3);
    }

    public static boolean k(View view) {
        WeakHashMap weakHashMap = z0.f15748a;
        return (h0.c(view) == 4 || h0.c(view) == 2) ? false : true;
    }

    public static boolean l(View view) {
        return ((c) view.getLayoutParams()).f17729a == 0;
    }

    public static boolean m(View view) {
        if (n(view)) {
            return (((c) view.getLayoutParams()).f17732d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public static boolean n(View view) {
        int i3 = ((c) view.getLayoutParams()).f17729a;
        WeakHashMap weakHashMap = z0.f15748a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i3, i0.d(view));
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    public final boolean a(int i3, View view) {
        return (i(view) & i3) == i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i3, int i10) {
        ArrayList arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i11 = 0;
        boolean z5 = false;
        while (true) {
            arrayList2 = this.f2015y;
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (!n(childAt)) {
                arrayList2.add(childAt);
            } else if (m(childAt)) {
                childAt.addFocusables(arrayList, i3, i10);
                z5 = true;
            }
            i11++;
        }
        if (!z5) {
            int size = arrayList2.size();
            for (int i12 = 0; i12 < size; i12++) {
                View view = (View) arrayList2.get(i12);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i3, i10);
                }
            }
        }
        arrayList2.clear();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (f() != null || n(view)) {
            WeakHashMap weakHashMap = z0.f15748a;
            h0.s(view, 4);
        } else {
            WeakHashMap weakHashMap2 = z0.f15748a;
            h0.s(view, 1);
        }
        if (E) {
            return;
        }
        z0.n(view, this.f1993a);
    }

    public final void b(View view) {
        if (!n(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        c cVar = (c) view.getLayoutParams();
        if (this.f2004m) {
            cVar.f17730b = 0.0f;
            cVar.f17732d = 0;
        } else {
            cVar.f17732d |= 4;
            if (a(3, view)) {
                this.f1998g.s(view, -view.getWidth(), view.getTop());
            } else {
                this.f1999h.s(view, getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public final void c() {
        View e = e(8388611);
        if (e != null) {
            b(e);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + j(8388611));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            f2 = Math.max(f2, ((c) getChildAt(i3).getLayoutParams()).f17730b);
        }
        this.e = f2;
        boolean g10 = this.f1998g.g();
        boolean g11 = this.f1999h.g();
        if (g10 || g11) {
            WeakHashMap weakHashMap = z0.f15748a;
            h0.k(this);
        }
    }

    public final void d(boolean z5) {
        int childCount = getChildCount();
        boolean z6 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            c cVar = (c) childAt.getLayoutParams();
            if (n(childAt) && (!z5 || cVar.f17731c)) {
                z6 |= a(3, childAt) ? this.f1998g.s(childAt, -childAt.getWidth(), childAt.getTop()) : this.f1999h.s(childAt, getWidth(), childAt.getTop());
                cVar.f17731c = false;
            }
        }
        q1.d dVar = this.f2000i;
        dVar.f17736d.removeCallbacks(dVar.f17735c);
        q1.d dVar2 = this.f2001j;
        dVar2.f17736d.removeCallbacks(dVar2.f17735c);
        if (z6) {
            invalidate();
        }
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean dispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y4 = motionEvent.getY();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt = getChildAt(i3);
            if (this.f2016z == null) {
                this.f2016z = new Rect();
            }
            childAt.getHitRect(this.f2016z);
            if (this.f2016z.contains((int) x10, (int) y4) && !l(childAt)) {
                if (childAt.getMatrix().isIdentity()) {
                    float scrollX = getScrollX() - childAt.getLeft();
                    float scrollY = getScrollY() - childAt.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                } else {
                    float scrollX2 = getScrollX() - childAt.getLeft();
                    float scrollY2 = getScrollY() - childAt.getTop();
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(scrollX2, scrollY2);
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.A == null) {
                            this.A = new Matrix();
                        }
                        matrix.invert(this.A);
                        obtain.transform(this.A);
                    }
                    dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(obtain);
                    obtain.recycle();
                }
                if (dispatchGenericMotionEvent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        Drawable background;
        int height = getHeight();
        boolean l3 = l(view);
        int width = getWidth();
        int save = canvas.save();
        int i3 = 0;
        if (l3) {
            int childCount = getChildCount();
            int i10 = 0;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && n(childAt) && childAt.getHeight() >= height) {
                    if (a(3, childAt)) {
                        int right = childAt.getRight();
                        if (right > i10) {
                            i10 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i10, 0, width, getHeight());
            i3 = i10;
        }
        boolean drawChild = super.drawChild(canvas, view, j4);
        canvas.restoreToCount(save);
        float f2 = this.e;
        if (f2 > 0.0f && l3) {
            int i12 = this.f1996d;
            Paint paint = this.f1997f;
            paint.setColor((((int) ((((-16777216) & i12) >>> 24) * f2)) << 24) | (i12 & 16777215));
            canvas.drawRect(i3, 0.0f, width, getHeight(), paint);
        }
        return drawChild;
    }

    public final View e(int i3) {
        WeakHashMap weakHashMap = z0.f15748a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i3, i0.d(this)) & 7;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((i(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    public final View f() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((((c) childAt.getLayoutParams()).f17732d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final View g() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (n(childAt)) {
                if (!n(childAt)) {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                if (((c) childAt.getLayoutParams()).f17730b > 0.0f) {
                    return childAt;
                }
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        c cVar = new c(-1, -1);
        cVar.f17729a = 0;
        return cVar;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof c) {
            c cVar = (c) layoutParams;
            c cVar2 = new c(cVar);
            cVar2.f17729a = 0;
            cVar2.f17729a = cVar.f17729a;
            return cVar2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            c cVar3 = new c((ViewGroup.MarginLayoutParams) layoutParams);
            cVar3.f17729a = 0;
            return cVar3;
        }
        c cVar4 = new c(layoutParams);
        cVar4.f17729a = 0;
        return cVar4;
    }

    public float getDrawerElevation() {
        if (F) {
            return this.f1994b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f2012v;
    }

    public final int h(View view) {
        if (!n(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        int i3 = ((c) view.getLayoutParams()).f17729a;
        WeakHashMap weakHashMap = z0.f15748a;
        int d5 = i0.d(this);
        if (i3 == 3) {
            int i10 = this.f2005n;
            if (i10 != 3) {
                return i10;
            }
            int i11 = d5 == 0 ? this.f2007p : this.f2008q;
            if (i11 != 3) {
                return i11;
            }
            return 0;
        }
        if (i3 == 5) {
            int i12 = this.f2006o;
            if (i12 != 3) {
                return i12;
            }
            int i13 = d5 == 0 ? this.f2008q : this.f2007p;
            if (i13 != 3) {
                return i13;
            }
            return 0;
        }
        if (i3 == 8388611) {
            int i14 = this.f2007p;
            if (i14 != 3) {
                return i14;
            }
            int i15 = d5 == 0 ? this.f2005n : this.f2006o;
            if (i15 != 3) {
                return i15;
            }
            return 0;
        }
        if (i3 != 8388613) {
            return 0;
        }
        int i16 = this.f2008q;
        if (i16 != 3) {
            return i16;
        }
        int i17 = d5 == 0 ? this.f2006o : this.f2005n;
        if (i17 != 3) {
            return i17;
        }
        return 0;
    }

    public final int i(View view) {
        int i3 = ((c) view.getLayoutParams()).f17729a;
        WeakHashMap weakHashMap = z0.f15748a;
        return Gravity.getAbsoluteGravity(i3, i0.d(this));
    }

    public final void o(View view) {
        if (!n(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        c cVar = (c) view.getLayoutParams();
        if (this.f2004m) {
            cVar.f17730b = 1.0f;
            cVar.f17732d = 1;
            t(view, true);
            s(view);
        } else {
            cVar.f17732d |= 2;
            if (a(3, view)) {
                this.f1998g.s(view, 0, view.getTop());
            } else {
                this.f1999h.s(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2004m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2004m = true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f2014x || this.f2012v == null) {
            return;
        }
        WindowInsets windowInsets = this.f2013w;
        int systemWindowInsetTop = windowInsets != null ? windowInsets.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f2012v.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f2012v.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        if (r0 != 3) goto L19;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getActionMasked()
            p1.d r1 = r8.f1998g
            boolean r2 = r1.r(r9)
            p1.d r3 = r8.f1999h
            boolean r3 = r3.r(r9)
            r2 = r2 | r3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L65
            if (r0 == r3) goto L5e
            r9 = 2
            if (r0 == r9) goto L1e
            r9 = 3
            if (r0 == r9) goto L5e
            goto L63
        L1e:
            float[] r9 = r1.f17372d
            int r9 = r9.length
            r0 = r4
        L22:
            if (r0 >= r9) goto L63
            int r5 = r1.f17378k
            int r6 = r3 << r0
            r5 = r5 & r6
            if (r5 == 0) goto L5b
            float[] r5 = r1.f17373f
            r5 = r5[r0]
            float[] r6 = r1.f17372d
            r6 = r6[r0]
            float r5 = r5 - r6
            float[] r6 = r1.f17374g
            r6 = r6[r0]
            float[] r7 = r1.e
            r7 = r7[r0]
            float r6 = r6 - r7
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r5 = r1.f17370b
            int r5 = r5 * r5
            float r5 = (float) r5
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L5b
            q1.d r9 = r8.f2000i
            pe.o r0 = r9.f17735c
            androidx.drawerlayout.widget.DrawerLayout r9 = r9.f17736d
            r9.removeCallbacks(r0)
            q1.d r9 = r8.f2001j
            pe.o r0 = r9.f17735c
            androidx.drawerlayout.widget.DrawerLayout r9 = r9.f17736d
            r9.removeCallbacks(r0)
            goto L63
        L5b:
            int r0 = r0 + 1
            goto L22
        L5e:
            r8.d(r3)
            r8.r = r4
        L63:
            r9 = r4
            goto L8b
        L65:
            float r0 = r9.getX()
            float r9 = r9.getY()
            r8.f2010t = r0
            r8.f2011u = r9
            float r5 = r8.e
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L88
            int r0 = (int) r0
            int r9 = (int) r9
            android.view.View r9 = r1.h(r0, r9)
            if (r9 == 0) goto L88
            boolean r9 = l(r9)
            if (r9 == 0) goto L88
            r9 = r3
            goto L89
        L88:
            r9 = r4
        L89:
            r8.r = r4
        L8b:
            if (r2 != 0) goto Lae
            if (r9 != 0) goto Lae
            int r9 = r8.getChildCount()
            r0 = r4
        L94:
            if (r0 >= r9) goto La8
            android.view.View r1 = r8.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            q1.c r1 = (q1.c) r1
            boolean r1 = r1.f17731c
            if (r1 == 0) goto La5
            goto Lae
        La5:
            int r0 = r0 + 1
            goto L94
        La8:
            boolean r9 = r8.r
            if (r9 == 0) goto Lad
            goto Lae
        Lad:
            return r4
        Lae:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 4 || g() == null) {
            return super.onKeyDown(i3, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            return super.onKeyUp(i3, keyEvent);
        }
        View g10 = g();
        if (g10 != null && h(g10) == 0) {
            d(false);
        }
        return g10 != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        WindowInsets rootWindowInsets;
        float f2;
        int i13;
        boolean z6 = true;
        this.f2003l = true;
        int i14 = i11 - i3;
        int childCount = getChildCount();
        int i15 = 0;
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (l(childAt)) {
                    int i16 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                    childAt.layout(i16, ((ViewGroup.MarginLayoutParams) cVar).topMargin, childAt.getMeasuredWidth() + i16, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) cVar).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(3, childAt)) {
                        float f10 = measuredWidth;
                        i13 = (-measuredWidth) + ((int) (cVar.f17730b * f10));
                        f2 = (measuredWidth + i13) / f10;
                    } else {
                        float f11 = measuredWidth;
                        f2 = (i14 - r11) / f11;
                        i13 = i14 - ((int) (cVar.f17730b * f11));
                    }
                    boolean z8 = f2 != cVar.f17730b ? z6 : false;
                    int i17 = cVar.f17729a & 112;
                    if (i17 == 16) {
                        int i18 = i12 - i10;
                        int i19 = (i18 - measuredHeight) / 2;
                        int i20 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
                        if (i19 < i20) {
                            i19 = i20;
                        } else {
                            int i21 = i19 + measuredHeight;
                            int i22 = i18 - ((ViewGroup.MarginLayoutParams) cVar).bottomMargin;
                            if (i21 > i22) {
                                i19 = i22 - measuredHeight;
                            }
                        }
                        childAt.layout(i13, i19, measuredWidth + i13, measuredHeight + i19);
                    } else if (i17 != 80) {
                        int i23 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
                        childAt.layout(i13, i23, measuredWidth + i13, measuredHeight + i23);
                    } else {
                        int i24 = i12 - i10;
                        childAt.layout(i13, (i24 - ((ViewGroup.MarginLayoutParams) cVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i13, i24 - ((ViewGroup.MarginLayoutParams) cVar).bottomMargin);
                    }
                    if (z8) {
                        r(childAt, f2);
                    }
                    int i25 = cVar.f17730b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i25) {
                        childAt.setVisibility(i25);
                    }
                }
            }
            i15++;
            z6 = true;
        }
        if (G && (rootWindowInsets = getRootWindowInsets()) != null) {
            c1.c i26 = x1.h(rootWindowInsets, null).f15738a.i();
            d dVar = this.f1998g;
            dVar.f17382o = Math.max(dVar.f17383p, i26.f3354a);
            d dVar2 = this.f1999h;
            dVar2.f17382o = Math.max(dVar2.f17383p, i26.f3356c);
        }
        this.f2003l = false;
        this.f2004m = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r19, int r20) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        View e;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i3 = savedState.f2017a;
        if (i3 != 0 && (e = e(i3)) != null) {
            o(e);
        }
        int i10 = savedState.f2018b;
        if (i10 != 3) {
            q(i10, 3);
        }
        int i11 = savedState.f2019c;
        if (i11 != 3) {
            q(i11, 5);
        }
        int i12 = savedState.f2020d;
        if (i12 != 3) {
            q(i12, 8388611);
        }
        int i13 = savedState.e;
        if (i13 != 3) {
            q(i13, 8388613);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i3) {
        if (F) {
            return;
        }
        WeakHashMap weakHashMap = z0.f15748a;
        i0.d(this);
        i0.d(this);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2017a = 0;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            int i10 = cVar.f17732d;
            boolean z5 = i10 == 1;
            boolean z6 = i10 == 2;
            if (z5 || z6) {
                savedState.f2017a = cVar.f17729a;
                break;
            }
        }
        savedState.f2018b = this.f2005n;
        savedState.f2019c = this.f2006o;
        savedState.f2020d = this.f2007p;
        savedState.e = this.f2008q;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (h(r7) != 2) goto L21;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            p1.d r0 = r6.f1998g
            r0.k(r7)
            p1.d r1 = r6.f1999h
            r1.k(r7)
            int r1 = r7.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L59
            if (r1 == r3) goto L20
            r7 = 3
            if (r1 == r7) goto L1a
            return r3
        L1a:
            r6.d(r3)
            r6.r = r2
            return r3
        L20:
            float r1 = r7.getX()
            float r7 = r7.getY()
            int r4 = (int) r1
            int r5 = (int) r7
            android.view.View r4 = r0.h(r4, r5)
            if (r4 == 0) goto L54
            boolean r4 = l(r4)
            if (r4 == 0) goto L54
            float r4 = r6.f2010t
            float r1 = r1 - r4
            float r4 = r6.f2011u
            float r7 = r7 - r4
            int r0 = r0.f17370b
            float r1 = r1 * r1
            float r7 = r7 * r7
            float r7 = r7 + r1
            int r0 = r0 * r0
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L54
            android.view.View r7 = r6.f()
            if (r7 == 0) goto L54
            int r7 = r6.h(r7)
            r0 = 2
            if (r7 != r0) goto L55
        L54:
            r2 = r3
        L55:
            r6.d(r2)
            return r3
        L59:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2010t = r0
            r6.f2011u = r7
            r6.r = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        View e = e(8388611);
        if (e != null) {
            o(e);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + j(8388611));
        }
    }

    public final void q(int i3, int i10) {
        View e;
        WeakHashMap weakHashMap = z0.f15748a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i10, i0.d(this));
        if (i10 == 3) {
            this.f2005n = i3;
        } else if (i10 == 5) {
            this.f2006o = i3;
        } else if (i10 == 8388611) {
            this.f2007p = i3;
        } else if (i10 == 8388613) {
            this.f2008q = i3;
        }
        if (i3 != 0) {
            (absoluteGravity == 3 ? this.f1998g : this.f1999h).a();
        }
        if (i3 != 1) {
            if (i3 == 2 && (e = e(absoluteGravity)) != null) {
                o(e);
                return;
            }
            return;
        }
        View e10 = e(absoluteGravity);
        if (e10 != null) {
            b(e10);
        }
    }

    public final void r(View view, float f2) {
        int size;
        c cVar = (c) view.getLayoutParams();
        if (f2 == cVar.f17730b) {
            return;
        }
        cVar.f17730b = f2;
        if (this.f2009s != null && r2.size() - 1 >= 0) {
            throw e.c(size, this.f2009s);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z5) {
        super.requestDisallowInterceptTouchEvent(z5);
        if (z5) {
            d(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f2003l) {
            return;
        }
        super.requestLayout();
    }

    public final void s(View view) {
        m1.c cVar = m1.c.f15930l;
        z0.j(cVar.a(), view);
        if (!m(view) || h(view) == 2) {
            return;
        }
        z0.l(view, cVar, this.B);
    }

    public void setDrawerElevation(float f2) {
        this.f1994b = f2;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (n(childAt)) {
                float f10 = this.f1994b;
                WeakHashMap weakHashMap = z0.f15748a;
                n0.s(childAt, f10);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(b bVar) {
        if (bVar != null) {
            if (this.f2009s == null) {
                this.f2009s = new ArrayList();
            }
            this.f2009s.add(bVar);
        }
    }

    public void setDrawerLockMode(int i3) {
        q(i3, 3);
        q(i3, 5);
    }

    public void setScrimColor(int i3) {
        this.f1996d = i3;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f2012v = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i3) {
        this.f2012v = new ColorDrawable(i3);
        invalidate();
    }

    public final void t(View view, boolean z5) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((z5 || n(childAt)) && !(z5 && childAt == view)) {
                WeakHashMap weakHashMap = z0.f15748a;
                h0.s(childAt, 4);
            } else {
                WeakHashMap weakHashMap2 = z0.f15748a;
                h0.s(childAt, 1);
            }
        }
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.drawerLayoutStyle);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1993a = new j(3);
        this.f1996d = -1728053248;
        this.f1997f = new Paint();
        this.f2004m = true;
        this.f2005n = 3;
        this.f2006o = 3;
        this.f2007p = 3;
        this.f2008q = 3;
        this.B = new m0(this, 12);
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.f1995c = (int) ((64.0f * f2) + 0.5f);
        float f10 = f2 * 400.0f;
        q1.d dVar = new q1.d(this, 3);
        this.f2000i = dVar;
        q1.d dVar2 = new q1.d(this, 5);
        this.f2001j = dVar2;
        d dVar3 = new d(getContext(), this, dVar);
        dVar3.f17370b = (int) (dVar3.f17370b * 1.0f);
        this.f1998g = dVar3;
        dVar3.f17384q = 1;
        dVar3.f17381n = f10;
        dVar.f17734b = dVar3;
        d dVar4 = new d(getContext(), this, dVar2);
        dVar4.f17370b = (int) (1.0f * dVar4.f17370b);
        this.f1999h = dVar4;
        dVar4.f17384q = 2;
        dVar4.f17381n = f10;
        dVar2.f17734b = dVar4;
        setFocusableInTouchMode(true);
        WeakHashMap weakHashMap = z0.f15748a;
        h0.s(this, 1);
        z0.n(this, new a2(this));
        setMotionEventSplittingEnabled(false);
        if (h0.b(this)) {
            setOnApplyWindowInsetsListener(new q1.a());
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C);
            try {
                this.f2012v = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.DrawerLayout, i3, 0);
        try {
            if (obtainStyledAttributes2.hasValue(R$styleable.DrawerLayout_elevation)) {
                this.f1994b = obtainStyledAttributes2.getDimension(R$styleable.DrawerLayout_elevation, 0.0f);
            } else {
                this.f1994b = getResources().getDimension(R$dimen.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.f2015y = new ArrayList();
        } catch (Throwable th2) {
            obtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public void setStatusBarBackground(int i3) {
        this.f2012v = i3 != 0 ? a1.c.b(getContext(), i3) : null;
        invalidate();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        c cVar = new c(context, attributeSet);
        cVar.f17729a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, D);
        cVar.f17729a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        return cVar;
    }
}
