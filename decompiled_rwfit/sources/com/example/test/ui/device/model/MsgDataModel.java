package com.example.test.ui.device.model;

/* loaded from: classes.dex */
public class MsgDataModel {
    private int appId;
    private boolean isOpen;

    public MsgDataModel() {
    }

    public int getAppId() {
        return this.appId;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setAppId(int i3) {
        this.appId = i3;
    }

    public void setOpen(boolean z5) {
        this.isOpen = z5;
    }

    public MsgDataModel(int i3, boolean z5) {
        this.appId = i3;
        this.isOpen = z5;
    }
}
