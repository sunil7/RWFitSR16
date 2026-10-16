package com.example.test.ui.main.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.database.table.User;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.main.g1;
import com.example.test.ui.mine.activity.SelectActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.StepChartData;
import com.example.test.ui.model.chart.formatter.DayFormatter;
import com.example.test.ui.model.chart.formatter.MonthFormatter;
import com.example.test.ui.model.chart.formatter.StepYFormatter;
import com.example.test.ui.model.chart.formatter.WeekFormatter;
import com.example.test.ui.model.chart.formatter.YearFormatter;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.example.test.ui.view.MyMarkerView;
import com.example.test.ui.view.RoundProgressBar;
import com.example.test.ui.view.TimeIndicatorView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.s3;
import g7.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class StepStatisticsFragment extends BaseFragment<g1, s3> implements x, View.OnClickListener, t7.d {

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f8091c = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.StepStatisticsFragment$statisticsType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Bundle arguments = StepStatisticsFragment.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("statistics_type") : 0);
        }
    });

    @Override // t7.d
    public final void A() {
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new g1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R(StepChartData stepChartData) {
        BarEntry barEntry;
        TimeIndicatorView timeIndicatorView;
        Object obj;
        BarEntry barEntry2;
        Object obj2;
        s3 s3Var = (s3) this.f7251b;
        if (s3Var != null) {
            android.support.v4.media.session.e.A(new Object[]{Integer.valueOf(stepChartData.getTotalSteps()), getString(R$string.str_unit_step)}, 2, "%d%s", s3Var.f13313l);
        }
        s3 s3Var2 = (s3) this.f7251b;
        if (s3Var2 != null) {
            android.support.v4.media.session.e.A(new Object[]{Integer.valueOf(stepChartData.getAvgSteps()), getString(R$string.str_unit_step)}, 2, "%d%s", s3Var2.f13311j);
        }
        s3 s3Var3 = (s3) this.f7251b;
        if (s3Var3 != null) {
            android.support.v4.media.session.e.A(new Object[]{getString(R$string.str_target), Integer.valueOf(stepChartData.getStepTarget()), getString(R$string.str_unit_step)}, 3, "%s:%d%s", s3Var3.f13312k);
        }
        s3 s3Var4 = (s3) this.f7251b;
        RoundProgressBar roundProgressBar = s3Var4 != null ? s3Var4.f13309h : null;
        if (roundProgressBar != null) {
            roundProgressBar.setCurrentProgress(stepChartData.getStepTargetPercent());
        }
        s3 s3Var5 = (s3) this.f7251b;
        if (s3Var5 != null) {
            s3Var5.f13305c.setValue(String.format("%.1fKCAL", Arrays.copyOf(new Object[]{Float.valueOf(((int) (stepChartData.getCalorie() * 10)) / 10.0f)}, 1)));
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 != null) {
            String string = d5.getMeterUnit() == 0 ? getString(R$string.str_km) : getString(R$string.str_mile);
            kotlin.jvm.internal.e.c(string);
            s3 s3Var6 = (s3) this.f7251b;
            if (s3Var6 != null) {
                s3Var6.f13306d.setValue(String.format("%.2f%s", Arrays.copyOf(new Object[]{Float.valueOf(((int) (stepChartData.getDistance() * 100)) / 100.0f), string}, 2)));
            }
        }
        if (q0() == 0) {
            List<BarEntry> steps = stepChartData.getSteps();
            if (steps == null || steps.isEmpty()) {
                s3 s3Var7 = (s3) this.f7251b;
                TimeIndicatorView timeIndicatorView2 = s3Var7 != null ? s3Var7.f13308g : null;
                if (timeIndicatorView2 != null) {
                    timeIndicatorView2.setVisibility(8);
                }
            } else {
                s3 s3Var8 = (s3) this.f7251b;
                TimeIndicatorView timeIndicatorView3 = s3Var8 != null ? s3Var8.f13308g : null;
                if (timeIndicatorView3 != null) {
                    timeIndicatorView3.setVisibility(0);
                }
            }
        }
        s3 s3Var9 = (s3) this.f7251b;
        if (s3Var9 != null) {
            BarChart barChart = s3Var9.f13304b;
            if (barChart.getData() == 0 || ((o7.a) barChart.getData()).c() <= 0) {
                List<BarEntry> steps2 = stepChartData.getSteps();
                if (steps2 != null) {
                    Iterator<T> it = steps2.iterator();
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
                List<BarEntry> steps3 = stepChartData.getSteps();
                if (steps3 == null || steps3.isEmpty() || barEntry == null) {
                    barChart.setData(null);
                    if (q0() == 0) {
                        s3 s3Var10 = (s3) this.f7251b;
                        timeIndicatorView = s3Var10 != null ? s3Var10.f13308g : null;
                        if (timeIndicatorView != null) {
                            timeIndicatorView.setVisibility(8);
                        }
                    }
                    barChart.n();
                } else {
                    o7.b bVar = new o7.b(stepChartData.getSteps());
                    bVar.l(getResources().getColor(R$color.color_3dc0d3));
                    bVar.f16815j = false;
                    bVar.n();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    barChart.setData(new o7.a(arrayList));
                    barChart.setFitBars(true);
                }
            } else {
                o7.d b3 = ((o7.a) barChart.getData()).b(0);
                kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
                o7.b bVar2 = (o7.b) b3;
                List<BarEntry> steps4 = stepChartData.getSteps();
                if (steps4 != null) {
                    Iterator<T> it2 = steps4.iterator();
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
                List<BarEntry> steps5 = stepChartData.getSteps();
                if (steps5 == null || steps5.isEmpty() || barEntry2 == null) {
                    ((o7.a) barChart.getData()).h(bVar2);
                    barChart.setData(null);
                    if (q0() == 0) {
                        s3 s3Var11 = (s3) this.f7251b;
                        timeIndicatorView = s3Var11 != null ? s3Var11.f13308g : null;
                        if (timeIndicatorView != null) {
                            timeIndicatorView.setVisibility(8);
                        }
                    }
                } else {
                    bVar2.m(stepChartData.getSteps());
                    ((o7.a) barChart.getData()).a();
                    if (q0() == 0) {
                        s3 s3Var12 = (s3) this.f7251b;
                        timeIndicatorView = s3Var12 != null ? s3Var12.f13308g : null;
                        if (timeIndicatorView != null) {
                            timeIndicatorView.setVisibility(0);
                        }
                    }
                }
                barChart.n();
            }
            barChart.invalidate();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        s3 s3Var = (s3) this.f7251b;
        if (s3Var != null) {
            return s3Var.f13303a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_step_statistics, viewGroup, false);
        int i3 = R$id.chart1;
        BarChart barChart = (BarChart) he.a(i3, inflate);
        if (barChart != null) {
            i3 = R$id.dv_calorie;
            DataView dataView = (DataView) he.a(i3, inflate);
            if (dataView != null) {
                i3 = R$id.dv_distance;
                DataView dataView2 = (DataView) he.a(i3, inflate);
                if (dataView2 != null) {
                    i3 = R$id.ll_avg;
                    LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                    if (linearLayout != null) {
                        i3 = R$id.ll_target;
                        LinearLayout linearLayout2 = (LinearLayout) he.a(i3, inflate);
                        if (linearLayout2 != null) {
                            i3 = R$id.ll_time;
                            TimeIndicatorView timeIndicatorView = (TimeIndicatorView) he.a(i3, inflate);
                            if (timeIndicatorView != null) {
                                i3 = R$id.progress;
                                RoundProgressBar roundProgressBar = (RoundProgressBar) he.a(i3, inflate);
                                if (roundProgressBar != null) {
                                    i3 = R$id.targetEditIv;
                                    ImageView imageView = (ImageView) he.a(i3, inflate);
                                    if (imageView != null) {
                                        i3 = R$id.tv_avg_step;
                                        TextView textView = (TextView) he.a(i3, inflate);
                                        if (textView != null) {
                                            i3 = R$id.tv_target;
                                            TextView textView2 = (TextView) he.a(i3, inflate);
                                            if (textView2 != null) {
                                                i3 = R$id.tv_total_step;
                                                TextView textView3 = (TextView) he.a(i3, inflate);
                                                if (textView3 != null) {
                                                    i3 = R$id.view_date_select;
                                                    DateSelectView dateSelectView = (DateSelectView) he.a(i3, inflate);
                                                    if (dateSelectView != null) {
                                                        return new s3((NestedScrollView) inflate, barChart, dataView, dataView2, linearLayout, linearLayout2, timeIndicatorView, roundProgressBar, imageView, textView, textView2, textView3, dateSelectView);
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
        s3 s3Var = (s3) this.f7251b;
        if (s3Var != null) {
            DateSelectView dateSelectView = s3Var.f13314m;
            dateSelectView.setDateModel(q0());
            dateSelectView.setOnDateSelectedListener(new n(this, 10));
            dateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        b2.a(this);
        if (q0() == 0) {
            s3 s3Var = (s3) this.f7251b;
            LinearLayout linearLayout = s3Var != null ? s3Var.e : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            s3 s3Var2 = (s3) this.f7251b;
            RoundProgressBar roundProgressBar = s3Var2 != null ? s3Var2.f13309h : null;
            if (roundProgressBar != null) {
                roundProgressBar.setVisibility(0);
            }
            s3 s3Var3 = (s3) this.f7251b;
            LinearLayout linearLayout2 = s3Var3 != null ? s3Var3.f13307f : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        } else {
            s3 s3Var4 = (s3) this.f7251b;
            LinearLayout linearLayout3 = s3Var4 != null ? s3Var4.e : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            s3 s3Var5 = (s3) this.f7251b;
            RoundProgressBar roundProgressBar2 = s3Var5 != null ? s3Var5.f13309h : null;
            if (roundProgressBar2 != null) {
                roundProgressBar2.setVisibility(8);
            }
            s3 s3Var6 = (s3) this.f7251b;
            LinearLayout linearLayout4 = s3Var6 != null ? s3Var6.f13307f : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
        }
        s3 s3Var7 = (s3) this.f7251b;
        if (s3Var7 != null) {
            s3Var7.f13310i.setOnClickListener(this);
        }
        s3 s3Var8 = (s3) this.f7251b;
        if (s3Var8 != null) {
            BarChart barChart = s3Var8.f13304b;
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
            int q02 = q0();
            if (q02 == 0) {
                s3 s3Var9 = (s3) this.f7251b;
                TimeIndicatorView timeIndicatorView = s3Var9 != null ? s3Var9.f13308g : null;
                if (timeIndicatorView != null) {
                    timeIndicatorView.setVisibility(0);
                }
                barChart.getXAxis().f16386f = new DayFormatter(f0());
            } else if (q02 == 1) {
                barChart.getXAxis().f16386f = new WeekFormatter(f0());
            } else if (q02 == 2) {
                barChart.getXAxis().f16386f = new MonthFormatter(f0());
            } else if (q02 == 3) {
                barChart.getXAxis().f16386f = new YearFormatter(f0());
            }
            barChart.getAxisLeft().f16386f = new StepYFormatter();
            barChart.getAxisLeft().e = -1;
            barChart.getAxisLeft().h(5, false);
            barChart.getAxisLeft().J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
            barChart.getAxisLeft().H = 15.0f;
            barChart.getAxisLeft().f(0.0f);
            barChart.getAxisRight().f16406a = false;
            barChart.getLegend().f16406a = false;
            MyMarkerView myMarkerView = new MyMarkerView(f0(), R$layout.custom_marker_view);
            s3 s3Var10 = (s3) this.f7251b;
            myMarkerView.setChartView(s3Var10 != null ? s3Var10.f13304b : null);
            barChart.setMarker(myMarkerView);
            barChart.setNoDataText(getString(R$string.str_no_data));
            barChart.setNoDataTextColor(-1);
            barChart.e();
            barChart.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.targetEditIv;
        if (valueOf != null && valueOf.intValue() == i3) {
            int i10 = SelectActivity.P;
            Context f02 = f0();
            Intent intent = new Intent(f02, (Class<?>) SelectActivity.class);
            intent.putExtra("select_type", 4);
            f02.startActivity(intent);
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
        s3 s3Var = (s3) this.f7251b;
        if (s3Var != null && s3Var.f13314m.d() && syncEvent.getSyncType() == 0) {
            Calendar calendar = Calendar.getInstance();
            int q02 = q0();
            String str = null;
            if (q02 == 0) {
                long timeInMillis = calendar.getTimeInMillis();
                try {
                    str = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                } catch (Exception e) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                }
                if (str != null) {
                    ((g1) X()).k(str);
                    return;
                }
                return;
            }
            if (q02 == 1) {
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
                ((g1) X()).l(j4, j10);
                return;
            }
            if (q02 == 2) {
                long timeInMillis2 = calendar.getTimeInMillis();
                try {
                    str = new SimpleDateFormat("yyyy/MM", Locale.ENGLISH).format(Long.valueOf(timeInMillis2));
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis2, " date translate error ", e10.getMessage()));
                }
                if (str != null) {
                    ((g1) X()).m(str);
                    return;
                }
                return;
            }
            if (q02 != 3) {
                return;
            }
            long timeInMillis3 = calendar.getTimeInMillis();
            try {
                str = new SimpleDateFormat("yyyy", Locale.ENGLISH).format(Long.valueOf(timeInMillis3));
            } catch (Exception e11) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis3, " date translate error ", e11.getMessage()));
            }
            if (str != null) {
                ((g1) X()).n(str);
            }
        }
    }

    public final int q0() {
        return ((Number) this.f8091c.getValue()).intValue();
    }

    @Override // t7.d
    public final void x(Entry entry) {
    }
}
