package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
public class w4 {
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
        if (i11 >= 1) {
            if (a10.length < 4) {
                int[] iArr = new int[4];
                System.arraycopy(a10, 0, iArr, 0, a10.length);
                a10 = iArr;
            }
            int i12 = a3[i11];
            int i13 = a3[0];
            int i14 = (52 / length2) + 6;
            int i15 = 0;
            while (true) {
                int i16 = i14 - 1;
                if (i14 <= 0) {
                    break;
                }
                i15 -= 1640531527;
                int i17 = (i15 >>> 2) & 3;
                int i18 = 0;
                while (i18 < i11) {
                    int i19 = i18 + 1;
                    int i20 = a3[i19];
                    i12 = ((((i12 >>> 5) ^ (i20 << 2)) + ((i20 >>> 3) ^ (i12 << 4))) ^ ((i20 ^ i15) + (i12 ^ a10[(i18 & 3) ^ i17]))) + a3[i18];
                    a3[i18] = i12;
                    i18 = i19;
                }
                int i21 = a3[0];
                i12 = ((((i12 >>> 5) ^ (i21 << 2)) + ((i21 >>> 3) ^ (i12 << 4))) ^ ((i21 ^ i15) + (i12 ^ a10[i17 ^ (i18 & 3)]))) + a3[i11];
                a3[i11] = i12;
                i14 = i16;
            }
        }
        int length3 = a3.length << 2;
        byte[] bArr4 = new byte[length3];
        for (int i22 = 0; i22 < length3; i22++) {
            bArr4[i22] = (byte) ((a3[i22 >>> 2] >>> ((i22 & 3) << 3)) & 255);
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
