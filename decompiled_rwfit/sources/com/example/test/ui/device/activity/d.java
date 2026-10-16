package com.example.test.ui.device.activity;

import android.text.format.DateFormat;
import com.example.blesdk.bean.function.BreatheBean;

/* loaded from: classes.dex */
public final class d implements t6.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BreatheSettingActivity f7851a;

    public d(BreatheSettingActivity breatheSettingActivity) {
        this.f7851a = breatheSettingActivity;
    }

    @Override // t6.d
    public final void h(int i3, int i10, int i11) {
        BreatheSettingActivity context = this.f7851a;
        kotlin.jvm.internal.e.f(context, "context");
        if (!DateFormat.is24HourFormat(context)) {
            int i12 = i10 + 1;
            if (i3 == 1) {
                if (i12 < 12) {
                    i10 += 13;
                }
                i10 = i12;
            } else {
                if (i12 == 12) {
                    i10 = 0;
                }
                i10 = i12;
            }
        }
        int i13 = context.E;
        if (i13 == 0) {
            ((BreatheBean.TimeItem) android.support.v4.media.session.e.e(context, 0)).setHour(i10);
            context.S0().getBreatheTime().get(0).setMin(i11);
        } else if (i13 == context.F) {
            ((BreatheBean.TimeItem) android.support.v4.media.session.e.e(context, 1)).setHour(i10);
            context.S0().getBreatheTime().get(1).setMin(i11);
        } else if (i13 == context.G) {
            ((BreatheBean.TimeItem) android.support.v4.media.session.e.e(context, 2)).setHour(i10);
            context.S0().getBreatheTime().get(2).setMin(i11);
        } else if (i13 == context.H) {
            ((BreatheBean.TimeItem) android.support.v4.media.session.e.e(context, 3)).setHour(i10);
            context.S0().getBreatheTime().get(3).setMin(i11);
        } else if (i13 == context.I) {
            ((BreatheBean.TimeItem) android.support.v4.media.session.e.e(context, 4)).setHour(i10);
            context.S0().getBreatheTime().get(4).setMin(i11);
        }
        context.R0();
    }

    @Override // t6.d
    public final void y() {
    }
}
