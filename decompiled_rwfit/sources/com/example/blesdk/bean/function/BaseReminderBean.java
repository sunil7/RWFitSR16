package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BaseReminderBean {
    private int advanceIndex;
    private boolean isOpen;
    private int startHour = 9;
    private int startMin = 0;
    private int endHour = 18;
    private int endMin = 0;

    public int getAdvanceIndex() {
        return this.advanceIndex;
    }

    public int getEndHour() {
        return this.endHour;
    }

    public int getEndMin() {
        return this.endMin;
    }

    public int getStartHour() {
        return this.startHour;
    }

    public int getStartMin() {
        return this.startMin;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setAdvanceIndex(int i3) {
        this.advanceIndex = i3;
    }

    public void setEndHour(int i3) {
        if (i3 < 24) {
            this.endHour = i3;
        }
    }

    public void setEndMin(int i3) {
        if (i3 < 60) {
            this.endMin = i3;
        }
    }

    public void setOpen(boolean z5) {
        this.isOpen = z5;
    }

    public void setStartHour(int i3) {
        if (i3 < 24) {
            this.startHour = i3;
        }
    }

    public void setStartMin(int i3) {
        if (i3 < 60) {
            this.startMin = i3;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BaseReminderBean{isOpen=");
        sb2.append(this.isOpen);
        sb2.append(", startHour=");
        sb2.append(this.startHour);
        sb2.append(", startMin=");
        sb2.append(this.startMin);
        sb2.append(", endHour=");
        sb2.append(this.endHour);
        sb2.append(", endMin=");
        return e.m(sb2, this.endMin, '}');
    }
}
