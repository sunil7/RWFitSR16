package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class i2 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final rg.c f14693b;

    public i2(rg.l lVar, rg.c cVar) {
        super(lVar);
        this.f14693b = cVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        ObservableMergeWithCompletable$MergeWithObserver observableMergeWithCompletable$MergeWithObserver = new ObservableMergeWithCompletable$MergeWithObserver(sVar);
        sVar.onSubscribe(observableMergeWithCompletable$MergeWithObserver);
        this.f14546a.subscribe(observableMergeWithCompletable$MergeWithObserver);
        ((rg.a) this.f14693b).b(observableMergeWithCompletable$MergeWithObserver.otherObserver);
    }
}
