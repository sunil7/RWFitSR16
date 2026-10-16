package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class t1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14898a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14899b;

    public t1(rg.l lVar, int i3) {
        this.f14898a = lVar;
        this.f14899b = i3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f14898a.replay(this.f14899b);
    }
}
