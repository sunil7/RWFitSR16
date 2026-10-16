package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import n7.h;
import q7.c;
import q7.f;
import u7.q;
import v7.d;

/* loaded from: classes.dex */
public class PieChart extends PieRadarChartBase<Object> {
    public final RectF J;
    public final float[] K;
    public final float[] L;
    public boolean M;
    public boolean N;
    public boolean O;
    public CharSequence P;
    public final d Q;
    public float R;
    public float S;
    public boolean T;
    public float U;
    public float V;
    public float W;

    public PieChart(Context context) {
        super(context);
        this.J = new RectF();
        this.K = new float[1];
        this.L = new float[1];
        this.M = true;
        this.N = false;
        this.O = false;
        this.P = "";
        this.Q = d.b(0.0f, 0.0f);
        this.R = 50.0f;
        this.S = 55.0f;
        this.T = true;
        this.U = 100.0f;
        this.V = 360.0f;
        this.W = 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public final void f() {
        super.f();
        if (this.f8792b == null) {
            return;
        }
        getDiameter();
        getCenterOffsets();
        this.f8792b.getClass();
        throw new ClassCastException();
    }

    public float[] getAbsoluteAngles() {
        return this.L;
    }

    public d getCenterCircleBox() {
        RectF rectF = this.J;
        return d.b(rectF.centerX(), rectF.centerY());
    }

    public CharSequence getCenterText() {
        return this.P;
    }

    public d getCenterTextOffset() {
        d dVar = this.Q;
        return d.b(dVar.f19182b, dVar.f19183c);
    }

    public float getCenterTextRadiusPercent() {
        return this.U;
    }

    public RectF getCircleBox() {
        return this.J;
    }

    public float[] getDrawAngles() {
        return this.K;
    }

    public float getHoleRadius() {
        return this.R;
    }

    public float getMaxAngle() {
        return this.V;
    }

    public float getMinAngleForSlices() {
        return this.W;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.J;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredBaseOffset() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredLegendOffset() {
        return this.f8805p.f18956b.getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.S;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public h getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public final float[] k(c cVar) {
        float[] fArr = this.L;
        d centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f2 = (radius / 10.0f) * 3.6f;
        if (this.M) {
            f2 = (radius - (getHoleRadius() * (radius / 100.0f))) / 2.0f;
        }
        float f10 = radius - f2;
        float rotationAngle = getRotationAngle();
        int i3 = (int) cVar.f17797a;
        float f11 = this.K[i3] / 2.0f;
        double d5 = f10;
        float f12 = (fArr[i3] + rotationAngle) - f11;
        this.f8808t.getClass();
        float cos = (float) ((Math.cos(Math.toRadians(f12 * 1.0f)) * d5) + centerCircleBox.f19182b);
        float f13 = (rotationAngle + fArr[i3]) - f11;
        this.f8808t.getClass();
        float sin = (float) ((Math.sin(Math.toRadians(f13 * 1.0f)) * d5) + centerCircleBox.f19183c);
        d.c(centerCircleBox);
        return new float[]{cos, sin};
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public final void m() {
        super.m();
        q qVar = new q(this.f8808t, this.f8807s);
        qVar.f18983m = new RectF();
        qVar.f18984n = new RectF[]{new RectF(), new RectF(), new RectF()};
        new Path();
        new RectF();
        qVar.f18987q = new Path();
        qVar.r = new Path();
        qVar.f18988s = new RectF();
        qVar.f18976f = this;
        Paint paint = new Paint(1);
        qVar.f18977g = paint;
        paint.setColor(-1);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        qVar.f18978h = paint2;
        paint2.setColor(-1);
        paint2.setStyle(style);
        paint2.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        qVar.f18979i = textPaint;
        textPaint.setColor(-16777216);
        textPaint.setTextSize(v7.h.c(12.0f));
        qVar.e.setTextSize(v7.h.c(13.0f));
        qVar.e.setColor(-1);
        Paint paint3 = qVar.e;
        Paint.Align align = Paint.Align.CENTER;
        paint3.setTextAlign(align);
        Paint paint4 = new Paint(1);
        qVar.f18980j = paint4;
        paint4.setColor(-1);
        paint4.setTextAlign(align);
        paint4.setTextSize(v7.h.c(13.0f));
        new Paint(1).setStyle(Paint.Style.STROKE);
        this.f8806q = qVar;
        this.f8798i = null;
        this.r = new f(this, 0);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        u7.h hVar = this.f8806q;
        if (hVar != null && (hVar instanceof q)) {
            q qVar = (q) hVar;
            Canvas canvas = qVar.f18986p;
            if (canvas != null) {
                canvas.setBitmap(null);
                qVar.f18986p = null;
            }
            WeakReference weakReference = qVar.f18985o;
            if (weakReference != null) {
                Bitmap bitmap = (Bitmap) weakReference.get();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                qVar.f18985o.clear();
                qVar.f18985o = null;
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8792b == null) {
            return;
        }
        this.f8806q.k(canvas);
        if (p()) {
            this.f8806q.m(canvas, this.f8814z);
        }
        this.f8806q.l(canvas);
        this.f8806q.o(canvas);
        this.f8805p.l(canvas);
        h(canvas);
        i(canvas);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final void q() {
        this.f8792b.getClass();
        throw new ClassCastException();
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.P = "";
        } else {
            this.P = charSequence;
        }
    }

    public void setCenterTextColor(int i3) {
        ((q) this.f8806q).f18979i.setColor(i3);
    }

    public void setCenterTextRadiusPercent(float f2) {
        this.U = f2;
    }

    public void setCenterTextSize(float f2) {
        ((q) this.f8806q).f18979i.setTextSize(v7.h.c(f2));
    }

    public void setCenterTextSizePixels(float f2) {
        ((q) this.f8806q).f18979i.setTextSize(f2);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((q) this.f8806q).f18979i.setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z5) {
        this.T = z5;
    }

    public void setDrawEntryLabels(boolean z5) {
    }

    public void setDrawHoleEnabled(boolean z5) {
        this.M = z5;
    }

    public void setDrawRoundedSlices(boolean z5) {
        this.O = z5;
    }

    @Deprecated
    public void setDrawSliceText(boolean z5) {
    }

    public void setDrawSlicesUnderHole(boolean z5) {
        this.N = z5;
    }

    public void setEntryLabelColor(int i3) {
        ((q) this.f8806q).f18980j.setColor(i3);
    }

    public void setEntryLabelTextSize(float f2) {
        ((q) this.f8806q).f18980j.setTextSize(v7.h.c(f2));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((q) this.f8806q).f18980j.setTypeface(typeface);
    }

    public void setHoleColor(int i3) {
        ((q) this.f8806q).f18977g.setColor(i3);
    }

    public void setHoleRadius(float f2) {
        this.R = f2;
    }

    public void setMaxAngle(float f2) {
        if (f2 > 360.0f) {
            f2 = 360.0f;
        }
        if (f2 < 90.0f) {
            f2 = 90.0f;
        }
        this.V = f2;
    }

    public void setMinAngleForSlices(float f2) {
        float f10 = this.V;
        if (f2 > f10 / 2.0f) {
            f2 = f10 / 2.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.W = f2;
    }

    public void setTransparentCircleAlpha(int i3) {
        ((q) this.f8806q).f18978h.setAlpha(i3);
    }

    public void setTransparentCircleColor(int i3) {
        Paint paint = ((q) this.f8806q).f18978h;
        int alpha = paint.getAlpha();
        paint.setColor(i3);
        paint.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f2) {
        this.S = f2;
    }

    public void setUsePercentValues(boolean z5) {
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final int t(float f2) {
        float rotationAngle = f2 - getRotationAngle();
        DisplayMetrics displayMetrics = v7.h.f19191a;
        while (rotationAngle < 0.0f) {
            rotationAngle += 360.0f;
        }
        float f10 = rotationAngle % 360.0f;
        int i3 = 0;
        while (true) {
            float[] fArr = this.L;
            if (i3 >= fArr.length) {
                return -1;
            }
            if (fArr[i3] > f10) {
                return i3;
            }
            i3++;
        }
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = new RectF();
        this.K = new float[1];
        this.L = new float[1];
        this.M = true;
        this.N = false;
        this.O = false;
        this.P = "";
        this.Q = d.b(0.0f, 0.0f);
        this.R = 50.0f;
        this.S = 55.0f;
        this.T = true;
        this.U = 100.0f;
        this.V = 360.0f;
        this.W = 0.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = new RectF();
        this.K = new float[1];
        this.L = new float[1];
        this.M = true;
        this.N = false;
        this.O = false;
        this.P = "";
        this.Q = d.b(0.0f, 0.0f);
        this.R = 50.0f;
        this.S = 55.0f;
        this.T = true;
        this.U = 100.0f;
        this.V = 360.0f;
        this.W = 0.0f;
    }
}
