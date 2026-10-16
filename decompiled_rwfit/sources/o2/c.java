package o2;

import androidx.work.NetworkType;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: i, reason: collision with root package name */
    public static final c f16698i;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16700b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16701c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16702d;
    public boolean e;

    /* renamed from: a, reason: collision with root package name */
    public NetworkType f16699a = NetworkType.NOT_REQUIRED;

    /* renamed from: f, reason: collision with root package name */
    public long f16703f = -1;

    /* renamed from: g, reason: collision with root package name */
    public long f16704g = -1;

    /* renamed from: h, reason: collision with root package name */
    public e f16705h = new e();

    static {
        NetworkType networkType = NetworkType.NOT_REQUIRED;
        e eVar = new e();
        c cVar = new c();
        cVar.f16699a = networkType;
        cVar.f16703f = -1L;
        cVar.f16704g = -1L;
        new HashSet();
        cVar.f16700b = false;
        cVar.f16701c = false;
        cVar.f16699a = networkType;
        cVar.f16702d = false;
        cVar.e = false;
        cVar.f16705h = eVar;
        cVar.f16703f = -1L;
        cVar.f16704g = -1L;
        f16698i = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f16700b == cVar.f16700b && this.f16701c == cVar.f16701c && this.f16702d == cVar.f16702d && this.e == cVar.e && this.f16703f == cVar.f16703f && this.f16704g == cVar.f16704g && this.f16699a == cVar.f16699a) {
            return this.f16705h.equals(cVar.f16705h);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((((((((this.f16699a.hashCode() * 31) + (this.f16700b ? 1 : 0)) * 31) + (this.f16701c ? 1 : 0)) * 31) + (this.f16702d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        long j4 = this.f16703f;
        int i3 = (hashCode + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j10 = this.f16704g;
        return this.f16705h.f16708a.hashCode() + ((i3 + ((int) (j10 ^ (j10 >>> 32)))) * 31);
    }
}
