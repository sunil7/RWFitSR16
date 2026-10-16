package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class UploadInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f6081a = 1;

    /* renamed from: b, reason: collision with root package name */
    private String f6082b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f6083c;

    public int getCoordType() {
        return this.f6081a;
    }

    public LatLonPoint getPoint() {
        return this.f6083c;
    }

    public String getUserID() {
        return this.f6082b;
    }

    public void setCoordType(int i3) {
        if (i3 == 0 || i3 == 1) {
            this.f6081a = i3;
        } else {
            this.f6081a = 1;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f6083c = latLonPoint;
    }

    public void setUserID(String str) {
        this.f6082b = str;
    }
}
