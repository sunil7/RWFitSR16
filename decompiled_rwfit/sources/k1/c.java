package k1;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f15450a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15451b;

    public c(Object obj, Object obj2) {
        this.f15450a = obj;
        this.f15451b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return b.a(cVar.f15450a, this.f15450a) && b.a(cVar.f15451b, this.f15451b);
    }

    public final int hashCode() {
        Object obj = this.f15450a;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f15451b;
        return (obj2 != null ? obj2.hashCode() : 0) ^ hashCode;
    }

    public final String toString() {
        return "Pair{" + this.f15450a + " " + this.f15451b + "}";
    }
}
