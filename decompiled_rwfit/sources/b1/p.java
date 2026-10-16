package b1;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: k, reason: collision with root package name */
    public static final p f3079k;

    /* renamed from: a, reason: collision with root package name */
    public final float f3080a;

    /* renamed from: b, reason: collision with root package name */
    public final float f3081b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3082c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3083d;
    public final float e;

    /* renamed from: f, reason: collision with root package name */
    public final float f3084f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f3085g;

    /* renamed from: h, reason: collision with root package name */
    public final float f3086h;

    /* renamed from: i, reason: collision with root package name */
    public final float f3087i;

    /* renamed from: j, reason: collision with root package name */
    public final float f3088j;

    static {
        float[] fArr = b.f3053c;
        float i3 = (float) ((b.i() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.f3051a;
        float f2 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f10 = fArr3[0] * f2;
        float f11 = fArr[1];
        float f12 = (fArr3[1] * f11) + f10;
        float f13 = fArr[2];
        float f14 = (fArr3[2] * f13) + f12;
        float[] fArr4 = fArr2[1];
        float f15 = (fArr4[2] * f13) + (fArr4[1] * f11) + (fArr4[0] * f2);
        float[] fArr5 = fArr2[2];
        float f16 = (f13 * fArr5[2]) + (f11 * fArr5[1]) + (f2 * fArr5[0]);
        float f17 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float exp = (1.0f - (((float) Math.exp(((-i3) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d5 = exp;
        if (d5 > 1.0d) {
            exp = 1.0f;
        } else if (d5 < 0.0d) {
            exp = 0.0f;
        }
        float f18 = 1.0f / ((5.0f * i3) + 1.0f);
        float f19 = f18 * f18 * f18 * f18;
        float f20 = 1.0f - f19;
        float cbrt = (0.1f * f20 * f20 * ((float) Math.cbrt(i3 * 5.0d))) + (f19 * i3);
        float i10 = b.i() / fArr[1];
        double d8 = i10;
        float sqrt = ((float) Math.sqrt(d8)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d8, 0.2d));
        float[] fArr6 = {(float) Math.pow(((r9[0] * cbrt) * f14) / 100.0d, 0.42d), (float) Math.pow(((r9[1] * cbrt) * f15) / 100.0d, 0.42d), (float) Math.pow(((r9[2] * cbrt) * f16) / 100.0d, 0.42d)};
        float f21 = fArr6[0];
        float f22 = (f21 * 400.0f) / (f21 + 27.13f);
        float f23 = fArr6[1];
        float f24 = (f23 * 400.0f) / (f23 + 27.13f);
        float f25 = fArr6[2];
        float[] fArr7 = {f22, f24, (400.0f * f25) / (f25 + 27.13f)};
        f3079k = new p(i10, ((fArr7[2] * 0.05f) + (fArr7[0] * 2.0f) + fArr7[1]) * pow, pow, pow, f17, 1.0f, new float[]{(((100.0f / f14) * exp) + 1.0f) - exp, (((100.0f / f15) * exp) + 1.0f) - exp, (((100.0f / f16) * exp) + 1.0f) - exp}, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    public p(float f2, float f10, float f11, float f12, float f13, float f14, float[] fArr, float f15, float f16, float f17) {
        this.f3084f = f2;
        this.f3080a = f10;
        this.f3081b = f11;
        this.f3082c = f12;
        this.f3083d = f13;
        this.e = f14;
        this.f3085g = fArr;
        this.f3086h = f15;
        this.f3087i = f16;
        this.f3088j = f17;
    }
}
