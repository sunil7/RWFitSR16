package com.example.blesdk.bean.function;

/* loaded from: classes.dex */
public class DNDModelBean extends BaseReminderBean {
    private boolean isAllDay;

    public boolean isAllDay() {
        return this.isAllDay;
    }

    public void setAllDay(boolean z5) {
        this.isAllDay = z5;
    }

    @Override // com.example.blesdk.bean.function.BaseReminderBean
    public String toString() {
        return "DNDModelBean{isAllDay=" + this.isAllDay + super.toString() + '}';
    }
}
