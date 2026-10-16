package g8;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f13876f = new a(10485760, 200, 10000, 604800000, 81920);

    /* renamed from: a, reason: collision with root package name */
    public final long f13877a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13878b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13879c;

    /* renamed from: d, reason: collision with root package name */
    public final long f13880d;
    public final int e;

    public a(long j4, int i3, int i10, long j10, int i11) {
        this.f13877a = j4;
        this.f13878b = i3;
        this.f13879c = i10;
        this.f13880d = j10;
        this.e = i11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f13877a == aVar.f13877a && this.f13878b == aVar.f13878b && this.f13879c == aVar.f13879c && this.f13880d == aVar.f13880d && this.e == aVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f13877a;
        int i3 = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f13878b) * 1000003) ^ this.f13879c) * 1000003;
        long j10 = this.f13880d;
        return ((i3 ^ ((int) ((j10 >>> 32) ^ j10))) * 1000003) ^ this.e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb2.append(this.f13877a);
        sb2.append(", loadBatchSize=");
        sb2.append(this.f13878b);
        sb2.append(", criticalSectionEnterTimeoutMs=");
        sb2.append(this.f13879c);
        sb2.append(", eventCleanUpAge=");
        sb2.append(this.f13880d);
        sb2.append(", maxBlobByteSizePerRow=");
        return r5.a.e(sb2, this.e, "}");
    }
}
