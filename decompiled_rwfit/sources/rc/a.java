package rc;

import androidx.recyclerview.widget.e1;
import com.google.android.gms.internal.mlkit_vision_common.e0;
import com.google.android.gms.internal.mlkit_vision_common.y;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.h;
import n.m0;
import sc.b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f18111g = {3808, 476, 2107, 1799};

    /* renamed from: a, reason: collision with root package name */
    public final b f18112a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f18113b;

    /* renamed from: c, reason: collision with root package name */
    public int f18114c;

    /* renamed from: d, reason: collision with root package name */
    public int f18115d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f18116f;

    public a(b bVar) {
        this.f18112a = bVar;
    }

    public static h[] b(h[] hVarArr, int i3, int i10) {
        float f2 = i10 / (i3 * 2.0f);
        h hVar = hVarArr[0];
        float f10 = hVar.f11247a;
        h hVar2 = hVarArr[2];
        float f11 = hVar2.f11247a;
        float f12 = f10 - f11;
        float f13 = hVar.f11248b;
        float f14 = hVar2.f11248b;
        float f15 = f13 - f14;
        float f16 = (f10 + f11) / 2.0f;
        float f17 = (f13 + f14) / 2.0f;
        float f18 = f12 * f2;
        float f19 = f15 * f2;
        h hVar3 = new h(f16 + f18, f17 + f19);
        h hVar4 = new h(f16 - f18, f17 - f19);
        h hVar5 = hVarArr[1];
        float f20 = hVar5.f11247a;
        h hVar6 = hVarArr[3];
        float f21 = hVar6.f11247a;
        float f22 = f20 - f21;
        float f23 = hVar5.f11248b;
        float f24 = hVar6.f11248b;
        float f25 = f23 - f24;
        float f26 = (f20 + f21) / 2.0f;
        float f27 = (f23 + f24) / 2.0f;
        float f28 = f22 * f2;
        float f29 = f2 * f25;
        return new h[]{hVar3, new h(f26 + f28, f27 + f29), hVar4, new h(f26 - f28, f27 - f29)};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final qc.a a(boolean z5) {
        h b3;
        h hVar;
        h hVar2;
        h hVar3;
        char c9;
        h b10;
        h b11;
        h hVar4;
        h hVar5;
        int i3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        long j4;
        int i17;
        e1 e1Var;
        e1 e1Var2;
        boolean z6;
        e1 e1Var3;
        b bVar = this.f18112a;
        int i18 = -1;
        int i19 = 2;
        int i20 = 1;
        try {
            h[] b12 = new tc.a(bVar).b();
            hVar2 = b12[0];
            hVar3 = b12[1];
            hVar = b12[2];
            b3 = b12[3];
        } catch (NotFoundException unused) {
            int i21 = bVar.f18221a / 2;
            int i22 = bVar.f18222b / 2;
            int i23 = i21 + 7;
            int i24 = i22 - 7;
            h b13 = e(new e1(i23, i24, 5), false, 1, -1).b();
            int i25 = i22 + 7;
            h b14 = e(new e1(i23, i25, 5), false, 1, 1).b();
            int i26 = i21 - 7;
            h b15 = e(new e1(i26, i25, 5), false, -1, 1).b();
            b3 = e(new e1(i26, i24, 5), false, -1, -1).b();
            hVar = b15;
            hVar2 = b13;
            hVar3 = b14;
        }
        int c10 = e0.c((((hVar2.f11247a + b3.f11247a) + hVar3.f11247a) + hVar.f11247a) / 4.0f);
        int c11 = e0.c((((hVar2.f11248b + b3.f11248b) + hVar3.f11248b) + hVar.f11248b) / 4.0f);
        char c12 = 15;
        try {
            h[] b16 = new tc.a(bVar, 15, c10, c11).b();
            hVar5 = b16[0];
            hVar4 = b16[1];
            b10 = b16[2];
            b11 = b16[3];
            c9 = 3;
        } catch (NotFoundException unused2) {
            int i27 = c10 + 7;
            int i28 = c11 - 7;
            h b17 = e(new e1(i27, i28, 5), false, 1, -1).b();
            int i29 = c11 + 7;
            c9 = 3;
            h b18 = e(new e1(i27, i29, 5), false, 1, 1).b();
            int i30 = c10 - 7;
            b10 = e(new e1(i30, i29, 5), false, -1, 1).b();
            b11 = e(new e1(i30, i28, 5), false, -1, -1).b();
            hVar4 = b18;
            hVar5 = b17;
        }
        e1 e1Var4 = new e1(e0.c((((hVar5.f11247a + b11.f11247a) + hVar4.f11247a) + b10.f11247a) / 4.0f), e0.c((((hVar5.f11248b + b11.f11248b) + hVar4.f11248b) + b10.f11248b) / 4.0f), 5);
        this.e = 1;
        boolean z8 = true;
        e1 e1Var5 = e1Var4;
        e1 e1Var6 = e1Var5;
        e1 e1Var7 = e1Var6;
        while (true) {
            int i31 = this.e;
            i3 = e1Var7.f2554b;
            char c13 = c12;
            i10 = e1Var7.f2555c;
            i11 = e1Var4.f2554b;
            i12 = e1Var4.f2555c;
            if (i31 >= 9) {
                i13 = i19;
                i14 = i20;
                break;
            }
            e1 e = e(e1Var4, z8, i20, i18);
            e1 e10 = e(e1Var5, z8, i20, i20);
            e1 e11 = e(e1Var6, z8, i18, i20);
            e1 e12 = e(e1Var7, z8, i18, i18);
            if (this.e > i19) {
                int i32 = e12.f2554b;
                i14 = i20;
                int i33 = e12.f2555c;
                i13 = i19;
                int i34 = e.f2554b;
                e1Var2 = e12;
                int i35 = e.f2555c;
                double b19 = (e0.b(i32, i33, i34, i35) * this.e) / ((this.e + 2) * e0.b(i3, i10, i11, i12));
                if (b19 < 0.75d || b19 > 1.25d) {
                    break;
                }
                e1 e1Var8 = new e1(Math.max(0, i34 - 3), Math.min(bVar.f18222b - 1, i35 + 3), 5);
                e1Var = e;
                e1 e1Var9 = new e1(Math.max(0, e10.f2554b - 3), Math.max(0, e10.f2555c - 3), 5);
                z6 = z8;
                e1 e1Var10 = new e1(Math.min(bVar.f18221a - 1, e11.f2554b + 3), Math.max(0, Math.min(bVar.f18222b - 1, e11.f2555c - 3)), 5);
                e1Var3 = e10;
                e1 e1Var11 = new e1(Math.min(bVar.f18221a - 1, i32 + 3), Math.min(bVar.f18222b - 1, i33 + 3), 5);
                int c14 = c(e1Var11, e1Var8);
                if (c14 == 0 || c(e1Var8, e1Var9) != c14 || c(e1Var9, e1Var10) != c14 || c(e1Var10, e1Var11) != c14) {
                    break;
                }
            } else {
                i13 = i19;
                i14 = i20;
                e1Var = e;
                e1Var2 = e12;
                z6 = z8;
                e1Var3 = e10;
            }
            z8 = !z6;
            this.e++;
            e1Var6 = e11;
            c12 = c13;
            i20 = i14;
            i19 = i13;
            e1Var7 = e1Var2;
            e1Var5 = e1Var3;
            e1Var4 = e1Var;
            i18 = -1;
        }
        int i36 = this.e;
        if (i36 != 5 && i36 != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.f18113b = i36 == 5 ? i14 : 0;
        int i37 = i36 * 2;
        h[] b20 = b(new h[]{new h(i11 + 0.5f, i12 - 0.5f), new h(e1Var5.f2554b + 0.5f, e1Var5.f2555c + 0.5f), new h(e1Var6.f2554b - 0.5f, e1Var6.f2555c + 0.5f), new h(i3 - 0.5f, i10 - 0.5f)}, i37 - 3, i37);
        if (z5) {
            h hVar6 = b20[0];
            b20[0] = b20[i13];
            b20[i13] = hVar6;
        }
        if (!g(b20[0]) || !g(b20[i14]) || !g(b20[i13]) || !g(b20[c9])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i38 = this.e * 2;
        int[] iArr = {h(b20[0], b20[i14], i38), h(b20[i14], b20[i13], i38), h(b20[i13], b20[c9], i38), h(b20[c9], b20[0], i38)};
        int i39 = 0;
        for (int i40 = 0; i40 < 4; i40++) {
            int i41 = iArr[i40];
            i39 = (i39 << 3) + ((i41 >> (i38 - 2)) << 1) + (i41 & 1);
        }
        int i42 = ((i39 & 1) << 11) + (i39 >> 1);
        for (int i43 = 0; i43 < 4; i43++) {
            int i44 = i13;
            if (Integer.bitCount(f18111g[i43] ^ i42) <= i44) {
                this.f18116f = i43;
                long j10 = 0;
                int i45 = 0;
                while (true) {
                    i15 = 10;
                    if (i45 >= 4) {
                        break;
                    }
                    int i46 = iArr[(this.f18116f + i45) % 4];
                    if (this.f18113b) {
                        j4 = j10 << 7;
                        i17 = (i46 >> 1) & 127;
                    } else {
                        j4 = j10 << 10;
                        i17 = ((i46 >> 2) & 992) + ((i46 >> 1) & 31);
                    }
                    j10 = j4 + i17;
                    i45++;
                }
                if (this.f18113b) {
                    i15 = 7;
                    i16 = 2;
                } else {
                    i16 = 4;
                }
                int i47 = i15 - i16;
                int[] iArr2 = new int[i15];
                for (int i48 = i15 - 1; i48 >= 0; i48--) {
                    iArr2[i48] = ((int) j10) & 15;
                    j10 >>= 4;
                }
                try {
                    int y4 = new m0(uc.a.f19035k, 23).y(i47, iArr2);
                    int i49 = 0;
                    for (int i50 = 0; i50 < i16; i50++) {
                        i49 = (i49 << 4) + iArr2[i50];
                    }
                    if (this.f18113b) {
                        this.f18114c = (i49 >> 6) + 1;
                        this.f18115d = (i49 & 63) + 1;
                    } else {
                        this.f18114c = (i49 >> 11) + 1;
                        this.f18115d = (i49 & 2047) + 1;
                    }
                    int i51 = this.f18116f;
                    h hVar7 = b20[i51 % 4];
                    h hVar8 = b20[(i51 + 1) % 4];
                    h hVar9 = b20[(i51 + 2) % 4];
                    h hVar10 = b20[(i51 + 3) % 4];
                    int d5 = d();
                    float f2 = d5 / 2.0f;
                    float f10 = this.e;
                    float f11 = f2 - f10;
                    float f12 = f2 + f10;
                    return new qc.a(y.a(bVar, d5, d5, sc.h.a(f11, f11, f12, f11, f12, f12, f11, f12, hVar7.f11247a, hVar7.f11248b, hVar8.f11247a, hVar8.f11248b, hVar9.f11247a, hVar9.f11248b, hVar10.f11247a, hVar10.f11248b)), b(b20, this.e * 2, d()), this.f18113b, this.f18115d, this.f18114c, y4);
                } catch (ReedSolomonException unused3) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            i13 = i44;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int c(e1 e1Var, e1 e1Var2) {
        int i3 = e1Var.f2554b;
        int i10 = e1Var.f2555c;
        float b3 = e0.b(i3, i10, e1Var2.f2554b, e1Var2.f2555c);
        if (b3 != 0.0f) {
            float f2 = (r1 - i3) / b3;
            float f10 = (r13 - i10) / b3;
            float f11 = i3;
            float f12 = i10;
            b bVar = this.f18112a;
            boolean b10 = bVar.b(i3, i10);
            int floor = (int) Math.floor(b3);
            int i11 = 0;
            for (int i12 = 0; i12 < floor; i12++) {
                if (bVar.b(e0.c(f11), e0.c(f12)) != b10) {
                    i11++;
                }
                f11 += f2;
                f12 += f10;
            }
            float f13 = i11 / b3;
            if (f13 <= 0.1f || f13 >= 0.9f) {
                return (f13 <= 0.1f) == b10 ? 1 : -1;
            }
        }
        return 0;
    }

    public final int d() {
        if (this.f18113b) {
            return (this.f18114c * 4) + 11;
        }
        int i3 = this.f18114c;
        return ((((i3 * 2) + 6) / 15) * 2) + (i3 * 4) + 15;
    }

    public final e1 e(e1 e1Var, boolean z5, int i3, int i10) {
        b bVar;
        int i11 = e1Var.f2554b + i3;
        int i12 = e1Var.f2555c;
        while (true) {
            i12 += i10;
            boolean f2 = f(i11, i12);
            bVar = this.f18112a;
            if (!f2 || bVar.b(i11, i12) != z5) {
                break;
            }
            i11 += i3;
        }
        int i13 = i11 - i3;
        int i14 = i12 - i10;
        while (f(i13, i14) && bVar.b(i13, i14) == z5) {
            i13 += i3;
        }
        int i15 = i13 - i3;
        while (f(i15, i14) && bVar.b(i15, i14) == z5) {
            i14 += i10;
        }
        return new e1(i15, i14 - i10, 5);
    }

    public final boolean f(int i3, int i10) {
        if (i3 < 0) {
            return false;
        }
        b bVar = this.f18112a;
        return i3 < bVar.f18221a && i10 >= 0 && i10 < bVar.f18222b;
    }

    public final boolean g(h hVar) {
        return f(e0.c(hVar.f11247a), e0.c(hVar.f11248b));
    }

    public final int h(h hVar, h hVar2, int i3) {
        float f2 = hVar.f11247a;
        float f10 = hVar2.f11247a;
        float f11 = hVar.f11248b;
        float f12 = hVar2.f11248b;
        float a3 = e0.a(f2, f11, f10, f12);
        float f13 = a3 / i3;
        float f14 = hVar2.f11247a;
        float f15 = hVar.f11247a;
        float f16 = ((f14 - f15) * f13) / a3;
        float f17 = ((f12 - f11) * f13) / a3;
        int i10 = 0;
        for (int i11 = 0; i11 < i3; i11++) {
            float f18 = i11;
            if (this.f18112a.b(e0.c((f18 * f16) + f15), e0.c((f18 * f17) + f11))) {
                i10 |= 1 << ((i3 - i11) - 1);
            }
        }
        return i10;
    }
}
