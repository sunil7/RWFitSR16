package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableTimer$TimerObserver extends AtomicReference<ug.b> implements ug.b, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    final rg.s actual;

    public ObservableTimer$TimerObserver(rg.s sVar) {
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
        if (isDisposed()) {
            return;
        }
        this.actual.onNext(0L);
        lazySet(EmptyDisposable.INSTANCE);
        this.actual.onComplete();
    }

    public void setResource(ug.b bVar) {
        DisposableHelper.trySet(this, bVar);
    }
}
