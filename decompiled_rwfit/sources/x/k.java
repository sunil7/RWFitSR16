package x;

import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class k implements ob.a {

    /* renamed from: c, reason: collision with root package name */
    public static final k f19707c = new k(null, 0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19708a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19709b;

    public /* synthetic */ k(Object obj, int i3) {
        this.f19708a = i3;
        this.f19709b = obj;
    }

    @Override // ob.a
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            a0.c("ImmediateFuture", "Experienced RuntimeException while attempting to notify " + runnable + " on Executor " + executor, e);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z5) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        switch (this.f19708a) {
            case 0:
                return this.f19709b;
            default:
                throw new ExecutionException((Throwable) this.f19709b);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        switch (this.f19708a) {
            case 0:
                return super.toString() + "[status=SUCCESS, result=[" + this.f19709b + "]]";
            default:
                return super.toString() + "[status=FAILURE, cause=[" + ((Throwable) this.f19709b) + "]]";
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        timeUnit.getClass();
        return get();
    }
}
