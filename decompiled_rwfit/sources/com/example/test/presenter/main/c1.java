package com.example.test.presenter.main;

import com.example.test.ui.model.chart.chart.SleepChartData;
import com.example.test.ui.model.chart.chart.SleepItemData;
import com.google.android.gms.internal.mlkit_vision_barcode.fc;
import java.util.List;

/* loaded from: classes.dex */
public final class c1 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(final String time) {
        kotlin.jvm.internal.e.f(time, "time");
        com.example.baselibrary.preseneter.b.j(time, new oh.l() { // from class: com.example.test.presenter.main.SleepPresenter$getDaySleepData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final SleepChartData invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return com.example.test.presenter.analysis.a.e(time);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SleepPresenter$getDaySleepData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SleepChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(SleepChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.v) c1.this.f7255a).Y(it);
            }
        });
    }

    public final void l(List list, final float f2, final float f10) {
        com.example.baselibrary.preseneter.b.j(list, new oh.l() { // from class: com.example.test.presenter.main.SleepPresenter$invokeDayChart$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final List<x6.a> invoke(List<? extends SleepItemData> it) {
                kotlin.jvm.internal.e.f(it, "it");
                return fc.c(it, f2, f10);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.SleepPresenter$invokeDayChart$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends x6.a>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<? extends x6.a> it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.v) c1.this.f7255a).c0(it);
            }
        });
    }
}
