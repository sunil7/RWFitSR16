package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class k2 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final rg.a0 f14720b;

    public k2(rg.l lVar, rg.a0 a0Var) {
        super(lVar);
        this.f14720b = a0Var;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        ObservableMergeWithSingle$MergeWithObserver observableMergeWithSingle$MergeWithObserver = new ObservableMergeWithSingle$MergeWithObserver(sVar);
        sVar.onSubscribe(observableMergeWithSingle$MergeWithObserver);
        this.f14546a.subscribe(observableMergeWithSingle$MergeWithObserver);
        ((rg.y) this.f14720b).b(observableMergeWithSingle$MergeWithObserver.otherObserver);
    }
}
