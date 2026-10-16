package com.example.test.presenter.main;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.database.db.BloodOxygenImpl;
import com.example.database.table.DataBloodOxygen;
import com.example.database.table.User;
import com.example.test.ui.main.fragment.BOStatisticsFragment;
import com.example.test.ui.model.chart.chart.BoChartData;
import com.example.test.ui.model.chart.chart.BoSumData;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.a2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.BOStatisticsPresenter$getDayBoDetail$1
            @Override // oh.l
            public final BoChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return com.example.test.presenter.analysis.a.b(it);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BOStatisticsPresenter$getDayBoDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BoChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BoChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BOStatisticsFragment) ((g7.b) b.this.f7255a)).g0(it);
            }
        });
    }

    public final void l(String start) {
        kotlin.jvm.internal.e.f(start, "start");
        com.example.baselibrary.preseneter.b.j(start, new oh.l() { // from class: com.example.test.presenter.main.BOStatisticsPresenter$getMonthBoDetail$1
            @Override // oh.l
            public final BoChartData invoke(String it) {
                String str;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                BoChartData boChartData = new BoChartData();
                Date h4 = a2.h(it, "yyyy/MM");
                if (h4 != null) {
                    Date d5 = a2.d(h4);
                    Date c9 = a2.c(h4);
                    String i3 = ca.i(d5.getTime(), "yyyyMMdd");
                    String i10 = ca.i(c9.getTime(), "yyyyMMdd");
                    if (i3 != null && i10 != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d8 = kVar != null ? kVar.d() : null;
                        if (d8 != null) {
                            ArrayList arrayList = new ArrayList();
                            BloodOxygenImpl bloodOxygenImpl = BloodOxygenImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d8.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            List<DataBloodOxygen> dataByDate = bloodOxygenImpl.getDataByDate(g10, userId, i3, i10);
                            if (dataByDate != null) {
                                kotlin.collections.n.i(arrayList, dataByDate);
                            }
                            int b3 = a2.b(d5);
                            int i11 = 0;
                            if (arrayList.size() < b3) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(d5);
                                for (int i12 = 0; i12 < b3; i12++) {
                                    long timeInMillis = calendar.getTimeInMillis();
                                    try {
                                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                                    } catch (Exception e) {
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                                        str = null;
                                    }
                                    if (str != null) {
                                        int size = arrayList.size();
                                        int i13 = 0;
                                        while (true) {
                                            if (i13 >= size) {
                                                obj = null;
                                                break;
                                            }
                                            obj = arrayList.get(i13);
                                            i13++;
                                            if (kotlin.jvm.internal.e.a(((DataBloodOxygen) obj).getDate(), str)) {
                                                break;
                                            }
                                        }
                                        if (((DataBloodOxygen) obj) == null) {
                                            arrayList.add(i12, new DataBloodOxygen());
                                        }
                                    }
                                    calendar.add(5, 1);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size2 = arrayList.size();
                            int i14 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                            int i15 = 0;
                            int i16 = 0;
                            int i17 = 0;
                            int i18 = 0;
                            while (i18 < size2) {
                                Object obj2 = arrayList.get(i18);
                                i18++;
                                int i19 = i15 + 1;
                                if (i15 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                DataBloodOxygen dataBloodOxygen = (DataBloodOxygen) obj2;
                                if (dataBloodOxygen.getMaxBo() > i16) {
                                    i16 = dataBloodOxygen.getMaxBo();
                                }
                                int minBo = dataBloodOxygen.getMinBo();
                                if (1 <= minBo && minBo < i14) {
                                    i14 = dataBloodOxygen.getMinBo();
                                }
                                i17 += dataBloodOxygen.getAvgBo();
                                arrayList2.add(new Entry(i15, dataBloodOxygen.getAvgBo()));
                                if (dataBloodOxygen.getAvgBo() > 0) {
                                    i11++;
                                }
                                i15 = i19;
                            }
                            if (i11 > 0) {
                                boChartData.setMaxBo(i16);
                                boChartData.setMinBo(i14);
                                boChartData.setAvgBo(i17 / i11);
                                boChartData.setItems(arrayList2);
                            }
                        }
                    }
                }
                return boChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BOStatisticsPresenter$getMonthBoDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BoChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BoChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BOStatisticsFragment) ((g7.b) b.this.f7255a)).g0(it);
            }
        });
    }

    public final void m(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.BOStatisticsPresenter$getWeekBoDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final BoChartData invoke(String it) {
                Date date;
                Date date2;
                String str3;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                String end = str2;
                kotlin.jvm.internal.e.f(end, "end");
                BoChartData boChartData = new BoChartData();
                try {
                    date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(it);
                } catch (Exception unused) {
                    date = null;
                }
                try {
                    date2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(end);
                } catch (Exception unused2) {
                    date2 = null;
                }
                if (date != null && date2 != null) {
                    String i3 = ca.i(date.getTime(), "yyyyMMdd");
                    String i10 = ca.i(date2.getTime(), "yyyyMMdd");
                    if (i3 != null && i10 != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d5 = kVar != null ? kVar.d() : null;
                        if (d5 != null) {
                            ArrayList arrayList = new ArrayList();
                            BloodOxygenImpl bloodOxygenImpl = BloodOxygenImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            List<DataBloodOxygen> dataByDate = bloodOxygenImpl.getDataByDate(g10, userId, i3, i10);
                            if (dataByDate != null) {
                                kotlin.collections.n.i(arrayList, dataByDate);
                            }
                            int i11 = 1;
                            int i12 = 0;
                            if (arrayList.size() < 7) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(date);
                                for (int i13 = 0; i13 < 7; i13++) {
                                    long timeInMillis = calendar.getTimeInMillis();
                                    try {
                                        str3 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                                    } catch (Exception e) {
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                                        str3 = null;
                                    }
                                    if (str3 != null) {
                                        int size = arrayList.size();
                                        int i14 = 0;
                                        while (true) {
                                            if (i14 >= size) {
                                                obj = null;
                                                break;
                                            }
                                            obj = arrayList.get(i14);
                                            i14++;
                                            if (kotlin.jvm.internal.e.a(((DataBloodOxygen) obj).getDate(), str3)) {
                                                break;
                                            }
                                        }
                                        if (((DataBloodOxygen) obj) == null) {
                                            arrayList.add(i13, new DataBloodOxygen());
                                        }
                                    }
                                    calendar.add(5, 1);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size2 = arrayList.size();
                            int i15 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                            int i16 = 0;
                            int i17 = 0;
                            int i18 = 0;
                            int i19 = 0;
                            while (i19 < size2) {
                                Object obj2 = arrayList.get(i19);
                                i19++;
                                int i20 = i16 + 1;
                                if (i16 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                DataBloodOxygen dataBloodOxygen = (DataBloodOxygen) obj2;
                                if (dataBloodOxygen.getMaxBo() > i17) {
                                    i17 = dataBloodOxygen.getMaxBo();
                                }
                                int minBo = dataBloodOxygen.getMinBo();
                                if (i11 <= minBo && minBo < i15) {
                                    i15 = dataBloodOxygen.getMinBo();
                                }
                                i18 += dataBloodOxygen.getAvgBo();
                                arrayList2.add(new Entry(i16, dataBloodOxygen.getAvgBo()));
                                if (dataBloodOxygen.getAvgBo() > 0) {
                                    i12++;
                                }
                                i16 = i20;
                                i11 = 1;
                            }
                            if (i12 > 0) {
                                boChartData.setMaxBo(i17);
                                boChartData.setMinBo(i15);
                                boChartData.setAvgBo(i18 / i12);
                                boChartData.setItems(arrayList2);
                            }
                        }
                    }
                }
                return boChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BOStatisticsPresenter$getWeekBoDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BoChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BoChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BOStatisticsFragment) ((g7.b) b.this.f7255a)).g0(it);
            }
        });
    }

    public final void n(String start) {
        kotlin.jvm.internal.e.f(start, "start");
        com.example.baselibrary.preseneter.b.j(start, new oh.l() { // from class: com.example.test.presenter.main.BOStatisticsPresenter$getYearBoDetail$1
            @Override // oh.l
            public final BoChartData invoke(String it) {
                int i3;
                int i10;
                int i11;
                kotlin.jvm.internal.e.f(it, "it");
                BoChartData boChartData = new BoChartData();
                Date h4 = a2.h(it, "yyyy");
                if (h4 != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(h4);
                    int a3 = a2.a(h4);
                    ArrayList arrayList = new ArrayList();
                    int i12 = 0;
                    int i13 = 0;
                    while (true) {
                        int i14 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                        if (i13 >= a3) {
                            break;
                        }
                        Date time = calendar.getTime();
                        kotlin.jvm.internal.e.e(time, "getTime(...)");
                        BoSumData boSumData = new BoSumData();
                        Date v6 = android.support.v4.media.session.e.v(Calendar.getInstance(), time, 5, 5, "getTime(...)");
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTime(time);
                        calendar2.set(5, calendar2.getActualMaximum(5));
                        Date time2 = calendar2.getTime();
                        kotlin.jvm.internal.e.e(time2, "getTime(...)");
                        String i15 = ca.i(v6.getTime(), "yyyyMMdd");
                        String i16 = ca.i(time2.getTime(), "yyyyMMdd");
                        if (i15 != null && i16 != null) {
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                            User d5 = kVar != null ? kVar.d() : null;
                            if (d5 != null) {
                                BloodOxygenImpl bloodOxygenImpl = BloodOxygenImpl.INSTANCE;
                                if (com.example.test.utils.k.f8731b == null) {
                                    synchronized (com.example.test.utils.k.class) {
                                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                    }
                                }
                                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                String g10 = kVar2 != null ? kVar2.g() : null;
                                String userId = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                List<DataBloodOxygen> dataByDate = bloodOxygenImpl.getDataByDate(g10, userId, i15, i16);
                                if (dataByDate != null) {
                                    i3 = 0;
                                    i10 = 0;
                                    i11 = 0;
                                    for (DataBloodOxygen dataBloodOxygen : dataByDate) {
                                        if (dataBloodOxygen.getMaxBo() > i11) {
                                            i11 = dataBloodOxygen.getMaxBo();
                                        }
                                        int minBo = dataBloodOxygen.getMinBo();
                                        if (1 <= minBo && minBo < i14) {
                                            i14 = dataBloodOxygen.getMinBo();
                                        }
                                        i3 += dataBloodOxygen.getAvgBo();
                                        if (dataBloodOxygen.getAvgBo() > 0) {
                                            i10++;
                                        }
                                    }
                                } else {
                                    i3 = 0;
                                    i10 = 0;
                                    i11 = 0;
                                }
                                if (i10 > 0) {
                                    boSumData.setMaxBo(i11);
                                    boSumData.setMinBo(i14);
                                    boSumData.setAvgBo(i3 / i10);
                                }
                            } else {
                                continue;
                            }
                        }
                        arrayList.add(boSumData);
                        calendar.add(2, 1);
                        i13++;
                    }
                    if (a3 < 12) {
                        int i17 = 12 - a3;
                        for (int i18 = 0; i18 < i17; i18++) {
                            arrayList.add(new BoSumData());
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i19 = 0;
                    int i20 = 0;
                    int i21 = 0;
                    int i22 = Integer.MAX_VALUE;
                    int i23 = 0;
                    while (i21 < size) {
                        Object obj = arrayList.get(i21);
                        i21++;
                        int i24 = i19 + 1;
                        if (i19 < 0) {
                            kotlin.collections.i.f();
                            throw null;
                        }
                        BoSumData boSumData2 = (BoSumData) obj;
                        if (boSumData2.getMaxBo() > i23) {
                            i23 = boSumData2.getMaxBo();
                        }
                        int minBo2 = boSumData2.getMinBo();
                        if (1 <= minBo2 && minBo2 < i22) {
                            i22 = boSumData2.getMinBo();
                        }
                        i20 += boSumData2.getAvgBo();
                        if (boSumData2.getAvgBo() > 0) {
                            i12++;
                        }
                        arrayList2.add(new Entry(i19, boSumData2.getAvgBo()));
                        i19 = i24;
                    }
                    if (i12 > 0) {
                        boChartData.setMaxBo(i23);
                        boChartData.setMinBo(i22);
                        boChartData.setAvgBo(i20 / i12);
                        boChartData.setItems(arrayList2);
                    }
                }
                return boChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BOStatisticsPresenter$getYearBoDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BoChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BoChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BOStatisticsFragment) ((g7.b) b.this.f7255a)).g0(it);
            }
        });
    }
}
