package x7;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f19820a;

    public b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f19820a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f19820a.equals(((b) obj).f19820a);
    }

    public final int hashCode() {
        return this.f19820a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return r5.a.f(new StringBuilder("Encoding{name=\""), this.f19820a, "\"}");
    }
}
