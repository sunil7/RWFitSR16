package com.example.test.ui.device.activity;

import com.example.test.presenter.device.s0;
import com.example.test.presenter.device.t0;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final class t implements a7.e, t6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MoreActivity f7889a;

    public /* synthetic */ t(MoreActivity moreActivity) {
        this.f7889a = moreActivity;
    }

    @Override // a7.e
    public void B() {
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        int i3 = MoreActivity.H;
        t0 t0Var = (t0) this.f7889a.I0();
        t0Var.f7484c = 1;
        ((XXBaseActivity) ((f7.r) t0Var.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.U((s0) t0Var.f7483b.getValue());
        if (y5.d.f20005b) {
            com.google.android.gms.internal.mlkit_vision_common.p.y(1);
        } else {
            com.google.android.gms.internal.mlkit_vision_common.p.b(1);
        }
    }

    @Override // a7.e
    public void u0() {
        this.f7889a.onBackPressed();
    }
}
