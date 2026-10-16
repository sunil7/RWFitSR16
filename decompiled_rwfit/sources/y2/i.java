package y2;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class i implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f19957b;

    /* renamed from: d, reason: collision with root package name */
    public volatile Runnable f19959d;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f19956a = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final Object f19958c = new Object();

    public i(ExecutorService executorService) {
        this.f19957b = executorService;
    }

    public final void a() {
        synchronized (this.f19958c) {
            try {
                Runnable runnable = (Runnable) this.f19956a.poll();
                this.f19959d = runnable;
                if (runnable != null) {
                    this.f19957b.execute(this.f19959d);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f19958c) {
            try {
                this.f19956a.add(new ia.j(this, 27, runnable, false));
                if (this.f19959d == null) {
                    a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
