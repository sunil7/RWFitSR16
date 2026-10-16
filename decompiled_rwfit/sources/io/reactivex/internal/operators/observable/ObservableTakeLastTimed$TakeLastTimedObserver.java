package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
final class ObservableTakeLastTimed$TakeLastTimedObserver<T> extends AtomicBoolean implements rg.s, ug.b {
    private static final long serialVersionUID = -5677354903406201275L;
    final rg.s actual;
    volatile boolean cancelled;
    final long count;

    /* renamed from: d, reason: collision with root package name */
    ug.b f14537d;
    final boolean delayError;
    Throwable error;
    final io.reactivex.internal.queue.b queue;
    final rg.x scheduler;
    final long time;
    final TimeUnit unit;

    public ObservableTakeLastTimed$TakeLastTimedObserver(rg.s sVar, long j4, long j10, TimeUnit timeUnit, rg.x xVar, int i3, boolean z5) {
        this.actual = sVar;
        this.count = j4;
        this.time = j10;
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
        this.f14537d.dispose();
        if (compareAndSet(false, true)) {
            this.queue.clear();
        }
    }

    public void drain() {
        Throwable th2;
        if (compareAndSet(false, true)) {
            rg.s sVar = this.actual;
            io.reactivex.internal.queue.b bVar = this.queue;
            boolean z5 = this.delayError;
            while (!this.cancelled) {
                if (!z5 && (th2 = this.error) != null) {
                    bVar.clear();
                    sVar.onError(th2);
                    return;
                }
                Object poll = bVar.poll();
                if (poll == null) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        sVar.onError(th3);
                        return;
                    } else {
                        sVar.onComplete();
                        return;
                    }
                }
                Object poll2 = bVar.poll();
                long longValue = ((Long) poll).longValue();
                rg.x xVar = this.scheduler;
                TimeUnit timeUnit = this.unit;
                xVar.getClass();
                if (longValue >= rg.x.b(timeUnit) - this.time) {
                    sVar.onNext(poll2);
                }
            }
            bVar.clear();
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // rg.s
    public void onComplete() {
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.error = th2;
        drain();
    }

    @Override // rg.s
    public void onNext(T t8) {
        long j4;
        long j10;
        io.reactivex.internal.queue.b bVar = this.queue;
        rg.x xVar = this.scheduler;
        TimeUnit timeUnit = this.unit;
        xVar.getClass();
        long b3 = rg.x.b(timeUnit);
        long j11 = this.time;
        long j12 = this.count;
        boolean z5 = j12 == Format.OFFSET_SAMPLE_RELATIVE;
        bVar.a(Long.valueOf(b3), t8);
        while (!bVar.isEmpty()) {
            if (((Long) bVar.b()).longValue() > b3 - j11) {
                if (z5) {
                    return;
                }
                AtomicLong atomicLong = bVar.f15057h;
                long j13 = atomicLong.get();
                while (true) {
                    j4 = bVar.f15051a.get();
                    j10 = atomicLong.get();
                    if (j13 == j10) {
                        break;
                    } else {
                        j13 = j10;
                    }
                }
                if ((((int) (j4 - j10)) >> 1) <= j12) {
                    return;
                }
            }
            bVar.poll();
            bVar.poll();
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14537d, bVar)) {
            this.f14537d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
