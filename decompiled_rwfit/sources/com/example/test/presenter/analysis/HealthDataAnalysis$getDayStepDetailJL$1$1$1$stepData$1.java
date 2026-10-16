package com.example.test.presenter.analysis;

import com.example.database.table.RawDataStep;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.e;
import oh.l;

/* loaded from: classes.dex */
final /* synthetic */ class HealthDataAnalysis$getDayStepDetailJL$1$1$1$stepData$1 extends FunctionReferenceImpl implements l {
    public static final HealthDataAnalysis$getDayStepDetailJL$1$1$1$stepData$1 INSTANCE = new HealthDataAnalysis$getDayStepDetailJL$1$1$1$stepData$1();

    public HealthDataAnalysis$getDayStepDetailJL$1$1$1$stepData$1() {
        super(1, RawDataStep.class, "getStep", "getStep()I", 0);
    }

    @Override // oh.l
    public final Integer invoke(RawDataStep p02) {
        e.f(p02, "p0");
        return Integer.valueOf(p02.getStep());
    }
}
