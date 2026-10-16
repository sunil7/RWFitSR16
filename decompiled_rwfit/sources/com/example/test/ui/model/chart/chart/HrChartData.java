package com.example.test.ui.model.chart.chart;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public class HrChartData {
    private int avgHr;
    private int currentHr;
    private String endTime;
    private List<Entry> items;
    private int maxHr;
    private int minHr;
    private String startTime;

    public int getAvgHr() {
        return this.avgHr;
    }

    public int getCurrentHr() {
        return this.currentHr;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public List<Entry> getItems() {
        return this.items;
    }

    public int getMaxHr() {
        return this.maxHr;
    }

    public int getMinHr() {
        return this.minHr;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setAvgHr(int i3) {
        this.avgHr = i3;
    }

    public void setCurrentHr(int i3) {
        this.currentHr = i3;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setItems(List<Entry> list) {
        this.items = list;
    }

    public void setMaxHr(int i3) {
        this.maxHr = i3;
    }

    public void setMinHr(int i3) {
        this.minHr = i3;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
