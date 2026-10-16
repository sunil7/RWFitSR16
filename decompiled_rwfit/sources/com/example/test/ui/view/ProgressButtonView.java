package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public class ProgressButtonView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f8520a;

    /* renamed from: b, reason: collision with root package name */
    public int f8521b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f8522c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8523d;
    public RectF e;

    /* renamed from: f, reason: collision with root package name */
    public RectF f8524f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8525g;

    /* renamed from: h, reason: collision with root package name */
    public final float f8526h;

    /* renamed from: i, reason: collision with root package name */
    public String f8527i;

    /* renamed from: j, reason: collision with root package name */
    public float f8528j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8529k;

    public ProgressButtonView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8522c.setColor(getResources().getColor(R$color.color_45516c));
        RectF rectF = this.e;
        float f2 = this.f8525g;
        canvas.drawRoundRect(rectF, f2, f2, this.f8522c);
        if (this.f8529k) {
            this.f8522c.setColor(getResources().getColor(R$color.colorAccent));
            RectF rectF2 = this.f8524f;
            rectF2.right = (this.f8528j / 100.0f) * this.f8520a;
            float f10 = this.f8525g;
            canvas.drawRoundRect(rectF2, f10, f10, this.f8522c);
        }
        String str = this.f8527i;
        if ((str == null || str.length() == 0 || "null".equalsIgnoreCase(str)) ? false : true) {
            Rect rect = new Rect();
            Paint paint = this.f8523d;
            String str2 = this.f8527i;
            paint.getTextBounds(str2, 0, str2.length(), rect);
            canvas.drawText(this.f8527i, (this.f8520a - (rect.right - rect.left)) / 2.0f, ((rect.bottom - rect.top) + this.f8521b) / 2.0f, this.f8523d);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        this.f8520a = View.MeasureSpec.getSize(i3);
        this.f8521b = View.MeasureSpec.getSize(i10);
        if (this.e != null || this.f8520a <= 0) {
            return;
        }
        RectF rectF = new RectF();
        this.e = rectF;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = this.f8520a;
        rectF.bottom = this.f8521b;
        RectF rectF2 = new RectF();
        this.f8524f = rectF2;
        rectF2.left = 0.0f;
        rectF2.top = 0.0f;
        rectF2.right = this.f8520a;
        rectF2.bottom = this.f8521b;
    }

    public void setCanPress(boolean z5) {
        this.f8529k = z5;
        setEnabled(z5);
        invalidate();
    }

    public void setEnable(boolean z5) {
        if (z5) {
            this.f8528j = 100.0f;
        } else {
            this.f8528j = 0.0f;
        }
        setEnabled(z5);
        invalidate();
    }

    public void setProgress(float f2) {
        this.f8528j = f2;
        setEnabled(false);
        invalidate();
    }

    public void setText(String str) {
        this.f8527i = str;
        invalidate();
    }

    public ProgressButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressButtonView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8527i = "";
        this.f8528j = 0.0f;
        this.f8529k = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ProgressButtonView);
            this.f8526h = obtainStyledAttributes.getDimension(R$styleable.ProgressButtonView_button_text_size, com.example.baselibrary.utils.b.v(context, 16.0f));
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.f8522c = paint;
        paint.setColor(getResources().getColor(R$color.color_45516c));
        this.f8525g = com.example.baselibrary.utils.b.f(context, 8.0f);
        Paint paint2 = new Paint(1);
        this.f8523d = paint2;
        paint2.setColor(-1);
        this.f8523d.setTextSize(this.f8526h);
    }
}
