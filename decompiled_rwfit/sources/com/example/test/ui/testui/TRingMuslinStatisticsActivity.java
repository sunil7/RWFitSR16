package com.example.test.ui.testui;

import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.formatter.DayFormatter;
import com.example.test.ui.model.chart.formatter.StepYFormatter;
import com.example.test.ui.view.TimeIndicatorView;
import com.example.test.ui.view.WaveView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.material.R$attr;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingMuslinStatisticsActivity extends XXBaseActivity<com.example.test.presenter.main.b1, f6.v0> implements g7.s, View.OnClickListener, t7.d {
    public static final /* synthetic */ int F = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingMuslinStatisticsActivity$statisticsType$2
        @Override // oh.a
        public final Integer invoke() {
            return 0;
        }
    });

    @Override // t7.d
    public final void A() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.b1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((f6.v0) this.f7247z.getValue()).f13389a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_muslin_statistics, (ViewGroup) null, false);
        int i3 = R$id.chart1;
        BarChart barChart = (BarChart) he.a(i3, inflate);
        if (barChart != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
            i3 = R$id.ll_desc;
            LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
            if (linearLayout != null) {
                i3 = R$id.ll_time;
                if (((TimeIndicatorView) he.a(i3, inflate)) != null) {
                    i3 = R$id.rl_bg;
                    if (((RelativeLayout) he.a(i3, inflate)) != null) {
                        i3 = R$id.rl_step_num;
                        if (((RelativeLayout) he.a(i3, inflate)) != null) {
                            i3 = R$id.sv_data;
                            if (((ScrollView) he.a(i3, inflate)) != null) {
                                i3 = R$id.toolbar;
                                TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                                if (tRingToolBarView != null) {
                                    i3 = R$id.tv_hr_avg;
                                    TextView textView = (TextView) he.a(i3, inflate);
                                    if (textView != null) {
                                        i3 = R$id.tv_hr_max;
                                        TextView textView2 = (TextView) he.a(i3, inflate);
                                        if (textView2 != null) {
                                            i3 = R$id.tv_hr_min;
                                            TextView textView3 = (TextView) he.a(i3, inflate);
                                            if (textView3 != null) {
                                                i3 = R$id.tv_muslin_title;
                                                if (((TextView) he.a(i3, inflate)) != null) {
                                                    i3 = R$id.tv_step_num;
                                                    TextView textView4 = (TextView) he.a(i3, inflate);
                                                    if (textView4 != null) {
                                                        i3 = R$id.tv_step_unit;
                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                            i3 = R$id.view_date_select;
                                                            TRingDateSelectView tRingDateSelectView = (TRingDateSelectView) he.a(i3, inflate);
                                                            if (tRingDateSelectView != null) {
                                                                i3 = R$id.wv_progress;
                                                                if (((WaveView) he.a(i3, inflate)) != null) {
                                                                    return new f6.v0(constraintLayout, barChart, linearLayout, tRingToolBarView, textView, textView2, textView3, textView4, tRingDateSelectView);
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

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        f6.v0 v0Var = (f6.v0) this.f7247z.getValue();
        if (v0Var != null) {
            TRingDateSelectView tRingDateSelectView = v0Var.f13396i;
            tRingDateSelectView.setDateModel(((Number) this.E.getValue()).intValue());
            tRingDateSelectView.setOnDateSelectedListener(new i0(this));
            tRingDateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        f6.v0 v0Var = (f6.v0) this.f7247z.getValue();
        if (v0Var != null) {
            v0Var.f13392d.setOnViewChildListener(new i0(this));
        }
        ((f6.v0) this.f7247z.getValue()).f13391c.setOnClickListener(this);
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R$attr.colorOnPrimary, typedValue, true);
        int i3 = typedValue.data;
        f6.v0 v0Var2 = (f6.v0) this.f7247z.getValue();
        if (v0Var2 != null) {
            BarChart barChart = v0Var2.f13390b;
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
            barChart.getXAxis().f16386f = new DayFormatter(this);
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
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
            if (valueOf == null || valueOf.intValue() != 0) {
                barChart.setNoDataTextColor(-16777216);
            }
            barChart.e();
            barChart.invalidate();
        }
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.ll_desc;
        if (valueOf != null && valueOf.intValue() == i3) {
            Intent intent = new Intent(this, (Class<?>) TRingBloodOxygenDescActivity.class);
            intent.putExtra("type", 5);
            startActivity(intent);
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        b2.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(EventBusBeans.SyncDataEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        if (syncEvent.getSyncType() == 6) {
            runOnUiThread(new com.example.blesdk.service.z(3));
        }
    }

    @Override // t7.d
    public final void x(Entry entry) {
        if (entry != null) {
            entry.j();
        }
        String valueOf = String.valueOf(entry != null ? Integer.valueOf((int) entry.d()) : null);
        f6.v0 v0Var = (f6.v0) this.f7247z.getValue();
        TextView textView = v0Var != null ? v0Var.f13395h : null;
        if (textView == null) {
            return;
        }
        textView.setText(valueOf);
    }
}
