package com.example.test.service;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.example.blesdk.bean.sync.BreatheItemBean;
import com.example.blesdk.bean.sync.ImperialPaceItemBean;
import com.example.blesdk.bean.sync.MetricPaceItemBean;
import com.example.blesdk.bean.sync.SportHrItemBean;
import com.example.database.db.BloodOxygenImpl;
import com.example.database.db.BloodPressImpl;
import com.example.database.db.BloodSugarImpl;
import com.example.database.db.BodyTempImpl;
import com.example.database.db.BreatheImpl;
import com.example.database.db.HrImpl;
import com.example.database.db.HrvImpl;
import com.example.database.db.MuslimCountImpl;
import com.example.database.db.PressureImpl;
import com.example.database.db.RawStepsImpl;
import com.example.database.db.SleepImpl;
import com.example.database.db.SportImpl;
import com.example.database.db.StepsImpl;
import com.example.database.table.DataBloodOxygen;
import com.example.database.table.DataBloodPress;
import com.example.database.table.DataBloodSugar;
import com.example.database.table.DataBodyTemp;
import com.example.database.table.DataBreathe;
import com.example.database.table.DataHeartHrv;
import com.example.database.table.DataHeartRate;
import com.example.database.table.DataMuslimCount;
import com.example.database.table.DataPressure;
import com.example.database.table.DataSleep;
import com.example.database.table.DataSport;
import com.example.database.table.DataStep;
import com.example.database.table.RawDataStep;
import com.example.database.table.User;
import com.example.network.api.DataApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.BoServerDailyBean;
import com.example.network.bean.BoServerItemBean;
import com.example.network.bean.BpServerDailyBean;
import com.example.network.bean.BpServerItemBean;
import com.example.network.bean.BreatheServerDailyBean;
import com.example.network.bean.BreatheServerItemBean;
import com.example.network.bean.BtServerDailyBean;
import com.example.network.bean.BtServerItemBean;
import com.example.network.bean.HrServerDailyBean;
import com.example.network.bean.HrServerItemBean;
import com.example.network.bean.HrvServerDailyBean;
import com.example.network.bean.PressureServerDailyBean;
import com.example.network.bean.RememberServerDailyBean;
import com.example.network.bean.SleepServerDailyBean;
import com.example.network.bean.SleepServerItemBean;
import com.example.network.bean.SportHrServerItemBean;
import com.example.network.bean.SportLatLngServerItemBean;
import com.example.network.bean.SportPacesServerItemBean;
import com.example.network.bean.SportServerDailyBean;
import com.example.network.bean.SportStepFreServerItemBean;
import com.example.network.bean.StepServerDailyBean;
import com.example.network.bean.StepServerItemBean;
import com.example.network.bean.SugarServerDailyBean;
import com.example.network.bean.SwitchBean;
import com.example.test.XXApplication;
import com.example.test.ui.model.chart.chart.BoData;
import com.example.test.ui.model.chart.chart.BpData;
import com.example.test.ui.model.chart.chart.HrData;
import com.example.test.ui.model.chart.chart.MuslimItemData;
import com.example.test.ui.model.chart.chart.PressureData;
import com.example.test.ui.model.chart.chart.SleepItemData;
import com.example.test.ui.model.chart.chart.StepItemData;
import com.example.test.ui.model.chart.chart.SugarData;
import com.example.test.ui.model.chart.chart.TempData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.LazyThreadSafetyMode;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes.dex */
public final class g1 {
    public static final Object e = kotlin.a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.example.test.service.SyncServerService$Companion$service$2
        @Override // oh.a
        public final g1 invoke() {
            return new g1();
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public boolean f7706a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7707b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7708c;

    /* renamed from: d, reason: collision with root package name */
    public List f7709d;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(g1 g1Var, long j4, long j10) {
        g1Var.getClass();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        SwitchBean switchBean = null;
        ArrayList w8 = kVar != null ? kVar.w() : null;
        g1Var.f7709d = w8;
        if (w8 != null) {
            int size = w8.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                Object obj = w8.get(i3);
                i3++;
                if (kotlin.jvm.internal.e.a(((SwitchBean) obj).getParaName(), "isSport")) {
                    switchBean = obj;
                    break;
                }
            }
            switchBean = switchBean;
        }
        if (switchBean != null && kotlin.jvm.internal.e.a(switchBean.getParaValue(), "0")) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "运动数据开关已关闭...");
            g1Var.n();
            return;
        }
        c6.a aVar = c6.a.f3389c;
        String startDate = String.valueOf(j4);
        String endDate = String.valueOf(j10);
        aVar.getClass();
        kotlin.jvm.internal.e.f(startDate, "startDate");
        kotlin.jvm.internal.e.f(endDate, "endDate");
        rg.l<HttpModel<List<SportServerDailyBean>>> downloadSports = ((DataApi) aVar.f113a).downloadSports(startDate, endDate);
        kotlin.jvm.internal.e.e(downloadSports, "downloadSports(...)");
        rg.l u10 = com.example.baselibrary.utils.b.u(downloadSports);
        XXApplication xXApplication = XXApplication.f7400h;
        u10.blockingSubscribe(new c1(g1Var, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
    }

    public static final void b(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "查询待上传血氧数据...");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        BloodOxygenImpl bloodOxygenImpl = BloodOxygenImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataBloodOxygen> bos = bloodOxygenImpl.getUploadBo(userId);
        List<DataBloodOxygen> list = bos;
        if (list == null || list.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的血氧数据...");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "转化血氧成服务器数据...");
        kotlin.jvm.internal.e.f(bos, "bos");
        ArrayList arrayList = new ArrayList();
        for (DataBloodOxygen dataBloodOxygen : bos) {
            String items = dataBloodOxygen.getItems();
            if (items != null && items.length() != 0) {
                BoServerDailyBean boServerDailyBean = new BoServerDailyBean();
                boServerDailyBean.setMemberId(dataBloodOxygen.getUserId());
                boServerDailyBean.setDeviceId(dataBloodOxygen.getMac());
                try {
                    String timestamp = dataBloodOxygen.getTimestamp();
                    kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                    boServerDailyBean.setDate(String.valueOf(Long.parseLong(timestamp) + ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000)));
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadBoData error ", th2.getMessage()));
                }
                String items2 = dataBloodOxygen.getItems();
                if (items2 != null) {
                    List<BoData> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.a0().f3204b);
                    ArrayList arrayList2 = new ArrayList();
                    kotlin.jvm.internal.e.c(h4);
                    for (BoData boData : h4) {
                        BoServerItemBean boServerItemBean = new BoServerItemBean();
                        boServerItemBean.setTimestamp(String.valueOf(((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000) + boData.getCurrentTime()));
                        boServerItemBean.setValue(boData.getBo());
                        arrayList2.add(boServerItemBean);
                    }
                    boServerDailyBean.setDetails(arrayList2);
                    arrayList.add(boServerDailyBean);
                }
            }
        }
        c6.a aVar = c6.a.f3389c;
        aVar.getClass();
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
        String z5 = com.example.baselibrary.utils.b.z(arrayList);
        kotlin.jvm.internal.e.e(z5, "toJson(...)");
        rg.l<HttpModel<String>> uploadBos = ((DataApi) aVar.f113a).uploadBos(companion.create(parse, z5));
        kotlin.jvm.internal.e.e(uploadBos, "uploadBos(...)");
        rg.l u10 = com.example.baselibrary.utils.b.u(uploadBos);
        XXApplication xXApplication = XXApplication.f7400h;
        u10.blockingSubscribe(new f1(g1Var, bos, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 0));
    }

    public static final void c(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "查询待上传血压数据...");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        BloodPressImpl bloodPressImpl = BloodPressImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataBloodPress> bps = bloodPressImpl.getUploadBps(userId);
        List<DataBloodPress> list = bps;
        if (list == null || list.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的血压数据...");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "转化血压成服务器数据...");
        kotlin.jvm.internal.e.f(bps, "bps");
        ArrayList arrayList = new ArrayList();
        for (DataBloodPress dataBloodPress : bps) {
            String items = dataBloodPress.getItems();
            if (items != null && items.length() != 0) {
                BpServerDailyBean bpServerDailyBean = new BpServerDailyBean();
                bpServerDailyBean.setMemberId(dataBloodPress.getUserId());
                bpServerDailyBean.setDeviceId(dataBloodPress.getMac());
                try {
                    String timestamp = dataBloodPress.getTimestamp();
                    kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                    bpServerDailyBean.setDate(String.valueOf(Long.parseLong(timestamp) + ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000)));
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadBpData error ", th2.getMessage()));
                }
                String items2 = dataBloodPress.getItems();
                if (items2 != null) {
                    List<BpData> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.b0().f3204b);
                    ArrayList arrayList2 = new ArrayList();
                    kotlin.jvm.internal.e.c(h4);
                    for (BpData bpData : h4) {
                        BpServerItemBean bpServerItemBean = new BpServerItemBean();
                        bpServerItemBean.setTimestamp(String.valueOf(((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000) + bpData.getCurrentTime()));
                        bpServerItemBean.setSbp(bpData.getSp());
                        bpServerItemBean.setDbp(bpData.getDp());
                        arrayList2.add(bpServerItemBean);
                    }
                    bpServerDailyBean.setDetails(arrayList2);
                    arrayList.add(bpServerDailyBean);
                }
            }
        }
        c6.a aVar = c6.a.f3389c;
        aVar.getClass();
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
        String z5 = com.example.baselibrary.utils.b.z(arrayList);
        kotlin.jvm.internal.e.e(z5, "toJson(...)");
        rg.l<HttpModel<String>> uploadBps = ((DataApi) aVar.f113a).uploadBps(companion.create(parse, z5));
        kotlin.jvm.internal.e.e(uploadBps, "uploadBps(...)");
        rg.l u10 = com.example.baselibrary.utils.b.u(uploadBps);
        XXApplication xXApplication = XXApplication.f7400h;
        u10.blockingSubscribe(new f1(g1Var, bps, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 1));
    }

    public static final void d(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "查询待上传呼吸数据...");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        BreatheImpl breatheImpl = BreatheImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataBreathe> breathes = breatheImpl.getUploadBreathes(userId);
        List<DataBreathe> list = breathes;
        if (list == null || list.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的呼吸数据...");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "转化呼吸成服务器数据...");
        kotlin.jvm.internal.e.f(breathes, "breathes");
        ArrayList arrayList = new ArrayList();
        for (DataBreathe dataBreathe : breathes) {
            String items = dataBreathe.getItems();
            if (items != null && items.length() != 0) {
                BreatheServerDailyBean breatheServerDailyBean = new BreatheServerDailyBean();
                breatheServerDailyBean.setMemberId(dataBreathe.getUserId());
                breatheServerDailyBean.setDeviceId(dataBreathe.getMac());
                try {
                    String timestamp = dataBreathe.getTimestamp();
                    kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                    breatheServerDailyBean.setDate(String.valueOf(Long.parseLong(timestamp) + ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000)));
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadBreatheData error ", th2.getMessage()));
                }
                String items2 = dataBreathe.getItems();
                if (items2 != null) {
                    List<BreatheItemBean> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.c0().f3204b);
                    ArrayList arrayList2 = new ArrayList();
                    kotlin.jvm.internal.e.c(h4);
                    for (BreatheItemBean breatheItemBean : h4) {
                        BreatheServerItemBean breatheServerItemBean = new BreatheServerItemBean();
                        breatheServerItemBean.setTimestamp(((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000) + breatheItemBean.getTimeMills());
                        breatheServerItemBean.setValue(breatheItemBean.getTimeLen());
                        arrayList2.add(breatheServerItemBean);
                    }
                    breatheServerDailyBean.setDetails(arrayList2);
                    arrayList.add(breatheServerDailyBean);
                }
            }
        }
        c6.a aVar = c6.a.f3389c;
        aVar.getClass();
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
        String z5 = com.example.baselibrary.utils.b.z(arrayList);
        kotlin.jvm.internal.e.e(z5, "toJson(...)");
        rg.l<HttpModel<String>> uploadBreathes = ((DataApi) aVar.f113a).uploadBreathes(companion.create(parse, z5));
        kotlin.jvm.internal.e.e(uploadBreathes, "uploadBreathes(...)");
        rg.l u10 = com.example.baselibrary.utils.b.u(uploadBreathes);
        XXApplication xXApplication = XXApplication.f7400h;
        u10.blockingSubscribe(new f1(g1Var, breathes, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 2));
    }

    public static final void e(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "查询待上传体温数据...");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        BodyTempImpl bodyTempImpl = BodyTempImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataBodyTemp> bts = bodyTempImpl.getUploadBts(userId);
        List<DataBodyTemp> list = bts;
        if (list == null || list.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的体温数据...");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "转化体温成服务器数据...");
        kotlin.jvm.internal.e.f(bts, "bts");
        ArrayList arrayList = new ArrayList();
        for (DataBodyTemp dataBodyTemp : bts) {
            String items = dataBodyTemp.getItems();
            if (items != null && items.length() != 0) {
                BtServerDailyBean btServerDailyBean = new BtServerDailyBean();
                btServerDailyBean.setMemberId(dataBodyTemp.getUserId());
                btServerDailyBean.setDeviceId(dataBodyTemp.getMac());
                try {
                    String timestamp = dataBodyTemp.getTimestamp();
                    kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                    btServerDailyBean.setDate(String.valueOf(Long.parseLong(timestamp) + ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000)));
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadBtData error ", th2.getMessage()));
                }
                String items2 = dataBodyTemp.getItems();
                if (items2 != null) {
                    List<TempData> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.d0().f3204b);
                    ArrayList arrayList2 = new ArrayList();
                    kotlin.jvm.internal.e.c(h4);
                    for (TempData tempData : h4) {
                        BtServerItemBean btServerItemBean = new BtServerItemBean();
                        btServerItemBean.setTimestamp(String.valueOf(((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000) + tempData.getCurrentTime()));
                        btServerItemBean.setValue((int) (tempData.getTemp() * 10));
                        arrayList2.add(btServerItemBean);
                    }
                    btServerDailyBean.setDetails(arrayList2);
                    arrayList.add(btServerDailyBean);
                }
            }
        }
        c6.a aVar = c6.a.f3389c;
        aVar.getClass();
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
        String z5 = com.example.baselibrary.utils.b.z(arrayList);
        kotlin.jvm.internal.e.e(z5, "toJson(...)");
        rg.l<HttpModel<String>> uploadBts = ((DataApi) aVar.f113a).uploadBts(companion.create(parse, z5));
        kotlin.jvm.internal.e.e(uploadBts, "uploadBts(...)");
        rg.l u10 = com.example.baselibrary.utils.b.u(uploadBts);
        XXApplication xXApplication = XXApplication.f7400h;
        u10.blockingSubscribe(new f1(g1Var, bts, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 3));
    }

    public static final void f(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("查询待上传心率数据...", Thread.currentThread().getName()));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        HrImpl hrImpl = HrImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataHeartRate> uploadHrs = hrImpl.getUploadHrs(userId);
        if (uploadHrs.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的心率数据...");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "开始上传心率数据...");
        ArrayList arrayList = new ArrayList();
        for (DataHeartRate dataHeartRate : uploadHrs) {
            String items = dataHeartRate.getItems();
            if (items != null && items.length() != 0) {
                HrServerDailyBean hrServerDailyBean = new HrServerDailyBean();
                hrServerDailyBean.setMemberId(dataHeartRate.getUserId());
                hrServerDailyBean.setDeviceId(dataHeartRate.getMac());
                try {
                    String timestamp = dataHeartRate.getTimestamp();
                    kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                    hrServerDailyBean.setDate(String.valueOf(Long.parseLong(timestamp) + ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000)));
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadHrData error ", th2.getMessage()));
                }
                String items2 = dataHeartRate.getItems();
                if (items2 != null) {
                    List<HrData> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.e0().f3204b);
                    ArrayList arrayList2 = new ArrayList();
                    kotlin.jvm.internal.e.c(h4);
                    for (HrData hrData : h4) {
                        HrServerItemBean hrServerItemBean = new HrServerItemBean();
                        hrServerItemBean.setTimestamp(String.valueOf(((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000) + hrData.getCurrentTime()));
                        hrServerItemBean.setValue(hrData.getHr());
                        arrayList2.add(hrServerItemBean);
                    }
                    hrServerDailyBean.setDetails(arrayList2);
                    arrayList.add(hrServerDailyBean);
                }
            }
        }
        c6.a aVar = c6.a.f3389c;
        aVar.getClass();
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
        String z5 = com.example.baselibrary.utils.b.z(arrayList);
        kotlin.jvm.internal.e.e(z5, "toJson(...)");
        rg.l<HttpModel<String>> uploadHrs2 = ((DataApi) aVar.f113a).uploadHrs(companion.create(parse, z5));
        kotlin.jvm.internal.e.e(uploadHrs2, "uploadHrs(...)");
        rg.l u10 = com.example.baselibrary.utils.b.u(uploadHrs2);
        XXApplication xXApplication = XXApplication.f7400h;
        u10.blockingSubscribe(new f1(g1Var, uploadHrs, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 4));
    }

    public static final void g(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("查询待上传心率变异性数据...", Thread.currentThread().getName()));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        HrvImpl hrvImpl = HrvImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataHeartHrv> uploadHrs = hrvImpl.getUploadHrs(userId);
        if (uploadHrs.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的心率变异性数据...");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "开始上传心率变异性数据...");
        ArrayList arrayList = new ArrayList();
        for (DataHeartHrv dataHeartHrv : uploadHrs) {
            String items = dataHeartHrv.getItems();
            if (items != null && items.length() != 0) {
                HrvServerDailyBean hrvServerDailyBean = new HrvServerDailyBean();
                hrvServerDailyBean.setMemberId(dataHeartHrv.getUserId());
                hrvServerDailyBean.setDeviceId(dataHeartHrv.getMac());
                try {
                    String timestamp = dataHeartHrv.getTimestamp();
                    kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                    hrvServerDailyBean.setDate(String.valueOf(Long.parseLong(timestamp) + ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000)));
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadHrData error ", th2.getMessage()));
                }
                String items2 = dataHeartHrv.getItems();
                if (items2 != null) {
                    List<HrData> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.f0().f3204b);
                    ArrayList arrayList2 = new ArrayList();
                    kotlin.jvm.internal.e.c(h4);
                    for (HrData hrData : h4) {
                        HrvServerDailyBean.ItemBean itemBean = new HrvServerDailyBean.ItemBean();
                        itemBean.setTimestamp(String.valueOf(((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000) + hrData.getCurrentTime()));
                        itemBean.setValue(hrData.getHr());
                        arrayList2.add(itemBean);
                    }
                    hrvServerDailyBean.setDetails(arrayList2);
                    arrayList.add(hrvServerDailyBean);
                }
            }
        }
        c6.a aVar = c6.a.f3389c;
        aVar.getClass();
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
        String z5 = com.example.baselibrary.utils.b.z(arrayList);
        kotlin.jvm.internal.e.e(z5, "toJson(...)");
        rg.l<HttpModel<String>> uploadHrv = ((DataApi) aVar.f113a).uploadHrv(companion.create(parse, z5));
        kotlin.jvm.internal.e.e(uploadHrv, "uploadHrv(...)");
        rg.l u10 = com.example.baselibrary.utils.b.u(uploadHrv);
        XXApplication xXApplication = XXApplication.f7400h;
        u10.blockingSubscribe(new f1(g1Var, uploadHrs, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 5));
    }

    public static final void h(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("查询待上传压力数据...", Thread.currentThread().getName()));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        PressureImpl pressureImpl = PressureImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataPressure> uploadPressure = pressureImpl.getUploadPressure(userId);
        if (uploadPressure != null) {
            if (uploadPressure.isEmpty()) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的压力数据...");
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "开始上传压力数据...");
            ArrayList arrayList = new ArrayList();
            for (DataPressure dataPressure : uploadPressure) {
                String items = dataPressure.getItems();
                if (items != null && items.length() != 0) {
                    PressureServerDailyBean pressureServerDailyBean = new PressureServerDailyBean();
                    pressureServerDailyBean.setMemberId(dataPressure.getUserId());
                    pressureServerDailyBean.setDeviceId(dataPressure.getMac());
                    try {
                        String timestamp = dataPressure.getTimestamp();
                        kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                        pressureServerDailyBean.setDate(String.valueOf(Long.parseLong(timestamp) + ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000)));
                    } catch (Throwable th2) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadPressureData error ", th2.getMessage()));
                    }
                    String items2 = dataPressure.getItems();
                    if (items2 != null) {
                        List<PressureData> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.g0().f3204b);
                        ArrayList arrayList2 = new ArrayList();
                        kotlin.jvm.internal.e.c(h4);
                        for (PressureData pressureData : h4) {
                            PressureServerDailyBean.ItemBean itemBean = new PressureServerDailyBean.ItemBean();
                            itemBean.setTimestamp(String.valueOf(((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000) + pressureData.getCurrentTime()));
                            itemBean.setValue(pressureData.getPressure());
                            arrayList2.add(itemBean);
                        }
                        pressureServerDailyBean.setDetails(arrayList2);
                        arrayList.add(pressureServerDailyBean);
                    }
                }
            }
            c6.a aVar = c6.a.f3389c;
            aVar.getClass();
            RequestBody.Companion companion = RequestBody.Companion;
            MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
            String z5 = com.example.baselibrary.utils.b.z(arrayList);
            kotlin.jvm.internal.e.e(z5, "toJson(...)");
            rg.l<HttpModel<String>> uploadPressure2 = ((DataApi) aVar.f113a).uploadPressure(companion.create(parse, z5));
            kotlin.jvm.internal.e.e(uploadPressure2, "uploadPressure(...)");
            rg.l u10 = com.example.baselibrary.utils.b.u(uploadPressure2);
            XXApplication xXApplication = XXApplication.f7400h;
            u10.blockingSubscribe(new f1(g1Var, uploadPressure, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 7));
        }
    }

    public static final void i(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("查询待上传赞念数据...", Thread.currentThread().getName()));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        MuslimCountImpl muslimCountImpl = MuslimCountImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataMuslimCount> uploadMuslimCount = muslimCountImpl.getUploadMuslimCount(userId);
        if (uploadMuslimCount != null) {
            if (uploadMuslimCount.isEmpty()) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的压力数据...");
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "开始上传压力数据...");
            ArrayList arrayList = new ArrayList();
            for (DataMuslimCount dataMuslimCount : uploadMuslimCount) {
                String items = dataMuslimCount.getItems();
                if (items != null && items.length() != 0) {
                    RememberServerDailyBean rememberServerDailyBean = new RememberServerDailyBean();
                    rememberServerDailyBean.setMemberId(dataMuslimCount.getUserId());
                    rememberServerDailyBean.setDeviceId(dataMuslimCount.getMac());
                    try {
                        String timestamp = dataMuslimCount.getTimestamp();
                        kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                        rememberServerDailyBean.setDate(String.valueOf(Long.parseLong(timestamp) + ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000)));
                    } catch (Throwable th2) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadRememberData error ", th2.getMessage()));
                    }
                    String items2 = dataMuslimCount.getItems();
                    if (items2 != null) {
                        List<MuslimItemData> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.h0().f3204b);
                        ArrayList arrayList2 = new ArrayList();
                        kotlin.jvm.internal.e.c(h4);
                        for (MuslimItemData muslimItemData : h4) {
                            RememberServerDailyBean.ItemBean itemBean = new RememberServerDailyBean.ItemBean();
                            itemBean.setHourIndex(Integer.valueOf(muslimItemData.getHourIndex()));
                            itemBean.setValue(muslimItemData.getCount());
                            arrayList2.add(itemBean);
                        }
                        rememberServerDailyBean.setDetails(arrayList2);
                        arrayList.add(rememberServerDailyBean);
                    }
                }
            }
            c6.a aVar = c6.a.f3389c;
            aVar.getClass();
            RequestBody.Companion companion = RequestBody.Companion;
            MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
            String z5 = com.example.baselibrary.utils.b.z(arrayList);
            kotlin.jvm.internal.e.e(z5, "toJson(...)");
            rg.l<HttpModel<String>> uploadRemember = ((DataApi) aVar.f113a).uploadRemember(companion.create(parse, z5));
            kotlin.jvm.internal.e.e(uploadRemember, "uploadRemember(...)");
            rg.l u10 = com.example.baselibrary.utils.b.u(uploadRemember);
            XXApplication xXApplication = XXApplication.f7400h;
            u10.blockingSubscribe(new f1(g1Var, uploadMuslimCount, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 8));
        }
    }

    public static final void j(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("查询待上传睡眠数据...", Thread.currentThread().getName()));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        SleepImpl sleepImpl = SleepImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataSleep> uploadSleeps = sleepImpl.getUploadSleeps(userId);
        if (uploadSleeps.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的睡眠数据...");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "转化睡眠成服务器数据...");
        ArrayList arrayList = new ArrayList();
        for (DataSleep dataSleep : uploadSleeps) {
            String items = dataSleep.getItems();
            if (items != null && items.length() != 0) {
                SleepServerDailyBean sleepServerDailyBean = new SleepServerDailyBean();
                sleepServerDailyBean.setMemberId(dataSleep.getUserId());
                sleepServerDailyBean.setDeviceId(dataSleep.getMac());
                sleepServerDailyBean.setTotalTime((int) dataSleep.getTotalSleepTime());
                try {
                    String date = dataSleep.getDate();
                    kotlin.jvm.internal.e.e(date, "getDate(...)");
                    long j4 = 1000;
                    sleepServerDailyBean.setDate(String.valueOf(com.example.baselibrary.utils.b.a(date) + (com.example.baselibrary.utils.b.l() / j4)));
                    sleepServerDailyBean.setStartTime(dataSleep.getAsleepTime() + (com.example.baselibrary.utils.b.l() / j4));
                    sleepServerDailyBean.setEndTime(dataSleep.getWakeupTime() + (com.example.baselibrary.utils.b.l() / j4));
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadSleepData error ", th2.getMessage()));
                }
                String items2 = dataSleep.getItems();
                if (items2 != null) {
                    List<SleepItemData> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.i0().f3204b);
                    ArrayList arrayList2 = new ArrayList();
                    kotlin.jvm.internal.e.c(h4);
                    for (SleepItemData sleepItemData : h4) {
                        SleepServerItemBean sleepServerItemBean = new SleepServerItemBean();
                        sleepServerItemBean.setPeriod(sleepItemData.getDuration());
                        sleepServerItemBean.setType(sleepItemData.getSleepType());
                        arrayList2.add(sleepServerItemBean);
                    }
                    sleepServerDailyBean.setDetails(arrayList2);
                    arrayList.add(sleepServerDailyBean);
                }
            }
        }
        c6.a aVar = c6.a.f3389c;
        aVar.getClass();
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
        String z5 = com.example.baselibrary.utils.b.z(arrayList);
        kotlin.jvm.internal.e.e(z5, "toJson(...)");
        rg.l<HttpModel<String>> uploadSleeps2 = ((DataApi) aVar.f113a).uploadSleeps(companion.create(parse, z5));
        kotlin.jvm.internal.e.e(uploadSleeps2, "uploadSleeps(...)");
        rg.l u10 = com.example.baselibrary.utils.b.u(uploadSleeps2);
        XXApplication xXApplication = XXApplication.f7400h;
        u10.blockingSubscribe(new f1(g1Var, uploadSleeps, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 9));
    }

    public static final void k(g1 g1Var) {
        SwitchBean switchBean;
        User d5;
        Object obj;
        g1Var.getClass();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        ArrayList w8 = kVar != null ? kVar.w() : null;
        g1Var.f7709d = w8;
        if (w8 != null) {
            int size = w8.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    obj = null;
                    break;
                }
                obj = w8.get(i3);
                i3++;
                if (kotlin.jvm.internal.e.a(((SwitchBean) obj).getParaName(), "isSport")) {
                    break;
                }
            }
            switchBean = (SwitchBean) obj;
        } else {
            switchBean = null;
        }
        if (switchBean != null && kotlin.jvm.internal.e.a(switchBean.getParaValue(), "0")) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "运动数据开关已关闭...");
            g1Var.n();
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "查询待上传运动数据...");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        if (kVar2 == null || (d5 = kVar2.d()) == null) {
            return;
        }
        SportImpl sportImpl = SportImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataSport> uploadSports = sportImpl.getUploadSports(userId);
        if (uploadSports.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的运动数据...");
            g1Var.n();
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "开始上传运动数据...");
        ArrayList arrayList = new ArrayList();
        for (DataSport dataSport : uploadSports) {
            SportServerDailyBean sportServerDailyBean = new SportServerDailyBean();
            sportServerDailyBean.setMemberId(dataSport.getUserId());
            sportServerDailyBean.setDeviceId(dataSport.getMac());
            sportServerDailyBean.setFrom(dataSport.getFrom());
            sportServerDailyBean.setViewType(Integer.valueOf(dataSport.getViewType()));
            sportServerDailyBean.setNewSportHrs(dataSport.getNewSportHrs());
            sportServerDailyBean.setAvgPace(Long.valueOf(dataSport.getAvgPace()));
            sportServerDailyBean.setMinPace(Long.valueOf(dataSport.getMinPace()));
            sportServerDailyBean.setMaxPace(Long.valueOf(dataSport.getMaxPace()));
            sportServerDailyBean.setAvgSteps(Long.valueOf(dataSport.getAvgSteps()));
            sportServerDailyBean.setMinSteps(Long.valueOf(dataSport.getMinSteps()));
            sportServerDailyBean.setMaxSteps(Long.valueOf(dataSport.getMaxSteps()));
            sportServerDailyBean.setAvgHr(Long.valueOf(dataSport.getAvgHr()));
            sportServerDailyBean.setMinHr(Long.valueOf(dataSport.getMinHr()));
            sportServerDailyBean.setMaxHr(Long.valueOf(dataSport.getMaxHr()));
            try {
                String timestamp = dataSport.getTimestamp();
                kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                sportServerDailyBean.setTimestamp((int) (Long.parseLong(timestamp) + ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000)));
                String totalTimes = dataSport.getTotalTimes();
                kotlin.jvm.internal.e.e(totalTimes, "getTotalTimes(...)");
                sportServerDailyBean.setTotalTime(Integer.parseInt(totalTimes));
                String totalDistances = dataSport.getTotalDistances();
                kotlin.jvm.internal.e.e(totalDistances, "getTotalDistances(...)");
                sportServerDailyBean.setTotalDistance((int) Float.parseFloat(totalDistances));
                String totalCalories = dataSport.getTotalCalories();
                kotlin.jvm.internal.e.e(totalCalories, "getTotalCalories(...)");
                sportServerDailyBean.setTotalCal((int) Float.parseFloat(totalCalories));
                String totalSteps = dataSport.getTotalSteps();
                kotlin.jvm.internal.e.e(totalSteps, "getTotalSteps(...)");
                sportServerDailyBean.setTotalStep(Integer.parseInt(totalSteps));
            } catch (Throwable th2) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadSportData error ", th2.getMessage()));
            }
            sportServerDailyBean.setType(dataSport.getSportType());
            String hrData = dataSport.getHrData();
            if (hrData != null) {
                List<SportHrItemBean> h4 = com.example.baselibrary.utils.b.h(hrData, new com.example.test.utils.j0().f3204b);
                ArrayList arrayList2 = new ArrayList();
                if (h4 != null) {
                    for (SportHrItemBean sportHrItemBean : h4) {
                        SportHrServerItemBean sportHrServerItemBean = new SportHrServerItemBean();
                        sportHrServerItemBean.setIndex((int) sportHrItemBean.getTimeMills());
                        sportHrServerItemBean.setValue(sportHrItemBean.getHr());
                        arrayList2.add(sportHrServerItemBean);
                    }
                }
                sportServerDailyBean.setHeartRates(arrayList2);
            }
            String paceMetrics = dataSport.getPaceMetrics();
            if (paceMetrics != null) {
                List<MetricPaceItemBean> h10 = com.example.baselibrary.utils.b.h(paceMetrics, new com.example.test.utils.k0().f3204b);
                ArrayList arrayList3 = new ArrayList();
                if (h10 != null) {
                    for (MetricPaceItemBean metricPaceItemBean : h10) {
                        SportPacesServerItemBean sportPacesServerItemBean = new SportPacesServerItemBean();
                        sportPacesServerItemBean.setPace((int) metricPaceItemBean.getPace());
                        sportPacesServerItemBean.setIndex(metricPaceItemBean.getPaceIndex());
                        sportPacesServerItemBean.setIsWhole(metricPaceItemBean.isKm() ? 1 : 0);
                        arrayList3.add(sportPacesServerItemBean);
                    }
                }
                sportServerDailyBean.setKmPaces(arrayList3);
            }
            String paceImperials = dataSport.getPaceImperials();
            if (paceImperials != null) {
                List<ImperialPaceItemBean> h11 = com.example.baselibrary.utils.b.h(paceImperials, new com.example.test.utils.l0().f3204b);
                ArrayList arrayList4 = new ArrayList();
                if (h11 != null) {
                    for (ImperialPaceItemBean imperialPaceItemBean : h11) {
                        SportPacesServerItemBean sportPacesServerItemBean2 = new SportPacesServerItemBean();
                        sportPacesServerItemBean2.setPace((int) imperialPaceItemBean.getPace());
                        sportPacesServerItemBean2.setIndex(imperialPaceItemBean.getPaceIndex());
                        sportPacesServerItemBean2.setIsWhole(imperialPaceItemBean.isMi() ? 1 : 0);
                        arrayList4.add(sportPacesServerItemBean2);
                    }
                }
                sportServerDailyBean.setMilePaces(arrayList4);
            }
            String stepDetails = dataSport.getStepDetails();
            if (stepDetails != null) {
                List h12 = com.example.baselibrary.utils.b.h(stepDetails, new com.example.test.utils.m0().f3204b);
                ArrayList arrayList5 = new ArrayList();
                if (h12 != null) {
                    int i10 = 0;
                    for (Object obj2 : h12) {
                        int i11 = i10 + 1;
                        if (i10 < 0) {
                            kotlin.collections.i.f();
                            throw null;
                        }
                        SportStepFreServerItemBean sportStepFreServerItemBean = new SportStepFreServerItemBean();
                        sportStepFreServerItemBean.setFrequency((int) ((Long) obj2).longValue());
                        sportStepFreServerItemBean.setIndex(i10);
                        arrayList5.add(sportStepFreServerItemBean);
                        i10 = i11;
                    }
                }
                sportServerDailyBean.setStepFrequencies(arrayList5);
            }
            String latLng = dataSport.getLatLng();
            if (latLng != null) {
                List<h6.a> h13 = com.example.baselibrary.utils.b.h(latLng, new com.example.test.utils.n0().f3204b);
                ArrayList arrayList6 = new ArrayList();
                if (h13 != null) {
                    for (h6.a aVar : h13) {
                        SportLatLngServerItemBean sportLatLngServerItemBean = new SportLatLngServerItemBean();
                        sportLatLngServerItemBean.setLat(String.valueOf(aVar.f14264a));
                        sportLatLngServerItemBean.setLng(String.valueOf(aVar.f14265b));
                        arrayList6.add(sportLatLngServerItemBean);
                    }
                }
                sportServerDailyBean.setLocations(arrayList6);
            }
            arrayList.add(sportServerDailyBean);
        }
        c6.a aVar2 = c6.a.f3389c;
        aVar2.getClass();
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
        String z5 = com.example.baselibrary.utils.b.z(arrayList);
        kotlin.jvm.internal.e.e(z5, "toJson(...)");
        rg.l<HttpModel<String>> uploadSports2 = ((DataApi) aVar2.f113a).uploadSports(companion.create(parse, z5));
        kotlin.jvm.internal.e.e(uploadSports2, "uploadSports(...)");
        rg.l u10 = com.example.baselibrary.utils.b.u(uploadSports2);
        XXApplication xXApplication = XXApplication.f7400h;
        u10.blockingSubscribe(new f1(g1Var, uploadSports, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 10));
    }

    public static final void l(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("查询待上传步数数据...", Thread.currentThread().getName()));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        StepsImpl stepsImpl = StepsImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataStep> uploadSteps = stepsImpl.getUploadSteps(userId);
        if (uploadSteps.isEmpty()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的步数数据");
            return;
        }
        XXApplication xXApplication = XXApplication.f7400h;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "uploadSteps 开始上传步数数据... " + com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c());
        ArrayList arrayList = new ArrayList();
        for (DataStep dataStep : uploadSteps) {
            String items = dataStep.getItems();
            if (items != null && items.length() != 0) {
                StepServerDailyBean stepServerDailyBean = new StepServerDailyBean();
                stepServerDailyBean.setMemberId(dataStep.getUserId());
                stepServerDailyBean.setDeviceId(dataStep.getMac());
                stepServerDailyBean.setCal((long) dataStep.getCalorie());
                stepServerDailyBean.setDistance((long) dataStep.getDistance());
                stepServerDailyBean.setStep(dataStep.getTotalStep());
                try {
                    String date = dataStep.getDate();
                    kotlin.jvm.internal.e.e(date, "getDate(...)");
                    stepServerDailyBean.setDate(String.valueOf(com.example.baselibrary.utils.b.a(date) + (com.example.baselibrary.utils.b.l() / 1000)));
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadStepData error ", th2.getMessage()));
                }
                String items2 = dataStep.getItems();
                if (items2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    List<StepItemData> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.o0().f3204b);
                    if (h4 != null) {
                        for (StepItemData stepItemData : h4) {
                            StepServerItemBean stepServerItemBean = new StepServerItemBean();
                            String time = stepItemData.getTime();
                            kotlin.jvm.internal.e.e(time, "getTime(...)");
                            stepServerItemBean.setIndex(Integer.parseInt(time));
                            stepServerItemBean.setCal((long) stepItemData.getCalorie());
                            stepServerItemBean.setDistance((long) stepItemData.getDistance());
                            stepServerItemBean.setStep(stepItemData.getSteps());
                            arrayList2.add(stepServerItemBean);
                        }
                    }
                    stepServerDailyBean.setDetails(arrayList2);
                    arrayList.add(stepServerDailyBean);
                }
            }
        }
        rg.l d8 = c6.a.f3389c.d(arrayList);
        XXApplication xXApplication2 = XXApplication.f7400h;
        d8.blockingSubscribe(new f1(g1Var, uploadSteps, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 11));
    }

    public static final void m(g1 g1Var) {
        User d5;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("查询待上传血糖数据...", Thread.currentThread().getName()));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        BloodSugarImpl bloodSugarImpl = BloodSugarImpl.INSTANCE;
        String userId = d5.getUserId();
        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
        List<DataBloodSugar> uploadSugars = bloodSugarImpl.getUploadSugars(userId);
        if (uploadSugars != null) {
            if (uploadSugars.isEmpty()) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的血糖数据...");
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "开始上传血糖数据...");
            ArrayList arrayList = new ArrayList();
            for (DataBloodSugar dataBloodSugar : uploadSugars) {
                String items = dataBloodSugar.getItems();
                if (items != null && items.length() != 0) {
                    SugarServerDailyBean sugarServerDailyBean = new SugarServerDailyBean();
                    sugarServerDailyBean.setMemberId(dataBloodSugar.getUserId());
                    sugarServerDailyBean.setDeviceId(dataBloodSugar.getMac());
                    try {
                        String timestamp = dataBloodSugar.getTimestamp();
                        kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                        sugarServerDailyBean.setDate(String.valueOf(Long.parseLong(timestamp) + ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000)));
                    } catch (Throwable th2) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadPressureData error ", th2.getMessage()));
                    }
                    String items2 = dataBloodSugar.getItems();
                    if (items2 != null) {
                        List<SugarData> h4 = com.example.baselibrary.utils.b.h(items2, new com.example.test.utils.z().f3204b);
                        ArrayList arrayList2 = new ArrayList();
                        kotlin.jvm.internal.e.c(h4);
                        for (SugarData sugarData : h4) {
                            SugarServerDailyBean.ItemBean itemBean = new SugarServerDailyBean.ItemBean();
                            itemBean.setTimestamp(String.valueOf(((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000) + sugarData.getCurrentTime()));
                            itemBean.setValue(sugarData.getSugar());
                            arrayList2.add(itemBean);
                        }
                        sugarServerDailyBean.setDetails(arrayList2);
                        arrayList.add(sugarServerDailyBean);
                    }
                }
            }
            c6.a aVar = c6.a.f3389c;
            aVar.getClass();
            RequestBody.Companion companion = RequestBody.Companion;
            MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
            String z5 = com.example.baselibrary.utils.b.z(arrayList);
            kotlin.jvm.internal.e.e(z5, "toJson(...)");
            rg.l<HttpModel<String>> uploadSugar = ((DataApi) aVar.f113a).uploadSugar(companion.create(parse, z5));
            kotlin.jvm.internal.e.e(uploadSugar, "uploadSugar(...)");
            rg.l u10 = com.example.baselibrary.utils.b.u(uploadSugar);
            XXApplication xXApplication = XXApplication.f7400h;
            u10.blockingSubscribe(new f1(g1Var, uploadSugars, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 12));
        }
    }

    public final void n() {
        User d5;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "上传结束...");
        this.f7706a = false;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        kVar.M(Long.valueOf(System.currentTimeMillis()), android.support.v4.media.session.e.l(d5.getUserId(), "data_sync_time"));
    }

    public final void o(boolean z5) {
        User d5;
        Long l3;
        if (!z5) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                User d8 = kVar.d();
                long j4 = 0;
                if (d8 != null && (l3 = (Long) kVar.i(android.support.v4.media.session.e.l(d8.getUserId(), "data_sync_time"), Long.TYPE)) != null) {
                    j4 = l3.longValue();
                }
                if (System.currentTimeMillis() - j4 < Const.L_WIFI_EXP) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "数据同步时间间隔小于一小时");
                    return;
                }
            }
        }
        if (this.f7706a || this.f7707b) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "正在上传或者下载数据...");
            return;
        }
        this.f7708c = true;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        if (kVar2 == null || (d5 = kVar2.d()) == null || d5.getPlatform() == 2) {
            return;
        }
        com.example.baselibrary.utils.b.y(new oh.l() { // from class: com.example.test.service.SyncServerService$serverDataInit$2$1
            @Override // oh.l
            public final List<SwitchBean> invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                if (kVar3 != null) {
                    return kVar3.w();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.service.SyncServerService$serverDataInit$2$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends SwitchBean>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<? extends SwitchBean> list) {
                User d10;
                if (list != null) {
                    g1.this.f7709d = list;
                }
                final g1 g1Var = g1.this;
                if (g1Var.f7707b) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "正在下载数据...");
                    return;
                }
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "开始下载数据...");
                Calendar calendar = Calendar.getInstance();
                calendar.set(5, calendar.get(5) + 1);
                calendar.set(11, 23);
                calendar.set(12, 59);
                calendar.set(13, 59);
                calendar.set(14, GLMapStaticValue.MAPRENDER_CAN_STOP_AND_FULLSCREEN_RENDEROVER);
                long j10 = 1000;
                final long rawOffset = ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? 3600000L : 0L)) / j10) + (calendar.getTimeInMillis() / j10);
                calendar.add(5, -100);
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                final long rawOffset2 = ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? 3600000L : 0L)) / j10) + (calendar.getTimeInMillis() / j10);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                if (kVar3 == null || (d10 = kVar3.d()) == null || d10.getPlatform() == 2) {
                    return;
                }
                g1Var.f7707b = true;
                com.example.baselibrary.utils.b.y(new oh.l() { // from class: com.example.test.service.SyncServerService$downloadData$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return eh.g.f12633a;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public final void invoke(String it) {
                        kotlin.jvm.internal.e.f(it, "it");
                        g1 g1Var2 = g1.this;
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                        SwitchBean switchBean = null;
                        g1Var2.f7709d = kVar4 != null ? kVar4.w() : null;
                        List list2 = g1.this.f7709d;
                        if (list2 != null) {
                            Iterator it2 = list2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                Object next = it2.next();
                                if (kotlin.jvm.internal.e.a(((SwitchBean) next).getParaName(), "isHealth")) {
                                    switchBean = next;
                                    break;
                                }
                            }
                            switchBean = switchBean;
                        }
                        if (switchBean != null && !kotlin.jvm.internal.e.a(switchBean.getParaValue(), "1")) {
                            g1.a(g1.this, rawOffset2, rawOffset);
                            return;
                        }
                        g1 g1Var3 = g1.this;
                        long j11 = rawOffset2;
                        long j12 = rawOffset;
                        g1Var3.getClass();
                        c6.a aVar = c6.a.f3389c;
                        String startDate = String.valueOf(j11);
                        String endDate = String.valueOf(j12);
                        aVar.getClass();
                        kotlin.jvm.internal.e.f(startDate, "startDate");
                        kotlin.jvm.internal.e.f(endDate, "endDate");
                        rg.l<HttpModel<List<StepServerDailyBean>>> downloadSteps = ((DataApi) aVar.f113a).downloadSteps(startDate, endDate);
                        kotlin.jvm.internal.e.e(downloadSteps, "downloadSteps(...)");
                        rg.l u10 = com.example.baselibrary.utils.b.u(downloadSteps);
                        XXApplication xXApplication = XXApplication.f7400h;
                        u10.blockingSubscribe(new d1(g1Var3, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1 g1Var4 = g1.this;
                        long j13 = rawOffset2;
                        long j14 = rawOffset;
                        g1Var4.getClass();
                        String startDate2 = String.valueOf(j13);
                        String endDate2 = String.valueOf(j14);
                        kotlin.jvm.internal.e.f(startDate2, "startDate");
                        kotlin.jvm.internal.e.f(endDate2, "endDate");
                        rg.l<HttpModel<List<SleepServerDailyBean>>> downloadSleeps = ((DataApi) aVar.f113a).downloadSleeps(startDate2, endDate2);
                        kotlin.jvm.internal.e.e(downloadSleeps, "downloadSleeps(...)");
                        com.example.baselibrary.utils.b.u(downloadSleeps).blockingSubscribe(new b1(g1Var4, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1 g1Var5 = g1.this;
                        long j15 = rawOffset2;
                        long j16 = rawOffset;
                        g1Var5.getClass();
                        String startDate3 = String.valueOf(j15);
                        String endDate3 = String.valueOf(j16);
                        kotlin.jvm.internal.e.f(startDate3, "startDate");
                        kotlin.jvm.internal.e.f(endDate3, "endDate");
                        rg.l<HttpModel<List<HrServerDailyBean>>> downloadHrs = ((DataApi) aVar.f113a).downloadHrs(startDate3, endDate3);
                        kotlin.jvm.internal.e.e(downloadHrs, "downloadHrs(...)");
                        com.example.baselibrary.utils.b.u(downloadHrs).blockingSubscribe(new x0(g1Var5, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1 g1Var6 = g1.this;
                        long j17 = rawOffset2;
                        long j18 = rawOffset;
                        g1Var6.getClass();
                        String startDate4 = String.valueOf(j17);
                        String endDate4 = String.valueOf(j18);
                        kotlin.jvm.internal.e.f(startDate4, "startDate");
                        kotlin.jvm.internal.e.f(endDate4, "endDate");
                        rg.l<HttpModel<List<BpServerDailyBean>>> downloadBps = ((DataApi) aVar.f113a).downloadBps(startDate4, endDate4);
                        kotlin.jvm.internal.e.e(downloadBps, "downloadBps(...)");
                        com.example.baselibrary.utils.b.u(downloadBps).blockingSubscribe(new u0(g1Var6, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1 g1Var7 = g1.this;
                        long j19 = rawOffset2;
                        long j20 = rawOffset;
                        g1Var7.getClass();
                        String startDate5 = String.valueOf(j19);
                        String endDate5 = String.valueOf(j20);
                        kotlin.jvm.internal.e.f(startDate5, "startDate");
                        kotlin.jvm.internal.e.f(endDate5, "endDate");
                        rg.l<HttpModel<List<BoServerDailyBean>>> downloadBos = ((DataApi) aVar.f113a).downloadBos(startDate5, endDate5);
                        kotlin.jvm.internal.e.e(downloadBos, "downloadBos(...)");
                        com.example.baselibrary.utils.b.u(downloadBos).blockingSubscribe(new t0(g1Var7, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1 g1Var8 = g1.this;
                        long j21 = rawOffset2;
                        long j22 = rawOffset;
                        g1Var8.getClass();
                        String startDate6 = String.valueOf(j21);
                        String endDate6 = String.valueOf(j22);
                        kotlin.jvm.internal.e.f(startDate6, "startDate");
                        kotlin.jvm.internal.e.f(endDate6, "endDate");
                        rg.l<HttpModel<List<BtServerDailyBean>>> downloadBts = ((DataApi) aVar.f113a).downloadBts(startDate6, endDate6);
                        kotlin.jvm.internal.e.e(downloadBts, "downloadBts(...)");
                        com.example.baselibrary.utils.b.u(downloadBts).blockingSubscribe(new w0(g1Var8, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1 g1Var9 = g1.this;
                        long j23 = rawOffset2;
                        long j24 = rawOffset;
                        g1Var9.getClass();
                        String startDate7 = String.valueOf(j23);
                        String endDate7 = String.valueOf(j24);
                        kotlin.jvm.internal.e.f(startDate7, "startDate");
                        kotlin.jvm.internal.e.f(endDate7, "endDate");
                        rg.l<HttpModel<List<BreatheServerDailyBean>>> downloadBreathes = ((DataApi) aVar.f113a).downloadBreathes(startDate7, endDate7);
                        kotlin.jvm.internal.e.e(downloadBreathes, "downloadBreathes(...)");
                        com.example.baselibrary.utils.b.u(downloadBreathes).blockingSubscribe(new v0(g1Var9, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1 g1Var10 = g1.this;
                        long j25 = rawOffset2;
                        long j26 = rawOffset;
                        g1Var10.getClass();
                        String startDate8 = String.valueOf(j25);
                        String endDate8 = String.valueOf(j26);
                        kotlin.jvm.internal.e.f(startDate8, "startDate");
                        kotlin.jvm.internal.e.f(endDate8, "endDate");
                        rg.l<HttpModel<List<HrvServerDailyBean>>> downloadHrv = ((DataApi) aVar.f113a).downloadHrv(startDate8, endDate8);
                        kotlin.jvm.internal.e.e(downloadHrv, "downloadHrv(...)");
                        com.example.baselibrary.utils.b.u(downloadHrv).blockingSubscribe(new y0(g1Var10, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1 g1Var11 = g1.this;
                        long j27 = rawOffset2;
                        long j28 = rawOffset;
                        g1Var11.getClass();
                        String startDate9 = String.valueOf(j27);
                        String endDate9 = String.valueOf(j28);
                        kotlin.jvm.internal.e.f(startDate9, "startDate");
                        kotlin.jvm.internal.e.f(endDate9, "endDate");
                        rg.l<HttpModel<List<PressureServerDailyBean>>> downloadPressure = ((DataApi) aVar.f113a).downloadPressure(startDate9, endDate9);
                        kotlin.jvm.internal.e.e(downloadPressure, "downloadPressure(...)");
                        com.example.baselibrary.utils.b.u(downloadPressure).blockingSubscribe(new z0(g1Var11, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1 g1Var12 = g1.this;
                        long j29 = rawOffset2;
                        long j30 = rawOffset;
                        g1Var12.getClass();
                        String startDate10 = String.valueOf(j29);
                        String endDate10 = String.valueOf(j30);
                        kotlin.jvm.internal.e.f(startDate10, "startDate");
                        kotlin.jvm.internal.e.f(endDate10, "endDate");
                        rg.l<HttpModel<List<RememberServerDailyBean>>> downloadRemember = ((DataApi) aVar.f113a).downloadRemember(startDate10, endDate10);
                        kotlin.jvm.internal.e.e(downloadRemember, "downloadRemember(...)");
                        com.example.baselibrary.utils.b.u(downloadRemember).blockingSubscribe(new a1(g1Var12, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1 g1Var13 = g1.this;
                        long j31 = rawOffset2;
                        long j32 = rawOffset;
                        g1Var13.getClass();
                        String startDate11 = String.valueOf(j31);
                        String endDate11 = String.valueOf(j32);
                        kotlin.jvm.internal.e.f(startDate11, "startDate");
                        kotlin.jvm.internal.e.f(endDate11, "endDate");
                        rg.l<HttpModel<List<SugarServerDailyBean>>> downloadSugar = ((DataApi) aVar.f113a).downloadSugar(startDate11, endDate11);
                        kotlin.jvm.internal.e.e(downloadSugar, "downloadSugar(...)");
                        com.example.baselibrary.utils.b.u(downloadSugar).blockingSubscribe(new e1(g1Var13, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d()));
                        g1.a(g1.this, rawOffset2, rawOffset);
                    }
                }, new oh.l() { // from class: com.example.test.service.SyncServerService$downloadData$1$2
                    public final void invoke(eh.g it) {
                        kotlin.jvm.internal.e.f(it, "it");
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((eh.g) obj);
                        return eh.g.f12633a;
                    }
                });
            }
        });
    }

    public final void p() {
        User d5;
        if (this.f7706a) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "正在上传数据...");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "开始上传数据... ");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        if (d5.getPlatform() == 2) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "访客身份不上传数据...");
        } else {
            this.f7706a = true;
            com.example.baselibrary.utils.b.y(new oh.l() { // from class: com.example.test.service.SyncServerService$uploadData$1$1
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final void invoke(String it) {
                    User d8;
                    kotlin.jvm.internal.e.f(it, "it");
                    g1 g1Var = g1.this;
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    SwitchBean switchBean = null;
                    g1Var.f7709d = kVar2 != null ? kVar2.w() : null;
                    List list = g1.this.f7709d;
                    if (list != null) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            if (kotlin.jvm.internal.e.a(((SwitchBean) next).getParaName(), "isHealth")) {
                                switchBean = next;
                                break;
                            }
                        }
                        switchBean = switchBean;
                    }
                    if (switchBean != null && !kotlin.jvm.internal.e.a(switchBean.getParaValue(), "1")) {
                        g1.this.getClass();
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "健康数据已关闭...");
                        g1.k(g1.this);
                        return;
                    }
                    if (!y5.d.f20005b) {
                        g1.l(g1.this);
                        g1.j(g1.this);
                        g1.f(g1.this);
                        g1.c(g1.this);
                        g1.b(g1.this);
                        g1.e(g1.this);
                        g1.d(g1.this);
                        g1.m(g1.this);
                        g1.g(g1.this);
                        g1.h(g1.this);
                        g1.i(g1.this);
                        g1.k(g1.this);
                        return;
                    }
                    g1 g1Var2 = g1.this;
                    g1Var2.getClass();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("查询待上传步数数据...", Thread.currentThread().getName()));
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                    if (kVar3 != null && (d8 = kVar3.d()) != null) {
                        RawStepsImpl rawStepsImpl = RawStepsImpl.INSTANCE;
                        String userId = d8.getUserId();
                        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                        List<RawDataStep> uploadSteps = rawStepsImpl.getUploadSteps(userId);
                        if (uploadSteps.isEmpty()) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "没有未上传的步数数据");
                        } else {
                            XXApplication xXApplication = XXApplication.f7400h;
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "uploadJLSteps 开始上传步数数据... " + com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c());
                            ArrayList arrayList = new ArrayList();
                            for (RawDataStep rawDataStep : uploadSteps) {
                                StepServerDailyBean stepServerDailyBean = new StepServerDailyBean();
                                stepServerDailyBean.setMemberId(rawDataStep.getUserId());
                                stepServerDailyBean.setDeviceId(rawDataStep.getMac());
                                stepServerDailyBean.setCal((long) rawDataStep.getCalorie());
                                stepServerDailyBean.setDistance((long) rawDataStep.getDistance());
                                stepServerDailyBean.setStep(rawDataStep.getStep());
                                try {
                                    String date = rawDataStep.getDate();
                                    kotlin.jvm.internal.e.e(date, "getDate(...)");
                                    stepServerDailyBean.setDate(String.valueOf(com.example.baselibrary.utils.b.a(date) + (com.example.baselibrary.utils.b.l() / 1000)));
                                } catch (Throwable th2) {
                                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeUploadStepData error ", th2.getMessage()));
                                }
                                arrayList.add(stepServerDailyBean);
                            }
                            rg.l d10 = c6.a.f3389c.d(arrayList);
                            XXApplication xXApplication2 = XXApplication.f7400h;
                            d10.blockingSubscribe(new f1(g1Var2, uploadSteps, com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), com.example.test.utils.w0.d(), 6));
                        }
                    }
                    g1.l(g1.this);
                    g1.j(g1.this);
                    g1.f(g1.this);
                    g1.c(g1.this);
                    g1.b(g1.this);
                    g1.e(g1.this);
                    g1.d(g1.this);
                    g1.m(g1.this);
                    g1.g(g1.this);
                    g1.h(g1.this);
                    g1.i(g1.this);
                    g1.k(g1.this);
                }
            }, new oh.l() { // from class: com.example.test.service.SyncServerService$uploadData$1$2
                public final void invoke(eh.g it) {
                    kotlin.jvm.internal.e.f(it, "it");
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((eh.g) obj);
                    return eh.g.f12633a;
                }
            });
        }
    }
}
