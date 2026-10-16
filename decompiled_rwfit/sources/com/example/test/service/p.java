package com.example.test.service;

import com.example.blesdk.bean.sync.HeartRateItemBean;
import com.example.blesdk.bean.sync.HeartRateSyncBean;
import com.example.database.db.HrImpl;
import com.example.database.table.DataHeartRate;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.HrData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class p implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7740a;

    public p(d0 d0Var) {
        this.f7740a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        this.f7740a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "DeviceMonitorService", "心率同步失败[" + i3 + "]");
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        List list = (List) obj;
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$hrCallback$2$1$onResult$1$1
                @Override // oh.l
                public final Boolean invoke(List<HeartRateSyncBean> list2) {
                    String str;
                    int i3;
                    int i10;
                    int i11;
                    int i12;
                    Devices c9;
                    User d5;
                    ArrayList t8 = android.support.v4.media.session.e.t("hrSyncBeans", list2);
                    for (HeartRateSyncBean heartRateSyncBean : list2) {
                        DataHeartRate dataHeartRate = new DataHeartRate();
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null && (d5 = kVar.d()) != null) {
                            dataHeartRate.setUserId(d5.getUserId());
                        }
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        if (kVar2 != null && (c9 = kVar2.c()) != null) {
                            dataHeartRate.setMac(c9.getMacAddress());
                        }
                        int i13 = 0;
                        dataHeartRate.setIsUpdate(false);
                        dataHeartRate.setTimestamp(String.valueOf(heartRateSyncBean.getTime()));
                        long time = heartRateSyncBean.getTime() * 1000;
                        try {
                            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                            str = null;
                        }
                        dataHeartRate.setDate(str);
                        ArrayList arrayList = new ArrayList();
                        List<HeartRateItemBean> items = heartRateSyncBean.getItems();
                        if (items != null) {
                            i3 = 0;
                            i10 = 0;
                            i11 = 0;
                            i12 = Integer.MAX_VALUE;
                            for (HeartRateItemBean heartRateItemBean : items) {
                                if (heartRateItemBean.getHr() > 0) {
                                    if (heartRateItemBean.getHr() < i12) {
                                        i12 = heartRateItemBean.getHr();
                                    }
                                    i10 += heartRateItemBean.getHr();
                                    i3++;
                                }
                                if (heartRateItemBean.getHr() > i11) {
                                    i11 = heartRateItemBean.getHr();
                                }
                                HrData hrData = new HrData();
                                hrData.setCurrentTime(heartRateItemBean.getTimeMills());
                                hrData.setHr(heartRateItemBean.getHr());
                                arrayList.add(hrData);
                            }
                        } else {
                            i3 = 0;
                            i10 = 0;
                            i11 = 0;
                            i12 = Integer.MAX_VALUE;
                        }
                        if (i3 > 0) {
                            dataHeartRate.setAvgHr(i10 / i3);
                        }
                        if (i12 != Integer.MAX_VALUE) {
                            i13 = i12;
                        }
                        dataHeartRate.setMinHr(i13);
                        dataHeartRate.setMaxHr(i11);
                        dataHeartRate.setItems(com.example.baselibrary.utils.b.z(arrayList));
                        t8.add(dataHeartRate);
                    }
                    return Boolean.valueOf(HrImpl.INSTANCE.saveDatas(t8));
                }
            }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$hrCallback$2$1$onResult$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Boolean) obj2).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(1));
                }
            });
        }
    }
}
