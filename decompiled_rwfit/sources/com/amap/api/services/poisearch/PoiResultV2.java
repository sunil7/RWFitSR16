package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PoiResultV2 {

    /* renamed from: a, reason: collision with root package name */
    private int f6114a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<PoiItemV2> f6115b;

    /* renamed from: c, reason: collision with root package name */
    private PoiSearchV2.Query f6116c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearchV2.SearchBound f6117d;

    private PoiResultV2(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i3, ArrayList<PoiItemV2> arrayList) {
        new ArrayList();
        this.f6116c = query;
        this.f6117d = searchBound;
        this.f6114a = i3;
        this.f6115b = arrayList;
    }

    public static PoiResultV2 createPagedResult(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i3, ArrayList<PoiItemV2> arrayList) {
        return new PoiResultV2(query, searchBound, i3, arrayList);
    }

    public PoiSearchV2.SearchBound getBound() {
        return this.f6117d;
    }

    public int getCount() {
        return this.f6114a;
    }

    public ArrayList<PoiItemV2> getPois() {
        return this.f6115b;
    }

    public PoiSearchV2.Query getQuery() {
        return this.f6116c;
    }
}
