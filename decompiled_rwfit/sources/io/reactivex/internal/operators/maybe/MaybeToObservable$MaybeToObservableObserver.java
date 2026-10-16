package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import rg.h;
import rg.s;
import ug.b;

/* loaded from: classes2.dex */
final class MaybeToObservable$MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements h {
    private static final long serialVersionUID = 7603343402964826922L;

    /* renamed from: d, reason: collision with root package name */
    b f14486d;

    public MaybeToObservable$MaybeToObservableObserver(s sVar) {
        super(sVar);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
    public void dispose() {
        super.dispose();
        this.f14486d.dispose();
    }

    @Override // rg.h
    public void onComplete() {
        complete();
    }

    @Override // rg.h
    public void onError(Throwable th2) {
        error(th2);
    }

    @Override // rg.h
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f14486d, bVar)) {
            this.f14486d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // rg.h
    public void onSuccess(T t8) {
        complete(t8);
    }
}
