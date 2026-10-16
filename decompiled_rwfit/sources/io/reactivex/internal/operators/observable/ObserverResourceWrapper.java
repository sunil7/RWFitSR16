package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<ug.b> implements rg.s, ug.b {
    private static final long serialVersionUID = -8612022020200669122L;
    final rg.s actual;
    final AtomicReference<ug.b> subscription = new AtomicReference<>();

    public ObserverResourceWrapper(rg.s sVar) {
        this.actual = sVar;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this.subscription);
        DisposableHelper.dispose(this);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.subscription.get() == DisposableHelper.DISPOSED;
    }

    @Override // rg.s
    public void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        dispose();
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.actual.onNext(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.setOnce(this.subscription, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    public void setResource(ug.b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
