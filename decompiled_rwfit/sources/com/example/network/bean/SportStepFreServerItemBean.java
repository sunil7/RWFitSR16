package com.example.network.bean;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class SportStepFreServerItemBean {
    private int frequency;
    private int index;

    public int getFrequency() {
        return this.frequency;
    }

    public int getIndex() {
        return this.index;
    }

    public void setFrequency(int i3) {
        this.frequency = i3;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportStepFreServerItemBean{index=");
        sb2.append(this.index);
        sb2.append(", frequency=");
        return e.m(sb2, this.frequency, '}');
    }
}
