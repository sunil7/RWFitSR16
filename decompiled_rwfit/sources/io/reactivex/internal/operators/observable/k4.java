package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class k4 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final long f14723b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14724c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14725d;

    public k4(rg.l lVar, long j4, long j10, int i3) {
        super(lVar);
        this.f14723b = j4;
        this.f14724c = j10;
        this.f14725d = i3;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        long j4 = this.f14723b;
        long j10 = this.f14724c;
        rg.q qVar = this.f14546a;
        if (j4 == j10) {
            qVar.subscribe(new ObservableWindow$WindowExactObserver(sVar, j4, this.f14725d));
        } else {
            qVar.subscribe(new ObservableWindow$WindowSkipObserver(sVar, this.f14723b, this.f14724c, this.f14725d));
        }
    }
}
