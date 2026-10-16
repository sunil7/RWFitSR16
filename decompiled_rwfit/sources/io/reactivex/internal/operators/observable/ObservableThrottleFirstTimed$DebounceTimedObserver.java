package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableThrottleFirstTimed$DebounceTimedObserver<T> extends AtomicReference<ug.b> implements rg.s, ug.b, Runnable {
    private static final long serialVersionUID = 786994795061867455L;
    final rg.s actual;
    boolean done;
    volatile boolean gate;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14539s;
    final long timeout;
    final TimeUnit unit;
    final rg.w worker;

    public ObservableThrottleFirstTimed$DebounceTimedObserver(rg.s sVar, long j4, TimeUnit timeUnit, rg.w wVar) {
        this.actual = sVar;
        this.timeout = j4;
        this.unit = timeUnit;
        this.worker = wVar;
    }

    @Override // ug.b
    public void dispose() {
        this.f14539s.dispose();
        this.worker.dispose();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.worker.isDisposed();
    }

    @Override // rg.s
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.actual.onComplete();
        this.worker.dispose();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.done) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.done = true;
        this.actual.onError(th2);
        this.worker.dispose();
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.gate || this.done) {
            return;
        }
        this.gate = true;
        this.actual.onNext(t8);
        ug.b bVar = get();
        if (bVar != null) {
            bVar.dispose();
        }
        DisposableHelper.replace(this, this.worker.a(this, this.timeout, this.unit));
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14539s, bVar)) {
            this.f14539s = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gate = false;
    }
}
