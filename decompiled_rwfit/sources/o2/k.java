package o2;

/* loaded from: classes.dex */
public final class k extends l {

    /* renamed from: a, reason: collision with root package name */
    public final f f16717a;

    public k(f fVar) {
        this.f16717a = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        return this.f16717a.equals(((k) obj).f16717a);
    }

    public final int hashCode() {
        return this.f16717a.hashCode() + (k.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Success {mOutputData=" + this.f16717a + '}';
    }
}
