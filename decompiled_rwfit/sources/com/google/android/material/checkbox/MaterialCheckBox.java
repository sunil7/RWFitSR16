package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.b;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* loaded from: classes.dex */
public class MaterialCheckBox extends AppCompatCheckBox {

    /* renamed from: g, reason: collision with root package name */
    public static final int f10358g = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: h, reason: collision with root package name */
    public static final int[][] f10359h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10360f;

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.e == null) {
            int b3 = x.b(R$attr.colorControlActivated, this);
            int b10 = x.b(R$attr.colorSurface, this);
            int b11 = x.b(R$attr.colorOnSurface, this);
            this.e = new ColorStateList(f10359h, new int[]{x.d(b10, 1.0f, b3), x.d(b10, 0.54f, b11), x.d(b10, 0.38f, b11), x.d(b10, 0.38f, b11)});
        }
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f10360f && b.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z5) {
        this.f10360f = z5;
        if (z5) {
            b.c(this, getMaterialThemeColorsTintList());
        } else {
            b.c(this, null);
        }
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialCheckBox(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.checkbox.MaterialCheckBox.f10358g
            android.content.Context r7 = ib.a.a(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialCheckBox
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.w.d(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R$styleable.MaterialCheckBox_buttonTint
            boolean r9 = r8.hasValue(r9)
            if (r9 == 0) goto L29
            int r9 = com.google.android.material.R$styleable.MaterialCheckBox_buttonTint
            android.content.res.ColorStateList r9 = com.google.android.gms.internal.mlkit_vision_barcode.t0.a(r0, r8, r9)
            androidx.core.widget.b.c(r6, r9)
        L29:
            int r9 = com.google.android.material.R$styleable.MaterialCheckBox_useMaterialThemeColors
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f10360f = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.checkbox.MaterialCheckBox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
