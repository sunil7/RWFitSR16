package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BpPartData {
    private int dp;
    private int sp;
    private long time;

    public int getDp() {
        return this.dp;
    }

    public int getSp() {
        return this.sp;
    }

    public long getTime() {
        return this.time;
    }

    public void setDp(int i3) {
        this.dp = i3;
    }

    public void setSp(int i3) {
        this.sp = i3;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BpPartData{time=");
        sb2.append(this.time);
        sb2.append(", sp=");
        sb2.append(this.sp);
        sb2.append(", dp=");
        return e.m(sb2, this.dp, '}');
    }
}
