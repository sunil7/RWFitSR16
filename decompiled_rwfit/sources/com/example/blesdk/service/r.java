package com.example.blesdk.service;

import com.example.test.service.s1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class r implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f7332a;

    public r(y yVar) {
        this.f7332a = yVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        y yVar = this.f7332a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "Muslim计数同步失败[" + i3 + ']');
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
            if (cVar != null) {
                linkedList.remove(cVar);
            }
        }
        yVar.f7340a = 99;
        y.b(yVar, 10);
        y.c(yVar);
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        List list = (List) obj;
        y yVar = this.f7332a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "MUSLIM计数同步成功");
        yVar.f7340a = 99;
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "Muslim计数数据[" + com.example.baselibrary.utils.b.z(list) + ']');
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -109, new byte[]{5, 23, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -109);
            }
            Iterator it = yVar.m().iterator();
            while (it.hasNext()) {
                ((s1) ((u5.h) it.next())).k(list);
            }
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -110, new byte[]{5, 23, 16}, new boolean[0]);
                return;
            } else {
                x5.b.I0().F0((byte) -110);
                return;
            }
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it2.next();
                if (cVar != null && cVar.g() == this) {
                    break;
                }
            }
            if (cVar != null) {
                linkedList.remove(cVar);
            }
        }
        Iterator it3 = yVar.m().iterator();
        while (it3.hasNext()) {
            ((s1) ((u5.h) it3.next())).k(list);
        }
        y.c(yVar);
    }
}
