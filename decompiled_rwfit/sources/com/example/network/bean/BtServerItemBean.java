package com.example.network.bean;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BtServerItemBean {
    private String timestamp;
    private int value;

    public String getTimestamp() {
        return this.timestamp;
    }

    public int getValue() {
        return this.value;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setValue(int i3) {
        this.value = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BtServerItemBean{timestamp='");
        sb2.append(this.timestamp);
        sb2.append("', value=");
        return e.m(sb2, this.value, '}');
    }
}
