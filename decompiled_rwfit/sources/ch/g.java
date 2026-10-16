package ch;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3508a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3509b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f3510c;

    public g(Object obj, long j4, TimeUnit timeUnit) {
        this.f3508a = obj;
        this.f3509b = j4;
        xg.c.b(timeUnit, "unit is null");
        this.f3510c = timeUnit;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (xg.c.a(this.f3508a, gVar.f3508a) && this.f3509b == gVar.f3509b && xg.c.a(this.f3510c, gVar.f3510c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f3508a;
        int hashCode = obj != null ? obj.hashCode() : 0;
        long j4 = this.f3509b;
        return this.f3510c.hashCode() + (((hashCode * 31) + ((int) (j4 ^ (j4 >>> 31)))) * 31);
    }

    public final String toString() {
        return "Timed[time=" + this.f3509b + ", unit=" + this.f3510c + ", value=" + this.f3508a + "]";
    }
}
