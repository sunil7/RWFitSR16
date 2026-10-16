package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class a1 extends rg.g implements yg.a {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14557a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14558b;

    public a1(rg.l lVar, long j4) {
        this.f14557a = lVar;
        this.f14558b = j4;
    }

    @Override // yg.a
    public final rg.l a() {
        return new y0(this.f14557a, this.f14558b, null, false);
    }

    @Override // rg.g
    public final void c(rg.h hVar) {
        this.f14557a.subscribe(new z0(hVar, this.f14558b));
    }
}
