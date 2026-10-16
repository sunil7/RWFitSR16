package com.haibin.calendarview;

import java.io.Serializable;

/* loaded from: classes.dex */
final class Month implements Serializable {
    private int count;
    private int diff;
    private int month;
    private int year;

    public int getCount() {
        return this.count;
    }

    public int getDiff() {
        return this.diff;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setDiff(int i3) {
        this.diff = i3;
    }

    public void setMonth(int i3) {
        this.month = i3;
    }

    public void setYear(int i3) {
        this.year = i3;
    }
}
