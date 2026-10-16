package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import java.util.WeakHashMap;
import l1.n0;
import l1.z0;
import ua.a;

/* loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {

    /* renamed from: a0, reason: collision with root package name */
    public static final int f10776a0 = R$style.Widget_MaterialComponents_CompoundButton_Switch;

    /* renamed from: b0, reason: collision with root package name */
    public static final int[][] f10777b0 = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public final a T;
    public ColorStateList U;
    public ColorStateList V;
    public boolean W;

    public SwitchMaterial(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.U == null) {
            int b3 = x.b(R$attr.colorSurface, this);
            int b10 = x.b(R$attr.colorControlActivated, this);
            float dimension = getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
            a aVar = this.T;
            if (aVar.f19028a) {
                float f2 = 0.0f;
                for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                    WeakHashMap weakHashMap = z0.f15748a;
                    f2 += n0.i((View) parent);
                }
                dimension += f2;
            }
            int a3 = aVar.a(dimension, b3);
            this.U = new ColorStateList(f10777b0, new int[]{x.d(b3, 1.0f, b10), a3, x.d(b3, 0.38f, b10), a3});
        }
        return this.U;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.V == null) {
            int b3 = x.b(R$attr.colorSurface, this);
            int b10 = x.b(R$attr.colorControlActivated, this);
            int b11 = x.b(R$attr.colorOnSurface, this);
            this.V = new ColorStateList(f10777b0, new int[]{x.d(b3, 0.54f, b10), x.d(b3, 0.32f, b11), x.d(b3, 0.12f, b10), x.d(b3, 0.12f, b11)});
        }
        return this.V;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.W && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.W && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z5) {
        this.W = z5;
        if (z5) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SwitchMaterial(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.switchmaterial.SwitchMaterial.f10776a0
            android.content.Context r7 = ib.a.a(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            ua.a r7 = new ua.a
            r7.<init>(r0)
            r6.T = r7
            int[] r2 = com.google.android.material.R$styleable.SwitchMaterial
            r7 = 0
            int[] r5 = new int[r7]
            com.google.android.material.internal.w.a(r0, r8, r9, r4)
            r1 = r8
            r3 = r9
            com.google.android.material.internal.w.b(r0, r1, r2, r3, r4, r5)
            android.content.res.TypedArray r8 = r0.obtainStyledAttributes(r1, r2, r3, r4)
            int r9 = com.google.android.material.R$styleable.SwitchMaterial_useMaterialThemeColors
            boolean r7 = r8.getBoolean(r9, r7)
            r6.W = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.switchmaterial.SwitchMaterial.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
