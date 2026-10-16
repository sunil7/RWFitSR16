package com.example.blesdk.bean.function;

import r5.a;

/* loaded from: classes.dex */
public class MsgPushBean {
    private String appId;
    private String content;
    private int msgType;
    private long timeMill;
    private String title;

    public String getAppId() {
        return this.appId;
    }

    public String getContent() {
        return this.content;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public long getTimeMill() {
        return this.timeMill;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setMsgType(int i3) {
        this.msgType = i3;
    }

    public void setTimeMill(long j4) {
        this.timeMill = j4;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("MsgPushBean{timeMill=");
        sb2.append(this.timeMill);
        sb2.append(", msgType=");
        sb2.append(this.msgType);
        sb2.append(", appId='");
        sb2.append(this.appId);
        sb2.append("', title='");
        sb2.append(this.title);
        sb2.append("', content='");
        return a.f(sb2, this.content, "'}");
    }
}
