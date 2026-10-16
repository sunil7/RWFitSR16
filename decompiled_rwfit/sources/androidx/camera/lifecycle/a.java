package androidx.camera.lifecycle;

import androidx.lifecycle.s;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final s f1550a;

    /* renamed from: b, reason: collision with root package name */
    public final y.a f1551b;

    public a(s sVar, y.a aVar) {
        if (sVar == null) {
            throw new NullPointerException("Null lifecycleOwner");
        }
        this.f1550a = sVar;
        if (aVar == null) {
            throw new NullPointerException("Null cameraId");
        }
        this.f1551b = aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f1550a.equals(aVar.f1550a) && this.f1551b.equals(aVar.f1551b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f1550a.hashCode() ^ 1000003) * 1000003) ^ this.f1551b.hashCode();
    }

    public final String toString() {
        return "Key{lifecycleOwner=" + this.f1550a + ", cameraId=" + this.f1551b + "}";
    }
}
