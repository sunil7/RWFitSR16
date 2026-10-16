package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableConcatWithSingle$ConcatWithObserver<T> extends AtomicReference<ug.b> implements rg.s, rg.z, ug.b {
    private static final long serialVersionUID = -1953724749712440952L;
    final rg.s actual;
    boolean inSingle;
    rg.a0 other;

    public ObservableConcatWithSingle$ConcatWithObserver(rg.s sVar, rg.a0 a0Var) {
        this.actual = sVar;
        this.other = a0Var;
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
        this.inSingle = true;
        DisposableHelper.replace(this, null);
        rg.a0 a0Var = this.other;
        this.other = null;
        ((rg.y) a0Var).b(this);
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
        if (!DisposableHelper.setOnce(this, bVar) || this.inSingle) {
            return;
        }
        this.actual.onSubscribe(this);
    }

    @Override // rg.z, rg.h
    public void onSuccess(T t8) {
        this.actual.onNext(t8);
        this.actual.onComplete();
    }
}
