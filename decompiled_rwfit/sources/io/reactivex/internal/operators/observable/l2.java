package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class l2 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public static final l2 f14736a = new l2();

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        sVar.onSubscribe(EmptyDisposable.NEVER);
    }
}
