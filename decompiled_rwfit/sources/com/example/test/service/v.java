package com.example.test.service;

import com.example.blesdk.bean.function.PowerBean;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class v implements v5.m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7830a;

    public v(d0 d0Var) {
        this.f7830a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7830a, "广播电量失败:", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        final PowerBean powerBean = (PowerBean) obj;
        if (powerBean != null) {
            this.f7830a.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", "收到广播电量:" + powerBean);
            com.example.baselibrary.utils.b.x(powerBean, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$powerCallback$2$1$onResult$1$1
                {
                    super(1);
                }

                @Override // oh.l
                public final PowerBean invoke(PowerBean power) {
                    kotlin.jvm.internal.e.f(power, "power");
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    if (kVar != null) {
                        kVar.S(PowerBean.this);
                    }
                    return power;
                }
            }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$powerCallback$2$1$onResult$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((PowerBean) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(PowerBean power) {
                    kotlin.jvm.internal.e.f(power, "power");
                    yh.d.b().e(new EventBusBeans.DevicePowerEvent(power));
                }
            });
        }
    }
}
