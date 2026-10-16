package com.example.test.presenter.device;

import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.MoreActivity;

/* loaded from: classes.dex */
public final class t0 extends d {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7483b;

    /* renamed from: c, reason: collision with root package name */
    public int f7484c;

    public t0(MoreActivity moreActivity) {
        super(moreActivity);
        this.f7483b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.MorePresenter$deviceControlCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final s0 invoke() {
                return new s0(t0.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void l() {
        this.f7484c = 2;
        ((XXBaseActivity) ((f7.r) this.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.U((s0) this.f7483b.getValue());
        if (y5.d.f20005b) {
            com.google.android.gms.internal.mlkit_vision_common.p.y(2);
        } else {
            com.google.android.gms.internal.mlkit_vision_common.p.b(2);
        }
    }
}
