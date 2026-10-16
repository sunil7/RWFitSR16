package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements rg.s {
    private static final long serialVersionUID = 8443155186132538303L;
    final rg.s actual;

    /* renamed from: d, reason: collision with root package name */
    ug.b f14517d;
    final boolean delayErrors;
    volatile boolean disposed;
    final vg.o mapper;
    final AtomicThrowable errors = new AtomicThrowable();
    final ug.a set = new ug.a();

    public final class InnerObserver extends AtomicReference<ug.b> implements rg.b, ug.b {
        private static final long serialVersionUID = 8606673141535671828L;

        public InnerObserver() {
        }

        @Override // ug.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ug.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // rg.b, rg.h
        public void onComplete() {
            ObservableFlatMapCompletable$FlatMapCompletableMainObserver.this.innerComplete(this);
        }

        @Override // rg.b
        public void onError(Throwable th2) {
            ObservableFlatMapCompletable$FlatMapCompletableMainObserver.this.innerError(this, th2);
        }

        @Override // rg.b
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableFlatMapCompletable$FlatMapCompletableMainObserver(rg.s sVar, vg.o oVar, boolean z5) {
        this.actual = sVar;
        this.mapper = oVar;
        this.delayErrors = z5;
        lazySet(1);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public void clear() {
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
    public void dispose() {
        this.disposed = true;
        this.f14517d.dispose();
        this.set.dispose();
    }

    public void innerComplete(ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
        this.set.a(innerObserver);
        onComplete();
    }

    public void innerError(ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th2) {
        this.set.a(innerObserver);
        onError(th2);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
    public boolean isDisposed() {
        return this.f14517d.isDisposed();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public boolean isEmpty() {
        return true;
    }

    @Override // rg.s
    public void onComplete() {
        if (decrementAndGet() == 0) {
            Throwable terminate = this.errors.terminate();
            if (terminate != null) {
                this.actual.onError(terminate);
            } else {
                this.actual.onComplete();
            }
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (!this.errors.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        if (this.delayErrors) {
            if (decrementAndGet() == 0) {
                this.actual.onError(this.errors.terminate());
                return;
            }
            return;
        }
        dispose();
        if (getAndSet(0) > 0) {
            this.actual.onError(this.errors.terminate());
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        try {
            Object apply = this.mapper.apply(t8);
            xg.c.b(apply, "The mapper returned a null CompletableSource");
            rg.c cVar = (rg.c) apply;
            getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            if (this.disposed || !this.set.c(innerObserver)) {
                return;
            }
            ((rg.a) cVar).b(innerObserver);
        } catch (Throwable th2) {
            ad.a(th2);
            this.f14517d.dispose();
            onError(th2);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14517d, bVar)) {
            this.f14517d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public T poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.c
    public int requestFusion(int i3) {
        return i3 & 2;
    }
}
