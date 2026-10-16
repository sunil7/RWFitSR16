package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final class s0 implements v5.h0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f7565a;

    public s0(u0 u0Var) {
        this.f7565a = u0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "HeartRatePresenter2222", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "errorCode = "));
        ((XXBaseActivity) ((g7.o) this.f7565a.f7255a)).b0();
    }

    @Override // u5.g
    public final void c() {
        Log.e("qob", "HeartRatePresenter222 onSuccess");
        u0 u0Var = this.f7565a;
        DrinkReminderBean drinkReminderBean = u0Var.e;
        if (drinkReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(drinkReminderBean, new HeartRatePresenter$saveDB$1$1(u0Var), new HeartRatePresenter$saveDB$1$2(u0Var));
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        DrinkReminderBean drinkReminderBean = (DrinkReminderBean) obj;
        Log.e("qob", "HeartRatePresenter222 onResult");
        u0 u0Var = this.f7565a;
        ((XXBaseActivity) ((g7.o) u0Var.f7255a)).b0();
        if (drinkReminderBean != null) {
            ((g7.o) u0Var.f7255a).c(drinkReminderBean);
        }
    }
}
