package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableFlatMap$InnerObserver<T, U> extends AtomicReference<ug.b> implements rg.s {
    private static final long serialVersionUID = -4606175640614850599L;
    volatile boolean done;
    int fusionMode;

    /* renamed from: id, reason: collision with root package name */
    final long f14515id;
    final ObservableFlatMap$MergeObserver<T, U> parent;
    volatile yg.f queue;

    public ObservableFlatMap$InnerObserver(ObservableFlatMap$MergeObserver<T, U> observableFlatMap$MergeObserver, long j4) {
        this.f14515id = j4;
        this.parent = observableFlatMap$MergeObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // rg.s
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (!this.parent.errors.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        ObservableFlatMap$MergeObserver<T, U> observableFlatMap$MergeObserver = this.parent;
        if (!observableFlatMap$MergeObserver.delayErrors) {
            observableFlatMap$MergeObserver.disposeAll();
        }
        this.done = true;
        this.parent.drain();
    }

    @Override // rg.s
    public void onNext(U u10) {
        if (this.fusionMode == 0) {
            this.parent.tryEmit(u10, this);
        } else {
            this.parent.drain();
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.setOnce(this, bVar) && (bVar instanceof yg.b)) {
            yg.b bVar2 = (yg.b) bVar;
            int requestFusion = bVar2.requestFusion(7);
            if (requestFusion == 1) {
                this.fusionMode = requestFusion;
                this.queue = bVar2;
                this.done = true;
                this.parent.drain();
                return;
            }
            if (requestFusion == 2) {
                this.fusionMode = requestFusion;
                this.queue = bVar2;
            }
        }
    }
}
