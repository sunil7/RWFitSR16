package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.function.DrinkReminderBean;

/* loaded from: classes.dex */
public final class e implements v5.i0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f7505a;

    public e(g gVar) {
        this.f7505a = gVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BSStatisticsPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "errorCode = "));
        ((g7.d) this.f7505a.f7255a).b0();
    }

    @Override // u5.g
    public final void c() {
        Log.e("qob", "BSStatisticsPresenter onSuccess");
        g gVar = this.f7505a;
        DrinkReminderBean drinkReminderBean = gVar.f7510d;
        if (drinkReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(drinkReminderBean, BSStatisticsPresenter$saveDB$1$1.INSTANCE, new BSStatisticsPresenter$saveDB$1$2(gVar));
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        DrinkReminderBean drinkReminderBean = (DrinkReminderBean) obj;
        Log.e("qob", "BSStatisticsPresenter onResult");
        g gVar = this.f7505a;
        ((g7.d) gVar.f7255a).b0();
        if (drinkReminderBean != null) {
            ((g7.d) gVar.f7255a).c(drinkReminderBean);
        }
    }
}
