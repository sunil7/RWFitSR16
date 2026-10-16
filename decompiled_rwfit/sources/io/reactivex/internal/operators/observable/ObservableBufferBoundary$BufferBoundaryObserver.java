package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableBufferBoundary$BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements rg.s, ug.b {
    private static final long serialVersionUID = -8466418554264089604L;
    final rg.s actual;
    final vg.o bufferClose;
    final rg.q bufferOpen;
    final Callable<C> bufferSupplier;
    volatile boolean cancelled;
    volatile boolean done;
    long index;
    final io.reactivex.internal.queue.b queue = new io.reactivex.internal.queue.b(rg.l.bufferSize());
    final ug.a observers = new ug.a();
    final AtomicReference<ug.b> upstream = new AtomicReference<>();
    Map<Long, C> buffers = new LinkedHashMap();
    final AtomicThrowable errors = new AtomicThrowable();

    public static final class BufferOpenObserver<Open> extends AtomicReference<ug.b> implements rg.s, ug.b {
        private static final long serialVersionUID = -8498650778633225126L;
        final ObservableBufferBoundary$BufferBoundaryObserver<?, ?, Open, ?> parent;

        public BufferOpenObserver(ObservableBufferBoundary$BufferBoundaryObserver<?, ?, Open, ?> observableBufferBoundary$BufferBoundaryObserver) {
            this.parent = observableBufferBoundary$BufferBoundaryObserver;
        }

        @Override // ug.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ug.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // rg.s
        public void onComplete() {
            lazySet(DisposableHelper.DISPOSED);
            this.parent.openComplete(this);
        }

        @Override // rg.s
        public void onError(Throwable th2) {
            lazySet(DisposableHelper.DISPOSED);
            this.parent.boundaryError(this, th2);
        }

        @Override // rg.s
        public void onNext(Open open) {
            this.parent.open(open);
        }

        @Override // rg.s
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableBufferBoundary$BufferBoundaryObserver(rg.s sVar, rg.q qVar, vg.o oVar, Callable<C> callable) {
        this.actual = sVar;
        this.bufferSupplier = callable;
        this.bufferOpen = qVar;
        this.bufferClose = oVar;
    }

    public void boundaryError(ug.b bVar, Throwable th2) {
        DisposableHelper.dispose(this.upstream);
        this.observers.a(bVar);
        onError(th2);
    }

    public void close(ObservableBufferBoundary$BufferCloseObserver<T, C> observableBufferBoundary$BufferCloseObserver, long j4) {
        boolean z5;
        this.observers.a(observableBufferBoundary$BufferCloseObserver);
        if (this.observers.d() == 0) {
            DisposableHelper.dispose(this.upstream);
            z5 = true;
        } else {
            z5 = false;
        }
        synchronized (this) {
            try {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                this.queue.offer(map.remove(Long.valueOf(j4)));
                if (z5) {
                    this.done = true;
                }
                drain();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ug.b
    public void dispose() {
        if (DisposableHelper.dispose(this.upstream)) {
            this.cancelled = true;
            this.observers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            if (getAndIncrement() != 0) {
                this.queue.clear();
            }
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        rg.s sVar = this.actual;
        io.reactivex.internal.queue.b bVar = this.queue;
        int i3 = 1;
        while (!this.cancelled) {
            boolean z5 = this.done;
            if (z5 && this.errors.get() != null) {
                bVar.clear();
                sVar.onError(this.errors.terminate());
                return;
            }
            Collection collection = (Collection) bVar.poll();
            boolean z6 = collection == null;
            if (z5 && z6) {
                sVar.onComplete();
                return;
            } else if (z6) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                sVar.onNext(collection);
            }
        }
        bVar.clear();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // rg.s
    public void onComplete() {
        this.observers.dispose();
        synchronized (this) {
            try {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.queue.offer(it.next());
                }
                this.buffers = null;
                this.done = true;
                drain();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (!this.errors.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.observers.dispose();
        synchronized (this) {
            this.buffers = null;
        }
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onNext(T t8) {
        synchronized (this) {
            try {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t8);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.setOnce(this.upstream, bVar)) {
            BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
            this.observers.c(bufferOpenObserver);
            this.bufferOpen.subscribe(bufferOpenObserver);
        }
    }

    public void open(Open open) {
        try {
            C call = this.bufferSupplier.call();
            xg.c.b(call, "The bufferSupplier returned a null Collection");
            C c9 = call;
            Object apply = this.bufferClose.apply(open);
            xg.c.b(apply, "The bufferClose returned a null ObservableSource");
            rg.q qVar = (rg.q) apply;
            long j4 = this.index;
            this.index = 1 + j4;
            synchronized (this) {
                try {
                    Map<Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    map.put(Long.valueOf(j4), c9);
                    ObservableBufferBoundary$BufferCloseObserver observableBufferBoundary$BufferCloseObserver = new ObservableBufferBoundary$BufferCloseObserver(this, j4);
                    this.observers.c(observableBufferBoundary$BufferCloseObserver);
                    qVar.subscribe(observableBufferBoundary$BufferCloseObserver);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            ad.a(th3);
            DisposableHelper.dispose(this.upstream);
            onError(th3);
        }
    }

    public void openComplete(BufferOpenObserver<Open> bufferOpenObserver) {
        this.observers.a(bufferOpenObserver);
        if (this.observers.d() == 0) {
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            drain();
        }
    }
}
