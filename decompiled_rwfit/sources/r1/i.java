package r1;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public double f18010a;

    /* renamed from: b, reason: collision with root package name */
    public double f18011b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18012c;

    /* renamed from: d, reason: collision with root package name */
    public double f18013d;
    public double e;

    /* renamed from: f, reason: collision with root package name */
    public double f18014f;

    /* renamed from: g, reason: collision with root package name */
    public double f18015g;

    /* renamed from: h, reason: collision with root package name */
    public double f18016h;

    /* renamed from: i, reason: collision with root package name */
    public double f18017i;

    /* renamed from: j, reason: collision with root package name */
    public final d f18018j;

    public i() {
        this.f18010a = Math.sqrt(1500.0d);
        this.f18011b = 0.5d;
        this.f18012c = false;
        this.f18017i = Double.MAX_VALUE;
        this.f18018j = new d();
    }

    public final d a(long j4, double d5, double d8) {
        double sin;
        double cos;
        if (!this.f18012c) {
            if (this.f18017i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d10 = this.f18011b;
            if (d10 > 1.0d) {
                double d11 = this.f18010a;
                this.f18014f = (Math.sqrt((d10 * d10) - 1.0d) * d11) + ((-d10) * d11);
                double d12 = this.f18011b;
                double d13 = this.f18010a;
                this.f18015g = ((-d12) * d13) - (Math.sqrt((d12 * d12) - 1.0d) * d13);
            } else if (d10 >= 0.0d && d10 < 1.0d) {
                this.f18016h = Math.sqrt(1.0d - (d10 * d10)) * this.f18010a;
            }
            this.f18012c = true;
        }
        double d14 = j4 / 1000.0d;
        double d15 = d5 - this.f18017i;
        double d16 = this.f18011b;
        if (d16 > 1.0d) {
            double d17 = this.f18015g;
            double d18 = ((d17 * d15) - d8) / (d17 - this.f18014f);
            double d19 = d15 - d18;
            sin = (Math.pow(2.718281828459045d, this.f18014f * d14) * d18) + (Math.pow(2.718281828459045d, d17 * d14) * d19);
            double d20 = this.f18015g;
            double pow = Math.pow(2.718281828459045d, d20 * d14) * d19 * d20;
            double d21 = this.f18014f;
            cos = (Math.pow(2.718281828459045d, d21 * d14) * d18 * d21) + pow;
        } else if (d16 == 1.0d) {
            double d22 = this.f18010a;
            double d23 = (d22 * d15) + d8;
            double d24 = (d23 * d14) + d15;
            double pow2 = Math.pow(2.718281828459045d, (-d22) * d14) * d24;
            double pow3 = Math.pow(2.718281828459045d, (-this.f18010a) * d14) * d24;
            double d25 = -this.f18010a;
            cos = (Math.pow(2.718281828459045d, d25 * d14) * d23) + (pow3 * d25);
            sin = pow2;
        } else {
            double d26 = 1.0d / this.f18016h;
            double d27 = this.f18010a;
            double d28 = ((d16 * d27 * d15) + d8) * d26;
            sin = ((Math.sin(this.f18016h * d14) * d28) + (Math.cos(this.f18016h * d14) * d15)) * Math.pow(2.718281828459045d, (-d16) * d27 * d14);
            double d29 = this.f18010a;
            double d30 = this.f18011b;
            double d31 = (-d29) * sin * d30;
            double pow4 = Math.pow(2.718281828459045d, (-d30) * d29 * d14);
            double d32 = this.f18016h;
            double sin2 = Math.sin(d32 * d14) * (-d32) * d15;
            double d33 = this.f18016h;
            cos = (((Math.cos(d33 * d14) * d28 * d33) + sin2) * pow4) + d31;
        }
        float f2 = (float) (sin + this.f18017i);
        d dVar = this.f18018j;
        dVar.f17991a = f2;
        dVar.f17992b = (float) cos;
        return dVar;
    }

    public i(float f2) {
        this.f18010a = Math.sqrt(1500.0d);
        this.f18011b = 0.5d;
        this.f18012c = false;
        this.f18018j = new d();
        this.f18017i = f2;
    }
}
