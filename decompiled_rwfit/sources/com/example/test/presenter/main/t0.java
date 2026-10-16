package com.example.test.presenter.main;

import android.util.Log;

/* loaded from: classes.dex */
public final class t0 implements w5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f7566a;

    public t0(u0 u0Var) {
        this.f7566a = u0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "WearHandCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
        Log.d("tong", "start test");
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        Log.d("tong", "start onResult data = " + num);
        if (num != null) {
            ((g7.o) this.f7566a.f7255a).f(num.intValue());
        }
    }
}
