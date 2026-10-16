package sc;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final float f18245a;

    /* renamed from: b, reason: collision with root package name */
    public final float f18246b;

    /* renamed from: c, reason: collision with root package name */
    public final float f18247c;

    /* renamed from: d, reason: collision with root package name */
    public final float f18248d;
    public final float e;

    /* renamed from: f, reason: collision with root package name */
    public final float f18249f;

    /* renamed from: g, reason: collision with root package name */
    public final float f18250g;

    /* renamed from: h, reason: collision with root package name */
    public final float f18251h;

    /* renamed from: i, reason: collision with root package name */
    public final float f18252i;

    public h(float f2, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        this.f18245a = f2;
        this.f18246b = f12;
        this.f18247c = f15;
        this.f18248d = f10;
        this.e = f13;
        this.f18249f = f16;
        this.f18250g = f11;
        this.f18251h = f14;
        this.f18252i = f17;
    }

    public static h a(float f2, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24) {
        h b3 = b(f2, f10, f11, f12, f13, f14, f15, f16);
        float f25 = b3.e;
        float f26 = b3.f18252i;
        float f27 = b3.f18249f;
        float f28 = b3.f18251h;
        float f29 = (f25 * f26) - (f27 * f28);
        float f30 = b3.f18250g;
        float f31 = b3.f18248d;
        float f32 = (f27 * f30) - (f31 * f26);
        float f33 = (f31 * f28) - (f25 * f30);
        float f34 = b3.f18247c;
        float f35 = b3.f18246b;
        float f36 = (f34 * f28) - (f35 * f26);
        float f37 = b3.f18245a;
        float f38 = (f26 * f37) - (f34 * f30);
        float f39 = (f30 * f35) - (f28 * f37);
        float f40 = (f35 * f27) - (f34 * f25);
        float f41 = (f34 * f31) - (f27 * f37);
        float f42 = (f37 * f25) - (f35 * f31);
        h b10 = b(f17, f18, f19, f20, f21, f22, f23, f24);
        float f43 = b10.f18245a;
        float f44 = b10.f18248d;
        float f45 = b10.f18250g;
        float f46 = (f45 * f40) + (f44 * f36) + (f43 * f29);
        float f47 = (f45 * f41) + (f44 * f38) + (f43 * f32);
        float f48 = f45 * f42;
        float f49 = f48 + (f44 * f39) + (f43 * f33);
        float f50 = b10.f18246b;
        float f51 = b10.e;
        float f52 = b10.f18251h;
        float f53 = (f52 * f40) + (f51 * f36) + (f50 * f29);
        float f54 = (f52 * f41) + (f51 * f38) + (f50 * f32);
        float f55 = f52 * f42;
        float f56 = f55 + (f51 * f39) + (f50 * f33);
        float f57 = b10.f18247c;
        float f58 = b10.f18249f;
        float f59 = f36 * f58;
        float f60 = b10.f18252i;
        return new h(f46, f47, f49, f53, f54, f56, (f40 * f60) + f59 + (f29 * f57), (f41 * f60) + (f38 * f58) + (f32 * f57), (f60 * f42) + (f58 * f39) + (f57 * f33));
    }

    public static h b(float f2, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        float f17 = ((f2 - f11) + f13) - f15;
        float f18 = ((f10 - f12) + f14) - f16;
        if (f17 == 0.0f && f18 == 0.0f) {
            return new h(f11 - f2, f13 - f11, f2, f12 - f10, f14 - f12, f10, 0.0f, 0.0f, 1.0f);
        }
        float f19 = f11 - f13;
        float f20 = f15 - f13;
        float f21 = f12 - f14;
        float f22 = f16 - f14;
        float f23 = (f19 * f22) - (f20 * f21);
        float f24 = ((f22 * f17) - (f20 * f18)) / f23;
        float f25 = ((f19 * f18) - (f17 * f21)) / f23;
        return new h((f24 * f11) + (f11 - f2), (f25 * f15) + (f15 - f2), f2, (f24 * f12) + (f12 - f10), (f25 * f16) + (f16 - f10), f10, f24, f25, 1.0f);
    }
}
