package com.example.test.presenter.device;

import com.example.blesdk.bean.function.GameChildAppBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.GameWatchAppActivity;

/* loaded from: classes.dex */
public final class d0 implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f7417a;

    public d0(e0 e0Var) {
        this.f7417a = e0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "GameWatchAppPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "设置开关失败 "));
        e0 e0Var = this.f7417a;
        ((XXBaseActivity) ((f7.l) e0Var.f7255a)).b0();
        e0Var.k(i3);
    }

    @Override // u5.g
    public final void c() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "GameWatchAppPresenter", "设置开关成功");
        final e0 e0Var = this.f7417a;
        GameChildAppBean gameChildAppBean = e0Var.f7421b;
        if (gameChildAppBean != null) {
            com.example.baselibrary.preseneter.b.j(gameChildAppBean, new oh.l() { // from class: com.example.test.presenter.device.GameWatchAppPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(GameChildAppBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_child_game_app");
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
            }, new oh.l() { // from class: com.example.test.presenter.device.GameWatchAppPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.l) e0.this.f7255a)).b0();
                    if (j4 <= 0) {
                        ((GameWatchAppActivity) ((f7.l) e0.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    } else {
                        GameWatchAppActivity gameWatchAppActivity = (GameWatchAppActivity) ((f7.l) e0.this.f7255a);
                        gameWatchAppActivity.getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                        gameWatchAppActivity.onBackPressed();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        GameChildAppBean gameChildAppBean = (GameChildAppBean) obj;
        if (gameChildAppBean != null) {
            ((GameWatchAppActivity) ((f7.l) this.f7417a.f7255a)).S0(gameChildAppBean);
        }
    }
}
