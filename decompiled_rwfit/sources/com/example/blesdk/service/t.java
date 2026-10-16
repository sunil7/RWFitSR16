package com.example.blesdk.service;

import com.example.test.service.s1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class t implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f7334a;

    public t(y yVar) {
        this.f7334a = yVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        y yVar = this.f7334a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "睡眠同步失败[" + i3 + ']');
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
        yVar.f7340a = 30;
        y.b(yVar, 1);
        y.g(yVar);
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        List list = (List) obj;
        y yVar = this.f7334a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "睡眠同步成功");
        yVar.f7340a = 30;
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "睡眠数据[" + com.example.baselibrary.utils.b.z(list) + ']');
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -67, new byte[]{5, 5, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -67);
            }
            kotlin.collections.n.i(yVar.n(), list);
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -66, new byte[]{5, 5, 16}, new boolean[0]);
                return;
            } else {
                x5.b.I0().F0((byte) -66);
                return;
            }
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "睡眠总数据[" + com.example.baselibrary.utils.b.z(yVar.n()) + ']');
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
        if (yVar.n().size() > 0) {
            Iterator it2 = yVar.m().iterator();
            while (it2.hasNext()) {
                ((s1) ((u5.h) it2.next())).i(yVar.n());
            }
        }
        y.g(yVar);
    }
}
