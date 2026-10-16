package com.amap.api.col.p0003sl;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class ba {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f3790a;

    /* renamed from: b, reason: collision with root package name */
    private static String[] f3791b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};

    public static String a(String str) {
        return e9.c(str);
    }

    public static String b(String str) {
        try {
            return x9.a(a(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(byte[] bArr) {
        try {
            if (f3790a == null) {
                f3790a = n9.b("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f3790a);
            int[] iArr = new int[8];
            int i3 = 0;
            while (true) {
                String[] strArr = f3791b;
                if (i3 >= strArr.length) {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(a(iArr).getBytes("UTF-8"), n9.b("EQUVT"));
                    Cipher cipher = Cipher.getInstance(n9.b("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                    return cipher.doFinal(bArr);
                }
                byte[] a3 = h9.a(strArr[i3]);
                iArr[i3] = ((a3[0] & 255) << 24) | (a3[3] & 255) | ((a3[2] & 255) << 8) | ((a3[1] & 255) << 16);
                i3++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i10 = iArr[i3];
            int i11 = 1;
            for (int i12 = 0; i12 < 15; i12++) {
                i11 = (i11 << 2) | 1;
            }
            int i13 = ((i10 & i11) << 1) | (((i11 << 1) & i10) >>> 1);
            int i14 = 0;
            for (int i15 = 0; i15 < i3; i15++) {
                i14 = (i14 >> 1) | Integer.MIN_VALUE;
            }
            int i16 = (i13 << i3) | ((i13 & i14) >>> (32 - i3));
            char[] cArr = new char[4];
            for (int i17 = 0; i17 < 4; i17++) {
                char c9 = (char) ((i16 >>> (i17 * 8)) & 255);
                cArr[3 - i17] = c9;
                String str = " ";
                for (int i18 = 0; i18 < 32; i18++) {
                    str = str + (((Integer.MIN_VALUE >>> i18) & c9) >>> (31 - i18));
                }
            }
            sb2.append(new String(cArr));
        }
        return sb2.toString();
    }
}
