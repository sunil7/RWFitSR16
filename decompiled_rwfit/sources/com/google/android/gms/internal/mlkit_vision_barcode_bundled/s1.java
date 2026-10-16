package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class s1 {

    /* renamed from: f, reason: collision with root package name */
    public static final s1 f9829f = new s1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f9830a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f9831b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f9832c;

    /* renamed from: d, reason: collision with root package name */
    public int f9833d = -1;
    public boolean e;

    public s1(int i3, int[] iArr, Object[] objArr, boolean z5) {
        this.f9830a = i3;
        this.f9831b = iArr;
        this.f9832c = objArr;
        this.e = z5;
    }

    public static s1 b() {
        return new s1(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int a3;
        int b3;
        int a10;
        int i3 = this.f9833d;
        if (i3 != -1) {
            return i3;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f9830a; i11++) {
            int i12 = this.f9831b[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 != 0) {
                if (i14 == 1) {
                    ((Long) this.f9832c[i11]).getClass();
                    a10 = z.a(i13 << 3) + 8;
                } else if (i14 == 2) {
                    int i15 = i13 << 3;
                    zzdf zzdfVar = (zzdf) this.f9832c[i11];
                    int a11 = z.a(i15);
                    int zzd = zzdfVar.zzd();
                    i10 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(zzd, zzd, a11, i10);
                } else if (i14 == 3) {
                    int a12 = z.a(i13 << 3);
                    a3 = a12 + a12;
                    b3 = ((s1) this.f9832c[i11]).a();
                } else {
                    if (i14 != 5) {
                        throw new IllegalStateException(new zzeq("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.f9832c[i11]).getClass();
                    a10 = z.a(i13 << 3) + 4;
                }
                i10 = a10 + i10;
            } else {
                int i16 = i13 << 3;
                long longValue = ((Long) this.f9832c[i11]).longValue();
                a3 = z.a(i16);
                b3 = z.b(longValue);
            }
            i10 = b3 + a3 + i10;
        }
        this.f9833d = i10;
        return i10;
    }

    public final void c(int i3, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        e(this.f9830a + 1);
        int[] iArr = this.f9831b;
        int i10 = this.f9830a;
        iArr[i10] = i3;
        this.f9832c[i10] = obj;
        this.f9830a = i10 + 1;
    }

    public final void d(x0 x0Var) {
        if (this.f9830a != 0) {
            for (int i3 = 0; i3 < this.f9830a; i3++) {
                int i10 = this.f9831b[i3];
                Object obj = this.f9832c[i3];
                int i11 = i10 & 7;
                int i12 = i10 >>> 3;
                if (i11 == 0) {
                    ((z) x0Var.f9840a).p(i12, ((Long) obj).longValue());
                } else if (i11 == 1) {
                    ((z) x0Var.f9840a).h(i12, ((Long) obj).longValue());
                } else if (i11 == 2) {
                    ((z) x0Var.f9840a).e(i12, (zzdf) obj);
                } else if (i11 == 3) {
                    ((z) x0Var.f9840a).m(i12, 3);
                    ((s1) obj).d(x0Var);
                    ((z) x0Var.f9840a).m(i12, 4);
                } else {
                    if (i11 != 5) {
                        throw new RuntimeException(new zzeq("Protocol message tag had invalid wire type."));
                    }
                    ((z) x0Var.f9840a).f(i12, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void e(int i3) {
        int[] iArr = this.f9831b;
        if (i3 > iArr.length) {
            int i10 = this.f9830a;
            int i11 = (i10 / 2) + i10;
            if (i11 >= i3) {
                i3 = i11;
            }
            if (i3 < 8) {
                i3 = 8;
            }
            this.f9831b = Arrays.copyOf(iArr, i3);
            this.f9832c = Arrays.copyOf(this.f9832c, i3);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof s1)) {
            return false;
        }
        s1 s1Var = (s1) obj;
        int i3 = this.f9830a;
        if (i3 == s1Var.f9830a) {
            int[] iArr = this.f9831b;
            int[] iArr2 = s1Var.f9831b;
            int i10 = 0;
            while (true) {
                if (i10 >= i3) {
                    Object[] objArr = this.f9832c;
                    Object[] objArr2 = s1Var.f9832c;
                    int i11 = this.f9830a;
                    for (int i12 = 0; i12 < i11; i12++) {
                        if (objArr[i12].equals(objArr2[i12])) {
                        }
                    }
                    return true;
                }
                if (iArr[i10] != iArr2[i10]) {
                    break;
                }
                i10++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.f9830a;
        int i10 = i3 + 527;
        int[] iArr = this.f9831b;
        int i11 = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i3; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = ((i10 * 31) + i12) * 31;
        Object[] objArr = this.f9832c;
        int i15 = this.f9830a;
        for (int i16 = 0; i16 < i15; i16++) {
            i11 = (i11 * 31) + objArr[i16].hashCode();
        }
        return i14 + i11;
    }
}
