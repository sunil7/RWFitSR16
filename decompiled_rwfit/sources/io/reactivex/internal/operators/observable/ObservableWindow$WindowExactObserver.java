package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableWindow$WindowExactObserver<T> extends AtomicInteger implements rg.s, ug.b, Runnable {
    private static final long serialVersionUID = -7481782523886138128L;
    final rg.s actual;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14542s;
    long size;
    io.reactivex.subjects.d window;

    public ObservableWindow$WindowExactObserver(rg.s sVar, long j4, int i3) {
        this.actual = sVar;
        this.count = j4;
        this.capacityHint = i3;
    }

    @Override // ug.b
    public void dispose() {
        this.cancelled = true;
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // rg.s
    public void onComplete() {
        io.reactivex.subjects.d dVar = this.window;
        if (dVar != null) {
            this.window = null;
            dVar.onComplete();
        }
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        io.reactivex.subjects.d dVar = this.window;
        if (dVar != null) {
            this.window = null;
            dVar.onError(th2);
        }
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        io.reactivex.subjects.d dVar = this.window;
        if (dVar == null && !this.cancelled) {
            io.reactivex.subjects.d dVar2 = new io.reactivex.subjects.d(this, this.capacityHint);
            this.window = dVar2;
            this.actual.onNext(dVar2);
            dVar = dVar2;
        }
        if (dVar != null) {
            dVar.onNext(t8);
            long j4 = this.size + 1;
            this.size = j4;
            if (j4 >= this.count) {
                this.size = 0L;
                this.window = null;
                dVar.onComplete();
                if (this.cancelled) {
                    this.f14542s.dispose();
                }
            }
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14542s, bVar)) {
            this.f14542s = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cancelled) {
            this.f14542s.dispose();
        }
    }
}
