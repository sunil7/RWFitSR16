package eb;

/* loaded from: classes.dex */
public final class f extends e {

    /* renamed from: c, reason: collision with root package name */
    public final float f12487c;

    public f(float f2) {
        super(0);
        this.f12487c = f2 - 0.001f;
    }

    @Override // eb.e
    public final void q(float f2, float f10, float f11, w wVar) {
        double d5 = this.f12487c;
        float sqrt = (float) ((Math.sqrt(2.0d) * d5) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(d5, 2.0d) - Math.pow(sqrt, 2.0d));
        wVar.e(f10 - sqrt, ((float) (-((Math.sqrt(2.0d) * d5) - d5))) + sqrt2, 270.0f, 0.0f);
        wVar.d(f10, (float) (-((Math.sqrt(2.0d) * d5) - d5)));
        wVar.d(f10 + sqrt, ((float) (-((Math.sqrt(2.0d) * d5) - d5))) + sqrt2);
    }
}
