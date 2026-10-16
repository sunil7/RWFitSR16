package com.example.test.service;

import com.example.blesdk.bean.function.SedentaryReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class x implements v5.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7834a;

    public x(d0 d0Var) {
        this.f7834a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7834a, "广播久坐设置失败:", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        SedentaryReminderBean sedentaryReminderBean = (SedentaryReminderBean) obj;
        if (sedentaryReminderBean != null) {
            com.example.baselibrary.utils.b.x(sedentaryReminderBean, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$sedentaryRemindCallback$2$1$onResult$1$1
                @Override // oh.l
                public final SedentaryReminderBean invoke(SedentaryReminderBean reminderBean) {
                    kotlin.jvm.internal.e.f(reminderBean, "reminderBean");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(e.h().g().f18212c);
                    dataSetting.setDataKey("setting_long_sit");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(reminderBean));
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
                    return reminderBean;
                }
            }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$sedentaryRemindCallback$2$1$onResult$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((SedentaryReminderBean) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(SedentaryReminderBean reminderBean) {
                    kotlin.jvm.internal.e.f(reminderBean, "reminderBean");
                    yh.d.b().e(new EventBusBeans.DeviceSedentaryEvent(reminderBean));
                }
            });
        }
    }
}
