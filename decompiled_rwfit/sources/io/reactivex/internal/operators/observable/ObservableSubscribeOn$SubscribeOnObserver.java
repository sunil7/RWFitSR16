package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<ug.b> implements rg.s, ug.b {
    private static final long serialVersionUID = 8094547886072529208L;
    final rg.s actual;

    /* renamed from: s, reason: collision with root package name */
    final AtomicReference<ug.b> f14534s = new AtomicReference<>();

    public ObservableSubscribeOn$SubscribeOnObserver(rg.s sVar) {
        this.actual = sVar;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this.f14534s);
        DisposableHelper.dispose(this);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // rg.s
    public void onComplete() {
        this.actual.onComplete();
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
        DisposableHelper.setOnce(this.f14534s, bVar);
    }

    public void setDisposable(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
