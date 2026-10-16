package com.example.test.presenter.mine;

import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.SwitchBean;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.mine.activity.PrivacySafeActivity;
import com.example.test.utils.w0;
import java.util.List;

/* loaded from: classes.dex */
public final class p extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k() {
        Object obj = (h7.i) this.f7255a;
        ((XXBaseActivity) obj).V();
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.mine.PrivacySafePresenter$getSwitchStatus$1
            @Override // oh.l
            public final List<SwitchBean> invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    return kVar.w();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.presenter.mine.PrivacySafePresenter$getSwitchStatus$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((List<? extends SwitchBean>) obj2);
                return eh.g.f12633a;
            }

            public final void invoke(List<? extends SwitchBean> list) {
                List<? extends SwitchBean> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                ((PrivacySafeActivity) ((h7.i) p.this.f7255a)).R0(list);
            }
        });
        rg.l<HttpModel<List<SwitchBean>>> switchParam = ((UserApi) c6.d.f3392c.f113a).getSwitchParam();
        kotlin.jvm.internal.e.e(switchParam, "getSwitchParam(...)");
        rg.l w8 = com.example.baselibrary.utils.b.w(switchParam);
        PrivacySafeActivity privacySafeActivity = (PrivacySafeActivity) obj;
        privacySafeActivity.getClass();
        w8.subscribe(new o(this, privacySafeActivity, w0.d(), 1));
    }
}
