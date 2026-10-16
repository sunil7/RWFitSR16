package com.amap.api.maps.model;

/* loaded from: classes.dex */
public class MyTrafficStyle {
    private int extremelySmoothColor = -15229099;
    private int smoothColor = -16735735;
    private int slowColor = -35576;
    private int congestedColor = -1441006;
    private int seriousCongestedColor = -7208950;
    private float ratio = 0.8f;
    private int trafficRoadBackgroundColor = -1;

    public int getCongestedColor() {
        return this.congestedColor;
    }

    public int getExtremelySmoothColor() {
        return this.extremelySmoothColor;
    }

    public float getRatio() {
        return this.ratio;
    }

    public int getSeriousCongestedColor() {
        return this.seriousCongestedColor;
    }

    public int getSlowColor() {
        return this.slowColor;
    }

    public int getSmoothColor() {
        return this.smoothColor;
    }

    public int getTrafficRoadBackgroundColor() {
        return this.trafficRoadBackgroundColor;
    }

    public void setCongestedColor(int i3) {
        this.congestedColor = i3;
    }

    public void setExtremelySmoothColor(int i3) {
        this.extremelySmoothColor = i3;
    }

    public void setRatio(float f2) {
        this.ratio = f2;
    }

    public void setSeriousCongestedColor(int i3) {
        this.seriousCongestedColor = i3;
    }

    public void setSlowColor(int i3) {
        this.slowColor = i3;
    }

    public void setSmoothColor(int i3) {
        this.smoothColor = i3;
    }

    public void setTrafficRoadBackgroundColor(int i3) {
        this.trafficRoadBackgroundColor = i3;
    }
}
