package com.example.blesdk.bean.function;

import r5.a;

/* loaded from: classes.dex */
public class BlueToothInfoBean {
    private String bleName;
    private String btName;

    public String getBleName() {
        return this.bleName;
    }

    public String getBtName() {
        return this.btName;
    }

    public void setBleName(String str) {
        this.bleName = str;
    }

    public void setBtName(String str) {
        this.btName = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BlueToothInfoBean{bleName='");
        sb2.append(this.bleName);
        sb2.append("', btName='");
        return a.f(sb2, this.btName, "'}");
    }
}
