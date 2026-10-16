package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th2) {
        return b.a(this, th2);
    }

    public boolean isTerminated() {
        return get() == b.f15123a;
    }

    public Throwable terminate() {
        Throwable th2 = b.f15123a;
        Throwable th3 = get();
        Throwable th4 = b.f15123a;
        return th3 != th4 ? getAndSet(th4) : th3;
    }
}
