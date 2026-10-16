package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class ObservableBuffer$BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements rg.s, ug.b {
    private static final long serialVersionUID = -8223395059921494546L;
    final rg.s actual;
    final Callable<U> bufferSupplier;
    final ArrayDeque<U> buffers = new ArrayDeque<>();
    final int count;
    long index;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14509s;
    final int skip;

    public ObservableBuffer$BufferSkipObserver(rg.s sVar, int i3, int i10, Callable<U> callable) {
        this.actual = sVar;
        this.count = i3;
        this.skip = i10;
        this.bufferSupplier = callable;
    }

    @Override // ug.b
    public void dispose() {
        this.f14509s.dispose();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.f14509s.isDisposed();
    }

    @Override // rg.s
    public void onComplete() {
        while (!this.buffers.isEmpty()) {
            this.actual.onNext(this.buffers.poll());
        }
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.buffers.clear();
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        long j4 = this.index;
        this.index = 1 + j4;
        if (j4 % this.skip == 0) {
            try {
                U call = this.bufferSupplier.call();
                xg.c.b(call, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                this.buffers.offer(call);
            } catch (Throwable th2) {
                this.buffers.clear();
                this.f14509s.dispose();
                this.actual.onError(th2);
                return;
            }
        }
        Iterator<U> it = this.buffers.iterator();
        while (it.hasNext()) {
            U next = it.next();
            next.add(t8);
            if (this.count <= next.size()) {
                it.remove();
                this.actual.onNext(next);
            }
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14509s, bVar)) {
            this.f14509s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
