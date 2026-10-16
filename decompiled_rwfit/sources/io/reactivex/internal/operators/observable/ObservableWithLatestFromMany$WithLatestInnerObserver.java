package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableWithLatestFromMany$WithLatestInnerObserver extends AtomicReference<ug.b> implements rg.s {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final ObservableWithLatestFromMany$WithLatestFromObserver<?, ?> parent;

    public ObservableWithLatestFromMany$WithLatestInnerObserver(ObservableWithLatestFromMany$WithLatestFromObserver<?, ?> observableWithLatestFromMany$WithLatestFromObserver, int i3) {
        this.parent = observableWithLatestFromMany$WithLatestFromObserver;
        this.index = i3;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // rg.s
    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.parent.innerError(this.index, th2);
    }

    @Override // rg.s
    public void onNext(Object obj) {
        if (!this.hasValue) {
            this.hasValue = true;
        }
        this.parent.innerNext(this.index, obj);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
