package com.example.network.bean;

import android.support.v4.media.session.e;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class RememberServerDailyBean {
    private String date;
    private List<ItemBean> details;
    private String deviceId;
    private String memberId;

    public static class ItemBean {
        private Integer hourIndex;
        private int value;

        public Integer getHourIndex() {
            return this.hourIndex;
        }

        public int getValue() {
            return this.value;
        }

        public void setHourIndex(Integer num) {
            this.hourIndex = num;
        }

        public void setValue(int i3) {
            this.value = i3;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("ItemBean{hourIndex=");
            sb2.append(this.hourIndex);
            sb2.append(", value=");
            return e.m(sb2, this.value, '}');
        }
    }

    public String getDate() {
        return this.date;
    }

    public List<ItemBean> getDetails() {
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

    public void setDetails(List<ItemBean> list) {
        this.details = list;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setMemberId(String str) {
        this.memberId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("HrvServerDailyBean{memberId='");
        sb2.append(this.memberId);
        sb2.append("', deviceId='");
        sb2.append(this.deviceId);
        sb2.append("', date='");
        sb2.append(this.date);
        sb2.append("', details=");
        return l0.r(sb2, this.details, '}');
    }
}
