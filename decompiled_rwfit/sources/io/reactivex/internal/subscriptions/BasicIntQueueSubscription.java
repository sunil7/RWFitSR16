package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import yg.c;

/* loaded from: classes2.dex */
public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements c, ci.c {
    private static final long serialVersionUID = -6671519529404341862L;

    public abstract /* synthetic */ void cancel();

    public abstract /* synthetic */ void clear();

    public abstract /* synthetic */ boolean isEmpty();

    @Override // yg.f
    public final boolean offer(T t8) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public abstract /* synthetic */ Object poll() throws Exception;

    public abstract /* synthetic */ void request(long j4);

    public abstract /* synthetic */ int requestFusion(int i3);

    public final boolean offer(T t8, T t10) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
