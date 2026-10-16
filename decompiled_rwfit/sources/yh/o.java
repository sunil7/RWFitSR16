package yh;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f20178a;

    /* renamed from: b, reason: collision with root package name */
    public final m f20179b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f20180c = true;

    public o(Object obj, m mVar) {
        this.f20178a = obj;
        this.f20179b = mVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f20178a == oVar.f20178a && this.f20179b.equals(oVar.f20179b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f20179b.f20175f.hashCode() + this.f20178a.hashCode();
    }
}
