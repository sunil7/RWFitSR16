package com.example.test.presenter.sport;

import com.example.blesdk.bean.function.SportTargetBean;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.sport.activity.SportSettingActivity;
import f6.g2;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class y extends com.example.baselibrary.preseneter.b {

    /* renamed from: b, reason: collision with root package name */
    public final String f7637b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7638c;

    public y(SportSettingActivity sportSettingActivity) {
        super(sportSettingActivity);
        this.f7637b = "SportSettingPresenter";
        this.f7638c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.sport.SportSettingPresenter$settingCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final x invoke() {
                return new x(y.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        x xVar = (x) this.f7638c.getValue();
        if (xVar == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(xVar)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == xVar) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.sport.SportSettingPresenter$getData$1
            @Override // oh.l
            public final SportTargetBean invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    return kVar.B();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.presenter.sport.SportSettingPresenter$getData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SportTargetBean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SportTargetBean sportTargetBean) {
                if (sportTargetBean != null) {
                    SportSettingActivity sportSettingActivity = (SportSettingActivity) ((i7.i) y.this.f7255a);
                    sportSettingActivity.getClass();
                    sportSettingActivity.S0().setCalorie(sportTargetBean.getCalorie());
                    sportSettingActivity.S0().setDistance(sportTargetBean.getDistance());
                    sportSettingActivity.S0().setTime(sportTargetBean.getTime());
                    sportSettingActivity.S0().setVibrator(sportTargetBean.isVibrator());
                    sportSettingActivity.S0().setScreenLight(sportTargetBean.isScreenLight());
                    sportSettingActivity.S0().setAutoPause(sportTargetBean.isAutoPause());
                    eh.b bVar = sportSettingActivity.f7247z;
                    ((g2) bVar.getValue()).f12922g.setItemOpen(sportTargetBean.isVibrator() == 1);
                    ((g2) bVar.getValue()).e.setItemOpen(sportTargetBean.isScreenLight() == 1);
                    ((g2) bVar.getValue()).f12918b.setItemOpen(sportTargetBean.isAutoPause() == 1);
                    sportSettingActivity.R0();
                }
            }
        });
    }

    public final void l(final SportTargetBean sportTargetBean) {
        kotlin.jvm.internal.e.f(sportTargetBean, "sportTargetBean");
        com.example.baselibrary.preseneter.b.j(sportTargetBean, new oh.l() { // from class: com.example.test.presenter.sport.SportSettingPresenter$save$1
            {
                super(1);
            }

            @Override // oh.l
            public final eh.g invoke(SportTargetBean it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar == null) {
                    return null;
                }
                SportTargetBean sportTarget = SportTargetBean.this;
                kotlin.jvm.internal.e.f(sportTarget, "sportTarget");
                User d5 = kVar.d();
                if (d5 != null) {
                    kVar.M(sportTarget, d5.getUserId() + "setting_sport_target");
                }
                return eh.g.f12633a;
            }
        }, new oh.l() { // from class: com.example.test.presenter.sport.SportSettingPresenter$save$2
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((eh.g) obj);
                return eh.g.f12633a;
            }

            public final void invoke(eh.g gVar) {
            }
        });
        if (!y5.d.f20005b) {
            com.google.android.gms.internal.mlkit_vision_common.p.T(48, (x) this.f7638c.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.E(sportTargetBean);
        } else {
            SportSettingActivity sportSettingActivity = (SportSettingActivity) ((i7.i) this.f7255a);
            sportSettingActivity.w0(R$string.str_save_success);
            sportSettingActivity.onBackPressed();
        }
    }
}
