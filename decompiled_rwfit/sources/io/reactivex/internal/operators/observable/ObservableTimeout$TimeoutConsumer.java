package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableTimeout$TimeoutConsumer extends AtomicReference<ug.b> implements rg.s, ug.b {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final e4 parent;

    public ObservableTimeout$TimeoutConsumer(long j4, e4 e4Var) {
        this.idx = j4;
        this.parent = e4Var;
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
        ug.b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            lazySet(disposableHelper);
            this.parent.onTimeout(this.idx);
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        ug.b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            lazySet(disposableHelper);
            this.parent.onTimeoutError(this.idx, th2);
        }
    }

    @Override // rg.s
    public void onNext(Object obj) {
        ug.b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            bVar.dispose();
            lazySet(disposableHelper);
            this.parent.onTimeout(this.idx);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
