package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableInterval$IntervalObserver extends AtomicReference<ug.b> implements ug.b, Runnable {
    private static final long serialVersionUID = 346773832286157679L;
    final rg.s actual;
    long count;

    public ObservableInterval$IntervalObserver(rg.s sVar) {
        this.actual = sVar;
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
        if (get() != DisposableHelper.DISPOSED) {
            rg.s sVar = this.actual;
            long j4 = this.count;
            this.count = 1 + j4;
            sVar.onNext(Long.valueOf(j4));
        }
    }

    public void setResource(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
