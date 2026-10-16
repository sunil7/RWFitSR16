package com.example.test.presenter.mine;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class c implements w5.c {
    @Override // w5.c
    public final void a(int i3) {
        u5.c cVar;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "AccountValidatePresenter", l0.j(i3, "绑定错误 "));
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

    @Override // w5.c
    public final void c() {
        u5.c cVar;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "AccountValidatePresenter", "绑定成功");
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
