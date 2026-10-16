package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservablePublishSelector$TargetObserver<T, R> extends AtomicReference<ug.b> implements rg.s, ug.b {
    private static final long serialVersionUID = 854110278590336484L;
    final rg.s actual;

    /* renamed from: d, reason: collision with root package name */
    ug.b f14523d;

    public ObservablePublishSelector$TargetObserver(rg.s sVar) {
        this.actual = sVar;
    }

    @Override // ug.b
    public void dispose() {
        this.f14523d.dispose();
        DisposableHelper.dispose(this);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.f14523d.isDisposed();
    }

    @Override // rg.s
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        DisposableHelper.dispose(this);
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(R r) {
        this.actual.onNext(r);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14523d, bVar)) {
            this.f14523d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
