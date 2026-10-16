package o0;

import ef.i;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: f, reason: collision with root package name */
    public e[] f16666f;

    /* renamed from: g, reason: collision with root package name */
    public e[] f16667g;

    /* renamed from: h, reason: collision with root package name */
    public int f16668h;

    /* renamed from: i, reason: collision with root package name */
    public i f16669i;

    @Override // o0.b
    public final e d(boolean[] zArr) {
        int i3 = -1;
        for (int i10 = 0; i10 < this.f16668h; i10++) {
            e[] eVarArr = this.f16666f;
            e eVar = eVarArr[i10];
            if (!zArr[eVar.f16671b]) {
                i iVar = this.f16669i;
                iVar.f12629b = eVar;
                int i11 = 8;
                if (i3 == -1) {
                    while (i11 >= 0) {
                        float f2 = ((e) iVar.f12629b).f16676h[i11];
                        if (f2 <= 0.0f) {
                            if (f2 < 0.0f) {
                                i3 = i10;
                                break;
                            }
                            i11--;
                        }
                    }
                } else {
                    e eVar2 = eVarArr[i3];
                    while (true) {
                        if (i11 >= 0) {
                            float f10 = eVar2.f16676h[i11];
                            float f11 = ((e) iVar.f12629b).f16676h[i11];
                            if (f11 == f10) {
                                i11--;
                            } else if (f11 >= f10) {
                            }
                        }
                    }
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        return this.f16666f[i3];
    }

    @Override // o0.b
    public final boolean e() {
        return this.f16668h == 0;
    }

    @Override // o0.b
    public final void i(c cVar, b bVar, boolean z5) {
        e eVar = bVar.f16646a;
        if (eVar == null) {
            return;
        }
        a aVar = bVar.f16649d;
        int d5 = aVar.d();
        for (int i3 = 0; i3 < d5; i3++) {
            e e = aVar.e(i3);
            float f2 = aVar.f(i3);
            i iVar = this.f16669i;
            iVar.f12629b = e;
            boolean z6 = e.f16670a;
            float[] fArr = eVar.f16676h;
            if (z6) {
                boolean z8 = true;
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr2 = ((e) iVar.f12629b).f16676h;
                    float f10 = (fArr[i10] * f2) + fArr2[i10];
                    fArr2[i10] = f10;
                    if (Math.abs(f10) < 1.0E-4f) {
                        ((e) iVar.f12629b).f16676h[i10] = 0.0f;
                    } else {
                        z8 = false;
                    }
                }
                if (z8) {
                    ((d) iVar.f12630c).k((e) iVar.f12629b);
                }
            } else {
                for (int i11 = 0; i11 < 9; i11++) {
                    float f11 = fArr[i11];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f2;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        ((e) iVar.f12629b).f16676h[i11] = f12;
                    } else {
                        ((e) iVar.f12629b).f16676h[i11] = 0.0f;
                    }
                }
                j(e);
            }
            this.f16647b = (bVar.f16647b * f2) + this.f16647b;
        }
        k(eVar);
    }

    public final void j(e eVar) {
        int i3;
        int i10 = this.f16668h + 1;
        e[] eVarArr = this.f16666f;
        if (i10 > eVarArr.length) {
            e[] eVarArr2 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
            this.f16666f = eVarArr2;
            this.f16667g = (e[]) Arrays.copyOf(eVarArr2, eVarArr2.length * 2);
        }
        e[] eVarArr3 = this.f16666f;
        int i11 = this.f16668h;
        eVarArr3[i11] = eVar;
        int i12 = i11 + 1;
        this.f16668h = i12;
        if (i12 > 1 && eVarArr3[i11].f16671b > eVar.f16671b) {
            int i13 = 0;
            while (true) {
                i3 = this.f16668h;
                if (i13 >= i3) {
                    break;
                }
                this.f16667g[i13] = this.f16666f[i13];
                i13++;
            }
            Arrays.sort(this.f16667g, 0, i3, new androidx.viewpager2.widget.a(12));
            for (int i14 = 0; i14 < this.f16668h; i14++) {
                this.f16666f[i14] = this.f16667g[i14];
            }
        }
        eVar.f16670a = true;
        eVar.a(this);
    }

    public final void k(e eVar) {
        int i3 = 0;
        while (i3 < this.f16668h) {
            if (this.f16666f[i3] == eVar) {
                while (true) {
                    int i10 = this.f16668h;
                    if (i3 >= i10 - 1) {
                        this.f16668h = i10 - 1;
                        eVar.f16670a = false;
                        return;
                    } else {
                        e[] eVarArr = this.f16666f;
                        int i11 = i3 + 1;
                        eVarArr[i3] = eVarArr[i11];
                        i3 = i11;
                    }
                }
            } else {
                i3++;
            }
        }
    }

    @Override // o0.b
    public final String toString() {
        String str = " goal -> (" + this.f16647b + ") : ";
        for (int i3 = 0; i3 < this.f16668h; i3++) {
            e eVar = this.f16666f[i3];
            i iVar = this.f16669i;
            iVar.f12629b = eVar;
            str = str + iVar + " ";
        }
        return str;
    }
}
