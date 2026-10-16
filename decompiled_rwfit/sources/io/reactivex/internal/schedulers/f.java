package io.reactivex.internal.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f15074a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f15075b;

    /* renamed from: c, reason: collision with root package name */
    public final ug.a f15076c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f15077d;
    public final ScheduledFuture e;

    /* renamed from: f, reason: collision with root package name */
    public final RxThreadFactory f15078f;

    public f(long j4, TimeUnit timeUnit, RxThreadFactory rxThreadFactory) {
        f fVar;
        ScheduledExecutorService scheduledExecutorService;
        ScheduledFuture<?> scheduledFuture;
        long nanos = timeUnit != null ? timeUnit.toNanos(j4) : 0L;
        this.f15074a = nanos;
        this.f15075b = new ConcurrentLinkedQueue();
        this.f15076c = new ug.a();
        this.f15078f = rxThreadFactory;
        if (timeUnit != null) {
            scheduledExecutorService = Executors.newScheduledThreadPool(1, i.f15085d);
            fVar = this;
            scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(fVar, nanos, nanos, TimeUnit.NANOSECONDS);
        } else {
            fVar = this;
            scheduledExecutorService = null;
            scheduledFuture = null;
        }
        fVar.f15077d = scheduledExecutorService;
        fVar.e = scheduledFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f15075b;
        if (concurrentLinkedQueue.isEmpty()) {
            return;
        }
        long nanoTime = System.nanoTime();
        Iterator it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (hVar.f15083c > nanoTime) {
                return;
            }
            if (concurrentLinkedQueue.remove(hVar)) {
                this.f15076c.b(hVar);
            }
        }
    }
}
