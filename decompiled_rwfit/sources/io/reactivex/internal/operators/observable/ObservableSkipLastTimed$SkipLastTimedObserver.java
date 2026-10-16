package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableSkipLastTimed$SkipLastTimedObserver<T> extends AtomicInteger implements rg.s, ug.b {
    private static final long serialVersionUID = -5677354903406201275L;
    final rg.s actual;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final io.reactivex.internal.queue.b queue;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14533s;
    final rg.x scheduler;
    final long time;
    final TimeUnit unit;

    public ObservableSkipLastTimed$SkipLastTimedObserver(rg.s sVar, long j4, TimeUnit timeUnit, rg.x xVar, int i3, boolean z5) {
        this.actual = sVar;
        this.time = j4;
        this.unit = timeUnit;
        this.scheduler = xVar;
        this.queue = new io.reactivex.internal.queue.b(i3);
        this.delayError = z5;
    }

    @Override // ug.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.f14533s.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        rg.s sVar = this.actual;
        io.reactivex.internal.queue.b bVar = this.queue;
        boolean z5 = this.delayError;
        TimeUnit timeUnit = this.unit;
        rg.x xVar = this.scheduler;
        long j4 = this.time;
        int i3 = 1;
        while (!this.cancelled) {
            boolean z6 = this.done;
            Long l3 = (Long) bVar.b();
            boolean z8 = l3 == null;
            xVar.getClass();
            long b3 = rg.x.b(timeUnit);
            if (!z8 && l3.longValue() > b3 - j4) {
                z8 = true;
            }
            if (z6) {
                if (!z5) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        sVar.onError(th2);
                        return;
                    } else if (z8) {
                        sVar.onComplete();
                        return;
                    }
                } else if (z8) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        sVar.onError(th3);
                        return;
                    } else {
                        sVar.onComplete();
                        return;
                    }
                }
            }
            if (z8) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                bVar.poll();
                sVar.onNext(bVar.poll());
            }
        }
        this.queue.clear();
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
        this.error = th2;
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onNext(T t8) {
        io.reactivex.internal.queue.b bVar = this.queue;
        rg.x xVar = this.scheduler;
        TimeUnit timeUnit = this.unit;
        xVar.getClass();
        bVar.a(Long.valueOf(rg.x.b(timeUnit)), t8);
        drain();
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14533s, bVar)) {
            this.f14533s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
