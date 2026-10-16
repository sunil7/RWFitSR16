package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.R$attr;
import androidx.recyclerview.widget.e1;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.ae;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.b0;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements l1.u, l1.r, b0 {
    public static final float A = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final j B = new j(0);
    public static final int[] C = {R.attr.fillViewport};

    /* renamed from: a, reason: collision with root package name */
    public final float f1927a;

    /* renamed from: b, reason: collision with root package name */
    public long f1928b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f1929c;

    /* renamed from: d, reason: collision with root package name */
    public final OverScroller f1930d;
    public final EdgeEffect e;

    /* renamed from: f, reason: collision with root package name */
    public final EdgeEffect f1931f;

    /* renamed from: g, reason: collision with root package name */
    public int f1932g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1933h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1934i;

    /* renamed from: j, reason: collision with root package name */
    public View f1935j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1936k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f1937l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1938m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1939n;

    /* renamed from: o, reason: collision with root package name */
    public final int f1940o;

    /* renamed from: p, reason: collision with root package name */
    public final int f1941p;

    /* renamed from: q, reason: collision with root package name */
    public final int f1942q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f1943s;

    /* renamed from: t, reason: collision with root package name */
    public final int[] f1944t;

    /* renamed from: u, reason: collision with root package name */
    public int f1945u;

    /* renamed from: v, reason: collision with root package name */
    public int f1946v;

    /* renamed from: w, reason: collision with root package name */
    public SavedState f1947w;

    /* renamed from: x, reason: collision with root package name */
    public final e1 f1948x;

    /* renamed from: y, reason: collision with root package name */
    public final l1.s f1949y;

    /* renamed from: z, reason: collision with root package name */
    public float f1950z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new m();
        public int scrollPosition;

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("HorizontalScrollView.SavedState{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" scrollPosition=");
            return r5.a.e(sb2, this.scrollPosition, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.scrollPosition);
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1950z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f1950z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f1950z;
    }

    public static boolean m(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && m((View) parent, nestedScrollView);
    }

    @Override // l1.t
    public final void a(View view, View view2, int i3, int i10) {
        e1 e1Var = this.f1948x;
        if (i10 == 1) {
            e1Var.f2555c = i3;
        } else {
            e1Var.f2554b = i3;
        }
        u(2, i10);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // l1.t
    public final void b(View view, int i3, int i10, int[] iArr, int i11) {
        this.f1949y.c(i3, i10, iArr, null, i11);
    }

    public final boolean c(int i3) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !n(findNextFocus, maxScrollAmount, getHeight())) {
            if (i3 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i3 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i3 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            e(maxScrollAmount);
        } else {
            Rect rect = this.f1929c;
            findNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findNextFocus, rect);
            e(d(rect));
            findNextFocus.requestFocus(i3);
        }
        if (findFocus == null || !findFocus.isFocused() || n(findFocus, 0, getHeight())) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e0  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void computeScroll() {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? (scrollY - max) + bottom : bottom;
    }

    public final int d(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i10 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        int i11 = rect.bottom;
        if (i11 > i10 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i10, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        }
        if (rect.top >= scrollY || i11 >= i10) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i10 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || h(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f10, boolean z5) {
        return this.f1949y.a(f2, f10, z5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f10) {
        return this.f1949y.b(f2, f10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i3, int i10, int[] iArr, int[] iArr2) {
        return this.f1949y.c(i3, i10, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i3, int i10, int i11, int i12, int[] iArr) {
        return this.f1949y.d(i3, i10, i11, i12, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i3;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.e;
        int i10 = 0;
        if (!edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (k.a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                i3 = getPaddingLeft();
            } else {
                i3 = 0;
            }
            if (k.a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate(i3, min);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                WeakHashMap weakHashMap = z0.f15748a;
                h0.k(this);
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect2 = this.f1931f;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int save2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int max = Math.max(getScrollRange(), scrollY) + height2;
        if (k.a(this)) {
            width2 -= getPaddingRight() + getPaddingLeft();
            i10 = getPaddingLeft();
        }
        if (k.a(this)) {
            height2 -= getPaddingBottom() + getPaddingTop();
            max -= getPaddingBottom();
        }
        canvas.translate(i10 - width2, max);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            WeakHashMap weakHashMap2 = z0.f15748a;
            h0.k(this);
        }
        canvas.restoreToCount(save2);
    }

    public final void e(int i3) {
        if (i3 != 0) {
            if (this.f1939n) {
                t(0, i3, false);
            } else {
                scrollBy(0, i3);
            }
        }
    }

    @Override // l1.t
    public final void f(int i3, View view) {
        e1 e1Var = this.f1948x;
        if (i3 == 1) {
            e1Var.f2555c = 0;
        } else {
            e1Var.f2554b = 0;
        }
        w(i3);
    }

    @Override // l1.u
    public final void g(View view, int i3, int i10, int i11, int i12, int i13, int[] iArr) {
        o(iArr, i12, i13);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        e1 e1Var = this.f1948x;
        return e1Var.f2555c | e1Var.f2554b;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public final boolean h(KeyEvent keyEvent) {
        Rect rect = this.f1929c;
        rect.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() == 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode == 19) {
                        return !keyEvent.isAltPressed() ? c(33) : l(33);
                    }
                    if (keyCode == 20) {
                        return !keyEvent.isAltPressed() ? c(130) : l(130);
                    }
                    if (keyCode == 62) {
                        int i3 = keyEvent.isShiftPressed() ? 33 : 130;
                        boolean z5 = i3 == 130;
                        int height = getHeight();
                        if (z5) {
                            rect.top = getScrollY() + height;
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                View childAt2 = getChildAt(childCount - 1);
                                int paddingBottom = getPaddingBottom() + childAt2.getBottom() + ((FrameLayout.LayoutParams) childAt2.getLayoutParams()).bottomMargin;
                                if (rect.top + height > paddingBottom) {
                                    rect.top = paddingBottom - height;
                                }
                            }
                        } else {
                            int scrollY = getScrollY() - height;
                            rect.top = scrollY;
                            if (scrollY < 0) {
                                rect.top = 0;
                            }
                        }
                        int i10 = rect.top;
                        int i11 = height + i10;
                        rect.bottom = i11;
                        r(i3, i10, i11);
                        return false;
                    }
                }
                return false;
            }
        }
        if (isFocused() && keyEvent.getKeyCode() != 4) {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus != null && findNextFocus != this && findNextFocus.requestFocus(130)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f1949y.f(0);
    }

    @Override // l1.t
    public final void i(View view, int i3, int i10, int i11, int i12, int i13) {
        o(null, i12, i13);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f1949y.f15729d;
    }

    @Override // l1.t
    public final boolean j(View view, View view2, int i3, int i10) {
        return (i3 & 2) != 0;
    }

    public final void k(int i3) {
        if (getChildCount() > 0) {
            this.f1930d.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO, 0, 0);
            u(2, 1);
            this.f1946v = getScrollY();
            WeakHashMap weakHashMap = z0.f15748a;
            h0.k(this);
        }
    }

    public final boolean l(int i3) {
        int childCount;
        boolean z5 = i3 == 130;
        int height = getHeight();
        Rect rect = this.f1929c;
        rect.top = 0;
        rect.bottom = height;
        if (z5 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return r(i3, rect.top, rect.bottom);
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i3, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i3, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final boolean n(View view, int i3, int i10) {
        Rect rect = this.f1929c;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i3 >= getScrollY() && rect.top - i3 <= getScrollY() + i10;
    }

    public final void o(int[] iArr, int i3, int i10) {
        int scrollY = getScrollY();
        scrollBy(0, i3);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f1949y.d(0, scrollY2, 0, i3 - scrollY2, null, i10, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1934i = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z5;
        int i3 = 0;
        if (motionEvent.getAction() == 8 && !this.f1936k) {
            float axisValue = ae.a(motionEvent, 2) ? motionEvent.getAxisValue(9) : ae.a(motionEvent, 4194304) ? motionEvent.getAxisValue(26) : 0.0f;
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i10 = scrollY - verticalScrollFactorCompat;
                if (i10 < 0) {
                    int overScrollMode = getOverScrollMode();
                    if ((overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !ae.a(motionEvent, 8194)) {
                        float height = (-i10) / getHeight();
                        EdgeEffect edgeEffect = this.e;
                        com.bumptech.glide.e.b(edgeEffect, height, 0.5f);
                        edgeEffect.onRelease();
                        invalidate();
                        z5 = 1;
                    } else {
                        z5 = 0;
                    }
                } else if (i10 > scrollRange) {
                    int overScrollMode2 = getOverScrollMode();
                    if ((overScrollMode2 == 0 || (overScrollMode2 == 1 && getScrollRange() > 0)) && !ae.a(motionEvent, 8194)) {
                        float height2 = (i10 - scrollRange) / getHeight();
                        EdgeEffect edgeEffect2 = this.f1931f;
                        com.bumptech.glide.e.b(edgeEffect2, height2, 0.5f);
                        edgeEffect2.onRelease();
                        invalidate();
                        i3 = 1;
                    }
                    z5 = i3;
                    i3 = scrollRange;
                } else {
                    z5 = 0;
                    i3 = i10;
                }
                if (i3 == scrollY) {
                    return z5;
                }
                super.scrollTo(getScrollX(), i3);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OverScroller overScroller = this.f1930d;
        int action = motionEvent.getAction();
        boolean z5 = true;
        if (action == 2 && this.f1936k) {
            return true;
        }
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    int i10 = this.r;
                    if (i10 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i10);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i10 + " in onInterceptTouchEvent");
                        } else {
                            int y4 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y4 - this.f1932g) > this.f1940o && (getNestedScrollAxes() & 2) == 0) {
                                this.f1936k = true;
                                this.f1932g = y4;
                                if (this.f1937l == null) {
                                    this.f1937l = VelocityTracker.obtain();
                                }
                                this.f1937l.addMovement(motionEvent);
                                this.f1945u = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i3 != 3) {
                    if (i3 == 6) {
                        p(motionEvent);
                    }
                }
            }
            this.f1936k = false;
            this.r = -1;
            VelocityTracker velocityTracker = this.f1937l;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f1937l = null;
            }
            if (this.f1930d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                WeakHashMap weakHashMap = z0.f15748a;
                h0.k(this);
            }
            w(0);
        } else {
            int y10 = (int) motionEvent.getY();
            int x10 = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y10 >= childAt.getTop() - scrollY && y10 < childAt.getBottom() - scrollY && x10 >= childAt.getLeft() && x10 < childAt.getRight()) {
                    this.f1932g = y10;
                    this.r = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker2 = this.f1937l;
                    if (velocityTracker2 == null) {
                        this.f1937l = VelocityTracker.obtain();
                    } else {
                        velocityTracker2.clear();
                    }
                    this.f1937l.addMovement(motionEvent);
                    overScroller.computeScrollOffset();
                    if (!v(motionEvent) && overScroller.isFinished()) {
                        z5 = false;
                    }
                    this.f1936k = z5;
                    u(2, 0);
                }
            }
            if (!v(motionEvent) && overScroller.isFinished()) {
                z5 = false;
            }
            this.f1936k = z5;
            VelocityTracker velocityTracker3 = this.f1937l;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f1937l = null;
            }
        }
        return this.f1936k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int i13;
        super.onLayout(z5, i3, i10, i11, i12);
        int i14 = 0;
        this.f1933h = false;
        View view = this.f1935j;
        if (view != null && m(view, this)) {
            View view2 = this.f1935j;
            Rect rect = this.f1929c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int d5 = d(rect);
            if (d5 != 0) {
                scrollBy(0, d5);
            }
        }
        this.f1935j = null;
        if (!this.f1934i) {
            if (this.f1947w != null) {
                scrollTo(getScrollX(), this.f1947w.scrollPosition);
                this.f1947w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i13 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i13 = 0;
            }
            int paddingTop = ((i12 - i10) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i13 && scrollY >= 0) {
                i14 = paddingTop + scrollY > i13 ? i13 - paddingTop : scrollY;
            }
            if (i14 != scrollY) {
                scrollTo(getScrollX(), i14);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1934i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        if (this.f1938m && View.MeasureSpec.getMode(i10) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f10, boolean z5) {
        if (z5) {
            return false;
        }
        dispatchNestedFling(0.0f, f10, true);
        k((int) f10);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f10) {
        return this.f1949y.b(f2, f10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i3, int i10, int[] iArr) {
        this.f1949y.c(i3, i10, iArr, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i3, int i10, int i11, int i12) {
        o(null, i12, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i3) {
        a(view, view2, i3, 0);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i3, int i10, boolean z5, boolean z6) {
        super.scrollTo(i3, i10);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (i3 == 2) {
            i3 = 130;
        } else if (i3 == 1) {
            i3 = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i3) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i3);
        if (findNextFocus != null && n(findNextFocus, 0, getHeight())) {
            return findNextFocus.requestFocus(i3, rect);
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
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1947w = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i3, int i10, int i11, int i12) {
        super.onScrollChanged(i3, i10, i11, i12);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        super.onSizeChanged(i3, i10, i11, i12);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !n(findFocus, 0, i12)) {
            return;
        }
        Rect rect = this.f1929c;
        findFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(findFocus, rect);
        e(d(rect));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i3) {
        return j(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        f(0, view);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0228  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r29) {
        /*
            Method dump skipped, instructions count: 767
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.f1932g = (int) motionEvent.getY(i3);
            this.r = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.f1937l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean q(int i3, int i10, int i11, int i12) {
        int i13;
        boolean z5;
        int i14;
        boolean z6;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i15 = i11 + i3;
        if (i10 <= 0 && i10 >= 0) {
            i13 = i10;
            z5 = false;
        } else {
            i13 = 0;
            z5 = true;
        }
        if (i15 > i12) {
            i14 = i12;
        } else {
            if (i15 >= 0) {
                i14 = i15;
                z6 = false;
                if (z6 && !this.f1949y.f(1)) {
                    this.f1930d.springBack(i13, i14, 0, 0, 0, getScrollRange());
                }
                super.scrollTo(i13, i14);
                return !z5 || z6;
            }
            i14 = 0;
        }
        z6 = true;
        if (z6) {
            this.f1930d.springBack(i13, i14, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i13, i14);
        if (z5) {
        }
    }

    public final boolean r(int i3, int i10, int i11) {
        boolean z5;
        int height = getHeight();
        int scrollY = getScrollY();
        int i12 = height + scrollY;
        boolean z6 = i3 == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z8 = false;
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = focusables.get(i13);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i10 < bottom && top < i11) {
                boolean z10 = i10 < top && bottom < i11;
                if (view == null) {
                    view = view2;
                    z8 = z10;
                } else {
                    boolean z11 = (z6 && top < view.getTop()) || (!z6 && bottom > view.getBottom());
                    if (z8) {
                        if (z10) {
                            if (!z11) {
                            }
                            view = view2;
                        }
                    } else if (z10) {
                        view = view2;
                        z8 = true;
                    } else {
                        if (!z11) {
                        }
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i10 < scrollY || i11 > i12) {
            e(z6 ? i10 - scrollY : i11 - i12);
            z5 = true;
        } else {
            z5 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i3);
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.f1933h) {
            this.f1935j = view2;
        } else {
            Rect rect = this.f1929c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int d5 = d(rect);
            if (d5 != 0) {
                scrollBy(0, d5);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int d5 = d(rect);
        boolean z6 = d5 != 0;
        if (z6) {
            if (z5) {
                scrollBy(0, d5);
                return z6;
            }
            t(0, d5, false);
        }
        return z6;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z5) {
        VelocityTracker velocityTracker;
        if (z5 && (velocityTracker = this.f1937l) != null) {
            velocityTracker.recycle();
            this.f1937l = null;
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f1933h = true;
        super.requestLayout();
    }

    public final boolean s(EdgeEffect edgeEffect, int i3) {
        if (i3 > 0) {
            return true;
        }
        float a3 = com.bumptech.glide.e.a(edgeEffect) * getHeight();
        float abs = Math.abs(-i3) * 0.35f;
        float f2 = this.f1927a * 0.015f;
        double log = Math.log(abs / f2);
        double d5 = A;
        return ((float) (Math.exp((d5 / (d5 - 1.0d)) * log) * ((double) f2))) < a3;
    }

    @Override // android.view.View
    public final void scrollTo(int i3, int i10) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i3 < 0) {
                i3 = 0;
            } else if (width + i3 > width2) {
                i3 = width2 - width;
            }
            if (height >= height2 || i10 < 0) {
                i10 = 0;
            } else if (height + i10 > height2) {
                i10 = height2 - height;
            }
            if (i3 == getScrollX() && i10 == getScrollY()) {
                return;
            }
            super.scrollTo(i3, i10);
        }
    }

    public void setFillViewport(boolean z5) {
        if (z5 != this.f1938m) {
            this.f1938m = z5;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z5) {
        this.f1949y.g(z5);
    }

    public void setOnScrollChangeListener(l lVar) {
    }

    public void setSmoothScrollingEnabled(boolean z5) {
        this.f1939n = z5;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i3) {
        return this.f1949y.h(i3, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        w(0);
    }

    public final void t(int i3, int i10, boolean z5) {
        OverScroller overScroller = this.f1930d;
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f1928b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f1930d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i10 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
            if (z5) {
                u(2, 1);
            } else {
                w(1);
            }
            this.f1946v = getScrollY();
            WeakHashMap weakHashMap = z0.f15748a;
            h0.k(this);
        } else {
            if (!overScroller.isFinished()) {
                overScroller.abortAnimation();
                w(1);
            }
            scrollBy(i3, i10);
        }
        this.f1928b = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void u(int i3, int i10) {
        this.f1949y.h(2, i10);
    }

    public final boolean v(MotionEvent motionEvent) {
        boolean z5;
        EdgeEffect edgeEffect = this.e;
        if (com.bumptech.glide.e.a(edgeEffect) != 0.0f) {
            com.bumptech.glide.e.b(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z5 = true;
        } else {
            z5 = false;
        }
        EdgeEffect edgeEffect2 = this.f1931f;
        if (com.bumptech.glide.e.a(edgeEffect2) == 0.0f) {
            return z5;
        }
        com.bumptech.glide.e.b(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void w(int i3) {
        this.f1949y.i(i3);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.nestedScrollViewStyle);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        this.f1929c = new Rect();
        this.f1933h = true;
        this.f1934i = false;
        this.f1935j = null;
        this.f1936k = false;
        this.f1939n = true;
        this.r = -1;
        this.f1943s = new int[2];
        this.f1944t = new int[2];
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            edgeEffect = f.a(context, attributeSet);
        } else {
            edgeEffect = new EdgeEffect(context);
        }
        this.e = edgeEffect;
        if (i10 >= 31) {
            edgeEffect2 = f.a(context, attributeSet);
        } else {
            edgeEffect2 = new EdgeEffect(context);
        }
        this.f1931f = edgeEffect2;
        this.f1927a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f1930d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1940o = viewConfiguration.getScaledTouchSlop();
        this.f1941p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1942q = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C, i3, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1948x = new e1(3);
        this.f1949y = new l1.s(this);
        setNestedScrollingEnabled(true);
        z0.n(this, B);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        if (getChildCount() <= 0) {
            super.addView(view, i3);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
