package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.database.db.HrvImpl;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataHeartHrv;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.chart.chart.HrChartData;
import com.example.test.ui.model.chart.chart.HrData;
import com.github.mikephil.charting.data.EntryDate;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.collections.EmptyList;

/* loaded from: classes.dex */
public final class u0 extends com.example.baselibrary.preseneter.b implements v5.g0 {

    /* renamed from: b, reason: collision with root package name */
    public int f7568b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7569c;

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f7570d;
    public DrinkReminderBean e;

    /* renamed from: f, reason: collision with root package name */
    public final eh.b f7571f;

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f7572g;

    public u0(g7.o oVar) {
        super(oVar);
        this.f7569c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.HeartRatePresenter$settingHrvCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final s0 invoke() {
                return new s0(u0.this);
            }
        });
        this.f7570d = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.HeartRatePresenter$testHrCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final t0 invoke() {
                return new t0(u0.this);
            }
        });
        this.f7571f = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.HeartRatePresenter$hrCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final q0 invoke() {
                return new q0(u0.this);
            }
        });
        this.f7572g = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.HeartRatePresenter$hrvCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final r0 invoke() {
                return new r0(u0.this);
            }
        });
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "HeartRatePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "errorCode = "));
        ((XXBaseActivity) ((g7.o) this.f7255a)).b0();
    }

    @Override // u5.g
    public final void c() {
        Log.e("qob", "HeartRatePresenter onSuccess");
        DrinkReminderBean drinkReminderBean = this.e;
        if (drinkReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(drinkReminderBean, new HeartRatePresenter$saveDB$1$1(this), new HeartRatePresenter$saveDB$1$2(this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u5.g
    public final void e(Object obj) {
        DrinkReminderBean drinkReminderBean = (DrinkReminderBean) obj;
        Log.e("qob", "HeartRatePresenter onResult");
        g7.o oVar = (g7.o) this.f7255a;
        ((XXBaseActivity) oVar).b0();
        if (drinkReminderBean != null) {
            oVar.c(drinkReminderBean);
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d(this);
        com.google.android.gms.internal.mlkit_vision_common.p.d((t0) this.f7570d.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((s0) this.f7569c.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((q0) this.f7571f.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((r0) this.f7572g.getValue());
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.HeartRatePresenter$initData$1
            {
                super(1);
            }

            @Override // oh.l
            public final DataSetting invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 == null) {
                    return null;
                }
                u0 u0Var = u0.this;
                SettingImpl settingImpl = SettingImpl.INSTANCE;
                String userId = d5.getUserId();
                String str = android.support.v4.media.session.e.y(userId, "getUserId(...)").f18212c;
                kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                return settingImpl.getData(userId, str, u0Var.f7568b == 1 ? "setting_hrv_watcher" : "setting_hr_watcher");
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HeartRatePresenter$initData$2

            public static final class a extends bc.a<DrinkReminderBean> {
            }

            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DataSetting) obj);
                return eh.g.f12633a;
            }

            public final void invoke(DataSetting dataSetting) {
                if (dataSetting != null) {
                    u0 u0Var = u0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((g7.o) u0Var.f7255a).c((DrinkReminderBean) g10);
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        com.google.android.gms.internal.mlkit_vision_common.p.U((t0) this.f7570d.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.U((s0) this.f7569c.getValue());
        ((XXBaseActivity) ((g7.o) this.f7255a)).V();
        if (this.f7568b == 0) {
            com.google.android.gms.internal.mlkit_vision_common.p.o();
        } else {
            com.google.android.gms.internal.mlkit_vision_common.p.n();
        }
    }

    public final void l(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.HeartRatePresenter$getDayHrDetail$1
            @Override // oh.l
            public final HrChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return com.example.test.presenter.analysis.a.d(it);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HeartRatePresenter$getDayHrDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HrChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HrChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.o) u0.this.f7255a).F(it);
            }
        });
    }

    public final void m(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.HeartRatePresenter$getDayHvrDetail$1
            @Override // oh.l
            public final HrChartData invoke(String it) {
                Date date2;
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                HrChartData hrChartData = new HrChartData();
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
                            ArrayList arrayList = new ArrayList();
                            if (dataByDate != null) {
                                List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new g6.k().f3204b);
                                Log.e("qob", "hrvData " + dataByDate.getAvgHr() + " items " + dataByDate.getItems());
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
                                    hrChartData.setCurrentHr(((HrData) com.google.android.gms.internal.mlkit_vision_barcode.l0.g(1, list)).getHr());
                                    int i3 = 0;
                                    long j4 = 1000;
                                    hrChartData.setStartTime(ca.i(((HrData) list.get(0)).getCurrentTime() * j4, "HH:mm"));
                                    hrChartData.setEndTime(ca.i(((HrData) list.get(list.size() - 1)).getCurrentTime() * j4, "HH:mm"));
                                    for (Object obj2 : list) {
                                        int i10 = i3 + 1;
                                        if (i3 < 0) {
                                            kotlin.collections.i.f();
                                            throw null;
                                        }
                                        arrayList.add(new EntryDate(i3, r4.getHr(), ((HrData) obj2).getCurrentTime()));
                                        i3 = i10;
                                    }
                                }
                                hrChartData.setMaxHr(dataByDate.getMaxHr());
                                hrChartData.setMinHr(dataByDate.getMinHr());
                                hrChartData.setAvgHr(dataByDate.getAvgHr());
                            }
                            hrChartData.setItems(arrayList);
                        }
                    }
                }
                return hrChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.HeartRatePresenter$getDayHvrDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HrChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(HrChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.o) u0.this.f7255a).F(it);
            }
        });
    }

    public final void n(byte b3) {
        if (this.f7568b == 0) {
            if (!r5.b.k().f18054c) {
                x5.b.I0().F0((byte) 31);
                return;
            }
            x5.c b10 = x5.c.b();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(b3, "getControlHealthDataCmdJL 3 "));
            b10.g((byte) 31, new byte[]{6, 9, 0, 3, 5, b3}, new boolean[0]);
            return;
        }
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 31);
            return;
        }
        x5.c b11 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(b3, "getControlHealthDataCmdJL 10 "));
        b11.g((byte) 31, new byte[]{6, 9, 0, 10, 5, b3}, new boolean[0]);
    }
}
