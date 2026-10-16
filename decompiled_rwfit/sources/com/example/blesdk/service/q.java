package com.example.blesdk.service;

import com.example.test.service.s1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class q implements v5.z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f7331a;

    public q(y yVar) {
        this.f7331a = yVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        y yVar = this.f7331a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "HRV同步失败[" + i3 + ']');
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
        y.b(yVar, 9);
        if (yVar.f7343d) {
            yVar.f7340a = 80;
            y.j(yVar);
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
        List list = (List) obj;
        y yVar = this.f7331a;
        yVar.getClass();
        StringBuilder sb2 = new StringBuilder("HRV同步成功 isSupportStress ");
        sb2.append(yVar.f7343d);
        sb2.append(" szie ");
        u5.c cVar = null;
        sb2.append(list != null ? Integer.valueOf(list.size()) : null);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", sb2.toString());
        if (y5.d.f20006c && yVar.f7343d) {
            yVar.f7340a = 80;
        } else {
            yVar.f7340a = 99;
        }
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "HRV数据[" + com.example.baselibrary.utils.b.z(list) + ']');
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -73, new byte[]{5, 10, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -73);
            }
            Iterator it = yVar.m().iterator();
            while (it.hasNext()) {
                ((s1) ((u5.h) it.next())).h(list);
            }
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -72, new byte[]{5, 10, 16}, new boolean[0]);
                return;
            } else {
                x5.b.I0().F0((byte) -72);
                return;
            }
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                u5.c cVar2 = (u5.c) it2.next();
                if (cVar2 != null && cVar2.g() == this) {
                    cVar = cVar2;
                    break;
                }
            }
            if (cVar != null) {
                linkedList.remove(cVar);
            }
        }
        Iterator it3 = yVar.m().iterator();
        while (it3.hasNext()) {
            ((s1) ((u5.h) it3.next())).h(list);
        }
        if (yVar.f7343d) {
            y.j(yVar);
        } else {
            y.c(yVar);
        }
    }
}
