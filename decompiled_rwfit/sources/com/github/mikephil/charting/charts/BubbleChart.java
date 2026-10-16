package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import o7.f;
import r7.c;
import u7.d;
import v7.h;

/* loaded from: classes.dex */
public class BubbleChart extends BarLineChartBase<f> implements c {
    public BubbleChart(Context context) {
        super(context);
    }

    @Override // r7.c
    public f getBubbleData() {
        if (this.f8792b == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void m() {
        super.m();
        d dVar = new d(this.f8808t, this.f8807s);
        dVar.f18942g = this;
        dVar.f18949c.setStyle(Paint.Style.FILL);
        dVar.f18950d.setStyle(Paint.Style.STROKE);
        dVar.f18950d.setStrokeWidth(h.c(1.5f));
        this.f8806q = dVar;
    }

    public BubbleChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
