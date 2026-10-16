package r0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import q0.k;
import q0.l;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final b f17976a = new b();

    public static boolean a(q0.f fVar) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = fVar.T;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = constraintWidget$DimensionBehaviourArr[0];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = constraintWidget$DimensionBehaviourArr[1];
        q0.f fVar2 = fVar.U;
        q0.g gVar = fVar2 != null ? (q0.g) fVar2 : null;
        if (gVar != null) {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = gVar.T[0];
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.FIXED;
        }
        if (gVar != null) {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour7 = gVar.T[1];
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour8 = ConstraintWidget$DimensionBehaviour.FIXED;
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour9 = ConstraintWidget$DimensionBehaviour.FIXED;
        boolean z5 = constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour9 || fVar.y() || constraintWidget$DimensionBehaviour3 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT || (constraintWidget$DimensionBehaviour3 == (constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && fVar.f17674q == 0 && fVar.X == 0.0f && fVar.r(0)) || (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour2 && fVar.f17674q == 1 && fVar.s(0, fVar.o()));
        boolean z6 = constraintWidget$DimensionBehaviour4 == constraintWidget$DimensionBehaviour9 || fVar.z() || constraintWidget$DimensionBehaviour4 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT || (constraintWidget$DimensionBehaviour4 == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && fVar.r == 0 && fVar.X == 0.0f && fVar.r(1)) || (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour && fVar.r == 1 && fVar.s(1, fVar.l()));
        return (fVar.X > 0.0f && (z5 || z6)) || (z5 && z6);
    }

    public static i b(q0.f fVar, int i3, ArrayList arrayList, i iVar) {
        int i10;
        int i11 = i3 == 0 ? fVar.f17675q0 : fVar.f17676r0;
        if (i11 != -1 && (iVar == null || i11 != iVar.f17981b)) {
            int i12 = 0;
            while (true) {
                if (i12 >= arrayList.size()) {
                    break;
                }
                i iVar2 = (i) arrayList.get(i12);
                if (iVar2.f17981b == i11) {
                    if (iVar != null) {
                        iVar.c(i3, iVar2);
                        arrayList.remove(iVar);
                    }
                    iVar = iVar2;
                } else {
                    i12++;
                }
            }
        } else if (i11 != -1) {
            return iVar;
        }
        if (iVar == null) {
            if (fVar instanceof l) {
                l lVar = (l) fVar;
                int i13 = 0;
                while (true) {
                    if (i13 >= lVar.f17721t0) {
                        i10 = -1;
                        break;
                    }
                    q0.f fVar2 = lVar.f17720s0[i13];
                    if ((i3 == 0 && (i10 = fVar2.f17675q0) != -1) || (i3 == 1 && (i10 = fVar2.f17676r0) != -1)) {
                        break;
                    }
                    i13++;
                }
                if (i10 != -1) {
                    int i14 = 0;
                    while (true) {
                        if (i14 >= arrayList.size()) {
                            break;
                        }
                        i iVar3 = (i) arrayList.get(i14);
                        if (iVar3.f17981b == i10) {
                            iVar = iVar3;
                            break;
                        }
                        i14++;
                    }
                }
            }
            if (iVar == null) {
                iVar = new i();
                iVar.f17980a = new ArrayList();
                iVar.f17983d = null;
                iVar.e = -1;
                int i15 = i.f17979f;
                i.f17979f = i15 + 1;
                iVar.f17981b = i15;
                iVar.f17982c = i3;
            }
            arrayList.add(iVar);
        }
        ArrayList arrayList2 = iVar.f17980a;
        if (arrayList2.contains(fVar)) {
            return iVar;
        }
        arrayList2.add(fVar);
        if (fVar instanceof k) {
            k kVar = (k) fVar;
            kVar.f17717v0.c(kVar.f17718w0 == 0 ? 1 : 0, arrayList, iVar);
        }
        int i16 = iVar.f17981b;
        if (i3 == 0) {
            fVar.f17675q0 = i16;
            fVar.I.c(i3, arrayList, iVar);
            fVar.K.c(i3, arrayList, iVar);
        } else {
            fVar.f17676r0 = i16;
            fVar.J.c(i3, arrayList, iVar);
            fVar.M.c(i3, arrayList, iVar);
            fVar.L.c(i3, arrayList, iVar);
        }
        fVar.P.c(i3, arrayList, iVar);
        return iVar;
    }

    public static void c(int i3, q0.f fVar, w0.f fVar2, boolean z5) {
        q0.d dVar;
        q0.d dVar2;
        q0.d dVar3;
        q0.d dVar4;
        q0.d dVar5;
        if (fVar.f17664l) {
            return;
        }
        if (!(fVar instanceof q0.g) && fVar.x() && a(fVar)) {
            q0.g.R(fVar, fVar2, new b());
        }
        q0.d j4 = fVar.j(ConstraintAnchor$Type.LEFT);
        q0.d j10 = fVar.j(ConstraintAnchor$Type.RIGHT);
        int d5 = j4.d();
        int d8 = j10.d();
        HashSet hashSet = j4.f17634a;
        char c9 = 0;
        if (hashSet != null && j4.f17636c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                q0.d dVar6 = (q0.d) it.next();
                q0.f fVar3 = dVar6.f17637d;
                int i10 = i3 + 1;
                boolean a3 = a(fVar3);
                if (fVar3.x() && a3) {
                    q0.g.R(fVar3, fVar2, new b());
                }
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = fVar3.T[c9];
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                char c10 = c9;
                q0.d dVar7 = fVar3.I;
                q0.d dVar8 = fVar3.K;
                if (constraintWidget$DimensionBehaviour != constraintWidget$DimensionBehaviour2 || a3) {
                    if (!fVar3.x()) {
                        if (dVar6 == dVar7 && dVar8.f17638f == null) {
                            int e = dVar7.e() + d5;
                            fVar3.F(e, fVar3.o() + e);
                            c(i10, fVar3, fVar2, z5);
                        } else if (dVar6 == dVar8 && dVar7.f17638f == null) {
                            int e10 = d5 - dVar8.e();
                            fVar3.F(e10 - fVar3.o(), e10);
                            c(i10, fVar3, fVar2, z5);
                        } else if (dVar6 == dVar7 && (dVar3 = dVar8.f17638f) != null && dVar3.f17636c && !fVar3.v()) {
                            d(i10, fVar3, fVar2, z5);
                        }
                    }
                } else if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 && fVar3.f17679u >= 0 && fVar3.f17678t >= 0 && ((fVar3.f17658h0 == 8 || (fVar3.f17674q == 0 && fVar3.X == 0.0f)) && !fVar3.v() && !fVar3.F && (((dVar6 == dVar7 && (dVar5 = dVar8.f17638f) != null && dVar5.f17636c) || (dVar6 == dVar8 && (dVar4 = dVar7.f17638f) != null && dVar4.f17636c)) && !fVar3.v()))) {
                    e(i10, fVar, fVar2, fVar3, z5);
                }
                c9 = c10;
            }
        }
        char c11 = c9;
        if (fVar instanceof k) {
            return;
        }
        HashSet hashSet2 = j10.f17634a;
        if (hashSet2 != null && j10.f17636c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                q0.d dVar9 = (q0.d) it2.next();
                q0.f fVar4 = dVar9.f17637d;
                int i11 = i3 + 1;
                boolean a10 = a(fVar4);
                if (fVar4.x() && a10) {
                    q0.g.R(fVar4, fVar2, new b());
                }
                q0.d dVar10 = fVar4.I;
                q0.d dVar11 = fVar4.K;
                char c12 = ((dVar9 == dVar10 && (dVar2 = dVar11.f17638f) != null && dVar2.f17636c) || (dVar9 == dVar11 && (dVar = dVar10.f17638f) != null && dVar.f17636c)) ? (char) 1 : c11;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = fVar4.T[c11];
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (constraintWidget$DimensionBehaviour3 != constraintWidget$DimensionBehaviour4 || a10) {
                    if (!fVar4.x()) {
                        if (dVar9 == dVar10 && dVar11.f17638f == null) {
                            int e11 = dVar10.e() + d8;
                            fVar4.F(e11, fVar4.o() + e11);
                            c(i11, fVar4, fVar2, z5);
                        } else if (dVar9 == dVar11 && dVar10.f17638f == null) {
                            int e12 = d8 - dVar11.e();
                            fVar4.F(e12 - fVar4.o(), e12);
                            c(i11, fVar4, fVar2, z5);
                        } else if (c12 != 0 && !fVar4.v()) {
                            d(i11, fVar4, fVar2, z5);
                        }
                    }
                } else if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour4 && fVar4.f17679u >= 0 && fVar4.f17678t >= 0 && (fVar4.f17658h0 == 8 || (fVar4.f17674q == 0 && fVar4.X == 0.0f))) {
                    if (!fVar4.v() && !fVar4.F && c12 != 0 && !fVar4.v()) {
                        e(i11, fVar, fVar2, fVar4, z5);
                    }
                }
            }
        }
        fVar.f17664l = true;
    }

    public static void d(int i3, q0.f fVar, w0.f fVar2, boolean z5) {
        float f2 = fVar.f17652e0;
        q0.d dVar = fVar.I;
        int d5 = dVar.f17638f.d();
        q0.d dVar2 = fVar.K;
        int d8 = dVar2.f17638f.d();
        int e = dVar.e() + d5;
        int e10 = d8 - dVar2.e();
        if (d5 == d8) {
            f2 = 0.5f;
        } else {
            d5 = e;
            d8 = e10;
        }
        int o3 = fVar.o();
        int i10 = (d8 - d5) - o3;
        if (d5 > d8) {
            i10 = (d5 - d8) - o3;
        }
        int i11 = ((int) (i10 > 0 ? (f2 * i10) + 0.5f : f2 * i10)) + d5;
        int i12 = i11 + o3;
        if (d5 > d8) {
            i12 = i11 - o3;
        }
        fVar.F(i11, i12);
        c(i3 + 1, fVar, fVar2, z5);
    }

    public static void e(int i3, q0.f fVar, w0.f fVar2, q0.f fVar3, boolean z5) {
        float f2 = fVar3.f17652e0;
        q0.d dVar = fVar3.I;
        int e = dVar.e() + dVar.f17638f.d();
        q0.d dVar2 = fVar3.K;
        int d5 = dVar2.f17638f.d() - dVar2.e();
        if (d5 >= e) {
            int o3 = fVar3.o();
            if (fVar3.f17658h0 != 8) {
                int i10 = fVar3.f17674q;
                if (i10 == 2) {
                    o3 = (int) (fVar3.f17652e0 * 0.5f * (fVar instanceof q0.g ? fVar.o() : fVar.U.o()));
                } else if (i10 == 0) {
                    o3 = d5 - e;
                }
                o3 = Math.max(fVar3.f17678t, o3);
                int i11 = fVar3.f17679u;
                if (i11 > 0) {
                    o3 = Math.min(i11, o3);
                }
            }
            int i12 = e + ((int) ((f2 * ((d5 - e) - o3)) + 0.5f));
            fVar3.F(i12, o3 + i12);
            c(i3 + 1, fVar3, fVar2, z5);
        }
    }

    public static void f(int i3, q0.f fVar, w0.f fVar2) {
        float f2 = fVar.f17654f0;
        q0.d dVar = fVar.J;
        int d5 = dVar.f17638f.d();
        q0.d dVar2 = fVar.L;
        int d8 = dVar2.f17638f.d();
        int e = dVar.e() + d5;
        int e10 = d8 - dVar2.e();
        if (d5 == d8) {
            f2 = 0.5f;
        } else {
            d5 = e;
            d8 = e10;
        }
        int l3 = fVar.l();
        int i10 = (d8 - d5) - l3;
        if (d5 > d8) {
            i10 = (d5 - d8) - l3;
        }
        int i11 = (int) (i10 > 0 ? (f2 * i10) + 0.5f : f2 * i10);
        int i12 = d5 + i11;
        int i13 = i12 + l3;
        if (d5 > d8) {
            i12 = d5 - i11;
            i13 = i12 - l3;
        }
        fVar.G(i12, i13);
        i(i3 + 1, fVar, fVar2);
    }

    public static void g(int i3, q0.f fVar, w0.f fVar2, q0.f fVar3) {
        float f2 = fVar3.f17654f0;
        q0.d dVar = fVar3.J;
        int e = dVar.e() + dVar.f17638f.d();
        q0.d dVar2 = fVar3.L;
        int d5 = dVar2.f17638f.d() - dVar2.e();
        if (d5 >= e) {
            int l3 = fVar3.l();
            if (fVar3.f17658h0 != 8) {
                int i10 = fVar3.r;
                if (i10 == 2) {
                    l3 = (int) (f2 * 0.5f * (fVar instanceof q0.g ? fVar.l() : fVar.U.l()));
                } else if (i10 == 0) {
                    l3 = d5 - e;
                }
                l3 = Math.max(fVar3.f17681w, l3);
                int i11 = fVar3.f17682x;
                if (i11 > 0) {
                    l3 = Math.min(i11, l3);
                }
            }
            int i12 = e + ((int) ((f2 * ((d5 - e) - l3)) + 0.5f));
            fVar3.G(i12, l3 + i12);
            i(i3 + 1, fVar3, fVar2);
        }
    }

    public static boolean h(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour7 = ConstraintWidget$DimensionBehaviour.FIXED;
        return (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour7 || constraintWidget$DimensionBehaviour3 == (constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || (constraintWidget$DimensionBehaviour3 == ConstraintWidget$DimensionBehaviour.MATCH_PARENT && constraintWidget$DimensionBehaviour != constraintWidget$DimensionBehaviour6)) || (constraintWidget$DimensionBehaviour4 == constraintWidget$DimensionBehaviour7 || constraintWidget$DimensionBehaviour4 == (constraintWidget$DimensionBehaviour5 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || (constraintWidget$DimensionBehaviour4 == ConstraintWidget$DimensionBehaviour.MATCH_PARENT && constraintWidget$DimensionBehaviour2 != constraintWidget$DimensionBehaviour5));
    }

    public static void i(int i3, q0.f fVar, w0.f fVar2) {
        q0.d dVar;
        q0.d dVar2;
        q0.d dVar3;
        q0.d dVar4;
        q0.d dVar5;
        q0.d dVar6;
        if (fVar.f17666m) {
            return;
        }
        if (!(fVar instanceof q0.g) && fVar.x() && a(fVar)) {
            q0.g.R(fVar, fVar2, new b());
        }
        q0.d j4 = fVar.j(ConstraintAnchor$Type.TOP);
        q0.d j10 = fVar.j(ConstraintAnchor$Type.BOTTOM);
        int d5 = j4.d();
        int d8 = j10.d();
        HashSet hashSet = j4.f17634a;
        if (hashSet != null && j4.f17636c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                q0.d dVar7 = (q0.d) it.next();
                q0.f fVar3 = dVar7.f17637d;
                int i10 = i3 + 1;
                boolean a3 = a(fVar3);
                if (fVar3.x() && a3) {
                    q0.g.R(fVar3, fVar2, new b());
                }
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = fVar3.T[1];
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                q0.d dVar8 = fVar3.J;
                q0.d dVar9 = fVar3.L;
                if (constraintWidget$DimensionBehaviour != constraintWidget$DimensionBehaviour2 || a3) {
                    if (!fVar3.x()) {
                        if (dVar7 == dVar8 && dVar9.f17638f == null) {
                            int e = dVar8.e() + d5;
                            fVar3.G(e, fVar3.l() + e);
                            i(i10, fVar3, fVar2);
                        } else if (dVar7 == dVar9 && dVar9.f17638f == null) {
                            int e10 = d5 - dVar9.e();
                            fVar3.G(e10 - fVar3.l(), e10);
                            i(i10, fVar3, fVar2);
                        } else if (dVar7 == dVar8 && (dVar4 = dVar9.f17638f) != null && dVar4.f17636c) {
                            f(i10, fVar3, fVar2);
                        }
                    }
                } else if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 && fVar3.f17682x >= 0 && fVar3.f17681w >= 0 && (fVar3.f17658h0 == 8 || (fVar3.r == 0 && fVar3.X == 0.0f))) {
                    if (!fVar3.w() && !fVar3.F && ((dVar7 == dVar8 && (dVar6 = dVar9.f17638f) != null && dVar6.f17636c) || (dVar7 == dVar9 && (dVar5 = dVar8.f17638f) != null && dVar5.f17636c))) {
                        if (!fVar3.w()) {
                            g(i10, fVar, fVar2, fVar3);
                        }
                    }
                }
            }
        }
        if (fVar instanceof k) {
            return;
        }
        HashSet hashSet2 = j10.f17634a;
        if (hashSet2 != null && j10.f17636c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                q0.d dVar10 = (q0.d) it2.next();
                q0.f fVar4 = dVar10.f17637d;
                int i11 = i3 + 1;
                boolean a10 = a(fVar4);
                if (fVar4.x() && a10) {
                    q0.g.R(fVar4, fVar2, new b());
                }
                q0.d dVar11 = fVar4.J;
                q0.d dVar12 = fVar4.L;
                boolean z5 = (dVar10 == dVar11 && (dVar3 = dVar12.f17638f) != null && dVar3.f17636c) || (dVar10 == dVar12 && (dVar2 = dVar11.f17638f) != null && dVar2.f17636c);
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = fVar4.T[1];
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (constraintWidget$DimensionBehaviour3 != constraintWidget$DimensionBehaviour4 || a10) {
                    if (!fVar4.x()) {
                        if (dVar10 == dVar11 && dVar12.f17638f == null) {
                            int e11 = dVar11.e() + d8;
                            fVar4.G(e11, fVar4.l() + e11);
                            i(i11, fVar4, fVar2);
                        } else if (dVar10 == dVar12 && dVar11.f17638f == null) {
                            int e12 = d8 - dVar12.e();
                            fVar4.G(e12 - fVar4.l(), e12);
                            i(i11, fVar4, fVar2);
                        } else if (z5 && !fVar4.w()) {
                            f(i11, fVar4, fVar2);
                        }
                    }
                } else if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour4 && fVar4.f17682x >= 0 && fVar4.f17681w >= 0 && (fVar4.f17658h0 == 8 || (fVar4.r == 0 && fVar4.X == 0.0f))) {
                    if (!fVar4.w() && !fVar4.F && z5 && !fVar4.w()) {
                        g(i11, fVar, fVar2, fVar4);
                    }
                }
            }
        }
        q0.d j11 = fVar.j(ConstraintAnchor$Type.BASELINE);
        if (j11.f17634a != null && j11.f17636c) {
            int d10 = j11.d();
            Iterator it3 = j11.f17634a.iterator();
            while (it3.hasNext()) {
                q0.d dVar13 = (q0.d) it3.next();
                q0.f fVar5 = dVar13.f17637d;
                int i12 = i3 + 1;
                boolean a11 = a(fVar5);
                if (fVar5.x() && a11) {
                    q0.g.R(fVar5, fVar2, new b());
                }
                if (fVar5.T[1] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT || a11) {
                    if (!fVar5.x() && dVar13 == (dVar = fVar5.M)) {
                        int e13 = dVar13.e() + d10;
                        if (fVar5.D) {
                            int i13 = e13 - fVar5.f17647b0;
                            int i14 = fVar5.W + i13;
                            fVar5.f17645a0 = i13;
                            fVar5.J.l(i13);
                            fVar5.L.l(i14);
                            dVar.l(e13);
                            fVar5.f17662k = true;
                        }
                        i(i12, fVar5, fVar2);
                    }
                }
            }
        }
        fVar.f17666m = true;
    }
}
