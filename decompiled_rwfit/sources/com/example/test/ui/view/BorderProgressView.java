package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public class BorderProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f8341a;

    /* renamed from: b, reason: collision with root package name */
    public int f8342b;

    /* renamed from: c, reason: collision with root package name */
    public int f8343c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8344d;
    public final float e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f8345f;

    /* renamed from: g, reason: collision with root package name */
    public int f8346g;

    public BorderProgressView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.e;
        int i3 = this.f8343c;
        canvas.drawRoundRect(f2, f2, this.f8342b - f2, i3 - f2, i3 / 2.0f, i3 / 2.0f, this.f8341a);
        int i10 = this.f8346g;
        if (i10 > 0) {
            float f10 = this.f8342b;
            float f11 = this.e;
            float f12 = (i10 / 100.0f) * (f10 - (f11 * 2.0f));
            int i11 = this.f8343c;
            if (f12 < i11 - (f11 * 2.0f)) {
                f12 = i11 - (f11 * 2.0f);
            }
            canvas.drawRoundRect(f11 * 2.0f, f11 * 2.0f, f12, i11 - (f11 * 2.0f), (i11 - (f11 * 2.0f)) / 2.0f, (i11 - (f11 * 2.0f)) / 2.0f, this.f8344d);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        this.f8342b = View.MeasureSpec.getSize(i3);
        this.f8343c = View.MeasureSpec.getSize(i10);
        float f2 = this.f8343c;
        int[] iArr = this.f8345f;
        this.f8344d.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f2, iArr[0], iArr[1], Shader.TileMode.MIRROR));
    }

    public void setCurrentProgress(int i3) {
        this.f8346g = i3;
        invalidate();
    }

    public BorderProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BorderProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BorderProgressView);
            this.f8346g = obtainStyledAttributes.getInt(R$styleable.BorderProgressView_border_progress, 0);
            obtainStyledAttributes.recycle();
        }
        this.e = com.example.baselibrary.utils.b.f(context, 1.5f);
        this.f8345f = new int[]{0, Color.parseColor("#53ABB7")};
        this.f8345f[0] = Color.parseColor("#73EAFB");
        Paint paint = new Paint(1);
        this.f8341a = paint;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        this.f8341a.setStrokeWidth(this.e);
        this.f8341a.setStyle(Paint.Style.STROKE);
        this.f8341a.setColor(Color.parseColor("#b3b3b3"));
        Paint paint2 = new Paint(1);
        this.f8344d = paint2;
        paint2.setStrokeCap(cap);
    }
}
