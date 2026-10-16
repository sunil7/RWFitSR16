package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class ReminderModeBean {
    private int reminderMode;

    public int getReminderMode() {
        return this.reminderMode;
    }

    public void setReminderMode(int i3) {
        this.reminderMode = i3;
    }

    public String toString() {
        return e.m(new StringBuilder("ReminderModeBean{reminderMode="), this.reminderMode, '}');
    }
}
