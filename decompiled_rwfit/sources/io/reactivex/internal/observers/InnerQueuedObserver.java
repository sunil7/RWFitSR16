package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicReference;
import rg.s;

/* loaded from: classes2.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<ug.b> implements s, ug.b {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final g parent;
    final int prefetch;
    yg.f queue;

    public InnerQueuedObserver(g gVar, int i3) {
        this.parent = gVar;
        this.prefetch = i3;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // rg.s
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.parent.innerError(this, th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t8);
        } else {
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
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    return;
                }
            }
            int i3 = -this.prefetch;
            this.queue = i3 < 0 ? new io.reactivex.internal.queue.b(-i3) : new SpscArrayQueue(i3);
        }
    }

    public yg.f queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
