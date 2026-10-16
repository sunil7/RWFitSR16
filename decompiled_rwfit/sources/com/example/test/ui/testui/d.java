package com.example.test.ui.testui;

import android.util.Log;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final class d implements a7.e, t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HealthWatcherActivity f8268a;

    public /* synthetic */ d(HealthWatcherActivity healthWatcherActivity) {
        this.f8268a = healthWatcherActivity;
    }

    @Override // a7.e
    public void B() {
        int i3 = HealthWatcherActivity.L;
        HealthWatcherActivity healthWatcherActivity = this.f8268a;
        com.example.test.presenter.device.k0 k0Var = (com.example.test.presenter.device.k0) healthWatcherActivity.I0();
        DrinkReminderBean data = healthWatcherActivity.U0();
        k0Var.getClass();
        kotlin.jvm.internal.e.f(data, "data");
        k0Var.f7443b = data;
        ((XXBaseActivity) ((f7.m) k0Var.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.N(data);
    }

    @Override // a7.e
    public void u0() {
        this.f8268a.onBackPressed();
    }

    @Override // t6.a
    public void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        Log.e("qob", "selectSingleDialog onDataSelect ".concat(data));
        boolean equals = data.equals("30");
        HealthWatcherActivity healthWatcherActivity = this.f8268a;
        if (equals) {
            int i3 = HealthWatcherActivity.L;
            healthWatcherActivity.U0().setOpen(true);
            healthWatcherActivity.U0().setRemindDuration(30);
        } else if (data.equals("60")) {
            int i10 = HealthWatcherActivity.L;
            healthWatcherActivity.U0().setOpen(true);
            healthWatcherActivity.U0().setRemindDuration(60);
        } else {
            int i11 = HealthWatcherActivity.L;
            healthWatcherActivity.U0().setOpen(false);
            healthWatcherActivity.U0().setRemindDuration(60);
        }
        healthWatcherActivity.R0();
        com.example.test.presenter.device.k0 k0Var = (com.example.test.presenter.device.k0) healthWatcherActivity.I0();
        DrinkReminderBean data2 = healthWatcherActivity.U0();
        k0Var.getClass();
        kotlin.jvm.internal.e.f(data2, "data");
        k0Var.f7443b = data2;
        ((XXBaseActivity) ((f7.m) k0Var.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.N(data2);
    }
}
