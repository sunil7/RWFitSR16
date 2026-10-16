package com.example.test.ui.mine.model;

/* loaded from: classes.dex */
public class PersonalQrCodeBean {
    private float cal;
    private float distance;
    private String nickName;
    private int step;
    private String unit;
    private String userAvatar;

    public float getCal() {
        return this.cal;
    }

    public float getDistance() {
        return this.distance;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getStep() {
        return this.step;
    }

    public String getUnit() {
        return this.unit;
    }

    public String getUserAvatar() {
        return this.userAvatar;
    }

    public void setCal(float f2) {
        this.cal = f2;
    }

    public void setDistance(float f2) {
        this.distance = f2;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setStep(int i3) {
        this.step = i3;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public void setUserAvatar(String str) {
        this.userAvatar = str;
    }

    public String toString() {
        return "PersonalQrCodeBean{userAvatar='" + this.userAvatar + "', nickName='" + this.nickName + "', step=" + this.step + ", cal=" + this.cal + ", distance=" + this.distance + ", unit=" + this.unit + '}';
    }
}
