package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class BusLineResult {

    /* renamed from: a, reason: collision with root package name */
    private int f5878a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<BusLineItem> f5879b;

    /* renamed from: c, reason: collision with root package name */
    private BusLineQuery f5880c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f5881d;
    private List<SuggestionCity> e;

    private BusLineResult(BusLineQuery busLineQuery, int i3, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        this.f5879b = new ArrayList<>();
        this.f5881d = new ArrayList();
        this.e = new ArrayList();
        this.f5880c = busLineQuery;
        this.f5878a = a(i3);
        this.e = list;
        this.f5881d = list2;
        this.f5879b = arrayList;
    }

    private int a(int i3) {
        int pageSize = ((i3 + r0) - 1) / this.f5880c.getPageSize();
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public static BusLineResult createPagedResult(BusLineQuery busLineQuery, int i3, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        return new BusLineResult(busLineQuery, i3, list, list2, arrayList);
    }

    public List<BusLineItem> getBusLines() {
        return this.f5879b;
    }

    public int getPageCount() {
        return this.f5878a;
    }

    public BusLineQuery getQuery() {
        return this.f5880c;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.e;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f5881d;
    }
}
