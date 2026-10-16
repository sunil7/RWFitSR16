package a4;

/* loaded from: classes.dex */
public final class e implements i {

    /* renamed from: a, reason: collision with root package name */
    public final f f84a;

    /* renamed from: b, reason: collision with root package name */
    public int f85b;

    /* renamed from: c, reason: collision with root package name */
    public Class f86c;

    public e(f fVar) {
        this.f84a = fVar;
    }

    @Override // a4.i
    public final void a() {
        this.f84a.g(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f85b == eVar.f85b && this.f86c == eVar.f86c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.f85b * 31;
        Class cls = this.f86c;
        return i3 + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.f85b + "array=" + this.f86c + '}';
    }
}
