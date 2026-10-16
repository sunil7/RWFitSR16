package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class d1 extends rg.l implements yg.d {

    /* renamed from: a, reason: collision with root package name */
    public static final d1 f14610a = new d1();

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return null;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        EmptyDisposable.complete(sVar);
    }
}
