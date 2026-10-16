package com.example.test.ui.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.main.d1;
import com.example.test.ui.model.chart.chart.SleepStaChartData;
import com.example.test.ui.model.chart.formatter.MonthFormatter;
import com.example.test.ui.model.chart.formatter.WeekFormatter;
import com.example.test.ui.model.chart.formatter.YearFormatter;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.example.test.ui.view.MyMarkerView;
import com.example.test.ui.view.SleepDetailChartView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.p3;
import g7.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class SleepStatisticsFragment extends BaseFragment<d1, p3> implements u, t7.d {

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f8090c = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.SleepStatisticsFragment$statisticsType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Bundle arguments = SleepStatisticsFragment.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("statistics_type") : 0);
        }
    });

    @Override // t7.d
    public final void A() {
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new d1(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        p3 p3Var = (p3) this.f7251b;
        if (p3Var != null) {
            return p3Var.f13231a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View a3;
        View a10;
        View inflate = layoutInflater.inflate(R$layout.fragment_sleep_statistics, viewGroup, false);
        int i3 = R$id.chart1;
        BarChart barChart = (BarChart) he.a(i3, inflate);
        if (barChart != null) {
            i3 = R$id.daySleepChart;
            SleepDetailChartView sleepDetailChartView = (SleepDetailChartView) he.a(i3, inflate);
            if (sleepDetailChartView != null) {
                i3 = R$id.dv_deep_sleep;
                DataView dataView = (DataView) he.a(i3, inflate);
                if (dataView != null) {
                    i3 = R$id.dv_light_sleep;
                    DataView dataView2 = (DataView) he.a(i3, inflate);
                    if (dataView2 != null) {
                        i3 = R$id.dv_sleep;
                        DataView dataView3 = (DataView) he.a(i3, inflate);
                        if (dataView3 != null) {
                            i3 = R$id.dv_total_time;
                            DataView dataView4 = (DataView) he.a(i3, inflate);
                            if (dataView4 != null) {
                                i3 = R$id.dv_wake;
                                DataView dataView5 = (DataView) he.a(i3, inflate);
                                if (dataView5 != null) {
                                    i3 = R$id.dv_wake_times;
                                    DataView dataView6 = (DataView) he.a(i3, inflate);
                                    if (dataView6 != null && (a3 = he.a((i3 = R$id.line_sleep), inflate)) != null && (a10 = he.a((i3 = R$id.line_wake), inflate)) != null) {
                                        i3 = R$id.ll_day;
                                        LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                                        if (linearLayout != null) {
                                            i3 = R$id.ll_statistics;
                                            LinearLayout linearLayout2 = (LinearLayout) he.a(i3, inflate);
                                            if (linearLayout2 != null) {
                                                i3 = R$id.tv_day_no_data;
                                                TextView textView = (TextView) he.a(i3, inflate);
                                                if (textView != null) {
                                                    i3 = R$id.view_date_select;
                                                    DateSelectView dateSelectView = (DateSelectView) he.a(i3, inflate);
                                                    if (dateSelectView != null) {
                                                        return new p3((NestedScrollView) inflate, barChart, sleepDetailChartView, dataView, dataView2, dataView3, dataView4, dataView5, dataView6, a3, a10, linearLayout, linearLayout2, textView, dateSelectView);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
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
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.e.d(activity, "null cannot be cast to non-null type android.content.Context");
        return activity;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        p3 p3Var = (p3) this.f7251b;
        if (p3Var != null) {
            DateSelectView dateSelectView = p3Var.f13244o;
            dateSelectView.setDateModel(((Number) this.f8090c.getValue()).intValue());
            dateSelectView.setOnDateSelectedListener(new n(this, 8));
            dateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        eh.b bVar = this.f8090c;
        if (((Number) bVar.getValue()).intValue() == 0) {
            p3 p3Var = (p3) this.f7251b;
            View view = p3Var != null ? p3Var.f13239j : null;
            if (view != null) {
                view.setVisibility(0);
            }
            p3 p3Var2 = (p3) this.f7251b;
            View view2 = p3Var2 != null ? p3Var2.f13240k : null;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            p3 p3Var3 = (p3) this.f7251b;
            DataView dataView = p3Var3 != null ? p3Var3.f13235f : null;
            if (dataView != null) {
                dataView.setVisibility(0);
            }
            p3 p3Var4 = (p3) this.f7251b;
            DataView dataView2 = p3Var4 != null ? p3Var4.f13237h : null;
            if (dataView2 != null) {
                dataView2.setVisibility(0);
            }
            p3 p3Var5 = (p3) this.f7251b;
            LinearLayout linearLayout = p3Var5 != null ? p3Var5.f13241l : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            p3 p3Var6 = (p3) this.f7251b;
            LinearLayout linearLayout2 = p3Var6 != null ? p3Var6.f13242m : null;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(8);
            return;
        }
        p3 p3Var7 = (p3) this.f7251b;
        View view3 = p3Var7 != null ? p3Var7.f13239j : null;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        p3 p3Var8 = (p3) this.f7251b;
        View view4 = p3Var8 != null ? p3Var8.f13240k : null;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        p3 p3Var9 = (p3) this.f7251b;
        DataView dataView3 = p3Var9 != null ? p3Var9.f13235f : null;
        if (dataView3 != null) {
            dataView3.setVisibility(8);
        }
        p3 p3Var10 = (p3) this.f7251b;
        DataView dataView4 = p3Var10 != null ? p3Var10.f13237h : null;
        if (dataView4 != null) {
            dataView4.setVisibility(8);
        }
        p3 p3Var11 = (p3) this.f7251b;
        LinearLayout linearLayout3 = p3Var11 != null ? p3Var11.f13241l : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        p3 p3Var12 = (p3) this.f7251b;
        LinearLayout linearLayout4 = p3Var12 != null ? p3Var12.f13242m : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(0);
        }
        p3 p3Var13 = (p3) this.f7251b;
        if (p3Var13 != null) {
            BarChart barChart = p3Var13.f13232b;
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
            int intValue = ((Number) bVar.getValue()).intValue();
            if (intValue == 1) {
                barChart.getXAxis().f16386f = new WeekFormatter(f0());
            } else if (intValue == 2) {
                barChart.getXAxis().f16386f = new MonthFormatter(f0());
            } else if (intValue == 3) {
                barChart.getXAxis().f16386f = new YearFormatter(f0());
            }
            barChart.getAxisLeft().e = -1;
            barChart.getAxisLeft().h(5, false);
            barChart.getAxisLeft().J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
            barChart.getAxisLeft().H = 15.0f;
            barChart.getAxisLeft().f(0.0f);
            barChart.getAxisRight().f16406a = false;
            barChart.getLegend().f16406a = false;
            MyMarkerView myMarkerView = new MyMarkerView(f0(), R$layout.custom_marker_view);
            p3 p3Var14 = (p3) this.f7251b;
            myMarkerView.setChartView(p3Var14 != null ? p3Var14.f13232b : null);
            barChart.setMarker(myMarkerView);
            barChart.setNoDataText(getString(R$string.str_no_data));
            barChart.setNoDataTextColor(-1);
            barChart.e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q0(SleepStaChartData sleepStaChartData) {
        BarEntry barEntry;
        Object obj;
        BarEntry barEntry2;
        Object obj2;
        p3 p3Var = (p3) this.f7251b;
        if (p3Var != null) {
            BarChart barChart = p3Var.f13232b;
            if (barChart.getData() == 0 || ((o7.a) barChart.getData()).c() <= 0) {
                List<BarEntry> items = sleepStaChartData.getItems();
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
                List<BarEntry> items2 = sleepStaChartData.getItems();
                if (items2 == null || items2.isEmpty() || barEntry == null) {
                    barChart.setData(null);
                    ((o7.a) barChart.getData()).a();
                } else {
                    o7.b bVar = new o7.b(sleepStaChartData.getItems());
                    bVar.l(getResources().getColor(R$color.color_925ed2));
                    bVar.f16815j = false;
                    bVar.f16808b = kotlin.collections.i.b(-1);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    barChart.setData(new o7.a(arrayList));
                    barChart.setFitBars(true);
                }
            } else {
                List<BarEntry> items3 = sleepStaChartData.getItems();
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
                List<BarEntry> items4 = sleepStaChartData.getItems();
                if (items4 == null || items4.isEmpty() || barEntry2 == null) {
                    barChart.setData(null);
                } else {
                    o7.d b3 = ((o7.a) barChart.getData()).b(0);
                    kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
                    ((o7.b) b3).m(sleepStaChartData.getItems());
                    ((o7.a) barChart.getData()).a();
                }
                barChart.n();
            }
            barChart.invalidate();
        }
        p3 p3Var2 = (p3) this.f7251b;
        if (p3Var2 != null) {
            DataView dataView = p3Var2.f13236g;
            String totalTime = sleepStaChartData.getTotalTime();
            kotlin.jvm.internal.e.e(totalTime, "getTotalTime(...)");
            dataView.setValue(totalTime);
        }
        p3 p3Var3 = (p3) this.f7251b;
        if (p3Var3 != null) {
            DataView dataView2 = p3Var3.f13234d;
            String deepTime = sleepStaChartData.getDeepTime();
            kotlin.jvm.internal.e.e(deepTime, "getDeepTime(...)");
            dataView2.setValue(deepTime);
        }
        p3 p3Var4 = (p3) this.f7251b;
        if (p3Var4 != null) {
            DataView dataView3 = p3Var4.e;
            String lightTime = sleepStaChartData.getLightTime();
            kotlin.jvm.internal.e.e(lightTime, "getLightTime(...)");
            dataView3.setValue(lightTime);
        }
        if (!y5.d.f20005b) {
            p3 p3Var5 = (p3) this.f7251b;
            if (p3Var5 != null) {
                DataView dataView4 = p3Var5.f13238i;
                String string = getString(R$string.str_wake_times);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                dataView4.setTitle(string);
            }
            p3 p3Var6 = (p3) this.f7251b;
            if (p3Var6 != null) {
                p3Var6.f13238i.setValue(String.format("%d%s", Arrays.copyOf(new Object[]{Integer.valueOf(sleepStaChartData.getWakeTimes()), getString(R$string.str_count)}, 2)));
                return;
            }
            return;
        }
        p3 p3Var7 = (p3) this.f7251b;
        if (p3Var7 != null) {
            DataView dataView5 = p3Var7.f13238i;
            String string2 = getString(R$string.str_wake_timelong);
            kotlin.jvm.internal.e.e(string2, "getString(...)");
            dataView5.setTitle(string2);
        }
        p3 p3Var8 = (p3) this.f7251b;
        if (p3Var8 != null) {
            DataView dataView6 = p3Var8.f13238i;
            String wakeTime = sleepStaChartData.getWakeTime();
            kotlin.jvm.internal.e.e(wakeTime, "getWakeTime(...)");
            dataView6.setValue(wakeTime);
        }
    }

    @Override // t7.d
    public final void x(Entry entry) {
    }
}
