package com.example.test.presenter.main;

import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.main.fragment.DeviceFragment;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class y implements w5.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f7581a;

    public y(h0 h0Var) {
        this.f7581a = h0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        h0 h0Var = this.f7581a;
        ((XXBaseFragment) ((g7.k) h0Var.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", "deviceUnbindControlCallback errorCode " + i3);
        ((DeviceFragment) ((g7.k) h0Var.f7255a)).F0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== deviceUnbindControlCallback");
        com.example.test.service.e.h().q();
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

    @Override // u5.g
    public final void c() {
        u5.c cVar;
        h0 h0Var = this.f7581a;
        ((XXBaseFragment) ((g7.k) h0Var.f7255a)).b0();
        ((DeviceFragment) ((g7.k) h0Var.f7255a)).F0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== deviceUnbindControlCallback onSuccess");
        com.example.test.service.e.h().q();
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

    @Override // u5.g
    public final /* bridge */ /* synthetic */ void e(Object obj) {
    }
}
