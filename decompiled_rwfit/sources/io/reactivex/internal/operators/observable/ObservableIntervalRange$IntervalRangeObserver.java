package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableIntervalRange$IntervalRangeObserver extends AtomicReference<ug.b> implements ug.b, Runnable {
    private static final long serialVersionUID = 1891866368734007884L;
    final rg.s actual;
    long count;
    final long end;

    public ObservableIntervalRange$IntervalRangeObserver(rg.s sVar, long j4, long j10) {
        this.actual = sVar;
        this.count = j4;
        this.end = j10;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isDisposed()) {
            return;
        }
        long j4 = this.count;
        this.actual.onNext(Long.valueOf(j4));
        if (j4 != this.end) {
            this.count = j4 + 1;
        } else {
            DisposableHelper.dispose(this);
            this.actual.onComplete();
        }
    }

    public void setResource(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
