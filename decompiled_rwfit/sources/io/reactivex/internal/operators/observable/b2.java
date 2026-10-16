package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class b2 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final rg.x f14579a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14580b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14581c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeUnit f14582d;

    public b2(long j4, long j10, TimeUnit timeUnit, rg.x xVar) {
        this.f14580b = j4;
        this.f14581c = j10;
        this.f14582d = timeUnit;
        this.f14579a = xVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        ObservableInterval$IntervalObserver observableInterval$IntervalObserver = new ObservableInterval$IntervalObserver(sVar);
        sVar.onSubscribe(observableInterval$IntervalObserver);
        rg.x xVar = this.f14579a;
        boolean z5 = xVar instanceof io.reactivex.internal.schedulers.r;
        TimeUnit timeUnit = this.f14582d;
        if (!z5) {
            observableInterval$IntervalObserver.setResource(xVar.e(observableInterval$IntervalObserver, this.f14580b, this.f14581c, timeUnit));
            return;
        }
        io.reactivex.internal.schedulers.q qVar = new io.reactivex.internal.schedulers.q();
        observableInterval$IntervalObserver.setResource(qVar);
        qVar.c(observableInterval$IntervalObserver, this.f14580b, this.f14581c, timeUnit);
    }
}
