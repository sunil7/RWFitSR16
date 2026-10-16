package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class PoiResult {

    /* renamed from: a, reason: collision with root package name */
    private int f6108a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<PoiItem> f6109b;

    /* renamed from: c, reason: collision with root package name */
    private PoiSearch.Query f6110c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearch.SearchBound f6111d;
    private List<String> e;

    /* renamed from: f, reason: collision with root package name */
    private List<SuggestionCity> f6112f;

    /* renamed from: g, reason: collision with root package name */
    private int f6113g;

    private PoiResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i3, int i10, ArrayList<PoiItem> arrayList) {
        this.f6109b = new ArrayList<>();
        this.f6110c = query;
        this.f6111d = searchBound;
        this.e = list;
        this.f6112f = list2;
        this.f6113g = i3;
        this.f6108a = a(i10);
        this.f6109b = arrayList;
    }

    private int a(int i3) {
        return ((i3 + r0) - 1) / this.f6113g;
    }

    public static PoiResult createPagedResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i3, int i10, ArrayList<PoiItem> arrayList) {
        return new PoiResult(query, searchBound, list, list2, i3, i10, arrayList);
    }

    public PoiSearch.SearchBound getBound() {
        return this.f6111d;
    }

    public int getPageCount() {
        return this.f6108a;
    }

    public ArrayList<PoiItem> getPois() {
        return this.f6109b;
    }

    public PoiSearch.Query getQuery() {
        return this.f6110c;
    }

    public List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f6112f;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.e;
    }
}
