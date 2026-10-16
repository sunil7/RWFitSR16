package com.google.android.gms.internal.mlkit_vision_barcode;

import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class gd {
    public static void a(rg.s sVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                sVar.onError(terminate);
            } else {
                sVar.onComplete();
            }
        }
    }

    public static void b(rg.s sVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th2)) {
            a1.b(th2);
        } else if (atomicInteger.getAndIncrement() == 0) {
            sVar.onError(atomicThrowable.terminate());
        }
    }

    public static void c(rg.s sVar, Object obj, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            sVar.onNext(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    sVar.onError(terminate);
                } else {
                    sVar.onComplete();
                }
            }
        }
    }
}
