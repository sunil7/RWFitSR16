package com.google.android.gms.internal.mlkit_vision_barcode;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public abstract class dd {
    public static boolean a(rg.s sVar, vg.o oVar, rg.q qVar) {
        if (!(qVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) qVar).call();
            if (call == null) {
                EmptyDisposable.complete(sVar);
                return true;
            }
            try {
                Object apply = oVar.apply(call);
                xg.c.b(apply, "The mapper returned a null ObservableSource");
                rg.q qVar2 = (rg.q) apply;
                if (!(qVar2 instanceof Callable)) {
                    qVar2.subscribe(sVar);
                    return true;
                }
                try {
                    Object call2 = ((Callable) qVar2).call();
                    if (call2 == null) {
                        EmptyDisposable.complete(sVar);
                        return true;
                    }
                    ObservableScalarXMap$ScalarDisposable observableScalarXMap$ScalarDisposable = new ObservableScalarXMap$ScalarDisposable(sVar, call2);
                    sVar.onSubscribe(observableScalarXMap$ScalarDisposable);
                    observableScalarXMap$ScalarDisposable.run();
                    return true;
                } catch (Throwable th2) {
                    ad.a(th2);
                    EmptyDisposable.error(th2, sVar);
                    return true;
                }
            } catch (Throwable th3) {
                ad.a(th3);
                EmptyDisposable.error(th3, sVar);
                return true;
            }
        } catch (Throwable th4) {
            ad.a(th4);
            EmptyDisposable.error(th4, sVar);
            return true;
        }
    }
}
