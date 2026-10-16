package com.example.test.service;

import android.app.Activity;
import com.autonavi.aps.amapapi.config.Const;
import com.example.database.db.HrvImpl;
import com.example.database.db.MuslimCountImpl;
import com.example.database.table.DataHeartHrv;
import com.example.database.table.DataMuslimCount;
import com.example.network.base.HttpModel;
import com.example.network.bean.RememberServerDailyBean;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.MuslimItemData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class a1 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g1 f7651d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(g1 g1Var, Activity activity, com.example.test.utils.w0 w0Var) {
        super(activity, w0Var);
        this.f7651d = g1Var;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        this.f7651d.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("downloadHrs onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
    }

    @Override // d6.b
    public final void b(Object obj) {
        List<RememberServerDailyBean> list;
        int i3;
        int i10;
        int i11;
        int i12;
        String str;
        DataHeartHrv dataByDate;
        HttpModel httpModel = (HttpModel) obj;
        this.f7651d.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "downloadHrs onSuccess ->");
        int i13 = 0;
        if ((httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false) && (list = (List) httpModel.getResults()) != null) {
            ArrayList arrayList = new ArrayList();
            for (RememberServerDailyBean rememberServerDailyBean : list) {
                DataMuslimCount dataMuslimCount = new DataMuslimCount();
                dataMuslimCount.setUserId(rememberServerDailyBean.getMemberId());
                dataMuslimCount.setMac(rememberServerDailyBean.getDeviceId());
                dataMuslimCount.setIsUpdate(true);
                try {
                    String date = rememberServerDailyBean.getDate();
                    kotlin.jvm.internal.e.e(date, "getDate(...)");
                    long j4 = 1000;
                    long parseLong = Long.parseLong(date) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / j4);
                    dataMuslimCount.setTimestamp(String.valueOf(parseLong));
                    long j10 = parseLong * j4;
                    try {
                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(j10));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, j10 + " date translate error " + e.getMessage());
                        str = null;
                    }
                    dataMuslimCount.setDate(str);
                    HrvImpl hrvImpl = HrvImpl.INSTANCE;
                    String mac = dataMuslimCount.getMac();
                    String userId = dataMuslimCount.getUserId();
                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                    String date2 = dataMuslimCount.getDate();
                    kotlin.jvm.internal.e.e(date2, "getDate(...)");
                    dataByDate = hrvImpl.getDataByDate(mac, userId, date2);
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeLocalStepData error ", th2.getMessage()));
                }
                if (dataByDate != null && !dataByDate.getIsUpdate()) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", "invokeLocalBoData 本地存在未上传的数据");
                    i13 = 0;
                }
                ArrayList arrayList2 = new ArrayList();
                List<RememberServerDailyBean.ItemBean> details = rememberServerDailyBean.getDetails();
                if (details != null && !details.isEmpty()) {
                    List<RememberServerDailyBean.ItemBean> details2 = rememberServerDailyBean.getDetails();
                    if (details2 != null) {
                        i10 = i13;
                        i11 = i10;
                        i12 = i11;
                        i3 = Integer.MAX_VALUE;
                        for (RememberServerDailyBean.ItemBean itemBean : details2) {
                            MuslimItemData muslimItemData = new MuslimItemData(i13, i13);
                            muslimItemData.setCount(itemBean.getValue());
                            Integer hourIndex = itemBean.getHourIndex();
                            kotlin.jvm.internal.e.e(hourIndex, "getHourIndex(...)");
                            muslimItemData.setHourIndex(hourIndex.intValue());
                            arrayList2.add(muslimItemData);
                            if (muslimItemData.getCount() > 0) {
                                if (muslimItemData.getCount() < i3) {
                                    i3 = muslimItemData.getCount();
                                }
                                i10 += muslimItemData.getCount();
                                i11++;
                            }
                            if (muslimItemData.getCount() > i12) {
                                i12 = muslimItemData.getCount();
                            }
                            i13 = 0;
                        }
                    } else {
                        i3 = Integer.MAX_VALUE;
                        i10 = 0;
                        i11 = 0;
                        i12 = 0;
                    }
                    if (i11 > 0) {
                        dataMuslimCount.setAvgCount(i10 / i11);
                    }
                    if (i3 == Integer.MAX_VALUE) {
                        i3 = 0;
                    }
                    dataMuslimCount.setMinCount(i3);
                    dataMuslimCount.setMaxCount(i12);
                    dataMuslimCount.setItems(com.example.baselibrary.utils.b.z(arrayList2));
                }
                arrayList.add(dataMuslimCount);
                i13 = 0;
            }
            MuslimCountImpl.INSTANCE.saveDatas(arrayList);
        }
        yh.d.b().e(new EventBusBeans.SyncEvent(10));
    }
}
