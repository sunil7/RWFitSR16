package a8;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final x7.b f128a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f129b;

    public e(x7.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f128a = bVar;
        this.f129b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f128a.equals(eVar.f128a)) {
            return Arrays.equals(this.f129b, eVar.f129b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f128a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f129b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f128a + ", bytes=[...]}";
    }
}
