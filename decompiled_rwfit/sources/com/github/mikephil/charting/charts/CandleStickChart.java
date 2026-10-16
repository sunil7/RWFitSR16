package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import o7.g;
import r7.d;
import u7.e;

/* loaded from: classes.dex */
public class CandleStickChart extends BarLineChartBase<g> implements d {
    public CandleStickChart(Context context) {
        super(context);
    }

    @Override // r7.d
    public g getCandleData() {
        if (this.f8792b == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void m() {
        super.m();
        e eVar = new e(this.f8808t, this.f8807s);
        eVar.f18943h = this;
        this.f8806q = eVar;
        getXAxis().f16403x = 0.5f;
        getXAxis().f16404y = 0.5f;
    }

    public CandleStickChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
