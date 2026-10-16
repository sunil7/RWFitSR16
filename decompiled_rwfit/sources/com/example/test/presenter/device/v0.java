package com.example.test.presenter.device;

import com.example.blesdk.bean.function.DNDModelBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.NoDisturbActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class v0 extends d implements v5.e {

    /* renamed from: b, reason: collision with root package name */
    public DNDModelBean f7487b;

    @Override // u5.g
    public final void a(int i3) {
        ((XXBaseActivity) ((f7.s) this.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "NoDisturbPresenter", "errorCode = " + i3);
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        DNDModelBean dNDModelBean = this.f7487b;
        if (dNDModelBean != null) {
            com.example.baselibrary.preseneter.b.j(dNDModelBean, new oh.l() { // from class: com.example.test.presenter.device.NoDisturbPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(DNDModelBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_dnd");
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
            }, new oh.l() { // from class: com.example.test.presenter.device.NoDisturbPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.s) v0.this.f7255a)).b0();
                    if (j4 <= 0) {
                        ((NoDisturbActivity) ((f7.s) v0.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    } else {
                        NoDisturbActivity noDisturbActivity = (NoDisturbActivity) ((f7.s) v0.this.f7255a);
                        noDisturbActivity.getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                        noDisturbActivity.onBackPressed();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        DNDModelBean dNDModelBean = (DNDModelBean) obj;
        if (dNDModelBean != null) {
            ((NoDisturbActivity) ((f7.s) this.f7255a)).U0(dNDModelBean);
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == this) {
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.NoDisturbPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_dnd");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.NoDisturbPresenter$initData$2

            public static final class a extends bc.a<DNDModelBean> {
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
                    v0 v0Var = v0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((NoDisturbActivity) ((f7.s) v0Var.f7255a)).U0((DNDModelBean) g10);
                }
            }
        });
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = this;
        I0.K0(eVar);
        if (!y5.d.f20005b) {
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) 13, new byte[0]);
                return;
            } else {
                x5.b.I0().F0((byte) 13);
                return;
            }
        }
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -26);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getDndRCmdJL");
        b3.g((byte) -26, new byte[]{2, 10, 16}, new boolean[0]);
    }
}
