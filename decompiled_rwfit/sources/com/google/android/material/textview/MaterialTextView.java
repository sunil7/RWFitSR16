package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import ib.a;

/* loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        TypedValue a3 = s0.a(context, R$attr.textAppearanceLineHeightEnabled);
        if (a3 != null && a3.type == 18 && a3.data == 0) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(i3, R$styleable.MaterialTextAppearance);
        Context context2 = getContext();
        int[] iArr = {R$styleable.MaterialTextAppearance_android_lineHeight, R$styleable.MaterialTextAppearance_lineHeight};
        int i10 = -1;
        for (int i11 = 0; i11 < 2 && i10 < 0; i11++) {
            i10 = t0.c(context2, obtainStyledAttributes, iArr[i11], -1);
        }
        obtainStyledAttributes.recycle();
        if (i10 >= 0) {
            setLineHeight(i10);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialTextView(Context context, AttributeSet attributeSet, int i3) {
        super(a.a(context, attributeSet, i3, 0), attributeSet, i3);
        Context context2 = getContext();
        TypedValue a3 = s0.a(context2, R$attr.textAppearanceLineHeightEnabled);
        if (a3 != null && a3.type == 18 && a3.data == 0) {
            return;
        }
        Resources.Theme theme = context2.getTheme();
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i3, 0);
        int[] iArr = {R$styleable.MaterialTextView_android_lineHeight, R$styleable.MaterialTextView_lineHeight};
        int i10 = -1;
        for (int i11 = 0; i11 < 2 && i10 < 0; i11++) {
            i10 = t0.c(context2, obtainStyledAttributes, iArr[i11], -1);
        }
        obtainStyledAttributes.recycle();
        if (i10 != -1) {
            return;
        }
        TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i3, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(R$styleable.MaterialTextView_android_textAppearance, -1);
        obtainStyledAttributes2.recycle();
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, R$styleable.MaterialTextAppearance);
            Context context3 = getContext();
            int[] iArr2 = {R$styleable.MaterialTextAppearance_android_lineHeight, R$styleable.MaterialTextAppearance_lineHeight};
            int i12 = -1;
            for (int i13 = 0; i13 < 2 && i12 < 0; i13++) {
                i12 = t0.c(context3, obtainStyledAttributes3, iArr2[i13], -1);
            }
            obtainStyledAttributes3.recycle();
            if (i12 >= 0) {
                setLineHeight(i12);
            }
        }
    }
}
