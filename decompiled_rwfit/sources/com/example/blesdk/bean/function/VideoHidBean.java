package com.example.blesdk.bean.function;

/* loaded from: classes.dex */
public class VideoHidBean extends BaseReminderBean {
    private boolean isDefaultOpen = false;
    private int hidOpen = 0;

    public int getHidOpen() {
        return this.hidOpen;
    }

    public boolean isDefaultOpen() {
        return this.isDefaultOpen;
    }

    public void setDefaultOpen(boolean z5) {
        this.isDefaultOpen = z5;
    }

    public void setHidOpen(int i3) {
        this.hidOpen = i3;
    }
}
