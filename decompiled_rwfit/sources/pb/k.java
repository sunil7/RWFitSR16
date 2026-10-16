package pb;

/* loaded from: classes.dex */
public final class k implements vb.a {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f17520c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f17521a = f17520c;

    /* renamed from: b, reason: collision with root package name */
    public volatile vb.a f17522b;

    public k(vb.a aVar) {
        this.f17522b = aVar;
    }

    @Override // vb.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f17521a;
        Object obj3 = f17520c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f17521a;
                if (obj == obj3) {
                    obj = this.f17522b.get();
                    this.f17521a = obj;
                    this.f17522b = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }
}
