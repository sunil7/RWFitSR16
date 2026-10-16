package f8;

import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final long f13505a;

    /* renamed from: b, reason: collision with root package name */
    public final long f13506b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f13507c;

    public c(long j4, long j10, Set set) {
        this.f13505a = j4;
        this.f13506b = j10;
        this.f13507c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f13505a == cVar.f13505a && this.f13506b == cVar.f13506b && this.f13507c.equals(cVar.f13507c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f13505a;
        int i3 = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        long j10 = this.f13506b;
        return ((i3 ^ ((int) ((j10 >>> 32) ^ j10))) * 1000003) ^ this.f13507c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f13505a + ", maxAllowedDelay=" + this.f13506b + ", flags=" + this.f13507c + "}";
    }
}
