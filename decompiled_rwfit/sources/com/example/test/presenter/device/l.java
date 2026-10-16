package com.example.test.presenter.device;

import com.example.blesdk.bean.function.BreatheBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.device.activity.BreatheSettingActivity;

/* loaded from: classes.dex */
public final class l extends d implements u5.g {

    /* renamed from: b, reason: collision with root package name */
    public final String f7454b;

    /* renamed from: c, reason: collision with root package name */
    public BreatheBean f7455c;

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f7456d;

    public l(BreatheSettingActivity breatheSettingActivity) {
        super(breatheSettingActivity);
        this.f7454b = "BreatheSettingPresenter";
        this.f7456d = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.BreatheSettingPresenter$breatheInfoCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final k invoke() {
                return new k(l.this);
            }
        });
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, this.f7454b, com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "获取失败 "));
        k(i3);
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        BreatheBean breatheBean = (BreatheBean) obj;
        if (breatheBean != null) {
            this.f7455c = breatheBean;
            com.example.baselibrary.preseneter.b.j(breatheBean, BreatheSettingPresenter$saveDB$1$1.INSTANCE, new BreatheSettingPresenter$saveDB$1$2(this, false));
            ((BreatheSettingActivity) ((f7.c) this.f7255a)).U0(breatheBean);
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d(this);
        com.google.android.gms.internal.mlkit_vision_common.p.d((k) this.f7456d.getValue());
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.BreatheSettingPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_breathe");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.BreatheSettingPresenter$initData$2

            public static final class a extends bc.a<BreatheBean> {
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
                    l lVar = l.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((BreatheSettingActivity) ((f7.c) lVar.f7255a)).U0((BreatheBean) g10);
                }
            }
        });
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = this;
        I0.K0(eVar);
        if (r5.b.k().f18054c) {
            x5.d.c().j((byte) 18, new byte[0]);
        } else {
            x5.b.I0().F0((byte) 18);
        }
    }
}
