package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DailySleepBean {
    private Integer createTime;
    private Integer date;
    private List<DailySleepDetail> details = new ArrayList();
    private String deviceId;
    private Integer endTime;

    /* renamed from: id, reason: collision with root package name */
    private Long f7389id;
    private Integer memberId;
    private Integer startTime;
    private Integer totalTime;

    public static class DailySleepDetail {
        private Long dailySleepId;

        /* renamed from: id, reason: collision with root package name */
        private Long f7390id;
        private Integer index;
        private Integer period;
        private Integer type;

        public Long getDailySleepId() {
            return this.dailySleepId;
        }

        public Long getId() {
            return this.f7390id;
        }

        public Integer getIndex() {
            return this.index;
        }

        public Integer getPeriod() {
            return this.period;
        }

        public Integer getType() {
            return this.type;
        }

        public void setDailySleepId(Long l3) {
            this.dailySleepId = l3;
        }

        public void setId(Long l3) {
            this.f7390id = l3;
        }

        public void setIndex(Integer num) {
            this.index = num;
        }

        public void setPeriod(Integer num) {
            this.period = num;
        }

        public void setType(Integer num) {
            this.type = num;
        }

        public String toString() {
            return "DailySleepDetail{id=" + this.f7390id + ", dailySleepId=" + this.dailySleepId + ", index=" + this.index + ", period=" + this.period + ", type=" + this.type + '}';
        }
    }

    public Integer getCreateTime() {
        return this.createTime;
    }

    public Integer getDate() {
        return this.date;
    }

    public List<DailySleepDetail> getDetails() {
        return this.details;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public Integer getEndTime() {
        return this.endTime;
    }

    public Long getId() {
        return this.f7389id;
    }

    public Integer getMemberId() {
        return this.memberId;
    }

    public Integer getStartTime() {
        return this.startTime;
    }

    public Integer getTotalTime() {
        return this.totalTime;
    }

    public void setCreateTime(Integer num) {
        this.createTime = num;
    }

    public void setDate(Integer num) {
        this.date = num;
    }

    public void setDetails(List<DailySleepDetail> list) {
        this.details = list;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setEndTime(Integer num) {
        this.endTime = num;
    }

    public void setId(Long l3) {
        this.f7389id = l3;
    }

    public void setMemberId(Integer num) {
        this.memberId = num;
    }

    public void setStartTime(Integer num) {
        this.startTime = num;
    }

    public void setTotalTime(Integer num) {
        this.totalTime = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DailySleepVO{id=");
        sb2.append(this.f7389id);
        sb2.append(", memberId=");
        sb2.append(this.memberId);
        sb2.append(", deviceId='");
        sb2.append(this.deviceId);
        sb2.append("', date=");
        sb2.append(this.date);
        sb2.append(", totalTime=");
        sb2.append(this.totalTime);
        sb2.append(", startTime=");
        sb2.append(this.startTime);
        sb2.append(", endTime=");
        sb2.append(this.endTime);
        sb2.append(", createTime=");
        sb2.append(this.createTime);
        sb2.append(", details=");
        return l0.r(sb2, this.details, '}');
    }
}
