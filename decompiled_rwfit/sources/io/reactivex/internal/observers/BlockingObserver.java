package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import rg.s;

/* loaded from: classes2.dex */
public final class BlockingObserver<T> extends AtomicReference<ug.b> implements s, ug.b {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingObserver(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // ug.b
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // rg.s
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.queue.offer(NotificationLite.error(th2));
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.queue.offer(NotificationLite.next(t8));
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
