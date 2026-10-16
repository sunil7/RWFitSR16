package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import o7.l;
import r7.h;
import u7.s;

/* loaded from: classes.dex */
public class ScatterChart extends BarLineChartBase<l> implements h {
    public ScatterChart(Context context) {
        super(context);
    }

    @Override // r7.h
    public l getScatterData() {
        if (this.f8792b == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void m() {
        super.m();
        s sVar = new s(this.f8808t, this.f8807s);
        sVar.f18991h = this;
        this.f8806q = sVar;
        getXAxis().f16403x = 0.5f;
        getXAxis().f16404y = 0.5f;
    }

    public ScatterChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
