package com.example.test.presenter.sport;

import com.example.blesdk.bean.function.SportTargetBean;
import com.example.test.ui.sport.activity.SportCountDownActivity;
import f6.h2;

/* loaded from: classes.dex */
public final class a extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.sport.SportCountDownPresenter$getData$1
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
        }, new oh.l() { // from class: com.example.test.presenter.sport.SportCountDownPresenter$getData$2
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
                    SportCountDownActivity sportCountDownActivity = (SportCountDownActivity) ((i7.a) a.this.f7255a);
                    sportCountDownActivity.getClass();
                    sportCountDownActivity.R0().setCalorie(sportTargetBean.getCalorie());
                    sportCountDownActivity.R0().setDistance(sportTargetBean.getDistance());
                    sportCountDownActivity.R0().setTime(sportTargetBean.getTime());
                    sportCountDownActivity.R0().setVibrator(sportTargetBean.isVibrator());
                    sportCountDownActivity.R0().setScreenLight(sportTargetBean.isScreenLight());
                    sportCountDownActivity.R0().setAutoPause(sportTargetBean.isAutoPause());
                    if (sportTargetBean.isVibrator() == 1) {
                        ef.i.y().M(200L);
                    }
                    eh.b bVar = sportCountDownActivity.f7247z;
                    ((h2) bVar.getValue()).f12953b.a();
                    ((h2) bVar.getValue()).f12953b.setOnTimeDownListener(new com.example.test.utils.y(sportTargetBean, 11, sportCountDownActivity, false));
                }
            }
        });
    }
}
