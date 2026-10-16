package io.reactivex.internal.operators.flowable;

import rg.l;

/* loaded from: classes2.dex */
public final class c extends rg.e {

    /* renamed from: b, reason: collision with root package name */
    public final l f14481b;

    public c(l lVar) {
        this.f14481b = lVar;
    }

    @Override // rg.e
    public final void b(rg.f fVar) {
        this.f14481b.subscribe(new b(fVar));
    }
}
