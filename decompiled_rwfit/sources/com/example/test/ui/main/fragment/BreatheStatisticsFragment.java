package com.example.test.ui.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.main.t;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.BreatheChartData;
import com.example.test.ui.model.chart.formatter.MonthFormatter;
import com.example.test.ui.model.chart.formatter.WeekFormatter;
import com.example.test.ui.model.chart.formatter.YFormatter;
import com.example.test.ui.model.chart.formatter.YearFormatter;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.example.test.ui.view.MyMarkerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.d3;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class BreatheStatisticsFragment extends XXBaseFragment<t, d3> implements g7.j, t7.d {

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f8041d = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.BreatheStatisticsFragment$statisticsType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Bundle arguments = BreatheStatisticsFragment.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("statistics_type") : 0);
        }
    });

    @Override // t7.d
    public final void A() {
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new t(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        d3 d3Var = (d3) this.f7251b;
        if (d3Var != null) {
            return d3Var.f12804a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_breathe_statistics, viewGroup, false);
        int i3 = R$id.chart1;
        BarChart barChart = (BarChart) he.a(i3, inflate);
        if (barChart != null) {
            i3 = R$id.dv_avg_time;
            DataView dataView = (DataView) he.a(i3, inflate);
            if (dataView != null) {
                i3 = R$id.dv_current_time;
                DataView dataView2 = (DataView) he.a(i3, inflate);
                if (dataView2 != null) {
                    i3 = R$id.ll_time;
                    if (((LinearLayout) he.a(i3, inflate)) != null) {
                        i3 = R$id.view_date_select;
                        DateSelectView dateSelectView = (DateSelectView) he.a(i3, inflate);
                        if (dateSelectView != null) {
                            return new d3((NestedScrollView) inflate, barChart, dataView, dataView2, dateSelectView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        d3 d3Var = (d3) this.f7251b;
        if (d3Var != null) {
            DateSelectView dateSelectView = d3Var.e;
            dateSelectView.setDateModel(((Number) this.f8041d.getValue()).intValue());
            dateSelectView.setOnDateSelectedListener(new n(this, 5));
            dateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        b2.a(this);
        d3 d3Var = (d3) this.f7251b;
        if (d3Var != null) {
            BarChart barChart = d3Var.f12805b;
            barChart.setOnChartValueSelectedListener(this);
            barChart.setDrawBarShadow(false);
            barChart.setDrawValueAboveBar(true);
            barChart.getDescription().f16406a = false;
            barChart.setDoubleTapToZoomEnabled(false);
            barChart.setMaxVisibleValueCount(24);
            barChart.setScaleEnabled(false);
            barChart.setPinchZoom(false);
            barChart.setDrawGridBackground(false);
            barChart.getXAxis().I = XAxis$XAxisPosition.BOTTOM;
            barChart.getXAxis().r = false;
            barChart.getXAxis().g();
            barChart.getXAxis().e = -1;
            int intValue = ((Number) this.f8041d.getValue()).intValue();
            if (intValue == 1) {
                barChart.getXAxis().f16386f = new WeekFormatter(getContext());
            } else if (intValue == 2) {
                barChart.getXAxis().f16386f = new MonthFormatter(getContext());
            } else if (intValue == 3) {
                barChart.getXAxis().f16386f = new YearFormatter(getContext());
            }
            barChart.getAxisLeft().f16386f = new YFormatter(getContext());
            barChart.getAxisLeft().e = -1;
            barChart.getAxisLeft().h(5, false);
            barChart.getAxisLeft().J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
            barChart.getAxisLeft().H = 15.0f;
            barChart.getAxisLeft().f(0.0f);
            barChart.getAxisRight().f16406a = false;
            barChart.getLegend().f16406a = false;
            MyMarkerView myMarkerView = new MyMarkerView(getContext(), R$layout.custom_marker_view);
            d3 d3Var2 = (d3) this.f7251b;
            myMarkerView.setChartView(d3Var2 != null ? d3Var2.f12805b : null);
            barChart.setMarker(myMarkerView);
            barChart.setNoDataText(getString(R$string.str_no_data));
            barChart.setNoDataTextColor(-1);
            barChart.e();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(EventBusBeans.SyncEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        d3 d3Var = (d3) this.f7251b;
        if (d3Var != null && d3Var.e.d() && syncEvent.getSyncType() == 7) {
            Calendar calendar = Calendar.getInstance();
            int intValue = ((Number) this.f8041d.getValue()).intValue();
            if (intValue == 1) {
                Date time = calendar.getTime();
                kotlin.jvm.internal.e.e(time, "getTime(...)");
                Locale locale = Locale.ENGLISH;
                Date v6 = android.support.v4.media.session.e.v(Calendar.getInstance(locale), time, 7, 7, "getTime(...)");
                Date time2 = calendar.getTime();
                kotlin.jvm.internal.e.e(time2, "getTime(...)");
                Calendar calendar2 = Calendar.getInstance(locale);
                calendar2.setTime(time2);
                calendar2.set(7, calendar2.getActualMaximum(7));
                Date time3 = calendar2.getTime();
                kotlin.jvm.internal.e.e(time3, "getTime(...)");
                String j4 = ca.j(v6.getTime());
                String j10 = ca.j(time3.getTime());
                if (j4 == null || j10 == null) {
                    return;
                }
                ((t) X()).l(j4, j10);
                return;
            }
            String str = null;
            if (intValue == 2) {
                long timeInMillis = calendar.getTimeInMillis();
                try {
                    str = new SimpleDateFormat("yyyy/MM", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                } catch (Exception e) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                }
                if (str != null) {
                    ((t) X()).k(str);
                    return;
                }
                return;
            }
            if (intValue != 3) {
                return;
            }
            long timeInMillis2 = calendar.getTimeInMillis();
            try {
                str = new SimpleDateFormat("yyyy", Locale.ENGLISH).format(Long.valueOf(timeInMillis2));
            } catch (Exception e10) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis2, " date translate error ", e10.getMessage()));
            }
            if (str != null) {
                ((t) X()).m(str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q0(BreatheChartData breatheChartData) {
        BarEntry barEntry;
        Object obj;
        float f2;
        BarEntry barEntry2;
        Object obj2;
        d3 d3Var = (d3) this.f7251b;
        if (d3Var != null) {
            BarChart barChart = d3Var.f12805b;
            if (barChart.getData() == 0 || ((o7.a) barChart.getData()).c() <= 0) {
                List<BarEntry> items = breatheChartData.getItems();
                if (items != null) {
                    Iterator<T> it = items.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it.next();
                            if (((BarEntry) obj).d() > 0.0f) {
                                break;
                            }
                        }
                    }
                    barEntry = (BarEntry) obj;
                } else {
                    barEntry = null;
                }
                List<BarEntry> items2 = breatheChartData.getItems();
                if (items2 == null || items2.isEmpty() || barEntry == null) {
                    barChart.setData(null);
                    barChart.n();
                } else {
                    o7.b bVar = new o7.b(breatheChartData.getItems());
                    bVar.l(getResources().getColor(R$color.color_3dc0d3));
                    bVar.f16815j = false;
                    bVar.n();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    o7.a aVar = new o7.a(arrayList);
                    aVar.f16801j = 0.9f;
                    barChart.setData(aVar);
                    barChart.setFitBars(true);
                }
            } else {
                List<BarEntry> items3 = breatheChartData.getItems();
                if (items3 != null) {
                    Iterator<T> it2 = items3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj2 = null;
                            break;
                        } else {
                            obj2 = it2.next();
                            if (((BarEntry) obj2).d() > 0.0f) {
                                break;
                            }
                        }
                    }
                    barEntry2 = (BarEntry) obj2;
                } else {
                    barEntry2 = null;
                }
                List<BarEntry> items4 = breatheChartData.getItems();
                if (items4 == null || items4.isEmpty() || barEntry2 == null) {
                    barChart.setData(null);
                } else {
                    o7.d b3 = ((o7.a) barChart.getData()).b(0);
                    kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
                    ((o7.b) b3).m(breatheChartData.getItems());
                    ((o7.a) barChart.getData()).a();
                }
                barChart.n();
            }
            d3 d3Var2 = (d3) this.f7251b;
            if (d3Var2 != null) {
                BarChart barChart2 = d3Var2.f12805b;
                List<BarEntry> items5 = breatheChartData.getItems();
                if (items5 != null) {
                    Iterator<T> it3 = items5.iterator();
                    if (!it3.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    f2 = ((BarEntry) it3.next()).d();
                    while (it3.hasNext()) {
                        f2 = Math.max(f2, ((BarEntry) it3.next()).d());
                    }
                } else {
                    f2 = 1.0f;
                }
                if (f2 >= 3.0f) {
                    barChart2.getAxisLeft().h(3, false);
                } else {
                    barChart2.getAxisLeft().h(5, false);
                }
            }
            barChart.invalidate();
        }
        d3 d3Var3 = (d3) this.f7251b;
        if (d3Var3 != null) {
            d3Var3.f12807d.setValue(String.format("%d min", Arrays.copyOf(new Object[]{Integer.valueOf((int) breatheChartData.getTotalTimes())}, 1)));
        }
        d3 d3Var4 = (d3) this.f7251b;
        if (d3Var4 != null) {
            d3Var4.f12806c.setValue(String.format("%d min", Arrays.copyOf(new Object[]{Integer.valueOf((int) breatheChartData.getAvgTimes())}, 1)));
        }
    }

    @Override // t7.d
    public final void x(Entry entry) {
    }
}
