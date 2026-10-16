package p0;

/* loaded from: classes.dex */
public final class j implements l {

    /* renamed from: a, reason: collision with root package name */
    public double f17331a;

    /* renamed from: b, reason: collision with root package name */
    public double f17332b;

    /* renamed from: c, reason: collision with root package name */
    public double f17333c;

    /* renamed from: d, reason: collision with root package name */
    public float f17334d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f17335f;

    /* renamed from: g, reason: collision with root package name */
    public float f17336g;

    /* renamed from: h, reason: collision with root package name */
    public float f17337h;

    /* renamed from: i, reason: collision with root package name */
    public int f17338i;

    @Override // p0.l
    public final boolean a() {
        double d5 = this.e - this.f17333c;
        double d8 = this.f17332b;
        double d10 = this.f17335f;
        return Math.sqrt((((d8 * d5) * d5) + ((d10 * d10) * ((double) this.f17336g))) / d8) <= ((double) this.f17337h);
    }

    @Override // p0.l
    public final float b() {
        return 0.0f;
    }

    @Override // p0.l
    public final float getInterpolation(float f2) {
        double d5 = f2 - this.f17334d;
        double d8 = this.f17332b;
        double d10 = this.f17331a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d8 / this.f17336g) * d5) * 4.0d)) + 1.0d);
        double d11 = d5 / sqrt;
        int i3 = 0;
        while (i3 < sqrt) {
            double d12 = this.e;
            double d13 = this.f17333c;
            double d14 = d11;
            double d15 = this.f17335f;
            double d16 = this.f17336g;
            double d17 = ((((((-d8) * (d12 - d13)) - (d10 * d15)) / d16) * d14) / 2.0d) + d15;
            double d18 = ((((-((((d14 * d17) / 2.0d) + d12) - d13)) * d8) - (d17 * d10)) / d16) * d14;
            double d19 = (d18 / 2.0d) + d15;
            float f10 = (float) (d15 + d18);
            this.f17335f = f10;
            float f11 = (float) ((d19 * d14) + d12);
            this.e = f11;
            int i10 = this.f17338i;
            if (i10 > 0) {
                if (f11 < 0.0f && (i10 & 1) == 1) {
                    this.e = -f11;
                    this.f17335f = -f10;
                }
                float f12 = this.e;
                if (f12 > 1.0f && (i10 & 2) == 2) {
                    this.e = 2.0f - f12;
                    this.f17335f = -this.f17335f;
                }
            }
            i3++;
            d11 = d14;
        }
        this.f17334d = f2;
        return this.e;
    }
}
