package com.example.test.ui.model.chart.chart;

import java.util.List;

/* loaded from: classes.dex */
public class SleepData {
    private long deepSleepTime;
    private List<SleepItemData> items;
    private long lightSleepTime;
    private long totalTime;
    private int wakeupTimes;

    public long getDeepSleepTime() {
        return this.deepSleepTime;
    }

    public List<SleepItemData> getItems() {
        return this.items;
    }

    public long getLightSleepTime() {
        return this.lightSleepTime;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public int getWakeupTimes() {
        return this.wakeupTimes;
    }

    public void setDeepSleepTime(long j4) {
        this.deepSleepTime = j4;
    }

    public void setItems(List<SleepItemData> list) {
        this.items = list;
    }

    public void setLightSleepTime(long j4) {
        this.lightSleepTime = j4;
    }

    public void setTotalTime(long j4) {
        this.totalTime = j4;
    }

    public void setWakeupTimes(int i3) {
        this.wakeupTimes = i3;
    }
}
