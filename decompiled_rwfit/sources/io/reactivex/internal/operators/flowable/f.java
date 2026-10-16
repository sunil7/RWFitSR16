package io.reactivex.internal.operators.flowable;

/* loaded from: classes2.dex */
public final class f extends a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14485c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(c cVar, int i3) {
        super(cVar);
        this.f14485c = i3;
    }

    @Override // rg.e
    public final void b(rg.f fVar) {
        switch (this.f14485c) {
            case 0:
                this.f14478b.a(new FlowableOnBackpressureError$BackpressureErrorSubscriber(fVar));
                break;
            default:
                this.f14478b.a(new FlowableOnBackpressureLatest$BackpressureLatestSubscriber(fVar));
                break;
        }
    }
}
