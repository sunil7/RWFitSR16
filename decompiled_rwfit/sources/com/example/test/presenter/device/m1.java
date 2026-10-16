package com.example.test.presenter.device;

import android.util.Log;
import com.example.blesdk.bean.function.JLWomenHealthBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class m1 extends d implements u5.g {

    /* renamed from: b, reason: collision with root package name */
    public JLWomenHealthBean f7462b;

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WomenHealthPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "生理周期错误，errorCode = "));
        ((XXBaseActivity) ((f7.c0) this.f7255a)).b0();
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WomenHealthPresenter", "设置生理周期成功");
        com.example.baselibrary.preseneter.b.j(this.f7462b, new oh.l() { // from class: com.example.test.presenter.device.WomenHealthJLPresenter$saveDB$1
            @Override // oh.l
            public final Long invoke(JLWomenHealthBean jLWomenHealthBean) {
                DataSetting dataSetting = new DataSetting();
                dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                dataSetting.setDataKey("setting_women_health");
                dataSetting.setDataValue(com.example.baselibrary.utils.b.z(jLWomenHealthBean));
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
        }, new oh.l() { // from class: com.example.test.presenter.device.WomenHealthJLPresenter$saveDB$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return eh.g.f12633a;
            }

            public final void invoke(long j4) {
                if (j4 > 0) {
                    ((f7.c0) m1.this.f7255a).a();
                } else {
                    ((f7.c0) m1.this.f7255a).b();
                }
            }
        });
        ((XXBaseActivity) ((f7.c0) this.f7255a)).b0();
    }

    @Override // u5.g
    public final void e(Object obj) {
        JLWomenHealthBean jLWomenHealthBean = (JLWomenHealthBean) obj;
        Log.e("qob", "onResult " + (jLWomenHealthBean != null ? Long.valueOf(jLWomenHealthBean.getLastDays()) : null));
        if (jLWomenHealthBean != null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WomenHealthPresenter", "获取设置 " + jLWomenHealthBean);
            com.example.baselibrary.preseneter.b.j(jLWomenHealthBean, new oh.l() { // from class: com.example.test.presenter.device.WomenHealthJLPresenter$onResult$1$1
                @Override // oh.l
                public final Long invoke(JLWomenHealthBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_women_health");
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
            }, new oh.l() { // from class: com.example.test.presenter.device.WomenHealthJLPresenter$onResult$1$2
                public final void invoke(long j4) {
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Number) obj2).longValue());
                    return eh.g.f12633a;
                }
            });
            ((f7.c0) this.f7255a).N(jLWomenHealthBean);
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.WomenHealthJLPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_women_health");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.WomenHealthJLPresenter$initData$2

            public static final class a extends bc.a<JLWomenHealthBean> {
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
                    m1 m1Var = m1.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((f7.c0) m1Var.f7255a).N((JLWomenHealthBean) g10);
                }
            }
        });
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = this;
        I0.K0(eVar);
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -97);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getWomenDataRCmdJL");
        b3.g((byte) -97, new byte[]{2, 26, 16}, new boolean[0]);
    }
}
