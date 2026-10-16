package com.example.test.service;

import android.app.Activity;
import com.example.database.db.SleepImpl;
import com.example.database.table.DataSleep;
import com.example.network.base.HttpModel;
import com.example.network.bean.SleepServerDailyBean;
import com.example.network.bean.SleepServerItemBean;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.SleepItemData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b1 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g1 f7653d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(g1 g1Var, Activity activity, com.example.test.utils.w0 w0Var) {
        super(activity, w0Var);
        this.f7653d = g1Var;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        this.f7653d.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("downloadSleeps onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
    }

    @Override // d6.b
    public final void b(Object obj) {
        String str;
        long j4;
        long j10;
        long j11;
        long j12;
        List<SleepServerItemBean> details;
        String str2;
        SleepServerItemBean sleepServerItemBean;
        boolean z5;
        String str3;
        DataSleep dataByDate;
        HttpModel httpModel = (HttpModel) obj;
        this.f7653d.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("downloadSleeps onSuccess ->", com.example.baselibrary.utils.b.z(httpModel)));
        if (httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false) {
            List<SleepServerDailyBean> list = (List) httpModel.getResults();
            String str4 = "ServerDataTransform";
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (SleepServerDailyBean sleepServerDailyBean : list) {
                    DataSleep dataSleep = new DataSleep();
                    dataSleep.setUserId(sleepServerDailyBean.getMemberId());
                    dataSleep.setMac(sleepServerDailyBean.getDeviceId());
                    dataSleep.setIsUpdate(true);
                    dataSleep.setTotalSleepTime(sleepServerDailyBean.getTotalTime());
                    try {
                        String date = sleepServerDailyBean.getDate();
                        kotlin.jvm.internal.e.e(date, "getDate(...)");
                        long j13 = 1000;
                        long parseLong = Long.parseLong(date) - (com.example.baselibrary.utils.b.l() / j13);
                        dataSleep.setTimestamp(String.valueOf(parseLong));
                        long j14 = parseLong * j13;
                        try {
                            str3 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(j14));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, j14 + " date translate error " + e.getMessage());
                            str3 = null;
                        }
                        dataSleep.setDate(str3);
                        dataSleep.setAsleepTime(sleepServerDailyBean.getStartTime() - (com.example.baselibrary.utils.b.l() / j13));
                        dataSleep.setWakeupTime(sleepServerDailyBean.getEndTime() - (com.example.baselibrary.utils.b.l() / j13));
                        SleepImpl sleepImpl = SleepImpl.INSTANCE;
                        String mac = dataSleep.getMac();
                        String userId = dataSleep.getUserId();
                        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                        String date2 = dataSleep.getDate();
                        kotlin.jvm.internal.e.e(date2, "getDate(...)");
                        dataByDate = sleepImpl.getDataByDate(mac, userId, date2);
                    } catch (Throwable th2) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, str4, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeLocalStepData error ", th2.getMessage()));
                    }
                    if (dataByDate != null && !dataByDate.getIsUpdate()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, str4, "invokeLocalBoData 本地存在未上传的数据");
                        str = str4;
                        str4 = str;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    List<SleepServerItemBean> details2 = sleepServerDailyBean.getDetails();
                    if (details2 == null || details2.isEmpty() || (details = sleepServerDailyBean.getDetails()) == null) {
                        str = str4;
                        j4 = 0;
                        j10 = 0;
                        j11 = 0;
                        j12 = 0;
                    } else {
                        j11 = 0;
                        j12 = 0;
                        long j15 = 0;
                        long j16 = 0;
                        for (SleepServerItemBean sleepServerItemBean2 : details) {
                            SleepItemData sleepItemData = new SleepItemData();
                            sleepItemData.setSleepType(sleepServerItemBean2.getType());
                            sleepItemData.setDuration(sleepServerItemBean2.getPeriod());
                            if (dataSleep.getTotalSleepTime() > 0) {
                                sleepServerItemBean = sleepServerItemBean2;
                                str2 = str4;
                                sleepItemData.setDurationPercent((sleepItemData.getDuration() * 60.0d) / dataSleep.getTotalSleepTime());
                            } else {
                                str2 = str4;
                                sleepServerItemBean = sleepServerItemBean2;
                            }
                            arrayList2.add(sleepItemData);
                            int type = sleepServerItemBean.getType();
                            if (type != 0) {
                                z5 = true;
                                if (type == 1) {
                                    j16 += sleepServerItemBean.getPeriod();
                                } else if (type == 2) {
                                    j11 += sleepServerItemBean.getPeriod();
                                } else if (type == 3) {
                                    j12 += sleepServerItemBean.getPeriod();
                                }
                            } else {
                                z5 = true;
                                j15 += sleepServerItemBean.getPeriod();
                            }
                            str4 = str2;
                        }
                        str = str4;
                        j4 = j15;
                        j10 = j16;
                    }
                    dataSleep.setWakeupCount((int) j4);
                    dataSleep.setSleepLightTime(j10);
                    dataSleep.setSleepDeepTime(j11);
                    dataSleep.setSleepRapidTime(j12);
                    dataSleep.setItems(com.example.baselibrary.utils.b.z(arrayList2));
                    arrayList.add(dataSleep);
                    str4 = str;
                }
                SleepImpl.INSTANCE.saveDatas(arrayList);
            }
        }
        yh.d.b().e(new EventBusBeans.SyncEvent(4));
    }
}
