package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class CallRemindBean {
    private String phoneName;
    private String phoneNum;
    private int remindType;
    private long timeMill;

    public String getPhoneName() {
        return this.phoneName;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public int getRemindType() {
        return this.remindType;
    }

    public long getTimeMill() {
        return this.timeMill;
    }

    public void setPhoneName(String str) {
        this.phoneName = str;
    }

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public void setRemindType(int i3) {
        this.remindType = i3;
    }

    public void setTimeMill(long j4) {
        this.timeMill = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CallRemindBean{remindType=");
        sb2.append(this.remindType);
        sb2.append(", phoneNum='");
        sb2.append(this.phoneNum);
        sb2.append("', phoneName='");
        sb2.append(this.phoneName);
        sb2.append("', timeMill='");
        return e.n(sb2, this.timeMill, "'}");
    }
}
