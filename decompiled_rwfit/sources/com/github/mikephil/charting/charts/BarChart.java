package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import n7.h;
import n7.i;
import o7.a;
import q7.c;
import u7.b;

/* loaded from: classes.dex */
public class BarChart extends BarLineChartBase<a> implements r7.a {
    public boolean W0;
    public boolean X0;
    public boolean Y0;
    public boolean Z0;

    public BarChart(Context context) {
        super(context);
        this.W0 = false;
        this.X0 = true;
        this.Y0 = false;
        this.Z0 = false;
    }

    @Override // r7.a
    public final boolean a() {
        return this.Y0;
    }

    @Override // r7.a
    public final boolean b() {
        return this.X0;
    }

    @Override // r7.a
    public final boolean c() {
        return this.W0;
    }

    @Override // r7.a
    public a getBarData() {
        return (a) this.f8792b;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public c j(float f2, float f10) {
        if (this.f8792b == null) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        c b3 = getHighlighter().b(f2, f10);
        return (b3 == null || !this.W0) ? b3 : new c(b3.f17797a, b3.f17798b, b3.f17799c, b3.f17800d, b3.f17801f, b3.f17803h, 0);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void m() {
        super.m();
        this.f8806q = new b(this, this.f8808t, this.f8807s);
        setHighlighter(new q7.a(this));
        getXAxis().f16403x = 0.5f;
        getXAxis().f16404y = 0.5f;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public final void q() {
        if (this.Z0) {
            h hVar = this.f8798i;
            o7.h hVar2 = this.f8792b;
            hVar.a(((a) hVar2).f16829d - (((a) hVar2).f16801j / 2.0f), (((a) hVar2).f16801j / 2.0f) + ((a) hVar2).f16828c);
        } else {
            h hVar3 = this.f8798i;
            o7.h hVar4 = this.f8792b;
            hVar3.a(((a) hVar4).f16829d, ((a) hVar4).f16828c);
        }
        i iVar = this.W;
        a aVar = (a) this.f8792b;
        YAxis$AxisDependency yAxis$AxisDependency = YAxis$AxisDependency.LEFT;
        iVar.a(aVar.g(yAxis$AxisDependency), ((a) this.f8792b).f(yAxis$AxisDependency));
        i iVar2 = this.f8781a0;
        a aVar2 = (a) this.f8792b;
        YAxis$AxisDependency yAxis$AxisDependency2 = YAxis$AxisDependency.RIGHT;
        iVar2.a(aVar2.g(yAxis$AxisDependency2), ((a) this.f8792b).f(yAxis$AxisDependency2));
    }

    public void setDrawBarShadow(boolean z5) {
        this.Y0 = z5;
    }

    public void setDrawValueAboveBar(boolean z5) {
        this.X0 = z5;
    }

    public void setFitBars(boolean z5) {
        this.Z0 = z5;
    }

    public void setHighlightFullBarEnabled(boolean z5) {
        this.W0 = z5;
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W0 = false;
        this.X0 = true;
        this.Y0 = false;
        this.Z0 = false;
    }

    public BarChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.W0 = false;
        this.X0 = true;
        this.Y0 = false;
        this.Z0 = false;
    }
}
