package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BreatheItemBean {
    private int timeLen;
    private long timeMills;

    public int getTimeLen() {
        return this.timeLen;
    }

    public long getTimeMills() {
        return this.timeMills;
    }

    public void setTimeLen(int i3) {
        this.timeLen = i3;
    }

    public void setTimeMills(long j4) {
        this.timeMills = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BreatheItemBean{timeMIlls=");
        sb2.append(this.timeMills);
        sb2.append(", timeLen=");
        return e.m(sb2, this.timeLen, '}');
    }
}
