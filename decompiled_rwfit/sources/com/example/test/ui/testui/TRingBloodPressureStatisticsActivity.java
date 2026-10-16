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
import com.example.test.ui.model.chart.formatter.DayFormatter;
import com.example.test.ui.model.chart.formatter.MonthFormatter;
import com.example.test.ui.model.chart.formatter.WeekFormatter;
import com.example.test.ui.model.chart.formatter.YearFormatter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingBloodPressureStatisticsActivity extends XXBaseActivity<com.example.test.presenter.main.n, f6.i> implements g7.g, View.OnClickListener, t7.d, CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ int J = 0;
    public final String E = "TRingBloodPressureStatisticsActivity";
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingBloodPressureStatisticsActivity$statisticsType$2
        @Override // oh.a
        public final Integer invoke() {
            return 0;
        }
    });
    public String G = "";
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingBloodPressureStatisticsActivity$boDrinkReminderBean$2
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
        return new com.example.test.presenter.main.n(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((f6.i) this.f7247z.getValue()).f12958a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_bloodpressurestatistics, (ViewGroup) null, false);
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
                                                                                                            return new f6.i((ConstraintLayout) inflate, lineChart, textView, linearLayout, linearLayout2, nestedScrollView, relativeLayout, switchCompat, textView2, tRingToolBarView, textView3, textView4, textView5, textView6, textView7, textView8, tRingDateSelectView);
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
        f6.i iVar = (f6.i) this.f7247z.getValue();
        if (iVar != null) {
            TRingDateSelectView tRingDateSelectView = iVar.f12973q;
            tRingDateSelectView.setDateModel(((Number) this.F.getValue()).intValue());
            tRingDateSelectView.setOnDateSelectedListener(new l(this));
            tRingDateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        VectorDrawable vectorDrawable;
        com.example.test.presenter.main.m bleDataCallback = (com.example.test.presenter.main.m) ((com.example.test.presenter.main.n) I0()).f7536b.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        eh.b bVar = this.f7247z;
        f6.i iVar = (f6.i) bVar.getValue();
        if (iVar != null) {
            iVar.f12972p.setOnClickListener(this);
        }
        ((f6.i) bVar.getValue()).f12964h.setOnCheckedChangeListener(this);
        ((com.example.test.presenter.main.n) I0()).k();
        f6.i iVar2 = (f6.i) bVar.getValue();
        if (iVar2 != null) {
            iVar2.f12961d.setOnClickListener(this);
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
        f6.i iVar3 = (f6.i) bVar.getValue();
        if (iVar3 != null) {
            iVar3.f12966j.setBarOption1Iv(vectorDrawable);
        }
        f6.i iVar4 = (f6.i) bVar.getValue();
        if (iVar4 != null) {
            iVar4.f12966j.setOnViewChildListener(new l(this));
        }
        ((f6.i) bVar.getValue()).f12963g.setOnClickListener(this);
        f6.i iVar5 = (f6.i) bVar.getValue();
        if (iVar5 != null) {
            LineChart lineChart = iVar5.f12959b;
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
                f6.i iVar6 = (f6.i) bVar.getValue();
                LinearLayout linearLayout = iVar6 != null ? iVar6.e : null;
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
            lineChart.getLegend().f16406a = false;
            lineChart.invalidate();
        }
    }

    public final void c(DrinkReminderBean drinkReminderBean) {
        kotlin.jvm.internal.e.f(drinkReminderBean, "drinkReminderBean");
        Log.d(this.E, r5.a.d("onData  isopen = ", drinkReminderBean.isOpen()));
        eh.b bVar = this.H;
        ((DrinkReminderBean) bVar.getValue()).setOpen(drinkReminderBean.isOpen());
        eh.b bVar2 = this.f7247z;
        ((f6.i) bVar2.getValue()).f12964h.setOnCheckedChangeListener(null);
        ((f6.i) bVar2.getValue()).f12964h.setChecked(((DrinkReminderBean) bVar.getValue()).isOpen());
        ((f6.i) bVar2.getValue()).f12964h.setOnCheckedChangeListener(this);
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
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
        com.example.test.presenter.main.n nVar = (com.example.test.presenter.main.n) I0();
        DrinkReminderBean data = (DrinkReminderBean) bVar.getValue();
        nVar.getClass();
        kotlin.jvm.internal.e.f(data, "data");
        data.setOpen(data.isOpen());
        data.setRemindDuration(60);
        data.setStartHour(0);
        data.setStartMin(0);
        data.setEndHour(23);
        data.setEndMin(59);
        nVar.f7537c = data;
        ((XXBaseActivity) ((g7.g) nVar.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.K(data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.ll_desc;
        if (valueOf != null && valueOf.intValue() == i3) {
            Intent intent = new Intent(this, (Class<?>) TRingBloodOxygenDescActivity.class);
            intent.putExtra("type", 6);
            startActivity(intent);
            return;
        }
        int i10 = R$id.rl_health_detaildata;
        if (valueOf != null && valueOf.intValue() == i10) {
            Intent intent2 = new Intent(this, (Class<?>) TRingHealthDetailActivity.class);
            intent2.putExtra("healthDataType", 5);
            intent2.putExtra("healthDate", this.G);
            startActivity(intent2);
            return;
        }
        int i11 = R$id.tv_start_test;
        if (valueOf != null && valueOf.intValue() == i11) {
            int i12 = this.I;
            eh.b bVar = this.f7247z;
            if (i12 == 0) {
                Log.d("tong", "start test bp");
                ((com.example.test.presenter.main.n) I0()).m((byte) 1);
                this.I = 1;
                f6.i iVar = (f6.i) bVar.getValue();
                textView = iVar != null ? iVar.f12972p : null;
                if (textView != null) {
                    textView.setText(getString(R$string.ring_end_measure));
                }
                f6.i iVar2 = (f6.i) bVar.getValue();
                if (iVar2 != null) {
                    iVar2.f12972p.setBackgroundResource(R$drawable.shape_block_text_press_button);
                    return;
                }
                return;
            }
            Log.d("tong", "stop test hr");
            ((com.example.test.presenter.main.n) I0()).m((byte) 0);
            this.I = 0;
            f6.i iVar3 = (f6.i) bVar.getValue();
            textView = iVar3 != null ? iVar3.f12972p : null;
            if (textView != null) {
                textView.setText(getString(R$string.ring_begin_measure));
            }
            f6.i iVar4 = (f6.i) bVar.getValue();
            if (iVar4 != null) {
                iVar4.f12972p.setBackgroundResource(R$drawable.shape_block_text_button);
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
            Log.d("tong", "bluedevice link success");
        } else {
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
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        b2.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        ((com.example.test.presenter.main.n) I0()).m((byte) 0);
        this.I = 0;
        eh.b bVar = this.f7247z;
        f6.i iVar = (f6.i) bVar.getValue();
        TextView textView = iVar != null ? iVar.f12972p : null;
        if (textView != null) {
            textView.setText(getString(R$string.ring_begin_measure));
        }
        f6.i iVar2 = (f6.i) bVar.getValue();
        if (iVar2 != null) {
            iVar2.f12972p.setBackgroundResource(R$drawable.shape_block_text_button);
        }
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(EventBusBeans.SyncDataEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        if (syncEvent.getSyncType() == 2) {
            Log.d("tong", "dp data = " + syncEvent.getSp() + "/" + syncEvent.getDp());
            runOnUiThread(new androidx.appcompat.app.i0(11, this, syncEvent));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:3:0x0003, B:5:0x000b, B:7:0x0015, B:9:0x001e, B:11:0x002c, B:12:0x0039, B:14:0x0041, B:16:0x004b, B:18:0x0054, B:20:0x0062, B:21:0x006d, B:23:0x0075, B:28:0x007c), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:3:0x0003, B:5:0x000b, B:7:0x0015, B:9:0x001e, B:11:0x002c, B:12:0x0039, B:14:0x0041, B:16:0x004b, B:18:0x0054, B:20:0x0062, B:21:0x006d, B:23:0x0075, B:28:0x007c), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c A[Catch: Exception -> 0x0036, TRY_LEAVE, TryCatch #0 {Exception -> 0x0036, blocks: (B:3:0x0003, B:5:0x000b, B:7:0x0015, B:9:0x001e, B:11:0x002c, B:12:0x0039, B:14:0x0041, B:16:0x004b, B:18:0x0054, B:20:0x0062, B:21:0x006d, B:23:0x0075, B:28:0x007c), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078  */
    @Override // t7.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(com.github.mikephil.charting.data.Entry r6) {
        /*
            r5 = this;
            eh.b r0 = r5.f7247z
            r1 = 0
            java.lang.Object r2 = r0.getValue()     // Catch: java.lang.Exception -> L36
            f6.i r2 = (f6.i) r2     // Catch: java.lang.Exception -> L36
            if (r2 == 0) goto L38
            com.github.mikephil.charting.charts.LineChart r2 = r2.f12959b     // Catch: java.lang.Exception -> L36
            o7.h r2 = r2.getData()     // Catch: java.lang.Exception -> L36
            o7.j r2 = (o7.j) r2     // Catch: java.lang.Exception -> L36
            if (r2 == 0) goto L38
            r3 = 0
            o7.d r2 = r2.b(r3)     // Catch: java.lang.Exception -> L36
            o7.k r2 = (o7.k) r2     // Catch: java.lang.Exception -> L36
            if (r2 == 0) goto L38
            kotlin.jvm.internal.e.c(r6)     // Catch: java.lang.Exception -> L36
            float r3 = r6.j()     // Catch: java.lang.Exception -> L36
            int r3 = (int) r3     // Catch: java.lang.Exception -> L36
            com.github.mikephil.charting.data.Entry r2 = r2.g(r3)     // Catch: java.lang.Exception -> L36
            if (r2 == 0) goto L38
            float r2 = r2.d()     // Catch: java.lang.Exception -> L36
            int r2 = (int) r2     // Catch: java.lang.Exception -> L36
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L36
            goto L39
        L36:
            r6 = move-exception
            goto L94
        L38:
            r2 = r1
        L39:
            java.lang.Object r3 = r0.getValue()     // Catch: java.lang.Exception -> L36
            f6.i r3 = (f6.i) r3     // Catch: java.lang.Exception -> L36
            if (r3 == 0) goto L6c
            com.github.mikephil.charting.charts.LineChart r3 = r3.f12959b     // Catch: java.lang.Exception -> L36
            o7.h r3 = r3.getData()     // Catch: java.lang.Exception -> L36
            o7.j r3 = (o7.j) r3     // Catch: java.lang.Exception -> L36
            if (r3 == 0) goto L6c
            r4 = 1
            o7.d r3 = r3.b(r4)     // Catch: java.lang.Exception -> L36
            o7.k r3 = (o7.k) r3     // Catch: java.lang.Exception -> L36
            if (r3 == 0) goto L6c
            kotlin.jvm.internal.e.c(r6)     // Catch: java.lang.Exception -> L36
            float r6 = r6.j()     // Catch: java.lang.Exception -> L36
            int r6 = (int) r6     // Catch: java.lang.Exception -> L36
            com.github.mikephil.charting.data.Entry r6 = r3.g(r6)     // Catch: java.lang.Exception -> L36
            if (r6 == 0) goto L6c
            float r6 = r6.d()     // Catch: java.lang.Exception -> L36
            int r6 = (int) r6     // Catch: java.lang.Exception -> L36
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L36
            goto L6d
        L6c:
            r6 = r1
        L6d:
            java.lang.Object r3 = r0.getValue()     // Catch: java.lang.Exception -> L36
            f6.i r3 = (f6.i) r3     // Catch: java.lang.Exception -> L36
            if (r3 == 0) goto L78
            android.widget.TextView r3 = r3.f12968l     // Catch: java.lang.Exception -> L36
            goto L79
        L78:
            r3 = r1
        L79:
            if (r3 != 0) goto L7c
            goto La9
        L7c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L36
            r4.<init>()     // Catch: java.lang.Exception -> L36
            r4.append(r2)     // Catch: java.lang.Exception -> L36
            java.lang.String r2 = "/"
            r4.append(r2)     // Catch: java.lang.Exception -> L36
            r4.append(r6)     // Catch: java.lang.Exception -> L36
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Exception -> L36
            r3.setText(r6)     // Catch: java.lang.Exception -> L36
            return
        L94:
            r6.printStackTrace()
            java.lang.Object r6 = r0.getValue()
            f6.i r6 = (f6.i) r6
            if (r6 == 0) goto La1
            android.widget.TextView r1 = r6.f12968l
        La1:
            if (r1 != 0) goto La4
            goto La9
        La4:
            java.lang.String r6 = "--"
            r1.setText(r6)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.testui.TRingBloodPressureStatisticsActivity.x(com.github.mikephil.charting.data.Entry):void");
    }
}
