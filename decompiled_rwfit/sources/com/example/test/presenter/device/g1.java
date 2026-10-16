package com.example.test.presenter.device;

import com.example.blesdk.bean.function.BrightScreenBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.ScreenLightActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class g1 extends d implements v5.b {

    /* renamed from: b, reason: collision with root package name */
    public BrightScreenBean f7432b;

    @Override // u5.g
    public final void a(int i3) {
        ((XXBaseActivity) ((f7.y) this.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenLightPresenter", "errorCode = " + i3);
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        BrightScreenBean brightScreenBean = this.f7432b;
        if (brightScreenBean != null) {
            com.example.baselibrary.preseneter.b.j(brightScreenBean, new oh.l() { // from class: com.example.test.presenter.device.ScreenLightPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(BrightScreenBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_bright_screen");
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
            }, new oh.l() { // from class: com.example.test.presenter.device.ScreenLightPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.y) g1.this.f7255a)).b0();
                    if (j4 <= 0) {
                        ((ScreenLightActivity) ((f7.y) g1.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    } else {
                        ScreenLightActivity screenLightActivity = (ScreenLightActivity) ((f7.y) g1.this.f7255a);
                        screenLightActivity.getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                        screenLightActivity.onBackPressed();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        BrightScreenBean brightScreenBean = (BrightScreenBean) obj;
        if (brightScreenBean != null) {
            ((ScreenLightActivity) ((f7.y) this.f7255a)).U0(brightScreenBean);
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.ScreenLightPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_bright_screen");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.ScreenLightPresenter$initData$2

            public static final class a extends bc.a<BrightScreenBean> {
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
                    g1 g1Var = g1.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((ScreenLightActivity) ((f7.y) g1Var.f7255a)).U0((BrightScreenBean) g10);
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
                x5.d.c().j((byte) 10, new byte[0]);
                return;
            } else {
                x5.b.I0().F0((byte) 10);
                return;
            }
        }
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -30);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getBrightRCmdJL");
        b3.g((byte) -30, new byte[]{2, 12, 16}, new boolean[0]);
    }
}
