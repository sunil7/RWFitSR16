package p0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: s, reason: collision with root package name */
    public static final double[] f17287s = new double[91];

    /* renamed from: a, reason: collision with root package name */
    public double[] f17288a;

    /* renamed from: b, reason: collision with root package name */
    public double f17289b;

    /* renamed from: c, reason: collision with root package name */
    public double f17290c;

    /* renamed from: d, reason: collision with root package name */
    public double f17291d;
    public double e;

    /* renamed from: f, reason: collision with root package name */
    public double f17292f;

    /* renamed from: g, reason: collision with root package name */
    public double f17293g;

    /* renamed from: h, reason: collision with root package name */
    public double f17294h;

    /* renamed from: i, reason: collision with root package name */
    public double f17295i;

    /* renamed from: j, reason: collision with root package name */
    public double f17296j;

    /* renamed from: k, reason: collision with root package name */
    public double f17297k;

    /* renamed from: l, reason: collision with root package name */
    public double f17298l;

    /* renamed from: m, reason: collision with root package name */
    public double f17299m;

    /* renamed from: n, reason: collision with root package name */
    public double f17300n;

    /* renamed from: o, reason: collision with root package name */
    public double f17301o;

    /* renamed from: p, reason: collision with root package name */
    public double f17302p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f17303q;
    public boolean r;

    public final double a() {
        double d5 = this.f17296j * this.f17302p;
        double hypot = this.f17300n / Math.hypot(d5, (-this.f17297k) * this.f17301o);
        return this.f17303q ? (-d5) * hypot : d5 * hypot;
    }

    public final double b() {
        double d5 = this.f17296j * this.f17302p;
        double d8 = (-this.f17297k) * this.f17301o;
        double hypot = this.f17300n / Math.hypot(d5, d8);
        return this.f17303q ? (-d8) * hypot : d8 * hypot;
    }

    public final double c(double d5) {
        double d8 = (d5 - this.f17290c) * this.f17295i;
        double d10 = this.f17292f;
        double d11 = this.e;
        return ((d10 - d11) * d8) + d11;
    }

    public final double d(double d5) {
        double d8 = (d5 - this.f17290c) * this.f17295i;
        double d10 = this.f17294h;
        double d11 = this.f17293g;
        return ((d10 - d11) * d8) + d11;
    }

    public final double e() {
        return (this.f17296j * this.f17301o) + this.f17298l;
    }

    public final double f() {
        return (this.f17297k * this.f17302p) + this.f17299m;
    }

    public final void g(double d5) {
        double d8 = (this.f17303q ? this.f17291d - d5 : d5 - this.f17290c) * this.f17295i;
        double d10 = 0.0d;
        if (d8 > 0.0d) {
            d10 = 1.0d;
            if (d8 < 1.0d) {
                double[] dArr = this.f17288a;
                double length = d8 * (dArr.length - 1);
                int i3 = (int) length;
                double d11 = dArr[i3];
                d10 = ((dArr[i3 + 1] - d11) * (length - i3)) + d11;
            }
        }
        double d12 = d10 * 1.5707963267948966d;
        this.f17301o = Math.sin(d12);
        this.f17302p = Math.cos(d12);
    }
}
