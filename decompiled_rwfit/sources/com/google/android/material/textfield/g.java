package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
public final class g extends eb.h {

    /* renamed from: x, reason: collision with root package name */
    public final Paint f10901x;

    /* renamed from: y, reason: collision with root package name */
    public final RectF f10902y;

    /* renamed from: z, reason: collision with root package name */
    public int f10903z;

    public g(eb.m mVar) {
        super(mVar == null ? new eb.m() : mVar);
        Paint paint = new Paint(1);
        this.f10901x = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f10902y = new RectF();
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
            canvas2 = canvas;
        } else {
            canvas2 = canvas;
            this.f10903z = canvas2.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        }
        super.draw(canvas2);
        canvas2.drawRect(this.f10902y, this.f10901x);
        if (getCallback() instanceof View) {
            return;
        }
        canvas2.restoreToCount(this.f10903z);
    }

    public final void u(float f2, float f10, float f11, float f12) {
        RectF rectF = this.f10902y;
        if (f2 == rectF.left && f10 == rectF.top && f11 == rectF.right && f12 == rectF.bottom) {
            return;
        }
        rectF.set(f2, f10, f11, f12);
        invalidateSelf();
    }
}
