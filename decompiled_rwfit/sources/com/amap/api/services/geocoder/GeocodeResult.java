package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GeocodeResult {

    /* renamed from: a, reason: collision with root package name */
    private GeocodeQuery f6022a;

    /* renamed from: b, reason: collision with root package name */
    private List<GeocodeAddress> f6023b;

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        new ArrayList();
        this.f6022a = geocodeQuery;
        this.f6023b = list;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.f6023b;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f6022a;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.f6023b = list;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f6022a = geocodeQuery;
    }
}
