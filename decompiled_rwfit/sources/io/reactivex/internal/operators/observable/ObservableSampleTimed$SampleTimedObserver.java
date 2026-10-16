package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
abstract class ObservableSampleTimed$SampleTimedObserver<T> extends AtomicReference<T> implements rg.s, ug.b, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final rg.s actual;
    final long period;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14526s;
    final rg.x scheduler;
    final AtomicReference<ug.b> timer = new AtomicReference<>();
    final TimeUnit unit;

    public ObservableSampleTimed$SampleTimedObserver(rg.s sVar, long j4, TimeUnit timeUnit, rg.x xVar) {
        this.actual = sVar;
        this.period = j4;
        this.unit = timeUnit;
        this.scheduler = xVar;
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    @Override // ug.b
    public void dispose() {
        cancelTimer();
        this.f14526s.dispose();
    }

    public void emit() {
        T andSet = getAndSet(null);
        if (andSet != null) {
            this.actual.onNext(andSet);
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.f14526s.isDisposed();
    }

    @Override // rg.s
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        cancelTimer();
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        lazySet(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14526s, bVar)) {
            this.f14526s = bVar;
            this.actual.onSubscribe(this);
            rg.x xVar = this.scheduler;
            long j4 = this.period;
            DisposableHelper.replace(this.timer, xVar.e(this, j4, j4, this.unit));
        }
    }
}
