package io.reactivex.internal.schedulers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rg.w;
import rg.x;

/* loaded from: classes2.dex */
public final class d extends x {

    /* renamed from: c, reason: collision with root package name */
    public static final b f15065c;

    /* renamed from: d, reason: collision with root package name */
    public static final RxThreadFactory f15066d;
    public static final int e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f15067f;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f15068b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int intValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (intValue > 0 && intValue <= availableProcessors) {
            availableProcessors = intValue;
        }
        e = availableProcessors;
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f15067f = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f15066d = rxThreadFactory;
        b bVar = new b(0, rxThreadFactory);
        f15065c = bVar;
        for (c cVar2 : bVar.f15063b) {
            cVar2.dispose();
        }
    }

    public d() {
        AtomicReference atomicReference;
        RxThreadFactory rxThreadFactory = f15066d;
        b bVar = f15065c;
        this.f15068b = new AtomicReference(bVar);
        b bVar2 = new b(e, rxThreadFactory);
        do {
            atomicReference = this.f15068b;
            if (atomicReference.compareAndSet(bVar, bVar2)) {
                return;
            }
        } while (atomicReference.get() == bVar);
        for (c cVar : bVar2.f15063b) {
            cVar.dispose();
        }
    }

    @Override // rg.x
    public final w a() {
        return new a(((b) this.f15068b.get()).a());
    }

    @Override // rg.x
    public final ug.b d(Runnable runnable, long j4, TimeUnit timeUnit) {
        c a3 = ((b) this.f15068b.get()).a();
        a3.getClass();
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnable);
        ScheduledExecutorService scheduledExecutorService = a3.f15091a;
        try {
            scheduledDirectTask.setFuture(j4 <= 0 ? scheduledExecutorService.submit(scheduledDirectTask) : scheduledExecutorService.schedule(scheduledDirectTask, j4, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            a1.b(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // rg.x
    public final ug.b e(Runnable runnable, long j4, long j10, TimeUnit timeUnit) {
        c a3 = ((b) this.f15068b.get()).a();
        a3.getClass();
        if (j10 > 0) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnable);
            try {
                scheduledDirectPeriodicTask.setFuture(a3.f15091a.scheduleAtFixedRate(scheduledDirectPeriodicTask, j4, j10, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e10) {
                a1.b(e10);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledExecutorService scheduledExecutorService = a3.f15091a;
        e eVar = new e(runnable, scheduledExecutorService);
        try {
            eVar.a(j4 <= 0 ? scheduledExecutorService.submit(eVar) : scheduledExecutorService.schedule(eVar, j4, timeUnit));
            return eVar;
        } catch (RejectedExecutionException e11) {
            a1.b(e11);
            return EmptyDisposable.INSTANCE;
        }
    }
}
