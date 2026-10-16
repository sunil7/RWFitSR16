package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BloodPressItemBean {
    private String date;
    private int dp;
    private String hour;
    private int sp;
    private long timeMills;

    public String getDate() {
        return this.date;
    }

    public int getDp() {
        return this.dp;
    }

    public String getHour() {
        return this.hour;
    }

    public int getSp() {
        return this.sp;
    }

    public long getTimeMills() {
        return this.timeMills;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDp(int i3) {
        this.dp = i3;
    }

    public void setHour(String str) {
        this.hour = str;
    }

    public void setSp(int i3) {
        this.sp = i3;
    }

    public void setTimeMills(long j4) {
        this.timeMills = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BloodPressItemBean{timeMills=");
        sb2.append(this.timeMills);
        sb2.append(", sp=");
        sb2.append(this.sp);
        sb2.append(", dp=");
        return e.m(sb2, this.dp, '}');
    }
}
