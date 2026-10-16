package n0;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class i implements ob.a {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f16357a;

    /* renamed from: b, reason: collision with root package name */
    public final h f16358b = new h(this);

    public i(androidx.concurrent.futures.b bVar) {
        this.f16357a = new WeakReference(bVar);
    }

    @Override // ob.a
    public final void a(Runnable runnable, Executor executor) {
        this.f16358b.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z5) {
        androidx.concurrent.futures.b bVar = (androidx.concurrent.futures.b) this.f16357a.get();
        boolean cancel = this.f16358b.cancel(z5);
        if (cancel && bVar != null) {
            bVar.f1605a = null;
            bVar.f1606b = null;
            bVar.f1607c.j(null);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f16358b.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f16358b.f16353a instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f16358b.isDone();
    }

    public final String toString() {
        return this.f16358b.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        return this.f16358b.get(j4, timeUnit);
    }
}
