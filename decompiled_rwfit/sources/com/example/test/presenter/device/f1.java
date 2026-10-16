package com.example.test.presenter.device;

import com.example.blesdk.bean.function.BrightScreenLedBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.ScreenLedLevelActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class f1 extends d implements v5.c {

    /* renamed from: b, reason: collision with root package name */
    public BrightScreenLedBean f7428b;

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenLedLightPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "亮屏等级错误，错误代码"));
        ((XXBaseActivity) ((f7.x) this.f7255a)).b0();
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        BrightScreenLedBean brightScreenLedBean = this.f7428b;
        if (brightScreenLedBean != null) {
            com.example.baselibrary.preseneter.b.j(brightScreenLedBean, new oh.l() { // from class: com.example.test.presenter.device.ScreenLedLightPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(BrightScreenLedBean brightScreenLedBean2) {
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_bright_led_level");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(brightScreenLedBean2));
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
            }, new oh.l() { // from class: com.example.test.presenter.device.ScreenLedLightPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.x) f1.this.f7255a)).b0();
                    if (j4 <= 0) {
                        ((ScreenLedLevelActivity) ((f7.x) f1.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    } else {
                        ScreenLedLevelActivity screenLedLevelActivity = (ScreenLedLevelActivity) ((f7.x) f1.this.f7255a);
                        screenLedLevelActivity.getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                        screenLedLevelActivity.onBackPressed();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        BrightScreenLedBean brightScreenLedBean = (BrightScreenLedBean) obj;
        if (brightScreenLedBean != null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenLedLightPresenter", String.valueOf(brightScreenLedBean));
            ScreenLedLevelActivity screenLedLevelActivity = (ScreenLedLevelActivity) ((f7.x) this.f7255a);
            screenLedLevelActivity.getClass();
            screenLedLevelActivity.S0().setOpen(brightScreenLedBean.isOpen());
            screenLedLevelActivity.S0().setLcdLevel(brightScreenLedBean.getLcdLevel());
            screenLedLevelActivity.R0();
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.ScreenLedLightPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_bright_led_level");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.ScreenLedLightPresenter$initData$2

            public static final class a extends bc.a<BrightScreenLedBean> {
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
                    f1 f1Var = f1.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    BrightScreenLedBean brightScreenLedBean = (BrightScreenLedBean) g10;
                    ScreenLedLevelActivity screenLedLevelActivity = (ScreenLedLevelActivity) ((f7.x) f1Var.f7255a);
                    screenLedLevelActivity.getClass();
                    screenLedLevelActivity.S0().setOpen(brightScreenLedBean.isOpen());
                    screenLedLevelActivity.S0().setLcdLevel(brightScreenLedBean.getLcdLevel());
                    screenLedLevelActivity.R0();
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        com.google.android.gms.internal.mlkit_vision_common.p.j();
    }
}
