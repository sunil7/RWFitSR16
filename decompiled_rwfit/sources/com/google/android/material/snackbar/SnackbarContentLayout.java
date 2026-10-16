package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f10772a;

    /* renamed from: b, reason: collision with root package name */
    public Button f10773b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10774c;

    /* renamed from: d, reason: collision with root package name */
    public int f10775d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public final boolean a(int i3, int i10, int i11) {
        boolean z5;
        if (i3 != getOrientation()) {
            setOrientation(i3);
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.f10772a.getPaddingTop() == i10 && this.f10772a.getPaddingBottom() == i11) {
            return z5;
        }
        TextView textView = this.f10772a;
        WeakHashMap weakHashMap = z0.f15748a;
        if (i0.g(textView)) {
            i0.k(textView, i0.f(textView), i10, i0.e(textView), i11);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i10, textView.getPaddingRight(), i11);
        return true;
    }

    public Button getActionView() {
        return this.f10773b;
    }

    public TextView getMessageView() {
        return this.f10772a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f10772a = (TextView) findViewById(R$id.snackbar_text);
        this.f10773b = (Button) findViewById(R$id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        int i11 = this.f10774c;
        if (i11 > 0 && getMeasuredWidth() > i11) {
            i3 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            super.onMeasure(i3, i10);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical);
        boolean z5 = this.f10772a.getLayout().getLineCount() > 1;
        if (!z5 || this.f10775d <= 0 || this.f10773b.getMeasuredWidth() <= this.f10775d) {
            if (!z5) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i3, i10);
    }

    public void setMaxInlineActionWidth(int i3) {
        this.f10775d = i3;
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        this.f10774c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
        this.f10775d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }
}
