package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.TRingBloodSugarStatisticsActivity;

/* loaded from: classes.dex */
public final class p implements v5.f0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f7543a;

    public p(r rVar) {
        this.f7543a = rVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        ((XXBaseActivity) ((g7.h) this.f7543a.f7255a)).b0();
    }

    @Override // u5.g
    public final void c() {
        final r rVar = this.f7543a;
        DrinkReminderBean drinkReminderBean = rVar.f7552d;
        if (drinkReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(drinkReminderBean, new oh.l() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(DrinkReminderBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_bloodsugar_watcher");
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
            }, new oh.l() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((g7.h) r.this.f7255a)).b0();
                    if (j4 > 0) {
                        ((g7.h) r.this.f7255a).getClass();
                    } else {
                        ((g7.h) r.this.f7255a).getClass();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        DrinkReminderBean drinkReminderBean = (DrinkReminderBean) obj;
        Log.e("qob", "BSStatisticsPresenter onResult");
        r rVar = this.f7543a;
        ((XXBaseActivity) ((g7.h) rVar.f7255a)).b0();
        if (drinkReminderBean != null) {
            ((TRingBloodSugarStatisticsActivity) ((g7.h) rVar.f7255a)).c(drinkReminderBean);
        }
    }
}
