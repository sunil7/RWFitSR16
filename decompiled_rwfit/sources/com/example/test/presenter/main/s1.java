package com.example.test.presenter.main;

import android.R;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.database.db.BloodOxygenImpl;
import com.example.database.db.BloodPressImpl;
import com.example.database.db.BloodSugarImpl;
import com.example.database.db.HrImpl;
import com.example.database.db.HrvImpl;
import com.example.database.db.PressureImpl;
import com.example.database.table.DataBloodOxygen;
import com.example.database.table.DataBloodPress;
import com.example.database.table.DataBloodSugar;
import com.example.database.table.DataHeartHrv;
import com.example.database.table.DataHeartRate;
import com.example.database.table.DataPressure;
import com.example.database.table.User;
import com.example.test.R$dimen;
import com.example.test.ui.adapter.TRingHealthDetailAdapter;
import com.example.test.ui.model.TRingBpModel;
import com.example.test.ui.model.TRingHealthItemModel;
import com.example.test.ui.model.chart.chart.BoData;
import com.example.test.ui.model.chart.chart.BpData;
import com.example.test.ui.model.chart.chart.HrData;
import com.example.test.ui.model.chart.chart.PressureData;
import com.example.test.ui.model.chart.chart.SugarData;
import com.example.test.ui.testui.TRingHealthDetailActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.collections.EmptyList;

/* loaded from: classes.dex */
public final class s1 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayBloodSugarHealthDetail$1
            @Override // oh.l
            public final List<TRingHealthItemModel> invoke(String it) {
                Date date2;
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                try {
                    date2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(it);
                } catch (Exception unused) {
                    date2 = null;
                }
                ArrayList arrayList = new ArrayList();
                if (date2 != null) {
                    long time = date2.getTime();
                    try {
                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                        str = null;
                    }
                    if (str != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d5 = kVar != null ? kVar.d() : null;
                        if (d5 != null) {
                            BloodSugarImpl bloodSugarImpl = BloodSugarImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            DataBloodSugar dataByDate = bloodSugarImpl.getDataByDate(g10, userId, str);
                            if (dataByDate != null) {
                                List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new g6.d().f3204b);
                                kotlin.jvm.internal.e.c(h4);
                                List list = EmptyList.INSTANCE;
                                for (Object obj : h4) {
                                    float sugar = ((SugarData) obj).getSugar();
                                    if (1.0f <= sugar && sugar <= 100.0f) {
                                        if (list.isEmpty()) {
                                            list = new ArrayList();
                                        }
                                        kotlin.jvm.internal.i.b(list).add(obj);
                                    }
                                }
                                int i3 = 0;
                                for (Object obj2 : list) {
                                    int i10 = i3 + 1;
                                    if (i3 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    SugarData sugarData = (SugarData) obj2;
                                    arrayList.add(new TRingHealthItemModel((int) (sugarData.getSugar() * 10), 4, sugarData.getCurrentTime()));
                                    i3 = i10;
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayBloodSugarHealthDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<TRingHealthItemModel>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<TRingHealthItemModel> it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (it.size() <= 0) {
                    ((TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a)).R0();
                    return;
                }
                TRingHealthDetailActivity tRingHealthDetailActivity = (TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a);
                tRingHealthDetailActivity.getClass();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                for (Object obj : it) {
                    int i10 = i3 + 1;
                    if (i3 < 0) {
                        kotlin.collections.i.f();
                        throw null;
                    }
                    TRingHealthItemModel tRingHealthItemModel = (TRingHealthItemModel) obj;
                    if (i3 == 0 || tRingHealthItemModel.getHealthTime() != it.get(i3 - 1).getHealthTime()) {
                        arrayList.add(obj);
                    }
                    i3 = i10;
                }
                eh.b bVar = tRingHealthDetailActivity.f7247z;
                ((f6.h0) bVar.getValue()).f12945b.setLayoutManager(new LinearLayoutManager(1));
                RecyclerView recyclerView = ((f6.h0) bVar.getValue()).f12945b;
                n.g0 g0Var = new n.g0(tRingHealthDetailActivity);
                g0Var.e(tRingHealthDetailActivity.getResources().getColor(R.color.transparent));
                g0Var.o(R$dimen.qb_px_10);
                recyclerView.g(g0Var.d());
                ((f6.h0) bVar.getValue()).f12945b.setAdapter(new TRingHealthDetailAdapter(arrayList));
                ((f6.h0) bVar.getValue()).f12945b.setItemAnimator(null);
                ((f6.h0) bVar.getValue()).f12946c.setVisibility(8);
            }
        });
    }

    public final void l(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayBoHealthDetail$1
            @Override // oh.l
            public final List<TRingHealthItemModel> invoke(String it) {
                Date date2;
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                try {
                    date2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(it);
                } catch (Exception unused) {
                    date2 = null;
                }
                ArrayList arrayList = new ArrayList();
                if (date2 != null) {
                    long time = date2.getTime();
                    try {
                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                        str = null;
                    }
                    if (str != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d5 = kVar != null ? kVar.d() : null;
                        if (d5 != null) {
                            BloodOxygenImpl bloodOxygenImpl = BloodOxygenImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            DataBloodOxygen dataByDate = bloodOxygenImpl.getDataByDate(g10, userId, str);
                            if (dataByDate != null) {
                                List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new g6.f().f3204b);
                                kotlin.jvm.internal.e.c(h4);
                                List list = EmptyList.INSTANCE;
                                for (Object obj : h4) {
                                    int bo = ((BoData) obj).getBo();
                                    if (1 <= bo && bo < 101) {
                                        if (list.isEmpty()) {
                                            list = new ArrayList();
                                        }
                                        kotlin.jvm.internal.i.b(list).add(obj);
                                    }
                                }
                                int i3 = 0;
                                for (Object obj2 : list) {
                                    int i10 = i3 + 1;
                                    if (i3 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    BoData boData = (BoData) obj2;
                                    arrayList.add(new TRingHealthItemModel(boData.getBo(), 1, boData.getCurrentTime()));
                                    i3 = i10;
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayBoHealthDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<TRingHealthItemModel>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<TRingHealthItemModel> it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (it.size() <= 0) {
                    ((TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a)).R0();
                    return;
                }
                TRingHealthDetailActivity tRingHealthDetailActivity = (TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a);
                tRingHealthDetailActivity.getClass();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                for (Object obj : it) {
                    int i10 = i3 + 1;
                    if (i3 < 0) {
                        kotlin.collections.i.f();
                        throw null;
                    }
                    TRingHealthItemModel tRingHealthItemModel = (TRingHealthItemModel) obj;
                    if (i3 == 0 || tRingHealthItemModel.getHealthTime() != it.get(i3 - 1).getHealthTime()) {
                        arrayList.add(obj);
                    }
                    i3 = i10;
                }
                eh.b bVar = tRingHealthDetailActivity.f7247z;
                ((f6.h0) bVar.getValue()).f12945b.setLayoutManager(new LinearLayoutManager(1));
                RecyclerView recyclerView = ((f6.h0) bVar.getValue()).f12945b;
                n.g0 g0Var = new n.g0(tRingHealthDetailActivity);
                g0Var.e(tRingHealthDetailActivity.getResources().getColor(R.color.transparent));
                g0Var.o(R$dimen.qb_px_10);
                recyclerView.g(g0Var.d());
                ((f6.h0) bVar.getValue()).f12945b.setAdapter(new TRingHealthDetailAdapter(arrayList));
                ((f6.h0) bVar.getValue()).f12945b.setItemAnimator(null);
                ((f6.h0) bVar.getValue()).f12946c.setVisibility(8);
            }
        });
    }

    public final void m(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayBpHealthDetail$1
            @Override // oh.l
            public final List<TRingBpModel> invoke(String it) {
                Date date2;
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                try {
                    date2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(it);
                } catch (Exception unused) {
                    date2 = null;
                }
                ArrayList arrayList = new ArrayList();
                if (date2 != null) {
                    long time = date2.getTime();
                    try {
                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                        str = null;
                    }
                    if (str != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d5 = kVar != null ? kVar.d() : null;
                        if (d5 != null) {
                            BloodPressImpl bloodPressImpl = BloodPressImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            DataBloodPress dataByDate = bloodPressImpl.getDataByDate(g10, userId, str);
                            if (dataByDate != null) {
                                List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new g6.h().f3204b);
                                kotlin.jvm.internal.e.c(h4);
                                List list = EmptyList.INSTANCE;
                                for (Object obj : h4) {
                                    int sp = ((BpData) obj).getSp();
                                    if (1 <= sp && sp < 10001) {
                                        if (list.isEmpty()) {
                                            list = new ArrayList();
                                        }
                                        kotlin.jvm.internal.i.b(list).add(obj);
                                    }
                                }
                                int i3 = 0;
                                for (Object obj2 : list) {
                                    int i10 = i3 + 1;
                                    if (i3 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    BpData bpData = (BpData) obj2;
                                    arrayList.add(new TRingBpModel(bpData.getSp(), bpData.getDp(), 5, bpData.getCurrentTime()));
                                    i3 = i10;
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayBpHealthDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<TRingBpModel>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<TRingBpModel> it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (it.size() <= 0) {
                    ((TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a)).R0();
                    return;
                }
                TRingHealthDetailActivity tRingHealthDetailActivity = (TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a);
                tRingHealthDetailActivity.getClass();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                for (Object obj : it) {
                    int i10 = i3 + 1;
                    if (i3 < 0) {
                        kotlin.collections.i.f();
                        throw null;
                    }
                    TRingBpModel tRingBpModel = (TRingBpModel) obj;
                    if (i3 == 0 || tRingBpModel.getHealthTime() != it.get(i3 - 1).getHealthTime()) {
                        arrayList.add(obj);
                    }
                    i3 = i10;
                }
                eh.b bVar = tRingHealthDetailActivity.f7247z;
                ((f6.h0) bVar.getValue()).f12945b.setLayoutManager(new LinearLayoutManager(1));
                RecyclerView recyclerView = ((f6.h0) bVar.getValue()).f12945b;
                n.g0 g0Var = new n.g0(tRingHealthDetailActivity);
                g0Var.e(tRingHealthDetailActivity.getResources().getColor(R.color.transparent));
                g0Var.o(R$dimen.qb_px_10);
                recyclerView.g(g0Var.d());
                ((f6.h0) bVar.getValue()).f12945b.setAdapter(new TRingHealthDetailAdapter(arrayList));
                ((f6.h0) bVar.getValue()).f12945b.setItemAnimator(null);
                ((f6.h0) bVar.getValue()).f12946c.setVisibility(8);
            }
        });
    }

    public final void n(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayHrHealthDetail$1
            @Override // oh.l
            public final List<TRingHealthItemModel> invoke(String it) {
                Date date2;
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                ArrayList arrayList = new ArrayList();
                try {
                    date2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(it);
                } catch (Exception unused) {
                    date2 = null;
                }
                if (date2 != null) {
                    long time = date2.getTime();
                    try {
                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                        str = null;
                    }
                    if (str != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d5 = kVar != null ? kVar.d() : null;
                        if (d5 != null) {
                            HrImpl hrImpl = HrImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            DataHeartRate dataByDate = hrImpl.getDataByDate(g10, userId, str);
                            if (dataByDate != null) {
                                List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new g6.j().f3204b);
                                Log.e("qob", "hrData " + dataByDate.getAvgHr() + " items " + dataByDate.getItems());
                                kotlin.jvm.internal.e.c(h4);
                                List list = EmptyList.INSTANCE;
                                for (Object obj : h4) {
                                    if (((HrData) obj).getHr() > 0) {
                                        if (list.isEmpty()) {
                                            list = new ArrayList();
                                        }
                                        kotlin.jvm.internal.i.b(list).add(obj);
                                    }
                                }
                                if (!list.isEmpty()) {
                                    int i3 = 0;
                                    for (Object obj2 : list) {
                                        int i10 = i3 + 1;
                                        if (i3 < 0) {
                                            kotlin.collections.i.f();
                                            throw null;
                                        }
                                        HrData hrData = (HrData) obj2;
                                        arrayList.add(new TRingHealthItemModel(hrData.getHr(), 0, hrData.getCurrentTime()));
                                        i3 = i10;
                                    }
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayHrHealthDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<TRingHealthItemModel>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<TRingHealthItemModel> it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (it.size() > 0) {
                    ((TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a)).S0(it);
                } else {
                    ((TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a)).R0();
                }
            }
        });
    }

    public final void o(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayHrvHealthDetail$1
            @Override // oh.l
            public final List<TRingHealthItemModel> invoke(String it) {
                Date date2;
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                ArrayList arrayList = new ArrayList();
                try {
                    date2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(it);
                } catch (Exception unused) {
                    date2 = null;
                }
                if (date2 != null) {
                    long time = date2.getTime();
                    try {
                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                        str = null;
                    }
                    if (str != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d5 = kVar != null ? kVar.d() : null;
                        if (d5 != null) {
                            HrvImpl hrvImpl = HrvImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            DataHeartHrv dataByDate = hrvImpl.getDataByDate(g10, userId, str);
                            if (dataByDate != null) {
                                List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new g6.l().f3204b);
                                Log.e("qob", "hrData " + dataByDate.getAvgHr() + " items " + dataByDate.getItems());
                                kotlin.jvm.internal.e.c(h4);
                                List list = EmptyList.INSTANCE;
                                for (Object obj : h4) {
                                    if (((HrData) obj).getHr() > 0) {
                                        if (list.isEmpty()) {
                                            list = new ArrayList();
                                        }
                                        kotlin.jvm.internal.i.b(list).add(obj);
                                    }
                                }
                                if (!list.isEmpty()) {
                                    int i3 = 0;
                                    for (Object obj2 : list) {
                                        int i10 = i3 + 1;
                                        if (i3 < 0) {
                                            kotlin.collections.i.f();
                                            throw null;
                                        }
                                        HrData hrData = (HrData) obj2;
                                        arrayList.add(new TRingHealthItemModel(hrData.getHr(), 2, hrData.getCurrentTime()));
                                        i3 = i10;
                                    }
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayHrvHealthDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<TRingHealthItemModel>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<TRingHealthItemModel> it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (it.size() > 0) {
                    ((TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a)).S0(it);
                } else {
                    ((TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a)).R0();
                }
            }
        });
    }

    public final void p(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayStressHealthDetail$1
            @Override // oh.l
            public final List<TRingHealthItemModel> invoke(String it) {
                Date date2;
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                try {
                    date2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(it);
                } catch (Exception unused) {
                    date2 = null;
                }
                ArrayList arrayList = new ArrayList();
                if (date2 != null) {
                    long time = date2.getTime();
                    try {
                        str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                        str = null;
                    }
                    if (str != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        User d5 = kVar != null ? kVar.d() : null;
                        if (d5 != null) {
                            PressureImpl pressureImpl = PressureImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            DataPressure dataByDate = pressureImpl.getDataByDate(g10, userId, str);
                            if (dataByDate != null) {
                                List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new g6.q().f3204b);
                                kotlin.jvm.internal.e.c(h4);
                                List list = EmptyList.INSTANCE;
                                for (Object obj : h4) {
                                    int pressure = ((PressureData) obj).getPressure();
                                    if (1 <= pressure && pressure < 161) {
                                        if (list.isEmpty()) {
                                            list = new ArrayList();
                                        }
                                        kotlin.jvm.internal.i.b(list).add(obj);
                                    }
                                }
                                int i3 = 0;
                                for (Object obj2 : list) {
                                    int i10 = i3 + 1;
                                    if (i3 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    PressureData pressureData = (PressureData) obj2;
                                    arrayList.add(new TRingHealthItemModel(pressureData.getPressure(), 3, pressureData.getCurrentTime()));
                                    i3 = i10;
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.TRingHealthDetailPresenter$getDayStressHealthDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<TRingHealthItemModel>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<TRingHealthItemModel> it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (it.size() <= 0) {
                    ((TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a)).R0();
                    return;
                }
                TRingHealthDetailActivity tRingHealthDetailActivity = (TRingHealthDetailActivity) ((com.example.test.ui.testui.y) s1.this.f7255a);
                tRingHealthDetailActivity.getClass();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                for (Object obj : it) {
                    int i10 = i3 + 1;
                    if (i3 < 0) {
                        kotlin.collections.i.f();
                        throw null;
                    }
                    TRingHealthItemModel tRingHealthItemModel = (TRingHealthItemModel) obj;
                    if (i3 == 0 || tRingHealthItemModel.getHealthTime() != it.get(i3 - 1).getHealthTime()) {
                        arrayList.add(obj);
                    }
                    i3 = i10;
                }
                eh.b bVar = tRingHealthDetailActivity.f7247z;
                ((f6.h0) bVar.getValue()).f12945b.setLayoutManager(new LinearLayoutManager(1));
                RecyclerView recyclerView = ((f6.h0) bVar.getValue()).f12945b;
                n.g0 g0Var = new n.g0(tRingHealthDetailActivity);
                g0Var.e(tRingHealthDetailActivity.getResources().getColor(R.color.transparent));
                g0Var.o(R$dimen.qb_px_10);
                recyclerView.g(g0Var.d());
                ((f6.h0) bVar.getValue()).f12945b.setAdapter(new TRingHealthDetailAdapter(arrayList));
                ((f6.h0) bVar.getValue()).f12945b.setItemAnimator(null);
                ((f6.h0) bVar.getValue()).f12946c.setVisibility(8);
            }
        });
    }
}
