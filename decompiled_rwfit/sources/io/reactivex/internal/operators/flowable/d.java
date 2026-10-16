package io.reactivex.internal.operators.flowable;

/* loaded from: classes2.dex */
public final class d extends a {

    /* renamed from: c, reason: collision with root package name */
    public final int f14482c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14483d;
    public final ec.a e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i3) {
        super(cVar);
        ec.a aVar = io.reactivex.internal.functions.a.f14444c;
        this.f14482c = i3;
        this.f14483d = true;
        this.e = aVar;
    }

    @Override // rg.e
    public final void b(rg.f fVar) {
        this.f14478b.a(new FlowableOnBackpressureBuffer$BackpressureBufferSubscriber(fVar, this.f14482c, this.f14483d, false, this.e));
    }
}
