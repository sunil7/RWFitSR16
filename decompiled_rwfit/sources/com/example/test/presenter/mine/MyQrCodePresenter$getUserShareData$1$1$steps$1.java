package com.example.test.presenter.mine;

import com.example.database.table.RawDataStep;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes.dex */
public /* synthetic */ class MyQrCodePresenter$getUserShareData$1$1$steps$1 extends FunctionReferenceImpl implements oh.l {
    public static final MyQrCodePresenter$getUserShareData$1$1$steps$1 INSTANCE = new MyQrCodePresenter$getUserShareData$1$1$steps$1();

    public MyQrCodePresenter$getUserShareData$1$1$steps$1() {
        super(1, RawDataStep.class, "getStep", "getStep()I", 0);
    }

    @Override // oh.l
    public final Integer invoke(RawDataStep p02) {
        kotlin.jvm.internal.e.f(p02, "p0");
        return Integer.valueOf(p02.getStep());
    }
}
