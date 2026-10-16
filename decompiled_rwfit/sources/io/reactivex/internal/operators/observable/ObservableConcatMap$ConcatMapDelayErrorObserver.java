package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements rg.s, ug.b {
    private static final long serialVersionUID = -6951100001833242599L;
    volatile boolean active;
    final rg.s actual;
    final int bufferSize;
    volatile boolean cancelled;

    /* renamed from: d, reason: collision with root package name */
    ug.b f14510d;
    volatile boolean done;
    final AtomicThrowable error = new AtomicThrowable();
    final vg.o mapper;
    final DelayErrorInnerObserver<R> observer;
    yg.f queue;
    int sourceMode;
    final boolean tillTheEnd;

    public static final class DelayErrorInnerObserver<R> extends AtomicReference<ug.b> implements rg.s {
        private static final long serialVersionUID = 2620149119579502636L;
        final rg.s actual;
        final ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> parent;

        public DelayErrorInnerObserver(rg.s sVar, ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> observableConcatMap$ConcatMapDelayErrorObserver) {
            this.actual = sVar;
            this.parent = observableConcatMap$ConcatMapDelayErrorObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // rg.s
        public void onComplete() {
            ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> observableConcatMap$ConcatMapDelayErrorObserver = this.parent;
            observableConcatMap$ConcatMapDelayErrorObserver.active = false;
            observableConcatMap$ConcatMapDelayErrorObserver.drain();
        }

        @Override // rg.s
        public void onError(Throwable th2) {
            ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> observableConcatMap$ConcatMapDelayErrorObserver = this.parent;
            if (!observableConcatMap$ConcatMapDelayErrorObserver.error.addThrowable(th2)) {
                com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                return;
            }
            if (!observableConcatMap$ConcatMapDelayErrorObserver.tillTheEnd) {
                observableConcatMap$ConcatMapDelayErrorObserver.f14510d.dispose();
            }
            observableConcatMap$ConcatMapDelayErrorObserver.active = false;
            observableConcatMap$ConcatMapDelayErrorObserver.drain();
        }

        @Override // rg.s
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // rg.s
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public ObservableConcatMap$ConcatMapDelayErrorObserver(rg.s sVar, vg.o oVar, int i3, boolean z5) {
        this.actual = sVar;
        this.mapper = oVar;
        this.bufferSize = i3;
        this.tillTheEnd = z5;
        this.observer = new DelayErrorInnerObserver<>(sVar, this);
    }

    @Override // ug.b
    public void dispose() {
        this.cancelled = true;
        this.f14510d.dispose();
        this.observer.dispose();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        rg.s sVar = this.actual;
        yg.f fVar = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        while (true) {
            if (!this.active) {
                if (this.cancelled) {
                    fVar.clear();
                    return;
                }
                if (!this.tillTheEnd && atomicThrowable.get() != null) {
                    fVar.clear();
                    this.cancelled = true;
                    sVar.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z5 = this.done;
                try {
                    Object poll = fVar.poll();
                    boolean z6 = poll == null;
                    if (z5 && z6) {
                        this.cancelled = true;
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate != null) {
                            sVar.onError(terminate);
                            return;
                        } else {
                            sVar.onComplete();
                            return;
                        }
                    }
                    if (!z6) {
                        try {
                            Object apply = this.mapper.apply(poll);
                            xg.c.b(apply, "The mapper returned a null ObservableSource");
                            rg.q qVar = (rg.q) apply;
                            if (qVar instanceof Callable) {
                                try {
                                    Object call = ((Callable) qVar).call();
                                    if (call != null && !this.cancelled) {
                                        sVar.onNext(call);
                                    }
                                } catch (Throwable th2) {
                                    ad.a(th2);
                                    atomicThrowable.addThrowable(th2);
                                }
                            } else {
                                this.active = true;
                                qVar.subscribe(this.observer);
                            }
                        } catch (Throwable th3) {
                            ad.a(th3);
                            this.cancelled = true;
                            this.f14510d.dispose();
                            fVar.clear();
                            atomicThrowable.addThrowable(th3);
                            sVar.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                } catch (Throwable th4) {
                    ad.a(th4);
                    this.cancelled = true;
                    this.f14510d.dispose();
                    atomicThrowable.addThrowable(th4);
                    sVar.onError(atomicThrowable.terminate());
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
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
        if (DisposableHelper.validate(this.f14510d, bVar)) {
            this.f14510d = bVar;
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
            this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
            this.actual.onSubscribe(this);
        }
    }
}
