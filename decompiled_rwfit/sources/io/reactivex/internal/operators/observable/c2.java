package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class c2 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final rg.x f14597a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14598b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14599c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14600d;
    public final long e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeUnit f14601f;

    public c2(long j4, long j10, long j11, long j12, TimeUnit timeUnit, rg.x xVar) {
        this.f14600d = j11;
        this.e = j12;
        this.f14601f = timeUnit;
        this.f14597a = xVar;
        this.f14598b = j4;
        this.f14599c = j10;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        ObservableIntervalRange$IntervalRangeObserver observableIntervalRange$IntervalRangeObserver = new ObservableIntervalRange$IntervalRangeObserver(sVar, this.f14598b, this.f14599c);
        sVar.onSubscribe(observableIntervalRange$IntervalRangeObserver);
        rg.x xVar = this.f14597a;
        boolean z5 = xVar instanceof io.reactivex.internal.schedulers.r;
        TimeUnit timeUnit = this.f14601f;
        if (!z5) {
            observableIntervalRange$IntervalRangeObserver.setResource(xVar.e(observableIntervalRange$IntervalRangeObserver, this.f14600d, this.e, timeUnit));
            return;
        }
        io.reactivex.internal.schedulers.q qVar = new io.reactivex.internal.schedulers.q();
        observableIntervalRange$IntervalRangeObserver.setResource(qVar);
        qVar.c(observableIntervalRange$IntervalRangeObserver, this.f14600d, this.e, timeUnit);
    }
}
