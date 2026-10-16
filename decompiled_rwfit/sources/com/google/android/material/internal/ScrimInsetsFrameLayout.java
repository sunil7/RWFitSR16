package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.example.test.ui.device.activity.f0;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.WeakHashMap;
import l1.n0;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f10549a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f10550b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f10551c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10552d;
    public boolean e;

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public void a(x1 x1Var) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f10550b == null || this.f10549a == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        boolean z5 = this.f10552d;
        Rect rect = this.f10551c;
        if (z5) {
            rect.set(0, 0, width, this.f10550b.top);
            this.f10549a.setBounds(rect);
            this.f10549a.draw(canvas);
        }
        if (this.e) {
            rect.set(0, height - this.f10550b.bottom, width, height);
            this.f10549a.setBounds(rect);
            this.f10549a.draw(canvas);
        }
        Rect rect2 = this.f10550b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.f10549a.setBounds(rect);
        this.f10549a.draw(canvas);
        Rect rect3 = this.f10550b;
        rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
        this.f10549a.setBounds(rect);
        this.f10549a.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f10549a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f10549a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z5) {
        this.e = z5;
    }

    public void setDrawTopInsetForeground(boolean z5) {
        this.f10552d = z5;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f10549a = drawable;
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f10551c = new Rect();
        this.f10552d = true;
        this.e = true;
        TypedArray d5 = w.d(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i3, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f10549a = d5.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        d5.recycle();
        setWillNotDraw(true);
        f0 f0Var = new f0(this, 8);
        WeakHashMap weakHashMap = z0.f15748a;
        n0.u(this, f0Var);
    }
}
