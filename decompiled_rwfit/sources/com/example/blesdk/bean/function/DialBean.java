package com.example.blesdk.bean.function;

import r5.a;

/* loaded from: classes.dex */
public class DialBean {
    private String dialId;
    private int type;

    public String getDialId() {
        return this.dialId;
    }

    public int getType() {
        return this.type;
    }

    public void setDialId(String str) {
        this.dialId = str;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DialBean{type=");
        sb2.append(this.type);
        sb2.append(", dialId='");
        return a.f(sb2, this.dialId, "'}");
    }
}
