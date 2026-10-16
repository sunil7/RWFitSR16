package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class g4 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final long f14656b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f14657c;

    /* renamed from: d, reason: collision with root package name */
    public final rg.x f14658d;
    public final rg.q e;

    public g4(rg.l lVar, long j4, TimeUnit timeUnit, rg.x xVar, rg.q qVar) {
        super(lVar);
        this.f14656b = j4;
        this.f14657c = timeUnit;
        this.f14658d = xVar;
        this.e = qVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        rg.q qVar = this.e;
        rg.q qVar2 = this.f14546a;
        rg.x xVar = this.f14658d;
        if (qVar == null) {
            ObservableTimeoutTimed$TimeoutObserver observableTimeoutTimed$TimeoutObserver = new ObservableTimeoutTimed$TimeoutObserver(sVar, this.f14656b, this.f14657c, xVar.a());
            sVar.onSubscribe(observableTimeoutTimed$TimeoutObserver);
            observableTimeoutTimed$TimeoutObserver.startTimeout(0L);
            qVar2.subscribe(observableTimeoutTimed$TimeoutObserver);
            return;
        }
        ObservableTimeoutTimed$TimeoutFallbackObserver observableTimeoutTimed$TimeoutFallbackObserver = new ObservableTimeoutTimed$TimeoutFallbackObserver(sVar, this.f14656b, this.f14657c, xVar.a(), this.e);
        sVar.onSubscribe(observableTimeoutTimed$TimeoutFallbackObserver);
        observableTimeoutTimed$TimeoutFallbackObserver.startTimeout(0L);
        qVar2.subscribe(observableTimeoutTimed$TimeoutFallbackObserver);
    }
}
