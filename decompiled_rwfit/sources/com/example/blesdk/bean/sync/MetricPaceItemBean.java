package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class MetricPaceItemBean {
    private boolean isKm;
    private long pace;
    private int paceIndex;

    public long getPace() {
        return this.pace;
    }

    public int getPaceIndex() {
        return this.paceIndex;
    }

    public boolean isKm() {
        return this.isKm;
    }

    public void setKm(boolean z5) {
        this.isKm = z5;
    }

    public void setPace(long j4) {
        this.pace = j4;
    }

    public void setPaceIndex(int i3) {
        this.paceIndex = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("MetricPaceItemBean{paceIndex=");
        sb2.append(this.paceIndex);
        sb2.append(", pace=");
        sb2.append(this.pace);
        sb2.append(", isKm=");
        return e.o(sb2, this.isKm, '}');
    }
}
