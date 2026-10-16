package com.example.test.presenter.device;

import android.util.Log;
import com.example.blesdk.bean.function.HrReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.HrReminderActivity;

/* loaded from: classes.dex */
public final class l0 implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f7457a;

    public l0(m0 m0Var) {
        this.f7457a = m0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        Log.e("qob", "hrReminderCallback onFail");
        m0 m0Var = this.f7457a;
        ((XXBaseActivity) ((f7.n) m0Var.f7255a)).b0();
        m0Var.k(i3);
    }

    @Override // u5.g
    public final void c() {
        Log.e("qob", "hrReminderCallback onSuccess");
        m0 m0Var = this.f7457a;
        ((XXBaseActivity) ((f7.n) m0Var.f7255a)).b0();
        HrReminderBean hrReminderBean = m0Var.f7460b;
        if (hrReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(hrReminderBean, HrReminderPresenter$saveDB$1$1.INSTANCE, new HrReminderPresenter$saveDB$1$2(m0Var));
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        HrReminderBean hrReminderBean = (HrReminderBean) obj;
        final m0 m0Var = this.f7457a;
        ((XXBaseActivity) ((f7.n) m0Var.f7255a)).b0();
        Log.e("qob", "hrReminderCallback onResult");
        if (hrReminderBean != null) {
            HrReminderActivity hrReminderActivity = (HrReminderActivity) ((f7.n) m0Var.f7255a);
            hrReminderActivity.getClass();
            hrReminderActivity.S0().setOpen(hrReminderBean.isOpen());
            hrReminderActivity.S0().setRemindValue(hrReminderBean.getRemindValue());
            hrReminderActivity.R0();
            com.example.baselibrary.preseneter.b.j(hrReminderBean, new oh.l() { // from class: com.example.test.presenter.device.HrReminderPresenter$saveDB$2
                @Override // oh.l
                public final Long invoke(HrReminderBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_hr_reminder");
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
            }, new oh.l() { // from class: com.example.test.presenter.device.HrReminderPresenter$saveDB$3
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Number) obj2).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.n) m0.this.f7255a)).b0();
                    if (j4 > 0) {
                        Log.e("qob", "HrReminderPresenter.saveDB 保存成功");
                    } else {
                        Log.e("qob", "HrReminderPresenter.saveDB 保存成功");
                    }
                }
            });
        }
    }
}
