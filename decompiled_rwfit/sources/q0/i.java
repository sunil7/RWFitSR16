package q0;

import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i extends o {

    /* renamed from: c1, reason: collision with root package name */
    public f[] f17711c1;
    public int F0 = -1;
    public int G0 = -1;
    public int H0 = -1;
    public int I0 = -1;
    public int J0 = -1;
    public int K0 = -1;
    public float L0 = 0.5f;
    public float M0 = 0.5f;
    public float N0 = 0.5f;
    public float O0 = 0.5f;
    public float P0 = 0.5f;
    public float Q0 = 0.5f;
    public int R0 = 0;
    public int S0 = 0;
    public int T0 = 2;
    public int U0 = 2;
    public int V0 = 0;
    public int W0 = -1;
    public int X0 = 0;
    public final ArrayList Y0 = new ArrayList();
    public f[] Z0 = null;

    /* renamed from: a1, reason: collision with root package name */
    public f[] f17709a1 = null;

    /* renamed from: b1, reason: collision with root package name */
    public int[] f17710b1 = null;

    /* renamed from: d1, reason: collision with root package name */
    public int f17712d1 = 0;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0530  */
    @Override // q0.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q(int r36, int r37, int r38, int r39) {
        /*
            Method dump skipped, instructions count: 1378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.i.Q(int, int, int, int):void");
    }

    public final int S(f fVar, int i3) {
        f fVar2;
        if (fVar == null) {
            return 0;
        }
        if (fVar.T[1] == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
            int i10 = fVar.r;
            if (i10 == 0) {
                return 0;
            }
            if (i10 == 2) {
                int i11 = (int) (fVar.f17683y * i3);
                if (i11 != fVar.l()) {
                    fVar.f17655g = true;
                    R(fVar, fVar.T[0], fVar.o(), ConstraintWidget$DimensionBehaviour.FIXED, i11);
                }
                return i11;
            }
            fVar2 = fVar;
            if (i10 == 1) {
                return fVar2.l();
            }
            if (i10 == 3) {
                return (int) ((fVar2.o() * fVar2.X) + 0.5f);
            }
        } else {
            fVar2 = fVar;
        }
        return fVar2.l();
    }

    public final int T(f fVar, int i3) {
        f fVar2;
        if (fVar == null) {
            return 0;
        }
        if (fVar.T[0] == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
            int i10 = fVar.f17674q;
            if (i10 == 0) {
                return 0;
            }
            if (i10 == 2) {
                int i11 = (int) (fVar.f17680v * i3);
                if (i11 != fVar.o()) {
                    fVar.f17655g = true;
                    R(fVar, ConstraintWidget$DimensionBehaviour.FIXED, i11, fVar.T[1], fVar.l());
                }
                return i11;
            }
            fVar2 = fVar;
            if (i10 == 1) {
                return fVar2.o();
            }
            if (i10 == 3) {
                return (int) ((fVar2.l() * fVar2.X) + 0.5f);
            }
        } else {
            fVar2 = fVar;
        }
        return fVar2.o();
    }

    @Override // q0.f
    public final void b(o0.c cVar, boolean z5) {
        f fVar;
        float f2;
        int i3;
        super.b(cVar, z5);
        f fVar2 = this.U;
        boolean z6 = fVar2 != null && ((g) fVar2).f17690x0;
        int i10 = this.V0;
        ArrayList arrayList = this.Y0;
        if (i10 != 0) {
            if (i10 == 1) {
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    ((h) arrayList.get(i11)).b(i11, z6, i11 == size + (-1));
                    i11++;
                }
            } else if (i10 == 2 && this.f17710b1 != null && this.f17709a1 != null && this.Z0 != null) {
                for (int i12 = 0; i12 < this.f17712d1; i12++) {
                    this.f17711c1[i12].B();
                }
                int[] iArr = this.f17710b1;
                int i13 = iArr[0];
                int i14 = iArr[1];
                float f10 = this.L0;
                f fVar3 = null;
                int i15 = 0;
                while (i15 < i13) {
                    if (z6) {
                        i3 = (i13 - i15) - 1;
                        f2 = 1.0f - this.L0;
                    } else {
                        f2 = f10;
                        i3 = i15;
                    }
                    f fVar4 = this.f17709a1[i3];
                    if (fVar4 != null && fVar4.f17658h0 != 8) {
                        d dVar = fVar4.I;
                        if (i15 == 0) {
                            fVar4.f(dVar, this.I, this.f17727y0);
                            fVar4.f17661j0 = this.F0;
                            fVar4.f17652e0 = f2;
                        }
                        if (i15 == i13 - 1) {
                            fVar4.f(fVar4.K, this.K, this.f17728z0);
                        }
                        if (i15 > 0 && fVar3 != null) {
                            int i16 = this.R0;
                            d dVar2 = fVar3.K;
                            fVar4.f(dVar, dVar2, i16);
                            fVar3.f(dVar2, dVar, 0);
                        }
                        fVar3 = fVar4;
                    }
                    i15++;
                    f10 = f2;
                }
                for (int i17 = 0; i17 < i14; i17++) {
                    f fVar5 = this.Z0[i17];
                    if (fVar5 != null && fVar5.f17658h0 != 8) {
                        d dVar3 = fVar5.J;
                        if (i17 == 0) {
                            fVar5.f(dVar3, this.J, this.f17723u0);
                            fVar5.f17663k0 = this.G0;
                            fVar5.f17654f0 = this.M0;
                        }
                        if (i17 == i14 - 1) {
                            fVar5.f(fVar5.L, this.L, this.f17724v0);
                        }
                        if (i17 > 0 && fVar3 != null) {
                            int i18 = this.S0;
                            d dVar4 = fVar3.L;
                            fVar5.f(dVar3, dVar4, i18);
                            fVar3.f(dVar4, dVar3, 0);
                        }
                        fVar3 = fVar5;
                    }
                }
                for (int i19 = 0; i19 < i13; i19++) {
                    for (int i20 = 0; i20 < i14; i20++) {
                        int i21 = (i20 * i13) + i19;
                        if (this.X0 == 1) {
                            i21 = (i19 * i14) + i20;
                        }
                        f[] fVarArr = this.f17711c1;
                        if (i21 < fVarArr.length && (fVar = fVarArr[i21]) != null && fVar.f17658h0 != 8) {
                            f fVar6 = this.f17709a1[i19];
                            f fVar7 = this.Z0[i20];
                            if (fVar != fVar6) {
                                fVar.f(fVar.I, fVar6.I, 0);
                                fVar.f(fVar.K, fVar6.K, 0);
                            }
                            if (fVar != fVar7) {
                                fVar.f(fVar.J, fVar7.J, 0);
                                fVar.f(fVar.L, fVar7.L, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((h) arrayList.get(0)).b(0, z6, true);
        }
        this.A0 = false;
    }

    @Override // q0.l, q0.f
    public final void g(f fVar, HashMap hashMap) {
        super.g(fVar, hashMap);
        i iVar = (i) fVar;
        this.F0 = iVar.F0;
        this.G0 = iVar.G0;
        this.H0 = iVar.H0;
        this.I0 = iVar.I0;
        this.J0 = iVar.J0;
        this.K0 = iVar.K0;
        this.L0 = iVar.L0;
        this.M0 = iVar.M0;
        this.N0 = iVar.N0;
        this.O0 = iVar.O0;
        this.P0 = iVar.P0;
        this.Q0 = iVar.Q0;
        this.R0 = iVar.R0;
        this.S0 = iVar.S0;
        this.T0 = iVar.T0;
        this.U0 = iVar.U0;
        this.V0 = iVar.V0;
        this.W0 = iVar.W0;
        this.X0 = iVar.X0;
    }
}
