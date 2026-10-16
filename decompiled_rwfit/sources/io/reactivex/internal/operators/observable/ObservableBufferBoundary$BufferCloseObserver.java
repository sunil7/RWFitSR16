package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableBufferBoundary$BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<ug.b> implements rg.s, ug.b {
    private static final long serialVersionUID = -8498650778633225126L;
    final long index;
    final ObservableBufferBoundary$BufferBoundaryObserver<T, C, ?, ?> parent;

    public ObservableBufferBoundary$BufferCloseObserver(ObservableBufferBoundary$BufferBoundaryObserver<T, C, ?, ?> observableBufferBoundary$BufferBoundaryObserver, long j4) {
        this.parent = observableBufferBoundary$BufferBoundaryObserver;
        this.index = j4;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // rg.s
    public void onComplete() {
        ug.b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            lazySet(disposableHelper);
            this.parent.close(this, this.index);
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
            this.parent.boundaryError(this, th2);
        }
    }

    @Override // rg.s
    public void onNext(Object obj) {
        ug.b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            lazySet(disposableHelper);
            bVar.dispose();
            this.parent.close(this, this.index);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
