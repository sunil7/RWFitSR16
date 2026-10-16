package com.example.test.presenter.device;

import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
final class AlarmJLPresenter$saveDB$3 extends Lambda implements oh.l {
    final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlarmJLPresenter$saveDB$3(b bVar) {
        super(1);
        this.this$0 = bVar;
    }

    @Override // oh.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return eh.g.f12633a;
    }

    public final void invoke(long j4) {
        if (j4 > 0) {
            ((f7.a) this.this$0.f7255a).a();
        } else {
            ((f7.a) this.this$0.f7255a).b();
        }
    }
}
