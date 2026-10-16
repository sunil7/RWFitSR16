package com.example.network.bean;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BpServerItemBean {
    private int dbp;
    private int sbp;
    private String timestamp;

    public int getDbp() {
        return this.dbp;
    }

    public int getSbp() {
        return this.sbp;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setDbp(int i3) {
        this.dbp = i3;
    }

    public void setSbp(int i3) {
        this.sbp = i3;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BpServerItemBean{timestamp='");
        sb2.append(this.timestamp);
        sb2.append("', sbp=");
        sb2.append(this.sbp);
        sb2.append(", dbp=");
        return e.m(sb2, this.dbp, '}');
    }
}
