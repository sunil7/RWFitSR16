package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class u1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14918a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14919b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14920c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeUnit f14921d;
    public final rg.x e;

    public u1(int i3, long j4, TimeUnit timeUnit, rg.l lVar, rg.x xVar) {
        this.f14918a = lVar;
        this.f14919b = i3;
        this.f14920c = j4;
        this.f14921d = timeUnit;
        this.e = xVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f14918a.replay(this.f14919b, this.f14920c, this.f14921d, this.e);
    }
}
