package z7;

/* loaded from: classes.dex */
public final class e implements rb.c {

    /* renamed from: a, reason: collision with root package name */
    public static final e f20338a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final rb.b f20339b = rb.b.b("eventTimeMs");

    /* renamed from: c, reason: collision with root package name */
    public static final rb.b f20340c = rb.b.b("eventCode");

    /* renamed from: d, reason: collision with root package name */
    public static final rb.b f20341d = rb.b.b("eventUptimeMs");
    public static final rb.b e = rb.b.b("sourceExtension");

    /* renamed from: f, reason: collision with root package name */
    public static final rb.b f20342f = rb.b.b("sourceExtensionJsonProto3");

    /* renamed from: g, reason: collision with root package name */
    public static final rb.b f20343g = rb.b.b("timezoneOffsetSeconds");

    /* renamed from: h, reason: collision with root package name */
    public static final rb.b f20344h = rb.b.b("networkConnectionInfo");

    @Override // rb.a
    public final void a(Object obj, Object obj2) {
        rb.d dVar = (rb.d) obj2;
        k kVar = (k) ((q) obj);
        dVar.d(f20339b, kVar.f20369a);
        dVar.a(f20340c, kVar.f20370b);
        dVar.d(f20341d, kVar.f20371c);
        dVar.a(e, kVar.f20372d);
        dVar.a(f20342f, kVar.e);
        dVar.d(f20343g, kVar.f20373f);
        dVar.a(f20344h, kVar.f20374g);
    }
}
