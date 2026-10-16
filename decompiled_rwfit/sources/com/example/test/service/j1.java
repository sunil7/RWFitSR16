package com.example.test.service;

import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class j1 implements w5.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f7724a;

    public j1(u1 u1Var) {
        this.f7724a = u1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        this.f7724a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "deviceUnbindControlCallback errorCode " + i3);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "++++++", "解绑 onFail");
        yh.d.b().e(new EventBusBeans.DeviceFunEvent(2));
        e.h().q();
    }

    @Override // u5.g
    public final void c() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "++++++", "解绑 onSuccess");
        yh.d.b().e(new EventBusBeans.DeviceFunEvent(2));
        e.h().q();
    }

    @Override // u5.g
    public final /* bridge */ /* synthetic */ void e(Object obj) {
    }
}
