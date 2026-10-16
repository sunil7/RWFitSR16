package com.example.test.presenter.device;

import com.example.blesdk.bean.function.GameChildAppBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.device.activity.GameWatchAppActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class e0 extends d {

    /* renamed from: b, reason: collision with root package name */
    public GameChildAppBean f7421b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7422c;

    public e0(GameWatchAppActivity gameWatchAppActivity) {
        super(gameWatchAppActivity);
        this.f7422c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.GameWatchAppPresenter$childGameAppCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final d0 invoke() {
                return new d0(e0.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        d0 d0Var = (d0) this.f7422c.getValue();
        if (d0Var == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(d0Var)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == d0Var) {
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.GameWatchAppPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_child_game_app");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.GameWatchAppPresenter$initData$2

            public static final class a extends bc.a<GameChildAppBean> {
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
                    e0 e0Var = e0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((GameWatchAppActivity) ((f7.l) e0Var.f7255a)).S0((GameChildAppBean) g10);
                }
            }
        });
        d0 bleDataCallback = (d0) this.f7422c.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 41);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getChildAppRCmdJL");
        b3.g((byte) 41, new byte[]{2, 109, 16}, new boolean[0]);
    }
}
