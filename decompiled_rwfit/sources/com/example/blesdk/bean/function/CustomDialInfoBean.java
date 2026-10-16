package com.example.blesdk.bean.function;

/* loaded from: classes.dex */
public class CustomDialInfoBean {
    private int timePosition;
    private int timeUpType = 1;
    private int timeDownType = 8;
    private String color = "#000000";

    public String getColor() {
        return this.color;
    }

    public int getTimeDownType() {
        return this.timeDownType;
    }

    public int getTimePosition() {
        return this.timePosition;
    }

    public int getTimeUpType() {
        return this.timeUpType;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setTimeDownType(int i3) {
        this.timeDownType = i3;
    }

    public void setTimePosition(int i3) {
        this.timePosition = i3;
    }

    public void setTimeUpType(int i3) {
        this.timeUpType = i3;
    }

    public String toString() {
        return "CustomDialInfoBean{timePosition=" + this.timePosition + ", timeUpType=" + this.timeUpType + ", timeDownType=" + this.timeDownType + ", color=" + this.color + '}';
    }
}
