package com.example.test.utils;

/* loaded from: classes.dex */
public final class r implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f8749a;

    public r(s sVar) {
        this.f8749a = sVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "设置位置失败："));
        this.f8749a.c();
    }

    @Override // u5.g
    public final void c() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "设置位置成功，刷新位置时间");
        this.f8749a.c();
    }

    @Override // u5.g
    public final void e(Object obj) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "设置位置成功，刷新位置时间 onResult");
    }
}
