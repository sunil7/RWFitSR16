package com.example.blesdk.bean.function;

import java.util.Arrays;

/* loaded from: classes.dex */
public class DrinkReminderBean extends BaseReminderBean {
    private int remindDuration = 30;
    private int[] repeatModel;

    public int getRemindDuration() {
        return this.remindDuration;
    }

    public int[] getRepeatModel() {
        return this.repeatModel;
    }

    public void setRemindDuration(int i3) {
        if (i3 > 0) {
            this.remindDuration = i3;
        }
    }

    public void setRepeatModel(int[] iArr) {
        this.repeatModel = iArr;
    }

    @Override // com.example.blesdk.bean.function.BaseReminderBean
    public String toString() {
        return "DrinkReminderBean{isOpen=" + isOpen() + "startHour=" + getStartHour() + "startMin=" + getStartMin() + "endHour=" + getEndHour() + "endMin=" + getEndMin() + "remindDuration=" + this.remindDuration + ", repeatModel=" + Arrays.toString(this.repeatModel) + '}';
    }
}
