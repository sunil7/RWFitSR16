package kotlin.jvm.internal;

/* loaded from: classes2.dex */
public final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public final Class f15650a;

    public f(Class jClass) {
        e.f(jClass, "jClass");
        this.f15650a = jClass;
    }

    @Override // kotlin.jvm.internal.a
    public final Class a() {
        return this.f15650a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return e.a(this.f15650a, ((f) obj).f15650a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f15650a.hashCode();
    }

    public final String toString() {
        return this.f15650a.toString() + " (Kotlin reflection is not available)";
    }
}
