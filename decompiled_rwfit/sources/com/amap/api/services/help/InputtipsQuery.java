package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class InputtipsQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f6057a;

    /* renamed from: b, reason: collision with root package name */
    private String f6058b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6059c = false;

    /* renamed from: d, reason: collision with root package name */
    private String f6060d = null;
    private LatLonPoint e;

    public InputtipsQuery(String str, String str2) {
        this.f6057a = str;
        this.f6058b = str2;
    }

    public String getCity() {
        return this.f6058b;
    }

    public boolean getCityLimit() {
        return this.f6059c;
    }

    public String getKeyword() {
        return this.f6057a;
    }

    public LatLonPoint getLocation() {
        return this.e;
    }

    public String getType() {
        return this.f6060d;
    }

    public void setCityLimit(boolean z5) {
        this.f6059c = z5;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public void setType(String str) {
        this.f6060d = str;
    }
}
