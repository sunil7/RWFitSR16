package com.autonavi.aps.amapapi;

/* loaded from: classes.dex */
public class DNSIPDelegate {

    /* renamed from: a, reason: collision with root package name */
    private String[] f6624a;

    /* renamed from: b, reason: collision with root package name */
    private String f6625b;

    /* renamed from: c, reason: collision with root package name */
    private String f6626c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6627d = false;
    private boolean e = false;

    public String getCacheIp() {
        return this.f6626c;
    }

    public String[] getLocationIPs() {
        return this.f6624a;
    }

    public String getUseIp() {
        return this.f6625b;
    }

    public boolean isHasLocalCache() {
        return this.f6627d;
    }

    public boolean isIsDNSOK() {
        return this.e;
    }

    public void setCacheIp(String str) {
        this.f6626c = str;
    }

    public void setHasLocalCache(boolean z5) {
        this.f6627d = z5;
    }

    public void setIsDNSOK(boolean z5) {
        this.e = z5;
    }

    public void setLocationIPs(String[] strArr) {
        this.f6624a = strArr;
    }

    public void setUseIp(String str) {
        this.f6625b = str;
    }
}
