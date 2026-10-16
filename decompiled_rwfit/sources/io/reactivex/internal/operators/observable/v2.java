package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class v2 extends rg.g {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14945a;

    /* renamed from: b, reason: collision with root package name */
    public final vg.c f14946b;

    public v2(rg.l lVar, vg.c cVar) {
        this.f14945a = lVar;
        this.f14946b = cVar;
    }

    @Override // rg.g
    public final void c(rg.h hVar) {
        this.f14945a.subscribe(new c0(hVar, this.f14946b));
    }
}
