package com.example.blesdk.service;

import android.util.Log;
import com.example.blesdk.bean.sync.StepItemBean;
import com.example.blesdk.bean.sync.StepSyncBean;
import com.example.test.service.s1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class w implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f7337a;

    public w(y yVar) {
        this.f7337a = yVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        y yVar = this.f7337a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "步数杰里2同步失败[" + i3 + ']');
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
        yVar.f7340a = 10;
        y.b(yVar, 0);
        yVar.q();
    }

    @Override // u5.g
    public final void c() {
        this.f7337a.getClass();
        Log.e("SyncJLDataService", "stepJL2Callback onSuccess");
    }

    @Override // u5.g
    public final void e(Object obj) {
        List list = (List) obj;
        y yVar = this.f7337a;
        yVar.getClass();
        Log.e("SyncJLDataService", "stepJL2Callback onResult");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "步数杰里2同步成功");
        yVar.f7340a = 10;
        List list2 = list;
        u5.c cVar = null;
        if (list2 == null || list2.isEmpty()) {
            x5.b I0 = x5.b.I0();
            if (I0.J0(this)) {
                LinkedList linkedList = I0.f19795a;
                Iterator it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    u5.c cVar2 = (u5.c) it.next();
                    if (cVar2 != null && cVar2.g() == this) {
                        cVar = cVar2;
                        break;
                    }
                }
                if (cVar != null) {
                    linkedList.remove(cVar);
                }
            }
            if (yVar.o().size() > 0) {
                Iterator it2 = yVar.m().iterator();
                while (it2.hasNext()) {
                    ((s1) ((u5.h) it2.next())).p(yVar.o());
                }
            }
            yVar.q();
            return;
        }
        if (list != null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "步数杰里2数据 [" + com.example.baselibrary.utils.b.z(list) + ']');
            if (y5.d.f20006c) {
                if (r5.b.k().f18054c) {
                    x5.c.b().g((byte) 28, new byte[]{5, 26, 48}, new boolean[0]);
                } else {
                    x5.b.I0().F0((byte) 28);
                }
                StepSyncBean stepSyncBean = (StepSyncBean) list.get(0);
                if (yVar.o().size() < 1) {
                    kotlin.collections.n.i(yVar.o(), list);
                } else {
                    StepSyncBean stepSyncBean2 = (StepSyncBean) yVar.o().get(0);
                    Iterator<StepItemBean> it3 = stepSyncBean.getItems().iterator();
                    while (it3.hasNext()) {
                        stepSyncBean2.getItems().add(it3.next());
                    }
                    stepSyncBean2.setItemCount(stepSyncBean2.getItems().size());
                }
                if (r5.b.k().f18054c) {
                    x5.c.b().g((byte) -105, new byte[]{5, 26, 16}, new boolean[0]);
                    return;
                } else {
                    x5.b.I0().F0((byte) -105);
                    return;
                }
            }
            Iterator it4 = yVar.m().iterator();
            while (it4.hasNext()) {
                ((s1) ((u5.h) it4.next())).p(list);
            }
            x5.b I02 = x5.b.I0();
            if (I02.J0(this)) {
                LinkedList linkedList2 = I02.f19795a;
                Iterator it5 = linkedList2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    u5.c cVar3 = (u5.c) it5.next();
                    if (cVar3 != null && cVar3.g() == this) {
                        cVar = cVar3;
                        break;
                    }
                }
                if (cVar != null) {
                    linkedList2.remove(cVar);
                }
            }
            yVar.q();
        }
    }
}
