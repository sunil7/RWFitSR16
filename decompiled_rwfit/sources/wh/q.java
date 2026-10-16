package wh;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class q extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public f0 f19658a;

    public q(f0 delegate) {
        kotlin.jvm.internal.e.f(delegate, "delegate");
        this.f19658a = delegate;
    }

    @Override // wh.f0
    public final f0 clearDeadline() {
        return this.f19658a.clearDeadline();
    }

    @Override // wh.f0
    public final f0 clearTimeout() {
        return this.f19658a.clearTimeout();
    }

    @Override // wh.f0
    public final long deadlineNanoTime() {
        return this.f19658a.deadlineNanoTime();
    }

    @Override // wh.f0
    public final boolean hasDeadline() {
        return this.f19658a.hasDeadline();
    }

    @Override // wh.f0
    public final void throwIfReached() {
        this.f19658a.throwIfReached();
    }

    @Override // wh.f0
    public final f0 timeout(long j4, TimeUnit unit) {
        kotlin.jvm.internal.e.f(unit, "unit");
        return this.f19658a.timeout(j4, unit);
    }

    @Override // wh.f0
    public final long timeoutNanos() {
        return this.f19658a.timeoutNanos();
    }

    @Override // wh.f0
    public final f0 deadlineNanoTime(long j4) {
        return this.f19658a.deadlineNanoTime(j4);
    }
}
