package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
final class BlockingObservableIterable$BlockingObservableIterator<T> extends AtomicReference<ug.b> implements rg.s, Iterator<T>, ug.b {
    private static final long serialVersionUID = 6695226475494099826L;
    final Condition condition;
    volatile boolean done;
    Throwable error;
    final Lock lock;
    final io.reactivex.internal.queue.b queue;

    public BlockingObservableIterable$BlockingObservableIterator(int i3) {
        this.queue = new io.reactivex.internal.queue.b(i3);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            boolean z5 = this.done;
            boolean isEmpty = this.queue.isEmpty();
            if (z5) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    throw io.reactivex.internal.util.b.b(th2);
                }
                if (isEmpty) {
                    return false;
                }
            }
            if (!isEmpty) {
                return true;
            }
            try {
                this.lock.lock();
                while (!this.done && this.queue.isEmpty()) {
                    try {
                        this.condition.await();
                    } finally {
                    }
                }
                this.lock.unlock();
            } catch (InterruptedException e) {
                DisposableHelper.dispose(this);
                signalConsumer();
                throw io.reactivex.internal.util.b.b(e);
            }
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            return (T) this.queue.poll();
        }
        throw new NoSuchElementException();
    }

    @Override // rg.s
    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        signalConsumer();
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.queue.offer(t8);
        signalConsumer();
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public void signalConsumer() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }
}
