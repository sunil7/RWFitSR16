package com.example.test.presenter.device;

import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.HealthWatcherActivity;

/* loaded from: classes.dex */
public final class j0 implements v5.i0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f7440a;

    public j0(k0 k0Var) {
        this.f7440a = k0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        k0 k0Var = this.f7440a;
        ((XXBaseActivity) ((f7.m) k0Var.f7255a)).b0();
        k0Var.k(i3);
    }

    @Override // u5.g
    public final void c() {
        final k0 k0Var = this.f7440a;
        ((XXBaseActivity) ((f7.m) k0Var.f7255a)).b0();
        DrinkReminderBean drinkReminderBean = k0Var.e;
        if (drinkReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(drinkReminderBean, new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$saveStressDB$1$1
                @Override // oh.l
                public final Long invoke(DrinkReminderBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_stress_watcher");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(it));
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
                    return Long.valueOf(SettingImpl.INSTANCE.saveData(dataSetting));
                }
            }, new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$saveStressDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.m) k0.this.f7255a)).b0();
                    if (j4 > 0) {
                        ((HealthWatcherActivity) ((f7.m) k0.this.f7255a)).a1();
                    } else {
                        ((HealthWatcherActivity) ((f7.m) k0.this.f7255a)).Z0();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        DrinkReminderBean drinkReminderBean = (DrinkReminderBean) obj;
        if (drinkReminderBean != null) {
            ((HealthWatcherActivity) ((f7.m) this.f7440a.f7255a)).Y0(drinkReminderBean, 3);
        }
    }
}
