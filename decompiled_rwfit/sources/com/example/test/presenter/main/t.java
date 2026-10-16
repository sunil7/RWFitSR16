package com.example.test.presenter.main;

import com.example.database.db.BreatheImpl;
import com.example.database.table.DataBreathe;
import com.example.database.table.User;
import com.example.test.ui.main.fragment.BreatheStatisticsFragment;
import com.example.test.ui.model.chart.chart.BreatheChartData;
import com.example.test.ui.model.chart.chart.BreatheSumData;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.gms.internal.mlkit_vision_barcode.a2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public final class t extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String startDate) {
        kotlin.jvm.internal.e.f(startDate, "startDate");
        com.example.baselibrary.preseneter.b.j(startDate, new oh.l() { // from class: com.example.test.presenter.main.BreatheStatisticsPresenter$getMonthBreatheDetail$1
            @Override // oh.l
            public final BreatheChartData invoke(String it) {
                String str;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                BreatheChartData breatheChartData = new BreatheChartData();
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
                            BreatheImpl breatheImpl = BreatheImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d8.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, breatheImpl.getDataByDate(g10, userId, i3, i10));
                            int b3 = a2.b(d5);
                            if (arrayList.size() > 0 && arrayList.size() < b3) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(d5);
                                for (int i11 = 0; i11 < b3; i11++) {
                                    long timeInMillis = calendar.getTimeInMillis();
                                    try {
                                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                                    } catch (Exception e) {
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                                        str = null;
                                    }
                                    if (str != null) {
                                        int size = arrayList.size();
                                        int i12 = 0;
                                        while (true) {
                                            if (i12 >= size) {
                                                obj = null;
                                                break;
                                            }
                                            obj = arrayList.get(i12);
                                            i12++;
                                            if (kotlin.jvm.internal.e.a(((DataBreathe) obj).getDate(), str)) {
                                                break;
                                            }
                                        }
                                        if (((DataBreathe) obj) == null) {
                                            arrayList.add(i11, new DataBreathe());
                                        }
                                    }
                                    calendar.add(5, 1);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size2 = arrayList.size();
                            float f2 = 0.0f;
                            int i13 = 0;
                            int i14 = 0;
                            while (i14 < size2) {
                                Object obj2 = arrayList.get(i14);
                                i14++;
                                int i15 = i13 + 1;
                                if (i13 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                Integer totalTime = ((DataBreathe) obj2).getTotalTime();
                                float intValue = totalTime == null ? 0 : totalTime.intValue();
                                f2 += intValue;
                                arrayList2.add(new BarEntry(i13, intValue));
                                i13 = i15;
                            }
                            breatheChartData.setTotalTimes(f2);
                            breatheChartData.setItems(arrayList2);
                            Calendar calendar2 = Calendar.getInstance();
                            calendar2.setTime(d5);
                            calendar2.set(11, 0);
                            calendar2.set(12, 0);
                            calendar2.set(13, 0);
                            calendar2.set(14, 0);
                            int actualMaximum = calendar2.getActualMaximum(5);
                            Calendar calendar3 = Calendar.getInstance();
                            calendar3.setTime(calendar2.getTime());
                            calendar3.set(5, actualMaximum);
                            if (calendar3.getTimeInMillis() > calendar2.getTimeInMillis()) {
                                actualMaximum = Calendar.getInstance().get(5);
                            }
                            breatheChartData.setAvgTimes(f2 / actualMaximum);
                        }
                    }
                }
                return breatheChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BreatheStatisticsPresenter$getMonthBreatheDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BreatheChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BreatheChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BreatheStatisticsFragment) ((g7.j) t.this.f7255a)).q0(it);
            }
        });
    }

    public final void l(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.BreatheStatisticsPresenter$getWeekBreatheDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final BreatheChartData invoke(String it) {
                Date date;
                Date date2;
                String str3;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                String end = str2;
                kotlin.jvm.internal.e.f(end, "end");
                BreatheChartData breatheChartData = new BreatheChartData();
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
                            BreatheImpl breatheImpl = BreatheImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, breatheImpl.getDataByDate(g10, userId, i3, i10));
                            if (arrayList.size() > 0 && arrayList.size() < 7) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(date);
                                for (int i11 = 0; i11 < 7; i11++) {
                                    long timeInMillis = calendar.getTimeInMillis();
                                    try {
                                        str3 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                                    } catch (Exception e) {
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                                        str3 = null;
                                    }
                                    if (str3 != null) {
                                        int size = arrayList.size();
                                        int i12 = 0;
                                        while (true) {
                                            if (i12 >= size) {
                                                obj = null;
                                                break;
                                            }
                                            obj = arrayList.get(i12);
                                            i12++;
                                            if (kotlin.jvm.internal.e.a(((DataBreathe) obj).getDate(), str3)) {
                                                break;
                                            }
                                        }
                                        if (((DataBreathe) obj) == null) {
                                            arrayList.add(i11, new DataBreathe());
                                        }
                                    }
                                    calendar.add(5, 1);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size2 = arrayList.size();
                            float f2 = 0.0f;
                            int i13 = 0;
                            int i14 = 0;
                            while (i14 < size2) {
                                Object obj2 = arrayList.get(i14);
                                i14++;
                                int i15 = i13 + 1;
                                if (i13 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                Integer totalTime = ((DataBreathe) obj2).getTotalTime();
                                float intValue = totalTime == null ? 0 : totalTime.intValue();
                                f2 += intValue;
                                arrayList2.add(new BarEntry(i13, intValue));
                                i13 = i15;
                            }
                            breatheChartData.setTotalTimes(f2);
                            breatheChartData.setItems(arrayList2);
                            Calendar calendar2 = Calendar.getInstance();
                            calendar2.setTime(date);
                            calendar2.set(11, 0);
                            calendar2.set(12, 0);
                            calendar2.set(13, 0);
                            calendar2.set(14, 0);
                            int actualMaximum = calendar2.getActualMaximum(7);
                            Calendar calendar3 = Calendar.getInstance();
                            calendar3.setTime(calendar2.getTime());
                            calendar3.set(7, actualMaximum);
                            if (calendar3.getTimeInMillis() > calendar2.getTimeInMillis()) {
                                actualMaximum = Calendar.getInstance().get(7);
                            }
                            breatheChartData.setAvgTimes(f2 / actualMaximum);
                        }
                    }
                }
                return breatheChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BreatheStatisticsPresenter$getWeekBreatheDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BreatheChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BreatheChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BreatheStatisticsFragment) ((g7.j) t.this.f7255a)).q0(it);
            }
        });
    }

    public final void m(String startDate) {
        kotlin.jvm.internal.e.f(startDate, "startDate");
        com.example.baselibrary.preseneter.b.j(startDate, new oh.l() { // from class: com.example.test.presenter.main.BreatheStatisticsPresenter$getYearBreatheDetail$1
            @Override // oh.l
            public final BreatheChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                BreatheChartData breatheChartData = new BreatheChartData();
                Date h4 = a2.h(it, "yyyy");
                if (h4 != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(h4);
                    int a3 = a2.a(h4);
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= a3) {
                            break;
                        }
                        Date time = calendar.getTime();
                        kotlin.jvm.internal.e.e(time, "getTime(...)");
                        BreatheSumData breatheSumData = new BreatheSumData();
                        Date v6 = android.support.v4.media.session.e.v(Calendar.getInstance(), time, 5, 5, "getTime(...)");
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTime(time);
                        calendar2.set(5, calendar2.getActualMaximum(5));
                        Date time2 = calendar2.getTime();
                        kotlin.jvm.internal.e.e(time2, "getTime(...)");
                        String i11 = ca.i(v6.getTime(), "yyyyMMdd");
                        String i12 = ca.i(time2.getTime(), "yyyyMMdd");
                        if (i11 != null && i12 != null) {
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                            User d5 = kVar != null ? kVar.d() : null;
                            if (d5 != null) {
                                BreatheImpl breatheImpl = BreatheImpl.INSTANCE;
                                if (com.example.test.utils.k.f8731b == null) {
                                    synchronized (com.example.test.utils.k.class) {
                                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                    }
                                }
                                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                String g10 = kVar2 != null ? kVar2.g() : null;
                                String userId = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                Iterator<T> it2 = breatheImpl.getDataByDate(g10, userId, i11, i12).iterator();
                                int i13 = 0;
                                while (it2.hasNext()) {
                                    Integer totalTime = ((DataBreathe) it2.next()).getTotalTime();
                                    kotlin.jvm.internal.e.e(totalTime, "getTotalTime(...)");
                                    i13 += totalTime.intValue();
                                }
                                breatheSumData.setTotalBreatheTime(i13);
                            } else {
                                continue;
                            }
                        }
                        arrayList.add(breatheSumData);
                        calendar.add(2, 1);
                        i10++;
                    }
                    if (a3 < 12) {
                        int i14 = 12 - a3;
                        for (int i15 = 0; i15 < i14; i15++) {
                            arrayList.add(new BreatheSumData());
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i16 = 0;
                    int i17 = 0;
                    while (i17 < size) {
                        Object obj = arrayList.get(i17);
                        i17++;
                        int i18 = i16 + 1;
                        if (i16 < 0) {
                            kotlin.collections.i.f();
                            throw null;
                        }
                        int totalBreatheTime = ((BreatheSumData) obj).getTotalBreatheTime();
                        i3 += totalBreatheTime;
                        arrayList2.add(new BarEntry(i16, totalBreatheTime));
                        i16 = i18;
                    }
                    breatheChartData.setTotalTimes(i3);
                    breatheChartData.setAvgTimes(i3 / a2.a(h4));
                    if (i3 > 0) {
                        breatheChartData.setItems(arrayList2);
                    }
                }
                return breatheChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BreatheStatisticsPresenter$getYearBreatheDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BreatheChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BreatheChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BreatheStatisticsFragment) ((g7.j) t.this.f7255a)).q0(it);
            }
        });
    }
}
