package com.example.blesdk.service;

import android.util.Log;
import com.example.test.service.s1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class v implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f7336a;

    public v(y yVar) {
        this.f7336a = yVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        y yVar = this.f7336a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "步数同步失败[" + i3 + ']');
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
        yVar.f7340a = 20;
        y.b(yVar, 0);
        y.k(yVar);
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        List list = (List) obj;
        y yVar = this.f7336a;
        yVar.getClass();
        StringBuilder sb2 = new StringBuilder("步数同步成功 size ");
        u5.c cVar = null;
        sb2.append(list != null ? Integer.valueOf(list.size()) : null);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", sb2.toString());
        yVar.f7340a = 20;
        List list2 = list;
        eh.b bVar = yVar.f7348j;
        if (list2 != null && !list2.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "步数数据 [" + com.example.baselibrary.utils.b.z(list) + ']');
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -61, new byte[]{5, 2, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -61);
            }
            if (!yVar.f7342c) {
                Iterator it = yVar.m().iterator();
                while (it.hasNext()) {
                    ((s1) ((u5.h) it.next())).j(list);
                }
            } else if (y5.d.f20006c) {
                ((List) bVar.getValue()).addAll(list2);
            } else {
                ArrayList a3 = y.a(yVar, list);
                Iterator it2 = yVar.m().iterator();
                while (it2.hasNext()) {
                    ((s1) ((u5.h) it2.next())).p(a3);
                }
            }
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -60, new byte[]{5, 2, 16}, new boolean[0]);
                return;
            } else {
                x5.b.I0().F0((byte) -60);
                return;
            }
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it3 = linkedList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                u5.c cVar2 = (u5.c) it3.next();
                if (cVar2 != null && cVar2.g() == this) {
                    cVar = cVar2;
                    break;
                }
            }
            if (cVar != null) {
                linkedList.remove(cVar);
            }
        }
        if (y5.d.f20006c) {
            ArrayList a10 = y.a(yVar, (List) bVar.getValue());
            Log.e("qob", "tData3 handleJLStepToJL2Step " + a10.size() + " mAllHistoryStepData " + ((List) bVar.getValue()).size());
            Iterator it4 = yVar.m().iterator();
            while (it4.hasNext()) {
                ((s1) ((u5.h) it4.next())).p(a10);
            }
        }
        y.k(yVar);
    }
}
