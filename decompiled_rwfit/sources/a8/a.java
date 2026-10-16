package a8;

import java.util.HashMap;
import n.g0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f115a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f116b;

    /* renamed from: c, reason: collision with root package name */
    public final e f117c;

    /* renamed from: d, reason: collision with root package name */
    public final long f118d;
    public final long e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f119f;

    public a(String str, Integer num, e eVar, long j4, long j10, HashMap hashMap) {
        this.f115a = str;
        this.f116b = num;
        this.f117c = eVar;
        this.f118d = j4;
        this.e = j10;
        this.f119f = hashMap;
    }

    public final String a(String str) {
        String str2 = (String) this.f119f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f119f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final g0 c() {
        g0 g0Var = new g0();
        String str = this.f115a;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        g0Var.f16174a = str;
        g0Var.f16175b = this.f116b;
        e eVar = this.f117c;
        if (eVar == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        g0Var.f16176c = eVar;
        g0Var.f16177d = Long.valueOf(this.f118d);
        g0Var.e = Long.valueOf(this.e);
        g0Var.f16178f = new HashMap(this.f119f);
        return g0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f115a.equals(aVar.f115a)) {
            return false;
        }
        Integer num = aVar.f116b;
        Integer num2 = this.f116b;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        return this.f117c.equals(aVar.f117c) && this.f118d == aVar.f118d && this.e == aVar.e && this.f119f.equals(aVar.f119f);
    }

    public final int hashCode() {
        int hashCode = (this.f115a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f116b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f117c.hashCode()) * 1000003;
        long j4 = this.f118d;
        int i3 = (hashCode2 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j10 = this.e;
        return ((i3 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ this.f119f.hashCode();
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f115a + ", code=" + this.f116b + ", encodedPayload=" + this.f117c + ", eventMillis=" + this.f118d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f119f + "}";
    }
}
