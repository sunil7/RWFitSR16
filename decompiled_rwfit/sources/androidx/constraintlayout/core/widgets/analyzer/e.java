package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import q0.l;

/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f1627k = new int[2];

    public e(q0.f fVar) {
        super(fVar);
        this.f1637h.e = DependencyNode$Type.LEFT;
        this.f1638i.e = DependencyNode$Type.RIGHT;
        this.f1635f = 0;
    }

    public static void m(int[] iArr, int i3, int i10, int i11, int i12, float f2, int i13) {
        int i14 = i10 - i3;
        int i15 = i12 - i11;
        if (i13 != -1) {
            if (i13 == 0) {
                iArr[0] = (int) ((i15 * f2) + 0.5f);
                iArr[1] = i15;
                return;
            } else {
                if (i13 != 1) {
                    return;
                }
                iArr[0] = i14;
                iArr[1] = (int) ((i14 * f2) + 0.5f);
                return;
            }
        }
        int i16 = (int) ((i15 * f2) + 0.5f);
        int i17 = (int) ((i14 / f2) + 0.5f);
        if (i16 <= i14) {
            iArr[0] = i16;
            iArr[1] = i15;
        } else if (i17 <= i15) {
            iArr[0] = i14;
            iArr[1] = i17;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x023f, code lost:
    
        if (r15 != 1) goto L124;
     */
    @Override // r0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(r0.d r23) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.e.a(r0.d):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void d() {
        q0.f fVar;
        q0.f fVar2;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        q0.f fVar3;
        q0.f fVar4;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
        q0.f fVar5 = this.f1632b;
        boolean z5 = fVar5.f17644a;
        b bVar = this.e;
        if (z5) {
            bVar.d(fVar5.o());
        }
        boolean z6 = bVar.f1622j;
        a aVar = this.f1638i;
        a aVar2 = this.f1637h;
        if (z6) {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = this.f1634d;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
            if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour4 && (fVar2 = (fVar = this.f1632b).U) != null && ((constraintWidget$DimensionBehaviour = fVar2.T[0]) == ConstraintWidget$DimensionBehaviour.FIXED || constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour4)) {
                h.b(aVar2, fVar2.f17650d.f1637h, fVar.I.e());
                h.b(aVar, fVar2.f17650d.f1638i, -this.f1632b.K.e());
                return;
            }
        } else {
            q0.f fVar6 = this.f1632b;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = fVar6.T[0];
            this.f1634d = constraintWidget$DimensionBehaviour5;
            if (constraintWidget$DimensionBehaviour5 != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour6 && (fVar4 = fVar6.U) != null && ((constraintWidget$DimensionBehaviour2 = fVar4.T[0]) == ConstraintWidget$DimensionBehaviour.FIXED || constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour6)) {
                    int o3 = (fVar4.o() - this.f1632b.I.e()) - this.f1632b.K.e();
                    h.b(aVar2, fVar4.f17650d.f1637h, this.f1632b.I.e());
                    h.b(aVar, fVar4.f17650d.f1638i, -this.f1632b.K.e());
                    bVar.d(o3);
                    return;
                }
                if (constraintWidget$DimensionBehaviour5 == ConstraintWidget$DimensionBehaviour.FIXED) {
                    bVar.d(fVar6.o());
                }
            }
        }
        if (bVar.f1622j) {
            q0.f fVar7 = this.f1632b;
            if (fVar7.f17644a) {
                q0.d[] dVarArr = fVar7.Q;
                q0.d dVar = dVarArr[0];
                q0.d dVar2 = dVar.f17638f;
                if (dVar2 != null && dVarArr[1].f17638f != null) {
                    if (fVar7.v()) {
                        aVar2.f1618f = this.f1632b.Q[0].e();
                        aVar.f1618f = -this.f1632b.Q[1].e();
                        return;
                    }
                    a h4 = h.h(this.f1632b.Q[0]);
                    if (h4 != null) {
                        h.b(aVar2, h4, this.f1632b.Q[0].e());
                    }
                    a h10 = h.h(this.f1632b.Q[1]);
                    if (h10 != null) {
                        h.b(aVar, h10, -this.f1632b.Q[1].e());
                    }
                    aVar2.f1615b = true;
                    aVar.f1615b = true;
                    return;
                }
                if (dVar2 != null) {
                    a h11 = h.h(dVar);
                    if (h11 != null) {
                        h.b(aVar2, h11, this.f1632b.Q[0].e());
                        h.b(aVar, aVar2, bVar.f1619g);
                        return;
                    }
                    return;
                }
                q0.d dVar3 = dVarArr[1];
                if (dVar3.f17638f != null) {
                    a h12 = h.h(dVar3);
                    if (h12 != null) {
                        h.b(aVar, h12, -this.f1632b.Q[1].e());
                        h.b(aVar2, aVar, -bVar.f1619g);
                        return;
                    }
                    return;
                }
                if ((fVar7 instanceof l) || fVar7.U == null || fVar7.j(ConstraintAnchor$Type.CENTER).f17638f != null) {
                    return;
                }
                q0.f fVar8 = this.f1632b;
                h.b(aVar2, fVar8.U.f17650d.f1637h, fVar8.p());
                h.b(aVar, aVar2, bVar.f1619g);
                return;
            }
        }
        if (this.f1634d == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
            q0.f fVar9 = this.f1632b;
            int i3 = fVar9.f17674q;
            if (i3 == 2) {
                q0.f fVar10 = fVar9.U;
                if (fVar10 != null) {
                    b bVar2 = fVar10.e.e;
                    bVar.f1624l.add(bVar2);
                    bVar2.f1623k.add(bVar);
                    bVar.f1615b = true;
                    bVar.f1623k.add(aVar2);
                    bVar.f1623k.add(aVar);
                }
            } else if (i3 == 3) {
                if (fVar9.r == 3) {
                    aVar2.f1614a = this;
                    aVar.f1614a = this;
                    g gVar = fVar9.e;
                    gVar.f1637h.f1614a = this;
                    gVar.f1638i.f1614a = this;
                    bVar.f1614a = this;
                    if (fVar9.w()) {
                        bVar.f1624l.add(this.f1632b.e.e);
                        this.f1632b.e.e.f1623k.add(bVar);
                        g gVar2 = this.f1632b.e;
                        gVar2.e.f1614a = this;
                        bVar.f1624l.add(gVar2.f1637h);
                        bVar.f1624l.add(this.f1632b.e.f1638i);
                        this.f1632b.e.f1637h.f1623k.add(bVar);
                        this.f1632b.e.f1638i.f1623k.add(bVar);
                    } else if (this.f1632b.v()) {
                        this.f1632b.e.e.f1624l.add(bVar);
                        bVar.f1623k.add(this.f1632b.e.e);
                    } else {
                        this.f1632b.e.e.f1624l.add(bVar);
                    }
                } else {
                    b bVar3 = fVar9.e.e;
                    bVar.f1624l.add(bVar3);
                    bVar3.f1623k.add(bVar);
                    this.f1632b.e.f1637h.f1623k.add(bVar);
                    this.f1632b.e.f1638i.f1623k.add(bVar);
                    bVar.f1615b = true;
                    bVar.f1623k.add(aVar2);
                    bVar.f1623k.add(aVar);
                    aVar2.f1624l.add(bVar);
                    aVar.f1624l.add(bVar);
                }
            }
        }
        q0.f fVar11 = this.f1632b;
        q0.d[] dVarArr2 = fVar11.Q;
        q0.d dVar4 = dVarArr2[0];
        q0.d dVar5 = dVar4.f17638f;
        if (dVar5 != null && dVarArr2[1].f17638f != null) {
            if (fVar11.v()) {
                aVar2.f1618f = this.f1632b.Q[0].e();
                aVar.f1618f = -this.f1632b.Q[1].e();
                return;
            }
            a h13 = h.h(this.f1632b.Q[0]);
            a h14 = h.h(this.f1632b.Q[1]);
            if (h13 != null) {
                h13.b(this);
            }
            if (h14 != null) {
                h14.b(this);
            }
            this.f1639j = WidgetRun$RunType.CENTER;
            return;
        }
        if (dVar5 != null) {
            a h15 = h.h(dVar4);
            if (h15 != null) {
                h.b(aVar2, h15, this.f1632b.Q[0].e());
                c(aVar, aVar2, 1, bVar);
                return;
            }
            return;
        }
        q0.d dVar6 = dVarArr2[1];
        if (dVar6.f17638f != null) {
            a h16 = h.h(dVar6);
            if (h16 != null) {
                h.b(aVar, h16, -this.f1632b.Q[1].e());
                c(aVar2, aVar, -1, bVar);
                return;
            }
            return;
        }
        if ((fVar11 instanceof l) || (fVar3 = fVar11.U) == null) {
            return;
        }
        h.b(aVar2, fVar3.f17650d.f1637h, fVar11.p());
        c(aVar, aVar2, 1, bVar);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void e() {
        a aVar = this.f1637h;
        if (aVar.f1622j) {
            this.f1632b.Z = aVar.f1619g;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void f() {
        this.f1633c = null;
        this.f1637h.c();
        this.f1638i.c();
        this.e.c();
        this.f1636g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final boolean k() {
        return this.f1634d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT || this.f1632b.f17674q == 0;
    }

    public final void n() {
        this.f1636g = false;
        a aVar = this.f1637h;
        aVar.c();
        aVar.f1622j = false;
        a aVar2 = this.f1638i;
        aVar2.c();
        aVar2.f1622j = false;
        this.e.f1622j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f1632b.i0;
    }
}
