package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/* loaded from: classes.dex */
public class NoThumbCircleProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    public Context f8494a;

    /* renamed from: b, reason: collision with root package name */
    public Paint f8495b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f8496c;

    /* renamed from: d, reason: collision with root package name */
    public float f8497d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f8498f;

    /* renamed from: g, reason: collision with root package name */
    public int f8499g;

    /* renamed from: h, reason: collision with root package name */
    public int f8500h;

    /* renamed from: i, reason: collision with root package name */
    public int f8501i;

    public NoThumbCircleProgressView(Context context) {
        super(context);
        this.f8497d = 100.0f;
        this.e = 0;
        this.f8498f = -6582273;
        this.f8499g = -9954817;
        this.f8500h = 20;
        this.f8501i = 20;
        a(context);
    }

    public final void a(Context context) {
        this.f8494a = context;
        Paint paint = new Paint();
        this.f8495b = paint;
        paint.setAntiAlias(true);
        this.f8495b.setLinearText(true);
        Paint paint2 = new Paint();
        this.f8496c = paint2;
        paint2.setAntiAlias(true);
        this.f8496c.setStyle(Paint.Style.STROKE);
        this.f8500h = com.example.baselibrary.utils.b.f(this.f8494a, 10.0f);
        Log.d("XXXtong", "mStrokeWidth = " + this.f8500h);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8496c.setColor(this.f8498f);
        this.f8496c.setStrokeWidth(this.f8500h);
        int measuredWidth = getMeasuredWidth();
        this.f8497d = measuredWidth - 10;
        Log.d("XXXtong", "parent width = " + measuredWidth);
        Log.d("XXXtong", "mWidth = " + this.f8497d);
        RectF rectF = new RectF();
        float f2 = (float) measuredWidth;
        float f10 = this.f8497d;
        float f11 = (f2 - f10) / 2.0f;
        rectF.left = f11;
        float f12 = 0.1f * f10;
        rectF.top = f12;
        float f13 = ((f2 - f10) / 2.0f) + f10;
        rectF.right = f13;
        float f14 = f10 * 0.9f;
        rectF.bottom = f14;
        if (f13 - f11 > f14 - f12) {
            float f15 = ((f13 - f11) - (f14 - f12)) / 2.0f;
            rectF.left = f11 + f15;
            rectF.right = f13 - f15;
        }
        canvas.drawArc(rectF, 270.0f, 360.0f, false, this.f8496c);
        this.f8496c.setColor(this.f8499g);
        this.f8496c.setStrokeCap(Paint.Cap.ROUND);
        this.f8496c.setStrokeWidth(this.f8501i);
        canvas.drawArc(rectF, 270.0f, this.e, false, this.f8496c);
    }

    public void setBottomText(String str) {
        invalidate();
    }

    public void setBottomTextColor(int i3) {
        this.f8494a.getResources().getColor(i3);
        invalidate();
    }

    public void setCircleBackgroundColor(int i3) {
        this.f8498f = this.f8494a.getResources().getColor(i3);
        invalidate();
    }

    public void setInnerStrokeWidth(int i3) {
        this.f8501i = i3;
        invalidate();
    }

    public void setProgress(float f2) {
        int i3 = (int) (((f2 * 1.0d) / 100.0d) * 360.0d);
        if (i3 != 0 && f2 <= 100.0f) {
            this.e = i3;
            String.valueOf(f2);
        }
        if (i3 == 0) {
            this.e = 0;
        }
        invalidate();
    }

    public void setProgressColor(int i3) {
        this.f8499g = this.f8494a.getResources().getColor(i3);
        invalidate();
    }

    public void setStrokeWidth(int i3) {
        this.f8500h = i3;
        invalidate();
    }

    public void setText(String str) {
        invalidate();
    }

    public void setTextColor(int i3) {
        this.f8494a.getResources().getColor(i3);
        invalidate();
    }

    public void setTextSize(int i3) {
        invalidate();
    }

    public void setTopText(String str) {
        invalidate();
    }

    public void setTopTextColor(int i3) {
        this.f8494a.getResources().getColor(i3);
        invalidate();
    }

    public void setTopTextSize(int i3) {
        invalidate();
    }

    public void setWidth(float f2) {
        this.f8497d = f2;
        invalidate();
    }

    public NoThumbCircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8497d = 100.0f;
        this.e = 0;
        this.f8498f = -6582273;
        this.f8499g = -9954817;
        this.f8500h = 20;
        this.f8501i = 20;
        a(context);
    }

    public NoThumbCircleProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8497d = 100.0f;
        this.e = 0;
        this.f8498f = -6582273;
        this.f8499g = -9954817;
        this.f8500h = 20;
        this.f8501i = 20;
        a(context);
    }
}
