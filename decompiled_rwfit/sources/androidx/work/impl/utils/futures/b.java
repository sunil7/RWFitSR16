package androidx.work.impl.utils.futures;

import z2.d;
import z2.g;

/* loaded from: classes.dex */
public final class b extends g {
    public final boolean j(Object obj) {
        if (obj == null) {
            obj = g.f20202g;
        }
        if (!g.f20201f.b(this, null, obj)) {
            return false;
        }
        g.c(this);
        return true;
    }

    public final boolean k(Throwable th2) {
        if (!g.f20201f.b(this, null, new a(th2))) {
            return false;
        }
        g.c(this);
        return true;
    }

    public final boolean l(ob.a aVar) {
        a aVar2;
        aVar.getClass();
        Object obj = this.f20203a;
        if (obj == null) {
            if (aVar.isDone()) {
                if (g.f20201f.b(this, null, g.f(aVar))) {
                    g.c(this);
                    return true;
                }
                return false;
            }
            d dVar = new d(this, aVar);
            if (g.f20201f.b(this, null, dVar)) {
                try {
                    aVar.a(dVar, DirectExecutor.INSTANCE);
                    return true;
                } catch (Throwable th2) {
                    try {
                        aVar2 = new a(th2);
                    } catch (Throwable unused) {
                        aVar2 = a.f3029b;
                    }
                    g.f20201f.b(this, dVar, aVar2);
                    return true;
                }
            }
            obj = this.f20203a;
        }
        if (obj instanceof z2.a) {
            aVar.cancel(((z2.a) obj).f20185a);
        }
        return false;
    }
}
