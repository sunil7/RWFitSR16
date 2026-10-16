package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
final class ObservableSkipLast$SkipLastObserver<T> extends ArrayDeque<T> implements rg.s, ug.b {
    private static final long serialVersionUID = -3807491841935125653L;
    final rg.s actual;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14532s;
    final int skip;

    public ObservableSkipLast$SkipLastObserver(rg.s sVar, int i3) {
        super(i3);
        this.actual = sVar;
        this.skip = i3;
    }

    @Override // ug.b
    public void dispose() {
        this.f14532s.dispose();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.f14532s.isDisposed();
    }

    @Override // rg.s
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.skip == size()) {
            this.actual.onNext(poll());
        }
        offer(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14532s, bVar)) {
            this.f14532s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
