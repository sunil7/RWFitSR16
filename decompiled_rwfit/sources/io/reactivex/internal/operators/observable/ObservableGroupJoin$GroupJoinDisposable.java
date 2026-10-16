package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableGroupJoin$GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements ug.b, q1 {
    private static final long serialVersionUID = -6071216598687999801L;
    final rg.s actual;
    volatile boolean cancelled;
    final vg.o leftEnd;
    int leftIndex;
    final vg.c resultSelector;
    final vg.o rightEnd;
    int rightIndex;
    static final Integer LEFT_VALUE = 1;
    static final Integer RIGHT_VALUE = 2;
    static final Integer LEFT_CLOSE = 3;
    static final Integer RIGHT_CLOSE = 4;
    final ug.a disposables = new ug.a();
    final io.reactivex.internal.queue.b queue = new io.reactivex.internal.queue.b(rg.l.bufferSize());
    final Map<Integer, io.reactivex.subjects.d> lefts = new LinkedHashMap();
    final Map<Integer, TRight> rights = new LinkedHashMap();
    final AtomicReference<Throwable> error = new AtomicReference<>();
    final AtomicInteger active = new AtomicInteger(2);

    public ObservableGroupJoin$GroupJoinDisposable(rg.s sVar, vg.o oVar, vg.o oVar2, vg.c cVar) {
        this.actual = sVar;
        this.leftEnd = oVar;
        this.rightEnd = oVar2;
        this.resultSelector = cVar;
    }

    public void cancelAll() {
        this.disposables.dispose();
    }

    @Override // ug.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.internal.queue.b bVar = this.queue;
        rg.s sVar = this.actual;
        int i3 = 1;
        while (!this.cancelled) {
            if (this.error.get() != null) {
                bVar.clear();
                cancelAll();
                errorAll(sVar);
                return;
            }
            boolean z5 = this.active.get() == 0;
            Integer num = (Integer) bVar.poll();
            boolean z6 = num == null;
            if (z5 && z6) {
                Iterator<io.reactivex.subjects.d> it = this.lefts.values().iterator();
                while (it.hasNext()) {
                    it.next().onComplete();
                }
                this.lefts.clear();
                this.rights.clear();
                this.disposables.dispose();
                sVar.onComplete();
                return;
            }
            if (z6) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                Object poll = bVar.poll();
                if (num == LEFT_VALUE) {
                    io.reactivex.subjects.d dVar = new io.reactivex.subjects.d(rg.l.bufferSize());
                    int i10 = this.leftIndex;
                    this.leftIndex = i10 + 1;
                    this.lefts.put(Integer.valueOf(i10), dVar);
                    try {
                        Object apply = this.leftEnd.apply(poll);
                        xg.c.b(apply, "The leftEnd returned a null ObservableSource");
                        rg.q qVar = (rg.q) apply;
                        ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver = new ObservableGroupJoin$LeftRightEndObserver(this, true, i10);
                        this.disposables.c(observableGroupJoin$LeftRightEndObserver);
                        qVar.subscribe(observableGroupJoin$LeftRightEndObserver);
                        if (this.error.get() != null) {
                            bVar.clear();
                            cancelAll();
                            errorAll(sVar);
                            return;
                        }
                        try {
                            Object a3 = this.resultSelector.a(poll, dVar);
                            xg.c.b(a3, "The resultSelector returned a null value");
                            sVar.onNext(a3);
                            Iterator<TRight> it2 = this.rights.values().iterator();
                            while (it2.hasNext()) {
                                dVar.onNext(it2.next());
                            }
                        } catch (Throwable th2) {
                            fail(th2, sVar, bVar);
                            return;
                        }
                    } catch (Throwable th3) {
                        fail(th3, sVar, bVar);
                        return;
                    }
                } else if (num == RIGHT_VALUE) {
                    int i11 = this.rightIndex;
                    this.rightIndex = i11 + 1;
                    this.rights.put(Integer.valueOf(i11), poll);
                    try {
                        Object apply2 = this.rightEnd.apply(poll);
                        xg.c.b(apply2, "The rightEnd returned a null ObservableSource");
                        rg.q qVar2 = (rg.q) apply2;
                        ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver2 = new ObservableGroupJoin$LeftRightEndObserver(this, false, i11);
                        this.disposables.c(observableGroupJoin$LeftRightEndObserver2);
                        qVar2.subscribe(observableGroupJoin$LeftRightEndObserver2);
                        if (this.error.get() != null) {
                            bVar.clear();
                            cancelAll();
                            errorAll(sVar);
                            return;
                        } else {
                            Iterator<io.reactivex.subjects.d> it3 = this.lefts.values().iterator();
                            while (it3.hasNext()) {
                                it3.next().onNext(poll);
                            }
                        }
                    } catch (Throwable th4) {
                        fail(th4, sVar, bVar);
                        return;
                    }
                } else if (num == LEFT_CLOSE) {
                    ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver3 = (ObservableGroupJoin$LeftRightEndObserver) poll;
                    io.reactivex.subjects.d remove = this.lefts.remove(Integer.valueOf(observableGroupJoin$LeftRightEndObserver3.index));
                    this.disposables.b(observableGroupJoin$LeftRightEndObserver3);
                    if (remove != null) {
                        remove.onComplete();
                    }
                } else if (num == RIGHT_CLOSE) {
                    ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver4 = (ObservableGroupJoin$LeftRightEndObserver) poll;
                    this.rights.remove(Integer.valueOf(observableGroupJoin$LeftRightEndObserver4.index));
                    this.disposables.b(observableGroupJoin$LeftRightEndObserver4);
                }
            }
        }
        bVar.clear();
    }

    public void errorAll(rg.s sVar) {
        AtomicReference<Throwable> atomicReference = this.error;
        Throwable th2 = io.reactivex.internal.util.b.f15123a;
        Throwable th3 = atomicReference.get();
        Throwable th4 = io.reactivex.internal.util.b.f15123a;
        if (th3 != th4) {
            th3 = atomicReference.getAndSet(th4);
        }
        Iterator<io.reactivex.subjects.d> it = this.lefts.values().iterator();
        while (it.hasNext()) {
            it.next().onError(th3);
        }
        this.lefts.clear();
        this.rights.clear();
        sVar.onError(th3);
    }

    public void fail(Throwable th2, rg.s sVar, io.reactivex.internal.queue.b bVar) {
        ad.a(th2);
        io.reactivex.internal.util.b.a(this.error, th2);
        bVar.clear();
        cancelAll();
        errorAll(sVar);
    }

    @Override // io.reactivex.internal.operators.observable.q1
    public void innerClose(boolean z5, ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver) {
        synchronized (this) {
            try {
                this.queue.a(z5 ? LEFT_CLOSE : RIGHT_CLOSE, observableGroupJoin$LeftRightEndObserver);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        drain();
    }

    @Override // io.reactivex.internal.operators.observable.q1
    public void innerCloseError(Throwable th2) {
        if (io.reactivex.internal.util.b.a(this.error, th2)) {
            drain();
        } else {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        }
    }

    @Override // io.reactivex.internal.operators.observable.q1
    public void innerComplete(ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver) {
        this.disposables.a(observableGroupJoin$LeftRightObserver);
        this.active.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.observable.q1
    public void innerError(Throwable th2) {
        if (!io.reactivex.internal.util.b.a(this.error, th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.active.decrementAndGet();
            drain();
        }
    }

    @Override // io.reactivex.internal.operators.observable.q1
    public void innerValue(boolean z5, Object obj) {
        synchronized (this) {
            try {
                this.queue.a(z5 ? LEFT_VALUE : RIGHT_VALUE, obj);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        drain();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }
}
