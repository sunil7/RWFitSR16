package com.example.test.service;

import com.amap.api.services.core.AMapException;
import com.example.test.XXApplication;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class s implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7780a;

    public s(d0 d0Var) {
        this.f7780a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7780a, "位置信息广播失败 ", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        this.f7780a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", "接收到位置信息广播");
        if (com.example.test.utils.s.f8754b == null) {
            synchronized (com.example.test.utils.s.class) {
                com.example.test.utils.s sVar = new com.example.test.utils.s();
                com.example.test.utils.r rVar = new com.example.test.utils.r(sVar);
                x5.b I0 = x5.b.I0();
                u5.e eVar = new u5.e();
                eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
                eVar.f18884b = rVar;
                I0.K0(eVar);
                com.example.test.utils.s.f8754b = sVar;
            }
        }
        com.example.test.utils.s sVar2 = com.example.test.utils.s.f8754b;
        sVar2.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "进入位置同步 ");
        if (sVar2.f8755a) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "位置正在同步");
            return;
        }
        s5.a aVar = e.h().e;
        if ((aVar == null ? 0 : aVar.f18213d) != 1) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "设备未连接");
            return;
        }
        if (e.h().g() == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "找不到设备");
            return;
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        if (com.example.test.utils.k.f8731b == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
            return;
        }
        XXApplication xXApplication = XXApplication.f7400h;
        com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
        if (!nd.c.j(com.google.android.gms.internal.mlkit_vision_barcode.j1.a(), kotlin.collections.i.b("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"))) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "定位权限未开启");
            return;
        }
        sVar2.f8755a = true;
        com.example.test.utils.t a3 = com.example.test.utils.t.a();
        if (!a3.c(sVar2)) {
            a3.f8761c.add(new WeakReference(sVar2));
        }
        com.example.test.utils.t.a().e(com.google.android.gms.internal.mlkit_vision_barcode.j1.a());
    }
}
