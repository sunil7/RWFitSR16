package com.example.test.ui.model.chart.chart;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public class StressChartData {
    private int avgStree;
    private int currentStress;
    private String endTime;
    private List<Entry> items;
    private int maxStress;
    private int minStress;
    private String startTime;

    public int getAvgStree() {
        return this.avgStree;
    }

    public int getCurrentStress() {
        return this.currentStress;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public List<Entry> getItems() {
        return this.items;
    }

    public int getMaxStress() {
        return this.maxStress;
    }

    public int getMinStress() {
        return this.minStress;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setAvgStree(int i3) {
        this.avgStree = i3;
    }

    public void setCurrentStress(int i3) {
        this.currentStress = i3;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setItems(List<Entry> list) {
        this.items = list;
    }

    public void setMaxStress(int i3) {
        this.maxStress = i3;
    }

    public void setMinStress(int i3) {
        this.minStress = i3;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
