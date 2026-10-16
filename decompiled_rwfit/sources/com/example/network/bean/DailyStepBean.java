package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DailyStepBean {
    private Integer cal;
    private Integer createTime;
    private Integer date;
    private List<DailyStepDetail> details = new ArrayList();
    private String deviceId;
    private Integer distance;

    /* renamed from: id, reason: collision with root package name */
    private Long f7391id;
    private Integer memberId;
    private Integer step;

    public static class DailyStepDetail {
        private Integer cal;
        private Long dailyStepId;
        private Integer distance;

        /* renamed from: id, reason: collision with root package name */
        private Long f7392id;
        private Integer index;
        private Integer step;

        public Integer getCal() {
            return this.cal;
        }

        public Long getDailyStepId() {
            return this.dailyStepId;
        }

        public Integer getDistance() {
            return this.distance;
        }

        public Long getId() {
            return this.f7392id;
        }

        public Integer getIndex() {
            return this.index;
        }

        public Integer getStep() {
            return this.step;
        }

        public void setCal(Integer num) {
            this.cal = num;
        }

        public void setDailyStepId(Long l3) {
            this.dailyStepId = l3;
        }

        public void setDistance(Integer num) {
            this.distance = num;
        }

        public void setId(Long l3) {
            this.f7392id = l3;
        }

        public void setIndex(Integer num) {
            this.index = num;
        }

        public void setStep(Integer num) {
            this.step = num;
        }

        public String toString() {
            return "DailyStepDetail{id=" + this.f7392id + ", dailyStepId=" + this.dailyStepId + ", index=" + this.index + ", step=" + this.step + ", cal=" + this.cal + ", distance=" + this.distance + '}';
        }
    }

    public Integer getCal() {
        return this.cal;
    }

    public Integer getCreateTime() {
        return this.createTime;
    }

    public Integer getDate() {
        return this.date;
    }

    public List<DailyStepDetail> getDetails() {
        return this.details;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public Long getId() {
        return this.f7391id;
    }

    public Integer getMemberId() {
        return this.memberId;
    }

    public Integer getStep() {
        return this.step;
    }

    public void setCal(Integer num) {
        this.cal = num;
    }

    public void setCreateTime(Integer num) {
        this.createTime = num;
    }

    public void setDate(Integer num) {
        this.date = num;
    }

    public void setDetails(List<DailyStepDetail> list) {
        this.details = list;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDistance(Integer num) {
        this.distance = num;
    }

    public void setId(Long l3) {
        this.f7391id = l3;
    }

    public void setMemberId(Integer num) {
        this.memberId = num;
    }

    public void setStep(Integer num) {
        this.step = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DailyStepVO{id=");
        sb2.append(this.f7391id);
        sb2.append(", memberId=");
        sb2.append(this.memberId);
        sb2.append(", deviceId='");
        sb2.append(this.deviceId);
        sb2.append("', date=");
        sb2.append(this.date);
        sb2.append(", step=");
        sb2.append(this.step);
        sb2.append(", cal=");
        sb2.append(this.cal);
        sb2.append(", distance=");
        sb2.append(this.distance);
        sb2.append(", createTime=");
        sb2.append(this.createTime);
        sb2.append(", details=");
        return l0.r(sb2, this.details, '}');
    }
}
