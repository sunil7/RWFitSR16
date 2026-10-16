package com.example.network.bean;

import r5.a;

/* loaded from: classes.dex */
public class FileBean {
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return a.f(new StringBuilder("FileBean{url='"), this.url, "'}");
    }
}
