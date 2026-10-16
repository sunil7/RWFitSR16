package com.autonavi.base.amap.mapcore;

/* loaded from: classes.dex */
public class LinkInfo {
    private int state = 0;
    private int time = 0;
    private int length = 0;

    public int getLength() {
        return this.length;
    }

    public int getState() {
        return this.state;
    }

    public int getTime() {
        return this.time;
    }

    public void setLength(int i3) {
        this.length = i3;
    }

    public void setState(int i3) {
        this.state = i3;
    }

    public void setTime(int i3) {
        this.time = i3;
    }

    public String toString() {
        return "状态：" + this.state + "|时间：" + this.time + "|长度：" + this.length;
    }
}
