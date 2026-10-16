package com.example.test.presenter.sport;

import com.example.blesdk.bean.function.SportTargetBean;
import com.example.test.ui.sport.activity.SportCountDownNewActivity;
import f6.h2;

/* loaded from: classes.dex */
public final class f extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.sport.SportNewCountDownPresenter$getData$1
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
        }, new oh.l() { // from class: com.example.test.presenter.sport.SportNewCountDownPresenter$getData$2
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
                    SportCountDownNewActivity sportCountDownNewActivity = (SportCountDownNewActivity) ((i7.c) f.this.f7255a);
                    sportCountDownNewActivity.getClass();
                    sportCountDownNewActivity.R0().setCalorie(sportTargetBean.getCalorie());
                    sportCountDownNewActivity.R0().setDistance(sportTargetBean.getDistance());
                    sportCountDownNewActivity.R0().setTime(sportTargetBean.getTime());
                    sportCountDownNewActivity.R0().setVibrator(sportTargetBean.isVibrator());
                    sportCountDownNewActivity.R0().setScreenLight(sportTargetBean.isScreenLight());
                    sportCountDownNewActivity.R0().setAutoPause(sportTargetBean.isAutoPause());
                    if (sportTargetBean.isVibrator() == 1) {
                        ef.i.y().M(200L);
                    }
                    eh.b bVar = sportCountDownNewActivity.f7247z;
                    ((h2) bVar.getValue()).f12953b.a();
                    ((h2) bVar.getValue()).f12953b.setOnTimeDownListener(new ef.i(11, sportTargetBean, sportCountDownNewActivity));
                }
            }
        });
    }
}
