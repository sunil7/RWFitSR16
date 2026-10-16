package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class JLSleepSyncBean {
    private int sleepModel;
    private long time;

    public int getSleepModel() {
        return this.sleepModel;
    }

    public long getTime() {
        return this.time;
    }

    public void setSleepModel(int i3) {
        this.sleepModel = i3;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SleepJLSyncBean{time=");
        sb2.append(this.time);
        sb2.append(", sleepModel=");
        return e.m(sb2, this.sleepModel, '}');
    }
}
