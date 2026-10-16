package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class BoServerDailyBean {
    private String date;
    private List<BoServerItemBean> details;
    private String deviceId;
    private String memberId;

    public String getDate() {
        return this.date;
    }

    public List<BoServerItemBean> getDetails() {
        return this.details;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDetails(List<BoServerItemBean> list) {
        this.details = list;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setMemberId(String str) {
        this.memberId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BoServerDailyBean{memberId='");
        sb2.append(this.memberId);
        sb2.append("', deviceId='");
        sb2.append(this.deviceId);
        sb2.append("', date='");
        sb2.append(this.date);
        sb2.append("', details=");
        return l0.r(sb2, this.details, '}');
    }
}
