package v7;

/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: d, reason: collision with root package name */
    public static final f f19175d;

    /* renamed from: b, reason: collision with root package name */
    public float f19176b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public float f19177c = 0.0f;

    static {
        f a3 = f.a(256, new a());
        f19175d = a3;
        a3.f19190f = 0.5f;
    }

    @Override // v7.e
    public final e a() {
        return new a();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f19176b == aVar.f19176b && this.f19177c == aVar.f19177c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f19176b) ^ Float.floatToIntBits(this.f19177c);
    }

    public final String toString() {
        return this.f19176b + "x" + this.f19177c;
    }
}
