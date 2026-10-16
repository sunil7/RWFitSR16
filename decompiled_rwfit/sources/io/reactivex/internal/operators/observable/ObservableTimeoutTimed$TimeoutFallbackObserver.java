package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableTimeoutTimed$TimeoutFallbackObserver<T> extends AtomicReference<ug.b> implements rg.s, ug.b, f4 {
    private static final long serialVersionUID = 3764492702657003550L;
    final rg.s actual;
    rg.q fallback;
    final long timeout;
    final TimeUnit unit;
    final rg.w worker;
    final SequentialDisposable task = new SequentialDisposable();
    final AtomicLong index = new AtomicLong();
    final AtomicReference<ug.b> upstream = new AtomicReference<>();

    public ObservableTimeoutTimed$TimeoutFallbackObserver(rg.s sVar, long j4, TimeUnit timeUnit, rg.w wVar, rg.q qVar) {
        this.actual = sVar;
        this.timeout = j4;
        this.unit = timeUnit;
        this.worker = wVar;
        this.fallback = qVar;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
        this.worker.dispose();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // rg.s
    public void onComplete() {
        if (this.index.getAndSet(Format.OFFSET_SAMPLE_RELATIVE) != Format.OFFSET_SAMPLE_RELATIVE) {
            this.task.dispose();
            this.actual.onComplete();
            this.worker.dispose();
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.index.getAndSet(Format.OFFSET_SAMPLE_RELATIVE) == Format.OFFSET_SAMPLE_RELATIVE) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.task.dispose();
        this.actual.onError(th2);
        this.worker.dispose();
    }

    @Override // rg.s
    public void onNext(T t8) {
        long j4 = this.index.get();
        if (j4 != Format.OFFSET_SAMPLE_RELATIVE) {
            long j10 = 1 + j4;
            if (this.index.compareAndSet(j4, j10)) {
                this.task.get().dispose();
                this.actual.onNext(t8);
                startTimeout(j10);
            }
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this.upstream, bVar);
    }

    @Override // io.reactivex.internal.operators.observable.f4
    public void onTimeout(long j4) {
        if (this.index.compareAndSet(j4, Format.OFFSET_SAMPLE_RELATIVE)) {
            DisposableHelper.dispose(this.upstream);
            rg.q qVar = this.fallback;
            this.fallback = null;
            qVar.subscribe(new r2(2, this.actual, this));
            this.worker.dispose();
        }
    }

    public void startTimeout(long j4) {
        this.task.replace(this.worker.a(new com.google.android.material.datepicker.i(j4, this), this.timeout, this.unit));
    }
}
