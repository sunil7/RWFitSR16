package z2;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_common.p6;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class g implements ob.a {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f20200d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger e = Logger.getLogger(g.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final p6 f20201f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f20202g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f20203a;

    /* renamed from: b, reason: collision with root package name */
    public volatile b f20204b;

    /* renamed from: c, reason: collision with root package name */
    public volatile f f20205c;

    static {
        p6 eVar;
        try {
            eVar = new c(AtomicReferenceFieldUpdater.newUpdater(f.class, Thread.class, Const.INTENT_KEY_APIKEY), AtomicReferenceFieldUpdater.newUpdater(f.class, f.class, Const.INTENT_KEY_PKGNAME), AtomicReferenceFieldUpdater.newUpdater(g.class, f.class, "c"), AtomicReferenceFieldUpdater.newUpdater(g.class, b.class, Const.INTENT_KEY_PKGNAME), AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, Const.INTENT_KEY_APIKEY));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            eVar = new e();
        }
        f20201f = eVar;
        if (th != null) {
            e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f20202g = new Object();
    }

    public static void c(g gVar) {
        b bVar;
        b bVar2;
        b bVar3 = null;
        while (true) {
            f fVar = gVar.f20205c;
            if (f20201f.c(gVar, fVar, f.f20197c)) {
                while (fVar != null) {
                    Thread thread = fVar.f20198a;
                    if (thread != null) {
                        fVar.f20198a = null;
                        LockSupport.unpark(thread);
                    }
                    fVar = fVar.f20199b;
                }
                do {
                    bVar = gVar.f20204b;
                } while (!f20201f.a(gVar, bVar, b.f20187d));
                while (true) {
                    bVar2 = bVar3;
                    bVar3 = bVar;
                    if (bVar3 == null) {
                        break;
                    }
                    bVar = bVar3.f20190c;
                    bVar3.f20190c = bVar2;
                }
                while (bVar2 != null) {
                    bVar3 = bVar2.f20190c;
                    Runnable runnable = bVar2.f20188a;
                    if (runnable instanceof d) {
                        d dVar = (d) runnable;
                        gVar = dVar.f20195a;
                        if (gVar.f20203a == dVar) {
                            if (f20201f.b(gVar, dVar, f(dVar.f20196b))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        d(runnable, bVar2.f20189b);
                    }
                    bVar2 = bVar3;
                }
                return;
            }
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object e(Object obj) {
        if (obj instanceof a) {
            CancellationException cancellationException = ((a) obj).f20186b;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof androidx.work.impl.utils.futures.a) {
            throw new ExecutionException(((androidx.work.impl.utils.futures.a) obj).f3030a);
        }
        if (obj == f20202g) {
            return null;
        }
        return obj;
    }

    public static Object f(ob.a aVar) {
        if (aVar instanceof g) {
            Object obj = ((g) aVar).f20203a;
            if (!(obj instanceof a)) {
                return obj;
            }
            a aVar2 = (a) obj;
            return aVar2.f20185a ? aVar2.f20186b != null ? new a(false, aVar2.f20186b) : a.f20184d : obj;
        }
        boolean isCancelled = aVar.isCancelled();
        if ((!f20200d) && isCancelled) {
            return a.f20184d;
        }
        try {
            Object g10 = g(aVar);
            return g10 == null ? f20202g : g10;
        } catch (CancellationException e10) {
            if (isCancelled) {
                return new a(false, e10);
            }
            return new androidx.work.impl.utils.futures.a(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e10));
        } catch (ExecutionException e11) {
            return new androidx.work.impl.utils.futures.a(e11.getCause());
        } catch (Throwable th2) {
            return new androidx.work.impl.utils.futures.a(th2);
        }
    }

    public static Object g(ob.a aVar) {
        Object obj;
        boolean z5 = false;
        while (true) {
            try {
                obj = aVar.get();
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
        return obj;
    }

    @Override // ob.a
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        b bVar = this.f20204b;
        b bVar2 = b.f20187d;
        if (bVar != bVar2) {
            b bVar3 = new b(runnable, executor);
            do {
                bVar3.f20190c = bVar;
                if (f20201f.a(this, bVar, bVar3)) {
                    return;
                } else {
                    bVar = this.f20204b;
                }
            } while (bVar != bVar2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb2) {
        try {
            Object g10 = g(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(g10 == this ? "this future" : String.valueOf(g10));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z5) {
        Object obj = this.f20203a;
        if (!(obj == null) && !(obj instanceof d)) {
            return false;
        }
        a aVar = f20200d ? new a(z5, new CancellationException("Future.cancel() was called.")) : z5 ? a.f20183c : a.f20184d;
        g gVar = this;
        boolean z6 = false;
        while (true) {
            if (f20201f.b(gVar, obj, aVar)) {
                c(gVar);
                if (!(obj instanceof d)) {
                    break;
                }
                ob.a aVar2 = ((d) obj).f20196b;
                if (!(aVar2 instanceof g)) {
                    aVar2.cancel(z5);
                    break;
                }
                gVar = (g) aVar2;
                obj = gVar.f20203a;
                if (!(obj == null) && !(obj instanceof d)) {
                    break;
                }
                z6 = true;
            } else {
                obj = gVar.f20203a;
                if (!(obj instanceof d)) {
                    return z6;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        boolean z5;
        long nanos = timeUnit.toNanos(j4);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f20203a;
        if ((obj != null) && (!(obj instanceof d))) {
            return e(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            f fVar = this.f20205c;
            f fVar2 = f.f20197c;
            if (fVar != fVar2) {
                f fVar3 = new f();
                z5 = true;
                do {
                    p6 p6Var = f20201f;
                    p6Var.d(fVar3, fVar);
                    if (p6Var.c(this, fVar, fVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                i(fVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f20203a;
                            if ((obj2 != null) && (!(obj2 instanceof d))) {
                                return e(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        i(fVar3);
                    } else {
                        fVar = this.f20205c;
                    }
                } while (fVar != fVar2);
            }
            return e(this.f20203a);
        }
        z5 = true;
        while (nanos > 0) {
            Object obj3 = this.f20203a;
            if ((obj3 != null ? z5 : false) && (!(obj3 instanceof d))) {
                return e(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String gVar = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        String str = "Waited " + j4 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String l3 = android.support.v4.media.session.e.l(str, " (plus ");
            long j10 = -nanos;
            long convert = timeUnit.convert(j10, TimeUnit.NANOSECONDS);
            long nanos2 = j10 - timeUnit.toNanos(convert);
            boolean z6 = (convert == 0 || nanos2 > 1000) ? z5 : false;
            if (convert > 0) {
                String str2 = l3 + convert + " " + lowerCase;
                if (z6) {
                    str2 = android.support.v4.media.session.e.l(str2, Const.STR_MART_COMMA);
                }
                l3 = android.support.v4.media.session.e.l(str2, " ");
            }
            if (z6) {
                l3 = l3 + nanos2 + " nanoseconds ";
            }
            str = android.support.v4.media.session.e.l(l3, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(android.support.v4.media.session.e.l(str, " but future completed as timeout expired"));
        }
        throw new TimeoutException(r5.a.c(str, " for ", gVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String h() {
        Object obj = this.f20203a;
        if (obj instanceof d) {
            StringBuilder sb2 = new StringBuilder("setFuture=[");
            ob.a aVar = ((d) obj).f20196b;
            return r5.a.f(sb2, aVar == this ? "this future" : String.valueOf(aVar), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void i(f fVar) {
        fVar.f20198a = null;
        while (true) {
            f fVar2 = this.f20205c;
            if (fVar2 == f.f20197c) {
                return;
            }
            f fVar3 = null;
            while (fVar2 != null) {
                f fVar4 = fVar2.f20199b;
                if (fVar2.f20198a != null) {
                    fVar3 = fVar2;
                } else if (fVar3 != null) {
                    fVar3.f20199b = fVar4;
                    if (fVar3.f20198a == null) {
                        break;
                    }
                } else if (!f20201f.c(this, fVar2, fVar4)) {
                    break;
                }
                fVar2 = fVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f20203a instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof d)) & (this.f20203a != null);
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (this.f20203a instanceof a) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
        } else {
            try {
                str = h();
            } catch (RuntimeException e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                b(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f20203a;
            if ((obj2 != null) & (!(obj2 instanceof d))) {
                return e(obj2);
            }
            f fVar = this.f20205c;
            f fVar2 = f.f20197c;
            if (fVar != fVar2) {
                f fVar3 = new f();
                do {
                    p6 p6Var = f20201f;
                    p6Var.d(fVar3, fVar);
                    if (p6Var.c(this, fVar, fVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f20203a;
                            } else {
                                i(fVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof d))));
                        return e(obj);
                    }
                    fVar = this.f20205c;
                } while (fVar != fVar2);
            }
            return e(this.f20203a);
        }
        throw new InterruptedException();
    }
}
