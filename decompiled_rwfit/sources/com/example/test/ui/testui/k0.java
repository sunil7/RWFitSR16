package com.example.test.ui.testui;

import com.example.blesdk.bean.function.ReminderModeBean;
import com.example.test.ui.device.model.OptionModel;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class k0 implements a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingOptionActivity f8287a;

    public k0(TRingOptionActivity tRingOptionActivity) {
        this.f8287a = tRingOptionActivity;
    }

    @Override // a7.e
    public final void B() {
        int i3 = TRingOptionActivity.K;
        TRingOptionActivity tRingOptionActivity = this.f8287a;
        Integer S0 = tRingOptionActivity.S0();
        if (S0 != null && S0.intValue() == 0) {
            ((com.example.test.presenter.device.w0) tRingOptionActivity.I0()).m((ReminderModeBean) tRingOptionActivity.J.getValue());
            return;
        }
        if (S0 != null && S0.intValue() == 3) {
            int[] iArr = new int[7];
            int i10 = 0;
            for (Object obj : tRingOptionActivity.T0()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.i.f();
                    throw null;
                }
                iArr[i10] = ((OptionModel) obj).isCheck() ? 1 : 0;
                i10 = i11;
            }
            yh.d.b().e(new EventBusBeans.OptionEvent(iArr));
            tRingOptionActivity.onBackPressed();
        }
    }

    @Override // a7.e
    public final void u0() {
        this.f8287a.onBackPressed();
    }
}
