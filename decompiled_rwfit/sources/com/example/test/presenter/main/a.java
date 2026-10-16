package com.example.test.presenter.main;

import com.example.test.ui.model.chart.chart.StepChartData;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;

/* loaded from: classes.dex */
public final class a extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        com.example.baselibrary.preseneter.b.j(date, new oh.l() { // from class: com.example.test.presenter.main.ActivityPresenter$getDayStepStatistics$1
            @Override // oh.l
            public final StepChartData invoke(String dateTime) {
                kotlin.jvm.internal.e.f(dateTime, "dateTime");
                if (y5.d.f20005b) {
                    Object obj = com.example.test.utils.m.f8734b;
                    if (!d2.a().a()) {
                        return com.example.test.presenter.analysis.a.g(dateTime);
                    }
                }
                return com.example.test.presenter.analysis.a.f(dateTime);
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.ActivityPresenter$getDayStepStatistics$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StepChartData) obj);
                return eh.g.f12633a;
            }

            public final void invoke(StepChartData it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((g7.a) a.this.f7255a).R(it);
            }
        });
    }
}
