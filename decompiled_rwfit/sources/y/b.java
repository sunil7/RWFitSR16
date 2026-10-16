package y;

import t.i1;

/* loaded from: classes.dex */
public final class b implements i1 {

    /* renamed from: a, reason: collision with root package name */
    public final float f19831a;

    /* renamed from: b, reason: collision with root package name */
    public final float f19832b;

    /* renamed from: c, reason: collision with root package name */
    public final float f19833c;

    /* renamed from: d, reason: collision with root package name */
    public final float f19834d;

    public b(float f2, float f10, float f11, float f12) {
        this.f19831a = f2;
        this.f19832b = f10;
        this.f19833c = f11;
        this.f19834d = f12;
    }

    public static b e(i1 i1Var) {
        return new b(i1Var.b(), i1Var.a(), i1Var.d(), i1Var.c());
    }

    @Override // t.i1
    public final float a() {
        return this.f19832b;
    }

    @Override // t.i1
    public final float b() {
        return this.f19831a;
    }

    @Override // t.i1
    public final float c() {
        return this.f19834d;
    }

    @Override // t.i1
    public final float d() {
        return this.f19833c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (Float.floatToIntBits(this.f19831a) == Float.floatToIntBits(bVar.f19831a) && Float.floatToIntBits(this.f19832b) == Float.floatToIntBits(bVar.f19832b) && Float.floatToIntBits(this.f19833c) == Float.floatToIntBits(bVar.f19833c) && Float.floatToIntBits(this.f19834d) == Float.floatToIntBits(bVar.f19834d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((Float.floatToIntBits(this.f19831a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.f19832b)) * 1000003) ^ Float.floatToIntBits(this.f19833c)) * 1000003) ^ Float.floatToIntBits(this.f19834d);
    }

    public final String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.f19831a + ", maxZoomRatio=" + this.f19832b + ", minZoomRatio=" + this.f19833c + ", linearZoom=" + this.f19834d + "}";
    }
}
