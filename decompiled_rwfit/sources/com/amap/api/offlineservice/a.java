package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected OfflineMapActivity f5835a = null;

    public abstract void a(View view);

    public void a(OfflineMapActivity offlineMapActivity) {
        this.f5835a = offlineMapActivity;
    }

    public abstract boolean a();

    public abstract RelativeLayout b();

    public void c() {
        this.f5835a.showScr();
    }

    public abstract void d();

    public abstract void e();

    public int a(float f2) {
        return this.f5835a != null ? (int) (((r0.getResources().getDisplayMetrics().densityDpi / 160.0f) * f2) + 0.5f) : (int) f2;
    }
}
