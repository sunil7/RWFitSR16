package x;

import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class b extends d implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public a f19690c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedBlockingQueue f19691d = new LinkedBlockingQueue(1);
    public final CountDownLatch e = new CountDownLatch(1);

    /* renamed from: f, reason: collision with root package name */
    public ob.a f19692f;

    /* renamed from: g, reason: collision with root package name */
    public volatile ob.a f19693g;

    public b(a aVar, ob.a aVar2) {
        this.f19690c = aVar;
        aVar2.getClass();
        this.f19692f = aVar2;
    }

    public static Object c(LinkedBlockingQueue linkedBlockingQueue) {
        Object take;
        boolean z5 = false;
        while (true) {
            try {
                take = linkedBlockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th2) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    @Override // x.d, java.util.concurrent.Future
    public final boolean cancel(boolean z5) {
        boolean z6 = false;
        if (!this.f19694a.cancel(z5)) {
            return false;
        }
        while (true) {
            try {
                this.f19691d.put(Boolean.valueOf(z5));
                break;
            } catch (InterruptedException unused) {
                z6 = true;
            } catch (Throwable th2) {
                if (z6) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
        ob.a aVar = this.f19692f;
        if (aVar != null) {
            aVar.cancel(z5);
        }
        ob.a aVar2 = this.f19693g;
        if (aVar2 != null) {
            aVar2.cancel(z5);
        }
        return true;
    }

    @Override // x.d, java.util.concurrent.Future
    public final Object get() {
        if (!this.f19694a.isDone()) {
            ob.a aVar = this.f19692f;
            if (aVar != null) {
                aVar.get();
            }
            this.e.await();
            ob.a aVar2 = this.f19693g;
            if (aVar2 != null) {
                aVar2.get();
            }
        }
        return this.f19694a.get();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [ob.a, x.a] */
    /* JADX WARN: Type inference failed for: r0v1, types: [ob.a, x.a] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [ob.a, x.a] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r02;
        ?? r03 = 0;
        r03 = 0;
        r03 = 0;
        r03 = 0;
        r03 = 0;
        try {
            try {
                try {
                    try {
                        try {
                            ob.a mo0apply = this.f19690c.mo0apply(i.b(this.f19692f));
                            this.f19693g = mo0apply;
                            if (this.f19694a.isCancelled()) {
                                mo0apply.cancel(((Boolean) c(this.f19691d)).booleanValue());
                                this.f19693g = null;
                            } else {
                                mo0apply.a(new ia.j(23, this, mo0apply), a6.a());
                            }
                        } catch (Exception e) {
                            androidx.concurrent.futures.b bVar = this.f19695b;
                            r02 = r03;
                            if (bVar != null) {
                                bVar.b(e);
                                r02 = r03;
                            }
                        }
                    } catch (Error e10) {
                        androidx.concurrent.futures.b bVar2 = this.f19695b;
                        r02 = r03;
                        if (bVar2 != null) {
                            bVar2.b(e10);
                            r02 = r03;
                        }
                    }
                } finally {
                    this.f19690c = r03;
                    this.f19692f = r03;
                    this.e.countDown();
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e11) {
                Throwable cause = e11.getCause();
                androidx.concurrent.futures.b bVar3 = this.f19695b;
                if (bVar3 != null) {
                    bVar3.b(cause);
                }
            }
        } catch (UndeclaredThrowableException e12) {
            Throwable cause2 = e12.getCause();
            androidx.concurrent.futures.b bVar4 = this.f19695b;
            r02 = r03;
            if (bVar4 != null) {
                bVar4.b(cause2);
                r02 = r03;
            }
        }
    }

    @Override // x.d, java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        if (!this.f19694a.isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j4 = timeUnit2.convert(j4, timeUnit);
                timeUnit = timeUnit2;
            }
            ob.a aVar = this.f19692f;
            if (aVar != null) {
                long nanoTime = System.nanoTime();
                aVar.get(j4, timeUnit);
                j4 -= Math.max(0L, System.nanoTime() - nanoTime);
            }
            long nanoTime2 = System.nanoTime();
            if (this.e.await(j4, timeUnit)) {
                j4 -= Math.max(0L, System.nanoTime() - nanoTime2);
                ob.a aVar2 = this.f19693g;
                if (aVar2 != null) {
                    aVar2.get(j4, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return this.f19694a.get(j4, timeUnit);
    }
}
