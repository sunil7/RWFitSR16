package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class p1 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14821b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.o f14822c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14823d;
    public final boolean e;

    public p1(rg.l lVar, vg.o oVar, vg.o oVar2, int i3, boolean z5) {
        super(lVar);
        this.f14821b = oVar;
        this.f14822c = oVar2;
        this.f14823d = i3;
        this.e = z5;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        this.f14546a.subscribe(new ObservableGroupBy$GroupByObserver(sVar, this.f14821b, this.f14822c, this.f14823d, this.e));
    }
}
