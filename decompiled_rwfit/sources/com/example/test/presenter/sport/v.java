package com.example.test.presenter.sport;

import com.example.blesdk.bean.sync.SportResultBean;
import com.example.blesdk.bean.sync.SportSyncBean;
import com.example.database.db.SportImpl;
import com.example.database.table.DataSport;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class v implements v5.s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f7634a;

    public v(w wVar) {
        this.f7634a = wVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, this.f7634a.f7635b, l0.k(i3, "运动同步失败[", "]"));
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
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        SportSyncBean data = (SportSyncBean) obj;
        kotlin.jvm.internal.e.f(data, "data");
        w wVar = this.f7634a;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, wVar.f7635b, "运动同步成功");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, wVar.f7635b, "运动数据[" + data + "]");
        com.example.baselibrary.utils.b.x(data.getResultItems(), new oh.l() { // from class: com.example.test.presenter.sport.SportRecordPresenter$sportCallback$2$1$onResult$2$1
            @Override // oh.l
            public final Boolean invoke(List<SportResultBean> list) {
                String str;
                Devices c9;
                User d5;
                ArrayList arrayList = new ArrayList();
                kotlin.jvm.internal.e.c(list);
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
                    dataSport.setTotalCalories(String.valueOf(sportResultBean.getCalorie()));
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
                    arrayList.add(dataSport);
                }
                return Boolean.valueOf(SportImpl.INSTANCE.saveDatas(arrayList));
            }
        }, new oh.l() { // from class: com.example.test.presenter.sport.SportRecordPresenter$sportCallback$2$1$onResult$2$2
            public final void invoke(boolean z5) {
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke(((Boolean) obj2).booleanValue());
                return eh.g.f12633a;
            }
        });
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
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }
}
