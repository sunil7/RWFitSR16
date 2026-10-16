package com.example.test.ui.testui;

import android.content.Intent;
import android.graphics.PointF;
import android.util.Log;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.database.table.User;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.device.activity.VaperPowerActivity;
import com.example.test.ui.main.activity.BODetailActivity;
import com.example.test.ui.main.activity.BPDetailActivity;
import com.example.test.ui.main.activity.BSDetailActivity;
import com.example.test.ui.main.activity.BTDetailActivity;
import com.example.test.ui.main.activity.BreatheDetailActivity;
import com.example.test.ui.main.activity.HRDetailActivity;
import com.example.test.ui.main.activity.SleepDetailActivity;
import com.example.test.ui.main.activity.StepDetailActivity;
import com.example.test.ui.main.activity.SugarDetailActivity;
import com.example.test.ui.main.model.BaseDataModel;
import com.example.test.ui.main.model.HomeBSModel;
import com.example.test.ui.main.model.HomeBoModel;
import com.example.test.ui.main.model.HomeBpModel;
import com.example.test.ui.main.model.HomeBreatheModel;
import com.example.test.ui.main.model.HomeBtModel;
import com.example.test.ui.main.model.HomeHrModel;
import com.example.test.ui.main.model.HomeHrvModel;
import com.example.test.ui.main.model.HomeSleepModel;
import com.example.test.ui.main.model.HomeStepModel;
import com.example.test.ui.main.model.HomeSugarModel;
import com.example.test.ui.main.model.HomeVaperBatteryModel;
import com.example.test.ui.main.model.HomeViperPowerModel;
import com.example.test.ui.view.BorderProgressView;
import com.example.test.ui.view.CircleProgressView;
import com.example.test.ui.view.HalfCircle;
import com.example.test.ui.view.LineChartView;
import com.example.test.ui.view.LineGradientChartView;
import com.example.test.ui.view.SleepChartView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet$Mode;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import com.google.android.material.timepicker.TimeModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b0 extends com.example.test.ui.view.e {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8263b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(int i3) {
        super(0);
        this.f8263b = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j(BaseViewHolder baseViewHolder, Object obj) {
        HomeHrvModel homeHrvModel = (HomeHrvModel) ((BaseDataModel) obj);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        int D = com.example.test.utils.k.f8731b.D();
        if (D == 1) {
            baseViewHolder.setBackgroundResource(R$id.hr_content, R$mipmap.homepage_heartrate_1);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
            baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_6E99D3));
            baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_6E99D3));
            baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_6E99D3));
            baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_6E99D3));
            baseViewHolder.setImageResource(R$id.iv_heart_hrv, R$mipmap.ring_home_run_hrv_icon_white);
            baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_6E99D3));
        } else if (D == 2) {
            baseViewHolder.setBackgroundResource(R$id.hr_content, R$mipmap.homepage_heartrate_2);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
            baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_white));
            baseViewHolder.setImageResource(R$id.iv_heart_hrv, R$mipmap.ic_heartrate_hrv);
            baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_white));
        } else {
            baseViewHolder.setBackgroundResource(R$id.hr_content, R$mipmap.homepage_heartrate);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
            baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_828282));
            baseViewHolder.setImageResource(R$id.iv_heart_hrv, R$mipmap.ic_heartrate_hrv);
            baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_white));
        }
        if (homeHrvModel.getCurrentHrv() > 0) {
            int i3 = R$id.tv_count;
            Locale locale = Locale.ENGLISH;
            baseViewHolder.setText(i3, homeHrvModel.getCurrentHrv() + " ms");
            if (homeHrvModel.getCurrentHrv() < 30) {
                baseViewHolder.setText(R$id.tv_range, R$string.str_ring_hrv_level1);
            } else if (homeHrvModel.getCurrentHrv() >= 30 && homeHrvModel.getCurrentHrv() < 60) {
                baseViewHolder.setText(R$id.tv_range, R$string.str_ring_hrv_level2);
            } else if (homeHrvModel.getCurrentHrv() < 60 || homeHrvModel.getCurrentHrv() >= 101) {
                baseViewHolder.setText(R$id.tv_range, R$string.str_ring_hrv_level4);
            } else {
                baseViewHolder.setText(R$id.tv_range, R$string.str_ring_hrv_level3);
            }
        } else {
            baseViewHolder.setText(R$id.tv_count, "--");
            baseViewHolder.setText(R$id.tv_range, "--");
        }
        baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        TextView textView = (TextView) baseViewHolder.getView(R$id.tv_no_data);
        if (homeHrvModel.getItems() != null) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        LineChart lineChart = (LineChart) baseViewHolder.getView(R$id.chart1);
        lineChart.setDrawGridBackground(false);
        lineChart.getDescription().f16406a = false;
        lineChart.setTouchEnabled(false);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(false);
        lineChart.setPinchZoom(false);
        n7.h xAxis = lineChart.getXAxis();
        xAxis.I = XAxis$XAxisPosition.BOTTOM;
        xAxis.g();
        xAxis.e = 0;
        xAxis.r = false;
        n7.i axisLeft = lineChart.getAxisLeft();
        n7.i axisRight = lineChart.getAxisRight();
        axisLeft.getClass();
        axisLeft.f(0.0f);
        axisRight.f16406a = false;
        axisLeft.h(4, false);
        axisLeft.e = -1;
        axisLeft.J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
        axisLeft.b();
        axisLeft.f16402w = true;
        lineChart.setNoDataText("暂无数据");
        lineChart.setNoDataTextColor(-1);
        lineChart.getLegend().f16406a = false;
        lineChart.invalidate();
        List<Entry> dataItems = homeHrvModel.getDataItems();
        if (lineChart.getData() != 0 && ((o7.j) lineChart.getData()).c() > 0) {
            Log.d("XXtong", "lineChart.getData() != null");
            o7.k kVar = (o7.k) ((o7.j) lineChart.getData()).b(0);
            if (dataItems == null) {
                ((o7.j) lineChart.getData()).h(kVar);
                lineChart.g();
            } else {
                kVar.m(dataItems);
                ((o7.j) lineChart.getData()).a();
            }
            lineChart.n();
        } else if (dataItems != null) {
            Log.d("XXtong", "hrChartData size = " + dataItems.size());
            o7.k kVar2 = new o7.k(dataItems);
            kVar2.B = LineDataSet$Mode.CUBIC_BEZIER;
            kVar2.G = 0.2f;
            kVar2.A = true;
            kVar2.I = false;
            kVar2.f16824t = android.support.v4.media.session.e.a(kVar2, 244, 117, 117);
            kVar2.l(-1);
            kVar2.f16837x = -1;
            kVar2.f16838y = 60;
            kVar2.f16835v = false;
            o7.j jVar = new o7.j(kVar2);
            jVar.j();
            jVar.i();
            lineChart.setData(jVar);
        } else {
            lineChart.g();
            lineChart.n();
        }
        lineChart.invalidate();
        baseViewHolder.setText(R$id.start_time, homeHrvModel.getStartTime());
        baseViewHolder.setText(R$id.end_time, homeHrvModel.getEndTime());
        f(baseViewHolder.getView(R$id.hr_content));
    }

    private final void k(BaseViewHolder baseViewHolder, Object obj) {
        HomeSleepModel homeSleepModel = (HomeSleepModel) ((BaseDataModel) obj);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        int D = com.example.test.utils.k.f8731b.D();
        if (D == 1) {
            baseViewHolder.setBackgroundResource(R$id.sleep_content, R$mipmap.homepage_sleep_bg_1);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
        } else if (D == 2) {
            baseViewHolder.setBackgroundResource(R$id.sleep_content, R$mipmap.homepage_sleep_bg_2);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
        } else {
            baseViewHolder.setBackgroundResource(R$id.sleep_content, R$mipmap.homepage_sleep_bg);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
        }
        if (homeSleepModel.getTotalHour() > 0 || homeSleepModel.getTotalMin() > 0) {
            baseViewHolder.setText(R$id.tv_hour, String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(homeSleepModel.getTotalHour())));
        } else {
            baseViewHolder.setText(R$id.tv_hour, "--");
        }
        if (homeSleepModel.getTotalHour() > 0 || homeSleepModel.getTotalMin() > 0) {
            baseViewHolder.setText(R$id.tv_min, String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(homeSleepModel.getTotalMin())));
        } else {
            baseViewHolder.setText(R$id.tv_min, "--");
        }
        baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        int A = com.example.test.utils.k.f8731b.A();
        if (homeSleepModel.getStartTime() != null) {
            baseViewHolder.setText(R$id.tv_start_time, homeSleepModel.getStartTime());
        } else {
            baseViewHolder.setText(R$id.tv_start_time, "--:--");
        }
        if (homeSleepModel.getEndTime() != null) {
            baseViewHolder.setText(R$id.tv_end_time, homeSleepModel.getEndTime());
        } else {
            baseViewHolder.setText(R$id.tv_end_time, "--:--");
        }
        TextView textView = (TextView) baseViewHolder.getView(R$id.tv_desc);
        HalfCircle halfCircle = (HalfCircle) baseViewHolder.getView(R$id.sleep_progress);
        float f2 = A;
        halfCircle.setMaxProgress(f2);
        float totalMin = homeSleepModel.getTotalMin() + (homeSleepModel.getTotalHour() * 60);
        halfCircle.setProgress(Float.valueOf(totalMin));
        int i3 = (int) ((100.0f * totalMin) / f2);
        if (i3 > 100) {
            i3 = 100;
        }
        if (i3 < 40) {
            textView.setText(getContext().getString(R$string.str_ring_sleep_level5));
        } else if (i3 >= 40 && i3 < 60) {
            textView.setText(getContext().getString(R$string.str_ring_sleep_level4));
        } else if (i3 >= 60 && i3 < 80) {
            textView.setText(getContext().getString(R$string.str_ring_sleep_level3));
        } else if (i3 < 80 || i3 >= 100) {
            textView.setText(getContext().getString(R$string.str_ring_sleep_level1));
        } else {
            textView.setText(getContext().getString(R$string.str_ring_sleep_level2));
        }
        halfCircle.setText(i3 + "");
        if (i3 == 0) {
            halfCircle.setText("--");
            textView.setText(R$string.str_no_data);
        }
        float lightSleepTime = homeSleepModel.getLightSleepTime() / totalMin;
        float deepSleepTime = homeSleepModel.getDeepSleepTime() / totalMin;
        float wakeSleepTime = homeSleepModel.getWakeSleepTime() / totalMin;
        if (!Float.isNaN(lightSleepTime) || !Float.isNaN(deepSleepTime) || !Float.isNaN(wakeSleepTime)) {
            Math.round(lightSleepTime * 10.0f);
            Math.round(deepSleepTime * 10.0f);
            Math.round(wakeSleepTime * 10.0f);
        }
        f(baseViewHolder.getView(R$id.sleep_content));
    }

    private final void l(BaseViewHolder baseViewHolder, Object obj) {
        HomeStepModel homeStepModel = (HomeStepModel) ((BaseDataModel) obj);
        String string = this.context.getString(R$string.str_km);
        if (y1.a() != null) {
            User d5 = y1.a().d();
            if ((d5 != null ? d5.getMeterUnit() : 0) == 1) {
                string = this.context.getString(R$string.str_mile);
            }
        }
        baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        long C = y1.a().C();
        Long valueOf = Long.valueOf(C);
        int f2 = y1.a().f();
        float o3 = y1.a().o();
        HalfCircle halfCircle = (HalfCircle) baseViewHolder.getView(R$id.step_progress);
        TextView textView = (TextView) baseViewHolder.getView(R$id.tv_desc);
        TextView textView2 = (TextView) baseViewHolder.getView(R$id.tv_target);
        TextView textView3 = (TextView) baseViewHolder.getView(R$id.tv_calorie);
        TextView textView4 = (TextView) baseViewHolder.getView(R$id.tv_distance);
        textView2.setText(valueOf + getContext().getString(R$string.str_unit_step));
        textView3.setText(f2 + "KCAL");
        textView4.setText(String.format(Locale.ENGLISH, "%.2f%s", Float.valueOf(((float) ((int) (o3 * ((float) 100)))) / 100.0f), string));
        Log.e("qob", "getCurrentSteps " + homeStepModel.getCurrentSteps() + " getTarget " + homeStepModel.getTarget());
        String currentSteps = homeStepModel.getCurrentSteps();
        if ((currentSteps == null || currentSteps.length() == 0 || "null".equalsIgnoreCase(currentSteps)) ? false : true) {
            halfCircle.setText(homeStepModel.getCurrentSteps());
            halfCircle.setMaxProgress(C);
            halfCircle.setProgress(Float.valueOf(Float.parseFloat(homeStepModel.getCurrentSteps())));
            float parseFloat = Float.parseFloat(homeStepModel.getCurrentSteps());
            float f10 = C / 5;
            if (parseFloat < f10) {
                textView.setText(getContext().getString(R$string.str_ring_step_level1));
            } else if (parseFloat > f10 && parseFloat < (C * 2) / 5) {
                textView.setText(getContext().getString(R$string.str_ring_step_level2));
            } else if (parseFloat > (2 * C) / 5 && parseFloat < (C * 3) / 5) {
                textView.setText(getContext().getString(R$string.str_ring_step_level3));
            } else if (parseFloat > (3 * C) / 5 && parseFloat < (C * 4) / 5) {
                textView.setText(getContext().getString(R$string.str_ring_step_level4));
            } else if (parseFloat >= (C * 4) / 5) {
                textView.setText(getContext().getString(R$string.str_ring_step_level5));
            }
        } else {
            halfCircle.setText("--");
            textView.setText(R$string.str_no_data);
        }
        f(baseViewHolder.getView(R$id.step_content));
        int D = y1.a().D();
        if (D == 1) {
            baseViewHolder.setBackgroundResource(R$id.step_content, R$mipmap.homepage_step_bg_1);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
        } else if (D == 2) {
            baseViewHolder.setBackgroundResource(R$id.step_content, R$mipmap.homepage_step_bg_2);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
        } else {
            baseViewHolder.setBackgroundResource(R$id.step_content, R$mipmap.homepage_step_bg);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(BaseViewHolder baseViewHolder, Object obj) {
        HomeSugarModel homeSugarModel = (HomeSugarModel) ((BaseDataModel) obj);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        int D = com.example.test.utils.k.f8731b.D();
        if (D == 1) {
            baseViewHolder.setBackgroundResource(R$id.bo_content, R$mipmap.homepage_bloodsugar_bg_1);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
            baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_6E99D3));
            baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_6E99D3));
            baseViewHolder.setTextColor(R$id.tv_current_bo, getContext().getColor(R$color.color_6E99D3));
            baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_6E99D3));
            baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_6E99D3));
            baseViewHolder.setImageResource(R$id.icon, R$mipmap.ring_home_bloodsugar_icon_white);
            baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_6E99D3));
        } else if (D == 2) {
            baseViewHolder.setBackgroundResource(R$id.bo_content, R$mipmap.homepage_bloodsugar_bg_2);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
            baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_current_bo, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_white));
            baseViewHolder.setImageResource(R$id.icon, R$mipmap.ic_bloodsugar_white);
            baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_white));
        } else {
            baseViewHolder.setBackgroundResource(R$id.bo_content, R$mipmap.homepage_bloodsugar_bg);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
            baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_current_bo, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_white));
            baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_828282));
            baseViewHolder.setImageResource(R$id.icon, R$mipmap.ic_bloodsugar_white);
            baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_white));
        }
        LineChart lineChart = (LineChart) baseViewHolder.getView(R$id.chart1);
        lineChart.setDrawGridBackground(false);
        lineChart.getDescription().f16406a = false;
        lineChart.setTouchEnabled(false);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(false);
        lineChart.setPinchZoom(false);
        n7.h xAxis = lineChart.getXAxis();
        xAxis.I = XAxis$XAxisPosition.BOTTOM;
        xAxis.g();
        xAxis.e = 0;
        xAxis.r = false;
        n7.i axisLeft = lineChart.getAxisLeft();
        n7.i axisRight = lineChart.getAxisRight();
        axisLeft.getClass();
        axisLeft.f(0.0f);
        axisRight.f16406a = false;
        axisLeft.h(4, true);
        axisLeft.e = -1;
        axisLeft.J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
        axisLeft.b();
        axisLeft.f16402w = true;
        lineChart.setNoDataText("暂无数据");
        lineChart.setNoDataTextColor(-1);
        lineChart.getLegend().f16406a = false;
        lineChart.invalidate();
        List<Entry> dataItems = homeSugarModel.getDataItems();
        if (lineChart.getData() != 0 && ((o7.j) lineChart.getData()).c() > 0) {
            o7.k kVar = (o7.k) ((o7.j) lineChart.getData()).b(0);
            if (dataItems == null) {
                ((o7.j) lineChart.getData()).h(kVar);
                lineChart.g();
            } else {
                kVar.m(dataItems);
                ((o7.j) lineChart.getData()).a();
            }
            lineChart.n();
        } else if (dataItems != null) {
            o7.k kVar2 = new o7.k(dataItems);
            kVar2.B = LineDataSet$Mode.CUBIC_BEZIER;
            kVar2.G = 0.2f;
            kVar2.A = true;
            kVar2.I = false;
            kVar2.f16824t = android.support.v4.media.session.e.a(kVar2, 244, 117, 117);
            kVar2.l(-1);
            kVar2.f16837x = -1;
            kVar2.f16838y = 60;
            kVar2.f16835v = false;
            o7.j jVar = new o7.j(kVar2);
            jVar.j();
            jVar.i();
            lineChart.setData(jVar);
        } else {
            lineChart.g();
            lineChart.n();
        }
        lineChart.invalidate();
        baseViewHolder.setText(R$id.start_time, homeSugarModel.getStartTime());
        baseViewHolder.setText(R$id.end_time, homeSugarModel.getEndTime());
        if (homeSugarModel.getCurrentSugar() > 0.0f) {
            baseViewHolder.setText(R$id.tv_current_bo, String.format("%.1f", Float.valueOf(homeSugarModel.getCurrentSugar())));
        } else {
            baseViewHolder.setText(R$id.tv_current_bo, "--");
        }
        TextView textView = (TextView) baseViewHolder.getView(R$id.tv_no_data);
        if (homeSugarModel.getItems() != null) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        ((TextView) baseViewHolder.getView(R$id.tv_range)).setText(this.context.getString(R$string.str_ring_hr_range) + "3.9-6.1 mmol/L");
        baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        f(baseViewHolder.getView(R$id.bo_content));
    }

    private final void n(BaseViewHolder baseViewHolder, Object obj) {
        HomeBpModel homeBpModel = (HomeBpModel) ((BaseDataModel) obj);
        if (homeBpModel.getCurrentSp() > 0) {
            baseViewHolder.setText(R$id.tv_sp, homeBpModel.getCurrentSp() + "");
        } else {
            baseViewHolder.setText(R$id.tv_sp, "--");
        }
        if (homeBpModel.getCurrentDp() > 0) {
            baseViewHolder.setText(R$id.tv_dp, homeBpModel.getCurrentDp() + "");
        } else {
            baseViewHolder.setText(R$id.tv_dp, "--");
        }
        LineChartView lineChartView = (LineChartView) baseViewHolder.getView(R$id.lineChartDouble);
        List<PointF> itemSp = homeBpModel.getItemSp();
        List<PointF> itemDp = homeBpModel.getItemDp();
        lineChartView.f8459g = itemSp;
        lineChartView.f8460h = itemDp;
        lineChartView.postInvalidate();
        f(baseViewHolder.getView(R$id.bp_content));
    }

    private final void o(BaseViewHolder baseViewHolder, Object obj) {
        HomeBSModel homeBSModel = (HomeBSModel) ((BaseDataModel) obj);
        LineGradientChartView lineGradientChartView = (LineGradientChartView) baseViewHolder.getView(R$id.lineChart);
        lineGradientChartView.setColor(R$color.color_45ffa5);
        lineGradientChartView.setData(homeBSModel.getItems());
        if (homeBSModel.getCurrentStress() > 0) {
            baseViewHolder.setText(R$id.tv_current_stress, homeBSModel.getCurrentStress() + "");
            if (homeBSModel.getCurrentStress() > 0 && homeBSModel.getCurrentStress() < 30) {
                baseViewHolder.setText(R$id.tv_stress_unit, R$string.str_normal_press_range);
            } else if (homeBSModel.getCurrentStress() >= 30 && homeBSModel.getCurrentStress() < 60) {
                baseViewHolder.setText(R$id.tv_stress_unit, R$string.str_slow_press);
            } else if (homeBSModel.getCurrentStress() >= 60 && homeBSModel.getCurrentStress() < 80) {
                baseViewHolder.setText(R$id.tv_stress_unit, R$string.str_middle_press);
            } else if (homeBSModel.getCurrentStress() >= 80 && homeBSModel.getCurrentStress() < 100) {
                baseViewHolder.setText(R$id.tv_stress_unit, R$string.str_height_press);
            }
        } else {
            baseViewHolder.setText(R$id.tv_current_stress, "--");
            baseViewHolder.setText(R$id.tv_stress_unit, "");
        }
        f(baseViewHolder.getView(R$id.stress_content));
    }

    private final void p(BaseViewHolder baseViewHolder, Object obj) {
        HomeBtModel homeBtModel = (HomeBtModel) ((BaseDataModel) obj);
        LineGradientChartView lineGradientChartView = (LineGradientChartView) baseViewHolder.getView(R$id.lineChart);
        lineGradientChartView.setColor(R$color.color_94ff4c);
        lineGradientChartView.setData(homeBtModel.getItems());
        if (homeBtModel.getCurrentBt() > 0.0f) {
            baseViewHolder.setText(R$id.tv_current_bt, String.format(Locale.ENGLISH, "%.1f", Float.valueOf(((int) (homeBtModel.getCurrentBt() * 10)) / 10.0f)));
        } else {
            baseViewHolder.setText(R$id.tv_current_bt, "--");
        }
        String str = "℃";
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            User d5 = kVar.d();
            if ((d5 != null ? d5.getTempUnit() : 0) == 1) {
                str = "℉";
            }
        }
        baseViewHolder.setText(R$id.tv_temp_unit, str);
        f(baseViewHolder.getView(R$id.bt_content));
    }

    private final void q(BaseViewHolder baseViewHolder, Object obj) {
        baseViewHolder.setText(R$id.item_name, R$string.str_breathe_title);
        HomeBreatheModel homeBreatheModel = (HomeBreatheModel) ((BaseDataModel) obj);
        if (homeBreatheModel.getBreatheTime() > 0) {
            int i3 = R$id.tv_current_breathe;
            Locale locale = Locale.ENGLISH;
            int breatheTime = homeBreatheModel.getBreatheTime();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(breatheTime);
            baseViewHolder.setText(i3, sb2.toString());
        } else {
            baseViewHolder.setText(R$id.tv_current_breathe, "--");
        }
        BorderProgressView borderProgressView = (BorderProgressView) baseViewHolder.getView(R$id.progress);
        int breatheTime2 = homeBreatheModel.getBreatheTime();
        Object obj2 = com.example.test.utils.m.f8734b;
        borderProgressView.setCurrentProgress(breatheTime2 >= 10 ? 100 : (int) ((homeBreatheModel.getBreatheTime() / 10) * 100.0f));
        f(baseViewHolder.getView(R$id.breathe_content));
    }

    private final void r(BaseViewHolder baseViewHolder, Object obj) {
        HomeHrModel homeHrModel = (HomeHrModel) ((BaseDataModel) obj);
        if (homeHrModel.getCurrentHr() > 0) {
            int i3 = R$id.tv_current_hr;
            Locale locale = Locale.ENGLISH;
            int currentHr = homeHrModel.getCurrentHr();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(currentHr);
            baseViewHolder.setText(i3, sb2.toString());
        } else {
            baseViewHolder.setText(R$id.tv_current_hr, "--");
        }
        ((LineGradientChartView) baseViewHolder.getView(R$id.lineChart)).setData(homeHrModel.getItems());
        f(baseViewHolder.getView(R$id.hr_content));
    }

    private final void s(BaseViewHolder baseViewHolder, Object obj) {
        HomeSleepModel homeSleepModel = (HomeSleepModel) ((BaseDataModel) obj);
        if (homeSleepModel.getTotalHour() > 0 || homeSleepModel.getTotalMin() > 0) {
            baseViewHolder.setText(R$id.tv_hour, String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(homeSleepModel.getTotalHour())));
        } else {
            baseViewHolder.setText(R$id.tv_hour, "--");
        }
        if (homeSleepModel.getTotalHour() > 0 || homeSleepModel.getTotalMin() > 0) {
            baseViewHolder.setText(R$id.tv_min, String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(homeSleepModel.getTotalMin())));
        } else {
            baseViewHolder.setText(R$id.tv_min, "--");
        }
        ((SleepChartView) baseViewHolder.getView(R$id.sleepChart)).setData(homeSleepModel.getItems());
        f(baseViewHolder.getView(R$id.sleep_content));
    }

    private final void t(BaseViewHolder baseViewHolder, Object obj) {
        HomeStepModel homeStepModel = (HomeStepModel) ((BaseDataModel) obj);
        CircleProgressView circleProgressView = (CircleProgressView) baseViewHolder.getView(R$id.step_progress);
        String currentSteps = homeStepModel.getCurrentSteps();
        if (currentSteps == null || currentSteps.length() == 0 || "null".equalsIgnoreCase(currentSteps)) {
            circleProgressView.f8367n = 0.0f;
            circleProgressView.f8368o = "0";
            circleProgressView.f8369p = circleProgressView.f8361h.measureText("0");
            circleProgressView.invalidate();
        } else {
            float targetPerCent = homeStepModel.getTargetPerCent();
            String currentSteps2 = homeStepModel.getCurrentSteps();
            circleProgressView.f8367n = targetPerCent;
            circleProgressView.f8368o = currentSteps2;
            circleProgressView.f8369p = circleProgressView.f8361h.measureText(currentSteps2);
            circleProgressView.invalidate();
        }
        String string = this.context.getString(R$string.str_km);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            User d5 = kVar.d();
            if ((d5 != null ? d5.getMeterUnit() : 0) == 1) {
                string = this.context.getString(R$string.str_mile);
            }
        }
        int i3 = R$id.tv_calorie;
        Locale locale = Locale.ENGLISH;
        baseViewHolder.setText(i3, String.format(locale, "%.1f%s", Float.valueOf(((int) (homeStepModel.getCalorie() * 10)) / 10.0f), "KCAL"));
        baseViewHolder.setText(R$id.tv_distance, String.format(locale, "%.2f%s", Float.valueOf(((int) (homeStepModel.getDistance() * 100)) / 100.0f), string));
        baseViewHolder.setText(R$id.tv_target, homeStepModel.getTarget() + this.context.getString(R$string.str_unit_step));
        f(baseViewHolder.getView(R$id.step_content));
    }

    private final void u(BaseViewHolder baseViewHolder, Object obj) {
        HomeSugarModel homeSugarModel = (HomeSugarModel) ((BaseDataModel) obj);
        if (homeSugarModel.getCurrentSugar() > 0.0f) {
            baseViewHolder.setText(R$id.tv_current_sugar, String.format(Locale.ENGLISH, "%.01f", Float.valueOf(homeSugarModel.getCurrentSugar())));
        } else {
            baseViewHolder.setText(R$id.tv_current_sugar, "--");
        }
        LineGradientChartView lineGradientChartView = (LineGradientChartView) baseViewHolder.getView(R$id.lineChart);
        lineGradientChartView.setColor(R$color.color_FED633);
        lineGradientChartView.setData(homeSugarModel.getItems());
        f(baseViewHolder.getView(R$id.sugar_content));
    }

    private final void v(BaseViewHolder baseViewHolder, Object obj) {
        HomeVaperBatteryModel homeVaperBatteryModel = (HomeVaperBatteryModel) ((BaseDataModel) obj);
        baseViewHolder.setText(R$id.tv_current_vaperbattery, homeVaperBatteryModel.getCurrentBattery() + "");
        if (homeVaperBatteryModel.getCurrentBattery() > 76 && homeVaperBatteryModel.getCurrentBattery() <= 100) {
            baseViewHolder.setImageResource(R$id.iv_battery_level, R$mipmap.vaper_battery_level4);
            return;
        }
        if (homeVaperBatteryModel.getCurrentBattery() == 0) {
            baseViewHolder.setImageResource(R$id.iv_battery_level, R$mipmap.vaper_battery_level0);
            return;
        }
        if (homeVaperBatteryModel.getCurrentBattery() < 26) {
            baseViewHolder.setImageResource(R$id.iv_battery_level, R$mipmap.vaper_battery_level1);
        } else if (homeVaperBatteryModel.getCurrentBattery() <= 25 || homeVaperBatteryModel.getCurrentBattery() > 50) {
            baseViewHolder.setImageResource(R$id.iv_battery_level, R$mipmap.vaper_battery_level3);
        } else {
            baseViewHolder.setImageResource(R$id.iv_battery_level, R$mipmap.vaper_battery_level2);
        }
    }

    private final void w() {
    }

    @Override // com.example.test.ui.view.e
    public final void b() {
        switch (this.f8263b) {
            case 0:
                getContext().startActivity(new Intent(getContext(), (Class<?>) TRingBloodOxygenStatisticsActivity.class));
                break;
            case 1:
                getContext().startActivity(new Intent(getContext(), (Class<?>) TRingBloodPressureStatisticsActivity.class));
                break;
            case 2:
                getContext().startActivity(new Intent(getContext(), (Class<?>) TRingEditCardActivity.class));
                break;
            case 3:
                com.example.test.utils.w0.d().getClass();
                if (!com.example.test.utils.w0.g()) {
                    getContext().startActivity(new Intent(getContext(), (Class<?>) TRingFamilyActivity.class));
                    break;
                } else {
                    com.example.baselibrary.utils.d.a(R$string.str_family_no_login);
                    break;
                }
            case 4:
                getContext().startActivity(new Intent(getContext(), (Class<?>) TRingHeartRateStatisticsActivity.class));
                break;
            case 5:
                Intent intent = new Intent();
                intent.putExtra("heartType", 1);
                intent.setClass(getContext(), TRingHeartRateStatisticsActivity.class);
                getContext().startActivity(intent);
                break;
            case 6:
                getContext().startActivity(new Intent(getContext(), (Class<?>) TRingSleepStatisticsActivity.class));
                break;
            case 7:
                getContext().startActivity(new Intent(getContext(), (Class<?>) TRingStepStatisticsActivity.class));
                break;
            case 8:
                getContext().startActivity(new Intent(getContext(), (Class<?>) TRingStressStatisticsActivity.class));
                break;
            case 9:
                getContext().startActivity(new Intent(getContext(), (Class<?>) TRingBloodSugarStatisticsActivity.class));
                break;
            case 10:
                getContext().startActivity(new Intent(getContext(), (Class<?>) BODetailActivity.class));
                break;
            case 11:
                getContext().startActivity(new Intent(getContext(), (Class<?>) BPDetailActivity.class));
                break;
            case 12:
                getContext().startActivity(new Intent(getContext(), (Class<?>) BSDetailActivity.class));
                break;
            case 13:
                getContext().startActivity(new Intent(getContext(), (Class<?>) BTDetailActivity.class));
                break;
            case 14:
                getContext().startActivity(new Intent(getContext(), (Class<?>) BreatheDetailActivity.class));
                break;
            case 15:
                getContext().startActivity(new Intent(getContext(), (Class<?>) HRDetailActivity.class));
                break;
            case 16:
                getContext().startActivity(new Intent(getContext(), (Class<?>) SleepDetailActivity.class));
                break;
            case 17:
                getContext().startActivity(new Intent(getContext(), (Class<?>) StepDetailActivity.class));
                break;
            case 18:
                getContext().startActivity(new Intent(getContext(), (Class<?>) SugarDetailActivity.class));
                break;
            case 19:
                break;
            default:
                Log.e("qob", "HomeViperPowerProvider onClick");
                getContext().startActivity(new Intent(getContext(), (Class<?>) VaperPowerActivity.class));
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final void convert(BaseViewHolder baseViewHolder, Object obj) {
        int i3;
        switch (this.f8263b) {
            case 0:
                HomeBoModel homeBoModel = (HomeBoModel) ((BaseDataModel) obj);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                int D = com.example.test.utils.k.f8731b.D();
                if (D == 1) {
                    baseViewHolder.setBackgroundResource(R$id.bo_content, R$mipmap.homepage_bo_bg_1);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
                    baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setTextColor(R$id.tv_current_bo, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setImageResource(R$id.icon, R$mipmap.ring_home_oo_icon_white);
                    baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_6E99D3));
                } else if (D == 2) {
                    baseViewHolder.setBackgroundResource(R$id.bo_content, R$mipmap.homepage_bo_bg_2);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
                    baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_current_bo, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_white));
                    baseViewHolder.setImageResource(R$id.icon, R$mipmap.ic_bo_blood);
                    baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_white));
                } else {
                    baseViewHolder.setBackgroundResource(R$id.bo_content, R$mipmap.homepage_bo_bg);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
                    baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_current_bo, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_828282));
                    baseViewHolder.setImageResource(R$id.icon, R$mipmap.ic_bo_blood);
                    baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_white));
                }
                LineChart lineChart = (LineChart) baseViewHolder.getView(R$id.chart1);
                lineChart.setDrawGridBackground(false);
                lineChart.getDescription().f16406a = false;
                lineChart.setTouchEnabled(false);
                lineChart.setDragEnabled(true);
                lineChart.setScaleEnabled(false);
                lineChart.setPinchZoom(false);
                n7.h xAxis = lineChart.getXAxis();
                xAxis.I = XAxis$XAxisPosition.BOTTOM;
                xAxis.g();
                xAxis.e = 0;
                xAxis.r = false;
                n7.i axisLeft = lineChart.getAxisLeft();
                n7.i axisRight = lineChart.getAxisRight();
                axisLeft.getClass();
                axisLeft.f(50.0f);
                axisRight.f16406a = false;
                axisLeft.h(4, true);
                axisLeft.e = -1;
                axisLeft.J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
                axisLeft.b();
                axisLeft.f16402w = true;
                lineChart.setNoDataText("暂无数据");
                lineChart.setNoDataTextColor(-1);
                lineChart.getLegend().f16406a = false;
                lineChart.invalidate();
                List<Entry> dataItems = homeBoModel.getDataItems();
                if (lineChart.getData() != 0 && ((o7.j) lineChart.getData()).c() > 0) {
                    Log.d("XXtong", "lineChart.getData() != null");
                    o7.k kVar = (o7.k) ((o7.j) lineChart.getData()).b(0);
                    if (dataItems == null) {
                        ((o7.j) lineChart.getData()).h(kVar);
                        lineChart.g();
                    } else {
                        kVar.m(dataItems);
                        ((o7.j) lineChart.getData()).a();
                    }
                    lineChart.n();
                } else if (dataItems != null) {
                    Log.d("XXtong", "hrChartData size = " + dataItems.size());
                    o7.k kVar2 = new o7.k(dataItems);
                    kVar2.B = LineDataSet$Mode.CUBIC_BEZIER;
                    kVar2.G = 0.2f;
                    kVar2.A = true;
                    kVar2.I = false;
                    kVar2.f16824t = android.support.v4.media.session.e.a(kVar2, 244, 117, 117);
                    kVar2.l(-1);
                    kVar2.f16837x = -1;
                    kVar2.f16838y = 60;
                    kVar2.f16835v = false;
                    o7.j jVar = new o7.j(kVar2);
                    jVar.j();
                    jVar.i();
                    lineChart.setData(jVar);
                } else {
                    lineChart.g();
                    lineChart.n();
                }
                lineChart.invalidate();
                baseViewHolder.setText(R$id.start_time, homeBoModel.getStartTime());
                baseViewHolder.setText(R$id.end_time, homeBoModel.getEndTime());
                if (homeBoModel.getCurrentBo() > 0) {
                    baseViewHolder.setText(R$id.tv_current_bo, homeBoModel.getCurrentBo() + "");
                } else {
                    baseViewHolder.setText(R$id.tv_current_bo, "--");
                }
                TextView textView = (TextView) baseViewHolder.getView(R$id.tv_no_data);
                if (homeBoModel.getItems() != null) {
                    Log.d("tong3", "bo data size = " + homeBoModel.getItems().size());
                    textView.setVisibility(8);
                } else {
                    Log.d("tong3", "bo no data  ");
                    textView.setVisibility(0);
                }
                ((TextView) baseViewHolder.getView(R$id.tv_range)).setText(this.context.getString(R$string.str_ring_hr_range) + "97 - 99 %");
                baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                f(baseViewHolder.getView(R$id.bo_content));
                return;
            case 1:
                HomeBpModel homeBpModel = (HomeBpModel) ((BaseDataModel) obj);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                int D2 = com.example.test.utils.k.f8731b.D();
                if (D2 == 1) {
                    baseViewHolder.setBackgroundResource(R$id.bo_content, R$mipmap.homepage_bo_bg_1);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
                    baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setTextColor(R$id.tv_current_bo, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setImageResource(R$id.icon, R$mipmap.ic_bloodpressure_white);
                    baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_6E99D3));
                } else if (D2 == 2) {
                    baseViewHolder.setBackgroundResource(R$id.bo_content, R$mipmap.homepage_bo_bg_2);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
                    baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_current_bo, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_white));
                    baseViewHolder.setImageResource(R$id.icon, R$mipmap.ic_bloodpressure_white);
                    baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_white));
                } else {
                    baseViewHolder.setBackgroundResource(R$id.bo_content, R$mipmap.homepage_bo_bg);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
                    baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_current_bo, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_828282));
                    baseViewHolder.setImageResource(R$id.icon, R$mipmap.ic_bloodpressure_white);
                    baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_white));
                }
                LineChart lineChart2 = (LineChart) baseViewHolder.getView(R$id.chart1);
                int i10 = 0;
                lineChart2.setDrawGridBackground(false);
                lineChart2.getDescription().f16406a = false;
                lineChart2.setTouchEnabled(false);
                lineChart2.setDragEnabled(true);
                lineChart2.setScaleEnabled(false);
                lineChart2.setPinchZoom(false);
                n7.h xAxis2 = lineChart2.getXAxis();
                xAxis2.I = XAxis$XAxisPosition.BOTTOM;
                xAxis2.g();
                xAxis2.e = 0;
                xAxis2.r = false;
                n7.i axisLeft2 = lineChart2.getAxisLeft();
                n7.i axisRight2 = lineChart2.getAxisRight();
                axisLeft2.getClass();
                axisLeft2.f(50.0f);
                axisRight2.f16406a = false;
                axisLeft2.h(4, true);
                axisLeft2.e = -1;
                axisLeft2.J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
                axisLeft2.b();
                axisLeft2.f16402w = true;
                lineChart2.setNoDataText("暂无数据");
                lineChart2.setNoDataTextColor(-1);
                lineChart2.getLegend().f16406a = false;
                lineChart2.invalidate();
                if (homeBpModel.getItemDps() == null) {
                    homeBpModel.setItemSps(new ArrayList());
                }
                if (homeBpModel.getItemDps() == null) {
                    homeBpModel.setItemDps(new ArrayList());
                }
                if (lineChart2.getData() != 0 && ((o7.j) lineChart2.getData()).c() > 0) {
                    Log.d("XXtong", "lineChart.getData() != null");
                    o7.k kVar3 = (o7.k) ((o7.j) lineChart2.getData()).b(0);
                    o7.k kVar4 = (o7.k) ((o7.j) lineChart2.getData()).b(1);
                    if (homeBpModel.getItemSps() == null) {
                        ((o7.j) lineChart2.getData()).h(kVar3);
                        lineChart2.g();
                    } else {
                        kVar3.m(homeBpModel.getItemSps());
                        ((o7.j) lineChart2.getData()).a();
                    }
                    if (homeBpModel.getItemDps() == null) {
                        ((o7.j) lineChart2.getData()).h(kVar4);
                        lineChart2.g();
                    } else {
                        kVar4.m(homeBpModel.getItemDps());
                        ((o7.j) lineChart2.getData()).a();
                    }
                    lineChart2.n();
                } else if (homeBpModel.getItemDps() == null || homeBpModel.getItemSps() == null) {
                    lineChart2.g();
                    lineChart2.n();
                } else {
                    Log.d("XXtong", "hrChartData size = " + homeBpModel.getItemDps().size());
                    o7.k kVar5 = new o7.k(homeBpModel.getItemSps());
                    LineDataSet$Mode lineDataSet$Mode = LineDataSet$Mode.CUBIC_BEZIER;
                    kVar5.B = lineDataSet$Mode;
                    kVar5.G = 0.2f;
                    kVar5.A = true;
                    kVar5.I = false;
                    kVar5.f16824t = android.support.v4.media.session.e.a(kVar5, 244, 117, 117);
                    kVar5.l(getContext().getColor(R$color.color_D84D2B));
                    kVar5.f16837x = getContext().getColor(R$color.color_D84D2B);
                    kVar5.f16838y = 60;
                    kVar5.f16835v = false;
                    kVar5.H = new com.example.test.ui.sport.activity.l(lineChart2, 7);
                    o7.k kVar6 = new o7.k(homeBpModel.getItemDps());
                    kVar6.B = lineDataSet$Mode;
                    kVar6.G = 0.2f;
                    kVar6.A = true;
                    kVar6.f16838y = 60;
                    kVar6.I = false;
                    kVar6.f16824t = android.support.v4.media.session.e.a(kVar6, 244, 117, 117);
                    kVar6.l(getContext().getColor(R$color.color_6E600));
                    kVar6.f16837x = getContext().getColor(R$color.color_6E600);
                    kVar6.f16835v = false;
                    kVar6.H = new com.example.test.ui.sport.activity.l(lineChart2, 8);
                    o7.j jVar2 = new o7.j(kVar5, kVar6);
                    jVar2.j();
                    jVar2.i();
                    lineChart2.setData(jVar2);
                }
                lineChart2.invalidate();
                baseViewHolder.setText(R$id.start_time, homeBpModel.getStartTime());
                baseViewHolder.setText(R$id.end_time, homeBpModel.getEndTime());
                if (homeBpModel.getCurrentDp() > 0) {
                    baseViewHolder.setText(R$id.tv_current_bo, homeBpModel.getCurrentSp() + "/" + homeBpModel.getCurrentDp() + "mmHg");
                } else {
                    baseViewHolder.setText(R$id.tv_current_bo, "--");
                }
                TextView textView2 = (TextView) baseViewHolder.getView(R$id.tv_no_data);
                if (homeBpModel.getItemDp() != null) {
                    Log.d("tong3", "bo data size = " + homeBpModel.getItemDp().size());
                    textView2.setVisibility(8);
                } else {
                    Log.d("tong3", "bo no data  ");
                    textView2.setVisibility(0);
                }
                TextView textView3 = (TextView) baseViewHolder.getView(R$id.tv_range);
                if (homeBpModel.getCurrentSp() <= 0 || homeBpModel.getCurrentDp() <= 0) {
                    textView3.setText("--");
                } else {
                    int currentSp = homeBpModel.getCurrentSp();
                    int currentDp = homeBpModel.getCurrentDp();
                    if (currentSp < 90 || currentDp < 60) {
                        i3 = R$string.bp_level_low;
                    } else if (currentSp < 140 || currentDp >= 90) {
                        int i11 = (currentSp < 120 || currentSp > 139) ? (currentSp < 140 || currentSp > 159) ? (currentSp < 160 || currentSp > 179) ? currentSp >= 180 ? 4 : 0 : 3 : 2 : 1;
                        if (currentDp >= 80 && currentDp <= 89) {
                            i10 = 1;
                        } else if (currentDp >= 90 && currentDp <= 99) {
                            i10 = 2;
                        } else if (currentDp >= 100 && currentDp <= 109) {
                            i10 = 3;
                        } else if (currentDp >= 110) {
                            i10 = 4;
                        }
                        int max = Math.max(i11, i10);
                        i3 = max != 0 ? max != 1 ? max != 2 ? max != 3 ? max != 4 ? R$string.bp_level_normal : R$string.bp_level_high_3 : R$string.bp_level_high_2 : R$string.bp_level_high_1 : R$string.bp_level_normal_high : R$string.bp_level_normal;
                    } else {
                        i3 = R$string.bp_level_isolated_systolic;
                    }
                    textView3.setText(this.context.getString(i3));
                }
                baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                f(baseViewHolder.getView(R$id.bo_content));
                return;
            case 2:
                f(baseViewHolder.getView(R$id.ec_content));
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                int D3 = com.example.test.utils.k.f8731b.D();
                if (D3 == 1) {
                    baseViewHolder.setTextColor(R$id.tv_title, getContext().getColor(R$color.color_black));
                    return;
                } else if (D3 == 2) {
                    baseViewHolder.setTextColor(R$id.tv_title, getContext().getColor(R$color.color_black));
                    return;
                } else {
                    baseViewHolder.setTextColor(R$id.tv_title, getContext().getColor(R$color.color_white));
                    return;
                }
            case 3:
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                int D4 = com.example.test.utils.k.f8731b.D();
                if (D4 == 1) {
                    baseViewHolder.setBackgroundResource(R$id.family_content, R$mipmap.homepage_family_bg_1);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
                } else if (D4 == 2) {
                    baseViewHolder.setBackgroundResource(R$id.family_content, R$mipmap.homepage_family_bg_2);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
                } else {
                    baseViewHolder.setBackgroundResource(R$id.family_content, R$mipmap.homepage_family_bg);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
                }
                baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                f(baseViewHolder.getView(R$id.family_content));
                return;
            case 4:
                HomeHrModel homeHrModel = (HomeHrModel) ((BaseDataModel) obj);
                if (homeHrModel.getCurrentHr() > 0) {
                    int i12 = R$id.tv_count;
                    Locale locale = Locale.ENGLISH;
                    baseViewHolder.setText(i12, homeHrModel.getCurrentHr() + " bpm");
                } else {
                    baseViewHolder.setText(R$id.tv_count, "--");
                }
                baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                TextView textView4 = (TextView) baseViewHolder.getView(R$id.tv_no_data);
                if (homeHrModel.getItems() != null) {
                    textView4.setVisibility(8);
                } else {
                    textView4.setVisibility(0);
                }
                ((TextView) baseViewHolder.getView(R$id.tv_range)).setText(this.context.getString(R$string.str_ring_hr_range) + "60 - 100 bpm");
                LineChart lineChart3 = (LineChart) baseViewHolder.getView(R$id.chart1);
                lineChart3.setDrawGridBackground(false);
                lineChart3.getDescription().f16406a = false;
                lineChart3.setTouchEnabled(false);
                lineChart3.setDragEnabled(true);
                lineChart3.setScaleEnabled(false);
                lineChart3.setPinchZoom(false);
                n7.h xAxis3 = lineChart3.getXAxis();
                xAxis3.I = XAxis$XAxisPosition.BOTTOM;
                xAxis3.g();
                xAxis3.e = 0;
                xAxis3.r = false;
                n7.i axisLeft3 = lineChart3.getAxisLeft();
                n7.i axisRight3 = lineChart3.getAxisRight();
                axisLeft3.getClass();
                axisLeft3.f(30.0f);
                axisRight3.f16406a = false;
                axisLeft3.h(4, false);
                axisLeft3.e = -1;
                axisLeft3.J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
                axisLeft3.b();
                axisLeft3.f16402w = true;
                lineChart3.setNoDataText("暂无数据");
                lineChart3.setNoDataTextColor(-1);
                lineChart3.getLegend().f16406a = false;
                lineChart3.invalidate();
                List<Entry> dataItems2 = homeHrModel.getDataItems();
                if (lineChart3.getData() != 0 && ((o7.j) lineChart3.getData()).c() > 0) {
                    Log.d("XXtong", "lineChart.getData() != null");
                    o7.k kVar7 = (o7.k) ((o7.j) lineChart3.getData()).b(0);
                    if (dataItems2 == null) {
                        ((o7.j) lineChart3.getData()).h(kVar7);
                        lineChart3.g();
                    } else {
                        kVar7.m(dataItems2);
                        ((o7.j) lineChart3.getData()).a();
                    }
                    lineChart3.n();
                } else if (dataItems2 != null) {
                    o7.k kVar8 = new o7.k(dataItems2);
                    kVar8.B = LineDataSet$Mode.CUBIC_BEZIER;
                    kVar8.G = 0.2f;
                    kVar8.A = true;
                    kVar8.I = false;
                    kVar8.f16824t = android.support.v4.media.session.e.a(kVar8, 244, 117, 117);
                    kVar8.l(-1);
                    kVar8.f16837x = -1;
                    kVar8.f16838y = 60;
                    kVar8.f16835v = false;
                    o7.j jVar3 = new o7.j(kVar8);
                    jVar3.j();
                    jVar3.i();
                    lineChart3.setData(jVar3);
                } else {
                    lineChart3.g();
                    lineChart3.n();
                }
                lineChart3.invalidate();
                baseViewHolder.setText(R$id.start_time, homeHrModel.getStartTime());
                baseViewHolder.setText(R$id.end_time, homeHrModel.getEndTime());
                f(baseViewHolder.getView(R$id.hr_content));
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                int D5 = com.example.test.utils.k.f8731b.D();
                if (D5 == 1) {
                    baseViewHolder.setBackgroundResource(R$id.hr_content, R$mipmap.homepage_heartrate_1);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
                    baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_6E99D3));
                    baseViewHolder.setImageResource(R$id.iv_heart, R$mipmap.ring_home_heart_icon_white);
                    baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_6E99D3));
                    return;
                }
                if (D5 == 2) {
                    baseViewHolder.setBackgroundResource(R$id.hr_content, R$mipmap.homepage_heartrate_2);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
                    baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_white));
                    baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_white));
                    baseViewHolder.setImageResource(R$id.iv_heart, R$mipmap.ic_heartrate_heart);
                    baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_white));
                    return;
                }
                baseViewHolder.setBackgroundResource(R$id.hr_content, R$mipmap.homepage_heartrate);
                baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
                baseViewHolder.setTextColor(R$id.item_name, getContext().getColor(R$color.color_white));
                baseViewHolder.setTextColor(R$id.tv_date, getContext().getColor(R$color.color_white));
                baseViewHolder.setTextColor(R$id.tv_count, getContext().getColor(R$color.color_white));
                baseViewHolder.setTextColor(R$id.tv_range, getContext().getColor(R$color.color_828282));
                baseViewHolder.setImageResource(R$id.iv_heart, R$mipmap.ic_heartrate_heart);
                baseViewHolder.setTextColor(R$id.tv_no_data, getContext().getColor(R$color.color_white));
                return;
            case 5:
                j(baseViewHolder, obj);
                return;
            case 6:
                k(baseViewHolder, obj);
                return;
            case 7:
                l(baseViewHolder, obj);
                return;
            case 8:
                HomeBSModel homeBSModel = (HomeBSModel) ((BaseDataModel) obj);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                int D6 = com.example.test.utils.k.f8731b.D();
                if (D6 == 1) {
                    baseViewHolder.setBackgroundResource(R$id.stress_content, R$mipmap.homepage_stress_bg_1);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
                } else if (D6 == 2) {
                    baseViewHolder.setBackgroundResource(R$id.stress_content, R$mipmap.homepage_stress_bg_2);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
                } else {
                    baseViewHolder.setBackgroundResource(R$id.stress_content, R$mipmap.homepage_stress_bg);
                    baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
                }
                baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                HalfCircle halfCircle = (HalfCircle) baseViewHolder.getView(R$id.stress_progress);
                TextView textView5 = (TextView) baseViewHolder.getView(R$id.tv_day_avg);
                TextView textView6 = (TextView) baseViewHolder.getView(R$id.tv_day_range);
                TextView textView7 = (TextView) baseViewHolder.getView(R$id.tv_avg_level);
                TextView textView8 = (TextView) baseViewHolder.getView(R$id.tv_range_level);
                TextView textView9 = (TextView) baseViewHolder.getView(R$id.tv_desc);
                if (homeBSModel.getCurrentStress() > 0) {
                    halfCircle.setText(homeBSModel.getCurrentStress() + "");
                    halfCircle.setMaxProgress(100.0f);
                    halfCircle.setProgress(Float.valueOf((float) homeBSModel.getCurrentStress()));
                    textView9.setText(ca.k(getContext(), homeBSModel.getCurrentStress()));
                    textView5.setText(homeBSModel.getAvgStress() + "");
                    textView7.setText(ca.k(getContext(), homeBSModel.getAvgStress()));
                    textView6.setText(homeBSModel.getMinStress() + "-" + homeBSModel.getMaxStress());
                    textView8.setText(ca.k(getContext(), homeBSModel.getMaxStress()));
                } else {
                    halfCircle.setText("--");
                    textView9.setText(R$string.str_no_data);
                    textView5.setText("--");
                    textView7.setText("");
                    textView6.setText("--");
                    textView8.setText("");
                }
                f(baseViewHolder.getView(R$id.stress_content));
                return;
            case 9:
                m(baseViewHolder, obj);
                return;
            case 10:
                HomeBoModel homeBoModel2 = (HomeBoModel) ((BaseDataModel) obj);
                LineGradientChartView lineGradientChartView = (LineGradientChartView) baseViewHolder.getView(R$id.lineChart);
                lineGradientChartView.setColor(R$color.color_d42725);
                lineGradientChartView.setData(homeBoModel2.getItems());
                if (homeBoModel2.getCurrentBo() > 0) {
                    baseViewHolder.setText(R$id.tv_current_bo, homeBoModel2.getCurrentBo() + "");
                } else {
                    baseViewHolder.setText(R$id.tv_current_bo, "--");
                }
                f(baseViewHolder.getView(R$id.bo_content));
                return;
            case 11:
                n(baseViewHolder, obj);
                return;
            case 12:
                o(baseViewHolder, obj);
                return;
            case 13:
                p(baseViewHolder, obj);
                return;
            case 14:
                q(baseViewHolder, obj);
                return;
            case 15:
                r(baseViewHolder, obj);
                return;
            case 16:
                s(baseViewHolder, obj);
                return;
            case 17:
                t(baseViewHolder, obj);
                return;
            case 18:
                u(baseViewHolder, obj);
                return;
            case 19:
                v(baseViewHolder, obj);
                return;
            default:
                HomeViperPowerModel homeViperPowerModel = (HomeViperPowerModel) ((BaseDataModel) obj);
                Log.e("qob", "HomeVaperPowerProvider PowerType " + homeViperPowerModel.getPowerType() + " CurrentPower " + homeViperPowerModel.getCurrentPower());
                if (homeViperPowerModel.getPowerType() == 2) {
                    ArrayList arrayList = new ArrayList();
                    for (int i13 : homeViperPowerModel.getPowerLevel()) {
                        arrayList.add(i13 + "W");
                    }
                    if (homeViperPowerModel.getCurrentPower() < arrayList.size()) {
                        baseViewHolder.setText(R$id.tv_current_viperpower, (CharSequence) arrayList.get(homeViperPowerModel.getCurrentPower()));
                        baseViewHolder.setImageResource(R$id.iv_power_level, R$mipmap.vaper_power_level3);
                    }
                } else if (homeViperPowerModel.getPowerType() == 3) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(this.context.getString(R$string.str_vaperpower_mode_normal));
                    arrayList2.add(this.context.getString(R$string.str_vaperpower_mode_smooth));
                    arrayList2.add(this.context.getString(R$string.str_vaperpower_mode_boost));
                    baseViewHolder.setText(R$id.tv_current_viperpower, (CharSequence) arrayList2.get(homeViperPowerModel.getCurrentPower()));
                    if (homeViperPowerModel.getCurrentPower() == 1) {
                        baseViewHolder.setImageResource(R$id.iv_power_level, R$mipmap.vaper_power_level2);
                    } else if (homeViperPowerModel.getCurrentPower() == 0) {
                        baseViewHolder.setImageResource(R$id.iv_power_level, R$mipmap.viper_power_level1);
                    } else {
                        baseViewHolder.setImageResource(R$id.iv_power_level, R$mipmap.vaper_power_level3);
                    }
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(this.context.getString(R$string.str_vaperpower_mode_smooth));
                    arrayList3.add(this.context.getString(R$string.str_vaperpower_mode_normal));
                    arrayList3.add(this.context.getString(R$string.str_vaperpower_mode_boost));
                    if (homeViperPowerModel.getCurrentPower() > 2) {
                        homeViperPowerModel.setCurrentPower(2);
                    }
                    baseViewHolder.setText(R$id.tv_current_viperpower, (CharSequence) arrayList3.get(homeViperPowerModel.getCurrentPower()));
                    if (homeViperPowerModel.getCurrentPower() == 0) {
                        baseViewHolder.setImageResource(R$id.iv_power_level, R$mipmap.viper_power_level1);
                    } else if (homeViperPowerModel.getCurrentPower() == 1) {
                        baseViewHolder.setImageResource(R$id.iv_power_level, R$mipmap.vaper_power_level2);
                    } else {
                        baseViewHolder.setImageResource(R$id.iv_power_level, R$mipmap.vaper_power_level3);
                    }
                }
                f(baseViewHolder.getView(R$id.vaperpower_content));
                return;
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getItemViewType() {
        switch (this.f8263b) {
            case 0:
                return 3;
            case 1:
                return 2;
            case 2:
                return 14;
            case 3:
                return 16;
            case 4:
                return 1;
            case 5:
                return 13;
            case 6:
                return 4;
            case 7:
                return 0;
            case 8:
                return 6;
            case 9:
                return 9;
            case 10:
                return 3;
            case 11:
                return 2;
            case 12:
                return 6;
            case 13:
                return 5;
            case 14:
                return 7;
            case 15:
                return 1;
            case 16:
                return 4;
            case 17:
                return 0;
            case 18:
                return 9;
            case 19:
                return 12;
            default:
                return 11;
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getLayoutId() {
        switch (this.f8263b) {
            case 0:
                return R$layout.item_ring_bo;
            case 1:
                return R$layout.item_ring_bp;
            case 2:
                return R$layout.item_ring_editcard;
            case 3:
                return R$layout.item_ring_family;
            case 4:
                return R$layout.item_ring_hr;
            case 5:
                return R$layout.item_ring_hrv;
            case 6:
                return R$layout.item_ring_sleep;
            case 7:
                return R$layout.item_ring_step;
            case 8:
                return R$layout.item_ring_stress;
            case 9:
                return R$layout.item_ring_suger;
            case 10:
                return R$layout.item_bo;
            case 11:
                return R$layout.item_home_bp;
            case 12:
                return R$layout.item_stress;
            case 13:
                return R$layout.item_bt;
            case 14:
                return R$layout.item_breathe;
            case 15:
                return R$layout.item_hr;
            case 16:
                return R$layout.item_sleep;
            case 17:
                return R$layout.item_step;
            case 18:
                return R$layout.item_suger;
            case 19:
                return R$layout.item_viper_battery;
            default:
                return R$layout.item_viper_power;
        }
    }
}
