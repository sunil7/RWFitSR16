package com.example.test.presenter.analysis;

import android.support.v4.media.session.e;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.example.baselibrary.utils.b;
import com.example.blesdk.bean.sync.StepItemBean;
import com.example.database.db.BloodOxygenImpl;
import com.example.database.db.BloodPressImpl;
import com.example.database.db.BloodSugarImpl;
import com.example.database.db.HrImpl;
import com.example.database.db.RawStepsImpl;
import com.example.database.db.SleepImpl;
import com.example.database.db.StepsImpl;
import com.example.database.table.DataBloodOxygen;
import com.example.database.table.DataBloodPress;
import com.example.database.table.DataBloodSugar;
import com.example.database.table.DataHeartRate;
import com.example.database.table.DataSleep;
import com.example.database.table.DataStep;
import com.example.database.table.RawDataStep;
import com.example.database.table.User;
import com.example.test.presenter.main.v0;
import com.example.test.ui.model.chart.chart.BoChartData;
import com.example.test.ui.model.chart.chart.BoData;
import com.example.test.ui.model.chart.chart.BpChartData;
import com.example.test.ui.model.chart.chart.BpData;
import com.example.test.ui.model.chart.chart.HrChartData;
import com.example.test.ui.model.chart.chart.HrData;
import com.example.test.ui.model.chart.chart.SleepChartData;
import com.example.test.ui.model.chart.chart.SleepItemData;
import com.example.test.ui.model.chart.chart.StepChartData;
import com.example.test.ui.model.chart.chart.StepItemData;
import com.example.test.ui.model.chart.chart.SugarChartData;
import com.example.test.ui.model.chart.chart.SugarData;
import com.example.test.utils.k;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.EntryDate;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import g6.c;
import g6.g;
import g6.n;
import g6.o;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.collections.EmptyList;
import kotlin.collections.h;
import kotlin.jvm.internal.i;
import oh.l;
import y5.d;

/* loaded from: classes.dex */
public abstract class a {
    public static SugarChartData a(String str) {
        Date date;
        String str2;
        SugarChartData sugarChartData = new SugarChartData();
        try {
            date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(str);
        } catch (Exception unused) {
            date = null;
        }
        if (date != null) {
            long time = date.getTime();
            try {
                str2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
            } catch (Exception e) {
                b.o(b.f7264b, e.h(time, " date translate error ", e.getMessage()));
                str2 = null;
            }
            if (str2 != null) {
                if (k.f8731b == null) {
                    synchronized (k.class) {
                        k.f8731b = new k();
                    }
                }
                k kVar = k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    BloodSugarImpl bloodSugarImpl = BloodSugarImpl.INSTANCE;
                    if (k.f8731b == null) {
                        synchronized (k.class) {
                            k.f8731b = new k();
                        }
                    }
                    k kVar2 = k.f8731b;
                    String g10 = kVar2 != null ? kVar2.g() : null;
                    String userId = d5.getUserId();
                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                    DataBloodSugar dataByDate = bloodSugarImpl.getDataByDate(g10, userId, str2);
                    if (dataByDate != null) {
                        List h4 = b.h(dataByDate.getItems(), new c().f3204b);
                        Log.e("qob", "btData " + dataByDate.getAvgSugar() + " items " + dataByDate.getItems());
                        kotlin.jvm.internal.e.c(h4);
                        List list = EmptyList.INSTANCE;
                        for (Object obj : h4) {
                            if (((SugarData) obj).getSugar() > 0.0f) {
                                if (list.isEmpty()) {
                                    list = new ArrayList();
                                }
                                i.b(list).add(obj);
                            }
                        }
                        if (!list.isEmpty()) {
                            sugarChartData.setCurrentSugar(((SugarData) l0.g(1, list)).getSugar());
                        }
                        ArrayList arrayList = new ArrayList();
                        int i3 = 0;
                        for (Object obj2 : list) {
                            int i10 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.i.f();
                                throw null;
                            }
                            SugarData sugarData = (SugarData) obj2;
                            arrayList.add(new EntryDate(i3, sugarData.getSugar(), sugarData.getCurrentTime()));
                            i3 = i10;
                        }
                        long j4 = 1000;
                        sugarChartData.setStartTime(ca.i(((SugarData) list.get(0)).getCurrentTime() * j4, "HH:mm"));
                        sugarChartData.setEndTime(ca.i(((SugarData) list.get(list.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                        sugarChartData.setMaxSugar(dataByDate.getMaxSugar());
                        sugarChartData.setMinSugar(dataByDate.getMinSugar());
                        sugarChartData.setAvgSugar(dataByDate.getAvgSugar());
                        sugarChartData.setItems(arrayList);
                    }
                }
            }
        }
        return sugarChartData;
    }

    public static BoChartData b(String str) {
        Date date;
        String str2;
        BoChartData boChartData = new BoChartData();
        try {
            date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(str);
        } catch (Exception unused) {
            date = null;
        }
        if (date != null) {
            long time = date.getTime();
            try {
                str2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
            } catch (Exception e) {
                b.o(b.f7264b, e.h(time, " date translate error ", e.getMessage()));
                str2 = null;
            }
            if (str2 != null) {
                if (k.f8731b == null) {
                    synchronized (k.class) {
                        k.f8731b = new k();
                    }
                }
                k kVar = k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    BloodOxygenImpl bloodOxygenImpl = BloodOxygenImpl.INSTANCE;
                    if (k.f8731b == null) {
                        synchronized (k.class) {
                            k.f8731b = new k();
                        }
                    }
                    k kVar2 = k.f8731b;
                    String g10 = kVar2 != null ? kVar2.g() : null;
                    String userId = d5.getUserId();
                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                    DataBloodOxygen dataByDate = bloodOxygenImpl.getDataByDate(g10, userId, str2);
                    if (dataByDate != null) {
                        List h4 = b.h(dataByDate.getItems(), new g6.e().f3204b);
                        kotlin.jvm.internal.e.c(h4);
                        List list = EmptyList.INSTANCE;
                        for (Object obj : h4) {
                            int bo = ((BoData) obj).getBo();
                            if (1 <= bo && bo < 101) {
                                if (list.isEmpty()) {
                                    list = new ArrayList();
                                }
                                i.b(list).add(obj);
                            }
                        }
                        int i3 = 0;
                        if (!list.isEmpty()) {
                            boChartData.setCurrentBo(((BoData) l0.g(1, list)).getBo());
                            long j4 = 1000;
                            boChartData.setStartTime(ca.i(((BoData) list.get(0)).getCurrentTime() * j4, "HH:mm"));
                            boChartData.setEndTime(ca.i(((BoData) list.get(list.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                        }
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : list) {
                            int i10 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.i.f();
                                throw null;
                            }
                            arrayList.add(new EntryDate(i3, r5.getBo(), ((BoData) obj2).getCurrentTime()));
                            i3 = i10;
                        }
                        boChartData.setMaxBo(dataByDate.getMaxBo());
                        boChartData.setMinBo(dataByDate.getMinBo());
                        boChartData.setAvgBo(dataByDate.getAvgBo());
                        boChartData.setItems(arrayList);
                    }
                }
            }
        }
        return boChartData;
    }

    public static BpChartData c(String str) {
        Date date;
        String str2;
        BpChartData bpChartData = new BpChartData();
        try {
            date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(str);
        } catch (Exception unused) {
            date = null;
        }
        if (date != null) {
            long time = date.getTime();
            try {
                str2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
            } catch (Exception e) {
                b.o(b.f7264b, e.h(time, " date translate error ", e.getMessage()));
                str2 = null;
            }
            if (str2 != null) {
                if (k.f8731b == null) {
                    synchronized (k.class) {
                        k.f8731b = new k();
                    }
                }
                k kVar = k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    BloodPressImpl bloodPressImpl = BloodPressImpl.INSTANCE;
                    if (k.f8731b == null) {
                        synchronized (k.class) {
                            k.f8731b = new k();
                        }
                    }
                    k kVar2 = k.f8731b;
                    String g10 = kVar2 != null ? kVar2.g() : null;
                    String userId = d5.getUserId();
                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                    DataBloodPress dataByDate = bloodPressImpl.getDataByDate(g10, userId, str2);
                    if (dataByDate != null) {
                        List h4 = b.h(dataByDate.getItems(), new g().f3204b);
                        kotlin.jvm.internal.e.c(h4);
                        List list = EmptyList.INSTANCE;
                        for (Object obj : h4) {
                            BpData bpData = (BpData) obj;
                            int sp = bpData.getSp();
                            int dp = bpData.getDp();
                            if (1 <= dp && dp <= sp) {
                                if (list.isEmpty()) {
                                    list = new ArrayList();
                                }
                                i.b(list).add(obj);
                            }
                        }
                        int i3 = 0;
                        if (!list.isEmpty()) {
                            bpChartData.setCurrentSp(((BpData) l0.g(1, list)).getSp());
                            bpChartData.setCurrentDp(((BpData) list.get(list.size() - 1)).getDp());
                            long j4 = 1000;
                            bpChartData.setStartTime(ca.i(((BpData) list.get(0)).getCurrentTime() * j4, "HH:mm"));
                            bpChartData.setEndTime(ca.i(((BpData) list.get(list.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                        }
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj2 : list) {
                            int i10 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.i.f();
                                throw null;
                            }
                            BpData bpData2 = (BpData) obj2;
                            float f2 = i3;
                            arrayList.add(new Entry(f2, bpData2.getSp()));
                            arrayList2.add(new Entry(f2, bpData2.getDp()));
                            i3 = i10;
                        }
                        bpChartData.setMaxSp(dataByDate.getMaxSp());
                        bpChartData.setMinSp(dataByDate.getMinSp());
                        bpChartData.setMaxDp(dataByDate.getMaxDp());
                        bpChartData.setMinDp(dataByDate.getMinDp());
                        bpChartData.setAvgSp(dataByDate.getAvgSp());
                        bpChartData.setAvgDp(dataByDate.getAvgDp());
                        bpChartData.setItemSps(arrayList);
                        bpChartData.setItemDps(arrayList2);
                    }
                }
            }
        }
        return bpChartData;
    }

    public static HrChartData d(String str) {
        Date date;
        String str2;
        HrChartData hrChartData = new HrChartData();
        try {
            date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(str);
        } catch (Exception unused) {
            date = null;
        }
        if (date != null) {
            long time = date.getTime();
            try {
                str2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
            } catch (Exception e) {
                b.o(b.f7264b, e.h(time, " date translate error ", e.getMessage()));
                str2 = null;
            }
            if (str2 != null) {
                if (k.f8731b == null) {
                    synchronized (k.class) {
                        k.f8731b = new k();
                    }
                }
                k kVar = k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    HrImpl hrImpl = HrImpl.INSTANCE;
                    if (k.f8731b == null) {
                        synchronized (k.class) {
                            k.f8731b = new k();
                        }
                    }
                    k kVar2 = k.f8731b;
                    String g10 = kVar2 != null ? kVar2.g() : null;
                    String userId = d5.getUserId();
                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                    DataHeartRate dataByDate = hrImpl.getDataByDate(g10, userId, str2);
                    ArrayList arrayList = new ArrayList();
                    if (dataByDate != null) {
                        List h4 = b.h(dataByDate.getItems(), new g6.i().f3204b);
                        Log.e("qob", "hrData " + dataByDate.getAvgHr() + " items " + dataByDate.getItems());
                        kotlin.jvm.internal.e.c(h4);
                        List list = EmptyList.INSTANCE;
                        for (Object obj : h4) {
                            if (((HrData) obj).getHr() > 0) {
                                if (list.isEmpty()) {
                                    list = new ArrayList();
                                }
                                i.b(list).add(obj);
                            }
                        }
                        if (!list.isEmpty()) {
                            hrChartData.setCurrentHr(((HrData) l0.g(1, list)).getHr());
                            int i3 = 0;
                            long j4 = 1000;
                            hrChartData.setStartTime(ca.i(((HrData) list.get(0)).getCurrentTime() * j4, "HH:mm"));
                            hrChartData.setEndTime(ca.i(((HrData) list.get(list.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                            for (Object obj2 : list) {
                                int i10 = i3 + 1;
                                if (i3 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                arrayList.add(new EntryDate(i3, r4.getHr(), ((HrData) obj2).getCurrentTime()));
                                i3 = i10;
                            }
                        }
                        hrChartData.setMaxHr(dataByDate.getMaxHr());
                        hrChartData.setMinHr(dataByDate.getMinHr());
                        hrChartData.setAvgHr(dataByDate.getAvgHr());
                    }
                    hrChartData.setItems(arrayList);
                }
            }
        }
        return hrChartData;
    }

    public static SleepChartData e(String time) {
        Date date;
        String i3;
        kotlin.jvm.internal.e.f(time, "time");
        SleepChartData sleepChartData = new SleepChartData();
        try {
            date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(time);
        } catch (Exception unused) {
            date = null;
        }
        if (date != null) {
            if (k.f8731b == null) {
                synchronized (k.class) {
                    k.f8731b = new k();
                }
            }
            k kVar = k.f8731b;
            User d5 = kVar != null ? kVar.d() : null;
            if (d5 != null && (i3 = ca.i(date.getTime(), "yyyyMMdd")) != null) {
                SleepImpl sleepImpl = SleepImpl.INSTANCE;
                if (k.f8731b == null) {
                    synchronized (k.class) {
                        k.f8731b = new k();
                    }
                }
                k kVar2 = k.f8731b;
                String g10 = kVar2 != null ? kVar2.g() : null;
                String userId = d5.getUserId();
                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                DataSleep dataByDate = sleepImpl.getDataByDate(g10, userId, i3);
                if (dataByDate != null) {
                    sleepChartData.setWakeupTimes(dataByDate.getWakeupCount());
                    long j4 = 1000;
                    sleepChartData.setStartTime(ca.e(dataByDate.getAsleepTime() * j4));
                    sleepChartData.setEndTime(ca.e(dataByDate.getWakeupTime() * j4));
                    long sleepRapidTime = dataByDate.getSleepRapidTime() + dataByDate.getSleepLightTime() + dataByDate.getSleepDeepTime() + dataByDate.getWakeupCount();
                    long j10 = 60;
                    sleepChartData.setRing_totalHour((int) (sleepRapidTime / j10));
                    sleepChartData.setRing_totalMin((int) (sleepRapidTime % j10));
                    sleepChartData.setRing_lightSleepTime((int) dataByDate.getSleepLightTime());
                    sleepChartData.setRing_deepSleepTime((int) dataByDate.getSleepDeepTime());
                    sleepChartData.setRing_wakeSleepTime(dataByDate.getWakeupCount());
                    sleepChartData.setRing_rapidSleepTime((int) dataByDate.getSleepRapidTime());
                    long totalSleepTime = dataByDate.getTotalSleepTime();
                    sleepChartData.setTotalTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(totalSleepTime / j10), Long.valueOf(totalSleepTime % j10)}, 2)));
                    long sleepDeepTime = dataByDate.getSleepDeepTime();
                    sleepChartData.setDeepSleepTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(sleepDeepTime / j10), Long.valueOf(sleepDeepTime % j10)}, 2)));
                    long sleepLightTime = dataByDate.getSleepLightTime();
                    sleepChartData.setLightSleepTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(sleepLightTime / j10), Long.valueOf(sleepLightTime % j10)}, 2)));
                    int wakeupCount = dataByDate.getWakeupCount();
                    sleepChartData.setWakeSleepTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Integer.valueOf(wakeupCount / 60), Integer.valueOf(wakeupCount % 60)}, 2)));
                    long sleepDeepTime2 = dataByDate.getSleepDeepTime() + dataByDate.getSleepLightTime();
                    if (d.f20005b) {
                        sleepDeepTime2 = dataByDate.getSleepDeepTime() + dataByDate.getSleepLightTime() + dataByDate.getWakeupCount();
                    }
                    sleepChartData.setSleepTime(String.format("%02dH%02dM", Arrays.copyOf(new Object[]{Long.valueOf(sleepDeepTime2 / j10), Long.valueOf(sleepDeepTime2 % j10)}, 2)));
                    List<SleepItemData> h4 = b.h(dataByDate.getItems(), new n().f3204b);
                    long asleepTime = dataByDate.getAsleepTime() * j4;
                    if (h4 != null) {
                        for (SleepItemData sleepItemData : h4) {
                            sleepItemData.setDurationPercent(sleepItemData.getDuration() / dataByDate.getTotalSleepTime());
                            sleepItemData.setStartTime(asleepTime);
                            asleepTime += sleepItemData.getDuration() * 60000;
                        }
                    }
                    sleepChartData.setItems(h4);
                }
            }
        }
        return sleepChartData;
    }

    public static StepChartData f(String str) {
        Date date;
        String str2;
        Object obj;
        StepChartData stepChartData = new StepChartData();
        try {
            date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(str);
        } catch (Exception unused) {
            date = null;
        }
        if (date != null) {
            long time = date.getTime();
            try {
                str2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
            } catch (Exception e) {
                b.o(b.f7264b, e.h(time, " date translate error ", e.getMessage()));
                str2 = null;
            }
            if (str2 != null) {
                if (k.f8731b == null) {
                    synchronized (k.class) {
                        k.f8731b = new k();
                    }
                }
                k kVar = k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    StepsImpl stepsImpl = StepsImpl.INSTANCE;
                    if (k.f8731b == null) {
                        synchronized (k.class) {
                            k.f8731b = new k();
                        }
                    }
                    k kVar2 = k.f8731b;
                    String g10 = kVar2 != null ? kVar2.g() : null;
                    String userId = d5.getUserId();
                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                    DataStep stepByDate = stepsImpl.getStepByDate(g10, userId, str2);
                    if (stepByDate != null) {
                        float f2 = 1000;
                        stepChartData.setCalorie(stepByDate.getCalorie() / f2);
                        stepChartData.setDistance(d5.getMeterUnit() == 0 ? stepByDate.getDistance() / f2 : v1.b(stepByDate.getDistance()));
                        stepChartData.setTotalSteps(stepByDate.getTotalStep());
                        List h4 = b.h(stepByDate.getItems(), new o().f3204b);
                        int i3 = 0;
                        for (int i10 = 0; i10 < 23; i10++) {
                            kotlin.jvm.internal.e.c(h4);
                            List list = h4;
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it.next();
                                if (kotlin.jvm.internal.e.a(((StepItemData) obj).getTime(), String.valueOf(i10))) {
                                    break;
                                }
                            }
                            if (((StepItemData) obj) == null) {
                                StepItemData stepItemData = new StepItemData();
                                stepItemData.setTime(String.valueOf(i10));
                                h4.add(i10, stepItemData);
                            } else {
                                List<StepItemData> list2 = EmptyList.INSTANCE;
                                for (Object obj2 : list) {
                                    if (kotlin.jvm.internal.e.a(((StepItemData) obj2).getTime(), String.valueOf(i10))) {
                                        if (list2.isEmpty()) {
                                            list2 = new ArrayList();
                                        }
                                        i.b(list2).add(obj2);
                                    }
                                }
                                if (list2.size() > 1) {
                                    StepItemData stepItemData2 = new StepItemData();
                                    stepItemData2.setTime(String.valueOf(i10));
                                    for (StepItemData stepItemData3 : list2) {
                                        stepItemData2.setCalorie(stepItemData3.getCalorie() + stepItemData2.getCalorie());
                                        stepItemData2.setSteps(stepItemData3.getSteps() + stepItemData2.getSteps());
                                        stepItemData2.setDistance(stepItemData3.getDistance() + stepItemData2.getDistance());
                                        h4.remove(stepItemData3);
                                    }
                                    h4.add(i10, stepItemData2);
                                }
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        kotlin.jvm.internal.e.c(h4);
                        for (Object obj3 : h4) {
                            int i11 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.i.f();
                                throw null;
                            }
                            arrayList.add(new BarEntry(i3, ((StepItemData) obj3).getSteps()));
                            i3 = i11;
                        }
                        stepChartData.setSteps(arrayList);
                    }
                    if (d5.getStepsTarget() == 0) {
                        d5.setStepsTarget(Const.I_GEO_MAX_TIME);
                    }
                    stepChartData.setStepTarget(d5.getStepsTarget());
                    int totalSteps = (int) ((stepChartData.getTotalSteps() / d5.getStepsTarget()) * 100);
                    stepChartData.setStepTargetPercent(100 > totalSteps ? totalSteps : 100);
                }
            }
        }
        return stepChartData;
    }

    public static StepChartData g(String str) {
        Date date;
        String str2;
        Object obj;
        StepChartData stepChartData = new StepChartData();
        try {
            date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(str);
        } catch (Exception unused) {
            date = null;
        }
        if (date != null) {
            long time = date.getTime();
            try {
                str2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
            } catch (Exception e) {
                b.o(b.f7264b, e.h(time, " date translate error ", e.getMessage()));
                str2 = null;
            }
            if (str2 != null) {
                if (k.f8731b == null) {
                    synchronized (k.class) {
                        k.f8731b = new k();
                    }
                }
                k kVar = k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    RawStepsImpl rawStepsImpl = RawStepsImpl.INSTANCE;
                    if (k.f8731b == null) {
                        synchronized (k.class) {
                            k.f8731b = new k();
                        }
                    }
                    k kVar2 = k.f8731b;
                    String g10 = kVar2 != null ? kVar2.g() : null;
                    String userId = d5.getUserId();
                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                    List<RawDataStep> stepByDate = rawStepsImpl.getStepByDate(g10, userId, str2);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i3 = 0;
                    if (!stepByDate.isEmpty()) {
                        RawDataStep rawDataStep = (RawDataStep) h.q(stepByDate);
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
                    Log.e("qob", "increasingList " + arrayList.size() + " decreasingList " + arrayList2.size());
                    RawStepsImpl.INSTANCE.deleteDecreaseStepData(arrayList);
                    if (!arrayList2.isEmpty()) {
                        Object obj2 = arrayList2.stream().max(Comparator.comparingInt(new v0(HealthDataAnalysis$getDayStepDetailJL$1$1$1$stepData$1.INSTANCE, 4))).get();
                        kotlin.jvm.internal.e.e(obj2, "get(...)");
                        RawDataStep rawDataStep3 = (RawDataStep) obj2;
                        float f2 = 1000;
                        stepChartData.setCalorie(rawDataStep3.getCalorie() / f2);
                        stepChartData.setDistance(d5.getMeterUnit() == 0 ? rawDataStep3.getDistance() / f2 : v1.b(rawDataStep3.getDistance()));
                        stepChartData.setTotalSteps(rawDataStep3.getStep());
                        ArrayList i10 = i(arrayList2);
                        for (int i11 = 0; i11 < 23; i11++) {
                            int size2 = i10.size();
                            int i12 = 0;
                            while (true) {
                                if (i12 >= size2) {
                                    obj = null;
                                    break;
                                }
                                obj = i10.get(i12);
                                i12++;
                                if (((StepItemBean) obj).getIndex() == i11) {
                                    break;
                                }
                            }
                            if (((StepItemBean) obj) == null) {
                                StepItemBean stepItemBean = new StepItemBean();
                                stepItemBean.setIndex(i11);
                                i10.add(i11, stepItemBean);
                            } else {
                                List<StepItemBean> list = EmptyList.INSTANCE;
                                int size3 = i10.size();
                                int i13 = 0;
                                while (i13 < size3) {
                                    Object obj3 = i10.get(i13);
                                    i13++;
                                    if (((StepItemBean) obj3).getIndex() == i11) {
                                        if (list.isEmpty()) {
                                            list = new ArrayList();
                                        }
                                        i.b(list).add(obj3);
                                    }
                                }
                                if (list.size() > 1) {
                                    StepItemBean stepItemBean2 = new StepItemBean();
                                    stepItemBean2.setIndex(i11);
                                    for (StepItemBean stepItemBean3 : list) {
                                        stepItemBean2.setCalorie(stepItemBean3.getCalorie() + stepItemBean2.getCalorie());
                                        stepItemBean2.setSteps(stepItemBean3.getSteps() + stepItemBean2.getSteps());
                                        stepItemBean2.setDistance(stepItemBean3.getDistance() + stepItemBean2.getDistance());
                                        i10.remove(stepItemBean3);
                                    }
                                    i10.add(i11, stepItemBean2);
                                }
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        int size4 = i10.size();
                        int i14 = 0;
                        while (i14 < size4) {
                            Object obj4 = i10.get(i14);
                            i14++;
                            int i15 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.i.f();
                                throw null;
                            }
                            arrayList3.add(new BarEntry(i3, ((StepItemBean) obj4).getSteps()));
                            i3 = i15;
                        }
                        stepChartData.setSteps(arrayList3);
                    }
                    if (d5.getStepsTarget() == 0) {
                        d5.setStepsTarget(Const.I_GEO_MAX_TIME);
                    }
                    stepChartData.setStepTarget(d5.getStepsTarget());
                    int totalSteps = (int) ((stepChartData.getTotalSteps() / d5.getStepsTarget()) * 100);
                    stepChartData.setStepTargetPercent(100 > totalSteps ? totalSteps : 100);
                }
            }
        }
        return stepChartData;
    }

    public static ArrayList h(List list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            HashMap a3 = y5.e.a("date", list);
            for (String str : a3.keySet()) {
                DataStep dataStep = new DataStep();
                Object obj = a3.get(str);
                kotlin.jvm.internal.e.c(obj);
                List list2 = (List) obj;
                Object obj2 = list2.stream().max(Comparator.comparingInt(new v0(HealthDataAnalysis$parseStepMoreData$stepData$1.INSTANCE, 3))).get();
                kotlin.jvm.internal.e.e(obj2, "get(...)");
                RawDataStep rawDataStep = (RawDataStep) obj2;
                dataStep.setCalorie(rawDataStep.getCalorie());
                dataStep.setDistance(rawDataStep.getDistance());
                dataStep.setTotalStep(rawDataStep.getStep());
                dataStep.setDate(str);
                dataStep.setItems(b.z(i(list2)));
                arrayList.add(dataStep);
            }
        }
        return arrayList;
    }

    public static ArrayList i(List list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            HashMap a3 = y5.e.a("hour", list);
            StepItemBean stepItemBean = new StepItemBean();
            for (String str : a3.keySet()) {
                Object obj = a3.get(str);
                kotlin.jvm.internal.e.c(obj);
                List list2 = (List) obj;
                StepItemBean stepItemBean2 = new StepItemBean();
                Stream stream = list2.stream();
                final HealthDataAnalysis$parseStepOneData$itemStep$1 healthDataAnalysis$parseStepOneData$itemStep$1 = new l() { // from class: com.example.test.presenter.analysis.HealthDataAnalysis$parseStepOneData$itemStep$1
                    @Override // oh.l
                    public final Long invoke(RawDataStep obj2) {
                        kotlin.jvm.internal.e.f(obj2, "obj");
                        return Long.valueOf(obj2.getTimestamp());
                    }
                };
                final int i3 = 0;
                int step = ((RawDataStep) stream.min(Comparator.comparingLong(new ToLongFunction() { // from class: g6.a
                    @Override // java.util.function.ToLongFunction
                    public final long applyAsLong(Object obj2) {
                        switch (i3) {
                            case 0:
                                oh.l tmp0 = healthDataAnalysis$parseStepOneData$itemStep$1;
                                kotlin.jvm.internal.e.f(tmp0, "$tmp0");
                                return ((Number) tmp0.invoke(obj2)).longValue();
                            case 1:
                                oh.l tmp02 = healthDataAnalysis$parseStepOneData$itemStep$1;
                                kotlin.jvm.internal.e.f(tmp02, "$tmp0");
                                return ((Number) tmp02.invoke(obj2)).longValue();
                            case 2:
                                oh.l tmp03 = healthDataAnalysis$parseStepOneData$itemStep$1;
                                kotlin.jvm.internal.e.f(tmp03, "$tmp0");
                                return ((Number) tmp03.invoke(obj2)).longValue();
                            case 3:
                                oh.l tmp04 = healthDataAnalysis$parseStepOneData$itemStep$1;
                                kotlin.jvm.internal.e.f(tmp04, "$tmp0");
                                return ((Number) tmp04.invoke(obj2)).longValue();
                            case 4:
                                oh.l tmp05 = healthDataAnalysis$parseStepOneData$itemStep$1;
                                kotlin.jvm.internal.e.f(tmp05, "$tmp0");
                                return ((Number) tmp05.invoke(obj2)).longValue();
                            default:
                                oh.l tmp06 = healthDataAnalysis$parseStepOneData$itemStep$1;
                                kotlin.jvm.internal.e.f(tmp06, "$tmp0");
                                return ((Number) tmp06.invoke(obj2)).longValue();
                        }
                    }
                })).get()).getStep();
                Stream stream2 = list2.stream();
                final HealthDataAnalysis$parseStepOneData$itemCalorie$1 healthDataAnalysis$parseStepOneData$itemCalorie$1 = new l() { // from class: com.example.test.presenter.analysis.HealthDataAnalysis$parseStepOneData$itemCalorie$1
                    @Override // oh.l
                    public final Long invoke(RawDataStep obj2) {
                        kotlin.jvm.internal.e.f(obj2, "obj");
                        return Long.valueOf(obj2.getTimestamp());
                    }
                };
                final int i10 = 1;
                float calorie = ((RawDataStep) stream2.min(Comparator.comparingLong(new ToLongFunction() { // from class: g6.a
                    @Override // java.util.function.ToLongFunction
                    public final long applyAsLong(Object obj2) {
                        switch (i10) {
                            case 0:
                                oh.l tmp0 = healthDataAnalysis$parseStepOneData$itemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp0, "$tmp0");
                                return ((Number) tmp0.invoke(obj2)).longValue();
                            case 1:
                                oh.l tmp02 = healthDataAnalysis$parseStepOneData$itemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp02, "$tmp0");
                                return ((Number) tmp02.invoke(obj2)).longValue();
                            case 2:
                                oh.l tmp03 = healthDataAnalysis$parseStepOneData$itemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp03, "$tmp0");
                                return ((Number) tmp03.invoke(obj2)).longValue();
                            case 3:
                                oh.l tmp04 = healthDataAnalysis$parseStepOneData$itemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp04, "$tmp0");
                                return ((Number) tmp04.invoke(obj2)).longValue();
                            case 4:
                                oh.l tmp05 = healthDataAnalysis$parseStepOneData$itemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp05, "$tmp0");
                                return ((Number) tmp05.invoke(obj2)).longValue();
                            default:
                                oh.l tmp06 = healthDataAnalysis$parseStepOneData$itemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp06, "$tmp0");
                                return ((Number) tmp06.invoke(obj2)).longValue();
                        }
                    }
                })).get()).getCalorie();
                Stream stream3 = list2.stream();
                final HealthDataAnalysis$parseStepOneData$itemDistance$1 healthDataAnalysis$parseStepOneData$itemDistance$1 = new l() { // from class: com.example.test.presenter.analysis.HealthDataAnalysis$parseStepOneData$itemDistance$1
                    @Override // oh.l
                    public final Long invoke(RawDataStep obj2) {
                        kotlin.jvm.internal.e.f(obj2, "obj");
                        return Long.valueOf(obj2.getTimestamp());
                    }
                };
                final int i11 = 2;
                float distance = ((RawDataStep) stream3.min(Comparator.comparingLong(new ToLongFunction() { // from class: g6.a
                    @Override // java.util.function.ToLongFunction
                    public final long applyAsLong(Object obj2) {
                        switch (i11) {
                            case 0:
                                oh.l tmp0 = healthDataAnalysis$parseStepOneData$itemDistance$1;
                                kotlin.jvm.internal.e.f(tmp0, "$tmp0");
                                return ((Number) tmp0.invoke(obj2)).longValue();
                            case 1:
                                oh.l tmp02 = healthDataAnalysis$parseStepOneData$itemDistance$1;
                                kotlin.jvm.internal.e.f(tmp02, "$tmp0");
                                return ((Number) tmp02.invoke(obj2)).longValue();
                            case 2:
                                oh.l tmp03 = healthDataAnalysis$parseStepOneData$itemDistance$1;
                                kotlin.jvm.internal.e.f(tmp03, "$tmp0");
                                return ((Number) tmp03.invoke(obj2)).longValue();
                            case 3:
                                oh.l tmp04 = healthDataAnalysis$parseStepOneData$itemDistance$1;
                                kotlin.jvm.internal.e.f(tmp04, "$tmp0");
                                return ((Number) tmp04.invoke(obj2)).longValue();
                            case 4:
                                oh.l tmp05 = healthDataAnalysis$parseStepOneData$itemDistance$1;
                                kotlin.jvm.internal.e.f(tmp05, "$tmp0");
                                return ((Number) tmp05.invoke(obj2)).longValue();
                            default:
                                oh.l tmp06 = healthDataAnalysis$parseStepOneData$itemDistance$1;
                                kotlin.jvm.internal.e.f(tmp06, "$tmp0");
                                return ((Number) tmp06.invoke(obj2)).longValue();
                        }
                    }
                })).get()).getDistance();
                Integer valueOf = Integer.valueOf(str);
                kotlin.jvm.internal.e.e(valueOf, "valueOf(...)");
                stepItemBean2.setIndex(valueOf.intValue());
                stepItemBean2.setSteps(step);
                stepItemBean2.setCalorie((int) calorie);
                stepItemBean2.setDistance((int) distance);
                Stream stream4 = list2.stream();
                final HealthDataAnalysis$parseStepOneData$lastItemStep$1 healthDataAnalysis$parseStepOneData$lastItemStep$1 = new l() { // from class: com.example.test.presenter.analysis.HealthDataAnalysis$parseStepOneData$lastItemStep$1
                    @Override // oh.l
                    public final Long invoke(RawDataStep obj2) {
                        kotlin.jvm.internal.e.f(obj2, "obj");
                        return Long.valueOf(obj2.getTimestamp());
                    }
                };
                final int i12 = 3;
                int step2 = ((RawDataStep) stream4.max(Comparator.comparingLong(new ToLongFunction() { // from class: g6.a
                    @Override // java.util.function.ToLongFunction
                    public final long applyAsLong(Object obj2) {
                        switch (i12) {
                            case 0:
                                oh.l tmp0 = healthDataAnalysis$parseStepOneData$lastItemStep$1;
                                kotlin.jvm.internal.e.f(tmp0, "$tmp0");
                                return ((Number) tmp0.invoke(obj2)).longValue();
                            case 1:
                                oh.l tmp02 = healthDataAnalysis$parseStepOneData$lastItemStep$1;
                                kotlin.jvm.internal.e.f(tmp02, "$tmp0");
                                return ((Number) tmp02.invoke(obj2)).longValue();
                            case 2:
                                oh.l tmp03 = healthDataAnalysis$parseStepOneData$lastItemStep$1;
                                kotlin.jvm.internal.e.f(tmp03, "$tmp0");
                                return ((Number) tmp03.invoke(obj2)).longValue();
                            case 3:
                                oh.l tmp04 = healthDataAnalysis$parseStepOneData$lastItemStep$1;
                                kotlin.jvm.internal.e.f(tmp04, "$tmp0");
                                return ((Number) tmp04.invoke(obj2)).longValue();
                            case 4:
                                oh.l tmp05 = healthDataAnalysis$parseStepOneData$lastItemStep$1;
                                kotlin.jvm.internal.e.f(tmp05, "$tmp0");
                                return ((Number) tmp05.invoke(obj2)).longValue();
                            default:
                                oh.l tmp06 = healthDataAnalysis$parseStepOneData$lastItemStep$1;
                                kotlin.jvm.internal.e.f(tmp06, "$tmp0");
                                return ((Number) tmp06.invoke(obj2)).longValue();
                        }
                    }
                })).get()).getStep();
                Stream stream5 = list2.stream();
                final HealthDataAnalysis$parseStepOneData$lastItemCalorie$1 healthDataAnalysis$parseStepOneData$lastItemCalorie$1 = new l() { // from class: com.example.test.presenter.analysis.HealthDataAnalysis$parseStepOneData$lastItemCalorie$1
                    @Override // oh.l
                    public final Long invoke(RawDataStep obj2) {
                        kotlin.jvm.internal.e.f(obj2, "obj");
                        return Long.valueOf(obj2.getTimestamp());
                    }
                };
                final int i13 = 4;
                float calorie2 = ((RawDataStep) stream5.max(Comparator.comparingLong(new ToLongFunction() { // from class: g6.a
                    @Override // java.util.function.ToLongFunction
                    public final long applyAsLong(Object obj2) {
                        switch (i13) {
                            case 0:
                                oh.l tmp0 = healthDataAnalysis$parseStepOneData$lastItemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp0, "$tmp0");
                                return ((Number) tmp0.invoke(obj2)).longValue();
                            case 1:
                                oh.l tmp02 = healthDataAnalysis$parseStepOneData$lastItemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp02, "$tmp0");
                                return ((Number) tmp02.invoke(obj2)).longValue();
                            case 2:
                                oh.l tmp03 = healthDataAnalysis$parseStepOneData$lastItemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp03, "$tmp0");
                                return ((Number) tmp03.invoke(obj2)).longValue();
                            case 3:
                                oh.l tmp04 = healthDataAnalysis$parseStepOneData$lastItemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp04, "$tmp0");
                                return ((Number) tmp04.invoke(obj2)).longValue();
                            case 4:
                                oh.l tmp05 = healthDataAnalysis$parseStepOneData$lastItemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp05, "$tmp0");
                                return ((Number) tmp05.invoke(obj2)).longValue();
                            default:
                                oh.l tmp06 = healthDataAnalysis$parseStepOneData$lastItemCalorie$1;
                                kotlin.jvm.internal.e.f(tmp06, "$tmp0");
                                return ((Number) tmp06.invoke(obj2)).longValue();
                        }
                    }
                })).get()).getCalorie();
                Stream stream6 = list2.stream();
                final HealthDataAnalysis$parseStepOneData$lastItemDistance$1 healthDataAnalysis$parseStepOneData$lastItemDistance$1 = new l() { // from class: com.example.test.presenter.analysis.HealthDataAnalysis$parseStepOneData$lastItemDistance$1
                    @Override // oh.l
                    public final Long invoke(RawDataStep obj2) {
                        kotlin.jvm.internal.e.f(obj2, "obj");
                        return Long.valueOf(obj2.getTimestamp());
                    }
                };
                final int i14 = 5;
                float distance2 = ((RawDataStep) stream6.max(Comparator.comparingLong(new ToLongFunction() { // from class: g6.a
                    @Override // java.util.function.ToLongFunction
                    public final long applyAsLong(Object obj2) {
                        switch (i14) {
                            case 0:
                                oh.l tmp0 = healthDataAnalysis$parseStepOneData$lastItemDistance$1;
                                kotlin.jvm.internal.e.f(tmp0, "$tmp0");
                                return ((Number) tmp0.invoke(obj2)).longValue();
                            case 1:
                                oh.l tmp02 = healthDataAnalysis$parseStepOneData$lastItemDistance$1;
                                kotlin.jvm.internal.e.f(tmp02, "$tmp0");
                                return ((Number) tmp02.invoke(obj2)).longValue();
                            case 2:
                                oh.l tmp03 = healthDataAnalysis$parseStepOneData$lastItemDistance$1;
                                kotlin.jvm.internal.e.f(tmp03, "$tmp0");
                                return ((Number) tmp03.invoke(obj2)).longValue();
                            case 3:
                                oh.l tmp04 = healthDataAnalysis$parseStepOneData$lastItemDistance$1;
                                kotlin.jvm.internal.e.f(tmp04, "$tmp0");
                                return ((Number) tmp04.invoke(obj2)).longValue();
                            case 4:
                                oh.l tmp05 = healthDataAnalysis$parseStepOneData$lastItemDistance$1;
                                kotlin.jvm.internal.e.f(tmp05, "$tmp0");
                                return ((Number) tmp05.invoke(obj2)).longValue();
                            default:
                                oh.l tmp06 = healthDataAnalysis$parseStepOneData$lastItemDistance$1;
                                kotlin.jvm.internal.e.f(tmp06, "$tmp0");
                                return ((Number) tmp06.invoke(obj2)).longValue();
                        }
                    }
                })).get()).getDistance();
                Integer valueOf2 = Integer.valueOf(str);
                kotlin.jvm.internal.e.e(valueOf2, "valueOf(...)");
                stepItemBean.setIndex(valueOf2.intValue());
                stepItemBean.setSteps(step2);
                stepItemBean.setCalorie((int) calorie2);
                stepItemBean.setDistance((int) distance2);
                arrayList2.add(stepItemBean2);
            }
            Stream stream7 = arrayList2.stream();
            final HealthDataAnalysis$parseStepOneData$sortedList$1 healthDataAnalysis$parseStepOneData$sortedList$1 = new l() { // from class: com.example.test.presenter.analysis.HealthDataAnalysis$parseStepOneData$sortedList$1
                @Override // oh.l
                public final Integer invoke(StepItemBean obj2) {
                    kotlin.jvm.internal.e.f(obj2, "obj");
                    return Integer.valueOf(obj2.getIndex());
                }
            };
            List list3 = (List) stream7.sorted(Comparator.comparing(new Function() { // from class: g6.b
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    oh.l tmp0 = oh.l.this;
                    kotlin.jvm.internal.e.f(tmp0, "$tmp0");
                    return (Integer) tmp0.invoke(obj2);
                }
            })).collect(Collectors.toList());
            if (list3.size() > 1) {
                StepItemBean stepItemBean3 = (StepItemBean) list3.get(0);
                int steps = stepItemBean3.getSteps();
                int calorie3 = stepItemBean3.getCalorie();
                int distance3 = stepItemBean3.getDistance();
                int i15 = 1;
                while (i15 < list3.size()) {
                    StepItemBean stepItemBean4 = (StepItemBean) list3.get(i15);
                    StepItemBean stepItemBean5 = (StepItemBean) list3.get(i15 - 1);
                    stepItemBean5.setSteps(stepItemBean4.getSteps() - steps);
                    stepItemBean5.setCalorie(stepItemBean4.getCalorie() - calorie3);
                    stepItemBean5.setDistance(stepItemBean4.getDistance() - distance3);
                    steps = stepItemBean4.getSteps();
                    calorie3 = stepItemBean4.getCalorie();
                    distance3 = stepItemBean4.getDistance();
                    i15++;
                }
                StepItemBean stepItemBean6 = (StepItemBean) list3.get(i15 - 1);
                stepItemBean6.setSteps(stepItemBean.getSteps() - steps);
                stepItemBean6.setCalorie(stepItemBean.getCalorie() - calorie3);
                stepItemBean6.setDistance(stepItemBean.getDistance() - distance3);
            }
            arrayList.addAll(list3);
        }
        return arrayList;
    }
}
