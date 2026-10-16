package com.example.network.bean;

import r5.a;

/* loaded from: classes.dex */
public class SportLatLngServerItemBean {
    private String lat;
    private String lng;

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportLatLngServerItemBean{lat='");
        sb2.append(this.lat);
        sb2.append("', lng='");
        return a.f(sb2, this.lng, "'}");
    }
}
