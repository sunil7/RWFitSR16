package com.example.test.ui.testui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.database.table.User;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.model.chart.chart.StepChartData;
import com.example.test.ui.model.chart.formatter.DayFormatter;
import com.example.test.ui.model.chart.formatter.StepYFormatter;
import com.example.test.ui.view.HalfCircle;
import com.example.test.ui.view.TimeIndicatorView;
import com.example.test.ui.view.WaveView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import com.google.android.material.R$attr;
import com.google.android.material.timepicker.TimeModel;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;
import f6.z2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TRingActivityFragment extends BaseFragment<com.example.test.presenter.main.a, z2> implements g7.a, t7.d, md.k {

    /* renamed from: c, reason: collision with root package name */
    public String f8204c = "";

    @Override // t7.d
    public final void A() {
        Log.d("tong", "onNothingSelected");
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new com.example.test.presenter.main.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g7.a
    public final void R(StepChartData stepChartData) {
        BarEntry barEntry;
        Object obj;
        BarEntry barEntry2;
        Object obj2;
        Log.d("tong", "stepChartData char size ");
        com.example.test.utils.k a3 = y1.a();
        Integer valueOf = a3 != null ? Integer.valueOf(a3.f()) : null;
        com.example.test.utils.k a10 = y1.a();
        Float valueOf2 = a10 != null ? Float.valueOf(a10.o()) : null;
        com.example.test.utils.k a11 = y1.a();
        Long valueOf3 = a11 != null ? Long.valueOf(a11.C()) : null;
        z2 z2Var = (z2) this.f7251b;
        if (z2Var != null) {
            HalfCircle halfCircle = z2Var.f13484d;
            kotlin.jvm.internal.e.c(valueOf);
            halfCircle.setMaxProgress(valueOf.intValue());
        }
        z2 z2Var2 = (z2) this.f7251b;
        if (z2Var2 != null) {
            z2Var2.f13484d.setProgress(Float.valueOf(stepChartData.getCalorie()));
        }
        z2 z2Var3 = (z2) this.f7251b;
        if (z2Var3 != null) {
            HalfCircle halfCircle2 = z2Var3.f13486g;
            kotlin.jvm.internal.e.c(valueOf2);
            halfCircle2.setMaxProgress(valueOf2.floatValue());
        }
        z2 z2Var4 = (z2) this.f7251b;
        if (z2Var4 != null) {
            z2Var4.f13486g.setProgress(Float.valueOf(stepChartData.getDistance()));
        }
        z2 z2Var5 = (z2) this.f7251b;
        TextView textView = z2Var5 != null ? z2Var5.f13492m : null;
        if (textView != null) {
            textView.setText(String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((int) (stepChartData.getCalorie() * 10)) / 10.0f)}, 1)));
        }
        z2 z2Var6 = (z2) this.f7251b;
        TextView textView2 = z2Var6 != null ? z2Var6.f13493n : null;
        if (textView2 != null) {
            textView2.setText(String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(((int) (stepChartData.getDistance() * 100)) / 100.0f)}, 1)));
        }
        z2 z2Var7 = (z2) this.f7251b;
        if (z2Var7 != null) {
            HalfCircle halfCircle3 = z2Var7.f13489j;
            kotlin.jvm.internal.e.c(valueOf3);
            halfCircle3.setMaxProgress(valueOf3.longValue());
        }
        z2 z2Var8 = (z2) this.f7251b;
        if (z2Var8 != null) {
            z2Var8.f13489j.setProgress(Float.valueOf(stepChartData.getTotalSteps()));
        }
        z2 z2Var9 = (z2) this.f7251b;
        TextView textView3 = z2Var9 != null ? z2Var9.f13495p : null;
        if (textView3 != null) {
            textView3.setText(String.valueOf(stepChartData.getTotalSteps()));
        }
        z2 z2Var10 = (z2) this.f7251b;
        if (z2Var10 != null) {
            BarChart barChart = z2Var10.f13482b;
            if (barChart.getData() == 0 || ((o7.a) barChart.getData()).c() <= 0) {
                List<BarEntry> steps = stepChartData.getSteps();
                if (steps != null) {
                    Iterator<T> it = steps.iterator();
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
                List<BarEntry> steps2 = stepChartData.getSteps();
                if (steps2 == null || steps2.isEmpty() || barEntry == null) {
                    barChart.setData(null);
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
                List<BarEntry> steps3 = stepChartData.getSteps();
                if (steps3 != null) {
                    Iterator<T> it2 = steps3.iterator();
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
                List<BarEntry> steps4 = stepChartData.getSteps();
                if (steps4 == null || steps4.isEmpty() || barEntry2 == null) {
                    ((o7.a) barChart.getData()).h(bVar2);
                    barChart.setData(null);
                } else {
                    bVar2.m(stepChartData.getSteps());
                    ((o7.a) barChart.getData()).a();
                }
                barChart.n();
            }
            barChart.invalidate();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        z2 z2Var = (z2) this.f7251b;
        if (z2Var != null) {
            return z2Var.f13481a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_activity, viewGroup, false);
        int i3 = R$id.chart1;
        BarChart barChart = (BarChart) he.a(i3, inflate);
        if (barChart != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
            i3 = R$id.deplete_progress;
            HalfCircle halfCircle = (HalfCircle) he.a(i3, inflate);
            if (halfCircle != null) {
                i3 = R$id.iv_steptarget;
                ImageView imageView = (ImageView) he.a(i3, inflate);
                if (imageView != null) {
                    i3 = R$id.ll_time;
                    TimeIndicatorView timeIndicatorView = (TimeIndicatorView) he.a(i3, inflate);
                    if (timeIndicatorView != null) {
                        i3 = R$id.mileage_progress;
                        HalfCircle halfCircle2 = (HalfCircle) he.a(i3, inflate);
                        if (halfCircle2 != null) {
                            i3 = R$id.rl_bg;
                            if (((RelativeLayout) he.a(i3, inflate)) != null) {
                                i3 = R$id.rl_info;
                                RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
                                if (relativeLayout != null) {
                                    i3 = R$id.rl_step_num;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) he.a(i3, inflate);
                                    if (relativeLayout2 != null) {
                                        i3 = R$id.step_progress;
                                        HalfCircle halfCircle3 = (HalfCircle) he.a(i3, inflate);
                                        if (halfCircle3 != null) {
                                            i3 = R$id.sv_data;
                                            ScrollView scrollView = (ScrollView) he.a(i3, inflate);
                                            if (scrollView != null) {
                                                i3 = R$id.toolbar;
                                                TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                                                if (tRingToolBarView != null) {
                                                    i3 = R$id.tv_deplete_count;
                                                    TextView textView = (TextView) he.a(i3, inflate);
                                                    if (textView != null) {
                                                        i3 = R$id.tv_mileage_count;
                                                        TextView textView2 = (TextView) he.a(i3, inflate);
                                                        if (textView2 != null) {
                                                            i3 = R$id.tv_step;
                                                            TextView textView3 = (TextView) he.a(i3, inflate);
                                                            if (textView3 != null) {
                                                                i3 = R$id.tv_step_count;
                                                                TextView textView4 = (TextView) he.a(i3, inflate);
                                                                if (textView4 != null) {
                                                                    i3 = R$id.tv_step_num;
                                                                    TextView textView5 = (TextView) he.a(i3, inflate);
                                                                    if (textView5 != null) {
                                                                        i3 = R$id.tv_step_time;
                                                                        TextView textView6 = (TextView) he.a(i3, inflate);
                                                                        if (textView6 != null) {
                                                                            i3 = R$id.tv_step_unit;
                                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                                i3 = R$id.tv_target_calu;
                                                                                TextView textView7 = (TextView) he.a(i3, inflate);
                                                                                if (textView7 != null) {
                                                                                    i3 = R$id.tv_target_distance;
                                                                                    TextView textView8 = (TextView) he.a(i3, inflate);
                                                                                    if (textView8 != null) {
                                                                                        i3 = R$id.tv_target_step;
                                                                                        TextView textView9 = (TextView) he.a(i3, inflate);
                                                                                        if (textView9 != null) {
                                                                                            i3 = R$id.view_date_select;
                                                                                            TRingDateSelectView tRingDateSelectView = (TRingDateSelectView) he.a(i3, inflate);
                                                                                            if (tRingDateSelectView != null) {
                                                                                                i3 = R$id.week_calendar_2;
                                                                                                if (((CalendarLayout) he.a(i3, inflate)) != null) {
                                                                                                    i3 = R$id.weekCalendarView;
                                                                                                    CalendarView calendarView = (CalendarView) he.a(i3, inflate);
                                                                                                    if (calendarView != null) {
                                                                                                        i3 = R$id.wv_progress;
                                                                                                        if (((WaveView) he.a(i3, inflate)) != null) {
                                                                                                            return new z2(constraintLayout, barChart, constraintLayout, halfCircle, imageView, timeIndicatorView, halfCircle2, relativeLayout, relativeLayout2, halfCircle3, scrollView, tRingToolBarView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, tRingDateSelectView, calendarView);
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
        com.example.test.utils.k a3 = y1.a();
        Long valueOf = a3 != null ? Long.valueOf(a3.C()) : null;
        com.example.test.utils.k a10 = y1.a();
        Integer valueOf2 = a10 != null ? Integer.valueOf(a10.f()) : null;
        com.example.test.utils.k a11 = y1.a();
        Float valueOf3 = a11 != null ? Float.valueOf(a11.o()) : null;
        Log.e("qob", "TRingActivityFragment initData stepnum " + valueOf + " calunum " + valueOf2 + " distnum " + valueOf3);
        com.example.test.utils.k a12 = y1.a();
        User d5 = a12 != null ? a12.d() : null;
        if (d5 != null) {
            String string = d5.getMeterUnit() == 0 ? getString(R$string.str_km) : getString(R$string.str_mile);
            kotlin.jvm.internal.e.c(string);
            z2 z2Var = (z2) this.f7251b;
            TextView textView = z2Var != null ? z2Var.f13498t : null;
            if (textView != null) {
                textView.setText(valueOf3 + string);
            }
        }
        z2 z2Var2 = (z2) this.f7251b;
        TextView textView2 = z2Var2 != null ? z2Var2.f13499u : null;
        if (textView2 != null) {
            textView2.setText(valueOf + getString(R$string.str_unit_step));
        }
        z2 z2Var3 = (z2) this.f7251b;
        TextView textView3 = z2Var3 != null ? z2Var3.f13497s : null;
        if (textView3 != null) {
            textView3.setText(valueOf2 + "KCAL");
        }
        z2 z2Var4 = (z2) this.f7251b;
        if (z2Var4 != null) {
            TRingDateSelectView tRingDateSelectView = z2Var4.f13500v;
            tRingDateSelectView.setDateModel(0);
            tRingDateSelectView.setOnDateSelectedListener(new j(this));
            tRingDateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        Resources.Theme theme;
        Log.e("qob", "TRingActivityFragment initView");
        z2 z2Var = (z2) this.f7251b;
        if (z2Var != null) {
            z2Var.e.setOnClickListener(new i(this));
        }
        Calendar calendar = Calendar.getInstance();
        z2 z2Var2 = (z2) this.f7251b;
        if (z2Var2 != null) {
            z2Var2.f13501w.d(PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        }
        z2 z2Var3 = (z2) this.f7251b;
        if (z2Var3 != null) {
            z2Var3.f13501w.setOnCalendarSelectListener(this);
        }
        z2 z2Var4 = (z2) this.f7251b;
        if (z2Var4 != null) {
            z2Var4.f13501w.e();
        }
        z2 z2Var5 = (z2) this.f7251b;
        if (z2Var5 != null) {
            z2Var5.f13491l.setbarStatusIvVisiable(4);
        }
        z2 z2Var6 = (z2) this.f7251b;
        if (z2Var6 != null) {
            z2Var6.f13491l.setOnViewChildListener(new j(this));
        }
        TypedValue typedValue = new TypedValue();
        Context context = getContext();
        if (context != null && (theme = context.getTheme()) != null) {
            theme.resolveAttribute(R$attr.colorOnPrimary, typedValue, true);
        }
        int i3 = typedValue.data;
        z2 z2Var7 = (z2) this.f7251b;
        if (z2Var7 != null) {
            BarChart barChart = z2Var7.f13482b;
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
            barChart.getXAxis().f16386f = new DayFormatter(f0());
            barChart.getAxisLeft().f16386f = new StepYFormatter();
            barChart.getAxisLeft().e = i3;
            barChart.getAxisLeft().h(5, false);
            barChart.getAxisLeft().J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
            barChart.getAxisLeft().H = 15.0f;
            barChart.getAxisLeft().f(0.0f);
            barChart.getAxisRight().f16406a = false;
            barChart.getLegend().f16406a = false;
            barChart.getAxisLeft().b();
            barChart.getAxisLeft().f16402w = true;
            barChart.setNoDataText(getString(R$string.str_no_data));
            barChart.setNoDataTextColor(-1);
            barChart.e();
            barChart.invalidate();
        }
    }

    @Override // md.k
    public final void o(com.haibin.calendarview.Calendar calendar) {
        z2 z2Var = (z2) this.f7251b;
        TextView textView = z2Var != null ? z2Var.r : null;
        if (textView != null) {
            textView.setText("--:--");
        }
        z2 z2Var2 = (z2) this.f7251b;
        TextView textView2 = z2Var2 != null ? z2Var2.f13496q : null;
        if (textView2 != null) {
            textView2.setText("--");
        }
        if (calendar != null) {
            int year = calendar.getYear();
            Locale locale = Locale.US;
            String str = year + "/" + String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendar.getMonth())}, 1)) + "/" + String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendar.getDay())}, 1));
            this.f8204c = str;
            z2 z2Var3 = (z2) this.f7251b;
            if (z2Var3 != null) {
                z2Var3.f13500v.setDate(str);
            }
            ((com.example.test.presenter.main.a) X()).k(this.f8204c);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Log.e("qob", "TRingActivityFragment onDestroy");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Log.e("qob", "TRingActivityFragment onDestroyView");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.e.f(outState, "outState");
        super.onSaveInstanceState(outState);
    }

    public final void q0() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        ConstraintLayout constraintLayout;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        ConstraintLayout constraintLayout2;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        TextView textView14;
        TextView textView15;
        ConstraintLayout constraintLayout3;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
        Log.d("tong", "mainActivity app style = " + valueOf);
        if (valueOf != null && valueOf.intValue() == 0) {
            z2 z2Var = (z2) this.f7251b;
            if (z2Var != null) {
                z2Var.f13491l.setBarTitleColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var2 = (z2) this.f7251b;
            if (z2Var2 != null && (constraintLayout3 = z2Var2.f13483c) != null) {
                constraintLayout3.setBackgroundColor(a1.d.a(f0(), R$color.color_black));
            }
            Drawable b3 = a1.c.b(f0(), R$drawable.svg_ic_tb_share);
            kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            VectorDrawable vectorDrawable = (VectorDrawable) b3;
            vectorDrawable.setTint(a1.d.a(f0(), R$color.color_white));
            z2 z2Var3 = (z2) this.f7251b;
            if (z2Var3 != null) {
                z2Var3.f13491l.setBarOption2Iv(vectorDrawable);
            }
            Drawable b10 = a1.c.b(f0(), R$drawable.svg_ic_activitypage_share);
            kotlin.jvm.internal.e.d(b10, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            VectorDrawable vectorDrawable2 = (VectorDrawable) b10;
            vectorDrawable2.setTint(a1.d.a(f0(), R$color.color_white));
            z2 z2Var4 = (z2) this.f7251b;
            if (z2Var4 != null) {
                z2Var4.e.setImageDrawable(vectorDrawable2);
            }
            z2 z2Var5 = (z2) this.f7251b;
            if (z2Var5 != null) {
                z2Var5.f13495p.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var6 = (z2) this.f7251b;
            if (z2Var6 != null) {
                z2Var6.f13493n.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var7 = (z2) this.f7251b;
            if (z2Var7 != null) {
                z2Var7.f13492m.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var8 = (z2) this.f7251b;
            if (z2Var8 != null) {
                z2Var8.f13500v.setDateColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var9 = (z2) this.f7251b;
            if (z2Var9 != null) {
                z2Var9.f13501w.f(a1.d.a(f0(), R$color.color_white), a1.d.a(f0(), R$color.color_white), a1.d.a(f0(), R$color.color_828282), a1.d.a(f0(), R$color.color_white), a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var10 = (z2) this.f7251b;
            if (z2Var10 != null) {
                z2Var10.f13501w.g(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var11 = (z2) this.f7251b;
            if (z2Var11 != null) {
                z2Var11.f13487h.setBackgroundResource(R$drawable.shape_cell_background_grey);
            }
            z2 z2Var12 = (z2) this.f7251b;
            if (z2Var12 != null) {
                z2Var12.f13488i.setBackgroundResource(R$drawable.shape_cell_background_grey);
            }
            z2 z2Var13 = (z2) this.f7251b;
            if (z2Var13 != null) {
                z2Var13.f13494o.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var14 = (z2) this.f7251b;
            if (z2Var14 != null) {
                z2Var14.f13496q.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var15 = (z2) this.f7251b;
            if (z2Var15 != null) {
                z2Var15.r.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var16 = (z2) this.f7251b;
            if (z2Var16 != null && (textView15 = (TextView) z2Var16.f13485f.findViewById(R$id.tv1)) != null) {
                textView15.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var17 = (z2) this.f7251b;
            if (z2Var17 != null && (textView14 = (TextView) z2Var17.f13485f.findViewById(R$id.tv2)) != null) {
                textView14.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var18 = (z2) this.f7251b;
            if (z2Var18 != null && (textView13 = (TextView) z2Var18.f13485f.findViewById(R$id.tv3)) != null) {
                textView13.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var19 = (z2) this.f7251b;
            if (z2Var19 != null && (textView12 = (TextView) z2Var19.f13485f.findViewById(R$id.tv4)) != null) {
                textView12.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var20 = (z2) this.f7251b;
            if (z2Var20 != null && (textView11 = (TextView) z2Var20.f13485f.findViewById(R$id.tv5)) != null) {
                textView11.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            z2 z2Var21 = (z2) this.f7251b;
            if (z2Var21 != null) {
                BarChart barChart = z2Var21.f13482b;
                barChart.getAxisLeft().e = -1;
                barChart.invalidate();
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            z2 z2Var22 = (z2) this.f7251b;
            if (z2Var22 != null) {
                z2Var22.f13491l.setBarTitleColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var23 = (z2) this.f7251b;
            if (z2Var23 != null && (constraintLayout2 = z2Var23.f13483c) != null) {
                constraintLayout2.setBackgroundColor(a1.d.a(f0(), R$color.color_greywhite));
            }
            Drawable b11 = a1.c.b(f0(), R$drawable.svg_ic_tb_share);
            kotlin.jvm.internal.e.d(b11, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            VectorDrawable vectorDrawable3 = (VectorDrawable) b11;
            vectorDrawable3.setTint(a1.d.a(f0(), R$color.color_black));
            z2 z2Var24 = (z2) this.f7251b;
            if (z2Var24 != null) {
                z2Var24.f13491l.setBarOption2Iv(vectorDrawable3);
            }
            Drawable b12 = a1.c.b(f0(), R$drawable.svg_ic_activitypage_share);
            kotlin.jvm.internal.e.d(b12, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            VectorDrawable vectorDrawable4 = (VectorDrawable) b12;
            vectorDrawable4.setTint(a1.d.a(f0(), R$color.color_black));
            z2 z2Var25 = (z2) this.f7251b;
            if (z2Var25 != null) {
                z2Var25.e.setImageDrawable(vectorDrawable4);
            }
            z2 z2Var26 = (z2) this.f7251b;
            if (z2Var26 != null) {
                z2Var26.f13495p.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var27 = (z2) this.f7251b;
            if (z2Var27 != null) {
                z2Var27.f13493n.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var28 = (z2) this.f7251b;
            if (z2Var28 != null) {
                z2Var28.f13492m.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var29 = (z2) this.f7251b;
            if (z2Var29 != null) {
                z2Var29.f13500v.setDateColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var30 = (z2) this.f7251b;
            if (z2Var30 != null) {
                z2Var30.f13501w.f(a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_828282), a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var31 = (z2) this.f7251b;
            if (z2Var31 != null) {
                z2Var31.f13501w.g(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var32 = (z2) this.f7251b;
            if (z2Var32 != null) {
                z2Var32.f13487h.setBackgroundResource(R$drawable.shape_cell_background_white);
            }
            z2 z2Var33 = (z2) this.f7251b;
            if (z2Var33 != null) {
                z2Var33.f13488i.setBackgroundResource(R$drawable.shape_cell_background_white);
            }
            z2 z2Var34 = (z2) this.f7251b;
            if (z2Var34 != null) {
                z2Var34.f13494o.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var35 = (z2) this.f7251b;
            if (z2Var35 != null) {
                z2Var35.f13496q.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var36 = (z2) this.f7251b;
            if (z2Var36 != null) {
                z2Var36.r.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var37 = (z2) this.f7251b;
            if (z2Var37 != null && (textView10 = (TextView) z2Var37.f13485f.findViewById(R$id.tv1)) != null) {
                textView10.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var38 = (z2) this.f7251b;
            if (z2Var38 != null && (textView9 = (TextView) z2Var38.f13485f.findViewById(R$id.tv2)) != null) {
                textView9.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var39 = (z2) this.f7251b;
            if (z2Var39 != null && (textView8 = (TextView) z2Var39.f13485f.findViewById(R$id.tv3)) != null) {
                textView8.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var40 = (z2) this.f7251b;
            if (z2Var40 != null && (textView7 = (TextView) z2Var40.f13485f.findViewById(R$id.tv4)) != null) {
                textView7.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var41 = (z2) this.f7251b;
            if (z2Var41 != null && (textView6 = (TextView) z2Var41.f13485f.findViewById(R$id.tv5)) != null) {
                textView6.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var42 = (z2) this.f7251b;
            if (z2Var42 != null) {
                BarChart barChart2 = z2Var42.f13482b;
                barChart2.getAxisLeft().e = -16777216;
                barChart2.invalidate();
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 2) {
            z2 z2Var43 = (z2) this.f7251b;
            if (z2Var43 != null) {
                z2Var43.f13491l.setBarTitleColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var44 = (z2) this.f7251b;
            if (z2Var44 != null && (constraintLayout = z2Var44.f13483c) != null) {
                constraintLayout.setBackgroundColor(a1.d.a(f0(), R$color.color_pink));
            }
            Drawable b13 = a1.c.b(f0(), R$drawable.svg_ic_tb_share);
            kotlin.jvm.internal.e.d(b13, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            VectorDrawable vectorDrawable5 = (VectorDrawable) b13;
            vectorDrawable5.setTint(a1.d.a(f0(), R$color.color_black));
            z2 z2Var45 = (z2) this.f7251b;
            if (z2Var45 != null) {
                z2Var45.f13491l.setBarOption2Iv(vectorDrawable5);
            }
            Drawable b14 = a1.c.b(f0(), R$drawable.svg_ic_activitypage_share);
            kotlin.jvm.internal.e.d(b14, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            VectorDrawable vectorDrawable6 = (VectorDrawable) b14;
            vectorDrawable6.setTint(a1.d.a(f0(), R$color.color_black));
            z2 z2Var46 = (z2) this.f7251b;
            if (z2Var46 != null) {
                z2Var46.e.setImageDrawable(vectorDrawable6);
            }
            z2 z2Var47 = (z2) this.f7251b;
            if (z2Var47 != null) {
                z2Var47.f13495p.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var48 = (z2) this.f7251b;
            if (z2Var48 != null) {
                z2Var48.f13493n.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var49 = (z2) this.f7251b;
            if (z2Var49 != null) {
                z2Var49.f13492m.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var50 = (z2) this.f7251b;
            if (z2Var50 != null) {
                z2Var50.f13500v.setDateColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var51 = (z2) this.f7251b;
            if (z2Var51 != null) {
                z2Var51.f13501w.f(a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_828282), a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var52 = (z2) this.f7251b;
            if (z2Var52 != null) {
                z2Var52.f13501w.g(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var53 = (z2) this.f7251b;
            if (z2Var53 != null) {
                z2Var53.f13487h.setBackgroundResource(R$drawable.shape_cell_background_white);
            }
            z2 z2Var54 = (z2) this.f7251b;
            if (z2Var54 != null) {
                z2Var54.f13488i.setBackgroundResource(R$drawable.shape_cell_background_white);
            }
            z2 z2Var55 = (z2) this.f7251b;
            if (z2Var55 != null) {
                z2Var55.f13494o.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var56 = (z2) this.f7251b;
            if (z2Var56 != null) {
                z2Var56.f13496q.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var57 = (z2) this.f7251b;
            if (z2Var57 != null) {
                z2Var57.r.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var58 = (z2) this.f7251b;
            if (z2Var58 != null && (textView5 = (TextView) z2Var58.f13485f.findViewById(R$id.tv1)) != null) {
                textView5.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var59 = (z2) this.f7251b;
            if (z2Var59 != null && (textView4 = (TextView) z2Var59.f13485f.findViewById(R$id.tv2)) != null) {
                textView4.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var60 = (z2) this.f7251b;
            if (z2Var60 != null && (textView3 = (TextView) z2Var60.f13485f.findViewById(R$id.tv3)) != null) {
                textView3.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var61 = (z2) this.f7251b;
            if (z2Var61 != null && (textView2 = (TextView) z2Var61.f13485f.findViewById(R$id.tv4)) != null) {
                textView2.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var62 = (z2) this.f7251b;
            if (z2Var62 != null && (textView = (TextView) z2Var62.f13485f.findViewById(R$id.tv5)) != null) {
                textView.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            z2 z2Var63 = (z2) this.f7251b;
            if (z2Var63 != null) {
                BarChart barChart3 = z2Var63.f13482b;
                barChart3.getAxisLeft().e = -16777216;
                barChart3.invalidate();
            }
        }
    }

    @Override // t7.d
    public final void x(Entry entry) {
        String str = (entry != null ? Integer.valueOf((int) entry.j()) : null) + ":00";
        String valueOf = String.valueOf(entry != null ? Integer.valueOf((int) entry.d()) : null);
        z2 z2Var = (z2) this.f7251b;
        TextView textView = z2Var != null ? z2Var.r : null;
        if (textView != null) {
            textView.setText(str);
        }
        z2 z2Var2 = (z2) this.f7251b;
        TextView textView2 = z2Var2 != null ? z2Var2.f13496q : null;
        if (textView2 == null) {
            return;
        }
        textView2.setText(valueOf);
    }
}
