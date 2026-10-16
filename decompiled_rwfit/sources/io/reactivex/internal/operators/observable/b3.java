package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class b3 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14583b;

    public b3(rg.l lVar, vg.o oVar) {
        super(lVar);
        this.f14583b = oVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        io.reactivex.subjects.b bVar = new io.reactivex.subjects.b(new io.reactivex.subjects.a());
        try {
            Object apply = this.f14583b.apply(bVar);
            xg.c.b(apply, "The handler returned a null ObservableSource");
            rg.q qVar = (rg.q) apply;
            ObservableRepeatWhen$RepeatWhenObserver observableRepeatWhen$RepeatWhenObserver = new ObservableRepeatWhen$RepeatWhenObserver(sVar, bVar, this.f14546a);
            sVar.onSubscribe(observableRepeatWhen$RepeatWhenObserver);
            qVar.subscribe(observableRepeatWhen$RepeatWhenObserver.inner);
            observableRepeatWhen$RepeatWhenObserver.subscribeNext();
        } catch (Throwable th2) {
            ad.a(th2);
            EmptyDisposable.error(th2, sVar);
        }
    }
}
