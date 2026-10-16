package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableRepeatUntil$RepeatUntilObserver<T> extends AtomicInteger implements rg.s {
    private static final long serialVersionUID = -7098360935104053232L;
    final rg.s actual;
    final SequentialDisposable sd;
    final rg.q source;
    final vg.e stop;

    public ObservableRepeatUntil$RepeatUntilObserver(rg.s sVar, vg.e eVar, SequentialDisposable sequentialDisposable, rg.q qVar) {
        this.actual = sVar;
        this.sd = sequentialDisposable;
        this.source = qVar;
    }

    @Override // rg.s
    public void onComplete() {
        try {
            throw null;
        } catch (Throwable th2) {
            ad.a(th2);
            this.actual.onError(th2);
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.actual.onNext(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        this.sd.replace(bVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i3 = 1;
            do {
                this.source.subscribe(this);
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }
    }
}
