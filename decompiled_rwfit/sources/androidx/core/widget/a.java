package androidx.core.widget;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f1951a;

    /* renamed from: b, reason: collision with root package name */
    public int f1952b;

    /* renamed from: c, reason: collision with root package name */
    public float f1953c;

    /* renamed from: d, reason: collision with root package name */
    public float f1954d;
    public long e;

    /* renamed from: f, reason: collision with root package name */
    public long f1955f;

    /* renamed from: g, reason: collision with root package name */
    public long f1956g;

    /* renamed from: h, reason: collision with root package name */
    public float f1957h;

    /* renamed from: i, reason: collision with root package name */
    public int f1958i;

    public final float a(long j4) {
        if (j4 < this.e) {
            return 0.0f;
        }
        long j10 = this.f1956g;
        if (j10 < 0 || j4 < j10) {
            return h.b((j4 - r0) / this.f1951a, 0.0f, 1.0f) * 0.5f;
        }
        float f2 = this.f1957h;
        return (h.b((j4 - j10) / this.f1958i, 0.0f, 1.0f) * f2) + (1.0f - f2);
    }
}
