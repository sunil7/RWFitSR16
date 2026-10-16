package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;

/* loaded from: classes.dex */
public class GpsSingleView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f8427a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f8428b;

    /* renamed from: c, reason: collision with root package name */
    public int f8429c;

    /* renamed from: d, reason: collision with root package name */
    public int f8430d;
    public int e;

    public GpsSingleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.f8429c;
        canvas.drawLine((i3 / 7.0f) / 2.0f, ((i3 / 7.0f) / 2.0f) + ((r2 * 3) / 4.0f), (i3 / 7.0f) / 2.0f, this.f8430d - ((i3 / 7.0f) / 2.0f), this.e >= 1 ? this.f8427a : this.f8428b);
        int i10 = this.f8429c;
        canvas.drawLine(((i10 / 7.0f) / 2.0f) * 5.0f, ((i10 / 7.0f) / 2.0f) + ((r2 * 2) / 4.0f), ((i10 / 7.0f) / 2.0f) * 5.0f, this.f8430d - ((i10 / 7.0f) / 2.0f), this.e >= 2 ? this.f8427a : this.f8428b);
        int i11 = this.f8429c;
        float f2 = ((i11 / 7.0f) / 2.0f) * 9.0f;
        int i12 = this.f8430d;
        canvas.drawLine(f2, ((i11 / 7.0f) / 2.0f) + (i12 / 4.0f), ((i11 / 7.0f) / 2.0f) * 9.0f, i12 - ((i11 / 7.0f) / 2.0f), this.e >= 3 ? this.f8427a : this.f8428b);
        int i13 = this.f8429c;
        canvas.drawLine(((i13 / 7.0f) / 2.0f) * 13.0f, (i13 / 7.0f) / 2.0f, ((i13 / 7.0f) / 2.0f) * 13.0f, this.f8430d - ((i13 / 7.0f) / 2.0f), this.e >= 4 ? this.f8427a : this.f8428b);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        this.f8429c = View.MeasureSpec.getSize(i3);
        this.f8430d = View.MeasureSpec.getSize(i3);
        this.f8427a.setStrokeWidth(this.f8429c / 7.0f);
        this.f8428b.setStrokeWidth(this.f8429c / 7.0f);
    }

    public void setLevel(int i3) {
        this.e = i3;
        invalidate();
    }

    public GpsSingleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GpsSingleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint(1);
        this.f8427a = paint;
        paint.setColor(getResources().getColor(R$color.colorAccent));
        Paint paint2 = this.f8427a;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        Paint paint3 = new Paint(1);
        this.f8428b = paint3;
        paint3.setColor(getResources().getColor(R$color.color_80888888));
        this.f8428b.setStrokeCap(cap);
    }
}
