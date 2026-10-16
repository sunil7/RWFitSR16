package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import ra.d;
import ra.e;

/* loaded from: classes.dex */
public class CircularRevealCardView extends MaterialCardView implements e {

    /* renamed from: p, reason: collision with root package name */
    public final androidx.camera.core.impl.e f10391p;

    public CircularRevealCardView(Context context) {
        this(context, null);
    }

    @Override // ra.e
    public final void c() {
        this.f10391p.getClass();
    }

    @Override // ra.e
    public final void d(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        androidx.camera.core.impl.e eVar = this.f10391p;
        if (eVar != null) {
            eVar.d(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // ra.e
    public final void e() {
        this.f10391p.getClass();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return (Drawable) this.f10391p.f1377b;
    }

    @Override // ra.e
    public int getCircularRevealScrimColor() {
        return ((Paint) this.f10391p.e).getColor();
    }

    @Override // ra.e
    public d getRevealInfo() {
        return this.f10391p.h();
    }

    @Override // ra.e
    public final boolean h() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public final boolean isOpaque() {
        androidx.camera.core.impl.e eVar = this.f10391p;
        return eVar != null ? eVar.i() : super.isOpaque();
    }

    @Override // ra.e
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f10391p.l(drawable);
    }

    @Override // ra.e
    public void setCircularRevealScrimColor(int i3) {
        this.f10391p.m(i3);
    }

    @Override // ra.e
    public void setRevealInfo(d dVar) {
        this.f10391p.n(dVar);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10391p = new androidx.camera.core.impl.e(this);
    }
}
