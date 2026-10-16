package q0;

import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g extends f {
    public int A0;
    public int B0;
    public int C0;
    public b[] D0;
    public b[] E0;
    public int F0;
    public boolean G0;
    public boolean H0;
    public WeakReference I0;
    public WeakReference J0;
    public WeakReference K0;
    public WeakReference L0;
    public final HashSet M0;
    public final r0.b N0;

    /* renamed from: s0, reason: collision with root package name */
    public ArrayList f17685s0 = new ArrayList();

    /* renamed from: t0, reason: collision with root package name */
    public final n.l f17686t0 = new n.l(this);

    /* renamed from: u0, reason: collision with root package name */
    public final r0.e f17687u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f17688v0;

    /* renamed from: w0, reason: collision with root package name */
    public w0.f f17689w0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f17690x0;

    /* renamed from: y0, reason: collision with root package name */
    public final o0.c f17691y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f17692z0;

    public g() {
        r0.e eVar = new r0.e();
        eVar.f17970b = true;
        eVar.f17971c = true;
        eVar.e = new ArrayList();
        new ArrayList();
        eVar.f17973f = null;
        eVar.f17974g = new r0.b();
        eVar.f17975h = new ArrayList();
        eVar.f17969a = this;
        eVar.f17972d = this;
        this.f17687u0 = eVar;
        this.f17689w0 = null;
        this.f17690x0 = false;
        this.f17691y0 = new o0.c();
        this.B0 = 0;
        this.C0 = 0;
        this.D0 = new b[4];
        this.E0 = new b[4];
        this.F0 = 257;
        this.G0 = false;
        this.H0 = false;
        this.I0 = null;
        this.J0 = null;
        this.K0 = null;
        this.L0 = null;
        this.M0 = new HashSet();
        this.N0 = new r0.b();
    }

    public static void R(f fVar, w0.f fVar2, r0.b bVar) {
        int i3;
        int i10;
        if (fVar2 == null) {
            return;
        }
        if (fVar.f17658h0 == 8 || (fVar instanceof k) || (fVar instanceof a)) {
            bVar.e = 0;
            bVar.f17962f = 0;
            return;
        }
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = fVar.T;
        bVar.f17958a = constraintWidget$DimensionBehaviourArr[0];
        bVar.f17959b = constraintWidget$DimensionBehaviourArr[1];
        bVar.f17960c = fVar.o();
        bVar.f17961d = fVar.l();
        bVar.f17965i = false;
        bVar.f17966j = 0;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = bVar.f17958a;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z5 = constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2;
        boolean z6 = bVar.f17959b == constraintWidget$DimensionBehaviour2;
        boolean z8 = z5 && fVar.X > 0.0f;
        boolean z10 = z6 && fVar.X > 0.0f;
        if (z5 && fVar.r(0) && fVar.f17674q == 0 && !z8) {
            bVar.f17958a = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (z6 && fVar.r == 0) {
                bVar.f17958a = ConstraintWidget$DimensionBehaviour.FIXED;
            }
            z5 = false;
        }
        if (z6 && fVar.r(1) && fVar.r == 0 && !z10) {
            bVar.f17959b = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (z5 && fVar.f17674q == 0) {
                bVar.f17959b = ConstraintWidget$DimensionBehaviour.FIXED;
            }
            z6 = false;
        }
        if (fVar.y()) {
            bVar.f17958a = ConstraintWidget$DimensionBehaviour.FIXED;
            z5 = false;
        }
        if (fVar.z()) {
            bVar.f17959b = ConstraintWidget$DimensionBehaviour.FIXED;
            z6 = false;
        }
        int[] iArr = fVar.f17677s;
        if (z8) {
            if (iArr[0] == 4) {
                bVar.f17958a = ConstraintWidget$DimensionBehaviour.FIXED;
            } else if (!z6) {
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = bVar.f17959b;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.FIXED;
                if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour4) {
                    i10 = bVar.f17961d;
                } else {
                    bVar.f17958a = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    fVar2.b(fVar, bVar);
                    i10 = bVar.f17962f;
                }
                bVar.f17958a = constraintWidget$DimensionBehaviour4;
                bVar.f17960c = (int) (fVar.X * i10);
            }
        }
        if (z10) {
            if (iArr[1] == 4) {
                bVar.f17959b = ConstraintWidget$DimensionBehaviour.FIXED;
            } else if (!z5) {
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = bVar.f17958a;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.FIXED;
                if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour6) {
                    i3 = bVar.f17960c;
                } else {
                    bVar.f17959b = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    fVar2.b(fVar, bVar);
                    i3 = bVar.e;
                }
                bVar.f17959b = constraintWidget$DimensionBehaviour6;
                if (fVar.Y == -1) {
                    bVar.f17961d = (int) (i3 / fVar.X);
                } else {
                    bVar.f17961d = (int) (fVar.X * i3);
                }
            }
        }
        fVar2.b(fVar, bVar);
        fVar.K(bVar.e);
        fVar.H(bVar.f17962f);
        fVar.D = bVar.f17964h;
        fVar.E(bVar.f17963g);
        bVar.f17966j = 0;
    }

    @Override // q0.f
    public final void A() {
        this.f17691y0.t();
        this.f17692z0 = 0;
        this.A0 = 0;
        this.f17685s0.clear();
        super.A();
    }

    @Override // q0.f
    public final void D(n.l lVar) {
        super.D(lVar);
        int size = this.f17685s0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f) this.f17685s0.get(i3)).D(lVar);
        }
    }

    @Override // q0.f
    public final void L(boolean z5, boolean z6) {
        super.L(z5, z6);
        int size = this.f17685s0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f) this.f17685s0.get(i3)).L(z5, z6);
        }
    }

    public final void N(f fVar, int i3) {
        if (i3 == 0) {
            int i10 = this.B0 + 1;
            b[] bVarArr = this.E0;
            if (i10 >= bVarArr.length) {
                this.E0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.E0;
            int i11 = this.B0;
            bVarArr2[i11] = new b(fVar, 0, this.f17690x0);
            this.B0 = i11 + 1;
            return;
        }
        if (i3 == 1) {
            int i12 = this.C0 + 1;
            b[] bVarArr3 = this.D0;
            if (i12 >= bVarArr3.length) {
                this.D0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.D0;
            int i13 = this.C0;
            bVarArr4[i13] = new b(fVar, 1, this.f17690x0);
            this.C0 = i13 + 1;
        }
    }

    public final void O(o0.c cVar) {
        g gVar;
        o0.c cVar2;
        boolean S = S(64);
        b(cVar, S);
        int size = this.f17685s0.size();
        boolean z5 = false;
        for (int i3 = 0; i3 < size; i3++) {
            f fVar = (f) this.f17685s0.get(i3);
            boolean[] zArr = fVar.S;
            zArr[0] = false;
            zArr[1] = false;
            if (fVar instanceof a) {
                z5 = true;
            }
        }
        if (z5) {
            for (int i10 = 0; i10 < size; i10++) {
                f fVar2 = (f) this.f17685s0.get(i10);
                if (fVar2 instanceof a) {
                    a aVar = (a) fVar2;
                    for (int i11 = 0; i11 < aVar.f17721t0; i11++) {
                        f fVar3 = aVar.f17720s0[i11];
                        if (aVar.f17614v0 || fVar3.c()) {
                            int i12 = aVar.f17613u0;
                            if (i12 == 0 || i12 == 1) {
                                fVar3.S[0] = true;
                            } else if (i12 == 2 || i12 == 3) {
                                fVar3.S[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.M0;
        hashSet.clear();
        for (int i13 = 0; i13 < size; i13++) {
            f fVar4 = (f) this.f17685s0.get(i13);
            fVar4.getClass();
            boolean z6 = fVar4 instanceof o;
            if (z6 || (fVar4 instanceof k)) {
                if (z6) {
                    hashSet.add(fVar4);
                } else {
                    fVar4.b(cVar, S);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o oVar = (o) ((f) it.next());
                for (int i14 = 0; i14 < oVar.f17721t0; i14++) {
                    if (hashSet.contains(oVar.f17720s0[i14])) {
                        oVar.b(cVar, S);
                        hashSet.remove(oVar);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((f) it2.next()).b(cVar, S);
                }
                hashSet.clear();
            }
        }
        if (o0.c.f16650p) {
            HashSet hashSet2 = new HashSet();
            for (int i15 = 0; i15 < size; i15++) {
                f fVar5 = (f) this.f17685s0.get(i15);
                fVar5.getClass();
                if (!(fVar5 instanceof o) && !(fVar5 instanceof k)) {
                    hashSet2.add(fVar5);
                }
            }
            gVar = this;
            cVar2 = cVar;
            gVar.a(this, cVar2, hashSet2, this.T[0] == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                f fVar6 = (f) it3.next();
                m.b(this, cVar2, fVar6);
                fVar6.b(cVar2, S);
            }
        } else {
            gVar = this;
            cVar2 = cVar;
            for (int i16 = 0; i16 < size; i16++) {
                f fVar7 = (f) gVar.f17685s0.get(i16);
                if (fVar7 instanceof g) {
                    ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = fVar7.T;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviourArr[0];
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviourArr[1];
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour3) {
                        fVar7.I(ConstraintWidget$DimensionBehaviour.FIXED);
                    }
                    if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3) {
                        fVar7.J(ConstraintWidget$DimensionBehaviour.FIXED);
                    }
                    fVar7.b(cVar2, S);
                    if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour3) {
                        fVar7.I(constraintWidget$DimensionBehaviour);
                    }
                    if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3) {
                        fVar7.J(constraintWidget$DimensionBehaviour2);
                    }
                } else {
                    m.b(this, cVar2, fVar7);
                    if (!(fVar7 instanceof o) && !(fVar7 instanceof k)) {
                        fVar7.b(cVar2, S);
                    }
                }
            }
        }
        if (gVar.B0 > 0) {
            m.a(this, cVar2, null, 0);
        }
        if (gVar.C0 > 0) {
            m.a(this, cVar2, null, 1);
        }
    }

    public final boolean P(int i3, boolean z5) {
        boolean z6;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        r0.e eVar = this.f17687u0;
        g gVar = eVar.f17969a;
        boolean z8 = false;
        ConstraintWidget$DimensionBehaviour k10 = gVar.k(0);
        ConstraintWidget$DimensionBehaviour k11 = gVar.k(1);
        int p8 = gVar.p();
        int q5 = gVar.q();
        ArrayList arrayList = eVar.e;
        if (z5 && (k10 == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || k11 == constraintWidget$DimensionBehaviour)) {
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                Object obj = arrayList.get(i10);
                i10++;
                androidx.constraintlayout.core.widgets.analyzer.h hVar = (androidx.constraintlayout.core.widgets.analyzer.h) obj;
                if (hVar.f1635f == i3 && !hVar.k()) {
                    z5 = false;
                    break;
                }
            }
            if (i3 == 0) {
                if (z5 && k10 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) {
                    gVar.I(ConstraintWidget$DimensionBehaviour.FIXED);
                    gVar.K(eVar.d(gVar, 0));
                    gVar.f17650d.e.d(gVar.o());
                }
            } else if (z5 && k11 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) {
                gVar.J(ConstraintWidget$DimensionBehaviour.FIXED);
                gVar.H(eVar.d(gVar, 1));
                gVar.e.e.d(gVar.l());
            }
        }
        if (i3 == 0) {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = gVar.T[0];
            if (constraintWidget$DimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.FIXED || constraintWidget$DimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) {
                int o3 = gVar.o() + p8;
                gVar.f17650d.f1638i.d(o3);
                gVar.f17650d.e.d(o3 - p8);
                z6 = true;
            }
            z6 = false;
        } else {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = gVar.T[1];
            if (constraintWidget$DimensionBehaviour3 == ConstraintWidget$DimensionBehaviour.FIXED || constraintWidget$DimensionBehaviour3 == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) {
                int l3 = gVar.l() + q5;
                gVar.e.f1638i.d(l3);
                gVar.e.e.d(l3 - q5);
                z6 = true;
            }
            z6 = false;
        }
        eVar.g();
        int size2 = arrayList.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList.get(i11);
            i11++;
            androidx.constraintlayout.core.widgets.analyzer.h hVar2 = (androidx.constraintlayout.core.widgets.analyzer.h) obj2;
            if (hVar2.f1635f == i3 && (hVar2.f1632b != gVar || hVar2.f1636g)) {
                hVar2.e();
            }
        }
        int size3 = arrayList.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size3) {
                z8 = true;
                break;
            }
            Object obj3 = arrayList.get(i12);
            i12++;
            androidx.constraintlayout.core.widgets.analyzer.h hVar3 = (androidx.constraintlayout.core.widgets.analyzer.h) obj3;
            if (hVar3.f1635f == i3 && (z6 || hVar3.f1632b != gVar)) {
                if (!hVar3.f1637h.f1622j) {
                    break;
                }
                if (!hVar3.f1638i.f1622j) {
                    break;
                }
                if (!(hVar3 instanceof r0.c) && !hVar3.e.f1622j) {
                    break;
                }
            }
        }
        gVar.I(k10);
        gVar.J(k11);
        return z8;
    }

    /* JADX WARN: Removed duplicated region for block: B:207:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0685 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x07d5  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0830 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x08ca  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x08dd  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0920  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0922  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x08d7  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0814  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0932  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:597:0x0619 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:600:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:614:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0643  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q() {
        /*
            Method dump skipped, instructions count: 2370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.g.Q():void");
    }

    public final boolean S(int i3) {
        return (this.F0 & i3) == i3;
    }
}
