package com.example.test.service;

import android.app.Activity;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.sync.BreatheItemBean;
import com.example.database.db.BreatheImpl;
import com.example.database.table.DataBreathe;
import com.example.network.base.HttpModel;
import com.example.network.bean.BreatheServerDailyBean;
import com.example.network.bean.BreatheServerItemBean;
import com.example.test.ui.model.EventBusBeans;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class v0 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g1 f7831d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(g1 g1Var, Activity activity, com.example.test.utils.w0 w0Var) {
        super(activity, w0Var);
        this.f7831d = g1Var;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        this.f7831d.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("downloadBreathes onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
    }

    @Override // d6.b
    public final void b(Object obj) {
        int i3;
        String str;
        String str2;
        String str3;
        DataBreathe dataByDate;
        HttpModel httpModel = (HttpModel) obj;
        this.f7831d.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("downloadBreathes onSuccess ->", com.example.baselibrary.utils.b.z(httpModel)));
        if (httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false) {
            List<BreatheServerDailyBean> list = (List) httpModel.getResults();
            String str4 = "getDate(...)";
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (BreatheServerDailyBean breatheServerDailyBean : list) {
                    DataBreathe dataBreathe = new DataBreathe();
                    dataBreathe.setUserId(breatheServerDailyBean.getMemberId());
                    dataBreathe.setMac(breatheServerDailyBean.getDeviceId());
                    dataBreathe.setIsUpdate(true);
                    try {
                        String date = breatheServerDailyBean.getDate();
                        kotlin.jvm.internal.e.e(date, str4);
                        long j4 = 1000;
                        long parseLong = Long.parseLong(date) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / j4);
                        dataBreathe.setTimestamp(String.valueOf(parseLong));
                        long j10 = parseLong * j4;
                        try {
                            str3 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(j10));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, j10 + " date translate error " + e.getMessage());
                            str3 = null;
                        }
                        dataBreathe.setDate(str3);
                        BreatheImpl breatheImpl = BreatheImpl.INSTANCE;
                        String mac = dataBreathe.getMac();
                        String userId = dataBreathe.getUserId();
                        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                        String date2 = dataBreathe.getDate();
                        kotlin.jvm.internal.e.e(date2, str4);
                        dataByDate = breatheImpl.getDataByDate(mac, userId, date2);
                    } catch (Throwable th2) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeLocalBreatheData error ", th2.getMessage()));
                    }
                    if (dataByDate != null && !dataByDate.getIsUpdate()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", "invokeLocalBreatheData 本地存在未上传的数据");
                        str = str4;
                        str4 = str;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    List<BreatheServerItemBean> details = breatheServerDailyBean.getDetails();
                    if (details != null) {
                        i3 = 0;
                        for (BreatheServerItemBean breatheServerItemBean : details) {
                            int value = breatheServerItemBean.getValue() + i3;
                            BreatheItemBean breatheItemBean = new BreatheItemBean();
                            breatheItemBean.setTimeLen(breatheServerItemBean.getValue());
                            try {
                                long timestamp = breatheServerItemBean.getTimestamp();
                                str2 = str4;
                                try {
                                    breatheItemBean.setTimeMills(timestamp - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000));
                                } catch (Throwable th3) {
                                    th = th3;
                                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ServerDataTransform", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("invokeLocalStepData error ", th.getMessage()));
                                    arrayList2.add(breatheItemBean);
                                    str4 = str2;
                                    i3 = value;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                str2 = str4;
                            }
                            arrayList2.add(breatheItemBean);
                            str4 = str2;
                            i3 = value;
                        }
                    } else {
                        i3 = 0;
                    }
                    str = str4;
                    dataBreathe.setTotalTime(Integer.valueOf(i3));
                    dataBreathe.setItems(com.example.baselibrary.utils.b.z(arrayList2));
                    arrayList.add(dataBreathe);
                    str4 = str;
                }
                BreatheImpl.INSTANCE.saveDatas(arrayList);
            }
        }
        yh.d.b().e(new EventBusBeans.SyncEvent(7));
    }
}
