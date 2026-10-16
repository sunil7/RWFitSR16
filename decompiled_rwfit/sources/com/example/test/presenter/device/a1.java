package com.example.test.presenter.device;

import com.example.baselibrary.base.activity.BaseActivity;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.QrCodeDetailActivity;

/* loaded from: classes.dex */
public final class a1 implements w5.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f7409a;

    public a1(b1 b1Var) {
        this.f7409a = b1Var;
    }

    @Override // w5.c
    public final void a(int i3) {
        b1 b1Var = this.f7409a;
        ((XXBaseActivity) ((f7.v) b1Var.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, b1Var.f7412b, com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "保存二维码失败 "));
        b1Var.k(i3);
    }

    @Override // w5.c
    public final void c() {
        b1 b1Var = this.f7409a;
        ((XXBaseActivity) ((f7.v) b1Var.f7255a)).b0();
        ((BaseActivity) ((f7.v) b1Var.f7255a)).getClass();
        com.example.baselibrary.utils.d.b("保存二维码成功");
        ((QrCodeDetailActivity) ((f7.v) b1Var.f7255a)).onBackPressed();
    }
}
