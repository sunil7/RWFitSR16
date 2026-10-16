package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class StepItemBean {
    private int calorie;
    private int distance;
    private int index;
    private int steps;

    public int getCalorie() {
        return this.calorie;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getSteps() {
        return this.steps;
    }

    public void setCalorie(int i3) {
        this.calorie = i3;
    }

    public void setDistance(int i3) {
        this.distance = i3;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setSteps(int i3) {
        this.steps = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StepItemBean{index=");
        sb2.append(this.index);
        sb2.append(", steps=");
        sb2.append(this.steps);
        sb2.append(", calorie=");
        sb2.append(this.calorie);
        sb2.append(", distance=");
        return e.m(sb2, this.distance, '}');
    }
}
