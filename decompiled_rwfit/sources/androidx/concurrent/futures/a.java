package androidx.concurrent.futures;

import n0.f;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f1604a;

    static {
        final String str = "Failure occurred while trying to finish a future.";
        new a(new Throwable(str) { // from class: androidx.concurrent.futures.AbstractResolvableFuture$Failure$1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
    }

    public a(Throwable th2) {
        boolean z5 = f.f16350d;
        th2.getClass();
        this.f1604a = th2;
    }
}
