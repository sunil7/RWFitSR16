package t;

import android.graphics.Matrix;
import androidx.camera.core.impl.w1;

/* loaded from: classes.dex */
public final class g implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public final w1 f18332a;

    /* renamed from: b, reason: collision with root package name */
    public final long f18333b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18334c;

    /* renamed from: d, reason: collision with root package name */
    public final Matrix f18335d;

    public g(w1 w1Var, long j4, int i3, Matrix matrix) {
        if (w1Var == null) {
            throw new NullPointerException("Null tagBundle");
        }
        this.f18332a = w1Var;
        this.f18333b = j4;
        this.f18334c = i3;
        this.f18335d = matrix;
    }

    @Override // t.n0
    public final w1 a() {
        return this.f18332a;
    }

    @Override // t.n0
    public final int b() {
        return this.f18334c;
    }

    @Override // t.n0
    public final long d() {
        return this.f18333b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f18332a.equals(gVar.f18332a) && this.f18333b == gVar.f18333b && this.f18334c == gVar.f18334c && this.f18335d.equals(gVar.f18335d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f18332a.hashCode() ^ 1000003) * 1000003;
        long j4 = this.f18333b;
        return ((((hashCode ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003) ^ this.f18334c) * 1000003) ^ this.f18335d.hashCode();
    }

    public final String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.f18332a + ", timestamp=" + this.f18333b + ", rotationDegrees=" + this.f18334c + ", sensorToBufferTransformMatrix=" + this.f18335d + "}";
    }
}
