package com.example.test.presenter.main;

import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.chart.chart.BoChartData;

/* loaded from: classes.dex */
public final class k extends com.example.baselibrary.preseneter.b implements v5.d0 {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7526b;

    /* renamed from: c, reason: collision with root package name */
    public DrinkReminderBean f7527c;

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f7528d;

    public k(g7.f fVar) {
        super(fVar);
        this.f7526b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.BloodOxygenPresenter$testHrCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final j invoke() {
                return new j(k.this);
            }
        });
        this.f7528d = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.BloodOxygenPresenter$boCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final i invoke() {
                return new i(k.this);
            }
        });
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "HrWatcherJlPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "errorCode = "));
        ((XXBaseActivity) ((g7.f) this.f7255a)).b0();
    }

    @Override // u5.g
    public final void c() {
        DrinkReminderBean drinkReminderBean = this.f7527c;
        if (drinkReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(drinkReminderBean, new oh.l() { // from class: com.example.test.presenter.main.BloodOxygenPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(DrinkReminderBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_bo_watcher");
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
            }, new oh.l() { // from class: com.example.test.presenter.main.BloodOxygenPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((g7.f) k.this.f7255a)).b0();
                    if (j4 > 0) {
                        ((g7.f) k.this.f7255a).a();
                    } else {
                        ((g7.f) k.this.f7255a).b();
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u5.g
    public final void e(Object obj) {
        DrinkReminderBean drinkReminderBean = (DrinkReminderBean) obj;
        g7.f fVar = (g7.f) this.f7255a;
        ((XXBaseActivity) fVar).b0();
        if (drinkReminderBean != null) {
            fVar.c(drinkReminderBean);
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d(this);
        com.google.android.gms.internal.mlkit_vision_common.p.d((j) this.f7526b.getValue());
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.BloodOxygenPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_bo_watcher");
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BloodOxygenPresenter$initData$2

            public static final class a extends bc.a<DrinkReminderBean> {
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
                    k kVar = k.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((g7.f) kVar.f7255a).c((DrinkReminderBean) g10);
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        ((XXBaseActivity) ((g7.f) this.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.k();
    }

    public final void l(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.BloodOxygenPresenter$getDayBoDetail$1
            @Override // oh.l
            public final BoChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return com.example.test.presenter.analysis.a.b(it);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BloodOxygenPresenter$getDayBoDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BoChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BoChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.f) k.this.f7255a).g0(it);
            }
        });
    }

    public final void m(byte b3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 31);
            return;
        }
        x5.c b10 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(b3, "getControlHealthDataCmdJL 9 "));
        b10.g((byte) 31, new byte[]{6, 9, 0, 9, 5, b3}, new boolean[0]);
    }
}
