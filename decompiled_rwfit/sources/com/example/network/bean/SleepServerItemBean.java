package com.example.network.bean;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class SleepServerItemBean {
    private int period;
    private int type;

    public int getPeriod() {
        return this.period;
    }

    public int getType() {
        return this.type;
    }

    public void setPeriod(int i3) {
        this.period = i3;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SleepServerItemBean{period=");
        sb2.append(this.period);
        sb2.append(", type=");
        return e.m(sb2, this.type, '}');
    }
}
