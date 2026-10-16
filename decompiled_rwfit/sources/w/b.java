package w;

import android.os.Handler;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import n.l;
import n0.i;

/* loaded from: classes.dex */
public final class b implements RunnableScheduledFuture {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f19272a = new AtomicReference(null);

    /* renamed from: b, reason: collision with root package name */
    public final long f19273b;

    /* renamed from: c, reason: collision with root package name */
    public final Callable f19274c;

    /* renamed from: d, reason: collision with root package name */
    public final i f19275d;

    public b(Handler handler, long j4, Callable callable) {
        this.f19273b = j4;
        this.f19274c = callable;
        this.f19275d = ve.a(new l(this, 9, handler, callable));
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z5) {
        return this.f19275d.cancel(z5);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Long.compare(getDelay(timeUnit), delayed.getDelay(timeUnit));
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f19275d.f16358b.get();
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.f19273b - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f19275d.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f19275d.f16358b.isDone();
    }

    @Override // java.util.concurrent.RunnableScheduledFuture
    public final boolean isPeriodic() {
        return false;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        androidx.concurrent.futures.b bVar = (androidx.concurrent.futures.b) this.f19272a.getAndSet(null);
        if (bVar != null) {
            try {
                bVar.a(this.f19274c.call());
            } catch (Exception e) {
                bVar.b(e);
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        return this.f19275d.f16358b.get(j4, timeUnit);
    }
}
