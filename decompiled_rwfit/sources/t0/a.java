package t0;

/* loaded from: classes.dex */
public final class a extends u0.o {

    /* renamed from: a, reason: collision with root package name */
    public final p0.m f18438a;

    /* renamed from: b, reason: collision with root package name */
    public p0.j f18439b;

    /* renamed from: c, reason: collision with root package name */
    public p0.l f18440c;

    public a() {
        p0.m mVar = new p0.m();
        mVar.f17348k = false;
        this.f18438a = mVar;
        this.f18440c = mVar;
    }

    @Override // u0.o
    public final float a() {
        return this.f18440c.b();
    }

    public final void b(float f2, float f10, float f11, float f12, float f13, float f14) {
        p0.m mVar = this.f18438a;
        this.f18440c = mVar;
        mVar.f17349l = f2;
        boolean z5 = f2 > f10;
        mVar.f17348k = z5;
        if (z5) {
            mVar.d(-f11, f2 - f10, f13, f14, f12);
        } else {
            mVar.d(f11, f10 - f2, f13, f14, f12);
        }
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        return this.f18440c.getInterpolation(f2);
    }
}
