package com.example.network.bean;

import r5.a;

/* loaded from: classes.dex */
public class AppVersionBean {

    /* renamed from: id, reason: collision with root package name */
    private String f7380id;
    private String summary;
    private String url;
    private String version;

    public String getId() {
        return this.f7380id;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setId(String str) {
        this.f7380id = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AppVersionBean{id='");
        sb2.append(this.f7380id);
        sb2.append("', version='");
        sb2.append(this.version);
        sb2.append("', url='");
        sb2.append(this.url);
        sb2.append("', summary='");
        return a.f(sb2, this.summary, "'}");
    }
}
