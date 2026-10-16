package com.example.test.presenter.main;

import android.util.Log;

/* loaded from: classes.dex */
public final class j implements w5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f7523a;

    public j(k kVar) {
        this.f7523a = kVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "WearHandCallback errorCode "));
        Log.d("tong", "start failed");
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
            ((g7.f) this.f7523a.f7255a).f(num.intValue());
        }
    }
}
