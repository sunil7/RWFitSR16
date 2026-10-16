package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import q0.l;

/* loaded from: classes.dex */
public final class g extends h {

    /* renamed from: k, reason: collision with root package name */
    public final a f1629k;

    /* renamed from: l, reason: collision with root package name */
    public r0.a f1630l;

    public g(q0.f fVar) {
        super(fVar);
        a aVar = new a(this);
        this.f1629k = aVar;
        this.f1630l = null;
        this.f1637h.e = DependencyNode$Type.TOP;
        this.f1638i.e = DependencyNode$Type.BOTTOM;
        aVar.e = DependencyNode$Type.BASELINE;
        this.f1635f = 1;
    }

    @Override // r0.d
    public final void a(r0.d dVar) {
        float f2;
        float f10;
        float f11;
        int i3;
        if (f.f1628a[this.f1639j.ordinal()] == 3) {
            q0.f fVar = this.f1632b;
            l(fVar.J, fVar.L, 1);
            return;
        }
        b bVar = this.e;
        if (bVar.f1616c && !bVar.f1622j && this.f1634d == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
            q0.f fVar2 = this.f1632b;
            int i10 = fVar2.r;
            if (i10 == 2) {
                q0.f fVar3 = fVar2.U;
                if (fVar3 != null) {
                    if (fVar3.e.e.f1622j) {
                        bVar.d((int) ((r1.f1619g * fVar2.f17683y) + 0.5f));
                    }
                }
            } else if (i10 == 3) {
                b bVar2 = fVar2.f17650d.e;
                if (bVar2.f1622j) {
                    int i11 = fVar2.Y;
                    if (i11 == -1) {
                        f2 = bVar2.f1619g;
                        f10 = fVar2.X;
                    } else if (i11 == 0) {
                        f11 = bVar2.f1619g * fVar2.X;
                        i3 = (int) (f11 + 0.5f);
                        bVar.d(i3);
                    } else if (i11 != 1) {
                        i3 = 0;
                        bVar.d(i3);
                    } else {
                        f2 = bVar2.f1619g;
                        f10 = fVar2.X;
                    }
                    f11 = f2 / f10;
                    i3 = (int) (f11 + 0.5f);
                    bVar.d(i3);
                }
            }
        }
        a aVar = this.f1637h;
        if (aVar.f1616c) {
            a aVar2 = this.f1638i;
            if (aVar2.f1616c) {
                if (aVar.f1622j && aVar2.f1622j && bVar.f1622j) {
                    return;
                }
                if (!bVar.f1622j && this.f1634d == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                    q0.f fVar4 = this.f1632b;
                    if (fVar4.f17674q == 0 && !fVar4.w()) {
                        a aVar3 = (a) aVar.f1624l.get(0);
                        a aVar4 = (a) aVar2.f1624l.get(0);
                        int i12 = aVar3.f1619g + aVar.f1618f;
                        int i13 = aVar4.f1619g + aVar2.f1618f;
                        aVar.d(i12);
                        aVar2.d(i13);
                        bVar.d(i13 - i12);
                        return;
                    }
                }
                if (!bVar.f1622j && this.f1634d == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && this.f1631a == 1 && aVar.f1624l.size() > 0 && aVar2.f1624l.size() > 0) {
                    a aVar5 = (a) aVar.f1624l.get(0);
                    int i14 = (((a) aVar2.f1624l.get(0)).f1619g + aVar2.f1618f) - (aVar5.f1619g + aVar.f1618f);
                    int i15 = bVar.f1625m;
                    if (i14 < i15) {
                        bVar.d(i14);
                    } else {
                        bVar.d(i15);
                    }
                }
                if (bVar.f1622j && aVar.f1624l.size() > 0 && aVar2.f1624l.size() > 0) {
                    a aVar6 = (a) aVar.f1624l.get(0);
                    a aVar7 = (a) aVar2.f1624l.get(0);
                    int i16 = aVar6.f1619g;
                    int i17 = aVar.f1618f + i16;
                    int i18 = aVar7.f1619g;
                    int i19 = aVar2.f1618f + i18;
                    float f12 = this.f1632b.f17654f0;
                    if (aVar6 == aVar7) {
                        f12 = 0.5f;
                    } else {
                        i16 = i17;
                        i18 = i19;
                    }
                    aVar.d((int) ((((i18 - i16) - bVar.f1619g) * f12) + i16 + 0.5f));
                    aVar2.d(aVar.f1619g + bVar.f1619g);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void d() {
        q0.f fVar;
        q0.f fVar2;
        q0.f fVar3;
        q0.f fVar4;
        q0.f fVar5 = this.f1632b;
        boolean z5 = fVar5.f17644a;
        b bVar = this.e;
        if (z5) {
            bVar.d(fVar5.l());
        }
        boolean z6 = bVar.f1622j;
        a aVar = this.f1638i;
        a aVar2 = this.f1637h;
        if (!z6) {
            q0.f fVar6 = this.f1632b;
            this.f1634d = fVar6.T[1];
            if (fVar6.D) {
                this.f1630l = new r0.a(this);
            }
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = this.f1634d;
            if (constraintWidget$DimensionBehaviour != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                if (constraintWidget$DimensionBehaviour == ConstraintWidget$DimensionBehaviour.MATCH_PARENT && (fVar4 = this.f1632b.U) != null && fVar4.T[1] == ConstraintWidget$DimensionBehaviour.FIXED) {
                    int l3 = (fVar4.l() - this.f1632b.J.e()) - this.f1632b.L.e();
                    h.b(aVar2, fVar4.e.f1637h, this.f1632b.J.e());
                    h.b(aVar, fVar4.e.f1638i, -this.f1632b.L.e());
                    bVar.d(l3);
                    return;
                }
                if (constraintWidget$DimensionBehaviour == ConstraintWidget$DimensionBehaviour.FIXED) {
                    bVar.d(this.f1632b.l());
                }
            }
        } else if (this.f1634d == ConstraintWidget$DimensionBehaviour.MATCH_PARENT && (fVar2 = (fVar = this.f1632b).U) != null && fVar2.T[1] == ConstraintWidget$DimensionBehaviour.FIXED) {
            h.b(aVar2, fVar2.e.f1637h, fVar.J.e());
            h.b(aVar, fVar2.e.f1638i, -this.f1632b.L.e());
            return;
        }
        boolean z8 = bVar.f1622j;
        a aVar3 = this.f1629k;
        if (z8) {
            q0.f fVar7 = this.f1632b;
            if (fVar7.f17644a) {
                q0.d[] dVarArr = fVar7.Q;
                q0.d dVar = dVarArr[2];
                q0.d dVar2 = dVar.f17638f;
                if (dVar2 != null && dVarArr[3].f17638f != null) {
                    if (fVar7.w()) {
                        aVar2.f1618f = this.f1632b.Q[2].e();
                        aVar.f1618f = -this.f1632b.Q[3].e();
                    } else {
                        a h4 = h.h(this.f1632b.Q[2]);
                        if (h4 != null) {
                            h.b(aVar2, h4, this.f1632b.Q[2].e());
                        }
                        a h10 = h.h(this.f1632b.Q[3]);
                        if (h10 != null) {
                            h.b(aVar, h10, -this.f1632b.Q[3].e());
                        }
                        aVar2.f1615b = true;
                        aVar.f1615b = true;
                    }
                    q0.f fVar8 = this.f1632b;
                    if (fVar8.D) {
                        h.b(aVar3, aVar2, fVar8.f17647b0);
                        return;
                    }
                    return;
                }
                if (dVar2 != null) {
                    a h11 = h.h(dVar);
                    if (h11 != null) {
                        h.b(aVar2, h11, this.f1632b.Q[2].e());
                        h.b(aVar, aVar2, bVar.f1619g);
                        q0.f fVar9 = this.f1632b;
                        if (fVar9.D) {
                            h.b(aVar3, aVar2, fVar9.f17647b0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                q0.d dVar3 = dVarArr[3];
                if (dVar3.f17638f != null) {
                    a h12 = h.h(dVar3);
                    if (h12 != null) {
                        h.b(aVar, h12, -this.f1632b.Q[3].e());
                        h.b(aVar2, aVar, -bVar.f1619g);
                    }
                    q0.f fVar10 = this.f1632b;
                    if (fVar10.D) {
                        h.b(aVar3, aVar2, fVar10.f17647b0);
                        return;
                    }
                    return;
                }
                q0.d dVar4 = dVarArr[4];
                if (dVar4.f17638f != null) {
                    a h13 = h.h(dVar4);
                    if (h13 != null) {
                        h.b(aVar3, h13, 0);
                        h.b(aVar2, aVar3, -this.f1632b.f17647b0);
                        h.b(aVar, aVar2, bVar.f1619g);
                        return;
                    }
                    return;
                }
                if ((fVar7 instanceof l) || fVar7.U == null || fVar7.j(ConstraintAnchor$Type.CENTER).f17638f != null) {
                    return;
                }
                q0.f fVar11 = this.f1632b;
                h.b(aVar2, fVar11.U.e.f1637h, fVar11.q());
                h.b(aVar, aVar2, bVar.f1619g);
                q0.f fVar12 = this.f1632b;
                if (fVar12.D) {
                    h.b(aVar3, aVar2, fVar12.f17647b0);
                    return;
                }
                return;
            }
        }
        if (z8 || this.f1634d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
            bVar.b(this);
        } else {
            q0.f fVar13 = this.f1632b;
            int i3 = fVar13.r;
            if (i3 == 2) {
                q0.f fVar14 = fVar13.U;
                if (fVar14 != null) {
                    b bVar2 = fVar14.e.e;
                    bVar.f1624l.add(bVar2);
                    bVar2.f1623k.add(bVar);
                    bVar.f1615b = true;
                    bVar.f1623k.add(aVar2);
                    bVar.f1623k.add(aVar);
                }
            } else if (i3 == 3 && !fVar13.w()) {
                q0.f fVar15 = this.f1632b;
                if (fVar15.f17674q != 3) {
                    b bVar3 = fVar15.f17650d.e;
                    bVar.f1624l.add(bVar3);
                    bVar3.f1623k.add(bVar);
                    bVar.f1615b = true;
                    bVar.f1623k.add(aVar2);
                    bVar.f1623k.add(aVar);
                }
            }
        }
        q0.f fVar16 = this.f1632b;
        q0.d[] dVarArr2 = fVar16.Q;
        q0.d dVar5 = dVarArr2[2];
        q0.d dVar6 = dVar5.f17638f;
        if (dVar6 != null && dVarArr2[3].f17638f != null) {
            if (fVar16.w()) {
                aVar2.f1618f = this.f1632b.Q[2].e();
                aVar.f1618f = -this.f1632b.Q[3].e();
            } else {
                a h14 = h.h(this.f1632b.Q[2]);
                a h15 = h.h(this.f1632b.Q[3]);
                if (h14 != null) {
                    h14.b(this);
                }
                if (h15 != null) {
                    h15.b(this);
                }
                this.f1639j = WidgetRun$RunType.CENTER;
            }
            if (this.f1632b.D) {
                c(aVar3, aVar2, 1, this.f1630l);
            }
        } else if (dVar6 != null) {
            a h16 = h.h(dVar5);
            if (h16 != null) {
                h.b(aVar2, h16, this.f1632b.Q[2].e());
                c(aVar, aVar2, 1, bVar);
                if (this.f1632b.D) {
                    c(aVar3, aVar2, 1, this.f1630l);
                }
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = this.f1634d;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3) {
                    q0.f fVar17 = this.f1632b;
                    if (fVar17.X > 0.0f) {
                        e eVar = fVar17.f17650d;
                        if (eVar.f1634d == constraintWidget$DimensionBehaviour3) {
                            eVar.e.f1623k.add(bVar);
                            bVar.f1624l.add(this.f1632b.f17650d.e);
                            bVar.f1614a = this;
                        }
                    }
                }
            }
        } else {
            q0.d dVar7 = dVarArr2[3];
            if (dVar7.f17638f != null) {
                a h17 = h.h(dVar7);
                if (h17 != null) {
                    h.b(aVar, h17, -this.f1632b.Q[3].e());
                    c(aVar2, aVar, -1, bVar);
                    if (this.f1632b.D) {
                        c(aVar3, aVar2, 1, this.f1630l);
                    }
                }
            } else {
                q0.d dVar8 = dVarArr2[4];
                if (dVar8.f17638f != null) {
                    a h18 = h.h(dVar8);
                    if (h18 != null) {
                        h.b(aVar3, h18, 0);
                        c(aVar2, aVar3, -1, this.f1630l);
                        c(aVar, aVar2, 1, bVar);
                    }
                } else if (!(fVar16 instanceof l) && (fVar3 = fVar16.U) != null) {
                    h.b(aVar2, fVar3.e.f1637h, fVar16.q());
                    c(aVar, aVar2, 1, bVar);
                    if (this.f1632b.D) {
                        c(aVar3, aVar2, 1, this.f1630l);
                    }
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = this.f1634d;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    if (constraintWidget$DimensionBehaviour4 == constraintWidget$DimensionBehaviour5) {
                        q0.f fVar18 = this.f1632b;
                        if (fVar18.X > 0.0f) {
                            e eVar2 = fVar18.f17650d;
                            if (eVar2.f1634d == constraintWidget$DimensionBehaviour5) {
                                eVar2.e.f1623k.add(bVar);
                                bVar.f1624l.add(this.f1632b.f17650d.e);
                                bVar.f1614a = this;
                            }
                        }
                    }
                }
            }
        }
        if (bVar.f1624l.size() == 0) {
            bVar.f1616c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void e() {
        a aVar = this.f1637h;
        if (aVar.f1622j) {
            this.f1632b.f17645a0 = aVar.f1619g;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void f() {
        this.f1633c = null;
        this.f1637h.c();
        this.f1638i.c();
        this.f1629k.c();
        this.e.c();
        this.f1636g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final boolean k() {
        return this.f1634d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT || this.f1632b.r == 0;
    }

    public final void m() {
        this.f1636g = false;
        a aVar = this.f1637h;
        aVar.c();
        aVar.f1622j = false;
        a aVar2 = this.f1638i;
        aVar2.c();
        aVar2.f1622j = false;
        a aVar3 = this.f1629k;
        aVar3.c();
        aVar3.f1622j = false;
        this.e.f1622j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f1632b.i0;
    }
}
