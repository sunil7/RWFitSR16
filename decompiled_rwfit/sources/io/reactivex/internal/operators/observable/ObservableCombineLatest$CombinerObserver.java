package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableCombineLatest$CombinerObserver<T, R> extends AtomicReference<ug.b> implements rg.s {
    private static final long serialVersionUID = -4823716997131257941L;
    final int index;
    final ObservableCombineLatest$LatestCoordinator<T, R> parent;

    public ObservableCombineLatest$CombinerObserver(ObservableCombineLatest$LatestCoordinator<T, R> observableCombineLatest$LatestCoordinator, int i3) {
        this.parent = observableCombineLatest$LatestCoordinator;
        this.index = i3;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // rg.s
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.parent.innerError(this.index, th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.parent.innerNext(this.index, t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
