package com.example.test.service;

import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class k1 implements w5.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f7727a;

    public k1(u1 u1Var) {
        this.f7727a = u1Var;
    }

    @Override // w5.b
    public final void d(int i3, int i10) {
        u5.c cVar;
        this.f7727a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "设置 " + i3 + " 失败，原因:" + i10);
        if (y5.d.f20005b && ((byte) i3) == -19) {
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

    @Override // w5.b
    public final void h(int i3) {
        u5.c cVar;
        this.f7727a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "设置 " + i3 + " 成功");
        if (y5.d.f20005b && ((byte) i3) == -19) {
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
}
