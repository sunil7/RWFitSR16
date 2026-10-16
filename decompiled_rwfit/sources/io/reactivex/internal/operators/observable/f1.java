package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class f1 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14637b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14638c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14639d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f1(rg.l lVar, Object obj, boolean z5, int i3) {
        super(lVar);
        this.f14637b = i3;
        this.f14638c = obj;
        this.f14639d = z5;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14637b) {
            case 0:
                this.f14546a.subscribe(new ObservableFlatMapCompletable$FlatMapCompletableMainObserver(sVar, (vg.o) this.f14638c, this.f14639d));
                break;
            case 1:
                this.f14546a.subscribe(new ObservableFlatMapMaybe$FlatMapMaybeObserver(sVar, (vg.o) this.f14638c, this.f14639d));
                break;
            case 2:
                this.f14546a.subscribe(new ObservableFlatMapSingle$FlatMapSingleObserver(sVar, (vg.o) this.f14638c, this.f14639d));
                break;
            case 3:
                n2 n2Var = new n2(sVar, (vg.o) this.f14638c, this.f14639d);
                sVar.onSubscribe(n2Var.f14779d);
                this.f14546a.subscribe(n2Var);
                break;
            default:
                final ah.c cVar = new ah.c(sVar);
                final rg.q qVar = (rg.q) this.f14638c;
                boolean z5 = this.f14639d;
                rg.q qVar2 = this.f14546a;
                if (!z5) {
                    qVar2.subscribe(new ObservableSampleWithObservable$SampleMainObserver<T>(cVar, qVar) { // from class: io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainNoLast
                        private static final long serialVersionUID = -3029755663834015785L;

                        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
                        public void completeMain() {
                            this.actual.onComplete();
                        }

                        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
                        public void completeOther() {
                            this.actual.onComplete();
                        }

                        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
                        public void run() {
                            emit();
                        }
                    });
                    break;
                } else {
                    qVar2.subscribe(new ObservableSampleWithObservable$SampleMainObserver<T>(cVar, qVar) { // from class: io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainEmitLast
                        private static final long serialVersionUID = -3029755663834015785L;
                        volatile boolean done;
                        final AtomicInteger wip = new AtomicInteger();

                        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
                        public void completeMain() {
                            this.done = true;
                            if (this.wip.getAndIncrement() == 0) {
                                emit();
                                this.actual.onComplete();
                            }
                        }

                        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
                        public void completeOther() {
                            this.done = true;
                            if (this.wip.getAndIncrement() == 0) {
                                emit();
                                this.actual.onComplete();
                            }
                        }

                        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
                        public void run() {
                            if (this.wip.getAndIncrement() == 0) {
                                do {
                                    boolean z6 = this.done;
                                    emit();
                                    if (z6) {
                                        this.actual.onComplete();
                                        return;
                                    }
                                } while (this.wip.decrementAndGet() != 0);
                            }
                        }
                    });
                    break;
                }
        }
    }
}
