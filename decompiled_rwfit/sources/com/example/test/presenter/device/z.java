package com.example.test.presenter.device;

import com.example.blesdk.bean.function.DialInfoBean;
import com.example.database.table.Devices;
import com.example.network.api.DeviceApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.DialPageBean;
import com.example.test.ui.device.activity.DialListActivity;
import com.example.test.ui.device.adapter.DialListAdapter;
import com.example.test.ui.device.model.DialModel;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class z extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(int i3, int i10, int i11) {
        Devices c9;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (c9 = kVar.c()) == null) {
            return;
        }
        c6.b bVar = c6.b.f3390c;
        String macAddress = c9.getMacAddress();
        kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
        bVar.getClass();
        rg.l<HttpModel<DialPageBean>> dialPage = ((DeviceApi) bVar.f113a).getDialPage(i3, macAddress, i10, i11);
        kotlin.jvm.internal.e.e(dialPage, "getDialPage(...)");
        rg.l w8 = com.example.baselibrary.utils.b.w(dialPage);
        DialListActivity dialListActivity = (DialListActivity) ((f7.h) this.f7255a);
        dialListActivity.getClass();
        w8.subscribe(new y(this, dialListActivity, com.example.test.utils.w0.d(), 0));
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.DialListPresenter$getLocalDialInfo$1
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
        }, new oh.l() { // from class: com.example.test.presenter.device.DialListPresenter$getLocalDialInfo$2
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
                    DialListActivity dialListActivity = (DialListActivity) ((f7.h) z.this.f7255a);
                    dialListActivity.getClass();
                    dialListActivity.E = dialInfoBean;
                    Iterator it = dialListActivity.R0().iterator();
                    while (it.hasNext()) {
                        ((DialModel) it.next()).setDialInfoBean(dialInfoBean);
                    }
                    ((DialListAdapter) dialListActivity.K.getValue()).notifyItemRangeChanged(0, dialListActivity.R0().size());
                }
            }
        });
    }
}
