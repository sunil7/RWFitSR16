package com.google.android.gms.internal.mlkit_vision_barcode;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public abstract class a1 {
    public static rg.x a(Callable callable) {
        try {
            Object call = callable.call();
            xg.c.b(call, "Scheduler Callable result can't be null");
            return (rg.x) call;
        } catch (Throwable th2) {
            throw io.reactivex.internal.util.b.b(th2);
        }
    }

    public static void b(Throwable th2) {
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!(th2 instanceof OnErrorNotImplementedException) && !(th2 instanceof MissingBackpressureException) && !(th2 instanceof IllegalStateException) && !(th2 instanceof NullPointerException) && !(th2 instanceof IllegalArgumentException) && !(th2 instanceof CompositeException)) {
            th2 = new UndeliverableException(th2);
        }
        th2.printStackTrace();
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }
}
