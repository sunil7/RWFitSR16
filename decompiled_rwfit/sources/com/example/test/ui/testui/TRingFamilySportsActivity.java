package com.example.test.ui.testui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.database.table.User;
import com.example.network.api.DeviceApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.DailyHeartRateBean;
import com.example.network.bean.DailyHrvBean;
import com.example.network.bean.DailyOxygenBean;
import com.example.network.bean.DailyPressureBean;
import com.example.network.bean.DailySleepBean;
import com.example.network.bean.DailyStepBean;
import com.example.network.bean.DailySugarBean;
import com.example.network.bean.DeviceSupportBean;
import com.example.network.bean.FamilySportItem;
import com.example.network.bean.MemberFriendDataBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.main.x1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.HalfCircle;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import com.tencent.connect.common.Constants;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TRingFamilySportsActivity extends XXBaseActivity<com.example.test.presenter.main.n0, f6.e0> implements g7.m, View.OnClickListener {
    public final ArrayList E = new ArrayList();
    public RecyclerView F;
    public u6.n G;
    public int H;
    public MemberFriendDataBean I;
    public DeviceSupportBean J;

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.n0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        Object value = this.f7247z.getValue();
        kotlin.jvm.internal.e.c(value);
        LinearLayout linearLayout = ((f6.e0) value).f12812a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_family_sports, (ViewGroup) null, false);
        int i3 = R$id.family_sport_list;
        if (((RecyclerView) he.a(i3, inflate)) != null) {
            i3 = R$id.step_content;
            if (((RelativeLayout) he.a(i3, inflate)) != null) {
                i3 = R$id.step_progress;
                HalfCircle halfCircle = (HalfCircle) he.a(i3, inflate);
                if (halfCircle != null) {
                    i3 = R$id.toolbar;
                    TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                    if (tRingToolBarView != null) {
                        i3 = R$id.tv_calorie;
                        TextView textView = (TextView) he.a(i3, inflate);
                        if (textView != null) {
                            i3 = R$id.tv_desc;
                            TextView textView2 = (TextView) he.a(i3, inflate);
                            if (textView2 != null) {
                                i3 = R$id.tv_distance;
                                TextView textView3 = (TextView) he.a(i3, inflate);
                                if (textView3 != null) {
                                    i3 = R$id.tv_target;
                                    TextView textView4 = (TextView) he.a(i3, inflate);
                                    if (textView4 != null) {
                                        i3 = R$id.view_date_select;
                                        TRingDateSelectView tRingDateSelectView = (TRingDateSelectView) he.a(i3, inflate);
                                        if (tRingDateSelectView != null) {
                                            return new f6.e0((LinearLayout) inflate, halfCircle, tRingToolBarView, textView, textView2, textView3, textView4, tRingDateSelectView);
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
        this.H = getIntent().getIntExtra("friendId", 0);
        com.example.test.presenter.main.n0 n0Var = (com.example.test.presenter.main.n0) I0();
        int i3 = this.H;
        n0Var.getClass();
        rg.l<HttpModel<DeviceSupportBean>> deviceSupportByMemberId = ((DeviceApi) c6.b.f3390c.f113a).getDeviceSupportByMemberId(i3);
        kotlin.jvm.internal.e.e(deviceSupportByMemberId, "getDeviceSupportByMemberId(...)");
        rg.l w8 = com.example.baselibrary.utils.b.w(deviceSupportByMemberId);
        TRingFamilySportsActivity tRingFamilySportsActivity = (TRingFamilySportsActivity) ((g7.m) n0Var.f7255a);
        tRingFamilySportsActivity.getClass();
        w8.subscribe(new com.example.test.presenter.main.m0(n0Var, tRingFamilySportsActivity, com.example.test.utils.w0.d(), 0));
        f6.e0 e0Var = (f6.e0) this.f7247z.getValue();
        if (e0Var != null) {
            TRingDateSelectView tRingDateSelectView = e0Var.f12818h;
            tRingDateSelectView.setDateModel(0);
            tRingDateSelectView.setOnDateSelectedListener(new x(this));
            tRingDateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        View findViewById = findViewById(R$id.family_sport_list);
        kotlin.jvm.internal.e.d(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.F = (RecyclerView) findViewById;
        f6.e0 e0Var = (f6.e0) this.f7247z.getValue();
        if (e0Var != null) {
            e0Var.f12814c.setOnViewChildListener(new x(this));
        }
    }

    public final void R0(MemberFriendDataBean memberFriendDataBean) {
        ArrayList arrayList = this.E;
        DeviceSupportBean deviceSupportBean = this.J;
        arrayList.clear();
        String mac = deviceSupportBean != null ? deviceSupportBean.getMac() : null;
        if (deviceSupportBean == null || x1.a(deviceSupportBean.getIsDataTypeHeart())) {
            DailyHeartRateBean heartRate = memberFriendDataBean.getHeartRate();
            if (heartRate == null || !x1.b(heartRate.getDeviceId(), mac) || heartRate.getDetails().isEmpty()) {
                arrayList.add(new FamilySportItem(null, 1));
            } else {
                List<DailyHeartRateBean.DailyHeartRateDetail> details = heartRate.getDetails();
                arrayList.add(new FamilySportItem(details.get(details.size() - 1).getValue(), 1));
            }
        }
        if (deviceSupportBean == null || x1.a(deviceSupportBean.getIsDataTypeSleep())) {
            DailySleepBean sleep = memberFriendDataBean.getSleep();
            if (sleep == null || !x1.b(sleep.getDeviceId(), mac)) {
                arrayList.add(new FamilySportItem(null, 2));
            } else {
                arrayList.add(new FamilySportItem(sleep.getTotalTime(), 2));
            }
        }
        if (deviceSupportBean != null && x1.a(deviceSupportBean.getIsDataTypeSPO2())) {
            DailyOxygenBean oxygen = memberFriendDataBean.getOxygen();
            if (oxygen == null || !x1.b(oxygen.getDeviceId(), mac) || oxygen.getDetails().isEmpty()) {
                arrayList.add(new FamilySportItem(null, 3));
            } else {
                List<DailyOxygenBean.DailyOxygenDetail> details2 = oxygen.getDetails();
                arrayList.add(new FamilySportItem(details2.get(details2.size() - 1).getValue(), 3));
            }
        }
        if (deviceSupportBean != null && x1.a(deviceSupportBean.getIsDataTypeBloodSugar())) {
            DailySugarBean sugar = memberFriendDataBean.getSugar();
            if (sugar == null || !x1.b(sugar.getDeviceId(), mac) || sugar.getDetails().isEmpty()) {
                arrayList.add(new FamilySportItem(null, 4));
            } else {
                List<DailySugarBean.DailySugarDetail> details3 = sugar.getDetails();
                DailySugarBean.DailySugarDetail dailySugarDetail = details3.get(details3.size() - 1);
                arrayList.add(new FamilySportItem(Integer.valueOf(dailySugarDetail.getValue().intValue()), 4, dailySugarDetail.getValue()));
            }
        }
        if (deviceSupportBean != null && x1.a(deviceSupportBean.getIsDataTypeHRV())) {
            DailyHrvBean hrv = memberFriendDataBean.getHrv();
            if (hrv == null || !x1.b(hrv.getDeviceId(), mac) || hrv.getDetails().isEmpty()) {
                arrayList.add(new FamilySportItem(null, 5));
            } else {
                List<DailyHrvBean.DailyHrvDetail> details4 = hrv.getDetails();
                arrayList.add(new FamilySportItem(details4.get(details4.size() - 1).getValue(), 5));
            }
        }
        if (deviceSupportBean != null && x1.a(deviceSupportBean.getIsDataTypeStress())) {
            DailyPressureBean pressure = memberFriendDataBean.getPressure();
            if (pressure == null || !x1.b(pressure.getDeviceId(), mac) || pressure.getDetails().isEmpty()) {
                arrayList.add(new FamilySportItem(null, 6));
            } else {
                List<DailyPressureBean.DailyPressureDetail> details5 = pressure.getDetails();
                arrayList.add(new FamilySportItem(details5.get(details5.size() - 1).getValue(), 6));
            }
        }
        ArrayList arrayList2 = this.E;
        u6.n nVar = new u6.n();
        nVar.f18911a = this;
        LayoutInflater.from(this);
        nVar.f18912b = arrayList2;
        this.G = nVar;
        RecyclerView recyclerView = this.F;
        kotlin.jvm.internal.e.c(recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(2));
        RecyclerView recyclerView2 = this.F;
        kotlin.jvm.internal.e.c(recyclerView2);
        recyclerView2.setAdapter(this.G);
        f6.e0 e0Var = (f6.e0) this.f7247z.getValue();
        TextView textView = e0Var != null ? e0Var.e : null;
        f6.e0 e0Var2 = (f6.e0) this.f7247z.getValue();
        HalfCircle halfCircle = e0Var2 != null ? e0Var2.f12813b : null;
        if (halfCircle != null) {
            halfCircle.setText("--");
        }
        if (halfCircle != null) {
            halfCircle.setProgress(Float.valueOf(0.0f));
        }
        kotlin.jvm.internal.e.c(textView);
        textView.setText(R$string.str_no_data);
        f6.e0 e0Var3 = (f6.e0) this.f7247z.getValue();
        TextView textView2 = e0Var3 != null ? e0Var3.f12815d : null;
        if (textView2 != null) {
            textView2.setText("0KCAL");
        }
        String string = getString(R$string.str_km);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            if (kVar == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            kotlin.jvm.internal.e.c(kVar2);
            User d5 = kVar2.d();
            r12 = d5 != null ? d5.getMeterUnit() : 0;
            if (r12 == 1) {
                string = getString(R$string.str_mile);
                kotlin.jvm.internal.e.e(string, "getString(...)");
            }
        }
        Locale locale = Locale.ENGLISH;
        float f2 = 100;
        String format = String.format(locale, "%.2f%s", Arrays.copyOf(new Object[]{Float.valueOf(((int) (0.0f * f2)) / 100.0f), string}, 2));
        f6.e0 e0Var4 = (f6.e0) this.f7247z.getValue();
        if (e0Var4 != null) {
            e0Var4.f12816f.setText(format);
        }
        if (memberFriendDataBean.getSportTarget() != null) {
            f6.e0 e0Var5 = (f6.e0) this.f7247z.getValue();
            if (e0Var5 != null) {
                e0Var5.f12817g.setText(memberFriendDataBean.getSportTarget() + getString(R$string.str_unit_step));
            }
            if (halfCircle != null) {
                halfCircle.setMaxProgress(memberFriendDataBean.getSportTarget().intValue());
            }
        }
        DailyStepBean step = memberFriendDataBean.getStep();
        if (step != null) {
            String format2 = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((int) (new BigDecimal(String.valueOf(step.getCal())).divide(new BigDecimal(Constants.DEFAULT_UIN)).floatValue() * 10)) / 10.0f)}, 1));
            f6.e0 e0Var6 = (f6.e0) this.f7247z.getValue();
            TextView textView3 = e0Var6 != null ? e0Var6.f12815d : null;
            if (textView3 != null) {
                textView3.setText(format2.concat("KCAL"));
            }
            float floatValue = ((int) (new BigDecimal(String.valueOf(step.getDistance())).divide(new BigDecimal(Constants.DEFAULT_UIN)).floatValue() * f2)) / 100.0f;
            if (r12 == 1) {
                floatValue = ((int) (v1.b(new BigDecimal(String.valueOf(step.getDistance())).floatValue()) * f2)) / 100.0f;
            }
            String format3 = String.format(locale, "%.2f%s", Arrays.copyOf(new Object[]{Float.valueOf(floatValue), string}, 2));
            f6.e0 e0Var7 = (f6.e0) this.f7247z.getValue();
            if (e0Var7 != null) {
                e0Var7.f12816f.setText(format3);
            }
            kotlin.jvm.internal.e.c(halfCircle);
            halfCircle.setText(String.valueOf(step.getStep()));
            halfCircle.setProgress(Float.valueOf(step.getStep().intValue()));
            float intValue = step.getStep().intValue();
            if (memberFriendDataBean.getSportTarget() != null) {
                if (intValue < r3.intValue() / 5) {
                    textView.setText(getString(R$string.str_ring_step_level1));
                    return;
                }
                if (intValue > r3.intValue() / 5 && intValue < (r3.intValue() * 2) / 5) {
                    textView.setText(getString(R$string.str_ring_step_level2));
                    return;
                }
                if (intValue > (r3.intValue() * 2) / 5 && intValue < (r3.intValue() * 3) / 5) {
                    textView.setText(getString(R$string.str_ring_step_level3));
                    return;
                }
                if (intValue > (r3.intValue() * 3) / 5 && intValue < (r3.intValue() * 4) / 5) {
                    textView.setText(getString(R$string.str_ring_step_level4));
                } else if (intValue >= (r3.intValue() * 4) / 5) {
                    textView.setText(getString(R$string.str_ring_step_level5));
                }
            }
        }
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        kotlin.jvm.internal.e.f(view, "view");
    }
}
