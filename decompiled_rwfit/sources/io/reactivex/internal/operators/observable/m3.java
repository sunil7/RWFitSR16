package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class m3 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14755b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14756c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeUnit f14757d;
    public final rg.x e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14758f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m3(int i3, long j4, TimeUnit timeUnit, rg.l lVar, rg.x xVar, boolean z5) {
        super(lVar);
        this.f14755b = i3;
        this.f14756c = j4;
        this.f14757d = timeUnit;
        this.e = xVar;
        this.f14758f = z5;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14755b) {
            case 0:
                final ah.c cVar = new ah.c(sVar);
                final rg.x xVar = this.e;
                final TimeUnit timeUnit = this.f14757d;
                boolean z5 = this.f14758f;
                rg.q qVar = this.f14546a;
                if (!z5) {
                    final long j4 = this.f14756c;
                    qVar.subscribe(new ObservableSampleTimed$SampleTimedObserver<T>(cVar, j4, timeUnit, xVar) { // from class: io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedNoLast
                        private static final long serialVersionUID = -7139995637533111443L;

                        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver
                        public void complete() {
                            this.actual.onComplete();
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            emit();
                        }
                    });
                    break;
                } else {
                    final long j10 = this.f14756c;
                    qVar.subscribe(new ObservableSampleTimed$SampleTimedObserver<T>(cVar, j10, timeUnit, xVar) { // from class: io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedEmitLast
                        private static final long serialVersionUID = -7139995637533111443L;
                        final AtomicInteger wip = new AtomicInteger(1);

                        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver
                        public void complete() {
                            emit();
                            if (this.wip.decrementAndGet() == 0) {
                                this.actual.onComplete();
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (this.wip.incrementAndGet() == 2) {
                                emit();
                                if (this.wip.decrementAndGet() == 0) {
                                    this.actual.onComplete();
                                }
                            }
                        }
                    });
                    break;
                }
            default:
                rg.s cVar2 = this.f14758f ? sVar : new ah.c(sVar);
                this.f14546a.subscribe(new p0(cVar2, this.f14756c, this.f14757d, this.e.a(), this.f14758f));
                break;
        }
    }
}
