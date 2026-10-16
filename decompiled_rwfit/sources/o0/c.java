package o0;

import androidx.constraintlayout.core.SolverVariable$Type;
import ef.i;
import java.util.Arrays;
import n.l;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: p, reason: collision with root package name */
    public static boolean f16650p = false;

    /* renamed from: q, reason: collision with root package name */
    public static int f16651q = 1000;

    /* renamed from: c, reason: collision with root package name */
    public final d f16654c;

    /* renamed from: f, reason: collision with root package name */
    public b[] f16656f;

    /* renamed from: l, reason: collision with root package name */
    public final l f16662l;

    /* renamed from: o, reason: collision with root package name */
    public b f16665o;

    /* renamed from: a, reason: collision with root package name */
    public boolean f16652a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f16653b = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f16655d = 32;
    public int e = 32;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16657g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f16658h = new boolean[32];

    /* renamed from: i, reason: collision with root package name */
    public int f16659i = 1;

    /* renamed from: j, reason: collision with root package name */
    public int f16660j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f16661k = 32;

    /* renamed from: m, reason: collision with root package name */
    public e[] f16663m = new e[f16651q];

    /* renamed from: n, reason: collision with root package name */
    public int f16664n = 0;

    public c() {
        this.f16656f = null;
        this.f16656f = new b[32];
        s();
        l lVar = new l(1);
        lVar.f16245b = new k1.d();
        lVar.f16246c = new k1.d();
        lVar.f16247d = new e[32];
        this.f16662l = lVar;
        d dVar = new d(lVar);
        dVar.f16666f = new e[128];
        dVar.f16667g = new e[128];
        dVar.f16668h = 0;
        dVar.f16669i = new i(dVar);
        this.f16654c = dVar;
        this.f16665o = new b(lVar);
    }

    public static int n(Object obj) {
        e eVar = ((q0.d) obj).f17641i;
        if (eVar != null) {
            return (int) (eVar.e + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final e a(SolverVariable$Type solverVariable$Type) {
        k1.d dVar = (k1.d) this.f16662l.f16246c;
        int i3 = dVar.f15453b;
        e eVar = null;
        if (i3 > 0) {
            int i10 = i3 - 1;
            ?? r32 = dVar.f15452a;
            ?? r42 = r32[i10];
            r32[i10] = 0;
            dVar.f15453b = i10;
            eVar = r42;
        }
        e eVar2 = eVar;
        if (eVar2 == null) {
            eVar2 = new e(solverVariable$Type);
            eVar2.f16677i = solverVariable$Type;
        } else {
            eVar2.c();
            eVar2.f16677i = solverVariable$Type;
        }
        int i11 = this.f16664n;
        int i12 = f16651q;
        if (i11 >= i12) {
            int i13 = i12 * 2;
            f16651q = i13;
            this.f16663m = (e[]) Arrays.copyOf(this.f16663m, i13);
        }
        e[] eVarArr = this.f16663m;
        int i14 = this.f16664n;
        this.f16664n = i14 + 1;
        eVarArr[i14] = eVar2;
        return eVar2;
    }

    public final void b(e eVar, e eVar2, int i3, float f2, e eVar3, e eVar4, int i10, int i11) {
        b l3 = l();
        if (eVar2 == eVar3) {
            l3.f16649d.g(eVar, 1.0f);
            l3.f16649d.g(eVar4, 1.0f);
            l3.f16649d.g(eVar2, -2.0f);
        } else if (f2 == 0.5f) {
            l3.f16649d.g(eVar, 1.0f);
            l3.f16649d.g(eVar2, -1.0f);
            l3.f16649d.g(eVar3, -1.0f);
            l3.f16649d.g(eVar4, 1.0f);
            if (i3 > 0 || i10 > 0) {
                l3.f16647b = (-i3) + i10;
            }
        } else if (f2 <= 0.0f) {
            l3.f16649d.g(eVar, -1.0f);
            l3.f16649d.g(eVar2, 1.0f);
            l3.f16647b = i3;
        } else if (f2 >= 1.0f) {
            l3.f16649d.g(eVar4, -1.0f);
            l3.f16649d.g(eVar3, 1.0f);
            l3.f16647b = -i10;
        } else {
            float f10 = 1.0f - f2;
            l3.f16649d.g(eVar, f10 * 1.0f);
            l3.f16649d.g(eVar2, f10 * (-1.0f));
            l3.f16649d.g(eVar3, (-1.0f) * f2);
            l3.f16649d.g(eVar4, 1.0f * f2);
            if (i3 > 0 || i10 > 0) {
                l3.f16647b = (i10 * f2) + ((-i3) * f10);
            }
        }
        if (i11 != 8) {
            l3.a(this, i11);
        }
        c(l3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d5, code lost:
    
        if (r4.f16680l <= 1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d8, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e2, code lost:
    
        if (r4.f16680l <= 1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f7, code lost:
    
        if (r4.f16680l <= 1) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00fa, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0104, code lost:
    
        if (r4.f16680l <= 1) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(o0.b r18) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.c.c(o0.b):void");
    }

    public final void d(e eVar, int i3) {
        int i10 = eVar.f16672c;
        if (i10 == -1) {
            eVar.d(this, i3);
            for (int i11 = 0; i11 < this.f16653b + 1; i11++) {
                e eVar2 = ((e[]) this.f16662l.f16247d)[i11];
            }
            return;
        }
        if (i10 == -1) {
            b l3 = l();
            l3.f16646a = eVar;
            float f2 = i3;
            eVar.e = f2;
            l3.f16647b = f2;
            l3.e = true;
            c(l3);
            return;
        }
        b bVar = this.f16656f[i10];
        if (bVar.e) {
            bVar.f16647b = i3;
            return;
        }
        if (bVar.f16649d.d() == 0) {
            bVar.e = true;
            bVar.f16647b = i3;
            return;
        }
        b l5 = l();
        if (i3 < 0) {
            l5.f16647b = i3 * (-1);
            l5.f16649d.g(eVar, 1.0f);
        } else {
            l5.f16647b = i3;
            l5.f16649d.g(eVar, -1.0f);
        }
        c(l5);
    }

    public final void e(e eVar, e eVar2, int i3, int i10) {
        if (i10 == 8 && eVar2.f16674f && eVar.f16672c == -1) {
            eVar.d(this, eVar2.e + i3);
            return;
        }
        b l3 = l();
        boolean z5 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z5 = true;
            }
            l3.f16647b = i3;
        }
        if (z5) {
            l3.f16649d.g(eVar, 1.0f);
            l3.f16649d.g(eVar2, -1.0f);
        } else {
            l3.f16649d.g(eVar, -1.0f);
            l3.f16649d.g(eVar2, 1.0f);
        }
        if (i10 != 8) {
            l3.a(this, i10);
        }
        c(l3);
    }

    public final void f(e eVar, e eVar2, int i3, int i10) {
        b l3 = l();
        e m10 = m();
        m10.f16673d = 0;
        l3.b(eVar, eVar2, m10, i3);
        if (i10 != 8) {
            l3.f16649d.g(j(i10), (int) (l3.f16649d.c(m10) * (-1.0f)));
        }
        c(l3);
    }

    public final void g(e eVar, e eVar2, int i3, int i10) {
        b l3 = l();
        e m10 = m();
        m10.f16673d = 0;
        l3.c(eVar, eVar2, m10, i3);
        if (i10 != 8) {
            l3.f16649d.g(j(i10), (int) (l3.f16649d.c(m10) * (-1.0f)));
        }
        c(l3);
    }

    public final void h(b bVar) {
        int i3;
        if (bVar.e) {
            bVar.f16646a.d(this, bVar.f16647b);
        } else {
            b[] bVarArr = this.f16656f;
            int i10 = this.f16660j;
            bVarArr[i10] = bVar;
            e eVar = bVar.f16646a;
            eVar.f16672c = i10;
            this.f16660j = i10 + 1;
            eVar.e(this, bVar);
        }
        if (this.f16652a) {
            int i11 = 0;
            while (i11 < this.f16660j) {
                if (this.f16656f[i11] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f16656f[i11];
                if (bVar2 != null && bVar2.e) {
                    bVar2.f16646a.d(this, bVar2.f16647b);
                    ((k1.d) this.f16662l.f16245b).b(bVar2);
                    this.f16656f[i11] = null;
                    int i12 = i11 + 1;
                    int i13 = i12;
                    while (true) {
                        i3 = this.f16660j;
                        if (i12 >= i3) {
                            break;
                        }
                        b[] bVarArr2 = this.f16656f;
                        int i14 = i12 - 1;
                        b bVar3 = bVarArr2[i12];
                        bVarArr2[i14] = bVar3;
                        e eVar2 = bVar3.f16646a;
                        if (eVar2.f16672c == i12) {
                            eVar2.f16672c = i14;
                        }
                        i13 = i12;
                        i12++;
                    }
                    if (i13 < i3) {
                        this.f16656f[i13] = null;
                    }
                    this.f16660j = i3 - 1;
                    i11--;
                }
                i11++;
            }
            this.f16652a = false;
        }
    }

    public final void i() {
        for (int i3 = 0; i3 < this.f16660j; i3++) {
            b bVar = this.f16656f[i3];
            bVar.f16646a.e = bVar.f16647b;
        }
    }

    public final e j(int i3) {
        if (this.f16659i + 1 >= this.e) {
            o();
        }
        e a3 = a(SolverVariable$Type.ERROR);
        int i10 = this.f16653b + 1;
        this.f16653b = i10;
        this.f16659i++;
        a3.f16671b = i10;
        a3.f16673d = i3;
        ((e[]) this.f16662l.f16247d)[i10] = a3;
        d dVar = this.f16654c;
        dVar.f16669i.f12629b = a3;
        float[] fArr = a3.f16676h;
        Arrays.fill(fArr, 0.0f);
        fArr[a3.f16673d] = 1.0f;
        dVar.j(a3);
        return a3;
    }

    public final e k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.f16659i + 1 >= this.e) {
            o();
        }
        if (!(obj instanceof q0.d)) {
            return null;
        }
        q0.d dVar = (q0.d) obj;
        e eVar = dVar.f17641i;
        if (eVar == null) {
            dVar.k();
            eVar = dVar.f17641i;
        }
        int i3 = eVar.f16671b;
        l lVar = this.f16662l;
        if (i3 != -1 && i3 <= this.f16653b && ((e[]) lVar.f16247d)[i3] != null) {
            return eVar;
        }
        if (i3 != -1) {
            eVar.c();
        }
        int i10 = this.f16653b + 1;
        this.f16653b = i10;
        this.f16659i++;
        eVar.f16671b = i10;
        eVar.f16677i = SolverVariable$Type.UNRESTRICTED;
        ((e[]) lVar.f16247d)[i10] = eVar;
        return eVar;
    }

    public final b l() {
        Object obj;
        l lVar = this.f16662l;
        k1.d dVar = (k1.d) lVar.f16245b;
        int i3 = dVar.f15453b;
        if (i3 > 0) {
            int i10 = i3 - 1;
            Object[] objArr = dVar.f15452a;
            obj = objArr[i10];
            objArr[i10] = null;
            dVar.f15453b = i10;
        } else {
            obj = null;
        }
        b bVar = (b) obj;
        if (bVar == null) {
            return new b(lVar);
        }
        bVar.f16646a = null;
        bVar.f16649d.b();
        bVar.f16647b = 0.0f;
        bVar.e = false;
        return bVar;
    }

    public final e m() {
        if (this.f16659i + 1 >= this.e) {
            o();
        }
        e a3 = a(SolverVariable$Type.SLACK);
        int i3 = this.f16653b + 1;
        this.f16653b = i3;
        this.f16659i++;
        a3.f16671b = i3;
        ((e[]) this.f16662l.f16247d)[i3] = a3;
        return a3;
    }

    public final void o() {
        int i3 = this.f16655d * 2;
        this.f16655d = i3;
        this.f16656f = (b[]) Arrays.copyOf(this.f16656f, i3);
        l lVar = this.f16662l;
        lVar.f16247d = (e[]) Arrays.copyOf((e[]) lVar.f16247d, this.f16655d);
        int i10 = this.f16655d;
        this.f16658h = new boolean[i10];
        this.e = i10;
        this.f16661k = i10;
    }

    public final void p() {
        d dVar = this.f16654c;
        if (dVar.e()) {
            i();
            return;
        }
        if (!this.f16657g) {
            q(dVar);
            return;
        }
        for (int i3 = 0; i3 < this.f16660j; i3++) {
            if (!this.f16656f[i3].e) {
                q(dVar);
                return;
            }
        }
        i();
    }

    public final void q(d dVar) {
        int i3 = 0;
        while (true) {
            if (i3 >= this.f16660j) {
                break;
            }
            b bVar = this.f16656f[i3];
            if (bVar.f16646a.f16677i != SolverVariable$Type.UNRESTRICTED) {
                float f2 = 0.0f;
                if (bVar.f16647b < 0.0f) {
                    boolean z5 = false;
                    int i10 = 0;
                    while (!z5) {
                        i10++;
                        float f10 = Float.MAX_VALUE;
                        int i11 = -1;
                        int i12 = -1;
                        int i13 = 0;
                        int i14 = 0;
                        while (i13 < this.f16660j) {
                            b bVar2 = this.f16656f[i13];
                            if (bVar2.f16646a.f16677i != SolverVariable$Type.UNRESTRICTED && !bVar2.e && bVar2.f16647b < f2) {
                                int d5 = bVar2.f16649d.d();
                                int i15 = 0;
                                while (i15 < d5) {
                                    e e = bVar2.f16649d.e(i15);
                                    float c9 = bVar2.f16649d.c(e);
                                    if (c9 > f2) {
                                        for (int i16 = 0; i16 < 9; i16++) {
                                            float f11 = e.f16675g[i16] / c9;
                                            if ((f11 < f10 && i16 == i14) || i16 > i14) {
                                                i14 = i16;
                                                i12 = e.f16671b;
                                                i11 = i13;
                                                f10 = f11;
                                            }
                                        }
                                    }
                                    i15++;
                                    f2 = 0.0f;
                                }
                            }
                            i13++;
                            f2 = 0.0f;
                        }
                        if (i11 != -1) {
                            b bVar3 = this.f16656f[i11];
                            bVar3.f16646a.f16672c = -1;
                            bVar3.g(((e[]) this.f16662l.f16247d)[i12]);
                            e eVar = bVar3.f16646a;
                            eVar.f16672c = i11;
                            eVar.e(this, bVar3);
                        } else {
                            z5 = true;
                        }
                        if (i10 > this.f16659i / 2) {
                            z5 = true;
                        }
                        f2 = 0.0f;
                    }
                }
            }
            i3++;
        }
        r(dVar);
        i();
    }

    public final void r(b bVar) {
        boolean z5;
        int i3 = 0;
        for (int i10 = 0; i10 < this.f16659i; i10++) {
            this.f16658h[i10] = false;
        }
        boolean z6 = false;
        int i11 = 0;
        while (!z6) {
            i11++;
            if (i11 >= this.f16659i * 2) {
                return;
            }
            e eVar = bVar.f16646a;
            if (eVar != null) {
                this.f16658h[eVar.f16671b] = true;
            }
            e d5 = bVar.d(this.f16658h);
            if (d5 != null) {
                boolean[] zArr = this.f16658h;
                int i12 = d5.f16671b;
                if (zArr[i12]) {
                    return;
                } else {
                    zArr[i12] = true;
                }
            }
            if (d5 != null) {
                float f2 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = i3; i14 < this.f16660j; i14++) {
                    b bVar2 = this.f16656f[i14];
                    if (bVar2.f16646a.f16677i != SolverVariable$Type.UNRESTRICTED && !bVar2.e) {
                        a aVar = bVar2.f16649d;
                        int i15 = aVar.f16643h;
                        if (i15 != -1) {
                            for (int i16 = 0; i15 != -1 && i16 < aVar.f16637a; i16++) {
                                if (aVar.e[i15] == d5.f16671b) {
                                    z5 = true;
                                    break;
                                }
                                i15 = aVar.f16641f[i15];
                            }
                        }
                        z5 = false;
                        if (z5) {
                            float c9 = bVar2.f16649d.c(d5);
                            if (c9 < 0.0f) {
                                float f10 = (-bVar2.f16647b) / c9;
                                if (f10 < f2) {
                                    i13 = i14;
                                    f2 = f10;
                                }
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    b bVar3 = this.f16656f[i13];
                    bVar3.f16646a.f16672c = -1;
                    bVar3.g(d5);
                    e eVar2 = bVar3.f16646a;
                    eVar2.f16672c = i13;
                    eVar2.e(this, bVar3);
                }
            } else {
                z6 = true;
            }
            i3 = 0;
        }
    }

    public final void s() {
        for (int i3 = 0; i3 < this.f16660j; i3++) {
            b bVar = this.f16656f[i3];
            if (bVar != null) {
                ((k1.d) this.f16662l.f16245b).b(bVar);
            }
            this.f16656f[i3] = null;
        }
    }

    public final void t() {
        l lVar;
        int i3 = 0;
        while (true) {
            lVar = this.f16662l;
            e[] eVarArr = (e[]) lVar.f16247d;
            if (i3 >= eVarArr.length) {
                break;
            }
            e eVar = eVarArr[i3];
            if (eVar != null) {
                eVar.c();
            }
            i3++;
        }
        k1.d dVar = (k1.d) lVar.f16246c;
        e[] eVarArr2 = this.f16663m;
        int i10 = this.f16664n;
        dVar.getClass();
        if (i10 > eVarArr2.length) {
            i10 = eVarArr2.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            e eVar2 = eVarArr2[i11];
            int i12 = dVar.f15453b;
            Object[] objArr = dVar.f15452a;
            if (i12 < objArr.length) {
                objArr[i12] = eVar2;
                dVar.f15453b = i12 + 1;
            }
        }
        this.f16664n = 0;
        Arrays.fill((e[]) lVar.f16247d, (Object) null);
        this.f16653b = 0;
        d dVar2 = this.f16654c;
        dVar2.f16668h = 0;
        dVar2.f16647b = 0.0f;
        this.f16659i = 1;
        for (int i13 = 0; i13 < this.f16660j; i13++) {
            b bVar = this.f16656f[i13];
        }
        s();
        this.f16660j = 0;
        this.f16665o = new b(lVar);
    }
}
