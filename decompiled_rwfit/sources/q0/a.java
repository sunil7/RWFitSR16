package q0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class a extends l {

    /* renamed from: u0, reason: collision with root package name */
    public int f17613u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f17614v0 = true;

    /* renamed from: w0, reason: collision with root package name */
    public int f17615w0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f17616x0 = false;

    public final boolean Q() {
        int i3;
        int i10;
        int i11;
        boolean z5 = true;
        int i12 = 0;
        while (true) {
            i3 = this.f17721t0;
            if (i12 >= i3) {
                break;
            }
            f fVar = this.f17720s0[i12];
            if ((this.f17614v0 || fVar.c()) && ((((i10 = this.f17613u0) == 0 || i10 == 1) && !fVar.y()) || (((i11 = this.f17613u0) == 2 || i11 == 3) && !fVar.z()))) {
                z5 = false;
            }
            i12++;
        }
        if (!z5 || i3 <= 0) {
            return false;
        }
        int i13 = 0;
        boolean z6 = false;
        for (int i14 = 0; i14 < this.f17721t0; i14++) {
            f fVar2 = this.f17720s0[i14];
            if (this.f17614v0 || fVar2.c()) {
                if (!z6) {
                    int i15 = this.f17613u0;
                    if (i15 == 0) {
                        i13 = fVar2.j(ConstraintAnchor$Type.LEFT).d();
                    } else if (i15 == 1) {
                        i13 = fVar2.j(ConstraintAnchor$Type.RIGHT).d();
                    } else if (i15 == 2) {
                        i13 = fVar2.j(ConstraintAnchor$Type.TOP).d();
                    } else if (i15 == 3) {
                        i13 = fVar2.j(ConstraintAnchor$Type.BOTTOM).d();
                    }
                    z6 = true;
                }
                int i16 = this.f17613u0;
                if (i16 == 0) {
                    i13 = Math.min(i13, fVar2.j(ConstraintAnchor$Type.LEFT).d());
                } else if (i16 == 1) {
                    i13 = Math.max(i13, fVar2.j(ConstraintAnchor$Type.RIGHT).d());
                } else if (i16 == 2) {
                    i13 = Math.min(i13, fVar2.j(ConstraintAnchor$Type.TOP).d());
                } else if (i16 == 3) {
                    i13 = Math.max(i13, fVar2.j(ConstraintAnchor$Type.BOTTOM).d());
                }
            }
        }
        int i17 = i13 + this.f17615w0;
        int i18 = this.f17613u0;
        if (i18 == 0 || i18 == 1) {
            F(i17, i17);
        } else {
            G(i17, i17);
        }
        this.f17616x0 = true;
        return true;
    }

    public final int R() {
        int i3 = this.f17613u0;
        if (i3 == 0 || i3 == 1) {
            return 0;
        }
        return (i3 == 2 || i3 == 3) ? 1 : -1;
    }

    @Override // q0.f
    public final void b(o0.c cVar, boolean z5) {
        boolean z6;
        int i3;
        int i10;
        d[] dVarArr = this.Q;
        d dVar = this.I;
        dVarArr[0] = dVar;
        d dVar2 = this.J;
        int i11 = 2;
        dVarArr[2] = dVar2;
        d dVar3 = this.K;
        dVarArr[1] = dVar3;
        d dVar4 = this.L;
        dVarArr[3] = dVar4;
        for (d dVar5 : dVarArr) {
            dVar5.f17641i = cVar.k(dVar5);
        }
        int i12 = this.f17613u0;
        if (i12 < 0 || i12 >= 4) {
            return;
        }
        d dVar6 = dVarArr[i12];
        if (!this.f17616x0) {
            Q();
        }
        if (this.f17616x0) {
            this.f17616x0 = false;
            int i13 = this.f17613u0;
            if (i13 == 0 || i13 == 1) {
                cVar.d(dVar.f17641i, this.Z);
                cVar.d(dVar3.f17641i, this.Z);
                return;
            } else {
                if (i13 == 2 || i13 == 3) {
                    cVar.d(dVar2.f17641i, this.f17645a0);
                    cVar.d(dVar4.f17641i, this.f17645a0);
                    return;
                }
                return;
            }
        }
        for (int i14 = 0; i14 < this.f17721t0; i14++) {
            f fVar = this.f17720s0[i14];
            if ((this.f17614v0 || fVar.c()) && ((((i10 = this.f17613u0) == 0 || i10 == 1) && fVar.T[0] == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && fVar.I.f17638f != null && fVar.K.f17638f != null) || ((i10 == 2 || i10 == 3) && fVar.T[1] == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && fVar.J.f17638f != null && fVar.L.f17638f != null))) {
                z6 = true;
                break;
            }
        }
        z6 = false;
        boolean z8 = dVar.g() || dVar3.g();
        boolean z10 = dVar2.g() || dVar4.g();
        int i15 = (z6 || !(((i3 = this.f17613u0) == 0 && z8) || ((i3 == 2 && z10) || ((i3 == 1 && z8) || (i3 == 3 && z10))))) ? 4 : 5;
        int i16 = 0;
        while (i16 < this.f17721t0) {
            f fVar2 = this.f17720s0[i16];
            if (this.f17614v0 || fVar2.c()) {
                o0.e k10 = cVar.k(fVar2.Q[this.f17613u0]);
                int i17 = this.f17613u0;
                d dVar7 = fVar2.Q[i17];
                dVar7.f17641i = k10;
                d dVar8 = dVar7.f17638f;
                int i18 = (dVar8 == null || dVar8.f17637d != this) ? 0 : dVar7.f17639g;
                if (i17 == 0 || i17 == i11) {
                    o0.e eVar = dVar6.f17641i;
                    int i19 = this.f17615w0 - i18;
                    o0.b l3 = cVar.l();
                    o0.e m10 = cVar.m();
                    m10.f16673d = 0;
                    l3.c(eVar, k10, m10, i19);
                    cVar.c(l3);
                } else {
                    o0.e eVar2 = dVar6.f17641i;
                    int i20 = this.f17615w0 + i18;
                    o0.b l5 = cVar.l();
                    o0.e m11 = cVar.m();
                    m11.f16673d = 0;
                    l5.b(eVar2, k10, m11, i20);
                    cVar.c(l5);
                }
                cVar.e(dVar6.f17641i, k10, this.f17615w0 + i18, i15);
            }
            i16++;
            i11 = 2;
        }
        int i21 = this.f17613u0;
        if (i21 == 0) {
            cVar.e(dVar3.f17641i, dVar.f17641i, 0, 8);
            cVar.e(dVar.f17641i, this.U.K.f17641i, 0, 4);
            cVar.e(dVar.f17641i, this.U.I.f17641i, 0, 0);
            return;
        }
        if (i21 == 1) {
            cVar.e(dVar.f17641i, dVar3.f17641i, 0, 8);
            cVar.e(dVar.f17641i, this.U.I.f17641i, 0, 4);
            cVar.e(dVar.f17641i, this.U.K.f17641i, 0, 0);
        } else if (i21 == 2) {
            cVar.e(dVar4.f17641i, dVar2.f17641i, 0, 8);
            cVar.e(dVar2.f17641i, this.U.L.f17641i, 0, 4);
            cVar.e(dVar2.f17641i, this.U.J.f17641i, 0, 0);
        } else if (i21 == 3) {
            cVar.e(dVar2.f17641i, dVar4.f17641i, 0, 8);
            cVar.e(dVar2.f17641i, this.U.J.f17641i, 0, 4);
            cVar.e(dVar2.f17641i, this.U.L.f17641i, 0, 0);
        }
    }

    @Override // q0.f
    public final boolean c() {
        return true;
    }

    @Override // q0.l, q0.f
    public final void g(f fVar, HashMap hashMap) {
        super.g(fVar, hashMap);
        a aVar = (a) fVar;
        this.f17613u0 = aVar.f17613u0;
        this.f17614v0 = aVar.f17614v0;
        this.f17615w0 = aVar.f17615w0;
    }

    @Override // q0.f
    public final String toString() {
        String f2 = r5.a.f(new StringBuilder("[Barrier] "), this.i0, " {");
        for (int i3 = 0; i3 < this.f17721t0; i3++) {
            f fVar = this.f17720s0[i3];
            if (i3 > 0) {
                f2 = android.support.v4.media.session.e.l(f2, ", ");
            }
            StringBuilder t8 = l0.t(f2);
            t8.append(fVar.i0);
            f2 = t8.toString();
        }
        return android.support.v4.media.session.e.l(f2, "}");
    }

    @Override // q0.f
    public final boolean y() {
        return this.f17616x0;
    }

    @Override // q0.f
    public final boolean z() {
        return this.f17616x0;
    }
}
