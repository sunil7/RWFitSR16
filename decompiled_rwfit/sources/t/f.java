package t;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f18317a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f18318b;

    public f(int i3, Throwable th2) {
        this.f18317a = i3;
        this.f18318b = th2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f18317a == fVar.f18317a) {
                Throwable th2 = fVar.f18318b;
                Throwable th3 = this.f18318b;
                if (th3 != null ? th3.equals(th2) : th2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = (this.f18317a ^ 1000003) * 1000003;
        Throwable th2 = this.f18318b;
        return i3 ^ (th2 == null ? 0 : th2.hashCode());
    }

    public final String toString() {
        return "StateError{code=" + this.f18317a + ", cause=" + this.f18318b + "}";
    }
}
