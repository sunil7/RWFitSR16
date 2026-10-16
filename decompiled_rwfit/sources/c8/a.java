package c8;

/* loaded from: classes.dex */
public final class a implements dh.a {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f3402c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile b f3403a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f3404b;

    public static dh.a a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        a aVar = new a();
        aVar.f3404b = f3402c;
        aVar.f3403a = bVar;
        return aVar;
    }

    @Override // dh.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f3404b;
        Object obj3 = f3402c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f3404b;
                if (obj == obj3) {
                    obj = this.f3403a.get();
                    Object obj4 = this.f3404b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f3404b = obj;
                    this.f3403a = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }
}
