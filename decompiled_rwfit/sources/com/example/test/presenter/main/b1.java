package com.example.test.presenter.main;

import android.util.Log;
import com.example.database.db.MuslimCountImpl;
import com.example.database.table.DataMuslimCount;
import com.example.database.table.User;
import com.example.test.R$color;
import com.example.test.ui.model.chart.chart.MuslimItemData;
import com.example.test.ui.model.chart.chart.StepChartData;
import com.example.test.ui.testui.TRingMuslinStatisticsActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarEntry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b1 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.MuslinStatisticsPresenter$getDayMuslimCountStatistics$1
            @Override // oh.l
            public final StepChartData invoke(String dateTime) {
                Date date2;
                String str;
                kotlin.jvm.internal.e.f(dateTime, "dateTime");
                Log.e("qob", "getDayMuslimCountDetail ".concat(dateTime));
                StepChartData stepChartData = new StepChartData();
                try {
                    date2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(dateTime);
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
                            MuslimCountImpl muslimCountImpl = MuslimCountImpl.INSTANCE;
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            String g10 = kVar2 != null ? kVar2.g() : null;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            DataMuslimCount dataByDate = muslimCountImpl.getDataByDate(g10, userId, str);
                            if (dataByDate != null) {
                                stepChartData.setTotalSteps(dataByDate.getTotalCount());
                                stepChartData.setAvgSteps(dataByDate.getAvgCount());
                                stepChartData.setCalorie(dataByDate.getMinCount());
                                stepChartData.setDistance(dataByDate.getMaxCount());
                                List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new g6.m().f3204b);
                                ArrayList arrayList = new ArrayList();
                                kotlin.jvm.internal.e.c(h4);
                                int i3 = 0;
                                for (Object obj : h4) {
                                    int i10 = i3 + 1;
                                    if (i3 < 0) {
                                        kotlin.collections.i.f();
                                        throw null;
                                    }
                                    arrayList.add(new BarEntry(i3, ((MuslimItemData) obj).getCount()));
                                    i3 = i10;
                                }
                                stepChartData.setSteps(arrayList);
                            }
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                            stepChartData.setStepTarget(kVar3 != null ? kVar3.v() : 33);
                            int totalSteps = (int) ((stepChartData.getTotalSteps() / d5.getStepsTarget()) * 100);
                            stepChartData.setStepTargetPercent(100 > totalSteps ? totalSteps : 100);
                        }
                    }
                }
                return stepChartData;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.MuslinStatisticsPresenter$getDayMuslimCountStatistics$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StepChartData) obj);
                return eh.g.f12633a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(StepChartData it) {
                BarEntry barEntry;
                Object obj;
                BarEntry barEntry2;
                Object obj2;
                kotlin.jvm.internal.e.f(it, "it");
                TRingMuslinStatisticsActivity tRingMuslinStatisticsActivity = (TRingMuslinStatisticsActivity) ((g7.s) b1.this.f7255a);
                tRingMuslinStatisticsActivity.getClass();
                String valueOf = ((int) it.getDistance()) == 0 ? "--" : String.valueOf((int) it.getDistance());
                String valueOf2 = ((int) it.getCalorie()) == 0 ? "--" : String.valueOf((int) it.getCalorie());
                String valueOf3 = it.getAvgSteps() != 0 ? String.valueOf(it.getAvgSteps()) : "--";
                eh.b bVar = tRingMuslinStatisticsActivity.f7247z;
                f6.v0 v0Var = (f6.v0) bVar.getValue();
                if (v0Var != null) {
                    v0Var.e.setText(valueOf3);
                }
                f6.v0 v0Var2 = (f6.v0) bVar.getValue();
                if (v0Var2 != null) {
                    v0Var2.f13393f.setText(valueOf);
                }
                f6.v0 v0Var3 = (f6.v0) bVar.getValue();
                if (v0Var3 != null) {
                    v0Var3.f13394g.setText(valueOf2);
                }
                f6.v0 v0Var4 = (f6.v0) bVar.getValue();
                if (v0Var4 != null) {
                    BarChart barChart = v0Var4.f13390b;
                    if (barChart.getData() == 0 || ((o7.a) barChart.getData()).c() <= 0) {
                        List<BarEntry> steps = it.getSteps();
                        if (steps != null) {
                            Iterator<T> it2 = steps.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj = null;
                                    break;
                                } else {
                                    obj = it2.next();
                                    if (((BarEntry) obj).d() > 0.0f) {
                                        break;
                                    }
                                }
                            }
                            barEntry = (BarEntry) obj;
                        } else {
                            barEntry = null;
                        }
                        List<BarEntry> steps2 = it.getSteps();
                        if (steps2 == null || steps2.isEmpty() || barEntry == null) {
                            barChart.setData(null);
                            barChart.n();
                        } else {
                            o7.b bVar2 = new o7.b(it.getSteps());
                            bVar2.l(tRingMuslinStatisticsActivity.getResources().getColor(R$color.color_3dc0d3));
                            bVar2.f16815j = false;
                            bVar2.n();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(bVar2);
                            barChart.setData(new o7.a(arrayList));
                            barChart.setFitBars(true);
                        }
                    } else {
                        o7.d b3 = ((o7.a) barChart.getData()).b(0);
                        kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
                        o7.b bVar3 = (o7.b) b3;
                        List<BarEntry> steps3 = it.getSteps();
                        if (steps3 != null) {
                            Iterator<T> it3 = steps3.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    obj2 = null;
                                    break;
                                } else {
                                    obj2 = it3.next();
                                    if (((BarEntry) obj2).d() > 0.0f) {
                                        break;
                                    }
                                }
                            }
                            barEntry2 = (BarEntry) obj2;
                        } else {
                            barEntry2 = null;
                        }
                        List<BarEntry> steps4 = it.getSteps();
                        if (steps4 == null || steps4.isEmpty() || barEntry2 == null) {
                            ((o7.a) barChart.getData()).h(bVar3);
                            barChart.setData(null);
                        } else {
                            bVar3.m(it.getSteps());
                            ((o7.a) barChart.getData()).a();
                        }
                        barChart.n();
                    }
                    barChart.invalidate();
                }
            }
        });
    }
}
