package com.example.test.ui.model.chart.chart;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public class TempChartData {
    private float avgTemp;
    private float currentTemp;
    private String endTime;
    private List<Entry> items;
    private float maxTemp;
    private float minTemp;
    private String startTime;

    public float getAvgTemp() {
        return this.avgTemp;
    }

    public float getCurrentTemp() {
        return this.currentTemp;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public List<Entry> getItems() {
        return this.items;
    }

    public float getMaxTemp() {
        return this.maxTemp;
    }

    public float getMinTemp() {
        return this.minTemp;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setAvgTemp(float f2) {
        this.avgTemp = f2;
    }

    public void setCurrentTemp(float f2) {
        this.currentTemp = f2;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setItems(List<Entry> list) {
        this.items = list;
    }

    public void setMaxTemp(float f2) {
        this.maxTemp = f2;
    }

    public void setMinTemp(float f2) {
        this.minTemp = f2;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
