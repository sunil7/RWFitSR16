package com.example.test.ui.testui;

import android.util.Log;

/* loaded from: classes.dex */
public final class e implements a7.e, t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HrReminderActivity f8271a;

    public /* synthetic */ e(HrReminderActivity hrReminderActivity) {
        this.f8271a = hrReminderActivity;
    }

    @Override // a7.e
    public void B() {
        int i3 = HrReminderActivity.G;
        HrReminderActivity hrReminderActivity = this.f8271a;
        ((com.example.test.presenter.device.m0) hrReminderActivity.I0()).m(hrReminderActivity.S0());
    }

    @Override // a7.e
    public void u0() {
        this.f8271a.onBackPressed();
    }

    @Override // t6.a
    public void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        Log.e("qob", "selectSingleDialog onDataSelect ".concat(data));
        int i3 = HrReminderActivity.G;
        HrReminderActivity hrReminderActivity = this.f8271a;
        hrReminderActivity.S0().setRemindValue(Integer.parseInt(data));
        ((com.example.test.presenter.device.m0) hrReminderActivity.I0()).m(hrReminderActivity.S0());
        hrReminderActivity.R0();
    }
}
