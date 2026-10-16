package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes2.dex */
public final class u2 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final long f14922a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14923b;

    public u2(long j4, long j10) {
        this.f14922a = j4;
        this.f14923b = j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.internal.operators.observable.ObservableRangeLong$RangeDisposable, ug.b] */
    @Override // rg.l
    public final void subscribeActual(final rg.s sVar) {
        final long j4 = this.f14922a;
        final long j10 = this.f14923b + j4;
        ?? r02 = new BasicIntQueueDisposable<Long>(sVar, j4, j10) { // from class: io.reactivex.internal.operators.observable.ObservableRangeLong$RangeDisposable
            private static final long serialVersionUID = 396518478098735504L;
            final rg.s actual;
            final long end;
            boolean fused;
            long index;

            {
                this.actual = sVar;
                this.index = j4;
                this.end = j10;
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
            public void clear() {
                this.index = this.end;
                lazySet(1);
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
            public void dispose() {
                set(1);
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
            public boolean isDisposed() {
                return get() != 0;
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
            public boolean isEmpty() {
                return this.index == this.end;
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.c
            public int requestFusion(int i3) {
                if ((i3 & 1) == 0) {
                    return 0;
                }
                this.fused = true;
                return 1;
            }

            public void run() {
                if (this.fused) {
                    return;
                }
                rg.s sVar2 = this.actual;
                long j11 = this.end;
                for (long j12 = this.index; j12 != j11 && get() == 0; j12++) {
                    sVar2.onNext(Long.valueOf(j12));
                }
                if (get() == 0) {
                    lazySet(1);
                    sVar2.onComplete();
                }
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
            public Long poll() throws Exception {
                long j11 = this.index;
                if (j11 != this.end) {
                    this.index = 1 + j11;
                    return Long.valueOf(j11);
                }
                lazySet(1);
                return null;
            }
        };
        sVar.onSubscribe(r02);
        r02.run();
    }
}
