package x3;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class f implements c {

    /* renamed from: b, reason: collision with root package name */
    public final t4.c f19776b = new t4.c();

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        int i3 = 0;
        while (true) {
            t4.c cVar = this.f19776b;
            if (i3 >= cVar.f15919c) {
                return;
            }
            e eVar = (e) cVar.h(i3);
            Object l3 = this.f19776b.l(i3);
            d dVar = eVar.f19773b;
            if (eVar.f19775d == null) {
                eVar.f19775d = eVar.f19774c.getBytes(c.f19771a);
            }
            dVar.d(eVar.f19775d, l3, messageDigest);
            i3++;
        }
    }

    public final Object c(e eVar) {
        t4.c cVar = this.f19776b;
        return cVar.containsKey(eVar) ? cVar.getOrDefault(eVar, null) : eVar.f19772a;
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f19776b.equals(((f) obj).f19776b);
        }
        return false;
    }

    @Override // x3.c
    public final int hashCode() {
        return this.f19776b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f19776b + '}';
    }
}
