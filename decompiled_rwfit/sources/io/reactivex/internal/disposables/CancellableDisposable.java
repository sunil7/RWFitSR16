package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import ug.b;
import vg.f;

/* loaded from: classes2.dex */
public final class CancellableDisposable extends AtomicReference<f> implements b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f fVar) {
        super(fVar);
    }

    @Override // ug.b
    public void dispose() {
        if (get() != null && getAndSet(null) != null) {
            throw new ClassCastException();
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get() == null;
    }
}
