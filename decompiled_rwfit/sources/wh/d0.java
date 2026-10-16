package wh;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class d0 extends f0 {
    @Override // wh.f0
    public final f0 deadlineNanoTime(long j4) {
        return this;
    }

    @Override // wh.f0
    public final void throwIfReached() {
    }

    @Override // wh.f0
    public final f0 timeout(long j4, TimeUnit unit) {
        kotlin.jvm.internal.e.f(unit, "unit");
        return this;
    }
}
