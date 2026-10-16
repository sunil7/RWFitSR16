package wh;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class f0 {
    public static final e0 Companion = new e0();
    public static final f0 NONE = new d0();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public f0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public f0 clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final f0 deadline(long j4, TimeUnit unit) {
        kotlin.jvm.internal.e.f(unit, "unit");
        if (j4 > 0) {
            return deadlineNanoTime(unit.toNanos(j4) + System.nanoTime());
        }
        throw new IllegalArgumentException(l0.l(j4, "duration <= 0: ").toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(f0 other, oh.a block) {
        kotlin.jvm.internal.e.f(other, "other");
        kotlin.jvm.internal.e.f(block, "block");
        long timeoutNanos = timeoutNanos();
        e0 e0Var = Companion;
        long timeoutNanos2 = other.timeoutNanos();
        long timeoutNanos3 = timeoutNanos();
        e0Var.getClass();
        if (timeoutNanos2 == 0 || (timeoutNanos3 != 0 && timeoutNanos2 >= timeoutNanos3)) {
            timeoutNanos2 = timeoutNanos3;
        }
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(timeoutNanos2, timeUnit);
        if (!hasDeadline()) {
            if (other.hasDeadline()) {
                deadlineNanoTime(other.deadlineNanoTime());
            }
            try {
                block.invoke();
                timeout(timeoutNanos, timeUnit);
                if (other.hasDeadline()) {
                    clearDeadline();
                    return;
                }
                return;
            } catch (Throwable th2) {
                timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
                throw th2;
            }
        }
        long deadlineNanoTime = deadlineNanoTime();
        if (other.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), other.deadlineNanoTime()));
        }
        try {
            block.invoke();
            timeout(timeoutNanos, timeUnit);
            if (other.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime);
            }
        } catch (Throwable th3) {
            timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (other.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime);
            }
            throw th3;
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public f0 timeout(long j4, TimeUnit unit) {
        kotlin.jvm.internal.e.f(unit, "unit");
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(l0.l(j4, "timeout < 0: ").toString());
        }
        this.timeoutNanos = unit.toNanos(j4);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object monitor) throws InterruptedIOException {
        kotlin.jvm.internal.e.f(monitor, "monitor");
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            long j4 = 0;
            if (!hasDeadline && timeoutNanos == 0) {
                monitor.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos > 0) {
                long j10 = timeoutNanos / 1000000;
                monitor.wait(j10, (int) (timeoutNanos - (1000000 * j10)));
                j4 = System.nanoTime() - nanoTime;
            }
            if (j4 >= timeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public f0 deadlineNanoTime(long j4) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j4;
        return this;
    }
}
