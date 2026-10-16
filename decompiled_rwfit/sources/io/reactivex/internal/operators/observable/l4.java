package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class l4 extends ah.a {

    /* renamed from: b, reason: collision with root package name */
    public final ObservableWindowBoundary$WindowBoundaryMainObserver f14738b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14739c;

    public l4(ObservableWindowBoundary$WindowBoundaryMainObserver observableWindowBoundary$WindowBoundaryMainObserver) {
        this.f14738b = observableWindowBoundary$WindowBoundaryMainObserver;
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14739c) {
            return;
        }
        this.f14739c = true;
        this.f14738b.innerComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f14739c) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.f14739c = true;
            this.f14738b.innerError(th2);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14739c) {
            return;
        }
        this.f14738b.innerNext();
    }
}
