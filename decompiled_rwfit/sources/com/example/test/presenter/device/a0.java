package com.example.test.presenter.device;

import android.util.Log;
import com.example.blesdk.bean.function.DialInfoBean;

/* loaded from: classes.dex */
public final class a0 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.DialMinePresenter$getLocalDialInfo$1
            @Override // oh.l
            public final DialInfoBean invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    return kVar.n();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.DialMinePresenter$getLocalDialInfo$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DialInfoBean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(DialInfoBean dialInfoBean) {
                if (dialInfoBean != null) {
                    com.example.test.ui.device.fragment.a aVar = (com.example.test.ui.device.fragment.a) ((f7.i) a0.this.f7255a);
                    aVar.getClass();
                    int dialType = dialInfoBean.getDialType();
                    int width = dialInfoBean.getWidth();
                    int height = dialInfoBean.getHeight();
                    StringBuilder s7 = com.google.android.gms.internal.mlkit_vision_barcode.l0.s(dialType, "onAttachDialInfo ", width, " width ", " height ");
                    s7.append(height);
                    Log.e("qob", s7.toString());
                    aVar.f7908d = dialInfoBean.getDialType();
                    a0 a0Var = (a0) aVar.X();
                    a0Var.getClass();
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    ((com.example.test.ui.device.fragment.a) ((f7.i) a0Var.f7255a)).k0(kVar != null ? kVar.h() : null);
                }
            }
        });
    }
}
