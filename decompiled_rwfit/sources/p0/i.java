package p0;

/* loaded from: classes.dex */
public final class i extends e {
    public double e;

    /* renamed from: f, reason: collision with root package name */
    public double f17330f;

    @Override // p0.e
    public final double a(double d5) {
        double d8 = this.f17330f;
        double d10 = this.e;
        if (d5 < d8) {
            return (d8 * d5) / (((d8 - d5) * d10) + d5);
        }
        return ((d5 - 1.0d) * (1.0d - d8)) / ((1.0d - d5) - ((d8 - d5) * d10));
    }

    @Override // p0.e
    public final double b(double d5) {
        double d8 = this.f17330f;
        double d10 = this.e;
        if (d5 < d8) {
            double d11 = d10 * d8 * d8;
            double d12 = ((d8 - d5) * d10) + d5;
            return d11 / (d12 * d12);
        }
        double d13 = d8 - 1.0d;
        double d14 = (((d8 - d5) * (-d10)) - d5) + 1.0d;
        return ((d13 * d10) * d13) / (d14 * d14);
    }
}
