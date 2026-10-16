package eb;

/* loaded from: classes.dex */
public final class i extends e {

    /* renamed from: c, reason: collision with root package name */
    public final f f12525c;

    /* renamed from: d, reason: collision with root package name */
    public final float f12526d;

    public i(f fVar, float f2) {
        super(0);
        this.f12525c = fVar;
        this.f12526d = f2;
    }

    @Override // eb.e
    public final boolean p() {
        return true;
    }

    @Override // eb.e
    public final void q(float f2, float f10, float f11, w wVar) {
        this.f12525c.q(f2, f10 - this.f12526d, f11, wVar);
    }
}
