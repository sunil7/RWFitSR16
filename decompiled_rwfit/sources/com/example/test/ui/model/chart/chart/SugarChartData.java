package com.example.test.ui.model.chart.chart;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public class SugarChartData {
    private float avgSugar;
    private float currentSugar;
    private String endTime;
    private List<Entry> items;
    private float maxSugar;
    private float minSugar;
    private String startTime;

    public float getAvgSugar() {
        return this.avgSugar;
    }

    public float getCurrentSugar() {
        return this.currentSugar;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public List<Entry> getItems() {
        return this.items;
    }

    public float getMaxSugar() {
        return this.maxSugar;
    }

    public float getMinSugar() {
        return this.minSugar;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setAvgSugar(float f2) {
        this.avgSugar = f2;
    }

    public void setCurrentSugar(float f2) {
        this.currentSugar = f2;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setItems(List<Entry> list) {
        this.items = list;
    }

    public void setMaxSugar(float f2) {
        this.maxSugar = f2;
    }

    public void setMinSugar(float f2) {
        this.minSugar = f2;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
