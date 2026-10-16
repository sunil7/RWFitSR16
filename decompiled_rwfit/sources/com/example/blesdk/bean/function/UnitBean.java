package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class UnitBean {
    private int lang;
    private int measureUnit;
    private int tempUnit;
    private int timeFont;

    public int getLang() {
        return this.lang;
    }

    public int getMeasureUnit() {
        return this.measureUnit;
    }

    public int getTempUnit() {
        return this.tempUnit;
    }

    public int getTimeFont() {
        return this.timeFont;
    }

    public void setLang(int i3) {
        this.lang = i3;
    }

    public void setMeasureUnit(int i3) {
        this.measureUnit = i3;
    }

    public void setTempUnit(int i3) {
        this.tempUnit = i3;
    }

    public void setTimeFont(int i3) {
        this.timeFont = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("UnitBean{lang=");
        sb2.append(this.lang);
        sb2.append(", measureUnit=");
        sb2.append(this.measureUnit);
        sb2.append(", tempUnit=");
        sb2.append(this.tempUnit);
        sb2.append(", timeFont=");
        return e.m(sb2, this.timeFont, '}');
    }
}
