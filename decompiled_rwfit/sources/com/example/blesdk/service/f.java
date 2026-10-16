package com.example.blesdk.service;

import com.example.blesdk.bean.sync.HealthSyncBean;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class f implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f7305a;

    public f(l lVar) {
        this.f7305a = lVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        l lVar = this.f7305a;
        lVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "开启同步失败[" + i3 + ']');
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
        l.a(lVar, -1);
        lVar.c();
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        HealthSyncBean healthSyncBean = (HealthSyncBean) obj;
        if (healthSyncBean != null) {
            l lVar = this.f7305a;
            lVar.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "开启同步[" + healthSyncBean + ']');
            lVar.f7323m = healthSyncBean;
            lVar.f7312a = 10;
            if (healthSyncBean.isHasStepData()) {
                HealthSyncBean healthSyncBean2 = lVar.f7323m;
                if (healthSyncBean2 != null) {
                    if (healthSyncBean2.isHasStepData()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "开始同步步数数据");
                        j bleDataCallback = (j) lVar.e.getValue();
                        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
                        x5.b I0 = x5.b.I0();
                        u5.e eVar = new u5.e();
                        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
                        eVar.f18884b = bleDataCallback;
                        I0.K0(eVar);
                        lVar.f7313b = 20;
                        if (r5.b.k().f18054c) {
                            x5.d.c().j((byte) -95, new byte[0]);
                        } else {
                            x5.b.I0().F0((byte) -95);
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "没有需要同步的步数数据...");
                        lVar.i();
                    }
                }
            } else if (healthSyncBean.isHasSleepData()) {
                lVar.i();
            } else if (healthSyncBean.isHasHrData()) {
                lVar.h();
            } else if (healthSyncBean.isHasBloodPressData()) {
                lVar.e();
            } else if (healthSyncBean.isHasBloodOxyData()) {
                lVar.d();
            } else if (healthSyncBean.isHasBodyTempData()) {
                lVar.g();
            } else if (healthSyncBean.isHasBreatheData()) {
                lVar.f();
            } else if (healthSyncBean.isHasSportData()) {
                lVar.j();
            } else if (healthSyncBean.isHasEcgData()) {
                Object obj2 = l.f7311q;
            } else {
                lVar.c();
            }
        }
        x5.b I02 = x5.b.I0();
        if (I02.J0(this)) {
            LinkedList linkedList = I02.f19795a;
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
