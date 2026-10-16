package com.example.test.presenter.main;

import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.example.database.db.UserImpl;
import com.example.database.table.User;
import com.example.test.ui.main.activity.SplashSelectActivity;
import com.example.test.ui.testui.TRingDeviceScanActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class e1 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.SplashPresenter$getAppVersion$1
            {
                super(1);
            }

            @Override // oh.l
            public final com.example.test.utils.a invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                SplashSelectActivity splashSelectActivity = (SplashSelectActivity) ((g7.w) e1.this.f7255a);
                splashSelectActivity.getClass();
                return com.google.android.gms.internal.mlkit_vision_barcode.u1.a(splashSelectActivity);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SplashPresenter$getAppVersion$2
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((com.example.test.utils.a) obj);
                return eh.g.f12633a;
            }

            public final void invoke(com.example.test.utils.a aVar) {
                if (aVar != null) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "APPVersion", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("v", aVar.f8718a));
                }
            }
        });
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j(2, new oh.l() { // from class: com.example.test.presenter.main.SplashPresenter$pass$1
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final User invoke(int i3) {
                User user;
                com.example.test.utils.k a3 = y1.a();
                if (a3 != null) {
                    user = a3.d();
                    if (user == null || user.getPlatform() != 2) {
                        user = UserImpl.INSTANCE.queryVisitor();
                    }
                } else {
                    user = null;
                }
                if (user != null) {
                    com.example.test.utils.k a10 = y1.a();
                    if (a10 != null) {
                        a10.G(user);
                    }
                    com.example.test.utils.k a11 = y1.a();
                    if (a11 != null) {
                        a11.M("visitor", "user_login_token");
                    }
                    if (d6.a.f12304c == null) {
                        synchronized (d6.a.class) {
                            d6.a.f12304c = new d6.a();
                        }
                    }
                    d6.a aVar = d6.a.f12304c;
                    if (aVar != null) {
                        aVar.f12305a = i3;
                    }
                    com.example.test.service.e.h().m();
                    return user;
                }
                User user2 = new User();
                user2.setPlatform(i3);
                user2.setName("visitor");
                user2.setWeight(60.0d);
                user2.setStepsTarget(Const.I_GEO_MAX_TIME);
                user2.setHeight(170.0d);
                user2.setSex(1);
                long j4 = 1000;
                user2.setUserId("v" + (System.currentTimeMillis() / j4));
                user2.setAccount("visitor");
                Calendar calendar = Calendar.getInstance();
                calendar.set(1, 1990);
                calendar.set(2, 0);
                calendar.set(5, 1);
                user2.setBirthday(String.valueOf(calendar.getTimeInMillis() / j4));
                com.example.test.utils.k a12 = y1.a();
                if (a12 != null) {
                    a12.G(user2);
                }
                com.example.test.utils.k a13 = y1.a();
                if (a13 != null) {
                    a13.M("visitor", "user_login_token");
                }
                if (d6.a.f12304c == null) {
                    synchronized (d6.a.class) {
                        d6.a.f12304c = new d6.a();
                    }
                }
                d6.a aVar2 = d6.a.f12304c;
                if (aVar2 == null) {
                    return user2;
                }
                aVar2.f12305a = i3;
                return user2;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SplashPresenter$pass$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((User) obj);
                return eh.g.f12633a;
            }

            public final void invoke(User it) {
                kotlin.jvm.internal.e.f(it, "it");
                SplashSelectActivity splashSelectActivity = (SplashSelectActivity) ((g7.w) e1.this.f7255a);
                splashSelectActivity.getClass();
                com.example.test.service.e.h();
                Intent intent = new Intent(splashSelectActivity, (Class<?>) TRingDeviceScanActivity.class);
                intent.putExtra("update_type", 2);
                splashSelectActivity.startActivity(intent);
                splashSelectActivity.finish();
            }
        });
    }
}
