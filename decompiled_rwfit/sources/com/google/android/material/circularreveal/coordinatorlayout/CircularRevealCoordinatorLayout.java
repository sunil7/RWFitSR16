package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ra.d;
import ra.e;

/* loaded from: classes.dex */
public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements e {

    /* renamed from: y, reason: collision with root package name */
    public final androidx.camera.core.impl.e f10392y;

    public CircularRevealCoordinatorLayout(Context context) {
        this(context, null);
    }

    @Override // ra.e
    public final void c() {
        this.f10392y.getClass();
    }

    @Override // ra.e
    public final void d(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        androidx.camera.core.impl.e eVar = this.f10392y;
        if (eVar != null) {
            eVar.d(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // ra.e
    public final void e() {
        this.f10392y.getClass();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return (Drawable) this.f10392y.f1377b;
    }

    @Override // ra.e
    public int getCircularRevealScrimColor() {
        return ((Paint) this.f10392y.e).getColor();
    }

    @Override // ra.e
    public d getRevealInfo() {
        return this.f10392y.h();
    }

    @Override // ra.e
    public final boolean h() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public final boolean isOpaque() {
        androidx.camera.core.impl.e eVar = this.f10392y;
        return eVar != null ? eVar.i() : super.isOpaque();
    }

    @Override // ra.e
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f10392y.l(drawable);
    }

    @Override // ra.e
    public void setCircularRevealScrimColor(int i3) {
        this.f10392y.m(i3);
    }

    @Override // ra.e
    public void setRevealInfo(d dVar) {
        this.f10392y.n(dVar);
    }

    public CircularRevealCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10392y = new androidx.camera.core.impl.e(this);
    }
}
