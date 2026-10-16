package d4;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f12269a;

    public j(String str) {
        this.f12269a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f12269a.equals(((j) obj).f12269a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12269a.hashCode();
    }

    public final String toString() {
        return r5.a.f(new StringBuilder("StringHeaderFactory{value='"), this.f12269a, "'}");
    }
}
