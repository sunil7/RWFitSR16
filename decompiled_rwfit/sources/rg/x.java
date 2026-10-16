package rg;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final long f18142a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public static long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public abstract w a();

    public ug.b c(Runnable runnable) {
        return d(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public ug.b d(Runnable runnable, long j4, TimeUnit timeUnit) {
        w a3 = a();
        t tVar = new t(runnable, a3);
        a3.a(tVar, j4, timeUnit);
        return tVar;
    }

    public ug.b e(Runnable runnable, long j4, long j10, TimeUnit timeUnit) {
        w a3 = a();
        u uVar = new u(runnable, a3);
        ug.b c9 = a3.c(uVar, j4, j10, timeUnit);
        return c9 == EmptyDisposable.INSTANCE ? c9 : uVar;
    }
}
