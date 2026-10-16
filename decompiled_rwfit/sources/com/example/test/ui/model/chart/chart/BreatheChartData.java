package com.example.test.ui.model.chart.chart;

import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* loaded from: classes.dex */
public class BreatheChartData {
    private float avgTimes;
    private List<BarEntry> items;
    private float totalTimes;

    public float getAvgTimes() {
        return this.avgTimes;
    }

    public List<BarEntry> getItems() {
        return this.items;
    }

    public float getTotalTimes() {
        return this.totalTimes;
    }

    public void setAvgTimes(float f2) {
        this.avgTimes = f2;
    }

    public void setItems(List<BarEntry> list) {
        this.items = list;
    }

    public void setTotalTimes(float f2) {
        this.totalTimes = f2;
    }
}
