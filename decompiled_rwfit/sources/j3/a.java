package j3;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public long f15317a = 0;

    /* renamed from: b, reason: collision with root package name */
    public double f15318b = 0.0d;

    /* renamed from: c, reason: collision with root package name */
    public double f15319c = 0.0d;

    /* renamed from: d, reason: collision with root package name */
    public double f15320d = 0.0d;
    public float e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f15321f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public float f15322g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public long f15323h;

    /* renamed from: i, reason: collision with root package name */
    public byte f15324i;

    public final double a(a aVar) {
        if (aVar == null) {
            return 0.0d;
        }
        double d5 = this.f15319c;
        double d8 = this.f15318b;
        double d10 = aVar.f15319c;
        double d11 = aVar.f15318b;
        double d12 = (((90.0d - d8) * 21412.0d) / 90.0d) + 6356725.0d;
        double cos = ((d10 * 0.01745329238474369d) - (d5 * 0.01745329238474369d)) * Math.cos((3.1415927410125732d * d8) / 180.0d) * d12;
        double d13 = ((d11 * 0.01745329238474369d) - (d8 * 0.01745329238474369d)) * d12;
        return Math.pow((d13 * d13) + (cos * cos), 0.5d);
    }
}
