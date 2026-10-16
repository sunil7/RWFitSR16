package com.example.test.presenter.mine;

import android.content.Context;
import android.text.format.DateFormat;
import com.example.blesdk.bean.function.UnitBean;
import com.example.database.table.User;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.f2;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class q extends com.example.baselibrary.preseneter.b implements w5.c {

    /* renamed from: b, reason: collision with root package name */
    public User f7601b;

    @Override // w5.c
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SettingPresenter", l0.j(i3, "errorCode "));
    }

    @Override // w5.c
    public final void c() {
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

    public final void k(User user, int i3) {
        if (user != null) {
            this.f7601b = user;
            com.google.android.gms.internal.mlkit_vision_common.p.T(36, this);
            User user2 = this.f7601b;
            if (user2 != null) {
                com.example.baselibrary.preseneter.b.j(user2, new oh.l() { // from class: com.example.test.presenter.mine.SettingPresenter$saveDB$1$1
                    @Override // oh.l
                    public final User invoke(User it) {
                        kotlin.jvm.internal.e.f(it, "it");
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d5 = kVar != null ? kVar.d() : null;
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        if (kVar2 != null) {
                            kVar2.G(it);
                        }
                        return d5;
                    }
                }, new oh.l() { // from class: com.example.test.presenter.mine.SettingPresenter$saveDB$1$2
                    public final void invoke(User user3) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d5 = kVar != null ? kVar.d() : null;
                        if (d5 == null || user3 == null) {
                            return;
                        }
                        if (user3.getMeterUnit() != d5.getMeterUnit()) {
                            yh.d.b().e(new EventBusBeans.UnitEvent(0));
                        }
                        if (user3.getTempUnit() != d5.getTempUnit()) {
                            yh.d.b().e(new EventBusBeans.UnitEvent(1));
                        }
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((User) obj);
                        return eh.g.f12633a;
                    }
                });
            }
            if (y5.d.f20005b) {
                if (i3 == 5) {
                    com.google.android.gms.internal.mlkit_vision_common.p.w(user.getMeterUnit());
                    return;
                } else {
                    if (i3 != 6) {
                        return;
                    }
                    com.google.android.gms.internal.mlkit_vision_common.p.I(user.getTempUnit());
                    return;
                }
            }
            UnitBean unitBean = new UnitBean();
            Context f02 = ((h7.j) this.f7255a).f0();
            if (f02 != null) {
                unitBean.setTimeFont(!DateFormat.is24HourFormat(f02) ? 1 : 0);
            }
            unitBean.setLang(f2.b());
            unitBean.setMeasureUnit(user.getMeterUnit());
            unitBean.setTempUnit(user.getTempUnit());
            com.google.android.gms.internal.mlkit_vision_common.p.P(unitBean);
        }
    }
}
