package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class StepServerDailyBean {
    private long cal;
    private String date;
    private List<StepServerItemBean> details;
    private String deviceId;
    private long distance;
    private String memberId;
    private int step;

    public long getCal() {
        return this.cal;
    }

    public String getDate() {
        return this.date;
    }

    public List<StepServerItemBean> getDetails() {
        return this.details;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public long getDistance() {
        return this.distance;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public int getStep() {
        return this.step;
    }

    public void setCal(long j4) {
        this.cal = j4;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDetails(List<StepServerItemBean> list) {
        this.details = list;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDistance(long j4) {
        this.distance = j4;
    }

    public void setMemberId(String str) {
        this.memberId = str;
    }

    public void setStep(int i3) {
        this.step = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StepServerDailyBean{memberId='");
        sb2.append(this.memberId);
        sb2.append("', deviceId='");
        sb2.append(this.deviceId);
        sb2.append("', date='");
        sb2.append(this.date);
        sb2.append("', step=");
        sb2.append(this.step);
        sb2.append(", cal=");
        sb2.append(this.cal);
        sb2.append(", distance=");
        sb2.append(this.distance);
        sb2.append(", details=");
        return l0.r(sb2, this.details, '}');
    }
}
