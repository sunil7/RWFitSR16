package com.example.test.ui.model.chart.chart;

/* loaded from: classes.dex */
public class SleepItemData {
    public static final int RAPID_EYE = 3;
    public static final int SLEEP_AWAKE = 0;
    public static final int SLEEP_DEEP = 2;
    public static final int SLEEP_LIGHT = 1;
    private int duration;
    private double durationPercent;
    private int sleepType;
    private long startTime;

    public int getDuration() {
        return this.duration;
    }

    public double getDurationPercent() {
        return this.durationPercent;
    }

    public int getSleepType() {
        return this.sleepType;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setDuration(int i3) {
        this.duration = i3;
    }

    public void setDurationPercent(double d5) {
        this.durationPercent = d5;
    }

    public void setSleepType(int i3) {
        this.sleepType = i3;
    }

    public void setStartTime(long j4) {
        this.startTime = j4;
    }

    public String toString() {
        return " sleepType " + this.sleepType + " duration " + this.duration;
    }
}
