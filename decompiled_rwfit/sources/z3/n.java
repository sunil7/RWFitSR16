package z3;

/* loaded from: classes.dex */
public final class n implements s {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20277a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20278b;

    /* renamed from: c, reason: collision with root package name */
    public final s f20279c;

    /* renamed from: d, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.c f20280d;
    public final m e;

    /* renamed from: f, reason: collision with root package name */
    public int f20281f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f20282g;

    public n(s sVar, boolean z5, boolean z6, m mVar, com.bumptech.glide.load.engine.c cVar) {
        t4.f.c(sVar, "Argument must not be null");
        this.f20279c = sVar;
        this.f20277a = z5;
        this.f20278b = z6;
        this.e = mVar;
        t4.f.c(cVar, "Argument must not be null");
        this.f20280d = cVar;
    }

    public final synchronized void a() {
        if (this.f20282g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f20281f++;
    }

    public final void b() {
        boolean z5;
        synchronized (this) {
            int i3 = this.f20281f;
            if (i3 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z5 = true;
            int i10 = i3 - 1;
            this.f20281f = i10;
            if (i10 != 0) {
                z5 = false;
            }
        }
        if (z5) {
            this.f20280d.e(this.e, this);
        }
    }

    @Override // z3.s
    public final int c() {
        return this.f20279c.c();
    }

    @Override // z3.s
    public final Class d() {
        return this.f20279c.d();
    }

    @Override // z3.s
    public final Object get() {
        return this.f20279c.get();
    }

    @Override // z3.s
    public final synchronized void recycle() {
        if (this.f20281f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f20282g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f20282g = true;
        if (this.f20278b) {
            this.f20279c.recycle();
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f20277a + ", listener=" + this.f20280d + ", key=" + this.e + ", acquired=" + this.f20281f + ", isRecycled=" + this.f20282g + ", resource=" + this.f20279c + '}';
    }
}
