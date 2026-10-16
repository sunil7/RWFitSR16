package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableWindow$WindowSkipObserver<T> extends AtomicBoolean implements rg.s, ug.b, Runnable {
    private static final long serialVersionUID = 3366976432059579510L;
    final rg.s actual;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    long firstEmission;
    long index;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14543s;
    final long skip;
    final AtomicInteger wip = new AtomicInteger();
    final ArrayDeque<io.reactivex.subjects.d> windows = new ArrayDeque<>();

    public ObservableWindow$WindowSkipObserver(rg.s sVar, long j4, long j10, int i3) {
        this.actual = sVar;
        this.count = j4;
        this.skip = j10;
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
        ArrayDeque<io.reactivex.subjects.d> arrayDeque = this.windows;
        while (!arrayDeque.isEmpty()) {
            arrayDeque.poll().onComplete();
        }
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        ArrayDeque<io.reactivex.subjects.d> arrayDeque = this.windows;
        while (!arrayDeque.isEmpty()) {
            arrayDeque.poll().onError(th2);
        }
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        ArrayDeque<io.reactivex.subjects.d> arrayDeque = this.windows;
        long j4 = this.index;
        long j10 = this.skip;
        if (j4 % j10 == 0 && !this.cancelled) {
            this.wip.getAndIncrement();
            io.reactivex.subjects.d dVar = new io.reactivex.subjects.d(this, this.capacityHint);
            arrayDeque.offer(dVar);
            this.actual.onNext(dVar);
        }
        long j11 = this.firstEmission + 1;
        Iterator<io.reactivex.subjects.d> it = arrayDeque.iterator();
        while (it.hasNext()) {
            it.next().onNext(t8);
        }
        if (j11 >= this.count) {
            arrayDeque.poll().onComplete();
            if (arrayDeque.isEmpty() && this.cancelled) {
                this.f14543s.dispose();
                return;
            }
            this.firstEmission = j11 - j10;
        } else {
            this.firstEmission = j11;
        }
        this.index = j4 + 1;
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14543s, bVar)) {
            this.f14543s = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.wip.decrementAndGet() == 0 && this.cancelled) {
            this.f14543s.dispose();
        }
    }
}
