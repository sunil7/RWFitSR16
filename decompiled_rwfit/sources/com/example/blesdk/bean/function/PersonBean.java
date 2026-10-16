package com.example.blesdk.bean.function;

import r5.a;

/* loaded from: classes.dex */
public class PersonBean {
    private int birthdayDay;
    private int birthdayMonth;
    private int birthdayYear = 1990;
    private int gender;
    private float height;
    private int measureUnit;
    private String nickName;
    private int stepTarget;
    private float weight;

    public int getBirthdayDay() {
        return this.birthdayDay;
    }

    public int getBirthdayMonth() {
        return this.birthdayMonth;
    }

    public int getBirthdayYear() {
        return this.birthdayYear;
    }

    public int getGender() {
        return this.gender;
    }

    public float getHeight() {
        return this.height;
    }

    public int getMeasureUnit() {
        return this.measureUnit;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getStepTarget() {
        return this.stepTarget;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setBirthdayDay(int i3) {
        this.birthdayDay = i3;
    }

    public void setBirthdayMonth(int i3) {
        this.birthdayMonth = i3;
    }

    public void setBirthdayYear(int i3) {
        this.birthdayYear = i3;
    }

    public void setGender(int i3) {
        this.gender = i3;
    }

    public void setHeight(float f2) {
        this.height = f2;
    }

    public void setMeasureUnit(int i3) {
        this.measureUnit = i3;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setStepTarget(int i3) {
        this.stepTarget = i3;
    }

    public void setWeight(float f2) {
        this.weight = f2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PersonBean{gender=");
        sb2.append(this.gender);
        sb2.append(", birthdayYear=");
        sb2.append(this.birthdayYear);
        sb2.append(", birthdayMonth=");
        sb2.append(this.birthdayMonth);
        sb2.append(", birthdayDay=");
        sb2.append(this.birthdayDay);
        sb2.append(", height=");
        sb2.append(this.height);
        sb2.append(", weight=");
        sb2.append(this.weight);
        sb2.append(", stepTarget=");
        sb2.append(this.stepTarget);
        sb2.append(", measureUnit=");
        sb2.append(this.measureUnit);
        sb2.append(", nickName='");
        return a.f(sb2, this.nickName, "'}");
    }
}
