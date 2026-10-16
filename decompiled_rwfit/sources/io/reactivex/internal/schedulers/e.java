package io.reactivex.internal.schedulers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class e implements Callable, ug.b {

    /* renamed from: f, reason: collision with root package name */
    public static final FutureTask f15069f = new FutureTask(io.reactivex.internal.functions.a.f14443b, null);

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f15070a;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f15073d;
    public Thread e;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f15072c = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f15071b = new AtomicReference();

    public e(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        this.f15070a = runnable;
        this.f15073d = scheduledExecutorService;
    }

    public final void a(Future future) {
        while (true) {
            AtomicReference atomicReference = this.f15072c;
            Future future2 = (Future) atomicReference.get();
            if (future2 == f15069f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
            while (!atomicReference.compareAndSet(future2, future)) {
                if (atomicReference.get() != future2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.e = Thread.currentThread();
        try {
            this.f15070a.run();
            Future submit = this.f15073d.submit(this);
            loop0: while (true) {
                AtomicReference atomicReference = this.f15071b;
                Future future = (Future) atomicReference.get();
                if (future != f15069f) {
                    while (!atomicReference.compareAndSet(future, submit)) {
                        if (atomicReference.get() != future) {
                            break;
                        }
                    }
                    break loop0;
                }
                submit.cancel(this.e != Thread.currentThread());
            }
            this.e = null;
            return null;
        } catch (Throwable th2) {
            this.e = null;
            a1.b(th2);
            return null;
        }
    }

    @Override // ug.b
    public final void dispose() {
        AtomicReference atomicReference = this.f15072c;
        FutureTask futureTask = f15069f;
        Future future = (Future) atomicReference.getAndSet(futureTask);
        if (future != null && future != futureTask) {
            future.cancel(this.e != Thread.currentThread());
        }
        Future future2 = (Future) this.f15071b.getAndSet(futureTask);
        if (future2 == null || future2 == futureTask) {
            return;
        }
        future2.cancel(this.e != Thread.currentThread());
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f15072c.get() == f15069f;
    }
}
