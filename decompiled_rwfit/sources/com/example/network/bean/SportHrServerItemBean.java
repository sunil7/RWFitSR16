package com.example.network.bean;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class SportHrServerItemBean {
    private int index;
    private int value;

    public int getIndex() {
        return this.index;
    }

    public int getValue() {
        return this.value;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setValue(int i3) {
        this.value = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportHrServerItemBean{index=");
        sb2.append(this.index);
        sb2.append(", value=");
        return e.m(sb2, this.value, '}');
    }
}
