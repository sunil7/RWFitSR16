package com.example.blesdk.bean.function;

/* loaded from: classes.dex */
public class FactoryStateBean {
    private int Voltage;
    private int isGsensorState;
    private int isHeartState;
    private int isWearState;

    public int getVoltage() {
        return this.Voltage;
    }

    public int isGsensorState() {
        return this.isGsensorState;
    }

    public int isHeartState() {
        return this.isHeartState;
    }

    public int isWearState() {
        return this.isWearState;
    }

    public void setGsensorState(int i3) {
        this.isGsensorState = i3;
    }

    public void setHeartState(int i3) {
        this.isHeartState = i3;
    }

    public void setVoltage(int i3) {
        this.Voltage = i3;
    }

    public void setWearState(int i3) {
        this.isWearState = i3;
    }
}
