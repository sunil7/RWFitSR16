package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Throwable f15123a = new Throwable() { // from class: io.reactivex.internal.util.ExceptionHelper$Termination
        private static final long serialVersionUID = -4649703670690200604L;

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    };

    public static boolean a(AtomicReference atomicReference, Throwable th2) {
        while (true) {
            Throwable th3 = (Throwable) atomicReference.get();
            if (th3 == f15123a) {
                return false;
            }
            Throwable compositeException = th3 == null ? th2 : new CompositeException(th3, th2);
            while (!atomicReference.compareAndSet(th3, compositeException)) {
                if (atomicReference.get() != th3) {
                    break;
                }
            }
            return true;
        }
    }

    public static RuntimeException b(Throwable th2) {
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        return th2 instanceof RuntimeException ? (RuntimeException) th2 : new RuntimeException(th2);
    }
}
