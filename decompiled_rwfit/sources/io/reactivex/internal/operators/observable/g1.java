package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class g1 extends rg.a implements yg.a {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14648a;

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14649b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14650c;

    public g1(rg.l lVar, vg.o oVar, boolean z5) {
        this.f14648a = lVar;
        this.f14649b = oVar;
        this.f14650c = z5;
    }

    @Override // yg.a
    public final rg.l a() {
        return new f1(this.f14648a, this.f14649b, this.f14650c, 0);
    }

    @Override // rg.a
    public final void c(rg.b bVar) {
        this.f14648a.subscribe(new ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver(bVar, this.f14649b, this.f14650c));
    }
}
