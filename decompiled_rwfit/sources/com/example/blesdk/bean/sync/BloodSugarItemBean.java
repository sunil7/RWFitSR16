package com.example.blesdk.bean.sync;

/* loaded from: classes.dex */
public class BloodSugarItemBean {
    private String date;
    private String hour;
    private float sugar;
    private long timeMills;

    public String getDate() {
        return this.date;
    }

    public String getHour() {
        return this.hour;
    }

    public float getSugar() {
        return this.sugar;
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

    public void setSugar(float f2) {
        this.sugar = f2;
    }

    public void setTimeMills(long j4) {
        this.timeMills = j4;
    }
}
