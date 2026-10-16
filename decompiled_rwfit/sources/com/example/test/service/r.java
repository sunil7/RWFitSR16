package com.example.test.service;

/* loaded from: classes.dex */
public final class r implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7754a;

    public r(d0 d0Var) {
        this.f7754a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7754a, "时间间隔广播失败：", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            d0 d0Var = this.f7754a;
            int intValue = num.intValue();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(d0Var, "设置时间间隔成功:", intValue));
            r5.b k10 = r5.b.k();
            if (intValue < 18) {
                intValue = 18;
            }
            k10.f18064n = intValue;
        }
    }
}
