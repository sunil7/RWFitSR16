package t;

import androidx.camera.core.CameraState$Type;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final CameraState$Type f18298a;

    /* renamed from: b, reason: collision with root package name */
    public final f f18299b;

    public e(CameraState$Type cameraState$Type, f fVar) {
        if (cameraState$Type == null) {
            throw new NullPointerException("Null type");
        }
        this.f18298a = cameraState$Type;
        this.f18299b = fVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f18298a.equals(eVar.f18298a)) {
                f fVar = eVar.f18299b;
                f fVar2 = this.f18299b;
                if (fVar2 != null ? fVar2.equals(fVar) : fVar == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f18298a.hashCode() ^ 1000003) * 1000003;
        f fVar = this.f18299b;
        return hashCode ^ (fVar == null ? 0 : fVar.hashCode());
    }

    public final String toString() {
        return "CameraState{type=" + this.f18298a + ", error=" + this.f18299b + "}";
    }
}
