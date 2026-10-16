package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class ChargeStationInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f6206a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f6207b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f6208c;

    /* renamed from: d, reason: collision with root package name */
    private String f6209d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6210f;

    /* renamed from: g, reason: collision with root package name */
    private int f6211g;

    /* renamed from: h, reason: collision with root package name */
    private int f6212h;

    /* renamed from: i, reason: collision with root package name */
    private int f6213i;

    /* renamed from: j, reason: collision with root package name */
    private int f6214j;

    /* renamed from: k, reason: collision with root package name */
    private int f6215k;

    /* renamed from: l, reason: collision with root package name */
    private int f6216l;

    public int getAmperage() {
        return this.f6216l;
    }

    public String getBrandName() {
        return this.f6210f;
    }

    public int getChargePercent() {
        return this.f6212h;
    }

    public int getChargeTime() {
        return this.f6213i;
    }

    public int getMaxPower() {
        return this.f6211g;
    }

    public String getName() {
        return this.e;
    }

    public String getPoiId() {
        return this.f6209d;
    }

    public LatLonPoint getProjectivePoint() {
        return this.f6208c;
    }

    public int getRemainingCapacity() {
        return this.f6214j;
    }

    public LatLonPoint getShowPoint() {
        return this.f6207b;
    }

    public int getStepIndex() {
        return this.f6206a;
    }

    public int getVoltage() {
        return this.f6215k;
    }

    public void setAmperage(int i3) {
        this.f6216l = i3;
    }

    public void setBrandName(String str) {
        this.f6210f = str;
    }

    public void setChargePercent(int i3) {
        this.f6212h = i3;
    }

    public void setChargeTime(int i3) {
        this.f6213i = i3;
    }

    public void setMaxPower(int i3) {
        this.f6211g = i3;
    }

    public void setName(String str) {
        this.e = str;
    }

    public void setPoiId(String str) {
        this.f6209d = str;
    }

    public void setProjectivePoint(LatLonPoint latLonPoint) {
        this.f6208c = latLonPoint;
    }

    public void setRemainingCapacity(int i3) {
        this.f6214j = i3;
    }

    public void setShowPoint(LatLonPoint latLonPoint) {
        this.f6207b = latLonPoint;
    }

    public void setStepIndex(int i3) {
        this.f6206a = i3;
    }

    public void setVoltage(int i3) {
        this.f6215k = i3;
    }
}
