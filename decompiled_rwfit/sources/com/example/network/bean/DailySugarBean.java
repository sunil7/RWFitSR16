package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DailySugarBean {
    private Integer createTime;
    private Integer date;
    private List<DailySugarDetail> details = new ArrayList();
    private String deviceId;

    /* renamed from: id, reason: collision with root package name */
    private Long f7393id;
    private Integer memberId;

    public static class DailySugarDetail {
        private Long dailySugarId;

        /* renamed from: id, reason: collision with root package name */
        private Long f7394id;
        private Integer timestamp;
        private BigDecimal value;

        public Long getDailySugarId() {
            return this.dailySugarId;
        }

        public Long getId() {
            return this.f7394id;
        }

        public Integer getTimestamp() {
            return this.timestamp;
        }

        public BigDecimal getValue() {
            return this.value;
        }

        public void setDailySugarId(Long l3) {
            this.dailySugarId = l3;
        }

        public void setId(Long l3) {
            this.f7394id = l3;
        }

        public void setTimestamp(Integer num) {
            this.timestamp = num;
        }

        public void setValue(BigDecimal bigDecimal) {
            this.value = bigDecimal;
        }

        public String toString() {
            return "DailySugarDetail{id=" + this.f7394id + ", dailySugarId=" + this.dailySugarId + ", timestamp=" + this.timestamp + ", value=" + this.value + '}';
        }
    }

    public Integer getCreateTime() {
        return this.createTime;
    }

    public Integer getDate() {
        return this.date;
    }

    public List<DailySugarDetail> getDetails() {
        return this.details;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public Long getId() {
        return this.f7393id;
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

    public void setDetails(List<DailySugarDetail> list) {
        this.details = list;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setId(Long l3) {
        this.f7393id = l3;
    }

    public void setMemberId(Integer num) {
        this.memberId = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DailySugarVO{id=");
        sb2.append(this.f7393id);
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
