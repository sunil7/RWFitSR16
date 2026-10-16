package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DailyHeartRateBean {
    private Integer createTime;
    private Integer date;
    private List<DailyHeartRateDetail> details = new ArrayList();
    private String deviceId;

    /* renamed from: id, reason: collision with root package name */
    private Long f7381id;
    private Integer memberId;

    public static class DailyHeartRateDetail {
        private Long dailyHeartRateId;

        /* renamed from: id, reason: collision with root package name */
        private Long f7382id;
        private Integer timestamp;
        private Integer value;

        public Long getDailyHeartRateId() {
            return this.dailyHeartRateId;
        }

        public Long getId() {
            return this.f7382id;
        }

        public Integer getTimestamp() {
            return this.timestamp;
        }

        public Integer getValue() {
            return this.value;
        }

        public void setDailyHeartRateId(Long l3) {
            this.dailyHeartRateId = l3;
        }

        public void setId(Long l3) {
            this.f7382id = l3;
        }

        public void setTimestamp(Integer num) {
            this.timestamp = num;
        }

        public void setValue(Integer num) {
            this.value = num;
        }

        public String toString() {
            return "DailyHeartRateDetail{id=" + this.f7382id + ", dailyHeartRateId=" + this.dailyHeartRateId + ", timestamp=" + this.timestamp + ", value=" + this.value + '}';
        }
    }

    public Integer getCreateTime() {
        return this.createTime;
    }

    public Integer getDate() {
        return this.date;
    }

    public List<DailyHeartRateDetail> getDetails() {
        return this.details;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public Long getId() {
        return this.f7381id;
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

    public void setDetails(List<DailyHeartRateDetail> list) {
        this.details = list;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setId(Long l3) {
        this.f7381id = l3;
    }

    public void setMemberId(Integer num) {
        this.memberId = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DailyHeartRateVO{id=");
        sb2.append(this.f7381id);
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
