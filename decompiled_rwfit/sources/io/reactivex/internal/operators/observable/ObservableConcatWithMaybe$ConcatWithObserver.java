package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableConcatWithMaybe$ConcatWithObserver<T> extends AtomicReference<ug.b> implements rg.s, rg.h, ug.b {
    private static final long serialVersionUID = -1953724749712440952L;
    final rg.s actual;
    boolean inMaybe;
    rg.i other;

    public ObservableConcatWithMaybe$ConcatWithObserver(rg.s sVar, rg.i iVar) {
        this.actual = sVar;
        this.other = iVar;
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
        if (this.inMaybe) {
            this.actual.onComplete();
            return;
        }
        this.inMaybe = true;
        DisposableHelper.replace(this, null);
        rg.i iVar = this.other;
        this.other = null;
        ((rg.g) iVar).b(this);
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
        if (!DisposableHelper.setOnce(this, bVar) || this.inMaybe) {
            return;
        }
        this.actual.onSubscribe(this);
    }

    @Override // rg.h
    public void onSuccess(T t8) {
        this.actual.onNext(t8);
        this.actual.onComplete();
    }
}
