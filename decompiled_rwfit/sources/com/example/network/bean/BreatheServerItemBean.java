package com.example.network.bean;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BreatheServerItemBean {
    private long timestamp;
    private int value;

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getValue() {
        return this.value;
    }

    public void setTimestamp(long j4) {
        this.timestamp = j4;
    }

    public void setValue(int i3) {
        this.value = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BreatheServerItemBean{timestamp=");
        sb2.append(this.timestamp);
        sb2.append(", value=");
        return e.m(sb2, this.value, '}');
    }
}
