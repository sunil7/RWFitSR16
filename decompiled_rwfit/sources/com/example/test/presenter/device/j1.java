package com.example.test.presenter.device;

import com.example.blesdk.bean.function.VaperPowerBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.VaperPowerActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class j1 extends d implements v5.j0 {

    /* renamed from: b, reason: collision with root package name */
    public VaperPowerBean f7441b;

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "VaperPowerPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "电子烟功率错误，错误代码"));
        ((XXBaseActivity) ((f7.a0) this.f7255a)).b0();
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        VaperPowerBean vaperPowerBean = this.f7441b;
        if (vaperPowerBean != null) {
            com.example.baselibrary.preseneter.b.j(vaperPowerBean, new oh.l() { // from class: com.example.test.presenter.device.VaperPowerPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(VaperPowerBean vaperPowerBean2) {
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_vaperpower_level");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(vaperPowerBean2));
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
            }, new oh.l() { // from class: com.example.test.presenter.device.VaperPowerPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.a0) j1.this.f7255a)).b0();
                    if (j4 <= 0) {
                        ((VaperPowerActivity) ((f7.a0) j1.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    } else {
                        VaperPowerActivity vaperPowerActivity = (VaperPowerActivity) ((f7.a0) j1.this.f7255a);
                        vaperPowerActivity.getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                        vaperPowerActivity.onBackPressed();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        VaperPowerBean vaperPowerBean = (VaperPowerBean) obj;
        if (vaperPowerBean != null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "VaperPowerPresenter", String.valueOf(vaperPowerBean));
            VaperPowerActivity vaperPowerActivity = (VaperPowerActivity) ((f7.a0) this.f7255a);
            vaperPowerActivity.getClass();
            vaperPowerActivity.E = vaperPowerBean;
            vaperPowerActivity.R0();
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.VaperPowerPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_vaperpower_level");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.VaperPowerPresenter$initData$2

            public static final class a extends bc.a<VaperPowerBean> {
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
                    j1 j1Var = j1.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    VaperPowerActivity vaperPowerActivity = (VaperPowerActivity) ((f7.a0) j1Var.f7255a);
                    vaperPowerActivity.getClass();
                    vaperPowerActivity.E = (VaperPowerBean) g10;
                    vaperPowerActivity.R0();
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -107);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getVaperPowerRCmdJL");
        b3.g((byte) -107, new byte[]{2, 97, 16}, new boolean[0]);
    }
}
