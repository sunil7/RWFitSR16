package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class q extends a {

    /* renamed from: b, reason: collision with root package name */
    public final int f14831b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14832c;

    /* renamed from: d, reason: collision with root package name */
    public final Callable f14833d;

    public q(rg.l lVar, int i3, int i10, Callable callable) {
        super(lVar);
        this.f14831b = i3;
        this.f14832c = i10;
        this.f14833d = callable;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        Callable callable = this.f14833d;
        rg.q qVar = this.f14546a;
        int i3 = this.f14832c;
        int i10 = this.f14831b;
        if (i3 != i10) {
            qVar.subscribe(new ObservableBuffer$BufferSkipObserver(sVar, i10, i3, callable));
            return;
        }
        p pVar = new p(sVar, i10, callable);
        if (pVar.a()) {
            qVar.subscribe(pVar);
        }
    }
}
