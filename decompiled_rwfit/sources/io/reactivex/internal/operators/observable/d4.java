package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class d4 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14614a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeUnit f14615b;

    /* renamed from: c, reason: collision with root package name */
    public long f14616c;

    /* renamed from: d, reason: collision with root package name */
    public ug.b f14617d;

    public d4(rg.s sVar, TimeUnit timeUnit, rg.x xVar) {
        this.f14614a = sVar;
        this.f14615b = timeUnit;
    }

    @Override // ug.b
    public final void dispose() {
        this.f14617d.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14617d.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        this.f14614a.onComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f14614a.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        TimeUnit timeUnit = this.f14615b;
        long b3 = rg.x.b(timeUnit);
        long j4 = this.f14616c;
        this.f14616c = b3;
        this.f14614a.onNext(new ch.g(obj, b3 - j4, timeUnit));
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14617d, bVar)) {
            this.f14617d = bVar;
            this.f14616c = rg.x.b(this.f14615b);
            this.f14614a.onSubscribe(this);
        }
    }
}
