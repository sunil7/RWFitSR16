package com.example.blesdk.service;

import com.example.blesdk.bean.sync.SportSyncBean;
import com.example.test.service.s1;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class i implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f7308a;

    public i(l lVar) {
        this.f7308a = lVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        l lVar = this.f7308a;
        lVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "运动同步失败[" + i3 + ']');
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
        lVar.f7312a = 99;
        l.a(lVar, 7);
        lVar.c();
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        SportSyncBean sportSyncBean = (SportSyncBean) obj;
        l lVar = this.f7308a;
        lVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "运动同步成功");
        lVar.f7312a = 99;
        if (sportSyncBean != null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "运动数据[" + sportSyncBean + ']');
            Iterator it = lVar.b().iterator();
            while (it.hasNext()) {
                ((s1) ((u5.h) it.next())).o(sportSyncBean);
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
        lVar.c();
    }
}
