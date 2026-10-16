package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableScalarXMap$ScalarDisposable<T> extends AtomicInteger implements yg.b, Runnable {
    static final int FUSED = 1;
    static final int ON_COMPLETE = 3;
    static final int ON_NEXT = 2;
    static final int START = 0;
    private static final long serialVersionUID = 3880992722410194083L;
    final rg.s observer;
    final T value;

    public ObservableScalarXMap$ScalarDisposable(rg.s sVar, T t8) {
        this.observer = sVar;
        this.value = t8;
    }

    @Override // yg.f
    public void clear() {
        lazySet(3);
    }

    @Override // ug.b
    public void dispose() {
        set(3);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get() == 3;
    }

    @Override // yg.f
    public boolean isEmpty() {
        return get() != 1;
    }

    @Override // yg.f
    public boolean offer(T t8) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // yg.f
    public T poll() throws Exception {
        if (get() != 1) {
            return null;
        }
        lazySet(3);
        return this.value;
    }

    @Override // yg.c
    public int requestFusion(int i3) {
        if ((i3 & 1) == 0) {
            return 0;
        }
        lazySet(1);
        return 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() == 0 && compareAndSet(0, 2)) {
            this.observer.onNext(this.value);
            if (get() == 2) {
                lazySet(3);
                this.observer.onComplete();
            }
        }
    }

    public boolean offer(T t8, T t10) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
