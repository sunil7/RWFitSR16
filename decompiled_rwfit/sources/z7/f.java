package z7;

/* loaded from: classes.dex */
public final class f implements rb.c {

    /* renamed from: a, reason: collision with root package name */
    public static final f f20345a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final rb.b f20346b = rb.b.b("requestTimeMs");

    /* renamed from: c, reason: collision with root package name */
    public static final rb.b f20347c = rb.b.b("requestUptimeMs");

    /* renamed from: d, reason: collision with root package name */
    public static final rb.b f20348d = rb.b.b("clientInfo");
    public static final rb.b e = rb.b.b("logSource");

    /* renamed from: f, reason: collision with root package name */
    public static final rb.b f20349f = rb.b.b("logSourceName");

    /* renamed from: g, reason: collision with root package name */
    public static final rb.b f20350g = rb.b.b("logEvent");

    /* renamed from: h, reason: collision with root package name */
    public static final rb.b f20351h = rb.b.b("qosTier");

    @Override // rb.a
    public final void a(Object obj, Object obj2) {
        rb.d dVar = (rb.d) obj2;
        l lVar = (l) ((r) obj);
        dVar.d(f20346b, lVar.f20375a);
        dVar.d(f20347c, lVar.f20376b);
        dVar.a(f20348d, lVar.f20377c);
        dVar.a(e, lVar.f20378d);
        dVar.a(f20349f, lVar.e);
        dVar.a(f20350g, lVar.f20379f);
        dVar.a(f20351h, lVar.f20380g);
    }
}
