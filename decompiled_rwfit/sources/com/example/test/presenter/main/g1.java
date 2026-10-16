package com.example.test.presenter.main;

import com.example.database.db.RawStepsImpl;
import com.example.database.db.StepsImpl;
import com.example.database.table.DataStep;
import com.example.database.table.RawDataStep;
import com.example.database.table.User;
import com.example.test.ui.main.fragment.StepStatisticsFragment;
import com.example.test.ui.model.chart.chart.StepChartData;
import com.example.test.ui.model.chart.chart.StepData;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.gms.internal.mlkit_vision_barcode.a2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class g1 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.StepStatisticsPresenter$getDayStepStatistics$1
            @Override // oh.l
            public final StepChartData invoke(String dateTime) {
                kotlin.jvm.internal.e.f(dateTime, "dateTime");
                if (y5.d.f20005b) {
                    Object obj = com.example.test.utils.m.f8734b;
                    if (!d2.a().a()) {
                        return com.example.test.presenter.analysis.a.g(dateTime);
                    }
                }
                return com.example.test.presenter.analysis.a.f(dateTime);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.StepStatisticsPresenter$getDayStepStatistics$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StepChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(StepChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((StepStatisticsFragment) ((g7.x) g1.this.f7255a)).R(it);
            }
        });
    }

    public final void l(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.StepStatisticsPresenter$getDayStepStatistics$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(2:3|(13:5|6|7|8|9|10|11|12|13|14|(1:16)|(5:18|(2:20|5d)|29|(1:31)(1:96)|(2:33|(14:36|(2:38|9c)|46|(1:48)(1:95)|49|(3:53|(5:55|56|57|(4:59|(1:(2:61|(1:63)(1:70))(2:71|72))|64|(2:66|67)(1:69))(1:73)|68)|77)|78|(2:80|(1:82)(3:83|84|85))|86|87|(1:89)|90|(1:92)(1:94)|93)))|97))|105|106|107|108|109|110|111|(1:113)|(5:115|(2:117|224)|125|(1:127)(1:192)|(2:129|(14:132|(2:134|263)|142|(1:144)(1:191)|145|(2:147|(3:149|(5:151|152|153|(4:155|(1:(2:157|(1:159)(1:166))(2:167|168))|160|(2:162|163)(1:165))(1:169)|164)|173))|174|(2:176|(1:178)(3:179|180|181))|182|183|(1:185)|186|(1:188)(1:190)|189)))|97|(1:(0))) */
            /* JADX WARN: Code restructure failed: missing block: B:194:0x0213, code lost:
            
                r0 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:196:0x0203, code lost:
            
                r3 = null;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
            /* JADX WARN: Type inference failed for: r0v33 */
            /* JADX WARN: Type inference failed for: r0v34 */
            /* JADX WARN: Type inference failed for: r0v35, types: [java.util.Date] */
            /* JADX WARN: Type inference failed for: r0v42, types: [java.util.Calendar] */
            /* JADX WARN: Type inference failed for: r0v60, types: [java.util.Date] */
            /* JADX WARN: Type inference failed for: r0v63 */
            /* JADX WARN: Type inference failed for: r12v12 */
            /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r12v26 */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r2v17, types: [com.example.database.table.User] */
            /* JADX WARN: Type inference failed for: r2v20 */
            /* JADX WARN: Type inference failed for: r3v19, types: [java.util.Calendar] */
            /* JADX WARN: Type inference failed for: r6v16, types: [com.example.database.db.RawStepsImpl] */
            /* JADX WARN: Type inference failed for: r8v3 */
            /* JADX WARN: Type inference failed for: r8v4, types: [java.util.Date] */
            /* JADX WARN: Type inference failed for: r8v7 */
            @Override // oh.l
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final com.example.test.ui.model.chart.chart.StepChartData invoke(java.lang.String r22) {
                /*
                    Method dump skipped, instructions count: 942
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.main.StepStatisticsPresenter$getDayStepStatistics$3.invoke(java.lang.String):com.example.test.ui.model.chart.chart.StepChartData");
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.StepStatisticsPresenter$getDayStepStatistics$4
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StepChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(StepChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((StepStatisticsFragment) ((g7.x) g1.this.f7255a)).R(it);
            }
        });
    }

    public final void m(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.StepStatisticsPresenter$getMonthStepStatistics$1
            @Override // oh.l
            public final StepChartData invoke(String dateTime) {
                StepChartData stepChartData;
                String str;
                Object obj;
                String str2;
                Object obj2;
                kotlin.jvm.internal.e.f(dateTime, "dateTime");
                int i3 = 1;
                if (y5.d.f20005b) {
                    Object obj3 = com.example.test.utils.m.f8734b;
                    if (!d2.a().a()) {
                        stepChartData = new StepChartData();
                        Date h4 = a2.h(dateTime, "yyyy/MM");
                        if (h4 != null) {
                            Date d5 = a2.d(h4);
                            Date c9 = a2.c(h4);
                            String i10 = ca.i(d5.getTime(), "yyyyMMdd");
                            String i11 = ca.i(c9.getTime(), "yyyyMMdd");
                            if (i10 != null && i11 != null) {
                                if (com.example.test.utils.k.f8731b == null) {
                                    synchronized (com.example.test.utils.k.class) {
                                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                    }
                                }
                                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                                User d8 = kVar != null ? kVar.d() : null;
                                if (d8 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    RawStepsImpl rawStepsImpl = RawStepsImpl.INSTANCE;
                                    if (com.example.test.utils.k.f8731b == null) {
                                        synchronized (com.example.test.utils.k.class) {
                                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                        }
                                    }
                                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                    String g10 = kVar2 != null ? kVar2.g() : null;
                                    String userId = d8.getUserId();
                                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                    arrayList.addAll(com.example.test.presenter.analysis.a.h(rawStepsImpl.getStepByDate(g10, userId, i10, i11)));
                                    int b3 = a2.b(h4);
                                    if (arrayList.size() > 0 && arrayList.size() < b3) {
                                        Calendar calendar = Calendar.getInstance();
                                        calendar.setTime(d5);
                                        for (int i12 = 0; i12 < b3; i12++) {
                                            long timeInMillis = calendar.getTimeInMillis();
                                            try {
                                                str2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                                            } catch (Exception e) {
                                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                                                str2 = null;
                                            }
                                            if (str2 != null) {
                                                int size = arrayList.size();
                                                int i13 = 0;
                                                while (true) {
                                                    if (i13 >= size) {
                                                        obj2 = null;
                                                        break;
                                                    }
                                                    obj2 = arrayList.get(i13);
                                                    i13++;
                                                    if (kotlin.jvm.internal.e.a(((DataStep) obj2).getDate(), str2)) {
                                                        break;
                                                    }
                                                }
                                                if (((DataStep) obj2) == null) {
                                                    arrayList.add(i12, new DataStep());
                                                }
                                            }
                                            calendar.add(5, 1);
                                        }
                                    }
                                    ArrayList arrayList2 = new ArrayList();
                                    int size2 = arrayList.size();
                                    int i14 = 0;
                                    int i15 = 0;
                                    int i16 = 0;
                                    float f2 = 0.0f;
                                    float f10 = 0.0f;
                                    while (i16 < size2) {
                                        Object obj4 = arrayList.get(i16);
                                        i16 += i3;
                                        int i17 = i15 + 1;
                                        if (i15 < 0) {
                                            kotlin.collections.i.f();
                                            throw null;
                                        }
                                        DataStep dataStep = (DataStep) obj4;
                                        arrayList2.add(new BarEntry(i15, dataStep.getTotalStep()));
                                        f2 += dataStep.getCalorie();
                                        f10 = dataStep.getDistance() + f10;
                                        i14 += dataStep.getTotalStep();
                                        i15 = i17;
                                        i3 = i3;
                                    }
                                    stepChartData.setSteps(arrayList2);
                                    Calendar calendar2 = Calendar.getInstance();
                                    calendar2.setTime(h4);
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
                                    stepChartData.setAvgSteps(i14 / actualMaximum);
                                    float f11 = 1000;
                                    stepChartData.setCalorie(f2 / f11);
                                    stepChartData.setDistance(d8.getMeterUnit() == 0 ? f10 / f11 : com.google.android.gms.internal.mlkit_vision_barcode.v1.b(f10));
                                    stepChartData.setTotalSteps(i14);
                                }
                            }
                        }
                        return stepChartData;
                    }
                }
                int i18 = 1;
                stepChartData = new StepChartData();
                Date h10 = a2.h(dateTime, "yyyy/MM");
                if (h10 != null) {
                    Date d10 = a2.d(h10);
                    Date c10 = a2.c(h10);
                    String i19 = ca.i(d10.getTime(), "yyyyMMdd");
                    String i20 = ca.i(c10.getTime(), "yyyyMMdd");
                    if (i19 != null && i20 != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                        User d11 = kVar3 != null ? kVar3.d() : null;
                        if (d11 != null) {
                            ArrayList arrayList3 = new ArrayList();
                            StepsImpl stepsImpl = StepsImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                            String g11 = kVar4 != null ? kVar4.g() : null;
                            String userId2 = d11.getUserId();
                            kotlin.jvm.internal.e.e(userId2, "getUserId(...)");
                            arrayList3.addAll(stepsImpl.getStepByDate(g11, userId2, i19, i20));
                            int b10 = a2.b(h10);
                            if (arrayList3.size() > 0 && arrayList3.size() < b10) {
                                Calendar calendar4 = Calendar.getInstance();
                                calendar4.setTime(d10);
                                int i21 = 0;
                                while (i21 < b10) {
                                    long timeInMillis2 = calendar4.getTimeInMillis();
                                    try {
                                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis2));
                                    } catch (Exception e10) {
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis2, " date translate error ", e10.getMessage()));
                                        str = null;
                                    }
                                    if (str != null) {
                                        int size3 = arrayList3.size();
                                        int i22 = 0;
                                        while (true) {
                                            if (i22 >= size3) {
                                                obj = null;
                                                break;
                                            }
                                            obj = arrayList3.get(i22);
                                            i22++;
                                            if (kotlin.jvm.internal.e.a(((DataStep) obj).getDate(), str)) {
                                                break;
                                            }
                                        }
                                        if (((DataStep) obj) == null) {
                                            arrayList3.add(i21, new DataStep());
                                        }
                                    }
                                    int i23 = i18;
                                    calendar4.add(5, i23);
                                    i21 += i23;
                                    i18 = i23;
                                }
                            }
                            int i24 = i18;
                            ArrayList arrayList4 = new ArrayList();
                            int size4 = arrayList3.size();
                            int i25 = 0;
                            int i26 = 0;
                            int i27 = 0;
                            float f12 = 0.0f;
                            float f13 = 0.0f;
                            while (i27 < size4) {
                                Object obj5 = arrayList3.get(i27);
                                i27 += i24;
                                int i28 = i26 + 1;
                                if (i26 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                DataStep dataStep2 = (DataStep) obj5;
                                arrayList4.add(new BarEntry(i26, dataStep2.getTotalStep()));
                                f13 = dataStep2.getCalorie() + f13;
                                f12 += dataStep2.getDistance();
                                i25 += dataStep2.getTotalStep();
                                i26 = i28;
                            }
                            stepChartData.setSteps(arrayList4);
                            Calendar calendar5 = Calendar.getInstance();
                            calendar5.setTime(h10);
                            calendar5.set(11, 0);
                            calendar5.set(12, 0);
                            calendar5.set(13, 0);
                            calendar5.set(14, 0);
                            int actualMaximum2 = calendar5.getActualMaximum(5);
                            Calendar calendar6 = Calendar.getInstance();
                            calendar6.setTime(calendar5.getTime());
                            calendar6.set(5, actualMaximum2);
                            if (calendar6.getTimeInMillis() > calendar5.getTimeInMillis()) {
                                actualMaximum2 = Calendar.getInstance().get(5);
                            }
                            stepChartData.setAvgSteps(i25 / actualMaximum2);
                            float f14 = 1000;
                            stepChartData.setCalorie(f13 / f14);
                            stepChartData.setDistance(d11.getMeterUnit() == 0 ? f12 / f14 : com.google.android.gms.internal.mlkit_vision_barcode.v1.b(f12));
                            stepChartData.setTotalSteps(i25);
                        }
                    }
                }
                return stepChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.StepStatisticsPresenter$getMonthStepStatistics$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StepChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(StepChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((StepStatisticsFragment) ((g7.x) g1.this.f7255a)).R(it);
            }
        });
    }

    public final void n(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.StepStatisticsPresenter$getYearStepStatistics$1
            @Override // oh.l
            public final StepChartData invoke(String dateTime) {
                kotlin.jvm.internal.e.f(dateTime, "dateTime");
                int i3 = 5;
                if (y5.d.f20005b) {
                    Object obj = com.example.test.utils.m.f8734b;
                    if (!d2.a().a()) {
                        StepChartData stepChartData = new StepChartData();
                        Date h4 = a2.h(dateTime, "yyyy");
                        if (h4 != null) {
                            int a3 = a2.a(h4);
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(h4);
                            ArrayList arrayList = new ArrayList();
                            int i10 = 0;
                            int i11 = 0;
                            float f2 = 0.0f;
                            float f10 = 0.0f;
                            while (i10 < a3) {
                                Date time = calendar.getTime();
                                kotlin.jvm.internal.e.e(time, "getTime(...)");
                                StepData stepData = new StepData();
                                if (com.example.test.utils.k.f8731b == null) {
                                    synchronized (com.example.test.utils.k.class) {
                                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                    }
                                }
                                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                                User d5 = kVar != null ? kVar.d() : null;
                                if (d5 != null) {
                                    Date v6 = android.support.v4.media.session.e.v(Calendar.getInstance(), time, i3, i3, "getTime(...)");
                                    Calendar calendar2 = Calendar.getInstance();
                                    calendar2.setTime(time);
                                    calendar2.set(i3, calendar2.getActualMaximum(i3));
                                    Date time2 = calendar2.getTime();
                                    kotlin.jvm.internal.e.e(time2, "getTime(...)");
                                    String i12 = ca.i(v6.getTime(), "yyyyMMdd");
                                    String i13 = ca.i(time2.getTime(), "yyyyMMdd");
                                    if (i12 != null && i13 != null) {
                                        RawStepsImpl rawStepsImpl = RawStepsImpl.INSTANCE;
                                        if (com.example.test.utils.k.f8731b == null) {
                                            synchronized (com.example.test.utils.k.class) {
                                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                            }
                                        }
                                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                        String g10 = kVar2 != null ? kVar2.g() : null;
                                        String userId = d5.getUserId();
                                        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                        List<RawDataStep> stepByDate = rawStepsImpl.getStepByDate(g10, userId, i12, i13);
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.addAll(com.example.test.presenter.analysis.a.h(stepByDate));
                                        int size = arrayList2.size();
                                        float f11 = 0.0f;
                                        float f12 = 0.0f;
                                        int i14 = 0;
                                        int i15 = 0;
                                        while (i15 < size) {
                                            Object obj2 = arrayList2.get(i15);
                                            i15++;
                                            DataStep dataStep = (DataStep) obj2;
                                            i14 = dataStep.getTotalStep() + i14;
                                            f12 = dataStep.getDistance() + f12;
                                            f11 = dataStep.getCalorie() + f11;
                                        }
                                        stepData.setTotalSteps(i14);
                                        stepData.setCalorie(f11);
                                        stepData.setDistance(f12);
                                    }
                                }
                                arrayList.add(new BarEntry(i10, stepData.getTotalSteps()));
                                i11 += stepData.getTotalSteps();
                                f2 += stepData.getCalorie();
                                f10 += stepData.getDistance();
                                calendar.add(2, 1);
                                i10++;
                                i3 = 5;
                            }
                            if (a3 < 12) {
                                int i16 = 12 - a3;
                                for (int i17 = 0; i17 < i16; i17++) {
                                    arrayList.add(new BarEntry(a3 + i17, 0.0f));
                                }
                            }
                            stepChartData.setAvgSteps(i11 / a3);
                            float f13 = 1000;
                            stepChartData.setCalorie(f2 / f13);
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                            User d8 = kVar3 != null ? kVar3.d() : null;
                            if (d8 != null) {
                                stepChartData.setDistance(d8.getMeterUnit() == 0 ? f10 / f13 : com.google.android.gms.internal.mlkit_vision_barcode.v1.b(f10));
                            }
                            stepChartData.setTotalSteps(i11);
                            if (i11 > 0) {
                                stepChartData.setSteps(arrayList);
                            }
                        }
                        return stepChartData;
                    }
                }
                StepChartData stepChartData2 = new StepChartData();
                Date h10 = a2.h(dateTime, "yyyy");
                if (h10 != null) {
                    int a10 = a2.a(h10);
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.setTime(h10);
                    ArrayList arrayList3 = new ArrayList();
                    float f14 = 0.0f;
                    float f15 = 0.0f;
                    int i18 = 0;
                    for (int i19 = 0; i19 < a10; i19++) {
                        Date time3 = calendar3.getTime();
                        kotlin.jvm.internal.e.e(time3, "getTime(...)");
                        StepData stepData2 = new StepData();
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                        User d10 = kVar4 != null ? kVar4.d() : null;
                        if (d10 != null) {
                            Date v9 = android.support.v4.media.session.e.v(Calendar.getInstance(), time3, 5, 5, "getTime(...)");
                            Calendar calendar4 = Calendar.getInstance();
                            calendar4.setTime(time3);
                            calendar4.set(5, calendar4.getActualMaximum(5));
                            Date time4 = calendar4.getTime();
                            kotlin.jvm.internal.e.e(time4, "getTime(...)");
                            String i20 = ca.i(v9.getTime(), "yyyyMMdd");
                            String i21 = ca.i(time4.getTime(), "yyyyMMdd");
                            if (i20 != null && i21 != null) {
                                StepsImpl stepsImpl = StepsImpl.INSTANCE;
                                if (com.example.test.utils.k.f8731b == null) {
                                    synchronized (com.example.test.utils.k.class) {
                                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                    }
                                }
                                com.example.test.utils.k kVar5 = com.example.test.utils.k.f8731b;
                                String g11 = kVar5 != null ? kVar5.g() : null;
                                String userId2 = d10.getUserId();
                                kotlin.jvm.internal.e.e(userId2, "getUserId(...)");
                                float f16 = 0.0f;
                                float f17 = 0.0f;
                                int i22 = 0;
                                for (DataStep dataStep2 : stepsImpl.getStepByDate(g11, userId2, i20, i21)) {
                                    i22 += dataStep2.getTotalStep();
                                    f17 += dataStep2.getDistance();
                                    f16 += dataStep2.getCalorie();
                                }
                                stepData2.setTotalSteps(i22);
                                stepData2.setCalorie(f16);
                                stepData2.setDistance(f17);
                            }
                        }
                        arrayList3.add(new BarEntry(i19, stepData2.getTotalSteps()));
                        i18 += stepData2.getTotalSteps();
                        f14 += stepData2.getCalorie();
                        f15 += stepData2.getDistance();
                        calendar3.add(2, 1);
                    }
                    if (a10 < 12) {
                        int i23 = 12 - a10;
                        for (int i24 = 0; i24 < i23; i24++) {
                            arrayList3.add(new BarEntry(a10 + i24, 0.0f));
                        }
                    }
                    stepChartData2.setAvgSteps(i18 / a10);
                    float f18 = 1000;
                    stepChartData2.setCalorie(f14 / f18);
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar6 = com.example.test.utils.k.f8731b;
                    User d11 = kVar6 != null ? kVar6.d() : null;
                    if (d11 != null) {
                        stepChartData2.setDistance(d11.getMeterUnit() == 0 ? f15 / f18 : com.google.android.gms.internal.mlkit_vision_barcode.v1.b(f15));
                    }
                    stepChartData2.setTotalSteps(i18);
                    if (i18 > 0) {
                        stepChartData2.setSteps(arrayList3);
                    }
                }
                return stepChartData2;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.StepStatisticsPresenter$getYearStepStatistics$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StepChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(StepChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((StepStatisticsFragment) ((g7.x) g1.this.f7255a)).R(it);
            }
        });
    }
}
