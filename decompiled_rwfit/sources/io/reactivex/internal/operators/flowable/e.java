package io.reactivex.internal.operators.flowable;

import vg.g;

/* loaded from: classes2.dex */
public final class e extends a implements g {

    /* renamed from: c, reason: collision with root package name */
    public final e f14484c;

    public e(c cVar) {
        super(cVar);
        this.f14484c = this;
    }

    @Override // rg.e
    public final void b(rg.f fVar) {
        this.f14478b.a(new FlowableOnBackpressureDrop$BackpressureDropSubscriber(fVar, this.f14484c));
    }

    @Override // vg.g
    public final void f(Object obj) {
    }
}
