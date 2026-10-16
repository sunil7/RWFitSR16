package io.reactivex.internal.operators.mixed;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rg.g;
import rg.h;
import rg.i;
import rg.s;
import vg.o;

/* loaded from: classes2.dex */
final class ObservableConcatMapMaybe$ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements s, ug.b {
    static final int STATE_ACTIVE = 1;
    static final int STATE_INACTIVE = 0;
    static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    volatile boolean cancelled;
    volatile boolean done;
    final s downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors = new AtomicThrowable();
    final ConcatMapMaybeObserver<R> inner = new ConcatMapMaybeObserver<>(this);
    R item;
    final o mapper;
    final yg.e queue;
    volatile int state;
    ug.b upstream;

    public static final class ConcatMapMaybeObserver<R> extends AtomicReference<ug.b> implements h {
        private static final long serialVersionUID = -3051469169682093892L;
        final ObservableConcatMapMaybe$ConcatMapMaybeMainObserver<?, R> parent;

        public ConcatMapMaybeObserver(ObservableConcatMapMaybe$ConcatMapMaybeMainObserver<?, R> observableConcatMapMaybe$ConcatMapMaybeMainObserver) {
            this.parent = observableConcatMapMaybe$ConcatMapMaybeMainObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // rg.h
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // rg.h
        public void onError(Throwable th2) {
            this.parent.innerError(th2);
        }

        @Override // rg.h
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // rg.h
        public void onSuccess(R r) {
            this.parent.innerSuccess(r);
        }
    }

    public ObservableConcatMapMaybe$ConcatMapMaybeMainObserver(s sVar, o oVar, int i3, ErrorMode errorMode) {
        this.downstream = sVar;
        this.mapper = oVar;
        this.errorMode = errorMode;
        this.queue = new io.reactivex.internal.queue.b(i3);
    }

    @Override // ug.b
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.inner.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
            this.item = null;
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        s sVar = this.downstream;
        ErrorMode errorMode = this.errorMode;
        yg.e eVar = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        int i3 = 1;
        while (true) {
            if (this.cancelled) {
                eVar.clear();
                this.item = null;
            }
            int i10 = this.state;
            if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i10 != 0))) {
                if (i10 == 0) {
                    boolean z5 = this.done;
                    Object poll = eVar.poll();
                    boolean z6 = poll == null;
                    if (z5 && z6) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate == null) {
                            sVar.onComplete();
                            return;
                        } else {
                            sVar.onError(terminate);
                            return;
                        }
                    }
                    if (!z6) {
                        try {
                            Object apply = this.mapper.apply(poll);
                            xg.c.b(apply, "The mapper returned a null MaybeSource");
                            i iVar = (i) apply;
                            this.state = 1;
                            ((g) iVar).b(this.inner);
                        } catch (Throwable th2) {
                            ad.a(th2);
                            this.upstream.dispose();
                            eVar.clear();
                            atomicThrowable.addThrowable(th2);
                            sVar.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                } else if (i10 == 2) {
                    R r = this.item;
                    this.item = null;
                    sVar.onNext(r);
                    this.state = 0;
                }
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
        eVar.clear();
        this.item = null;
        sVar.onError(atomicThrowable.terminate());
    }

    public void innerComplete() {
        this.state = 0;
        drain();
    }

    public void innerError(Throwable th2) {
        if (!this.errors.addThrowable(th2)) {
            a1.b(th2);
            return;
        }
        if (this.errorMode != ErrorMode.END) {
            this.upstream.dispose();
        }
        this.state = 0;
        drain();
    }

    public void innerSuccess(R r) {
        this.item = r;
        this.state = 2;
        drain();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // rg.s
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (!this.errors.addThrowable(th2)) {
            a1.b(th2);
            return;
        }
        if (this.errorMode == ErrorMode.IMMEDIATE) {
            this.inner.dispose();
        }
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.queue.offer(t8);
        drain();
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
