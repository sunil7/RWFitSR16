package com.example.network.bean;

/* loaded from: classes.dex */
public class StepServerItemBean {
    private long cal;
    private long distance;
    private int index;
    private int step;

    public long getCal() {
        return this.cal;
    }

    public long getDistance() {
        return this.distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getStep() {
        return this.step;
    }

    public void setCal(long j4) {
        this.cal = j4;
    }

    public void setDistance(long j4) {
        this.distance = j4;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setStep(int i3) {
        this.step = i3;
    }

    public String toString() {
        return "StepServerItemBean{index=" + this.index + ", step=" + this.step + ", cal=" + this.cal + ", distance=" + this.distance + '}';
    }
}
