package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.function.BrightScreenLedBean;
import com.example.blesdk.bean.function.FirmVersionBean;
import com.example.blesdk.bean.function.PowerBean;
import com.example.blesdk.bean.function.VideoHidBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.testui.TRingDeviceFragment;

/* loaded from: classes.dex */
public final class r1 extends com.example.baselibrary.preseneter.b implements v5.c {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7554b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7555c;

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f7556d;
    public final eh.b e;

    /* renamed from: f, reason: collision with root package name */
    public final eh.b f7557f;

    /* renamed from: g, reason: collision with root package name */
    public int f7558g;

    /* renamed from: h, reason: collision with root package name */
    public BrightScreenLedBean f7559h;

    /* renamed from: i, reason: collision with root package name */
    public VideoHidBean f7560i;

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f7561j;

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f7562k;

    /* renamed from: l, reason: collision with root package name */
    public final eh.b f7563l;

    /* renamed from: m, reason: collision with root package name */
    public final eh.b f7564m;

    public r1(TRingDeviceFragment tRingDeviceFragment) {
        super(tRingDeviceFragment);
        this.f7554b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.TRingDevicePresenter$firmwareCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final m1 invoke() {
                return new m1(r1.this);
            }
        });
        this.f7555c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.TRingDevicePresenter$powerCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final o1 invoke() {
                return new o1(r1.this);
            }
        });
        this.f7556d = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.TRingDevicePresenter$findDeviceControlCallback$2
            @Override // oh.a
            public final l1 invoke() {
                return new l1();
            }
        });
        this.e = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.TRingDevicePresenter$deviceControlCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final j1 invoke() {
                return new j1(r1.this);
            }
        });
        this.f7557f = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.TRingDevicePresenter$deviceUnbindControlCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final k1 invoke() {
                return new k1(r1.this);
            }
        });
        this.f7561j = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.TRingDevicePresenter$vibrationCountCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final p1 invoke() {
                return new p1(r1.this);
            }
        });
        this.f7562k = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.TRingDevicePresenter$VideoHidCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final i1 invoke() {
                return new i1(r1.this);
            }
        });
        this.f7563l = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.TRingDevicePresenter$wearHandCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final q1 invoke() {
                return new q1(r1.this);
            }
        });
        this.f7564m = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.TRingDevicePresenter$muslimCountSwitchCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final n1 invoke() {
                return new n1(r1.this);
            }
        });
    }

    @Override // u5.g
    public final void a(int i3) {
        r5.a.h(i3, "亮屏等级错误，错误代码", "TRingDevicePresenter");
        ((XXBaseFragment) ((g7.z) this.f7255a)).b0();
    }

    @Override // u5.g
    public final void c() {
        Log.e("TRingDevicePresenter", "onSuccess");
        BrightScreenLedBean brightScreenLedBean = this.f7559h;
        if (brightScreenLedBean != null) {
            com.example.baselibrary.preseneter.b.j(brightScreenLedBean, new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$saveDB$1$1
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
            }, new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseFragment) ((g7.z) r1.this.f7255a)).b0();
                    if (j4 > 0) {
                        ((TRingDeviceFragment) ((g7.z) r1.this.f7255a)).getClass();
                        Log.d("tong", " onSaveDataSuccess");
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                    } else {
                        ((TRingDeviceFragment) ((g7.z) r1.this.f7255a)).getClass();
                        Log.d("tong", " onSaveDataFail");
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        BrightScreenLedBean brightScreenLedBean = (BrightScreenLedBean) obj;
        if (brightScreenLedBean != null) {
            Log.e("TRingDevicePresenter", String.valueOf(brightScreenLedBean));
            ((TRingDeviceFragment) ((g7.z) this.f7255a)).H0(brightScreenLedBean);
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d((m1) this.f7554b.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((o1) this.f7555c.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((l1) this.f7556d.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((j1) this.e.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((k1) this.f7557f.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d(this);
        com.google.android.gms.internal.mlkit_vision_common.p.d((q1) this.f7563l.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((i1) this.f7562k.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((p1) this.f7561j.getValue());
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$getLocalPower$1
            @Override // oh.l
            public final PowerBean invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    return kVar.k();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$getLocalPower$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PowerBean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(PowerBean powerBean) {
                if (powerBean != null) {
                    ((TRingDeviceFragment) ((g7.z) r1.this.f7255a)).G0(powerBean);
                }
            }
        });
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$getLocalVersion$1
            @Override // oh.l
            public final String invoke(String it) {
                Devices c9;
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar == null || (c9 = kVar.c()) == null) {
                    return null;
                }
                return c9.getDeviceVer();
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$getLocalVersion$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return eh.g.f12633a;
            }

            public final void invoke(String str) {
                if (str != null) {
                    r1 r1Var = r1.this;
                    FirmVersionBean firmVersionBean = new FirmVersionBean();
                    firmVersionBean.setDeviceNo(str);
                    ((g7.z) r1Var.f7255a).onAttachFirmware(firmVersionBean);
                }
            }
        });
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$initData$1
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
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$initData$2

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
                    r1 r1Var = r1.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((TRingDeviceFragment) ((g7.z) r1Var.f7255a)).H0((BrightScreenLedBean) g10);
                }
            }
        });
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$initVCData$1
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
                return settingImpl.getData(userId, str, "setting_video_hid");
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$initVCData$2

            public static final class a extends bc.a<VideoHidBean> {
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
                    r1 r1Var = r1.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((TRingDeviceFragment) ((g7.z) r1Var.f7255a)).K0((VideoHidBean) g10);
                }
            }
        });
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.E()) : null;
        if (valueOf != null) {
            ((TRingDeviceFragment) ((g7.z) this.f7255a)).L0(valueOf.intValue());
        }
        l();
    }

    public final void l() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.z()) : null;
        if (valueOf != null) {
            ((TRingDeviceFragment) ((g7.z) this.f7255a)).I0(valueOf.intValue());
        }
    }

    public final void m(User user, int i3) {
        if (user != null) {
            com.example.baselibrary.preseneter.b.j(user, new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$saveUserInfoDB$1$1
                @Override // oh.l
                public final User invoke(User it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    User d5 = kVar != null ? kVar.d() : null;
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    if (kVar2 != null) {
                        kVar2.G(it);
                    }
                    return d5;
                }
            }, new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$saveUserInfoDB$1$2
                public final void invoke(User user2) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    User d5 = kVar != null ? kVar.d() : null;
                    if (d5 == null || user2 == null) {
                        return;
                    }
                    if (user2.getMeterUnit() != d5.getMeterUnit()) {
                        yh.d.b().e(new EventBusBeans.UnitEvent(0));
                    }
                    if (user2.getTempUnit() != d5.getTempUnit()) {
                        yh.d.b().e(new EventBusBeans.UnitEvent(1));
                    }
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((User) obj);
                    return eh.g.f12633a;
                }
            });
        }
    }

    public final void n(boolean z5) {
        q1 bleDataCallback = (q1) this.f7563l.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.d0(z5 ? 1 : 0);
        }
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 29);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", r5.a.d("getRingWearHandWCmdJL ", z5));
        b3.g((byte) 29, new byte[]{2, 104, 0, z5 ? (byte) 1 : (byte) 0}, new boolean[0]);
    }

    public final void o() {
        ((XXBaseFragment) ((g7.z) this.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.U((k1) this.f7557f.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.X();
        ((XXBaseFragment) ((g7.z) this.f7255a)).b0();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.f0();
        }
        ((TRingDeviceFragment) ((g7.z) this.f7255a)).J0();
        com.example.test.service.e.h().q();
    }
}
