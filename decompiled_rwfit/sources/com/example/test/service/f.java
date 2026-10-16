package com.example.test.service;

import com.example.blesdk.bean.function.AlarmRemainderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.model.EventBusBeans;
import java.util.List;

/* loaded from: classes.dex */
public final class f implements v5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7699a;

    public f(d0 d0Var) {
        this.f7699a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7699a, "闹钟广播设置失败:", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        List list = (List) obj;
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$alarmRemainderCallback$2$1$onResult$1$1
                @Override // oh.l
                public final List<AlarmRemainderBean> invoke(List<AlarmRemainderBean> alarms) {
                    kotlin.jvm.internal.e.f(alarms, "alarms");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(e.h().g().f18212c);
                    dataSetting.setDataKey("setting_alarm");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(alarms));
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
                    return alarms;
                }
            }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$alarmRemainderCallback$2$1$onResult$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((List<AlarmRemainderBean>) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(List<AlarmRemainderBean> alarmRemainder) {
                    kotlin.jvm.internal.e.f(alarmRemainder, "alarmRemainder");
                    yh.d.b().e(new EventBusBeans.AlarmChangeEvent(alarmRemainder));
                }
            });
        }
    }
}
