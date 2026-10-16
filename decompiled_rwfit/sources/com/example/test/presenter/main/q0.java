package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.sync.HeartRateSyncBean;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.HrData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class q0 implements v5.y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f7548a;

    public q0(u0 u0Var) {
        this.f7548a = u0Var;
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
        Log.e("HeartRatePresenter hrCallback", "onResult hr " + (list != null ? Integer.valueOf(list.size()) : null));
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -63, new byte[]{5, 3, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -63);
            }
            final u0 u0Var = this.f7548a;
            u0Var.getClass();
            if (list != null) {
                com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.presenter.main.HeartRatePresenter$onSyncHr$1$1

                    public static final class a extends bc.a<ArrayList<HrData>> {
                    }

                    {
                        super(1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:63:0x0129  */
                    /* JADX WARN: Removed duplicated region for block: B:83:0x018c A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:91:0x017f A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:94:0x017c  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void invoke(java.util.List<com.example.blesdk.bean.sync.HeartRateSyncBean> r17) {
                        /*
                            Method dump skipped, instructions count: 441
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.main.HeartRatePresenter$onSyncHr$1$1.invoke(java.util.List):void");
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((List<HeartRateSyncBean>) obj2);
                        return eh.g.f12633a;
                    }
                }, new oh.l() { // from class: com.example.test.presenter.main.HeartRatePresenter$onSyncHr$1$2
                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((eh.g) obj2);
                        return eh.g.f12633a;
                    }

                    public final void invoke(eh.g it) {
                        kotlin.jvm.internal.e.f(it, "it");
                        yh.d.b().e(new EventBusBeans.SyncEvent(1));
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
