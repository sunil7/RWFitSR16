package com.example.test.presenter.main;

import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.database.db.PressureImpl;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataPressure;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.model.chart.chart.PressureData;
import com.example.test.ui.model.chart.chart.StressChartData;
import com.example.test.ui.model.chart.chart.StressSumData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.EntryDate;
import com.google.android.gms.internal.mlkit_vision_barcode.a2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.collections.EmptyList;

/* loaded from: classes.dex */
public final class g extends com.example.baselibrary.preseneter.b implements v5.i0 {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7508b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7509c;

    /* renamed from: d, reason: collision with root package name */
    public DrinkReminderBean f7510d;
    public final eh.b e;

    public g(g7.d dVar) {
        super(dVar);
        this.f7508b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$settingStressCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final e invoke() {
                return new e(g.this);
            }
        });
        this.f7509c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$testHrCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final f invoke() {
                return new f(g.this);
            }
        });
        this.e = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$pressureCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final d invoke() {
                return new d(g.this);
            }
        });
    }

    public static void p(byte b3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 31);
            return;
        }
        x5.c b10 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(b3, "getControlHealthDataCmdJL 13 "));
        b10.g((byte) 31, new byte[]{6, 9, 0, 13, 5, b3}, new boolean[0]);
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BSStatisticsPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "errorCode = "));
        ((g7.d) this.f7255a).b0();
    }

    @Override // u5.g
    public final void c() {
        Log.e("qob", "BSStatisticsPresenter onSuccess");
        DrinkReminderBean drinkReminderBean = this.f7510d;
        if (drinkReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(drinkReminderBean, BSStatisticsPresenter$saveDB$1$1.INSTANCE, new BSStatisticsPresenter$saveDB$1$2(this));
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        DrinkReminderBean drinkReminderBean = (DrinkReminderBean) obj;
        Log.e("qob", "BSStatisticsPresenter onResult");
        g7.d dVar = (g7.d) this.f7255a;
        dVar.b0();
        if (drinkReminderBean != null) {
            dVar.c(drinkReminderBean);
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d(this);
        com.google.android.gms.internal.mlkit_vision_common.p.d((f) this.f7509c.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((e) this.f7508b.getValue());
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_stress_watcher");
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$initData$2

            public static final class a extends bc.a<DrinkReminderBean> {
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
                    g gVar = g.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((g7.d) gVar.f7255a).c((DrinkReminderBean) g10);
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        com.google.android.gms.internal.mlkit_vision_common.p.U((f) this.f7509c.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.U((e) this.f7508b.getValue());
        ((g7.d) this.f7255a).V();
        com.google.android.gms.internal.mlkit_vision_common.p.p();
    }

    public final void l(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$getDayStressDetail$1
            @Override // oh.l
            public final StressChartData invoke(String it) {
                Date date2;
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                StressChartData stressChartData = new StressChartData();
                try {
                    date2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(it);
                } catch (Exception unused) {
                    date2 = null;
                }
                if (date2 != null) {
                    long time = date2.getTime();
                    try {
                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                        str = null;
                    }
                    if (str != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d5 = kVar != null ? kVar.d() : null;
                        if (d5 != null) {
                            PressureImpl pressureImpl = PressureImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            DataPressure dataByDate = pressureImpl.getDataByDate(g10, userId, str);
                            ArrayList arrayList = new ArrayList();
                            if (dataByDate != null) {
                                List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new g6.p().f3204b);
                                kotlin.jvm.internal.e.c(h4);
                                List list = EmptyList.INSTANCE;
                                for (Object obj : h4) {
                                    if (((PressureData) obj).getPressure() > 0) {
                                        if (list.isEmpty()) {
                                            list = new ArrayList();
                                        }
                                        kotlin.jvm.internal.i.b(list).add(obj);
                                    }
                                }
                                if (!list.isEmpty()) {
                                    stressChartData.setCurrentStress(((PressureData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getPressure());
                                    int i3 = 0;
                                    long j4 = 1000;
                                    stressChartData.setStartTime(ca.i(((PressureData) list.get(0)).getCurrentTime() * j4, "HH:mm"));
                                    stressChartData.setEndTime(ca.i(((PressureData) list.get(list.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                                    for (Object obj2 : list) {
                                        int i10 = i3 + 1;
                                        if (i3 < 0) {
                                            kotlin.collections.i.f();
                                            throw null;
                                        }
                                        arrayList.add(new EntryDate(i3, r4.getPressure(), ((PressureData) obj2).getCurrentTime()));
                                        i3 = i10;
                                    }
                                }
                                stressChartData.setMaxStress(dataByDate.getMaxPressure());
                                stressChartData.setMinStress(dataByDate.getMinPressure());
                                stressChartData.setAvgStree(dataByDate.getAvgPressure());
                            }
                            stressChartData.setItems(arrayList);
                        }
                    }
                }
                return stressChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$getDayStressDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StressChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(StressChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.d) g.this.f7255a).d0(it);
            }
        });
    }

    public final void m(String start) {
        kotlin.jvm.internal.e.f(start, "start");
        com.example.baselibrary.preseneter.b.j(start, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$getMonthStressDetail$1
            @Override // oh.l
            public final StressChartData invoke(String it) {
                String str;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                StressChartData stressChartData = new StressChartData();
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
                            PressureImpl pressureImpl = PressureImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d8.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            List<DataPressure> dataByDate = pressureImpl.getDataByDate(g10, userId, i3, i10);
                            if (dataByDate != null) {
                                arrayList.addAll(dataByDate);
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
                                            if (kotlin.jvm.internal.e.a(((DataPressure) obj).getDate(), str)) {
                                                break;
                                            }
                                        }
                                        if (((DataPressure) obj) == null) {
                                            arrayList.add(i12, new DataPressure());
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
                                DataPressure dataPressure = (DataPressure) obj2;
                                if (dataPressure.getMaxPressure() > i16) {
                                    i16 = dataPressure.getMaxPressure();
                                }
                                int minPressure = dataPressure.getMinPressure();
                                if (1 <= minPressure && minPressure < i14) {
                                    i14 = dataPressure.getMinPressure();
                                }
                                i17 += dataPressure.getAvgPressure();
                                arrayList2.add(new Entry(i15, dataPressure.getAvgPressure()));
                                if (dataPressure.getAvgPressure() > 0) {
                                    i11++;
                                }
                                i15 = i19;
                            }
                            if (i11 > 0) {
                                stressChartData.setMaxStress(i16);
                                stressChartData.setMinStress(i14);
                                stressChartData.setAvgStree(i17 / i11);
                                stressChartData.setItems(arrayList2);
                            }
                        }
                    }
                }
                return stressChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$getMonthStressDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StressChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(StressChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.d) g.this.f7255a).d0(it);
            }
        });
    }

    public final void n(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$getWeekStressDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final StressChartData invoke(String it) {
                Date date;
                Date date2;
                String str3;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                String end = str2;
                kotlin.jvm.internal.e.f(end, "end");
                StressChartData stressChartData = new StressChartData();
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
                            PressureImpl pressureImpl = PressureImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            List<DataPressure> dataByDate = pressureImpl.getDataByDate(g10, userId, i3, i10);
                            if (dataByDate != null) {
                                arrayList.addAll(dataByDate);
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
                                            if (kotlin.jvm.internal.e.a(((DataPressure) obj).getDate(), str3)) {
                                                break;
                                            }
                                        }
                                        if (((DataPressure) obj) == null) {
                                            arrayList.add(i13, new DataPressure());
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
                                DataPressure dataPressure = (DataPressure) obj2;
                                if (dataPressure.getMaxPressure() > i17) {
                                    i17 = dataPressure.getMaxPressure();
                                }
                                int minPressure = dataPressure.getMinPressure();
                                if (i11 <= minPressure && minPressure < i15) {
                                    i15 = dataPressure.getMinPressure();
                                }
                                i18 += dataPressure.getAvgPressure();
                                arrayList2.add(new Entry(i16, dataPressure.getAvgPressure()));
                                if (dataPressure.getAvgPressure() > 0) {
                                    i12++;
                                }
                                i16 = i20;
                                i11 = 1;
                            }
                            if (i12 > 0) {
                                stressChartData.setMaxStress(i17);
                                stressChartData.setMinStress(i15);
                                stressChartData.setAvgStree(i18 / i12);
                                stressChartData.setItems(arrayList2);
                            }
                        }
                    }
                }
                return stressChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$getWeekStressDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StressChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(StressChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.d) g.this.f7255a).d0(it);
            }
        });
    }

    public final void o(String start) {
        kotlin.jvm.internal.e.f(start, "start");
        com.example.baselibrary.preseneter.b.j(start, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$getYearStressDetail$1
            @Override // oh.l
            public final StressChartData invoke(String it) {
                int i3;
                int i10;
                int i11;
                kotlin.jvm.internal.e.f(it, "it");
                StressChartData stressChartData = new StressChartData();
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
                        StressSumData stressSumData = new StressSumData();
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
                                PressureImpl pressureImpl = PressureImpl.INSTANCE;
                                if (com.example.test.utils.k.f8731b == null) {
                                    synchronized (com.example.test.utils.k.class) {
                                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                    }
                                }
                                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                String g10 = kVar2 != null ? kVar2.g() : null;
                                String userId = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                List<DataPressure> dataByDate = pressureImpl.getDataByDate(g10, userId, i15, i16);
                                if (dataByDate != null) {
                                    i3 = 0;
                                    i10 = 0;
                                    i11 = 0;
                                    for (DataPressure dataPressure : dataByDate) {
                                        if (dataPressure.getMaxPressure() > i11) {
                                            i11 = dataPressure.getMaxPressure();
                                        }
                                        int minPressure = dataPressure.getMinPressure();
                                        if (1 <= minPressure && minPressure < i14) {
                                            i14 = dataPressure.getMinPressure();
                                        }
                                        i3 += dataPressure.getAvgPressure();
                                        if (dataPressure.getAvgPressure() > 0) {
                                            i10++;
                                        }
                                    }
                                } else {
                                    i3 = 0;
                                    i10 = 0;
                                    i11 = 0;
                                }
                                if (i10 > 0) {
                                    stressSumData.setMaxStress(i11);
                                    stressSumData.setMinStress(i14);
                                    stressSumData.setAvgStress(i3 / i10);
                                }
                            } else {
                                continue;
                            }
                        }
                        arrayList.add(stressSumData);
                        calendar.add(2, 1);
                        i13++;
                    }
                    if (a3 < 12) {
                        int i17 = 12 - a3;
                        for (int i18 = 0; i18 < i17; i18++) {
                            arrayList.add(new StressSumData());
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
                        StressSumData stressSumData2 = (StressSumData) obj;
                        if (stressSumData2.getMaxStress() > i23) {
                            i23 = stressSumData2.getMaxStress();
                        }
                        int minStress = stressSumData2.getMinStress();
                        if (1 <= minStress && minStress < i22) {
                            i22 = stressSumData2.getMinStress();
                        }
                        i20 += stressSumData2.getAvgStress();
                        if (stressSumData2.getAvgStress() > 0) {
                            i12++;
                        }
                        arrayList2.add(new Entry(i19, stressSumData2.getAvgStress()));
                        i19 = i24;
                    }
                    if (i12 > 0) {
                        stressChartData.setMaxStress(i23);
                        stressChartData.setMinStress(i22);
                        stressChartData.setAvgStree(i20 / i12);
                        stressChartData.setItems(arrayList2);
                    }
                }
                return stressChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BSStatisticsPresenter$getYearStressDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StressChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(StressChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.d) g.this.f7255a).d0(it);
            }
        });
    }
}
