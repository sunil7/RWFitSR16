package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Looper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public abstract class xc {
    public static Object a(ia.m mVar) {
        String name;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("Must not be called on the main application thread");
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && ((name = myLooper.getThread().getName()) == "GoogleApiHandler" || (name != null && name.equals("GoogleApiHandler")))) {
            throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
        }
        q9.n.f(mVar, "Task must not be null");
        if (mVar.e()) {
            return d(mVar);
        }
        com.example.test.ui.device.activity.e0 e0Var = new com.example.test.ui.device.activity.e0(20);
        w.a aVar = ia.h.f14384b;
        mVar.b(aVar, e0Var);
        mVar.a(aVar, e0Var);
        mVar.f14399b.f(new ia.i(aVar, (ia.a) e0Var));
        mVar.k();
        ((CountDownLatch) e0Var.f7855b).await();
        return d(mVar);
    }

    public static ia.m b(ff.l lVar) {
        ia.l lVar2 = ia.h.f14383a;
        q9.n.f(lVar2, "Executor must not be null");
        ia.m mVar = new ia.m();
        lVar2.execute(new ia.j(mVar, 4, lVar, false));
        return mVar;
    }

    public static ia.m c(Object obj) {
        ia.m mVar = new ia.m();
        mVar.h(obj);
        return mVar;
    }

    public static Object d(ia.m mVar) {
        if (mVar.f()) {
            return mVar.d();
        }
        if (mVar.f14401d) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(mVar.c());
    }
}
