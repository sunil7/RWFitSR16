package v7;

/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: d, reason: collision with root package name */
    public static final f f19178d;

    /* renamed from: b, reason: collision with root package name */
    public double f19179b = 0.0d;

    /* renamed from: c, reason: collision with root package name */
    public double f19180c = 0.0d;

    static {
        f a3 = f.a(64, new c());
        f19178d = a3;
        a3.f19190f = 0.5f;
    }

    public static c b(double d5, double d8) {
        c cVar = (c) f19178d.b();
        cVar.f19179b = d5;
        cVar.f19180c = d8;
        return cVar;
    }

    public static void c(c cVar) {
        f19178d.c(cVar);
    }

    @Override // v7.e
    public final e a() {
        return new c();
    }

    public final String toString() {
        return "MPPointD, x: " + this.f19179b + ", y: " + this.f19180c;
    }
}
