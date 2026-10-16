package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class ObservableUnsubscribeOn$UnsubscribeObserver<T> extends AtomicBoolean implements rg.s, ug.b {
    private static final long serialVersionUID = 1015244841293359600L;
    final rg.s actual;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14540s;
    final rg.x scheduler;

    public ObservableUnsubscribeOn$UnsubscribeObserver(rg.s sVar, rg.x xVar) {
        this.actual = sVar;
        this.scheduler = xVar;
    }

    @Override // ug.b
    public void dispose() {
        if (compareAndSet(false, true)) {
            this.scheduler.c(new i4(this, 0));
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get();
    }

    @Override // rg.s
    public void onComplete() {
        if (get()) {
            return;
        }
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (get()) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.actual.onError(th2);
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (get()) {
            return;
        }
        this.actual.onNext(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14540s, bVar)) {
            this.f14540s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
