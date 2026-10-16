package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
final class ObservableTakeLast$TakeLastObserver<T> extends ArrayDeque<T> implements rg.s, ug.b {
    private static final long serialVersionUID = 7240042530241604978L;
    final rg.s actual;
    volatile boolean cancelled;
    final int count;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14536s;

    public ObservableTakeLast$TakeLastObserver(rg.s sVar, int i3) {
        this.actual = sVar;
        this.count = i3;
    }

    @Override // ug.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.f14536s.dispose();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // rg.s
    public void onComplete() {
        rg.s sVar = this.actual;
        while (!this.cancelled) {
            T poll = poll();
            if (poll == null) {
                if (this.cancelled) {
                    return;
                }
                sVar.onComplete();
                return;
            }
            sVar.onNext(poll);
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.count == size()) {
            poll();
        }
        offer(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14536s, bVar)) {
            this.f14536s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
