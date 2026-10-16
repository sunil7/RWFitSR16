package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableRetryBiPredicate$RetryBiObserver<T> extends AtomicInteger implements rg.s {
    private static final long serialVersionUID = -7098360935104053232L;
    final rg.s actual;
    final vg.d predicate;
    int retries;
    final SequentialDisposable sa;
    final rg.q source;

    public ObservableRetryBiPredicate$RetryBiObserver(rg.s sVar, vg.d dVar, SequentialDisposable sequentialDisposable, rg.q qVar) {
        this.actual = sVar;
        this.sa = sequentialDisposable;
        this.source = qVar;
        this.predicate = dVar;
    }

    @Override // rg.s
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        try {
            vg.d dVar = this.predicate;
            int i3 = this.retries + 1;
            this.retries = i3;
            Integer valueOf = Integer.valueOf(i3);
            ((ec.a) dVar).getClass();
            if (xg.c.a(valueOf, th2)) {
                subscribeNext();
            } else {
                this.actual.onError(th2);
            }
        } catch (Throwable th3) {
            ad.a(th3);
            this.actual.onError(new CompositeException(th2, th3));
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.actual.onNext(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        this.sa.update(bVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i3 = 1;
            while (!this.sa.isDisposed()) {
                this.source.subscribe(this);
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
    }
}
