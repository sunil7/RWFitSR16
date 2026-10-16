package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;
import com.example.test.R$mipmap;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public class CircleProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f8355a;

    /* renamed from: b, reason: collision with root package name */
    public int f8356b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f8357c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8358d;
    public final Paint e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f8359f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f8360g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f8361h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f8362i;

    /* renamed from: j, reason: collision with root package name */
    public SweepGradient f8363j;

    /* renamed from: k, reason: collision with root package name */
    public final Bitmap f8364k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f8365l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f8366m;

    /* renamed from: n, reason: collision with root package name */
    public float f8367n;

    /* renamed from: o, reason: collision with root package name */
    public String f8368o;

    /* renamed from: p, reason: collision with root package name */
    public float f8369p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f8370q;
    public final float r;

    /* renamed from: s, reason: collision with root package name */
    public final float f8371s;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(90.0f, this.f8356b / 2.0f, this.f8355a / 2.0f);
        RectF rectF = this.f8357c;
        float f2 = this.f8367n;
        canvas.drawArc(rectF, ((f2 * 360.0f) + 0.0f) - 360.0f, 360.0f - (f2 * 360.0f), false, this.e);
        this.f8358d.setShader(this.f8363j);
        canvas.drawArc(this.f8357c, 0.0f, this.f8367n * 360.0f, false, this.f8358d);
        canvas.restore();
        canvas.save();
        canvas.rotate(this.f8367n * 360.0f, this.f8356b / 2.0f, this.f8355a / 2.0f);
        float f10 = this.f8355a;
        float f11 = this.r;
        canvas.drawCircle(this.f8356b / 2.0f, f10 - f11, (4.0f * f11) / 5.0f, this.f8359f);
        canvas.drawCircle(this.f8356b / 2.0f, this.f8355a - f11, f11 / 2.0f, this.f8360g);
        canvas.restore();
        Paint paint = this.f8361h;
        Context context = getContext();
        float f12 = this.f8371s;
        paint.setTextSize(com.example.baselibrary.utils.b.v(context, f12));
        float f13 = this.f8369p;
        if (f13 > 0.0f) {
            if (this.f8370q) {
                canvas.drawText(this.f8368o, (this.f8356b - f13) / 2.0f, (this.f8355a / 2.0f) + com.example.baselibrary.utils.b.v(getContext(), f12), this.f8361h);
            } else {
                canvas.drawText(this.f8368o, (this.f8356b - f13) / 2.0f, (com.example.baselibrary.utils.b.v(getContext(), f12) + this.f8355a) / 2.0f, this.f8361h);
            }
        }
        if (this.f8370q) {
            canvas.drawBitmap(this.f8364k, this.f8365l, this.f8366m, this.f8361h);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        Bitmap bitmap = this.f8364k;
        Rect rect = this.f8366m;
        super.onMeasure(i3, i10);
        this.f8356b = View.MeasureSpec.getSize(i3);
        int size = View.MeasureSpec.getSize(i10);
        this.f8355a = size;
        RectF rectF = this.f8357c;
        float f2 = this.r;
        rectF.left = f2;
        rectF.right = this.f8356b - f2;
        rectF.top = f2;
        rectF.bottom = size - f2;
        if (this.f8363j == null) {
            this.f8363j = new SweepGradient(this.f8356b / 2.0f, this.f8355a / 2.0f, this.f8362i, new float[]{0.0f, 1.0f});
        }
        rect.left = (this.f8356b - bitmap.getWidth()) / 2;
        rect.top = ((this.f8355a / 2) - bitmap.getHeight()) + 6;
        rect.right = (bitmap.getWidth() / 2) + (this.f8356b / 2);
        rect.bottom = (this.f8355a / 2) + 6;
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8367n = 0.0f;
        this.f8368o = "0";
        this.r = 26.0f;
        this.f8371s = 22.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleProgressView);
            this.f8370q = obtainStyledAttributes.getBoolean(R$styleable.CircleProgressView_is_show_progress_icon, true);
            obtainStyledAttributes.recycle();
        }
        this.f8357c = new RectF();
        Paint paint = new Paint(1);
        this.f8358d = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f8358d.setStrokeWidth(26.0f);
        this.f8358d.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint(1);
        this.e = paint2;
        paint2.setStyle(style);
        this.e.setColor(getResources().getColor(R$color.colorPrimaryDark));
        this.e.setStrokeWidth(26.0f);
        Paint paint3 = new Paint(1);
        this.f8359f = paint3;
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        this.f8359f.setColor(getResources().getColor(R$color.color_29b7cb));
        Paint paint4 = new Paint(1);
        this.f8360g = paint4;
        paint4.setStyle(style2);
        this.f8360g.setColor(-1);
        this.f8362i = new int[]{getResources().getColor(R$color.color_29b7cb), getResources().getColor(R$color.color_29b7cb)};
        Paint paint5 = new Paint(33);
        this.f8361h = paint5;
        paint5.setColor(-1);
        this.f8361h.setTextSize(com.example.baselibrary.utils.b.v(context, 22.0f));
        this.f8369p = this.f8361h.measureText(this.f8368o);
        this.f8364k = BitmapFactory.decodeResource(getResources(), R$mipmap.ic_step);
        this.f8365l = new Rect(0, 0, this.f8364k.getWidth(), this.f8364k.getHeight());
        this.f8366m = new Rect();
    }
}
