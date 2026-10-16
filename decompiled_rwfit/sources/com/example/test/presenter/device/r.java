package com.example.test.presenter.device;

import com.example.blesdk.bean.function.CustomDialInfoBean;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class r implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f7473a;

    public r(s sVar) {
        this.f7473a = sVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        s sVar = this.f7473a;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, sVar.f7476d, com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "ERROR CODE "));
        ((f7.e) sVar.f7255a).T(null);
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        ((f7.e) this.f7473a.f7255a).T((CustomDialInfoBean) obj);
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
