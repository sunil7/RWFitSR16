package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class l3 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14737b;

    public l3(rg.l lVar, vg.o oVar) {
        super(lVar);
        this.f14737b = oVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        io.reactivex.subjects.b bVar = new io.reactivex.subjects.b(new io.reactivex.subjects.a());
        try {
            Object apply = this.f14737b.apply(bVar);
            xg.c.b(apply, "The handler returned a null ObservableSource");
            rg.q qVar = (rg.q) apply;
            ObservableRetryWhen$RepeatWhenObserver observableRetryWhen$RepeatWhenObserver = new ObservableRetryWhen$RepeatWhenObserver(sVar, bVar, this.f14546a);
            sVar.onSubscribe(observableRetryWhen$RepeatWhenObserver);
            qVar.subscribe(observableRetryWhen$RepeatWhenObserver.inner);
            observableRetryWhen$RepeatWhenObserver.subscribeNext();
        } catch (Throwable th2) {
            ad.a(th2);
            EmptyDisposable.error(th2, sVar);
        }
    }
}
