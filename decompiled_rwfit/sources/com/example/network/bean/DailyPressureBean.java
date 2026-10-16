package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DailyPressureBean {
    private Integer createTime;
    private Integer date;
    private List<DailyPressureDetail> details = new ArrayList();
    private String deviceId;

    /* renamed from: id, reason: collision with root package name */
    private Long f7387id;
    private Integer memberId;

    public static class DailyPressureDetail {
        private Long dailyPressureId;

        /* renamed from: id, reason: collision with root package name */
        private Long f7388id;
        private Integer timestamp;
        private Integer value;

        public Long getDailyPressureId() {
            return this.dailyPressureId;
        }

        public Long getId() {
            return this.f7388id;
        }

        public Integer getTimestamp() {
            return this.timestamp;
        }

        public Integer getValue() {
            return this.value;
        }

        public void setDailyPressureId(Long l3) {
            this.dailyPressureId = l3;
        }

        public void setId(Long l3) {
            this.f7388id = l3;
        }

        public void setTimestamp(Integer num) {
            this.timestamp = num;
        }

        public void setValue(Integer num) {
            this.value = num;
        }

        public String toString() {
            return "DailyPressureDetail{id=" + this.f7388id + ", dailyPressureId=" + this.dailyPressureId + ", timestamp=" + this.timestamp + ", value=" + this.value + '}';
        }
    }

    public Integer getCreateTime() {
        return this.createTime;
    }

    public Integer getDate() {
        return this.date;
    }

    public List<DailyPressureDetail> getDetails() {
        return this.details;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public Long getId() {
        return this.f7387id;
    }

    public Integer getMemberId() {
        return this.memberId;
    }

    public void setCreateTime(Integer num) {
        this.createTime = num;
    }

    public void setDate(Integer num) {
        this.date = num;
    }

    public void setDetails(List<DailyPressureDetail> list) {
        this.details = list;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setId(Long l3) {
        this.f7387id = l3;
    }

    public void setMemberId(Integer num) {
        this.memberId = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DailyPressureVO{id=");
        sb2.append(this.f7387id);
        sb2.append(", memberId=");
        sb2.append(this.memberId);
        sb2.append(", deviceId='");
        sb2.append(this.deviceId);
        sb2.append("', date=");
        sb2.append(this.date);
        sb2.append(", createTime=");
        sb2.append(this.createTime);
        sb2.append(", details=");
        return l0.r(sb2, this.details, '}');
    }
}
