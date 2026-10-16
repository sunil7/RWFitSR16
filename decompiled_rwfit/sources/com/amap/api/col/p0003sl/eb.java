package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
public final class eb {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i3 = 4 - (length % 4);
        int i10 = ((length / 4) + 1) * 4;
        byte[] bArr3 = new byte[i10];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < i10) {
            bArr3[length] = (byte) i3;
            length++;
        }
        int[] a3 = a(bArr3);
        int[] a10 = a(bArr2);
        int length2 = a3.length;
        int i11 = length2 - 1;
        if (i11 > 0) {
            if (a10.length < 4) {
                int[] iArr = new int[4];
                System.arraycopy(a10, 0, iArr, 0, a10.length);
                a10 = iArr;
            }
            int i12 = a3[i11];
            int i13 = (52 / length2) + 6;
            int i14 = 0;
            while (true) {
                int i15 = i13 - 1;
                if (i13 <= 0) {
                    break;
                }
                i14 -= 1640531527;
                int i16 = (i14 >>> 2) & 3;
                int i17 = 0;
                while (i17 < i11) {
                    int i18 = i17 + 1;
                    int i19 = a3[i18];
                    i12 = ((((i12 >>> 5) ^ (i19 << 2)) + ((i19 >>> 3) ^ (i12 << 4))) ^ ((i19 ^ i14) + (i12 ^ a10[(i17 & 3) ^ i16]))) + a3[i17];
                    a3[i17] = i12;
                    i17 = i18;
                }
                int i20 = a3[0];
                i12 = ((((i12 >>> 5) ^ (i20 << 2)) + ((i20 >>> 3) ^ (i12 << 4))) ^ ((i20 ^ i14) + (i12 ^ a10[i16 ^ (i17 & 3)]))) + a3[i11];
                a3[i11] = i12;
                i13 = i15;
            }
        }
        int length3 = a3.length << 2;
        byte[] bArr4 = new byte[length3];
        for (int i21 = 0; i21 < length3; i21++) {
            bArr4[i21] = (byte) ((a3[i21 >>> 2] >>> ((i21 & 3) << 3)) & 255);
        }
        return bArr4;
    }

    private static int[] a(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i10 = i3 >>> 2;
            iArr[i10] = iArr[i10] | ((bArr[i3] & 255) << ((i3 & 3) << 3));
        }
        return iArr;
    }
}
