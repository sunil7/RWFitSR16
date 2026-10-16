package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class StepPartData {
    private int cal;
    private int distance;
    private int index;
    private int steps;

    public int getCal() {
        return this.cal;
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

    public void setCal(int i3) {
        this.cal = i3;
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
        StringBuilder sb2 = new StringBuilder("StepPartData{index=");
        sb2.append(this.index);
        sb2.append(", steps=");
        sb2.append(this.steps);
        sb2.append(", cal=");
        sb2.append(this.cal);
        sb2.append(", distance=");
        return e.m(sb2, this.distance, '}');
    }
}
