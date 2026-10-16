package com.example.network.bean;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class SportPacesServerItemBean {
    private int index;
    private int isWhole;
    private int pace;

    public int getIndex() {
        return this.index;
    }

    public int getIsWhole() {
        return this.isWhole;
    }

    public int getPace() {
        return this.pace;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setIsWhole(int i3) {
        this.isWhole = i3;
    }

    public void setPace(int i3) {
        this.pace = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportPacesServerItemBean{index=");
        sb2.append(this.index);
        sb2.append(", pace=");
        sb2.append(this.pace);
        sb2.append(", isWhole=");
        return e.m(sb2, this.isWhole, '}');
    }
}
