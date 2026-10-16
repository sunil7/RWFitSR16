package com.amap.api.services.cloud;

import com.amap.api.services.cloud.CloudSearch;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CloudResult {

    /* renamed from: a, reason: collision with root package name */
    private int f5905a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<CloudItem> f5906b;

    /* renamed from: c, reason: collision with root package name */
    private int f5907c;

    /* renamed from: d, reason: collision with root package name */
    private int f5908d;
    private CloudSearch.Query e;

    /* renamed from: f, reason: collision with root package name */
    private CloudSearch.SearchBound f5909f;

    private CloudResult(CloudSearch.Query query, int i3, CloudSearch.SearchBound searchBound, int i10, ArrayList<CloudItem> arrayList) {
        this.e = query;
        this.f5907c = i3;
        this.f5908d = i10;
        this.f5905a = a(i3);
        this.f5906b = arrayList;
        this.f5909f = searchBound;
    }

    private int a(int i3) {
        return ((i3 + r0) - 1) / this.f5908d;
    }

    public static CloudResult createPagedResult(CloudSearch.Query query, int i3, CloudSearch.SearchBound searchBound, int i10, ArrayList<CloudItem> arrayList) {
        return new CloudResult(query, i3, searchBound, i10, arrayList);
    }

    public CloudSearch.SearchBound getBound() {
        return this.f5909f;
    }

    public ArrayList<CloudItem> getClouds() {
        return this.f5906b;
    }

    public int getPageCount() {
        return this.f5905a;
    }

    public CloudSearch.Query getQuery() {
        return this.e;
    }

    public int getTotalCount() {
        return this.f5907c;
    }
}
