package com.example.test.presenter.main;

import com.example.blesdk.bean.function.DialInfoBean;
import com.example.test.ui.main.fragment.DeviceFragment;
import com.example.test.ui.model.EventBusBeans;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class z implements v5.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f7584a;

    public z(h0 h0Var) {
        this.f7584a = h0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "dialInfoCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        DialInfoBean dialInfoBean = (DialInfoBean) obj;
        if (dialInfoBean != null) {
            ((DeviceFragment) ((g7.k) this.f7584a.f7255a)).n0(dialInfoBean);
            com.example.baselibrary.utils.b.x(dialInfoBean, new oh.l() { // from class: com.example.test.presenter.main.DevicePresenter$dialInfoCallback$2$1$onResult$1$1
                @Override // oh.l
                public final DialInfoBean invoke(DialInfoBean dialInfo) {
                    kotlin.jvm.internal.e.f(dialInfo, "dialInfo");
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    if (kVar != null) {
                        kVar.T(dialInfo);
                    }
                    return dialInfo;
                }
            }, new oh.l() { // from class: com.example.test.presenter.main.DevicePresenter$dialInfoCallback$2$1$onResult$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((DialInfoBean) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(DialInfoBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    yh.d.b().e(new EventBusBeans.DeviceDialInfoEvent(it));
                }
            });
        }
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
}
