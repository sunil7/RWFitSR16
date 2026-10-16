package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class h4 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14679a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final long f14680b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f14681c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14682d;

    public h4(long j4, TimeUnit timeUnit, rg.x xVar) {
        this.f14680b = j4;
        this.f14681c = timeUnit;
        this.f14682d = xVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14679a) {
            case 0:
                ObservableTimer$TimerObserver observableTimer$TimerObserver = new ObservableTimer$TimerObserver(sVar);
                sVar.onSubscribe(observableTimer$TimerObserver);
                observableTimer$TimerObserver.setResource(((rg.x) this.f14682d).d(observableTimer$TimerObserver, this.f14680b, this.f14681c));
                break;
            default:
                DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(sVar);
                sVar.onSubscribe(deferredScalarDisposable);
                if (!deferredScalarDisposable.isDisposed()) {
                    try {
                        TimeUnit timeUnit = this.f14681c;
                        Future future = (Future) this.f14682d;
                        Object obj = timeUnit != null ? future.get(this.f14680b, timeUnit) : future.get();
                        xg.c.b(obj, "Future returned null");
                        deferredScalarDisposable.complete(obj);
                        break;
                    } catch (Throwable th2) {
                        ad.a(th2);
                        if (deferredScalarDisposable.isDisposed()) {
                            return;
                        }
                        sVar.onError(th2);
                    }
                }
                break;
        }
    }

    public h4(Future future, long j4, TimeUnit timeUnit) {
        this.f14682d = future;
        this.f14680b = j4;
        this.f14681c = timeUnit;
    }
}
