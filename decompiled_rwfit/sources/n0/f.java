package n0;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.ue;
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
public abstract class f implements ob.a {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f16350d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger e = Logger.getLogger(f.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final ue f16351f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f16352g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f16353a;

    /* renamed from: b, reason: collision with root package name */
    public volatile b f16354b;

    /* renamed from: c, reason: collision with root package name */
    public volatile e f16355c;

    static {
        ue dVar;
        try {
            dVar = new c(AtomicReferenceFieldUpdater.newUpdater(e.class, Thread.class, Const.INTENT_KEY_APIKEY), AtomicReferenceFieldUpdater.newUpdater(e.class, e.class, Const.INTENT_KEY_PKGNAME), AtomicReferenceFieldUpdater.newUpdater(f.class, e.class, "c"), AtomicReferenceFieldUpdater.newUpdater(f.class, b.class, Const.INTENT_KEY_PKGNAME), AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, Const.INTENT_KEY_APIKEY));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            dVar = new d();
        }
        f16351f = dVar;
        if (th != null) {
            e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f16352g = new Object();
    }

    public static void c(f fVar) {
        e eVar;
        b bVar;
        b bVar2;
        b bVar3;
        do {
            eVar = fVar.f16355c;
        } while (!f16351f.c(fVar, eVar, e.f16347c));
        while (true) {
            bVar = null;
            if (eVar == null) {
                break;
            }
            Thread thread = eVar.f16348a;
            if (thread != null) {
                eVar.f16348a = null;
                LockSupport.unpark(thread);
            }
            eVar = eVar.f16349b;
        }
        do {
            bVar2 = fVar.f16354b;
        } while (!f16351f.a(fVar, bVar2, b.f16339d));
        while (true) {
            bVar3 = bVar;
            bVar = bVar2;
            if (bVar == null) {
                break;
            }
            bVar2 = bVar.f16342c;
            bVar.f16342c = bVar3;
        }
        while (bVar3 != null) {
            b bVar4 = bVar3.f16342c;
            d(bVar3.f16340a, bVar3.f16341b);
            bVar3 = bVar4;
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
            CancellationException cancellationException = ((a) obj).f16338a;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof androidx.concurrent.futures.a) {
            throw new ExecutionException(((androidx.concurrent.futures.a) obj).f1604a);
        }
        if (obj == f16352g) {
            return null;
        }
        return obj;
    }

    public static Object f(f fVar) {
        Object obj;
        boolean z5 = false;
        while (true) {
            try {
                obj = fVar.get();
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
        b bVar = this.f16354b;
        b bVar2 = b.f16339d;
        if (bVar != bVar2) {
            b bVar3 = new b(runnable, executor);
            do {
                bVar3.f16342c = bVar;
                if (f16351f.a(this, bVar, bVar3)) {
                    return;
                } else {
                    bVar = this.f16354b;
                }
            } while (bVar != bVar2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb2) {
        try {
            Object f2 = f(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(f2 == this ? "this future" : String.valueOf(f2));
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
        Object obj = this.f16353a;
        if (obj != null) {
            return false;
        }
        if (!f16351f.b(this, obj, f16350d ? new a(z5, new CancellationException("Future.cancel() was called.")) : z5 ? a.f16336b : a.f16337c)) {
            return false;
        }
        c(this);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String g() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j4);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f16353a;
        if (obj != null) {
            return e(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            e eVar = this.f16355c;
            e eVar2 = e.f16347c;
            if (eVar != eVar2) {
                e eVar3 = new e();
                do {
                    ue ueVar = f16351f;
                    ueVar.d(eVar3, eVar);
                    if (ueVar.c(this, eVar, eVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                h(eVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f16353a;
                            if (obj2 != null) {
                                return e(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        h(eVar3);
                    } else {
                        eVar = this.f16355c;
                    }
                } while (eVar != eVar2);
            }
            return e(this.f16353a);
        }
        while (nanos > 0) {
            Object obj3 = this.f16353a;
            if (obj3 != null) {
                return e(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String fVar = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        String str = "Waited " + j4 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String l3 = android.support.v4.media.session.e.l(str, " (plus ");
            long j10 = -nanos;
            long convert = timeUnit.convert(j10, TimeUnit.NANOSECONDS);
            long nanos2 = j10 - timeUnit.toNanos(convert);
            boolean z5 = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str2 = l3 + convert + " " + lowerCase;
                if (z5) {
                    str2 = android.support.v4.media.session.e.l(str2, Const.STR_MART_COMMA);
                }
                l3 = android.support.v4.media.session.e.l(str2, " ");
            }
            if (z5) {
                l3 = l3 + nanos2 + " nanoseconds ";
            }
            str = android.support.v4.media.session.e.l(l3, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(android.support.v4.media.session.e.l(str, " but future completed as timeout expired"));
        }
        throw new TimeoutException(r5.a.c(str, " for ", fVar));
    }

    public final void h(e eVar) {
        eVar.f16348a = null;
        while (true) {
            e eVar2 = this.f16355c;
            if (eVar2 == e.f16347c) {
                return;
            }
            e eVar3 = null;
            while (eVar2 != null) {
                e eVar4 = eVar2.f16349b;
                if (eVar2.f16348a != null) {
                    eVar3 = eVar2;
                } else if (eVar3 != null) {
                    eVar3.f16349b = eVar4;
                    if (eVar3.f16348a == null) {
                        break;
                    }
                } else if (!f16351f.c(this, eVar2, eVar4)) {
                    break;
                }
                eVar2 = eVar4;
            }
            return;
        }
    }

    public boolean i(Throwable th2) {
        th2.getClass();
        if (!f16351f.b(this, null, new androidx.concurrent.futures.a(th2))) {
            return false;
        }
        c(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f16353a instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f16353a != null;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (this.f16353a instanceof a) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
        } else {
            try {
                str = g();
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
            Object obj2 = this.f16353a;
            if (obj2 != null) {
                return e(obj2);
            }
            e eVar = this.f16355c;
            e eVar2 = e.f16347c;
            if (eVar != eVar2) {
                e eVar3 = new e();
                do {
                    ue ueVar = f16351f;
                    ueVar.d(eVar3, eVar);
                    if (ueVar.c(this, eVar, eVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f16353a;
                            } else {
                                h(eVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return e(obj);
                    }
                    eVar = this.f16355c;
                } while (eVar != eVar2);
            }
            return e(this.f16353a);
        }
        throw new InterruptedException();
    }
}
