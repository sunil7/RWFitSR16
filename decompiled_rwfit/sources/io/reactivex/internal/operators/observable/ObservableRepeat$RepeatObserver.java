package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableRepeat$RepeatObserver<T> extends AtomicInteger implements rg.s {
    private static final long serialVersionUID = -7098360935104053232L;
    final rg.s actual;
    long remaining;
    final SequentialDisposable sd;
    final rg.q source;

    public ObservableRepeat$RepeatObserver(rg.s sVar, long j4, SequentialDisposable sequentialDisposable, rg.q qVar) {
        this.actual = sVar;
        this.sd = sequentialDisposable;
        this.source = qVar;
        this.remaining = j4;
    }

    @Override // rg.s
    public void onComplete() {
        long j4 = this.remaining;
        if (j4 != Format.OFFSET_SAMPLE_RELATIVE) {
            this.remaining = j4 - 1;
        }
        if (j4 != 0) {
            subscribeNext();
        } else {
            this.actual.onComplete();
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
            while (!this.sd.isDisposed()) {
                this.source.subscribe(this);
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
    }
}
