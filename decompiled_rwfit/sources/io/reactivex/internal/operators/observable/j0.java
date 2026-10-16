package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class j0 extends rg.y implements yg.a {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14700a;

    public j0(rg.l lVar) {
        this.f14700a = lVar;
    }

    @Override // yg.a
    public final rg.l a() {
        return new a3(this.f14700a, 1);
    }

    @Override // rg.y
    public final void c(rg.z zVar) {
        this.f14700a.subscribe(new i0(zVar, 2));
    }
}
