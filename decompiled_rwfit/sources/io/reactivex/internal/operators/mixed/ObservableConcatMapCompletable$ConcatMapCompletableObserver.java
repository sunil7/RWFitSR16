package io.reactivex.internal.operators.mixed;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rg.s;
import vg.o;
import yg.f;

/* loaded from: classes2.dex */
final class ObservableConcatMapCompletable$ConcatMapCompletableObserver<T> extends AtomicInteger implements s, ug.b {
    private static final long serialVersionUID = 3610901111000061034L;
    volatile boolean active;
    volatile boolean disposed;
    volatile boolean done;
    final rg.b downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors = new AtomicThrowable();
    final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
    final o mapper;
    final int prefetch;
    f queue;
    ug.b upstream;

    public static final class ConcatMapInnerObserver extends AtomicReference<ug.b> implements rg.b {
        private static final long serialVersionUID = 5638352172918776687L;
        final ObservableConcatMapCompletable$ConcatMapCompletableObserver<?> parent;

        public ConcatMapInnerObserver(ObservableConcatMapCompletable$ConcatMapCompletableObserver<?> observableConcatMapCompletable$ConcatMapCompletableObserver) {
            this.parent = observableConcatMapCompletable$ConcatMapCompletableObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // rg.b, rg.h
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // rg.b
        public void onError(Throwable th2) {
            this.parent.innerError(th2);
        }

        @Override // rg.b
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public ObservableConcatMapCompletable$ConcatMapCompletableObserver(rg.b bVar, o oVar, ErrorMode errorMode, int i3) {
        this.downstream = bVar;
        this.mapper = oVar;
        this.errorMode = errorMode;
        this.prefetch = i3;
    }

    @Override // ug.b
    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.inner.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        rg.c cVar;
        boolean z5;
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicThrowable atomicThrowable = this.errors;
        ErrorMode errorMode = this.errorMode;
        while (!this.disposed) {
            if (!this.active) {
                if (errorMode == ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                    this.disposed = true;
                    this.queue.clear();
                    this.downstream.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z6 = this.done;
                try {
                    Object poll = this.queue.poll();
                    if (poll != null) {
                        Object apply = this.mapper.apply(poll);
                        xg.c.b(apply, "The mapper returned a null CompletableSource");
                        cVar = (rg.c) apply;
                        z5 = false;
                    } else {
                        cVar = null;
                        z5 = true;
                    }
                    if (z6 && z5) {
                        this.disposed = true;
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate != null) {
                            this.downstream.onError(terminate);
                            return;
                        } else {
                            this.downstream.onComplete();
                            return;
                        }
                    }
                    if (!z5) {
                        this.active = true;
                        ((rg.a) cVar).b(this.inner);
                    }
                } catch (Throwable th2) {
                    ad.a(th2);
                    this.disposed = true;
                    this.queue.clear();
                    this.upstream.dispose();
                    atomicThrowable.addThrowable(th2);
                    this.downstream.onError(atomicThrowable.terminate());
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.queue.clear();
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable th2) {
        if (!this.errors.addThrowable(th2)) {
            a1.b(th2);
            return;
        }
        if (this.errorMode != ErrorMode.IMMEDIATE) {
            this.active = false;
            drain();
            return;
        }
        this.disposed = true;
        this.upstream.dispose();
        Throwable terminate = this.errors.terminate();
        if (terminate != io.reactivex.internal.util.b.f15123a) {
            this.downstream.onError(terminate);
        }
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // rg.s
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (!this.errors.addThrowable(th2)) {
            a1.b(th2);
            return;
        }
        if (this.errorMode != ErrorMode.IMMEDIATE) {
            this.done = true;
            drain();
            return;
        }
        this.disposed = true;
        this.inner.dispose();
        Throwable terminate = this.errors.terminate();
        if (terminate != io.reactivex.internal.util.b.f15123a) {
            this.downstream.onError(terminate);
        }
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (t8 != null) {
            this.queue.offer(t8);
        }
        drain();
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            if (bVar instanceof yg.b) {
                yg.b bVar2 = (yg.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.queue = bVar2;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.queue = bVar2;
                    this.downstream.onSubscribe(this);
                    return;
                }
            }
            this.queue = new io.reactivex.internal.queue.b(this.prefetch);
            this.downstream.onSubscribe(this);
        }
    }
}
