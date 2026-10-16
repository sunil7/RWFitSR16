package tg;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final d f18629a;

    static {
        try {
            d dVar = a.f18628a;
            if (dVar == null) {
                throw new NullPointerException("Scheduler Callable returned null");
            }
            f18629a = dVar;
        } catch (Throwable th2) {
            throw io.reactivex.internal.util.b.b(th2);
        }
    }
}
