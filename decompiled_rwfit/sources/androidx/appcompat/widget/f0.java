package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public final class f0 extends d0 {
    public final AppCompatSeekBar e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f893f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f894g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f895h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f896i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f897j;

    public f0(AppCompatSeekBar appCompatSeekBar) {
        super(appCompatSeekBar);
        this.f894g = null;
        this.f895h = null;
        this.f896i = false;
        this.f897j = false;
        this.e = appCompatSeekBar;
    }

    @Override // androidx.appcompat.widget.d0
    public final void b(AttributeSet attributeSet, int i3) {
        super.b(attributeSet, i3);
        AppCompatSeekBar appCompatSeekBar = this.e;
        de.o I = de.o.I(appCompatSeekBar.getContext(), attributeSet, R$styleable.AppCompatSeekBar, i3);
        l1.z0.m(appCompatSeekBar, appCompatSeekBar.getContext(), R$styleable.AppCompatSeekBar, attributeSet, (TypedArray) I.f12378c, i3);
        Drawable x10 = I.x(R$styleable.AppCompatSeekBar_android_thumb);
        if (x10 != null) {
            appCompatSeekBar.setThumb(x10);
        }
        Drawable w8 = I.w(R$styleable.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f893f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f893f = w8;
        if (w8 != null) {
            w8.setCallback(appCompatSeekBar);
            d1.c.b(w8, l1.i0.d(appCompatSeekBar));
            if (w8.isStateful()) {
                w8.setState(appCompatSeekBar.getDrawableState());
            }
            f();
        }
        appCompatSeekBar.invalidate();
        int i10 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        TypedArray typedArray = (TypedArray) I.f12378c;
        if (typedArray.hasValue(i10)) {
            this.f895h = n1.c(typedArray.getInt(R$styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f895h);
            this.f897j = true;
        }
        if (typedArray.hasValue(R$styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f894g = I.v(R$styleable.AppCompatSeekBar_tickMarkTint);
            this.f896i = true;
        }
        I.K();
        f();
    }

    public final void f() {
        Drawable drawable = this.f893f;
        if (drawable != null) {
            if (this.f896i || this.f897j) {
                Drawable mutate = drawable.mutate();
                this.f893f = mutate;
                if (this.f896i) {
                    d1.b.h(mutate, this.f894g);
                }
                if (this.f897j) {
                    d1.b.i(this.f893f, this.f895h);
                }
                if (this.f893f.isStateful()) {
                    this.f893f.setState(this.e.getDrawableState());
                }
            }
        }
    }

    public final void g(Canvas canvas) {
        if (this.f893f != null) {
            int max = this.e.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f893f.getIntrinsicWidth();
                int intrinsicHeight = this.f893f.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i10 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f893f.setBounds(-i3, -i10, i3, i10);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i11 = 0; i11 <= max; i11++) {
                    this.f893f.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
