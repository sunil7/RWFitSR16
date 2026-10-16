package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import n7.h;
import n7.i;
import q7.f;
import u7.r;
import u7.u;
import u7.x;

/* loaded from: classes.dex */
public class RadarChart extends PieRadarChartBase<Object> {
    public float J;
    public float K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public int P;
    public i Q;
    public x R;
    public u S;

    public RadarChart(Context context) {
        super(context);
        this.J = 2.5f;
        this.K = 1.5f;
        this.L = Color.rgb(122, 122, 122);
        this.M = Color.rgb(122, 122, 122);
        this.N = 150;
        this.O = true;
        this.P = 0;
    }

    public float getFactor() {
        RectF rectF = this.f8807s.f19202b;
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f) / this.Q.C;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.f8807s.f19202b;
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredBaseOffset() {
        h hVar = this.f8798i;
        return (hVar.f16406a && hVar.f16399t) ? hVar.F : v7.h.c(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredLegendOffset() {
        return this.f8805p.f18956b.getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.P;
    }

    public float getSliceAngle() {
        this.f8792b.getClass();
        throw new ClassCastException();
    }

    public int getWebAlpha() {
        return this.N;
    }

    public int getWebColor() {
        return this.L;
    }

    public int getWebColorInner() {
        return this.M;
    }

    public float getWebLineWidth() {
        return this.J;
    }

    public float getWebLineWidthInner() {
        return this.K;
    }

    public i getYAxis() {
        return this.Q;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart, r7.e
    public float getYChartMax() {
        return this.Q.A;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart, r7.e
    public float getYChartMin() {
        return this.Q.B;
    }

    public float getYRange() {
        return this.Q.C;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public final void m() {
        super.m();
        i iVar = new i(YAxis$AxisDependency.LEFT);
        this.Q = iVar;
        iVar.K = 10.0f;
        this.J = v7.h.c(1.5f);
        this.K = v7.h.c(0.75f);
        r rVar = new r(this.f8808t, this.f8807s);
        new Path();
        new Path();
        rVar.f18989h = this;
        Paint paint = new Paint(1);
        rVar.f18950d = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        rVar.f18950d.setStrokeWidth(2.0f);
        rVar.f18950d.setColor(Color.rgb(255, 187, 115));
        Paint paint2 = new Paint(1);
        rVar.f18990i = paint2;
        paint2.setStyle(style);
        new Paint(1);
        this.f8806q = rVar;
        x xVar = new x(this.f8807s, this.Q, null);
        new Path();
        xVar.f19007n = this;
        this.R = xVar;
        u uVar = new u(this.f8807s, this.f8798i, null, 1);
        uVar.f18998n = this;
        this.S = uVar;
        this.r = new f(this, 1);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public final void n() {
        if (this.f8792b == null) {
            return;
        }
        q();
        throw null;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8792b == null) {
            return;
        }
        h hVar = this.f8798i;
        if (hVar.f16406a) {
            this.S.j(hVar.B, hVar.A);
        }
        this.S.q(canvas);
        if (this.O) {
            this.f8806q.l(canvas);
        }
        boolean z5 = this.Q.f16406a;
        this.f8806q.k(canvas);
        if (p()) {
            this.f8806q.m(canvas, this.f8814z);
        }
        if (this.Q.f16406a) {
            this.R.s();
        }
        this.R.p(canvas);
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

    public void setDrawWeb(boolean z5) {
        this.O = z5;
    }

    public void setSkipWebLineCount(int i3) {
        this.P = Math.max(0, i3);
    }

    public void setWebAlpha(int i3) {
        this.N = i3;
    }

    public void setWebColor(int i3) {
        this.L = i3;
    }

    public void setWebColorInner(int i3) {
        this.M = i3;
    }

    public void setWebLineWidth(float f2) {
        this.J = v7.h.c(f2);
    }

    public void setWebLineWidthInner(float f2) {
        this.K = v7.h.c(f2);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final int t(float f2) {
        getRotationAngle();
        DisplayMetrics displayMetrics = v7.h.f19191a;
        getSliceAngle();
        this.f8792b.getClass();
        throw new ClassCastException();
    }

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = 2.5f;
        this.K = 1.5f;
        this.L = Color.rgb(122, 122, 122);
        this.M = Color.rgb(122, 122, 122);
        this.N = 150;
        this.O = true;
        this.P = 0;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = 2.5f;
        this.K = 1.5f;
        this.L = Color.rgb(122, 122, 122);
        this.M = Color.rgb(122, 122, 122);
        this.N = 150;
        this.O = true;
        this.P = 0;
    }
}
