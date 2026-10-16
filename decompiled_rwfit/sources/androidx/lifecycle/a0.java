package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class a0 extends b0 {

    /* renamed from: l, reason: collision with root package name */
    public final j.f f2340l = new j.f();

    @Override // androidx.lifecycle.y
    public final void g() {
        Iterator it = this.f2340l.iterator();
        while (true) {
            j.b bVar = (j.b) it;
            if (!bVar.hasNext()) {
                return;
            }
            z zVar = (z) ((Map.Entry) bVar.next()).getValue();
            zVar.f2412a.f(zVar);
        }
    }

    @Override // androidx.lifecycle.y
    public final void h() {
        Iterator it = this.f2340l.iterator();
        while (true) {
            j.b bVar = (j.b) it;
            if (!bVar.hasNext()) {
                return;
            }
            z zVar = (z) ((Map.Entry) bVar.next()).getValue();
            zVar.f2412a.j(zVar);
        }
    }

    public void l(y yVar, c0 c0Var) {
        b0 b0Var = (b0) yVar;
        z zVar = new z(b0Var, c0Var);
        z zVar2 = (z) this.f2340l.c(yVar, zVar);
        if (zVar2 != null && zVar2.f2413b != c0Var) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (zVar2 == null && this.f2405c > 0) {
            b0Var.f(zVar);
        }
    }
}
