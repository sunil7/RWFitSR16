package com.example.test.presenter.device;

import android.util.Log;
import com.example.blesdk.bean.function.BoReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.BoReminderActivity;

/* loaded from: classes.dex */
public final class h implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f7433a;

    public h(i iVar) {
        this.f7433a = iVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        Log.e("qob", "boReminderCallback onFail");
        i iVar = this.f7433a;
        ((XXBaseActivity) ((f7.b) iVar.f7255a)).b0();
        iVar.k(i3);
    }

    @Override // u5.g
    public final void c() {
        Log.e("qob", "boReminderCallback onSuccess");
        i iVar = this.f7433a;
        ((XXBaseActivity) ((f7.b) iVar.f7255a)).b0();
        BoReminderBean boReminderBean = iVar.f7436b;
        if (boReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(boReminderBean, BoReminderPresenter$saveDB$1$1.INSTANCE, new BoReminderPresenter$saveDB$1$2(iVar));
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        BoReminderBean boReminderBean = (BoReminderBean) obj;
        final i iVar = this.f7433a;
        ((XXBaseActivity) ((f7.b) iVar.f7255a)).b0();
        Log.e("qob", "boReminderCallback onResult");
        if (boReminderBean != null) {
            BoReminderActivity boReminderActivity = (BoReminderActivity) ((f7.b) iVar.f7255a);
            boReminderActivity.getClass();
            boReminderActivity.S0().setOpen(boReminderBean.isOpen());
            boReminderActivity.S0().setRemindValue(boReminderBean.getRemindValue());
            boReminderActivity.R0();
            com.example.baselibrary.preseneter.b.j(boReminderBean, new oh.l() { // from class: com.example.test.presenter.device.BoReminderPresenter$saveDB$2
                @Override // oh.l
                public final Long invoke(BoReminderBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_bo_reminder");
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
            }, new oh.l() { // from class: com.example.test.presenter.device.BoReminderPresenter$saveDB$3
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Number) obj2).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.b) i.this.f7255a)).b0();
                    if (j4 > 0) {
                        Log.e("qob", "BoReminderPresenter.saveDB 保存成功");
                    } else {
                        Log.e("qob", "BoReminderPresenter.saveDB 保存失败");
                    }
                }
            });
        }
    }
}
