package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c extends h {
    @Override // r0.d
    public final void a(r0.d dVar) {
        q0.a aVar = (q0.a) this.f1632b;
        int i3 = aVar.f17613u0;
        a aVar2 = this.f1637h;
        ArrayList arrayList = aVar2.f1624l;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            int i13 = ((a) obj).f1619g;
            if (i12 == -1 || i13 < i12) {
                i12 = i13;
            }
            if (i10 < i13) {
                i10 = i13;
            }
        }
        if (i3 == 0 || i3 == 2) {
            aVar2.d(i12 + aVar.f17615w0);
        } else {
            aVar2.d(i10 + aVar.f17615w0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void d() {
        q0.f fVar = this.f1632b;
        if (fVar instanceof q0.a) {
            a aVar = this.f1637h;
            aVar.f1615b = true;
            q0.a aVar2 = (q0.a) fVar;
            int i3 = aVar2.f17613u0;
            boolean z5 = aVar2.f17614v0;
            int i10 = 0;
            if (i3 == 0) {
                aVar.e = DependencyNode$Type.LEFT;
                while (i10 < aVar2.f17721t0) {
                    q0.f fVar2 = aVar2.f17720s0[i10];
                    if (z5 || fVar2.f17658h0 != 8) {
                        a aVar3 = fVar2.f17650d.f1637h;
                        aVar3.f1623k.add(aVar);
                        aVar.f1624l.add(aVar3);
                    }
                    i10++;
                }
                m(this.f1632b.f17650d.f1637h);
                m(this.f1632b.f17650d.f1638i);
                return;
            }
            if (i3 == 1) {
                aVar.e = DependencyNode$Type.RIGHT;
                while (i10 < aVar2.f17721t0) {
                    q0.f fVar3 = aVar2.f17720s0[i10];
                    if (z5 || fVar3.f17658h0 != 8) {
                        a aVar4 = fVar3.f17650d.f1638i;
                        aVar4.f1623k.add(aVar);
                        aVar.f1624l.add(aVar4);
                    }
                    i10++;
                }
                m(this.f1632b.f17650d.f1637h);
                m(this.f1632b.f17650d.f1638i);
                return;
            }
            if (i3 == 2) {
                aVar.e = DependencyNode$Type.TOP;
                while (i10 < aVar2.f17721t0) {
                    q0.f fVar4 = aVar2.f17720s0[i10];
                    if (z5 || fVar4.f17658h0 != 8) {
                        a aVar5 = fVar4.e.f1637h;
                        aVar5.f1623k.add(aVar);
                        aVar.f1624l.add(aVar5);
                    }
                    i10++;
                }
                m(this.f1632b.e.f1637h);
                m(this.f1632b.e.f1638i);
                return;
            }
            if (i3 != 3) {
                return;
            }
            aVar.e = DependencyNode$Type.BOTTOM;
            while (i10 < aVar2.f17721t0) {
                q0.f fVar5 = aVar2.f17720s0[i10];
                if (z5 || fVar5.f17658h0 != 8) {
                    a aVar6 = fVar5.e.f1638i;
                    aVar6.f1623k.add(aVar);
                    aVar.f1624l.add(aVar6);
                }
                i10++;
            }
            m(this.f1632b.e.f1637h);
            m(this.f1632b.e.f1638i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void e() {
        q0.f fVar = this.f1632b;
        if (fVar instanceof q0.a) {
            int i3 = ((q0.a) fVar).f17613u0;
            a aVar = this.f1637h;
            if (i3 == 0 || i3 == 1) {
                fVar.Z = aVar.f1619g;
            } else {
                fVar.f17645a0 = aVar.f1619g;
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void f() {
        this.f1633c = null;
        this.f1637h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final boolean k() {
        return false;
    }

    public final void m(a aVar) {
        a aVar2 = this.f1637h;
        aVar2.f1623k.add(aVar);
        aVar.f1624l.add(aVar2);
    }
}
