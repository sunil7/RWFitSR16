package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import ra.d;
import ra.e;

/* loaded from: classes.dex */
public class CircularRevealLinearLayout extends LinearLayout implements e {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.camera.core.impl.e f10389a;

    public CircularRevealLinearLayout(Context context) {
        this(context, null);
    }

    @Override // ra.e
    public final void c() {
        this.f10389a.getClass();
    }

    @Override // ra.e
    public final void d(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        androidx.camera.core.impl.e eVar = this.f10389a;
        if (eVar != null) {
            eVar.d(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // ra.e
    public final void e() {
        this.f10389a.getClass();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return (Drawable) this.f10389a.f1377b;
    }

    @Override // ra.e
    public int getCircularRevealScrimColor() {
        return ((Paint) this.f10389a.e).getColor();
    }

    @Override // ra.e
    public d getRevealInfo() {
        return this.f10389a.h();
    }

    @Override // ra.e
    public final boolean h() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public final boolean isOpaque() {
        androidx.camera.core.impl.e eVar = this.f10389a;
        return eVar != null ? eVar.i() : super.isOpaque();
    }

    @Override // ra.e
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f10389a.l(drawable);
    }

    @Override // ra.e
    public void setCircularRevealScrimColor(int i3) {
        this.f10389a.m(i3);
    }

    @Override // ra.e
    public void setRevealInfo(d dVar) {
        this.f10389a.n(dVar);
    }

    public CircularRevealLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10389a = new androidx.camera.core.impl.e(this);
    }
}
