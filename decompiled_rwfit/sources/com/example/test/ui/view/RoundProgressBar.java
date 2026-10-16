package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public class RoundProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f8548a;

    /* renamed from: b, reason: collision with root package name */
    public int f8549b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f8550c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8551d;
    public LinearGradient e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8552f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8553g;

    /* renamed from: h, reason: collision with root package name */
    public int f8554h;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public int getCurrentProgress() {
        return this.f8554h;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.f8549b;
        canvas.drawLine(i3 / 2.0f, i3 / 2.0f, this.f8548a - (i3 / 2.0f), i3 / 2.0f, this.f8550c);
        int i10 = this.f8554h;
        if (i10 > 0) {
            float f2 = this.f8548a;
            int i11 = this.f8549b;
            float f10 = (i10 / 100.0f) * (f2 - (i11 / 2.0f));
            if (f10 < i11) {
                f10 = i11 / 2.0f;
            }
            canvas.drawLine(i11 / 2.0f, i11 / 2.0f, f10, i11 / 2.0f, this.f8551d);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        this.f8548a = View.MeasureSpec.getSize(i3);
        this.f8549b = View.MeasureSpec.getSize(i10);
        if (this.e == null) {
            this.e = new LinearGradient(0.0f, 0.0f, this.f8548a, 0.0f, this.f8552f, this.f8553g, Shader.TileMode.CLAMP);
        }
        this.f8550c.setStrokeWidth(this.f8549b);
        this.f8551d.setStrokeWidth(this.f8549b);
    }

    public void setCurrentProgress(int i3) {
        this.f8554h = i3;
        invalidate();
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundProgressBar);
            this.f8552f = obtainStyledAttributes.getColor(R$styleable.RoundProgressBar_color_bar_start, getResources().getColor(R$color.color_40c1d5));
            this.f8553g = obtainStyledAttributes.getColor(R$styleable.RoundProgressBar_color_bar_end, getResources().getColor(R$color.color_aef3fe));
            this.f8554h = obtainStyledAttributes.getInteger(R$styleable.RoundProgressBar_bar_progress, 0);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.f8550c = paint;
        paint.setColor(getResources().getColor(R$color.colorPrimaryDark));
        Paint paint2 = this.f8550c;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        Paint paint3 = new Paint(1);
        this.f8551d = paint3;
        paint3.setColor(this.f8552f);
        this.f8551d.setStrokeCap(cap);
    }
}
