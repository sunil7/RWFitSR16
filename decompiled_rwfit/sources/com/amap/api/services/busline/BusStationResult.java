package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class BusStationResult {

    /* renamed from: a, reason: collision with root package name */
    private int f5892a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<BusStationItem> f5893b;

    /* renamed from: c, reason: collision with root package name */
    private BusStationQuery f5894c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f5895d;
    private List<SuggestionCity> e;

    private BusStationResult(BusStationQuery busStationQuery, int i3, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        this.f5893b = new ArrayList<>();
        this.f5895d = new ArrayList();
        this.e = new ArrayList();
        this.f5894c = busStationQuery;
        this.f5892a = a(i3);
        this.e = list;
        this.f5895d = list2;
        this.f5893b = arrayList;
    }

    private int a(int i3) {
        int pageSize = ((i3 + r0) - 1) / this.f5894c.getPageSize();
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public static BusStationResult createPagedResult(BusStationQuery busStationQuery, int i3, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        return new BusStationResult(busStationQuery, i3, list, list2, arrayList);
    }

    public List<BusStationItem> getBusStations() {
        return this.f5893b;
    }

    public int getPageCount() {
        return this.f5892a;
    }

    public BusStationQuery getQuery() {
        return this.f5894c;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.e;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f5895d;
    }
}
