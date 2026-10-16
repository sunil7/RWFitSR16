package d0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final e0.b f12176a;

    /* renamed from: b, reason: collision with root package name */
    public final e0.b f12177b;

    public a(e0.b bVar, e0.b bVar2) {
        this.f12176a = bVar;
        this.f12177b = bVar2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f12176a.equals(aVar.f12176a) && this.f12177b.equals(aVar.f12177b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f12176a.hashCode() ^ 1000003) * 1000003) ^ this.f12177b.hashCode();
    }

    public final String toString() {
        return "DualOutConfig{primaryOutConfig=" + this.f12176a + ", secondaryOutConfig=" + this.f12177b + "}";
    }
}
