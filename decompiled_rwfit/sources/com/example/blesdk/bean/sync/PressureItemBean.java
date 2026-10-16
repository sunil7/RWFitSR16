package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class PressureItemBean {
    private String date;
    private String hour;
    private int pressure;
    private long timeMills;

    public String getDate() {
        return this.date;
    }

    public String getHour() {
        return this.hour;
    }

    public int getPressure() {
        return this.pressure;
    }

    public long getTimeMills() {
        return this.timeMills;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setHour(String str) {
        this.hour = str;
    }

    public void setPressure(int i3) {
        this.pressure = i3;
    }

    public void setTimeMills(long j4) {
        this.timeMills = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("HeartRateItemBean{timeMills=");
        sb2.append(this.timeMills);
        sb2.append(", hr=");
        return e.m(sb2, this.pressure, '}');
    }
}
