package com.example.test.service;

import com.example.blesdk.bean.function.ReminderModeBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class w implements v5.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7832a;

    public w(d0 d0Var) {
        this.f7832a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7832a, "广播提醒模式设置失败:", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        ReminderModeBean reminderModeBean = (ReminderModeBean) obj;
        if (reminderModeBean != null) {
            com.example.baselibrary.utils.b.x(reminderModeBean, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$remindModelCallback$2$1$onResult$1$1
                @Override // oh.l
                public final ReminderModeBean invoke(ReminderModeBean reminderModel) {
                    kotlin.jvm.internal.e.f(reminderModel, "reminderModel");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(e.h().g().f18212c);
                    dataSetting.setDataKey("setting_remind_mode");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(reminderModel));
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
                    return reminderModel;
                }
            }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$remindModelCallback$2$1$onResult$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((ReminderModeBean) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(ReminderModeBean modelBean) {
                    kotlin.jvm.internal.e.f(modelBean, "modelBean");
                    yh.d.b().e(new EventBusBeans.DeviceReminderModelEvent(modelBean));
                }
            });
        }
    }
}
