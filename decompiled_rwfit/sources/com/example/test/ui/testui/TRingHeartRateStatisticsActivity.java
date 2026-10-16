package com.example.test.ui.testui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
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
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.HrChartData;
import com.example.test.ui.model.chart.formatter.DayFormatter;
import com.example.test.ui.model.chart.formatter.MonthFormatter;
import com.example.test.ui.model.chart.formatter.WeekFormatter;
import com.example.test.ui.model.chart.formatter.YearFormatter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet$Mode;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingHeartRateStatisticsActivity extends XXBaseActivity<com.example.test.presenter.main.u0, f6.k0> implements g7.o, View.OnClickListener, t7.d, CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ int K = 0;
    public int H;
    public int J;
    public final String E = "TRingHeartRateStatistic";
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingHeartRateStatisticsActivity$statisticsType$2
        @Override // oh.a
        public final Integer invoke() {
            return 0;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingHeartRateStatisticsActivity$drinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });
    public String I = "";

    @Override // t7.d
    public final void A() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g7.o
    public final void F(HrChartData hrChartData) {
        f6.k0 k0Var;
        f6.k0 k0Var2;
        Entry entry;
        Object obj;
        Entry entry2;
        Object obj2;
        Entry entry3;
        Object obj3;
        eh.b bVar = this.F;
        int intValue = ((Number) bVar.getValue()).intValue();
        eh.b bVar2 = this.f7247z;
        if (intValue == 0) {
            List<Entry> items = hrChartData.getItems();
            if (items != null) {
                Iterator<T> it = items.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj3 = null;
                        break;
                    } else {
                        obj3 = it.next();
                        if (((Entry) obj3).d() > 0.0f) {
                            break;
                        }
                    }
                }
                entry3 = (Entry) obj3;
            } else {
                entry3 = null;
            }
            List<Entry> items2 = hrChartData.getItems();
            if (items2 == null || items2.isEmpty() || entry3 == null) {
                f6.k0 k0Var3 = (f6.k0) bVar2.getValue();
                LinearLayout linearLayout = k0Var3 != null ? k0Var3.e : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else {
                f6.k0 k0Var4 = (f6.k0) bVar2.getValue();
                LinearLayout linearLayout2 = k0Var4 != null ? k0Var4.e : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
            }
        }
        f6.k0 k0Var5 = (f6.k0) bVar2.getValue();
        if (k0Var5 != null) {
            LineChart lineChart = k0Var5.f13028b;
            if (lineChart.getData() == 0 || ((o7.j) lineChart.getData()).c() <= 0) {
                List<Entry> items3 = hrChartData.getItems();
                if (items3 != null) {
                    Iterator<T> it2 = items3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it2.next();
                            if (((Entry) obj).d() > 0.0f) {
                                break;
                            }
                        }
                    }
                    entry = (Entry) obj;
                } else {
                    entry = null;
                }
                List<Entry> items4 = hrChartData.getItems();
                if (items4 == null || items4.isEmpty() || entry == null) {
                    lineChart.setData(null);
                    lineChart.n();
                } else {
                    o7.k kVar = new o7.k(hrChartData.getItems());
                    kVar.B = LineDataSet$Mode.CUBIC_BEZIER;
                    kVar.G = 0.2f;
                    kVar.A = true;
                    kVar.I = false;
                    kVar.f16824t = android.support.v4.media.session.e.a(kVar, 244, 117, 117);
                    kVar.l(getResources().getColor(R$color.color_dc2641));
                    kVar.f16837x = getResources().getColor(R$color.color_dc2641);
                    kVar.f16838y = 60;
                    kVar.f16835v = false;
                    kVar.H = new com.example.test.ui.sport.activity.l(lineChart, 6);
                    o7.j jVar = new o7.j(kVar);
                    jVar.j();
                    jVar.i();
                    lineChart.setData(jVar);
                }
            } else {
                o7.d b3 = ((o7.j) lineChart.getData()).b(0);
                kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
                o7.k kVar2 = (o7.k) b3;
                List<Entry> items5 = hrChartData.getItems();
                if (items5 != null) {
                    Iterator<T> it3 = items5.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj2 = null;
                            break;
                        } else {
                            obj2 = it3.next();
                            if (((Entry) obj2).d() > 0.0f) {
                                break;
                            }
                        }
                    }
                    entry2 = (Entry) obj2;
                } else {
                    entry2 = null;
                }
                List<Entry> items6 = hrChartData.getItems();
                if (items6 == null || items6.isEmpty() || entry2 == null) {
                    ((o7.j) lineChart.getData()).h(kVar2);
                    lineChart.setData(null);
                } else {
                    kVar2.m(hrChartData.getItems());
                    ((o7.j) lineChart.getData()).a();
                }
                lineChart.n();
            }
            lineChart.invalidate();
        }
        String valueOf = hrChartData.getCurrentHr() == 0 ? "--" : String.valueOf(hrChartData.getCurrentHr());
        String valueOf2 = hrChartData.getMaxHr() == 0 ? "--" : String.valueOf(hrChartData.getMaxHr());
        String valueOf3 = hrChartData.getMinHr() == 0 ? "--" : String.valueOf(hrChartData.getMinHr());
        String valueOf4 = hrChartData.getAvgHr() != 0 ? String.valueOf(hrChartData.getAvgHr()) : "--";
        f6.k0 k0Var6 = (f6.k0) bVar2.getValue();
        if (k0Var6 != null) {
            k0Var6.f13038m.setText(valueOf);
        }
        f6.k0 k0Var7 = (f6.k0) bVar2.getValue();
        if (k0Var7 != null) {
            k0Var7.f13039n.setText(valueOf2);
        }
        f6.k0 k0Var8 = (f6.k0) bVar2.getValue();
        if (k0Var8 != null) {
            k0Var8.f13040o.setText(valueOf3);
        }
        f6.k0 k0Var9 = (f6.k0) bVar2.getValue();
        if (k0Var9 != null) {
            k0Var9.f13037l.setText(valueOf4);
        }
        if (((Number) bVar.getValue()).intValue() == 0) {
            f6.k0 k0Var10 = (f6.k0) bVar2.getValue();
            TextView textView = k0Var10 != null ? k0Var10.f13034i : null;
            if (textView != null) {
                textView.setText("00:00");
            }
            f6.k0 k0Var11 = (f6.k0) bVar2.getValue();
            TextView textView2 = k0Var11 != null ? k0Var11.f13029c : null;
            if (textView2 != null) {
                textView2.setText("24:00");
            }
            String startTime = hrChartData.getStartTime();
            if (startTime != null && (k0Var2 = (f6.k0) bVar2.getValue()) != null) {
                k0Var2.f13034i.setText(startTime);
            }
            String endTime = hrChartData.getEndTime();
            if (endTime == null || (k0Var = (f6.k0) bVar2.getValue()) == null) {
                return;
            }
            k0Var.f13029c.setText(endTime);
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.u0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((f6.k0) this.f7247z.getValue()).f13027a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_heartratestatistics, (ViewGroup) null, false);
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
                                                        i3 = R$id.tv_data_title;
                                                        TextView textView3 = (TextView) he.a(i3, inflate);
                                                        if (textView3 != null) {
                                                            i3 = R$id.tv_hr_avg;
                                                            TextView textView4 = (TextView) he.a(i3, inflate);
                                                            if (textView4 != null) {
                                                                i3 = R$id.tv_hr_currentvalue;
                                                                TextView textView5 = (TextView) he.a(i3, inflate);
                                                                if (textView5 != null) {
                                                                    i3 = R$id.tv_hr_detail_title;
                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                        i3 = R$id.tv_hr_max;
                                                                        TextView textView6 = (TextView) he.a(i3, inflate);
                                                                        if (textView6 != null) {
                                                                            i3 = R$id.tv_hr_min;
                                                                            TextView textView7 = (TextView) he.a(i3, inflate);
                                                                            if (textView7 != null) {
                                                                                i3 = R$id.tv_hr_tips;
                                                                                TextView textView8 = (TextView) he.a(i3, inflate);
                                                                                if (textView8 != null) {
                                                                                    i3 = R$id.tv_hr_unit;
                                                                                    TextView textView9 = (TextView) he.a(i3, inflate);
                                                                                    if (textView9 != null) {
                                                                                        i3 = R$id.tv_realtime_data_title;
                                                                                        TextView textView10 = (TextView) he.a(i3, inflate);
                                                                                        if (textView10 != null) {
                                                                                            i3 = R$id.tv_rt_hr;
                                                                                            TextView textView11 = (TextView) he.a(i3, inflate);
                                                                                            if (textView11 != null) {
                                                                                                i3 = R$id.tv_rt_hr_unit;
                                                                                                TextView textView12 = (TextView) he.a(i3, inflate);
                                                                                                if (textView12 != null) {
                                                                                                    i3 = R$id.tv_start_test;
                                                                                                    TextView textView13 = (TextView) he.a(i3, inflate);
                                                                                                    if (textView13 != null) {
                                                                                                        i3 = R$id.tv_title;
                                                                                                        TextView textView14 = (TextView) he.a(i3, inflate);
                                                                                                        if (textView14 != null) {
                                                                                                            i3 = R$id.view_date_select;
                                                                                                            TRingDateSelectView tRingDateSelectView = (TRingDateSelectView) he.a(i3, inflate);
                                                                                                            if (tRingDateSelectView != null) {
                                                                                                                return new f6.k0((ConstraintLayout) inflate, lineChart, textView, linearLayout, linearLayout2, nestedScrollView, relativeLayout, switchCompat, textView2, tRingToolBarView, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, tRingDateSelectView);
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
        Log.e("qob", "DeviceScanFragment initData");
        TRingDateSelectView tRingDateSelectView = ((f6.k0) this.f7247z.getValue()).f13047w;
        tRingDateSelectView.setDateModel(((Number) this.F.getValue()).intValue());
        tRingDateSelectView.setOnDateSelectedListener(new a0(this));
        tRingDateSelectView.c();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        VectorDrawable vectorDrawable;
        this.H = getIntent().getIntExtra("heartType", 0);
        com.example.test.presenter.main.u0 u0Var = (com.example.test.presenter.main.u0) I0();
        int i3 = this.H;
        u0Var.f7568b = i3;
        if (i3 == 1) {
            TRingToolBarView tRingToolBarView = ((f6.k0) this.f7247z.getValue()).f13035j;
            String string = getString(R$string.ring_str_hrv_title);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            tRingToolBarView.setBarTitle(string);
            ((f6.k0) this.f7247z.getValue()).f13046v.setText(getString(R$string.ring_hrv_watcher));
            ((f6.k0) this.f7247z.getValue()).f13041p.setText(getString(R$string.ring_hrv_watcher_tips));
            ((f6.k0) this.f7247z.getValue()).f13036k.setText(getString(R$string.ring_hrv_detail_title));
            ((f6.k0) this.f7247z.getValue()).f13042q.setText(Const.SP_KEY_GSM_UPLOAD_MXSIZE);
            ((f6.k0) this.f7247z.getValue()).f13044t.setText(Const.SP_KEY_GSM_UPLOAD_MXSIZE);
            ((f6.k0) this.f7247z.getValue()).r.setText(getString(R$string.ring_hrv_real_title));
        }
        f6.k0 k0Var = (f6.k0) this.f7247z.getValue();
        if (k0Var != null) {
            k0Var.f13045u.setOnClickListener(this);
        }
        ((f6.k0) this.f7247z.getValue()).f13033h.setOnCheckedChangeListener(this);
        ((com.example.test.presenter.main.u0) I0()).k();
        f6.k0 k0Var2 = (f6.k0) this.f7247z.getValue();
        if (k0Var2 != null) {
            k0Var2.f13030d.setOnClickListener(this);
        }
        Object obj = com.example.test.utils.m.f8734b;
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (!(supportMenuBean != null ? supportMenuBean.isSupportHrReminder() : false) || this.H == 1) {
            Drawable b3 = a1.c.b(this, R$drawable.svg_ic_tb_share);
            kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            vectorDrawable = (VectorDrawable) b3;
        } else {
            Drawable b10 = a1.c.b(this, R$drawable.svg_reminder);
            kotlin.jvm.internal.e.d(b10, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            vectorDrawable = (VectorDrawable) b10;
        }
        f6.k0 k0Var3 = (f6.k0) this.f7247z.getValue();
        if (k0Var3 != null) {
            k0Var3.f13035j.setBarOption1Iv(vectorDrawable);
        }
        f6.k0 k0Var4 = (f6.k0) this.f7247z.getValue();
        if (k0Var4 != null) {
            k0Var4.f13035j.setOnViewChildListener(new a0(this));
        }
        ((f6.k0) this.f7247z.getValue()).f13032g.setOnClickListener(this);
        f6.k0 k0Var5 = (f6.k0) this.f7247z.getValue();
        if (k0Var5 != null) {
            LineChart lineChart = k0Var5.f13028b;
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
                f6.k0 k0Var6 = (f6.k0) this.f7247z.getValue();
                LinearLayout linearLayout = k0Var6 != null ? k0Var6.e : null;
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
            if (this.H == 1) {
                lineChart.getAxisLeft().B = 0.0f;
            } else {
                lineChart.getAxisLeft().B = 30.0f;
            }
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
        b0();
    }

    @Override // g7.o
    public final void c(DrinkReminderBean drinkReminderBean) {
        kotlin.jvm.internal.e.f(drinkReminderBean, "drinkReminderBean");
        Log.d(this.E, r5.a.d("onData  isopen = ", drinkReminderBean.isOpen()));
        eh.b bVar = this.G;
        ((DrinkReminderBean) bVar.getValue()).setOpen(drinkReminderBean.isOpen());
        eh.b bVar2 = this.f7247z;
        ((f6.k0) bVar2.getValue()).f13033h.setOnCheckedChangeListener(null);
        ((f6.k0) bVar2.getValue()).f13033h.setChecked(((DrinkReminderBean) bVar.getValue()).isOpen());
        ((f6.k0) bVar2.getValue()).f13033h.setOnCheckedChangeListener(this);
        if (this.H == 0) {
            if (drinkReminderBean.getRemindDuration() == 30) {
                ((f6.k0) bVar2.getValue()).f13041p.setText(getString(R$string.ring_hr_watcher_tips));
            } else {
                ((f6.k0) bVar2.getValue()).f13041p.setText(getString(R$string.ring_hr_watcher_tips_60));
            }
        }
    }

    @Override // g7.o
    public final void e() {
        String str = null;
        if (this.H == 0) {
            com.example.test.presenter.main.u0 u0Var = (com.example.test.presenter.main.u0) I0();
            try {
                str = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("date translate error ", e.getMessage()));
            }
            kotlin.jvm.internal.e.c(str);
            u0Var.l(str);
            return;
        }
        com.example.test.presenter.main.u0 u0Var2 = (com.example.test.presenter.main.u0) I0();
        try {
            str = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e10) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("date translate error ", e10.getMessage()));
        }
        kotlin.jvm.internal.e.c(str);
        u0Var2.m(str);
    }

    @Override // g7.o
    public final void f(int i3) {
        if (i3 >= 10) {
            this.J = 0;
            eh.b bVar = this.f7247z;
            f6.k0 k0Var = (f6.k0) bVar.getValue();
            TextView textView = k0Var != null ? k0Var.f13045u : null;
            if (textView != null) {
                textView.setText(getString(R$string.ring_begin_measure));
            }
            f6.k0 k0Var2 = (f6.k0) bVar.getValue();
            if (k0Var2 != null) {
                k0Var2.f13045u.setBackgroundResource(R$drawable.shape_block_text_button);
            }
            if (this.H == 0) {
                com.example.test.presenter.main.u0 u0Var = (com.example.test.presenter.main.u0) I0();
                u0Var.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "HeartRatePresenter", "开始同步心率数据");
                com.example.test.presenter.main.q0 bleDataCallback = (com.example.test.presenter.main.q0) u0Var.f7571f.getValue();
                kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
                x5.b I0 = x5.b.I0();
                u5.e eVar = new u5.e();
                eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
                eVar.f18884b = bleDataCallback;
                I0.K0(eVar);
                if (r5.b.k().f18054c) {
                    x5.c.b().g((byte) -62, new byte[]{5, 3, 16}, new boolean[0]);
                    return;
                } else {
                    x5.b.I0().F0((byte) -62);
                    return;
                }
            }
            com.example.test.presenter.main.u0 u0Var2 = (com.example.test.presenter.main.u0) I0();
            u0Var2.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "HeartRatePresenter", "开始同步心率变异性数据");
            com.example.test.presenter.main.r0 bleDataCallback2 = (com.example.test.presenter.main.r0) u0Var2.f7572g.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback2, "bleDataCallback");
            x5.b I02 = x5.b.I0();
            u5.e eVar2 = new u5.e();
            eVar2.f18883a = new com.example.baselibrary.utils.e(eVar2);
            eVar2.f18884b = bleDataCallback2;
            I02.K0(eVar2);
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -72, new byte[]{5, 10, 16}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -72);
            }
        }
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
        com.example.test.presenter.main.u0 u0Var = (com.example.test.presenter.main.u0) I0();
        DrinkReminderBean data = (DrinkReminderBean) bVar.getValue();
        u0Var.getClass();
        kotlin.jvm.internal.e.f(data, "data");
        data.setRemindDuration(30);
        data.setStartHour(0);
        data.setStartMin(0);
        data.setEndHour(23);
        data.setEndMin(59);
        u0Var.e = data;
        ((XXBaseActivity) ((g7.o) u0Var.f7255a)).V();
        if (u0Var.f7568b == 0) {
            com.google.android.gms.internal.mlkit_vision_common.p.N(data);
        } else {
            data.setRemindDuration(60);
            com.google.android.gms.internal.mlkit_vision_common.p.M(data);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.ll_desc;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (this.H != 1) {
                startActivity(new Intent(this, (Class<?>) TRingHeartRateDescActivity.class));
                return;
            }
            Intent intent = new Intent(this, (Class<?>) TRingBloodOxygenDescActivity.class);
            intent.putExtra("type", 1);
            startActivity(intent);
            return;
        }
        int i10 = R$id.rl_health_detaildata;
        if (valueOf != null && valueOf.intValue() == i10) {
            Intent intent2 = new Intent(this, (Class<?>) TRingHealthDetailActivity.class);
            if (this.H == 0) {
                intent2.putExtra("healthDataType", 0);
            } else {
                intent2.putExtra("healthDataType", 2);
            }
            intent2.putExtra("healthDate", this.I);
            startActivity(intent2);
            return;
        }
        int i11 = R$id.tv_start_test;
        if (valueOf != null && valueOf.intValue() == i11) {
            int i12 = this.J;
            eh.b bVar = this.f7247z;
            if (i12 == 0) {
                ((com.example.test.presenter.main.u0) I0()).n((byte) 1);
                this.J = 1;
                f6.k0 k0Var = (f6.k0) bVar.getValue();
                textView = k0Var != null ? k0Var.f13045u : null;
                if (textView != null) {
                    textView.setText(getString(R$string.ring_end_measure));
                }
                f6.k0 k0Var2 = (f6.k0) bVar.getValue();
                if (k0Var2 != null) {
                    k0Var2.f13045u.setBackgroundResource(R$drawable.shape_block_text_press_button);
                    return;
                }
                return;
            }
            ((com.example.test.presenter.main.u0) I0()).n((byte) 0);
            this.J = 0;
            f6.k0 k0Var3 = (f6.k0) bVar.getValue();
            textView = k0Var3 != null ? k0Var3.f13045u : null;
            if (textView != null) {
                textView.setText(getString(R$string.ring_begin_measure));
            }
            f6.k0 k0Var4 = (f6.k0) bVar.getValue();
            if (k0Var4 != null) {
                k0Var4.f13045u.setBackgroundResource(R$drawable.shape_block_text_button);
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
        if (status == 2) {
            Log.e("qob", "DeviceScanFragment DEVICE_CONNECTING");
            return;
        }
        if (status == 3) {
            Log.e("qob", "DeviceScanFragment DEVICE_BINDING");
            Q0(R$string.str_binding);
        } else if (status == 4) {
            b0();
        } else if (status != 5) {
            b0();
        } else {
            b0();
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
        ((com.example.test.presenter.main.u0) I0()).n((byte) 0);
        this.J = 0;
        eh.b bVar = this.f7247z;
        f6.k0 k0Var = (f6.k0) bVar.getValue();
        TextView textView = k0Var != null ? k0Var.f13045u : null;
        if (textView != null) {
            textView.setText(getString(R$string.ring_begin_measure));
        }
        f6.k0 k0Var2 = (f6.k0) bVar.getValue();
        if (k0Var2 != null) {
            k0Var2.f13045u.setBackgroundResource(R$drawable.shape_block_text_button);
        }
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(final EventBusBeans.SyncDataEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        if (syncEvent.getSyncType() == 1) {
            final int i3 = 0;
            runOnUiThread(new Runnable(this) { // from class: com.example.test.ui.testui.z

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ TRingHeartRateStatisticsActivity f8330b;

                {
                    this.f8330b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    TextView textView;
                    EventBusBeans.SyncDataEvent syncEvent2 = syncEvent;
                    TRingHeartRateStatisticsActivity this$0 = this.f8330b;
                    switch (i3) {
                        case 0:
                            int i10 = TRingHeartRateStatisticsActivity.K;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            kotlin.jvm.internal.e.f(syncEvent2, "$syncEvent");
                            f6.k0 k0Var = (f6.k0) this$0.f7247z.getValue();
                            textView = k0Var != null ? k0Var.f13043s : null;
                            if (textView != null) {
                                textView.setText(String.valueOf(syncEvent2.getData()));
                                break;
                            }
                            break;
                        default:
                            int i11 = TRingHeartRateStatisticsActivity.K;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            kotlin.jvm.internal.e.f(syncEvent2, "$syncEvent");
                            f6.k0 k0Var2 = (f6.k0) this$0.f7247z.getValue();
                            textView = k0Var2 != null ? k0Var2.f13043s : null;
                            if (textView != null) {
                                textView.setText(String.valueOf(syncEvent2.getData()));
                                break;
                            }
                            break;
                    }
                }
            });
        } else if (syncEvent.getSyncType() == 13) {
            final int i10 = 1;
            runOnUiThread(new Runnable(this) { // from class: com.example.test.ui.testui.z

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ TRingHeartRateStatisticsActivity f8330b;

                {
                    this.f8330b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    TextView textView;
                    EventBusBeans.SyncDataEvent syncEvent2 = syncEvent;
                    TRingHeartRateStatisticsActivity this$0 = this.f8330b;
                    switch (i10) {
                        case 0:
                            int i102 = TRingHeartRateStatisticsActivity.K;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            kotlin.jvm.internal.e.f(syncEvent2, "$syncEvent");
                            f6.k0 k0Var = (f6.k0) this$0.f7247z.getValue();
                            textView = k0Var != null ? k0Var.f13043s : null;
                            if (textView != null) {
                                textView.setText(String.valueOf(syncEvent2.getData()));
                                break;
                            }
                            break;
                        default:
                            int i11 = TRingHeartRateStatisticsActivity.K;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            kotlin.jvm.internal.e.f(syncEvent2, "$syncEvent");
                            f6.k0 k0Var2 = (f6.k0) this$0.f7247z.getValue();
                            textView = k0Var2 != null ? k0Var2.f13043s : null;
                            if (textView != null) {
                                textView.setText(String.valueOf(syncEvent2.getData()));
                                break;
                            }
                            break;
                    }
                }
            });
        }
    }

    @Override // t7.d
    public final void x(Entry entry) {
        Integer valueOf = entry != null ? Integer.valueOf((int) entry.d()) : null;
        f6.k0 k0Var = (f6.k0) this.f7247z.getValue();
        TextView textView = k0Var != null ? k0Var.f13038m : null;
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(valueOf));
    }
}
