package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class d2 extends rg.l implements yg.d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f14611a;

    public d2(Object obj) {
        this.f14611a = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f14611a;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        ObservableScalarXMap$ScalarDisposable observableScalarXMap$ScalarDisposable = new ObservableScalarXMap$ScalarDisposable(sVar, this.f14611a);
        sVar.onSubscribe(observableScalarXMap$ScalarDisposable);
        observableScalarXMap$ScalarDisposable.run();
    }
}
