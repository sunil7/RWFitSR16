package com.example.test.utils;

import com.amap.api.location.AMapLocation;
import com.example.network.api.DeviceApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.LocationServerInfoBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class s implements e6.a {

    /* renamed from: b, reason: collision with root package name */
    public static s f8754b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8755a;

    @Override // e6.a
    public final void a(AMapLocation aMapLocation) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "位置定位成功 lat = " + aMapLocation.getLatitude() + " lng = " + aMapLocation.getLongitude() + " " + toString());
        String lng = String.valueOf(aMapLocation.getLongitude());
        String lat = String.valueOf(aMapLocation.getLatitude());
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "请求位置数据");
        c6.b bVar = c6.b.f3390c;
        bVar.getClass();
        kotlin.jvm.internal.e.f(lng, "lng");
        kotlin.jvm.internal.e.f(lat, "lat");
        rg.l<HttpModel<LocationServerInfoBean>> locationInfo = ((DeviceApi) bVar.f113a).getLocationInfo(lng, lat);
        kotlin.jvm.internal.e.e(locationInfo, "getLocationInfo(...)");
        com.example.baselibrary.utils.b.w(locationInfo).subscribe(new androidx.camera.core.impl.h0(this, 1, lat, lng), new af.a(this, 15));
    }

    @Override // e6.a
    public final void b() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "位置定位失败");
        this.f8755a = false;
    }

    public final void c() {
        WeakReference weakReference;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "结束位置同步");
        int i3 = 0;
        this.f8755a = false;
        t a3 = t.a();
        if (a3.c(this)) {
            ArrayList arrayList = a3.f8761c;
            int size = arrayList.size();
            while (true) {
                if (i3 >= size) {
                    weakReference = null;
                    break;
                }
                Object obj = arrayList.get(i3);
                i3++;
                weakReference = (WeakReference) obj;
                if (weakReference.get() != null && weakReference.get() == this) {
                    break;
                }
            }
            if (weakReference == null) {
                return;
            }
            if (weakReference.get() == null) {
                arrayList.remove(weakReference);
            } else {
                weakReference.clear();
                arrayList.remove(weakReference);
            }
        }
    }
}
