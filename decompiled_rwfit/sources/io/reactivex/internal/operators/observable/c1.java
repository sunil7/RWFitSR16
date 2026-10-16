package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class c1 extends rg.y implements yg.a {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14594a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14595b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14596c;

    public c1(rg.l lVar, long j4, Object obj) {
        this.f14594a = lVar;
        this.f14595b = j4;
        this.f14596c = obj;
    }

    @Override // yg.a
    public final rg.l a() {
        return new y0(this.f14594a, this.f14595b, this.f14596c, true);
    }

    @Override // rg.y
    public final void c(rg.z zVar) {
        this.f14594a.subscribe(new b1(zVar, this.f14595b, this.f14596c));
    }
}
