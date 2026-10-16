package n;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f16146a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16147b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16148c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f16149d;

    public c(int i3, int i10, boolean z5, boolean z6) {
        this.f16146a = i3;
        this.f16147b = i10;
        this.f16148c = z5;
        this.f16149d = z6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f16146a == cVar.f16146a && this.f16147b == cVar.f16147b && this.f16148c == cVar.f16148c && this.f16149d == cVar.f16149d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f16146a ^ 1000003) * 1000003) ^ this.f16147b) * 1000003) ^ (this.f16148c ? 1231 : 1237)) * 1000003) ^ (this.f16149d ? 1231 : 1237);
    }

    public final String toString() {
        return "FeatureSettings{cameraMode=" + this.f16146a + ", requiredMaxBitDepth=" + this.f16147b + ", previewStabilizationOn=" + this.f16148c + ", ultraHdrOn=" + this.f16149d + "}";
    }
}
