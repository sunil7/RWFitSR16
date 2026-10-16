package com.example.network.bean;

import r5.a;

/* loaded from: classes.dex */
public class SwitchBean {
    private String paraName;
    private String paraValue;

    public String getParaName() {
        return this.paraName;
    }

    public String getParaValue() {
        return this.paraValue;
    }

    public void setParaName(String str) {
        this.paraName = str;
    }

    public void setParaValue(String str) {
        this.paraValue = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SwitchBean{paraName='");
        sb2.append(this.paraName);
        sb2.append("', paraValue='");
        return a.f(sb2, this.paraValue, "'}");
    }
}
