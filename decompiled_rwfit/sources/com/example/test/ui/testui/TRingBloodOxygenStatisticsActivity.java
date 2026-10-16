package com.example.test.ui.testui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.BoChartData;
import com.example.test.ui.model.chart.formatter.DayFormatter;
import com.example.test.ui.model.chart.formatter.MonthFormatter;
import com.example.test.ui.model.chart.formatter.WeekFormatter;
import com.example.test.ui.model.chart.formatter.YearFormatter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.EntryDate;
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
public final class TRingBloodOxygenStatisticsActivity extends XXBaseActivity<com.example.test.presenter.main.k, f6.h> implements g7.f, View.OnClickListener, t7.d, CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ int J = 0;
    public final String E = "TRingBloodOxygenStatisticsActivity";
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingBloodOxygenStatisticsActivity$statisticsType$2
        @Override // oh.a
        public final Integer invoke() {
            return 0;
        }
    });
    public String G = "";
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingBloodOxygenStatisticsActivity$boDrinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });
    public int I;

    @Override // t7.d
    public final void A() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.k(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((f6.h) this.f7247z.getValue()).f12928a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_bloodoxygenstatistics, (ViewGroup) null, false);
        int i3 = R$id.chart1;
        LineChart lineChart = (LineChart) he.a(i3, inflate);
        if (lineChart != null) {
            i3 = R$id.end_time;
            TextView textView = (TextView) he.a(i3, inflate);
            if (textView != null) {
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
                                                    i3 = R$id.tv_bo_avg;
                                                    TextView textView3 = (TextView) he.a(i3, inflate);
                                                    if (textView3 != null) {
                                                        i3 = R$id.tv_bo_currentvalue;
                                                        TextView textView4 = (TextView) he.a(i3, inflate);
                                                        if (textView4 != null) {
                                                            i3 = R$id.tv_bo_detail_title;
                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                i3 = R$id.tv_bo_max;
                                                                TextView textView5 = (TextView) he.a(i3, inflate);
                                                                if (textView5 != null) {
                                                                    i3 = R$id.tv_bo_min;
                                                                    TextView textView6 = (TextView) he.a(i3, inflate);
                                                                    if (textView6 != null) {
                                                                        i3 = R$id.tv_bo_tips;
                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                            i3 = R$id.tv_bo_unit;
                                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                                i3 = R$id.tv_data_title;
                                                                                if (((TextView) he.a(i3, inflate)) != null) {
                                                                                    i3 = R$id.tv_realtime_data_title;
                                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                                        i3 = R$id.tv_rt_bo;
                                                                                        TextView textView7 = (TextView) he.a(i3, inflate);
                                                                                        if (textView7 != null) {
                                                                                            i3 = R$id.tv_rt_hr_unit;
                                                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                i3 = R$id.tv_start_test;
                                                                                                TextView textView8 = (TextView) he.a(i3, inflate);
                                                                                                if (textView8 != null) {
                                                                                                    i3 = R$id.tv_title;
                                                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                        i3 = R$id.view_date_select;
                                                                                                        TRingDateSelectView tRingDateSelectView = (TRingDateSelectView) he.a(i3, inflate);
                                                                                                        if (tRingDateSelectView != null) {
                                                                                                            return new f6.h((ConstraintLayout) inflate, lineChart, textView, linearLayout, linearLayout2, nestedScrollView, relativeLayout, switchCompat, textView2, tRingToolBarView, textView3, textView4, textView5, textView6, textView7, textView8, tRingDateSelectView);
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
        f6.h hVar = (f6.h) this.f7247z.getValue();
        if (hVar != null) {
            TRingDateSelectView tRingDateSelectView = hVar.f12943q;
            tRingDateSelectView.setDateModel(((Number) this.F.getValue()).intValue());
            tRingDateSelectView.setOnDateSelectedListener(new k(this));
            tRingDateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        VectorDrawable vectorDrawable;
        com.example.test.presenter.main.j bleDataCallback = (com.example.test.presenter.main.j) ((com.example.test.presenter.main.k) I0()).f7526b.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        f6.h hVar = (f6.h) this.f7247z.getValue();
        if (hVar != null) {
            hVar.f12942p.setOnClickListener(this);
        }
        ((f6.h) this.f7247z.getValue()).f12934h.setOnCheckedChangeListener(this);
        ((com.example.test.presenter.main.k) I0()).k();
        f6.h hVar2 = (f6.h) this.f7247z.getValue();
        if (hVar2 != null) {
            hVar2.f12931d.setOnClickListener(this);
        }
        Object obj = com.example.test.utils.m.f8734b;
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (supportMenuBean != null ? supportMenuBean.isSupportBoReminder() : false) {
            Drawable b3 = a1.c.b(this, R$drawable.svg_reminder);
            kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            vectorDrawable = (VectorDrawable) b3;
        } else {
            Drawable b10 = a1.c.b(this, R$drawable.svg_ic_tb_share);
            kotlin.jvm.internal.e.d(b10, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            vectorDrawable = (VectorDrawable) b10;
        }
        f6.h hVar3 = (f6.h) this.f7247z.getValue();
        if (hVar3 != null) {
            hVar3.f12936j.setBarOption1Iv(vectorDrawable);
        }
        f6.h hVar4 = (f6.h) this.f7247z.getValue();
        if (hVar4 != null) {
            hVar4.f12936j.setOnViewChildListener(new k(this));
        }
        ((f6.h) this.f7247z.getValue()).f12933g.setOnClickListener(this);
        f6.h hVar5 = (f6.h) this.f7247z.getValue();
        if (hVar5 != null) {
            LineChart lineChart = hVar5.f12929b;
            lineChart.setOnChartValueSelectedListener(this);
            lineChart.setDrawGridBackground(false);
            lineChart.getDescription().f16406a = false;
            lineChart.setTouchEnabled(true);
            lineChart.setDragEnabled(true);
            lineChart.setScaleEnabled(false);
            lineChart.setPinchZoom(false);
            lineChart.getXAxis().H = true;
            lineChart.getXAxis().I = XAxis$XAxisPosition.BOTTOM;
            lineChart.getXAxis().e = getColor(R$color.ring_activitypage_text_mask);
            lineChart.getXAxis().r = false;
            lineChart.getXAxis().f(0.0f);
            int intValue = ((Number) this.F.getValue()).intValue();
            if (intValue == 0) {
                f6.h hVar6 = (f6.h) this.f7247z.getValue();
                LinearLayout linearLayout = hVar6 != null ? hVar6.e : null;
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
            n7.i axisLeft = lineChart.getAxisLeft();
            axisLeft.getClass();
            axisLeft.f(0.0f);
            lineChart.getAxisRight().f16406a = false;
            lineChart.getAxisLeft().h(4, true);
            lineChart.getAxisLeft().e = getColor(R$color.ring_activitypage_text_mask);
            lineChart.getAxisLeft().J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
            lineChart.getAxisLeft().B = 50.0f;
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

    @Override // g7.f
    public final void a() {
    }

    @Override // g7.f
    public final void b() {
    }

    @Override // g7.f
    public final void c(DrinkReminderBean drinkReminderBean) {
        kotlin.jvm.internal.e.f(drinkReminderBean, "drinkReminderBean");
        Log.d(this.E, r5.a.d("onData  isopen = ", drinkReminderBean.isOpen()));
        eh.b bVar = this.H;
        ((DrinkReminderBean) bVar.getValue()).setOpen(drinkReminderBean.isOpen());
        eh.b bVar2 = this.f7247z;
        ((f6.h) bVar2.getValue()).f12934h.setOnCheckedChangeListener(null);
        ((f6.h) bVar2.getValue()).f12934h.setChecked(((DrinkReminderBean) bVar.getValue()).isOpen());
        ((f6.h) bVar2.getValue()).f12934h.setOnCheckedChangeListener(this);
    }

    @Override // g7.f
    public final void e() {
        String str;
        com.example.test.presenter.main.k kVar = (com.example.test.presenter.main.k) I0();
        try {
            str = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("date translate error ", e.getMessage()));
            str = null;
        }
        kotlin.jvm.internal.e.c(str);
        kVar.l(str);
    }

    @Override // g7.f
    public final void f(int i3) {
        if (i3 >= 10) {
            this.I = 0;
            eh.b bVar = this.f7247z;
            f6.h hVar = (f6.h) bVar.getValue();
            TextView textView = hVar != null ? hVar.f12942p : null;
            if (textView != null) {
                textView.setText(getString(R$string.ring_begin_measure));
            }
            f6.h hVar2 = (f6.h) bVar.getValue();
            if (hVar2 != null) {
                hVar2.f12942p.setBackgroundResource(R$drawable.shape_block_text_button);
            }
            com.example.test.presenter.main.k kVar = (com.example.test.presenter.main.k) I0();
            kVar.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BloodOxygenPresenter", "开始同步血氧数据");
            com.google.android.gms.internal.mlkit_vision_common.p.U((com.example.test.presenter.main.i) kVar.f7528d.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.W();
        }
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g7.f
    public final void g0(BoChartData boChartData) {
        f6.h hVar;
        f6.h hVar2;
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
            List<Entry> items = boChartData.getItems();
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
            List<Entry> items2 = boChartData.getItems();
            if (items2 == null || items2.isEmpty() || entry3 == null) {
                f6.h hVar3 = (f6.h) bVar2.getValue();
                LinearLayout linearLayout = hVar3 != null ? hVar3.e : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else {
                f6.h hVar4 = (f6.h) bVar2.getValue();
                LinearLayout linearLayout2 = hVar4 != null ? hVar4.e : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
            }
        }
        f6.h hVar5 = (f6.h) bVar2.getValue();
        if (hVar5 != null) {
            LineChart lineChart = hVar5.f12929b;
            if (lineChart.getData() == 0 || ((o7.j) lineChart.getData()).c() <= 0) {
                List<Entry> items3 = boChartData.getItems();
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
                List<Entry> items4 = boChartData.getItems();
                if (items4 == null || items4.isEmpty() || entry == null) {
                    lineChart.setData(null);
                    lineChart.n();
                } else {
                    o7.k kVar = new o7.k(boChartData.getItems());
                    kVar.B = LineDataSet$Mode.CUBIC_BEZIER;
                    kVar.G = 0.2f;
                    kVar.A = true;
                    kVar.I = false;
                    kVar.f16824t = android.support.v4.media.session.e.a(kVar, 244, 117, 117);
                    kVar.l(getResources().getColor(R$color.color_d42725));
                    kVar.f16837x = getResources().getColor(R$color.color_d42725);
                    kVar.f16838y = 60;
                    kVar.f16835v = false;
                    kVar.H = new com.example.test.ui.sport.activity.l(lineChart, 2);
                    o7.j jVar = new o7.j(kVar);
                    jVar.j();
                    jVar.i();
                    lineChart.setData(jVar);
                }
            } else {
                o7.d b3 = ((o7.j) lineChart.getData()).b(0);
                kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
                o7.k kVar2 = (o7.k) b3;
                List<Entry> items5 = boChartData.getItems();
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
                List<Entry> items6 = boChartData.getItems();
                if (items6 == null || items6.isEmpty() || entry2 == null) {
                    lineChart.setData(null);
                } else {
                    kVar2.m(boChartData.getItems());
                    ((o7.j) lineChart.getData()).a();
                }
                lineChart.n();
            }
            lineChart.invalidate();
        }
        String valueOf = boChartData.getCurrentBo() == 0 ? "--" : String.valueOf(boChartData.getCurrentBo());
        String valueOf2 = boChartData.getMaxBo() == 0 ? "--" : String.valueOf(boChartData.getMaxBo());
        String valueOf3 = boChartData.getMinBo() == 0 ? "--" : String.valueOf(boChartData.getMinBo());
        String valueOf4 = boChartData.getAvgBo() != 0 ? String.valueOf(boChartData.getAvgBo()) : "--";
        f6.h hVar6 = (f6.h) bVar2.getValue();
        if (hVar6 != null) {
            hVar6.f12938l.setText(valueOf);
        }
        f6.h hVar7 = (f6.h) bVar2.getValue();
        if (hVar7 != null) {
            hVar7.f12937k.setText(valueOf4);
        }
        f6.h hVar8 = (f6.h) bVar2.getValue();
        if (hVar8 != null) {
            hVar8.f12939m.setText(valueOf2);
        }
        f6.h hVar9 = (f6.h) bVar2.getValue();
        if (hVar9 != null) {
            hVar9.f12940n.setText(valueOf3);
        }
        if (((Number) bVar.getValue()).intValue() == 0) {
            f6.h hVar10 = (f6.h) bVar2.getValue();
            TextView textView = hVar10 != null ? hVar10.f12935i : null;
            if (textView != null) {
                textView.setText("00:00");
            }
            f6.h hVar11 = (f6.h) bVar2.getValue();
            TextView textView2 = hVar11 != null ? hVar11.f12930c : null;
            if (textView2 != null) {
                textView2.setText("24:00");
            }
            String startTime = boChartData.getStartTime();
            if (startTime != null && (hVar2 = (f6.h) bVar2.getValue()) != null) {
                hVar2.f12935i.setText(startTime);
            }
            String endTime = boChartData.getEndTime();
            if (endTime == null || (hVar = (f6.h) bVar2.getValue()) == null) {
                return;
            }
            hVar.f12930c.setText(endTime);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton p02, boolean z5) {
        kotlin.jvm.internal.e.f(p02, "p0");
        eh.b bVar = this.H;
        if (z5) {
            ((DrinkReminderBean) bVar.getValue()).setOpen(true);
        } else {
            ((DrinkReminderBean) bVar.getValue()).setOpen(false);
        }
        com.example.test.presenter.main.k kVar = (com.example.test.presenter.main.k) I0();
        DrinkReminderBean data = (DrinkReminderBean) bVar.getValue();
        kVar.getClass();
        kotlin.jvm.internal.e.f(data, "data");
        data.setRemindDuration(60);
        data.setStartHour(0);
        data.setStartMin(0);
        data.setEndHour(23);
        data.setEndMin(59);
        kVar.f7527c = data;
        ((XXBaseActivity) ((g7.f) kVar.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.J(data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.ll_desc;
        if (valueOf != null && valueOf.intValue() == i3) {
            Intent intent = new Intent(this, (Class<?>) TRingBloodOxygenDescActivity.class);
            intent.putExtra("type", 0);
            startActivity(intent);
            return;
        }
        int i10 = R$id.rl_health_detaildata;
        if (valueOf != null && valueOf.intValue() == i10) {
            Intent intent2 = new Intent(this, (Class<?>) TRingHealthDetailActivity.class);
            intent2.putExtra("healthDataType", 1);
            intent2.putExtra("healthDate", this.G);
            startActivity(intent2);
            return;
        }
        int i11 = R$id.tv_start_test;
        if (valueOf != null && valueOf.intValue() == i11) {
            int i12 = this.I;
            eh.b bVar = this.f7247z;
            if (i12 == 0) {
                ((com.example.test.presenter.main.k) I0()).m((byte) 1);
                this.I = 1;
                f6.h hVar = (f6.h) bVar.getValue();
                textView = hVar != null ? hVar.f12942p : null;
                if (textView != null) {
                    textView.setText(getString(R$string.ring_end_measure));
                }
                f6.h hVar2 = (f6.h) bVar.getValue();
                if (hVar2 != null) {
                    hVar2.f12942p.setBackgroundResource(R$drawable.shape_block_text_press_button);
                    return;
                }
                return;
            }
            ((com.example.test.presenter.main.k) I0()).m((byte) 0);
            this.I = 0;
            f6.h hVar3 = (f6.h) bVar.getValue();
            textView = hVar3 != null ? hVar3.f12942p : null;
            if (textView != null) {
                textView.setText(getString(R$string.ring_begin_measure));
            }
            f6.h hVar4 = (f6.h) bVar.getValue();
            if (hVar4 != null) {
                hVar4.f12942p.setBackgroundResource(R$drawable.shape_block_text_button);
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
            Log.e("qob", "DeviceScanFragment DEVICE_CONNECTED");
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
        ((com.example.test.presenter.main.k) I0()).m((byte) 0);
        this.I = 0;
        eh.b bVar = this.f7247z;
        f6.h hVar = (f6.h) bVar.getValue();
        TextView textView = hVar != null ? hVar.f12942p : null;
        if (textView != null) {
            textView.setText(getString(R$string.ring_begin_measure));
        }
        f6.h hVar2 = (f6.h) bVar.getValue();
        if (hVar2 != null) {
            hVar2.f12942p.setBackgroundResource(R$drawable.shape_block_text_button);
        }
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(EventBusBeans.SyncDataEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        if (syncEvent.getSyncType() == 3) {
            f6.h hVar = (f6.h) this.f7247z.getValue();
            TextView textView = hVar != null ? hVar.f12941o : null;
            if (textView == null) {
                return;
            }
            textView.setText(String.valueOf(syncEvent.getData()));
        }
    }

    @Override // t7.d
    public final void x(Entry entry) {
        String str;
        String valueOf = String.valueOf(entry != null ? Integer.valueOf((int) entry.d()) : null);
        if (entry instanceof EntryDate) {
            long longValue = ((EntryDate) entry).l().longValue() * 1000;
            try {
                str = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(Long.valueOf(longValue));
            } catch (Exception e) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(longValue, " date translate error ", e.getMessage()));
                str = null;
            }
            valueOf = r5.a.c(str, " -- ", valueOf);
        }
        f6.h hVar = (f6.h) this.f7247z.getValue();
        TextView textView = hVar != null ? hVar.f12938l : null;
        if (textView == null) {
            return;
        }
        textView.setText(valueOf);
    }
}
