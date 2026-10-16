package com.example.network.bean;

import r5.a;

/* loaded from: classes.dex */
public class FirmwareInfoBean {
    private String deviceModel;
    private String downloadUrl;
    private String fromVersion = "0";
    private int size;
    private String summary;
    private String toVersion;

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getFromVersion() {
        return this.fromVersion;
    }

    public int getSize() {
        return this.size;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getToVersion() {
        return this.toVersion;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setFromVersion(String str) {
        this.fromVersion = str;
    }

    public void setSize(int i3) {
        this.size = i3;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setToVersion(String str) {
        this.toVersion = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FirmwareInfoBean{deviceModel='");
        sb2.append(this.deviceModel);
        sb2.append("', fromVersion='");
        sb2.append(this.fromVersion);
        sb2.append("', toVersion='");
        sb2.append(this.toVersion);
        sb2.append("', downloadUrl='");
        sb2.append(this.downloadUrl);
        sb2.append("', size=");
        sb2.append(this.size);
        sb2.append(", summary='");
        return a.f(sb2, this.summary, "'}");
    }
}
