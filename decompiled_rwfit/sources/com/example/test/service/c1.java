package com.example.test.service;

import android.app.Activity;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.sync.ImperialPaceItemBean;
import com.example.blesdk.bean.sync.MetricPaceItemBean;
import com.example.blesdk.bean.sync.SportHrItemBean;
import com.example.database.db.SportImpl;
import com.example.database.table.DataSport;
import com.example.network.base.HttpModel;
import com.example.network.bean.SportHrServerItemBean;
import com.example.network.bean.SportLatLngServerItemBean;
import com.example.network.bean.SportPacesServerItemBean;
import com.example.network.bean.SportServerDailyBean;
import com.example.network.bean.SportStepFreServerItemBean;
import com.example.test.ui.model.EventBusBeans;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class c1 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g1 f7656d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(g1 g1Var, Activity activity, com.example.test.utils.w0 w0Var) {
        super(activity, w0Var);
        this.f7656d = g1Var;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        g1 g1Var = this.f7656d;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("downloadSport onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "下载结束...");
        g1Var.f7707b = false;
        if (g1Var.f7708c) {
            g1Var.p();
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        List<SportServerDailyBean> list;
        String str;
        HttpModel httpModel = (HttpModel) obj;
        g1 g1Var = this.f7656d;
        g1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "downloadSport onSuccess ->");
        if ((httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false) && (list = (List) httpModel.getResults()) != null) {
            ArrayList arrayList = new ArrayList();
            for (SportServerDailyBean sportServerDailyBean : list) {
                DataSport dataSport = new DataSport();
                dataSport.setUserId(sportServerDailyBean.getMemberId());
                dataSport.setMac(sportServerDailyBean.getDeviceId());
                dataSport.setIsUpdate(true);
                dataSport.setSportType(sportServerDailyBean.getType());
                dataSport.setFrom(sportServerDailyBean.getFrom());
                dataSport.setTotalTimes(String.valueOf(sportServerDailyBean.getTotalTime()));
                dataSport.setTotalCalories(String.valueOf(sportServerDailyBean.getTotalCal()));
                dataSport.setTotalSteps(String.valueOf(sportServerDailyBean.getTotalStep()));
                dataSport.setTotalDistances(String.valueOf(sportServerDailyBean.getTotalDistance()));
                dataSport.setNewSportHrs(sportServerDailyBean.getNewSportHrs());
                Integer viewType = sportServerDailyBean.getViewType();
                kotlin.jvm.internal.e.e(viewType, "getViewType(...)");
                dataSport.setViewType(viewType.intValue());
                Long avgPace = sportServerDailyBean.getAvgPace();
                kotlin.jvm.internal.e.e(avgPace, "getAvgPace(...)");
                dataSport.setAvgPace(avgPace.longValue());
                Long minPace = sportServerDailyBean.getMinPace();
                kotlin.jvm.internal.e.e(minPace, "getMinPace(...)");
                dataSport.setMinPace(minPace.longValue());
                Long maxPace = sportServerDailyBean.getMaxPace();
                kotlin.jvm.internal.e.e(maxPace, "getMaxPace(...)");
                dataSport.setMaxPace(maxPace.longValue());
                Long avgSteps = sportServerDailyBean.getAvgSteps();
                kotlin.jvm.internal.e.e(avgSteps, "getAvgSteps(...)");
                dataSport.setAvgSteps(avgSteps.longValue());
                Long minSteps = sportServerDailyBean.getMinSteps();
                kotlin.jvm.internal.e.e(minSteps, "getMinSteps(...)");
                dataSport.setMinSteps(minSteps.longValue());
                Long maxSteps = sportServerDailyBean.getMaxSteps();
                kotlin.jvm.internal.e.e(maxSteps, "getMaxSteps(...)");
                dataSport.setMaxSteps(maxSteps.longValue());
                Long avgHr = sportServerDailyBean.getAvgHr();
                kotlin.jvm.internal.e.e(avgHr, "getAvgHr(...)");
                dataSport.setAvgHr(avgHr.longValue());
                Long minHr = sportServerDailyBean.getMinHr();
                kotlin.jvm.internal.e.e(minHr, "getMinHr(...)");
                dataSport.setMinHr(minHr.longValue());
                Long maxHr = sportServerDailyBean.getMaxHr();
                kotlin.jvm.internal.e.e(maxHr, "getMaxHr(...)");
                dataSport.setMaxHr(maxHr.longValue());
                try {
                    long j4 = 1000;
                    long timestamp = sportServerDailyBean.getTimestamp() - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / j4);
                    dataSport.setTimestamp(String.valueOf(timestamp));
                    long j10 = timestamp * j4;
                    try {
                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(j10));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, j10 + " date translate error " + e.getMessage());
                        str = null;
                    }
                    dataSport.setDate(str);
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeLocalSportsData error ", th2.getMessage()));
                }
                ArrayList arrayList2 = new ArrayList();
                List<SportHrServerItemBean> heartRates = sportServerDailyBean.getHeartRates();
                if (heartRates != null) {
                    for (SportHrServerItemBean sportHrServerItemBean : heartRates) {
                        SportHrItemBean sportHrItemBean = new SportHrItemBean();
                        sportHrItemBean.setHr(sportHrServerItemBean.getValue());
                        sportHrItemBean.setTimeMills(sportHrServerItemBean.getIndex());
                        arrayList2.add(sportHrItemBean);
                    }
                }
                dataSport.setHrData(com.example.baselibrary.utils.b.z(arrayList2));
                ArrayList arrayList3 = new ArrayList();
                List<SportPacesServerItemBean> kmPaces = sportServerDailyBean.getKmPaces();
                if (kmPaces != null) {
                    for (SportPacesServerItemBean sportPacesServerItemBean : kmPaces) {
                        MetricPaceItemBean metricPaceItemBean = new MetricPaceItemBean();
                        metricPaceItemBean.setKm(sportPacesServerItemBean.getIsWhole() == 1);
                        metricPaceItemBean.setPace(sportPacesServerItemBean.getPace());
                        metricPaceItemBean.setPaceIndex(sportPacesServerItemBean.getIndex());
                        arrayList3.add(metricPaceItemBean);
                    }
                }
                dataSport.setPaceMetrics(com.example.baselibrary.utils.b.z(arrayList3));
                ArrayList arrayList4 = new ArrayList();
                List<SportPacesServerItemBean> kmPaces2 = sportServerDailyBean.getKmPaces();
                if (kmPaces2 != null) {
                    for (SportPacesServerItemBean sportPacesServerItemBean2 : kmPaces2) {
                        ImperialPaceItemBean imperialPaceItemBean = new ImperialPaceItemBean();
                        imperialPaceItemBean.setMi(sportPacesServerItemBean2.getIsWhole() == 1);
                        imperialPaceItemBean.setPace(sportPacesServerItemBean2.getPace());
                        imperialPaceItemBean.setPaceIndex(sportPacesServerItemBean2.getIndex());
                        arrayList4.add(imperialPaceItemBean);
                    }
                }
                dataSport.setPaceImperials(com.example.baselibrary.utils.b.z(arrayList4));
                ArrayList arrayList5 = new ArrayList();
                List<SportStepFreServerItemBean> stepFrequencies = sportServerDailyBean.getStepFrequencies();
                if (stepFrequencies != null) {
                    Iterator<T> it = stepFrequencies.iterator();
                    while (it.hasNext()) {
                        arrayList5.add(Long.valueOf(((SportStepFreServerItemBean) it.next()).getFrequency()));
                    }
                }
                dataSport.setStepDetails(com.example.baselibrary.utils.b.z(arrayList5));
                ArrayList arrayList6 = new ArrayList();
                List<SportLatLngServerItemBean> locations = sportServerDailyBean.getLocations();
                if (locations != null) {
                    for (SportLatLngServerItemBean sportLatLngServerItemBean : locations) {
                        String lat = sportLatLngServerItemBean.getLat();
                        kotlin.jvm.internal.e.e(lat, "getLat(...)");
                        double parseDouble = Double.parseDouble(lat);
                        String lng = sportLatLngServerItemBean.getLng();
                        kotlin.jvm.internal.e.e(lng, "getLng(...)");
                        arrayList6.add(new h6.a(parseDouble, Double.parseDouble(lng)));
                    }
                }
                dataSport.setLatLng(com.example.baselibrary.utils.b.z(arrayList6));
                arrayList.add(dataSport);
            }
            SportImpl.INSTANCE.saveDatas(arrayList);
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "下载结束...");
        g1Var.f7707b = false;
        if (g1Var.f7708c) {
            g1Var.p();
        }
        yh.d.b().e(new EventBusBeans.SyncEvent(8));
    }
}
