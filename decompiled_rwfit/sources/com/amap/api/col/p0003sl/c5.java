package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* loaded from: classes.dex */
public class c5 extends View {

    /* renamed from: b, reason: collision with root package name */
    public static final int f3807b = Color.argb(255, 235, 235, 235);

    /* renamed from: c, reason: collision with root package name */
    public static final int f3808c = Color.argb(255, 21, 21, 21);

    /* renamed from: a, reason: collision with root package name */
    private Paint f3809a;

    public c5(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f3809a = paint;
        paint.setAntiAlias(true);
        this.f3809a.setColor(f3807b);
    }

    public void a(int i3) {
        Paint paint = this.f3809a;
        if (paint != null) {
            paint.setColor(i3);
            try {
                postInvalidate();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f3809a);
    }
}
