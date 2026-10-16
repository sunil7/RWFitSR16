package com.amap.api.services.routepoisearch;

import com.amap.api.col.p0003sl.d6;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import java.util.List;

/* loaded from: classes.dex */
public class RoutePOISearchQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f6508a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f6509b;

    /* renamed from: c, reason: collision with root package name */
    private int f6510c;

    /* renamed from: d, reason: collision with root package name */
    private RoutePOISearch.RoutePOISearchType f6511d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f6512f;

    /* renamed from: g, reason: collision with root package name */
    private String f6513g;

    public RoutePOISearchQuery(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i3, RoutePOISearch.RoutePOISearchType routePOISearchType, int i10) {
        this.f6508a = latLonPoint;
        this.f6509b = latLonPoint2;
        this.f6510c = i3;
        this.f6511d = routePOISearchType;
        this.e = i10;
    }

    public String getChannel() {
        return this.f6513g;
    }

    public LatLonPoint getFrom() {
        return this.f6508a;
    }

    public int getMode() {
        return this.f6510c;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f6512f;
    }

    public int getRange() {
        return this.e;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.f6511d;
    }

    public LatLonPoint getTo() {
        return this.f6509b;
    }

    public void setChannel(String str) {
        this.f6513g = str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RoutePOISearchQuery m40clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            d6.a(e, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        List<LatLonPoint> list = this.f6512f;
        if (list == null || list.size() <= 0) {
            RoutePOISearchQuery routePOISearchQuery = new RoutePOISearchQuery(this.f6508a, this.f6509b, this.f6510c, this.f6511d, this.e);
            routePOISearchQuery.setChannel(this.f6513g);
            return routePOISearchQuery;
        }
        RoutePOISearchQuery routePOISearchQuery2 = new RoutePOISearchQuery(this.f6512f, this.f6511d, this.e);
        routePOISearchQuery2.setChannel(this.f6513g);
        return routePOISearchQuery2;
    }

    public RoutePOISearchQuery(List<LatLonPoint> list, RoutePOISearch.RoutePOISearchType routePOISearchType, int i3) {
        this.f6512f = list;
        this.f6511d = routePOISearchType;
        this.e = i3;
    }
}
