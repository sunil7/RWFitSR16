package com.example.test.presenter.device;

import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.testui.TRingMuslinTargetActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class u0 extends d implements u5.g {

    /* renamed from: b, reason: collision with root package name */
    public Integer f7485b;

    @Override // u5.g
    public final void a(int i3) {
        ((XXBaseActivity) ((g7.t) this.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "MuslinTargetPresenter", "errorCode = " + i3);
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        ((XXBaseActivity) ((g7.t) this.f7255a)).b0();
        Integer num = this.f7485b;
        if (num != null) {
            int intValue = num.intValue();
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                kVar.W(intValue);
            }
            TRingMuslinTargetActivity tRingMuslinTargetActivity = (TRingMuslinTargetActivity) ((g7.t) this.f7255a);
            tRingMuslinTargetActivity.getClass();
            com.example.baselibrary.utils.d.a(R$string.str_save_success);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            if (kVar2 != null) {
                Integer num2 = tRingMuslinTargetActivity.F;
                kotlin.jvm.internal.e.c(num2);
                kVar2.W(num2.intValue());
            }
            yh.d.b().e(new EventBusBeans.SyncEvent(10));
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            ((TRingMuslinTargetActivity) ((g7.t) this.f7255a)).S0(num.intValue());
        }
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
}
