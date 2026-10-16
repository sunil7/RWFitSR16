package com.example.test.ui.testui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.formatter.DayFormatter;
import com.example.test.ui.model.chart.formatter.MonthFormatter;
import com.example.test.ui.model.chart.formatter.WeekFormatter;
import com.example.test.ui.model.chart.formatter.YearFormatter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.EntryDate;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingBloodSugarStatisticsActivity extends XXBaseActivity<com.example.test.presenter.main.r, f6.j> implements g7.h, View.OnClickListener, t7.d, CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ int J = 0;
    public final String E = "TRingBloodSugarStatisticsActivity";
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingBloodSugarStatisticsActivity$statisticsType$2
        @Override // oh.a
        public final Integer invoke() {
            return 0;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingBloodSugarStatisticsActivity$drinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });
    public String H = "";
    public int I;

    @Override // t7.d
    public final void A() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.r(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((f6.j) this.f7247z.getValue()).f12998a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_bloodsugar_statistics, (ViewGroup) null, false);
        int i3 = R$id.chart1;
        LineChart lineChart = (LineChart) he.a(i3, inflate);
        if (lineChart != null) {
            i3 = R$id.end_time;
            TextView textView = (TextView) he.a(i3, inflate);
            if (textView != null) {
                i3 = R$id.iv_heart_real_icon;
                if (((ImageView) he.a(i3, inflate)) != null) {
                    i3 = R$id.ll_desc;
                    LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                    if (linearLayout != null) {
                        i3 = R$id.ll_hr_value;
                        if (((LinearLayout) he.a(i3, inflate)) != null) {
                            i3 = R$id.ll_realtime;
                            if (((LinearLayout) he.a(i3, inflate)) != null) {
                                i3 = R$id.ll_time;
                                LinearLayout linearLayout2 = (LinearLayout) he.a(i3, inflate);
                                if (linearLayout2 != null) {
                                    i3 = R$id.nsv_data;
                                    NestedScrollView nestedScrollView = (NestedScrollView) he.a(i3, inflate);
                                    if (nestedScrollView != null) {
                                        i3 = R$id.rl_health_detaildata;
                                        RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
                                        if (relativeLayout != null) {
                                            i3 = R$id.scBtn;
                                            SwitchCompat switchCompat = (SwitchCompat) he.a(i3, inflate);
                                            if (switchCompat != null) {
                                                i3 = R$id.start_time;
                                                TextView textView2 = (TextView) he.a(i3, inflate);
                                                if (textView2 != null) {
                                                    i3 = R$id.toolbar;
                                                    TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                                                    if (tRingToolBarView != null) {
                                                        i3 = R$id.tv_bs_avg;
                                                        TextView textView3 = (TextView) he.a(i3, inflate);
                                                        if (textView3 != null) {
                                                            i3 = R$id.tv_bs_max;
                                                            TextView textView4 = (TextView) he.a(i3, inflate);
                                                            if (textView4 != null) {
                                                                i3 = R$id.tv_bs_min;
                                                                TextView textView5 = (TextView) he.a(i3, inflate);
                                                                if (textView5 != null) {
                                                                    i3 = R$id.tv_bs_tips;
                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                        i3 = R$id.tv_data_title;
                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                            i3 = R$id.tv_hr_currentvalue;
                                                                            TextView textView6 = (TextView) he.a(i3, inflate);
                                                                            if (textView6 != null) {
                                                                                i3 = R$id.tv_hr_detail_title;
                                                                                if (((TextView) he.a(i3, inflate)) != null) {
                                                                                    i3 = R$id.tv_hr_unit;
                                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                                        i3 = R$id.tv_realtime_data_title;
                                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                                            i3 = R$id.tv_rt_hr;
                                                                                            TextView textView7 = (TextView) he.a(i3, inflate);
                                                                                            if (textView7 != null) {
                                                                                                i3 = R$id.tv_rt_hr_unit;
                                                                                                TextView textView8 = (TextView) he.a(i3, inflate);
                                                                                                if (textView8 != null) {
                                                                                                    i3 = R$id.tv_start_test;
                                                                                                    TextView textView9 = (TextView) he.a(i3, inflate);
                                                                                                    if (textView9 != null) {
                                                                                                        i3 = R$id.tv_title;
                                                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                            i3 = R$id.view_date_select;
                                                                                                            TRingDateSelectView tRingDateSelectView = (TRingDateSelectView) he.a(i3, inflate);
                                                                                                            if (tRingDateSelectView != null) {
                                                                                                                return new f6.j((ConstraintLayout) inflate, lineChart, textView, linearLayout, linearLayout2, nestedScrollView, relativeLayout, switchCompat, textView2, tRingToolBarView, textView3, textView4, textView5, textView6, textView7, textView8, textView9, tRingDateSelectView);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        TRingDateSelectView tRingDateSelectView = ((f6.j) this.f7247z.getValue()).r;
        tRingDateSelectView.setDateModel(((Number) this.F.getValue()).intValue());
        tRingDateSelectView.setOnDateSelectedListener(new m(this));
        tRingDateSelectView.c();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        f6.j jVar = (f6.j) this.f7247z.getValue();
        if (jVar != null) {
            jVar.f13013q.setOnClickListener(this);
        }
        ((f6.j) this.f7247z.getValue()).f13004h.setOnCheckedChangeListener(this);
        ((com.example.test.presenter.main.r) I0()).k();
        f6.j jVar2 = (f6.j) this.f7247z.getValue();
        if (jVar2 != null) {
            jVar2.f13001d.setOnClickListener(this);
        }
        f6.j jVar3 = (f6.j) this.f7247z.getValue();
        if (jVar3 != null) {
            jVar3.f13006j.setOnViewChildListener(new m(this));
        }
        ((f6.j) this.f7247z.getValue()).f13003g.setOnClickListener(this);
        f6.j jVar4 = (f6.j) this.f7247z.getValue();
        if (jVar4 != null) {
            LineChart lineChart = jVar4.f12999b;
            lineChart.setOnChartValueSelectedListener(this);
            lineChart.setDrawGridBackground(false);
            lineChart.getDescription().f16406a = false;
            lineChart.setTouchEnabled(true);
            lineChart.setDragEnabled(true);
            lineChart.setScaleEnabled(false);
            lineChart.setPinchZoom(false);
            lineChart.getXAxis().I = XAxis$XAxisPosition.BOTTOM;
            lineChart.getXAxis().g();
            lineChart.getXAxis().e = getColor(R$color.ring_activitypage_text_mask);
            lineChart.getXAxis().r = false;
            int intValue = ((Number) this.F.getValue()).intValue();
            if (intValue == 0) {
                f6.j jVar5 = (f6.j) this.f7247z.getValue();
                LinearLayout linearLayout = jVar5 != null ? jVar5.e : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                lineChart.getXAxis().f16386f = new DayFormatter(this);
            } else if (intValue == 1) {
                lineChart.getXAxis().f16386f = new WeekFormatter(this);
            } else if (intValue == 2) {
                lineChart.getXAxis().f16386f = new MonthFormatter(this);
            } else if (intValue == 3) {
                lineChart.getXAxis().f16386f = new YearFormatter(this);
            }
            lineChart.getAxisLeft().getClass();
            lineChart.getAxisLeft().f(0.0f);
            lineChart.getAxisRight().f16406a = false;
            lineChart.getAxisLeft().h(4, false);
            lineChart.getAxisLeft().e = getColor(R$color.ring_activitypage_text_mask);
            lineChart.getAxisLeft().J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
            lineChart.getAxisLeft().B = 0.0f;
            lineChart.getAxisLeft().b();
            lineChart.getAxisLeft().f16402w = true;
            lineChart.setNoDataText(getString(R$string.str_no_data));
            lineChart.setNoDataTextColor(-1);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
            if (valueOf == null || valueOf.intValue() != 0) {
                lineChart.setNoDataTextColor(-16777216);
            }
            lineChart.getLegend().f16406a = false;
            lineChart.invalidate();
        }
    }

    public final void c(DrinkReminderBean drinkReminderBean) {
        kotlin.jvm.internal.e.f(drinkReminderBean, "drinkReminderBean");
        Log.d(this.E, r5.a.d("onData  isopen = ", drinkReminderBean.isOpen()));
        eh.b bVar = this.G;
        ((DrinkReminderBean) bVar.getValue()).setOpen(drinkReminderBean.isOpen());
        eh.b bVar2 = this.f7247z;
        ((f6.j) bVar2.getValue()).f13004h.setOnCheckedChangeListener(null);
        ((f6.j) bVar2.getValue()).f13004h.setChecked(((DrinkReminderBean) bVar.getValue()).isOpen());
        ((f6.j) bVar2.getValue()).f13004h.setOnCheckedChangeListener(this);
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton p02, boolean z5) {
        kotlin.jvm.internal.e.f(p02, "p0");
        eh.b bVar = this.G;
        if (z5) {
            ((DrinkReminderBean) bVar.getValue()).setOpen(true);
        } else {
            ((DrinkReminderBean) bVar.getValue()).setOpen(false);
        }
        com.example.test.presenter.main.r rVar = (com.example.test.presenter.main.r) I0();
        DrinkReminderBean data = (DrinkReminderBean) bVar.getValue();
        rVar.getClass();
        kotlin.jvm.internal.e.f(data, "data");
        data.setRemindDuration(60);
        data.setStartHour(0);
        data.setStartMin(0);
        data.setEndHour(23);
        data.setEndMin(59);
        rVar.f7552d = data;
        ((XXBaseActivity) ((g7.h) rVar.f7255a)).V();
        data.setRemindDuration(60);
        com.google.android.gms.internal.mlkit_vision_common.p.L(data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.ll_desc;
        if (valueOf != null && valueOf.intValue() == i3) {
            Intent intent = new Intent(this, (Class<?>) TRingBloodOxygenDescActivity.class);
            intent.putExtra("type", 4);
            startActivity(intent);
            return;
        }
        int i10 = R$id.rl_health_detaildata;
        if (valueOf != null && valueOf.intValue() == i10) {
            Intent intent2 = new Intent(this, (Class<?>) TRingHealthDetailActivity.class);
            intent2.putExtra("healthDataType", 4);
            intent2.putExtra("healthDate", this.H);
            startActivity(intent2);
            return;
        }
        int i11 = R$id.tv_start_test;
        if (valueOf != null && valueOf.intValue() == i11) {
            int i12 = this.I;
            eh.b bVar = this.f7247z;
            if (i12 == 0) {
                ((com.example.test.presenter.main.r) I0()).getClass();
                com.example.test.presenter.main.r.m((byte) 1);
                this.I = 1;
                f6.j jVar = (f6.j) bVar.getValue();
                textView = jVar != null ? jVar.f13013q : null;
                if (textView != null) {
                    textView.setText(getString(R$string.ring_end_measure));
                }
                f6.j jVar2 = (f6.j) bVar.getValue();
                if (jVar2 != null) {
                    jVar2.f13013q.setBackgroundResource(R$drawable.shape_block_text_press_button);
                    return;
                }
                return;
            }
            ((com.example.test.presenter.main.r) I0()).getClass();
            com.example.test.presenter.main.r.m((byte) 0);
            this.I = 0;
            f6.j jVar3 = (f6.j) bVar.getValue();
            textView = jVar3 != null ? jVar3.f13013q : null;
            if (textView != null) {
                textView.setText(getString(R$string.ring_begin_measure));
            }
            f6.j jVar4 = (f6.j) bVar.getValue();
            if (jVar4 != null) {
                jVar4.f13013q.setBackgroundResource(R$drawable.shape_block_text_button);
            }
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b0();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            b0();
            return;
        }
        if (status != 2) {
            if (status == 3) {
                Q0(R$string.str_binding);
                return;
            }
            if (status == 4) {
                b0();
            } else if (status != 5) {
                b0();
            } else {
                b0();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        b2.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        ((com.example.test.presenter.main.r) I0()).getClass();
        com.example.test.presenter.main.r.m((byte) 0);
        this.I = 0;
        eh.b bVar = this.f7247z;
        f6.j jVar = (f6.j) bVar.getValue();
        TextView textView = jVar != null ? jVar.f13013q : null;
        if (textView != null) {
            textView.setText(getString(R$string.ring_begin_measure));
        }
        f6.j jVar2 = (f6.j) bVar.getValue();
        if (jVar2 != null) {
            jVar2.f13013q.setBackgroundResource(R$drawable.shape_block_text_button);
        }
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(EventBusBeans.SyncDataEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        if (syncEvent.getSyncType() == 9) {
            runOnUiThread(new androidx.appcompat.app.i0(12, this, syncEvent));
        }
    }

    @Override // t7.d
    public final void x(Entry entry) {
        String str;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{entry != null ? Float.valueOf(entry.d()) : null}, 1));
        if (entry instanceof EntryDate) {
            long longValue = ((EntryDate) entry).l().longValue() * 1000;
            try {
                str = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(Long.valueOf(longValue));
            } catch (Exception e) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(longValue, " date translate error ", e.getMessage()));
                str = null;
            }
            format = r5.a.c(str, " -- ", format);
        }
        f6.j jVar = (f6.j) this.f7247z.getValue();
        TextView textView = jVar != null ? jVar.f13010n : null;
        if (textView == null) {
            return;
        }
        textView.setText(format);
    }
}
