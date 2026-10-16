package pf;

/* loaded from: classes2.dex */
public final class b {
    public static final ef.b e = ef.b.a(b.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final c f17593a;

    /* renamed from: b, reason: collision with root package name */
    public Object f17594b = null;

    /* renamed from: c, reason: collision with root package name */
    public long f17595c = -1;

    /* renamed from: d, reason: collision with root package name */
    public long f17596d = -1;

    public b(c cVar) {
        this.f17593a = cVar;
        cVar.getClass();
    }

    public final long a() {
        if (this.f17594b != null) {
            return this.f17595c;
        }
        e.b(3, "Frame is dead! time:", Long.valueOf(this.f17595c), "lastTime:", Long.valueOf(this.f17596d));
        throw new RuntimeException("You should not access a released frame. If this frame was passed to a FrameProcessor, you can only use its contents synchronously, for the duration of the process() method.");
    }

    public final void b() {
        if (this.f17594b != null) {
            e.b(0, "Frame with time", Long.valueOf(this.f17595c), "is being released.");
            Object obj = this.f17594b;
            this.f17594b = null;
            this.f17595c = -1L;
            c cVar = this.f17593a;
            if (cVar.f17600c != null) {
                cVar.b(obj, cVar.f17601d.offer(this));
            }
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f17595c == this.f17595c;
    }
}
