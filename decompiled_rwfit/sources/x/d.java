package x;

import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class d implements ob.a {

    /* renamed from: a, reason: collision with root package name */
    public final ob.a f19694a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.concurrent.futures.b f19695b;

    public d(ob.a aVar) {
        aVar.getClass();
        this.f19694a = aVar;
    }

    public static d b(ob.a aVar) {
        return aVar instanceof d ? (d) aVar : new d(aVar);
    }

    @Override // ob.a
    public final void a(Runnable runnable, Executor executor) {
        this.f19694a.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        return this.f19694a.cancel(z5);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.f19694a.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f19694a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f19694a.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j4, TimeUnit timeUnit) {
        return this.f19694a.get(j4, timeUnit);
    }

    public d() {
        this.f19694a = ve.a(new mc.g(this, 22));
    }
}
