package t4;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public Class f18519a;

    /* renamed from: b, reason: collision with root package name */
    public Class f18520b;

    /* renamed from: c, reason: collision with root package name */
    public Class f18521c;

    public j(Class cls, Class cls2, Class cls3) {
        this.f18519a = cls;
        this.f18520b = cls2;
        this.f18521c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f18519a.equals(jVar.f18519a) && this.f18520b.equals(jVar.f18520b) && l.a(this.f18521c, jVar.f18521c);
    }

    public final int hashCode() {
        int hashCode = (this.f18520b.hashCode() + (this.f18519a.hashCode() * 31)) * 31;
        Class cls = this.f18521c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f18519a + ", second=" + this.f18520b + '}';
    }
}
