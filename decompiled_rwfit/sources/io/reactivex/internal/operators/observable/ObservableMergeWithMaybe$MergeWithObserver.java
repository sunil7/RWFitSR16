package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableMergeWithMaybe$MergeWithObserver<T> extends AtomicInteger implements rg.s, ug.b {
    static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    final rg.s actual;
    volatile boolean disposed;
    volatile boolean mainDone;
    volatile int otherState;
    volatile yg.e queue;
    T singleItem;
    final AtomicReference<ug.b> mainDisposable = new AtomicReference<>();
    final OtherObserver<T> otherObserver = new OtherObserver<>(this);
    final AtomicThrowable error = new AtomicThrowable();

    public static final class OtherObserver<T> extends AtomicReference<ug.b> implements rg.h {
        private static final long serialVersionUID = -2935427570954647017L;
        final ObservableMergeWithMaybe$MergeWithObserver<T> parent;

        public OtherObserver(ObservableMergeWithMaybe$MergeWithObserver<T> observableMergeWithMaybe$MergeWithObserver) {
            this.parent = observableMergeWithMaybe$MergeWithObserver;
        }

        @Override // rg.h
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // rg.h
        public void onError(Throwable th2) {
            this.parent.otherError(th2);
        }

        @Override // rg.h
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // rg.h
        public void onSuccess(T t8) {
            this.parent.otherSuccess(t8);
        }
    }

    public ObservableMergeWithMaybe$MergeWithObserver(rg.s sVar) {
        this.actual = sVar;
    }

    @Override // ug.b
    public void dispose() {
        this.disposed = true;
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
        if (getAndIncrement() == 0) {
            this.queue = null;
            this.singleItem = null;
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        rg.s sVar = this.actual;
        int i3 = 1;
        while (!this.disposed) {
            if (this.error.get() != null) {
                this.singleItem = null;
                this.queue = null;
                sVar.onError(this.error.terminate());
                return;
            }
            int i10 = this.otherState;
            if (i10 == 1) {
                T t8 = this.singleItem;
                this.singleItem = null;
                this.otherState = 2;
                sVar.onNext(t8);
                i10 = 2;
            }
            boolean z5 = this.mainDone;
            yg.e eVar = this.queue;
            Object poll = eVar != null ? eVar.poll() : null;
            boolean z6 = poll == null;
            if (z5 && z6 && i10 == 2) {
                this.queue = null;
                sVar.onComplete();
                return;
            } else if (z6) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                sVar.onNext(poll);
            }
        }
        this.singleItem = null;
        this.queue = null;
    }

    public yg.e getOrCreateQueue() {
        yg.e eVar = this.queue;
        if (eVar != null) {
            return eVar;
        }
        io.reactivex.internal.queue.b bVar = new io.reactivex.internal.queue.b(rg.l.bufferSize());
        this.queue = bVar;
        return bVar;
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.mainDisposable.get());
    }

    @Override // rg.s
    public void onComplete() {
        this.mainDone = true;
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (!this.error.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            DisposableHelper.dispose(this.mainDisposable);
            drain();
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (compareAndSet(0, 1)) {
            this.actual.onNext(t8);
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            getOrCreateQueue().offer(t8);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this.mainDisposable, bVar);
    }

    public void otherComplete() {
        this.otherState = 2;
        drain();
    }

    public void otherError(Throwable th2) {
        if (!this.error.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            DisposableHelper.dispose(this.mainDisposable);
            drain();
        }
    }

    public void otherSuccess(T t8) {
        if (compareAndSet(0, 1)) {
            this.actual.onNext(t8);
            this.otherState = 2;
        } else {
            this.singleItem = t8;
            this.otherState = 1;
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }
}
