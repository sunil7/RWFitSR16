package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class SleepServerDailyBean {
    private String date;
    private List<SleepServerItemBean> details;
    private String deviceId;
    private long endTime;
    private String memberId;
    private long startTime;
    private int totalTime;

    public String getDate() {
        return this.date;
    }

    public List<SleepServerItemBean> getDetails() {
        return this.details;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDetails(List<SleepServerItemBean> list) {
        this.details = list;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setEndTime(long j4) {
        this.endTime = j4;
    }

    public void setMemberId(String str) {
        this.memberId = str;
    }

    public void setStartTime(long j4) {
        this.startTime = j4;
    }

    public void setTotalTime(int i3) {
        this.totalTime = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SleepServerDailyBean{memberId='");
        sb2.append(this.memberId);
        sb2.append("', deviceId='");
        sb2.append(this.deviceId);
        sb2.append("', date='");
        sb2.append(this.date);
        sb2.append("', totalTime=");
        sb2.append(this.totalTime);
        sb2.append(", startTime=");
        sb2.append(this.startTime);
        sb2.append(", endTime=");
        sb2.append(this.endTime);
        sb2.append(", details=");
        return l0.r(sb2, this.details, '}');
    }
}
