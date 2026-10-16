package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RegeocodeQuery {

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f6041a;

    /* renamed from: b, reason: collision with root package name */
    private float f6042b;

    /* renamed from: c, reason: collision with root package name */
    private String f6043c = GeocodeSearch.AMAP;

    /* renamed from: d, reason: collision with root package name */
    private String f6044d = "";
    private String e = "distance";

    /* renamed from: f, reason: collision with root package name */
    private String f6045f = "base";

    public RegeocodeQuery(LatLonPoint latLonPoint, float f2, String str) {
        this.f6041a = latLonPoint;
        this.f6042b = f2;
        setLatLonType(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
        String str = this.f6043c;
        if (str == null) {
            if (regeocodeQuery.f6043c != null) {
                return false;
            }
        } else if (!str.equals(regeocodeQuery.f6043c)) {
            return false;
        }
        LatLonPoint latLonPoint = this.f6041a;
        if (latLonPoint == null) {
            if (regeocodeQuery.f6041a != null) {
                return false;
            }
        } else if (!latLonPoint.equals(regeocodeQuery.f6041a)) {
            return false;
        }
        if (Float.floatToIntBits(this.f6042b) != Float.floatToIntBits(regeocodeQuery.f6042b) || !this.e.equals(regeocodeQuery.e)) {
            return false;
        }
        String str2 = this.f6045f;
        if (str2 == null) {
            if (regeocodeQuery.f6045f != null) {
                return false;
            }
        } else if (!str2.equals(regeocodeQuery.f6045f)) {
            return false;
        }
        return true;
    }

    public String getExtensions() {
        return this.f6045f;
    }

    public String getLatLonType() {
        return this.f6043c;
    }

    public String getMode() {
        return this.e;
    }

    public String getPoiType() {
        return this.f6044d;
    }

    public LatLonPoint getPoint() {
        return this.f6041a;
    }

    public float getRadius() {
        return this.f6042b;
    }

    public int hashCode() {
        String str = this.f6043c;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f6041a;
        return Float.floatToIntBits(this.f6042b) + ((hashCode + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31);
    }

    public void setExtensions(String str) {
        this.f6045f = str;
    }

    public void setLatLonType(String str) {
        if (str != null) {
            if (str.equals(GeocodeSearch.AMAP) || str.equals("gps")) {
                this.f6043c = str;
            }
        }
    }

    public void setMode(String str) {
        this.e = str;
    }

    public void setPoiType(String str) {
        this.f6044d = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f6041a = latLonPoint;
    }

    public void setRadius(float f2) {
        this.f6042b = f2;
    }
}
