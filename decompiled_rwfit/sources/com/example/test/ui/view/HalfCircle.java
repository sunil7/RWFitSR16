package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public class HalfCircle extends View {

    /* renamed from: a, reason: collision with root package name */
    public final int f8431a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8432b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8433c;

    /* renamed from: d, reason: collision with root package name */
    public String f8434d;
    public final Paint e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f8435f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f8436g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8437h;

    /* renamed from: i, reason: collision with root package name */
    public float f8438i;

    /* renamed from: j, reason: collision with root package name */
    public float f8439j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8440k;

    public HalfCircle(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.f8437h;
        RectF rectF = new RectF(i3, i3, getWidth() - (i3 * 2), getHeight() - (i3 * 2));
        canvas.drawArc(rectF, 180.0f, 180.0f, false, this.e);
        float f2 = (180.0f / this.f8439j) * this.f8438i;
        canvas.drawArc(rectF, 180.0f, f2 >= 180.0f ? 180.0f : f2, false, this.f8436g);
        float height = getHeight() / 2;
        canvas.drawText(this.f8434d, (int) (((getWidth() - (i3 / 2)) / 2) - (r1.measureText(this.f8434d) / 2.0f)), ((int) ((((r1.descent() - r1.ascent()) / 2.0f) + height) - r1.descent())) - i3, this.f8435f);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i10);
        Rect rect = new Rect();
        Paint paint = this.e;
        String str = this.f8434d;
        paint.getTextBounds(str, 0, str.length(), rect);
        int i11 = this.f8433c;
        if (mode == Integer.MIN_VALUE) {
            size = getPaddingRight() + getPaddingLeft() + (i11 * 2) + (rect.width() / 2);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = getPaddingBottom() + getPaddingTop() + (i11 * 2) + (rect.width() / 2);
        }
        setMeasuredDimension(size, size2);
    }

    public void setMaxProgress(float f2) {
        this.f8439j = f2;
    }

    public void setProgress(Float f2) {
        this.f8438i = f2.floatValue();
        invalidate();
    }

    public void setText(String str) {
        this.f8434d = str;
    }

    public HalfCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HalfCircle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8437h = 20;
        this.f8438i = 0.0f;
        this.f8439j = 100.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Half_Circle_attrs);
        int color = obtainStyledAttributes.getColor(R$styleable.Half_Circle_attrs_bg_color, this.f8431a);
        this.f8431a = color;
        int color2 = obtainStyledAttributes.getColor(R$styleable.Half_Circle_attrs_fore_color, this.f8432b);
        this.f8432b = color2;
        this.f8433c = (int) obtainStyledAttributes.getDimension(R$styleable.Half_Circle_attrs_radius_len, this.f8433c);
        this.f8434d = (String) obtainStyledAttributes.getText(R$styleable.Half_Circle_attrs_text_str);
        int dimension = (int) obtainStyledAttributes.getDimension(R$styleable.Half_Circle_attrs_txt_size, this.f8440k);
        this.f8440k = dimension;
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        paint.setColor(color);
        float f2 = 20;
        paint.setStrokeWidth(f2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        float f10 = dimension;
        paint.setTextSize(f10);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint paint2 = new Paint();
        this.f8435f = paint2;
        paint2.setTextSize(f10);
        paint2.setFakeBoldText(true);
        paint2.setColor(color2);
        Paint paint3 = new Paint();
        this.f8436g = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(color2);
        paint3.setStrokeWidth(f2);
        paint3.setStrokeCap(cap);
        paint3.setTextSize(f10);
        paint3.setStyle(style);
        this.f8437h = com.example.baselibrary.utils.b.f(context, 10.0f);
    }
}
