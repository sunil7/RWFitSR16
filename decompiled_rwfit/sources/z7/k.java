package z7;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class k extends q {

    /* renamed from: a, reason: collision with root package name */
    public final long f20369a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f20370b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20371c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f20372d;
    public final String e;

    /* renamed from: f, reason: collision with root package name */
    public final long f20373f;

    /* renamed from: g, reason: collision with root package name */
    public final n f20374g;

    public k(long j4, Integer num, long j10, byte[] bArr, String str, long j11, n nVar) {
        this.f20369a = j4;
        this.f20370b = num;
        this.f20371c = j10;
        this.f20372d = bArr;
        this.e = str;
        this.f20373f = j11;
        this.f20374g = nVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        k kVar = (k) qVar;
        if (this.f20369a != kVar.f20369a) {
            return false;
        }
        Integer num = this.f20370b;
        if (num == null) {
            if (kVar.f20370b != null) {
                return false;
            }
        } else if (!num.equals(kVar.f20370b)) {
            return false;
        }
        if (this.f20371c != kVar.f20371c) {
            return false;
        }
        if (!Arrays.equals(this.f20372d, qVar instanceof k ? ((k) qVar).f20372d : kVar.f20372d)) {
            return false;
        }
        String str = kVar.e;
        String str2 = this.e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (this.f20373f != kVar.f20373f) {
            return false;
        }
        n nVar = kVar.f20374g;
        n nVar2 = this.f20374g;
        return nVar2 == null ? nVar == null : nVar2.equals(nVar);
    }

    public final int hashCode() {
        long j4 = this.f20369a;
        int i3 = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f20370b;
        int hashCode = (i3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j10 = this.f20371c;
        int hashCode2 = (((hashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f20372d)) * 1000003;
        String str = this.e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j11 = this.f20373f;
        int i10 = (hashCode3 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        n nVar = this.f20374g;
        return i10 ^ (nVar != null ? nVar.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f20369a + ", eventCode=" + this.f20370b + ", eventUptimeMs=" + this.f20371c + ", sourceExtension=" + Arrays.toString(this.f20372d) + ", sourceExtensionJsonProto3=" + this.e + ", timezoneOffsetSeconds=" + this.f20373f + ", networkConnectionInfo=" + this.f20374g + "}";
    }
}
