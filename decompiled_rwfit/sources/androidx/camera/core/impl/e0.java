package androidx.camera.core.impl;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public interface e0 {
    static void M(x0 x0Var, e0 e0Var, e0 e0Var2, c cVar) {
        if (!Objects.equals(cVar, p0.A0)) {
            x0Var.l(cVar, e0Var2.j(cVar), e0Var2.e(cVar));
            return;
        }
        f0.b bVar = (f0.b) e0Var2.k(cVar, null);
        f0.b bVar2 = (f0.b) e0Var.k(cVar, null);
        Config$OptionPriority j4 = e0Var2.j(cVar);
        if (bVar != null) {
            if (bVar2 != null) {
                f0.a aVar = bVar.f12638a;
                if (aVar == null) {
                    aVar = bVar2.f12638a;
                }
                f0.c cVar2 = bVar.f12639b;
                if (cVar2 == null) {
                    cVar2 = bVar2.f12639b;
                }
                he.a aVar2 = bVar.f12640c;
                if (aVar2 == null) {
                    aVar2 = bVar2.f12640c;
                }
                bVar2 = new f0.b(aVar, cVar2, aVar2);
            }
            x0Var.l(cVar, j4, bVar);
        }
        bVar = bVar2;
        x0Var.l(cVar, j4, bVar);
    }

    static d1 t(e0 e0Var, e0 e0Var2) {
        if (e0Var == null && e0Var2 == null) {
            return d1.f1373c;
        }
        x0 i3 = e0Var2 != null ? x0.i(e0Var2) : x0.f();
        if (e0Var != null) {
            Iterator it = e0Var.g().iterator();
            while (it.hasNext()) {
                M(i3, e0Var2, e0Var, (c) it.next());
            }
        }
        return d1.a(i3);
    }

    boolean b(c cVar);

    void c(c0.b bVar);

    Object d(c cVar, Config$OptionPriority config$OptionPriority);

    Object e(c cVar);

    Set g();

    Set h(c cVar);

    Config$OptionPriority j(c cVar);

    Object k(c cVar, Object obj);
}
