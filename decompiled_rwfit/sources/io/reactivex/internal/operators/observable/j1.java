package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class j1 extends rg.l implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final Callable f14701a;

    public j1(Callable callable) {
        this.f14701a = callable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Object call = this.f14701a.call();
        xg.c.b(call, "The callable returned a null value");
        return call;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(sVar);
        sVar.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            Object call = this.f14701a.call();
            xg.c.b(call, "Callable returned null");
            deferredScalarDisposable.complete(call);
        } catch (Throwable th2) {
            ad.a(th2);
            if (deferredScalarDisposable.isDisposed()) {
                com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            } else {
                sVar.onError(th2);
            }
        }
    }
}
