package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class o1 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final Object f14791a;

    /* renamed from: b, reason: collision with root package name */
    public final ObservableGroupBy$State f14792b;

    public o1(Object obj, ObservableGroupBy$State observableGroupBy$State) {
        this.f14791a = obj;
        this.f14792b = observableGroupBy$State;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        this.f14792b.subscribe(sVar);
    }
}
