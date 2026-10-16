package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableConcatWithCompletable$ConcatWithObserver<T> extends AtomicReference<ug.b> implements rg.s, rg.b, ug.b {
    private static final long serialVersionUID = -1953724749712440952L;
    final rg.s actual;
    boolean inCompletable;
    rg.c other;

    public ObservableConcatWithCompletable$ConcatWithObserver(rg.s sVar, rg.c cVar) {
        this.actual = sVar;
        this.other = cVar;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // rg.s
    public void onComplete() {
        if (this.inCompletable) {
            this.actual.onComplete();
            return;
        }
        this.inCompletable = true;
        DisposableHelper.replace(this, null);
        rg.c cVar = this.other;
        this.other = null;
        ((rg.a) cVar).b(this);
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.actual.onNext(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (!DisposableHelper.setOnce(this, bVar) || this.inCompletable) {
            return;
        }
        this.actual.onSubscribe(this);
    }
}
