package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class n3 implements rg.s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14781a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.s f14782b;

    public /* synthetic */ n3(rg.s sVar, int i3) {
        this.f14781a = i3;
        this.f14782b = sVar;
    }

    private final void a() {
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14781a) {
            case 0:
                ((ObservableSampleWithObservable$SampleMainObserver) this.f14782b).complete();
                break;
            case 1:
                break;
            default:
                ((q0) this.f14782b).f14835b.onComplete();
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14781a) {
            case 0:
                ((ObservableSampleWithObservable$SampleMainObserver) this.f14782b).error(th2);
                break;
            case 1:
                ((ObservableWithLatestFrom$WithLatestFromObserver) this.f14782b).otherError(th2);
                break;
            default:
                ((q0) this.f14782b).f14835b.onError(th2);
                break;
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14781a) {
            case 0:
                ((ObservableSampleWithObservable$SampleMainObserver) this.f14782b).run();
                break;
            case 1:
                ((ObservableWithLatestFrom$WithLatestFromObserver) this.f14782b).lazySet(obj);
                break;
            default:
                ((q0) this.f14782b).f14835b.onNext(obj);
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14781a) {
            case 0:
                ((ObservableSampleWithObservable$SampleMainObserver) this.f14782b).setOther(bVar);
                break;
            case 1:
                ((ObservableWithLatestFrom$WithLatestFromObserver) this.f14782b).setOther(bVar);
                break;
            default:
                ((q0) this.f14782b).f14836c.update(bVar);
                break;
        }
    }
}
