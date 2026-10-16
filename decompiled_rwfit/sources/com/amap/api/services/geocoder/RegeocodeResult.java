package com.amap.api.services.geocoder;

/* loaded from: classes.dex */
public class RegeocodeResult {

    /* renamed from: a, reason: collision with root package name */
    private RegeocodeQuery f6046a;

    /* renamed from: b, reason: collision with root package name */
    private RegeocodeAddress f6047b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f6046a = regeocodeQuery;
        this.f6047b = regeocodeAddress;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.f6047b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f6046a;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.f6047b = regeocodeAddress;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f6046a = regeocodeQuery;
    }
}
