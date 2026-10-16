package io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;
import ug.b;
import xg.c;

/* loaded from: classes2.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferenceDisposable(T t8) {
        super(t8);
        c.b(t8, "value is null");
    }

    @Override // ug.b
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return get() == null;
    }

    public abstract void onDisposed(T t8);
}
