package com.example.test.service;

import com.example.blesdk.bean.function.DNDModelBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class j implements v5.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7722a;

    public j(d0 d0Var) {
        this.f7722a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7722a, "勿扰提醒广播设置失败:", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        DNDModelBean dNDModelBean = (DNDModelBean) obj;
        if (dNDModelBean != null) {
            com.example.baselibrary.utils.b.x(dNDModelBean, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$dndCallback$2$1$onResult$1$1
                @Override // oh.l
                public final DNDModelBean invoke(DNDModelBean dndModelBean) {
                    kotlin.jvm.internal.e.f(dndModelBean, "dndModelBean");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(e.h().g().f18212c);
                    dataSetting.setDataKey("setting_dnd");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(dndModelBean));
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
                    return dndModelBean;
                }
            }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$dndCallback$2$1$onResult$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((DNDModelBean) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(DNDModelBean dndModelBean) {
                    kotlin.jvm.internal.e.f(dndModelBean, "dndModelBean");
                    yh.d.b().e(new EventBusBeans.DNDModelEvent(dndModelBean));
                }
            });
        }
    }
}
