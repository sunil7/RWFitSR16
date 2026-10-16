package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RoutePOISearchResult {

    /* renamed from: a, reason: collision with root package name */
    private List<RoutePOIItem> f6514a;

    /* renamed from: b, reason: collision with root package name */
    private RoutePOISearchQuery f6515b;

    public RoutePOISearchResult(ArrayList<RoutePOIItem> arrayList, RoutePOISearchQuery routePOISearchQuery) {
        new ArrayList();
        this.f6514a = arrayList;
        this.f6515b = routePOISearchQuery;
    }

    public RoutePOISearchQuery getQuery() {
        return this.f6515b;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.f6514a;
    }
}
