package q0;

import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public int f17693a;

    /* renamed from: d, reason: collision with root package name */
    public d f17696d;
    public d e;

    /* renamed from: f, reason: collision with root package name */
    public d f17697f;

    /* renamed from: g, reason: collision with root package name */
    public d f17698g;

    /* renamed from: h, reason: collision with root package name */
    public int f17699h;

    /* renamed from: i, reason: collision with root package name */
    public int f17700i;

    /* renamed from: j, reason: collision with root package name */
    public int f17701j;

    /* renamed from: k, reason: collision with root package name */
    public int f17702k;

    /* renamed from: q, reason: collision with root package name */
    public int f17708q;
    public final /* synthetic */ i r;

    /* renamed from: b, reason: collision with root package name */
    public f f17694b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f17695c = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f17703l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f17704m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f17705n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f17706o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f17707p = 0;

    public h(i iVar, int i3, d dVar, d dVar2, d dVar3, d dVar4, int i10) {
        this.r = iVar;
        this.f17693a = i3;
        this.f17696d = dVar;
        this.e = dVar2;
        this.f17697f = dVar3;
        this.f17698g = dVar4;
        this.f17699h = iVar.f17727y0;
        this.f17700i = iVar.f17723u0;
        this.f17701j = iVar.f17728z0;
        this.f17702k = iVar.f17724v0;
        this.f17708q = i10;
    }

    public final void a(f fVar) {
        int i3 = this.f17693a;
        i iVar = this.r;
        if (i3 == 0) {
            int T = iVar.T(fVar, this.f17708q);
            if (fVar.T[0] == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                this.f17707p++;
                T = 0;
            }
            this.f17703l = T + (fVar.f17658h0 != 8 ? iVar.R0 : 0) + this.f17703l;
            int S = iVar.S(fVar, this.f17708q);
            if (this.f17694b == null || this.f17695c < S) {
                this.f17694b = fVar;
                this.f17695c = S;
                this.f17704m = S;
            }
        } else {
            int T2 = iVar.T(fVar, this.f17708q);
            int S2 = iVar.S(fVar, this.f17708q);
            if (fVar.T[1] == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                this.f17707p++;
                S2 = 0;
            }
            this.f17704m = S2 + (fVar.f17658h0 != 8 ? iVar.S0 : 0) + this.f17704m;
            if (this.f17694b == null || this.f17695c < T2) {
                this.f17694b = fVar;
                this.f17695c = T2;
                this.f17703l = T2;
            }
        }
        this.f17706o++;
    }

    public final void b(int i3, boolean z5, boolean z6) {
        i iVar;
        int i10;
        int i11;
        f fVar;
        boolean z8;
        char c9;
        float f2;
        float f10;
        int i12;
        float f11;
        float f12;
        int i13;
        int i14 = this.f17706o;
        int i15 = 0;
        while (true) {
            iVar = this.r;
            if (i15 >= i14 || (i13 = this.f17705n + i15) >= iVar.f17712d1) {
                break;
            }
            f fVar2 = iVar.f17711c1[i13];
            if (fVar2 != null) {
                fVar2.B();
            }
            i15++;
        }
        if (i14 == 0 || this.f17694b == null) {
            return;
        }
        boolean z10 = z6 && i3 == 0;
        int i16 = -1;
        int i17 = -1;
        for (int i18 = 0; i18 < i14; i18++) {
            int i19 = this.f17705n + (z5 ? (i14 - 1) - i18 : i18);
            if (i19 >= iVar.f17712d1) {
                break;
            }
            f fVar3 = iVar.f17711c1[i19];
            if (fVar3 != null && fVar3.f17658h0 == 0) {
                if (i16 == -1) {
                    i16 = i18;
                }
                i17 = i18;
            }
        }
        if (this.f17693a != 0) {
            boolean z11 = z10;
            f fVar4 = this.f17694b;
            fVar4.f17661j0 = iVar.F0;
            int i20 = this.f17699h;
            if (i3 > 0) {
                i20 += iVar.R0;
            }
            d dVar = fVar4.I;
            d dVar2 = fVar4.K;
            if (z5) {
                dVar2.a(this.f17697f, i20);
                if (z6) {
                    dVar.a(this.f17696d, this.f17701j);
                }
                if (i3 > 0) {
                    this.f17697f.f17637d.I.a(dVar2, 0);
                }
            } else {
                dVar.a(this.f17696d, i20);
                if (z6) {
                    dVar2.a(this.f17697f, this.f17701j);
                }
                if (i3 > 0) {
                    this.f17696d.f17637d.K.a(dVar, 0);
                }
            }
            f fVar5 = null;
            for (int i21 = 0; i21 < i14; i21++) {
                int i22 = this.f17705n + i21;
                if (i22 >= iVar.f17712d1) {
                    return;
                }
                f fVar6 = iVar.f17711c1[i22];
                if (fVar6 != null) {
                    d dVar3 = fVar6.J;
                    if (i21 == 0) {
                        fVar6.f(dVar3, this.e, this.f17700i);
                        int i23 = iVar.G0;
                        float f13 = iVar.M0;
                        if (this.f17705n == 0) {
                            i11 = iVar.I0;
                            i10 = -1;
                            if (i11 != -1) {
                                f13 = iVar.O0;
                                i23 = i11;
                                fVar6.f17663k0 = i23;
                                fVar6.f17654f0 = f13;
                            }
                        } else {
                            i10 = -1;
                        }
                        if (z6 && (i11 = iVar.K0) != i10) {
                            f13 = iVar.Q0;
                            i23 = i11;
                        }
                        fVar6.f17663k0 = i23;
                        fVar6.f17654f0 = f13;
                    }
                    if (i21 == i14 - 1) {
                        fVar6.f(fVar6.L, this.f17698g, this.f17702k);
                    }
                    if (fVar5 != null) {
                        int i24 = iVar.S0;
                        d dVar4 = fVar5.L;
                        dVar3.a(dVar4, i24);
                        if (i21 == i16) {
                            int i25 = this.f17700i;
                            if (dVar3.h()) {
                                dVar3.f17640h = i25;
                            }
                        }
                        dVar4.a(dVar3, 0);
                        if (i21 == i17 + 1) {
                            int i26 = this.f17702k;
                            if (dVar4.h()) {
                                dVar4.f17640h = i26;
                            }
                        }
                    }
                    if (fVar6 != fVar4) {
                        d dVar5 = fVar6.K;
                        d dVar6 = fVar6.I;
                        if (z5) {
                            int i27 = iVar.T0;
                            if (i27 == 0) {
                                dVar5.a(dVar2, 0);
                            } else if (i27 == 1) {
                                dVar6.a(dVar, 0);
                            } else if (i27 == 2) {
                                dVar6.a(dVar, 0);
                                dVar5.a(dVar2, 0);
                            }
                        } else {
                            int i28 = iVar.T0;
                            if (i28 == 0) {
                                dVar6.a(dVar, 0);
                            } else if (i28 == 1) {
                                dVar5.a(dVar2, 0);
                            } else if (i28 == 2) {
                                if (z11) {
                                    dVar6.a(this.f17696d, this.f17699h);
                                    dVar5.a(this.f17697f, this.f17701j);
                                } else {
                                    dVar6.a(dVar, 0);
                                    dVar5.a(dVar2, 0);
                                }
                            }
                            fVar5 = fVar6;
                        }
                    }
                    fVar5 = fVar6;
                }
            }
            return;
        }
        f fVar7 = this.f17694b;
        fVar7.f17663k0 = iVar.G0;
        int i29 = this.f17700i;
        if (i3 > 0) {
            i29 += iVar.S0;
        }
        d dVar7 = this.e;
        d dVar8 = fVar7.J;
        dVar8.a(dVar7, i29);
        d dVar9 = fVar7.L;
        if (z6) {
            dVar9.a(this.f17698g, this.f17702k);
        }
        if (i3 > 0) {
            this.e.f17637d.L.a(dVar8, 0);
        }
        if (iVar.U0 == 3 && !fVar7.D) {
            for (int i30 = 0; i30 < i14; i30++) {
                int i31 = this.f17705n + (z5 ? (i14 - 1) - i30 : i30);
                if (i31 >= iVar.f17712d1) {
                    break;
                }
                fVar = iVar.f17711c1[i31];
                if (fVar.D) {
                    break;
                }
            }
        }
        fVar = fVar7;
        int i32 = 0;
        f fVar8 = null;
        while (i32 < i14) {
            int i33 = z5 ? (i14 - 1) - i32 : i32;
            int i34 = this.f17705n + i33;
            if (i34 >= iVar.f17712d1) {
                return;
            }
            f fVar9 = iVar.f17711c1[i34];
            if (fVar9 == null) {
                z8 = z10;
                c9 = 3;
            } else {
                d dVar10 = fVar9.I;
                if (i32 == 0) {
                    fVar9.f(dVar10, this.f17696d, this.f17699h);
                }
                if (i33 == 0) {
                    int i35 = iVar.F0;
                    if (z5) {
                        f2 = 1.0f;
                        f10 = 1.0f - iVar.L0;
                    } else {
                        f2 = 1.0f;
                        f10 = iVar.L0;
                    }
                    if (this.f17705n == 0) {
                        i12 = iVar.H0;
                        z8 = z10;
                        if (i12 != -1) {
                            if (z5) {
                                f12 = iVar.N0;
                                f10 = f2 - f12;
                                fVar9.f17661j0 = i12;
                                fVar9.f17652e0 = f10;
                            } else {
                                f11 = iVar.N0;
                                f10 = f11;
                                fVar9.f17661j0 = i12;
                                fVar9.f17652e0 = f10;
                            }
                        }
                    } else {
                        z8 = z10;
                    }
                    if (!z6 || (i12 = iVar.J0) == -1) {
                        i12 = i35;
                        fVar9.f17661j0 = i12;
                        fVar9.f17652e0 = f10;
                    } else if (z5) {
                        f12 = iVar.P0;
                        f10 = f2 - f12;
                        fVar9.f17661j0 = i12;
                        fVar9.f17652e0 = f10;
                    } else {
                        f11 = iVar.P0;
                        f10 = f11;
                        fVar9.f17661j0 = i12;
                        fVar9.f17652e0 = f10;
                    }
                } else {
                    z8 = z10;
                }
                if (i32 == i14 - 1) {
                    fVar9.f(fVar9.K, this.f17697f, this.f17701j);
                }
                if (fVar8 != null) {
                    int i36 = iVar.R0;
                    d dVar11 = fVar8.K;
                    dVar10.a(dVar11, i36);
                    if (i32 == i16) {
                        int i37 = this.f17699h;
                        if (dVar10.h()) {
                            dVar10.f17640h = i37;
                        }
                    }
                    dVar11.a(dVar10, 0);
                    if (i32 == i17 + 1) {
                        int i38 = this.f17701j;
                        if (dVar11.h()) {
                            dVar11.f17640h = i38;
                        }
                    }
                }
                if (fVar9 != fVar7) {
                    int i39 = iVar.U0;
                    c9 = 3;
                    if (i39 == 3 && fVar.D && fVar9 != fVar && fVar9.D) {
                        fVar9.M.a(fVar.M, 0);
                    } else {
                        d dVar12 = fVar9.J;
                        if (i39 != 0) {
                            d dVar13 = fVar9.L;
                            if (i39 == 1) {
                                dVar13.a(dVar9, 0);
                            } else if (z8) {
                                dVar12.a(this.e, this.f17700i);
                                dVar13.a(this.f17698g, this.f17702k);
                            } else {
                                dVar12.a(dVar8, 0);
                                dVar13.a(dVar9, 0);
                            }
                        } else {
                            dVar12.a(dVar8, 0);
                        }
                    }
                } else {
                    c9 = 3;
                }
                fVar8 = fVar9;
            }
            i32++;
            z10 = z8;
        }
    }

    public final int c() {
        return this.f17693a == 1 ? this.f17704m - this.r.S0 : this.f17704m;
    }

    public final int d() {
        return this.f17693a == 0 ? this.f17703l - this.r.R0 : this.f17703l;
    }

    public final void e(int i3) {
        int i10 = this.f17707p;
        if (i10 == 0) {
            return;
        }
        int i11 = this.f17706o;
        int i12 = i3 / i10;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = this.f17705n;
            int i15 = i14 + i13;
            i iVar = this.r;
            if (i15 >= iVar.f17712d1) {
                break;
            }
            f fVar = iVar.f17711c1[i14 + i13];
            if (this.f17693a == 0) {
                if (fVar != null) {
                    ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = fVar.T;
                    if (constraintWidget$DimensionBehaviourArr[0] == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && fVar.f17674q == 0) {
                        iVar.R(fVar, ConstraintWidget$DimensionBehaviour.FIXED, i12, constraintWidget$DimensionBehaviourArr[1], fVar.l());
                    }
                }
            } else if (fVar != null) {
                ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr2 = fVar.T;
                if (constraintWidget$DimensionBehaviourArr2[1] == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && fVar.r == 0) {
                    int i16 = i12;
                    iVar.R(fVar, constraintWidget$DimensionBehaviourArr2[0], fVar.o(), ConstraintWidget$DimensionBehaviour.FIXED, i16);
                    i12 = i16;
                }
            }
        }
        this.f17703l = 0;
        this.f17704m = 0;
        this.f17694b = null;
        this.f17695c = 0;
        int i17 = this.f17706o;
        for (int i18 = 0; i18 < i17; i18++) {
            int i19 = this.f17705n + i18;
            i iVar2 = this.r;
            if (i19 >= iVar2.f17712d1) {
                return;
            }
            f fVar2 = iVar2.f17711c1[i19];
            if (this.f17693a == 0) {
                int o3 = fVar2.o();
                int i20 = iVar2.R0;
                if (fVar2.f17658h0 == 8) {
                    i20 = 0;
                }
                this.f17703l = o3 + i20 + this.f17703l;
                int S = iVar2.S(fVar2, this.f17708q);
                if (this.f17694b == null || this.f17695c < S) {
                    this.f17694b = fVar2;
                    this.f17695c = S;
                    this.f17704m = S;
                }
            } else {
                int T = iVar2.T(fVar2, this.f17708q);
                int S2 = iVar2.S(fVar2, this.f17708q);
                int i21 = iVar2.S0;
                if (fVar2.f17658h0 == 8) {
                    i21 = 0;
                }
                this.f17704m = S2 + i21 + this.f17704m;
                if (this.f17694b == null || this.f17695c < T) {
                    this.f17694b = fVar2;
                    this.f17695c = T;
                    this.f17703l = T;
                }
            }
        }
    }

    public final void f(int i3, d dVar, d dVar2, d dVar3, d dVar4, int i10, int i11, int i12, int i13, int i14) {
        this.f17693a = i3;
        this.f17696d = dVar;
        this.e = dVar2;
        this.f17697f = dVar3;
        this.f17698g = dVar4;
        this.f17699h = i10;
        this.f17700i = i11;
        this.f17701j = i12;
        this.f17702k = i13;
        this.f17708q = i14;
    }
}
