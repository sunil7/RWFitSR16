package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BloodOxyItemBean {
    private int bloodOxy;
    private String date;
    private String hour;
    private long timeMills;

    public int getBloodOxy() {
        return this.bloodOxy;
    }

    public String getDate() {
        return this.date;
    }

    public String getHour() {
        return this.hour;
    }

    public long getTimeMills() {
        return this.timeMills;
    }

    public void setBloodOxy(int i3) {
        this.bloodOxy = i3;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setHour(String str) {
        this.hour = str;
    }

    public void setTimeMills(long j4) {
        this.timeMills = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BloodOxyItemBean{timeMills=");
        sb2.append(this.timeMills);
        sb2.append(", bloodOxy=");
        return e.m(sb2, this.bloodOxy, '}');
    }
}
