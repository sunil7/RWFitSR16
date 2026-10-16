package com.example.test.presenter.main;

import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
final class BSStatisticsPresenter$saveDB$1$2 extends Lambda implements oh.l {
    final /* synthetic */ g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BSStatisticsPresenter$saveDB$1$2(g gVar) {
        super(1);
        this.this$0 = gVar;
    }

    @Override // oh.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return eh.g.f12633a;
    }

    public final void invoke(long j4) {
        ((g7.d) this.this$0.f7255a).b0();
        if (j4 > 0) {
            ((g7.d) this.this$0.f7255a).a();
        } else {
            ((g7.d) this.this$0.f7255a).b();
        }
    }
}
