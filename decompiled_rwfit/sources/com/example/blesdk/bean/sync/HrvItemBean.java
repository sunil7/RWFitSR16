package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class HrvItemBean {
    private String date;
    private String hour;
    private int hrv;
    private long timeMills;

    public String getDate() {
        return this.date;
    }

    public String getHour() {
        return this.hour;
    }

    public int getHrv() {
        return this.hrv;
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

    public void setHrv(int i3) {
        this.hrv = i3;
    }

    public void setTimeMills(long j4) {
        this.timeMills = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("HeartRateItemBean{timeMills=");
        sb2.append(this.timeMills);
        sb2.append(", hrv=");
        return e.m(sb2, this.hrv, '}');
    }
}
