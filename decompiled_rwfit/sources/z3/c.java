package z3;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class c implements x3.c {

    /* renamed from: b, reason: collision with root package name */
    public final x3.c f20217b;

    /* renamed from: c, reason: collision with root package name */
    public final x3.c f20218c;

    public c(x3.c cVar, x3.c cVar2) {
        this.f20217b = cVar;
        this.f20218c = cVar2;
    }

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        this.f20217b.b(messageDigest);
        this.f20218c.b(messageDigest);
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f20217b.equals(cVar.f20217b) && this.f20218c.equals(cVar.f20218c)) {
                return true;
            }
        }
        return false;
    }

    @Override // x3.c
    public final int hashCode() {
        return this.f20218c.hashCode() + (this.f20217b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f20217b + ", signature=" + this.f20218c + '}';
    }
}
