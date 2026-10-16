package com.example.test.presenter.device;

import com.example.blesdk.bean.function.BrightScreenTimeBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.ScreenLongActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class h1 extends d implements v5.d {

    /* renamed from: b, reason: collision with root package name */
    public BrightScreenTimeBean f7435b;

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenLongPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "亮屏时长错误，错误代码"));
        ((XXBaseActivity) ((f7.z) this.f7255a)).b0();
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        BrightScreenTimeBean brightScreenTimeBean = this.f7435b;
        if (brightScreenTimeBean != null) {
            com.example.baselibrary.preseneter.b.j(brightScreenTimeBean, new oh.l() { // from class: com.example.test.presenter.device.ScreenLongPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(BrightScreenTimeBean brightScreenTimeBean2) {
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_bright_time");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(brightScreenTimeBean2));
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
            }, new oh.l() { // from class: com.example.test.presenter.device.ScreenLongPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.z) h1.this.f7255a)).b0();
                    if (j4 <= 0) {
                        ((ScreenLongActivity) ((f7.z) h1.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    } else {
                        ScreenLongActivity screenLongActivity = (ScreenLongActivity) ((f7.z) h1.this.f7255a);
                        screenLongActivity.getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                        screenLongActivity.onBackPressed();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        BrightScreenTimeBean brightScreenTimeBean = (BrightScreenTimeBean) obj;
        if (brightScreenTimeBean != null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenLongPresenter", String.valueOf(brightScreenTimeBean));
            ((ScreenLongActivity) ((f7.z) this.f7255a)).T0(brightScreenTimeBean);
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.ScreenLongPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_bright_time");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.ScreenLongPresenter$initData$2

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
                    h1 h1Var = h1.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((ScreenLongActivity) ((f7.z) h1Var.f7255a)).T0((BrightScreenTimeBean) g10);
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        if (y5.d.f20005b) {
            com.google.android.gms.internal.mlkit_vision_common.p.g();
        } else if (r5.b.k().f18054c) {
            x5.d.c().j((byte) 11, new byte[0]);
        } else {
            x5.b.I0().F0((byte) 11);
        }
    }
}
