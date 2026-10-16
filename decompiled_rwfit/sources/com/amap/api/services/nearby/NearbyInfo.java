package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class NearbyInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f6068a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f6069b;

    /* renamed from: c, reason: collision with root package name */
    private long f6070c;

    /* renamed from: d, reason: collision with root package name */
    private int f6071d;
    private int e;

    public int getDistance() {
        return this.f6071d;
    }

    public int getDrivingDistance() {
        return this.e;
    }

    public LatLonPoint getPoint() {
        return this.f6069b;
    }

    public long getTimeStamp() {
        return this.f6070c;
    }

    public String getUserID() {
        return this.f6068a;
    }

    public void setDistance(int i3) {
        this.f6071d = i3;
    }

    public void setDrivingDistance(int i3) {
        this.e = i3;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f6069b = latLonPoint;
    }

    public void setTimeStamp(long j4) {
        this.f6070c = j4;
    }

    public void setUserID(String str) {
        this.f6068a = str;
    }
}
