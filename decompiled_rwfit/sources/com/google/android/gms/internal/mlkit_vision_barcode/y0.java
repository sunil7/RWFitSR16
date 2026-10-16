package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class y0 {
    public static int a(int i3, int i10) {
        int i11 = i3 - i10;
        if (i11 > i10) {
            i11 = i10;
            i10 = i11;
        }
        int i12 = 1;
        int i13 = 1;
        while (i3 > i10) {
            i12 *= i3;
            if (i13 <= i11) {
                i12 /= i13;
                i13++;
            }
            i3--;
        }
        while (i13 <= i11) {
            i12 /= i13;
            i13++;
        }
        return i12;
    }

    public static int b(int[] iArr, int i3, boolean z5) {
        boolean z6;
        int[] iArr2 = iArr;
        int i10 = 0;
        for (int i11 : iArr2) {
            i10 += i11;
        }
        int length = iArr2.length;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = length - 1;
            if (i12 >= i15) {
                return i13;
            }
            int i16 = 1 << i12;
            i14 |= i16;
            int i17 = 1;
            while (i17 < iArr2[i12]) {
                int i18 = i10 - i17;
                int i19 = length - i12;
                int i20 = i19 - 2;
                int a3 = a(i18 - 1, i20);
                if (z5 && i14 == 0) {
                    int i21 = i19 - 1;
                    if (i18 - i21 >= i21) {
                        a3 -= a(i18 - i19, i20);
                    }
                }
                boolean z8 = true;
                if (i19 - 1 > 1) {
                    int i22 = i18 - i20;
                    int i23 = 0;
                    while (i22 > i3) {
                        i23 += a((i18 - i22) - 1, i19 - 3);
                        i22--;
                        z8 = z8;
                    }
                    z6 = z8;
                    a3 -= (i15 - i12) * i23;
                } else {
                    z6 = true;
                    if (i18 > i3) {
                        a3--;
                    }
                }
                i13 += a3;
                i17++;
                i14 &= ~i16;
                iArr2 = iArr;
            }
            i10 -= i17;
            i12++;
            iArr2 = iArr;
        }
    }
}
