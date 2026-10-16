package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableReplay$InnerDisposable<T> extends AtomicInteger implements ug.b {
    private static final long serialVersionUID = 2728361546769921047L;
    volatile boolean cancelled;
    final rg.s child;
    Object index;
    final ObservableReplay$ReplayObserver<T> parent;

    public ObservableReplay$InnerDisposable(ObservableReplay$ReplayObserver<T> observableReplay$ReplayObserver, rg.s sVar) {
        this.parent = observableReplay$ReplayObserver;
        this.child = sVar;
    }

    @Override // ug.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.parent.remove(this);
    }

    public <U> U index() {
        return (U) this.index;
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }
}
