package p0;

/* loaded from: classes.dex */
public final class d extends e {
    public final double e;

    /* renamed from: f, reason: collision with root package name */
    public final double f17308f;

    /* renamed from: g, reason: collision with root package name */
    public final double f17309g;

    /* renamed from: h, reason: collision with root package name */
    public final double f17310h;

    public d(String str) {
        super(0);
        this.f17314b = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.e = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i3 = indexOf2 + 1;
        int indexOf3 = str.indexOf(44, i3);
        this.f17308f = Double.parseDouble(str.substring(i3, indexOf3).trim());
        int i10 = indexOf3 + 1;
        int indexOf4 = str.indexOf(44, i10);
        this.f17309g = Double.parseDouble(str.substring(i10, indexOf4).trim());
        int i11 = indexOf4 + 1;
        this.f17310h = Double.parseDouble(str.substring(i11, str.indexOf(41, i11)).trim());
    }

    @Override // p0.e
    public final double a(double d5) {
        if (d5 <= 0.0d) {
            return 0.0d;
        }
        if (d5 >= 1.0d) {
            return 1.0d;
        }
        double d8 = 0.5d;
        double d10 = 0.5d;
        while (d8 > 0.01d) {
            d8 *= 0.5d;
            d10 = e(d10) < d5 ? d10 + d8 : d10 - d8;
        }
        double d11 = d10 - d8;
        double e = e(d11);
        double d12 = d10 + d8;
        double e10 = e(d12);
        double f2 = f(d11);
        return (((d5 - e) * (f(d12) - f2)) / (e10 - e)) + f2;
    }

    @Override // p0.e
    public final double b(double d5) {
        double d8 = 0.5d;
        double d10 = 0.5d;
        while (d8 > 1.0E-4d) {
            d8 *= 0.5d;
            d10 = e(d10) < d5 ? d10 + d8 : d10 - d8;
        }
        double d11 = d10 - d8;
        double d12 = d10 + d8;
        return (f(d12) - f(d11)) / (e(d12) - e(d11));
    }

    public final double e(double d5) {
        double d8 = 1.0d - d5;
        double d10 = 3.0d * d8;
        double d11 = d8 * d10 * d5;
        double d12 = d10 * d5 * d5;
        return (this.f17309g * d12) + (this.e * d11) + (d5 * d5 * d5);
    }

    public final double f(double d5) {
        double d8 = 1.0d - d5;
        double d10 = 3.0d * d8;
        double d11 = d8 * d10 * d5;
        double d12 = d10 * d5 * d5;
        return (this.f17310h * d12) + (this.f17308f * d11) + (d5 * d5 * d5);
    }
}
