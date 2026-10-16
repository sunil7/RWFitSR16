package com.example.test.presenter.sport;

import android.widget.TextView;
import com.example.database.db.SportImpl;
import com.example.database.table.DataSport;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.ui.sport.fragment.SportTypeFragment;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import f6.r3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class z extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(int i3) {
        com.example.baselibrary.preseneter.b.j(Integer.valueOf(i3), new oh.l() { // from class: com.example.test.presenter.sport.SportTypePresenter$getSportTotalDistance$1
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Double invoke(int i10) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                double d8 = 0.0d;
                if (d5 != null) {
                    ArrayList arrayList = new ArrayList();
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    Devices c9 = kVar2 != null ? kVar2.c() : null;
                    if (c9 != null) {
                        SportImpl sportImpl = SportImpl.INSTANCE;
                        String userId = d5.getUserId();
                        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                        String macAddress = c9.getMacAddress();
                        kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
                        List<DataSport> sportByType = sportImpl.getSportByType(userId, i10, macAddress);
                        if (sportByType != null) {
                            kotlin.collections.n.i(arrayList, sportByType);
                        }
                    }
                    int size = arrayList.size();
                    int i11 = 0;
                    while (i11 < size) {
                        Object obj = arrayList.get(i11);
                        i11++;
                        String totalDistances = ((DataSport) obj).getTotalDistances();
                        kotlin.jvm.internal.e.e(totalDistances, "getTotalDistances(...)");
                        d8 += Double.parseDouble(totalDistances);
                    }
                    d8 = d5.getMeterUnit() == 0 ? d8 / 1000 : v1.b((float) d8);
                }
                return Double.valueOf(d8);
            }
        }, new oh.l() { // from class: com.example.test.presenter.sport.SportTypePresenter$getSportTotalDistance$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).doubleValue());
                return eh.g.f12633a;
            }

            public final void invoke(double d5) {
                TextView textView;
                double d8 = ((int) (((float) d5) * 100)) / 100.0f;
                r3 r3Var = (r3) ((SportTypeFragment) ((i7.j) z.this.f7255a)).f7251b;
                if (r3Var == null || (textView = r3Var.f13285g) == null) {
                    return;
                }
                android.support.v4.media.session.e.A(new Object[]{Double.valueOf(d8)}, 1, "%.2f", textView);
            }
        });
    }
}
