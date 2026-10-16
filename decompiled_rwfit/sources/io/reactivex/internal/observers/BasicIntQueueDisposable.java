package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements yg.b {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // yg.f
    public abstract /* synthetic */ void clear();

    @Override // ug.b
    public abstract /* synthetic */ void dispose();

    @Override // ug.b
    public abstract /* synthetic */ boolean isDisposed();

    @Override // yg.f
    public abstract /* synthetic */ boolean isEmpty();

    @Override // yg.f
    public final boolean offer(T t8) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // yg.f
    public abstract /* synthetic */ Object poll() throws Exception;

    @Override // yg.c
    public abstract /* synthetic */ int requestFusion(int i3);

    public final boolean offer(T t8, T t10) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
