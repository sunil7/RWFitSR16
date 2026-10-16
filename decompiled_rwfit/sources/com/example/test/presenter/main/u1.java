package com.example.test.presenter.main;

import com.example.blesdk.bean.function.BrightScreenTimeBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.TRingSleepModeActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class u1 extends com.example.test.presenter.device.d implements v5.d {

    /* renamed from: b, reason: collision with root package name */
    public BrightScreenTimeBean f7573b;

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DrinkPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "errorCode = "));
        ((XXBaseActivity) ((g7.a0) this.f7255a)).b0();
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        BrightScreenTimeBean brightScreenTimeBean = this.f7573b;
        if (brightScreenTimeBean != null) {
            com.example.baselibrary.preseneter.b.j(brightScreenTimeBean, new oh.l() { // from class: com.example.test.presenter.main.TRingSleepModePresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(BrightScreenTimeBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_sleep_mode");
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
            }, new oh.l() { // from class: com.example.test.presenter.main.TRingSleepModePresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((g7.a0) u1.this.f7255a)).b0();
                    if (j4 <= 0) {
                        ((TRingSleepModeActivity) ((g7.a0) u1.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    } else {
                        TRingSleepModeActivity tRingSleepModeActivity = (TRingSleepModeActivity) ((g7.a0) u1.this.f7255a);
                        tRingSleepModeActivity.getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                        tRingSleepModeActivity.onBackPressed();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        BrightScreenTimeBean brightScreenTimeBean = (BrightScreenTimeBean) obj;
        Object obj2 = (g7.a0) this.f7255a;
        ((XXBaseActivity) obj2).b0();
        if (brightScreenTimeBean != null) {
            ((TRingSleepModeActivity) obj2).U0(brightScreenTimeBean);
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.TRingSleepModePresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_sleep_mode");
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingSleepModePresenter$initData$2

            public static final class a extends bc.a<BrightScreenTimeBean> {
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
                    u1 u1Var = u1.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((TRingSleepModeActivity) ((g7.a0) u1Var.f7255a)).U0((BrightScreenTimeBean) g10);
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        ((XXBaseActivity) ((g7.a0) this.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.g();
    }
}
