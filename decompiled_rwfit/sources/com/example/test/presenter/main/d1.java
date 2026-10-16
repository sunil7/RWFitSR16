package com.example.test.presenter.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.database.db.SleepImpl;
import com.example.database.table.DataSleep;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.main.fragment.SleepStatisticsFragment;
import com.example.test.ui.model.chart.chart.SleepChartData;
import com.example.test.ui.model.chart.chart.SleepData;
import com.example.test.ui.model.chart.chart.SleepItemData;
import com.example.test.ui.model.chart.chart.SleepStaChartData;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.SleepDetailChartView;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.gms.internal.mlkit_vision_barcode.a2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.fc;
import f6.p3;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class d1 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(final String time) {
        kotlin.jvm.internal.e.f(time, "time");
        com.example.baselibrary.preseneter.b.j(time, new oh.l() { // from class: com.example.test.presenter.main.SleepStatisticsPresenter$getDaySleepData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final SleepChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return com.example.test.presenter.analysis.a.e(time);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SleepStatisticsPresenter$getDaySleepData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SleepChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SleepChartData it) {
                LinearLayout linearLayout;
                kotlin.jvm.internal.e.f(it, "it");
                SleepStatisticsFragment sleepStatisticsFragment = (SleepStatisticsFragment) ((g7.u) d1.this.f7255a);
                sleepStatisticsFragment.getClass();
                List<SleepItemData> items = it.getItems();
                if (items == null || items.isEmpty()) {
                    p3 p3Var = (p3) sleepStatisticsFragment.f7251b;
                    TextView textView = p3Var != null ? p3Var.f13243n : null;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    p3 p3Var2 = (p3) sleepStatisticsFragment.f7251b;
                    linearLayout = p3Var2 != null ? p3Var2.f13241l : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                } else {
                    p3 p3Var3 = (p3) sleepStatisticsFragment.f7251b;
                    TextView textView2 = p3Var3 != null ? p3Var3.f13243n : null;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    p3 p3Var4 = (p3) sleepStatisticsFragment.f7251b;
                    linearLayout = p3Var4 != null ? p3Var4.f13241l : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    p3 p3Var5 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var5 != null) {
                        SleepDetailChartView sleepDetailChartView = p3Var5.f13233c;
                        final d1 d1Var = (d1) sleepStatisticsFragment.X();
                        List<SleepItemData> items2 = it.getItems();
                        kotlin.jvm.internal.e.e(items2, "getItems(...)");
                        final float width = sleepDetailChartView.getWidth();
                        final float height = sleepDetailChartView.getHeight();
                        d1Var.getClass();
                        com.example.baselibrary.preseneter.b.j(items2, new oh.l() { // from class: com.example.test.presenter.main.SleepStatisticsPresenter$invokeDayChart$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // oh.l
                            public final List<x6.a> invoke(List<? extends SleepItemData> it2) {
                                kotlin.jvm.internal.e.f(it2, "it");
                                return fc.c(it2, width, height);
                            }
                        }, new oh.l() { // from class: com.example.test.presenter.main.SleepStatisticsPresenter$invokeDayChart$2
                            {
                                super(1);
                            }

                            @Override // oh.l
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((List<? extends x6.a>) obj);
                                return eh.g.f12633a;
                            }

                            public final void invoke(List<? extends x6.a> it2) {
                                kotlin.jvm.internal.e.f(it2, "it");
                                SleepStatisticsFragment sleepStatisticsFragment2 = (SleepStatisticsFragment) ((g7.u) d1.this.f7255a);
                                sleepStatisticsFragment2.getClass();
                                Object obj = sleepStatisticsFragment2.f7251b;
                                kotlin.jvm.internal.e.c(obj);
                                ((p3) obj).f13233c.setData(it2);
                            }
                        });
                        Object obj = sleepStatisticsFragment.f7251b;
                        kotlin.jvm.internal.e.c(obj);
                        String startTime = it.getStartTime();
                        String endTime = it.getEndTime();
                        SleepDetailChartView sleepDetailChartView2 = ((p3) obj).f13233c;
                        sleepDetailChartView2.f8582j = startTime;
                        sleepDetailChartView2.f8583k = endTime;
                    }
                }
                String sleepTime = it.getSleepTime();
                if (sleepTime == null || sleepTime.length() == 0) {
                    p3 p3Var6 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var6 != null) {
                        p3Var6.f13236g.setValue("00H00M");
                    }
                } else {
                    p3 p3Var7 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var7 != null) {
                        DataView dataView = p3Var7.f13236g;
                        String sleepTime2 = it.getSleepTime();
                        kotlin.jvm.internal.e.e(sleepTime2, "getSleepTime(...)");
                        dataView.setValue(sleepTime2);
                    }
                }
                String deepSleepTime = it.getDeepSleepTime();
                if (deepSleepTime == null || deepSleepTime.length() == 0) {
                    p3 p3Var8 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var8 != null) {
                        p3Var8.f13234d.setValue("00H00M");
                    }
                } else {
                    p3 p3Var9 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var9 != null) {
                        DataView dataView2 = p3Var9.f13234d;
                        String deepSleepTime2 = it.getDeepSleepTime();
                        kotlin.jvm.internal.e.e(deepSleepTime2, "getDeepSleepTime(...)");
                        dataView2.setValue(deepSleepTime2);
                    }
                }
                String lightSleepTime = it.getLightSleepTime();
                if (lightSleepTime == null || lightSleepTime.length() == 0) {
                    p3 p3Var10 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var10 != null) {
                        p3Var10.e.setValue("00H00M");
                    }
                } else {
                    p3 p3Var11 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var11 != null) {
                        DataView dataView3 = p3Var11.e;
                        String lightSleepTime2 = it.getLightSleepTime();
                        kotlin.jvm.internal.e.e(lightSleepTime2, "getLightSleepTime(...)");
                        dataView3.setValue(lightSleepTime2);
                    }
                }
                String startTime2 = it.getStartTime();
                if (startTime2 == null || startTime2.length() == 0) {
                    p3 p3Var12 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var12 != null) {
                        p3Var12.f13235f.setValue("--:--");
                    }
                } else {
                    p3 p3Var13 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var13 != null) {
                        DataView dataView4 = p3Var13.f13235f;
                        String startTime3 = it.getStartTime();
                        kotlin.jvm.internal.e.e(startTime3, "getStartTime(...)");
                        dataView4.setValue(startTime3);
                    }
                }
                String endTime2 = it.getEndTime();
                if (endTime2 == null || endTime2.length() == 0) {
                    p3 p3Var14 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var14 != null) {
                        p3Var14.f13237h.setValue("--:--");
                    }
                } else {
                    p3 p3Var15 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var15 != null) {
                        DataView dataView5 = p3Var15.f13237h;
                        String endTime3 = it.getEndTime();
                        kotlin.jvm.internal.e.e(endTime3, "getEndTime(...)");
                        dataView5.setValue(endTime3);
                    }
                }
                if (!y5.d.f20005b) {
                    p3 p3Var16 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var16 != null) {
                        DataView dataView6 = p3Var16.f13238i;
                        String string = sleepStatisticsFragment.getString(R$string.str_wake_times);
                        kotlin.jvm.internal.e.e(string, "getString(...)");
                        dataView6.setTitle(string);
                    }
                    p3 p3Var17 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var17 != null) {
                        p3Var17.f13238i.setValue(String.format("%d%s", Arrays.copyOf(new Object[]{Integer.valueOf(it.getWakeupTimes()), sleepStatisticsFragment.getString(R$string.str_count)}, 2)));
                        return;
                    }
                    return;
                }
                p3 p3Var18 = (p3) sleepStatisticsFragment.f7251b;
                if (p3Var18 != null) {
                    DataView dataView7 = p3Var18.f13238i;
                    String string2 = sleepStatisticsFragment.getString(R$string.str_wake_timelong);
                    kotlin.jvm.internal.e.e(string2, "getString(...)");
                    dataView7.setTitle(string2);
                }
                String wakeSleepTime = it.getWakeSleepTime();
                if (wakeSleepTime == null || wakeSleepTime.length() == 0) {
                    p3 p3Var19 = (p3) sleepStatisticsFragment.f7251b;
                    if (p3Var19 != null) {
                        p3Var19.f13238i.setValue("00H00M");
                        return;
                    }
                    return;
                }
                p3 p3Var20 = (p3) sleepStatisticsFragment.f7251b;
                if (p3Var20 != null) {
                    DataView dataView8 = p3Var20.f13238i;
                    String wakeSleepTime2 = it.getWakeSleepTime();
                    kotlin.jvm.internal.e.e(wakeSleepTime2, "getWakeSleepTime(...)");
                    dataView8.setValue(wakeSleepTime2);
                }
            }
        });
    }

    public final void l(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.SleepStatisticsPresenter$getMonthSleepData$1
            @Override // oh.l
            public final SleepStaChartData invoke(String it) {
                String str;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                SleepStaChartData sleepStaChartData = new SleepStaChartData();
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
                            SleepImpl sleepImpl = SleepImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d8.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, sleepImpl.getDataByDate(g10, userId, i3, i10));
                            int b3 = a2.b(d5);
                            int i11 = 0;
                            if (arrayList.size() > 0 && arrayList.size() < b3) {
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
                                            if (kotlin.jvm.internal.e.a(((DataSleep) obj).getDate(), str)) {
                                                break;
                                            }
                                        }
                                        if (((DataSleep) obj) == null) {
                                            arrayList.add(i12, new DataSleep());
                                        }
                                    }
                                    calendar.add(5, 1);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size2 = arrayList.size();
                            int i14 = 0;
                            long j4 = 0;
                            long j10 = 0;
                            int i15 = 0;
                            long j11 = 0;
                            while (i15 < size2) {
                                Object obj2 = arrayList.get(i15);
                                int i16 = i15 + 1;
                                int i17 = i14 + 1;
                                if (i14 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                DataSleep dataSleep = (DataSleep) obj2;
                                j11 = dataSleep.getSleepLightTime() + dataSleep.getSleepDeepTime() + j11;
                                j4 = dataSleep.getSleepDeepTime() + j4;
                                j10 = dataSleep.getSleepLightTime() + j10;
                                i11 = dataSleep.getWakeupCount() + i11;
                                arrayList2.add(new BarEntry(i14, dataSleep.getTotalSleepTime() / 60.0f));
                                i14 = i17;
                                arrayList = arrayList;
                                i15 = i16;
                            }
                            sleepStaChartData.setItems(arrayList2);
                            long j12 = 60;
                            sleepStaChartData.setTotalTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(j11 / j12), Long.valueOf(j11 % j12)}, 2)));
                            sleepStaChartData.setDeepTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(j4 / j12), Long.valueOf(j4 % j12)}, 2)));
                            sleepStaChartData.setLightTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(j10 / j12), Long.valueOf(j10 % j12)}, 2)));
                            sleepStaChartData.setWakeTimes(i11);
                        }
                    }
                }
                return sleepStaChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SleepStatisticsPresenter$getMonthSleepData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SleepStaChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SleepStaChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((SleepStatisticsFragment) ((g7.u) d1.this.f7255a)).q0(it);
            }
        });
    }

    public final void m(final String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.SleepStatisticsPresenter$getWeekSleepData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final SleepStaChartData invoke(String it) {
                Date date;
                Date date2;
                String str3;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                String startTime = str;
                String endTime = str2;
                kotlin.jvm.internal.e.f(startTime, "startTime");
                kotlin.jvm.internal.e.f(endTime, "endTime");
                SleepStaChartData sleepStaChartData = new SleepStaChartData();
                try {
                    date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(startTime);
                } catch (Exception unused) {
                    date = null;
                }
                try {
                    date2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(endTime);
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
                            SleepImpl sleepImpl = SleepImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            arrayList.addAll(sleepImpl.getDataByDate(g10, userId, i3, i10));
                            int i11 = 0;
                            if (arrayList.size() > 0 && arrayList.size() < 7) {
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
                                            if (kotlin.jvm.internal.e.a(((DataSleep) obj).getDate(), str3)) {
                                                break;
                                            }
                                        }
                                        if (((DataSleep) obj) == null) {
                                            arrayList.add(i12, new DataSleep());
                                        }
                                    }
                                    calendar.add(5, 1);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int i14 = 0;
                            long j4 = 0;
                            long j10 = 0;
                            int i15 = 0;
                            long j11 = 0;
                            for (int size2 = arrayList.size(); i15 < size2; size2 = size2) {
                                Object obj2 = arrayList.get(i15);
                                i15++;
                                int i16 = i14 + 1;
                                if (i14 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                DataSleep dataSleep = (DataSleep) obj2;
                                j11 = dataSleep.getSleepLightTime() + dataSleep.getSleepDeepTime() + dataSleep.getWakeupCount() + j11;
                                j4 += dataSleep.getSleepDeepTime();
                                j10 += dataSleep.getSleepLightTime();
                                i11 += dataSleep.getWakeupCount();
                                arrayList2.add(new BarEntry(i14, dataSleep.getTotalSleepTime() / 60.0f));
                                i14 = i16;
                            }
                            sleepStaChartData.setItems(arrayList2);
                            long j12 = 60;
                            sleepStaChartData.setTotalTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(j11 / j12), Long.valueOf(j11 % j12)}, 2)));
                            sleepStaChartData.setDeepTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(j4 / j12), Long.valueOf(j4 % j12)}, 2)));
                            sleepStaChartData.setLightTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(j10 / j12), Long.valueOf(j10 % j12)}, 2)));
                            sleepStaChartData.setWakeTimes(i11);
                        }
                    }
                }
                return sleepStaChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SleepStatisticsPresenter$getWeekSleepData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SleepStaChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SleepStaChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((SleepStatisticsFragment) ((g7.u) d1.this.f7255a)).q0(it);
            }
        });
    }

    public final void n(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.SleepStatisticsPresenter$getYearSleepData$1
            @Override // oh.l
            public final SleepStaChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                SleepStaChartData sleepStaChartData = new SleepStaChartData();
                Date h4 = a2.h(it, "yyyy");
                if (h4 != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(h4);
                    int a3 = a2.a(h4);
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    for (int i10 = 0; i10 < a3; i10++) {
                        Date time = calendar.getTime();
                        kotlin.jvm.internal.e.e(time, "getTime(...)");
                        SleepData sleepData = new SleepData();
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
                                SleepImpl sleepImpl = SleepImpl.INSTANCE;
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
                                long j4 = 0;
                                long j10 = 0;
                                long j11 = 0;
                                for (DataSleep dataSleep : sleepImpl.getDataByDate(g10, userId, i11, i12)) {
                                    j11 = dataSleep.getSleepLightTime() + dataSleep.getSleepDeepTime() + j11;
                                    j10 = dataSleep.getSleepDeepTime() + j10;
                                    j4 = dataSleep.getSleepLightTime() + j4;
                                    i13 = dataSleep.getWakeupCount() + i13;
                                }
                                sleepData.setWakeupTimes(i13);
                                sleepData.setLightSleepTime(j4);
                                sleepData.setDeepSleepTime(j10);
                                sleepData.setTotalTime(j11);
                            } else {
                                continue;
                            }
                        }
                        arrayList.add(sleepData);
                        calendar.add(2, 1);
                    }
                    if (a3 < 12) {
                        int i14 = 12 - a3;
                        for (int i15 = 0; i15 < i14; i15++) {
                            arrayList.add(new SleepData());
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i16 = 0;
                    int i17 = 0;
                    long j12 = 0;
                    long j13 = 0;
                    long j14 = 0;
                    while (i17 < size) {
                        Object obj = arrayList.get(i17);
                        i17++;
                        int i18 = i3 + 1;
                        if (i3 < 0) {
                            kotlin.collections.i.f();
                            throw null;
                        }
                        SleepData sleepData2 = (SleepData) obj;
                        j12 = sleepData2.getTotalTime() + j12;
                        j13 = sleepData2.getDeepSleepTime() + j13;
                        j14 = sleepData2.getLightSleepTime() + j14;
                        i16 = sleepData2.getWakeupTimes() + i16;
                        arrayList2.add(new BarEntry(i3, sleepData2.getTotalTime() / 60.0f));
                        i3 = i18;
                    }
                    if (j12 > 0) {
                        sleepStaChartData.setItems(arrayList2);
                    }
                    long j15 = 60;
                    sleepStaChartData.setTotalTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(j12 / j15), Long.valueOf(j12 % j15)}, 2)));
                    sleepStaChartData.setDeepTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(j13 / j15), Long.valueOf(j13 % j15)}, 2)));
                    sleepStaChartData.setLightTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(j14 / j15), Long.valueOf(j14 % j15)}, 2)));
                    sleepStaChartData.setWakeTimes(i16);
                }
                return sleepStaChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SleepStatisticsPresenter$getYearSleepData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SleepStaChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SleepStaChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((SleepStatisticsFragment) ((g7.u) d1.this.f7255a)).q0(it);
            }
        });
    }
}
