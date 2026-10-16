package com.example.test.ui.device.activity;

import com.example.blesdk.bean.function.ReminderModeBean;
import com.example.test.presenter.device.w0;
import com.example.test.ui.device.model.OptionModel;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class v implements a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OptionActivity f7892a;

    public v(OptionActivity optionActivity) {
        this.f7892a = optionActivity;
    }

    @Override // a7.e
    public final void B() {
        int i3 = OptionActivity.K;
        OptionActivity optionActivity = this.f7892a;
        Integer S0 = optionActivity.S0();
        if (S0 != null && S0.intValue() == 0) {
            ((w0) optionActivity.I0()).m((ReminderModeBean) optionActivity.J.getValue());
            return;
        }
        if (S0 != null && S0.intValue() == 3) {
            int[] iArr = new int[7];
            int i10 = 0;
            for (Object obj : optionActivity.T0()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.i.f();
                    throw null;
                }
                iArr[i10] = ((OptionModel) obj).isCheck() ? 1 : 0;
                i10 = i11;
            }
            yh.d.b().e(new EventBusBeans.OptionEvent(iArr));
            optionActivity.onBackPressed();
        }
    }

    @Override // a7.e
    public final void u0() {
        this.f7892a.onBackPressed();
    }
}
