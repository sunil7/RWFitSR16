package com.example.test.ui.device.model;

/* loaded from: classes.dex */
public class RemindModel {
    private int index;
    private String showStr;
    private int timeInMinutes;

    public RemindModel(int i3, String str, int i10) {
        this.index = i3;
        this.showStr = str;
        this.timeInMinutes = i10;
    }

    public int getIndex() {
        return this.index;
    }

    public String getShowStr() {
        return this.showStr;
    }

    public int getTimeInMinutes() {
        return this.timeInMinutes;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setShowStr(String str) {
        this.showStr = str;
    }

    public void setTimeInMinutes(int i3) {
        this.timeInMinutes = i3;
    }
}
