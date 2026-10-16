package s4;

import java.security.MessageDigest;
import t4.f;

/* loaded from: classes.dex */
public final class d implements x3.c {

    /* renamed from: b, reason: collision with root package name */
    public final Object f18209b;

    public d(Object obj) {
        f.c(obj, "Argument must not be null");
        this.f18209b = obj;
    }

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(this.f18209b.toString().getBytes(x3.c.f19771a));
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f18209b.equals(((d) obj).f18209b);
        }
        return false;
    }

    @Override // x3.c
    public final int hashCode() {
        return this.f18209b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f18209b + '}';
    }
}
