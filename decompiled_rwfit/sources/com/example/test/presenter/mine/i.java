package com.example.test.presenter.mine;

import com.example.blesdk.bean.function.BtNameBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.mine.activity.InputActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import f6.o0;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class i extends com.example.baselibrary.preseneter.b implements u5.g {

    /* renamed from: b, reason: collision with root package name */
    public BtNameBean f7593b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f7594c;

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "InputPresenter", l0.j(i3, "设置名字错误，错误代码"));
        ((XXBaseActivity) ((h7.e) this.f7255a)).b0();
    }

    @Override // u5.g
    public final void c() {
        BtNameBean btNameBean = this.f7593b;
        if (btNameBean != null) {
            com.example.baselibrary.preseneter.b.j(btNameBean, new oh.l() { // from class: com.example.test.presenter.mine.InputPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(BtNameBean btNameBean2) {
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_bt_name");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(btNameBean2));
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
            }, new oh.l() { // from class: com.example.test.presenter.mine.InputPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((h7.e) i.this.f7255a)).b0();
                    if (j4 <= 0) {
                        ((InputActivity) ((h7.e) i.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    } else {
                        InputActivity inputActivity = (InputActivity) ((h7.e) i.this.f7255a);
                        inputActivity.getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                        inputActivity.onBackPressed();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        BtNameBean btNameBean = (BtNameBean) obj;
        if (btNameBean != null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "InputPresenter", String.valueOf(btNameBean));
            InputActivity inputActivity = (InputActivity) ((h7.e) this.f7255a);
            inputActivity.getClass();
            ((o0) inputActivity.f7247z.getValue()).f13161b.setText(btNameBean.getBtName());
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        Integer num = this.f7594c;
        if (num != null && num.intValue() == 3) {
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
    }

    public final void k() {
        this.f7594c = 3;
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.mine.InputPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_bt_name");
            }
        }, new oh.l() { // from class: com.example.test.presenter.mine.InputPresenter$initData$2

            public static final class a extends bc.a<BtNameBean> {
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
                    i iVar = i.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    InputActivity inputActivity = (InputActivity) ((h7.e) iVar.f7255a);
                    inputActivity.getClass();
                    ((o0) inputActivity.f7247z.getValue()).f13161b.setText(((BtNameBean) g10).getBtName());
                }
            }
        });
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = this;
        I0.K0(eVar);
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 23);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getBtNameRCmdJL");
        b3.g((byte) 23, new byte[]{2, 101, 16}, new boolean[0]);
    }
}
