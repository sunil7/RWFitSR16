package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NearbySearchResult {

    /* renamed from: a, reason: collision with root package name */
    private List<NearbyInfo> f6079a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f6080b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f6079a;
    }

    public int getTotalNum() {
        return this.f6080b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.f6079a = list;
        this.f6080b = list.size();
    }
}
