package androidx.work.impl.utils.futures;

import z2.g;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3029b;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f3030a;

    static {
        final String str = "Failure occurred while trying to finish a future.";
        f3029b = new a(new Throwable(str) { // from class: androidx.work.impl.utils.futures.AbstractFuture$Failure$1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
    }

    public a(Throwable th2) {
        boolean z5 = g.f20200d;
        th2.getClass();
        this.f3030a = th2;
    }
}
