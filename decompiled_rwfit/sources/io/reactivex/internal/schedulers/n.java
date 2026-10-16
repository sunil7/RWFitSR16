package io.reactivex.internal.schedulers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rg.w;
import rg.x;

/* loaded from: classes2.dex */
public final class n extends x {

    /* renamed from: c, reason: collision with root package name */
    public static final RxThreadFactory f15100c;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f15101b;

    static {
        Executors.newScheduledThreadPool(0).shutdown();
        f15100c = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public n() {
        AtomicReference atomicReference = new AtomicReference();
        this.f15101b = atomicReference;
        boolean z5 = l.f15093a;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, f15100c);
        if (l.f15093a && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            l.f15096d.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        atomicReference.lazySet(newScheduledThreadPool);
    }

    @Override // rg.x
    public final w a() {
        return new m((ScheduledExecutorService) this.f15101b.get());
    }

    @Override // rg.x
    public final ug.b d(Runnable runnable, long j4, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnable);
        AtomicReference atomicReference = this.f15101b;
        try {
            scheduledDirectTask.setFuture(j4 <= 0 ? ((ScheduledExecutorService) atomicReference.get()).submit(scheduledDirectTask) : ((ScheduledExecutorService) atomicReference.get()).schedule(scheduledDirectTask, j4, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            a1.b(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // rg.x
    public final ug.b e(Runnable runnable, long j4, long j10, TimeUnit timeUnit) {
        AtomicReference atomicReference = this.f15101b;
        if (j10 > 0) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnable);
            try {
                scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) atomicReference.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j4, j10, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e) {
                a1.b(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) atomicReference.get();
        e eVar = new e(runnable, scheduledExecutorService);
        try {
            eVar.a(j4 <= 0 ? scheduledExecutorService.submit(eVar) : scheduledExecutorService.schedule(eVar, j4, timeUnit));
            return eVar;
        } catch (RejectedExecutionException e10) {
            a1.b(e10);
            return EmptyDisposable.INSTANCE;
        }
    }
}
