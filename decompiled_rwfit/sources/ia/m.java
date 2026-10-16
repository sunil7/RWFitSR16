package ia;

import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import q9.n;

/* loaded from: classes.dex */
public final class m extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Object f14398a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final k f14399b = new k(0);

    /* renamed from: c, reason: collision with root package name */
    public boolean f14400c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f14401d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public Exception f14402f;

    @Override // ia.f
    public final m a(Executor executor, c cVar) {
        this.f14399b.f(new i(executor, cVar));
        k();
        return this;
    }

    @Override // ia.f
    public final m b(Executor executor, d dVar) {
        this.f14399b.f(new i(executor, dVar));
        k();
        return this;
    }

    @Override // ia.f
    public final Exception c() {
        Exception exc;
        synchronized (this.f14398a) {
            exc = this.f14402f;
        }
        return exc;
    }

    @Override // ia.f
    public final Object d() {
        Object obj;
        synchronized (this.f14398a) {
            try {
                n.g("Task is not yet complete", this.f14400c);
                if (this.f14401d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f14402f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }

    @Override // ia.f
    public final boolean e() {
        boolean z5;
        synchronized (this.f14398a) {
            z5 = this.f14400c;
        }
        return z5;
    }

    @Override // ia.f
    public final boolean f() {
        boolean z5;
        synchronized (this.f14398a) {
            try {
                z5 = false;
                if (this.f14400c && !this.f14401d && this.f14402f == null) {
                    z5 = true;
                }
            } finally {
            }
        }
        return z5;
    }

    public final void g(Exception exc) {
        n.f(exc, "Exception must not be null");
        synchronized (this.f14398a) {
            if (this.f14400c) {
                throw DuplicateTaskCompletionException.of(this);
            }
            this.f14400c = true;
            this.f14402f = exc;
        }
        this.f14399b.g(this);
    }

    public final void h(Object obj) {
        synchronized (this.f14398a) {
            if (this.f14400c) {
                throw DuplicateTaskCompletionException.of(this);
            }
            this.f14400c = true;
            this.e = obj;
        }
        this.f14399b.g(this);
    }

    public final void i() {
        synchronized (this.f14398a) {
            try {
                if (this.f14400c) {
                    return;
                }
                this.f14400c = true;
                this.f14401d = true;
                this.f14399b.g(this);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean j(Object obj) {
        synchronized (this.f14398a) {
            try {
                if (this.f14400c) {
                    return false;
                }
                this.f14400c = true;
                this.e = obj;
                this.f14399b.g(this);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void k() {
        synchronized (this.f14398a) {
            try {
                if (this.f14400c) {
                    this.f14399b.g(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
