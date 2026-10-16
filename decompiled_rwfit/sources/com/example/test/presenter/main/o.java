package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.sync.BloodSugarSyncBean;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.SugarData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class o implements v5.v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f7540a;

    public o(r rVar) {
        this.f7540a = rVar;
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
        Log.e("BloodSugarStatisticsPresenter bloodSugarCallback", "onResult" + (list != null ? Integer.valueOf(list.size()) : null));
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -111, new byte[]{5, 16, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -111);
            }
            ArrayList w8 = kotlin.collections.h.w(list2);
            final r rVar = this.f7540a;
            rVar.getClass();
            com.example.baselibrary.utils.b.x(w8, new oh.l() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$onSyncBloodSugar$1$1

                public static final class a extends bc.a<ArrayList<SugarData>> {
                }

                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:63:0x012b  */
                /* JADX WARN: Removed duplicated region for block: B:81:0x017f  */
                /* JADX WARN: Removed duplicated region for block: B:84:0x0189  */
                /* JADX WARN: Removed duplicated region for block: B:87:0x018a A[SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(java.util.List<com.example.blesdk.bean.sync.BloodSugarSyncBean> r15) {
                    /*
                        Method dump skipped, instructions count: 480
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.main.BloodSugarStatisticsPresenter$onSyncBloodSugar$1$1.invoke(java.util.List):void");
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((List<BloodSugarSyncBean>) obj2);
                    return eh.g.f12633a;
                }
            }, new oh.l() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$onSyncBloodSugar$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((eh.g) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(eh.g it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    yh.d.b().e(new EventBusBeans.SyncEvent(9));
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
