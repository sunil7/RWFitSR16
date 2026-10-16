package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableGroupBy$State<T, K> extends AtomicInteger implements ug.b, rg.q {
    private static final long serialVersionUID = -3852313036005250360L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final ObservableGroupBy$GroupByObserver<?, K, T> parent;
    final io.reactivex.internal.queue.b queue;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicReference<rg.s> actual = new AtomicReference<>();

    public ObservableGroupBy$State(int i3, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, K k10, boolean z5) {
        this.queue = new io.reactivex.internal.queue.b(i3);
        this.parent = observableGroupBy$GroupByObserver;
        this.key = k10;
        this.delayError = z5;
    }

    public boolean checkTerminated(boolean z5, boolean z6, rg.s sVar, boolean z8) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.parent.cancel(this.key);
            this.actual.lazySet(null);
            return true;
        }
        if (!z5) {
            return false;
        }
        if (z8) {
            if (!z6) {
                return false;
            }
            Throwable th2 = this.error;
            this.actual.lazySet(null);
            if (th2 != null) {
                sVar.onError(th2);
            } else {
                sVar.onComplete();
            }
            return true;
        }
        Throwable th3 = this.error;
        if (th3 != null) {
            this.queue.clear();
            this.actual.lazySet(null);
            sVar.onError(th3);
            return true;
        }
        if (!z6) {
            return false;
        }
        this.actual.lazySet(null);
        sVar.onComplete();
        return true;
    }

    @Override // ug.b
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.actual.lazySet(null);
            this.parent.cancel(this.key);
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.internal.queue.b bVar = this.queue;
        boolean z5 = this.delayError;
        rg.s sVar = this.actual.get();
        int i3 = 1;
        while (true) {
            if (sVar != null) {
                while (true) {
                    boolean z6 = this.done;
                    Object poll = bVar.poll();
                    boolean z8 = poll == null;
                    if (checkTerminated(z6, z8, sVar, z5)) {
                        return;
                    }
                    if (z8) {
                        break;
                    } else {
                        sVar.onNext(poll);
                    }
                }
            }
            i3 = addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
            if (sVar == null) {
                sVar = this.actual.get();
            }
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t8) {
        this.queue.offer(t8);
        drain();
    }

    @Override // rg.q
    public void subscribe(rg.s sVar) {
        if (!this.once.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), sVar);
            return;
        }
        sVar.onSubscribe(this);
        this.actual.lazySet(sVar);
        if (this.cancelled.get()) {
            this.actual.lazySet(null);
        } else {
            drain();
        }
    }
}
