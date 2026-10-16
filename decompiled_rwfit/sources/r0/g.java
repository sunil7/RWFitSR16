package r0;

import q0.k;

/* loaded from: classes.dex */
public final class g extends androidx.constraintlayout.core.widgets.analyzer.h {
    @Override // r0.d
    public final void a(d dVar) {
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f1637h;
        if (aVar.f1616c && !aVar.f1622j) {
            aVar.d((int) ((((androidx.constraintlayout.core.widgets.analyzer.a) aVar.f1624l.get(0)).f1619g * ((k) this.f1632b).f17714s0) + 0.5f));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void d() {
        q0.f fVar = this.f1632b;
        k kVar = (k) fVar;
        int i3 = kVar.f17715t0;
        int i10 = kVar.f17716u0;
        int i11 = kVar.f17718w0;
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f1637h;
        if (i11 == 1) {
            if (i3 != -1) {
                aVar.f1624l.add(fVar.U.f17650d.f1637h);
                this.f1632b.U.f17650d.f1637h.f1623k.add(aVar);
                aVar.f1618f = i3;
            } else if (i10 != -1) {
                aVar.f1624l.add(fVar.U.f17650d.f1638i);
                this.f1632b.U.f17650d.f1638i.f1623k.add(aVar);
                aVar.f1618f = -i10;
            } else {
                aVar.f1615b = true;
                aVar.f1624l.add(fVar.U.f17650d.f1638i);
                this.f1632b.U.f17650d.f1638i.f1623k.add(aVar);
            }
            m(this.f1632b.f17650d.f1637h);
            m(this.f1632b.f17650d.f1638i);
            return;
        }
        if (i3 != -1) {
            aVar.f1624l.add(fVar.U.e.f1637h);
            this.f1632b.U.e.f1637h.f1623k.add(aVar);
            aVar.f1618f = i3;
        } else if (i10 != -1) {
            aVar.f1624l.add(fVar.U.e.f1638i);
            this.f1632b.U.e.f1638i.f1623k.add(aVar);
            aVar.f1618f = -i10;
        } else {
            aVar.f1615b = true;
            aVar.f1624l.add(fVar.U.e.f1638i);
            this.f1632b.U.e.f1638i.f1623k.add(aVar);
        }
        m(this.f1632b.e.f1637h);
        m(this.f1632b.e.f1638i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void e() {
        q0.f fVar = this.f1632b;
        int i3 = ((k) fVar).f17718w0;
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f1637h;
        if (i3 == 1) {
            fVar.Z = aVar.f1619g;
        } else {
            fVar.f17645a0 = aVar.f1619g;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void f() {
        this.f1637h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final boolean k() {
        return false;
    }

    public final void m(androidx.constraintlayout.core.widgets.analyzer.a aVar) {
        androidx.constraintlayout.core.widgets.analyzer.a aVar2 = this.f1637h;
        aVar2.f1623k.add(aVar);
        aVar.f1624l.add(aVar2);
    }
}
