package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/* loaded from: classes.dex */
public class SegmentedProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f8555a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f8556b;

    /* renamed from: c, reason: collision with root package name */
    public int f8557c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8558d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8559f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8560g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8561h;

    public SegmentedProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f8555a = paint;
        paint.setAntiAlias(true);
        this.f8558d = a(12);
        this.e = a(20);
        this.f8559f = a(20);
        this.f8560g = -1;
        this.f8561h = -1;
    }

    public final int a(int i3) {
        return (int) ((i3 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i3 = this.e;
        Paint paint = this.f8555a;
        super.onDraw(canvas);
        if (this.f8556b == null || this.f8557c == 0) {
            return;
        }
        Log.d("tong333", "MeasuredWidth = " + getMeasuredWidth());
        int a3 = a(getMeasuredWidth());
        if (getResources().getDisplayMetrics().density >= 3.0f) {
            a3 = a(getMeasuredWidth() - 100);
        } else if (getResources().getDisplayMetrics().density == 2.0f) {
            a3 = a(getMeasuredWidth() + 200);
        }
        Log.d("tong333", "density = " + getResources().getDisplayMetrics().density);
        Log.d("tong333", "totalWidth = " + a3);
        int i10 = this.f8557c;
        float f2 = (float) ((a3 - ((i10 + (-1)) * i3)) / i10);
        Log.d("tong333", "segmentWidth = " + f2);
        float f10 = 0.0f;
        for (int i11 = 0; i11 < this.f8557c; i11++) {
            float f11 = this.f8556b[i11] * f2;
            paint.setColor(this.f8561h);
            Path path = new Path();
            float f12 = f10 + f11;
            path.addRoundRect(new RectF(f10, 0.0f, f12, this.f8558d), new float[]{20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f}, Path.Direction.CW);
            canvas.drawPath(path, paint);
            if (i11 < this.f8557c - 1 && (i11 != 1 || this.f8556b[2] > 0.0f)) {
                paint.setColor(this.f8560g);
                canvas.drawRect(f12, (int) (getResources().getDisplayMetrics().density * 4.0f), f12 + this.f8559f, r9 + 6, this.f8555a);
            }
            f10 += f11 + i3;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        int size = View.MeasureSpec.getSize(i3);
        View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i10);
        View.MeasureSpec.getMode(i10);
        setMeasuredDimension(size, size2);
    }

    public void setSegments(float[] fArr) {
        this.f8556b = fArr;
        this.f8557c = fArr.length;
        requestLayout();
    }
}
