package th;

/* loaded from: classes2.dex */
public final class f extends d {

    /* renamed from: d, reason: collision with root package name */
    public static final f f18648d = new f(1, 0);

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        long j4 = this.f18641a;
        long j10 = this.f18642b;
        if (j4 > j10) {
            f fVar = (f) obj;
            if (fVar.f18641a > fVar.f18642b) {
                return true;
            }
        }
        f fVar2 = (f) obj;
        return j4 == fVar2.f18641a && j10 == fVar2.f18642b;
    }

    public final int hashCode() {
        long j4 = this.f18641a;
        long j10 = this.f18642b;
        if (j4 > j10) {
            return -1;
        }
        return (int) ((31 * (j4 ^ (j4 >>> 32))) + ((j10 >>> 32) ^ j10));
    }

    public final String toString() {
        return this.f18641a + ".." + this.f18642b;
    }
}
