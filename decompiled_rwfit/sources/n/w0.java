package n;

import t.i1;

/* loaded from: classes.dex */
public final class w0 implements i1 {

    /* renamed from: a, reason: collision with root package name */
    public float f16312a;

    /* renamed from: b, reason: collision with root package name */
    public final float f16313b;

    /* renamed from: c, reason: collision with root package name */
    public final float f16314c;

    /* renamed from: d, reason: collision with root package name */
    public float f16315d;

    public w0(float f2, float f10) {
        this.f16313b = f2;
        this.f16314c = f10;
    }

    @Override // t.i1
    public final float a() {
        return this.f16313b;
    }

    @Override // t.i1
    public final float b() {
        return this.f16312a;
    }

    @Override // t.i1
    public final float c() {
        return this.f16315d;
    }

    @Override // t.i1
    public final float d() {
        return this.f16314c;
    }

    public final void e(float f2) {
        float f10 = this.f16313b;
        float f11 = this.f16314c;
        if (f2 > f10 || f2 < f11) {
            throw new IllegalArgumentException("Requested zoomRatio " + f2 + " is not within valid range [" + f11 + " , " + f10 + "]");
        }
        this.f16312a = f2;
        float f12 = 0.0f;
        if (f10 != f11) {
            if (f2 == f10) {
                f12 = 1.0f;
            } else if (f2 != f11) {
                float f13 = 1.0f / f11;
                f12 = ((1.0f / f2) - f13) / ((1.0f / f10) - f13);
            }
        }
        this.f16315d = f12;
    }
}
