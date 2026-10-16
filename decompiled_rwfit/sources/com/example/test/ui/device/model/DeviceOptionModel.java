package com.example.test.ui.device.model;

/* loaded from: classes.dex */
public class DeviceOptionModel {
    private int actionType;

    /* renamed from: id, reason: collision with root package name */
    private int f7909id;
    private boolean isChecked;
    private boolean isEnableSwitch;
    private boolean isHighTips;
    private String optionHint;
    private int optionRes;
    private int optionStr;
    private int optionType;

    public DeviceOptionModel() {
    }

    public int getActionType() {
        return this.actionType;
    }

    public int getId() {
        return this.f7909id;
    }

    public String getOptionHint() {
        return this.optionHint;
    }

    public int getOptionRes() {
        return this.optionRes;
    }

    public int getOptionStr() {
        return this.optionStr;
    }

    public int getOptionType() {
        return this.optionType;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isEnableSwitch() {
        return this.isEnableSwitch;
    }

    public boolean isHighTips() {
        return this.isHighTips;
    }

    public void setActionType(int i3) {
        this.actionType = i3;
    }

    public void setChecked(boolean z5) {
        this.isChecked = z5;
    }

    public void setEnableSwitch(boolean z5) {
        this.isEnableSwitch = z5;
    }

    public void setHighTips(boolean z5) {
        this.isHighTips = z5;
    }

    public void setId(int i3) {
        this.f7909id = i3;
    }

    public void setOptionHint(String str) {
        this.optionHint = str;
    }

    public void setOptionRes(int i3) {
        this.optionRes = i3;
    }

    public void setOptionStr(int i3) {
        this.optionStr = i3;
    }

    public void setOptionType(int i3) {
        this.optionType = i3;
    }

    public DeviceOptionModel(int i3) {
        this.optionType = i3;
    }

    public DeviceOptionModel(int i3, int i10) {
        this.f7909id = i3;
        this.optionType = i10;
    }
}
