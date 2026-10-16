package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
abstract class ObservableSampleWithObservable$SampleMainObserver<T> extends AtomicReference<T> implements rg.s, ug.b {
    private static final long serialVersionUID = -3517602651313910099L;
    final rg.s actual;
    final AtomicReference<ug.b> other = new AtomicReference<>();

    /* renamed from: s, reason: collision with root package name */
    ug.b f14527s;
    final rg.q sampler;

    public ObservableSampleWithObservable$SampleMainObserver(rg.s sVar, rg.q qVar) {
        this.actual = sVar;
        this.sampler = qVar;
    }

    public void complete() {
        this.f14527s.dispose();
        completeOther();
    }

    public abstract void completeMain();

    public abstract void completeOther();

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this.other);
        this.f14527s.dispose();
    }

    public void emit() {
        T andSet = getAndSet(null);
        if (andSet != null) {
            this.actual.onNext(andSet);
        }
    }

    public void error(Throwable th2) {
        this.f14527s.dispose();
        this.actual.onError(th2);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.other.get() == DisposableHelper.DISPOSED;
    }

    @Override // rg.s
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        completeMain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.other);
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        lazySet(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14527s, bVar)) {
            this.f14527s = bVar;
            this.actual.onSubscribe(this);
            if (this.other.get() == null) {
                this.sampler.subscribe(new n3(this, 0));
            }
        }
    }

    public abstract void run();

    public boolean setOther(ug.b bVar) {
        return DisposableHelper.setOnce(this.other, bVar);
    }
}
