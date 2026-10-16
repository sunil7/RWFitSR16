package com.example.test.presenter.sport;

import android.util.Log;
import com.example.database.db.SportImpl;
import com.example.database.table.DataSport;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.ui.sport.activity.SportRecordActivity;
import com.example.test.ui.sport.model.SportRecordModel;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import f6.e2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class w extends com.example.baselibrary.preseneter.b {

    /* renamed from: b, reason: collision with root package name */
    public final String f7635b;

    public w(SportRecordActivity sportRecordActivity) {
        super(sportRecordActivity);
        this.f7635b = "SportRecordPresenter";
        kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.sport.SportRecordPresenter$sportCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final v invoke() {
                return new v(w.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.sport.SportRecordPresenter$getSportData$1
            @Override // oh.l
            public final List<SportRecordModel> invoke(String it) {
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                ArrayList arrayList = new ArrayList();
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    Devices c9 = kVar2 != null ? kVar2.c() : null;
                    if (c9 != null) {
                        SportImpl sportImpl = SportImpl.INSTANCE;
                        String userId = d5.getUserId();
                        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                        String macAddress = c9.getMacAddress();
                        kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
                        List<DataSport> allData = sportImpl.getAllData(userId, macAddress);
                        if (allData != null) {
                            for (DataSport dataSport : allData) {
                                String timestamp = dataSport.getTimestamp();
                                kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                                long parseLong = Long.parseLong(timestamp) * 1000;
                                try {
                                    str = new SimpleDateFormat("yyyy/MM", Locale.ENGLISH).format(Long.valueOf(parseLong));
                                } catch (Exception e) {
                                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(parseLong, " date translate error ", e.getMessage()));
                                    str = null;
                                }
                                if (!y5.d.f20005b) {
                                    if (arrayList.isEmpty()) {
                                        arrayList.add(new SportRecordModel(0, str));
                                    } else if (str != null && str.length() != 0 && !str.equals(((SportRecordModel) l0.h(1, arrayList)).getDate())) {
                                        arrayList.add(new SportRecordModel(0, str));
                                    }
                                }
                                h6.b bVar = new h6.b();
                                Log.e("qob", "getSportData viewType " + dataSport.getViewType());
                                Long id2 = dataSport.getId();
                                kotlin.jvm.internal.e.e(id2, "getId(...)");
                                bVar.f14266a = id2.longValue();
                                bVar.f14267b = dataSport.getSportType();
                                String totalCalories = dataSport.getTotalCalories();
                                kotlin.jvm.internal.e.e(totalCalories, "getTotalCalories(...)");
                                bVar.f14271g = Double.parseDouble(totalCalories);
                                String totalDistances = dataSport.getTotalDistances();
                                kotlin.jvm.internal.e.e(totalDistances, "getTotalDistances(...)");
                                bVar.f14268c = Double.parseDouble(totalDistances);
                                String totalSteps = dataSport.getTotalSteps();
                                kotlin.jvm.internal.e.e(totalSteps, "getTotalSteps(...)");
                                bVar.f14270f = Long.parseLong(totalSteps);
                                String totalTimes = dataSport.getTotalTimes();
                                kotlin.jvm.internal.e.e(totalTimes, "getTotalTimes(...)");
                                bVar.e = Long.parseLong(totalTimes);
                                String timestamp2 = dataSport.getTimestamp();
                                kotlin.jvm.internal.e.e(timestamp2, "getTimestamp(...)");
                                bVar.f14269d = Long.parseLong(timestamp2);
                                if (y5.d.f20005b) {
                                    bVar.f14280p = dataSport.getAvgSteps();
                                    bVar.f14281q = dataSport.getMaxSteps();
                                    bVar.r = dataSport.getMinSteps();
                                    dataSport.getSpeed();
                                    bVar.f14277m = dataSport.getAvgPace();
                                    bVar.f14278n = dataSport.getMaxPace();
                                    bVar.f14279o = dataSport.getMinPace();
                                    bVar.f14282s = dataSport.getAvgHr();
                                    bVar.f14283t = dataSport.getMaxHr();
                                    bVar.f14284u = dataSport.getMinHr();
                                    bVar.f14288y = dataSport.getViewType();
                                }
                                bVar.f14287x = dataSport.getFrom();
                                SportRecordModel sportRecordModel = new SportRecordModel(1, str);
                                sportRecordModel.setDetailBean(bVar);
                                Long id3 = dataSport.getId();
                                kotlin.jvm.internal.e.e(id3, "getId(...)");
                                sportRecordModel.setId(id3.longValue());
                                arrayList.add(sportRecordModel);
                            }
                        }
                    }
                }
                return arrayList;
            }
        }, new oh.l() { // from class: com.example.test.presenter.sport.SportRecordPresenter$getSportData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<SportRecordModel>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<SportRecordModel> it) {
                kotlin.jvm.internal.e.f(it, "it");
                SportRecordActivity sportRecordActivity = (SportRecordActivity) ((i7.h) w.this.f7255a);
                sportRecordActivity.getClass();
                sportRecordActivity.R0().clear();
                kotlin.collections.n.i(sportRecordActivity.R0(), it);
                sportRecordActivity.S0().notifyDataSetChanged();
                int size = sportRecordActivity.R0().size();
                eh.b bVar = sportRecordActivity.f7247z;
                if (size > 0) {
                    ((e2) bVar.getValue()).f12825b.setVisibility(8);
                } else {
                    ((e2) bVar.getValue()).f12825b.setVisibility(0);
                }
            }
        });
    }
}
