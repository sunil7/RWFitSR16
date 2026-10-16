package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public int f10535a;

    /* renamed from: b, reason: collision with root package name */
    public int f10536b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10537c;

    /* renamed from: d, reason: collision with root package name */
    public int f10538d;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f10537c;
    }

    public int getItemSpacing() {
        return this.f10536b;
    }

    public int getLineSpacing() {
        return this.f10535a;
    }

    public int getRowCount() {
        return this.f10538d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int i13;
        int i14;
        if (getChildCount() == 0) {
            this.f10538d = 0;
            return;
        }
        this.f10538d = 1;
        WeakHashMap weakHashMap = z0.f15748a;
        boolean z6 = i0.d(this) == 1;
        int paddingRight = z6 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z6 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i15 = (i11 - i3) - paddingLeft;
        int i16 = paddingRight;
        int i17 = paddingTop;
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R$id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i14 = l1.p.c(marginLayoutParams);
                    i13 = l1.p.b(marginLayoutParams);
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                int measuredWidth = childAt.getMeasuredWidth() + i16 + i14;
                if (!this.f10537c && measuredWidth > i15) {
                    i17 = this.f10535a + paddingTop;
                    this.f10538d++;
                    i16 = paddingRight;
                }
                childAt.setTag(R$id.row_index_key, Integer.valueOf(this.f10538d - 1));
                int i19 = i16 + i14;
                int measuredWidth2 = childAt.getMeasuredWidth() + i19;
                int measuredHeight = childAt.getMeasuredHeight() + i17;
                if (z6) {
                    childAt.layout(i15 - measuredWidth2, i17, (i15 - i16) - i14, measuredHeight);
                } else {
                    childAt.layout(i19, i17, measuredWidth2, measuredHeight);
                }
                i16 += childAt.getMeasuredWidth() + i14 + i13 + this.f10536b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        int i11;
        int i12;
        int i13;
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i10);
        int i14 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i14 - getPaddingRight();
        int i15 = paddingTop;
        int i16 = 0;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i10);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i13 = marginLayoutParams.leftMargin;
                    i12 = marginLayoutParams.rightMargin;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int i18 = i12;
                if (childAt.getMeasuredWidth() + paddingLeft + i13 > paddingRight && !a()) {
                    paddingLeft = getPaddingLeft();
                    i15 = paddingTop + this.f10535a;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i13;
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (measuredWidth > i16) {
                    i16 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i13 + i18 + this.f10536b + paddingLeft;
                if (i17 == getChildCount() - 1) {
                    i16 += i18;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i16;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            i11 = 1073741824;
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            i11 = 1073741824;
            size = Math.min(paddingRight2, size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != i11) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i3) {
        this.f10536b = i3;
    }

    public void setLineSpacing(int i3) {
        this.f10535a = i3;
    }

    public void setSingleLine(boolean z5) {
        this.f10537c = z5;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f10537c = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        this.f10535a = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_lineSpacing, 0);
        this.f10536b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }
}
