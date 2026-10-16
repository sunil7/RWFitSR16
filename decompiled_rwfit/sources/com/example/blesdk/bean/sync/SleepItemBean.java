package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class SleepItemBean {
    private int len;
    private int sleepType;

    public int getLen() {
        return this.len;
    }

    public int getSleepType() {
        return this.sleepType;
    }

    public void setLen(int i3) {
        this.len = i3;
    }

    public void setSleepType(int i3) {
        this.sleepType = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SleepItemBean{len=");
        sb2.append(this.len);
        sb2.append(", sleepType=");
        return e.m(sb2, this.sleepType, '}');
    }
}
