package com.example.test.ui.device.activity;

import android.text.format.DateFormat;

/* loaded from: classes.dex */
public final class o0 implements t6.a, t6.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WomenHealthJLActivity f7883a;

    public /* synthetic */ o0(WomenHealthJLActivity womenHealthJLActivity) {
        this.f7883a = womenHealthJLActivity;
    }

    @Override // t6.d
    public void h(int i3, int i10, int i11) {
        WomenHealthJLActivity context = this.f7883a;
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
        int i13 = WomenHealthJLActivity.K;
        context.R0().setRemindHour(i10);
        context.R0().setRemindMin(i11);
        context.S0();
    }

    @Override // t6.a
    public void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        int i3 = WomenHealthJLActivity.K;
        WomenHealthJLActivity womenHealthJLActivity = this.f7883a;
        womenHealthJLActivity.R0().setOvulateDays(Integer.parseInt(data));
        womenHealthJLActivity.S0();
    }

    @Override // t6.d
    public void y() {
    }
}
