package com.example.test.presenter.main;

import com.example.blesdk.bean.function.BrightVibrationBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.TRingVibrationActivity;

/* loaded from: classes.dex */
public final class v1 implements v5.k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f7577a;

    public v1(w1 w1Var) {
        this.f7577a = w1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        ((XXBaseActivity) ((g7.b0) this.f7577a.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", "VideoHidCallback errorCode " + i3);
    }

    @Override // u5.g
    public final void c() {
        final w1 w1Var = this.f7577a;
        BrightVibrationBean brightVibrationBean = w1Var.f7578b;
        if (brightVibrationBean != null) {
            com.example.baselibrary.preseneter.b.j(brightVibrationBean, new oh.l() { // from class: com.example.test.presenter.main.TRingVibrationPresenter$saveVibrationDB$1$1
                @Override // oh.l
                public final Long invoke(BrightVibrationBean brightVibrationBean2) {
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_vibration_level");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(brightVibrationBean2));
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
            }, new oh.l() { // from class: com.example.test.presenter.main.TRingVibrationPresenter$saveVibrationDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((g7.b0) w1.this.f7255a)).b0();
                    if (j4 > 0) {
                        ((TRingVibrationActivity) ((g7.b0) w1.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                    } else {
                        ((TRingVibrationActivity) ((g7.b0) w1.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        BrightVibrationBean brightVibrationBean = (BrightVibrationBean) obj;
        w1 w1Var = this.f7577a;
        ((XXBaseActivity) ((g7.b0) w1Var.f7255a)).b0();
        if (brightVibrationBean != null) {
            TRingVibrationActivity tRingVibrationActivity = (TRingVibrationActivity) ((g7.b0) w1Var.f7255a);
            tRingVibrationActivity.getClass();
            tRingVibrationActivity.S0().setLevel(brightVibrationBean.getLevel());
            tRingVibrationActivity.S0().setCount(brightVibrationBean.getCount());
            tRingVibrationActivity.R0();
        }
    }
}
