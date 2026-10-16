package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes2.dex */
final class ObservableObserveOn$ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements rg.s, Runnable {
    private static final long serialVersionUID = 6576896619930983584L;
    final rg.s actual;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    boolean outputFused;
    yg.f queue;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14522s;
    int sourceMode;
    final rg.w worker;

    public ObservableObserveOn$ObserveOnObserver(rg.s sVar, rg.w wVar, boolean z5, int i3) {
        this.actual = sVar;
        this.worker = wVar;
        this.delayError = z5;
        this.bufferSize = i3;
    }

    public boolean checkTerminated(boolean z5, boolean z6, rg.s sVar) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        }
        if (!z5) {
            return false;
        }
        Throwable th2 = this.error;
        if (this.delayError) {
            if (!z6) {
                return false;
            }
            if (th2 != null) {
                sVar.onError(th2);
            } else {
                sVar.onComplete();
            }
            this.worker.dispose();
            return true;
        }
        if (th2 != null) {
            this.queue.clear();
            sVar.onError(th2);
            this.worker.dispose();
            return true;
        }
        if (!z6) {
            return false;
        }
        sVar.onComplete();
        this.worker.dispose();
        return true;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public void clear() {
        this.queue.clear();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.f14522s.dispose();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drainFused() {
        int i3 = 1;
        while (!this.cancelled) {
            boolean z5 = this.done;
            Throwable th2 = this.error;
            if (!this.delayError && z5 && th2 != null) {
                this.actual.onError(th2);
                this.worker.dispose();
                return;
            }
            this.actual.onNext(null);
            if (z5) {
                Throwable th3 = this.error;
                if (th3 != null) {
                    this.actual.onError(th3);
                } else {
                    this.actual.onComplete();
                }
                this.worker.dispose();
                return;
            }
            i3 = addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        r3 = addAndGet(-r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r3 != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drainNormal() {
        /*
            r7 = this;
            yg.f r0 = r7.queue
            rg.s r1 = r7.actual
            r2 = 1
            r3 = r2
        L6:
            boolean r4 = r7.done
            boolean r5 = r0.isEmpty()
            boolean r4 = r7.checkTerminated(r4, r5, r1)
            if (r4 == 0) goto L13
            goto L2e
        L13:
            boolean r4 = r7.done
            java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
            if (r5 != 0) goto L1d
            r6 = r2
            goto L1e
        L1d:
            r6 = 0
        L1e:
            boolean r4 = r7.checkTerminated(r4, r6, r1)
            if (r4 == 0) goto L25
            goto L2e
        L25:
            if (r6 == 0) goto L2f
            int r3 = -r3
            int r3 = r7.addAndGet(r3)
            if (r3 != 0) goto L6
        L2e:
            return
        L2f:
            r1.onNext(r5)
            goto L13
        L33:
            r2 = move-exception
            com.google.android.gms.internal.mlkit_vision_barcode.ad.a(r2)
            ug.b r3 = r7.f14522s
            r3.dispose()
            r0.clear()
            r1.onError(r2)
            rg.w r0 = r7.worker
            r0.dispose()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver.drainNormal():void");
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // rg.s
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        schedule();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.done) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        schedule();
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.done) {
            return;
        }
        if (this.sourceMode != 2) {
            this.queue.offer(t8);
        }
        schedule();
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14522s, bVar)) {
            this.f14522s = bVar;
            if (bVar instanceof yg.b) {
                yg.b bVar2 = (yg.b) bVar;
                int requestFusion = bVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    schedule();
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

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public T poll() throws Exception {
        return (T) this.queue.poll();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.c
    public int requestFusion(int i3) {
        if ((i3 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.outputFused) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    public void schedule() {
        if (getAndIncrement() == 0) {
            this.worker.b(this);
        }
    }
}
