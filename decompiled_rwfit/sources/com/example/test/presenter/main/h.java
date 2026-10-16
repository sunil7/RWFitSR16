package com.example.test.presenter.main;

import com.example.database.db.BodyTempImpl;
import com.example.database.table.DataBodyTemp;
import com.example.database.table.User;
import com.example.test.ui.main.fragment.BTStatisticsFragment;
import com.example.test.ui.model.chart.chart.BtSumData;
import com.example.test.ui.model.chart.chart.TempChartData;
import com.example.test.ui.model.chart.chart.TempData;
import com.github.mikephil.charting.data.Entry;
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
public final class h extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.BTStatisticsPresenter$getDayTempDetail$1
            @Override // oh.l
            public final TempChartData invoke(String it) {
                Date date2;
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                TempChartData tempChartData = new TempChartData();
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
                            BodyTempImpl bodyTempImpl = BodyTempImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            DataBodyTemp dataByDate = bodyTempImpl.getDataByDate(g10, userId, str);
                            if (dataByDate != null) {
                                List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new g6.r().f3204b);
                                kotlin.jvm.internal.e.c(h4);
                                List list = EmptyList.INSTANCE;
                                for (Object obj : h4) {
                                    if (((TempData) obj).getTemp() > 0.0f) {
                                        if (list.isEmpty()) {
                                            list = new ArrayList();
                                        }
                                        kotlin.jvm.internal.i.b(list).add(obj);
                                    }
                                }
                                if (!list.isEmpty()) {
                                    tempChartData.setCurrentTemp(d5.getTempUnit() == 0 ? ((TempData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getTemp() : com.google.android.gms.internal.mlkit_vision_barcode.v1.a(((TempData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getTemp()));
                                }
                                ArrayList arrayList = new ArrayList();
                                int i3 = 0;
                                for (Object obj2 : list) {
                                    int i10 = i3 + 1;
                                    if (i3 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    TempData tempData = (TempData) obj2;
                                    arrayList.add(new Entry(i3, d5.getTempUnit() == 0 ? tempData.getTemp() : com.google.android.gms.internal.mlkit_vision_barcode.v1.a(tempData.getTemp())));
                                    i3 = i10;
                                }
                                long j4 = 1000;
                                tempChartData.setStartTime(ca.i(((TempData) list.get(0)).getCurrentTime() * j4, "HH:mm"));
                                tempChartData.setEndTime(ca.i(((TempData) list.get(list.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                                if (d5.getTempUnit() == 0) {
                                    tempChartData.setMaxTemp(dataByDate.getMaxTemp());
                                    tempChartData.setMinTemp(dataByDate.getMinTemp());
                                    tempChartData.setAvgTemp(dataByDate.getAvgTemp());
                                } else {
                                    tempChartData.setMaxTemp(com.google.android.gms.internal.mlkit_vision_barcode.v1.a(dataByDate.getMaxTemp()));
                                    tempChartData.setMinTemp(com.google.android.gms.internal.mlkit_vision_barcode.v1.a(dataByDate.getMinTemp()));
                                    tempChartData.setAvgTemp(com.google.android.gms.internal.mlkit_vision_barcode.v1.a(dataByDate.getAvgTemp()));
                                }
                                tempChartData.setItems(arrayList);
                            }
                        }
                    }
                }
                return tempChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BTStatisticsPresenter$getDayTempDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TempChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(TempChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BTStatisticsFragment) ((g7.e) h.this.f7255a)).u0(it);
            }
        });
    }

    public final void l(String start) {
        kotlin.jvm.internal.e.f(start, "start");
        com.example.baselibrary.preseneter.b.j(start, new oh.l() { // from class: com.example.test.presenter.main.BTStatisticsPresenter$getMonthTempDetail$1
            @Override // oh.l
            public final TempChartData invoke(String it) {
                String str;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                TempChartData tempChartData = new TempChartData();
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
                            BodyTempImpl bodyTempImpl = BodyTempImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d8.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, bodyTempImpl.getDataByDate(g10, userId, i3, i10));
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
                                            if (kotlin.jvm.internal.e.a(((DataBodyTemp) obj).getDate(), str)) {
                                                break;
                                            }
                                        }
                                        if (((DataBodyTemp) obj) == null) {
                                            arrayList.add(i12, new DataBodyTemp());
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
                                DataBodyTemp dataBodyTemp = (DataBodyTemp) obj2;
                                if (dataBodyTemp.getMaxTemp() > f10) {
                                    f10 = dataBodyTemp.getMaxTemp();
                                }
                                if (dataBodyTemp.getMinTemp() < f12 && dataBodyTemp.getMinTemp() > f2) {
                                    f12 = dataBodyTemp.getMinTemp();
                                }
                                float f13 = f2;
                                arrayList2.add(new Entry(i15, d8.getTempUnit() == 0 ? dataBodyTemp.getAvgTemp() : com.google.android.gms.internal.mlkit_vision_barcode.v1.a(dataBodyTemp.getAvgTemp())));
                                if (dataBodyTemp.getAvgTemp() > f13) {
                                    f11 += d8.getTempUnit() == 0 ? dataBodyTemp.getAvgTemp() : com.google.android.gms.internal.mlkit_vision_barcode.v1.a(dataBodyTemp.getAvgTemp());
                                    i11++;
                                }
                                f2 = f13;
                                i15 = i16;
                            }
                            if (i11 > 0) {
                                if (d8.getTempUnit() != 0) {
                                    f10 = com.google.android.gms.internal.mlkit_vision_barcode.v1.a(f10);
                                }
                                tempChartData.setMaxTemp(f10);
                                if (d8.getTempUnit() != 0) {
                                    f12 = com.google.android.gms.internal.mlkit_vision_barcode.v1.a(f12);
                                }
                                tempChartData.setMinTemp(f12);
                                tempChartData.setAvgTemp(f11 / i11);
                                tempChartData.setItems(arrayList2);
                            }
                        }
                    }
                }
                return tempChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BTStatisticsPresenter$getMonthTempDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TempChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(TempChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BTStatisticsFragment) ((g7.e) h.this.f7255a)).u0(it);
            }
        });
    }

    public final void m(String str, final String str2) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.main.BTStatisticsPresenter$getWeekTempDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final TempChartData invoke(String it) {
                Date date;
                Date date2;
                String str3;
                Object obj;
                kotlin.jvm.internal.e.f(it, "it");
                String end = str2;
                kotlin.jvm.internal.e.f(end, "end");
                TempChartData tempChartData = new TempChartData();
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
                            BodyTempImpl bodyTempImpl = BodyTempImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            kotlin.collections.n.i(arrayList, bodyTempImpl.getDataByDate(g10, userId, i3, i10));
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
                                            if (kotlin.jvm.internal.e.a(((DataBodyTemp) obj).getDate(), str3)) {
                                                break;
                                            }
                                        }
                                        if (((DataBodyTemp) obj) == null) {
                                            arrayList.add(i12, new DataBodyTemp());
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
                                DataBodyTemp dataBodyTemp = (DataBodyTemp) obj2;
                                if (dataBodyTemp.getMaxTemp() > f10) {
                                    f10 = dataBodyTemp.getMaxTemp();
                                }
                                if (dataBodyTemp.getMinTemp() < f12 && dataBodyTemp.getMinTemp() > f2) {
                                    f12 = dataBodyTemp.getMinTemp();
                                }
                                float f13 = f2;
                                arrayList2.add(new Entry(i15, d5.getTempUnit() == 0 ? dataBodyTemp.getAvgTemp() : com.google.android.gms.internal.mlkit_vision_barcode.v1.a(dataBodyTemp.getAvgTemp())));
                                if (dataBodyTemp.getAvgTemp() > f13) {
                                    f11 += d5.getTempUnit() == 0 ? dataBodyTemp.getAvgTemp() : com.google.android.gms.internal.mlkit_vision_barcode.v1.a(dataBodyTemp.getAvgTemp());
                                    i11++;
                                }
                                f2 = f13;
                                i15 = i16;
                            }
                            if (i11 > 0) {
                                if (d5.getTempUnit() != 0) {
                                    f10 = com.google.android.gms.internal.mlkit_vision_barcode.v1.a(f10);
                                }
                                tempChartData.setMaxTemp(f10);
                                if (d5.getTempUnit() != 0) {
                                    f12 = com.google.android.gms.internal.mlkit_vision_barcode.v1.a(f12);
                                }
                                tempChartData.setMinTemp(f12);
                                tempChartData.setAvgTemp(f11 / i11);
                                tempChartData.setItems(arrayList2);
                            }
                        }
                    }
                }
                return tempChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BTStatisticsPresenter$getWeekTempDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TempChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(TempChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BTStatisticsFragment) ((g7.e) h.this.f7255a)).u0(it);
            }
        });
    }

    public final void n(String start) {
        kotlin.jvm.internal.e.f(start, "start");
        com.example.baselibrary.preseneter.b.j(start, new oh.l() { // from class: com.example.test.presenter.main.BTStatisticsPresenter$getYearTempDetail$1
            @Override // oh.l
            public final TempChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                TempChartData tempChartData = new TempChartData();
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
                        BtSumData btSumData = new BtSumData();
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
                                BodyTempImpl bodyTempImpl = BodyTempImpl.INSTANCE;
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
                                for (DataBodyTemp dataBodyTemp : bodyTempImpl.getDataByDate(g10, userId, i11, i12)) {
                                    if (dataBodyTemp.getMaxTemp() > f10) {
                                        f10 = dataBodyTemp.getMaxTemp();
                                    }
                                    if (dataBodyTemp.getMinTemp() < f2 && dataBodyTemp.getMinTemp() > 0.0f) {
                                        f2 = dataBodyTemp.getMinTemp();
                                    }
                                    if (dataBodyTemp.getAvgTemp() > 0.0f) {
                                        f11 += d5.getTempUnit() == 0 ? dataBodyTemp.getAvgTemp() : com.google.android.gms.internal.mlkit_vision_barcode.v1.a(dataBodyTemp.getAvgTemp());
                                        i13++;
                                    }
                                }
                                if (i13 > 0) {
                                    if (d5.getTempUnit() != 0) {
                                        f10 = com.google.android.gms.internal.mlkit_vision_barcode.v1.a(f10);
                                    }
                                    btSumData.setMaxTemp(f10);
                                    if (d5.getTempUnit() != 0) {
                                        f2 = com.google.android.gms.internal.mlkit_vision_barcode.v1.a(f2);
                                    }
                                    btSumData.setMinTemp(f2);
                                    btSumData.setAvgTemp(f11 / i13);
                                }
                            } else {
                                continue;
                            }
                        }
                        arrayList.add(btSumData);
                        calendar.add(2, 1);
                        i10++;
                    }
                    if (a3 < 12) {
                        int i14 = 12 - a3;
                        for (int i15 = 0; i15 < i14; i15++) {
                            arrayList.add(new BtSumData());
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
                        BtSumData btSumData2 = (BtSumData) obj;
                        if (btSumData2.getMaxTemp() > f13) {
                            f13 = btSumData2.getMaxTemp();
                        }
                        if (btSumData2.getMinTemp() < f12 && btSumData2.getMinTemp() > 0.0f) {
                            f12 = btSumData2.getMinTemp();
                        }
                        f14 += btSumData2.getAvgTemp();
                        if (btSumData2.getAvgTemp() > 0.0f) {
                            i3++;
                        }
                        arrayList2.add(new Entry(i16, btSumData2.getAvgTemp()));
                        i16 = i18;
                    }
                    if (i3 > 0) {
                        tempChartData.setMaxTemp(f13);
                        tempChartData.setMinTemp(f12);
                        tempChartData.setAvgTemp(f14 / i3);
                        tempChartData.setItems(arrayList2);
                    }
                }
                return tempChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BTStatisticsPresenter$getYearTempDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TempChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(TempChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((BTStatisticsFragment) ((g7.e) h.this.f7255a)).u0(it);
            }
        });
    }
}
