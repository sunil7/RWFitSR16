package com.example.test.service;

import com.example.blesdk.bean.function.BrightScreenTimeBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class h implements v5.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7710a;

    public h(d0 d0Var) {
        this.f7710a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7710a, "亮屏时长广播设置失败:", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        BrightScreenTimeBean brightScreenTimeBean = (BrightScreenTimeBean) obj;
        if (brightScreenTimeBean != null) {
            com.example.baselibrary.utils.b.x(brightScreenTimeBean, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$brightTimeCallback$2$1$onResult$1$1
                @Override // oh.l
                public final BrightScreenTimeBean invoke(BrightScreenTimeBean brightTime) {
                    kotlin.jvm.internal.e.f(brightTime, "brightTime");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(e.h().g().f18212c);
                    dataSetting.setDataKey("setting_bright_time");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(brightTime));
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    User d5 = kVar != null ? kVar.d() : null;
                    if (d5 != null) {
                        dataSetting.setUserId(d5.getUserId());
                    }
                    SettingImpl.INSTANCE.saveData(dataSetting);
                    return brightTime;
                }
            }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$brightTimeCallback$2$1$onResult$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((BrightScreenTimeBean) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(BrightScreenTimeBean brightTime) {
                    kotlin.jvm.internal.e.f(brightTime, "brightTime");
                    yh.d.b().e(new EventBusBeans.BrightTimeEvent(brightTime));
                }
            });
        }
    }
}
