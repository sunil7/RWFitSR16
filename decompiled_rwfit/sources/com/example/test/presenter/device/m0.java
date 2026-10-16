package com.example.test.presenter.device;

import com.example.blesdk.bean.function.HrReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.HrReminderActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class m0 extends d {

    /* renamed from: b, reason: collision with root package name */
    public HrReminderBean f7460b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7461c;

    public m0(HrReminderActivity hrReminderActivity) {
        super(hrReminderActivity);
        this.f7461c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.HrReminderPresenter$hrReminderCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final l0 invoke() {
                return new l0(m0.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        l0 l0Var = (l0) this.f7461c.getValue();
        if (l0Var == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(l0Var)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == l0Var) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.HrReminderPresenter$initData$1
            @Override // oh.l
            public final DataSetting invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 == null) {
                    return null;
                }
                SettingImpl settingImpl = SettingImpl.INSTANCE;
                String userId = d5.getUserId();
                String str = android.support.v4.media.session.e.y(userId, "getUserId(...)").f18212c;
                kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                return settingImpl.getData(userId, str, "setting_hr_reminder");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.HrReminderPresenter$initData$2

            public static final class a extends bc.a<HrReminderBean> {
            }

            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DataSetting) obj);
                return eh.g.f12633a;
            }

            public final void invoke(DataSetting dataSetting) {
                if (dataSetting != null) {
                    m0 m0Var = m0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    HrReminderBean hrReminderBean = (HrReminderBean) g10;
                    HrReminderActivity hrReminderActivity = (HrReminderActivity) ((f7.n) m0Var.f7255a);
                    hrReminderActivity.getClass();
                    hrReminderActivity.S0().setOpen(hrReminderBean.isOpen());
                    hrReminderActivity.S0().setRemindValue(hrReminderBean.getRemindValue());
                    hrReminderActivity.R0();
                }
            }
        });
        l0 bleDataCallback = (l0) this.f7461c.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        ((XXBaseActivity) ((f7.n) this.f7255a)).V();
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 67);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "心率提醒获取命令");
        b3.g((byte) 67, new byte[]{2, 121, 16}, new boolean[0]);
    }

    public final void m(HrReminderBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        this.f7460b = data;
        boolean isOpen = data.isOpen();
        int remindValue = data.getRemindValue();
        if (r5.b.k().f18054c) {
            x5.c b3 = x5.c.b();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "心率提醒设置命令");
            char[] cArr = y5.b.f20001a;
            b3.g((byte) 66, new byte[]{2, 121, 0, (byte) ((isOpen ? 1 : 0) & 255), (byte) (remindValue & 255)}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) 66);
        }
        HrReminderBean hrReminderBean = this.f7460b;
        if (hrReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(hrReminderBean, HrReminderPresenter$saveDB$1$1.INSTANCE, new HrReminderPresenter$saveDB$1$2(this));
        }
    }
}
