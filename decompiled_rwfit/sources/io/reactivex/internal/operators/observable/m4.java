package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class m4 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14759b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14760c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14761d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m4(rg.l lVar, Object obj, int i3, int i10) {
        super(lVar);
        this.f14759b = i10;
        this.f14761d = obj;
        this.f14760c = i3;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14759b) {
            case 0:
                ObservableWindowBoundary$WindowBoundaryMainObserver observableWindowBoundary$WindowBoundaryMainObserver = new ObservableWindowBoundary$WindowBoundaryMainObserver(sVar, this.f14760c);
                sVar.onSubscribe(observableWindowBoundary$WindowBoundaryMainObserver);
                ((rg.q) this.f14761d).subscribe(observableWindowBoundary$WindowBoundaryMainObserver.boundaryObserver);
                this.f14546a.subscribe(observableWindowBoundary$WindowBoundaryMainObserver);
                break;
            default:
                this.f14546a.subscribe(new ObservableWindowBoundarySupplier$WindowBoundaryMainObserver(sVar, this.f14760c, (Callable) this.f14761d));
                break;
        }
    }
}
