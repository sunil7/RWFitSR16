package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableAmb$AmbInnerObserver<T> extends AtomicReference<ug.b> implements rg.s {
    private static final long serialVersionUID = -1185974347409665484L;
    final rg.s actual;
    final int index;
    final n parent;
    boolean won;

    public ObservableAmb$AmbInnerObserver(n nVar, int i3, rg.s sVar) {
        this.parent = nVar;
        this.index = i3;
        this.actual = sVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // rg.s
    public void onComplete() {
        if (this.won) {
            this.actual.onComplete();
        } else if (this.parent.a(this.index)) {
            this.won = true;
            this.actual.onComplete();
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.won) {
            this.actual.onError(th2);
        } else if (!this.parent.a(this.index)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.won = true;
            this.actual.onError(th2);
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.won) {
            this.actual.onNext(t8);
        } else if (!this.parent.a(this.index)) {
            get().dispose();
        } else {
            this.won = true;
            this.actual.onNext(t8);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
