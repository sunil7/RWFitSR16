package com.amap.api.maps;

import com.amap.api.maps.AMap;

/* loaded from: classes.dex */
class d implements AMap.CancelableCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f5717a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f5718b;

    public d(AMap aMap, Runnable runnable, Runnable runnable2) {
        this.f5717a = runnable;
        this.f5718b = runnable2;
    }

    @Override // com.amap.api.maps.AMap.CancelableCallback
    public void onCancel() {
        this.f5718b.run();
    }

    @Override // com.amap.api.maps.AMap.CancelableCallback
    public void onFinish() {
        this.f5717a.run();
    }
}
