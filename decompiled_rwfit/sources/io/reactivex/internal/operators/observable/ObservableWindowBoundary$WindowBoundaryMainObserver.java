package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> extends AtomicInteger implements rg.s, ug.b, Runnable {
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final int capacityHint;
    volatile boolean done;
    final rg.s downstream;
    io.reactivex.subjects.d window;
    final l4 boundaryObserver = new l4(this);
    final AtomicReference<ug.b> upstream = new AtomicReference<>();
    final AtomicInteger windows = new AtomicInteger(1);
    final io.reactivex.internal.queue.a queue = new io.reactivex.internal.queue.a();
    final AtomicThrowable errors = new AtomicThrowable();
    final AtomicBoolean stopWindows = new AtomicBoolean();

    public ObservableWindowBoundary$WindowBoundaryMainObserver(rg.s sVar, int i3) {
        this.downstream = sVar;
        this.capacityHint = i3;
    }

    @Override // ug.b
    public void dispose() {
        if (this.stopWindows.compareAndSet(false, true)) {
            this.boundaryObserver.dispose();
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        rg.s sVar = this.downstream;
        io.reactivex.internal.queue.a aVar = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        int i3 = 1;
        while (this.windows.get() != 0) {
            io.reactivex.subjects.d dVar = this.window;
            boolean z5 = this.done;
            if (z5 && atomicThrowable.get() != null) {
                aVar.clear();
                Throwable terminate = atomicThrowable.terminate();
                if (dVar != null) {
                    this.window = null;
                    dVar.onError(terminate);
                }
                sVar.onError(terminate);
                return;
            }
            Object poll = aVar.poll();
            boolean z6 = poll == null;
            if (z5 && z6) {
                Throwable terminate2 = atomicThrowable.terminate();
                if (terminate2 == null) {
                    if (dVar != null) {
                        this.window = null;
                        dVar.onComplete();
                    }
                    sVar.onComplete();
                    return;
                }
                if (dVar != null) {
                    this.window = null;
                    dVar.onError(terminate2);
                }
                sVar.onError(terminate2);
                return;
            }
            if (z6) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else if (poll != NEXT_WINDOW) {
                dVar.onNext(poll);
            } else {
                if (dVar != null) {
                    this.window = null;
                    dVar.onComplete();
                }
                if (!this.stopWindows.get()) {
                    io.reactivex.subjects.d dVar2 = new io.reactivex.subjects.d(this, this.capacityHint);
                    this.window = dVar2;
                    this.windows.getAndIncrement();
                    sVar.onNext(dVar2);
                }
            }
        }
        aVar.clear();
        this.window = null;
    }

    public void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        this.done = true;
        drain();
    }

    public void innerError(Throwable th2) {
        DisposableHelper.dispose(this.upstream);
        if (!this.errors.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.done = true;
            drain();
        }
    }

    public void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    @Override // rg.s
    public void onComplete() {
        this.boundaryObserver.dispose();
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.boundaryObserver.dispose();
        if (!this.errors.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.done = true;
            drain();
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.queue.offer(t8);
        drain();
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.setOnce(this.upstream, bVar)) {
            innerNext();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windows.decrementAndGet() == 0) {
            DisposableHelper.dispose(this.upstream);
        }
    }
}
