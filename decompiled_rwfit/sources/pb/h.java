package pb;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Class f17514a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f17515b;

    public h(Class cls, boolean z5) {
        this.f17514a = cls;
        this.f17515b = z5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.f17514a.equals(this.f17514a) && hVar.f17515b == this.f17515b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f17514a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f17515b).hashCode();
    }
}
