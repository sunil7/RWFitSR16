package o2;

/* loaded from: classes.dex */
public final class i extends l {

    /* renamed from: a, reason: collision with root package name */
    public final f f16716a = f.f16710c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        return this.f16716a.equals(((i) obj).f16716a);
    }

    public final int hashCode() {
        return this.f16716a.hashCode() + (i.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Failure {mOutputData=" + this.f16716a + '}';
    }
}
