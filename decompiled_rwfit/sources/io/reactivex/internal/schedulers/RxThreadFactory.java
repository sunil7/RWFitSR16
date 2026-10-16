package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.prefix + '-' + incrementAndGet();
        Thread eVar = this.nonBlocking ? new ca.e(runnable, str) : new Thread(runnable, str);
        eVar.setPriority(this.priority);
        eVar.setDaemon(true);
        return eVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return r5.a.f(new StringBuilder("RxThreadFactory["), this.prefix, "]");
    }

    public RxThreadFactory(String str, int i3) {
        this(str, i3, false);
    }

    public RxThreadFactory(String str, int i3, boolean z5) {
        this.prefix = str;
        this.priority = i3;
        this.nonBlocking = z5;
    }
}
