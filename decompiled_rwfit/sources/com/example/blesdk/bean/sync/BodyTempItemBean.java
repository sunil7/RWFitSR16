package com.example.blesdk.bean.sync;

/* loaded from: classes.dex */
public class BodyTempItemBean {
    private String date;
    private String hour;
    private float temp;
    private long timeMills;

    public String getDate() {
        return this.date;
    }

    public String getHour() {
        return this.hour;
    }

    public float getTemp() {
        return this.temp;
    }

    public long getTimeMills() {
        return this.timeMills;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setHour(String str) {
        this.hour = str;
    }

    public void setTemp(float f2) {
        this.temp = f2;
    }

    public void setTimeMills(long j4) {
        this.timeMills = j4;
    }

    public String toString() {
        return "BodyTempItemBean{timeMills=" + this.timeMills + ", temp=" + this.temp + '}';
    }
}
