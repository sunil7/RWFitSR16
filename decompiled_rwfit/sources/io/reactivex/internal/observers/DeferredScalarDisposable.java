package io.reactivex.internal.observers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import rg.s;

/* loaded from: classes2.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final s actual;
    protected T value;

    public DeferredScalarDisposable(s sVar) {
        this.actual = sVar;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t8) {
        int i3 = get();
        if ((i3 & 54) != 0) {
            return;
        }
        s sVar = this.actual;
        if (i3 == 8) {
            this.value = t8;
            lazySet(16);
            sVar.onNext(null);
        } else {
            lazySet(2);
            sVar.onNext(t8);
        }
        if (get() != 4) {
            sVar.onComplete();
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable th2) {
        if ((get() & 54) != 0) {
            a1.b(th2);
        } else {
            lazySet(2);
            this.actual.onError(th2);
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t8 = this.value;
        this.value = null;
        lazySet(32);
        return t8;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.c
    public final int requestFusion(int i3) {
        if ((i3 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }

    public final void complete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.actual.onComplete();
    }
}
