package com.example.test.ui.model;

/* loaded from: classes.dex */
public class TRingHealthItemModel {
    private long healthTime;
    private int healthType;
    private int healthValue;

    public TRingHealthItemModel(int i3, int i10, long j4) {
        this.healthValue = i3;
        this.healthType = i10;
        this.healthTime = j4;
    }

    public long getHealthTime() {
        return this.healthTime;
    }

    public int getHealthType() {
        return this.healthType;
    }

    public int getHealthValue() {
        return this.healthValue;
    }

    public void setHealthTime(long j4) {
        this.healthTime = j4;
    }

    public void setHealthType(int i3) {
        this.healthType = i3;
    }

    public void setHealthValue(int i3) {
        this.healthValue = i3;
    }
}
