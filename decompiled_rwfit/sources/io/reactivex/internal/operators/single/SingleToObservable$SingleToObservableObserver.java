package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import rg.s;
import rg.z;
import ug.b;

/* loaded from: classes2.dex */
final class SingleToObservable$SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements z {
    private static final long serialVersionUID = 3786543492451018833L;

    /* renamed from: d, reason: collision with root package name */
    b f15044d;

    public SingleToObservable$SingleToObservableObserver(s sVar) {
        super(sVar);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
    public void dispose() {
        super.dispose();
        this.f15044d.dispose();
    }

    @Override // rg.z
    public void onError(Throwable th2) {
        error(th2);
    }

    @Override // rg.z
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f15044d, bVar)) {
            this.f15044d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // rg.z, rg.h
    public void onSuccess(T t8) {
        complete(t8);
    }
}
