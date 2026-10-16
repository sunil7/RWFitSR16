package com.example.test.presenter.main;

import com.example.database.db.BloodSugarImpl;
import com.example.database.table.DataBloodSugar;
import com.example.database.table.User;
import com.example.test.ui.main.fragment.SugarStatisticsFragment;
import com.example.test.ui.model.chart.chart.SugarChartData;
import com.example.test.ui.model.chart.chart.SugarSumData;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.a2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class h1 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.SugarStatisticsPresenter$getDayBloodSugarDetail$1
            @Override // oh.l
            public final SugarChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return com.example.test.presenter.analysis.a.a(it);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SugarStatisticsPresenter$getDayBloodSugarDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SugarChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SugarChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((SugarStatisticsFragment) ((g7.y) h1.this.f7255a)).u0(it);
            }
        });
    }

    public final void l(String start) {
        kotlin.jvm.internal.e.f(start, "start");
        com.example.baselibrary.preseneter.b.j(start, new oh.l() { // from class: com.example.test.presenter.main.SugarStatisticsPresenter$getMonthBloodSugarDetail$1
            @Override // oh.l
            public final SugarChartData invoke(String it) {
                String str;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                SugarChartData sugarChartData = new SugarChartData();
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
                            BloodSugarImpl bloodSugarImpl = BloodSugarImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d8.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, bloodSugarImpl.getDataByDate(g10, userId, i3, i10));
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
                                            if (kotlin.jvm.internal.e.a(((DataBloodSugar) obj).getDate(), str)) {
                                                break;
                                            }
                                        }
                                        if (((DataBloodSugar) obj) == null) {
                                            arrayList.add(i12, new DataBloodSugar());
                                        }
                                    }
                                    calendar.add(5, 1);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size2 = arrayList.size();
                            float f2 = 0.0f;
                            float f10 = 0.0f;
                            int i14 = 0;
                            float f11 = Float.MAX_VALUE;
                            int i15 = 0;
                            while (i14 < size2) {
                                Object obj2 = arrayList.get(i14);
                                i14++;
                                int i16 = i15 + 1;
                                if (i15 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                DataBloodSugar dataBloodSugar = (DataBloodSugar) obj2;
                                if (dataBloodSugar.getMaxSugar() > f2) {
                                    f2 = dataBloodSugar.getMaxSugar();
                                }
                                if (dataBloodSugar.getMinSugar() < f11 && dataBloodSugar.getMinSugar() > 0.0f) {
                                    f11 = dataBloodSugar.getMinSugar();
                                }
                                arrayList2.add(new Entry(i15, dataBloodSugar.getAvgSugar()));
                                if (dataBloodSugar.getAvgSugar() > 0.0f) {
                                    f10 += dataBloodSugar.getAvgSugar();
                                    i11++;
                                }
                                i15 = i16;
                            }
                            if (i11 > 0) {
                                sugarChartData.setMaxSugar(f2);
                                sugarChartData.setMinSugar(f11);
                                sugarChartData.setAvgSugar(f10 / i11);
                                sugarChartData.setItems(arrayList2);
                            }
                        }
                    }
                }
                return sugarChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SugarStatisticsPresenter$getMonthBloodSugarDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SugarChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SugarChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((SugarStatisticsFragment) ((g7.y) h1.this.f7255a)).u0(it);
            }
        });
    }

    public final void m(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.SugarStatisticsPresenter$getWeekBloodSugarDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final SugarChartData invoke(String it) {
                Date date;
                Date date2;
                String str3;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                String end = str2;
                kotlin.jvm.internal.e.f(end, "end");
                SugarChartData sugarChartData = new SugarChartData();
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
                            BloodSugarImpl bloodSugarImpl = BloodSugarImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, bloodSugarImpl.getDataByDate(g10, userId, i3, i10));
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
                                            if (kotlin.jvm.internal.e.a(((DataBloodSugar) obj).getDate(), str3)) {
                                                break;
                                            }
                                        }
                                        if (((DataBloodSugar) obj) == null) {
                                            arrayList.add(i12, new DataBloodSugar());
                                        }
                                    }
                                    calendar.add(5, 1);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size2 = arrayList.size();
                            float f2 = 0.0f;
                            float f10 = 0.0f;
                            float f11 = 0.0f;
                            int i14 = 0;
                            float f12 = Float.MAX_VALUE;
                            int i15 = 0;
                            while (i14 < size2) {
                                Object obj2 = arrayList.get(i14);
                                i14++;
                                int i16 = i15 + 1;
                                if (i15 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                DataBloodSugar dataBloodSugar = (DataBloodSugar) obj2;
                                if (dataBloodSugar.getMaxSugar() > f10) {
                                    f10 = dataBloodSugar.getMaxSugar();
                                }
                                if (dataBloodSugar.getMinSugar() < f12 && dataBloodSugar.getMinSugar() > f2) {
                                    f12 = dataBloodSugar.getMinSugar();
                                }
                                float f13 = f2;
                                arrayList2.add(new Entry(i15, dataBloodSugar.getAvgSugar()));
                                if (dataBloodSugar.getAvgSugar() > f13) {
                                    f11 += dataBloodSugar.getAvgSugar();
                                    i11++;
                                }
                                f2 = f13;
                                i15 = i16;
                            }
                            if (i11 > 0) {
                                sugarChartData.setMaxSugar(f10);
                                sugarChartData.setMinSugar(f12);
                                sugarChartData.setAvgSugar(f11 / i11);
                                sugarChartData.setItems(arrayList2);
                            }
                        }
                    }
                }
                return sugarChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SugarStatisticsPresenter$getWeekBloodSugarDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SugarChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SugarChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((SugarStatisticsFragment) ((g7.y) h1.this.f7255a)).u0(it);
            }
        });
    }

    public final void n(String start) {
        kotlin.jvm.internal.e.f(start, "start");
        com.example.baselibrary.preseneter.b.j(start, new oh.l() { // from class: com.example.test.presenter.main.SugarStatisticsPresenter$getYearBloodSugarDetail$1
            @Override // oh.l
            public final SugarChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                SugarChartData sugarChartData = new SugarChartData();
                Date h4 = a2.h(it, "yyyy");
                if (h4 != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(h4);
                    int a3 = a2.a(h4);
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    int i10 = 0;
                    while (true) {
                        float f2 = Float.MAX_VALUE;
                        if (i10 >= a3) {
                            break;
                        }
                        Date time = calendar.getTime();
                        kotlin.jvm.internal.e.e(time, "getTime(...)");
                        SugarSumData sugarSumData = new SugarSumData();
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
                                BloodSugarImpl bloodSugarImpl = BloodSugarImpl.INSTANCE;
                                if (com.example.test.utils.k.f8731b == null) {
                                    synchronized (com.example.test.utils.k.class) {
                                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                    }
                                }
                                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                String g10 = kVar2 != null ? kVar2.g() : null;
                                String userId = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                int i13 = 0;
                                float f10 = 0.0f;
                                float f11 = 0.0f;
                                for (DataBloodSugar dataBloodSugar : bloodSugarImpl.getDataByDate(g10, userId, i11, i12)) {
                                    if (dataBloodSugar.getMaxSugar() > f10) {
                                        f10 = dataBloodSugar.getMaxSugar();
                                    }
                                    if (dataBloodSugar.getMinSugar() < f2 && dataBloodSugar.getMinSugar() > 0.0f) {
                                        f2 = dataBloodSugar.getMinSugar();
                                    }
                                    if (dataBloodSugar.getAvgSugar() > 0.0f) {
                                        f11 += dataBloodSugar.getAvgSugar();
                                        i13++;
                                    }
                                }
                                if (i13 > 0) {
                                    sugarSumData.setMaxSugar(f10);
                                    sugarSumData.setMinSugar(f2);
                                    sugarSumData.setAvgSugar(f11 / i13);
                                }
                            } else {
                                continue;
                            }
                        }
                        arrayList.add(sugarSumData);
                        calendar.add(2, 1);
                        i10++;
                    }
                    if (a3 < 12) {
                        int i14 = 12 - a3;
                        for (int i15 = 0; i15 < i14; i15++) {
                            arrayList.add(new SugarSumData());
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i16 = 0;
                    float f12 = Float.MAX_VALUE;
                    float f13 = 0.0f;
                    float f14 = 0.0f;
                    int i17 = 0;
                    while (i17 < size) {
                        Object obj = arrayList.get(i17);
                        i17++;
                        int i18 = i16 + 1;
                        if (i16 < 0) {
                            kotlin.collections.i.f();
                            throw null;
                        }
                        SugarSumData sugarSumData2 = (SugarSumData) obj;
                        if (sugarSumData2.getMaxSugar() > f13) {
                            f13 = sugarSumData2.getMaxSugar();
                        }
                        if (sugarSumData2.getMinSugar() < f12 && sugarSumData2.getMinSugar() > 0.0f) {
                            f12 = sugarSumData2.getMinSugar();
                        }
                        f14 += sugarSumData2.getAvgSugar();
                        if (sugarSumData2.getAvgSugar() > 0.0f) {
                            i3++;
                        }
                        arrayList2.add(new Entry(i16, sugarSumData2.getAvgSugar()));
                        i16 = i18;
                    }
                    if (i3 > 0) {
                        sugarChartData.setMaxSugar(f13);
                        sugarChartData.setMinSugar(f12);
                        sugarChartData.setAvgSugar(f14 / i3);
                        sugarChartData.setItems(arrayList2);
                    }
                }
                return sugarChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SugarStatisticsPresenter$getYearBloodSugarDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SugarChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SugarChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((SugarStatisticsFragment) ((g7.y) h1.this.f7255a)).u0(it);
            }
        });
    }
}
