package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class a2 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14559a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14560b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f14561c;

    /* renamed from: d, reason: collision with root package name */
    public final rg.x f14562d;

    public a2(rg.l lVar, long j4, TimeUnit timeUnit, rg.x xVar) {
        this.f14559a = lVar;
        this.f14560b = j4;
        this.f14561c = timeUnit;
        this.f14562d = xVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f14559a.replay(this.f14560b, this.f14561c, this.f14562d);
    }
}
