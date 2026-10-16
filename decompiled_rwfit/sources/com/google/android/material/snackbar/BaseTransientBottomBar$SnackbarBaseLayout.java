package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import d1.b;
import fb.c;
import ib.a;
import java.util.WeakHashMap;
import l1.h0;
import l1.l0;
import l1.n0;
import l1.z0;

/* loaded from: classes.dex */
public class BaseTransientBottomBar$SnackbarBaseLayout extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public static final c f10767f = new c(0);

    /* renamed from: a, reason: collision with root package name */
    public int f10768a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10769b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10770c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f10771d;
    public PorterDuff.Mode e;

    public BaseTransientBottomBar$SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
            float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0);
            WeakHashMap weakHashMap = z0.f15748a;
            n0.s(this, dimensionPixelSize);
        }
        this.f10768a = obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
        this.f10769b = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        setBackgroundTintList(t0.a(context2, obtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
        setBackgroundTintMode(gb.e(obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
        this.f10770c = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f10767f);
        setFocusable(true);
        if (getBackground() == null) {
            float dimension = getResources().getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(x.d(x.b(R$attr.colorSurface, this), getBackgroundOverlayColorAlpha(), x.b(R$attr.colorOnSurface, this)));
            ColorStateList colorStateList = this.f10771d;
            if (colorStateList != null) {
                b.h(gradientDrawable, colorStateList);
            }
            WeakHashMap weakHashMap2 = z0.f15748a;
            h0.q(this, gradientDrawable);
        }
    }

    public float getActionTextColorAlpha() {
        return this.f10770c;
    }

    public int getAnimationMode() {
        return this.f10768a;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f10769b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        WeakHashMap weakHashMap = z0.f15748a;
        l0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
    }

    public void setAnimationMode(int i3) {
        this.f10768a = i3;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f10771d != null) {
            drawable = drawable.mutate();
            b.h(drawable, this.f10771d);
            b.i(drawable, this.e);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f10771d = colorStateList;
        if (getBackground() != null) {
            Drawable mutate = getBackground().mutate();
            b.h(mutate, colorStateList);
            b.i(mutate, this.e);
            if (mutate != getBackground()) {
                super.setBackgroundDrawable(mutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.e = mode;
        if (getBackground() != null) {
            Drawable mutate = getBackground().mutate();
            b.i(mutate, mode);
            if (mutate != getBackground()) {
                super.setBackgroundDrawable(mutate);
            }
        }
    }

    public void setOnAttachStateChangeListener(fb.a aVar) {
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f10767f);
        super.setOnClickListener(onClickListener);
    }

    public void setOnLayoutChangeListener(fb.b bVar) {
    }
}
