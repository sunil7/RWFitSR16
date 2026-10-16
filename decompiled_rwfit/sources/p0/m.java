package p0;

/* loaded from: classes.dex */
public final class m implements l {

    /* renamed from: a, reason: collision with root package name */
    public float f17339a;

    /* renamed from: b, reason: collision with root package name */
    public float f17340b;

    /* renamed from: c, reason: collision with root package name */
    public float f17341c;

    /* renamed from: d, reason: collision with root package name */
    public float f17342d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f17343f;

    /* renamed from: g, reason: collision with root package name */
    public float f17344g;

    /* renamed from: h, reason: collision with root package name */
    public float f17345h;

    /* renamed from: i, reason: collision with root package name */
    public float f17346i;

    /* renamed from: j, reason: collision with root package name */
    public int f17347j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f17348k;

    /* renamed from: l, reason: collision with root package name */
    public float f17349l;

    /* renamed from: m, reason: collision with root package name */
    public float f17350m;

    @Override // p0.l
    public final boolean a() {
        return b() < 1.0E-5f && Math.abs(this.f17346i - this.f17350m) < 1.0E-5f;
    }

    @Override // p0.l
    public final float b() {
        return this.f17348k ? -c(this.f17350m) : c(this.f17350m);
    }

    public final float c(float f2) {
        float f10;
        float f11;
        float f12 = this.f17342d;
        if (f2 <= f12) {
            f10 = this.f17339a;
            f11 = this.f17340b;
        } else {
            int i3 = this.f17347j;
            if (i3 == 1) {
                return 0.0f;
            }
            f2 -= f12;
            f12 = this.e;
            if (f2 >= f12) {
                if (i3 == 2) {
                    return this.f17345h;
                }
                float f13 = f2 - f12;
                float f14 = this.f17343f;
                if (f13 >= f14) {
                    return this.f17346i;
                }
                float f15 = this.f17341c;
                return f15 - ((f13 * f15) / f14);
            }
            f10 = this.f17340b;
            f11 = this.f17341c;
        }
        return (((f11 - f10) * f2) / f12) + f10;
    }

    public final void d(float f2, float f10, float f11, float f12, float f13) {
        if (f2 == 0.0f) {
            f2 = 1.0E-4f;
        }
        this.f17339a = f2;
        float f14 = f2 / f11;
        float f15 = (f14 * f2) / 2.0f;
        if (f2 < 0.0f) {
            float sqrt = (float) Math.sqrt((f10 - ((((-f2) / f11) * f2) / 2.0f)) * f11);
            if (sqrt < f12) {
                this.f17347j = 2;
                this.f17339a = f2;
                this.f17340b = sqrt;
                this.f17341c = 0.0f;
                float f16 = (sqrt - f2) / f11;
                this.f17342d = f16;
                this.e = sqrt / f11;
                this.f17344g = ((f2 + sqrt) * f16) / 2.0f;
                this.f17345h = f10;
                this.f17346i = f10;
                return;
            }
            this.f17347j = 3;
            this.f17339a = f2;
            this.f17340b = f12;
            this.f17341c = f12;
            float f17 = (f12 - f2) / f11;
            this.f17342d = f17;
            float f18 = f12 / f11;
            this.f17343f = f18;
            float f19 = ((f2 + f12) * f17) / 2.0f;
            float f20 = (f18 * f12) / 2.0f;
            this.e = ((f10 - f19) - f20) / f12;
            this.f17344g = f19;
            this.f17345h = f10 - f20;
            this.f17346i = f10;
            return;
        }
        if (f15 >= f10) {
            this.f17347j = 1;
            this.f17339a = f2;
            this.f17340b = 0.0f;
            this.f17344g = f10;
            this.f17342d = (2.0f * f10) / f2;
            return;
        }
        float f21 = f10 - f15;
        float f22 = f21 / f2;
        if (f22 + f14 < f13) {
            this.f17347j = 2;
            this.f17339a = f2;
            this.f17340b = f2;
            this.f17341c = 0.0f;
            this.f17344g = f21;
            this.f17345h = f10;
            this.f17342d = f22;
            this.e = f14;
            return;
        }
        float sqrt2 = (float) Math.sqrt(((f2 * f2) / 2.0f) + (f11 * f10));
        float f23 = (sqrt2 - f2) / f11;
        this.f17342d = f23;
        float f24 = sqrt2 / f11;
        this.e = f24;
        if (sqrt2 < f12) {
            this.f17347j = 2;
            this.f17339a = f2;
            this.f17340b = sqrt2;
            this.f17341c = 0.0f;
            this.f17342d = f23;
            this.e = f24;
            this.f17344g = ((f2 + sqrt2) * f23) / 2.0f;
            this.f17345h = f10;
            return;
        }
        this.f17347j = 3;
        this.f17339a = f2;
        this.f17340b = f12;
        this.f17341c = f12;
        float f25 = (f12 - f2) / f11;
        this.f17342d = f25;
        float f26 = f12 / f11;
        this.f17343f = f26;
        float f27 = ((f2 + f12) * f25) / 2.0f;
        float f28 = (f26 * f12) / 2.0f;
        this.e = ((f10 - f27) - f28) / f12;
        this.f17344g = f27;
        this.f17345h = f10 - f28;
        this.f17346i = f10;
    }

    @Override // p0.l
    public final float getInterpolation(float f2) {
        float f10;
        float f11 = this.f17342d;
        if (f2 <= f11) {
            float f12 = this.f17339a;
            f10 = ((((this.f17340b - f12) * f2) * f2) / (f11 * 2.0f)) + (f12 * f2);
        } else {
            int i3 = this.f17347j;
            if (i3 == 1) {
                f10 = this.f17344g;
            } else {
                float f13 = f2 - f11;
                float f14 = this.e;
                if (f13 < f14) {
                    float f15 = this.f17344g;
                    float f16 = this.f17340b;
                    f10 = ((((this.f17341c - f16) * f13) * f13) / (f14 * 2.0f)) + (f16 * f13) + f15;
                } else if (i3 == 2) {
                    f10 = this.f17345h;
                } else {
                    float f17 = f13 - f14;
                    float f18 = this.f17343f;
                    if (f17 <= f18) {
                        float f19 = this.f17345h;
                        float f20 = this.f17341c * f17;
                        f10 = (f19 + f20) - ((f20 * f17) / (f18 * 2.0f));
                    } else {
                        f10 = this.f17346i;
                    }
                }
            }
        }
        this.f17350m = f2;
        return this.f17348k ? this.f17349l - f10 : this.f17349l + f10;
    }
}
