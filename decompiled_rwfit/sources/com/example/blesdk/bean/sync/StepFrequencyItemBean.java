package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class StepFrequencyItemBean {
    private int stepFrequency;
    private int timeMin;

    public int getStepFrequency() {
        return this.stepFrequency;
    }

    public int getTimeMin() {
        return this.timeMin;
    }

    public void setStepFrequency(int i3) {
        this.stepFrequency = i3;
    }

    public void setTimeMin(int i3) {
        this.timeMin = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StepFrequencyItemBean{timeMin=");
        sb2.append(this.timeMin);
        sb2.append(", stepFrequency=");
        return e.m(sb2, this.stepFrequency, '}');
    }
}
