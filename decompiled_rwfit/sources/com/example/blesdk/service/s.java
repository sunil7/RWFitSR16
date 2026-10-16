package com.example.blesdk.service;

import com.example.test.service.s1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class s implements v5.a0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f7333a;

    public s(y yVar) {
        this.f7333a = yVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        y yVar = this.f7333a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "压力同步失败[" + i3 + ']');
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
        y.b(yVar, 6);
        if (!y5.d.f20006c) {
            yVar.f7340a = 80;
            y.l(yVar);
        } else if (yVar.e) {
            y.d(yVar);
        } else {
            yVar.f7340a = 99;
            y.c(yVar);
        }
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        List list = (List) obj;
        y yVar = this.f7333a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "压力同步成功");
        if (y5.d.f20006c) {
            yVar.f7340a = 99;
        } else {
            yVar.f7340a = 80;
        }
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "压力数据[" + com.example.baselibrary.utils.b.z(list) + ']');
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -75, new byte[]{5, 13, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -75);
            }
            Iterator it = yVar.m().iterator();
            while (it.hasNext()) {
                ((s1) ((u5.h) it.next())).l(list);
            }
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -74, new byte[]{5, 13, 16}, new boolean[0]);
                return;
            } else {
                x5.b.I0().F0((byte) -74);
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
            ((s1) ((u5.h) it3.next())).l(list);
        }
        if (!y5.d.f20006c) {
            y.l(yVar);
            return;
        }
        if (yVar.e) {
            y.d(yVar);
        } else if (yVar.f7344f) {
            y.i(yVar);
        } else {
            y.c(yVar);
        }
    }
}
