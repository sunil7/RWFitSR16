package com.example.test.presenter.mine;

import com.google.android.gms.internal.mlkit_vision_barcode.u1;

/* loaded from: classes.dex */
public final class a extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.mine.AboutPresenter$getAppVersion$1
            {
                super(1);
            }

            @Override // oh.l
            public final com.example.test.utils.a invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return u1.a(((h7.a) a.this.f7255a).f0());
            }
        }, new oh.l() { // from class: com.example.test.presenter.mine.AboutPresenter$getAppVersion$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((com.example.test.utils.a) obj);
                return eh.g.f12633a;
            }

            public final void invoke(com.example.test.utils.a aVar) {
                if (aVar != null) {
                    ((h7.a) a.this.f7255a).M(aVar);
                }
            }
        });
    }
}
