package com.example.test.ui.model.chart.chart;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public class BoChartData {
    private int avgBo;
    private int currentBo;
    private String endTime;
    private List<Entry> items;
    private int maxBo;
    private int minBo;
    private String startTime;

    public int getAvgBo() {
        return this.avgBo;
    }

    public int getCurrentBo() {
        return this.currentBo;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public List<Entry> getItems() {
        return this.items;
    }

    public int getMaxBo() {
        return this.maxBo;
    }

    public int getMinBo() {
        return this.minBo;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setAvgBo(int i3) {
        this.avgBo = i3;
    }

    public void setCurrentBo(int i3) {
        this.currentBo = i3;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setItems(List<Entry> list) {
        this.items = list;
    }

    public void setMaxBo(int i3) {
        this.maxBo = i3;
    }

    public void setMinBo(int i3) {
        this.minBo = i3;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
