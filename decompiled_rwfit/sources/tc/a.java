package tc;

import com.google.android.gms.internal.mlkit_vision_common.e0;
import com.google.zxing.NotFoundException;
import com.google.zxing.h;
import sc.b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f18609a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18610b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18611c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18612d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f18613f;

    /* renamed from: g, reason: collision with root package name */
    public final int f18614g;

    public a(b bVar, int i3, int i10, int i11) {
        this.f18609a = bVar;
        int i12 = bVar.f18222b;
        this.f18610b = i12;
        int i13 = bVar.f18221a;
        this.f18611c = i13;
        int i14 = i3 / 2;
        int i15 = i10 - i14;
        this.f18612d = i15;
        int i16 = i10 + i14;
        this.e = i16;
        int i17 = i11 - i14;
        this.f18614g = i17;
        int i18 = i11 + i14;
        this.f18613f = i18;
        if (i17 < 0 || i15 < 0 || i18 >= i12 || i16 >= i13) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public final boolean a(int i3, int i10, int i11, boolean z5) {
        b bVar = this.f18609a;
        if (z5) {
            while (i3 <= i10) {
                if (bVar.b(i3, i11)) {
                    return true;
                }
                i3++;
            }
            return false;
        }
        while (i3 <= i10) {
            if (bVar.b(i11, i3)) {
                return true;
            }
            i3++;
        }
        return false;
    }

    public final h[] b() {
        int i3;
        int i10;
        int i11 = this.f18612d;
        int i12 = this.e;
        int i13 = this.f18614g;
        int i14 = this.f18613f;
        boolean z5 = false;
        boolean z6 = false;
        boolean z8 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = true;
        do {
            i3 = this.f18611c;
            if (!z12) {
                break;
            }
            boolean z13 = false;
            boolean z14 = true;
            while (true) {
                if ((z14 || !z6) && i12 < i3) {
                    z14 = a(i13, i14, i12, false);
                    if (z14) {
                        i12++;
                        z6 = true;
                        z13 = true;
                    } else if (!z6) {
                        i12++;
                    }
                }
            }
            if (i12 >= i3) {
                break;
            }
            boolean z15 = true;
            while (true) {
                i10 = this.f18610b;
                if ((z15 || !z8) && i14 < i10) {
                    z15 = a(i11, i12, i14, true);
                    if (z15) {
                        i14++;
                        z8 = true;
                        z13 = true;
                    } else if (!z8) {
                        i14++;
                    }
                }
            }
            if (i14 >= i10) {
                break;
            }
            boolean z16 = true;
            while (true) {
                if ((z16 || !z10) && i11 >= 0) {
                    z16 = a(i13, i14, i11, false);
                    if (z16) {
                        i11--;
                        z10 = true;
                        z13 = true;
                    } else if (!z10) {
                        i11--;
                    }
                }
            }
            if (i11 < 0) {
                break;
            }
            z12 = z13;
            boolean z17 = true;
            while (true) {
                if ((z17 || !z11) && i13 >= 0) {
                    z17 = a(i11, i12, i13, true);
                    if (z17) {
                        i13--;
                        z12 = true;
                        z11 = true;
                    } else if (!z11) {
                        i13--;
                    }
                }
            }
        } while (i13 >= 0);
        z5 = true;
        if (z5) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i15 = i12 - i11;
        h hVar = null;
        h hVar2 = null;
        for (int i16 = 1; hVar2 == null && i16 < i15; i16++) {
            hVar2 = c(i11, i14 - i16, i11 + i16, i14);
        }
        if (hVar2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        h hVar3 = null;
        for (int i17 = 1; hVar3 == null && i17 < i15; i17++) {
            hVar3 = c(i11, i13 + i17, i11 + i17, i13);
        }
        if (hVar3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        h hVar4 = null;
        for (int i18 = 1; hVar4 == null && i18 < i15; i18++) {
            hVar4 = c(i12, i13 + i18, i12 - i18, i13);
        }
        if (hVar4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i19 = 1; hVar == null && i19 < i15; i19++) {
            hVar = c(i12, i14 - i19, i12 - i19, i14);
        }
        if (hVar == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float f2 = i3 / 2.0f;
        float f10 = hVar.f11247a;
        float f11 = hVar2.f11247a;
        float f12 = hVar4.f11247a;
        float f13 = hVar3.f11247a;
        float f14 = hVar.f11248b;
        float f15 = hVar2.f11248b;
        float f16 = hVar4.f11248b;
        float f17 = hVar3.f11248b;
        return f10 < f2 ? new h[]{new h(f13 - 1.0f, f17 + 1.0f), new h(f11 + 1.0f, f15 + 1.0f), new h(f12 - 1.0f, f16 - 1.0f), new h(f10 + 1.0f, f14 - 1.0f)} : new h[]{new h(f13 + 1.0f, f17 + 1.0f), new h(f11 + 1.0f, f15 - 1.0f), new h(f12 - 1.0f, f16 + 1.0f), new h(f10 - 1.0f, f14 - 1.0f)};
    }

    public final h c(float f2, float f10, float f11, float f12) {
        int c9 = e0.c(e0.a(f2, f10, f11, f12));
        float f13 = c9;
        float f14 = (f11 - f2) / f13;
        float f15 = (f12 - f10) / f13;
        for (int i3 = 0; i3 < c9; i3++) {
            float f16 = i3;
            int c10 = e0.c((f16 * f14) + f2);
            int c11 = e0.c((f16 * f15) + f10);
            if (this.f18609a.b(c10, c11)) {
                return new h(c10, c11);
            }
        }
        return null;
    }

    public a(b bVar) {
        this(bVar, 10, bVar.f18221a / 2, bVar.f18222b / 2);
    }
}
