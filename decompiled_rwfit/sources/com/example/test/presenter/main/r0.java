package com.example.test.presenter.main;

import com.example.blesdk.bean.sync.HrvSyncBean;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.HrData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class r0 implements v5.z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f7553a;

    public r0(u0 u0Var) {
        this.f7553a = u0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        List list = (List) obj;
        u5.c cVar = null;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "HeartRatePresenter hrvCallback", "HRV同步成功" + (list != null ? Integer.valueOf(list.size()) : null));
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "HeartRatePresenter hrvCallback", com.google.android.gms.internal.mlkit_vision_barcode.l0.o("HRV数据[", com.example.baselibrary.utils.b.z(list), "]"));
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -73, new byte[]{5, 10, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -73);
            }
            ArrayList w8 = kotlin.collections.h.w(list2);
            final u0 u0Var = this.f7553a;
            u0Var.getClass();
            com.example.baselibrary.utils.b.x(w8, new oh.l() { // from class: com.example.test.presenter.main.HeartRatePresenter$onSyncHrv$1$1

                public static final class a extends bc.a<ArrayList<HrData>> {
                }

                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:63:0x0126  */
                /* JADX WARN: Removed duplicated region for block: B:80:0x0176  */
                /* JADX WARN: Removed duplicated region for block: B:82:0x017d  */
                /* JADX WARN: Removed duplicated region for block: B:85:0x017e A[SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(java.util.List<com.example.blesdk.bean.sync.HrvSyncBean> r15) {
                    /*
                        Method dump skipped, instructions count: 415
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.main.HeartRatePresenter$onSyncHrv$1$1.invoke(java.util.List):void");
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((List<HrvSyncBean>) obj2);
                    return eh.g.f12633a;
                }
            }, new oh.l() { // from class: com.example.test.presenter.main.HeartRatePresenter$onSyncHrv$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((eh.g) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(eh.g it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    yh.d.b().e(new EventBusBeans.SyncEvent(13));
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
                    break;
                }
                u5.c cVar2 = (u5.c) it.next();
                if (cVar2 != null && cVar2.g() == this) {
                    cVar = cVar2;
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
