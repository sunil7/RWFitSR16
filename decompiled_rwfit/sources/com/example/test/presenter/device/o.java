package com.example.test.presenter.device;

import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final class o implements u5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f7466a;

    public o(p pVar) {
        this.f7466a = pVar;
    }

    @Override // u5.i
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ContactPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "errorCode "));
        p pVar = this.f7466a;
        ((XXBaseActivity) ((f7.d) pVar.f7255a)).b0();
        pVar.k(i3);
    }

    @Override // u5.i
    public final void b(float f2) {
    }

    @Override // u5.i
    public final void onFinish() {
        p pVar = this.f7466a;
        pVar.m();
        ((XXBaseActivity) ((f7.d) pVar.f7255a)).b0();
    }
}
