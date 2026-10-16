package com.example.test.presenter.device;

import android.util.Log;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.HealthWatcherActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;

/* loaded from: classes.dex */
public final class k0 extends d implements v5.g0 {

    /* renamed from: b, reason: collision with root package name */
    public DrinkReminderBean f7443b;

    /* renamed from: c, reason: collision with root package name */
    public DrinkReminderBean f7444c;

    /* renamed from: d, reason: collision with root package name */
    public DrinkReminderBean f7445d;
    public DrinkReminderBean e;

    /* renamed from: f, reason: collision with root package name */
    public DrinkReminderBean f7446f;

    /* renamed from: g, reason: collision with root package name */
    public DrinkReminderBean f7447g;

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f7448h;

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f7449i;

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f7450j;

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f7451k;

    /* renamed from: l, reason: collision with root package name */
    public final eh.b f7452l;

    public k0(HealthWatcherActivity healthWatcherActivity) {
        super(healthWatcherActivity);
        this.f7448h = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$ooDataCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final i0 invoke() {
                return new i0(k0.this);
            }
        });
        this.f7449i = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$hrvDataCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final h0 invoke() {
                return new h0(k0.this);
            }
        });
        this.f7450j = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$stressDataCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final j0 invoke() {
                return new j0(k0.this);
            }
        });
        this.f7451k = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$bloodsugarDataCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final g0 invoke() {
                return new g0(k0.this);
            }
        });
        this.f7452l = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$bloodPressureDataCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final f0 invoke() {
                return new f0(k0.this);
            }
        });
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "HealthWatcherPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "errorCode = "));
        ((XXBaseActivity) ((f7.m) this.f7255a)).b0();
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        ((XXBaseActivity) ((f7.m) this.f7255a)).b0();
        DrinkReminderBean drinkReminderBean = this.f7443b;
        if (drinkReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(drinkReminderBean, new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(DrinkReminderBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_hr_watcher");
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
            }, new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.m) k0.this.f7255a)).b0();
                    if (j4 > 0) {
                        ((HealthWatcherActivity) ((f7.m) k0.this.f7255a)).a1();
                    } else {
                        ((HealthWatcherActivity) ((f7.m) k0.this.f7255a)).Z0();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        DrinkReminderBean drinkReminderBean = (DrinkReminderBean) obj;
        Log.e("qob", "onResult " + drinkReminderBean);
        if (drinkReminderBean != null) {
            ((HealthWatcherActivity) ((f7.m) this.f7255a)).Y0(drinkReminderBean, 0);
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d(this);
        com.google.android.gms.internal.mlkit_vision_common.p.d((i0) this.f7448h.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((h0) this.f7449i.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((j0) this.f7450j.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((g0) this.f7451k.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((f0) this.f7452l.getValue());
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_hr_watcher");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initData$2

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
                    k0 k0Var = k0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((HealthWatcherActivity) ((f7.m) k0Var.f7255a)).Y0((DrinkReminderBean) g10, 0);
                }
            }
        });
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initOOData$1
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
        }, new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initOOData$2

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
                    k0 k0Var = k0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((HealthWatcherActivity) ((f7.m) k0Var.f7255a)).Y0((DrinkReminderBean) g10, 1);
                }
            }
        });
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initHrvData$1
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
                return settingImpl.getData(userId, str, "setting_hrv_watcher");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initHrvData$2

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
                    k0 k0Var = k0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((HealthWatcherActivity) ((f7.m) k0Var.f7255a)).Y0((DrinkReminderBean) g10, 2);
                }
            }
        });
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initStressData$1
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
                return settingImpl.getData(userId, str, "setting_stress_watcher");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initStressData$2

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
                    k0 k0Var = k0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((HealthWatcherActivity) ((f7.m) k0Var.f7255a)).Y0((DrinkReminderBean) g10, 3);
                }
            }
        });
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initBloodSugarData$1
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
                return settingImpl.getData(userId, str, "setting_bloodsugar_watcher");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initBloodSugarData$2

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
                    k0 k0Var = k0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((HealthWatcherActivity) ((f7.m) k0Var.f7255a)).Y0((DrinkReminderBean) g10, 4);
                }
            }
        });
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initBpData$1
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
                return settingImpl.getData(userId, str, "setting_bloodpressure_watcher");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.HealthWatcherPresenter$initBpData$2

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
                    k0 k0Var = k0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((HealthWatcherActivity) ((f7.m) k0Var.f7255a)).Y0((DrinkReminderBean) g10, 5);
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        com.google.android.gms.internal.mlkit_vision_common.p.U((i0) this.f7448h.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.U((h0) this.f7449i.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.U((j0) this.f7450j.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.U((g0) this.f7451k.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.U((f0) this.f7452l.getValue());
        ((XXBaseActivity) ((f7.m) this.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.o();
        com.google.android.gms.internal.mlkit_vision_common.p.k();
        com.google.android.gms.internal.mlkit_vision_common.p.n();
        Object obj = com.example.test.utils.m.f8734b;
        if (d2.a().d()) {
            com.google.android.gms.internal.mlkit_vision_common.p.p();
        }
        if (d2.a().b()) {
            com.google.android.gms.internal.mlkit_vision_common.p.m();
        }
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (supportMenuBean != null ? supportMenuBean.isBloodPress() : true) {
            com.google.android.gms.internal.mlkit_vision_common.p.l();
        }
    }
}
