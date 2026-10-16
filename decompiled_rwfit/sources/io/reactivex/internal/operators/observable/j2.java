package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class j2 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final rg.i f14702b;

    public j2(rg.l lVar, rg.i iVar) {
        super(lVar);
        this.f14702b = iVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        ObservableMergeWithMaybe$MergeWithObserver observableMergeWithMaybe$MergeWithObserver = new ObservableMergeWithMaybe$MergeWithObserver(sVar);
        sVar.onSubscribe(observableMergeWithMaybe$MergeWithObserver);
        this.f14546a.subscribe(observableMergeWithMaybe$MergeWithObserver);
        ((rg.g) this.f14702b).b(observableMergeWithMaybe$MergeWithObserver.otherObserver);
    }
}
