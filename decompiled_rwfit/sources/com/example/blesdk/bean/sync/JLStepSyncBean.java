package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class JLStepSyncBean {
    private int calorie;
    private String date;
    private int distance;
    private String hour;
    private int steps;
    private long time;

    public int getCalorie() {
        return this.calorie;
    }

    public String getDate() {
        return this.date;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getHour() {
        return this.hour;
    }

    public int getSteps() {
        return this.steps;
    }

    public long getTime() {
        return this.time;
    }

    public void setCalorie(int i3) {
        this.calorie = i3;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDistance(int i3) {
        this.distance = i3;
    }

    public void setHour(String str) {
        this.hour = str;
    }

    public void setSteps(int i3) {
        this.steps = i3;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StepSyncBean{time=");
        sb2.append(this.time);
        sb2.append(", totalSteps=");
        sb2.append(this.steps);
        sb2.append(", totalCalorie=");
        sb2.append(this.calorie);
        sb2.append(", totalDistance=");
        return e.m(sb2, this.distance, '}');
    }
}
