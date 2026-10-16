package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes2.dex */
public final class k3 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final vg.p f14721b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14722c;

    public k3(rg.l lVar, long j4, vg.p pVar) {
        super(lVar);
        this.f14721b = pVar;
        this.f14722c = j4;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        sVar.onSubscribe(sequentialDisposable);
        new ObservableRetryPredicate$RepeatObserver(sVar, this.f14722c, this.f14721b, sequentialDisposable, this.f14546a).subscribeNext();
    }
}
