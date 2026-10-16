package com.example.test.presenter.main;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.db.BloodOxygenImpl;
import com.example.database.db.BloodPressImpl;
import com.example.database.db.BloodSugarImpl;
import com.example.database.db.BreatheImpl;
import com.example.database.db.HrImpl;
import com.example.database.db.HrvImpl;
import com.example.database.db.MuslimCountImpl;
import com.example.database.db.PressureImpl;
import com.example.database.db.RawStepsImpl;
import com.example.database.db.SleepImpl;
import com.example.database.db.SportImpl;
import com.example.database.db.StepsImpl;
import com.example.database.table.DataBloodOxygen;
import com.example.database.table.DataBloodPress;
import com.example.database.table.DataBloodSugar;
import com.example.database.table.DataBreathe;
import com.example.database.table.DataHeartHrv;
import com.example.database.table.DataHeartRate;
import com.example.database.table.DataMuslimCount;
import com.example.database.table.DataPressure;
import com.example.database.table.DataSleep;
import com.example.database.table.DataSport;
import com.example.database.table.DataStep;
import com.example.database.table.RawDataStep;
import com.example.database.table.User;
import com.example.test.ui.main.model.HomeBSModel;
import com.example.test.ui.main.model.HomeBoModel;
import com.example.test.ui.main.model.HomeBpModel;
import com.example.test.ui.main.model.HomeBreatheModel;
import com.example.test.ui.main.model.HomeHrModel;
import com.example.test.ui.main.model.HomeHrvModel;
import com.example.test.ui.main.model.HomeMuslinModel;
import com.example.test.ui.main.model.HomeSleepModel;
import com.example.test.ui.main.model.HomeSportModel;
import com.example.test.ui.main.model.HomeStepModel;
import com.example.test.ui.main.model.HomeSugarModel;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.BoData;
import com.example.test.ui.model.chart.chart.BpData;
import com.example.test.ui.model.chart.chart.HrData;
import com.example.test.ui.model.chart.chart.LineEntry;
import com.example.test.ui.model.chart.chart.PressureData;
import com.example.test.ui.model.chart.chart.SleepItemData;
import com.example.test.ui.model.chart.chart.SugarData;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.fc;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.EmptyList;

/* loaded from: classes.dex */
public final class t1 extends com.example.baselibrary.preseneter.b {
    public static final float k(t1 t1Var) {
        g7.p pVar = (g7.p) t1Var.f7255a;
        return ((com.example.baselibrary.utils.b.j(pVar.f0()) - (com.example.baselibrary.utils.b.f(pVar.f0(), 10.0f) * 3)) / 2) - (com.example.baselibrary.utils.b.f(pVar.f0(), 10.0f) * 2.0f);
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void l(String str, final String str2) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BO_DATA 刷新血氧数据 ".concat(str));
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeBo$1

            public static final class a extends bc.a<ArrayList<BoData>> {
            }

            public static final class b extends bc.a<ArrayList<BoData>> {
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeBoModel invoke(String it) {
                List list;
                kotlin.jvm.internal.e.f(it, "it");
                HomeBoModel homeBoModel = new HomeBoModel();
                BloodOxygenImpl bloodOxygenImpl = BloodOxygenImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                DataBloodOxygen dataByDate = bloodOxygenImpl.getDataByDate(kVar != null ? kVar.g() : null, str2, it);
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("BO_DATA 刷新血氧数据 ", com.example.baselibrary.utils.b.z(dataByDate)));
                ArrayList arrayList = new ArrayList();
                if (dataByDate != null) {
                    t1 t1Var = this;
                    String items = dataByDate.getItems();
                    int i3 = 0;
                    if (items != null) {
                        List h4 = com.example.baselibrary.utils.b.h(items, new a().f3204b);
                        if (h4 != null) {
                            list = EmptyList.INSTANCE;
                            for (Object obj : h4) {
                                int bo = ((BoData) obj).getBo();
                                if (1 <= bo && bo < 101) {
                                    if (list.isEmpty()) {
                                        list = new ArrayList();
                                    }
                                    kotlin.jvm.internal.i.b(list).add(obj);
                                }
                            }
                        } else {
                            list = null;
                        }
                        List list2 = list;
                        if (list2 != null && !list2.isEmpty()) {
                            homeBoModel.setCurrentBo(((BoData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getBo());
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it2 = kotlin.collections.h.l(list).iterator();
                            int i10 = 0;
                            while (true) {
                                kotlin.collections.q qVar = (kotlin.collections.q) it2;
                                if (qVar.f15638b.hasPrevious()) {
                                    Object previous = qVar.f15638b.previous();
                                    int i11 = i10 + 1;
                                    if (i10 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    BoData boData = (BoData) previous;
                                    if (i10 < 24) {
                                        LineEntry lineEntry = new LineEntry();
                                        lineEntry.setX(i10);
                                        lineEntry.setY(boData.getBo());
                                        arrayList2.add(lineEntry);
                                    }
                                    i10 = i11;
                                } else {
                                    kotlin.collections.r rVar = new kotlin.collections.r(arrayList2);
                                    if (rVar.f15640a.size() < 24) {
                                        int size = 24 - rVar.f15640a.size();
                                        for (int i12 = 0; i12 < size; i12++) {
                                            LineEntry lineEntry2 = new LineEntry();
                                            lineEntry2.setX(i12);
                                            lineEntry2.setY(0.0f);
                                            rVar.add(lineEntry2);
                                        }
                                    }
                                    homeBoModel.setItems(fc.a(60.0f, rVar, t1.k(t1Var), com.example.baselibrary.utils.b.f(((g7.p) t1Var.f7255a).f0(), 64.0f)));
                                }
                            }
                        }
                    }
                    List h10 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new b().f3204b);
                    Log.e("qob", "boData " + dataByDate.getAvgBo() + " items " + dataByDate.getItems());
                    kotlin.jvm.internal.e.c(h10);
                    List list3 = EmptyList.INSTANCE;
                    for (Object obj2 : h10) {
                        if (((BoData) obj2).getBo() > 0) {
                            if (list3.isEmpty()) {
                                list3 = new ArrayList();
                            }
                            kotlin.jvm.internal.i.b(list3).add(obj2);
                        }
                    }
                    long j4 = 1000;
                    homeBoModel.setStartTime(ca.i(((BoData) list3.get(0)).getCurrentTime() * j4, "HH:mm"));
                    homeBoModel.setEndTime(ca.i(((BoData) list3.get(list3.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                    if (!list3.isEmpty()) {
                        for (Object obj3 : list3) {
                            int i13 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.i.f();
                                throw null;
                            }
                            arrayList.add(new Entry(i3, ((BoData) obj3).getBo()));
                            i3 = i13;
                        }
                    }
                }
                homeBoModel.setDataItems(arrayList);
                return homeBoModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeBo$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeBoModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeBoModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("BO_DATA ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) t1.this.f7255a).G(it);
            }
        });
    }

    public final void m(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeBp$1

            public static final class a extends bc.a<ArrayList<BpData>> {
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeBpModel invoke(String it) {
                List list;
                Object previous;
                boolean z5;
                kotlin.jvm.internal.e.f(it, "it");
                HomeBpModel homeBpModel = new HomeBpModel();
                BloodPressImpl bloodPressImpl = BloodPressImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                Object obj = null;
                DataBloodPress dataByDate = bloodPressImpl.getDataByDate(kVar != null ? kVar.g() : null, str2, it);
                if (dataByDate != null) {
                    t1 t1Var = this;
                    String items = dataByDate.getItems();
                    if (items != null) {
                        List h4 = com.example.baselibrary.utils.b.h(items, new a().f3204b);
                        boolean z6 = true;
                        if (h4 != null) {
                            list = EmptyList.INSTANCE;
                            for (Object obj2 : h4) {
                                BpData bpData = (BpData) obj2;
                                int sp = bpData.getSp();
                                int dp = bpData.getDp();
                                if (1 <= dp && dp <= sp) {
                                    if (list.isEmpty()) {
                                        list = new ArrayList();
                                    }
                                    kotlin.jvm.internal.i.b(list).add(obj2);
                                }
                            }
                        } else {
                            list = null;
                        }
                        List list2 = list;
                        if (list2 != null && !list2.isEmpty()) {
                            homeBpModel.setCurrentSp(((BpData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getSp());
                            homeBpModel.setCurrentDp(((BpData) list.get(list.size() - 1)).getDp());
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            Iterator it2 = kotlin.collections.h.l(list).iterator();
                            int i3 = 0;
                            while (true) {
                                kotlin.collections.q qVar = (kotlin.collections.q) it2;
                                if (qVar.f15638b.hasPrevious()) {
                                    Object previous2 = qVar.f15638b.previous();
                                    int i10 = i3 + 1;
                                    if (i3 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    BpData bpData2 = (BpData) previous2;
                                    if (i3 < 24) {
                                        LineEntry lineEntry = new LineEntry();
                                        float f2 = i3;
                                        lineEntry.setX(f2);
                                        z5 = z6;
                                        lineEntry.setY(bpData2.getSp());
                                        arrayList.add(lineEntry);
                                        LineEntry lineEntry2 = new LineEntry();
                                        lineEntry2.setX(f2);
                                        lineEntry2.setY(bpData2.getDp());
                                        arrayList2.add(lineEntry2);
                                    } else {
                                        z5 = z6;
                                    }
                                    z6 = z5;
                                    i3 = i10;
                                } else {
                                    int i11 = 0;
                                    for (Object obj3 : list) {
                                        int i12 = i11 + 1;
                                        if (i11 < 0) {
                                            kotlin.collections.i.f();
                                            throw null;
                                        }
                                        BpData bpData3 = (BpData) obj3;
                                        float f10 = i11;
                                        arrayList3.add(new Entry(f10, bpData3.getSp()));
                                        arrayList4.add(new Entry(f10, bpData3.getDp()));
                                        i11 = i12;
                                    }
                                    homeBpModel.setItemSps(arrayList3);
                                    homeBpModel.setItemDps(arrayList4);
                                    kotlin.collections.r rVar = new kotlin.collections.r(arrayList);
                                    kotlin.collections.r rVar2 = new kotlin.collections.r(arrayList2);
                                    long j4 = 1000;
                                    homeBpModel.setStartTime(ca.i(((BpData) list.get(0)).getCurrentTime() * j4, "HH:mm"));
                                    homeBpModel.setEndTime(ca.i(((BpData) list.get(list.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                                    kotlin.collections.q qVar2 = (kotlin.collections.q) rVar.iterator();
                                    if (qVar2.f15638b.hasPrevious()) {
                                        previous = qVar2.f15638b.previous();
                                        if (qVar2.f15638b.hasPrevious()) {
                                            float y4 = ((LineEntry) previous).getY();
                                            do {
                                                Object previous3 = qVar2.f15638b.previous();
                                                float y10 = ((LineEntry) previous3).getY();
                                                if (Float.compare(y4, y10) < 0) {
                                                    previous = previous3;
                                                    y4 = y10;
                                                }
                                            } while (qVar2.f15638b.hasPrevious());
                                        }
                                    } else {
                                        previous = null;
                                    }
                                    LineEntry lineEntry3 = (LineEntry) previous;
                                    if (lineEntry3 == null) {
                                        lineEntry3 = new LineEntry();
                                    }
                                    LineEntry lineEntry4 = lineEntry3;
                                    kotlin.collections.q qVar3 = (kotlin.collections.q) rVar2.iterator();
                                    if (qVar3.f15638b.hasPrevious()) {
                                        obj = qVar3.f15638b.previous();
                                        if (qVar3.f15638b.hasPrevious()) {
                                            float y11 = ((LineEntry) obj).getY();
                                            do {
                                                Object previous4 = qVar3.f15638b.previous();
                                                float y12 = ((LineEntry) previous4).getY();
                                                if (Float.compare(y11, y12) < 0) {
                                                    obj = previous4;
                                                    y11 = y12;
                                                }
                                            } while (qVar3.f15638b.hasPrevious());
                                        }
                                    }
                                    LineEntry lineEntry5 = (LineEntry) obj;
                                    if (lineEntry5 == null) {
                                        lineEntry5 = new LineEntry();
                                    }
                                    float y13 = lineEntry4.getY() > lineEntry5.getY() ? lineEntry4.getY() : lineEntry5.getY();
                                    homeBpModel.setItemSp(fc.b(rVar, t1.k(t1Var), com.example.baselibrary.utils.b.f(((g7.p) t1Var.f7255a).f0(), 64.0f), y13));
                                    homeBpModel.setItemDp(fc.b(rVar2, t1.k(t1Var), com.example.baselibrary.utils.b.f(((g7.p) t1Var.f7255a).f0(), 64.0f), y13));
                                }
                            }
                        }
                    }
                }
                return homeBpModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeBp$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeBpModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeBpModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("home data bp ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) t1.this.f7255a).w(it);
            }
        });
    }

    public final void n(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeBreathe$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeBreatheModel invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                HomeBreatheModel homeBreatheModel = new HomeBreatheModel();
                BreatheImpl breatheImpl = BreatheImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                DataBreathe dataByDate = breatheImpl.getDataByDate(kVar != null ? kVar.g() : null, str2, str);
                if (dataByDate != null) {
                    Integer totalTime = dataByDate.getTotalTime();
                    kotlin.jvm.internal.e.e(totalTime, "getTotalTime(...)");
                    homeBreatheModel.setBreatheTime(totalTime.intValue());
                }
                return homeBreatheModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeBreathe$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeBreatheModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeBreatheModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.p) t1.this.f7255a).O(it);
            }
        });
    }

    public final void o(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeHr$1

            public static final class a extends bc.a<ArrayList<HrData>> {
            }

            public static final class b extends bc.a<ArrayList<HrData>> {
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeHrModel invoke(String it) {
                List list;
                kotlin.jvm.internal.e.f(it, "it");
                HomeHrModel homeHrModel = new HomeHrModel();
                HrImpl hrImpl = HrImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                DataHeartRate dataByDate = hrImpl.getDataByDate(kVar != null ? kVar.g() : null, str2, it);
                ArrayList arrayList = new ArrayList();
                if (dataByDate != null) {
                    t1 t1Var = this;
                    String items = dataByDate.getItems();
                    int i3 = 0;
                    if (items != null) {
                        List h4 = com.example.baselibrary.utils.b.h(items, new a().f3204b);
                        if (h4 != null) {
                            list = EmptyList.INSTANCE;
                            for (Object obj : h4) {
                                if (((HrData) obj).getHr() > 0) {
                                    if (list.isEmpty()) {
                                        list = new ArrayList();
                                    }
                                    kotlin.jvm.internal.i.b(list).add(obj);
                                }
                            }
                        } else {
                            list = null;
                        }
                        List list2 = list;
                        if (list2 != null && !list2.isEmpty()) {
                            homeHrModel.setCurrentHr(((HrData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getHr());
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it2 = kotlin.collections.h.l(list).iterator();
                            int i10 = 0;
                            while (true) {
                                kotlin.collections.q qVar = (kotlin.collections.q) it2;
                                if (qVar.f15638b.hasPrevious()) {
                                    Object previous = qVar.f15638b.previous();
                                    int i11 = i10 + 1;
                                    if (i10 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    HrData hrData = (HrData) previous;
                                    if (i10 < 24) {
                                        LineEntry lineEntry = new LineEntry();
                                        lineEntry.setX(i10);
                                        lineEntry.setY(hrData.getHr());
                                        arrayList2.add(lineEntry);
                                    }
                                    i10 = i11;
                                } else {
                                    kotlin.collections.r rVar = new kotlin.collections.r(arrayList2);
                                    if (rVar.f15640a.size() < 24) {
                                        int size = 24 - rVar.f15640a.size();
                                        for (int i12 = 0; i12 < size; i12++) {
                                            LineEntry lineEntry2 = new LineEntry();
                                            lineEntry2.setX(i12);
                                            lineEntry2.setY(0.0f);
                                            rVar.add(lineEntry2);
                                        }
                                    }
                                    homeHrModel.setItems(fc.a(10.0f, rVar, t1.k(t1Var), com.example.baselibrary.utils.b.f(((g7.p) t1Var.f7255a).f0(), 64.0f)));
                                }
                            }
                        }
                    }
                    List h10 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new b().f3204b);
                    Log.e("qob", "hrData " + dataByDate.getAvgHr() + " items " + dataByDate.getItems());
                    kotlin.jvm.internal.e.c(h10);
                    List list3 = EmptyList.INSTANCE;
                    for (Object obj2 : h10) {
                        if (((HrData) obj2).getHr() > 0) {
                            if (list3.isEmpty()) {
                                list3 = new ArrayList();
                            }
                            kotlin.jvm.internal.i.b(list3).add(obj2);
                        }
                    }
                    long j4 = 1000;
                    homeHrModel.setStartTime(ca.i(((HrData) list3.get(0)).getCurrentTime() * j4, "HH:mm"));
                    homeHrModel.setEndTime(ca.i(((HrData) list3.get(list3.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                    if (!list3.isEmpty()) {
                        for (Object obj3 : list3) {
                            int i13 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.i.f();
                                throw null;
                            }
                            arrayList.add(new Entry(i3, ((HrData) obj3).getHr()));
                            i3 = i13;
                        }
                    }
                }
                homeHrModel.setDataItems(arrayList);
                return homeHrModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeHr$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeHrModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeHrModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.p) t1.this.f7255a).H(it);
            }
        });
    }

    public final void p(String str, final String str2) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "HRV_DATA 刷新HRV数据 ".concat(str));
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeHrv$1

            public static final class a extends bc.a<ArrayList<HrData>> {
            }

            public static final class b extends bc.a<ArrayList<HrData>> {
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeHrvModel invoke(String it) {
                List list;
                kotlin.jvm.internal.e.f(it, "it");
                HomeHrvModel homeHrvModel = new HomeHrvModel();
                HrvImpl hrvImpl = HrvImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                DataHeartHrv dataByDate = hrvImpl.getDataByDate(kVar != null ? kVar.g() : null, str2, it);
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("HRV_DATA 刷新HRV数据 ", com.example.baselibrary.utils.b.z(dataByDate)));
                ArrayList arrayList = new ArrayList();
                if (dataByDate != null) {
                    t1 t1Var = this;
                    String items = dataByDate.getItems();
                    int i3 = 0;
                    if (items != null) {
                        List h4 = com.example.baselibrary.utils.b.h(items, new a().f3204b);
                        if (h4 != null) {
                            list = EmptyList.INSTANCE;
                            for (Object obj : h4) {
                                int hr = ((HrData) obj).getHr();
                                if (1 <= hr && hr < 101) {
                                    if (list.isEmpty()) {
                                        list = new ArrayList();
                                    }
                                    kotlin.jvm.internal.i.b(list).add(obj);
                                }
                            }
                        } else {
                            list = null;
                        }
                        List list2 = list;
                        if (list2 != null && !list2.isEmpty()) {
                            homeHrvModel.setCurrentHrv(((HrData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getHr());
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it2 = kotlin.collections.h.l(list).iterator();
                            int i10 = 0;
                            while (true) {
                                kotlin.collections.q qVar = (kotlin.collections.q) it2;
                                if (qVar.f15638b.hasPrevious()) {
                                    Object previous = qVar.f15638b.previous();
                                    int i11 = i10 + 1;
                                    if (i10 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    HrData hrData = (HrData) previous;
                                    if (i10 < 24) {
                                        LineEntry lineEntry = new LineEntry();
                                        lineEntry.setX(i10);
                                        lineEntry.setY(hrData.getHr());
                                        arrayList2.add(lineEntry);
                                    }
                                    i10 = i11;
                                } else {
                                    kotlin.collections.r rVar = new kotlin.collections.r(arrayList2);
                                    if (rVar.f15640a.size() < 24) {
                                        int size = 24 - rVar.f15640a.size();
                                        for (int i12 = 0; i12 < size; i12++) {
                                            LineEntry lineEntry2 = new LineEntry();
                                            lineEntry2.setX(i12);
                                            lineEntry2.setY(0.0f);
                                            rVar.add(lineEntry2);
                                        }
                                    }
                                    homeHrvModel.setItems(fc.a(60.0f, rVar, t1.k(t1Var), com.example.baselibrary.utils.b.f(((g7.p) t1Var.f7255a).f0(), 64.0f)));
                                }
                            }
                        }
                    }
                    List h10 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new b().f3204b);
                    Log.e("qob", "hrvData " + dataByDate.getAvgHr() + " items " + dataByDate.getItems());
                    kotlin.jvm.internal.e.c(h10);
                    List list3 = EmptyList.INSTANCE;
                    for (Object obj2 : h10) {
                        if (((HrData) obj2).getHr() > 0) {
                            if (list3.isEmpty()) {
                                list3 = new ArrayList();
                            }
                            kotlin.jvm.internal.i.b(list3).add(obj2);
                        }
                    }
                    long j4 = 1000;
                    homeHrvModel.setStartTime(ca.i(((HrData) list3.get(0)).getCurrentTime() * j4, "HH:mm"));
                    homeHrvModel.setEndTime(ca.i(((HrData) list3.get(list3.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                    if (!list3.isEmpty()) {
                        for (Object obj3 : list3) {
                            int i13 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.i.f();
                                throw null;
                            }
                            arrayList.add(new Entry(i3, ((HrData) obj3).getHr()));
                            i3 = i13;
                        }
                    }
                }
                homeHrvModel.setDataItems(arrayList);
                return homeHrvModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeHrv$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeHrvModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeHrvModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("HRV_DATA ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) t1.this.f7255a).v0(it);
            }
        });
    }

    public final void q(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeMuslimCount$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeMuslinModel invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                MuslimCountImpl muslimCountImpl = MuslimCountImpl.INSTANCE;
                com.example.test.utils.k a3 = y1.a();
                DataMuslimCount dataByDate = muslimCountImpl.getDataByDate(a3 != null ? a3.g() : null, str2, str);
                Log.e("qob", "getHomeMuslimCount " + dataByDate);
                HomeMuslinModel homeMuslinModel = new HomeMuslinModel();
                com.example.test.utils.k a10 = y1.a();
                if ((a10 != null ? a10.d() : null) != null) {
                    com.example.test.utils.k a11 = y1.a();
                    homeMuslinModel.setGoalCount(a11 != null ? a11.v() : 33);
                    Log.e("qob", "homeMuslinModel.goalCount " + homeMuslinModel.getGoalCount() + " " + (dataByDate != null ? Integer.valueOf(dataByDate.getTotalCount()) : null) + " " + (dataByDate != null ? dataByDate.getItems() : null));
                    if (dataByDate != null) {
                        homeMuslinModel.setTotalCount(dataByDate.getTotalCount());
                        homeMuslinModel.setTargetPerCent(((float) dataByDate.getTotalCount()) / ((float) homeMuslinModel.getGoalCount()) <= 1.0f ? dataByDate.getTotalCount() / homeMuslinModel.getGoalCount() : 1.0f);
                    }
                }
                return homeMuslinModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeMuslimCount$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeMuslinModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeMuslinModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("home data Muslim Count ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) t1.this.f7255a).r(it);
            }
        });
    }

    public final void r(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeRunSport$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeSportModel invoke(String it) {
                String str3;
                kotlin.jvm.internal.e.f(it, "it");
                ArrayList arrayList = new ArrayList();
                SportImpl sportImpl = SportImpl.INSTANCE;
                String str4 = str2;
                String str5 = str;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                String g10 = kVar != null ? kVar.g() : null;
                kotlin.jvm.internal.e.c(g10);
                List<DataSport> dataByDate = sportImpl.getDataByDate(str4, str5, g10);
                HomeSportModel homeSportModel = new HomeSportModel();
                if (dataByDate != null) {
                    for (DataSport dataSport : dataByDate) {
                        String timestamp = dataSport.getTimestamp();
                        kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                        long parseLong = Long.parseLong(timestamp) * 1000;
                        try {
                            str3 = new SimpleDateFormat("yyyy/MM", Locale.ENGLISH).format(Long.valueOf(parseLong));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(parseLong, " date translate error ", e.getMessage()));
                            str3 = null;
                        }
                        h6.b bVar = new h6.b();
                        Log.e("qob", "getSportData viewType " + dataSport.getViewType() + " currentDate " + str3);
                        Long id2 = dataSport.getId();
                        kotlin.jvm.internal.e.e(id2, "getId(...)");
                        bVar.f14266a = id2.longValue();
                        bVar.f14267b = dataSport.getSportType();
                        String totalCalories = dataSport.getTotalCalories();
                        kotlin.jvm.internal.e.e(totalCalories, "getTotalCalories(...)");
                        bVar.f14271g = Double.parseDouble(totalCalories);
                        String totalDistances = dataSport.getTotalDistances();
                        kotlin.jvm.internal.e.e(totalDistances, "getTotalDistances(...)");
                        bVar.f14268c = Double.parseDouble(totalDistances);
                        String totalSteps = dataSport.getTotalSteps();
                        kotlin.jvm.internal.e.e(totalSteps, "getTotalSteps(...)");
                        bVar.f14270f = Long.parseLong(totalSteps);
                        String totalTimes = dataSport.getTotalTimes();
                        kotlin.jvm.internal.e.e(totalTimes, "getTotalTimes(...)");
                        bVar.e = Long.parseLong(totalTimes);
                        String timestamp2 = dataSport.getTimestamp();
                        kotlin.jvm.internal.e.e(timestamp2, "getTimestamp(...)");
                        bVar.f14269d = Long.parseLong(timestamp2);
                        if (y5.d.f20005b) {
                            bVar.f14280p = dataSport.getAvgSteps();
                            bVar.f14281q = dataSport.getMaxSteps();
                            bVar.r = dataSport.getMinSteps();
                            dataSport.getSpeed();
                            bVar.f14277m = dataSport.getAvgPace();
                            bVar.f14278n = dataSport.getMaxPace();
                            bVar.f14279o = dataSport.getMinPace();
                            bVar.f14282s = dataSport.getAvgHr();
                            bVar.f14283t = dataSport.getMaxHr();
                            bVar.f14284u = dataSport.getMinHr();
                            bVar.f14288y = dataSport.getViewType();
                        }
                        bVar.f14287x = dataSport.getFrom();
                        arrayList.add(bVar);
                    }
                }
                homeSportModel.setDataItems(arrayList);
                return homeSportModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeRunSport$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeSportModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeSportModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("home data sport ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) t1.this.f7255a).P(it);
            }
        });
    }

    public final void s(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeSleep$1

            public static final class a extends bc.a<ArrayList<SleepItemData>> {
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeSleepModel invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                HomeSleepModel homeSleepModel = new HomeSleepModel();
                SleepImpl sleepImpl = SleepImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                DataSleep dataByDate = sleepImpl.getDataByDate(kVar != null ? kVar.g() : null, str2, str);
                if (dataByDate != null) {
                    t1 t1Var = this;
                    long sleepRapidTime = dataByDate.getSleepRapidTime() + dataByDate.getSleepLightTime() + dataByDate.getSleepDeepTime() + dataByDate.getWakeupCount();
                    long j4 = 60;
                    homeSleepModel.setTotalHour((int) (sleepRapidTime / j4));
                    homeSleepModel.setTotalMin((int) (sleepRapidTime % j4));
                    homeSleepModel.setLightSleepTime((int) dataByDate.getSleepLightTime());
                    homeSleepModel.setDeepSleepTime((int) dataByDate.getSleepDeepTime());
                    homeSleepModel.setWakeSleepTime(dataByDate.getWakeupCount());
                    long j10 = 1000;
                    homeSleepModel.setStartTime(ca.e(dataByDate.getAsleepTime() * j10));
                    homeSleepModel.setEndTime(ca.e(dataByDate.getWakeupTime() * j10));
                    List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new a().f3204b);
                    List list = h4;
                    if (list != null && !list.isEmpty()) {
                        kotlin.jvm.internal.e.c(h4);
                        Iterator it2 = h4.iterator();
                        while (it2.hasNext()) {
                            ((SleepItemData) it2.next()).setDurationPercent(r4.getDuration() / dataByDate.getTotalSleepTime());
                        }
                    }
                    kotlin.jvm.internal.e.c(h4);
                    homeSleepModel.setItems(fc.d(h4, t1.k(t1Var), com.example.baselibrary.utils.b.f(((g7.p) t1Var.f7255a).f0(), 64.0f)));
                }
                return homeSleepModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeSleep$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeSleepModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeSleepModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("home data sleep ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) t1.this.f7255a).m(it);
            }
        });
    }

    public final void t(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeSteps$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeStepModel invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                StepsImpl stepsImpl = StepsImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                DataStep stepByDate = stepsImpl.getStepByDate(kVar != null ? kVar.g() : null, str2, str);
                HomeStepModel homeStepModel = new HomeStepModel();
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                User d5 = kVar2 != null ? kVar2.d() : null;
                if (d5 != null) {
                    if (d5.getStepsTarget() == 0) {
                        d5.setStepsTarget(Const.I_GEO_MAX_TIME);
                    }
                    homeStepModel.setTarget(String.valueOf(d5.getStepsTarget()));
                    if (stepByDate != null) {
                        homeStepModel.setCurrentSteps(String.valueOf(stepByDate.getTotalStep()));
                        float f2 = 1000;
                        homeStepModel.setCalorie(stepByDate.getCalorie() / f2);
                        homeStepModel.setDistance(d5.getMeterUnit() == 0 ? stepByDate.getDistance() / f2 : com.google.android.gms.internal.mlkit_vision_barcode.v1.b(stepByDate.getDistance()));
                        homeStepModel.setTargetPerCent(((float) stepByDate.getTotalStep()) / ((float) d5.getStepsTarget()) <= 1.0f ? stepByDate.getTotalStep() / d5.getStepsTarget() : 1.0f);
                    }
                }
                return homeStepModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeSteps$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeStepModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeStepModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("home data steps ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) t1.this.f7255a).l0(it);
            }
        });
    }

    public final void u(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeStepsJL$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeStepModel invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                RawStepsImpl rawStepsImpl = RawStepsImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                List<RawDataStep> stepByDate = rawStepsImpl.getStepByDate(kVar != null ? kVar.g() : null, str2, str);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (!stepByDate.isEmpty()) {
                    RawDataStep rawDataStep = (RawDataStep) kotlin.collections.h.q(stepByDate);
                    arrayList2.add(rawDataStep);
                    boolean z5 = false;
                    for (int size = stepByDate.size() - 2; -1 < size; size--) {
                        RawDataStep rawDataStep2 = stepByDate.get(size);
                        if (z5) {
                            arrayList.add(rawDataStep2);
                        } else {
                            if (rawDataStep2.getStep() < rawDataStep.getStep()) {
                                arrayList2.add(rawDataStep2);
                            } else {
                                arrayList.add(rawDataStep2);
                                z5 = true;
                            }
                            rawDataStep = rawDataStep2;
                        }
                    }
                }
                Log.e("qob", "home increasingList " + arrayList.size() + " decreasingList " + arrayList2.size());
                RawStepsImpl.INSTANCE.deleteDecreaseStepData(arrayList);
                HomeStepModel homeStepModel = new HomeStepModel();
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                User d5 = kVar2 != null ? kVar2.d() : null;
                if (d5 != null) {
                    if (d5.getStepsTarget() == 0) {
                        d5.setStepsTarget(Const.I_GEO_MAX_TIME);
                    }
                    homeStepModel.setTarget(String.valueOf(d5.getStepsTarget()));
                    if (!arrayList2.isEmpty()) {
                        Object obj = arrayList2.stream().max(Comparator.comparingInt(new v0(TRingHomePresenter$getHomeStepsJL$1$1$steps$1.INSTANCE, 1))).get();
                        kotlin.jvm.internal.e.e(obj, "get(...)");
                        RawDataStep rawDataStep3 = (RawDataStep) obj;
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("home data steps in db ", com.example.baselibrary.utils.b.z(rawDataStep3)));
                        homeStepModel.setCurrentSteps(String.valueOf(rawDataStep3.getStep()));
                        float f2 = 1000;
                        homeStepModel.setCalorie(rawDataStep3.getCalorie() / f2);
                        homeStepModel.setDistance(d5.getMeterUnit() == 0 ? rawDataStep3.getDistance() / f2 : com.google.android.gms.internal.mlkit_vision_barcode.v1.b(rawDataStep3.getDistance()));
                        homeStepModel.setTargetPerCent(((float) rawDataStep3.getStep()) / ((float) d5.getStepsTarget()) <= 1.0f ? rawDataStep3.getStep() / d5.getStepsTarget() : 1.0f);
                    }
                }
                return homeStepModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeStepsJL$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeStepModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeStepModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("home data steps ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) t1.this.f7255a).l0(it);
            }
        });
    }

    public final void v(String str, final String str2) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SUGAR_DATA 刷新血糖数据 ".concat(str));
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeSugar$1

            public static final class a extends bc.a<ArrayList<SugarData>> {
            }

            public static final class b extends bc.a<ArrayList<SugarData>> {
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeSugarModel invoke(String it) {
                List list;
                kotlin.jvm.internal.e.f(it, "it");
                HomeSugarModel homeSugarModel = new HomeSugarModel();
                BloodSugarImpl bloodSugarImpl = BloodSugarImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                DataBloodSugar dataByDate = bloodSugarImpl.getDataByDate(kVar != null ? kVar.g() : null, str2, it);
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("SUGAR_DATA 刷新血糖数据 ", com.example.baselibrary.utils.b.z(dataByDate)));
                ArrayList arrayList = new ArrayList();
                if (dataByDate != null) {
                    t1 t1Var = this;
                    String items = dataByDate.getItems();
                    int i3 = 0;
                    if (items != null) {
                        List h4 = com.example.baselibrary.utils.b.h(items, new a().f3204b);
                        if (h4 != null) {
                            list = EmptyList.INSTANCE;
                            for (Object obj : h4) {
                                float sugar = ((SugarData) obj).getSugar();
                                if (1.0f <= sugar && sugar <= 100.0f) {
                                    if (list.isEmpty()) {
                                        list = new ArrayList();
                                    }
                                    kotlin.jvm.internal.i.b(list).add(obj);
                                }
                            }
                        } else {
                            list = null;
                        }
                        List list2 = list;
                        if (list2 != null && !list2.isEmpty()) {
                            homeSugarModel.setCurrentSugar(((SugarData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getSugar());
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it2 = kotlin.collections.h.l(list).iterator();
                            int i10 = 0;
                            while (true) {
                                kotlin.collections.q qVar = (kotlin.collections.q) it2;
                                if (qVar.f15638b.hasPrevious()) {
                                    Object previous = qVar.f15638b.previous();
                                    int i11 = i10 + 1;
                                    if (i10 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    SugarData sugarData = (SugarData) previous;
                                    if (i10 < 24) {
                                        LineEntry lineEntry = new LineEntry();
                                        lineEntry.setX(i10);
                                        lineEntry.setY(sugarData.getSugar());
                                        arrayList2.add(lineEntry);
                                    }
                                    i10 = i11;
                                } else {
                                    kotlin.collections.r rVar = new kotlin.collections.r(arrayList2);
                                    if (rVar.f15640a.size() < 24) {
                                        int size = 24 - rVar.f15640a.size();
                                        for (int i12 = 0; i12 < size; i12++) {
                                            LineEntry lineEntry2 = new LineEntry();
                                            lineEntry2.setX(i12);
                                            lineEntry2.setY(0.0f);
                                            rVar.add(lineEntry2);
                                        }
                                    }
                                    homeSugarModel.setItems(fc.a(60.0f, rVar, t1.k(t1Var), com.example.baselibrary.utils.b.f(((g7.p) t1Var.f7255a).f0(), 64.0f)));
                                }
                            }
                        }
                    }
                    List h10 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new b().f3204b);
                    Log.e("qob", "boData " + dataByDate.getAvgSugar() + " items " + dataByDate.getItems());
                    kotlin.jvm.internal.e.c(h10);
                    List list3 = EmptyList.INSTANCE;
                    for (Object obj2 : h10) {
                        if (((SugarData) obj2).getSugar() > 0.0f) {
                            if (list3.isEmpty()) {
                                list3 = new ArrayList();
                            }
                            kotlin.jvm.internal.i.b(list3).add(obj2);
                        }
                    }
                    long j4 = 1000;
                    homeSugarModel.setStartTime(ca.i(((SugarData) list3.get(0)).getCurrentTime() * j4, "HH:mm"));
                    homeSugarModel.setEndTime(ca.i(((SugarData) list3.get(list3.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                    if (!list3.isEmpty()) {
                        for (Object obj3 : list3) {
                            int i13 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.i.f();
                                throw null;
                            }
                            arrayList.add(new Entry(i3, ((SugarData) obj3).getSugar()));
                            i3 = i13;
                        }
                    }
                }
                homeSugarModel.setDataItems(arrayList);
                return homeSugarModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getHomeSugar$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeSugarModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeSugarModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("Sugar_DATA ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) t1.this.f7255a).q(it);
            }
        });
    }

    public final void w() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getLocalSupport$1
            @Override // oh.l
            public final SupportMenuBean invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                SupportMenuBean l3 = kVar != null ? kVar.l() : null;
                Log.e("qob", "getLocalSupport isPressure isSupportSleep " + (l3 != null ? Boolean.valueOf(l3.isSleep()) : null));
                if (l3 != null) {
                    Object obj = com.example.test.utils.m.f8734b;
                    com.example.test.utils.m a3 = d2.a();
                    a3.getClass();
                    a3.f8735a = l3;
                }
                return l3;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getLocalSupport$2
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SupportMenuBean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SupportMenuBean supportMenuBean) {
                if (supportMenuBean != null) {
                    yh.d.b().e(new EventBusBeans.DeviceSupportEvent(supportMenuBean));
                }
            }
        });
    }

    public final void x(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getRingHomeBs$1

            public static final class a extends bc.a<ArrayList<PressureData>> {
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeBSModel invoke(String it) {
                String items;
                List list;
                kotlin.jvm.internal.e.f(it, "it");
                HomeBSModel homeBSModel = new HomeBSModel();
                PressureImpl pressureImpl = PressureImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                DataPressure dataByDate = pressureImpl.getDataByDate(kVar != null ? kVar.g() : null, str2, it);
                if (dataByDate != null && (items = dataByDate.getItems()) != null) {
                    List h4 = com.example.baselibrary.utils.b.h(items, new a().f3204b);
                    if (h4 != null) {
                        list = EmptyList.INSTANCE;
                        for (Object obj : h4) {
                            if (((PressureData) obj).getPressure() > 0) {
                                if (list.isEmpty()) {
                                    list = new ArrayList();
                                }
                                kotlin.jvm.internal.i.b(list).add(obj);
                            }
                        }
                    } else {
                        list = null;
                    }
                    List list2 = list;
                    if (list2 != null && !list2.isEmpty()) {
                        homeBSModel.setCurrentStress(((PressureData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getPressure());
                        homeBSModel.setMinStress(homeBSModel.getCurrentStress());
                        homeBSModel.setMaxStress(homeBSModel.getCurrentStress());
                        Iterator it2 = kotlin.collections.h.l(list).iterator();
                        int i3 = 0;
                        while (true) {
                            kotlin.collections.q qVar = (kotlin.collections.q) it2;
                            if (!qVar.f15638b.hasPrevious()) {
                                homeBSModel.setAvgStress((homeBSModel.getMaxStress() + homeBSModel.getMinStress()) / 2);
                                break;
                            }
                            Object previous = qVar.f15638b.previous();
                            int i10 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.i.f();
                                throw null;
                            }
                            PressureData pressureData = (PressureData) previous;
                            if (pressureData.getPressure() > homeBSModel.getMaxStress()) {
                                homeBSModel.setMaxStress(pressureData.getPressure());
                            }
                            if (pressureData.getPressure() < homeBSModel.getMinStress()) {
                                homeBSModel.setMinStress(pressureData.getPressure());
                            }
                            i3 = i10;
                        }
                    }
                }
                return homeBSModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHomePresenter$getRingHomeBs$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeBSModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeBSModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("home data Stress ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) t1.this.f7255a).o0(it);
            }
        });
    }
}
