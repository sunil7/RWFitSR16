package com.example.test.service;

import android.app.Activity;
import com.autonavi.aps.amapapi.config.Const;
import com.example.database.db.RawStepsImpl;
import com.example.database.db.StepsImpl;
import com.example.database.table.DataStep;
import com.example.database.table.RawDataStep;
import com.example.network.base.HttpModel;
import com.example.network.bean.StepServerDailyBean;
import com.example.network.bean.StepServerItemBean;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.StepItemData;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class d1 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g1 f7680d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(g1 g1Var, Activity activity, com.example.test.utils.w0 w0Var) {
        super(activity, w0Var);
        this.f7680d = g1Var;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        this.f7680d.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("downloadSteps onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
    }

    @Override // d6.b
    public final void b(Object obj) {
        String str;
        String str2;
        List<StepServerItemBean> details;
        String str3;
        float f2;
        float f10;
        int i3;
        List<StepServerItemBean> details2;
        String str4;
        long j4;
        String str5;
        DataStep stepByDate;
        ArrayList arrayList;
        ArrayList arrayList2;
        Object obj2;
        HttpModel httpModel = (HttpModel) obj;
        this.f7680d.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "downloadSteps onSuccess ->");
        if (httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false) {
            String str6 = "invokeLocalStepData error ";
            int i10 = 1000;
            String str7 = "getDate(...)";
            if (y5.d.f20005b) {
                List<StepServerDailyBean> list = (List) httpModel.getResults();
                if (list != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (StepServerDailyBean stepServerDailyBean : list) {
                        RawDataStep rawDataStep = new RawDataStep();
                        rawDataStep.setUserId(stepServerDailyBean.getMemberId());
                        rawDataStep.setMac(stepServerDailyBean.getDeviceId());
                        try {
                            String date = stepServerDailyBean.getDate();
                            kotlin.jvm.internal.e.e(date, "getDate(...)");
                            arrayList = arrayList3;
                            long j10 = 1000;
                            try {
                                long parseLong = Long.parseLong(date) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / j10);
                                rawDataStep.setTimestamp(parseLong);
                                long j11 = parseLong * j10;
                                rawDataStep.setDate(ca.i(j11, "yyyyMMdd"));
                                rawDataStep.setHour(ca.i(j11, "HH"));
                                RawStepsImpl rawStepsImpl = RawStepsImpl.INSTANCE;
                                String mac = rawDataStep.getMac();
                                String userId = rawDataStep.getUserId();
                                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                String date2 = rawDataStep.getDate();
                                kotlin.jvm.internal.e.e(date2, "getDate(...)");
                                Iterator<T> it = rawStepsImpl.getStepByDate(mac, userId, date2).iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        obj2 = it.next();
                                        if (!((RawDataStep) obj2).getIsUpdate()) {
                                            break;
                                        }
                                    } else {
                                        obj2 = null;
                                        break;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeLocalStepData error ", th.getMessage()));
                                rawDataStep.setIsUpdate(true);
                                rawDataStep.setStep(stepServerDailyBean.getStep());
                                rawDataStep.setCalorie(stepServerDailyBean.getCal());
                                rawDataStep.setDistance(stepServerDailyBean.getDistance());
                                arrayList2 = arrayList;
                                arrayList2.add(rawDataStep);
                                arrayList3 = arrayList2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            arrayList = arrayList3;
                        }
                        if (((RawDataStep) obj2) != null) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", "invokeLocalBoData 本地存在未上传的数据");
                            arrayList2 = arrayList;
                            arrayList3 = arrayList2;
                        }
                        rawDataStep.setIsUpdate(true);
                        rawDataStep.setStep(stepServerDailyBean.getStep());
                        rawDataStep.setCalorie(stepServerDailyBean.getCal());
                        rawDataStep.setDistance(stepServerDailyBean.getDistance());
                        arrayList2 = arrayList;
                        arrayList2.add(rawDataStep);
                        arrayList3 = arrayList2;
                    }
                    RawStepsImpl.INSTANCE.saveSteps(arrayList3);
                }
            } else {
                List<StepServerDailyBean> list2 = (List) httpModel.getResults();
                if (list2 != null) {
                    ArrayList arrayList4 = new ArrayList();
                    for (StepServerDailyBean stepServerDailyBean2 : list2) {
                        DataStep dataStep = new DataStep();
                        dataStep.setUserId(stepServerDailyBean2.getMemberId());
                        dataStep.setMac(stepServerDailyBean2.getDeviceId());
                        try {
                            String date3 = stepServerDailyBean2.getDate();
                            kotlin.jvm.internal.e.e(date3, str7);
                            str = str6;
                            try {
                                str4 = str7;
                                j4 = i10;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                long parseLong2 = Long.parseLong(date3) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / j4);
                                dataStep.setTimestamp(String.valueOf(parseLong2));
                                long j12 = parseLong2 * j4;
                                try {
                                    str5 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(j12));
                                } catch (Exception e) {
                                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, j12 + " date translate error " + e.getMessage());
                                    str5 = null;
                                }
                                dataStep.setDate(str5);
                                StepsImpl stepsImpl = StepsImpl.INSTANCE;
                                String mac2 = dataStep.getMac();
                                String userId2 = dataStep.getUserId();
                                kotlin.jvm.internal.e.e(userId2, "getUserId(...)");
                                String date4 = dataStep.getDate();
                                str7 = str4;
                                kotlin.jvm.internal.e.e(date4, str7);
                                stepByDate = stepsImpl.getStepByDate(mac2, userId2, date4);
                            } catch (Throwable th5) {
                                th = th5;
                                str7 = str4;
                                str2 = str;
                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n(str2, th.getMessage()));
                                dataStep.setIsUpdate(true);
                                ArrayList arrayList5 = new ArrayList();
                                details = stepServerDailyBean2.getDetails();
                                float f11 = 0.0f;
                                if (details != null) {
                                }
                                str3 = str7;
                                f2 = 0.0f;
                                f10 = 0.0f;
                                i3 = 0;
                                dataStep.setTotalStep(i3);
                                dataStep.setCalorie(f2);
                                dataStep.setDistance(f10);
                                dataStep.setItems(com.example.baselibrary.utils.b.z(arrayList5));
                                arrayList4.add(dataStep);
                                str6 = str2;
                                str7 = str3;
                                i10 = 1000;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            str = str6;
                        }
                        if (stepByDate == null || stepByDate.getIsUpdate()) {
                            str2 = str;
                            dataStep.setIsUpdate(true);
                            ArrayList arrayList52 = new ArrayList();
                            details = stepServerDailyBean2.getDetails();
                            float f112 = 0.0f;
                            if (details != null || details.isEmpty() || (details2 = stepServerDailyBean2.getDetails()) == null) {
                                str3 = str7;
                                f2 = 0.0f;
                                f10 = 0.0f;
                                i3 = 0;
                            } else {
                                f10 = 0.0f;
                                int i11 = 0;
                                for (StepServerItemBean stepServerItemBean : details2) {
                                    StepItemData stepItemData = new StepItemData();
                                    stepItemData.setSteps(stepServerItemBean.getStep());
                                    stepItemData.setTime(String.valueOf(stepServerItemBean.getIndex()));
                                    stepItemData.setDistance(stepServerItemBean.getDistance());
                                    stepItemData.setCalorie(stepServerItemBean.getCal());
                                    arrayList52.add(stepItemData);
                                    i11 = stepItemData.getSteps() + i11;
                                    f112 = stepItemData.getCalorie() + f112;
                                    f10 += stepItemData.getDistance();
                                    str7 = str7;
                                }
                                str3 = str7;
                                f2 = f112;
                                i3 = i11;
                            }
                            dataStep.setTotalStep(i3);
                            dataStep.setCalorie(f2);
                            dataStep.setDistance(f10);
                            dataStep.setItems(com.example.baselibrary.utils.b.z(arrayList52));
                            arrayList4.add(dataStep);
                            str6 = str2;
                            str7 = str3;
                            i10 = 1000;
                        } else {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", "invokeLocalBoData 本地存在未上传的数据");
                            str3 = str7;
                            str2 = str;
                            str6 = str2;
                            str7 = str3;
                            i10 = 1000;
                        }
                    }
                    StepsImpl.INSTANCE.saveSteps(arrayList4);
                }
            }
        }
        yh.d.b().e(new EventBusBeans.SyncEvent(0));
    }
}
