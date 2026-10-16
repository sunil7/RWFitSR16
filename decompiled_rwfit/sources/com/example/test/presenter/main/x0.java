package com.example.test.presenter.main;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.database.db.HrImpl;
import com.example.database.table.DataHeartRate;
import com.example.database.table.User;
import com.example.test.ui.main.fragment.HRStatisticsFragment;
import com.example.test.ui.model.chart.chart.HrChartData;
import com.example.test.ui.model.chart.chart.HrSumData;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.a2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class x0 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.HrStatisticsPresenter$getDayHrDetail$1
            @Override // oh.l
            public final HrChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return com.example.test.presenter.analysis.a.d(it);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HrStatisticsPresenter$getDayHrDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HrChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HrChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((HRStatisticsFragment) ((g7.q) x0.this.f7255a)).F(it);
            }
        });
    }

    public final void l(String start) {
        kotlin.jvm.internal.e.f(start, "start");
        com.example.baselibrary.preseneter.b.j(start, new oh.l() { // from class: com.example.test.presenter.main.HrStatisticsPresenter$getMonthHrDetail$1
            @Override // oh.l
            public final HrChartData invoke(String it) {
                String str;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                HrChartData hrChartData = new HrChartData();
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
                            HrImpl hrImpl = HrImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d8.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, hrImpl.getDataByDate(g10, userId, i3, i10));
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
                                            if (kotlin.jvm.internal.e.a(((DataHeartRate) obj).getDate(), str)) {
                                                break;
                                            }
                                        }
                                        if (((DataHeartRate) obj) == null) {
                                            arrayList.add(i12, new DataHeartRate());
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
                                DataHeartRate dataHeartRate = (DataHeartRate) obj2;
                                if (dataHeartRate.getMaxHr() > i16) {
                                    i16 = dataHeartRate.getMaxHr();
                                }
                                int minHr = dataHeartRate.getMinHr();
                                if (1 <= minHr && minHr < i14) {
                                    i14 = dataHeartRate.getMinHr();
                                }
                                i17 += dataHeartRate.getAvgHr();
                                arrayList2.add(new Entry(i15, dataHeartRate.getAvgHr()));
                                if (dataHeartRate.getAvgHr() > 0) {
                                    i11++;
                                }
                                i15 = i19;
                            }
                            if (i11 > 0) {
                                hrChartData.setMaxHr(i16);
                                hrChartData.setMinHr(i14);
                                hrChartData.setAvgHr(i17 / i11);
                                hrChartData.setItems(arrayList2);
                            }
                        }
                    }
                }
                return hrChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HrStatisticsPresenter$getMonthHrDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HrChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HrChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((HRStatisticsFragment) ((g7.q) x0.this.f7255a)).F(it);
            }
        });
    }

    public final void m(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.HrStatisticsPresenter$getWeekHrDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final HrChartData invoke(String it) {
                Date date;
                Date date2;
                String str3;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                String end = str2;
                kotlin.jvm.internal.e.f(end, "end");
                HrChartData hrChartData = new HrChartData();
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
                            HrImpl hrImpl = HrImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, hrImpl.getDataByDate(g10, userId, i3, i10));
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
                                            if (kotlin.jvm.internal.e.a(((DataHeartRate) obj).getDate(), str3)) {
                                                break;
                                            }
                                        }
                                        if (((DataHeartRate) obj) == null) {
                                            arrayList.add(i13, new DataHeartRate());
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
                                DataHeartRate dataHeartRate = (DataHeartRate) obj2;
                                if (dataHeartRate.getMaxHr() > i17) {
                                    i17 = dataHeartRate.getMaxHr();
                                }
                                int minHr = dataHeartRate.getMinHr();
                                if (i11 <= minHr && minHr < i15) {
                                    i15 = dataHeartRate.getMinHr();
                                }
                                i18 += dataHeartRate.getAvgHr();
                                arrayList2.add(new Entry(i16, dataHeartRate.getAvgHr()));
                                if (dataHeartRate.getAvgHr() > 0) {
                                    i12++;
                                }
                                i16 = i20;
                                i11 = 1;
                            }
                            if (i12 > 0) {
                                hrChartData.setMaxHr(i17);
                                hrChartData.setMinHr(i15);
                                hrChartData.setAvgHr(i18 / i12);
                                hrChartData.setItems(arrayList2);
                            }
                        }
                    }
                }
                return hrChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HrStatisticsPresenter$getWeekHrDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HrChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HrChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((HRStatisticsFragment) ((g7.q) x0.this.f7255a)).F(it);
            }
        });
    }

    public final void n(String start) {
        kotlin.jvm.internal.e.f(start, "start");
        com.example.baselibrary.preseneter.b.j(start, new oh.l() { // from class: com.example.test.presenter.main.HrStatisticsPresenter$getYearHrDetail$1
            @Override // oh.l
            public final HrChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                HrChartData hrChartData = new HrChartData();
                Date h4 = a2.h(it, "yyyy");
                if (h4 != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(h4);
                    int a3 = a2.a(h4);
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    int i10 = 0;
                    while (true) {
                        int i11 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                        if (i10 >= a3) {
                            break;
                        }
                        Date time = calendar.getTime();
                        kotlin.jvm.internal.e.e(time, "getTime(...)");
                        HrSumData hrSumData = new HrSumData();
                        Date v6 = android.support.v4.media.session.e.v(Calendar.getInstance(), time, 5, 5, "getTime(...)");
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTime(time);
                        calendar2.set(5, calendar2.getActualMaximum(5));
                        Date time2 = calendar2.getTime();
                        kotlin.jvm.internal.e.e(time2, "getTime(...)");
                        String i12 = ca.i(v6.getTime(), "yyyyMMdd");
                        String i13 = ca.i(time2.getTime(), "yyyyMMdd");
                        if (i12 != null && i13 != null) {
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                            User d5 = kVar != null ? kVar.d() : null;
                            if (d5 != null) {
                                HrImpl hrImpl = HrImpl.INSTANCE;
                                if (com.example.test.utils.k.f8731b == null) {
                                    synchronized (com.example.test.utils.k.class) {
                                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                    }
                                }
                                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                String g10 = kVar2 != null ? kVar2.g() : null;
                                String userId = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                int i14 = 0;
                                int i15 = 0;
                                int i16 = 0;
                                for (DataHeartRate dataHeartRate : hrImpl.getDataByDate(g10, userId, i12, i13)) {
                                    if (dataHeartRate.getMaxHr() > i15) {
                                        i15 = dataHeartRate.getMaxHr();
                                    }
                                    int minHr = dataHeartRate.getMinHr();
                                    if (1 <= minHr && minHr < i11) {
                                        i11 = dataHeartRate.getMinHr();
                                    }
                                    i16 += dataHeartRate.getAvgHr();
                                    if (dataHeartRate.getAvgHr() > 0) {
                                        i14++;
                                    }
                                }
                                if (i14 > 0) {
                                    hrSumData.setMaxHr(i15);
                                    hrSumData.setMinHr(i11);
                                    hrSumData.setAvgHr(i16 / i14);
                                }
                            } else {
                                continue;
                            }
                        }
                        arrayList.add(hrSumData);
                        calendar.add(2, 1);
                        i10++;
                    }
                    if (a3 < 12) {
                        int i17 = 12 - a3;
                        for (int i18 = 0; i18 < i17; i18++) {
                            arrayList.add(new HrSumData());
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
                        HrSumData hrSumData2 = (HrSumData) obj;
                        if (hrSumData2.getMaxHr() > i23) {
                            i23 = hrSumData2.getMaxHr();
                        }
                        int minHr2 = hrSumData2.getMinHr();
                        if (1 <= minHr2 && minHr2 < i22) {
                            i22 = hrSumData2.getMinHr();
                        }
                        i20 += hrSumData2.getAvgHr();
                        if (hrSumData2.getAvgHr() > 0) {
                            i3++;
                        }
                        arrayList2.add(new Entry(i19, hrSumData2.getAvgHr()));
                        i19 = i24;
                    }
                    if (i3 > 0) {
                        hrChartData.setMaxHr(i23);
                        hrChartData.setMinHr(i22);
                        hrChartData.setAvgHr(i20 / i3);
                        hrChartData.setItems(arrayList2);
                    }
                }
                return hrChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HrStatisticsPresenter$getYearHrDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HrChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HrChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((HRStatisticsFragment) ((g7.q) x0.this.f7255a)).F(it);
            }
        });
    }
}
