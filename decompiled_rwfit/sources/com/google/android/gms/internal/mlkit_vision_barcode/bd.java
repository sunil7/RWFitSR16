package com.google.android.gms.internal.mlkit_vision_barcode;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public abstract class bd {
    public static boolean a(Object obj, vg.o oVar, rg.b bVar) {
        rg.c cVar;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                Object apply = oVar.apply(call);
                xg.c.b(apply, "The mapper returned a null CompletableSource");
                cVar = (rg.c) apply;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                EmptyDisposable.complete(bVar);
                return true;
            }
            ((rg.a) cVar).b(bVar);
            return true;
        } catch (Throwable th2) {
            ad.a(th2);
            EmptyDisposable.error(th2, bVar);
            return true;
        }
    }

    public static boolean b(Object obj, vg.o oVar, rg.s sVar) {
        rg.i iVar;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                Object apply = oVar.apply(call);
                xg.c.b(apply, "The mapper returned a null MaybeSource");
                iVar = (rg.i) apply;
            } else {
                iVar = null;
            }
            if (iVar == null) {
                EmptyDisposable.complete(sVar);
                return true;
            }
            ((rg.g) iVar).b(io.reactivex.internal.operators.maybe.a.c(sVar));
            return true;
        } catch (Throwable th2) {
            ad.a(th2);
            EmptyDisposable.error(th2, sVar);
            return true;
        }
    }

    public static boolean c(Object obj, vg.o oVar, rg.s sVar) {
        rg.a0 a0Var;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                Object apply = oVar.apply(call);
                xg.c.b(apply, "The mapper returned a null SingleSource");
                a0Var = (rg.a0) apply;
            } else {
                a0Var = null;
            }
            if (a0Var == null) {
                EmptyDisposable.complete(sVar);
                return true;
            }
            ((rg.y) a0Var).b(io.reactivex.internal.operators.single.a.c(sVar));
            return true;
        } catch (Throwable th2) {
            ad.a(th2);
            EmptyDisposable.error(th2, sVar);
            return true;
        }
    }
}
