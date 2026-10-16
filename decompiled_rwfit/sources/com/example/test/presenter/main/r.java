package com.example.test.presenter.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$color;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.chart.chart.SugarChartData;
import com.example.test.ui.testui.TRingBloodSugarStatisticsActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet$Mode;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class r extends com.example.baselibrary.preseneter.b {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7550b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7551c;

    /* renamed from: d, reason: collision with root package name */
    public DrinkReminderBean f7552d;
    public final eh.b e;

    public r(TRingBloodSugarStatisticsActivity tRingBloodSugarStatisticsActivity) {
        super(tRingBloodSugarStatisticsActivity);
        this.f7550b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$settingBloodSugarCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final p invoke() {
                return new p(r.this);
            }
        });
        this.f7551c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$testHrCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final q invoke() {
                return new q(r.this);
            }
        });
        this.e = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$bloodSugarCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final o invoke() {
                return new o(r.this);
            }
        });
    }

    public static void m(byte b3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 31);
            return;
        }
        x5.c b10 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(b3, "getControlHealthDataCmdJL 16 "));
        b10.g((byte) 31, new byte[]{6, 9, 0, 16, 5, b3}, new boolean[0]);
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d((q) this.f7551c.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((p) this.f7550b.getValue());
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_bloodsugar_watcher");
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$initData$2

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
                    r rVar = r.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((TRingBloodSugarStatisticsActivity) ((g7.h) rVar.f7255a)).c((DrinkReminderBean) g10);
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U((q) this.f7551c.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.U((p) this.f7550b.getValue());
        ((XXBaseActivity) ((g7.h) this.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.m();
    }

    public final void l(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$getDayBloodSugarDetail$1
            @Override // oh.l
            public final SugarChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return com.example.test.presenter.analysis.a.a(it);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BloodSugarStatisticsPresenter$getDayBloodSugarDetail$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SugarChartData) obj);
                return eh.g.f12633a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(SugarChartData it) {
                f6.j jVar;
                f6.j jVar2;
                Entry entry;
                Object obj;
                Entry entry2;
                Object obj2;
                Entry entry3;
                Object obj3;
                kotlin.jvm.internal.e.f(it, "it");
                TRingBloodSugarStatisticsActivity tRingBloodSugarStatisticsActivity = (TRingBloodSugarStatisticsActivity) ((g7.h) r.this.f7255a);
                tRingBloodSugarStatisticsActivity.getClass();
                eh.b bVar = tRingBloodSugarStatisticsActivity.F;
                int intValue = ((Number) bVar.getValue()).intValue();
                eh.b bVar2 = tRingBloodSugarStatisticsActivity.f7247z;
                if (intValue == 0) {
                    List<Entry> items = it.getItems();
                    if (items != null) {
                        Iterator<T> it2 = items.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj3 = null;
                                break;
                            } else {
                                obj3 = it2.next();
                                if (((Entry) obj3).d() > 0.0f) {
                                    break;
                                }
                            }
                        }
                        entry3 = (Entry) obj3;
                    } else {
                        entry3 = null;
                    }
                    List<Entry> items2 = it.getItems();
                    if (items2 == null || items2.isEmpty() || entry3 == null) {
                        f6.j jVar3 = (f6.j) bVar2.getValue();
                        LinearLayout linearLayout = jVar3 != null ? jVar3.e : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                    } else {
                        f6.j jVar4 = (f6.j) bVar2.getValue();
                        LinearLayout linearLayout2 = jVar4 != null ? jVar4.e : null;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(0);
                        }
                    }
                }
                f6.j jVar5 = (f6.j) bVar2.getValue();
                if (jVar5 != null) {
                    LineChart lineChart = jVar5.f12999b;
                    if (lineChart.getData() == 0 || ((o7.j) lineChart.getData()).c() <= 0) {
                        List<Entry> items3 = it.getItems();
                        if (items3 != null) {
                            Iterator<T> it3 = items3.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    obj = null;
                                    break;
                                } else {
                                    obj = it3.next();
                                    if (((Entry) obj).d() > 0.0f) {
                                        break;
                                    }
                                }
                            }
                            entry = (Entry) obj;
                        } else {
                            entry = null;
                        }
                        List<Entry> items4 = it.getItems();
                        if (items4 == null || items4.isEmpty() || entry == null) {
                            lineChart.setData(null);
                            lineChart.n();
                        } else {
                            o7.k kVar = new o7.k(it.getItems());
                            kVar.B = LineDataSet$Mode.CUBIC_BEZIER;
                            kVar.G = 0.2f;
                            kVar.A = true;
                            kVar.I = false;
                            kVar.f16824t = android.support.v4.media.session.e.a(kVar, 244, 117, 117);
                            kVar.l(tRingBloodSugarStatisticsActivity.getResources().getColor(R$color.color_c89349));
                            kVar.f16837x = tRingBloodSugarStatisticsActivity.getResources().getColor(R$color.color_c89349);
                            kVar.f16838y = 60;
                            kVar.f16835v = false;
                            kVar.H = new com.example.test.ui.sport.activity.l(lineChart, 5);
                            o7.j jVar6 = new o7.j(kVar);
                            jVar6.j();
                            jVar6.i();
                            lineChart.setData(jVar6);
                        }
                    } else {
                        o7.d b3 = ((o7.j) lineChart.getData()).b(0);
                        kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
                        o7.k kVar2 = (o7.k) b3;
                        List<Entry> items5 = it.getItems();
                        if (items5 != null) {
                            Iterator<T> it4 = items5.iterator();
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
                            entry2 = (Entry) obj2;
                        } else {
                            entry2 = null;
                        }
                        List<Entry> items6 = it.getItems();
                        if (items6 == null || items6.isEmpty() || entry2 == null) {
                            ((o7.j) lineChart.getData()).h(kVar2);
                            lineChart.setData(null);
                        } else {
                            kVar2.m(it.getItems());
                            ((o7.j) lineChart.getData()).a();
                        }
                        lineChart.n();
                    }
                    lineChart.invalidate();
                }
                String format = it.getCurrentSugar() == 0.0f ? "--" : String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(it.getCurrentSugar())}, 1));
                String format2 = it.getMaxSugar() == 0.0f ? "--" : String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(it.getMaxSugar())}, 1));
                String format3 = it.getMinSugar() == 0.0f ? "--" : String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(it.getMinSugar())}, 1));
                String format4 = it.getAvgSugar() != 0.0f ? String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(it.getAvgSugar())}, 1)) : "--";
                f6.j jVar7 = (f6.j) bVar2.getValue();
                if (jVar7 != null) {
                    jVar7.f13010n.setText(format);
                }
                f6.j jVar8 = (f6.j) bVar2.getValue();
                if (jVar8 != null) {
                    jVar8.f13008l.setText(format2);
                }
                f6.j jVar9 = (f6.j) bVar2.getValue();
                if (jVar9 != null) {
                    jVar9.f13009m.setText(format3);
                }
                f6.j jVar10 = (f6.j) bVar2.getValue();
                if (jVar10 != null) {
                    jVar10.f13007k.setText(format4);
                }
                if (((Number) bVar.getValue()).intValue() == 0) {
                    f6.j jVar11 = (f6.j) bVar2.getValue();
                    TextView textView = jVar11 != null ? jVar11.f13005i : null;
                    if (textView != null) {
                        textView.setText("00:00");
                    }
                    f6.j jVar12 = (f6.j) bVar2.getValue();
                    TextView textView2 = jVar12 != null ? jVar12.f13000c : null;
                    if (textView2 != null) {
                        textView2.setText("24:00");
                    }
                    String startTime = it.getStartTime();
                    if (startTime != null && (jVar2 = (f6.j) bVar2.getValue()) != null) {
                        jVar2.f13005i.setText(startTime);
                    }
                    String endTime = it.getEndTime();
                    if (endTime == null || (jVar = (f6.j) bVar2.getValue()) == null) {
                        return;
                    }
                    jVar.f13000c.setText(endTime);
                }
            }
        });
    }
}
