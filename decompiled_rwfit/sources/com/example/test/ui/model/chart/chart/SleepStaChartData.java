package com.example.test.ui.model.chart.chart;

import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* loaded from: classes.dex */
public class SleepStaChartData {
    private String deepTime;
    private List<BarEntry> items;
    private String lightTime;
    private String totalTime;
    private String wakeTime;
    private int wakeTimes;

    public String getDeepTime() {
        return this.deepTime;
    }

    public List<BarEntry> getItems() {
        return this.items;
    }

    public String getLightTime() {
        return this.lightTime;
    }

    public String getTotalTime() {
        return this.totalTime;
    }

    public String getWakeTime() {
        return this.wakeTime;
    }

    public int getWakeTimes() {
        return this.wakeTimes;
    }

    public void setDeepTime(String str) {
        this.deepTime = str;
    }

    public void setItems(List<BarEntry> list) {
        this.items = list;
    }

    public void setLightTime(String str) {
        this.lightTime = str;
    }

    public void setTotalTime(String str) {
        this.totalTime = str;
    }

    public void setWakeTime(String str) {
        this.wakeTime = str;
    }

    public void setWakeTimes(int i3) {
        this.wakeTimes = i3;
    }
}
