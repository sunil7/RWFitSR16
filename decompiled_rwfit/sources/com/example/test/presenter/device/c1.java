package com.example.test.presenter.device;

import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.model.MsgDataModel;
import java.util.List;

/* loaded from: classes.dex */
public final class c1 implements w5.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f7416a;

    public c1(d1 d1Var) {
        this.f7416a = d1Var;
    }

    @Override // w5.c
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "MessagePushPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "设置开关失败 "));
        d1 d1Var = this.f7416a;
        ((XXBaseActivity) ((f7.q) d1Var.f7255a)).b0();
        d1Var.k(i3);
    }

    @Override // w5.c
    public final void c() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "MessagePushPresenter", "设置开关成功");
        final d1 d1Var = this.f7416a;
        com.example.baselibrary.preseneter.b.j(d1Var.f7419c, new oh.l() { // from class: com.example.test.presenter.device.RingMessagePushPresenter$saveDB$1
            @Override // oh.l
            public final Long invoke(List<MsgDataModel> list) {
                DataSetting dataSetting = new DataSetting();
                dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                dataSetting.setDataKey("setting_message");
                dataSetting.setDataValue(com.example.baselibrary.utils.b.z(list));
                dataSetting.getDataValue();
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
        }, new oh.l() { // from class: com.example.test.presenter.device.RingMessagePushPresenter$saveDB$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return eh.g.f12633a;
            }

            public final void invoke(long j4) {
                ((XXBaseActivity) ((f7.q) d1.this.f7255a)).b0();
                if (j4 > 0) {
                    ((f7.q) d1.this.f7255a).a();
                } else {
                    ((f7.q) d1.this.f7255a).b();
                }
            }
        });
    }
}
