package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableFlatMap$MergeObserver<T, U> extends AtomicInteger implements ug.b, rg.s {
    private static final long serialVersionUID = -2117620485640801370L;
    final rg.s actual;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final AtomicThrowable errors = new AtomicThrowable();
    long lastId;
    int lastIndex;
    final vg.o mapper;
    final int maxConcurrency;
    final AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> observers;
    volatile yg.e queue;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14516s;
    Queue<rg.q> sources;
    long uniqueId;
    int wip;
    static final ObservableFlatMap$InnerObserver<?, ?>[] EMPTY = new ObservableFlatMap$InnerObserver[0];
    static final ObservableFlatMap$InnerObserver<?, ?>[] CANCELLED = new ObservableFlatMap$InnerObserver[0];

    public ObservableFlatMap$MergeObserver(rg.s sVar, vg.o oVar, boolean z5, int i3, int i10) {
        this.actual = sVar;
        this.mapper = oVar;
        this.delayErrors = z5;
        this.maxConcurrency = i3;
        this.bufferSize = i10;
        if (i3 != Integer.MAX_VALUE) {
            this.sources = new ArrayDeque(i3);
        }
        this.observers = new AtomicReference<>(EMPTY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean addInner(ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver) {
        while (true) {
            ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr = this.observers.get();
            if (observableFlatMap$InnerObserverArr == CANCELLED) {
                observableFlatMap$InnerObserver.dispose();
                return false;
            }
            int length = observableFlatMap$InnerObserverArr.length;
            ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArr2 = new ObservableFlatMap$InnerObserver[length + 1];
            System.arraycopy(observableFlatMap$InnerObserverArr, 0, observableFlatMap$InnerObserverArr2, 0, length);
            observableFlatMap$InnerObserverArr2[length] = observableFlatMap$InnerObserver;
            AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> atomicReference = this.observers;
            while (!atomicReference.compareAndSet(observableFlatMap$InnerObserverArr, observableFlatMap$InnerObserverArr2)) {
                if (atomicReference.get() != observableFlatMap$InnerObserverArr) {
                    break;
                }
            }
            return true;
        }
    }

    public boolean checkTerminate() {
        if (this.cancelled) {
            return true;
        }
        Throwable th2 = this.errors.get();
        if (this.delayErrors || th2 == null) {
            return false;
        }
        disposeAll();
        Throwable terminate = this.errors.terminate();
        if (terminate != io.reactivex.internal.util.b.f15123a) {
            this.actual.onError(terminate);
        }
        return true;
    }

    @Override // ug.b
    public void dispose() {
        Throwable terminate;
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        if (!disposeAll() || (terminate = this.errors.terminate()) == null || terminate == io.reactivex.internal.util.b.f15123a) {
            return;
        }
        com.google.android.gms.internal.mlkit_vision_barcode.a1.b(terminate);
    }

    public boolean disposeAll() {
        ObservableFlatMap$InnerObserver<?, ?>[] andSet;
        this.f14516s.dispose();
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr = this.observers.get();
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr2 = CANCELLED;
        if (observableFlatMap$InnerObserverArr == observableFlatMap$InnerObserverArr2 || (andSet = this.observers.getAndSet(observableFlatMap$InnerObserverArr2)) == observableFlatMap$InnerObserverArr2) {
            return false;
        }
        for (ObservableFlatMap$InnerObserver<?, ?> observableFlatMap$InnerObserver : andSet) {
            observableFlatMap$InnerObserver.dispose();
        }
        return true;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drainLoop() {
        int i3;
        rg.s sVar = this.actual;
        int i10 = 1;
        while (!checkTerminate()) {
            yg.e eVar = this.queue;
            if (eVar != null) {
                while (!checkTerminate()) {
                    Object poll = eVar.poll();
                    if (poll != null) {
                        sVar.onNext(poll);
                    } else if (poll == null) {
                    }
                }
                return;
            }
            boolean z5 = this.done;
            yg.e eVar2 = this.queue;
            ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr = this.observers.get();
            int length = observableFlatMap$InnerObserverArr.length;
            boolean z6 = false;
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                synchronized (this) {
                    i3 = this.sources.size();
                }
            } else {
                i3 = 0;
            }
            if (z5 && ((eVar2 == null || eVar2.isEmpty()) && length == 0 && i3 == 0)) {
                Throwable terminate = this.errors.terminate();
                if (terminate != io.reactivex.internal.util.b.f15123a) {
                    if (terminate == null) {
                        sVar.onComplete();
                        return;
                    } else {
                        sVar.onError(terminate);
                        return;
                    }
                }
                return;
            }
            if (length != 0) {
                long j4 = this.lastId;
                int i11 = this.lastIndex;
                if (length <= i11 || observableFlatMap$InnerObserverArr[i11].f14515id != j4) {
                    if (length <= i11) {
                        i11 = 0;
                    }
                    for (int i12 = 0; i12 < length && observableFlatMap$InnerObserverArr[i11].f14515id != j4; i12++) {
                        i11++;
                        if (i11 == length) {
                            i11 = 0;
                        }
                    }
                    this.lastIndex = i11;
                    this.lastId = observableFlatMap$InnerObserverArr[i11].f14515id;
                }
                int i13 = 0;
                boolean z8 = false;
                while (i13 < length) {
                    if (checkTerminate()) {
                        return;
                    }
                    ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver = observableFlatMap$InnerObserverArr[i11];
                    while (!checkTerminate()) {
                        yg.f fVar = observableFlatMap$InnerObserver.queue;
                        if (fVar != null) {
                            do {
                                try {
                                    Object poll2 = fVar.poll();
                                    if (poll2 != null) {
                                        sVar.onNext(poll2);
                                    } else if (poll2 == null) {
                                    }
                                } catch (Throwable th2) {
                                    ad.a(th2);
                                    observableFlatMap$InnerObserver.dispose();
                                    this.errors.addThrowable(th2);
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    removeInner(observableFlatMap$InnerObserver);
                                    i13++;
                                    z8 = true;
                                }
                            } while (!checkTerminate());
                            return;
                        }
                        boolean z10 = observableFlatMap$InnerObserver.done;
                        yg.f fVar2 = observableFlatMap$InnerObserver.queue;
                        if (z10 && (fVar2 == null || fVar2.isEmpty())) {
                            removeInner(observableFlatMap$InnerObserver);
                            if (checkTerminate()) {
                                return;
                            } else {
                                z8 = true;
                            }
                        }
                        i11++;
                        if (i11 == length) {
                            i11 = 0;
                        }
                        i13++;
                    }
                    return;
                }
                this.lastIndex = i11;
                this.lastId = observableFlatMap$InnerObserverArr[i11].f14515id;
                z6 = z8;
            }
            if (!z6) {
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                synchronized (this) {
                    try {
                        rg.q poll3 = this.sources.poll();
                        if (poll3 == null) {
                            this.wip--;
                        } else {
                            subscribeInner(poll3);
                        }
                    } finally {
                    }
                }
            } else {
                continue;
            }
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // rg.s
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.done) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else if (!this.errors.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.done = true;
            drain();
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.done) {
            return;
        }
        try {
            Object apply = this.mapper.apply(t8);
            xg.c.b(apply, "The mapper returned a null ObservableSource");
            rg.q qVar = (rg.q) apply;
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                synchronized (this) {
                    try {
                        int i3 = this.wip;
                        if (i3 == this.maxConcurrency) {
                            this.sources.offer(qVar);
                            return;
                        }
                        this.wip = i3 + 1;
                    } finally {
                    }
                }
            }
            subscribeInner(qVar);
        } catch (Throwable th2) {
            ad.a(th2);
            this.f14516s.dispose();
            onError(th2);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14516s, bVar)) {
            this.f14516s = bVar;
            this.actual.onSubscribe(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeInner(ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver) {
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr;
        while (true) {
            ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr2 = this.observers.get();
            int length = observableFlatMap$InnerObserverArr2.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (observableFlatMap$InnerObserverArr2[i3] == observableFlatMap$InnerObserver) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                observableFlatMap$InnerObserverArr = EMPTY;
            } else {
                ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr3 = new ObservableFlatMap$InnerObserver[length - 1];
                System.arraycopy(observableFlatMap$InnerObserverArr2, 0, observableFlatMap$InnerObserverArr3, 0, i3);
                System.arraycopy(observableFlatMap$InnerObserverArr2, i3 + 1, observableFlatMap$InnerObserverArr3, i3, (length - i3) - 1);
                observableFlatMap$InnerObserverArr = observableFlatMap$InnerObserverArr3;
            }
            AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> atomicReference = this.observers;
            while (!atomicReference.compareAndSet(observableFlatMap$InnerObserverArr2, observableFlatMap$InnerObserverArr)) {
                if (atomicReference.get() != observableFlatMap$InnerObserverArr2) {
                    break;
                }
            }
            return;
        }
    }

    public void subscribeInner(rg.q qVar) {
        boolean z5;
        while (qVar instanceof Callable) {
            if (!tryEmitScalar((Callable) qVar) || this.maxConcurrency == Integer.MAX_VALUE) {
                return;
            }
            synchronized (this) {
                try {
                    qVar = this.sources.poll();
                    if (qVar == null) {
                        z5 = true;
                        this.wip--;
                    } else {
                        z5 = false;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z5) {
                drain();
                return;
            }
        }
        long j4 = this.uniqueId;
        this.uniqueId = 1 + j4;
        ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver = new ObservableFlatMap$InnerObserver<>(this, j4);
        if (addInner(observableFlatMap$InnerObserver)) {
            qVar.subscribe(observableFlatMap$InnerObserver);
        }
    }

    public void tryEmit(U u10, ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver) {
        if (get() == 0 && compareAndSet(0, 1)) {
            this.actual.onNext(u10);
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            yg.f fVar = observableFlatMap$InnerObserver.queue;
            if (fVar == null) {
                fVar = new io.reactivex.internal.queue.b(this.bufferSize);
                observableFlatMap$InnerObserver.queue = fVar;
            }
            fVar.offer(u10);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    public boolean tryEmitScalar(Callable<? extends U> callable) {
        try {
            U call = callable.call();
            if (call == null) {
                return true;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(call);
                if (decrementAndGet() == 0) {
                    return true;
                }
            } else {
                yg.e eVar = this.queue;
                if (eVar == null) {
                    eVar = this.maxConcurrency == Integer.MAX_VALUE ? new io.reactivex.internal.queue.b(this.bufferSize) : new SpscArrayQueue(this.maxConcurrency);
                    this.queue = eVar;
                }
                if (!eVar.offer(call)) {
                    onError(new IllegalStateException("Scalar queue full?!"));
                    return true;
                }
                if (getAndIncrement() != 0) {
                    return false;
                }
            }
            drainLoop();
            return true;
        } catch (Throwable th2) {
            ad.a(th2);
            this.errors.addThrowable(th2);
            drain();
            return true;
        }
    }
}
