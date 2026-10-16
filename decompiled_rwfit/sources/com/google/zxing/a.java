package com.google.zxing;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final sc.f f11216a;

    /* renamed from: b, reason: collision with root package name */
    public sc.b f11217b;

    public a(sc.f fVar) {
        this.f11216a = fVar;
    }

    public final sc.b a() {
        if (this.f11217b == null) {
            this.f11217b = this.f11216a.e();
        }
        return this.f11217b;
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [byte[], java.io.Serializable] */
    public final sc.a b(sc.a aVar, int i3) {
        int[] iArr;
        sc.f fVar = this.f11216a;
        b bVar = (b) fVar.f18241b;
        int i10 = aVar.f18220b;
        int i11 = bVar.f11226a;
        if (i10 < i11) {
            aVar = new sc.a(i11);
        } else {
            int length = aVar.f18219a.length;
            for (int i12 = 0; i12 < length; i12++) {
                aVar.f18219a[i12] = 0;
            }
        }
        if (((byte[]) fVar.f18242c).length < i11) {
            fVar.f18242c = new byte[i11];
        }
        int i13 = 0;
        while (true) {
            iArr = (int[]) fVar.f18243d;
            if (i13 >= 32) {
                break;
            }
            iArr[i13] = 0;
            i13++;
        }
        byte[] b3 = bVar.b(i3, (byte[]) fVar.f18242c);
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = (b3[i14] & 255) >> 3;
            iArr[i15] = iArr[i15] + 1;
        }
        int d5 = sc.f.d(iArr);
        if (i11 < 3) {
            for (int i16 = 0; i16 < i11; i16++) {
                if ((b3[i16] & 255) < d5) {
                    aVar.j(i16);
                }
            }
        } else {
            int i17 = b3[0] & 255;
            int i18 = b3[1] & 255;
            int i19 = 1;
            while (i19 < i11 - 1) {
                int i20 = i19 + 1;
                int i21 = b3[i20] & 255;
                if ((((i18 * 4) - i17) - i21) / 2 < d5) {
                    aVar.j(i19);
                }
                i17 = i18;
                i19 = i20;
                i18 = i21;
            }
        }
        return aVar;
    }

    public final String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
