package t;

import android.graphics.Rect;
import android.util.Size;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Size f18342a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f18343b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.camera.core.impl.v f18344c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18345d;
    public final boolean e;

    public i(Size size, Rect rect, androidx.camera.core.impl.v vVar, int i3, boolean z5) {
        if (size == null) {
            throw new NullPointerException("Null inputSize");
        }
        this.f18342a = size;
        if (rect == null) {
            throw new NullPointerException("Null inputCropRect");
        }
        this.f18343b = rect;
        this.f18344c = vVar;
        this.f18345d = i3;
        this.e = z5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f18342a.equals(iVar.f18342a) && this.f18343b.equals(iVar.f18343b)) {
                androidx.camera.core.impl.v vVar = iVar.f18344c;
                androidx.camera.core.impl.v vVar2 = this.f18344c;
                if (vVar2 != null ? vVar2.equals(vVar) : vVar == null) {
                    if (this.f18345d == iVar.f18345d && this.e == iVar.e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((this.f18342a.hashCode() ^ 1000003) * 1000003) ^ this.f18343b.hashCode()) * 1000003;
        androidx.camera.core.impl.v vVar = this.f18344c;
        return ((((hashCode ^ (vVar == null ? 0 : vVar.hashCode())) * 1000003) ^ this.f18345d) * 1000003) ^ (this.e ? 1231 : 1237);
    }

    public final String toString() {
        return "CameraInputInfo{inputSize=" + this.f18342a + ", inputCropRect=" + this.f18343b + ", cameraInternal=" + this.f18344c + ", rotationDegrees=" + this.f18345d + ", mirroring=" + this.e + "}";
    }
}
