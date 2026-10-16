package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.b;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* loaded from: classes.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: g, reason: collision with root package name */
    public static final int f10724g = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: h, reason: collision with root package name */
    public static final int[][] f10725h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10726f;

    public MaterialRadioButton(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.e == null) {
            int b3 = x.b(R$attr.colorControlActivated, this);
            int b10 = x.b(R$attr.colorOnSurface, this);
            int b11 = x.b(R$attr.colorSurface, this);
            this.e = new ColorStateList(f10725h, new int[]{x.d(b11, 1.0f, b3), x.d(b11, 0.54f, b10), x.d(b11, 0.38f, b10), x.d(b11, 0.38f, b10)});
        }
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f10726f && b.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z5) {
        this.f10726f = z5;
        if (z5) {
            b.c(this, getMaterialThemeColorsTintList());
        } else {
            b.c(this, null);
        }
    }

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialRadioButton(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.radiobutton.MaterialRadioButton.f10724g
            android.content.Context r7 = ib.a.a(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialRadioButton
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.w.d(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R$styleable.MaterialRadioButton_buttonTint
            boolean r9 = r8.hasValue(r9)
            if (r9 == 0) goto L29
            int r9 = com.google.android.material.R$styleable.MaterialRadioButton_buttonTint
            android.content.res.ColorStateList r9 = com.google.android.gms.internal.mlkit_vision_barcode.t0.a(r0, r8, r9)
            androidx.core.widget.b.c(r6, r9)
        L29:
            int r9 = com.google.android.material.R$styleable.MaterialRadioButton_useMaterialThemeColors
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f10726f = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.radiobutton.MaterialRadioButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
