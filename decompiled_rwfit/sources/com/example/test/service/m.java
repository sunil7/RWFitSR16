package com.example.test.service;

import android.util.Log;
import com.example.blesdk.bean.sync.BoPartData;
import com.example.blesdk.bean.sync.BpPartData;
import com.example.blesdk.bean.sync.BreathPartData;
import com.example.blesdk.bean.sync.BreatheItemBean;
import com.example.blesdk.bean.sync.HealthDataSyncBean;
import com.example.blesdk.bean.sync.HrPartData;
import com.example.blesdk.bean.sync.JLStepSyncBean;
import com.example.blesdk.bean.sync.PressurePartData;
import com.example.blesdk.bean.sync.StepPartData;
import com.example.blesdk.bean.sync.TempPartData;
import com.example.database.db.BloodPressImpl;
import com.example.database.db.BodyTempImpl;
import com.example.database.db.BreatheImpl;
import com.example.database.db.RawStepsImpl;
import com.example.database.db.StepsImpl;
import com.example.database.table.DataBloodPress;
import com.example.database.table.DataBodyTemp;
import com.example.database.table.DataBreathe;
import com.example.database.table.DataStep;
import com.example.database.table.Devices;
import com.example.database.table.RawDataStep;
import com.example.database.table.User;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.BpData;
import com.example.test.ui.model.chart.chart.MuslimItemData;
import com.example.test.ui.model.chart.chart.StepItemData;
import com.example.test.ui.model.chart.chart.TempData;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class m implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7731a;

    public m(d0 d0Var) {
        this.f7731a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7731a, "健康数据广播失败", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        final HealthDataSyncBean healthDataSyncBean = (HealthDataSyncBean) obj;
        if (healthDataSyncBean != null) {
            this.f7731a.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("健康数据广播", com.example.baselibrary.utils.b.z(healthDataSyncBean)));
            final Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            switch (healthDataSyncBean.getDataType()) {
                case 0:
                    if (!y5.d.f20005b) {
                        com.example.baselibrary.utils.b.x(healthDataSyncBean.getStepPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$3

                            public static final class a extends bc.a<ArrayList<StepItemData>> {
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // oh.l
                            public final Integer invoke(List<StepPartData> list) {
                                User d5;
                                Devices c9;
                                Object obj2;
                                com.example.test.utils.k a3 = y1.a();
                                if (a3 != null && (d5 = a3.d()) != null) {
                                    Calendar calendar2 = calendar;
                                    String i3 = ca.i(Calendar.getInstance().getTimeInMillis(), "yyyyMMdd");
                                    if (i3 != null) {
                                        StepsImpl stepsImpl = StepsImpl.INSTANCE;
                                        com.example.test.utils.k a10 = y1.a();
                                        String g10 = a10 != null ? a10.g() : null;
                                        String userId = d5.getUserId();
                                        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                        DataStep stepByDate = stepsImpl.getStepByDate(g10, userId, i3);
                                        if (stepByDate == null) {
                                            stepByDate = new DataStep();
                                        }
                                        String date = stepByDate.getDate();
                                        if (date == null || date.length() == 0) {
                                            stepByDate.setDate(ca.i(calendar2.getTimeInMillis(), "yyyyMMdd"));
                                            stepByDate.setTimestamp(String.valueOf(calendar2.getTimeInMillis() / 1000));
                                            com.example.test.utils.k a11 = y1.a();
                                            if (a11 != null && (c9 = a11.c()) != null) {
                                                stepByDate.setMac(c9.getMacAddress());
                                            }
                                            stepByDate.setUserId(d5.getUserId());
                                        }
                                        stepByDate.setIsUpdate(false);
                                        List<StepItemData> h4 = com.example.baselibrary.utils.b.h(stepByDate.getItems(), new a().f3204b);
                                        kotlin.jvm.internal.e.c(list);
                                        for (StepPartData stepPartData : list) {
                                            kotlin.jvm.internal.e.c(h4);
                                            Iterator it = h4.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    obj2 = null;
                                                    break;
                                                }
                                                obj2 = it.next();
                                                if (kotlin.jvm.internal.e.a(((StepItemData) obj2).getTime(), String.valueOf(stepPartData.getIndex()))) {
                                                    break;
                                                }
                                            }
                                            StepItemData stepItemData = (StepItemData) obj2;
                                            if (stepItemData != null) {
                                                stepItemData.setSteps(stepPartData.getSteps());
                                                stepItemData.setDistance(stepPartData.getDistance());
                                                stepItemData.setCalorie(stepPartData.getCal());
                                            } else {
                                                StepItemData stepItemData2 = new StepItemData();
                                                stepItemData2.setTime(String.valueOf(stepPartData.getIndex()));
                                                stepItemData2.setCalorie(stepPartData.getCal());
                                                stepItemData2.setDistance(stepPartData.getDistance());
                                                stepItemData2.setSteps(stepPartData.getSteps());
                                                h4.add(stepItemData2);
                                            }
                                        }
                                        stepByDate.setCalorie(0.0f);
                                        stepByDate.setDistance(0.0f);
                                        stepByDate.setTotalStep(0);
                                        kotlin.jvm.internal.e.c(h4);
                                        for (StepItemData stepItemData3 : h4) {
                                            stepByDate.setCalorie(stepItemData3.getCalorie() + stepByDate.getCalorie());
                                            stepByDate.setDistance(stepItemData3.getDistance() + stepByDate.getDistance());
                                            stepByDate.setTotalStep(stepItemData3.getSteps() + stepByDate.getTotalStep());
                                        }
                                        stepByDate.setItems(com.example.baselibrary.utils.b.z(h4));
                                        StepsImpl.INSTANCE.saveStep(stepByDate);
                                    }
                                }
                                return 1;
                            }
                        }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$4
                            @Override // oh.l
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke(((Number) obj2).intValue());
                                return eh.g.f12633a;
                            }

                            public final void invoke(int i3) {
                                yh.d.b().e(new EventBusBeans.SyncEvent(0));
                            }
                        });
                        break;
                    } else {
                        Object obj2 = u1.f7811u;
                        u1 a3 = com.google.android.gms.internal.mlkit_vision_barcode.q1.a();
                        List<JLStepSyncBean> stepJLPartData = healthDataSyncBean.getStepJLPartData();
                        a3.getClass();
                        if (stepJLPartData != null) {
                            com.example.baselibrary.utils.b.x(stepJLPartData, new oh.l() { // from class: com.example.test.service.SyncService$onSyncJLStepRealTimeData$1$1
                                @Override // oh.l
                                public final Boolean invoke(List<? extends JLStepSyncBean> list) {
                                    String str;
                                    User d5;
                                    Devices c9;
                                    ArrayList t8 = android.support.v4.media.session.e.t("stepSyncList", list);
                                    for (JLStepSyncBean jLStepSyncBean : list) {
                                        RawDataStep rawDataStep = new RawDataStep();
                                        rawDataStep.setCalorie(jLStepSyncBean.getCalorie());
                                        rawDataStep.setDistance(jLStepSyncBean.getDistance());
                                        rawDataStep.setStep(jLStepSyncBean.getSteps());
                                        rawDataStep.setTimestamp(jLStepSyncBean.getTime());
                                        Calendar calendar2 = Calendar.getInstance();
                                        calendar2.setTimeInMillis(jLStepSyncBean.getTime() * 1000);
                                        calendar2.set(11, 0);
                                        calendar2.set(12, 0);
                                        calendar2.set(13, 0);
                                        calendar2.set(14, 0);
                                        long timeInMillis = calendar2.getTimeInMillis();
                                        try {
                                            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                                        } catch (Exception e) {
                                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                                            str = null;
                                        }
                                        rawDataStep.setDate(str);
                                        rawDataStep.setHour(jLStepSyncBean.getHour());
                                        if (com.example.test.utils.k.f8731b == null) {
                                            synchronized (com.example.test.utils.k.class) {
                                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                            }
                                        }
                                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                                        if (kVar != null && (c9 = kVar.c()) != null) {
                                            rawDataStep.setMac(c9.getMacAddress());
                                        }
                                        if (com.example.test.utils.k.f8731b == null) {
                                            synchronized (com.example.test.utils.k.class) {
                                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                            }
                                        }
                                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                        if (kVar2 != null && (d5 = kVar2.d()) != null) {
                                            rawDataStep.setUserId(d5.getUserId());
                                        }
                                        rawDataStep.setIsUpdate(false);
                                        t8.add(rawDataStep);
                                    }
                                    return Boolean.valueOf(RawStepsImpl.INSTANCE.saveSteps(t8));
                                }
                            }, new oh.l() { // from class: com.example.test.service.SyncService$onSyncJLStepRealTimeData$1$2
                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                    invoke(((Boolean) obj3).booleanValue());
                                    return eh.g.f12633a;
                                }

                                public final void invoke(boolean z5) {
                                    yh.d.b().e(new EventBusBeans.SyncEvent(0));
                                }
                            });
                        }
                        Object obj3 = com.example.test.utils.m.f8734b;
                        if (d2.a().a()) {
                            com.example.baselibrary.utils.b.x(healthDataSyncBean.getStepJLPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$1
                                @Override // oh.l
                                public final Integer invoke(List<JLStepSyncBean> list) {
                                    String str;
                                    User d5;
                                    Devices c9;
                                    ArrayList arrayList = new ArrayList();
                                    kotlin.jvm.internal.e.c(list);
                                    for (JLStepSyncBean jLStepSyncBean : list) {
                                        DataStep dataStep = new DataStep();
                                        dataStep.setCalorie(jLStepSyncBean.getCalorie());
                                        dataStep.setDistance(jLStepSyncBean.getDistance());
                                        dataStep.setTotalStep(jLStepSyncBean.getSteps());
                                        dataStep.setTimestamp(String.valueOf(jLStepSyncBean.getTime()));
                                        Calendar calendar2 = Calendar.getInstance();
                                        calendar2.setTimeInMillis(jLStepSyncBean.getTime() * 1000);
                                        calendar2.set(11, 0);
                                        calendar2.set(12, 0);
                                        calendar2.set(13, 0);
                                        calendar2.set(14, 0);
                                        long timeInMillis = calendar2.getTimeInMillis();
                                        try {
                                            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                                        } catch (Exception e) {
                                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                                            str = null;
                                        }
                                        dataStep.setDate(str);
                                        if (com.example.test.utils.k.f8731b == null) {
                                            synchronized (com.example.test.utils.k.class) {
                                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                            }
                                        }
                                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                                        if (kVar != null && (c9 = kVar.c()) != null) {
                                            dataStep.setMac(c9.getMacAddress());
                                        }
                                        if (com.example.test.utils.k.f8731b == null) {
                                            synchronized (com.example.test.utils.k.class) {
                                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                            }
                                        }
                                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                        if (kVar2 != null && (d5 = kVar2.d()) != null) {
                                            dataStep.setUserId(d5.getUserId());
                                        }
                                        dataStep.setIsUpdate(false);
                                        ArrayList arrayList2 = new ArrayList();
                                        StepsImpl stepsImpl = StepsImpl.INSTANCE;
                                        String mac = dataStep.getMac();
                                        String userId = dataStep.getUserId();
                                        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                        String date = dataStep.getDate();
                                        kotlin.jvm.internal.e.e(date, "getDate(...)");
                                        DataStep stepByDate = stepsImpl.getStepByDate(mac, userId, date);
                                        dataStep.setItems(com.example.baselibrary.utils.b.z(arrayList2));
                                        if (stepByDate != null) {
                                            dataStep.setItems(stepByDate.getItems());
                                        }
                                        arrayList.add(dataStep);
                                        Log.e("qob", "onSyncStep " + dataStep.getDate() + " items " + dataStep.getItems());
                                    }
                                    StepsImpl.INSTANCE.saveStep((DataStep) arrayList.get(0));
                                    return 1;
                                }
                            }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$2
                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                                    invoke(((Number) obj4).intValue());
                                    return eh.g.f12633a;
                                }

                                public final void invoke(int i3) {
                                    yh.d.b().e(new EventBusBeans.SyncEvent(0));
                                }
                            });
                            break;
                        }
                    }
                    break;
                case 1:
                    com.example.baselibrary.utils.b.x(healthDataSyncBean.getHrPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$5
                        public final void invoke(List<HrPartData> list) {
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                            invoke((List<HrPartData>) obj4);
                            return eh.g.f12633a;
                        }
                    }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$6
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                            invoke((eh.g) obj4);
                            return eh.g.f12633a;
                        }

                        public final void invoke(eh.g it) {
                            kotlin.jvm.internal.e.f(it, "it");
                            List<HrPartData> hrPartData = HealthDataSyncBean.this.getHrPartData();
                            kotlin.jvm.internal.e.e(hrPartData, "getHrPartData(...)");
                            Log.d("tong", "2send hr value = " + ((HrPartData) kotlin.collections.h.q(hrPartData)).getHr());
                            List<HrPartData> hrPartData2 = HealthDataSyncBean.this.getHrPartData();
                            kotlin.jvm.internal.e.e(hrPartData2, "getHrPartData(...)");
                            yh.d.b().e(new EventBusBeans.SyncDataEvent(1, ((HrPartData) kotlin.collections.h.q(hrPartData2)).getHr()));
                        }
                    });
                    break;
                case 2:
                    com.example.baselibrary.utils.b.x(healthDataSyncBean.getBpPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$13

                        public static final class a extends bc.a<ArrayList<BpData>> {
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public final Integer invoke(List<BpPartData> list) {
                            User d5;
                            Devices c9;
                            com.example.test.utils.k a10 = y1.a();
                            if (a10 != null && (d5 = a10.d()) != null) {
                                Calendar calendar2 = calendar;
                                String i3 = ca.i(Calendar.getInstance().getTimeInMillis(), "yyyyMMdd");
                                if (i3 != null) {
                                    BloodPressImpl bloodPressImpl = BloodPressImpl.INSTANCE;
                                    com.example.test.utils.k a11 = y1.a();
                                    String g10 = a11 != null ? a11.g() : null;
                                    String userId = d5.getUserId();
                                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                    DataBloodPress dataByDate = bloodPressImpl.getDataByDate(g10, userId, i3);
                                    if (dataByDate == null) {
                                        dataByDate = new DataBloodPress();
                                    }
                                    String date = dataByDate.getDate();
                                    if (date == null || date.length() == 0) {
                                        dataByDate.setUserId(d5.getUserId());
                                        com.example.test.utils.k a12 = y1.a();
                                        if (a12 != null && (c9 = a12.c()) != null) {
                                            dataByDate.setMac(c9.getMacAddress());
                                        }
                                        dataByDate.setTimestamp(String.valueOf(calendar2.getTimeInMillis() / 1000));
                                        dataByDate.setDate(ca.i(calendar2.getTimeInMillis(), "yyyyMMdd"));
                                    }
                                    int i10 = 0;
                                    dataByDate.setIsUpdate(false);
                                    List<BpData> h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new a().f3204b);
                                    kotlin.jvm.internal.e.c(list);
                                    for (BpPartData bpPartData : list) {
                                        BpData bpData = new BpData();
                                        bpData.setSp(bpPartData.getSp());
                                        bpData.setDp(bpPartData.getDp());
                                        bpData.setCurrentTime(bpPartData.getTime());
                                        kotlin.jvm.internal.e.c(h4);
                                        h4.add(bpData);
                                    }
                                    kotlin.jvm.internal.e.c(h4);
                                    int i11 = 0;
                                    int i12 = 0;
                                    int i13 = 0;
                                    int i14 = 0;
                                    int i15 = Integer.MAX_VALUE;
                                    int i16 = Integer.MAX_VALUE;
                                    int i17 = 0;
                                    for (BpData bpData2 : h4) {
                                        if (bpData2.getDp() > 0) {
                                            if (bpData2.getDp() < i15) {
                                                i15 = bpData2.getDp();
                                            }
                                            i10++;
                                            i17 = bpData2.getDp() + i17;
                                        }
                                        if (bpData2.getSp() > 0) {
                                            if (bpData2.getSp() < i16) {
                                                i16 = bpData2.getSp();
                                            }
                                            i11++;
                                            i12 = bpData2.getSp() + i12;
                                        }
                                        if (bpData2.getDp() > i14) {
                                            i14 = bpData2.getDp();
                                        }
                                        if (bpData2.getSp() > i13) {
                                            i13 = bpData2.getSp();
                                        }
                                    }
                                    if (i10 > 0) {
                                        dataByDate.setAvgDp(i17 / i10);
                                    }
                                    if (i11 > 0) {
                                        dataByDate.setAvgSp(i12 / i11);
                                    }
                                    dataByDate.setMaxDp(i14);
                                    dataByDate.setMaxSp(i13);
                                    dataByDate.setMinSp(i16);
                                    dataByDate.setMinDp(i15);
                                    dataByDate.setItems(com.example.baselibrary.utils.b.z(h4));
                                    BloodPressImpl.INSTANCE.saveData(dataByDate);
                                }
                            }
                            return 1;
                        }
                    }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$14
                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                            invoke(((Number) obj4).intValue());
                            return eh.g.f12633a;
                        }

                        public final void invoke(int i3) {
                            yh.d.b().e(new EventBusBeans.SyncEvent(2));
                        }
                    });
                    break;
                case 3:
                    com.example.baselibrary.utils.b.x(healthDataSyncBean.getBoPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$15
                        public final void invoke(List<BoPartData> list) {
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                            invoke((List<BoPartData>) obj4);
                            return eh.g.f12633a;
                        }
                    }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$16
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                            invoke((eh.g) obj4);
                            return eh.g.f12633a;
                        }

                        public final void invoke(eh.g it) {
                            kotlin.jvm.internal.e.f(it, "it");
                            List<BoPartData> boPartData = HealthDataSyncBean.this.getBoPartData();
                            kotlin.jvm.internal.e.e(boPartData, "getBoPartData(...)");
                            Log.d("tong", "2send bo value = " + ((BoPartData) kotlin.collections.h.q(boPartData)).getBo());
                            List<BoPartData> boPartData2 = HealthDataSyncBean.this.getBoPartData();
                            kotlin.jvm.internal.e.e(boPartData2, "getBoPartData(...)");
                            yh.d.b().e(new EventBusBeans.SyncDataEvent(3, ((BoPartData) kotlin.collections.h.q(boPartData2)).getBo()));
                        }
                    });
                    break;
                case 4:
                    com.example.baselibrary.utils.b.x(healthDataSyncBean.getTempPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$17

                        public static final class a extends bc.a<ArrayList<TempData>> {
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public final Integer invoke(List<TempPartData> list) {
                            User d5;
                            Devices c9;
                            com.example.test.utils.k a10 = y1.a();
                            if (a10 != null && (d5 = a10.d()) != null) {
                                Calendar calendar2 = calendar;
                                String i3 = ca.i(Calendar.getInstance().getTimeInMillis(), "yyyyMMdd");
                                if (i3 != null) {
                                    BodyTempImpl bodyTempImpl = BodyTempImpl.INSTANCE;
                                    com.example.test.utils.k a11 = y1.a();
                                    String g10 = a11 != null ? a11.g() : null;
                                    String userId = d5.getUserId();
                                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                    DataBodyTemp dataByDate = bodyTempImpl.getDataByDate(g10, userId, i3);
                                    if (dataByDate == null) {
                                        dataByDate = new DataBodyTemp();
                                    }
                                    String date = dataByDate.getDate();
                                    if (date == null || date.length() == 0) {
                                        dataByDate.setUserId(d5.getUserId());
                                        com.example.test.utils.k a12 = y1.a();
                                        if (a12 != null && (c9 = a12.c()) != null) {
                                            dataByDate.setMac(c9.getMacAddress());
                                        }
                                        dataByDate.setTimestamp(String.valueOf(calendar2.getTimeInMillis() / 1000));
                                        dataByDate.setDate(ca.i(calendar2.getTimeInMillis(), "yyyyMMdd"));
                                    }
                                    int i10 = 0;
                                    dataByDate.setIsUpdate(false);
                                    List<TempData> h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new a().f3204b);
                                    kotlin.jvm.internal.e.c(list);
                                    for (TempPartData tempPartData : list) {
                                        TempData tempData = new TempData();
                                        tempData.setTemp(tempPartData.getTemp());
                                        tempData.setCurrentTime(tempPartData.getTime());
                                        kotlin.jvm.internal.e.c(h4);
                                        h4.add(tempData);
                                    }
                                    kotlin.jvm.internal.e.c(h4);
                                    float f2 = Float.MAX_VALUE;
                                    float f10 = 0.0f;
                                    float f11 = 0.0f;
                                    for (TempData tempData2 : h4) {
                                        if (tempData2.getTemp() > 0.0f) {
                                            if (tempData2.getTemp() < f2) {
                                                f2 = tempData2.getTemp();
                                            }
                                            f10 += tempData2.getTemp();
                                            i10++;
                                        }
                                        if (tempData2.getTemp() > f11) {
                                            f11 = tempData2.getTemp();
                                        }
                                    }
                                    if (i10 > 0) {
                                        dataByDate.setAvgTemp(f10 / i10);
                                    }
                                    dataByDate.setMinTemp(f2);
                                    dataByDate.setMaxTemp(f11);
                                    dataByDate.setItems(com.example.baselibrary.utils.b.z(h4));
                                    BodyTempImpl.INSTANCE.saveData(dataByDate);
                                }
                            }
                            return 1;
                        }
                    }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$18
                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                            invoke(((Number) obj4).intValue());
                            return eh.g.f12633a;
                        }

                        public final void invoke(int i3) {
                            yh.d.b().e(new EventBusBeans.SyncEvent(5));
                        }
                    });
                    break;
                case 5:
                    com.example.baselibrary.utils.b.x(healthDataSyncBean.getBreathPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$19

                        public static final class a extends bc.a<ArrayList<BreatheItemBean>> {
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public final Integer invoke(List<BreathPartData> list) {
                            User d5;
                            Devices c9;
                            com.example.test.utils.k a10 = y1.a();
                            if (a10 != null && (d5 = a10.d()) != null) {
                                Calendar calendar2 = calendar;
                                String i3 = ca.i(Calendar.getInstance().getTimeInMillis(), "yyyyMMdd");
                                if (i3 != null) {
                                    BreatheImpl breatheImpl = BreatheImpl.INSTANCE;
                                    com.example.test.utils.k a11 = y1.a();
                                    String g10 = a11 != null ? a11.g() : null;
                                    String userId = d5.getUserId();
                                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                    DataBreathe dataByDate = breatheImpl.getDataByDate(g10, userId, i3);
                                    if (dataByDate == null) {
                                        dataByDate = new DataBreathe();
                                    }
                                    String date = dataByDate.getDate();
                                    if (date == null || date.length() == 0) {
                                        dataByDate.setUserId(d5.getUserId());
                                        com.example.test.utils.k a12 = y1.a();
                                        if (a12 != null && (c9 = a12.c()) != null) {
                                            dataByDate.setMac(c9.getMacAddress());
                                        }
                                        dataByDate.setTimestamp(String.valueOf(calendar2.getTimeInMillis() / 1000));
                                        dataByDate.setDate(ca.i(calendar2.getTimeInMillis(), "yyyyMMdd"));
                                    }
                                    int i10 = 0;
                                    dataByDate.setIsUpdate(false);
                                    List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new a().f3204b);
                                    kotlin.jvm.internal.e.c(list);
                                    for (BreathPartData breathPartData : list) {
                                        BreatheItemBean breatheItemBean = new BreatheItemBean();
                                        breatheItemBean.setTimeLen(breathPartData.getBreathTime());
                                        breatheItemBean.setTimeMills(breathPartData.getTime());
                                        kotlin.jvm.internal.e.c(h4);
                                        h4.add(breatheItemBean);
                                    }
                                    kotlin.jvm.internal.e.c(h4);
                                    Iterator it = h4.iterator();
                                    while (it.hasNext()) {
                                        i10 += ((BreatheItemBean) it.next()).getTimeLen();
                                    }
                                    dataByDate.setTotalTime(Integer.valueOf(i10));
                                    dataByDate.setItems(com.example.baselibrary.utils.b.z(h4));
                                    BreatheImpl.INSTANCE.saveData(dataByDate);
                                }
                            }
                            return 1;
                        }
                    }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$20
                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                            invoke(((Number) obj4).intValue());
                            return eh.g.f12633a;
                        }

                        public final void invoke(int i3) {
                            yh.d.b().e(new EventBusBeans.SyncEvent(7));
                        }
                    });
                    break;
                case 6:
                    Object obj4 = u1.f7811u;
                    com.google.android.gms.internal.mlkit_vision_barcode.q1.a().g();
                    break;
                case 7:
                    Object obj5 = u1.f7811u;
                    com.google.android.gms.internal.mlkit_vision_barcode.q1.a().g();
                    break;
                case 8:
                    com.example.baselibrary.utils.b.x(healthDataSyncBean.getPressurePartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$21
                        public final void invoke(List<PressurePartData> list) {
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj6) {
                            invoke((List<PressurePartData>) obj6);
                            return eh.g.f12633a;
                        }
                    }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$22
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj6) {
                            invoke((eh.g) obj6);
                            return eh.g.f12633a;
                        }

                        public final void invoke(eh.g it) {
                            kotlin.jvm.internal.e.f(it, "it");
                            List<PressurePartData> pressurePartData = HealthDataSyncBean.this.getPressurePartData();
                            kotlin.jvm.internal.e.e(pressurePartData, "getPressurePartData(...)");
                            yh.d.b().e(new EventBusBeans.SyncDataEvent(6, ((PressurePartData) kotlin.collections.h.q(pressurePartData)).getPressure()));
                        }
                    });
                    break;
                case 9:
                    com.example.baselibrary.utils.b.x(healthDataSyncBean.getTempPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$9
                        public final void invoke(List<TempPartData> list) {
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj6) {
                            invoke((List<TempPartData>) obj6);
                            return eh.g.f12633a;
                        }
                    }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$10
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj6) {
                            invoke((eh.g) obj6);
                            return eh.g.f12633a;
                        }

                        public final void invoke(eh.g it) {
                            kotlin.jvm.internal.e.f(it, "it");
                            List<TempPartData> tempPartData = HealthDataSyncBean.this.getTempPartData();
                            kotlin.jvm.internal.e.e(tempPartData, "getTempPartData(...)");
                            yh.d.b().e(new EventBusBeans.SyncDataEvent(9, (int) ((TempPartData) kotlin.collections.h.q(tempPartData)).getTemp()));
                        }
                    });
                    break;
                case 10:
                    com.example.baselibrary.utils.b.x(healthDataSyncBean.getMuslimCountPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$11

                        public static final class a extends bc.a<ArrayList<MuslimItemData>> {
                        }

                        /* JADX WARN: Can't wrap try/catch for region: R(33:0|1|(2:3|b)|12|(1:16)|17|(2:19|2f)|27|(1:31)|32|33|34|(20:36|37|38|39|40|(1:42)|43|(3:45|(1:47)|48)|(3:52|(1:54)|55)|56|(1:58)|59|(4:61|(1:63)|64|65)|66|(1:68)(1:88)|69|(3:71|(1:84)(5:73|74|(1:76)|77|(3:79|80|81)(1:83))|82)|85|86|87)|93|37|38|39|40|(0)|43|(0)|(4:50|52|(0)|55)|56|(0)|59|(0)|66|(0)(0)|69|(0)|85|86|87) */
                        /* JADX WARN: Code restructure failed: missing block: B:90:0x00a3, code lost:
                        
                            r2 = move-exception;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:91:0x00a4, code lost:
                        
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(r4, " date translate error ", r2.getMessage()));
                            r2 = null;
                         */
                        /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
                        /* JADX WARN: Removed duplicated region for block: B:45:0x00fd  */
                        /* JADX WARN: Removed duplicated region for block: B:54:0x0120 A[LOOP:1: B:53:0x011e->B:54:0x0120, LOOP_END] */
                        /* JADX WARN: Removed duplicated region for block: B:58:0x0140 A[LOOP:2: B:57:0x013e->B:58:0x0140, LOOP_END] */
                        /* JADX WARN: Removed duplicated region for block: B:61:0x0150  */
                        /* JADX WARN: Removed duplicated region for block: B:68:0x0177  */
                        /* JADX WARN: Removed duplicated region for block: B:71:0x0197  */
                        /* JADX WARN: Removed duplicated region for block: B:88:0x0180  */
                        @Override // oh.l
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Long invoke(com.example.blesdk.bean.sync.MuslimCountItemBean r10) {
                            /*
                                Method dump skipped, instructions count: 495
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$11.invoke(com.example.blesdk.bean.sync.MuslimCountItemBean):java.lang.Long");
                        }
                    }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$12
                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj6) {
                            invoke(((Number) obj6).longValue());
                            return eh.g.f12633a;
                        }

                        public final void invoke(long j4) {
                            yh.d.b().e(new EventBusBeans.SyncEvent(10));
                        }
                    });
                    break;
                case 13:
                    com.example.baselibrary.utils.b.x(healthDataSyncBean.getHrPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$7
                        public final void invoke(List<HrPartData> list) {
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj6) {
                            invoke((List<HrPartData>) obj6);
                            return eh.g.f12633a;
                        }
                    }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$8
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj6) {
                            invoke((eh.g) obj6);
                            return eh.g.f12633a;
                        }

                        public final void invoke(eh.g it) {
                            kotlin.jvm.internal.e.f(it, "it");
                            List<HrPartData> hrPartData = HealthDataSyncBean.this.getHrPartData();
                            kotlin.jvm.internal.e.e(hrPartData, "getHrPartData(...)");
                            Log.d("tong", "2send hrv value = " + ((HrPartData) kotlin.collections.h.q(hrPartData)).getHr());
                            List<HrPartData> hrPartData2 = HealthDataSyncBean.this.getHrPartData();
                            kotlin.jvm.internal.e.e(hrPartData2, "getHrPartData(...)");
                            yh.d.b().e(new EventBusBeans.SyncDataEvent(13, ((HrPartData) kotlin.collections.h.q(hrPartData2)).getHr()));
                        }
                    });
                    break;
                case 14:
                    com.example.baselibrary.utils.b.x(healthDataSyncBean.getBpPartData(), new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$23

                        public static final class a extends bc.a<ArrayList<BpData>> {
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public final Integer invoke(List<BpPartData> list) {
                            User d5;
                            Devices c9;
                            com.example.test.utils.k a10 = y1.a();
                            if (a10 != null && (d5 = a10.d()) != null) {
                                Calendar calendar2 = calendar;
                                String i3 = ca.i(Calendar.getInstance().getTimeInMillis(), "yyyyMMdd");
                                if (i3 != null) {
                                    BloodPressImpl bloodPressImpl = BloodPressImpl.INSTANCE;
                                    com.example.test.utils.k a11 = y1.a();
                                    String g10 = a11 != null ? a11.g() : null;
                                    String userId = d5.getUserId();
                                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                    DataBloodPress dataByDate = bloodPressImpl.getDataByDate(g10, userId, i3);
                                    if (dataByDate == null) {
                                        dataByDate = new DataBloodPress();
                                    }
                                    String date = dataByDate.getDate();
                                    if (date == null || date.length() == 0) {
                                        dataByDate.setUserId(d5.getUserId());
                                        com.example.test.utils.k a12 = y1.a();
                                        if (a12 != null && (c9 = a12.c()) != null) {
                                            dataByDate.setMac(c9.getMacAddress());
                                        }
                                        dataByDate.setTimestamp(String.valueOf(calendar2.getTimeInMillis() / 1000));
                                        dataByDate.setDate(ca.i(calendar2.getTimeInMillis(), "yyyyMMdd"));
                                    }
                                    int i10 = 0;
                                    dataByDate.setIsUpdate(false);
                                    List<BpData> h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new a().f3204b);
                                    kotlin.jvm.internal.e.c(list);
                                    for (BpPartData bpPartData : list) {
                                        BpData bpData = new BpData();
                                        bpData.setSp(bpPartData.getSp());
                                        bpData.setDp(bpPartData.getDp());
                                        bpData.setCurrentTime(bpPartData.getTime());
                                    }
                                    kotlin.jvm.internal.e.c(h4);
                                    int i11 = 0;
                                    int i12 = 0;
                                    int i13 = 0;
                                    int i14 = 0;
                                    int i15 = Integer.MAX_VALUE;
                                    int i16 = Integer.MAX_VALUE;
                                    int i17 = 0;
                                    for (BpData bpData2 : h4) {
                                        if (bpData2.getDp() > 0) {
                                            if (bpData2.getDp() < i15) {
                                                i15 = bpData2.getDp();
                                            }
                                            i10++;
                                            i17 = bpData2.getDp() + i17;
                                        }
                                        if (bpData2.getSp() > 0) {
                                            if (bpData2.getSp() < i16) {
                                                i16 = bpData2.getSp();
                                            }
                                            i11++;
                                            i12 = bpData2.getSp() + i12;
                                        }
                                        if (bpData2.getDp() > i14) {
                                            i14 = bpData2.getDp();
                                        }
                                        if (bpData2.getSp() > i13) {
                                            i13 = bpData2.getSp();
                                        }
                                    }
                                    if (i10 > 0) {
                                        dataByDate.setAvgDp(i17 / i10);
                                    }
                                    if (i11 > 0) {
                                        dataByDate.setAvgSp(i12 / i11);
                                    }
                                    dataByDate.setMaxDp(i14);
                                    dataByDate.setMaxSp(i13);
                                    dataByDate.setMinSp(i16);
                                    dataByDate.setMinDp(i15);
                                    dataByDate.setItems(com.example.baselibrary.utils.b.z(h4));
                                }
                            }
                            return 1;
                        }
                    }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$healthDataCallback$2$1$onResult$1$24
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj6) {
                            invoke(((Number) obj6).intValue());
                            return eh.g.f12633a;
                        }

                        public final void invoke(int i3) {
                            List<BpPartData> bpPartData = HealthDataSyncBean.this.getBpPartData();
                            kotlin.jvm.internal.e.e(bpPartData, "getBpPartData(...)");
                            int sp = ((BpPartData) kotlin.collections.h.q(bpPartData)).getSp();
                            List<BpPartData> bpPartData2 = HealthDataSyncBean.this.getBpPartData();
                            kotlin.jvm.internal.e.e(bpPartData2, "getBpPartData(...)");
                            yh.d.b().e(new EventBusBeans.SyncDataEvent(2, sp, ((BpPartData) kotlin.collections.h.q(bpPartData2)).getDp()));
                        }
                    });
                    break;
            }
        }
    }
}
