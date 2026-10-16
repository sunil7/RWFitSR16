package w;

import android.os.Handler;
import android.os.SystemClock;
import ca.h;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import x.j;

/* loaded from: classes.dex */
public final class c extends AbstractExecutorService implements ScheduledExecutorService, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f19276a;

    static {
        new h(3);
    }

    public c(Handler handler) {
        this.f19276a = handler;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j4, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(c.class.getSimpleName().concat(" cannot be shut down. Use Looper.quitSafely()."));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        if (this == ForkJoinPool.commonPool()) {
            return;
        }
        shutdown();
        throw null;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Handler handler = this.f19276a;
        if (handler.post(runnable)) {
            return;
        }
        throw new RejectedExecutionException(handler + " is shutting down");
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
        return schedule(new nf.a(runnable, 1), j4, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j4, long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(c.class.getSimpleName().concat(" does not yet support fixed-rate scheduling."));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j4, long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(c.class.getSimpleName().concat(" does not yet support fixed-delay scheduling."));
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        throw new UnsupportedOperationException(c.class.getSimpleName().concat(" cannot be shut down. Use Looper.quitSafely()."));
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        throw new UnsupportedOperationException(c.class.getSimpleName().concat(" cannot be shut down. Use Looper.quitSafely()."));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Callable callable, long j4, TimeUnit timeUnit) {
        long convert = TimeUnit.MILLISECONDS.convert(j4, timeUnit) + SystemClock.uptimeMillis();
        Handler handler = this.f19276a;
        b bVar = new b(handler, convert, callable);
        if (handler.postAtTime(bVar, convert)) {
            return bVar;
        }
        return new j(new RejectedExecutionException(handler + " is shutting down"), 1);
    }
}
