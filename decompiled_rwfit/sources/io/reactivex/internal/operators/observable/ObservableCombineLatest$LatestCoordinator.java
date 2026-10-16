package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements ug.b {
    private static final long serialVersionUID = 8567835998786448817L;
    int active;
    final rg.s actual;
    volatile boolean cancelled;
    final vg.o combiner;
    int complete;
    final boolean delayError;
    volatile boolean done;
    final AtomicThrowable errors = new AtomicThrowable();
    Object[] latest;
    final ObservableCombineLatest$CombinerObserver<T, R>[] observers;
    final io.reactivex.internal.queue.b queue;

    public ObservableCombineLatest$LatestCoordinator(rg.s sVar, vg.o oVar, int i3, int i10, boolean z5) {
        this.actual = sVar;
        this.combiner = oVar;
        this.delayError = z5;
        this.latest = new Object[i3];
        ObservableCombineLatest$CombinerObserver<T, R>[] observableCombineLatest$CombinerObserverArr = new ObservableCombineLatest$CombinerObserver[i3];
        for (int i11 = 0; i11 < i3; i11++) {
            observableCombineLatest$CombinerObserverArr[i11] = new ObservableCombineLatest$CombinerObserver<>(this, i11);
        }
        this.observers = observableCombineLatest$CombinerObserverArr;
        this.queue = new io.reactivex.internal.queue.b(i10);
    }

    public void cancelSources() {
        for (ObservableCombineLatest$CombinerObserver<T, R> observableCombineLatest$CombinerObserver : this.observers) {
            observableCombineLatest$CombinerObserver.dispose();
        }
    }

    public void clear(io.reactivex.internal.queue.b bVar) {
        synchronized (this) {
            this.latest = null;
        }
        bVar.clear();
    }

    @Override // ug.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelSources();
        if (getAndIncrement() == 0) {
            clear(this.queue);
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.internal.queue.b bVar = this.queue;
        rg.s sVar = this.actual;
        boolean z5 = this.delayError;
        int i3 = 1;
        while (!this.cancelled) {
            if (!z5 && this.errors.get() != null) {
                cancelSources();
                clear(bVar);
                sVar.onError(this.errors.terminate());
                return;
            }
            boolean z6 = this.done;
            Object[] objArr = (Object[]) bVar.poll();
            boolean z8 = objArr == null;
            if (z6 && z8) {
                clear(bVar);
                Throwable terminate = this.errors.terminate();
                if (terminate == null) {
                    sVar.onComplete();
                    return;
                } else {
                    sVar.onError(terminate);
                    return;
                }
            }
            if (z8) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                try {
                    Object apply = this.combiner.apply(objArr);
                    xg.c.b(apply, "The combiner returned a null value");
                    sVar.onNext(apply);
                } catch (Throwable th2) {
                    ad.a(th2);
                    this.errors.addThrowable(th2);
                    cancelSources();
                    clear(bVar);
                    sVar.onError(this.errors.terminate());
                    return;
                }
            }
        }
        clear(bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        if (r2 == r0.length) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void innerComplete(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.Object[] r0 = r3.latest     // Catch: java.lang.Throwable -> L7
            if (r0 != 0) goto L9
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7
            return
        L7:
            r4 = move-exception
            goto L27
        L9:
            r4 = r0[r4]     // Catch: java.lang.Throwable -> L7
            r1 = 1
            if (r4 != 0) goto L10
            r4 = r1
            goto L11
        L10:
            r4 = 0
        L11:
            if (r4 != 0) goto L1b
            int r2 = r3.complete     // Catch: java.lang.Throwable -> L7
            int r2 = r2 + r1
            r3.complete = r2     // Catch: java.lang.Throwable -> L7
            int r0 = r0.length     // Catch: java.lang.Throwable -> L7
            if (r2 != r0) goto L1d
        L1b:
            r3.done = r1     // Catch: java.lang.Throwable -> L7
        L1d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7
            if (r4 == 0) goto L23
            r3.cancelSources()
        L23:
            r3.drain()
            return
        L27:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator.innerComplete(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        if (r1 == r4.length) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void innerError(int r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            io.reactivex.internal.util.AtomicThrowable r0 = r2.errors
            boolean r0 = r0.addThrowable(r4)
            if (r0 == 0) goto L37
            boolean r4 = r2.delayError
            r0 = 1
            if (r4 == 0) goto L2e
            monitor-enter(r2)
            java.lang.Object[] r4 = r2.latest     // Catch: java.lang.Throwable -> L14
            if (r4 != 0) goto L16
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            return
        L14:
            r3 = move-exception
            goto L2c
        L16:
            r3 = r4[r3]     // Catch: java.lang.Throwable -> L14
            if (r3 != 0) goto L1c
            r3 = r0
            goto L1d
        L1c:
            r3 = 0
        L1d:
            if (r3 != 0) goto L27
            int r1 = r2.complete     // Catch: java.lang.Throwable -> L14
            int r1 = r1 + r0
            r2.complete = r1     // Catch: java.lang.Throwable -> L14
            int r4 = r4.length     // Catch: java.lang.Throwable -> L14
            if (r1 != r4) goto L29
        L27:
            r2.done = r0     // Catch: java.lang.Throwable -> L14
        L29:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            r0 = r3
            goto L2e
        L2c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            throw r3
        L2e:
            if (r0 == 0) goto L33
            r2.cancelSources()
        L33:
            r2.drain()
            return
        L37:
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator.innerError(int, java.lang.Throwable):void");
    }

    public void innerNext(int i3, T t8) {
        boolean z5;
        synchronized (this) {
            try {
                Object[] objArr = this.latest;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i3];
                int i10 = this.active;
                if (obj == null) {
                    i10++;
                    this.active = i10;
                }
                objArr[i3] = t8;
                if (i10 == objArr.length) {
                    this.queue.offer(objArr.clone());
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    drain();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(rg.q[] qVarArr) {
        ObservableCombineLatest$CombinerObserver<T, R>[] observableCombineLatest$CombinerObserverArr = this.observers;
        int length = observableCombineLatest$CombinerObserverArr.length;
        this.actual.onSubscribe(this);
        for (int i3 = 0; i3 < length && !this.done && !this.cancelled; i3++) {
            qVarArr[i3].subscribe(observableCombineLatest$CombinerObserverArr[i3]);
        }
    }
}
