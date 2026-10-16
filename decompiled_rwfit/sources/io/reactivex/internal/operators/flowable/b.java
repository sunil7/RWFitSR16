package io.reactivex.internal.operators.flowable;

import rg.s;

/* loaded from: classes2.dex */
public final class b implements s, ci.c {

    /* renamed from: a, reason: collision with root package name */
    public final rg.f f14479a;

    /* renamed from: b, reason: collision with root package name */
    public ug.b f14480b;

    public b(rg.f fVar) {
        this.f14479a = fVar;
    }

    @Override // ci.c
    public final void cancel() {
        this.f14480b.dispose();
    }

    @Override // rg.s
    public final void onComplete() {
        this.f14479a.onComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f14479a.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        this.f14479a.onNext(obj);
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        this.f14480b = bVar;
        this.f14479a.onSubscribe(this);
    }

    @Override // ci.c
    public final void request(long j4) {
    }
}
