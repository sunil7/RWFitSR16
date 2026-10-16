package com.example.test.service;

import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public final class b0 implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7652a;

    public b0(d0 d0Var) {
        this.f7652a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        this.f7652a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", "请求APP时间广播失败");
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        this.f7652a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", "收到请求APP时间广播");
        if (y5.d.f20005b) {
            Date time = Calendar.getInstance().getTime();
            kotlin.jvm.internal.e.e(time, "getTime(...)");
            com.google.android.gms.internal.mlkit_vision_common.p.v(time);
        } else {
            Date time2 = Calendar.getInstance().getTime();
            kotlin.jvm.internal.e.e(time2, "getTime(...)");
            com.google.android.gms.internal.mlkit_vision_common.p.u(time2);
        }
    }
}
