package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class y0 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final long f15017b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f15018c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f15019d;

    public y0(rg.l lVar, long j4, Object obj, boolean z5) {
        super(lVar);
        this.f15017b = j4;
        this.f15018c = obj;
        this.f15019d = z5;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        this.f14546a.subscribe(new x0(sVar, this.f15017b, this.f15018c, this.f15019d));
    }
}
