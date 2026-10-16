package com.example.blesdk.bean.function;

/* loaded from: classes.dex */
public class HrMonitorBean extends BaseReminderBean {
    private int testDuration = 10;

    public int getTestDuration() {
        return this.testDuration;
    }

    public void setTestDuration(int i3) {
        this.testDuration = i3;
    }

    @Override // com.example.blesdk.bean.function.BaseReminderBean
    public String toString() {
        return "HrMonitorBean{testDuration=" + this.testDuration + '}' + super.toString();
    }
}
