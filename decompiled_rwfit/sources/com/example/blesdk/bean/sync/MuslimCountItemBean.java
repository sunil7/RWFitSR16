package com.example.blesdk.bean.sync;

/* loaded from: classes.dex */
public class MuslimCountItemBean {
    private int count;
    private String date;
    private String hour;
    private long timeMills;

    public int getCount() {
        return this.count;
    }

    public String getDate() {
        return this.date;
    }

    public String getHour() {
        return this.hour;
    }

    public long getTimeMills() {
        return this.timeMills;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setHour(String str) {
        this.hour = str;
    }

    public void setTimeMills(long j4) {
        this.timeMills = j4;
    }

    public String toString() {
        return "hour " + this.hour + " count " + this.count + " date " + this.date;
    }
}
