package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableDebounceTimed$DebounceEmitter<T> extends AtomicReference<ug.b> implements Runnable, ug.b {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once = new AtomicBoolean();
    final n0 parent;
    final T value;

    public ObservableDebounceTimed$DebounceEmitter(T t8, long j4, n0 n0Var) {
        this.value = t8;
        this.idx = j4;
        this.parent = n0Var;
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
        if (this.once.compareAndSet(false, true)) {
            n0 n0Var = this.parent;
            long j4 = this.idx;
            T t8 = this.value;
            if (j4 == n0Var.f14770g) {
                n0Var.f14765a.onNext(t8);
                dispose();
            }
        }
    }

    public void setResource(ug.b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
