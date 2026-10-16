package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableConcatMapEager$ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements rg.s, ug.b, io.reactivex.internal.observers.g {
    private static final long serialVersionUID = 8080567949447303262L;
    int activeCount;
    final rg.s actual;
    volatile boolean cancelled;
    InnerQueuedObserver<R> current;

    /* renamed from: d, reason: collision with root package name */
    ug.b f14512d;
    volatile boolean done;
    final ErrorMode errorMode;
    final vg.o mapper;
    final int maxConcurrency;
    final int prefetch;
    yg.f queue;
    int sourceMode;
    final AtomicThrowable error = new AtomicThrowable();
    final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();

    public ObservableConcatMapEager$ConcatMapEagerMainObserver(rg.s sVar, vg.o oVar, int i3, int i10, ErrorMode errorMode) {
        this.actual = sVar;
        this.mapper = oVar;
        this.maxConcurrency = i3;
        this.prefetch = i10;
        this.errorMode = errorMode;
    }

    @Override // ug.b
    public void dispose() {
        this.cancelled = true;
        if (getAndIncrement() == 0) {
            this.queue.clear();
            disposeAll();
        }
    }

    public void disposeAll() {
        InnerQueuedObserver<R> innerQueuedObserver = this.current;
        if (innerQueuedObserver != null) {
            innerQueuedObserver.dispose();
        }
        while (true) {
            InnerQueuedObserver<R> poll = this.observers.poll();
            if (poll == null) {
                return;
            } else {
                poll.dispose();
            }
        }
    }

    @Override // io.reactivex.internal.observers.g
    public void drain() {
        Object poll;
        boolean z5;
        if (getAndIncrement() != 0) {
            return;
        }
        yg.f fVar = this.queue;
        ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
        rg.s sVar = this.actual;
        ErrorMode errorMode = this.errorMode;
        int i3 = 1;
        while (true) {
            int i10 = this.activeCount;
            while (i10 != this.maxConcurrency) {
                if (this.cancelled) {
                    fVar.clear();
                    disposeAll();
                    return;
                }
                if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                    fVar.clear();
                    disposeAll();
                    sVar.onError(this.error.terminate());
                    return;
                }
                try {
                    Object poll2 = fVar.poll();
                    if (poll2 == null) {
                        break;
                    }
                    Object apply = this.mapper.apply(poll2);
                    xg.c.b(apply, "The mapper returned a null ObservableSource");
                    rg.q qVar = (rg.q) apply;
                    InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.prefetch);
                    arrayDeque.offer(innerQueuedObserver);
                    qVar.subscribe(innerQueuedObserver);
                    i10++;
                } catch (Throwable th2) {
                    ad.a(th2);
                    this.f14512d.dispose();
                    fVar.clear();
                    disposeAll();
                    this.error.addThrowable(th2);
                    sVar.onError(this.error.terminate());
                    return;
                }
            }
            this.activeCount = i10;
            if (this.cancelled) {
                fVar.clear();
                disposeAll();
                return;
            }
            if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                fVar.clear();
                disposeAll();
                sVar.onError(this.error.terminate());
                return;
            }
            InnerQueuedObserver<R> innerQueuedObserver2 = this.current;
            if (innerQueuedObserver2 == null) {
                if (errorMode == ErrorMode.BOUNDARY && this.error.get() != null) {
                    fVar.clear();
                    disposeAll();
                    sVar.onError(this.error.terminate());
                    return;
                }
                boolean z6 = this.done;
                InnerQueuedObserver<R> poll3 = arrayDeque.poll();
                boolean z8 = poll3 == null;
                if (z6 && z8) {
                    if (this.error.get() == null) {
                        sVar.onComplete();
                        return;
                    }
                    fVar.clear();
                    disposeAll();
                    sVar.onError(this.error.terminate());
                    return;
                }
                if (!z8) {
                    this.current = poll3;
                }
                innerQueuedObserver2 = poll3;
            }
            if (innerQueuedObserver2 != null) {
                yg.f queue = innerQueuedObserver2.queue();
                while (!this.cancelled) {
                    boolean isDone = innerQueuedObserver2.isDone();
                    if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                        fVar.clear();
                        disposeAll();
                        sVar.onError(this.error.terminate());
                        return;
                    }
                    try {
                        poll = queue.poll();
                        z5 = poll == null;
                    } catch (Throwable th3) {
                        ad.a(th3);
                        this.error.addThrowable(th3);
                        this.current = null;
                        this.activeCount--;
                    }
                    if (isDone && z5) {
                        this.current = null;
                        this.activeCount--;
                    } else if (!z5) {
                        sVar.onNext(poll);
                    }
                }
                fVar.clear();
                disposeAll();
                return;
            }
            i3 = addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.observers.g
    public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
        innerQueuedObserver.setDone();
        drain();
    }

    @Override // io.reactivex.internal.observers.g
    public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th2) {
        if (!this.error.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        if (this.errorMode == ErrorMode.IMMEDIATE) {
            this.f14512d.dispose();
        }
        innerQueuedObserver.setDone();
        drain();
    }

    @Override // io.reactivex.internal.observers.g
    public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r) {
        innerQueuedObserver.queue().offer(r);
        drain();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // rg.s
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (!this.error.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.done = true;
            drain();
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.sourceMode == 0) {
            this.queue.offer(t8);
        }
        drain();
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14512d, bVar)) {
            this.f14512d = bVar;
            if (bVar instanceof yg.b) {
                yg.b bVar2 = (yg.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.actual.onSubscribe(this);
                    return;
                }
            }
            this.queue = new io.reactivex.internal.queue.b(this.prefetch);
            this.actual.onSubscribe(this);
        }
    }
}
