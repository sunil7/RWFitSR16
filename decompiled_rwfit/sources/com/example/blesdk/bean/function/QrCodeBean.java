package com.example.blesdk.bean.function;

import r5.a;

/* loaded from: classes.dex */
public class QrCodeBean {
    private int appType = -1;
    private String content = "";
    private String name;

    public int getAppType() {
        return this.appType;
    }

    public String getContent() {
        return this.content;
    }

    public String getName() {
        return this.name;
    }

    public void setAppType(int i3) {
        this.appType = i3;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("QrCodeBean{appType=");
        sb2.append(this.appType);
        sb2.append(", name='");
        sb2.append(this.name);
        sb2.append("', content='");
        return a.f(sb2, this.content, "'}");
    }
}
