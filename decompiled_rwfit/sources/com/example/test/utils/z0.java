package com.example.test.utils;

import com.amap.api.location.AMapLocation;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.network.api.DeviceApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.WeatherInfoBean;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class z0 implements e6.a {

    /* renamed from: d, reason: collision with root package name */
    public static z0 f8776d;
    public static HashMap e;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue f8777a = new LinkedBlockingQueue();

    /* renamed from: b, reason: collision with root package name */
    public boolean f8778b = false;

    /* renamed from: c, reason: collision with root package name */
    public final long f8779c = Const.L_WIFI_EXP;

    public z0() {
        y0 y0Var = new y0(this);
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = y0Var;
        I0.K0(eVar);
    }

    public static z0 d() {
        if (f8776d == null) {
            synchronized (z0.class) {
                f8776d = new z0();
                e();
            }
        }
        return f8776d;
    }

    public static void e() {
        HashMap hashMap = new HashMap();
        e = hashMap;
        hashMap.put(1, 1);
        e.put(2, 3);
        e.put(3, 2);
        e.put(4, 13);
        e.put(6, 14);
        e.put(8, 6);
        e.put(9, 16);
        e.put(10, 8);
        e.put(11, 17);
        e.put(12, 18);
        e.put(13, 9);
        e.put(14, 10);
        e.put(7, 4);
        e.put(5, 4);
        e.put(0, 0);
    }

    @Override // e6.a
    public final void a(AMapLocation aMapLocation) {
        String str;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "天气定位成功 lat = " + aMapLocation.getLatitude() + " lng = " + aMapLocation.getLongitude() + " " + toString());
        String lng = String.valueOf(aMapLocation.getLongitude());
        String lat = String.valueOf(aMapLocation.getLatitude());
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "请求天气数据");
        try {
            str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
            kotlin.jvm.internal.e.e(str, "format(...)");
        } catch (Exception e10) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("date translate error ", e10.getMessage()));
            str = "";
        }
        c6.b bVar = c6.b.f3390c;
        bVar.getClass();
        kotlin.jvm.internal.e.f(lng, "lng");
        kotlin.jvm.internal.e.f(lat, "lat");
        rg.l<HttpModel<List<WeatherInfoBean>>> weather = ((DeviceApi) bVar.f113a).getWeather(lng, lat, str);
        kotlin.jvm.internal.e.e(weather, "getWeather(...)");
        final int i3 = 0;
        final int i10 = 1;
        com.example.baselibrary.utils.b.w(weather).subscribe(new vg.g(this) { // from class: com.example.test.utils.x0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ z0 f8770b;

            {
                this.f8770b = this;
            }

            /* JADX WARN: Removed duplicated region for block: B:112:0x050a  */
            /* JADX WARN: Removed duplicated region for block: B:114:0x0513  */
            @Override // vg.g
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void f(java.lang.Object r34) {
                /*
                    Method dump skipped, instructions count: 1464
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.test.utils.x0.f(java.lang.Object):void");
            }
        }, new vg.g(this) { // from class: com.example.test.utils.x0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ z0 f8770b;

            {
                this.f8770b = this;
            }

            @Override // vg.g
            public final void f(Object obj) {
                /*
                    Method dump skipped, instructions count: 1464
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.test.utils.x0.f(java.lang.Object):void");
            }
        });
    }

    @Override // e6.a
    public final void b() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "天气定位失败");
        this.f8778b = false;
    }

    public final void c() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "结束天气同步");
        this.f8778b = false;
    }

    public final void f(boolean z5) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "进入天气同步 ");
        Object obj = m.f8734b;
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (!(supportMenuBean != null ? supportMenuBean.isWeather() : true)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "设备不支持天气同步");
            return;
        }
        if (this.f8778b) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "天气正在同步");
            return;
        }
        s5.a aVar = com.example.test.service.e.h().e;
        if ((aVar == null ? 0 : aVar.f18213d) != 1) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "设备未连接");
            return;
        }
        s5.a g10 = com.example.test.service.e.h().g();
        if (g10 == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "找不到设备");
            return;
        }
        if (y1.a() == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
            return;
        }
        if (!y1.a().K(g10.f18212c)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "天气开关未开启");
            return;
        }
        if (!z5) {
            if (System.currentTimeMillis() - y1.a().r(g10.f18212c) < this.f8779c) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "时间间隔小于一小时");
                return;
            }
        }
        XXApplication xXApplication = XXApplication.f7400h;
        if (!nd.c.j(j1.a(), kotlin.collections.i.b("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"))) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "定位权限未开启");
            return;
        }
        this.f8778b = true;
        t a3 = t.a();
        if (!a3.c(this)) {
            a3.f8761c.add(new WeakReference(this));
        }
        t.a().e(j1.a());
    }
}
