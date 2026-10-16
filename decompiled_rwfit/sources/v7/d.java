package v7;

/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: d, reason: collision with root package name */
    public static final f f19181d;

    /* renamed from: b, reason: collision with root package name */
    public float f19182b;

    /* renamed from: c, reason: collision with root package name */
    public float f19183c;

    static {
        f a3 = f.a(32, new d(0.0f, 0.0f));
        f19181d = a3;
        a3.f19190f = 0.5f;
    }

    public d(float f2, float f10) {
        this.f19182b = f2;
        this.f19183c = f10;
    }

    public static d b(float f2, float f10) {
        d dVar = (d) f19181d.b();
        dVar.f19182b = f2;
        dVar.f19183c = f10;
        return dVar;
    }

    public static void c(d dVar) {
        f19181d.c(dVar);
    }

    @Override // v7.e
    public final e a() {
        return new d(0.0f, 0.0f);
    }
}
