package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableFlatMapSingle$FlatMapSingleObserver<T, R> extends AtomicInteger implements rg.s, ug.b {
    private static final long serialVersionUID = 8600231336733376951L;
    final rg.s actual;
    volatile boolean cancelled;

    /* renamed from: d, reason: collision with root package name */
    ug.b f14520d;
    final boolean delayErrors;
    final vg.o mapper;
    final ug.a set = new ug.a();
    final AtomicThrowable errors = new AtomicThrowable();
    final AtomicInteger active = new AtomicInteger(1);
    final AtomicReference<io.reactivex.internal.queue.b> queue = new AtomicReference<>();

    public final class InnerObserver extends AtomicReference<ug.b> implements rg.z, ug.b {
        private static final long serialVersionUID = -502562646270949838L;

        public InnerObserver() {
        }

        @Override // ug.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ug.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // rg.z
        public void onError(Throwable th2) {
            ObservableFlatMapSingle$FlatMapSingleObserver.this.innerError(this, th2);
        }

        @Override // rg.z
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // rg.z, rg.h
        public void onSuccess(R r) {
            ObservableFlatMapSingle$FlatMapSingleObserver.this.innerSuccess(this, r);
        }
    }

    public ObservableFlatMapSingle$FlatMapSingleObserver(rg.s sVar, vg.o oVar, boolean z5) {
        this.actual = sVar;
        this.mapper = oVar;
        this.delayErrors = z5;
    }

    public void clear() {
        io.reactivex.internal.queue.b bVar = this.queue.get();
        if (bVar != null) {
            bVar.clear();
        }
    }

    @Override // ug.b
    public void dispose() {
        this.cancelled = true;
        this.f14520d.dispose();
        this.set.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        rg.s sVar = this.actual;
        AtomicInteger atomicInteger = this.active;
        AtomicReference<io.reactivex.internal.queue.b> atomicReference = this.queue;
        int i3 = 1;
        while (!this.cancelled) {
            if (!this.delayErrors && this.errors.get() != null) {
                Throwable terminate = this.errors.terminate();
                clear();
                sVar.onError(terminate);
                return;
            }
            boolean z5 = atomicInteger.get() == 0;
            io.reactivex.internal.queue.b bVar = atomicReference.get();
            Object poll = bVar != null ? bVar.poll() : null;
            boolean z6 = poll == null;
            if (z5 && z6) {
                Throwable terminate2 = this.errors.terminate();
                if (terminate2 != null) {
                    sVar.onError(terminate2);
                    return;
                } else {
                    sVar.onComplete();
                    return;
                }
            }
            if (z6) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                sVar.onNext(poll);
            }
        }
        clear();
    }

    public io.reactivex.internal.queue.b getOrCreateQueue() {
        while (true) {
            io.reactivex.internal.queue.b bVar = this.queue.get();
            if (bVar != null) {
                return bVar;
            }
            io.reactivex.internal.queue.b bVar2 = new io.reactivex.internal.queue.b(rg.l.bufferSize());
            AtomicReference<io.reactivex.internal.queue.b> atomicReference = this.queue;
            while (!atomicReference.compareAndSet(null, bVar2)) {
                if (atomicReference.get() != null) {
                    break;
                }
            }
            return bVar2;
        }
    }

    public void innerError(ObservableFlatMapSingle$FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th2) {
        this.set.a(innerObserver);
        if (!this.errors.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        if (!this.delayErrors) {
            this.f14520d.dispose();
            this.set.dispose();
        }
        this.active.decrementAndGet();
        drain();
    }

    public void innerSuccess(ObservableFlatMapSingle$FlatMapSingleObserver<T, R>.InnerObserver innerObserver, R r) {
        this.set.a(innerObserver);
        if (get() == 0) {
            if (compareAndSet(0, 1)) {
                this.actual.onNext(r);
                boolean z5 = this.active.decrementAndGet() == 0;
                io.reactivex.internal.queue.b bVar = this.queue.get();
                if (!z5 || (bVar != null && !bVar.isEmpty())) {
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                } else {
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        this.actual.onError(terminate);
                        return;
                    } else {
                        this.actual.onComplete();
                        return;
                    }
                }
            }
        }
        io.reactivex.internal.queue.b orCreateQueue = getOrCreateQueue();
        synchronized (orCreateQueue) {
            orCreateQueue.offer(r);
        }
        this.active.decrementAndGet();
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // rg.s
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.active.decrementAndGet();
        if (!this.errors.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        if (!this.delayErrors) {
            this.set.dispose();
        }
        drain();
    }

    @Override // rg.s
    public void onNext(T t8) {
        try {
            Object apply = this.mapper.apply(t8);
            xg.c.b(apply, "The mapper returned a null SingleSource");
            rg.a0 a0Var = (rg.a0) apply;
            this.active.getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            if (this.cancelled || !this.set.c(innerObserver)) {
                return;
            }
            ((rg.y) a0Var).b(innerObserver);
        } catch (Throwable th2) {
            ad.a(th2);
            this.f14520d.dispose();
            onError(th2);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14520d, bVar)) {
            this.f14520d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
