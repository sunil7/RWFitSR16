package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.ErrorMode;

/* loaded from: classes2.dex */
public final class g0 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14645b;

    /* renamed from: c, reason: collision with root package name */
    public final ErrorMode f14646c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14647d;
    public final int e;

    public g0(rg.l lVar, vg.o oVar, ErrorMode errorMode, int i3, int i10) {
        super(lVar);
        this.f14645b = oVar;
        this.f14646c = errorMode;
        this.f14647d = i3;
        this.e = i10;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        this.f14546a.subscribe(new ObservableConcatMapEager$ConcatMapEagerMainObserver(sVar, this.f14645b, this.f14647d, this.e, this.f14646c));
    }
}
