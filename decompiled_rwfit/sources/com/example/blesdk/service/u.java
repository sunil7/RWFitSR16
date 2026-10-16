package com.example.blesdk.service;

import android.util.Log;
import com.example.blesdk.bean.sync.SportSyncBean;
import com.example.test.service.s1;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class u implements v5.s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f7335a;

    public u(y yVar) {
        this.f7335a = yVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        y yVar = this.f7335a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "运动同步失败[" + i3 + ']');
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
        y.b(yVar, 8);
        y.c(yVar);
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        SportSyncBean data = (SportSyncBean) obj;
        kotlin.jvm.internal.e.f(data, "data");
        y yVar = this.f7335a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "运动同步成功");
        yVar.f7340a = 99;
        if (data.getResultItems().size() > 0) {
            Log.e("qob", "删除已同步的多运动数据 deleteSportResultJL");
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -84, new byte[]{5, 14, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -84);
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "运动数据[" + data + ']');
            Iterator it = yVar.m().iterator();
            while (it.hasNext()) {
                ((s1) ((u5.h) it.next())).o(data);
            }
            y.l(yVar);
            return;
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
        y.c(yVar);
    }
}
