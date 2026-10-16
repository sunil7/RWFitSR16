package com.example.test.ui.model.chart.chart;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public class BpChartData {
    private int avgDp;
    private int avgSp;
    private int currentDp;
    private int currentSp;
    private String endTime;
    private List<Entry> itemDps;
    private List<Entry> itemSps;
    private int maxDp;
    private int maxSp;
    private int minDp;
    private int minSp;
    private String startTime;

    public int getAvgDp() {
        return this.avgDp;
    }

    public int getAvgSp() {
        return this.avgSp;
    }

    public int getCurrentDp() {
        return this.currentDp;
    }

    public int getCurrentSp() {
        return this.currentSp;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public List<Entry> getItemDps() {
        return this.itemDps;
    }

    public List<Entry> getItemSps() {
        return this.itemSps;
    }

    public int getMaxDp() {
        return this.maxDp;
    }

    public int getMaxSp() {
        return this.maxSp;
    }

    public int getMinDp() {
        return this.minDp;
    }

    public int getMinSp() {
        return this.minSp;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setAvgDp(int i3) {
        this.avgDp = i3;
    }

    public void setAvgSp(int i3) {
        this.avgSp = i3;
    }

    public void setCurrentDp(int i3) {
        this.currentDp = i3;
    }

    public void setCurrentSp(int i3) {
        this.currentSp = i3;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setItemDps(List<Entry> list) {
        this.itemDps = list;
    }

    public void setItemSps(List<Entry> list) {
        this.itemSps = list;
    }

    public void setMaxDp(int i3) {
        this.maxDp = i3;
    }

    public void setMaxSp(int i3) {
        this.maxSp = i3;
    }

    public void setMinDp(int i3) {
        this.minDp = i3;
    }

    public void setMinSp(int i3) {
        this.minSp = i3;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
