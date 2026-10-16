package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.gd;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableRetryWhen$RepeatWhenObserver<T> extends AtomicInteger implements rg.s, ug.b {
    private static final long serialVersionUID = 802743776666017014L;
    volatile boolean active;
    final rg.s actual;
    final io.reactivex.subjects.c signaller;
    final rg.q source;
    final AtomicInteger wip = new AtomicInteger();
    final AtomicThrowable error = new AtomicThrowable();
    final ObservableRetryWhen$RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();

    /* renamed from: d, reason: collision with root package name */
    final AtomicReference<ug.b> f14525d = new AtomicReference<>();

    public final class InnerRepeatObserver extends AtomicReference<ug.b> implements rg.s {
        private static final long serialVersionUID = 3254781284376480842L;

        public InnerRepeatObserver() {
        }

        @Override // rg.s
        public void onComplete() {
            ObservableRetryWhen$RepeatWhenObserver.this.innerComplete();
        }

        @Override // rg.s
        public void onError(Throwable th2) {
            ObservableRetryWhen$RepeatWhenObserver.this.innerError(th2);
        }

        @Override // rg.s
        public void onNext(Object obj) {
            ObservableRetryWhen$RepeatWhenObserver.this.innerNext();
        }

        @Override // rg.s
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableRetryWhen$RepeatWhenObserver(rg.s sVar, io.reactivex.subjects.c cVar, rg.q qVar) {
        this.actual = sVar;
        this.signaller = cVar;
        this.source = qVar;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this.f14525d);
        DisposableHelper.dispose(this.inner);
    }

    public void innerComplete() {
        DisposableHelper.dispose(this.f14525d);
        gd.a(this.actual, this, this.error);
    }

    public void innerError(Throwable th2) {
        DisposableHelper.dispose(this.f14525d);
        gd.b(this.actual, th2, this, this.error);
    }

    public void innerNext() {
        subscribeNext();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f14525d.get());
    }

    @Override // rg.s
    public void onComplete() {
        DisposableHelper.dispose(this.inner);
        gd.a(this.actual, this, this.error);
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.active = false;
        this.signaller.onNext(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        gd.c(this.actual, t8, this, this.error);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.replace(this.f14525d, bVar);
    }

    public void subscribeNext() {
        if (this.wip.getAndIncrement() == 0) {
            while (!isDisposed()) {
                if (!this.active) {
                    this.active = true;
                    this.source.subscribe(this);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }
}
