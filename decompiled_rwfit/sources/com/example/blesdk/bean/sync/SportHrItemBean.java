package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class SportHrItemBean {
    private int hr;
    private long timeMills;

    public int getHr() {
        return this.hr;
    }

    public long getTimeMills() {
        return this.timeMills;
    }

    public void setHr(int i3) {
        this.hr = i3;
    }

    public void setTimeMills(long j4) {
        this.timeMills = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportHrItemBean{timeMills=");
        sb2.append(this.timeMills);
        sb2.append(", hr=");
        return e.m(sb2, this.hr, '}');
    }
}
