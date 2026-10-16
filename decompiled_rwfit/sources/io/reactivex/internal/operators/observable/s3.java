package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class s3 extends rg.y implements yg.a {

    /* renamed from: a, reason: collision with root package name */
    public final rg.q f14874a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.q f14875b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.d f14876c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14877d;

    public s3(rg.q qVar, rg.q qVar2, vg.d dVar, int i3) {
        this.f14874a = qVar;
        this.f14875b = qVar2;
        this.f14876c = dVar;
        this.f14877d = i3;
    }

    @Override // yg.a
    public final rg.l a() {
        return new q3(this.f14874a, this.f14875b, this.f14876c, this.f14877d);
    }

    @Override // rg.y
    public final void c(rg.z zVar) {
        ObservableSequenceEqualSingle$EqualCoordinator observableSequenceEqualSingle$EqualCoordinator = new ObservableSequenceEqualSingle$EqualCoordinator(zVar, this.f14877d, this.f14874a, this.f14875b, this.f14876c);
        zVar.onSubscribe(observableSequenceEqualSingle$EqualCoordinator);
        observableSequenceEqualSingle$EqualCoordinator.subscribe();
    }
}
