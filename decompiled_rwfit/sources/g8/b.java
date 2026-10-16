package g8;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f13881a;

    /* renamed from: b, reason: collision with root package name */
    public final a8.b f13882b;

    /* renamed from: c, reason: collision with root package name */
    public final a8.a f13883c;

    public b(long j4, a8.b bVar, a8.a aVar) {
        this.f13881a = j4;
        this.f13882b = bVar;
        this.f13883c = aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f13881a == bVar.f13881a && this.f13882b.equals(bVar.f13882b) && this.f13883c.equals(bVar.f13883c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f13881a;
        return ((((((int) ((j4 >>> 32) ^ j4)) ^ 1000003) * 1000003) ^ this.f13882b.hashCode()) * 1000003) ^ this.f13883c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f13881a + ", transportContext=" + this.f13882b + ", event=" + this.f13883c + "}";
    }
}
