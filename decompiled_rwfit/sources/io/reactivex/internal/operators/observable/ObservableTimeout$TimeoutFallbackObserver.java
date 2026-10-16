package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableTimeout$TimeoutFallbackObserver<T> extends AtomicReference<ug.b> implements rg.s, ug.b, e4 {
    private static final long serialVersionUID = -7508389464265974549L;
    final rg.s actual;
    rg.q fallback;
    final vg.o itemTimeoutIndicator;
    final SequentialDisposable task = new SequentialDisposable();
    final AtomicLong index = new AtomicLong();
    final AtomicReference<ug.b> upstream = new AtomicReference<>();

    public ObservableTimeout$TimeoutFallbackObserver(rg.s sVar, vg.o oVar, rg.q qVar) {
        this.actual = sVar;
        this.itemTimeoutIndicator = oVar;
        this.fallback = qVar;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
        this.task.dispose();
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
            this.task.dispose();
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
        this.task.dispose();
    }

    @Override // rg.s
    public void onNext(T t8) {
        long j4 = this.index.get();
        if (j4 != Format.OFFSET_SAMPLE_RELATIVE) {
            long j10 = 1 + j4;
            if (this.index.compareAndSet(j4, j10)) {
                ug.b bVar = this.task.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.actual.onNext(t8);
                try {
                    Object apply = this.itemTimeoutIndicator.apply(t8);
                    xg.c.b(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                    rg.q qVar = (rg.q) apply;
                    ObservableTimeout$TimeoutConsumer observableTimeout$TimeoutConsumer = new ObservableTimeout$TimeoutConsumer(j10, this);
                    if (this.task.replace(observableTimeout$TimeoutConsumer)) {
                        qVar.subscribe(observableTimeout$TimeoutConsumer);
                    }
                } catch (Throwable th2) {
                    ad.a(th2);
                    this.upstream.get().dispose();
                    this.index.getAndSet(Format.OFFSET_SAMPLE_RELATIVE);
                    this.actual.onError(th2);
                }
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
        }
    }

    @Override // io.reactivex.internal.operators.observable.e4
    public void onTimeoutError(long j4, Throwable th2) {
        if (!this.index.compareAndSet(j4, Format.OFFSET_SAMPLE_RELATIVE)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            DisposableHelper.dispose(this);
            this.actual.onError(th2);
        }
    }

    public void startFirstTimeout(rg.q qVar) {
        if (qVar != null) {
            ObservableTimeout$TimeoutConsumer observableTimeout$TimeoutConsumer = new ObservableTimeout$TimeoutConsumer(0L, this);
            if (this.task.replace(observableTimeout$TimeoutConsumer)) {
                qVar.subscribe(observableTimeout$TimeoutConsumer);
            }
        }
    }
}
