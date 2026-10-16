package com.example.test.service;

/* loaded from: classes.dex */
public final class t implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7806a;

    public t(d0 d0Var) {
        this.f7806a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7806a, "MTU广播失败：", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            int intValue = num.intValue();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7806a, "设置MTU成功:", intValue));
            r5.b.k().f18063m = intValue;
        }
    }
}
