package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public boolean f742a;

    /* renamed from: b, reason: collision with root package name */
    public int f743b;

    /* renamed from: c, reason: collision with root package name */
    public int f744c;

    /* renamed from: d, reason: collision with root package name */
    public int f745d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f746f;

    /* renamed from: g, reason: collision with root package name */
    public float f747g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f748h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f749i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f750j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f751k;

    /* renamed from: l, reason: collision with root package name */
    public int f752l;

    /* renamed from: m, reason: collision with root package name */
    public int f753m;

    /* renamed from: n, reason: collision with root package name */
    public int f754n;

    /* renamed from: o, reason: collision with root package name */
    public int f755o;

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof y1;
    }

    public final void f(Canvas canvas, int i3) {
        this.f751k.setBounds(getPaddingLeft() + this.f755o, i3, (getWidth() - getPaddingRight()) - this.f755o, this.f753m + i3);
        this.f751k.draw(canvas);
    }

    public final void g(Canvas canvas, int i3) {
        this.f751k.setBounds(i3, getPaddingTop() + this.f755o, this.f752l + i3, (getHeight() - getPaddingBottom()) - this.f755o);
        this.f751k.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i3;
        if (this.f743b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i10 = this.f743b;
        if (childCount <= i10) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i10);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f743b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i11 = this.f744c;
        if (this.f745d == 1 && (i3 = this.e & 112) != 48) {
            if (i3 == 16) {
                i11 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f746f) / 2;
            } else if (i3 == 80) {
                i11 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f746f;
            }
        }
        return i11 + ((LinearLayout.LayoutParams) ((y1) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f743b;
    }

    public Drawable getDividerDrawable() {
        return this.f751k;
    }

    public int getDividerPadding() {
        return this.f755o;
    }

    public int getDividerWidth() {
        return this.f752l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.f745d;
    }

    public int getShowDividers() {
        return this.f754n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f747g;
    }

    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public y1 generateDefaultLayoutParams() {
        int i3 = this.f745d;
        if (i3 == 0) {
            return new y1(-2, -2);
        }
        if (i3 == 1) {
            return new y1(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public y1 generateLayoutParams(AttributeSet attributeSet) {
        return new y1(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public y1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new y1(layoutParams);
    }

    public final boolean k(int i3) {
        if (i3 == 0) {
            return (this.f754n & 1) != 0;
        }
        if (i3 == getChildCount()) {
            return (this.f754n & 4) != 0;
        }
        if ((this.f754n & 2) != 0) {
            for (int i10 = i3 - 1; i10 >= 0; i10--) {
                if (getChildAt(i10).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i3;
        if (this.f751k == null) {
            return;
        }
        int i10 = 0;
        if (this.f745d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i10 < virtualChildCount) {
                View childAt = getChildAt(i10);
                if (childAt != null && childAt.getVisibility() != 8 && k(i10)) {
                    f(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((y1) childAt.getLayoutParams())).topMargin) - this.f753m);
                }
                i10++;
            }
            if (k(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                f(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f753m : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((y1) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean a3 = b4.a(this);
        while (i10 < virtualChildCount2) {
            View childAt3 = getChildAt(i10);
            if (childAt3 != null && childAt3.getVisibility() != 8 && k(i10)) {
                y1 y1Var = (y1) childAt3.getLayoutParams();
                g(canvas, a3 ? childAt3.getRight() + ((LinearLayout.LayoutParams) y1Var).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) y1Var).leftMargin) - this.f752l);
            }
            i10++;
        }
        if (k(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                y1 y1Var2 = (y1) childAt4.getLayoutParams();
                if (a3) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) y1Var2).leftMargin;
                    i3 = this.f752l;
                    right = left - i3;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) y1Var2).rightMargin;
                }
            } else if (a3) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i3 = this.f752l;
                right = left - i3;
            }
            g(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2151
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z5) {
        this.f742a = z5;
    }

    public void setBaselineAlignedChildIndex(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            this.f743b = i3;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f751k) {
            return;
        }
        this.f751k = drawable;
        if (drawable != null) {
            this.f752l = drawable.getIntrinsicWidth();
            this.f753m = drawable.getIntrinsicHeight();
        } else {
            this.f752l = 0;
            this.f753m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i3) {
        this.f755o = i3;
    }

    public void setGravity(int i3) {
        if (this.e != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.e = i3;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i3) {
        int i10 = i3 & 8388615;
        int i11 = this.e;
        if ((8388615 & i11) != i10) {
            this.e = i10 | ((-8388616) & i11);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z5) {
        this.f748h = z5;
    }

    public void setOrientation(int i3) {
        if (this.f745d != i3) {
            this.f745d = i3;
            requestLayout();
        }
    }

    public void setShowDividers(int i3) {
        if (i3 != this.f754n) {
            requestLayout();
        }
        this.f754n = i3;
    }

    public void setVerticalGravity(int i3) {
        int i10 = i3 & 112;
        int i11 = this.e;
        if ((i11 & 112) != i10) {
            this.e = i10 | (i11 & Const.I_DEF_CGI_SIG);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f747g = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f742a = true;
        this.f743b = -1;
        this.f744c = 0;
        this.e = 8388659;
        de.o I = de.o.I(context, attributeSet, R$styleable.LinearLayoutCompat, i3);
        l1.z0.m(this, context, R$styleable.LinearLayoutCompat, attributeSet, (TypedArray) I.f12378c, i3);
        int i10 = R$styleable.LinearLayoutCompat_android_orientation;
        TypedArray typedArray = (TypedArray) I.f12378c;
        int i11 = typedArray.getInt(i10, -1);
        if (i11 >= 0) {
            setOrientation(i11);
        }
        int i12 = typedArray.getInt(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (i12 >= 0) {
            setGravity(i12);
        }
        boolean z5 = typedArray.getBoolean(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z5) {
            setBaselineAligned(z5);
        }
        this.f747g = typedArray.getFloat(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f743b = typedArray.getInt(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f748h = typedArray.getBoolean(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(I.w(R$styleable.LinearLayoutCompat_divider));
        this.f754n = typedArray.getInt(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.f755o = typedArray.getDimensionPixelSize(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        I.K();
    }
}
