package j9;

/* loaded from: classes.dex */
public final class f {
    public static final f e = new f(0, 1.0f, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f15379a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15380b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15381c;

    /* renamed from: d, reason: collision with root package name */
    public final float f15382d;

    public f(int i3, float f2, int i10, int i11) {
        this.f15379a = i3;
        this.f15380b = i10;
        this.f15381c = i11;
        this.f15382d = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f15379a == fVar.f15379a && this.f15380b == fVar.f15380b && this.f15381c == fVar.f15381c && this.f15382d == fVar.f15382d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f15382d) + ((((((217 + this.f15379a) * 31) + this.f15380b) * 31) + this.f15381c) * 31);
    }
}
