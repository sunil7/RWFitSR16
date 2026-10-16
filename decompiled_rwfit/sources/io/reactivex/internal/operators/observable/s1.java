package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class s1 extends rg.a implements yg.a {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14871a;

    public s1(rg.l lVar) {
        this.f14871a = lVar;
    }

    @Override // yg.a
    public final rg.l a() {
        return new a3(this.f14871a, 5);
    }

    @Override // rg.a
    public final void c(rg.b bVar) {
        this.f14871a.subscribe(new s0(bVar, 4));
    }
}
