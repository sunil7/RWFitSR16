package com.example.test.presenter.main;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.PowerBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.blesdk.bean.function.VaperPowerBean;
import com.example.database.db.BloodOxygenImpl;
import com.example.database.db.BloodPressImpl;
import com.example.database.db.BloodSugarImpl;
import com.example.database.db.BodyTempImpl;
import com.example.database.db.BreatheImpl;
import com.example.database.db.HrImpl;
import com.example.database.db.PressureImpl;
import com.example.database.db.RawStepsImpl;
import com.example.database.db.SettingImpl;
import com.example.database.db.SleepImpl;
import com.example.database.db.StepsImpl;
import com.example.database.table.DataBloodOxygen;
import com.example.database.table.DataBloodPress;
import com.example.database.table.DataBloodSugar;
import com.example.database.table.DataBodyTemp;
import com.example.database.table.DataBreathe;
import com.example.database.table.DataHeartRate;
import com.example.database.table.DataPressure;
import com.example.database.table.DataSetting;
import com.example.database.table.DataSleep;
import com.example.database.table.DataStep;
import com.example.database.table.RawDataStep;
import com.example.database.table.User;
import com.example.test.ui.main.model.HomeBSModel;
import com.example.test.ui.main.model.HomeBoModel;
import com.example.test.ui.main.model.HomeBpModel;
import com.example.test.ui.main.model.HomeBreatheModel;
import com.example.test.ui.main.model.HomeBtModel;
import com.example.test.ui.main.model.HomeHrModel;
import com.example.test.ui.main.model.HomeSleepModel;
import com.example.test.ui.main.model.HomeStepModel;
import com.example.test.ui.main.model.HomeSugarModel;
import com.example.test.ui.main.model.HomeVaperBatteryModel;
import com.example.test.ui.main.model.HomeViperPowerModel;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.BoData;
import com.example.test.ui.model.chart.chart.BpData;
import com.example.test.ui.model.chart.chart.HrData;
import com.example.test.ui.model.chart.chart.LineEntry;
import com.example.test.ui.model.chart.chart.PressureData;
import com.example.test.ui.model.chart.chart.SleepItemData;
import com.example.test.ui.model.chart.chart.SugarData;
import com.example.test.ui.model.chart.chart.TempData;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.fc;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.EmptyList;

/* loaded from: classes.dex */
public final class w0 extends com.example.baselibrary.preseneter.b {
    public static final float k(w0 w0Var) {
        g7.p pVar = (g7.p) w0Var.f7255a;
        return ((com.example.baselibrary.utils.b.j(pVar.f0()) - (com.example.baselibrary.utils.b.f(pVar.f0(), 10.0f) * 3)) / 2) - (com.example.baselibrary.utils.b.f(pVar.f0(), 10.0f) * 2.0f);
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void l(String str, final String str2) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BO_DATA 刷新血氧数据 ".concat(str));
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeBo$1

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
                    w0 w0Var = this;
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
                                    homeBoModel.setItems(fc.a(60.0f, rVar, w0.k(w0Var), com.example.baselibrary.utils.b.f(((g7.p) w0Var.f7255a).f0(), 64.0f)));
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
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeBo$2
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
                ((g7.p) w0.this.f7255a).G(it);
            }
        });
    }

    public final void m(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeBp$1

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
                    w0 w0Var = this;
                    String items = dataByDate.getItems();
                    if (items != null) {
                        List h4 = com.example.baselibrary.utils.b.h(items, new a().f3204b);
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
                                        lineEntry.setY(bpData2.getSp());
                                        arrayList.add(lineEntry);
                                        LineEntry lineEntry2 = new LineEntry();
                                        lineEntry2.setX(f2);
                                        lineEntry2.setY(bpData2.getDp());
                                        arrayList2.add(lineEntry2);
                                    }
                                    i3 = i10;
                                } else {
                                    kotlin.collections.r rVar = new kotlin.collections.r(arrayList);
                                    kotlin.collections.r rVar2 = new kotlin.collections.r(arrayList2);
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
                                    homeBpModel.setItemSp(fc.b(rVar, w0.k(w0Var), com.example.baselibrary.utils.b.f(((g7.p) w0Var.f7255a).f0(), 64.0f), y13));
                                    homeBpModel.setItemDp(fc.b(rVar2, w0.k(w0Var), com.example.baselibrary.utils.b.f(((g7.p) w0Var.f7255a).f0(), 64.0f), y13));
                                }
                            }
                        }
                    }
                }
                return homeBpModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeBp$2
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
                ((g7.p) w0.this.f7255a).w(it);
            }
        });
    }

    public final void n(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeBreathe$1
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
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeBreathe$2
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
                ((g7.p) w0.this.f7255a).O(it);
            }
        });
    }

    public final void o(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeBs$1

            public static final class a extends bc.a<ArrayList<PressureData>> {
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeBSModel invoke(String it) {
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
                if (dataByDate != null) {
                    w0 w0Var = this;
                    String items = dataByDate.getItems();
                    if (items != null) {
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
                            ArrayList arrayList = new ArrayList();
                            Iterator it2 = kotlin.collections.h.l(list).iterator();
                            int i3 = 0;
                            while (true) {
                                kotlin.collections.q qVar = (kotlin.collections.q) it2;
                                if (qVar.f15638b.hasPrevious()) {
                                    Object previous = qVar.f15638b.previous();
                                    int i10 = i3 + 1;
                                    if (i3 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    PressureData pressureData = (PressureData) previous;
                                    if (i3 < 24) {
                                        LineEntry lineEntry = new LineEntry();
                                        lineEntry.setX(i3);
                                        lineEntry.setY(pressureData.getPressure());
                                        arrayList.add(lineEntry);
                                    }
                                    i3 = i10;
                                } else {
                                    kotlin.collections.r rVar = new kotlin.collections.r(arrayList);
                                    if (rVar.f15640a.size() < 24) {
                                        int size = 24 - rVar.f15640a.size();
                                        for (int i11 = 0; i11 < size; i11++) {
                                            LineEntry lineEntry2 = new LineEntry();
                                            lineEntry2.setX(i11);
                                            lineEntry2.setY(0.0f);
                                            rVar.add(lineEntry2);
                                        }
                                    }
                                    homeBSModel.setItems(fc.a(10.0f, rVar, w0.k(w0Var), com.example.baselibrary.utils.b.f(((g7.p) w0Var.f7255a).f0(), 64.0f)));
                                }
                            }
                        }
                    }
                }
                return homeBSModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeBs$2
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
                ((g7.p) w0.this.f7255a).o0(it);
            }
        });
    }

    public final void p(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeBt$1

            public static final class a extends bc.a<ArrayList<TempData>> {
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HomeBtModel invoke(String it) {
                List list;
                kotlin.jvm.internal.e.f(it, "it");
                HomeBtModel homeBtModel = new HomeBtModel();
                BodyTempImpl bodyTempImpl = BodyTempImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                DataBodyTemp dataByDate = bodyTempImpl.getDataByDate(kVar != null ? kVar.g() : null, str2, it);
                if (dataByDate != null) {
                    w0 w0Var = this;
                    String items = dataByDate.getItems();
                    if (items != null) {
                        List h4 = com.example.baselibrary.utils.b.h(items, new a().f3204b);
                        if (h4 != null) {
                            list = EmptyList.INSTANCE;
                            for (Object obj : h4) {
                                if (((TempData) obj).getTemp() > 0.0f) {
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
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            User d5 = kVar2 != null ? kVar2.d() : null;
                            if (d5 != null) {
                                if (d5.getTempUnit() == 0) {
                                    homeBtModel.setCurrentBt(((TempData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getTemp());
                                } else {
                                    homeBtModel.setCurrentBt(com.google.android.gms.internal.mlkit_vision_barcode.v1.a(((TempData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getTemp()));
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            Iterator it2 = kotlin.collections.h.l(list).iterator();
                            int i3 = 0;
                            while (true) {
                                kotlin.collections.q qVar = (kotlin.collections.q) it2;
                                if (qVar.f15638b.hasPrevious()) {
                                    Object previous = qVar.f15638b.previous();
                                    int i10 = i3 + 1;
                                    if (i3 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    TempData tempData = (TempData) previous;
                                    if (i3 < 24) {
                                        LineEntry lineEntry = new LineEntry();
                                        lineEntry.setX(i3);
                                        lineEntry.setY(tempData.getTemp());
                                        arrayList.add(lineEntry);
                                    }
                                    i3 = i10;
                                } else {
                                    kotlin.collections.r rVar = new kotlin.collections.r(arrayList);
                                    if (rVar.f15640a.size() < 24) {
                                        int size = 24 - rVar.f15640a.size();
                                        for (int i11 = 0; i11 < size; i11++) {
                                            LineEntry lineEntry2 = new LineEntry();
                                            lineEntry2.setX(i11);
                                            lineEntry2.setY(0.0f);
                                            rVar.add(lineEntry2);
                                        }
                                    }
                                    homeBtModel.setItems(fc.a(30.0f, rVar, w0.k(w0Var), com.example.baselibrary.utils.b.f(((g7.p) w0Var.f7255a).f0(), 64.0f)));
                                }
                            }
                        }
                    }
                }
                return homeBtModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeBt$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeBtModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HomeBtModel it) {
                kotlin.jvm.internal.e.f(it, "it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("home data bt ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) w0.this.f7255a).i0(it);
            }
        });
    }

    public final void q() {
        String str;
        User d5;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String str2 = null;
        try {
            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
            str = null;
        }
        if (str != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null && (d5 = kVar.d()) != null) {
                str2 = d5.getUserId();
            }
            if (str2 != null) {
                if (y5.d.f20005b) {
                    Object obj = com.example.test.utils.m.f8734b;
                    if (!d2.a().a()) {
                        u(str, str2);
                        s(str, str2);
                        r(str, str2);
                        l(str, str2);
                        p(str, str2);
                        m(str, str2);
                        n(str, str2);
                        o(str, str2);
                        w();
                        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeVaperBattery$1
                            @Override // oh.l
                            public final PowerBean invoke(String it) {
                                kotlin.jvm.internal.e.f(it, "it");
                                if (com.example.test.utils.k.f8731b == null) {
                                    synchronized (com.example.test.utils.k.class) {
                                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                    }
                                }
                                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                if (kVar2 != null) {
                                    return kVar2.k();
                                }
                                return null;
                            }
                        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeVaperBattery$2
                            {
                                super(1);
                            }

                            @Override // oh.l
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((PowerBean) obj2);
                                return eh.g.f12633a;
                            }

                            public final void invoke(PowerBean powerBean) {
                                if (powerBean != null) {
                                    w0 w0Var = w0.this;
                                    HomeVaperBatteryModel homeVaperBatteryModel = new HomeVaperBatteryModel();
                                    homeVaperBatteryModel.setCurrentBattery(powerBean.getPower());
                                    ((g7.p) w0Var.f7255a).x0(homeVaperBatteryModel);
                                }
                            }
                        });
                    }
                }
                t(str, str2);
                s(str, str2);
                r(str, str2);
                l(str, str2);
                p(str, str2);
                m(str, str2);
                n(str, str2);
                o(str, str2);
                w();
                com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeVaperBattery$1
                    @Override // oh.l
                    public final PowerBean invoke(String it) {
                        kotlin.jvm.internal.e.f(it, "it");
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        if (kVar2 != null) {
                            return kVar2.k();
                        }
                        return null;
                    }
                }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeVaperBattery$2
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((PowerBean) obj2);
                        return eh.g.f12633a;
                    }

                    public final void invoke(PowerBean powerBean) {
                        if (powerBean != null) {
                            w0 w0Var = w0.this;
                            HomeVaperBatteryModel homeVaperBatteryModel = new HomeVaperBatteryModel();
                            homeVaperBatteryModel.setCurrentBattery(powerBean.getPower());
                            ((g7.p) w0Var.f7255a).x0(homeVaperBatteryModel);
                        }
                    }
                });
            }
        }
    }

    public final void r(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeHr$1

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
                    w0 w0Var = this;
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
                                    homeHrModel.setItems(fc.a(10.0f, rVar, w0.k(w0Var), com.example.baselibrary.utils.b.f(((g7.p) w0Var.f7255a).f0(), 64.0f)));
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
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeHr$2
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
                ((g7.p) w0.this.f7255a).H(it);
            }
        });
    }

    public final void s(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeSleep$1

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
                    w0 w0Var = this;
                    long sleepLightTime = dataByDate.getSleepLightTime() + dataByDate.getSleepDeepTime() + dataByDate.getWakeupCount();
                    long j4 = 60;
                    homeSleepModel.setTotalHour((int) (sleepLightTime / j4));
                    homeSleepModel.setTotalMin((int) (sleepLightTime % j4));
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
                    homeSleepModel.setItems(fc.d(h4, w0.k(w0Var), com.example.baselibrary.utils.b.f(((g7.p) w0Var.f7255a).f0(), 64.0f)));
                }
                return homeSleepModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeSleep$2
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
                ((g7.p) w0.this.f7255a).m(it);
            }
        });
    }

    public final void t(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeSteps$1
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
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeSteps$2
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
                ((g7.p) w0.this.f7255a).l0(it);
            }
        });
    }

    public final void u(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeStepsJL$1
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
                        Object obj = arrayList2.stream().max(Comparator.comparingInt(new v0(HomePresenter$getHomeStepsJL$1$1$steps$1.INSTANCE, 0))).get();
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
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeStepsJL$2
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
                ((g7.p) w0.this.f7255a).l0(it);
            }
        });
    }

    public final void v(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeSugar$1

            public static final class a extends bc.a<ArrayList<SugarData>> {
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
                if (dataByDate != null) {
                    w0 w0Var = this;
                    String items = dataByDate.getItems();
                    if (items != null) {
                        List h4 = com.example.baselibrary.utils.b.h(items, new a().f3204b);
                        if (h4 != null) {
                            list = EmptyList.INSTANCE;
                            for (Object obj : h4) {
                                if (((SugarData) obj).getSugar() > 0.0f) {
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
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            if ((kVar2 != null ? kVar2.d() : null) != null) {
                                homeSugarModel.setCurrentSugar(((SugarData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getSugar());
                            }
                            ArrayList arrayList = new ArrayList();
                            Iterator it2 = kotlin.collections.h.l(list).iterator();
                            int i3 = 0;
                            while (true) {
                                kotlin.collections.q qVar = (kotlin.collections.q) it2;
                                if (qVar.f15638b.hasPrevious()) {
                                    Object previous = qVar.f15638b.previous();
                                    int i10 = i3 + 1;
                                    if (i3 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    SugarData sugarData = (SugarData) previous;
                                    if (i3 < 24) {
                                        LineEntry lineEntry = new LineEntry();
                                        lineEntry.setX(i3);
                                        lineEntry.setY(sugarData.getSugar());
                                        arrayList.add(lineEntry);
                                    }
                                    i3 = i10;
                                } else {
                                    kotlin.collections.r rVar = new kotlin.collections.r(arrayList);
                                    if (rVar.f15640a.size() < 24) {
                                        int size = 24 - rVar.f15640a.size();
                                        for (int i11 = 0; i11 < size; i11++) {
                                            LineEntry lineEntry2 = new LineEntry();
                                            lineEntry2.setX(i11);
                                            lineEntry2.setY(0.0f);
                                            rVar.add(lineEntry2);
                                        }
                                    }
                                    homeSugarModel.setItems(fc.a(3.0f, rVar, w0.k(w0Var), com.example.baselibrary.utils.b.f(((g7.p) w0Var.f7255a).f0(), 64.0f)));
                                }
                            }
                        }
                    }
                }
                return homeSugarModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeSugar$2
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
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("home data sugar ", com.example.baselibrary.utils.b.z(it)));
                ((g7.p) w0.this.f7255a).q(it);
            }
        });
    }

    public final void w() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeVaperPower$1
            @Override // oh.l
            public final DataSetting invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 == null) {
                    return null;
                }
                SettingImpl settingImpl = SettingImpl.INSTANCE;
                String userId = d5.getUserId();
                String str = android.support.v4.media.session.e.y(userId, "getUserId(...)").f18212c;
                kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                return settingImpl.getData(userId, str, "setting_vaperpower_level");
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getHomeVaperPower$2

            public static final class a extends bc.a<VaperPowerBean> {
            }

            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DataSetting) obj);
                return eh.g.f12633a;
            }

            public final void invoke(DataSetting dataSetting) {
                if (dataSetting != null) {
                    w0 w0Var = w0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    VaperPowerBean vaperPowerBean = (VaperPowerBean) g10;
                    HomeViperPowerModel homeViperPowerModel = new HomeViperPowerModel();
                    homeViperPowerModel.setCurrentPower(vaperPowerBean.getPowerLevel());
                    homeViperPowerModel.setPowerType(vaperPowerBean.getVaperPowerType());
                    homeViperPowerModel.setPowerLevel(vaperPowerBean.getVaperPowerLevel());
                    ((g7.p) w0Var.f7255a).U(homeViperPowerModel);
                }
            }
        });
    }

    public final void x() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getLocalSupport$1
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
                if (l3 != null) {
                    Object obj = com.example.test.utils.m.f8734b;
                    com.example.test.utils.m a3 = d2.a();
                    a3.getClass();
                    a3.f8735a = l3;
                }
                return l3;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HomePresenter$getLocalSupport$2
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
}
