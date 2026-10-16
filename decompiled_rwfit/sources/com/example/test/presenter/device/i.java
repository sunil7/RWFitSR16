package com.example.test.presenter.device;

import com.example.blesdk.bean.function.BoReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.BoReminderActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class i extends d {

    /* renamed from: b, reason: collision with root package name */
    public BoReminderBean f7436b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7437c;

    public i(BoReminderActivity boReminderActivity) {
        super(boReminderActivity);
        this.f7437c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.BoReminderPresenter$boReminderCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final h invoke() {
                return new h(i.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        h hVar = (h) this.f7437c.getValue();
        if (hVar == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(hVar)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == hVar) {
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.BoReminderPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_bo_reminder");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.BoReminderPresenter$initData$2

            public static final class a extends bc.a<BoReminderBean> {
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
                    i iVar = i.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    BoReminderBean boReminderBean = (BoReminderBean) g10;
                    BoReminderActivity boReminderActivity = (BoReminderActivity) ((f7.b) iVar.f7255a);
                    boReminderActivity.getClass();
                    boReminderActivity.S0().setOpen(boReminderBean.isOpen());
                    boReminderActivity.S0().setRemindValue(boReminderBean.getRemindValue());
                    boReminderActivity.R0();
                }
            }
        });
        h bleDataCallback = (h) this.f7437c.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        ((XXBaseActivity) ((f7.b) this.f7255a)).V();
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 69);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "心率提醒获取命令");
        b3.g((byte) 69, new byte[]{2, 122, 16}, new boolean[0]);
    }

    public final void m(BoReminderBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        this.f7436b = data;
        boolean isOpen = data.isOpen();
        int remindValue = data.getRemindValue();
        if (r5.b.k().f18054c) {
            x5.c b3 = x5.c.b();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "心率提醒设置命令");
            char[] cArr = y5.b.f20001a;
            b3.g((byte) 68, new byte[]{2, 122, 0, (byte) ((isOpen ? 1 : 0) & 255), (byte) (remindValue & 255)}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) 68);
        }
        BoReminderBean boReminderBean = this.f7436b;
        if (boReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(boReminderBean, BoReminderPresenter$saveDB$1$1.INSTANCE, new BoReminderPresenter$saveDB$1$2(this));
        }
    }
}
