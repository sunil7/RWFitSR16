package io.reactivex.internal.schedulers;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rg.w;
import rg.x;

/* loaded from: classes2.dex */
public final class i extends x {

    /* renamed from: c, reason: collision with root package name */
    public static final RxThreadFactory f15084c;

    /* renamed from: d, reason: collision with root package name */
    public static final RxThreadFactory f15085d;
    public static final TimeUnit e = TimeUnit.SECONDS;

    /* renamed from: f, reason: collision with root package name */
    public static final h f15086f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f15087g;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f15088b;

    static {
        h hVar = new h(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f15086f = hVar;
        hVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        f15084c = rxThreadFactory;
        f15085d = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        f fVar = new f(0L, null, rxThreadFactory);
        f15087g = fVar;
        fVar.f15076c.dispose();
        ScheduledFuture scheduledFuture = fVar.e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = fVar.f15077d;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public i() {
        AtomicReference atomicReference;
        RxThreadFactory rxThreadFactory = f15084c;
        f fVar = f15087g;
        this.f15088b = new AtomicReference(fVar);
        f fVar2 = new f(60L, e, rxThreadFactory);
        do {
            atomicReference = this.f15088b;
            if (atomicReference.compareAndSet(fVar, fVar2)) {
                return;
            }
        } while (atomicReference.get() == fVar);
        fVar2.f15076c.dispose();
        ScheduledFuture scheduledFuture = fVar2.e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = fVar2.f15077d;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override // rg.x
    public final w a() {
        return new g((f) this.f15088b.get());
    }
}
