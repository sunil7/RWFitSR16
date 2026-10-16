package com.example.test.ui.main.model;

import java.util.List;
import x6.a;

/* loaded from: classes.dex */
public class HomeSleepModel extends BaseDataModel {
    private int deepSleepTime;
    private String endTime;
    private List<a> items;
    private int lightSleepTime;
    private String startTime;
    private int totalHour;
    private int totalMin;
    private int wakeSleepTime;
    private int wakeupTimes;

    public HomeSleepModel() {
        super(4);
    }

    public int getDeepSleepTime() {
        return this.deepSleepTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public List<a> getItems() {
        return this.items;
    }

    public int getLightSleepTime() {
        return this.lightSleepTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int getTotalHour() {
        return this.totalHour;
    }

    public int getTotalMin() {
        return this.totalMin;
    }

    public int getWakeSleepTime() {
        return this.wakeSleepTime;
    }

    public int getWakeupTimes() {
        return this.wakeupTimes;
    }

    public void setDeepSleepTime(int i3) {
        this.deepSleepTime = i3;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setItems(List<a> list) {
        this.items = list;
    }

    public void setLightSleepTime(int i3) {
        this.lightSleepTime = i3;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setTotalHour(int i3) {
        this.totalHour = i3;
    }

    public void setTotalMin(int i3) {
        this.totalMin = i3;
    }

    public void setWakeSleepTime(int i3) {
        this.wakeSleepTime = i3;
    }

    public void setWakeupTimes(int i3) {
        this.wakeupTimes = i3;
    }
}
