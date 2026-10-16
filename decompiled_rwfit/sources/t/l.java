package t;

import android.graphics.Matrix;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f18354a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18355b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18356c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f18357d;
    public final Matrix e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f18358f;

    public l(Rect rect, int i3, int i10, boolean z5, Matrix matrix, boolean z6) {
        if (rect == null) {
            throw new NullPointerException("Null getCropRect");
        }
        this.f18354a = rect;
        this.f18355b = i3;
        this.f18356c = i10;
        this.f18357d = z5;
        if (matrix == null) {
            throw new NullPointerException("Null getSensorToBufferTransform");
        }
        this.e = matrix;
        this.f18358f = z6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f18354a.equals(lVar.f18354a) && this.f18355b == lVar.f18355b && this.f18356c == lVar.f18356c && this.f18357d == lVar.f18357d && this.e.equals(lVar.e) && this.f18358f == lVar.f18358f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((this.f18354a.hashCode() ^ 1000003) * 1000003) ^ this.f18355b) * 1000003) ^ this.f18356c) * 1000003) ^ (this.f18357d ? 1231 : 1237)) * 1000003) ^ this.e.hashCode()) * 1000003) ^ (this.f18358f ? 1231 : 1237);
    }

    public final String toString() {
        return "TransformationInfo{getCropRect=" + this.f18354a + ", getRotationDegrees=" + this.f18355b + ", getTargetRotation=" + this.f18356c + ", hasCameraTransform=" + this.f18357d + ", getSensorToBufferTransform=" + this.e + ", isMirroring=" + this.f18358f + "}";
    }
}
