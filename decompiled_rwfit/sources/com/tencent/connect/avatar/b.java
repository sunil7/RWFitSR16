package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

/* loaded from: classes2.dex */
public class b extends View {

    /* renamed from: a, reason: collision with root package name */
    private Rect f11808a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f11809b;

    public b(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.f11809b = new Paint();
    }

    public Rect a() {
        if (this.f11808a == null) {
            this.f11808a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min(measuredHeight - 140, measuredWidth), GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH);
            int i3 = (measuredWidth - min) / 2;
            int i10 = (measuredHeight - min) / 2;
            this.f11808a.set(i3, i10, i3 + min, min + i10);
        }
        return this.f11808a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect a3 = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f11809b.setStyle(Paint.Style.FILL);
        this.f11809b.setColor(Color.argb(100, 0, 0, 0));
        float f2 = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f2, a3.top, this.f11809b);
        canvas.drawRect(0.0f, a3.bottom, f2, measuredHeight, this.f11809b);
        canvas.drawRect(0.0f, a3.top, a3.left, a3.bottom, this.f11809b);
        canvas.drawRect(a3.right, a3.top, f2, a3.bottom, this.f11809b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f11809b.setStyle(Paint.Style.STROKE);
        this.f11809b.setColor(-1);
        canvas.drawRect(a3.left, a3.top, a3.right - 1, a3.bottom, this.f11809b);
    }
}
