package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.sync.BloodPressSyncBean;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.BpData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class l implements v5.x {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f7532a;

    public l(n nVar) {
        this.f7532a = nVar;
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
        Log.e("BloodOxygenPresenter boCallback", "onResult bo " + (list != null ? Integer.valueOf(list.size()) : null));
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -65, new byte[]{5, 4, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -65);
            }
            final n nVar = this.f7532a;
            nVar.getClass();
            if (list != null) {
                com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.presenter.main.BloodPressurePresenter$onSyncBo$1$1

                    public static final class a extends bc.a<ArrayList<BpData>> {
                    }

                    {
                        super(1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:103:0x0204  */
                    /* JADX WARN: Removed duplicated region for block: B:105:0x020a  */
                    /* JADX WARN: Removed duplicated region for block: B:108:0x0216  */
                    /* JADX WARN: Removed duplicated region for block: B:111:0x021f  */
                    /* JADX WARN: Removed duplicated region for block: B:114:0x0220 A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:74:0x0175  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void invoke(java.util.List<? extends com.example.blesdk.bean.sync.BloodPressSyncBean> r19) {
                        /*
                            Method dump skipped, instructions count: 651
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.main.BloodPressurePresenter$onSyncBo$1$1.invoke(java.util.List):void");
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((List<? extends BloodPressSyncBean>) obj2);
                        return eh.g.f12633a;
                    }
                }, new oh.l() { // from class: com.example.test.presenter.main.BloodPressurePresenter$onSyncBo$1$2
                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((eh.g) obj2);
                        return eh.g.f12633a;
                    }

                    public final void invoke(eh.g it) {
                        kotlin.jvm.internal.e.f(it, "it");
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BO_DATA " + it);
                        yh.d.b().e(new EventBusBeans.SyncEvent(2));
                    }
                });
                return;
            }
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
