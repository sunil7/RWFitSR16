package io.reactivex.internal.schedulers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import rg.w;

/* loaded from: classes2.dex */
public class k extends w {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f15091a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f15092b;

    public k(RxThreadFactory rxThreadFactory) {
        boolean z5 = l.f15093a;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, rxThreadFactory);
        if (l.f15093a && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            l.f15096d.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        this.f15091a = newScheduledThreadPool;
    }

    @Override // rg.w
    public final ug.b a(Runnable runnable, long j4, TimeUnit timeUnit) {
        return this.f15092b ? EmptyDisposable.INSTANCE : d(runnable, j4, timeUnit, null);
    }

    @Override // rg.w
    public final void b(Runnable runnable) {
        a(runnable, 0L, null);
    }

    public final ScheduledRunnable d(Runnable runnable, long j4, TimeUnit timeUnit, wg.a aVar) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(runnable, aVar);
        if (aVar == null || aVar.c(scheduledRunnable)) {
            ScheduledExecutorService scheduledExecutorService = this.f15091a;
            try {
                scheduledRunnable.setFuture(j4 <= 0 ? scheduledExecutorService.submit((Callable) scheduledRunnable) : scheduledExecutorService.schedule((Callable) scheduledRunnable, j4, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e) {
                if (aVar != null) {
                    aVar.b(scheduledRunnable);
                }
                a1.b(e);
            }
        }
        return scheduledRunnable;
    }

    @Override // ug.b
    public final void dispose() {
        if (this.f15092b) {
            return;
        }
        this.f15092b = true;
        this.f15091a.shutdownNow();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f15092b;
    }
}
