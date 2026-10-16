package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class y1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f15020a;

    public y1(rg.l lVar) {
        this.f15020a = lVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f15020a.replay();
    }
}
