package wh;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class e extends f0 {
    public static final b Companion = new b();
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static e head;
    private boolean inQueue;
    private e next;
    private long timeoutAt;

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static final long access$remainingNanos(e eVar, long j4) {
        return eVar.timeoutAt - j4;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.inQueue = true;
            Companion.getClass();
            synchronized (e.class) {
                try {
                    if (head == null) {
                        head = new e();
                        ca.e eVar = new ca.e("Okio Watchdog");
                        eVar.setDaemon(true);
                        eVar.start();
                    }
                    long nanoTime = System.nanoTime();
                    if (timeoutNanos != 0 && hasDeadline) {
                        this.timeoutAt = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime) + nanoTime;
                    } else if (timeoutNanos != 0) {
                        this.timeoutAt = timeoutNanos + nanoTime;
                    } else {
                        if (!hasDeadline) {
                            throw new AssertionError();
                        }
                        this.timeoutAt = deadlineNanoTime();
                    }
                    long access$remainingNanos = access$remainingNanos(this, nanoTime);
                    e eVar2 = head;
                    kotlin.jvm.internal.e.c(eVar2);
                    while (eVar2.next != null) {
                        e eVar3 = eVar2.next;
                        kotlin.jvm.internal.e.c(eVar3);
                        if (access$remainingNanos < access$remainingNanos(eVar3, nanoTime)) {
                            break;
                        }
                        eVar2 = eVar2.next;
                        kotlin.jvm.internal.e.c(eVar2);
                    }
                    this.next = eVar2.next;
                    eVar2.next = this;
                    if (eVar2 == head) {
                        e.class.notify();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        Companion.getClass();
        synchronized (e.class) {
            for (e eVar = head; eVar != null; eVar = eVar.next) {
                if (eVar.next == this) {
                    eVar.next = this.next;
                    this.next = null;
                    return false;
                }
            }
            return true;
        }
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final a0 sink(a0 sink) {
        kotlin.jvm.internal.e.f(sink, "sink");
        return new c(0, this, sink);
    }

    public final c0 source(c0 source) {
        kotlin.jvm.internal.e.f(source, "source");
        return new d(0, this, source);
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(oh.a block) {
        kotlin.jvm.internal.e.f(block, "block");
        enter();
        try {
            T t8 = (T) block.invoke();
            if (exit()) {
                throw access$newTimeoutException(null);
            }
            return t8;
        } catch (IOException e) {
            if (exit()) {
                throw access$newTimeoutException(e);
            }
            throw e;
        } finally {
            exit();
        }
    }
}
