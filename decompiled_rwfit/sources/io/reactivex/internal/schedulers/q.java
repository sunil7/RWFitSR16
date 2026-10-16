package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rg.w;

/* loaded from: classes2.dex */
public final class q extends w {

    /* renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue f15109a = new PriorityBlockingQueue();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f15110b = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f15111c = new AtomicInteger();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f15112d;

    @Override // rg.w
    public final ug.b a(Runnable runnable, long j4, TimeUnit timeUnit) {
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        long millis = timeUnit.toMillis(j4) + timeUnit2.convert(System.currentTimeMillis(), timeUnit2);
        return d(new o(runnable, this, millis), millis);
    }

    @Override // rg.w
    public final void b(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        d(runnable, timeUnit.convert(System.currentTimeMillis(), timeUnit));
    }

    public final ug.b d(Runnable runnable, long j4) {
        if (this.f15112d) {
            return EmptyDisposable.INSTANCE;
        }
        p pVar = new p(runnable, Long.valueOf(j4), this.f15111c.incrementAndGet());
        this.f15109a.add(pVar);
        if (this.f15110b.getAndIncrement() != 0) {
            return io.reactivex.disposables.a.a(new ia.j(5, this, pVar));
        }
        int i3 = 1;
        while (!this.f15112d) {
            p pVar2 = (p) this.f15109a.poll();
            if (pVar2 == null) {
                i3 = this.f15110b.addAndGet(-i3);
                if (i3 == 0) {
                    return EmptyDisposable.INSTANCE;
                }
            } else if (!pVar2.f15108d) {
                pVar2.f15105a.run();
            }
        }
        this.f15109a.clear();
        return EmptyDisposable.INSTANCE;
    }

    @Override // ug.b
    public final void dispose() {
        this.f15112d = true;
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f15112d;
    }
}
