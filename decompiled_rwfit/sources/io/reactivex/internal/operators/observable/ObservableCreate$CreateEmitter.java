package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableCreate$CreateEmitter<T> extends AtomicReference<ug.b> implements rg.n, ug.b {
    private static final long serialVersionUID = -3434801548987643227L;
    final rg.s observer;

    public ObservableCreate$CreateEmitter(rg.s sVar) {
        this.observer = sVar;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // rg.n, ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // rg.d
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        try {
            this.observer.onComplete();
        } finally {
            dispose();
        }
    }

    @Override // rg.d
    public void onError(Throwable th2) {
        if (tryOnError(th2)) {
            return;
        }
        com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
    }

    @Override // rg.d
    public void onNext(T t8) {
        if (t8 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            if (isDisposed()) {
                return;
            }
            this.observer.onNext(t8);
        }
    }

    public rg.n serialize() {
        return new ObservableCreate$SerializedEmitter(this);
    }

    @Override // rg.n
    public void setCancellable(vg.f fVar) {
        setDisposable(new CancellableDisposable(fVar));
    }

    @Override // rg.n
    public void setDisposable(ug.b bVar) {
        DisposableHelper.set(this, bVar);
    }

    public boolean tryOnError(Throwable th2) {
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (isDisposed()) {
            return false;
        }
        try {
            this.observer.onError(th2);
            dispose();
            return true;
        } catch (Throwable th3) {
            dispose();
            throw th3;
        }
    }
}
