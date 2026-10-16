package rg;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class w implements ug.b {
    public abstract ug.b a(Runnable runnable, long j4, TimeUnit timeUnit);

    public void b(Runnable runnable) {
        a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public final ug.b c(Runnable runnable, long j4, long j10, TimeUnit timeUnit) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
        long nanos = timeUnit.toNanos(j10);
        long convert = TimeUnit.NANOSECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        ug.b a3 = a(new v(this, timeUnit.toNanos(j4) + convert, runnable, convert, sequentialDisposable2, nanos), j4, timeUnit);
        if (a3 == EmptyDisposable.INSTANCE) {
            return a3;
        }
        sequentialDisposable.replace(a3);
        return sequentialDisposable2;
    }
}
