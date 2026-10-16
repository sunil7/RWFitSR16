package com.example.test.presenter.main;

import android.util.Log;

/* loaded from: classes.dex */
public final class f implements w5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f7507a;

    public f(g gVar) {
        this.f7507a = gVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BSStatisticsPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "WearHandCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
        Log.d("BSStatisticsPresenter", "start test");
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        Log.d("BSStatisticsPresenter", "start onResult data = " + num);
        if (num != null) {
            ((g7.d) this.f7507a.f7255a).f(num.intValue());
        }
    }
}
