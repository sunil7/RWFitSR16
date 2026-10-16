package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class d0 extends rg.y implements yg.a {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14607a;

    /* renamed from: b, reason: collision with root package name */
    public final Callable f14608b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.b f14609c;

    public d0(rg.l lVar, Callable callable, vg.b bVar) {
        this.f14607a = lVar;
        this.f14608b = callable;
        this.f14609c = bVar;
    }

    @Override // yg.a
    public final rg.l a() {
        return new b0(this.f14607a, this.f14608b, this.f14609c, 4);
    }

    @Override // rg.y
    public final void c(rg.z zVar) {
        try {
            Object call = this.f14608b.call();
            xg.c.b(call, "The initialSupplier returned a null value");
            this.f14607a.subscribe(new c0(zVar, call, this.f14609c, 1));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, zVar);
        }
    }
}
