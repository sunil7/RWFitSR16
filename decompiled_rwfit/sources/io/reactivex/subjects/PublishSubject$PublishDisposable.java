package io.reactivex.subjects;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import java.util.concurrent.atomic.AtomicBoolean;
import rg.s;

/* loaded from: classes2.dex */
final class PublishSubject$PublishDisposable<T> extends AtomicBoolean implements ug.b {
    private static final long serialVersionUID = 3562861878281475070L;
    final s actual;
    final a parent;

    public PublishSubject$PublishDisposable(s sVar, a aVar) {
        this.actual = sVar;
        this.parent = aVar;
    }

    @Override // ug.b
    public void dispose() {
        if (compareAndSet(false, true)) {
            this.parent.c(this);
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get();
    }

    public void onComplete() {
        if (get()) {
            return;
        }
        this.actual.onComplete();
    }

    public void onError(Throwable th2) {
        if (get()) {
            a1.b(th2);
        } else {
            this.actual.onError(th2);
        }
    }

    public void onNext(T t8) {
        if (get()) {
            return;
        }
        this.actual.onNext(t8);
    }
}
