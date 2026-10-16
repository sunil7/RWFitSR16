package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class VaperPowerOHMBean extends BaseReminderBean {
    private int powerOHM = 1;

    public int getPowerOHM() {
        return this.powerOHM;
    }

    public void setPowerOHM(int i3) {
        this.powerOHM = i3;
    }

    @Override // com.example.blesdk.bean.function.BaseReminderBean
    public String toString() {
        return e.m(new StringBuilder("VaperPowerOHMBean{powerOHM="), this.powerOHM, '}');
    }
}
