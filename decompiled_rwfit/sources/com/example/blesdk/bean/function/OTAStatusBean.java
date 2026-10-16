package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class OTAStatusBean {
    private boolean isOtaComplete;
    private int otaStatus;

    public int getOtaStatus() {
        return this.otaStatus;
    }

    public boolean isOtaComplete() {
        return this.isOtaComplete;
    }

    public void setOtaComplete(boolean z5) {
        this.isOtaComplete = z5;
    }

    public void setOtaStatus(int i3) {
        this.otaStatus = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("OTAStatusBean{otaStatus=");
        sb2.append(this.otaStatus);
        sb2.append(", isOtaComplete=");
        return e.o(sb2, this.isOtaComplete, '}');
    }
}
