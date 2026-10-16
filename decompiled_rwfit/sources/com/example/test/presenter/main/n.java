package com.example.test.presenter.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$color;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.chart.chart.BpChartData;
import com.example.test.ui.testui.TRingBloodPressureStatisticsActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet$Mode;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class n extends com.example.baselibrary.preseneter.b implements v5.e0 {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7536b;

    /* renamed from: c, reason: collision with root package name */
    public DrinkReminderBean f7537c;

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f7538d;

    public n(TRingBloodPressureStatisticsActivity tRingBloodPressureStatisticsActivity) {
        super(tRingBloodPressureStatisticsActivity);
        this.f7536b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.BloodPressurePresenter$testHrCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final m invoke() {
                return new m(n.this);
            }
        });
        this.f7538d = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.BloodPressurePresenter$boCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final l invoke() {
                return new l(n.this);
            }
        });
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "HrWatcherJlPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "errorCode = "));
        ((XXBaseActivity) ((g7.g) this.f7255a)).b0();
    }

    @Override // u5.g
    public final void c() {
        DrinkReminderBean drinkReminderBean = this.f7537c;
        if (drinkReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(drinkReminderBean, new oh.l() { // from class: com.example.test.presenter.main.BloodPressurePresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(DrinkReminderBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_bo_watcher");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(it));
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    User d5 = kVar != null ? kVar.d() : null;
                    if (d5 != null) {
                        dataSetting.setUserId(d5.getUserId());
                    }
                    return Long.valueOf(SettingImpl.INSTANCE.saveData(dataSetting));
                }
            }, new oh.l() { // from class: com.example.test.presenter.main.BloodPressurePresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((g7.g) n.this.f7255a)).b0();
                    if (j4 > 0) {
                        ((g7.g) n.this.f7255a).getClass();
                    } else {
                        ((g7.g) n.this.f7255a).getClass();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        DrinkReminderBean drinkReminderBean = (DrinkReminderBean) obj;
        Object obj2 = (g7.g) this.f7255a;
        ((XXBaseActivity) obj2).b0();
        if (drinkReminderBean != null) {
            ((TRingBloodPressureStatisticsActivity) obj2).c(drinkReminderBean);
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d(this);
        com.google.android.gms.internal.mlkit_vision_common.p.d((m) this.f7536b.getValue());
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.BloodPressurePresenter$initData$1
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
                SettingImpl settingImpl = SettingImpl.INSTANCE;
                String userId = d5.getUserId();
                String str = android.support.v4.media.session.e.y(userId, "getUserId(...)").f18212c;
                kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                return settingImpl.getData(userId, str, "setting_bo_watcher");
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BloodPressurePresenter$initData$2

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
                    n nVar = n.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((TRingBloodPressureStatisticsActivity) ((g7.g) nVar.f7255a)).c((DrinkReminderBean) g10);
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        ((XXBaseActivity) ((g7.g) this.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.l();
    }

    public final void l(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.BloodPressurePresenter$getDayBoDetail$1
            @Override // oh.l
            public final BpChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return com.example.test.presenter.analysis.a.c(it);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BloodPressurePresenter$getDayBoDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BpChartData) obj);
                return eh.g.f12633a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v46 */
            /* JADX WARN: Type inference failed for: r4v47, types: [o7.h] */
            /* JADX WARN: Type inference failed for: r4v49 */
            /* JADX WARN: Type inference failed for: r4v50, types: [o7.d] */
            /* JADX WARN: Type inference failed for: r4v82 */
            /* JADX WARN: Type inference failed for: r4v83 */
            public final void invoke(BpChartData it) {
                TextView textView;
                String str;
                f6.i iVar;
                f6.i iVar2;
                int i3;
                Entry entry;
                Entry entry2;
                List<Entry> itemSps;
                Object obj;
                Object obj2;
                Entry entry3;
                Entry entry4;
                List<Entry> itemSps2;
                Object obj3;
                Object obj4;
                Entry entry5;
                Entry entry6;
                List<Entry> itemSps3;
                Object obj5;
                Object obj6;
                kotlin.jvm.internal.e.f(it, "it");
                TRingBloodPressureStatisticsActivity tRingBloodPressureStatisticsActivity = (TRingBloodPressureStatisticsActivity) ((g7.g) n.this.f7255a);
                tRingBloodPressureStatisticsActivity.getClass();
                eh.b bVar = tRingBloodPressureStatisticsActivity.F;
                int intValue = ((Number) bVar.getValue()).intValue();
                eh.b bVar2 = tRingBloodPressureStatisticsActivity.f7247z;
                int i10 = 0;
                if (intValue == 0) {
                    List<Entry> itemDps = it.getItemDps();
                    if (itemDps != null) {
                        Iterator it2 = itemDps.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj6 = null;
                                break;
                            } else {
                                obj6 = it2.next();
                                if (((Entry) obj6).d() > 0.0f) {
                                    break;
                                }
                            }
                        }
                        entry5 = (Entry) obj6;
                    } else {
                        entry5 = null;
                    }
                    List<Entry> itemSps4 = it.getItemSps();
                    if (itemSps4 != null) {
                        Iterator it3 = itemSps4.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj5 = null;
                                break;
                            } else {
                                obj5 = it3.next();
                                if (((Entry) obj5).d() > 0.0f) {
                                    break;
                                }
                            }
                        }
                        entry6 = (Entry) obj5;
                    } else {
                        entry6 = null;
                    }
                    List<Entry> itemDps2 = it.getItemDps();
                    if (itemDps2 == null || itemDps2.isEmpty() || (itemSps3 = it.getItemSps()) == null || itemSps3.isEmpty() || entry5 == null || entry6 == null) {
                        f6.i iVar3 = (f6.i) bVar2.getValue();
                        LinearLayout linearLayout = iVar3 != null ? iVar3.e : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                    } else {
                        f6.i iVar4 = (f6.i) bVar2.getValue();
                        LinearLayout linearLayout2 = iVar4 != null ? iVar4.e : null;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(0);
                        }
                    }
                }
                f6.i iVar5 = (f6.i) bVar2.getValue();
                if (iVar5 != null) {
                    LineChart lineChart = iVar5.f12959b;
                    if (lineChart.getData() == null || ((o7.j) lineChart.getData()).c() <= 0) {
                        List<Entry> itemDps3 = it.getItemDps();
                        if (itemDps3 != null) {
                            Iterator it4 = itemDps3.iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    obj2 = null;
                                    break;
                                } else {
                                    obj2 = it4.next();
                                    if (((Entry) obj2).d() > 0.0f) {
                                        break;
                                    }
                                }
                            }
                            entry = (Entry) obj2;
                        } else {
                            entry = null;
                        }
                        List<Entry> itemSps5 = it.getItemSps();
                        if (itemSps5 != null) {
                            Iterator it5 = itemSps5.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    obj = null;
                                    break;
                                } else {
                                    obj = it5.next();
                                    if (((Entry) obj).d() > 0.0f) {
                                        break;
                                    }
                                }
                            }
                            entry2 = (Entry) obj;
                        } else {
                            entry2 = null;
                        }
                        List<Entry> itemDps4 = it.getItemDps();
                        if (itemDps4 == null || itemDps4.isEmpty() || (itemSps = it.getItemSps()) == null || itemSps.isEmpty()) {
                            textView = null;
                        } else if (entry == null || entry2 == null) {
                            textView = null;
                        } else {
                            o7.k kVar = new o7.k(it.getItemSps());
                            LineDataSet$Mode lineDataSet$Mode = LineDataSet$Mode.CUBIC_BEZIER;
                            kVar.B = lineDataSet$Mode;
                            kVar.G = 0.2f;
                            kVar.A = true;
                            kVar.I = false;
                            kVar.f16824t = android.support.v4.media.session.e.a(kVar, 244, 117, 117);
                            kVar.l(tRingBloodPressureStatisticsActivity.getResources().getColor(R$color.color_D84D2B));
                            kVar.f16837x = tRingBloodPressureStatisticsActivity.getResources().getColor(R$color.color_D84D2B);
                            kVar.f16838y = 60;
                            kVar.f16835v = false;
                            kVar.H = new com.example.test.ui.sport.activity.l(lineChart, 3);
                            o7.k kVar2 = new o7.k(it.getItemDps());
                            kVar2.B = lineDataSet$Mode;
                            kVar2.G = 0.2f;
                            kVar2.A = true;
                            kVar2.I = false;
                            kVar2.f16824t = android.support.v4.media.session.e.a(kVar2, 244, 117, 117);
                            kVar2.l(tRingBloodPressureStatisticsActivity.getResources().getColor(R$color.color_6E600));
                            kVar2.f16837x = tRingBloodPressureStatisticsActivity.getResources().getColor(R$color.color_6E600);
                            kVar2.f16838y = 60;
                            kVar2.f16835v = false;
                            kVar2.H = new com.example.test.ui.sport.activity.l(lineChart, 4);
                            o7.j jVar = new o7.j(kVar, kVar2);
                            jVar.j();
                            jVar.i();
                            lineChart.setData(jVar);
                            textView = null;
                        }
                        lineChart.setData(textView);
                        lineChart.n();
                    } else {
                        List<Entry> itemDps5 = it.getItemDps();
                        if (itemDps5 != null) {
                            Iterator it6 = itemDps5.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    obj4 = null;
                                    break;
                                } else {
                                    obj4 = it6.next();
                                    if (((Entry) obj4).d() > 0.0f) {
                                        break;
                                    }
                                }
                            }
                            entry3 = (Entry) obj4;
                        } else {
                            entry3 = null;
                        }
                        List<Entry> itemSps6 = it.getItemSps();
                        if (itemSps6 != null) {
                            Iterator it7 = itemSps6.iterator();
                            while (true) {
                                if (!it7.hasNext()) {
                                    obj3 = null;
                                    break;
                                } else {
                                    obj3 = it7.next();
                                    if (((Entry) obj3).d() > 0.0f) {
                                        break;
                                    }
                                }
                            }
                            entry4 = (Entry) obj3;
                        } else {
                            entry4 = null;
                        }
                        List<Entry> itemDps6 = it.getItemDps();
                        if (itemDps6 == null || itemDps6.isEmpty() || (itemSps2 = it.getItemSps()) == null || itemSps2.isEmpty() || entry3 == null || entry4 == null) {
                            lineChart.setData(null);
                        } else {
                            o7.d b3 = ((o7.j) lineChart.getData()).b(0);
                            kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
                            ((o7.k) b3).m(it.getItemSps());
                            o7.d b10 = ((o7.j) lineChart.getData()).b(1);
                            kotlin.jvm.internal.e.d(b10, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
                            ((o7.k) b10).m(it.getItemDps());
                            ((o7.j) lineChart.getData()).a();
                        }
                        lineChart.n();
                        textView = null;
                    }
                    lineChart.invalidate();
                    f6.i iVar6 = (f6.i) bVar2.getValue();
                    ?? r42 = iVar6 != null ? (o7.j) iVar6.f12959b.getData() : textView;
                    if (r42 != 0 && r42.c() != 0) {
                        o7.d b11 = r42.b(0);
                        ?? r43 = b11 instanceof o7.k ? (o7.k) b11 : textView;
                        if (r43 != 0 && r43.f16820o.size() != 0) {
                            Entry g10 = r43.g(r43.f16820o.size() - 1);
                            float j4 = g10.j();
                            float d5 = g10.d();
                            q7.c cVar = new q7.c();
                            cVar.f17802g = -1;
                            cVar.f17797a = j4;
                            cVar.f17798b = d5;
                            cVar.f17801f = 0;
                            cVar.e = -1;
                            f6.i iVar7 = (f6.i) bVar2.getValue();
                            if (iVar7 != null) {
                                iVar7.f12959b.l(cVar);
                            }
                        }
                    }
                } else {
                    textView = null;
                }
                if (it.getCurrentSp() == 0) {
                    str = "-- / --";
                } else {
                    str = it.getCurrentSp() + "/" + it.getCurrentDp();
                }
                f6.i iVar8 = (f6.i) bVar2.getValue();
                TextView textView2 = iVar8 != null ? iVar8.f12968l : textView;
                if (textView2 != null) {
                    textView2.setText(str);
                }
                if (it.getCurrentSp() > 0) {
                    f6.i iVar9 = (f6.i) bVar2.getValue();
                    TextView textView3 = iVar9 != null ? iVar9.f12970n : textView;
                    if (textView3 != null) {
                        textView3.setText(String.valueOf(it.getCurrentSp()));
                    }
                }
                if (it.getCurrentDp() > 0) {
                    f6.i iVar10 = (f6.i) bVar2.getValue();
                    TextView textView4 = iVar10 != null ? iVar10.f12967k : textView;
                    if (textView4 != null) {
                        textView4.setText(String.valueOf(it.getCurrentDp()));
                    }
                }
                if (it.getCurrentSp() > 0 && it.getCurrentDp() > 0) {
                    int currentSp = it.getCurrentSp();
                    int currentDp = it.getCurrentDp();
                    if (currentSp < 90 || currentDp < 60) {
                        i3 = R$string.bp_level_low;
                    } else if (currentSp < 140 || currentDp >= 90) {
                        int i11 = (120 > currentSp || currentSp >= 140) ? (140 > currentSp || currentSp >= 160) ? (160 > currentSp || currentSp >= 180) ? currentSp >= 180 ? 4 : 0 : 3 : 2 : 1;
                        if (80 <= currentDp && currentDp < 90) {
                            i10 = 1;
                        } else if (90 <= currentDp && currentDp < 100) {
                            i10 = 2;
                        } else if (100 <= currentDp && currentDp < 110) {
                            i10 = 3;
                        } else if (currentDp >= 110) {
                            i10 = 4;
                        }
                        int max = Math.max(i11, i10);
                        i3 = max != 0 ? max != 1 ? max != 2 ? max != 3 ? max != 4 ? R$string.bp_level_normal : R$string.bp_level_high_3 : R$string.bp_level_high_2 : R$string.bp_level_high_1 : R$string.bp_level_normal_high : R$string.bp_level_normal;
                    } else {
                        i3 = R$string.bp_level_isolated_systolic;
                    }
                    f6.i iVar11 = (f6.i) bVar2.getValue();
                    if (iVar11 != null) {
                        iVar11.f12969m.setText(i3);
                    }
                }
                if (((Number) bVar.getValue()).intValue() == 0) {
                    f6.i iVar12 = (f6.i) bVar2.getValue();
                    TextView textView5 = iVar12 != null ? iVar12.f12965i : textView;
                    if (textView5 != null) {
                        textView5.setText("00:00");
                    }
                    f6.i iVar13 = (f6.i) bVar2.getValue();
                    TextView textView6 = iVar13 != null ? iVar13.f12960c : textView;
                    if (textView6 != null) {
                        textView6.setText("24:00");
                    }
                    String startTime = it.getStartTime();
                    if (startTime != null && (iVar2 = (f6.i) bVar2.getValue()) != null) {
                        iVar2.f12965i.setText(startTime);
                    }
                    String endTime = it.getEndTime();
                    if (endTime == null || (iVar = (f6.i) bVar2.getValue()) == null) {
                        return;
                    }
                    iVar.f12960c.setText(endTime);
                }
            }
        });
    }

    public final void m(byte b3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 31);
            return;
        }
        x5.c b10 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(b3, "getControlHealthDataCmdJL 4 "));
        b10.g((byte) 31, new byte[]{6, 9, 0, 4, 5, b3}, new boolean[0]);
    }
}
