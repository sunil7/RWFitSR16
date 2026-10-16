package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class HealthSyncBean {
    private boolean isHasBloodOxyData;
    private boolean isHasBloodPressData;
    private boolean isHasBodyTempData;
    private boolean isHasBreatheData;
    private boolean isHasEcgData;
    private boolean isHasHrData;
    private boolean isHasSleepData;
    private boolean isHasSportData;
    private boolean isHasStepData;
    private int totalDataCount;

    public int getTotalDataCount() {
        return this.totalDataCount;
    }

    public boolean isHasBloodOxyData() {
        return this.isHasBloodOxyData;
    }

    public boolean isHasBloodPressData() {
        return this.isHasBloodPressData;
    }

    public boolean isHasBodyTempData() {
        return this.isHasBodyTempData;
    }

    public boolean isHasBreatheData() {
        return this.isHasBreatheData;
    }

    public boolean isHasEcgData() {
        return this.isHasEcgData;
    }

    public boolean isHasHrData() {
        return this.isHasHrData;
    }

    public boolean isHasSleepData() {
        return this.isHasSleepData;
    }

    public boolean isHasSportData() {
        return this.isHasSportData;
    }

    public boolean isHasStepData() {
        return this.isHasStepData;
    }

    public void setHasBloodOxyData(boolean z5) {
        this.isHasBloodOxyData = z5;
    }

    public void setHasBloodPressData(boolean z5) {
        this.isHasBloodPressData = z5;
    }

    public void setHasBodyTempData(boolean z5) {
        this.isHasBodyTempData = z5;
    }

    public void setHasBreatheData(boolean z5) {
        this.isHasBreatheData = z5;
    }

    public void setHasEcgData(boolean z5) {
        this.isHasEcgData = z5;
    }

    public void setHasHrData(boolean z5) {
        this.isHasHrData = z5;
    }

    public void setHasSleepData(boolean z5) {
        this.isHasSleepData = z5;
    }

    public void setHasSportData(boolean z5) {
        this.isHasSportData = z5;
    }

    public void setHasStepData(boolean z5) {
        this.isHasStepData = z5;
    }

    public void setTotalDataCount(int i3) {
        this.totalDataCount = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("HealthSyncBean{totalDataCount=");
        sb2.append(this.totalDataCount);
        sb2.append(", isHasStepData=");
        sb2.append(this.isHasStepData);
        sb2.append(", isHasSleepData=");
        sb2.append(this.isHasSleepData);
        sb2.append(", isHasHrData=");
        sb2.append(this.isHasHrData);
        sb2.append(", isHasBloodPressData=");
        sb2.append(this.isHasBloodPressData);
        sb2.append(", isHasBloodOxyData=");
        sb2.append(this.isHasBloodOxyData);
        sb2.append(", isHasBodyTempData=");
        sb2.append(this.isHasBodyTempData);
        sb2.append(", isHasBreatheData=");
        sb2.append(this.isHasBreatheData);
        sb2.append(", isHasEcgData=");
        sb2.append(this.isHasEcgData);
        sb2.append(", isHasSportData=");
        return e.o(sb2, this.isHasSportData, '}');
    }
}
