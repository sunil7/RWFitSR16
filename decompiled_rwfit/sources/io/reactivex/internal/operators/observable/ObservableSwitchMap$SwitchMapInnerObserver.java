package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableSwitchMap$SwitchMapInnerObserver<T, R> extends AtomicReference<ug.b> implements rg.s {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    final long index;
    final ObservableSwitchMap$SwitchMapObserver<T, R> parent;
    volatile yg.f queue;

    public ObservableSwitchMap$SwitchMapInnerObserver(ObservableSwitchMap$SwitchMapObserver<T, R> observableSwitchMap$SwitchMapObserver, long j4, int i3) {
        this.parent = observableSwitchMap$SwitchMapObserver;
        this.index = j4;
        this.bufferSize = i3;
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // rg.s
    public void onComplete() {
        if (this.index == this.parent.unique) {
            this.done = true;
            this.parent.drain();
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.parent.innerError(this, th2);
    }

    @Override // rg.s
    public void onNext(R r) {
        if (this.index == this.parent.unique) {
            if (r != null) {
                this.queue.offer(r);
            }
            this.parent.drain();
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            if (bVar instanceof yg.b) {
                yg.b bVar2 = (yg.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.queue = bVar2;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.queue = bVar2;
                    return;
                }
            }
            this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
        }
    }
}
