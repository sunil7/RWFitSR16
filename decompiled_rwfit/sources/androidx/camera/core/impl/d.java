package androidx.camera.core.impl;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1362a;

    public d(Object obj) {
        this.f1362a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        return this.f1362a.equals(((d) obj).f1362a);
    }

    public final int hashCode() {
        return this.f1362a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "Identifier{value=" + this.f1362a + "}";
    }
}
