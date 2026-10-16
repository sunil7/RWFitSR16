package com.example.test.presenter.main;

import com.example.blesdk.bean.function.BrightVibrationBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.TRingVibrationActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class w1 extends com.example.test.presenter.device.d {

    /* renamed from: b, reason: collision with root package name */
    public BrightVibrationBean f7578b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7579c;

    public w1(TRingVibrationActivity tRingVibrationActivity) {
        super(tRingVibrationActivity);
        this.f7579c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.TRingVibrationPresenter$vibrationCountCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final v1 invoke() {
                return new v1(w1.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        v1 v1Var = (v1) this.f7579c.getValue();
        if (v1Var == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(v1Var)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == v1Var) {
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.TRingVibrationPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_vibration_level");
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingVibrationPresenter$initData$2

            public static final class a extends bc.a<BrightVibrationBean> {
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
                    w1 w1Var = w1.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    BrightVibrationBean brightVibrationBean = (BrightVibrationBean) g10;
                    TRingVibrationActivity tRingVibrationActivity = (TRingVibrationActivity) ((g7.b0) w1Var.f7255a);
                    tRingVibrationActivity.getClass();
                    tRingVibrationActivity.S0().setLevel(brightVibrationBean.getLevel());
                    tRingVibrationActivity.S0().setCount(brightVibrationBean.getCount());
                    tRingVibrationActivity.R0();
                }
            }
        });
        ((XXBaseActivity) ((g7.b0) this.f7255a)).V();
        v1 bleDataCallback = (v1) this.f7579c.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -28);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getVibrationCountCmdJL");
        b3.g((byte) -28, new byte[]{2, 11, 16}, new boolean[0]);
    }

    public final void m(BrightVibrationBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        v1 bleDataCallback = (v1) this.f7579c.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        this.f7578b = data;
        ((XXBaseActivity) ((g7.b0) this.f7255a)).V();
        int level = data.getLevel();
        int count = data.getCount();
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -27);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(count, "getVibrationCountCmdJL "));
        char[] cArr = y5.b.f20001a;
        b3.g((byte) -27, new byte[]{2, 11, 0, (byte) (level & 255), (byte) (count & 255)}, new boolean[0]);
    }
}
