package t;

import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class o implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static final ef.e f18368c = new ef.e(2);

    /* renamed from: a, reason: collision with root package name */
    public final Object f18369a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f18370b;

    public o() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), f18368c);
        threadPoolExecutor.setRejectedExecutionHandler(new n());
        this.f18370b = threadPoolExecutor;
    }

    public final void a(n.i iVar) {
        ThreadPoolExecutor threadPoolExecutor;
        iVar.getClass();
        synchronized (this.f18369a) {
            try {
                if (this.f18370b.isShutdown()) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), f18368c);
                    threadPoolExecutor2.setRejectedExecutionHandler(new n());
                    this.f18370b = threadPoolExecutor2;
                }
                threadPoolExecutor = this.f18370b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int max = Math.max(1, new LinkedHashSet(iVar.f16207f).size());
        threadPoolExecutor.setMaximumPoolSize(max);
        threadPoolExecutor.setCorePoolSize(max);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        synchronized (this.f18369a) {
            this.f18370b.execute(runnable);
        }
    }
}
