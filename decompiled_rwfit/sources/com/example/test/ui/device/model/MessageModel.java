package com.example.test.ui.device.model;

/* loaded from: classes.dex */
public class MessageModel {

    /* renamed from: id, reason: collision with root package name */
    private int f7910id;
    private boolean isEnableSwitch;
    private boolean isNext;
    private boolean isSelected;
    private int res;
    private int strRes;

    public MessageModel() {
    }

    public int getId() {
        return this.f7910id;
    }

    public int getRes() {
        return this.res;
    }

    public int getStrRes() {
        return this.strRes;
    }

    public boolean isEnableSwitch() {
        return this.isEnableSwitch;
    }

    public boolean isNext() {
        return this.isNext;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setEnableSwitch(boolean z5) {
        this.isEnableSwitch = z5;
    }

    public void setId(int i3) {
        this.f7910id = i3;
    }

    public void setNext(boolean z5) {
        this.isNext = z5;
    }

    public void setRes(int i3) {
        this.res = i3;
    }

    public void setSelected(boolean z5) {
        this.isSelected = z5;
    }

    public void setStrRes(int i3) {
        this.strRes = i3;
    }

    public MessageModel(int i3, int i10, int i11) {
        this.res = i10;
        this.strRes = i11;
        this.f7910id = i3;
    }

    public MessageModel(int i3, int i10, int i11, boolean z5) {
        this.res = i10;
        this.strRes = i11;
        this.f7910id = i3;
        this.isNext = z5;
    }
}
