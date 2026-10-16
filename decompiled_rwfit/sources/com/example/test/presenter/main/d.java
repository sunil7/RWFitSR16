package com.example.test.presenter.main;

import com.example.blesdk.bean.sync.PressureSyncBean;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.PressureData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class d implements v5.a0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f7502a;

    public d(g gVar) {
        this.f7502a = gVar;
    }

    @Override // u5.g
    public final void a(int i3) {
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BSStatisticsPresenter", "压力同步成功");
        List list = (List) obj;
        if (list != null && !list.isEmpty()) {
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -75, new byte[]{5, 13, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -75);
            }
            ArrayList w8 = kotlin.collections.h.w(list);
            final g gVar = this.f7502a;
            gVar.getClass();
            com.example.baselibrary.utils.b.x(w8, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$onSyncPressure$1$1

                public static final class a extends bc.a<ArrayList<PressureData>> {
                }

                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
                /* JADX WARN: Removed duplicated region for block: B:81:0x0185  */
                /* JADX WARN: Removed duplicated region for block: B:84:0x018f  */
                /* JADX WARN: Removed duplicated region for block: B:87:0x0190 A[SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(java.util.List<com.example.blesdk.bean.sync.PressureSyncBean> r17) {
                    /*
                        Method dump skipped, instructions count: 451
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.main.BSStatisticsPresenter$onSyncPressure$1$1.invoke(java.util.List):void");
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((List<PressureSyncBean>) obj2);
                    return eh.g.f12633a;
                }
            }, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$onSyncPressure$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((eh.g) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(eh.g it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PRESSURE_DATA " + it);
                    yh.d.b().e(new EventBusBeans.SyncEvent(6));
                }
            });
            return;
        }
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
