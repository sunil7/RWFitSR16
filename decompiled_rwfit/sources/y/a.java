package y;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f19829a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.camera.core.impl.d f19830b;

    public a(String str, androidx.camera.core.impl.d dVar) {
        if (str == null) {
            throw new NullPointerException("Null cameraIdString");
        }
        this.f19829a = str;
        if (dVar == null) {
            throw new NullPointerException("Null cameraConfigId");
        }
        this.f19830b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f19829a.equals(aVar.f19829a) && this.f19830b.equals(aVar.f19830b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f19829a.hashCode() ^ 1000003) * 1000003) ^ this.f19830b.hashCode();
    }

    public final String toString() {
        return "CameraId{cameraIdString=" + this.f19829a + ", cameraConfigId=" + this.f19830b + "}";
    }
}
