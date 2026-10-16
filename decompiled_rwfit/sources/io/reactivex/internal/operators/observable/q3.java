package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class q3 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final rg.q f14841a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.q f14842b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.d f14843c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14844d;

    public q3(rg.q qVar, rg.q qVar2, vg.d dVar, int i3) {
        this.f14841a = qVar;
        this.f14842b = qVar2;
        this.f14843c = dVar;
        this.f14844d = i3;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        rg.q qVar = this.f14842b;
        vg.d dVar = this.f14843c;
        ObservableSequenceEqual$EqualCoordinator observableSequenceEqual$EqualCoordinator = new ObservableSequenceEqual$EqualCoordinator(sVar, this.f14844d, this.f14841a, qVar, dVar);
        sVar.onSubscribe(observableSequenceEqual$EqualCoordinator);
        observableSequenceEqual$EqualCoordinator.subscribe();
    }
}
