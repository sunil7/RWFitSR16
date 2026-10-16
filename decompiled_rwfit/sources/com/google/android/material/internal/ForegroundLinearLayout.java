package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* renamed from: p, reason: collision with root package name */
    public Drawable f10539p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f10540q;
    public final Rect r;

    /* renamed from: s, reason: collision with root package name */
    public int f10541s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f10542t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10543u;

    public ForegroundLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f10539p;
        if (drawable != null) {
            if (this.f10543u) {
                this.f10543u = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z5 = this.f10542t;
                Rect rect = this.f10540q;
                if (z5) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i3 = this.f10541s;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.r;
                Gravity.apply(i3, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float f2, float f10) {
        super.drawableHotspotChanged(f2, f10);
        Drawable drawable = this.f10539p;
        if (drawable != null) {
            drawable.setHotspot(f2, f10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f10539p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f10539p.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f10539p;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f10541s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f10539p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        this.f10543u = z5 | this.f10543u;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        super.onSizeChanged(i3, i10, i11, i12);
        this.f10543u = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f10539p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f10539p);
            }
            this.f10539p = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f10541s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i3) {
        if (this.f10541s != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.f10541s = i3;
            if (i3 == 119 && this.f10539p != null) {
                this.f10539p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f10539p;
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f10540q = new Rect();
        this.r = new Rect();
        this.f10541s = 119;
        this.f10542t = true;
        this.f10543u = false;
        TypedArray d5 = w.d(context, attributeSet, R$styleable.ForegroundLinearLayout, i3, 0, new int[0]);
        this.f10541s = d5.getInt(R$styleable.ForegroundLinearLayout_android_foregroundGravity, this.f10541s);
        Drawable drawable = d5.getDrawable(R$styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f10542t = d5.getBoolean(R$styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        d5.recycle();
    }
}
