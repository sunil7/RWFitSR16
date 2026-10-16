package com.example.test.ui.sport.activity;

import com.example.test.ui.testui.TRingBloodOxygenStatisticsActivity;
import com.example.test.ui.testui.TRingBloodPressureStatisticsActivity;
import com.example.test.ui.testui.TRingBloodSugarStatisticsActivity;
import com.example.test.ui.testui.TRingHeartRateStatisticsActivity;
import com.example.test.ui.testui.TRingStressStatisticsActivity;
import com.github.mikephil.charting.charts.LineChart;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements p7.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8177a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LineChart f8178b;

    public /* synthetic */ l(LineChart lineChart, int i3) {
        this.f8177a = i3;
        this.f8178b = lineChart;
    }

    @Override // p7.c
    public final float e(o7.k kVar, r7.g gVar) {
        LineChart lineChart = this.f8178b;
        switch (this.f8177a) {
            case 0:
                int i3 = SportNewRecordDetailActivity.M;
                break;
            case 1:
                int i10 = SportRecordDetailActivity.M;
                break;
            case 2:
                int i11 = TRingBloodOxygenStatisticsActivity.J;
                break;
            case 3:
                int i12 = TRingBloodPressureStatisticsActivity.J;
                kotlin.jvm.internal.e.f(lineChart, "$lineChart");
                break;
            case 4:
                int i13 = TRingBloodPressureStatisticsActivity.J;
                kotlin.jvm.internal.e.f(lineChart, "$lineChart");
                break;
            case 5:
                int i14 = TRingBloodSugarStatisticsActivity.J;
                kotlin.jvm.internal.e.f(lineChart, "$lineChart");
                break;
            case 6:
                int i15 = TRingHeartRateStatisticsActivity.K;
                kotlin.jvm.internal.e.f(lineChart, "$lineChart");
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                int i16 = TRingStressStatisticsActivity.J;
                kotlin.jvm.internal.e.f(lineChart, "$lineChart");
                break;
        }
        return lineChart.getAxisLeft().B;
    }
}
