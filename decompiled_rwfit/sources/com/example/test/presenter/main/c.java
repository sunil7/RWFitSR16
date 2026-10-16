package com.example.test.presenter.main;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.database.db.BloodPressImpl;
import com.example.database.table.DataBloodPress;
import com.example.database.table.User;
import com.example.test.ui.main.fragment.BPStatisticsFragment;
import com.example.test.ui.model.chart.chart.BpChartData;
import com.example.test.ui.model.chart.chart.BpSumData;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.a2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.BPStatisticsPresenter$getDayBpDetail$1
            @Override // oh.l
            public final BpChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return com.example.test.presenter.analysis.a.c(it);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BPStatisticsPresenter$getDayBpDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BpChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BpChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BPStatisticsFragment) ((g7.c) c.this.f7255a)).u0(it);
            }
        });
    }

    public final void l(String month) {
        kotlin.jvm.internal.e.f(month, "month");
        com.example.baselibrary.preseneter.b.j(month, new oh.l() { // from class: com.example.test.presenter.main.BPStatisticsPresenter$getMonthBpDetail$1
            @Override // oh.l
            public final BpChartData invoke(String it) {
                String str;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                BpChartData bpChartData = new BpChartData();
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
                            BloodPressImpl bloodPressImpl = BloodPressImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d8.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, bloodPressImpl.getDataByDate(g10, userId, i3, i10));
                            int b3 = a2.b(d5);
                            int i11 = 1;
                            int i12 = 0;
                            if (arrayList.size() < b3) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(d5);
                                for (int i13 = 0; i13 < b3; i13++) {
                                    long timeInMillis = calendar.getTimeInMillis();
                                    try {
                                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                                    } catch (Exception e) {
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                                        str = null;
                                    }
                                    if (str != null) {
                                        int size = arrayList.size();
                                        int i14 = 0;
                                        while (true) {
                                            if (i14 >= size) {
                                                obj = null;
                                                break;
                                            }
                                            obj = arrayList.get(i14);
                                            i14++;
                                            if (kotlin.jvm.internal.e.a(((DataBloodPress) obj).getDate(), str)) {
                                                break;
                                            }
                                        }
                                        if (((DataBloodPress) obj) == null) {
                                            arrayList.add(i13, new DataBloodPress());
                                        }
                                    }
                                    calendar.add(5, 1);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            int size2 = arrayList.size();
                            int i15 = 0;
                            int i16 = 0;
                            int i17 = 0;
                            int i18 = 0;
                            int i19 = 0;
                            int i20 = Integer.MAX_VALUE;
                            int i21 = Integer.MAX_VALUE;
                            int i22 = 0;
                            while (i19 < size2) {
                                Object obj2 = arrayList.get(i19);
                                i19++;
                                int i23 = i22 + 1;
                                if (i22 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                DataBloodPress dataBloodPress = (DataBloodPress) obj2;
                                if (dataBloodPress.getMaxSp() > i15) {
                                    i15 = dataBloodPress.getMaxSp();
                                }
                                if (dataBloodPress.getMaxDp() > i16) {
                                    i16 = dataBloodPress.getMaxDp();
                                }
                                int minSp = dataBloodPress.getMinSp();
                                if (i11 <= minSp && minSp < i20) {
                                    i20 = dataBloodPress.getMinSp();
                                }
                                int minDp = dataBloodPress.getMinDp();
                                if (i11 <= minDp && minDp < i21) {
                                    i21 = dataBloodPress.getMinDp();
                                }
                                i17 += dataBloodPress.getAvgSp();
                                i18 += dataBloodPress.getAvgDp();
                                float f2 = i22;
                                arrayList2.add(new Entry(f2, dataBloodPress.getAvgSp()));
                                arrayList3.add(new Entry(f2, dataBloodPress.getAvgDp()));
                                if (dataBloodPress.getAvgSp() > 0) {
                                    i12++;
                                }
                                i22 = i23;
                                i11 = 1;
                            }
                            if (i12 > 0) {
                                bpChartData.setMaxSp(i15);
                                bpChartData.setMaxDp(i16);
                                bpChartData.setMinSp(i20);
                                bpChartData.setMinDp(i21);
                                bpChartData.setAvgSp(i17 / i12);
                                bpChartData.setAvgDp(i18 / i12);
                                bpChartData.setItemSps(arrayList2);
                                bpChartData.setItemDps(arrayList3);
                            }
                        }
                    }
                }
                return bpChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BPStatisticsPresenter$getMonthBpDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BpChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BpChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BPStatisticsFragment) ((g7.c) c.this.f7255a)).u0(it);
            }
        });
    }

    public final void m(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.BPStatisticsPresenter$getWeekBpDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final BpChartData invoke(String it) {
                Date date;
                Date date2;
                String str3;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                String end = str2;
                kotlin.jvm.internal.e.f(end, "end");
                BpChartData bpChartData = new BpChartData();
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
                            BloodPressImpl bloodPressImpl = BloodPressImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, bloodPressImpl.getDataByDate(g10, userId, i3, i10));
                            int i11 = 0;
                            if (arrayList.size() < 7) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(date);
                                for (int i12 = 0; i12 < 7; i12++) {
                                    long timeInMillis = calendar.getTimeInMillis();
                                    try {
                                        str3 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                                    } catch (Exception e) {
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                                        str3 = null;
                                    }
                                    if (str3 != null) {
                                        int size = arrayList.size();
                                        int i13 = 0;
                                        while (true) {
                                            if (i13 >= size) {
                                                obj = null;
                                                break;
                                            }
                                            obj = arrayList.get(i13);
                                            i13++;
                                            if (kotlin.jvm.internal.e.a(((DataBloodPress) obj).getDate(), str3)) {
                                                break;
                                            }
                                        }
                                        if (((DataBloodPress) obj) == null) {
                                            arrayList.add(i12, new DataBloodPress());
                                        }
                                    }
                                    calendar.add(5, 1);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            int size2 = arrayList.size();
                            int i14 = 0;
                            int i15 = 0;
                            int i16 = 0;
                            int i17 = 0;
                            int i18 = 0;
                            int i19 = Integer.MAX_VALUE;
                            int i20 = Integer.MAX_VALUE;
                            int i21 = 0;
                            while (i18 < size2) {
                                Object obj2 = arrayList.get(i18);
                                i18++;
                                int i22 = i21 + 1;
                                if (i21 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                DataBloodPress dataBloodPress = (DataBloodPress) obj2;
                                if (dataBloodPress.getMaxSp() > i14) {
                                    i14 = dataBloodPress.getMaxSp();
                                }
                                if (dataBloodPress.getMaxDp() > i15) {
                                    i15 = dataBloodPress.getMaxDp();
                                }
                                int minSp = dataBloodPress.getMinSp();
                                if (1 <= minSp && minSp < i20) {
                                    i20 = dataBloodPress.getMinSp();
                                }
                                int minDp = dataBloodPress.getMinDp();
                                if (1 <= minDp && minDp < i19) {
                                    i19 = dataBloodPress.getMinDp();
                                }
                                i16 += dataBloodPress.getAvgSp();
                                i17 += dataBloodPress.getAvgDp();
                                float f2 = i21;
                                arrayList2.add(new Entry(f2, dataBloodPress.getAvgSp()));
                                arrayList3.add(new Entry(f2, dataBloodPress.getAvgDp()));
                                if (dataBloodPress.getAvgSp() > 0) {
                                    i11++;
                                }
                                i21 = i22;
                            }
                            if (i11 > 0) {
                                bpChartData.setMaxSp(i14);
                                bpChartData.setMaxDp(i15);
                                bpChartData.setMinSp(i20);
                                bpChartData.setMinDp(i19);
                                bpChartData.setAvgSp(i16 / i11);
                                bpChartData.setAvgDp(i17 / i11);
                                bpChartData.setItemSps(arrayList2);
                                bpChartData.setItemDps(arrayList3);
                            }
                        }
                    }
                }
                return bpChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BPStatisticsPresenter$getWeekBpDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BpChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BpChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BPStatisticsFragment) ((g7.c) c.this.f7255a)).u0(it);
            }
        });
    }

    public final void n(String year) {
        kotlin.jvm.internal.e.f(year, "year");
        com.example.baselibrary.preseneter.b.j(year, new oh.l() { // from class: com.example.test.presenter.main.BPStatisticsPresenter$getYearBpDetail$1
            @Override // oh.l
            public final BpChartData invoke(String it) {
                int i3;
                kotlin.jvm.internal.e.f(it, "it");
                BpChartData bpChartData = new BpChartData();
                Date h4 = a2.h(it, "yyyy");
                if (h4 != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(h4);
                    int a3 = a2.a(h4);
                    ArrayList arrayList = new ArrayList();
                    int i10 = 0;
                    while (true) {
                        i3 = 1;
                        int i11 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                        if (i10 >= a3) {
                            break;
                        }
                        Date time = calendar.getTime();
                        kotlin.jvm.internal.e.e(time, "getTime(...)");
                        BpSumData bpSumData = new BpSumData();
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
                                BloodPressImpl bloodPressImpl = BloodPressImpl.INSTANCE;
                                if (com.example.test.utils.k.f8731b == null) {
                                    synchronized (com.example.test.utils.k.class) {
                                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                    }
                                }
                                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                String g10 = kVar2 != null ? kVar2.g() : null;
                                String userId = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                int i14 = Integer.MAX_VALUE;
                                int i15 = 0;
                                int i16 = 0;
                                int i17 = 0;
                                int i18 = 0;
                                int i19 = 0;
                                for (DataBloodPress dataBloodPress : bloodPressImpl.getDataByDate(g10, userId, i12, i13)) {
                                    if (dataBloodPress.getMaxSp() > i16) {
                                        i16 = dataBloodPress.getMaxSp();
                                    }
                                    if (dataBloodPress.getMaxDp() > i17) {
                                        i17 = dataBloodPress.getMaxDp();
                                    }
                                    int minSp = dataBloodPress.getMinSp();
                                    if (1 <= minSp && minSp < i11) {
                                        i11 = dataBloodPress.getMinSp();
                                    }
                                    int minDp = dataBloodPress.getMinDp();
                                    if (1 <= minDp && minDp < i14) {
                                        i14 = dataBloodPress.getMinDp();
                                    }
                                    i18 += dataBloodPress.getAvgSp();
                                    i19 += dataBloodPress.getAvgDp();
                                    if (dataBloodPress.getAvgSp() > 0) {
                                        i15++;
                                    }
                                }
                                if (i15 > 0) {
                                    bpSumData.setMaxSp(i16);
                                    bpSumData.setMaxDp(i17);
                                    bpSumData.setMinSp(i11);
                                    bpSumData.setMinDp(i14);
                                    bpSumData.setAvgSp(i18 / i15);
                                    bpSumData.setAvgDp(i19 / i15);
                                }
                            } else {
                                continue;
                            }
                        }
                        arrayList.add(bpSumData);
                        calendar.add(2, 1);
                        i10++;
                    }
                    if (a3 < 12) {
                        int i20 = 12 - a3;
                        for (int i21 = 0; i21 < i20; i21++) {
                            arrayList.add(new BpSumData());
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    int size = arrayList.size();
                    int i22 = Integer.MAX_VALUE;
                    int i23 = Integer.MAX_VALUE;
                    int i24 = 0;
                    int i25 = 0;
                    int i26 = 0;
                    int i27 = 0;
                    int i28 = 0;
                    int i29 = 0;
                    int i30 = 0;
                    while (i30 < size) {
                        Object obj = arrayList.get(i30);
                        i30++;
                        int i31 = i25 + 1;
                        if (i25 < 0) {
                            kotlin.collections.i.f();
                            throw null;
                        }
                        BpSumData bpSumData2 = (BpSumData) obj;
                        if (bpSumData2.getMaxSp() > i26) {
                            i26 = bpSumData2.getMaxSp();
                        }
                        if (bpSumData2.getMaxDp() > i27) {
                            i27 = bpSumData2.getMaxDp();
                        }
                        int minSp2 = bpSumData2.getMinSp();
                        if (i3 <= minSp2 && minSp2 < i22) {
                            i22 = bpSumData2.getMinSp();
                        }
                        int minDp2 = bpSumData2.getMinDp();
                        if (i3 <= minDp2 && minDp2 < i23) {
                            i23 = bpSumData2.getMinDp();
                        }
                        i28 += bpSumData2.getAvgSp();
                        i29 += bpSumData2.getAvgDp();
                        if (bpSumData2.getAvgSp() > 0) {
                            i24++;
                        }
                        float f2 = i25;
                        arrayList2.add(new Entry(f2, bpSumData2.getAvgSp()));
                        arrayList3.add(new Entry(f2, bpSumData2.getAvgDp()));
                        i25 = i31;
                        i3 = 1;
                    }
                    if (i24 > 0) {
                        bpChartData.setMaxSp(i26);
                        bpChartData.setMaxDp(i27);
                        bpChartData.setMinSp(i22);
                        bpChartData.setMinDp(i23);
                        bpChartData.setAvgSp(i28 / i24);
                        bpChartData.setAvgDp(i29 / i24);
                        bpChartData.setItemSps(arrayList2);
                        bpChartData.setItemDps(arrayList3);
                    }
                }
                return bpChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BPStatisticsPresenter$getYearBpDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BpChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BpChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BPStatisticsFragment) ((g7.c) c.this.f7255a)).u0(it);
            }
        });
    }
}
