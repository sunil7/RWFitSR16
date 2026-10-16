package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableConcatMap$SourceObserver<T, U> extends AtomicInteger implements rg.s, ug.b {
    private static final long serialVersionUID = 8828587559905699186L;
    volatile boolean active;
    final rg.s actual;
    final int bufferSize;
    volatile boolean disposed;
    volatile boolean done;
    int fusionMode;
    final InnerObserver<U> inner;
    final vg.o mapper;
    yg.f queue;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14511s;

    public static final class InnerObserver<U> extends AtomicReference<ug.b> implements rg.s {
        private static final long serialVersionUID = -7449079488798789337L;
        final rg.s actual;
        final ObservableConcatMap$SourceObserver<?, ?> parent;

        public InnerObserver(rg.s sVar, ObservableConcatMap$SourceObserver<?, ?> observableConcatMap$SourceObserver) {
            this.actual = sVar;
            this.parent = observableConcatMap$SourceObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // rg.s
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // rg.s
        public void onError(Throwable th2) {
            this.parent.dispose();
            this.actual.onError(th2);
        }

        @Override // rg.s
        public void onNext(U u10) {
            this.actual.onNext(u10);
        }

        @Override // rg.s
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.set(this, bVar);
        }
    }

    public ObservableConcatMap$SourceObserver(rg.s sVar, vg.o oVar, int i3) {
        this.actual = sVar;
        this.mapper = oVar;
        this.bufferSize = i3;
        this.inner = new InnerObserver<>(sVar, this);
    }

    @Override // ug.b
    public void dispose() {
        this.disposed = true;
        this.inner.dispose();
        this.f14511s.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        while (!this.disposed) {
            if (!this.active) {
                boolean z5 = this.done;
                try {
                    Object poll = this.queue.poll();
                    boolean z6 = poll == null;
                    if (z5 && z6) {
                        this.disposed = true;
                        this.actual.onComplete();
                        return;
                    }
                    if (!z6) {
                        try {
                            Object apply = this.mapper.apply(poll);
                            xg.c.b(apply, "The mapper returned a null ObservableSource");
                            rg.q qVar = (rg.q) apply;
                            this.active = true;
                            qVar.subscribe(this.inner);
                        } catch (Throwable th2) {
                            ad.a(th2);
                            dispose();
                            this.queue.clear();
                            this.actual.onError(th2);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    ad.a(th3);
                    dispose();
                    this.queue.clear();
                    this.actual.onError(th3);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.queue.clear();
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // rg.s
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.done) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.done = true;
        dispose();
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.done) {
            return;
        }
        if (this.fusionMode == 0) {
            this.queue.offer(t8);
        }
        drain();
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14511s, bVar)) {
            this.f14511s = bVar;
            if (bVar instanceof yg.b) {
                yg.b bVar2 = (yg.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.actual.onSubscribe(this);
                    return;
                }
            }
            this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
            this.actual.onSubscribe(this);
        }
    }
}
