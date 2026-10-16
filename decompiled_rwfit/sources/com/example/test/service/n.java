package com.example.test.service;

/* loaded from: classes.dex */
public final class n implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7734a;

    public n(d0 d0Var) {
        this.f7734a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        this.f7734a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", "HID 广播" + num);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "++++++", "data is null ?" + (num == null) + " " + num);
        if (num != null && num.intValue() == 1) {
            Object obj2 = u1.f7811u;
            com.google.android.gms.internal.mlkit_vision_barcode.q1.a().c();
        } else {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "++++++", "进入解绑");
            Object obj3 = u1.f7811u;
            com.google.android.gms.internal.mlkit_vision_barcode.q1.a().h();
        }
    }
}
