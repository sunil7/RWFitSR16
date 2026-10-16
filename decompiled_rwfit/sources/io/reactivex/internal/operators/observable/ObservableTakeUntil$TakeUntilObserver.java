package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class ObservableTakeUntil$TakeUntilObserver<T> extends AtomicBoolean implements rg.s {
    private static final long serialVersionUID = 3451719290311127173L;
    final rg.s actual;
    final ArrayCompositeDisposable frc;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14538s;

    public ObservableTakeUntil$TakeUntilObserver(rg.s sVar, ArrayCompositeDisposable arrayCompositeDisposable) {
        this.actual = sVar;
        this.frc = arrayCompositeDisposable;
    }

    @Override // rg.s
    public void onComplete() {
        this.frc.dispose();
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.frc.dispose();
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.actual.onNext(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14538s, bVar)) {
            this.f14538s = bVar;
            this.frc.setResource(0, bVar);
        }
    }
}
