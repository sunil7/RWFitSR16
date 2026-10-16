package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BrightScreenTimeBean extends BaseReminderBean {
    private int timeSecond = 15;
    private String durationNums = "";

    public String getDurationNums() {
        return this.durationNums;
    }

    public int getTimeSecond() {
        return this.timeSecond;
    }

    public void setDurationNums(String str) {
        this.durationNums = str;
    }

    public void setTimeSecond(int i3) {
        this.timeSecond = i3;
    }

    @Override // com.example.blesdk.bean.function.BaseReminderBean
    public String toString() {
        return e.m(new StringBuilder("BrightScreenTimeBean{timeSecond="), this.timeSecond, '}');
    }
}
