package com.example.test.ui.model.chart.chart;

/* loaded from: classes.dex */
public class PressureData {
    private long currentTime;
    private String mac;
    private int pressure;
    private String userId;

    public long getCurrentTime() {
        return this.currentTime;
    }

    public String getMac() {
        return this.mac;
    }

    public int getPressure() {
        return this.pressure;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCurrentTime(long j4) {
        this.currentTime = j4;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setPressure(int i3) {
        this.pressure = i3;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
