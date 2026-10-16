package com.example.test.presenter.sport;

import com.amap.api.maps.model.LatLng;
import com.example.blesdk.bean.sync.ImperialPaceItemBean;
import com.example.blesdk.bean.sync.MetricPaceItemBean;
import com.example.database.db.SportImpl;
import com.example.database.table.DataSport;
import com.example.database.table.User;
import com.example.test.service.g1;
import com.example.test.service.r0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.n1;
import com.google.android.gms.internal.mlkit_vision_barcode.p1;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c extends com.example.baselibrary.preseneter.b {

    /* renamed from: b, reason: collision with root package name */
    public b f7603b;

    public static void k(byte b3, int i3) {
        byte b10;
        if (i3 != 2) {
            b10 = 7;
            if (i3 == 7) {
                b10 = 12;
            } else if (i3 == 14) {
                b10 = 13;
            } else if (i3 == 4) {
                b10 = 8;
            } else if (i3 != 5) {
                b10 = -1;
            }
        } else {
            b10 = 10;
        }
        if (b10 == -1) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportDetailPresenter", l0.j(i3, "表端不支持的运动类型 "));
            return;
        }
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -78);
            return;
        }
        x5.c b11 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getControlSportCmdJL " + ((int) b10) + ' ' + ((int) b3));
        b11.g((byte) -78, new byte[]{6, 4, 0, b10, b3}, new boolean[0]);
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        b bVar = this.f7603b;
        if (bVar == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(bVar)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == bVar) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    public final void l(h6.b bVar) {
        com.example.baselibrary.preseneter.b.j(bVar, new oh.l() { // from class: com.example.test.presenter.sport.SportDetailJLPresenter$saveSport$1
            @Override // oh.l
            public final Long invoke(h6.b sport) {
                String str;
                int i3;
                kotlin.jvm.internal.e.f(sport, "sport");
                DataSport dataSport = new DataSport();
                long j4 = sport.f14269d * 1000;
                try {
                    str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(j4));
                } catch (Exception e) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(j4, " date translate error ", e.getMessage()));
                    str = null;
                }
                dataSport.setDate(str);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    dataSport.setUserId(d5.getUserId());
                }
                dataSport.setMac(com.example.test.service.e.h().g().f18212c);
                dataSport.setTimestamp(String.valueOf(sport.f14269d));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = sport.f14272h;
                int i10 = 0;
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    int i11 = 0;
                    int i12 = 0;
                    while (i12 < size) {
                        Object obj = arrayList2.get(i12);
                        i12++;
                        int i13 = i11 + 1;
                        if (i11 < 0) {
                            kotlin.collections.i.f();
                            throw null;
                        }
                        Long l3 = (Long) obj;
                        MetricPaceItemBean metricPaceItemBean = new MetricPaceItemBean();
                        metricPaceItemBean.setPaceIndex(i11);
                        kotlin.jvm.internal.e.c(l3);
                        metricPaceItemBean.setPace(l3.longValue());
                        if (i11 < sport.f14272h.size() - 1) {
                            metricPaceItemBean.setKm(true);
                            i3 = size;
                        } else {
                            i3 = size;
                            metricPaceItemBean.setKm(sport.f14268c % ((double) 1000) == 0.0d);
                        }
                        arrayList.add(metricPaceItemBean);
                        size = i3;
                        i11 = i13;
                    }
                }
                dataSport.setPaceMetrics(com.example.baselibrary.utils.b.z(arrayList));
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = sport.f14273i;
                if (arrayList4 != null) {
                    int size2 = arrayList4.size();
                    int i14 = 0;
                    int i15 = 0;
                    while (i15 < size2) {
                        Object obj2 = arrayList4.get(i15);
                        i15++;
                        int i16 = i14 + 1;
                        if (i14 < 0) {
                            kotlin.collections.i.f();
                            throw null;
                        }
                        Long l5 = (Long) obj2;
                        ImperialPaceItemBean imperialPaceItemBean = new ImperialPaceItemBean();
                        imperialPaceItemBean.setPaceIndex(i14);
                        kotlin.jvm.internal.e.c(l5);
                        imperialPaceItemBean.setPace(l5.longValue());
                        if (i14 < sport.f14272h.size() - 1) {
                            imperialPaceItemBean.setMi(true);
                        } else {
                            imperialPaceItemBean.setMi(v1.b((float) sport.f14268c) % ((float) 1) == 0.0f);
                        }
                        arrayList3.add(imperialPaceItemBean);
                        i14 = i16;
                    }
                }
                dataSport.setPaceImperials(com.example.baselibrary.utils.b.z(arrayList3));
                dataSport.setStepDetails(com.example.baselibrary.utils.b.z(sport.f14274j));
                dataSport.setSportType(sport.f14267b);
                dataSport.setTotalTimes(String.valueOf(sport.e));
                dataSport.setTotalCalories(String.valueOf(sport.f14271g * 1000));
                dataSport.setTotalSteps(String.valueOf(sport.f14270f));
                dataSport.setTotalDistances(String.valueOf(sport.f14268c));
                dataSport.setFrom(9);
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = sport.f14275k;
                if (arrayList6 != null) {
                    int size3 = arrayList6.size();
                    while (i10 < size3) {
                        Object obj3 = arrayList6.get(i10);
                        i10++;
                        LatLng latLng = (LatLng) obj3;
                        arrayList5.add(new h6.a(latLng.latitude, latLng.longitude));
                    }
                }
                dataSport.setLatLng(com.example.baselibrary.utils.b.z(arrayList5));
                return Long.valueOf(SportImpl.INSTANCE.saveData(dataSport));
            }
        }, new oh.l() { // from class: com.example.test.presenter.sport.SportDetailJLPresenter$saveSport$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return eh.g.f12633a;
            }

            public final void invoke(long j4) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportDetailPresenter", l0.l(j4, "运动保存 "));
                Object obj = r0.M;
                n1.a().l();
                Object obj2 = g1.e;
                p1.a().p();
                ((i7.b) c.this.f7255a).D(j4);
            }
        });
    }
}
