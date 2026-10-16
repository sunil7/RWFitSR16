package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class d3 extends zg.a {

    /* renamed from: a, reason: collision with root package name */
    public final zg.a f14612a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.l f14613b;

    public d3(zg.a aVar, rg.l lVar) {
        this.f14612a = aVar;
        this.f14613b = lVar;
    }

    @Override // zg.a
    public final void c(vg.g gVar) {
        this.f14612a.c(gVar);
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        this.f14613b.subscribe(sVar);
    }
}
