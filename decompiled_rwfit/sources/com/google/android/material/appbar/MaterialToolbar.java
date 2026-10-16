package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.internal.mlkit_vision_barcode.fb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final int U = R$style.Widget_MaterialComponents_Toolbar;
    public Integer R;
    public boolean S;
    public boolean T;

    public MaterialToolbar(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        rb.d(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        if (this.S || this.T) {
            TextView a3 = fb.a(this, getTitle());
            TextView a10 = fb.a(this, getSubtitle());
            if (a3 == null && a10 == null) {
                return;
            }
            int measuredWidth = getMeasuredWidth();
            int i13 = measuredWidth / 2;
            int paddingLeft = getPaddingLeft();
            int paddingRight = measuredWidth - getPaddingRight();
            for (int i14 = 0; i14 < getChildCount(); i14++) {
                View childAt = getChildAt(i14);
                if (childAt.getVisibility() != 8 && childAt != a3 && childAt != a10) {
                    if (childAt.getRight() < i13 && childAt.getRight() > paddingLeft) {
                        paddingLeft = childAt.getRight();
                    }
                    if (childAt.getLeft() > i13 && childAt.getLeft() < paddingRight) {
                        paddingRight = childAt.getLeft();
                    }
                }
            }
            Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
            if (this.S && a3 != null) {
                u(a3, pair);
            }
            if (!this.T || a10 == null) {
                return;
            }
            u(a10, pair);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        rb.b(this, f2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        Integer num;
        if (drawable != null && (num = this.R) != null) {
            d1.b.g(drawable, num.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i3) {
        this.R = Integer.valueOf(i3);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z5) {
        if (this.T != z5) {
            this.T = z5;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z5) {
        if (this.S != z5) {
            this.S = z5;
            requestLayout();
        }
    }

    public final void u(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i3 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i10 = measuredWidth2 + i3;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i3, 0), Math.max(i10 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i3 += max;
            i10 -= max;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i10 - i3, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i3, textView.getTop(), i10, textView.getBottom());
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialToolbar(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.appbar.MaterialToolbar.U
            android.content.Context r7 = ib.a.a(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialToolbar
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.w.d(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R$styleable.MaterialToolbar_navigationIconTint
            boolean r9 = r8.hasValue(r9)
            if (r9 == 0) goto L2a
            int r9 = com.google.android.material.R$styleable.MaterialToolbar_navigationIconTint
            r1 = -1
            int r9 = r8.getColor(r9, r1)
            r6.setNavigationIconTint(r9)
        L2a:
            int r9 = com.google.android.material.R$styleable.MaterialToolbar_titleCentered
            boolean r9 = r8.getBoolean(r9, r7)
            r6.S = r9
            int r9 = com.google.android.material.R$styleable.MaterialToolbar_subtitleCentered
            boolean r9 = r8.getBoolean(r9, r7)
            r6.T = r9
            r8.recycle()
            android.graphics.drawable.Drawable r8 = r6.getBackground()
            if (r8 == 0) goto L48
            boolean r9 = r8 instanceof android.graphics.drawable.ColorDrawable
            if (r9 != 0) goto L48
            return
        L48:
            eb.h r9 = new eb.h
            r9.<init>()
            if (r8 == 0) goto L55
            android.graphics.drawable.ColorDrawable r8 = (android.graphics.drawable.ColorDrawable) r8
            int r7 = r8.getColor()
        L55:
            android.content.res.ColorStateList r7 = android.content.res.ColorStateList.valueOf(r7)
            r9.l(r7)
            r9.j(r0)
            java.util.WeakHashMap r7 = l1.z0.f15748a
            float r7 = l1.n0.i(r6)
            r9.k(r7)
            l1.h0.q(r6, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.MaterialToolbar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
