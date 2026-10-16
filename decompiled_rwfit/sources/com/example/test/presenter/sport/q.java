package com.example.test.presenter.sport;

import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.example.blesdk.bean.sync.SportResultBean;
import com.example.database.db.SportImpl;
import com.example.database.table.DataSport;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.service.s0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.sport.activity.SportNewRecordActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.o1;
import com.tencent.connect.common.Constants;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class q implements v5.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f7626a;

    public q(r rVar) {
        this.f7626a = rVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SportNewRecordPresenter sport3ResultCallback", l0.k(i3, "运动列表运动同步失败[", "]"));
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == this) {
                    break;
                }
            }
            if (cVar != null) {
                linkedList.remove(cVar);
            }
        }
        r rVar = this.f7626a;
        Log.e("sport3ResultCallbackSaveData", "saveData " + com.example.baselibrary.utils.b.z(rVar.f7628c));
        ArrayList arrayList = rVar.f7628c;
        ((SportNewRecordActivity) ((i7.f) rVar.f7255a)).getClass();
        if (arrayList != null) {
            com.example.baselibrary.utils.b.x(arrayList, new oh.l() { // from class: com.example.test.presenter.sport.SportNewRecordPresenter$onSyncSportDb$1$1
                public final void invoke(List<SportResultBean> list) {
                    String str;
                    Devices c9;
                    User d5;
                    ArrayList t8 = android.support.v4.media.session.e.t("sportResults", list);
                    boolean z5 = false;
                    for (SportResultBean sportResultBean : list) {
                        DataSport dataSport = new DataSport();
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null && (d5 = kVar.d()) != null) {
                            dataSport.setUserId(d5.getUserId());
                        }
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        if (kVar2 != null && (c9 = kVar2.c()) != null) {
                            dataSport.setMac(c9.getMacAddress());
                        }
                        dataSport.setIsUpdate(false);
                        dataSport.setTimestamp(String.valueOf(sportResultBean.getStartTime()));
                        long startTime = sportResultBean.getStartTime() * 1000;
                        try {
                            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(startTime));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(startTime, " date translate error ", e.getMessage()));
                            str = null;
                        }
                        dataSport.setDate(str);
                        dataSport.setTotalDistances(String.valueOf(sportResultBean.getDistance()));
                        dataSport.setTotalSteps(String.valueOf(sportResultBean.getStep()));
                        dataSport.setTotalCalories(new BigDecimal(String.valueOf(sportResultBean.getCalorie())).divide(new BigDecimal(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)).toString());
                        dataSport.setTotalTimes(String.valueOf(sportResultBean.getExerciseTime()));
                        dataSport.setSportType(sportResultBean.getWorkModel());
                        dataSport.setAvgSteps(sportResultBean.getCadence());
                        dataSport.setMaxSteps(sportResultBean.getMaxCadence());
                        dataSport.setMinSteps(sportResultBean.getMinCadence());
                        dataSport.setSpeed(sportResultBean.getSpeed());
                        dataSport.setAvgPace(sportResultBean.getPace());
                        dataSport.setMaxPace(sportResultBean.getMaxPace());
                        dataSport.setMinPace(sportResultBean.getMinPace());
                        dataSport.setAvgHr(sportResultBean.getAverageHr());
                        dataSport.setMaxHr(sportResultBean.getMaxHr());
                        dataSport.setMinHr(sportResultBean.getMinHr());
                        dataSport.setFrom(1);
                        dataSport.setViewType(sportResultBean.getViewType());
                        dataSport.setIsNew(true);
                        dataSport.setNewSportHrs(sportResultBean.getNewSportHrs());
                        if (z5) {
                            t8.add(dataSport);
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            Object obj = s0.N;
                            List<LatLng> h4 = o1.a().h();
                            if (h4 != null) {
                                for (LatLng latLng : h4) {
                                    arrayList2.add(new h6.a(latLng.latitude, latLng.longitude));
                                }
                            }
                            dataSport.setLatLng(com.example.baselibrary.utils.b.z(arrayList2));
                            r5.a.h(dataSport.getViewType(), "onSyncSportDb viewType ", "qob");
                            Object obj2 = s0.N;
                            o1.a().h().clear();
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                            if (kVar3 != null) {
                                kVar3.b();
                            }
                            SportImpl.INSTANCE.saveData(dataSport);
                            z5 = true;
                        }
                    }
                    if (t8.isEmpty()) {
                        return;
                    }
                    SportImpl.INSTANCE.saveDatas(t8);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<SportResultBean>) obj);
                    return eh.g.f12633a;
                }
            }, new oh.l() { // from class: com.example.test.presenter.sport.SportNewRecordPresenter$onSyncSportDb$1$2
                public final void invoke(eh.g it2) {
                    kotlin.jvm.internal.e.f(it2, "it");
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((eh.g) obj);
                    return eh.g.f12633a;
                }
            });
        }
        ((XXBaseActivity) ((i7.f) rVar.f7255a)).b0();
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        SportResultBean data = (SportResultBean) obj;
        kotlin.jvm.internal.e.f(data, "data");
        r rVar = this.f7626a;
        synchronized (this) {
            try {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SportNewRecordPresenter sport3ResultCallback", "运动同步成功");
                Log.e("qob", "删除已同步的多运动3数据 deleteSportResultJL");
                if (r5.b.k().f18054c) {
                    x5.c.b().g((byte) 114, new byte[]{5, 28, 48}, new boolean[0]);
                } else {
                    x5.b.I0().F0((byte) 114);
                }
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SportNewRecordPresenter sport3ResultCallback", "运动数据[" + data + "]");
                if (data.isNewSportHrsData()) {
                    rVar.f7627b.setNewSportHrsData(true);
                    rVar.f7627b.setNewSportHrs(data.getNewSportHrs());
                    if (rVar.f7629d) {
                        rVar.f7629d = false;
                        rVar.f7628c.add(rVar.f7627b);
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SportNewRecordPresenter sport3ResultCallback", "获取运动数据出现异常，运动数据[" + data + "]");
                    }
                    rVar.f7627b = new SportResultBean();
                } else {
                    rVar.f7629d = true;
                    rVar.f7627b = data;
                }
                rVar.m();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
