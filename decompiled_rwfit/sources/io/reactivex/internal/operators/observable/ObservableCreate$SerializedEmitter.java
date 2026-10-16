package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableCreate$SerializedEmitter<T> extends AtomicInteger implements rg.n {
    private static final long serialVersionUID = 4883307006032401862L;
    volatile boolean done;
    final rg.n emitter;
    final AtomicThrowable error = new AtomicThrowable();
    final io.reactivex.internal.queue.b queue = new io.reactivex.internal.queue.b(16);

    public ObservableCreate$SerializedEmitter(rg.n nVar) {
        this.emitter = nVar;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        rg.n nVar = this.emitter;
        io.reactivex.internal.queue.b bVar = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        int i3 = 1;
        while (!nVar.isDisposed()) {
            if (atomicThrowable.get() != null) {
                bVar.clear();
                nVar.onError(atomicThrowable.terminate());
                return;
            }
            boolean z5 = this.done;
            Object poll = bVar.poll();
            boolean z6 = poll == null;
            if (z5 && z6) {
                nVar.onComplete();
                return;
            } else if (z6) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                nVar.onNext(poll);
            }
        }
        bVar.clear();
    }

    @Override // rg.n, ug.b
    public boolean isDisposed() {
        return this.emitter.isDisposed();
    }

    @Override // rg.d
    public void onComplete() {
        if (this.emitter.isDisposed() || this.done) {
            return;
        }
        this.done = true;
        drain();
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
        if (this.emitter.isDisposed() || this.done) {
            return;
        }
        if (t8 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            this.emitter.onNext(t8);
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            io.reactivex.internal.queue.b bVar = this.queue;
            synchronized (bVar) {
                bVar.offer(t8);
            }
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    public rg.n serialize() {
        return this;
    }

    @Override // rg.n
    public void setCancellable(vg.f fVar) {
        this.emitter.setCancellable(fVar);
    }

    @Override // rg.n
    public void setDisposable(ug.b bVar) {
        this.emitter.setDisposable(bVar);
    }

    public boolean tryOnError(Throwable th2) {
        if (!this.emitter.isDisposed() && !this.done) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (this.error.addThrowable(th2)) {
                this.done = true;
                drain();
                return true;
            }
        }
        return false;
    }
}
